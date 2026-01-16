package ir.eitaa.messenger;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Ads_Ad;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$InputEncryptedFile;
import ir.eitaa.tgnet.TLRPC$InputFile;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeVideo;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_fileLocationToBeDeprecated;
import ir.eitaa.tgnet.TLRPC$TL_fileLocationUnavailable;
import ir.eitaa.tgnet.TLRPC$TL_fileLocation_layer82;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaLiveStream;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaWebPage;
import ir.eitaa.tgnet.TLRPC$TL_photoCachedSize;
import ir.eitaa.tgnet.TLRPC$TL_photoSize;
import ir.eitaa.tgnet.TLRPC$TL_photoSize_layer127;
import ir.eitaa.tgnet.TLRPC$TL_photoStrippedSize;
import ir.eitaa.ui.Cells.ChatMessageCell;
import ir.eitaa.ui.Components.AnimatedFileDrawable;
import ir.eitaa.ui.Components.RLottieDrawable;
import j$.C$r8$wrapper$java$util$stream$Stream$VWRP;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Consumer;
import j$.util.stream.Stream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class ImageLoader {
    public static final String AUTOPLAY_FILTER = "g";
    private boolean canForce8888;
    private LruCache<RLottieDrawable> lottieMemCache;
    private LruCache<BitmapDrawable> memCache;
    private LruCache<BitmapDrawable> wallpaperMemCache;
    private static ThreadLocal<byte[]> bytesLocal = new ThreadLocal<>();
    private static ThreadLocal<byte[]> bytesThumbLocal = new ThreadLocal<>();
    private static byte[] header = new byte[12];
    private static byte[] headerThumb = new byte[12];
    private static volatile ImageLoader Instance = null;
    private HashMap<String, Integer> bitmapUseCounts = new HashMap<>();
    private HashMap<String, CacheImage> imageLoadingByUrl = new HashMap<>();
    private HashMap<String, CacheImage> imageLoadingByKeys = new HashMap<>();
    private SparseArray<CacheImage> imageLoadingByTag = new SparseArray<>();
    private HashMap<String, ThumbGenerateInfo> waitingForQualityThumb = new HashMap<>();
    private SparseArray<String> waitingForQualityThumbByTag = new SparseArray<>();
    private LinkedList<HttpImageTask> httpTasks = new LinkedList<>();
    private LinkedList<ArtworkLoadTask> artworkTasks = new LinkedList<>();
    private DispatchQueue cacheOutQueue = new DispatchQueue("cacheOutQueue");
    private DispatchQueue cacheThumbOutQueue = new DispatchQueue("cacheThumbOutQueue");
    private DispatchQueue thumbGeneratingQueue = new DispatchQueue("thumbGeneratingQueue");
    private DispatchQueue imageLoadQueue = new DispatchQueue("imageLoadQueue");
    private HashMap<String, String> replacedBitmaps = new HashMap<>();
    private ConcurrentHashMap<String, long[]> fileProgresses = new ConcurrentHashMap<>();
    private HashMap<String, ThumbGenerateTask> thumbGenerateTasks = new HashMap<>();
    private HashMap<String, Integer> forceLoadingImages = new HashMap<>();
    private int currentHttpTasksCount = 0;
    private int currentArtworkTasksCount = 0;
    private ConcurrentHashMap<String, WebFile> testWebFile = new ConcurrentHashMap<>();
    private LinkedList<HttpFileTask> httpFileLoadTasks = new LinkedList<>();
    private HashMap<String, HttpFileTask> httpFileLoadTasksByKeys = new HashMap<>();
    private HashMap<String, Runnable> retryHttpsTasks = new HashMap<>();
    private int currentHttpFileLoadTasksCount = 0;
    private String ignoreRemoval = null;
    private volatile long lastCacheOutTime = 0;
    private int lastImageNum = 0;
    private File eitaaPath = null;

    public void putThumbsToCache(ArrayList<MessageThumb> updateMessageThumbs) {
        for (int i = 0; i < updateMessageThumbs.size(); i++) {
            putImageToCache(updateMessageThumbs.get(i).drawable, updateMessageThumbs.get(i).key);
        }
    }

    private static class ThumbGenerateInfo {
        private boolean big;
        private String filter;
        private ArrayList<ImageReceiver> imageReceiverArray;
        private ArrayList<Integer> imageReceiverGuidsArray;
        private TLRPC$Document parentDocument;

        private ThumbGenerateInfo() {
            this.imageReceiverArray = new ArrayList<>();
            this.imageReceiverGuidsArray = new ArrayList<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class HttpFileTask extends AsyncTask<Void, Void, Boolean> {
        private int currentAccount;
        private String ext;
        private int fileSize;
        private long lastProgressTime;
        private File tempFile;
        private String url;
        private RandomAccessFile fileOutputStream = null;
        private boolean canRetry = true;

        public HttpFileTask(String url, File tempFile, String ext, int currentAccount) {
            this.url = url;
            this.tempFile = tempFile;
            this.ext = ext;
            this.currentAccount = currentAccount;
        }

        private void reportProgress(final long uploadedSize, final long totalSize) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (uploadedSize != totalSize) {
                long j = this.lastProgressTime;
                if (j != 0 && j >= jElapsedRealtime - 100) {
                    return;
                }
            }
            this.lastProgressTime = jElapsedRealtime;
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$HttpFileTask$YOyd35MA3DMCRlTlWfluUo7-9hU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$reportProgress$1$ImageLoader$HttpFileTask(uploadedSize, totalSize);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$reportProgress$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$reportProgress$1$ImageLoader$HttpFileTask(final long j, final long j2) {
            ImageLoader.this.fileProgresses.put(this.url, new long[]{j, j2});
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$HttpFileTask$2HdxUqDo844zEIqnSUj7IbdDUl8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$reportProgress$0$ImageLoader$HttpFileTask(j, j2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$reportProgress$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$reportProgress$0$ImageLoader$HttpFileTask(long j, long j2) {
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.fileLoadProgressChanged, this.url, Long.valueOf(j), Long.valueOf(j2));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0120, code lost:
        
            if (r5 != (-1)) goto L88;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0122, code lost:
        
            r0 = r11.fileSize;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0124, code lost:
        
            if (r0 == 0) goto L98;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0126, code lost:
        
            reportProgress(r0, r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x012c, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x012e, code lost:
        
            r1 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0132, code lost:
        
            ir.eitaa.messenger.FileLog.e(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0136, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x013a, code lost:
        
            ir.eitaa.messenger.FileLog.e(r0);
         */
        /* JADX WARN: Removed duplicated region for block: B:101:0x0142 A[Catch: all -> 0x0148, TRY_LEAVE, TryCatch #5 {all -> 0x0148, blocks: (B:99:0x013e, B:101:0x0142), top: B:121:0x013e }] */
        /* JADX WARN: Removed duplicated region for block: B:114:0x014e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:125:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Boolean doInBackground(java.lang.Void... r12) {
            /*
                Method dump skipped, instructions count: 347
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.ImageLoader.HttpFileTask.doInBackground(java.lang.Void[]):java.lang.Boolean");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            ImageLoader.this.runHttpFileLoadTasks(this, result.booleanValue() ? 2 : 1);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            ImageLoader.this.runHttpFileLoadTasks(this, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ArtworkLoadTask extends AsyncTask<Void, Void, String> {
        private CacheImage cacheImage;
        private boolean canRetry = true;
        private HttpURLConnection httpConnection;
        private boolean small;

        public ArtworkLoadTask(CacheImage cacheImage) {
            this.cacheImage = cacheImage;
            this.small = Uri.parse(cacheImage.imageLocation.path).getQueryParameter("s") != null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Void... voids) throws IOException {
            InputStream inputStream;
            ByteArrayOutputStream byteArrayOutputStream;
            InputStream inputStream2;
            ByteArrayOutputStream byteArrayOutputStream2;
            JSONArray jSONArray;
            int i;
            int responseCode;
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.cacheImage.imageLocation.path.replace("athumb://", "https://")).openConnection();
                    this.httpConnection = httpURLConnection;
                    httpURLConnection.setConnectTimeout(5000);
                    this.httpConnection.setReadTimeout(5000);
                    this.httpConnection.connect();
                    try {
                        HttpURLConnection httpURLConnection2 = this.httpConnection;
                        if (httpURLConnection2 != null && (responseCode = httpURLConnection2.getResponseCode()) != 200 && responseCode != 202 && responseCode != 304) {
                            this.canRetry = false;
                        }
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    inputStream2 = this.httpConnection.getInputStream();
                    try {
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[32768];
                            while (!isCancelled() && (i = inputStream2.read(bArr)) > 0) {
                                byteArrayOutputStream2.write(bArr, 0, i);
                            }
                            this.canRetry = false;
                            jSONArray = new JSONObject(new String(byteArrayOutputStream2.toByteArray())).getJSONArray("results");
                        } catch (Throwable th) {
                            inputStream = inputStream2;
                            th = th;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            try {
                                if (th instanceof SocketTimeoutException) {
                                    if (ApplicationLoader.isNetworkOnline()) {
                                        this.canRetry = false;
                                    }
                                } else if (th instanceof UnknownHostException) {
                                    this.canRetry = false;
                                } else if (th instanceof SocketException) {
                                    if (th.getMessage() != null && th.getMessage().contains("ECONNRESET")) {
                                        this.canRetry = false;
                                    }
                                } else if (th instanceof FileNotFoundException) {
                                    this.canRetry = false;
                                }
                                FileLog.e(th);
                                try {
                                    HttpURLConnection httpURLConnection3 = this.httpConnection;
                                    if (httpURLConnection3 != null) {
                                        httpURLConnection3.disconnect();
                                    }
                                } catch (Throwable unused) {
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th2) {
                                        FileLog.e(th2);
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                return null;
                            } catch (Throwable th3) {
                                try {
                                    HttpURLConnection httpURLConnection4 = this.httpConnection;
                                    if (httpURLConnection4 != null) {
                                        httpURLConnection4.disconnect();
                                    }
                                } catch (Throwable unused2) {
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th4) {
                                        FileLog.e(th4);
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception unused3) {
                                    }
                                }
                                throw th3;
                            }
                        }
                    } catch (Throwable th5) {
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = null;
                    byteArrayOutputStream = null;
                }
            } catch (Exception unused4) {
            }
            if (jSONArray.length() <= 0) {
                try {
                    HttpURLConnection httpURLConnection5 = this.httpConnection;
                    if (httpURLConnection5 != null) {
                        httpURLConnection5.disconnect();
                    }
                } catch (Throwable unused5) {
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable th7) {
                        FileLog.e(th7);
                    }
                }
                byteArrayOutputStream2.close();
                return null;
            }
            String string = jSONArray.getJSONObject(0).getString("artworkUrl100");
            if (this.small) {
                try {
                    HttpURLConnection httpURLConnection6 = this.httpConnection;
                    if (httpURLConnection6 != null) {
                        httpURLConnection6.disconnect();
                    }
                } catch (Throwable unused6) {
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable th8) {
                        FileLog.e(th8);
                    }
                }
                try {
                    byteArrayOutputStream2.close();
                } catch (Exception unused7) {
                }
                return string;
            }
            String strReplace = string.replace("100x100", "600x600");
            try {
                HttpURLConnection httpURLConnection7 = this.httpConnection;
                if (httpURLConnection7 != null) {
                    httpURLConnection7.disconnect();
                }
            } catch (Throwable unused8) {
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Throwable th9) {
                    FileLog.e(th9);
                }
            }
            try {
                byteArrayOutputStream2.close();
            } catch (Exception unused9) {
            }
            return strReplace;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(final String result) {
            if (result != null) {
                ImageLoader.this.imageLoadQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$ArtworkLoadTask$n8eyH1t8mA6K9N3Qv8xPwH4uUt4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onPostExecute$0$ImageLoader$ArtworkLoadTask(result);
                    }
                });
            } else if (this.canRetry) {
                ImageLoader.this.artworkLoadError(this.cacheImage.url);
            }
            ImageLoader.this.imageLoadQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$ArtworkLoadTask$1B5JZvFOs3GgGfnWY9I-zHb0_-s
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPostExecute$1$ImageLoader$ArtworkLoadTask();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onPostExecute$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onPostExecute$0$ImageLoader$ArtworkLoadTask(String str) {
            CacheImage cacheImage = this.cacheImage;
            cacheImage.httpTask = ImageLoader.this.new HttpImageTask(cacheImage, 0, str);
            ImageLoader.this.httpTasks.add(this.cacheImage.httpTask);
            ImageLoader.this.runHttpTasks(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onPostExecute$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onPostExecute$1$ImageLoader$ArtworkLoadTask() {
            ImageLoader.this.runArtworkTasks(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCancelled$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCancelled$2$ImageLoader$ArtworkLoadTask() {
            ImageLoader.this.runArtworkTasks(true);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            ImageLoader.this.imageLoadQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$ArtworkLoadTask$h4mLepQQgBwXRfCtZ9AlsGvLsQA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCancelled$2$ImageLoader$ArtworkLoadTask();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class HttpImageTask extends AsyncTask<Void, Void, Boolean> {
        private CacheImage cacheImage;
        private boolean canRetry = true;
        private RandomAccessFile fileOutputStream;
        private HttpURLConnection httpConnection;
        private int imageSize;
        private long lastProgressTime;
        private String overrideUrl;

        static /* synthetic */ void lambda$doInBackground$2(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        }

        public HttpImageTask(CacheImage cacheImage, int size) {
            this.cacheImage = cacheImage;
            this.imageSize = size;
        }

        public HttpImageTask(CacheImage cacheImage, int size, String url) {
            this.cacheImage = cacheImage;
            this.imageSize = size;
            this.overrideUrl = url;
        }

        private void reportProgress(final long uploadedSize, final long totalSize) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (uploadedSize != totalSize) {
                long j = this.lastProgressTime;
                if (j != 0 && j >= jElapsedRealtime - 100) {
                    return;
                }
            }
            this.lastProgressTime = jElapsedRealtime;
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$HttpImageTask$vjqUFJ_FkFP_mrE_aVImFEXgY5U
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$reportProgress$1$ImageLoader$HttpImageTask(uploadedSize, totalSize);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$reportProgress$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$reportProgress$1$ImageLoader$HttpImageTask(final long j, final long j2) {
            ImageLoader.this.fileProgresses.put(this.cacheImage.url, new long[]{j, j2});
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$HttpImageTask$-fkOxFQBP8YG6qgpd6JPaZvhk9U
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$reportProgress$0$ImageLoader$HttpImageTask(j, j2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$reportProgress$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$reportProgress$0$ImageLoader$HttpImageTask(long j, long j2) {
            NotificationCenter.getInstance(this.cacheImage.currentAccount).postNotificationName(NotificationCenter.fileLoadProgressChanged, this.cacheImage.url, Long.valueOf(j), Long.valueOf(j2));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x0172, code lost:
        
            ir.eitaa.messenger.FileLog.e(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x0175, code lost:
        
            r0 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:105:0x0179, code lost:
        
            ir.eitaa.messenger.FileLog.e(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x015b, code lost:
        
            if (r5 != (-1)) goto L99;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x015d, code lost:
        
            r2 = r11.imageSize;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x015f, code lost:
        
            if (r2 == 0) goto L103;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0161, code lost:
        
            reportProgress(r2, r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x0167, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0168, code lost:
        
            r0 = r2;
            r2 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x016b, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x016c, code lost:
        
            r0 = r2;
            r2 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x016f, code lost:
        
            r0 = false;
         */
        /* JADX WARN: Removed duplicated region for block: B:108:0x0180 A[Catch: all -> 0x0186, TRY_LEAVE, TryCatch #5 {all -> 0x0186, blocks: (B:106:0x017c, B:108:0x0180), top: B:138:0x017c }] */
        /* JADX WARN: Removed duplicated region for block: B:114:0x018e A[Catch: all -> 0x0192, TRY_LEAVE, TryCatch #1 {all -> 0x0192, blocks: (B:112:0x018a, B:114:0x018e), top: B:132:0x018a }] */
        /* JADX WARN: Removed duplicated region for block: B:123:0x019f  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:142:0x0195 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00df  */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Boolean doInBackground(java.lang.Void... r12) {
            /*
                Method dump skipped, instructions count: 440
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.ImageLoader.HttpImageTask.doInBackground(java.lang.Void[]):java.lang.Boolean");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(final Boolean result) {
            if (!result.booleanValue() && this.canRetry) {
                ImageLoader.this.httpFileLoadError(this.cacheImage.url);
            } else {
                ImageLoader imageLoader = ImageLoader.this;
                CacheImage cacheImage = this.cacheImage;
                imageLoader.fileDidLoaded(cacheImage.url, cacheImage.finalFilePath, 0);
            }
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$HttpImageTask$SftRaQEdxPYHcyknUp-w6Pr1VuM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPostExecute$4$ImageLoader$HttpImageTask(result);
                }
            });
            ImageLoader.this.imageLoadQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$HttpImageTask$MgjkJ20nW5FVbRBnhcKyNMaW9Qg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPostExecute$5$ImageLoader$HttpImageTask();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onPostExecute$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onPostExecute$4$ImageLoader$HttpImageTask(final Boolean bool) {
            ImageLoader.this.fileProgresses.remove(this.cacheImage.url);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$HttpImageTask$hRkwUuR6M7npa5nfcYYFzdy49uQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPostExecute$3$ImageLoader$HttpImageTask(bool);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onPostExecute$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onPostExecute$3$ImageLoader$HttpImageTask(Boolean bool) {
            if (bool.booleanValue()) {
                NotificationCenter notificationCenter = NotificationCenter.getInstance(this.cacheImage.currentAccount);
                int i = NotificationCenter.fileLoaded;
                CacheImage cacheImage = this.cacheImage;
                notificationCenter.postNotificationName(i, cacheImage.url, cacheImage.finalFilePath);
                return;
            }
            NotificationCenter.getInstance(this.cacheImage.currentAccount).postNotificationName(NotificationCenter.fileLoadFailed, this.cacheImage.url, 2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onPostExecute$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onPostExecute$5$ImageLoader$HttpImageTask() {
            ImageLoader.this.runHttpTasks(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCancelled$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCancelled$6$ImageLoader$HttpImageTask() {
            ImageLoader.this.runHttpTasks(true);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            ImageLoader.this.imageLoadQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$HttpImageTask$tJzqB-FKkFaO95y4iAmZrPWPuTY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCancelled$6$ImageLoader$HttpImageTask();
                }
            });
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$HttpImageTask$CRKeVMyzWTzzcJdwvOQXsO0wVw8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCancelled$8$ImageLoader$HttpImageTask();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCancelled$8, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCancelled$8$ImageLoader$HttpImageTask() {
            ImageLoader.this.fileProgresses.remove(this.cacheImage.url);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$HttpImageTask$zcw74FKEYy95Z1dkO08bSp_kUk8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCancelled$7$ImageLoader$HttpImageTask();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCancelled$7, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCancelled$7$ImageLoader$HttpImageTask() {
            NotificationCenter.getInstance(this.cacheImage.currentAccount).postNotificationName(NotificationCenter.fileLoadFailed, this.cacheImage.url, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ThumbGenerateTask implements Runnable {
        private ThumbGenerateInfo info;
        private int mediaType;
        private File originalPath;

        public ThumbGenerateTask(int type, File path, ThumbGenerateInfo i) {
            this.mediaType = type;
            this.originalPath = path;
            this.info = i;
        }

        private void removeTask() {
            ThumbGenerateInfo thumbGenerateInfo = this.info;
            if (thumbGenerateInfo == null) {
                return;
            }
            final String attachFileName = FileLoader.getAttachFileName(thumbGenerateInfo.parentDocument);
            ImageLoader.this.imageLoadQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$ThumbGenerateTask$gUuWOzzBYucnQhLkHDgCMyAuCp8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeTask$0$ImageLoader$ThumbGenerateTask(attachFileName);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$removeTask$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$removeTask$0$ImageLoader$ThumbGenerateTask(String str) {
            ImageLoader.this.thumbGenerateTasks.remove(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            int iMin;
            Bitmap bitmapCreateScaledBitmap;
            try {
                if (this.info == null) {
                    removeTask();
                    return;
                }
                final String str = "q_" + this.info.parentDocument.dc_id + "_" + this.info.parentDocument.id;
                File file = new File(FileLoader.getDirectory(4), str + ".jpg");
                if (!file.exists() && this.originalPath.exists()) {
                    if (this.info.big) {
                        Point point = AndroidUtilities.displaySize;
                        iMin = Math.max(point.x, point.y);
                    } else {
                        Point point2 = AndroidUtilities.displaySize;
                        iMin = Math.min(180, Math.min(point2.x, point2.y) / 4);
                    }
                    int i = this.mediaType;
                    Bitmap bitmapLoadBitmap = null;
                    if (i == 0) {
                        float f = iMin;
                        bitmapLoadBitmap = ImageLoader.loadBitmap(this.originalPath.toString(), null, f, f, false);
                    } else {
                        int i2 = 2;
                        if (i == 2) {
                            String string = this.originalPath.toString();
                            if (!this.info.big) {
                                i2 = 1;
                            }
                            bitmapLoadBitmap = SendMessagesHelper.createVideoThumbnail(string, i2);
                        } else if (i == 3) {
                            String lowerCase = this.originalPath.toString().toLowerCase();
                            if (lowerCase.endsWith("mp4")) {
                                String string2 = this.originalPath.toString();
                                if (!this.info.big) {
                                    i2 = 1;
                                }
                                bitmapLoadBitmap = SendMessagesHelper.createVideoThumbnail(string2, i2);
                            } else if (lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".png") || lowerCase.endsWith(".gif")) {
                                float f2 = iMin;
                                bitmapLoadBitmap = ImageLoader.loadBitmap(lowerCase, null, f2, f2, false);
                            }
                        }
                    }
                    if (bitmapLoadBitmap == null) {
                        removeTask();
                        return;
                    }
                    int width = bitmapLoadBitmap.getWidth();
                    int height = bitmapLoadBitmap.getHeight();
                    if (width != 0 && height != 0) {
                        float f3 = width;
                        float f4 = iMin;
                        float f5 = height;
                        float fMin = Math.min(f3 / f4, f5 / f4);
                        if (fMin > 1.0f && (bitmapCreateScaledBitmap = Bitmaps.createScaledBitmap(bitmapLoadBitmap, (int) (f3 / fMin), (int) (f5 / fMin), true)) != bitmapLoadBitmap) {
                            bitmapLoadBitmap.recycle();
                            bitmapLoadBitmap = bitmapCreateScaledBitmap;
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        bitmapLoadBitmap.compress(Bitmap.CompressFormat.JPEG, this.info.big ? 83 : 60, fileOutputStream);
                        try {
                            fileOutputStream.close();
                        } catch (Exception e) {
                            FileLog.e(e);
                        }
                        final BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapLoadBitmap);
                        final ArrayList arrayList = new ArrayList(this.info.imageReceiverArray);
                        final ArrayList arrayList2 = new ArrayList(this.info.imageReceiverGuidsArray);
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$ThumbGenerateTask$FLQkQOH6jq7dFAIUzJ-VTt32I-M
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$run$1$ImageLoader$ThumbGenerateTask(str, arrayList, bitmapDrawable, arrayList2);
                            }
                        });
                        return;
                    }
                    removeTask();
                    return;
                }
                removeTask();
            } catch (Throwable th) {
                FileLog.e(th);
                removeTask();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$1$ImageLoader$ThumbGenerateTask(String str, ArrayList arrayList, BitmapDrawable bitmapDrawable, ArrayList arrayList2) {
            removeTask();
            if (this.info.filter != null) {
                str = str + "@" + this.info.filter;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                ((ImageReceiver) arrayList.get(i)).setImageBitmapByKey(bitmapDrawable, str, 0, false, ((Integer) arrayList2.get(i)).intValue());
            }
            ImageLoader.this.memCache.put(str, bitmapDrawable);
        }
    }

    public static String decompressGzip(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (file == null) {
            return "";
        }
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new FileInputStream(file));
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream, "UTF-8"));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append(line);
                        } else {
                            String string = sb.toString();
                            bufferedReader.close();
                            gZIPInputStream.close();
                            return string;
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                try {
                    gZIPInputStream.close();
                } catch (Throwable unused2) {
                }
                throw th2;
            }
        } catch (Exception unused3) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class CacheOutTask implements Runnable {
        private CacheImage cacheImage;
        private boolean isCancelled;
        private Thread runningThread;
        private final Object sync = new Object();

        public CacheOutTask(CacheImage image) {
            this.cacheImage = image;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 29, insn: 0x0567: MOVE (r5 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r29 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:338:0x0563 */
        /* JADX WARN: Not initialized variable reg: 30, insn: 0x0569: MOVE (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r30 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:338:0x0563 */
        /* JADX WARN: Removed duplicated region for block: B:101:0x01ab  */
        /* JADX WARN: Removed duplicated region for block: B:122:0x01d4  */
        /* JADX WARN: Removed duplicated region for block: B:123:0x01ef  */
        /* JADX WARN: Removed duplicated region for block: B:153:0x026d  */
        /* JADX WARN: Removed duplicated region for block: B:158:0x0295  */
        /* JADX WARN: Removed duplicated region for block: B:192:0x0335  */
        /* JADX WARN: Removed duplicated region for block: B:220:0x036f  */
        /* JADX WARN: Removed duplicated region for block: B:238:0x03d0  */
        /* JADX WARN: Removed duplicated region for block: B:241:0x03e3  */
        /* JADX WARN: Removed duplicated region for block: B:245:0x03f5 A[Catch: all -> 0x0605, TryCatch #18 {all -> 0x0605, blocks: (B:243:0x03ef, B:245:0x03f5, B:247:0x03fe, B:352:0x0597, B:354:0x059b, B:356:0x05a0, B:355:0x059e), top: B:785:0x03ef }] */
        /* JADX WARN: Removed duplicated region for block: B:350:0x0594  */
        /* JADX WARN: Removed duplicated region for block: B:512:0x0820  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:527:0x0858 A[PHI: r10
          0x0858: PHI (r10v56 ??) = (r10v6 ??), (r10v33 ??), (r10v34 ??) binds: [B:515:0x0825, B:517:0x0831, B:519:0x0842] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:544:0x0885 A[Catch: all -> 0x0acd, TRY_ENTER, TryCatch #24 {all -> 0x0acd, blocks: (B:528:0x085c, B:529:0x0867, B:545:0x0889, B:544:0x0885), top: B:796:0x085c }] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:624:0x09bf  */
        /* JADX WARN: Removed duplicated region for block: B:631:0x09d7 A[Catch: all -> 0x0ad1, TryCatch #31 {all -> 0x0ad1, blocks: (B:625:0x09c1, B:627:0x09cb, B:629:0x09d1, B:631:0x09d7, B:633:0x09dd, B:639:0x09f3, B:645:0x0a01, B:647:0x0a07, B:653:0x0a26, B:648:0x0a11, B:650:0x0a17, B:656:0x0a2e, B:658:0x0a3c, B:660:0x0a47, B:664:0x0a4e, B:593:0x0951), top: B:809:0x0951 }] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:651:0x0a23  */
        /* JADX WARN: Removed duplicated region for block: B:653:0x0a26 A[Catch: all -> 0x0ad1, TryCatch #31 {all -> 0x0ad1, blocks: (B:625:0x09c1, B:627:0x09cb, B:629:0x09d1, B:631:0x09d7, B:633:0x09dd, B:639:0x09f3, B:645:0x0a01, B:647:0x0a07, B:653:0x0a26, B:648:0x0a11, B:650:0x0a17, B:656:0x0a2e, B:658:0x0a3c, B:660:0x0a47, B:664:0x0a4e, B:593:0x0951), top: B:809:0x0951 }] */
        /* JADX WARN: Removed duplicated region for block: B:677:0x0a78 A[Catch: all -> 0x0ac1, TryCatch #12 {all -> 0x0ac1, blocks: (B:669:0x0a65, B:677:0x0a78, B:683:0x0a8e, B:685:0x0a96, B:689:0x0a9e), top: B:775:0x0a65 }] */
        /* JADX WARN: Removed duplicated region for block: B:692:0x0ab3 A[PHI: r9
          0x0ab3: PHI (r9v46 android.graphics.Bitmap) = (r9v45 android.graphics.Bitmap), (r9v52 android.graphics.Bitmap) binds: [B:632:0x09db, B:654:0x0a2a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:716:0x0ada A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:723:0x0aed  */
        /* JADX WARN: Removed duplicated region for block: B:724:0x0af3  */
        /* JADX WARN: Removed duplicated region for block: B:731:0x0b2c  */
        /* JADX WARN: Removed duplicated region for block: B:760:0x035c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:773:0x0ab8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:791:0x0211 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0159  */
        /* JADX WARN: Removed duplicated region for block: B:815:0x061f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:832:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:834:? A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r10v33, types: [int] */
        /* JADX WARN: Type inference failed for: r10v34, types: [ir.eitaa.messenger.ImageLoader] */
        /* JADX WARN: Type inference failed for: r10v56 */
        /* JADX WARN: Type inference failed for: r10v6, types: [int] */
        /* JADX WARN: Type inference failed for: r9v10 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 3002
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.ImageLoader.CacheOutTask.run():void");
        }

        private void onPostExecute(final Drawable drawable) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$CacheOutTask$SdG7t6A3lJ3eD70PHy18U66or6I
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPostExecute$1$ImageLoader$CacheOutTask(drawable);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onPostExecute$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onPostExecute$1$ImageLoader$CacheOutTask(final Drawable drawable) {
            final String str = null;
            if (drawable instanceof RLottieDrawable) {
                RLottieDrawable rLottieDrawable = (RLottieDrawable) drawable;
                Drawable drawable2 = (Drawable) ImageLoader.this.lottieMemCache.get(this.cacheImage.key);
                if (drawable2 == null) {
                    ImageLoader.this.lottieMemCache.put(this.cacheImage.key, rLottieDrawable);
                    drawable = rLottieDrawable;
                } else {
                    rLottieDrawable.recycle();
                    drawable = drawable2;
                }
                if (drawable != null) {
                    ImageLoader.this.incrementUseCount(this.cacheImage.key);
                    str = this.cacheImage.key;
                }
            } else if (!(drawable instanceof AnimatedFileDrawable)) {
                if (drawable instanceof BitmapDrawable) {
                    BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                    BitmapDrawable fromMemCache = ImageLoader.this.getFromMemCache(this.cacheImage.key);
                    boolean z = true;
                    if (fromMemCache == null) {
                        if (this.cacheImage.key.endsWith("_f")) {
                            ImageLoader.this.wallpaperMemCache.put(this.cacheImage.key, bitmapDrawable);
                            z = false;
                            drawable = bitmapDrawable;
                        } else {
                            ImageLoader.this.memCache.put(this.cacheImage.key, bitmapDrawable);
                            drawable = bitmapDrawable;
                        }
                    } else {
                        bitmapDrawable.getBitmap().recycle();
                        drawable = fromMemCache;
                    }
                    if (drawable != null && z) {
                        ImageLoader.this.incrementUseCount(this.cacheImage.key);
                        str = this.cacheImage.key;
                    }
                } else {
                    drawable = null;
                }
            }
            ImageLoader.this.imageLoadQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$CacheOutTask$LT6_09sBQLzuqyOxIuqBiCZGHNg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPostExecute$0$ImageLoader$CacheOutTask(drawable, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onPostExecute$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onPostExecute$0$ImageLoader$CacheOutTask(Drawable drawable, String str) {
            this.cacheImage.setImageAndClear(drawable, str);
        }

        public void cancel() {
            synchronized (this.sync) {
                try {
                    this.isCancelled = true;
                    Thread thread = this.runningThread;
                    if (thread != null) {
                        thread.interrupt();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BitmapDrawable getFromMemCache(String key) {
        BitmapDrawable bitmapDrawable = this.memCache.get(key);
        return bitmapDrawable == null ? this.wallpaperMemCache.get(key) : bitmapDrawable;
    }

    public static Bitmap getStrippedPhotoBitmap(byte[] photoBytes, String filter) {
        int length = (photoBytes.length - 3) + Bitmaps.header.length + Bitmaps.footer.length;
        byte[] bArr = bytesLocal.get();
        if (bArr == null || bArr.length < length) {
            bArr = null;
        }
        if (bArr == null) {
            bArr = new byte[length];
            bytesLocal.set(bArr);
        }
        byte[] bArr2 = Bitmaps.header;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        System.arraycopy(photoBytes, 3, bArr, Bitmaps.header.length, photoBytes.length - 3);
        System.arraycopy(Bitmaps.footer, 0, bArr, (Bitmaps.header.length + photoBytes.length) - 3, Bitmaps.footer.length);
        bArr[164] = photoBytes[1];
        bArr[166] = photoBytes[2];
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, length);
        if (bitmapDecodeByteArray != null && !TextUtils.isEmpty(filter) && filter.contains("b")) {
            Utilities.blurBitmap(bitmapDecodeByteArray, 3, 1, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), bitmapDecodeByteArray.getRowBytes());
        }
        return bitmapDecodeByteArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class CacheImage {
        protected ArtworkLoadTask artworkTask;
        protected CacheOutTask cacheTask;
        protected int currentAccount;
        protected File encryptionKeyPath;
        protected String ext;
        protected String filter;
        protected ArrayList<String> filters;
        protected File finalFilePath;
        protected HttpImageTask httpTask;
        protected ImageLocation imageLocation;
        protected ArrayList<ImageReceiver> imageReceiverArray;
        protected ArrayList<Integer> imageReceiverGuidsArray;
        protected int imageType;
        protected String key;
        protected ArrayList<String> keys;
        protected Object parentObject;
        protected SecureDocument secureDocument;
        protected int size;
        protected File tempFilePath;
        protected int type;
        protected ArrayList<Integer> types;
        protected String url;

        private CacheImage() {
            this.imageReceiverArray = new ArrayList<>();
            this.imageReceiverGuidsArray = new ArrayList<>();
            this.keys = new ArrayList<>();
            this.filters = new ArrayList<>();
            this.types = new ArrayList<>();
        }

        public void addImageReceiver(ImageReceiver imageReceiver, String key, String filter, int type, int guid) {
            int iIndexOf = this.imageReceiverArray.indexOf(imageReceiver);
            if (iIndexOf >= 0) {
                this.imageReceiverGuidsArray.set(iIndexOf, Integer.valueOf(guid));
                return;
            }
            this.imageReceiverArray.add(imageReceiver);
            this.imageReceiverGuidsArray.add(Integer.valueOf(guid));
            this.keys.add(key);
            this.filters.add(filter);
            this.types.add(Integer.valueOf(type));
            ImageLoader.this.imageLoadingByTag.put(imageReceiver.getTag(type), this);
        }

        public void replaceImageReceiver(ImageReceiver imageReceiver, String key, String filter, int type, int guid) {
            int iIndexOf = this.imageReceiverArray.indexOf(imageReceiver);
            if (iIndexOf == -1) {
                return;
            }
            if (this.types.get(iIndexOf).intValue() != type) {
                ArrayList<ImageReceiver> arrayList = this.imageReceiverArray;
                iIndexOf = arrayList.subList(iIndexOf + 1, arrayList.size()).indexOf(imageReceiver);
                if (iIndexOf == -1) {
                    return;
                }
            }
            this.imageReceiverGuidsArray.set(iIndexOf, Integer.valueOf(guid));
            this.keys.set(iIndexOf, key);
            this.filters.set(iIndexOf, filter);
        }

        public void setImageReceiverGuid(ImageReceiver imageReceiver, int guid) {
            int iIndexOf = this.imageReceiverArray.indexOf(imageReceiver);
            if (iIndexOf == -1) {
                return;
            }
            this.imageReceiverGuidsArray.set(iIndexOf, Integer.valueOf(guid));
        }

        public void removeImageReceiver(ImageReceiver imageReceiver) throws InterruptedException {
            int iIntValue = this.type;
            int i = 0;
            while (i < this.imageReceiverArray.size()) {
                ImageReceiver imageReceiver2 = this.imageReceiverArray.get(i);
                if (imageReceiver2 == null || imageReceiver2 == imageReceiver) {
                    this.imageReceiverArray.remove(i);
                    this.imageReceiverGuidsArray.remove(i);
                    this.keys.remove(i);
                    this.filters.remove(i);
                    iIntValue = this.types.remove(i).intValue();
                    if (imageReceiver2 != null) {
                        ImageLoader.this.imageLoadingByTag.remove(imageReceiver2.getTag(iIntValue));
                    }
                    i--;
                }
                i++;
            }
            if (this.imageReceiverArray.isEmpty()) {
                if (this.imageLocation != null && !ImageLoader.this.forceLoadingImages.containsKey(this.key)) {
                    ImageLocation imageLocation = this.imageLocation;
                    if (imageLocation.location != null) {
                        FileLoader.getInstance(this.currentAccount).cancelLoadFile(this.imageLocation.location, this.ext);
                    } else if (imageLocation.document != null) {
                        FileLoader.getInstance(this.currentAccount).cancelLoadFile(this.imageLocation.document);
                    } else if (imageLocation.secureDocument != null) {
                        FileLoader.getInstance(this.currentAccount).cancelLoadFile(this.imageLocation.secureDocument);
                    } else if (imageLocation.webFile != null) {
                        FileLoader.getInstance(this.currentAccount).cancelLoadFile(this.imageLocation.webFile);
                    }
                }
                if (this.cacheTask != null) {
                    if (iIntValue == 1) {
                        ImageLoader.this.cacheThumbOutQueue.cancelRunnable(this.cacheTask);
                    } else {
                        ImageLoader.this.cacheOutQueue.cancelRunnable(this.cacheTask);
                    }
                    this.cacheTask.cancel();
                    this.cacheTask = null;
                }
                if (this.httpTask != null) {
                    ImageLoader.this.httpTasks.remove(this.httpTask);
                    this.httpTask.cancel(true);
                    this.httpTask = null;
                }
                if (this.artworkTask != null) {
                    ImageLoader.this.artworkTasks.remove(this.artworkTask);
                    this.artworkTask.cancel(true);
                    this.artworkTask = null;
                }
                if (this.url != null) {
                    ImageLoader.this.imageLoadingByUrl.remove(this.url);
                }
                if (this.key != null) {
                    ImageLoader.this.imageLoadingByKeys.remove(this.key);
                }
            }
        }

        public void setImageAndClear(final Drawable image, final String decrementKey) {
            if (image != null) {
                final ArrayList arrayList = new ArrayList(this.imageReceiverArray);
                final ArrayList arrayList2 = new ArrayList(this.imageReceiverGuidsArray);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$CacheImage$NfhofmvVCJPKNO4vBebK9D3yQKY
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setImageAndClear$0$ImageLoader$CacheImage(image, arrayList, arrayList2, decrementKey);
                    }
                });
            }
            for (int i = 0; i < this.imageReceiverArray.size(); i++) {
                ImageLoader.this.imageLoadingByTag.remove(this.imageReceiverArray.get(i).getTag(this.type));
            }
            this.imageReceiverArray.clear();
            this.imageReceiverGuidsArray.clear();
            if (this.url != null) {
                ImageLoader.this.imageLoadingByUrl.remove(this.url);
            }
            if (this.key != null) {
                ImageLoader.this.imageLoadingByKeys.remove(this.key);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$setImageAndClear$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$setImageAndClear$0$ImageLoader$CacheImage(Drawable drawable, ArrayList arrayList, ArrayList arrayList2, String str) {
            int i = 0;
            if (drawable instanceof AnimatedFileDrawable) {
                AnimatedFileDrawable animatedFileDrawable = (AnimatedFileDrawable) drawable;
                boolean z = false;
                while (i < arrayList.size()) {
                    ImageReceiver imageReceiver = (ImageReceiver) arrayList.get(i);
                    AnimatedFileDrawable animatedFileDrawableMakeCopy = i == 0 ? animatedFileDrawable : animatedFileDrawable.makeCopy();
                    if (imageReceiver.setImageBitmapByKey(animatedFileDrawableMakeCopy, this.key, this.type, false, ((Integer) arrayList2.get(i)).intValue())) {
                        if (animatedFileDrawableMakeCopy == animatedFileDrawable) {
                            z = true;
                        }
                    } else if (animatedFileDrawableMakeCopy != animatedFileDrawable) {
                        animatedFileDrawableMakeCopy.recycle();
                    }
                    i++;
                }
                if (!z) {
                    animatedFileDrawable.recycle();
                }
            } else {
                while (i < arrayList.size()) {
                    ((ImageReceiver) arrayList.get(i)).setImageBitmapByKey(drawable, this.key, this.types.get(i).intValue(), false, ((Integer) arrayList2.get(i)).intValue());
                    i++;
                }
            }
            if (str != null) {
                ImageLoader.this.decrementUseCount(str);
            }
        }
    }

    public static ImageLoader getInstance() {
        ImageLoader imageLoader = Instance;
        if (imageLoader == null) {
            synchronized (ImageLoader.class) {
                imageLoader = Instance;
                if (imageLoader == null) {
                    imageLoader = new ImageLoader();
                    Instance = imageLoader;
                }
            }
        }
        return imageLoader;
    }

    public ImageLoader() {
        this.thumbGeneratingQueue.setPriority(1);
        int memoryClass = ((ActivityManager) ApplicationLoader.applicationContext.getSystemService("activity")).getMemoryClass();
        boolean z = memoryClass >= 192;
        this.canForce8888 = z;
        int iMin = Math.min(z ? 30 : 15, memoryClass / 7) * Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV * Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV;
        this.memCache = new LruCache<BitmapDrawable>(iMin) { // from class: ir.eitaa.messenger.ImageLoader.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // ir.eitaa.messenger.LruCache
            public int sizeOf(String key, BitmapDrawable value) {
                return value.getBitmap().getByteCount();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // ir.eitaa.messenger.LruCache
            public void entryRemoved(boolean evicted, String key, final BitmapDrawable oldValue, BitmapDrawable newValue) {
                if (ImageLoader.this.ignoreRemoval == null || !ImageLoader.this.ignoreRemoval.equals(key)) {
                    Integer num = (Integer) ImageLoader.this.bitmapUseCounts.get(key);
                    if (num == null || num.intValue() == 0) {
                        Bitmap bitmap = oldValue.getBitmap();
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        bitmap.recycle();
                    }
                }
            }
        };
        this.wallpaperMemCache = new LruCache<BitmapDrawable>(iMin / 4) { // from class: ir.eitaa.messenger.ImageLoader.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // ir.eitaa.messenger.LruCache
            public int sizeOf(String key, BitmapDrawable value) {
                return value.getBitmap().getByteCount();
            }
        };
        this.lottieMemCache = new LruCache<RLottieDrawable>(10485760) { // from class: ir.eitaa.messenger.ImageLoader.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // ir.eitaa.messenger.LruCache
            public int sizeOf(String key, RLottieDrawable value) {
                return value.getIntrinsicWidth() * value.getIntrinsicHeight() * 4 * 2;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // ir.eitaa.messenger.LruCache
            public void entryRemoved(boolean evicted, String key, final RLottieDrawable oldValue, RLottieDrawable newValue) {
                Integer num = (Integer) ImageLoader.this.bitmapUseCounts.get(key);
                if (num == null || num.intValue() == 0) {
                    oldValue.recycle();
                }
            }
        };
        SparseArray sparseArray = new SparseArray();
        File cacheDir = AndroidUtilities.getCacheDir();
        if (!cacheDir.isDirectory()) {
            try {
                cacheDir.mkdirs();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        AndroidUtilities.createEmptyFile(new File(cacheDir, ".nomedia"));
        sparseArray.put(4, cacheDir);
        for (int i = 0; i < 3; i++) {
            FileLoader.getInstance(i).setDelegate(new AnonymousClass4(i));
        }
        FileLoader.setMediaDirs(sparseArray);
        AnonymousClass5 anonymousClass5 = new AnonymousClass5();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
        intentFilter.addAction("android.intent.action.MEDIA_CHECKING");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_NOFS");
        intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
        intentFilter.addAction("android.intent.action.MEDIA_SHARED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTABLE");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        try {
            ApplicationLoader.applicationContext.registerReceiver(anonymousClass5, intentFilter);
        } catch (Throwable unused) {
        }
        checkMediaPaths();
    }

    /* renamed from: ir.eitaa.messenger.ImageLoader$4, reason: invalid class name */
    class AnonymousClass4 implements FileLoader.FileLoaderDelegate {
        final /* synthetic */ int val$currentAccount;

        AnonymousClass4(final int val$currentAccount) {
            this.val$currentAccount = val$currentAccount;
        }

        @Override // ir.eitaa.messenger.FileLoader.FileLoaderDelegate
        public void fileUploadProgressChanged(FileUploadOperation operation, final String location, final long uploadedSize, final long totalSize, final boolean isEncrypted) {
            ImageLoader.this.fileProgresses.put(location, new long[]{uploadedSize, totalSize});
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = operation.lastProgressUpdateTime;
            if (j == 0 || j < jElapsedRealtime - 100 || uploadedSize == totalSize) {
                operation.lastProgressUpdateTime = jElapsedRealtime;
                final int i = this.val$currentAccount;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$4$QPzcjtDuakb3C7CUrv_o5E_nGNM
                    @Override // java.lang.Runnable
                    public final void run() {
                        NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.fileUploadProgressChanged, location, Long.valueOf(uploadedSize), Long.valueOf(totalSize), Boolean.valueOf(isEncrypted));
                    }
                });
            }
        }

        @Override // ir.eitaa.messenger.FileLoader.FileLoaderDelegate
        public void fileDidUploaded(final String location, final TLRPC$InputFile inputFile, final TLRPC$InputEncryptedFile inputEncryptedFile, final byte[] key, final byte[] iv, final long totalFileSize) {
            DispatchQueue dispatchQueue = Utilities.stageQueue;
            final int i = this.val$currentAccount;
            dispatchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$4$1prWLULPyfwaypcFBMMiaWwRmrI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$fileDidUploaded$2$ImageLoader$4(i, location, inputFile, inputEncryptedFile, key, iv, totalFileSize);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$fileDidUploaded$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$fileDidUploaded$2$ImageLoader$4(final int i, final String str, final TLRPC$InputFile tLRPC$InputFile, final TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile, final byte[] bArr, final byte[] bArr2, final long j) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$4$awkw5-lWYaU8MBvrKBDwPZ7LSN0
                @Override // java.lang.Runnable
                public final void run() {
                    NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.fileUploaded, str, tLRPC$InputFile, tLRPC$InputEncryptedFile, bArr, bArr2, Long.valueOf(j));
                }
            });
            ImageLoader.this.fileProgresses.remove(str);
        }

        @Override // ir.eitaa.messenger.FileLoader.FileLoaderDelegate
        public void fileDidFailedUpload(final String location, final boolean isEncrypted) {
            DispatchQueue dispatchQueue = Utilities.stageQueue;
            final int i = this.val$currentAccount;
            dispatchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$4$qZsHoeOuYMqz1Qw_U_NEDM3DB2A
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$fileDidFailedUpload$4$ImageLoader$4(i, location, isEncrypted);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$fileDidFailedUpload$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$fileDidFailedUpload$4$ImageLoader$4(final int i, final String str, final boolean z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$4$wat3wiew5dQF2aL4UpcXwIKJne0
                @Override // java.lang.Runnable
                public final void run() {
                    NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.fileUploadFailed, str, Boolean.valueOf(z));
                }
            });
            ImageLoader.this.fileProgresses.remove(str);
        }

        @Override // ir.eitaa.messenger.FileLoader.FileLoaderDelegate
        public void fileDidLoaded(final String location, final File finalFile, final int type) {
            ImageLoader.this.fileProgresses.remove(location);
            final int i = this.val$currentAccount;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$4$vJ2hyAgcYCOrErvHda2yZLzuDdg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$fileDidLoaded$5$ImageLoader$4(finalFile, location, i, type);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$fileDidLoaded$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$fileDidLoaded$5$ImageLoader$4(File file, String str, int i, int i2) {
            if (SharedConfig.saveToGallery && ImageLoader.this.eitaaPath != null && file != null && ((str.endsWith(".mp4") || str.endsWith(".jpg")) && file.toString().startsWith(ImageLoader.this.eitaaPath.toString()))) {
                AndroidUtilities.addMediaToGallery(file.toString());
            }
            NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.fileLoaded, str, file);
            ImageLoader.this.fileDidLoaded(str, file, i2);
        }

        @Override // ir.eitaa.messenger.FileLoader.FileLoaderDelegate
        public void fileDidFailedLoad(final String location, final int canceled) {
            ImageLoader.this.fileProgresses.remove(location);
            final int i = this.val$currentAccount;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$4$4O-8Jb6L2CTC6oBwdPeoTM-WPBk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$fileDidFailedLoad$6$ImageLoader$4(location, canceled, i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$fileDidFailedLoad$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$fileDidFailedLoad$6$ImageLoader$4(String str, int i, int i2) {
            ImageLoader.this.fileDidFailedLoad(str, i);
            NotificationCenter.getInstance(i2).postNotificationName(NotificationCenter.fileLoadFailed, str, Integer.valueOf(i));
        }

        @Override // ir.eitaa.messenger.FileLoader.FileLoaderDelegate
        public void fileLoadProgressChanged(FileLoadOperation operation, final String location, final long uploadedSize, final long totalSize) {
            ImageLoader.this.fileProgresses.put(location, new long[]{uploadedSize, totalSize});
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = operation.lastProgressUpdateTime;
            if (j == 0 || j < jElapsedRealtime - 500 || uploadedSize == 0) {
                operation.lastProgressUpdateTime = jElapsedRealtime;
                final int i = this.val$currentAccount;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$4$qjPSnoPhSqAUmgw1yhpSUQK-hi4
                    @Override // java.lang.Runnable
                    public final void run() {
                        NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.fileLoadProgressChanged, location, Long.valueOf(uploadedSize), Long.valueOf(totalSize));
                    }
                });
            }
        }
    }

    /* renamed from: ir.eitaa.messenger.ImageLoader$5, reason: invalid class name */
    class AnonymousClass5 extends BroadcastReceiver {
        AnonymousClass5() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context arg0, Intent intent) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("file system changed");
            }
            Runnable runnable = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$5$CT92Dem_IcGYGm1XkjYbhicRsl8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onReceive$0$ImageLoader$5();
                }
            };
            if ("android.intent.action.MEDIA_UNMOUNTED".equals(intent.getAction())) {
                AndroidUtilities.runOnUIThread(runnable, 1000L);
            } else {
                runnable.run();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onReceive$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onReceive$0$ImageLoader$5() {
            ImageLoader.this.checkMediaPaths();
        }
    }

    public void checkMediaPaths() {
        this.cacheOutQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$OeSsOUB_B8nt0qGJT4-qNnEiyMg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkMediaPaths$1$ImageLoader();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkMediaPaths$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkMediaPaths$1$ImageLoader() {
        final SparseArray<File> sparseArrayCreateMediaPaths = createMediaPaths();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$LvVDYxtjiqQebZCwWBNUWJBP-jc
            @Override // java.lang.Runnable
            public final void run() {
                FileLoader.setMediaDirs(sparseArrayCreateMediaPaths);
            }
        });
    }

    public void addTestWebFile(String url, WebFile webFile) {
        if (url == null || webFile == null) {
            return;
        }
        this.testWebFile.put(url, webFile);
    }

    public void removeTestWebFile(String url) {
        if (url == null) {
            return;
        }
        this.testWebFile.remove(url);
    }

    @TargetApi(26)
    private static void moveDirectory(File source, final File target) {
        if (target.exists() || target.mkdir()) {
            try {
                Stream streamConvert = C$r8$wrapper$java$util$stream$Stream$VWRP.convert(Files.list(source.toPath()));
                try {
                    streamConvert.forEach(new Consumer() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$xmTlqEuLmm91meb6j9k0XrOcm-A
                        @Override // j$.util.function.Consumer
                        public final void accept(Object obj) throws IOException {
                            ImageLoader.lambda$moveDirectory$2(target, (Path) obj);
                        }

                        @Override // j$.util.function.Consumer
                        public /* synthetic */ Consumer andThen(Consumer consumer) {
                            return Consumer.CC.$default$andThen(this, consumer);
                        }
                    });
                    streamConvert.close();
                } catch (Throwable th) {
                    if (streamConvert != null) {
                        try {
                            streamConvert.close();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    static /* synthetic */ void lambda$moveDirectory$2(File file, Path path) throws IOException {
        File file2 = new File(file, path.getFileName().toString());
        if (Files.isDirectory(path, new LinkOption[0])) {
            moveDirectory(path.toFile(), file2);
            return;
        }
        try {
            Files.move(path, file2.toPath(), new CopyOption[0]);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public SparseArray<File> createMediaPaths() {
        ArrayList<File> rootDirs;
        SparseArray<File> sparseArray = new SparseArray<>();
        File cacheDir = AndroidUtilities.getCacheDir();
        if (!cacheDir.isDirectory()) {
            try {
                cacheDir.mkdirs();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        AndroidUtilities.createEmptyFile(new File(cacheDir, ".nomedia"));
        sparseArray.put(4, cacheDir);
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("cache path = " + cacheDir);
        }
        File file = new File(cacheDir, "temp");
        try {
            file.mkdirs();
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        sparseArray.put(57, file);
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (Build.VERSION.SDK_INT >= 19 && !TextUtils.isEmpty(SharedConfig.storageCacheDir) && (rootDirs = AndroidUtilities.getRootDirs()) != null) {
                    int size = rootDirs.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        File file2 = rootDirs.get(i);
                        if (file2.getAbsolutePath().startsWith(SharedConfig.storageCacheDir)) {
                            externalStorageDirectory = file2;
                            break;
                        }
                        i++;
                    }
                }
                File file3 = new File(externalStorageDirectory, "Eitaa");
                this.eitaaPath = file3;
                file3.mkdirs();
                if (Build.VERSION.SDK_INT >= 19 && !this.eitaaPath.isDirectory()) {
                    ArrayList<File> dataDirs = AndroidUtilities.getDataDirs();
                    int size2 = dataDirs.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size2) {
                            break;
                        }
                        File file4 = dataDirs.get(i2);
                        if (file4.getAbsolutePath().startsWith(SharedConfig.storageCacheDir)) {
                            File file5 = new File(file4, "Eitaa");
                            this.eitaaPath = file5;
                            file5.mkdirs();
                            break;
                        }
                        i2++;
                    }
                }
                if (this.eitaaPath.isDirectory()) {
                    try {
                        File file6 = new File(this.eitaaPath, "Eitaa Images");
                        file6.mkdir();
                        if (file6.isDirectory() && canMoveFiles(cacheDir, file6, 0)) {
                            sparseArray.put(0, file6);
                            if (BuildVars.LOGS_ENABLED) {
                                FileLog.d("image path = " + file6);
                            }
                        }
                    } catch (Exception e3) {
                        FileLog.e(e3);
                    }
                    try {
                        File file7 = new File(this.eitaaPath, "Eitaa Video");
                        file7.mkdir();
                        if (file7.isDirectory() && canMoveFiles(cacheDir, file7, 2)) {
                            sparseArray.put(2, file7);
                            if (BuildVars.LOGS_ENABLED) {
                                FileLog.d("video path = " + file7);
                            }
                        }
                    } catch (Exception e4) {
                        FileLog.e(e4);
                    }
                    try {
                        File file8 = new File(this.eitaaPath, "Eitaa Audio");
                        file8.mkdir();
                        if (file8.isDirectory() && canMoveFiles(cacheDir, file8, 1)) {
                            AndroidUtilities.createEmptyFile(new File(file8, ".nomedia"));
                            sparseArray.put(1, file8);
                            if (BuildVars.LOGS_ENABLED) {
                                FileLog.d("audio path = " + file8);
                            }
                        }
                    } catch (Exception e5) {
                        FileLog.e(e5);
                    }
                    try {
                        File file9 = new File(this.eitaaPath, "Eitaa Documents");
                        file9.mkdir();
                        if (file9.isDirectory() && canMoveFiles(cacheDir, file9, 3)) {
                            AndroidUtilities.createEmptyFile(new File(file9, ".nomedia"));
                            sparseArray.put(3, file9);
                            if (BuildVars.LOGS_ENABLED) {
                                FileLog.d("documents path = " + file9);
                            }
                        }
                    } catch (Exception e6) {
                        FileLog.e(e6);
                    }
                }
            } else if (BuildVars.LOGS_ENABLED) {
                FileLog.d("this Android can't rename files");
            }
            SharedConfig.checkSaveToGalleryFiles();
        } catch (Exception e7) {
            FileLog.e(e7);
        }
        return sparseArray;
    }

    private boolean canMoveFiles(File from, File to, int type) throws Throwable {
        File file;
        File file2;
        byte[] bArr;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                int iNextInt = Utilities.random.nextInt(1000);
                file = new File(from, iNextInt + "000000000_999999_temp.f");
                file2 = new File(to, iNextInt + "000000000_999999.f");
                bArr = new byte[Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV];
                file.createNewFile();
                randomAccessFile = new RandomAccessFile(file, "rws");
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            randomAccessFile.write(bArr);
            randomAccessFile.close();
            boolean zRenameTo = file.renameTo(file2);
            file.delete();
            file2.delete();
            return zRenameTo;
        } catch (Exception e2) {
            e = e2;
            randomAccessFile2 = randomAccessFile;
            FileLog.e(e);
            if (randomAccessFile2 == null) {
                return false;
            }
            try {
                randomAccessFile2.close();
                return false;
            } catch (Exception e3) {
                FileLog.e(e3);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (Exception e4) {
                    FileLog.e(e4);
                }
            }
            throw th;
        }
    }

    public Float getFileProgress(String location) {
        long[] jArr;
        if (location == null || (jArr = (long[]) this.fileProgresses.get(location)) == null) {
            return null;
        }
        if (jArr[1] == 0) {
            return Float.valueOf(0.0f);
        }
        return Float.valueOf(Math.min(1.0f, jArr[0] / jArr[1]));
    }

    public long[] getFileProgressSizes(String location) {
        if (location == null) {
            return null;
        }
        return (long[]) this.fileProgresses.get(location);
    }

    public String getReplacedKey(String oldKey) {
        if (oldKey == null) {
            return null;
        }
        return this.replacedBitmaps.get(oldKey);
    }

    private void performReplace(String oldKey, String newKey) {
        BitmapDrawable bitmapDrawable = this.memCache.get(oldKey);
        this.replacedBitmaps.put(oldKey, newKey);
        if (bitmapDrawable != null) {
            BitmapDrawable bitmapDrawable2 = this.memCache.get(newKey);
            boolean z = false;
            if (bitmapDrawable2 != null && bitmapDrawable2.getBitmap() != null && bitmapDrawable.getBitmap() != null) {
                Bitmap bitmap = bitmapDrawable2.getBitmap();
                Bitmap bitmap2 = bitmapDrawable.getBitmap();
                if (bitmap.getWidth() > bitmap2.getWidth() || bitmap.getHeight() > bitmap2.getHeight()) {
                    z = true;
                }
            }
            if (!z) {
                this.ignoreRemoval = oldKey;
                this.memCache.remove(oldKey);
                this.memCache.put(newKey, bitmapDrawable);
                this.ignoreRemoval = null;
            } else {
                this.memCache.remove(oldKey);
            }
        }
        Integer num = this.bitmapUseCounts.get(oldKey);
        if (num != null) {
            this.bitmapUseCounts.put(newKey, num);
            this.bitmapUseCounts.remove(oldKey);
        }
    }

    public void incrementUseCount(String key) {
        Integer num = this.bitmapUseCounts.get(key);
        if (num == null) {
            this.bitmapUseCounts.put(key, 1);
        } else {
            this.bitmapUseCounts.put(key, Integer.valueOf(num.intValue() + 1));
        }
    }

    public boolean decrementUseCount(String key) {
        Integer num = this.bitmapUseCounts.get(key);
        if (num == null) {
            return true;
        }
        if (num.intValue() == 1) {
            this.bitmapUseCounts.remove(key);
            return true;
        }
        this.bitmapUseCounts.put(key, Integer.valueOf(num.intValue() - 1));
        return false;
    }

    public void removeImage(String key) {
        this.bitmapUseCounts.remove(key);
        this.memCache.remove(key);
    }

    public boolean isInMemCache(String key, boolean animated) {
        return animated ? this.lottieMemCache.get(key) != null : getFromMemCache(key) != null;
    }

    public void clearMemory() {
        this.memCache.evictAll();
        this.lottieMemCache.evictAll();
    }

    private void removeFromWaitingForThumb(int TAG, ImageReceiver imageReceiver) {
        String str = this.waitingForQualityThumbByTag.get(TAG);
        if (str != null) {
            ThumbGenerateInfo thumbGenerateInfo = this.waitingForQualityThumb.get(str);
            if (thumbGenerateInfo != null) {
                int iIndexOf = thumbGenerateInfo.imageReceiverArray.indexOf(imageReceiver);
                if (iIndexOf >= 0) {
                    thumbGenerateInfo.imageReceiverArray.remove(iIndexOf);
                    thumbGenerateInfo.imageReceiverGuidsArray.remove(iIndexOf);
                }
                if (thumbGenerateInfo.imageReceiverArray.isEmpty()) {
                    this.waitingForQualityThumb.remove(str);
                }
            }
            this.waitingForQualityThumbByTag.remove(TAG);
        }
    }

    public void cancelLoadingForImageReceiver(final ImageReceiver imageReceiver, final boolean cancelAll) {
        if (imageReceiver == null) {
            return;
        }
        this.imageLoadQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$1EaihbyhFSHqP7av99wI2g3Txkk
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$cancelLoadingForImageReceiver$3$ImageLoader(cancelAll, imageReceiver);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cancelLoadingForImageReceiver$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$cancelLoadingForImageReceiver$3$ImageLoader(boolean z, ImageReceiver imageReceiver) throws InterruptedException {
        int i = 0;
        while (true) {
            int i2 = 3;
            if (i >= 3) {
                return;
            }
            if (i > 0 && !z) {
                return;
            }
            if (i == 0) {
                i2 = 1;
            } else if (i == 1) {
                i2 = 0;
            }
            int tag = imageReceiver.getTag(i2);
            if (tag != 0) {
                if (i == 0) {
                    removeFromWaitingForThumb(tag, imageReceiver);
                }
                CacheImage cacheImage = this.imageLoadingByTag.get(tag);
                if (cacheImage != null) {
                    cacheImage.removeImageReceiver(imageReceiver);
                }
            }
            i++;
        }
    }

    public BitmapDrawable getAnyImageFromMemory(String key) {
        ArrayList<String> filterKeys;
        BitmapDrawable bitmapDrawable = this.memCache.get(key);
        if (bitmapDrawable != null || (filterKeys = this.memCache.getFilterKeys(key)) == null || filterKeys.isEmpty()) {
            return bitmapDrawable;
        }
        return this.memCache.get(key + "@" + filterKeys.get(0));
    }

    public BitmapDrawable getImageFromMemory(TLObject fileLocation, String httpUrl, String filter) {
        String strMD5 = null;
        if (fileLocation == null && httpUrl == null) {
            return null;
        }
        if (httpUrl != null) {
            strMD5 = Utilities.MD5(httpUrl);
        } else if (fileLocation instanceof TLRPC$FileLocation) {
            TLRPC$FileLocation tLRPC$FileLocation = (TLRPC$FileLocation) fileLocation;
            strMD5 = tLRPC$FileLocation.volume_id + "_" + tLRPC$FileLocation.local_id;
        } else if (fileLocation instanceof TLRPC$Document) {
            TLRPC$Document tLRPC$Document = (TLRPC$Document) fileLocation;
            strMD5 = tLRPC$Document.dc_id + "_" + tLRPC$Document.id;
        } else if (fileLocation instanceof SecureDocument) {
            SecureDocument secureDocument = (SecureDocument) fileLocation;
            strMD5 = secureDocument.secureFile.dc_id + "_" + secureDocument.secureFile.id;
        } else if (fileLocation instanceof WebFile) {
            strMD5 = Utilities.MD5(((WebFile) fileLocation).url);
        }
        if (filter != null) {
            strMD5 = strMD5 + "@" + filter;
        }
        return getFromMemCache(strMD5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: replaceImageInCacheInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$replaceImageInCache$4$ImageLoader(final String oldKey, final String newKey, final ImageLocation newLocation) {
        ArrayList<String> filterKeys = this.memCache.getFilterKeys(oldKey);
        if (filterKeys != null) {
            for (int i = 0; i < filterKeys.size(); i++) {
                String str = filterKeys.get(i);
                String str2 = oldKey + "@" + str;
                String str3 = newKey + "@" + str;
                performReplace(str2, str3);
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didReplacedPhotoInMemCache, str2, str3, newLocation);
            }
            return;
        }
        performReplace(oldKey, newKey);
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didReplacedPhotoInMemCache, oldKey, newKey, newLocation);
    }

    public void replaceImageInCache(final String oldKey, final String newKey, final ImageLocation newLocation, boolean post) {
        if (post) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$oVhc3X7rXXl0lJU-wfIVRLdSgCY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$replaceImageInCache$4$ImageLoader(oldKey, newKey, newLocation);
                }
            });
        } else {
            lambda$replaceImageInCache$4(oldKey, newKey, newLocation);
        }
    }

    public void putImageToCache(BitmapDrawable bitmap, String key) {
        this.memCache.put(key, bitmap);
    }

    private void generateThumb(int mediaType, File originalPath, ThumbGenerateInfo info) {
        if ((mediaType != 0 && mediaType != 2 && mediaType != 3) || originalPath == null || info == null) {
            return;
        }
        if (this.thumbGenerateTasks.get(FileLoader.getAttachFileName(info.parentDocument)) == null) {
            this.thumbGeneratingQueue.postRunnable(new ThumbGenerateTask(mediaType, originalPath, info));
        }
    }

    public void cancelForceLoadingForImageReceiver(final ImageReceiver imageReceiver) {
        final String imageKey;
        if (imageReceiver == null || (imageKey = imageReceiver.getImageKey()) == null) {
            return;
        }
        this.imageLoadQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$9qKThD2ahepdp0OOQ7ciQh2kWyg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cancelForceLoadingForImageReceiver$5$ImageLoader(imageKey);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cancelForceLoadingForImageReceiver$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$cancelForceLoadingForImageReceiver$5$ImageLoader(String str) {
        this.forceLoadingImages.remove(str);
    }

    private void createLoadOperationForImageReceiver(final ImageReceiver imageReceiver, final String key, final String url, final String ext, final ImageLocation imageLocation, final String filter, final int size, final int cacheType, final int type, final int thumb, final int guid) {
        if (imageReceiver == null || url == null || key == null || imageLocation == null) {
            return;
        }
        int tag = imageReceiver.getTag(type);
        if (tag == 0) {
            tag = this.lastImageNum;
            imageReceiver.setTag(tag, type);
            int i = this.lastImageNum + 1;
            this.lastImageNum = i;
            if (i == Integer.MAX_VALUE) {
                this.lastImageNum = 0;
            }
        }
        final int i2 = tag;
        final boolean zIsNeedsQualityThumb = imageReceiver.isNeedsQualityThumb();
        final Object parentObject = imageReceiver.getParentObject();
        final TLRPC$Document qulityThumbDocument = imageReceiver.getQulityThumbDocument();
        final boolean zIsShouldGenerateQualityThumb = imageReceiver.isShouldGenerateQualityThumb();
        final int currentAccount = imageReceiver.getCurrentAccount();
        final boolean z = type == 0 && imageReceiver.isCurrentKeyQuality();
        this.imageLoadQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$c23nkbyxsfY_Dq0CEbkCs7WrVAc
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$createLoadOperationForImageReceiver$6$ImageLoader(thumb, url, key, i2, imageReceiver, guid, filter, type, imageLocation, z, parentObject, qulityThumbDocument, zIsNeedsQualityThumb, zIsShouldGenerateQualityThumb, ext, cacheType, size, currentAccount);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:119:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ff  */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* renamed from: lambda$createLoadOperationForImageReceiver$6, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$createLoadOperationForImageReceiver$6$ImageLoader(int r22, java.lang.String r23, java.lang.String r24, int r25, ir.eitaa.messenger.ImageReceiver r26, int r27, java.lang.String r28, int r29, ir.eitaa.messenger.ImageLocation r30, boolean r31, java.lang.Object r32, ir.eitaa.tgnet.TLRPC$Document r33, boolean r34, boolean r35, java.lang.String r36, int r37, int r38, int r39) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 1562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.ImageLoader.lambda$createLoadOperationForImageReceiver$6$ImageLoader(int, java.lang.String, java.lang.String, int, ir.eitaa.messenger.ImageReceiver, int, java.lang.String, int, ir.eitaa.messenger.ImageLocation, boolean, java.lang.Object, ir.eitaa.tgnet.TLRPC$Document, boolean, boolean, java.lang.String, int, int, int):void");
    }

    public void preloadArtwork(final String athumbUrl) {
        this.imageLoadQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$F_XvqMX8ypr8iZgT6D3GPQmUhU4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$preloadArtwork$7$ImageLoader(athumbUrl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$preloadArtwork$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$preloadArtwork$7$ImageLoader(String str) {
        String httpUrlExtension = getHttpUrlExtension(str, "jpg");
        String str2 = Utilities.MD5(str) + "." + httpUrlExtension;
        File file = new File(FileLoader.getDirectory(4), str2);
        if (file.exists()) {
            return;
        }
        ImageLocation forPath = ImageLocation.getForPath(str);
        CacheImage cacheImage = new CacheImage();
        cacheImage.type = 1;
        cacheImage.key = Utilities.MD5(str);
        cacheImage.filter = null;
        cacheImage.imageLocation = forPath;
        cacheImage.ext = httpUrlExtension;
        cacheImage.parentObject = null;
        int i = forPath.imageType;
        if (i != 0) {
            cacheImage.imageType = i;
        }
        cacheImage.url = str2;
        this.imageLoadingByUrl.put(str2, cacheImage);
        String strMD5 = Utilities.MD5(forPath.path);
        cacheImage.tempFilePath = new File(FileLoader.getDirectory(4), strMD5 + "_temp.jpg");
        cacheImage.finalFilePath = file;
        ArtworkLoadTask artworkLoadTask = new ArtworkLoadTask(cacheImage);
        cacheImage.artworkTask = artworkLoadTask;
        this.artworkTasks.add(artworkLoadTask);
        runArtworkTasks(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:145:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void loadImageForImageReceiver(ir.eitaa.messenger.ImageReceiver r37) {
        /*
            Method dump skipped, instructions count: 1296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.ImageLoader.loadImageForImageReceiver(ir.eitaa.messenger.ImageReceiver):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void httpFileLoadError(final String location) {
        this.imageLoadQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$LbIc-7Qbl0FTvmQ50DTEg6XOP10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$httpFileLoadError$8$ImageLoader(location);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$httpFileLoadError$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$httpFileLoadError$8$ImageLoader(String str) {
        CacheImage cacheImage = this.imageLoadingByUrl.get(str);
        if (cacheImage == null) {
            return;
        }
        HttpImageTask httpImageTask = cacheImage.httpTask;
        if (httpImageTask != null) {
            HttpImageTask httpImageTask2 = new HttpImageTask(httpImageTask.cacheImage, httpImageTask.imageSize);
            cacheImage.httpTask = httpImageTask2;
            this.httpTasks.add(httpImageTask2);
        }
        runHttpTasks(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void artworkLoadError(final String location) {
        this.imageLoadQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$2Tgx5dEDZrGa0g_ORWH9IwOusBM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$artworkLoadError$9$ImageLoader(location);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$artworkLoadError$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$artworkLoadError$9$ImageLoader(String str) {
        CacheImage cacheImage = this.imageLoadingByUrl.get(str);
        if (cacheImage == null) {
            return;
        }
        ArtworkLoadTask artworkLoadTask = cacheImage.artworkTask;
        if (artworkLoadTask != null) {
            ArtworkLoadTask artworkLoadTask2 = new ArtworkLoadTask(artworkLoadTask.cacheImage);
            cacheImage.artworkTask = artworkLoadTask2;
            this.artworkTasks.add(artworkLoadTask2);
        }
        runArtworkTasks(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fileDidLoaded(final String location, final File finalFile, final int mediaType) {
        this.imageLoadQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$KJPHovnDqCDfobFB-av169EUtfo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$fileDidLoaded$10$ImageLoader(location, mediaType, finalFile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$fileDidLoaded$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$fileDidLoaded$10$ImageLoader(String str, int i, File file) {
        ThumbGenerateInfo thumbGenerateInfo = this.waitingForQualityThumb.get(str);
        if (thumbGenerateInfo != null && thumbGenerateInfo.parentDocument != null) {
            generateThumb(i, file, thumbGenerateInfo);
            this.waitingForQualityThumb.remove(str);
        }
        CacheImage cacheImage = this.imageLoadingByUrl.get(str);
        if (cacheImage == null) {
            return;
        }
        this.imageLoadingByUrl.remove(str);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < cacheImage.imageReceiverArray.size(); i2++) {
            String str2 = cacheImage.keys.get(i2);
            String str3 = cacheImage.filters.get(i2);
            int iIntValue = cacheImage.types.get(i2).intValue();
            ImageReceiver imageReceiver = cacheImage.imageReceiverArray.get(i2);
            int iIntValue2 = cacheImage.imageReceiverGuidsArray.get(i2).intValue();
            CacheImage cacheImage2 = this.imageLoadingByKeys.get(str2);
            if (cacheImage2 == null) {
                cacheImage2 = new CacheImage();
                cacheImage2.secureDocument = cacheImage.secureDocument;
                cacheImage2.currentAccount = cacheImage.currentAccount;
                cacheImage2.finalFilePath = file;
                cacheImage2.parentObject = cacheImage.parentObject;
                cacheImage2.key = str2;
                cacheImage2.imageLocation = cacheImage.imageLocation;
                cacheImage2.type = iIntValue;
                cacheImage2.ext = cacheImage.ext;
                cacheImage2.encryptionKeyPath = cacheImage.encryptionKeyPath;
                cacheImage2.cacheTask = new CacheOutTask(cacheImage2);
                cacheImage2.filter = str3;
                cacheImage2.imageType = cacheImage.imageType;
                this.imageLoadingByKeys.put(str2, cacheImage2);
                arrayList.add(cacheImage2.cacheTask);
            }
            cacheImage2.addImageReceiver(imageReceiver, str2, str3, iIntValue, iIntValue2);
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            CacheOutTask cacheOutTask = (CacheOutTask) arrayList.get(i3);
            if (cacheOutTask.cacheImage.type == 1) {
                this.cacheThumbOutQueue.postRunnable(cacheOutTask);
            } else {
                this.cacheOutQueue.postRunnable(cacheOutTask);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fileDidFailedLoad(final String location, int canceled) {
        if (canceled == 1) {
            return;
        }
        this.imageLoadQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$lXtLu2pvSNvSYyQUQMb8NFcHEdY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$fileDidFailedLoad$11$ImageLoader(location);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$fileDidFailedLoad$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$fileDidFailedLoad$11$ImageLoader(String str) {
        CacheImage cacheImage = this.imageLoadingByUrl.get(str);
        if (cacheImage != null) {
            cacheImage.setImageAndClear(null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runHttpTasks(boolean complete) {
        if (complete) {
            this.currentHttpTasksCount--;
        }
        while (this.currentHttpTasksCount < 4 && !this.httpTasks.isEmpty()) {
            HttpImageTask httpImageTaskPoll = this.httpTasks.poll();
            if (httpImageTaskPoll != null) {
                httpImageTaskPoll.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null, null, null);
                this.currentHttpTasksCount++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runArtworkTasks(boolean complete) {
        if (complete) {
            this.currentArtworkTasksCount--;
        }
        while (this.currentArtworkTasksCount < 4 && !this.artworkTasks.isEmpty()) {
            try {
                this.artworkTasks.poll().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null, null, null);
                this.currentArtworkTasksCount++;
            } catch (Throwable unused) {
                runArtworkTasks(false);
            }
        }
    }

    public boolean isLoadingHttpFile(String url) {
        return this.httpFileLoadTasksByKeys.containsKey(url);
    }

    public static String getHttpFileName(String url) {
        return Utilities.MD5(url);
    }

    public static File getHttpFilePath(String url, String defaultExt) {
        String httpUrlExtension = getHttpUrlExtension(url, defaultExt);
        return new File(FileLoader.getDirectory(4), Utilities.MD5(url) + "." + httpUrlExtension);
    }

    public void loadHttpFile(String url, String defaultExt, int currentAccount) {
        if (url == null || url.length() == 0 || this.httpFileLoadTasksByKeys.containsKey(url)) {
            return;
        }
        String httpUrlExtension = getHttpUrlExtension(url, defaultExt);
        File file = new File(FileLoader.getDirectory(4), Utilities.MD5(url) + "_temp." + httpUrlExtension);
        file.delete();
        HttpFileTask httpFileTask = new HttpFileTask(url, file, httpUrlExtension, currentAccount);
        this.httpFileLoadTasks.add(httpFileTask);
        this.httpFileLoadTasksByKeys.put(url, httpFileTask);
        runHttpFileLoadTasks(null, 0);
    }

    public void cancelLoadHttpFile(String url) {
        HttpFileTask httpFileTask = this.httpFileLoadTasksByKeys.get(url);
        if (httpFileTask != null) {
            httpFileTask.cancel(true);
            this.httpFileLoadTasksByKeys.remove(url);
            this.httpFileLoadTasks.remove(httpFileTask);
        }
        Runnable runnable = this.retryHttpsTasks.get(url);
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
        }
        runHttpFileLoadTasks(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runHttpFileLoadTasks(final HttpFileTask oldTask, final int reason) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$F2MGdStEk624QS7Qy57aFvJbqCY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runHttpFileLoadTasks$13$ImageLoader(oldTask, reason);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runHttpFileLoadTasks$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runHttpFileLoadTasks$13$ImageLoader(HttpFileTask httpFileTask, int i) {
        if (httpFileTask != null) {
            this.currentHttpFileLoadTasksCount--;
        }
        if (httpFileTask != null) {
            if (i == 1) {
                if (!httpFileTask.canRetry) {
                    this.httpFileLoadTasksByKeys.remove(httpFileTask.url);
                    NotificationCenter.getInstance(httpFileTask.currentAccount).postNotificationName(NotificationCenter.httpFileDidFailedLoad, httpFileTask.url, 0);
                } else {
                    final HttpFileTask httpFileTask2 = new HttpFileTask(httpFileTask.url, httpFileTask.tempFile, httpFileTask.ext, httpFileTask.currentAccount);
                    Runnable runnable = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ImageLoader$YbmruUb6ydahJKfxFEJW6zYX7Z8
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$runHttpFileLoadTasks$12$ImageLoader(httpFileTask2);
                        }
                    };
                    this.retryHttpsTasks.put(httpFileTask.url, runnable);
                    AndroidUtilities.runOnUIThread(runnable, 1000L);
                }
            } else if (i == 2) {
                this.httpFileLoadTasksByKeys.remove(httpFileTask.url);
                File file = new File(FileLoader.getDirectory(4), Utilities.MD5(httpFileTask.url) + "." + httpFileTask.ext);
                if (!httpFileTask.tempFile.renameTo(file)) {
                    file = httpFileTask.tempFile;
                }
                NotificationCenter.getInstance(httpFileTask.currentAccount).postNotificationName(NotificationCenter.httpFileDidLoad, httpFileTask.url, file.toString());
            }
        }
        while (this.currentHttpFileLoadTasksCount < 2 && !this.httpFileLoadTasks.isEmpty()) {
            this.httpFileLoadTasks.poll().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null, null, null);
            this.currentHttpFileLoadTasksCount++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runHttpFileLoadTasks$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runHttpFileLoadTasks$12$ImageLoader(HttpFileTask httpFileTask) {
        this.httpFileLoadTasks.add(httpFileTask);
        runHttpFileLoadTasks(null, 0);
    }

    public static boolean shouldSendImageAsDocument(String path, Uri uri) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (path == null && uri != null && uri.getScheme() != null) {
            if (uri.getScheme().contains("file")) {
                path = uri.getPath();
            } else {
                try {
                    path = AndroidUtilities.getPath(uri);
                } catch (Throwable th) {
                    FileLog.e(th);
                }
            }
        }
        if (path != null) {
            BitmapFactory.decodeFile(path, options);
        } else if (uri != null) {
            try {
                InputStream inputStreamOpenInputStream = ApplicationLoader.applicationContext.getContentResolver().openInputStream(uri);
                BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                inputStreamOpenInputStream.close();
            } catch (Throwable th2) {
                FileLog.e(th2);
                return false;
            }
        }
        float f = options.outWidth;
        float f2 = options.outHeight;
        return f / f2 > 10.0f || f2 / f > 10.0f;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:0|2|(2:7|(1:9)(2:10|(2:165|14)))|18|(1:20)(18:(2:145|22)|28|(1:30)(1:31)|32|(1:34)|35|(3:37|(2:38|(1:40)(1:172))|41)|42|(1:44)(1:45)|46|(2:169|48)(1:(6:157|51|152|52|(1:54)|156))|60|143|(2:62|(6:64|(3:67|68|69)|66|80|(2:(1:83)|84)|(3:167|86|(4:88|(1:90)|91|(3:93|94|175)(1:174))(1:173))(2:148|(5:150|112|(6:170|114|(1:116)|117|(2:119|120)(1:123)|124)(0)|147|138)(1:180)))(3:71|72|73))(3:75|76|77)|142|80|(0)|(0)(0))|27|28|(0)(0)|32|(0)|35|(0)|42|(0)(0)|46|(0)(0)|60|143|(0)(0)|142|80|(0)|(0)(0)|(1:(0))) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0177 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0116 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f5 A[Catch: all -> 0x00dd, TRY_ENTER, TRY_LEAVE, TryCatch #12 {all -> 0x00dd, blocks: (B:48:0x00a7, B:67:0x00df, B:71:0x00ea, B:75:0x00f5), top: B:169:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0109  */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17, types: [int] */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v4, types: [int] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:127:0x01a7 -> B:147:0x01bd). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap loadBitmap(java.lang.String r11, android.net.Uri r12, float r13, float r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.ImageLoader.loadBitmap(java.lang.String, android.net.Uri, float, float, boolean):android.graphics.Bitmap");
    }

    public static void fillPhotoSizeWithBytes(TLRPC$PhotoSize photoSize) {
        if (photoSize != null) {
            byte[] bArr = photoSize.bytes;
            if (bArr == null || bArr.length == 0) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(FileLoader.getPathToAttach(photoSize, true), "r");
                    if (((int) randomAccessFile.length()) < 20000) {
                        byte[] bArr2 = new byte[(int) randomAccessFile.length()];
                        photoSize.bytes = bArr2;
                        randomAccessFile.readFully(bArr2, 0, bArr2.length);
                    }
                } catch (Throwable th) {
                    FileLog.e(th);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static ir.eitaa.tgnet.TLRPC$PhotoSize scaleAndSaveImageInternal(ir.eitaa.tgnet.TLRPC$PhotoSize r13, android.graphics.Bitmap r14, android.graphics.Bitmap.CompressFormat r15, boolean r16, int r17, int r18, float r19, float r20, float r21, int r22, boolean r23, boolean r24, boolean r25) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.ImageLoader.scaleAndSaveImageInternal(ir.eitaa.tgnet.TLRPC$PhotoSize, android.graphics.Bitmap, android.graphics.Bitmap$CompressFormat, boolean, int, int, float, float, float, int, boolean, boolean, boolean):ir.eitaa.tgnet.TLRPC$PhotoSize");
    }

    public static TLRPC$PhotoSize scaleAndSaveImage(Bitmap bitmap, float maxWidth, float maxHeight, int quality, boolean cache) {
        return scaleAndSaveImage(null, bitmap, Bitmap.CompressFormat.JPEG, false, maxWidth, maxHeight, quality, cache, 0, 0, false);
    }

    public static TLRPC$PhotoSize scaleAndSaveImage(TLRPC$PhotoSize photoSize, Bitmap bitmap, float maxWidth, float maxHeight, int quality, boolean cache, boolean forceCacheDir) {
        return scaleAndSaveImage(photoSize, bitmap, Bitmap.CompressFormat.JPEG, false, maxWidth, maxHeight, quality, cache, 0, 0, forceCacheDir);
    }

    public static TLRPC$PhotoSize scaleAndSaveImage(Bitmap bitmap, float maxWidth, float maxHeight, int quality, boolean cache, int minWidth, int minHeight) {
        return scaleAndSaveImage(null, bitmap, Bitmap.CompressFormat.JPEG, false, maxWidth, maxHeight, quality, cache, minWidth, minHeight, false);
    }

    public static TLRPC$PhotoSize scaleAndSaveImage(Bitmap bitmap, float maxWidth, float maxHeight, boolean progressive, int quality, boolean cache, int minWidth, int minHeight) {
        return scaleAndSaveImage(null, bitmap, Bitmap.CompressFormat.JPEG, progressive, maxWidth, maxHeight, quality, cache, minWidth, minHeight, false);
    }

    public static TLRPC$PhotoSize scaleAndSaveImage(Bitmap bitmap, Bitmap.CompressFormat compressFormat, float maxWidth, float maxHeight, int quality, boolean cache, int minWidth, int minHeight) {
        return scaleAndSaveImage(null, bitmap, compressFormat, false, maxWidth, maxHeight, quality, cache, minWidth, minHeight, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ir.eitaa.tgnet.TLRPC$PhotoSize scaleAndSaveImage(ir.eitaa.tgnet.TLRPC$PhotoSize r21, android.graphics.Bitmap r22, android.graphics.Bitmap.CompressFormat r23, boolean r24, float r25, float r26, int r27, boolean r28, int r29, int r30, boolean r31) {
        /*
            Method dump skipped, instructions count: 189
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.ImageLoader.scaleAndSaveImage(ir.eitaa.tgnet.TLRPC$PhotoSize, android.graphics.Bitmap, android.graphics.Bitmap$CompressFormat, boolean, float, float, int, boolean, int, int, boolean):ir.eitaa.tgnet.TLRPC$PhotoSize");
    }

    public static String getHttpUrlExtension(String url, String defaultExt) {
        String lastPathSegment = Uri.parse(url).getLastPathSegment();
        if (!TextUtils.isEmpty(lastPathSegment) && lastPathSegment.length() > 1) {
            url = lastPathSegment;
        }
        int iLastIndexOf = url.lastIndexOf(46);
        String strSubstring = iLastIndexOf != -1 ? url.substring(iLastIndexOf + 1) : null;
        return (strSubstring == null || strSubstring.length() == 0 || strSubstring.length() > 4) ? defaultExt : strSubstring;
    }

    public static void saveMessageThumbs(TLRPC$Message message) {
        TLRPC$PhotoSize tLRPC$PhotoSizeFindPhotoCachedSize;
        byte[] bArr;
        TLRPC$TL_messageMediaLiveStream tLRPC$TL_messageMediaLiveStream;
        ArrayList<TLRPC$PhotoSize> arrayList;
        if (message.media == null || (tLRPC$PhotoSizeFindPhotoCachedSize = findPhotoCachedSize(message)) == null || (bArr = tLRPC$PhotoSizeFindPhotoCachedSize.bytes) == null || bArr.length == 0) {
            return;
        }
        TLRPC$FileLocation tLRPC$FileLocation = tLRPC$PhotoSizeFindPhotoCachedSize.location;
        if (tLRPC$FileLocation == null || (tLRPC$FileLocation instanceof TLRPC$TL_fileLocationUnavailable)) {
            TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated = new TLRPC$TL_fileLocationToBeDeprecated();
            tLRPC$PhotoSizeFindPhotoCachedSize.location = tLRPC$TL_fileLocationToBeDeprecated;
            tLRPC$TL_fileLocationToBeDeprecated.volume_id = -2147483648L;
            tLRPC$TL_fileLocationToBeDeprecated.local_id = SharedConfig.getLastLocalId();
        }
        boolean z = true;
        File pathToAttach = FileLoader.getPathToAttach(tLRPC$PhotoSizeFindPhotoCachedSize, true);
        int i = 0;
        if (MessageObject.shouldEncryptPhotoOrVideo(message)) {
            pathToAttach = new File(pathToAttach.getAbsolutePath() + ".enc");
        } else {
            z = false;
        }
        if (!pathToAttach.exists()) {
            if (z) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(new File(FileLoader.getInternalCacheDir(), pathToAttach.getName() + ".key"), "rws");
                    long length = randomAccessFile.length();
                    byte[] bArr2 = new byte[32];
                    byte[] bArr3 = new byte[16];
                    if (length > 0 && length % 48 == 0) {
                        randomAccessFile.read(bArr2, 0, 32);
                        randomAccessFile.read(bArr3, 0, 16);
                    } else {
                        Utilities.random.nextBytes(bArr2);
                        Utilities.random.nextBytes(bArr3);
                        randomAccessFile.write(bArr2);
                        randomAccessFile.write(bArr3);
                    }
                    randomAccessFile.close();
                    byte[] bArr4 = tLRPC$PhotoSizeFindPhotoCachedSize.bytes;
                    Utilities.aesCtrDecryptionByteArray(bArr4, bArr2, bArr3, 0, bArr4.length, 0);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(pathToAttach, "rws");
            randomAccessFile2.write(tLRPC$PhotoSizeFindPhotoCachedSize.bytes);
            randomAccessFile2.close();
        }
        TLRPC$TL_photoSize_layer127 tLRPC$TL_photoSize_layer127 = new TLRPC$TL_photoSize_layer127();
        tLRPC$TL_photoSize_layer127.w = tLRPC$PhotoSizeFindPhotoCachedSize.w;
        tLRPC$TL_photoSize_layer127.h = tLRPC$PhotoSizeFindPhotoCachedSize.h;
        tLRPC$TL_photoSize_layer127.location = tLRPC$PhotoSizeFindPhotoCachedSize.location;
        tLRPC$TL_photoSize_layer127.size = tLRPC$PhotoSizeFindPhotoCachedSize.size;
        tLRPC$TL_photoSize_layer127.type = tLRPC$PhotoSizeFindPhotoCachedSize.type;
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) {
            int size = tLRPC$MessageMedia.photo.sizes.size();
            while (i < size) {
                if (message.media.photo.sizes.get(i) instanceof TLRPC$TL_photoCachedSize) {
                    message.media.photo.sizes.set(i, tLRPC$TL_photoSize_layer127);
                    return;
                }
                i++;
            }
            return;
        }
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) {
            int size2 = tLRPC$MessageMedia.document.thumbs.size();
            while (i < size2) {
                if (message.media.document.thumbs.get(i) instanceof TLRPC$TL_photoCachedSize) {
                    message.media.document.thumbs.set(i, tLRPC$TL_photoSize_layer127);
                    return;
                }
                i++;
            }
            return;
        }
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
            int size3 = tLRPC$MessageMedia.webpage.photo.sizes.size();
            while (i < size3) {
                if (message.media.webpage.photo.sizes.get(i) instanceof TLRPC$TL_photoCachedSize) {
                    message.media.webpage.photo.sizes.set(i, tLRPC$TL_photoSize_layer127);
                    return;
                }
                i++;
            }
            return;
        }
        if (!(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaLiveStream) || (arrayList = (tLRPC$TL_messageMediaLiveStream = (TLRPC$TL_messageMediaLiveStream) tLRPC$MessageMedia).thumbs) == null) {
            return;
        }
        int size4 = arrayList.size();
        while (i < size4 && !(tLRPC$TL_messageMediaLiveStream.thumbs.get(i) instanceof TLRPC$TL_photoCachedSize)) {
            i++;
        }
    }

    private static TLRPC$PhotoSize findPhotoCachedSize(TLRPC$Message message) {
        TLRPC$TL_messageMediaLiveStream tLRPC$TL_messageMediaLiveStream;
        ArrayList<TLRPC$PhotoSize> arrayList;
        TLRPC$PhotoSize tLRPC$PhotoSize;
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        int i = 0;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) {
            int size = tLRPC$MessageMedia.photo.sizes.size();
            while (i < size) {
                tLRPC$PhotoSize = message.media.photo.sizes.get(i);
                if (!(tLRPC$PhotoSize instanceof TLRPC$TL_photoCachedSize)) {
                    i++;
                }
            }
            return null;
        }
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) {
            int size2 = tLRPC$MessageMedia.document.thumbs.size();
            while (i < size2) {
                tLRPC$PhotoSize = message.media.document.thumbs.get(i);
                if (!(tLRPC$PhotoSize instanceof TLRPC$TL_photoCachedSize)) {
                    i++;
                }
            }
            return null;
        }
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
            TLRPC$Photo tLRPC$Photo = tLRPC$MessageMedia.webpage.photo;
            if (tLRPC$Photo == null) {
                return null;
            }
            int size3 = tLRPC$Photo.sizes.size();
            while (i < size3) {
                tLRPC$PhotoSize = message.media.webpage.photo.sizes.get(i);
                if (!(tLRPC$PhotoSize instanceof TLRPC$TL_photoCachedSize)) {
                    i++;
                }
            }
            return null;
        }
        if (!(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaLiveStream) || (arrayList = (tLRPC$TL_messageMediaLiveStream = (TLRPC$TL_messageMediaLiveStream) tLRPC$MessageMedia).thumbs) == null) {
            return null;
        }
        int size4 = arrayList.size();
        while (i < size4) {
            tLRPC$PhotoSize = tLRPC$TL_messageMediaLiveStream.thumbs.get(i);
            if (!(tLRPC$PhotoSize instanceof TLRPC$TL_photoCachedSize)) {
                i++;
            }
        }
        return null;
        return tLRPC$PhotoSize;
    }

    public static void saveMessagesThumbs(ArrayList<TLRPC$Message> messages) {
        if (messages == null || messages.isEmpty()) {
            return;
        }
        for (int i = 0; i < messages.size(); i++) {
            saveMessageThumbs(messages.get(i));
        }
    }

    public static MessageThumb generateMessageThumb(TLRPC$Message message) {
        int i;
        int i2;
        Bitmap strippedPhotoBitmap;
        byte[] bArr;
        TLRPC$PhotoSize tLRPC$PhotoSizeFindPhotoCachedSize = findPhotoCachedSize(message);
        if (tLRPC$PhotoSizeFindPhotoCachedSize != null && (bArr = tLRPC$PhotoSizeFindPhotoCachedSize.bytes) != null && bArr.length != 0) {
            File pathToAttach = FileLoader.getPathToAttach(tLRPC$PhotoSizeFindPhotoCachedSize, true);
            TLRPC$TL_photoSize_layer127 tLRPC$TL_photoSize_layer127 = new TLRPC$TL_photoSize_layer127();
            tLRPC$TL_photoSize_layer127.w = tLRPC$PhotoSizeFindPhotoCachedSize.w;
            tLRPC$TL_photoSize_layer127.h = tLRPC$PhotoSizeFindPhotoCachedSize.h;
            tLRPC$TL_photoSize_layer127.location = tLRPC$PhotoSizeFindPhotoCachedSize.location;
            tLRPC$TL_photoSize_layer127.size = tLRPC$PhotoSizeFindPhotoCachedSize.size;
            tLRPC$TL_photoSize_layer127.type = tLRPC$PhotoSizeFindPhotoCachedSize.type;
            if (pathToAttach.exists() && message.grouped_id == 0) {
                ir.eitaa.ui.Components.Point messageSize = ChatMessageCell.getMessageSize(tLRPC$PhotoSizeFindPhotoCachedSize.w, tLRPC$PhotoSizeFindPhotoCachedSize.h);
                String str = String.format(Locale.US, "%d_%d@%d_%d_b", Long.valueOf(tLRPC$PhotoSizeFindPhotoCachedSize.location.volume_id), Integer.valueOf(tLRPC$PhotoSizeFindPhotoCachedSize.location.local_id), Integer.valueOf((int) (messageSize.x / AndroidUtilities.density)), Integer.valueOf((int) (messageSize.y / AndroidUtilities.density)));
                if (!getInstance().isInMemCache(str, false)) {
                    String path = pathToAttach.getPath();
                    float f = messageSize.x;
                    float f2 = AndroidUtilities.density;
                    Bitmap bitmapLoadBitmap = loadBitmap(path, null, (int) (f / f2), (int) (messageSize.y / f2), false);
                    if (bitmapLoadBitmap != null) {
                        Utilities.blurBitmap(bitmapLoadBitmap, 3, 1, bitmapLoadBitmap.getWidth(), bitmapLoadBitmap.getHeight(), bitmapLoadBitmap.getRowBytes());
                        float f3 = messageSize.x;
                        float f4 = AndroidUtilities.density;
                        Bitmap bitmapCreateScaledBitmap = Bitmaps.createScaledBitmap(bitmapLoadBitmap, (int) (f3 / f4), (int) (messageSize.y / f4), true);
                        if (bitmapCreateScaledBitmap != bitmapLoadBitmap) {
                            bitmapLoadBitmap.recycle();
                            bitmapLoadBitmap = bitmapCreateScaledBitmap;
                        }
                        return new MessageThumb(str, new BitmapDrawable(bitmapLoadBitmap));
                    }
                }
            }
        } else {
            TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
            if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) {
                int size = tLRPC$MessageMedia.document.thumbs.size();
                for (int i3 = 0; i3 < size; i3++) {
                    TLRPC$PhotoSize tLRPC$PhotoSize = message.media.document.thumbs.get(i3);
                    if (tLRPC$PhotoSize instanceof TLRPC$TL_photoStrippedSize) {
                        TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(message.media.document.thumbs, 320);
                        if (closestPhotoSizeWithSize == null) {
                            int i4 = 0;
                            while (true) {
                                if (i4 >= message.media.document.attributes.size()) {
                                    i = 0;
                                    i2 = 0;
                                    break;
                                }
                                if (message.media.document.attributes.get(i4) instanceof TLRPC$TL_documentAttributeVideo) {
                                    TLRPC$TL_documentAttributeVideo tLRPC$TL_documentAttributeVideo = (TLRPC$TL_documentAttributeVideo) message.media.document.attributes.get(i4);
                                    i2 = tLRPC$TL_documentAttributeVideo.h;
                                    i = tLRPC$TL_documentAttributeVideo.w;
                                    break;
                                }
                                i4++;
                            }
                        } else {
                            i2 = closestPhotoSizeWithSize.h;
                            i = closestPhotoSizeWithSize.w;
                        }
                        ir.eitaa.ui.Components.Point messageSize2 = ChatMessageCell.getMessageSize(i, i2);
                        String str2 = String.format(Locale.US, "%s_false@%d_%d_b", ImageLocation.getStippedKey(message, message, tLRPC$PhotoSize), Integer.valueOf((int) (messageSize2.x / AndroidUtilities.density)), Integer.valueOf((int) (messageSize2.y / AndroidUtilities.density)));
                        if (!getInstance().memCache.contains(str2) && (strippedPhotoBitmap = getStrippedPhotoBitmap(tLRPC$PhotoSize.bytes, null)) != null) {
                            Utilities.blurBitmap(strippedPhotoBitmap, 3, 1, strippedPhotoBitmap.getWidth(), strippedPhotoBitmap.getHeight(), strippedPhotoBitmap.getRowBytes());
                            float f5 = messageSize2.x;
                            float f6 = AndroidUtilities.density;
                            Bitmap bitmapCreateScaledBitmap2 = Bitmaps.createScaledBitmap(strippedPhotoBitmap, (int) (f5 / f6), (int) (messageSize2.y / f6), true);
                            if (bitmapCreateScaledBitmap2 != strippedPhotoBitmap) {
                                strippedPhotoBitmap.recycle();
                                strippedPhotoBitmap = bitmapCreateScaledBitmap2;
                            }
                            return new MessageThumb(str2, new BitmapDrawable(strippedPhotoBitmap));
                        }
                    }
                }
            }
        }
        return null;
    }

    public static class MessageThumb {
        BitmapDrawable drawable;
        String key;

        public MessageThumb(String key, BitmapDrawable bitmapDrawable) {
            this.key = key;
            this.drawable = bitmapDrawable;
        }
    }

    public static void saveAdThumbs(TLRPC$Ads_Ad ad) throws IOException {
        byte[] bArr;
        ArrayList<TLRPC$PhotoSize> arrayList = ad.photos;
        if (arrayList == null) {
            return;
        }
        TLRPC$PhotoSize tLRPC$PhotoSize = null;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            TLRPC$PhotoSize tLRPC$PhotoSize2 = arrayList.get(i);
            if (tLRPC$PhotoSize2 instanceof TLRPC$TL_photoCachedSize) {
                tLRPC$PhotoSize = tLRPC$PhotoSize2;
                break;
            }
            i++;
        }
        if (tLRPC$PhotoSize == null || (bArr = tLRPC$PhotoSize.bytes) == null || bArr.length == 0) {
            return;
        }
        if (tLRPC$PhotoSize.location instanceof TLRPC$TL_fileLocationUnavailable) {
            TLRPC$TL_fileLocation_layer82 tLRPC$TL_fileLocation_layer82 = new TLRPC$TL_fileLocation_layer82();
            tLRPC$PhotoSize.location = tLRPC$TL_fileLocation_layer82;
            tLRPC$TL_fileLocation_layer82.volume_id = -2147483648L;
            tLRPC$TL_fileLocation_layer82.dc_id = Integer.MIN_VALUE;
            tLRPC$TL_fileLocation_layer82.local_id = SharedConfig.getLastLocalId();
        }
        File pathToAttach = FileLoader.getPathToAttach(tLRPC$PhotoSize, true);
        if (!pathToAttach.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(pathToAttach, "rws");
                randomAccessFile.write(tLRPC$PhotoSize.bytes);
                randomAccessFile.close();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        TLRPC$TL_photoSize tLRPC$TL_photoSize = new TLRPC$TL_photoSize();
        tLRPC$TL_photoSize.w = tLRPC$PhotoSize.w;
        tLRPC$TL_photoSize.h = tLRPC$PhotoSize.h;
        tLRPC$TL_photoSize.location = tLRPC$PhotoSize.location;
        tLRPC$TL_photoSize.size = tLRPC$PhotoSize.size;
        tLRPC$TL_photoSize.type = tLRPC$PhotoSize.type;
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (arrayList.get(i2) instanceof TLRPC$TL_photoCachedSize) {
                arrayList.set(i2, tLRPC$TL_photoSize);
                return;
            }
        }
    }

    public static void saveAdsThumbs(ArrayList<TLRPC$Ads_Ad> ads) {
        if (ads == null || ads.isEmpty()) {
            return;
        }
        for (int i = 0; i < ads.size(); i++) {
            saveAdThumbs(ads.get(i));
        }
    }
}

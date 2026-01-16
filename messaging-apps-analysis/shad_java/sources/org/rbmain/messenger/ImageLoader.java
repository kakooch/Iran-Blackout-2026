package org.rbmain.messenger;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import androidMessenger.proxy.CallProxy$$ExternalSyntheticBackport0;
import androidMessenger.proxy.IdStorage;
import androidx.core.graphics.ColorUtils;
import com.facebook.stetho.common.Utf8Charset;
import ir.appp.rghapp.components.sshCrop.SSHCropView;
import ir.appp.rghapp.rubinoPostSlider.FileLoaderRubinoPost;
import ir.appp.rghapp.rubinoPostSlider.PhotoViewerObject;
import j$.util.concurrent.ConcurrentHashMap;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.rbmain.DispatchQueuePriority;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$InputEncryptedFile;
import org.rbmain.tgnet.TLRPC$InputFile;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$Photo;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeVideo;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_fileLocationToBeDeprecated;
import org.rbmain.tgnet.TLRPC$TL_fileLocationUnavailable;
import org.rbmain.tgnet.TLRPC$TL_messageMediaDocument;
import org.rbmain.tgnet.TLRPC$TL_messageMediaPhoto;
import org.rbmain.tgnet.TLRPC$TL_messageMediaWebPage;
import org.rbmain.tgnet.TLRPC$TL_photoCachedSize;
import org.rbmain.tgnet.TLRPC$TL_photoSize;
import org.rbmain.tgnet.TLRPC$TL_photoStrippedSize;
import org.rbmain.tgnet.TLRPC$WallPaper;
import org.rbmain.tgnet.TLRPC$WallPaperSettings;
import org.rbmain.ui.Cells.ChatMessageCell;
import org.rbmain.ui.Components.AnimatedFileDrawable;
import org.rbmain.ui.Components.RLottieDrawable;

/* loaded from: classes4.dex */
public class ImageLoader {
    public static final String AUTOPLAY_FILTER = "g";
    private boolean canForce8888;
    private LruCache<BitmapDrawable> lottieMemCache;
    private LruCache<BitmapDrawable> memCache;
    private LruCache<BitmapDrawable> smallImagesMemCache;
    private LruCache<BitmapDrawable> wallpaperMemCache;
    private static ThreadLocal<byte[]> bytesLocal = new ThreadLocal<>();
    private static ThreadLocal<byte[]> bytesThumbLocal = new ThreadLocal<>();
    private static byte[] header = new byte[12];
    private static byte[] headerThumb = new byte[12];
    private static volatile ImageLoader Instance = null;
    private HashMap<String, Integer> bitmapUseCounts = new HashMap<>();
    ArrayList<AnimatedFileDrawable> cachedAnimatedFileDrawables = new ArrayList<>();
    private HashMap<String, CacheImage> imageLoadingByUrl = new HashMap<>();
    private HashMap<String, CacheImage> imageLoadingByKeys = new HashMap<>();
    private SparseArray<CacheImage> imageLoadingByTag = new SparseArray<>();
    private HashMap<String, ThumbGenerateInfo> waitingForQualityThumb = new HashMap<>();
    private SparseArray<String> waitingForQualityThumbByTag = new SparseArray<>();
    private LinkedList<HttpImageTask> httpTasks = new LinkedList<>();
    private LinkedList<ArtworkLoadTask> artworkTasks = new LinkedList<>();
    private DispatchQueuePriority cacheOutQueue = new DispatchQueuePriority("cacheOutQueue");
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
    private File rubikaPath = null;

    public static boolean hasAutoplayFilter(String str) {
        if (str == null) {
            return false;
        }
        for (String str2 : str.split("_")) {
            if (AUTOPLAY_FILTER.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public void moveToFront(String str) {
        if (str == null) {
            return;
        }
        if (this.lottieMemCache.get(str) != null) {
            this.lottieMemCache.moveToFront(str);
        }
        if (this.memCache.get(str) != null) {
            this.memCache.moveToFront(str);
        }
        if (this.smallImagesMemCache.get(str) != null) {
            this.smallImagesMemCache.moveToFront(str);
        }
    }

    public void putThumbsToCache(ArrayList<MessageThumb> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            putImageToCache(arrayList.get(i).drawable, arrayList.get(i).key, true);
        }
    }

    public LruCache<BitmapDrawable> getLottieMemCahce() {
        return this.lottieMemCache;
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

        public HttpFileTask(String str, File file, String str2, int i) {
            this.url = str;
            this.tempFile = file;
            this.ext = str2;
            this.currentAccount = i;
        }

        private void reportProgress(final long j, final long j2) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (j != j2) {
                long j3 = this.lastProgressTime;
                if (j3 != 0 && j3 >= jElapsedRealtime - 100) {
                    return;
                }
            }
            this.lastProgressTime = jElapsedRealtime;
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$HttpFileTask$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$reportProgress$1(j, j2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$reportProgress$1(final long j, final long j2) {
            ImageLoader.this.fileProgresses.put(this.url, new long[]{j, j2});
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$HttpFileTask$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$reportProgress$0(j, j2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$reportProgress$0(long j, long j2) {
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.FileLoadProgressChanged, this.url, Long.valueOf(j), Long.valueOf(j2));
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
        
            org.rbmain.messenger.FileLog.e(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0136, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x013a, code lost:
        
            org.rbmain.messenger.FileLog.e(r0);
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
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.ImageLoader.HttpFileTask.doInBackground(java.lang.Void[]):java.lang.Boolean");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            ImageLoader.this.runHttpFileLoadTasks(this, bool.booleanValue() ? 2 : 1);
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
        public String doInBackground(Void... voidArr) throws IOException {
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
                        FileLog.e((Throwable) e, false);
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
                                FileLog.e(th, false);
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
        public void onPostExecute(final String str) {
            if (str != null) {
                ImageLoader.this.imageLoadQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$ArtworkLoadTask$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onPostExecute$0(str);
                    }
                });
            } else if (this.canRetry) {
                ImageLoader.this.artworkLoadError(this.cacheImage.url);
            }
            ImageLoader.this.imageLoadQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$ArtworkLoadTask$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPostExecute$1();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPostExecute$0(String str) {
            CacheImage cacheImage = this.cacheImage;
            cacheImage.httpTask = ImageLoader.this.new HttpImageTask(cacheImage, 0, str);
            ImageLoader.this.httpTasks.add(this.cacheImage.httpTask);
            ImageLoader.this.runHttpTasks(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPostExecute$1() {
            ImageLoader.this.runArtworkTasks(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCancelled$2() {
            ImageLoader.this.runArtworkTasks(true);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            ImageLoader.this.imageLoadQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$ArtworkLoadTask$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCancelled$2();
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
        private long imageSize;
        private long lastProgressTime;
        private String overrideUrl;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$doInBackground$2(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        }

        public HttpImageTask(CacheImage cacheImage, long j) {
            this.cacheImage = cacheImage;
            this.imageSize = j;
        }

        public HttpImageTask(CacheImage cacheImage, int i, String str) {
            this.cacheImage = cacheImage;
            this.imageSize = i;
            this.overrideUrl = str;
        }

        private void reportProgress(final long j, final long j2) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (j != j2) {
                long j3 = this.lastProgressTime;
                if (j3 != 0 && j3 >= jElapsedRealtime - 100) {
                    return;
                }
            }
            this.lastProgressTime = jElapsedRealtime;
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$HttpImageTask$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$reportProgress$1(j, j2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$reportProgress$1(final long j, final long j2) {
            ImageLoader.this.fileProgresses.put(this.cacheImage.url, new long[]{j, j2});
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$HttpImageTask$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$reportProgress$0(j, j2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$reportProgress$0(long j, long j2) {
            NotificationCenter.getInstance(this.cacheImage.currentAccount).postNotificationName(NotificationCenter.FileLoadProgressChanged, this.cacheImage.url, Long.valueOf(j), Long.valueOf(j2));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:100:0x0175, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x0176, code lost:
        
            r1 = r2;
            r2 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x0179, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x017a, code lost:
        
            r1 = r2;
            r2 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x017d, code lost:
        
            r1 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x0180, code lost:
        
            org.rbmain.messenger.FileLog.e(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:107:0x0183, code lost:
        
            r1 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x0187, code lost:
        
            org.rbmain.messenger.FileLog.e(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x0169, code lost:
        
            if (r7 != (-1)) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x016b, code lost:
        
            r2 = r12.imageSize;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x016f, code lost:
        
            if (r2 == 0) goto L108;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0171, code lost:
        
            reportProgress(r2, r2);
         */
        /* JADX WARN: Removed duplicated region for block: B:113:0x018e A[Catch: all -> 0x0194, TRY_LEAVE, TryCatch #4 {all -> 0x0194, blocks: (B:111:0x018a, B:113:0x018e), top: B:143:0x018a }] */
        /* JADX WARN: Removed duplicated region for block: B:119:0x019c A[Catch: all -> 0x01a0, TRY_LEAVE, TryCatch #0 {all -> 0x01a0, blocks: (B:117:0x0198, B:119:0x019c), top: B:135:0x0198 }] */
        /* JADX WARN: Removed duplicated region for block: B:128:0x01ad  */
        /* JADX WARN: Removed duplicated region for block: B:149:0x01a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:151:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00e7  */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Boolean doInBackground(java.lang.Void... r13) {
            /*
                Method dump skipped, instructions count: 454
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.ImageLoader.HttpImageTask.doInBackground(java.lang.Void[]):java.lang.Boolean");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(final Boolean bool) {
            if (!bool.booleanValue() && this.canRetry) {
                ImageLoader.this.httpFileLoadError(this.cacheImage.url);
            } else {
                ImageLoader imageLoader = ImageLoader.this;
                CacheImage cacheImage = this.cacheImage;
                imageLoader.fileDidLoaded(cacheImage.url, cacheImage.finalFilePath, 0);
            }
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$HttpImageTask$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPostExecute$4(bool);
                }
            });
            ImageLoader.this.imageLoadQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$HttpImageTask$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPostExecute$5();
                }
            }, this.cacheImage.priority);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPostExecute$4(final Boolean bool) {
            ImageLoader.this.fileProgresses.remove(this.cacheImage.url);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$HttpImageTask$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPostExecute$3(bool);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPostExecute$3(Boolean bool) {
            if (bool.booleanValue()) {
                NotificationCenter notificationCenter = NotificationCenter.getInstance(this.cacheImage.currentAccount);
                int i = NotificationCenter.fileDidLoad;
                CacheImage cacheImage = this.cacheImage;
                notificationCenter.postNotificationName(i, cacheImage.url, cacheImage.finalFilePath);
                return;
            }
            NotificationCenter.getInstance(this.cacheImage.currentAccount).postNotificationName(NotificationCenter.fileDidFailToLoad, this.cacheImage.url, 2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPostExecute$5() {
            ImageLoader.this.runHttpTasks(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCancelled$6() {
            ImageLoader.this.runHttpTasks(true);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            ImageLoader.this.imageLoadQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$HttpImageTask$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCancelled$6();
                }
            }, this.cacheImage.priority);
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$HttpImageTask$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCancelled$8();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCancelled$8() {
            ImageLoader.this.fileProgresses.remove(this.cacheImage.url);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$HttpImageTask$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCancelled$7();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCancelled$7() {
            NotificationCenter.getInstance(this.cacheImage.currentAccount).postNotificationName(NotificationCenter.fileDidFailToLoad, this.cacheImage.url, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ThumbGenerateTask implements Runnable {
        private ThumbGenerateInfo info;
        private int mediaType;
        private File originalPath;

        public ThumbGenerateTask(int i, File file, ThumbGenerateInfo thumbGenerateInfo) {
            this.mediaType = i;
            this.originalPath = file;
            this.info = thumbGenerateInfo;
        }

        private void removeTask() {
            ThumbGenerateInfo thumbGenerateInfo = this.info;
            if (thumbGenerateInfo == null) {
                return;
            }
            final String attachFileName = FileLoader.getAttachFileName(thumbGenerateInfo.parentDocument);
            ImageLoader.this.imageLoadQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$ThumbGenerateTask$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeTask$0(attachFileName);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$removeTask$0(String str) {
            ImageLoader.this.thumbGenerateTasks.remove(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            int iMin;
            Bitmap bitmapCreateScaledBitmap;
            try {
                if (this.info != null) {
                    final String str = "q_" + IdStorage.getInstance().getDcId(this.info.parentDocument.dc_id) + "_" + this.info.parentDocument.id;
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
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$ThumbGenerateTask$$ExternalSyntheticLambda1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$run$1(str, arrayList, bitmapDrawable, arrayList2);
                                }
                            });
                            return;
                        }
                        removeTask();
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
        public /* synthetic */ void lambda$run$1(String str, ArrayList arrayList, BitmapDrawable bitmapDrawable, ArrayList arrayList2) {
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
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new FileInputStream(file));
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream, Utf8Charset.NAME));
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
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class CacheOutTask implements Runnable {
        private CacheImage cacheImage;
        private boolean isCancelled;
        private Thread runningThread;
        private final Object sync = new Object();

        public CacheOutTask(CacheImage cacheImage) {
            this.cacheImage = cacheImage;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(6:(2:1009|662)|(2:664|(5:666|(1:668)|987|676|aa3)(1:670))(1:674)|675|987|676|aa3) */
        /* JADX WARN: Code restructure failed: missing block: B:874:0x0d75, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:1012:0x02ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:1028:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:112:0x0203  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x022f  */
        /* JADX WARN: Removed duplicated region for block: B:140:0x0239  */
        /* JADX WARN: Removed duplicated region for block: B:153:0x0265  */
        /* JADX WARN: Removed duplicated region for block: B:155:0x0269  */
        /* JADX WARN: Removed duplicated region for block: B:156:0x0287  */
        /* JADX WARN: Removed duplicated region for block: B:187:0x0301  */
        /* JADX WARN: Removed duplicated region for block: B:248:0x03de  */
        /* JADX WARN: Removed duplicated region for block: B:253:0x0407  */
        /* JADX WARN: Removed duplicated region for block: B:314:0x051c  */
        /* JADX WARN: Removed duplicated region for block: B:342:0x0556  */
        /* JADX WARN: Removed duplicated region for block: B:361:0x05b3  */
        /* JADX WARN: Removed duplicated region for block: B:364:0x05c4  */
        /* JADX WARN: Removed duplicated region for block: B:368:0x05d6 A[Catch: all -> 0x0813, TRY_LEAVE, TryCatch #47 {all -> 0x0813, blocks: (B:366:0x05d0, B:368:0x05d6), top: B:1014:0x05d0 }] */
        /* JADX WARN: Removed duplicated region for block: B:489:0x0799  */
        /* JADX WARN: Removed duplicated region for block: B:658:0x0a57  */
        /* JADX WARN: Removed duplicated region for block: B:674:0x0a94  */
        /* JADX WARN: Removed duplicated region for block: B:692:0x0ac1 A[Catch: all -> 0x0d75, TRY_ENTER, TryCatch #31 {all -> 0x0d75, blocks: (B:676:0x0a98, B:677:0x0aa3, B:693:0x0ac5, B:692:0x0ac1), top: B:987:0x0a98 }] */
        /* JADX WARN: Removed duplicated region for block: B:743:0x0bcb A[Catch: all -> 0x0bdf, TryCatch #13 {all -> 0x0bdf, blocks: (B:737:0x0bb5, B:740:0x0bbc, B:741:0x0bc6, B:743:0x0bcb, B:745:0x0bd3), top: B:957:0x0bb5 }] */
        /* JADX WARN: Removed duplicated region for block: B:744:0x0bd1  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:788:0x0c64  */
        /* JADX WARN: Removed duplicated region for block: B:795:0x0c7c A[Catch: all -> 0x0d6b, TryCatch #20 {all -> 0x0d6b, blocks: (B:789:0x0c66, B:791:0x0c70, B:793:0x0c76, B:795:0x0c7c, B:797:0x0c82, B:803:0x0c98, B:809:0x0ca6, B:811:0x0cac, B:817:0x0ccd, B:812:0x0cb8, B:814:0x0cbe, B:820:0x0cd5, B:822:0x0ce3, B:824:0x0cee, B:828:0x0cf5, B:753:0x0beb, B:784:0x0c5b, B:759:0x0bfc, B:761:0x0c14, B:766:0x0c1b, B:767:0x0c24, B:769:0x0c2d, B:771:0x0c36, B:776:0x0c40, B:781:0x0c55, B:778:0x0c49), top: B:968:0x0beb, inners: #12 }] */
        /* JADX WARN: Removed duplicated region for block: B:815:0x0cca  */
        /* JADX WARN: Removed duplicated region for block: B:817:0x0ccd A[Catch: all -> 0x0d6b, TryCatch #20 {all -> 0x0d6b, blocks: (B:789:0x0c66, B:791:0x0c70, B:793:0x0c76, B:795:0x0c7c, B:797:0x0c82, B:803:0x0c98, B:809:0x0ca6, B:811:0x0cac, B:817:0x0ccd, B:812:0x0cb8, B:814:0x0cbe, B:820:0x0cd5, B:822:0x0ce3, B:824:0x0cee, B:828:0x0cf5, B:753:0x0beb, B:784:0x0c5b, B:759:0x0bfc, B:761:0x0c14, B:766:0x0c1b, B:767:0x0c24, B:769:0x0c2d, B:771:0x0c36, B:776:0x0c40, B:781:0x0c55, B:778:0x0c49), top: B:968:0x0beb, inners: #12 }] */
        /* JADX WARN: Removed duplicated region for block: B:841:0x0d1d A[Catch: all -> 0x0d69, TryCatch #19 {all -> 0x0d69, blocks: (B:833:0x0d0c, B:841:0x0d1d, B:847:0x0d35, B:849:0x0d3d, B:853:0x0d48, B:858:0x0d61, B:860:0x0d65), top: B:966:0x0d0c }] */
        /* JADX WARN: Removed duplicated region for block: B:856:0x0d5d A[PHI: r8
          0x0d5d: PHI (r8v39 android.graphics.Bitmap) = (r8v38 android.graphics.Bitmap), (r8v42 android.graphics.Bitmap) binds: [B:796:0x0c80, B:818:0x0cd1] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:884:0x0d8b A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:887:0x0d99  */
        /* JADX WARN: Removed duplicated region for block: B:888:0x0d9b  */
        /* JADX WARN: Removed duplicated region for block: B:891:0x0db0  */
        /* JADX WARN: Removed duplicated region for block: B:897:0x0dcf  */
        /* JADX WARN: Removed duplicated region for block: B:899:0x0dd7 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:906:0x0dea  */
        /* JADX WARN: Removed duplicated region for block: B:913:0x0e22  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01aa  */
        /* JADX WARN: Removed duplicated region for block: B:950:0x083d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:970:0x0aa4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r14v4 */
        /* JADX WARN: Type inference failed for: r14v5 */
        /* JADX WARN: Type inference failed for: r14v9 */
        /* JADX WARN: Type inference failed for: r41v0, types: [org.rbmain.messenger.ImageLoader$CacheOutTask] */
        /* JADX WARN: Type inference failed for: r4v108 */
        /* JADX WARN: Type inference failed for: r4v109 */
        /* JADX WARN: Type inference failed for: r4v110 */
        /* JADX WARN: Type inference failed for: r4v31 */
        /* JADX WARN: Type inference failed for: r4v32 */
        /* JADX WARN: Type inference failed for: r4v33 */
        /* JADX WARN: Type inference failed for: r4v34 */
        /* JADX WARN: Type inference failed for: r4v35 */
        /* JADX WARN: Type inference failed for: r4v38 */
        /* JADX WARN: Type inference failed for: r4v41 */
        /* JADX WARN: Type inference failed for: r4v42 */
        /* JADX WARN: Type inference failed for: r4v43 */
        /* JADX WARN: Type inference failed for: r4v44 */
        /* JADX WARN: Type inference failed for: r4v45 */
        /* JADX WARN: Type inference failed for: r4v46 */
        /* JADX WARN: Type inference failed for: r4v47 */
        /* JADX WARN: Type inference failed for: r4v48 */
        /* JADX WARN: Type inference failed for: r4v49, types: [android.graphics.Rect] */
        /* JADX WARN: Type inference failed for: r4v53 */
        /* JADX WARN: Type inference failed for: r4v55 */
        /* JADX WARN: Type inference failed for: r4v57 */
        /* JADX WARN: Type inference failed for: r4v62 */
        /* JADX WARN: Type inference failed for: r4v63 */
        /* JADX WARN: Type inference failed for: r4v90 */
        /* JADX WARN: Type inference failed for: r4v91, types: [java.io.RandomAccessFile] */
        /* JADX WARN: Type inference failed for: r4v92 */
        /* JADX WARN: Type inference failed for: r8v65 */
        /* JADX WARN: Type inference failed for: r8v66 */
        /* JADX WARN: Type inference failed for: r8v67 */
        /* JADX WARN: Type inference failed for: r8v68 */
        /* JADX WARN: Type inference failed for: r8v7 */
        /* JADX WARN: Type inference failed for: r8v8 */
        /* JADX WARN: Type inference failed for: r8v9 */
        /* JADX WARN: Type inference failed for: r8v93 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 3696
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.ImageLoader.CacheOutTask.run():void");
        }

        private Bitmap applyWallpaperSetting(Bitmap bitmap, TLRPC$WallPaper tLRPC$WallPaper) {
            if (!tLRPC$WallPaper.pattern || tLRPC$WallPaper.settings == null) {
                TLRPC$WallPaperSettings tLRPC$WallPaperSettings = tLRPC$WallPaper.settings;
                return (tLRPC$WallPaperSettings == null || !tLRPC$WallPaperSettings.blur) ? bitmap : Utilities.blurWallpaper(bitmap);
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            boolean z = true;
            TLRPC$WallPaperSettings tLRPC$WallPaperSettings2 = tLRPC$WallPaper.settings;
            int patternColor = 0;
            if (tLRPC$WallPaperSettings2.second_background_color == 0) {
                patternColor = AndroidUtilities.getPatternColor(tLRPC$WallPaperSettings2.background_color);
                canvas.drawColor(ColorUtils.setAlphaComponent(tLRPC$WallPaper.settings.background_color, 255));
            } else {
                z = false;
            }
            if (z) {
                Paint paint = new Paint(2);
                paint.setColorFilter(new PorterDuffColorFilter(patternColor, PorterDuff.Mode.SRC_IN));
                paint.setAlpha((int) ((tLRPC$WallPaper.settings.intensity / 100.0f) * 255.0f));
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            }
            return bitmapCreateBitmap;
        }

        private void loadLastFrame(RLottieDrawable rLottieDrawable, int i, int i2, boolean z, boolean z2) {
            Bitmap bitmapCreateBitmap;
            Canvas canvas;
            Drawable bitmapDrawable;
            if (z && z2) {
                float f = i * 1.2f;
                float f2 = i2 * 1.2f;
                bitmapCreateBitmap = Bitmap.createBitmap((int) f, (int) f2, Bitmap.Config.ARGB_8888);
                canvas = new Canvas(bitmapCreateBitmap);
                canvas.scale(2.0f, 2.0f, f / 2.0f, f2 / 2.0f);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                canvas = new Canvas(bitmapCreateBitmap);
            }
            rLottieDrawable.prepareForGenerateCache();
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(rLottieDrawable.getIntrinsicWidth(), rLottieDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            rLottieDrawable.setGeneratingFrame(z ? rLottieDrawable.getFramesCount() - 1 : 0);
            rLottieDrawable.getNextFrame(bitmapCreateBitmap2);
            rLottieDrawable.releaseForGenerateCache();
            canvas.save();
            if (!z || !z2) {
                canvas.scale(bitmapCreateBitmap2.getWidth() / i, bitmapCreateBitmap2.getHeight() / i2, i / 2.0f, i2 / 2.0f);
            }
            Paint paint = new Paint(1);
            paint.setFilterBitmap(true);
            if (z && z2) {
                canvas.drawBitmap(bitmapCreateBitmap2, (bitmapCreateBitmap.getWidth() - bitmapCreateBitmap2.getWidth()) / 2.0f, (bitmapCreateBitmap.getHeight() - bitmapCreateBitmap2.getHeight()) / 2.0f, paint);
                bitmapDrawable = new ImageReceiver.ReactionLastFrame(bitmapCreateBitmap);
            } else {
                canvas.drawBitmap(bitmapCreateBitmap2, 0.0f, 0.0f, paint);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            }
            rLottieDrawable.recycle(false);
            bitmapCreateBitmap2.recycle();
            onPostExecute(bitmapDrawable);
        }

        private void onPostExecute(final Drawable drawable) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$CacheOutTask$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPostExecute$1(drawable);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPostExecute$1(Drawable drawable) {
            final String str;
            boolean z = false;
            final Drawable drawable2 = null;
            str = null;
            str = null;
            str = null;
            String str2 = null;
            if (drawable instanceof RLottieDrawable) {
                RLottieDrawable rLottieDrawable = (RLottieDrawable) drawable;
                Drawable drawable3 = (Drawable) ImageLoader.this.lottieMemCache.get(this.cacheImage.key);
                if (drawable3 == null) {
                    ImageLoader.this.lottieMemCache.put(this.cacheImage.key, rLottieDrawable);
                    drawable = rLottieDrawable;
                } else {
                    rLottieDrawable.recycle(false);
                    drawable = drawable3;
                }
                if (drawable != null) {
                    ImageLoader.this.incrementUseCount(this.cacheImage.key);
                    str2 = this.cacheImage.key;
                }
            } else if (drawable instanceof AnimatedFileDrawable) {
                AnimatedFileDrawable animatedFileDrawable = (AnimatedFileDrawable) drawable;
                if (animatedFileDrawable.isWebmSticker) {
                    BitmapDrawable fromLottieCache = ImageLoader.this.getFromLottieCache(this.cacheImage.key);
                    if (fromLottieCache == null) {
                        ImageLoader.this.lottieMemCache.put(this.cacheImage.key, animatedFileDrawable);
                        drawable = animatedFileDrawable;
                    } else {
                        animatedFileDrawable.recycle();
                        drawable = fromLottieCache;
                    }
                    ImageLoader.this.incrementUseCount(this.cacheImage.key);
                    str2 = this.cacheImage.key;
                }
            } else {
                if (!(drawable instanceof BitmapDrawable)) {
                    str = null;
                    ImageLoader.this.imageLoadQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$CacheOutTask$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onPostExecute$0(drawable2, str);
                        }
                    }, this.cacheImage.priority);
                }
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                BitmapDrawable fromMemCache = ImageLoader.this.getFromMemCache(this.cacheImage.key);
                boolean z2 = true;
                if (fromMemCache == null) {
                    if (this.cacheImage.key.endsWith("_f")) {
                        ImageLoader.this.wallpaperMemCache.put(this.cacheImage.key, bitmapDrawable);
                    } else {
                        if (this.cacheImage.key.endsWith("_isc") || bitmapDrawable.getBitmap().getWidth() > AndroidUtilities.density * 80.0f || bitmapDrawable.getBitmap().getHeight() > AndroidUtilities.density * 80.0f) {
                            ImageLoader.this.memCache.put(this.cacheImage.key, bitmapDrawable);
                        } else {
                            ImageLoader.this.smallImagesMemCache.put(this.cacheImage.key, bitmapDrawable);
                        }
                        z = true;
                    }
                    z2 = z;
                    drawable = bitmapDrawable;
                } else {
                    AndroidUtilities.recycleBitmap(bitmapDrawable.getBitmap());
                    drawable = fromMemCache;
                }
                if (drawable != null && z2) {
                    ImageLoader.this.incrementUseCount(this.cacheImage.key);
                    str2 = this.cacheImage.key;
                }
            }
            String str3 = str2;
            drawable2 = drawable;
            str = str3;
            ImageLoader.this.imageLoadQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$CacheOutTask$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPostExecute$0(drawable2, str);
                }
            }, this.cacheImage.priority);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPostExecute$0(Drawable drawable, String str) {
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
    public boolean isAnimatedAvatar(String str) {
        return str != null && str.endsWith("avatar");
    }

    public BitmapDrawable getFromMemCache(String str) {
        BitmapDrawable bitmapDrawable = this.memCache.get(str);
        if (bitmapDrawable == null) {
            bitmapDrawable = this.smallImagesMemCache.get(str);
        }
        if (bitmapDrawable == null) {
            bitmapDrawable = this.wallpaperMemCache.get(str);
        }
        return bitmapDrawable == null ? getFromLottieCache(str) : bitmapDrawable;
    }

    public static Bitmap getStrippedPhotoBitmap(byte[] bArr, String str) {
        int length = (bArr.length - 3) + Bitmaps.header.length + Bitmaps.footer.length;
        byte[] bArr2 = bytesLocal.get();
        if (bArr2 == null || bArr2.length < length) {
            bArr2 = null;
        }
        if (bArr2 == null) {
            bArr2 = new byte[length];
            bytesLocal.set(bArr2);
        }
        byte[] bArr3 = Bitmaps.header;
        System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
        System.arraycopy(bArr, 3, bArr2, Bitmaps.header.length, bArr.length - 3);
        System.arraycopy(Bitmaps.footer, 0, bArr2, (Bitmaps.header.length + bArr.length) - 3, Bitmaps.footer.length);
        bArr2[164] = bArr[1];
        bArr2[166] = bArr[2];
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr2, 0, length);
        if (bitmapDecodeByteArray != null && !TextUtils.isEmpty(str) && str.contains("b")) {
            Utilities.blurBitmap(bitmapDecodeByteArray, 3, 1, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), bitmapDecodeByteArray.getRowBytes());
        }
        return bitmapDecodeByteArray;
    }

    public static Bitmap getStrippedPhotoBitmap2(byte[] bArr, String str) {
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        if (bitmapDecodeByteArray != null && !TextUtils.isEmpty(str) && str.contains("b")) {
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
        public int priority;
        public Runnable runningTask;
        protected SecureDocument secureDocument;
        protected long size;
        protected File tempFilePath;
        protected int type;
        protected ArrayList<Integer> types;
        protected String url;

        private CacheImage() {
            this.priority = 1;
            this.imageReceiverArray = new ArrayList<>();
            this.imageReceiverGuidsArray = new ArrayList<>();
            this.keys = new ArrayList<>();
            this.filters = new ArrayList<>();
            this.types = new ArrayList<>();
        }

        public void addImageReceiver(ImageReceiver imageReceiver, String str, String str2, int i, int i2) {
            int iIndexOf = this.imageReceiverArray.indexOf(imageReceiver);
            if (iIndexOf >= 0 && CallProxy$$ExternalSyntheticBackport0.m(this.imageReceiverArray.get(iIndexOf).getImageKey(), str)) {
                this.imageReceiverGuidsArray.set(iIndexOf, Integer.valueOf(i2));
                return;
            }
            this.imageReceiverArray.add(imageReceiver);
            this.imageReceiverGuidsArray.add(Integer.valueOf(i2));
            this.keys.add(str);
            this.filters.add(str2);
            this.types.add(Integer.valueOf(i));
            ImageLoader.this.imageLoadingByTag.put(imageReceiver.getTag(i), this);
        }

        public void replaceImageReceiver(ImageReceiver imageReceiver, String str, String str2, int i, int i2) {
            int iIndexOf = this.imageReceiverArray.indexOf(imageReceiver);
            if (iIndexOf == -1) {
                return;
            }
            if (this.types.get(iIndexOf).intValue() != i) {
                ArrayList<ImageReceiver> arrayList = this.imageReceiverArray;
                iIndexOf = arrayList.subList(iIndexOf + 1, arrayList.size()).indexOf(imageReceiver);
                if (iIndexOf == -1) {
                    return;
                }
            }
            this.imageReceiverGuidsArray.set(iIndexOf, Integer.valueOf(i2));
            this.keys.set(iIndexOf, str);
            this.filters.set(iIndexOf, str2);
        }

        public void setImageReceiverGuid(ImageReceiver imageReceiver, int i) {
            int iIndexOf = this.imageReceiverArray.indexOf(imageReceiver);
            if (iIndexOf == -1) {
                return;
            }
            this.imageReceiverGuidsArray.set(iIndexOf, Integer.valueOf(i));
        }

        public void removeImageReceiver(ImageReceiver imageReceiver) {
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
                    } else if (imageLocation.photoViewerObject != null) {
                        FileLoaderRubinoPost.getInstance(this.currentAccount).cancelLoadFile(this.imageLocation.photoViewerObject);
                    }
                }
                if (this.cacheTask != null) {
                    if (iIntValue == 1) {
                        ImageLoader.this.cacheThumbOutQueue.cancelRunnable(this.cacheTask);
                    } else {
                        ImageLoader.this.cacheOutQueue.cancelRunnable(this.cacheTask);
                        ImageLoader.this.cacheOutQueue.cancelRunnable(this.runningTask);
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

        public void setImageAndClear(final Drawable drawable, final String str) {
            if (drawable != null) {
                final ArrayList arrayList = new ArrayList(this.imageReceiverArray);
                final ArrayList arrayList2 = new ArrayList(this.imageReceiverGuidsArray);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$CacheImage$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setImageAndClear$0(drawable, arrayList, arrayList2, str);
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
        /* JADX WARN: Removed duplicated region for block: B:34:? A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$setImageAndClear$0(android.graphics.drawable.Drawable r10, java.util.ArrayList r11, java.util.ArrayList r12, java.lang.String r13) {
            /*
                r9 = this;
                boolean r0 = r10 instanceof org.rbmain.ui.Components.AnimatedFileDrawable
                r1 = 0
                if (r0 == 0) goto L4a
                r0 = r10
                org.rbmain.ui.Components.AnimatedFileDrawable r0 = (org.rbmain.ui.Components.AnimatedFileDrawable) r0
                boolean r2 = r0.isWebmSticker
                if (r2 != 0) goto L4a
                r10 = 0
            Ld:
                int r2 = r11.size()
                if (r1 >= r2) goto L44
                java.lang.Object r2 = r11.get(r1)
                r3 = r2
                org.rbmain.messenger.ImageReceiver r3 = (org.rbmain.messenger.ImageReceiver) r3
                if (r1 != 0) goto L1e
                r2 = r0
                goto L22
            L1e:
                org.rbmain.ui.Components.AnimatedFileDrawable r2 = r0.makeCopy()
            L22:
                java.lang.String r5 = r9.key
                int r6 = r9.type
                r7 = 0
                java.lang.Object r4 = r12.get(r1)
                java.lang.Integer r4 = (java.lang.Integer) r4
                int r8 = r4.intValue()
                r4 = r2
                boolean r3 = r3.setImageBitmapByKey(r4, r5, r6, r7, r8)
                if (r3 == 0) goto L3c
                if (r2 != r0) goto L41
                r10 = 1
                goto L41
            L3c:
                if (r2 == r0) goto L41
                r2.recycle()
            L41:
                int r1 = r1 + 1
                goto Ld
            L44:
                if (r10 != 0) goto L77
                r0.recycle()
                goto L77
            L4a:
                int r0 = r11.size()
                if (r1 >= r0) goto L77
                java.lang.Object r0 = r11.get(r1)
                r2 = r0
                org.rbmain.messenger.ImageReceiver r2 = (org.rbmain.messenger.ImageReceiver) r2
                java.lang.String r4 = r9.key
                java.util.ArrayList<java.lang.Integer> r0 = r9.types
                java.lang.Object r0 = r0.get(r1)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r5 = r0.intValue()
                r6 = 0
                java.lang.Object r0 = r12.get(r1)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r7 = r0.intValue()
                r3 = r10
                r2.setImageBitmapByKey(r3, r4, r5, r6, r7)
                int r1 = r1 + 1
                goto L4a
            L77:
                if (r13 == 0) goto L7e
                org.rbmain.messenger.ImageLoader r10 = org.rbmain.messenger.ImageLoader.this
                r10.decrementUseCount(r13)
            L7e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.ImageLoader.CacheImage.lambda$setImageAndClear$0(android.graphics.drawable.Drawable, java.util.ArrayList, java.util.ArrayList, java.lang.String):void");
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
        int iMin = Math.min(z ? 30 : 15, memoryClass / 7) * 1024 * 1024;
        float f = iMin;
        this.memCache = new LruCache<BitmapDrawable>((int) (0.8f * f)) { // from class: org.rbmain.messenger.ImageLoader.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.rbmain.messenger.LruCache
            public int sizeOf(String str, BitmapDrawable bitmapDrawable) {
                return bitmapDrawable.getBitmap().getByteCount();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.rbmain.messenger.LruCache
            public void entryRemoved(boolean z2, String str, BitmapDrawable bitmapDrawable, BitmapDrawable bitmapDrawable2) {
                if (ImageLoader.this.ignoreRemoval == null || !ImageLoader.this.ignoreRemoval.equals(str)) {
                    Integer num = (Integer) ImageLoader.this.bitmapUseCounts.get(str);
                    if (num == null || num.intValue() == 0) {
                        Bitmap bitmap = bitmapDrawable.getBitmap();
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(bitmap);
                        AndroidUtilities.recycleBitmaps(arrayList);
                    }
                }
            }
        };
        this.smallImagesMemCache = new LruCache<BitmapDrawable>((int) (f * 0.2f)) { // from class: org.rbmain.messenger.ImageLoader.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.rbmain.messenger.LruCache
            public int sizeOf(String str, BitmapDrawable bitmapDrawable) {
                return bitmapDrawable.getBitmap().getByteCount();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.rbmain.messenger.LruCache
            public void entryRemoved(boolean z2, String str, BitmapDrawable bitmapDrawable, BitmapDrawable bitmapDrawable2) {
                if (ImageLoader.this.ignoreRemoval == null || !ImageLoader.this.ignoreRemoval.equals(str)) {
                    Integer num = (Integer) ImageLoader.this.bitmapUseCounts.get(str);
                    if (num == null || num.intValue() == 0) {
                        Bitmap bitmap = bitmapDrawable.getBitmap();
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(bitmap);
                        AndroidUtilities.recycleBitmaps(arrayList);
                    }
                }
            }
        };
        this.wallpaperMemCache = new LruCache<BitmapDrawable>(iMin / 4) { // from class: org.rbmain.messenger.ImageLoader.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.rbmain.messenger.LruCache
            public int sizeOf(String str, BitmapDrawable bitmapDrawable) {
                return bitmapDrawable.getBitmap().getByteCount();
            }
        };
        this.lottieMemCache = new LruCache<BitmapDrawable>(10485760) { // from class: org.rbmain.messenger.ImageLoader.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.rbmain.messenger.LruCache
            public int sizeOf(String str, BitmapDrawable bitmapDrawable) {
                return bitmapDrawable.getIntrinsicWidth() * bitmapDrawable.getIntrinsicHeight() * 4 * 2;
            }

            @Override // org.rbmain.messenger.LruCache
            public BitmapDrawable put(String str, BitmapDrawable bitmapDrawable) {
                if (bitmapDrawable instanceof AnimatedFileDrawable) {
                    ImageLoader.this.cachedAnimatedFileDrawables.add((AnimatedFileDrawable) bitmapDrawable);
                }
                return (BitmapDrawable) super.put(str, (String) bitmapDrawable);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.rbmain.messenger.LruCache
            public void entryRemoved(boolean z2, String str, BitmapDrawable bitmapDrawable, BitmapDrawable bitmapDrawable2) {
                Integer num = (Integer) ImageLoader.this.bitmapUseCounts.get(str);
                boolean z3 = bitmapDrawable instanceof AnimatedFileDrawable;
                if (z3) {
                    ImageLoader.this.cachedAnimatedFileDrawables.remove((AnimatedFileDrawable) bitmapDrawable);
                }
                if (num == null || num.intValue() == 0) {
                    if (z3) {
                        ((AnimatedFileDrawable) bitmapDrawable).recycle();
                    }
                    if (bitmapDrawable instanceof RLottieDrawable) {
                        ((RLottieDrawable) bitmapDrawable).recycle(false);
                    }
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
            FileLoaderRubinoPost.getInstance(i).setDelegate(new AnonymousClass5());
            FileLoader.getInstance(i).setDelegate(new AnonymousClass6(i));
        }
        FileLoader.setMediaDirs(sparseArray);
        AnonymousClass7 anonymousClass7 = new AnonymousClass7();
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
            ApplicationLoader.applicationContext.registerReceiver(anonymousClass7, intentFilter);
        } catch (Throwable unused) {
        }
        checkMediaPaths();
    }

    /* renamed from: org.rbmain.messenger.ImageLoader$5, reason: invalid class name */
    class AnonymousClass5 implements FileLoaderRubinoPost.FileLoaderDelegate {
        public void fileDidFailedUpload(PhotoViewerObject photoViewerObject) {
        }

        public void fileDidUploaded(String str, long j) {
        }

        @Override // ir.appp.rghapp.rubinoPostSlider.FileLoaderRubinoPost.FileLoaderDelegate
        public void fileLoadProgressChanged(PhotoViewerObject photoViewerObject, float f) {
        }

        public void fileUploadProgressChanged(String str, float f) {
        }

        AnonymousClass5() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$fileDidLoaded$0(PhotoViewerObject photoViewerObject) {
            ImageLoader.this.fileDidLoaded(photoViewerObject.getFileDownloadedName(), photoViewerObject.getDownloadFile(), 0);
        }

        @Override // ir.appp.rghapp.rubinoPostSlider.FileLoaderRubinoPost.FileLoaderDelegate
        public void fileDidLoaded(final PhotoViewerObject photoViewerObject) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$5$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$fileDidLoaded$0(photoViewerObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$fileDidFailedLoad$1(PhotoViewerObject photoViewerObject, boolean z) {
            ImageLoader.this.fileDidFailedLoad(photoViewerObject.getFileDownloadedName(), z ? 1 : 0);
        }

        @Override // ir.appp.rghapp.rubinoPostSlider.FileLoaderRubinoPost.FileLoaderDelegate
        public void fileDidFailedLoad(final PhotoViewerObject photoViewerObject, final boolean z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$5$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$fileDidFailedLoad$1(photoViewerObject, z);
                }
            });
        }
    }

    /* renamed from: org.rbmain.messenger.ImageLoader$6, reason: invalid class name */
    class AnonymousClass6 implements FileLoader.FileLoaderDelegate {
        final /* synthetic */ int val$currentAccount;

        AnonymousClass6(int i) {
            this.val$currentAccount = i;
        }

        @Override // org.rbmain.messenger.FileLoader.FileLoaderDelegate
        public void fileUploadProgressChanged(FileUploadOperation fileUploadOperation, final String str, final long j, final long j2, final boolean z) {
            ImageLoader.this.fileProgresses.put(str, new long[]{j, j2});
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = fileUploadOperation.lastProgressUpdateTime;
            if (j3 == 0 || j3 < jElapsedRealtime - 100 || j == j2) {
                fileUploadOperation.lastProgressUpdateTime = jElapsedRealtime;
                final int i = this.val$currentAccount;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$6$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageLoader.AnonymousClass6.lambda$fileUploadProgressChanged$0(i, str, j, j2, z);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$fileUploadProgressChanged$0(int i, String str, long j, long j2, boolean z) {
            NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.FileUploadProgressChanged, str, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z));
        }

        @Override // org.rbmain.messenger.FileLoader.FileLoaderDelegate
        public void fileDidUploaded(final String str, final TLRPC$InputFile tLRPC$InputFile, final TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile, final byte[] bArr, final byte[] bArr2, final long j) {
            DispatchQueue dispatchQueue = Utilities.stageQueue;
            final int i = this.val$currentAccount;
            dispatchQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$6$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$fileDidUploaded$2(i, str, tLRPC$InputFile, tLRPC$InputEncryptedFile, bArr, bArr2, j);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$fileDidUploaded$1(int i, String str, TLRPC$InputFile tLRPC$InputFile, TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile, byte[] bArr, byte[] bArr2, long j) {
            NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.FileDidUpload, str, tLRPC$InputFile, tLRPC$InputEncryptedFile, bArr, bArr2, Long.valueOf(j));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$fileDidUploaded$2(final int i, final String str, final TLRPC$InputFile tLRPC$InputFile, final TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile, final byte[] bArr, final byte[] bArr2, final long j) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$6$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ImageLoader.AnonymousClass6.lambda$fileDidUploaded$1(i, str, tLRPC$InputFile, tLRPC$InputEncryptedFile, bArr, bArr2, j);
                }
            });
            ImageLoader.this.fileProgresses.remove(str);
        }

        @Override // org.rbmain.messenger.FileLoader.FileLoaderDelegate
        public void fileDidFailedUpload(final String str, final boolean z) {
            DispatchQueue dispatchQueue = Utilities.stageQueue;
            final int i = this.val$currentAccount;
            dispatchQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$6$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$fileDidFailedUpload$4(i, str, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$fileDidFailedUpload$3(int i, String str, boolean z) {
            NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.FileDidFailUpload, str, Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$fileDidFailedUpload$4(final int i, final String str, final boolean z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$6$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    ImageLoader.AnonymousClass6.lambda$fileDidFailedUpload$3(i, str, z);
                }
            });
            ImageLoader.this.fileProgresses.remove(str);
        }

        @Override // org.rbmain.messenger.FileLoader.FileLoaderDelegate
        public void fileDidLoaded(final String str, final File file, final int i) {
            ImageLoader.this.fileProgresses.remove(str);
            final int i2 = this.val$currentAccount;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$6$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$fileDidLoaded$5(file, str, i2, i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$fileDidLoaded$5(File file, String str, int i, int i2) {
            if (SharedConfig.saveToGallery && ImageLoader.this.rubikaPath != null && file != null && ((str.endsWith(".mp4") || str.endsWith(".jpg")) && file.toString().startsWith(ImageLoader.this.rubikaPath.toString()))) {
                AndroidUtilities.addMediaToGallery(file.toString());
            }
            NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.fileDidLoad, str, file);
            ImageLoader.this.fileDidLoaded(str, file, i2);
        }

        @Override // org.rbmain.messenger.FileLoader.FileLoaderDelegate
        public void fileDidFailedLoad(final String str, final int i) {
            ImageLoader.this.fileProgresses.remove(str);
            final int i2 = this.val$currentAccount;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$6$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$fileDidFailedLoad$6(str, i, i2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$fileDidFailedLoad$6(String str, int i, int i2) {
            ImageLoader.this.fileDidFailedLoad(str, i);
            NotificationCenter.getInstance(i2).postNotificationName(NotificationCenter.fileDidFailToLoad, str, Integer.valueOf(i));
        }

        @Override // org.rbmain.messenger.FileLoader.FileLoaderDelegate
        public void fileLoadProgressChanged(FileLoadOperation fileLoadOperation, final String str, final long j, final long j2) {
            ImageLoader.this.fileProgresses.put(str, new long[]{j, j2});
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = fileLoadOperation.lastProgressUpdateTime;
            if (j3 == 0 || j3 < jElapsedRealtime - 500 || j == 0) {
                fileLoadOperation.lastProgressUpdateTime = jElapsedRealtime;
                final int i = this.val$currentAccount;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$6$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageLoader.AnonymousClass6.lambda$fileLoadProgressChanged$7(i, str, j, j2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$fileLoadProgressChanged$7(int i, String str, long j, long j2) {
            NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.FileLoadProgressChanged, str, Long.valueOf(j), Long.valueOf(j2));
        }
    }

    /* renamed from: org.rbmain.messenger.ImageLoader$7, reason: invalid class name */
    class AnonymousClass7 extends BroadcastReceiver {
        AnonymousClass7() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("file system changed");
            }
            Runnable runnable = new Runnable() { // from class: org.rbmain.messenger.ImageLoader$7$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onReceive$0();
                }
            };
            if ("android.intent.action.MEDIA_UNMOUNTED".equals(intent.getAction())) {
                AndroidUtilities.runOnUIThread(runnable, 1000L);
            } else {
                runnable.run();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceive$0() {
            ImageLoader.this.checkMediaPaths();
        }
    }

    public void checkMediaPaths() {
        checkMediaPaths(null);
    }

    public void checkMediaPaths(final Runnable runnable) {
        this.cacheOutQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkMediaPaths$1(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkMediaPaths$1(final Runnable runnable) {
        final SparseArray<File> sparseArrayCreateMediaPaths = createMediaPaths();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ImageLoader.lambda$checkMediaPaths$0(sparseArrayCreateMediaPaths, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkMediaPaths$0(SparseArray sparseArray, Runnable runnable) {
        FileLoader.setMediaDirs(sparseArray);
        if (runnable != null) {
            runnable.run();
        }
    }

    public void addTestWebFile(String str, WebFile webFile) {
        if (str == null || webFile == null) {
            return;
        }
        this.testWebFile.put(str, webFile);
    }

    public void removeTestWebFile(String str) {
        if (str == null) {
            return;
        }
        this.testWebFile.remove(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00cd A[Catch: Exception -> 0x0297, TryCatch #3 {Exception -> 0x0297, blocks: (B:11:0x003d, B:13:0x0049, B:15:0x0054, B:17:0x005c, B:19:0x0067, B:22:0x007b, B:23:0x007e, B:25:0x0089, B:44:0x00f7, B:46:0x00fe, B:48:0x0106, B:50:0x010c, B:52:0x0113, B:54:0x011b, B:56:0x0123, B:58:0x012f, B:59:0x013e, B:60:0x0141, B:101:0x0285, B:91:0x0231, B:81:0x01de, B:105:0x0293, B:71:0x0191, B:26:0x009b, B:28:0x00a3, B:33:0x00b4, B:35:0x00ba, B:40:0x00c7, B:42:0x00cd, B:38:0x00c1, B:43:0x00ec, B:102:0x0289, B:104:0x028d, B:82:0x01e1, B:84:0x0206, B:86:0x020c, B:88:0x021b, B:62:0x0149, B:64:0x016e, B:66:0x0174, B:68:0x017b, B:72:0x0194, B:74:0x01b9, B:76:0x01c0, B:78:0x01c7, B:92:0x0234, B:94:0x0259, B:96:0x0260, B:98:0x026f), top: B:116:0x003d, inners: #0, #1, #2, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.util.SparseArray<java.io.File> createMediaPaths() {
        /*
            Method dump skipped, instructions count: 668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.ImageLoader.createMediaPaths():android.util.SparseArray");
    }

    private boolean canMoveFiles(File file, File file2, int i) throws Throwable {
        File file3;
        File file4;
        byte[] bArr;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                if (i == 0 || i == 3 || i == 1 || i == 2) {
                    file4 = new File(file, "000000000_999999_temp.f");
                    file3 = new File(file2, "000000000_999999.f");
                } else {
                    file3 = null;
                    file4 = null;
                }
                bArr = new byte[1024];
                file4.createNewFile();
                randomAccessFile = new RandomAccessFile(file4, "rws");
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            randomAccessFile.write(bArr);
            randomAccessFile.close();
            boolean zRenameTo = file4.renameTo(file3);
            file4.delete();
            file3.delete();
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

    public Float getFileProgress(String str) {
        long[] jArr;
        if (str == null || (jArr = this.fileProgresses.get(str)) == null) {
            return null;
        }
        if (jArr[1] == 0) {
            return Float.valueOf(0.0f);
        }
        return Float.valueOf(Math.min(1.0f, jArr[0] / jArr[1]));
    }

    public long[] getFileProgressSizes(String str) {
        if (str == null) {
            return null;
        }
        return this.fileProgresses.get(str);
    }

    public String getReplacedKey(String str) {
        if (str == null) {
            return null;
        }
        return this.replacedBitmaps.get(str);
    }

    private void performReplace(String str, String str2) {
        LruCache<BitmapDrawable> lruCache = this.memCache;
        BitmapDrawable bitmapDrawable = lruCache.get(str);
        if (bitmapDrawable == null) {
            lruCache = this.smallImagesMemCache;
            bitmapDrawable = lruCache.get(str);
        }
        this.replacedBitmaps.put(str, str2);
        if (bitmapDrawable != null) {
            BitmapDrawable bitmapDrawable2 = lruCache.get(str2);
            boolean z = false;
            if (bitmapDrawable2 != null && bitmapDrawable2.getBitmap() != null && bitmapDrawable.getBitmap() != null) {
                Bitmap bitmap = bitmapDrawable2.getBitmap();
                Bitmap bitmap2 = bitmapDrawable.getBitmap();
                if (bitmap.getWidth() > bitmap2.getWidth() || bitmap.getHeight() > bitmap2.getHeight()) {
                    z = true;
                }
            }
            if (!z) {
                this.ignoreRemoval = str;
                lruCache.remove(str);
                lruCache.put(str2, bitmapDrawable);
                this.ignoreRemoval = null;
            } else {
                lruCache.remove(str);
            }
        }
        Integer num = this.bitmapUseCounts.get(str);
        if (num != null) {
            this.bitmapUseCounts.put(str2, num);
            this.bitmapUseCounts.remove(str);
        }
    }

    public void incrementUseCount(String str) {
        Integer num = this.bitmapUseCounts.get(str);
        if (num == null) {
            this.bitmapUseCounts.put(str, 1);
        } else {
            this.bitmapUseCounts.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public boolean decrementUseCount(String str) {
        Integer num = this.bitmapUseCounts.get(str);
        if (num == null) {
            return true;
        }
        if (num.intValue() == 1) {
            this.bitmapUseCounts.remove(str);
            return true;
        }
        this.bitmapUseCounts.put(str, Integer.valueOf(num.intValue() - 1));
        return false;
    }

    public void removeImage(String str) {
        this.bitmapUseCounts.remove(str);
        this.memCache.remove(str);
        this.smallImagesMemCache.remove(str);
    }

    public boolean isInMemCache(String str, boolean z) {
        return z ? getFromLottieCache(str) != null : getFromMemCache(str) != null;
    }

    public void clearMemory() {
        this.smallImagesMemCache.evictAll();
        this.memCache.evictAll();
        this.lottieMemCache.evictAll();
    }

    private void removeFromWaitingForThumb(int i, ImageReceiver imageReceiver) {
        String str = this.waitingForQualityThumbByTag.get(i);
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
            this.waitingForQualityThumbByTag.remove(i);
        }
    }

    public void cancelLoadingForImageReceiver(final ImageReceiver imageReceiver, final boolean z) {
        if (imageReceiver == null) {
            return;
        }
        ArrayList<Runnable> loadingOperations = imageReceiver.getLoadingOperations();
        if (!loadingOperations.isEmpty()) {
            for (int i = 0; i < loadingOperations.size(); i++) {
                this.imageLoadQueue.cancelRunnable(loadingOperations.get(i));
            }
            loadingOperations.clear();
        }
        imageReceiver.addLoadingImageRunnable(null);
        this.imageLoadQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cancelLoadingForImageReceiver$2(z, imageReceiver);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancelLoadingForImageReceiver$2(boolean z, ImageReceiver imageReceiver) {
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

    public BitmapDrawable getImageFromMemory(TLObject tLObject, String str, String str2) {
        String strMD5 = null;
        if (tLObject == null && str == null) {
            return null;
        }
        if (str != null) {
            strMD5 = Utilities.MD5(str);
        } else if (tLObject instanceof TLRPC$FileLocation) {
            TLRPC$FileLocation tLRPC$FileLocation = (TLRPC$FileLocation) tLObject;
            strMD5 = tLRPC$FileLocation.volume_id + "_" + tLRPC$FileLocation.local_id;
        } else if (tLObject instanceof TLRPC$Document) {
            TLRPC$Document tLRPC$Document = (TLRPC$Document) tLObject;
            strMD5 = IdStorage.getInstance().getDcId(tLRPC$Document.dc_id) + "_" + tLRPC$Document.id;
        } else if (tLObject instanceof SecureDocument) {
            SecureDocument secureDocument = (SecureDocument) tLObject;
            strMD5 = IdStorage.getInstance().getDcId(secureDocument.secureFile.dc_id) + "_" + secureDocument.secureFile.id;
        } else if (tLObject instanceof WebFile) {
            strMD5 = Utilities.MD5(((WebFile) tLObject).url);
        }
        if (str2 != null) {
            strMD5 = strMD5 + "@" + str2;
        }
        return getFromMemCache(strMD5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: replaceImageInCacheInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$replaceImageInCache$3(String str, String str2, ImageLocation imageLocation) {
        ArrayList<String> filterKeys;
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                filterKeys = this.memCache.getFilterKeys(str);
            } else {
                filterKeys = this.smallImagesMemCache.getFilterKeys(str);
            }
            if (filterKeys != null) {
                for (int i2 = 0; i2 < filterKeys.size(); i2++) {
                    String str3 = filterKeys.get(i2);
                    String str4 = str + "@" + str3;
                    String str5 = str2 + "@" + str3;
                    performReplace(str4, str5);
                    NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didReplacedPhotoInMemCache, str4, str5, imageLocation);
                }
            } else {
                performReplace(str, str2);
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didReplacedPhotoInMemCache, str, str2, imageLocation);
            }
        }
    }

    public void replaceImageInCache(final String str, final String str2, final ImageLocation imageLocation, boolean z) {
        if (z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$replaceImageInCache$3(str, str2, imageLocation);
                }
            });
        } else {
            lambda$replaceImageInCache$3(str, str2, imageLocation);
        }
    }

    public void putImageToCache(BitmapDrawable bitmapDrawable, String str) {
        putImageToCache(bitmapDrawable, str, false);
    }

    public void putImageToCache(BitmapDrawable bitmapDrawable, String str, boolean z) {
        if (z) {
            this.smallImagesMemCache.put(str, bitmapDrawable);
        } else {
            this.memCache.put(str, bitmapDrawable);
        }
    }

    private void generateThumb(int i, File file, ThumbGenerateInfo thumbGenerateInfo) {
        if ((i != 0 && i != 2 && i != 3) || file == null || thumbGenerateInfo == null) {
            return;
        }
        if (this.thumbGenerateTasks.get(FileLoader.getAttachFileName(thumbGenerateInfo.parentDocument)) == null) {
            this.thumbGeneratingQueue.postRunnable(new ThumbGenerateTask(i, file, thumbGenerateInfo));
        }
    }

    public void cancelForceLoadingForImageReceiver(ImageReceiver imageReceiver) {
        final String imageKey;
        if (imageReceiver == null || (imageKey = imageReceiver.getImageKey()) == null) {
            return;
        }
        this.imageLoadQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cancelForceLoadingForImageReceiver$4(imageKey);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancelForceLoadingForImageReceiver$4(String str) {
        this.forceLoadingImages.remove(str);
    }

    private void createLoadOperationForImageReceiver(final ImageReceiver imageReceiver, final String str, final String str2, final String str3, final ImageLocation imageLocation, final String str4, final long j, final int i, final int i2, final int i3, final int i4) {
        if (imageReceiver == null || str2 == null || str == null || imageLocation == null) {
            return;
        }
        int tag = imageReceiver.getTag(i2);
        if (tag == 0) {
            tag = this.lastImageNum;
            imageReceiver.setTag(tag, i2);
            int i5 = this.lastImageNum + 1;
            this.lastImageNum = i5;
            if (i5 == Integer.MAX_VALUE) {
                this.lastImageNum = 0;
            }
        }
        final int i6 = tag;
        final boolean zIsNeedsQualityThumb = imageReceiver.isNeedsQualityThumb();
        final Object parentObject = imageReceiver.getParentObject();
        final TLRPC$Document qualityThumbDocument = imageReceiver.getQualityThumbDocument();
        final boolean zIsShouldGenerateQualityThumb = imageReceiver.isShouldGenerateQualityThumb();
        final int currentAccount = imageReceiver.getCurrentAccount();
        final boolean z = i2 == 0 && imageReceiver.isCurrentKeyQuality();
        Runnable runnable = new Runnable() { // from class: org.rbmain.messenger.ImageLoader$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createLoadOperationForImageReceiver$6(i3, str2, str, i6, imageReceiver, i4, str4, i2, imageLocation, z, parentObject, currentAccount, qualityThumbDocument, zIsNeedsQualityThumb, zIsShouldGenerateQualityThumb, str3, i, j);
            }
        };
        this.imageLoadQueue.postRunnable(runnable, imageReceiver.getFileLoadingPriority() == 0 ? 0L : 1L);
        imageReceiver.addLoadingImageRunnable(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0437 A[PHI: r12
      0x0437: PHI (r12v32 java.lang.String) = (r12v23 java.lang.String), (r12v33 java.lang.String) binds: [B:202:0x0404, B:198:0x03fb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0544  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$createLoadOperationForImageReceiver$6(int r26, java.lang.String r27, java.lang.String r28, int r29, org.rbmain.messenger.ImageReceiver r30, int r31, java.lang.String r32, int r33, org.rbmain.messenger.ImageLocation r34, boolean r35, java.lang.Object r36, int r37, org.rbmain.tgnet.TLRPC$Document r38, boolean r39, boolean r40, java.lang.String r41, int r42, long r43) {
        /*
            Method dump skipped, instructions count: 1739
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.ImageLoader.lambda$createLoadOperationForImageReceiver$6(int, java.lang.String, java.lang.String, int, org.rbmain.messenger.ImageReceiver, int, java.lang.String, int, org.rbmain.messenger.ImageLocation, boolean, java.lang.Object, int, org.rbmain.tgnet.TLRPC$Document, boolean, boolean, java.lang.String, int, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createLoadOperationForImageReceiver$5(PhotoViewerObject photoViewerObject) {
        fileDidLoaded(photoViewerObject.getFileDownloadedName(), photoViewerObject.getDownloadFile(), 0);
    }

    public void preloadArtwork(final String str) {
        this.imageLoadQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$preloadArtwork$7(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$preloadArtwork$7(String str) {
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

    /* JADX WARN: Removed duplicated region for block: B:162:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0161  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void loadImageForImageReceiver(org.rbmain.messenger.ImageReceiver r38) {
        /*
            Method dump skipped, instructions count: 1428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.ImageLoader.loadImageForImageReceiver(org.rbmain.messenger.ImageReceiver):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BitmapDrawable getFromLottieCache(String str) {
        BitmapDrawable bitmapDrawable = this.lottieMemCache.get(str);
        if (!(bitmapDrawable instanceof AnimatedFileDrawable) || !((AnimatedFileDrawable) bitmapDrawable).isRecycled()) {
            return bitmapDrawable;
        }
        this.lottieMemCache.remove(str);
        return null;
    }

    private boolean useLottieMemCache(ImageLocation imageLocation, String str) {
        if (str.endsWith("_firstframe") || str.endsWith("_lastframe")) {
            return false;
        }
        return (imageLocation != null && (MessageObject.isAnimatedStickerDocument(imageLocation.document, true) || imageLocation.imageType == 1 || MessageObject.isVideoSticker(imageLocation.document))) || isAnimatedAvatar(str);
    }

    public boolean hasLottieMemCache(String str) {
        LruCache<BitmapDrawable> lruCache = this.lottieMemCache;
        return lruCache != null && lruCache.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void httpFileLoadError(final String str) {
        this.imageLoadQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$httpFileLoadError$8(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$httpFileLoadError$8(String str) {
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
    public void artworkLoadError(final String str) {
        this.imageLoadQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$artworkLoadError$9(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$artworkLoadError$9(String str) {
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
    public void fileDidLoaded(final String str, final File file, final int i) {
        this.imageLoadQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$fileDidLoaded$10(str, i, file);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fileDidLoaded$10(String str, int i, File file) {
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
                cacheImage2.priority = cacheImage.priority;
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
            if (cacheOutTask.cacheImage.type != 1) {
                this.cacheOutQueue.postRunnable(cacheOutTask, cacheOutTask.cacheImage.priority);
            } else {
                this.cacheThumbOutQueue.postRunnable(cacheOutTask);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fileDidFailedLoad(final String str, int i) {
        if (i == 1) {
            return;
        }
        this.imageLoadQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$fileDidFailedLoad$11(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fileDidFailedLoad$11(String str) {
        CacheImage cacheImage = this.imageLoadingByUrl.get(str);
        if (cacheImage != null) {
            cacheImage.setImageAndClear(null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runHttpTasks(boolean z) {
        if (z) {
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
    public void runArtworkTasks(boolean z) {
        if (z) {
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

    public boolean isLoadingHttpFile(String str) {
        return this.httpFileLoadTasksByKeys.containsKey(str);
    }

    public static String getHttpFileName(String str) {
        return Utilities.MD5(str);
    }

    public static File getHttpFilePath(String str, String str2) {
        String httpUrlExtension = getHttpUrlExtension(str, str2);
        return new File(FileLoader.getDirectory(4), Utilities.MD5(str) + "." + httpUrlExtension);
    }

    public void loadHttpFile(String str, String str2, int i) {
        if (str == null || str.length() == 0 || this.httpFileLoadTasksByKeys.containsKey(str)) {
            return;
        }
        String httpUrlExtension = getHttpUrlExtension(str, str2);
        File file = new File(FileLoader.getDirectory(4), Utilities.MD5(str) + "_temp." + httpUrlExtension);
        file.delete();
        HttpFileTask httpFileTask = new HttpFileTask(str, file, httpUrlExtension, i);
        this.httpFileLoadTasks.add(httpFileTask);
        this.httpFileLoadTasksByKeys.put(str, httpFileTask);
        runHttpFileLoadTasks(null, 0);
    }

    public void cancelLoadHttpFile(String str) {
        HttpFileTask httpFileTask = this.httpFileLoadTasksByKeys.get(str);
        if (httpFileTask != null) {
            httpFileTask.cancel(true);
            this.httpFileLoadTasksByKeys.remove(str);
            this.httpFileLoadTasks.remove(httpFileTask);
        }
        Runnable runnable = this.retryHttpsTasks.get(str);
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
        }
        runHttpFileLoadTasks(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runHttpFileLoadTasks(final HttpFileTask httpFileTask, final int i) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ImageLoader$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runHttpFileLoadTasks$13(httpFileTask, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runHttpFileLoadTasks$13(HttpFileTask httpFileTask, int i) {
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
                    Runnable runnable = new Runnable() { // from class: org.rbmain.messenger.ImageLoader$$ExternalSyntheticLambda11
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$runHttpFileLoadTasks$12(httpFileTask2);
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
    public /* synthetic */ void lambda$runHttpFileLoadTasks$12(HttpFileTask httpFileTask) {
        this.httpFileLoadTasks.add(httpFileTask);
        runHttpFileLoadTasks(null, 0);
    }

    public static boolean shouldSendImageAsDocument(String str, Uri uri) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (str == null && uri != null && uri.getScheme() != null) {
            if (uri.getScheme().contains("file")) {
                str = uri.getPath();
            } else {
                try {
                    str = AndroidUtilities.getPath(uri);
                } catch (Throwable th) {
                    FileLog.e(th);
                }
            }
        }
        if (str != null) {
            BitmapFactory.decodeFile(str, options);
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

    /* JADX WARN: Can't wrap try/catch for region: R(30:0|2|(1:19)(3:7|(1:9)(3:11|(2:165|15)|19)|10)|20|(1:22)(18:(3:161|24|25)|30|(1:32)(1:33)|34|(1:36)|37|(3:39|(2:40|(1:42)(1:171))|43)|44|(1:46)|47|169|48|(5:153|52|157|53|(1:55))|59|(6:65|159|66|(5:68|(1:70)(1:71)|72|(1:74)(1:75)|76)|77|(1:79))(1:64)|82|(2:(1:85)|86)|(3:151|88|(4:90|(1:92)|93|(3:95|96|175)(1:174))(1:173))(2:147|(5:155|114|(6:163|116|(1:118)|119|(2:121|122)(1:125)|126)(0)|146|141)(1:179)))|29|30|(0)(0)|34|(0)|37|(0)|44|(0)|47|169|48|(6:50|153|52|157|53|(0))|59|(2:61|63)|65|159|66|(0)|77|(0)|82|(0)|(0)(0)|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x014f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d2 A[Catch: all -> 0x00ef, PHI: r8 r9
      0x00d2: PHI (r8v6 android.util.Pair<java.lang.Integer, java.lang.Integer>) = 
      (r8v3 android.util.Pair<java.lang.Integer, java.lang.Integer>)
      (r8v8 android.util.Pair<java.lang.Integer, java.lang.Integer>)
     binds: [B:58:0x00d9, B:54:0x00d0] A[DONT_GENERATE, DONT_INLINE]
      0x00d2: PHI (r9v23 java.io.InputStream) = (r9v22 java.io.InputStream), (r9v26 java.io.InputStream) binds: [B:58:0x00d9, B:54:0x00d0] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #12 {all -> 0x00ef, blocks: (B:48:0x00aa, B:50:0x00b8, B:55:0x00d2, B:59:0x00da, B:61:0x00e4, B:65:0x00f1), top: B:169:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e4 A[Catch: all -> 0x00ef, TryCatch #12 {all -> 0x00ef, blocks: (B:48:0x00aa, B:50:0x00b8, B:55:0x00d2, B:59:0x00da, B:61:0x00e4, B:65:0x00f1), top: B:169:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0100 A[Catch: all -> 0x0138, TryCatch #7 {all -> 0x0138, blocks: (B:66:0x00f6, B:68:0x0100, B:72:0x0111, B:76:0x011e, B:77:0x0121, B:79:0x012b), top: B:159:0x00f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x012b A[Catch: all -> 0x0138, TRY_LEAVE, TryCatch #7 {all -> 0x0138, blocks: (B:66:0x00f6, B:68:0x0100, B:72:0x0111, B:76:0x011e, B:77:0x0121, B:79:0x012b), top: B:159:0x00f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0141  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:129:0x01e2 -> B:146:0x01fb). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap loadBitmap(java.lang.String r17, android.net.Uri r18, float r19, float r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.ImageLoader.loadBitmap(java.lang.String, android.net.Uri, float, float, boolean):android.graphics.Bitmap");
    }

    public static void fillPhotoSizeWithBytes(TLRPC$PhotoSize tLRPC$PhotoSize) {
        if (tLRPC$PhotoSize != null) {
            byte[] bArr = tLRPC$PhotoSize.bytes;
            if (bArr == null || bArr.length == 0) {
                FileLoader.getInstance(UserConfig.selectedAccount);
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(FileLoader.getPathToAttach(tLRPC$PhotoSize, true), "r");
                    if (((int) randomAccessFile.length()) < 20000) {
                        byte[] bArr2 = new byte[(int) randomAccessFile.length()];
                        tLRPC$PhotoSize.bytes = bArr2;
                        randomAccessFile.readFully(bArr2, 0, bArr2.length);
                    }
                } catch (Throwable th) {
                    FileLog.e(th);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static org.rbmain.tgnet.TLRPC$PhotoSize scaleAndSaveImageInternal(org.rbmain.tgnet.TLRPC$PhotoSize r2, android.graphics.Bitmap r3, android.graphics.Bitmap.CompressFormat r4, boolean r5, int r6, int r7, float r8, float r9, float r10, int r11, boolean r12, boolean r13, boolean r14) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.ImageLoader.scaleAndSaveImageInternal(org.rbmain.tgnet.TLRPC$PhotoSize, android.graphics.Bitmap, android.graphics.Bitmap$CompressFormat, boolean, int, int, float, float, float, int, boolean, boolean, boolean):org.rbmain.tgnet.TLRPC$PhotoSize");
    }

    public static TLRPC$PhotoSize scaleAndSaveImage(Bitmap bitmap, float f, float f2, int i, boolean z) {
        return scaleAndSaveImage(null, bitmap, Bitmap.CompressFormat.JPEG, false, f, f2, i, z, 0, 0, false);
    }

    public static TLRPC$PhotoSize scaleAndSaveImage(TLRPC$PhotoSize tLRPC$PhotoSize, Bitmap bitmap, float f, float f2, int i, boolean z, boolean z2) {
        return scaleAndSaveImage(tLRPC$PhotoSize, bitmap, Bitmap.CompressFormat.JPEG, false, f, f2, i, z, 0, 0, z2);
    }

    public static TLRPC$PhotoSize scaleAndSaveImage(Bitmap bitmap, float f, float f2, int i, boolean z, int i2, int i3) {
        return scaleAndSaveImage(null, bitmap, Bitmap.CompressFormat.JPEG, false, f, f2, i, z, i2, i3, false);
    }

    public static TLRPC$PhotoSize scaleAndSaveImage(Bitmap bitmap, float f, float f2, boolean z, int i, boolean z2, int i2, int i3) {
        return scaleAndSaveImage(null, bitmap, Bitmap.CompressFormat.JPEG, z, f, f2, i, z2, i2, i3, false);
    }

    public static TLRPC$PhotoSize scaleAndSaveImage(Bitmap bitmap, Bitmap.CompressFormat compressFormat, float f, float f2, int i, boolean z, int i2, int i3) {
        return scaleAndSaveImage(null, bitmap, compressFormat, false, f, f2, i, z, i2, i3, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.rbmain.tgnet.TLRPC$PhotoSize scaleAndSaveImage(org.rbmain.tgnet.TLRPC$PhotoSize r21, android.graphics.Bitmap r22, android.graphics.Bitmap.CompressFormat r23, boolean r24, float r25, float r26, int r27, boolean r28, int r29, int r30, boolean r31) {
        /*
            Method dump skipped, instructions count: 189
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.ImageLoader.scaleAndSaveImage(org.rbmain.tgnet.TLRPC$PhotoSize, android.graphics.Bitmap, android.graphics.Bitmap$CompressFormat, boolean, float, float, int, boolean, int, int, boolean):org.rbmain.tgnet.TLRPC$PhotoSize");
    }

    public static String getHttpUrlExtension(String str, String str2) {
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        if (!TextUtils.isEmpty(lastPathSegment) && lastPathSegment.length() > 1) {
            str = lastPathSegment;
        }
        int iLastIndexOf = str.lastIndexOf(46);
        String strSubstring = iLastIndexOf != -1 ? str.substring(iLastIndexOf + 1) : null;
        return (strSubstring == null || strSubstring.length() == 0 || strSubstring.length() > 4) ? str2 : strSubstring;
    }

    public static void saveMessageThumbs(TLRPC$Message tLRPC$Message) {
        TLRPC$PhotoSize tLRPC$PhotoSizeFindPhotoCachedSize;
        byte[] bArr;
        TLRPC$PhotoSize tLRPC$TL_photoSize;
        if (tLRPC$Message.media == null || (tLRPC$PhotoSizeFindPhotoCachedSize = findPhotoCachedSize(tLRPC$Message)) == null || (bArr = tLRPC$PhotoSizeFindPhotoCachedSize.bytes) == null || bArr.length == 0) {
            return;
        }
        TLRPC$FileLocation tLRPC$FileLocation = tLRPC$PhotoSizeFindPhotoCachedSize.location;
        if (tLRPC$FileLocation == null || (tLRPC$FileLocation instanceof TLRPC$TL_fileLocationUnavailable)) {
            TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated = new TLRPC$TL_fileLocationToBeDeprecated();
            tLRPC$PhotoSizeFindPhotoCachedSize.location = tLRPC$TL_fileLocationToBeDeprecated;
            tLRPC$TL_fileLocationToBeDeprecated.volume_id = -2147483648L;
            tLRPC$TL_fileLocationToBeDeprecated.local_id = SharedConfig.getLastLocalId();
        }
        int i = 0;
        if (tLRPC$PhotoSizeFindPhotoCachedSize.h <= 50 && tLRPC$PhotoSizeFindPhotoCachedSize.w <= 50) {
            tLRPC$TL_photoSize = new TLRPC$TL_photoStrippedSize();
            tLRPC$TL_photoSize.location = tLRPC$PhotoSizeFindPhotoCachedSize.location;
            tLRPC$TL_photoSize.bytes = tLRPC$PhotoSizeFindPhotoCachedSize.bytes;
            tLRPC$TL_photoSize.h = tLRPC$PhotoSizeFindPhotoCachedSize.h;
            tLRPC$TL_photoSize.w = tLRPC$PhotoSizeFindPhotoCachedSize.w;
        } else {
            FileLoader.getInstance(UserConfig.selectedAccount);
            boolean z = true;
            File pathToAttach = FileLoader.getPathToAttach(tLRPC$PhotoSizeFindPhotoCachedSize, true);
            if (MessageObject.shouldEncryptPhotoOrVideo(tLRPC$Message)) {
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
            tLRPC$TL_photoSize = new TLRPC$TL_photoSize();
            tLRPC$TL_photoSize.w = tLRPC$PhotoSizeFindPhotoCachedSize.w;
            tLRPC$TL_photoSize.h = tLRPC$PhotoSizeFindPhotoCachedSize.h;
            tLRPC$TL_photoSize.location = tLRPC$PhotoSizeFindPhotoCachedSize.location;
            tLRPC$TL_photoSize.size = tLRPC$PhotoSizeFindPhotoCachedSize.size;
            tLRPC$TL_photoSize.type = tLRPC$PhotoSizeFindPhotoCachedSize.type;
        }
        TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) {
            int size = tLRPC$MessageMedia.photo.sizes.size();
            while (i < size) {
                if (tLRPC$Message.media.photo.sizes.get(i) instanceof TLRPC$TL_photoCachedSize) {
                    tLRPC$Message.media.photo.sizes.set(i, tLRPC$TL_photoSize);
                    return;
                }
                i++;
            }
            return;
        }
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) {
            int size2 = tLRPC$MessageMedia.document.thumbs.size();
            while (i < size2) {
                if (tLRPC$Message.media.document.thumbs.get(i) instanceof TLRPC$TL_photoCachedSize) {
                    tLRPC$Message.media.document.thumbs.set(i, tLRPC$TL_photoSize);
                    return;
                }
                i++;
            }
            return;
        }
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
            int size3 = tLRPC$MessageMedia.webpage.photo.sizes.size();
            while (i < size3) {
                if (tLRPC$Message.media.webpage.photo.sizes.get(i) instanceof TLRPC$TL_photoCachedSize) {
                    tLRPC$Message.media.webpage.photo.sizes.set(i, tLRPC$TL_photoSize);
                    return;
                }
                i++;
            }
        }
    }

    private static TLRPC$PhotoSize findPhotoCachedSize(TLRPC$Message tLRPC$Message) {
        TLRPC$Photo tLRPC$Photo;
        TLRPC$PhotoSize tLRPC$PhotoSize;
        TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
        int i = 0;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) {
            int size = tLRPC$MessageMedia.photo.sizes.size();
            while (i < size) {
                tLRPC$PhotoSize = tLRPC$Message.media.photo.sizes.get(i);
                if (!(tLRPC$PhotoSize instanceof TLRPC$TL_photoCachedSize)) {
                    i++;
                }
            }
            return null;
        }
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) {
            int size2 = tLRPC$MessageMedia.document.thumbs.size();
            while (i < size2) {
                tLRPC$PhotoSize = tLRPC$Message.media.document.thumbs.get(i);
                if (!(tLRPC$PhotoSize instanceof TLRPC$TL_photoCachedSize)) {
                    i++;
                }
            }
            return null;
        }
        if (!(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) || (tLRPC$Photo = tLRPC$MessageMedia.webpage.photo) == null) {
            return null;
        }
        int size3 = tLRPC$Photo.sizes.size();
        while (i < size3) {
            tLRPC$PhotoSize = tLRPC$Message.media.webpage.photo.sizes.get(i);
            if (!(tLRPC$PhotoSize instanceof TLRPC$TL_photoCachedSize)) {
                i++;
            }
        }
        return null;
        return tLRPC$PhotoSize;
    }

    public static void saveMessagesThumbs(ArrayList<TLRPC$Message> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            saveMessageThumbs(arrayList.get(i));
        }
    }

    public static MessageThumb generateMessageThumb(TLRPC$Message tLRPC$Message) {
        int i;
        int i2;
        Bitmap strippedPhotoBitmap;
        byte[] bArr;
        TLRPC$PhotoSize tLRPC$PhotoSizeFindPhotoCachedSize = findPhotoCachedSize(tLRPC$Message);
        if (tLRPC$PhotoSizeFindPhotoCachedSize != null && (bArr = tLRPC$PhotoSizeFindPhotoCachedSize.bytes) != null && bArr.length != 0) {
            FileLoader.getInstance(UserConfig.selectedAccount);
            File pathToAttach = FileLoader.getPathToAttach(tLRPC$PhotoSizeFindPhotoCachedSize, true);
            TLRPC$TL_photoSize tLRPC$TL_photoSize = new TLRPC$TL_photoSize();
            tLRPC$TL_photoSize.w = tLRPC$PhotoSizeFindPhotoCachedSize.w;
            tLRPC$TL_photoSize.h = tLRPC$PhotoSizeFindPhotoCachedSize.h;
            tLRPC$TL_photoSize.location = tLRPC$PhotoSizeFindPhotoCachedSize.location;
            tLRPC$TL_photoSize.size = tLRPC$PhotoSizeFindPhotoCachedSize.size;
            tLRPC$TL_photoSize.type = tLRPC$PhotoSizeFindPhotoCachedSize.type;
            if (pathToAttach.exists() && tLRPC$Message.grouped_id == 0) {
                org.rbmain.ui.Components.Point messageSize = ChatMessageCell.getMessageSize(tLRPC$PhotoSizeFindPhotoCachedSize.w, tLRPC$PhotoSizeFindPhotoCachedSize.h);
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
            TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
            if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) {
                int size = tLRPC$MessageMedia.document.thumbs.size();
                for (int i3 = 0; i3 < size; i3++) {
                    TLRPC$PhotoSize tLRPC$PhotoSize = tLRPC$Message.media.document.thumbs.get(i3);
                    if (tLRPC$PhotoSize instanceof TLRPC$TL_photoStrippedSize) {
                        TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Message.media.document.thumbs, 320);
                        if (closestPhotoSizeWithSize == null) {
                            int i4 = 0;
                            while (true) {
                                if (i4 >= tLRPC$Message.media.document.attributes.size()) {
                                    i = 0;
                                    i2 = 0;
                                    break;
                                }
                                if (tLRPC$Message.media.document.attributes.get(i4) instanceof TLRPC$TL_documentAttributeVideo) {
                                    TLRPC$TL_documentAttributeVideo tLRPC$TL_documentAttributeVideo = (TLRPC$TL_documentAttributeVideo) tLRPC$Message.media.document.attributes.get(i4);
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
                        org.rbmain.ui.Components.Point messageSize2 = ChatMessageCell.getMessageSize(i, i2);
                        String str2 = String.format(Locale.US, "%s_false@%d_%d_b", ImageLocation.getStippedKey(tLRPC$Message, tLRPC$Message, tLRPC$PhotoSize), Integer.valueOf((int) (messageSize2.x / AndroidUtilities.density)), Integer.valueOf((int) (messageSize2.y / AndroidUtilities.density)));
                        if (!getInstance().isInMemCache(str2, false) && (strippedPhotoBitmap = getStrippedPhotoBitmap(tLRPC$PhotoSize.bytes, null)) != null) {
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

    public void onFragmentStackChanged() {
        for (int i = 0; i < this.cachedAnimatedFileDrawables.size(); i++) {
            this.cachedAnimatedFileDrawables.get(i).repeatCount = 0;
        }
    }

    public DispatchQueuePriority getCacheOutQueue() {
        return this.cacheOutQueue;
    }

    public static class MessageThumb {
        BitmapDrawable drawable;
        String key;

        public MessageThumb(String str, BitmapDrawable bitmapDrawable) {
            this.key = str;
            this.drawable = bitmapDrawable;
        }
    }

    public static Bitmap generateThumbnail(Bitmap bitmap, SSHCropView.SSHCropState sSHCropState, int i, int i2) {
        new RectF().set(MediaController.getInstance().getAddPostCropArea());
        int iCeil = (int) Math.ceil(scaleWidthToMaxSize(r7, new RectF(0.0f, 0.0f, 1280.0f, 1280.0f)));
        float f = iCeil;
        int iCeil2 = (int) Math.ceil(f / (MediaController.getInstance().getAddPostCropArea().width() / MediaController.getInstance().getAddPostCropArea().height()));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iCeil, iCeil2, Bitmap.Config.ARGB_8888);
        Matrix matrix = new Matrix();
        matrix.postTranslate((-sSHCropState.getWidth()) / 2.0f, (-sSHCropState.getHeight()) / 2.0f);
        matrix.postRotate(sSHCropState.getOrientation());
        sSHCropState.getConcatMatrix(matrix);
        float fWidth = f / MediaController.getInstance().getAddPostCropArea().width();
        matrix.postScale(fWidth, fWidth);
        matrix.postTranslate(f / 2.0f, iCeil2 / 2.0f);
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, matrix, new Paint(2));
        return bitmapCreateBitmap;
    }

    public static Bitmap generateThumbnail(Bitmap bitmap, float f, int i, int i2, int i3, int i4) {
        float width;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        float f2 = i3;
        float fWidth = f2 / MediaController.getInstance().getAddPostCropArea().width();
        float f3 = i4;
        float fHeight = f3 / MediaController.getInstance().getAddPostCropArea().height();
        if (bitmap.getHeight() > bitmap.getWidth() || i3 > i4) {
            width = f2 / bitmap.getWidth();
        } else {
            width = f3 / bitmap.getHeight();
        }
        float f4 = width * f;
        int i5 = (int) (i * fWidth);
        int i6 = (int) (i2 * fHeight);
        int i7 = (-((int) ((bitmap.getWidth() * f4) - f2))) / 2;
        int i8 = (-((int) ((bitmap.getHeight() * f4) - f3))) / 2;
        Matrix matrix = new Matrix();
        matrix.postScale(f4, f4);
        matrix.postTranslate(i5 + i7, i6 + i8);
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, matrix, new Paint(2));
        return bitmapCreateBitmap;
    }

    public static float scaleWidthToMaxSize(RectF rectF, RectF rectF2) {
        float fWidth = rectF2.width();
        return ((float) Math.floor((double) ((rectF.height() * fWidth) / rectF.width()))) > rectF2.height() ? (float) Math.floor((rectF2.height() * rectF.width()) / rectF.height()) : fWidth;
    }

    public static void saveFilteredBitmap(Bitmap bitmap, SSHCropView.SSHCropState sSHCropState, int i, int i2, File file, int i3) throws Exception {
        new RectF().set(MediaController.getInstance().getAddPostCropArea());
        int iCeil = (int) Math.ceil(scaleWidthToMaxSize(r7, new RectF(0.0f, 0.0f, 800.0f, 800.0f)));
        float f = iCeil;
        int iCeil2 = (int) Math.ceil(f / (MediaController.getInstance().getAddPostCropArea().width() / MediaController.getInstance().getAddPostCropArea().height()));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iCeil, iCeil2, Bitmap.Config.ARGB_8888);
        Matrix matrix = new Matrix();
        matrix.postTranslate((-bitmap.getWidth()) / 2.0f, (-bitmap.getHeight()) / 2.0f);
        matrix.postRotate(sSHCropState.getOrientation());
        float width = f / bitmap.getWidth();
        matrix.postScale(width, width);
        matrix.postTranslate(f / 2.0f, iCeil2 / 2.0f);
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, matrix, new Paint(2));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, i3, fileOutputStream);
        fileOutputStream.close();
        bitmapCreateBitmap.recycle();
    }

    public static TLRPC$PhotoSize getValidSize(Bitmap bitmap, float f, float f2, int i, boolean z) throws IOException {
        byte[] bArr;
        TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage = null;
        for (int i2 = 1; i2 <= 3; i2++) {
            float f3 = i2;
            tLRPC$PhotoSizeScaleAndSaveImage = scaleAndSaveImage(bitmap, f / f3, f2 / f3, i / i2, z);
            File pathToAttach = FileLoader.getPathToAttach(tLRPC$PhotoSizeScaleAndSaveImage.location, false);
            if (pathToAttach.exists()) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(pathToAttach, "r");
                    bArr = new byte[(int) randomAccessFile.length()];
                    try {
                        randomAccessFile.readFully(bArr);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (bArr != null) {
                            continue;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    bArr = null;
                }
                if (bArr != null && bArr.length > 0 && Base64.encodeToString(bArr, 0).length() < 2500) {
                    return tLRPC$PhotoSizeScaleAndSaveImage;
                }
            }
        }
        return tLRPC$PhotoSizeScaleAndSaveImage;
    }
}

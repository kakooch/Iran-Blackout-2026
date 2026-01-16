package ir.appp.rghapp.rubinoPostSlider;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidMessenger.proxy.FileLoadProxy;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import ir.appp.rghapp.rubinoPostSlider.FileLoadOperation;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.logger.MyLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import okhttp3.ResponseBody;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.NativeByteBuffer;
import org.rbmain.tgnet.TLRPC$TL_upload_file;
import org.rbmain.tgnet.TLRPC$TL_upload_webFile;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class FileLoadOperation {
    private static int preloadMaxBytes = 1179648;
    private boolean allowDisordererFileSave;
    private int bytesCountPadding;
    private File cacheFileFinal;
    private File cacheFileGzipTemp;
    private File cacheFileParts;
    private File cacheFilePreload;
    private File cacheFileTemp;
    private File cacheIvTemp;
    private int currentAccount;
    private int currentDownloadChunkSize;
    private int currentMaxDownloadRequests;
    private int currentType;
    private ArrayList<RequestInfo> delayedRequestInfos;
    FileLoadOperationDelegate delegate;
    private int downloadedBytes;
    private boolean encryptFile;
    private byte[] encryptIv;
    private byte[] encryptKey;
    private String ext;
    public PhotoViewerObject fileInlineObject;
    private RandomAccessFile fileOutputStream;
    private RandomAccessFile filePartsStream;
    private RandomAccessFile fileReadStream;
    private RandomAccessFile fiv;
    private int foundMoovSize;
    private boolean isForceRequest;
    private boolean isPreloadVideoOperation;
    private byte[] iv;
    private byte[] key;
    private int moovFound;
    private int nextAtomOffset;
    private boolean nextPartWasPreloaded;
    private int nextPreloadDownloadOffset;
    private ArrayList<Range> notLoadedBytesRanges;
    private volatile ArrayList<Range> notLoadedBytesRangesCopy;
    private ArrayList<Range> notRequestedBytesRanges;
    private volatile boolean paused;
    private boolean preloadFinished;
    private int preloadNotRequestedBytesCount;
    private RandomAccessFile preloadStream;
    private int preloadStreamFileOffset;
    private int preloadTempBufferCount;
    private SparseArray<PreloadRange> preloadedBytesRanges;
    private int priority;
    private RequestInfo priorityRequestInfo;
    private int renameRetryCount;
    private ArrayList<RequestInfo> requestInfos;
    private int requestedBytesCount;
    private SparseIntArray requestedPreloadedBytesRanges;
    private int requestsCount;
    private boolean reuploadingCdn;
    private boolean started;
    private File storePath;
    private ArrayList<FileLoadOperationStream> streamListeners;
    private int streamPriorityStartOffset;
    private int streamStartOffset;
    private File tempPath;
    private int totalBytesCount;
    private int totalPreloadedBytes;
    private boolean ungzip;
    private long lastTimeProgressNotified = 0;
    private Object processRequestSyncObject = new Object();
    private boolean oneTimeCheckedLenght = false;
    private final Object rangSynObject = new Object();
    private boolean supportsPreloading = true;
    private byte[] preloadTempBuffer = new byte[16];
    private String initialDatacenterId = BuildConfig.FLAVOR;
    private volatile int state = 0;

    public interface FileLoadOperationDelegate {
        void didChangedLoadProgress(FileLoadOperation fileLoadOperation, long j, long j2);

        void didFailedLoadingFile(FileLoadOperation fileLoadOperation, int i);

        void didFinishLoadingFile(FileLoadOperation fileLoadOperation, File file);
    }

    static /* synthetic */ int access$1920(FileLoadOperation fileLoadOperation, int i) {
        int i2 = fileLoadOperation.downloadedBytes - i;
        fileLoadOperation.downloadedBytes = i2;
        return i2;
    }

    protected static class RequestInfo {
        private DisposableObserver disposableObserver;
        private int offset;
        private TLRPC$TL_upload_file response;
        private TLRPC$TL_upload_webFile responseWeb;

        protected RequestInfo() {
        }
    }

    public static class Range {
        private int end;
        private int start;

        private Range(int i, int i2) {
            this.start = i;
            this.end = i2;
        }
    }

    private static class PreloadRange {
        private int fileOffset;
        private int length;

        private PreloadRange(int i, int i2) {
            this.fileOffset = i;
            this.length = i2;
        }
    }

    public FileLoadOperation(PhotoViewerObject photoViewerObject, Object obj) throws IOException {
        int iLastIndexOf;
        try {
            this.fileInlineObject = photoViewerObject;
            this.allowDisordererFileSave = true;
            int i = photoViewerObject.size;
            this.totalBytesCount = i;
            if (this.key != null && i % 16 != 0) {
                int i2 = 16 - (i % 16);
                this.bytesCountPadding = i2;
                this.totalBytesCount = i + i2;
            }
            String fileDownloadedName = photoViewerObject.getFileDownloadedName();
            this.ext = fileDownloadedName;
            if (fileDownloadedName == null || (iLastIndexOf = fileDownloadedName.lastIndexOf(46)) == -1) {
                this.ext = BuildConfig.FLAVOR;
            } else {
                this.ext = this.ext.substring(iLastIndexOf);
            }
            this.currentType = ConnectionsManager.FileTypeFile;
        } catch (Exception e) {
            FileLog.e(e);
            onFail(true, 0);
        }
    }

    public void setEncryptFile(boolean z) {
        this.encryptFile = z;
        if (z) {
            this.allowDisordererFileSave = false;
        }
    }

    public String getDatacenterId() {
        return this.initialDatacenterId;
    }

    public void setForceRequest(boolean z) {
        this.isForceRequest = z;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPaths(int i, File file, File file2) {
        this.storePath = file;
        this.tempPath = file2;
        this.currentAccount = i;
    }

    public boolean wasStarted() {
        return this.started && !this.paused;
    }

    private void removePart(ArrayList<Range> arrayList, int i, int i2) {
        int i3;
        boolean z;
        if (arrayList == null || i2 < i) {
            return;
        }
        synchronized (this.rangSynObject) {
            int size = arrayList.size();
            i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                Range range = arrayList.get(i4);
                if (i == range.end) {
                    range.end = i2;
                } else if (i2 == range.start) {
                    range.start = i;
                }
                z = true;
            }
            z = false;
        }
        synchronized (this.rangSynObject) {
            Collections.sort(arrayList, new Comparator() { // from class: ir.appp.rghapp.rubinoPostSlider.FileLoadOperation$$ExternalSyntheticLambda10
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return FileLoadOperation.lambda$removePart$0((FileLoadOperation.Range) obj, (FileLoadOperation.Range) obj2);
                }
            });
        }
        synchronized (this.rangSynObject) {
            while (i3 < arrayList.size() - 1) {
                Range range2 = arrayList.get(i3);
                int i5 = i3 + 1;
                Range range3 = arrayList.get(i5);
                if (range2.end == range3.start) {
                    range2.end = range3.end;
                    arrayList.remove(i5);
                    i3--;
                }
                i3++;
            }
            if (!z) {
                arrayList.add(new Range(i, i2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$removePart$0(Range range, Range range2) {
        if (range.start > range2.start) {
            return 1;
        }
        return range.start < range2.start ? -1 : 0;
    }

    private void addPart(ArrayList<Range> arrayList, int i, int i2, boolean z) {
        boolean z2;
        if (arrayList == null || i2 < i) {
            return;
        }
        synchronized (this.rangSynObject) {
            int size = arrayList.size();
            int i3 = 0;
            while (true) {
                z2 = true;
                if (i3 >= size) {
                    z2 = false;
                    break;
                }
                Range range = arrayList.get(i3);
                if (i <= range.start) {
                    if (i2 < range.end) {
                        if (i2 > range.start) {
                            range.start = i2;
                            break;
                        }
                        i3++;
                    } else {
                        arrayList.remove(i3);
                        break;
                    }
                } else if (i2 >= range.end) {
                    if (i < range.end) {
                        range.end = i;
                        break;
                    }
                    i3++;
                } else {
                    arrayList.add(0, new Range(range.start, i));
                    range.start = i2;
                    break;
                }
            }
            if (z) {
                if (z2) {
                    try {
                        this.filePartsStream.seek(0L);
                        int size2 = arrayList.size();
                        this.filePartsStream.writeInt(size2);
                        for (int i4 = 0; i4 < size2; i4++) {
                            Range range2 = arrayList.get(i4);
                            this.filePartsStream.writeInt(range2.start);
                            this.filePartsStream.writeInt(range2.end);
                        }
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    ArrayList<FileLoadOperationStream> arrayList2 = this.streamListeners;
                    if (arrayList2 != null) {
                        int size3 = arrayList2.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            this.streamListeners.get(i5).newDataAvailable();
                        }
                    }
                } else {
                    boolean z3 = BuildVars.LOGS_ENABLED;
                }
            }
        }
    }

    protected File getCurrentFile() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final File[] fileArr = new File[1];
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FileLoadOperation$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getCurrentFile$1(fileArr, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
        return fileArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCurrentFile$1(File[] fileArr, CountDownLatch countDownLatch) {
        if (this.state == 3) {
            fileArr[0] = this.cacheFileFinal;
        } else {
            fileArr[0] = this.cacheFileTemp;
        }
        countDownLatch.countDown();
    }

    private int getDownloadedLengthFromOffsetInternal(ArrayList<Range> arrayList, int i, int i2) {
        int i3;
        if (arrayList == null || this.state == 3 || arrayList.isEmpty()) {
            int i4 = this.downloadedBytes;
            return i4 == 0 ? i2 : Math.min(i2, Math.max(i4 - i, 0));
        }
        Range range = null;
        synchronized (this.rangSynObject) {
            int i5 = 0;
            while (true) {
                if (i5 >= arrayList.size()) {
                    i3 = i2;
                    break;
                }
                Range range2 = arrayList.get(i5);
                if (i <= range2.start && (range == null || range2.start < range.start)) {
                    range = range2;
                }
                if (range2.start <= i && range2.end > i) {
                    i3 = 0;
                    break;
                }
                i5++;
            }
        }
        if (i3 == 0) {
            return 0;
        }
        if (range != null) {
            return Math.min(i2, range.start - i);
        }
        return Math.min(i2, Math.max(this.totalBytesCount - i, 0));
    }

    protected int getDownloadedLengthFromOffset(final int i, final int i2) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final int[] iArr = new int[1];
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FileLoadOperation$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getDownloadedLengthFromOffset$2(iArr, i, i2, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception unused) {
        }
        return iArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDownloadedLengthFromOffset$2(int[] iArr, int i, int i2, CountDownLatch countDownLatch) {
        iArr[0] = getDownloadedLengthFromOffsetInternal(this.notLoadedBytesRanges, i, i2);
        countDownLatch.countDown();
    }

    protected void removeStreamListener(final FileLoadOperationStream fileLoadOperationStream) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FileLoadOperation$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeStreamListener$3(fileLoadOperationStream);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeStreamListener$3(FileLoadOperationStream fileLoadOperationStream) {
        ArrayList<FileLoadOperationStream> arrayList = this.streamListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(fileLoadOperationStream);
    }

    private void copyNotLoadedRanges() {
        if (this.notLoadedBytesRanges == null) {
            return;
        }
        this.notLoadedBytesRangesCopy = new ArrayList<>(this.notLoadedBytesRanges);
    }

    public boolean start() {
        return start(null, 0, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x050e A[Catch: Exception -> 0x0513, TRY_LEAVE, TryCatch #8 {Exception -> 0x0513, blocks: (B:204:0x04ff, B:206:0x050e), top: B:236:0x04ff }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x051f  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0218 A[Catch: Exception -> 0x02da, TryCatch #4 {Exception -> 0x02da, blocks: (B:74:0x01fe, B:76:0x0218, B:80:0x0223, B:81:0x0226, B:83:0x022b, B:86:0x0233, B:89:0x0244, B:92:0x024a, B:94:0x025a, B:97:0x025f, B:100:0x0274, B:102:0x027e, B:106:0x028b, B:107:0x028f, B:109:0x02a5, B:110:0x02ac, B:112:0x02b0, B:113:0x02b7, B:114:0x02d1), top: B:229:0x01fe }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean start(final ir.appp.rghapp.rubinoPostSlider.FileLoadOperationStream r23, final int r24, final boolean r25) {
        /*
            Method dump skipped, instructions count: 1341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.FileLoadOperation.start(ir.appp.rghapp.rubinoPostSlider.FileLoadOperationStream, int, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$4(boolean z, int i, FileLoadOperationStream fileLoadOperationStream, boolean z2) throws IOException {
        if (this.streamListeners == null) {
            this.streamListeners = new ArrayList<>();
        }
        if (z) {
            int i2 = this.currentDownloadChunkSize;
            int i3 = (i / i2) * i2;
            RequestInfo requestInfo = this.priorityRequestInfo;
            if (requestInfo != null && requestInfo.offset != i3) {
                synchronized (this.rangSynObject) {
                    this.requestInfos.remove(this.priorityRequestInfo);
                }
                this.requestedBytesCount -= this.currentDownloadChunkSize;
                removePart(this.notRequestedBytesRanges, this.priorityRequestInfo.offset, this.priorityRequestInfo.offset + this.currentDownloadChunkSize);
                if (this.priorityRequestInfo.disposableObserver != null) {
                    this.priorityRequestInfo.disposableObserver.dispose();
                    this.requestsCount--;
                }
                if (BuildVars.DEBUG_VERSION) {
                    FileLog.d("frame get cancel request at offset " + this.priorityRequestInfo.offset);
                }
                this.priorityRequestInfo = null;
            }
            if (this.priorityRequestInfo == null) {
                this.streamPriorityStartOffset = i3;
            }
        } else {
            int i4 = this.currentDownloadChunkSize;
            this.streamStartOffset = (i / i4) * i4;
        }
        this.streamListeners.add(fileLoadOperationStream);
        if (z2) {
            if (this.preloadedBytesRanges != null && getDownloadedLengthFromOffsetInternal(this.notLoadedBytesRanges, this.streamStartOffset, 1) == 0 && this.preloadedBytesRanges.get(this.streamStartOffset) != null) {
                this.nextPartWasPreloaded = true;
            }
            startDownloadRequest();
            this.nextPartWasPreloaded = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$5(boolean[] zArr) throws IOException {
        int i = this.totalBytesCount;
        if (i != 0 && ((this.isPreloadVideoOperation && zArr[0]) || this.downloadedBytes == i)) {
            try {
                MyLog.e("RubinoDownload", "RubinoDownload finished 5 ");
                onFinishLoadingFile(false);
                return;
            } catch (Exception unused) {
                onFail(true, 0);
                return;
            }
        }
        startDownloadRequest();
    }

    public boolean isPaused() {
        return this.paused;
    }

    public void setIsPreloadVideoOperation(final boolean z) {
        boolean z2 = this.isPreloadVideoOperation;
        if (z2 == z) {
            return;
        }
        if (!z && z2) {
            if (this.state == 3) {
                this.isPreloadVideoOperation = z;
                this.state = 0;
                this.preloadFinished = false;
                start();
                return;
            }
            if (this.state == 1) {
                Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FileLoadOperation$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        this.f$0.lambda$setIsPreloadVideoOperation$6(z);
                    }
                });
                return;
            } else {
                this.isPreloadVideoOperation = z;
                return;
            }
        }
        this.isPreloadVideoOperation = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setIsPreloadVideoOperation$6(boolean z) throws IOException {
        this.requestedBytesCount = 0;
        clearOperaion(null, true);
        this.isPreloadVideoOperation = z;
        startDownloadRequest();
    }

    public boolean isPreloadVideoOperation() {
        return this.isPreloadVideoOperation;
    }

    public boolean isPreloadFinished() {
        return this.preloadFinished;
    }

    public void cancel() {
        MyLog.e("FileLoadOperation", toString() + "cancel");
        MyLog.e("StoryLogPreload", " cancel in FileLoadOperation storyId " + this.fileInlineObject.storyId + " " + this.fileInlineObject.filePath);
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FileLoadOperation$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.f$0.lambda$cancel$7();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancel$7() throws IOException {
        MyLog.e("FileLoadOperation", "FileLoader: cancel2 " + this.fileInlineObject.getFileDownloadedName());
        if (this.state == 3 || this.state == 2) {
            MyLog.e("FileLoadOperation", "FileLoader: cancel3 " + this.fileInlineObject.getFileDownloadedName());
            return;
        }
        try {
            if (this.requestInfos != null) {
                for (int i = 0; i < this.requestInfos.size(); i++) {
                    RequestInfo requestInfo = this.requestInfos.get(i);
                    if (requestInfo.disposableObserver != null) {
                        requestInfo.disposableObserver.dispose();
                    }
                }
            }
        } catch (Exception unused) {
        }
        onFail(false, 1);
    }

    private void cleanup() throws IOException {
        MyLog.e("FileLoadOperation", "FileLoader: cancel5 " + this.fileInlineObject.getFileDownloadedName());
        try {
            RandomAccessFile randomAccessFile = this.fileOutputStream;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.getChannel().close();
                } catch (Exception e) {
                    FileLog.e(e);
                }
                this.fileOutputStream.close();
                this.fileOutputStream = null;
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        try {
            RandomAccessFile randomAccessFile2 = this.preloadStream;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.getChannel().close();
                } catch (Exception e3) {
                    FileLog.e(e3);
                }
                this.preloadStream.close();
                this.preloadStream = null;
            }
        } catch (Exception e4) {
            FileLog.e(e4);
        }
        try {
            RandomAccessFile randomAccessFile3 = this.fileReadStream;
            if (randomAccessFile3 != null) {
                try {
                    randomAccessFile3.getChannel().close();
                } catch (Exception e5) {
                    FileLog.e(e5);
                }
                this.fileReadStream.close();
                this.fileReadStream = null;
            }
        } catch (Exception e6) {
            FileLog.e(e6);
        }
        try {
            RandomAccessFile randomAccessFile4 = this.filePartsStream;
            if (randomAccessFile4 != null) {
                try {
                    randomAccessFile4.getChannel().close();
                } catch (Exception e7) {
                    FileLog.e(e7);
                }
                this.filePartsStream.close();
                this.filePartsStream = null;
            }
        } catch (Exception e8) {
            FileLog.e(e8);
        }
        try {
            RandomAccessFile randomAccessFile5 = this.fiv;
            if (randomAccessFile5 != null) {
                randomAccessFile5.close();
                this.fiv = null;
            }
        } catch (Exception e9) {
            FileLog.e(e9);
        }
        if (this.delayedRequestInfos != null) {
            synchronized (this.rangSynObject) {
                for (int i = 0; i < this.delayedRequestInfos.size(); i++) {
                    RequestInfo requestInfo = this.delayedRequestInfos.get(i);
                    if (requestInfo.disposableObserver != null) {
                        requestInfo.disposableObserver.dispose();
                    }
                }
                this.delayedRequestInfos.clear();
            }
        }
        if (this.requestInfos != null) {
            synchronized (this.rangSynObject) {
                for (int i2 = 0; i2 < this.requestInfos.size(); i2++) {
                    RequestInfo requestInfo2 = this.requestInfos.get(i2);
                    if (requestInfo2 != null && requestInfo2.disposableObserver != null) {
                        requestInfo2.disposableObserver.dispose();
                    }
                }
                this.requestInfos.clear();
            }
        }
    }

    private void onFinishLoadingFile(final boolean z) throws IOException {
        if (this.state != 1) {
            return;
        }
        MyLog.e("StoryLogPreload", "FileLoaderOperation onFinishLoadingFile " + this.fileInlineObject.storyId);
        this.state = 3;
        cleanup();
        if (this.isPreloadVideoOperation) {
            this.preloadFinished = true;
            if (BuildVars.DEBUG_VERSION) {
                FileLog.d("finished preloading file to " + this.cacheFileTemp + " loaded " + this.totalPreloadedBytes + " of " + this.totalBytesCount);
            }
        } else {
            if (this.cacheFileTemp != null) {
                if (this.ungzip) {
                    try {
                        GZIPInputStream gZIPInputStream = new GZIPInputStream(new FileInputStream(this.cacheFileTemp));
                        FileLoaderRubinoPost.copyFile(gZIPInputStream, this.cacheFileGzipTemp, 2097152);
                        gZIPInputStream.close();
                        this.cacheFileTemp.delete();
                        this.cacheFileTemp = this.cacheFileGzipTemp;
                        this.ungzip = false;
                    } catch (ZipException unused) {
                        this.ungzip = false;
                    } catch (Throwable th) {
                        FileLog.e(th);
                        boolean z2 = BuildVars.LOGS_ENABLED;
                    }
                }
                if (!this.ungzip) {
                    if (!this.cacheFileTemp.renameTo(this.cacheFileFinal)) {
                        boolean z3 = BuildVars.LOGS_ENABLED;
                        int i = this.renameRetryCount + 1;
                        this.renameRetryCount = i;
                        if (i < 3) {
                            this.state = 1;
                            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FileLoadOperation$$ExternalSyntheticLambda5
                                @Override // java.lang.Runnable
                                public final void run() throws IOException {
                                    this.f$0.lambda$onFinishLoadingFile$8(z);
                                }
                            }, 200L);
                            return;
                        } else {
                            onFail(false, 0);
                            return;
                        }
                    }
                    MyLog.e("RubioDownload", "RubinoDownload Finished");
                } else {
                    onFail(false, 0);
                    return;
                }
            }
            File file = this.cacheIvTemp;
            if (file != null) {
                file.delete();
                this.cacheIvTemp = null;
            }
            File file2 = this.cacheFileParts;
            if (file2 != null) {
                file2.delete();
                this.cacheFileParts = null;
            }
            File file3 = this.cacheFilePreload;
            if (file3 != null) {
                file3.delete();
                this.cacheFilePreload = null;
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("finished downloading file to " + this.cacheFileFinal);
            }
            if (z && this.currentType != 50331648) {
            }
        }
        PhotoViewerObject photoViewerObject = this.fileInlineObject;
        if (photoViewerObject != null) {
            photoViewerObject.isRecentlyDownloaded = true;
        }
        this.delegate.didFinishLoadingFile(this, this.cacheFileFinal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFinishLoadingFile$8(boolean z) throws IOException {
        try {
            onFinishLoadingFile(z);
        } catch (Exception unused) {
            onFail(false, 0);
        }
    }

    private void delayRequestInfo(RequestInfo requestInfo) {
        this.delayedRequestInfos.add(requestInfo);
    }

    private int findNextPreloadDownloadOffset(int i, int i2, ByteBuffer byteBuffer) {
        int i3;
        int iLimit = byteBuffer.limit();
        do {
            if (i < i2 - (this.preloadTempBuffer != null ? 16 : 0) || i >= (i3 = i2 + iLimit)) {
                return 0;
            }
            if (i >= i3 - 16) {
                this.preloadTempBufferCount = i3 - i;
                byteBuffer.position(byteBuffer.limit() - this.preloadTempBufferCount);
                byteBuffer.get(this.preloadTempBuffer, 0, this.preloadTempBufferCount);
                return i3;
            }
            if (this.preloadTempBufferCount != 0) {
                byteBuffer.position(0);
                byte[] bArr = this.preloadTempBuffer;
                int i4 = this.preloadTempBufferCount;
                byteBuffer.get(bArr, i4, 16 - i4);
                this.preloadTempBufferCount = 0;
            } else {
                byteBuffer.position(i - i2);
                byteBuffer.get(this.preloadTempBuffer, 0, 16);
            }
            byte[] bArr2 = this.preloadTempBuffer;
            int i5 = ((bArr2[0] & 255) << 24) + ((bArr2[1] & 255) << 16) + ((bArr2[2] & 255) << 8) + (bArr2[3] & 255);
            if (i5 == 0) {
                return 0;
            }
            if (i5 == 1) {
                i5 = ((bArr2[12] & 255) << 24) + ((bArr2[13] & 255) << 16) + ((bArr2[14] & 255) << 8) + (bArr2[15] & 255);
            }
            if (bArr2[4] == 109 && bArr2[5] == 111 && bArr2[6] == 111 && bArr2[7] == 118) {
                return -i5;
            }
            i += i5;
        } while (i < i3);
        return i;
    }

    protected boolean processRequestResult(RequestInfo requestInfo, Object obj) {
        boolean z;
        int i;
        boolean z2;
        synchronized (this.processRequestSyncObject) {
            if (this.state != 1) {
                if (BuildVars.DEBUG_VERSION) {
                    FileLog.d("trying to write to finished file " + this.cacheFileFinal + " offset " + requestInfo.offset);
                }
                return false;
            }
            this.requestInfos.remove(requestInfo);
            if (obj == null) {
                try {
                    if (this.notLoadedBytesRanges != null || this.downloadedBytes == requestInfo.offset) {
                        NativeByteBuffer nativeByteBuffer = requestInfo.response != null ? requestInfo.response.bytes : requestInfo.responseWeb != null ? requestInfo.responseWeb.bytes : null;
                        if (nativeByteBuffer != null && nativeByteBuffer.limit() != 0) {
                            int iLimit = nativeByteBuffer.limit();
                            if (this.isPreloadVideoOperation) {
                                this.preloadStream.writeInt(requestInfo.offset);
                                this.preloadStream.writeInt(iLimit);
                                this.preloadStreamFileOffset += 8;
                                this.preloadStream.getChannel().write(nativeByteBuffer.buffer);
                                if (BuildVars.DEBUG_VERSION) {
                                    FileLog.d("save preload file part " + this.cacheFilePreload + " offset " + requestInfo.offset + " size " + iLimit);
                                }
                                if (this.preloadedBytesRanges == null) {
                                    this.preloadedBytesRanges = new SparseArray<>();
                                }
                                this.preloadedBytesRanges.put(requestInfo.offset, new PreloadRange(this.preloadStreamFileOffset, iLimit));
                                this.totalPreloadedBytes += iLimit;
                                this.preloadStreamFileOffset += iLimit;
                                if (this.moovFound == 0) {
                                    int iFindNextPreloadDownloadOffset = findNextPreloadDownloadOffset(this.nextAtomOffset, requestInfo.offset, nativeByteBuffer.buffer);
                                    if (iFindNextPreloadDownloadOffset < 0) {
                                        iFindNextPreloadDownloadOffset *= -1;
                                        int i2 = this.nextPreloadDownloadOffset + this.currentDownloadChunkSize;
                                        this.nextPreloadDownloadOffset = i2;
                                        if (i2 < this.totalBytesCount / 2) {
                                            int i3 = (preloadMaxBytes / 2) + iFindNextPreloadDownloadOffset;
                                            this.foundMoovSize = i3;
                                            this.preloadNotRequestedBytesCount = i3;
                                            this.moovFound = 1;
                                        } else {
                                            int i4 = preloadMaxBytes;
                                            this.foundMoovSize = i4;
                                            this.preloadNotRequestedBytesCount = i4;
                                            this.moovFound = 2;
                                        }
                                        this.nextPreloadDownloadOffset = -1;
                                    } else {
                                        int i5 = this.currentDownloadChunkSize;
                                        this.nextPreloadDownloadOffset = (iFindNextPreloadDownloadOffset / i5) * i5;
                                    }
                                    this.nextAtomOffset = iFindNextPreloadDownloadOffset;
                                }
                                this.preloadStream.writeInt(this.foundMoovSize);
                                this.preloadStream.writeInt(this.nextPreloadDownloadOffset);
                                this.preloadStream.writeInt(this.nextAtomOffset);
                                this.preloadStreamFileOffset += 12;
                                int i6 = this.nextPreloadDownloadOffset;
                                z2 = i6 == 0 || (this.moovFound != 0 && this.foundMoovSize < 0) || this.totalPreloadedBytes > preloadMaxBytes || i6 >= this.totalBytesCount;
                                if (z2) {
                                    this.preloadStream.seek(0L);
                                    this.preloadStream.write(1);
                                } else if (this.moovFound != 0) {
                                    this.foundMoovSize -= this.currentDownloadChunkSize;
                                }
                            } else {
                                this.downloadedBytes += iLimit;
                                MyLog.e("RubinoDownload", "RubinoDowload downloadedBytes6= " + this.downloadedBytes);
                                int i7 = this.totalBytesCount;
                                if (i7 > 0) {
                                    z = this.downloadedBytes >= i7;
                                    if (z) {
                                        MyLog.e("RubinoDownload", "RubinoDownload finished 1 " + this.downloadedBytes + " " + this.totalBytesCount);
                                    }
                                } else {
                                    int i8 = this.currentDownloadChunkSize;
                                    z = iLimit != i8 || ((i7 == (i = this.downloadedBytes) || i % i8 != 0) && (i7 <= 0 || i7 <= i));
                                    MyLog.e("RubinoDownload", "RubinoDownload finished 2 ");
                                }
                                boolean z3 = z;
                                if (this.notLoadedBytesRanges != null) {
                                    this.fileOutputStream.seek(requestInfo.offset);
                                    if (BuildVars.DEBUG_VERSION) {
                                        FileLog.d("save file part " + this.cacheFileFinal + " offset " + requestInfo.offset);
                                    }
                                }
                                this.fileOutputStream.getChannel().write(nativeByteBuffer.buffer);
                                addPart(this.notLoadedBytesRanges, requestInfo.offset, requestInfo.offset + iLimit, true);
                                RandomAccessFile randomAccessFile = this.fiv;
                                if (randomAccessFile != null) {
                                    randomAccessFile.seek(0L);
                                    this.fiv.write(this.iv);
                                }
                                if (this.totalBytesCount > 0 && this.state == 1) {
                                    copyNotLoadedRanges();
                                    if (System.currentTimeMillis() - this.lastTimeProgressNotified > 200) {
                                        this.lastTimeProgressNotified = System.currentTimeMillis();
                                        this.delegate.didChangedLoadProgress(this, this.downloadedBytes, this.totalBytesCount);
                                    }
                                }
                                z2 = z3;
                            }
                            for (int i9 = 0; i9 < this.delayedRequestInfos.size(); i9++) {
                                RequestInfo requestInfo2 = this.delayedRequestInfos.get(i9);
                                if (this.notLoadedBytesRanges == null && this.downloadedBytes != requestInfo2.offset) {
                                }
                                this.delayedRequestInfos.remove(i9);
                                processRequestResult(requestInfo2, null);
                            }
                            if (z2) {
                                onFinishLoadingFile(true);
                            } else {
                                startDownloadRequest();
                            }
                            if (requestInfo.response != null) {
                                requestInfo.response.disableFree = false;
                                requestInfo.response.freeResources();
                            }
                        }
                        MyLog.e("RubinoDownload", "RubinoDownload finished 3 byte null");
                        onFinishLoadingFile(true);
                        return false;
                    }
                    delayRequestInfo(requestInfo);
                    return false;
                } catch (Exception e) {
                    onFail(false, 0);
                    FileLog.e(e);
                }
            } else {
                onFail(false, 0);
            }
            return false;
        }
    }

    protected void onFail(boolean z, final int i) throws IOException {
        cleanup();
        this.state = 2;
        MyLog.e("FileLoadOperation", toString() + "state Cancel ");
        if (z) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FileLoadOperation.1
                @Override // java.lang.Runnable
                public void run() {
                    FileLoadOperation fileLoadOperation = FileLoadOperation.this;
                    FileLoadOperationDelegate fileLoadOperationDelegate = fileLoadOperation.delegate;
                    if (fileLoadOperationDelegate != null) {
                        fileLoadOperationDelegate.didFailedLoadingFile(fileLoadOperation, i);
                    }
                }
            });
        } else {
            this.delegate.didFailedLoadingFile(this, i);
        }
    }

    private void clearOperaion(RequestInfo requestInfo, boolean z) {
        int iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
        for (int i = 0; i < this.requestInfos.size(); i++) {
            RequestInfo requestInfo2 = this.requestInfos.get(i);
            iMin = Math.min(requestInfo2.offset, iMin);
            if (this.isPreloadVideoOperation) {
                this.requestedPreloadedBytesRanges.delete(requestInfo2.offset);
            } else {
                removePart(this.notRequestedBytesRanges, requestInfo2.offset, requestInfo2.offset + this.currentDownloadChunkSize);
            }
            if (requestInfo != requestInfo2 && requestInfo2.disposableObserver != null) {
                requestInfo2.disposableObserver.dispose();
            }
        }
        this.requestInfos.clear();
        for (int i2 = 0; i2 < this.delayedRequestInfos.size(); i2++) {
            RequestInfo requestInfo3 = this.delayedRequestInfos.get(i2);
            if (this.isPreloadVideoOperation) {
                this.requestedPreloadedBytesRanges.delete(requestInfo3.offset);
            } else {
                removePart(this.notRequestedBytesRanges, requestInfo3.offset, requestInfo3.offset + this.currentDownloadChunkSize);
            }
            if (requestInfo3.response != null) {
                requestInfo3.response.disableFree = false;
                requestInfo3.response.freeResources();
            } else if (requestInfo3.responseWeb != null) {
                requestInfo3.responseWeb.disableFree = false;
                requestInfo3.responseWeb.freeResources();
            }
            iMin = Math.min(requestInfo3.offset, iMin);
        }
        this.delayedRequestInfos.clear();
        this.requestsCount = 0;
        if (!z && this.isPreloadVideoOperation) {
            this.requestedBytesCount = this.totalPreloadedBytes;
            return;
        }
        if (this.notLoadedBytesRanges == null) {
            this.downloadedBytes = iMin;
            this.requestedBytesCount = iMin;
            MyLog.e("RubinoDownload", "RubinoDowload downloadedBytes2= " + this.downloadedBytes);
        }
    }

    protected void startDownloadRequest() throws IOException {
        final int i;
        int iMin;
        SparseArray<PreloadRange> sparseArray;
        PreloadRange preloadRange;
        ArrayList<Range> arrayList;
        boolean z;
        boolean z2;
        if (this.paused || this.reuploadingCdn || this.state != 1) {
            return;
        }
        if (this.streamPriorityStartOffset == 0) {
            if (!this.nextPartWasPreloaded && this.requestInfos.size() + this.delayedRequestInfos.size() >= this.currentMaxDownloadRequests) {
                return;
            }
            if (this.isPreloadVideoOperation) {
                if (this.requestedBytesCount > preloadMaxBytes) {
                    return;
                }
                if (this.moovFound != 0 && this.requestInfos.size() > 0) {
                    return;
                }
            }
        }
        int iMax = (this.streamPriorityStartOffset != 0 || this.nextPartWasPreloaded || ((z2 = this.isPreloadVideoOperation) && this.moovFound == 0) || this.totalBytesCount <= 0) ? 1 : Math.max(0, ((z2 && FileLoaderRubinoPost.getInstance(this.currentAccount).isHighPriorityFileDownloading()) ? 1 : this.currentMaxDownloadRequests) - this.requestInfos.size());
        for (int i2 = 0; i2 < iMax; i2++) {
            if (this.isPreloadVideoOperation) {
                if (this.moovFound != 0 && this.preloadNotRequestedBytesCount <= 0) {
                    return;
                }
                i = this.nextPreloadDownloadOffset;
                if (i == -1) {
                    int i3 = 0;
                    for (int i4 = (preloadMaxBytes / this.currentDownloadChunkSize) + 2; i4 != 0; i4--) {
                        if (this.requestedPreloadedBytesRanges.get(i3, 0) == 0) {
                            i = i3;
                            z = true;
                            break;
                        }
                        int i5 = this.currentDownloadChunkSize;
                        i3 += i5;
                        int i6 = this.totalBytesCount;
                        if (i3 > i6) {
                            break;
                        }
                        if (this.moovFound == 2 && i3 == i5 * 8) {
                            i3 = ((i6 - (preloadMaxBytes / 2)) / i5) * i5;
                        }
                    }
                    i = i3;
                    z = false;
                    if (!z && this.requestInfos.isEmpty()) {
                        onFinishLoadingFile(false);
                    }
                    if (!z) {
                        continue;
                    }
                }
                if (this.requestedPreloadedBytesRanges == null) {
                    this.requestedPreloadedBytesRanges = new SparseIntArray();
                }
                this.requestedPreloadedBytesRanges.put(i, 1);
                if (BuildVars.DEBUG_VERSION) {
                    FileLog.d("start next preload from " + i + " size " + this.totalBytesCount + " for " + this.cacheFilePreload);
                }
                this.preloadNotRequestedBytesCount -= this.currentDownloadChunkSize;
            } else if (this.notRequestedBytesRanges != null) {
                i = this.streamPriorityStartOffset;
                if (i == 0) {
                    i = this.streamStartOffset;
                }
                synchronized (this.rangSynObject) {
                    int size = this.notRequestedBytesRanges.size();
                    int i7 = 0;
                    iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
                    int i8 = ConnectionsManager.DEFAULT_DATACENTER_ID;
                    while (true) {
                        if (i7 >= size) {
                            i = i8;
                            break;
                        }
                        Range range = this.notRequestedBytesRanges.get(i7);
                        if (i != 0) {
                            if (range.start <= i && range.end > i) {
                                iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
                                break;
                            } else if (i < range.start && range.start < i8) {
                                i8 = range.start;
                            }
                        }
                        iMin = Math.min(iMin, range.start);
                        i7++;
                    }
                }
                if (i == Integer.MAX_VALUE) {
                    if (iMin == Integer.MAX_VALUE) {
                        return;
                    } else {
                        i = iMin;
                    }
                }
            } else {
                i = this.requestedBytesCount;
            }
            if (!this.isPreloadVideoOperation && (arrayList = this.notRequestedBytesRanges) != null) {
                addPart(arrayList, i, this.currentDownloadChunkSize + i, false);
            }
            int i9 = this.totalBytesCount;
            if (i9 > 0 && i >= i9) {
                return;
            }
            if (i9 > 0) {
                int i10 = iMax - 1;
            }
            int i11 = this.requestsCount % 2;
            this.requestedBytesCount += this.currentDownloadChunkSize;
            final RequestInfo requestInfo = new RequestInfo();
            synchronized (this.rangSynObject) {
                this.requestInfos.add(requestInfo);
            }
            requestInfo.offset = i;
            if (!this.isPreloadVideoOperation && this.supportsPreloading && this.preloadStream != null && (sparseArray = this.preloadedBytesRanges) != null && (preloadRange = sparseArray.get(requestInfo.offset)) != null) {
                requestInfo.response = new TLRPC$TL_upload_file();
                try {
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(preloadRange.length);
                    this.preloadStream.seek(preloadRange.fileOffset);
                    this.preloadStream.getChannel().read(byteBufferAllocate);
                    byteBufferAllocate.position(0);
                    requestInfo.response.bytes = FileLoadProxy.getByteBufferOfResult(byteBufferAllocate.array());
                    Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FileLoadOperation$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$startDownloadRequest$9(requestInfo);
                        }
                    });
                } catch (Exception unused) {
                }
            } else {
                if (this.streamPriorityStartOffset != 0) {
                    if (BuildVars.DEBUG_VERSION) {
                        FileLog.d("frame get offset = " + this.streamPriorityStartOffset);
                    }
                    this.streamPriorityStartOffset = 0;
                    this.priorityRequestInfo = requestInfo;
                }
                requestInfo.disposableObserver = (DisposableObserver) Observable.just(1).delay(i == 0 ? 300L : 10L, TimeUnit.MILLISECONDS).flatMap(new Function<Integer, Observable<Response<ResponseBody>>>() { // from class: ir.appp.rghapp.rubinoPostSlider.FileLoadOperation.3
                    @Override // io.reactivex.functions.Function
                    public Observable<Response<ResponseBody>> apply(Integer num) throws Exception {
                        if (FileLoadOperation.this.fileInlineObject.isVideo) {
                            MyLog.e("RubioDownload", "RubinoDownload1 video request " + FileLoadOperation.this.isPreloadVideoOperation + " " + (i / FileLoadOperation.this.currentDownloadChunkSize) + " " + FileLoadOperation.this.fileInlineObject.filePath);
                        } else {
                            MyLog.e("RubioDownload", "RubinoDownload1 image request " + (i / FileLoadOperation.this.currentDownloadChunkSize) + " " + FileLoadOperation.this.fileInlineObject.filePath);
                        }
                        MyLog.e("StoryLogPreload44", "Progress request" + FileLoadOperation.this.fileInlineObject.storyId + " FileOffset:" + (i / FileLoadOperation.this.currentDownloadChunkSize) + " isPreload:" + FileLoadOperation.this.isPreloadVideoOperation + " filePath " + FileLoadOperation.this.fileInlineObject.filePath);
                        return ApiRequestMessangerRx.getInstance(FileLoadOperation.this.currentAccount).getFileRubino(FileLoadOperation.this.fileInlineObject.filePath, i, (r2 + r8.currentDownloadChunkSize) - 1);
                    }
                }).subscribeWith(new DisposableObserver<Response<ResponseBody>>() { // from class: ir.appp.rghapp.rubinoPostSlider.FileLoadOperation.2
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(Response<ResponseBody> response) throws IOException {
                        int i12;
                        MyLog.e("StoryLogPreload44", "Progress response" + FileLoadOperation.this.fileInlineObject.storyId + " FileOffset:" + (i / FileLoadOperation.this.currentDownloadChunkSize) + " isPreload:" + FileLoadOperation.this.isPreloadVideoOperation + " filePath " + FileLoadOperation.this.fileInlineObject.filePath);
                        try {
                            if (!FileLoadOperation.this.oneTimeCheckedLenght && (i12 = Integer.parseInt(response.headers().get("total_length"))) != 0) {
                                FileLoadOperation.this.oneTimeCheckedLenght = true;
                                FileLoadOperation fileLoadOperation = FileLoadOperation.this;
                                PhotoViewerObject photoViewerObject = fileLoadOperation.fileInlineObject;
                                if (i12 != photoViewerObject.size) {
                                    photoViewerObject.size = i12;
                                    synchronized (fileLoadOperation.processRequestSyncObject) {
                                        if (FileLoadOperation.this.notRequestedBytesRanges != null) {
                                            Iterator it = FileLoadOperation.this.notRequestedBytesRanges.iterator();
                                            while (it.hasNext()) {
                                                Range range2 = (Range) it.next();
                                                if (range2.end == FileLoadOperation.this.totalBytesCount) {
                                                    range2.end = i12;
                                                }
                                            }
                                        }
                                        if (FileLoadOperation.this.notRequestedBytesRanges != null) {
                                            Iterator it2 = FileLoadOperation.this.notLoadedBytesRanges.iterator();
                                            while (it2.hasNext()) {
                                                Range range3 = (Range) it2.next();
                                                if (range3.end == FileLoadOperation.this.totalBytesCount) {
                                                    range3.end = i12;
                                                }
                                            }
                                        }
                                        if (FileLoadOperation.this.notLoadedBytesRangesCopy != null) {
                                            Iterator it3 = FileLoadOperation.this.notLoadedBytesRangesCopy.iterator();
                                            while (it3.hasNext()) {
                                                Range range4 = (Range) it3.next();
                                                if (range4.end == FileLoadOperation.this.totalBytesCount) {
                                                    range4.end = i12;
                                                }
                                            }
                                        }
                                    }
                                    if (FileLoadOperation.this.notLoadedBytesRanges != null) {
                                        synchronized (FileLoadOperation.this.rangSynObject) {
                                            FileLoadOperation.this.downloadedBytes = i12;
                                            MyLog.e("RubinoDownload", "RubinoDowload downloadedBytes10= " + FileLoadOperation.this.downloadedBytes);
                                            int size2 = FileLoadOperation.this.notLoadedBytesRanges.size();
                                            for (int i13 = 0; i13 < size2; i13++) {
                                                Range range5 = (Range) FileLoadOperation.this.notLoadedBytesRanges.get(i13);
                                                FileLoadOperation.access$1920(FileLoadOperation.this, range5.end - range5.start);
                                                MyLog.e("RubinoDownload", "RubinoDowload downloadedBytes70= " + FileLoadOperation.this.downloadedBytes);
                                            }
                                        }
                                    }
                                    FileLoadOperation.this.totalBytesCount = i12;
                                }
                            }
                        } catch (Exception unused2) {
                        }
                        try {
                            requestInfo.response = new TLRPC$TL_upload_file();
                            requestInfo.response.bytes = FileLoadProxy.getByteBufferOfResult(response.body().bytes());
                            MyLog.e("FileLoadOperation", FileLoadOperation.this.toString() + " state " + FileLoadOperation.this.state);
                            FileLoadOperation.this.processRequestResult(requestInfo, null);
                        } catch (Exception unused3) {
                            FileLoadOperation.this.onFail(true, 0);
                        }
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) throws IOException {
                        FileLoadOperation.this.onFail(true, 0);
                    }
                });
                this.requestsCount++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startDownloadRequest$9(RequestInfo requestInfo) {
        processRequestResult(requestInfo, null);
    }

    public void setDelegate(FileLoadOperationDelegate fileLoadOperationDelegate) {
        this.delegate = fileLoadOperationDelegate;
    }
}

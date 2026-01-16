package ir.resaneh1.iptv.insta;

import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.resaneh1.iptv.apiIPTV.CallbackWithRetry;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.insta.FileLoaderStory;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.messanger.model.InputUploadBigFilePartObject;
import ir.resaneh1.iptv.messanger.model.InputUploadFilePartObject;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.RubinoRequestUploadFileInput;
import ir.resaneh1.iptv.model.RubinoRequestUploadFileOutput;
import ir.resaneh1.iptv.model.RubinoUploadFileOutput;
import ir.resaneh1.iptv.model.StoryObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.Utilities;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class FileUploadOperationStory {
    public String access_hash_rec;
    public String access_hash_send;
    int callingApiCount;
    final int currentAccount;
    private long currentFileId;
    private int currentPartNum;
    private int currentUploadRequetsCount;
    private FileUploadOperationDelegate delegate;
    private int estimatedSize;
    private String fileKey;
    public String file_id;
    private boolean isBigFile;
    public boolean isFileAvailableWithDelay;
    public boolean isVideoPreparedWithDelay;
    private long lastCheckedUploadingSpeedTime;
    private int lastMeasuredSpeedMaxRequestCount;
    private long lastNotifiedProgressTime;
    private SharedPreferences preferences;
    private byte[] readBuffer;
    private long readBytesCount;
    private int requestNum;
    private FileInputStream stream;
    private long totalFileSize;
    private int totalPartsCount;
    public FileLoaderStory.UploadInfo uploadInfo;
    private String uploadUrl;
    private long uploadedBytesCount;
    private long uploadedBytesInMeasureSpeedPeriod;
    private Handler handler = new Handler();
    private UploadingStatus uploadingStatus = UploadingStatus.notStarted;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private long[] delayArray = {1, 3, 5, 10, 20, 20, 20, 20, 20};
    private long lastMeasuredSpeed = 0;
    private final Object startNewUpload = new Object();
    private boolean isIncreasing = true;
    private long BIG_FILE_SIZE = 5242880;
    long availableByte = 0;
    private boolean isFirstPartUploaded = false;
    private boolean isLastPart = false;
    private int maxRequestsCount = 1;
    private int uploadChunkSize = MessagesController.UPDATE_MASK_REORDER;

    public interface FileUploadOperationDelegate {
        void onUploadCompleted(FileUploadOperationStory fileUploadOperationStory);

        void onUploadError(FileUploadOperationStory fileUploadOperationStory);

        void onUploadProgress(FileUploadOperationStory fileUploadOperationStory);

        void onUploadStart(FileUploadOperationStory fileUploadOperationStory);
    }

    enum UploadingStatus {
        notStarted,
        requestingSendFile,
        uploading,
        error,
        done,
        cancled
    }

    static /* synthetic */ int access$1110(FileUploadOperationStory fileUploadOperationStory) {
        int i = fileUploadOperationStory.currentUploadRequetsCount;
        fileUploadOperationStory.currentUploadRequetsCount = i - 1;
        return i;
    }

    static /* synthetic */ int access$412(FileUploadOperationStory fileUploadOperationStory, int i) {
        int i2 = fileUploadOperationStory.maxRequestsCount + i;
        fileUploadOperationStory.maxRequestsCount = i2;
        return i2;
    }

    static /* synthetic */ int access$420(FileUploadOperationStory fileUploadOperationStory, int i) {
        int i2 = fileUploadOperationStory.maxRequestsCount - i;
        fileUploadOperationStory.maxRequestsCount = i2;
        return i2;
    }

    static /* synthetic */ long access$614(FileUploadOperationStory fileUploadOperationStory, long j) {
        long j2 = fileUploadOperationStory.uploadedBytesInMeasureSpeedPeriod + j;
        fileUploadOperationStory.uploadedBytesInMeasureSpeedPeriod = j2;
        return j2;
    }

    static /* synthetic */ long access$714(FileUploadOperationStory fileUploadOperationStory, long j) {
        long j2 = fileUploadOperationStory.uploadedBytesCount + j;
        fileUploadOperationStory.uploadedBytesCount = j2;
        return j2;
    }

    public FileUploadOperationStory(int i, FileLoaderStory.UploadInfo uploadInfo, boolean z) {
        new HashMap();
        new HashMap();
        this.callingApiCount = 0;
        this.uploadInfo = uploadInfo;
        this.isFileAvailableWithDelay = z;
        this.isVideoPreparedWithDelay = z;
        this.currentAccount = i;
    }

    public long getTotalFileSize() {
        return this.totalFileSize;
    }

    public long getUploadedBytesCount() {
        return this.uploadedBytesCount;
    }

    public int getRnd() {
        return this.uploadInfo.rnd;
    }

    public void setDelegate(FileUploadOperationDelegate fileUploadOperationDelegate) {
        this.delegate = fileUploadOperationDelegate;
    }

    public void start() {
        if (this.uploadingStatus != UploadingStatus.notStarted) {
            return;
        }
        this.delegate.onUploadStart(this);
        this.uploadingStatus = UploadingStatus.requestingSendFile;
        this.preferences = ApplicationLoader.applicationContext.getSharedPreferences("uploadinfo", 0);
        requestSendFile();
    }

    public void cancel() {
        this.handler.removeCallbacksAndMessages(null);
        this.delegate.onUploadError(this);
        this.compositeDisposable.dispose();
        this.uploadingStatus = UploadingStatus.cancled;
        cleanup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanup() throws IOException {
        if (this.preferences == null) {
            this.preferences = ApplicationLoader.applicationContext.getSharedPreferences("uploadinfo", 0);
        }
        this.preferences.edit().remove(this.fileKey + "_time").remove(this.fileKey + "_size").remove(this.fileKey + "_uploaded").remove(this.fileKey + "_id").remove(this.fileKey + "_iv").remove(this.fileKey + "_key").remove(this.fileKey + "_ivc").commit();
        try {
            FileInputStream fileInputStream = this.stream;
            if (fileInputStream != null) {
                fileInputStream.close();
                this.stream = null;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void requestSendFile() {
        RubinoRequestUploadFileInput rubinoRequestUploadFileInput = new RubinoRequestUploadFileInput();
        Long lValueOf = Long.valueOf(new File(this.uploadInfo.path).length());
        rubinoRequestUploadFileInput.file_size = lValueOf;
        FileLoaderStory.UploadInfo uploadInfo = this.uploadInfo;
        rubinoRequestUploadFileInput.file_name = uploadInfo.fileName;
        StoryObject.StoryTypeEnum storyTypeEnum = uploadInfo.storyType;
        rubinoRequestUploadFileInput.file_type = storyTypeEnum == StoryObject.StoryTypeEnum.Picture ? RubinoRequestUploadFileInput.FileType.Picture : storyTypeEnum == StoryObject.StoryTypeEnum.Video ? RubinoRequestUploadFileInput.FileType.Video : null;
        if (lValueOf.longValue() > this.BIG_FILE_SIZE) {
            this.maxRequestsCount = 3;
        }
        this.compositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(this.currentAccount).requestSendFileRubino(rubinoRequestUploadFileInput).observeOn(Schedulers.io()).doOnNext(new Consumer<MessangerOutput<RubinoRequestUploadFileOutput>>() { // from class: ir.resaneh1.iptv.insta.FileUploadOperationStory.2
            @Override // io.reactivex.functions.Consumer
            public void accept(MessangerOutput<RubinoRequestUploadFileOutput> messangerOutput) throws Exception {
                if (FileUploadOperationStory.this.uploadingStatus == UploadingStatus.cancled) {
                    return;
                }
                FileUploadOperationStory fileUploadOperationStory = FileUploadOperationStory.this;
                RubinoRequestUploadFileOutput rubinoRequestUploadFileOutput = messangerOutput.data;
                fileUploadOperationStory.access_hash_send = rubinoRequestUploadFileOutput.hash_file_request;
                fileUploadOperationStory.file_id = rubinoRequestUploadFileOutput.file_id;
                fileUploadOperationStory.uploadUrl = rubinoRequestUploadFileOutput.server_url;
                FileUploadOperationStory.this.uploadingStatus = UploadingStatus.uploading;
                FileUploadOperationStory.this.lastCheckedUploadingSpeedTime = System.currentTimeMillis();
                for (int i = 0; i < FileUploadOperationStory.this.maxRequestsCount && FileUploadOperationStory.this.startUploadRequest(); i++) {
                }
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<MessangerOutput<RubinoRequestUploadFileOutput>>() { // from class: ir.resaneh1.iptv.insta.FileUploadOperationStory.1
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<RubinoRequestUploadFileOutput> messangerOutput) {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                FileUploadOperationStory.this.uploadingStatus = UploadingStatus.error;
                FileUploadOperationStory.this.delegate.onUploadError(FileUploadOperationStory.this);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startUploadRequest() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        boolean z = this.isFileAvailableWithDelay;
        if (z && this.availableByte < this.uploadChunkSize * 2) {
            return false;
        }
        if ((z && this.readBytesCount + (this.uploadChunkSize * 2) >= this.availableByte) || this.uploadingStatus != UploadingStatus.uploading) {
            return false;
        }
        try {
            if (this.stream == null) {
                File file = new File(this.uploadInfo.path);
                FileInputStream fileInputStream = new FileInputStream(file);
                this.stream = fileInputStream;
                if (this.isVideoPreparedWithDelay) {
                    fileInputStream.skip(this.uploadChunkSize);
                    this.currentPartNum = 1;
                }
                int i3 = this.estimatedSize;
                if (i3 != 0) {
                    this.totalFileSize = i3;
                } else if (this.isFileAvailableWithDelay) {
                    this.totalFileSize = this.uploadInfo.estimateSize;
                } else {
                    this.totalFileSize = file.length();
                }
                long j = this.totalFileSize;
                if (j > 10485760) {
                    this.isBigFile = true;
                }
                int i4 = this.uploadChunkSize;
                this.totalPartsCount = ((int) ((j + i4) - 1)) / i4;
                this.readBuffer = new byte[i4];
                this.fileKey = Utilities.MD5(this.uploadInfo.path);
                long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                this.uploadedBytesCount = this.readBytesCount;
            }
            if (this.estimatedSize != 0) {
                if (this.readBytesCount + this.uploadChunkSize > this.stream.getChannel().size()) {
                    return false;
                }
            }
            int i5 = this.currentPartNum;
            int i6 = this.totalPartsCount;
            if (i5 >= i6) {
                return false;
            }
            if (i5 == i6 - 1 && this.currentUploadRequetsCount > 0) {
                return false;
            }
            int i7 = this.stream.read(this.readBuffer);
            MyLog.e("currentRequestBytes", "current" + i7);
            if (i7 == -1) {
                return false;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i7 + 0);
            if (i7 != this.uploadChunkSize || (this.estimatedSize == 0 && this.totalPartsCount == this.currentPartNum + 1)) {
                this.isLastPart = true;
            }
            byteBufferAllocate.put(this.readBuffer, 0, i7);
            byteBufferAllocate.rewind();
            if (this.isBigFile) {
                InputUploadBigFilePartObject inputUploadBigFilePartObject = new InputUploadBigFilePartObject();
                i = this.currentPartNum;
                inputUploadBigFilePartObject.file_part = i;
                inputUploadBigFilePartObject.file_id = this.currentFileId;
                if (this.estimatedSize != 0) {
                    inputUploadBigFilePartObject.file_total_parts = -1;
                } else {
                    inputUploadBigFilePartObject.file_total_parts = this.totalPartsCount;
                }
                inputUploadBigFilePartObject.bytes = byteBufferAllocate;
                bArr = this.readBuffer;
                i2 = this.totalPartsCount;
            } else {
                InputUploadFilePartObject inputUploadFilePartObject = new InputUploadFilePartObject();
                i = this.currentPartNum;
                inputUploadFilePartObject.file_part = i;
                inputUploadFilePartObject.file_id = this.currentFileId;
                inputUploadFilePartObject.bytes = byteBufferAllocate;
                bArr = this.readBuffer;
                i2 = this.totalPartsCount;
            }
            int i8 = i2;
            int i9 = i;
            long j2 = i7;
            long j3 = this.readBytesCount + j2;
            this.readBytesCount = j3;
            this.requestNum++;
            this.currentPartNum++;
            if (i9 >= i8) {
                return false;
            }
            this.currentUploadRequetsCount++;
            MyLog.e("byteSize", bArr.length + BuildConfig.FLAVOR);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(this.readBuffer, 0, i7);
            Log.e("UploadingStep", "start upload part_number:" + i9 + " totalPart:" + i8 + "  isLastPart:" + this.isLastPart + " currentUploadRequetsCount" + this.currentUploadRequetsCount + " callingApiCount:" + this.callingApiCount);
            callRequest(0, bArrCopyOfRange, i9, i8, j3, j2);
            return true;
        } catch (Exception e) {
            FileLog.e(e);
            this.delegate.onUploadError(this);
            this.handler.removeCallbacksAndMessages(null);
            cleanup();
            return false;
        }
    }

    void callRequest(final int i, final byte[] bArr, final int i2, int i3, final long j, final long j2) {
        this.callingApiCount++;
        int i4 = this.isFileAvailableWithDelay ? 0 : i3;
        final int i5 = i4;
        ApiRequestMessanger.getInstance(this.currentAccount).instaUploadFile(this.uploadUrl, bArr, i2 + 1, i4, this.access_hash_send, this.file_id + BuildConfig.FLAVOR, new ApiRequestMessanger.Listener2() { // from class: ir.resaneh1.iptv.insta.FileUploadOperationStory.3
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, final Object obj) {
                FileUploadOperationStory fileUploadOperationStory = FileUploadOperationStory.this;
                fileUploadOperationStory.callingApiCount--;
                Observable.just(0).observeOn(Schedulers.io()).subscribe(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.insta.FileUploadOperationStory.3.1
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(Integer num) throws IOException {
                        FileUploadOperationStory fileUploadOperationStory2;
                        boolean z;
                        String str;
                        FileUploadOperationStory.access$614(FileUploadOperationStory.this, bArr.length);
                        RubinoUploadFileOutput rubinoUploadFileOutput = (RubinoUploadFileOutput) obj;
                        if (rubinoUploadFileOutput != null && (str = rubinoUploadFileOutput.hash_file_receive) != null && str.length() != 0) {
                            FileUploadOperationStory.this.access_hash_rec = rubinoUploadFileOutput.hash_file_receive;
                        }
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        FileUploadOperationStory.access$714(FileUploadOperationStory.this, j2);
                        if (System.currentTimeMillis() - FileUploadOperationStory.this.lastNotifiedProgressTime > 400 || FileUploadOperationStory.this.uploadedBytesCount > FileUploadOperationStory.this.totalFileSize - 1000) {
                            FileUploadOperationStory.this.lastNotifiedProgressTime = System.currentTimeMillis();
                            FileUploadOperationStory.this.delegate.onUploadProgress(FileUploadOperationStory.this);
                        }
                        synchronized (FileUploadOperationStory.this.startNewUpload) {
                            FileUploadOperationStory.access$1110(FileUploadOperationStory.this);
                        }
                        long jCurrentTimeMillis = System.currentTimeMillis() - FileUploadOperationStory.this.lastCheckedUploadingSpeedTime;
                        if (jCurrentTimeMillis > 6000) {
                            FileUploadOperationStory.this.lastCheckedUploadingSpeedTime = System.currentTimeMillis();
                            long j3 = FileUploadOperationStory.this.uploadedBytesInMeasureSpeedPeriod;
                            FileUploadOperationStory.this.uploadedBytesInMeasureSpeedPeriod = 0L;
                            long j4 = (j3 * 100) / jCurrentTimeMillis;
                            Log.e("Uploading Speed Measure", " Uploading Speed Measure speed:" + j4 + " for Count:" + FileUploadOperationStory.this.maxRequestsCount);
                            int i6 = FileUploadOperationStory.this.maxRequestsCount;
                            double d = (double) j4;
                            double d2 = (double) FileUploadOperationStory.this.lastMeasuredSpeed;
                            Double.isNaN(d2);
                            if (d > d2 * 1.1d || FileUploadOperationStory.this.maxRequestsCount == 1) {
                                if (!FileUploadOperationStory.this.isIncreasing && FileUploadOperationStory.this.maxRequestsCount != 1) {
                                    FileUploadOperationStory.this.isIncreasing = false;
                                    FileUploadOperationStory.access$420(FileUploadOperationStory.this, 2);
                                } else {
                                    FileUploadOperationStory.access$412(FileUploadOperationStory.this, 2);
                                    FileUploadOperationStory.this.isIncreasing = true;
                                }
                                FileUploadOperationStory.this.lastMeasuredSpeed = j4;
                                FileUploadOperationStory.this.lastMeasuredSpeedMaxRequestCount = i6;
                            } else {
                                double d3 = FileUploadOperationStory.this.lastMeasuredSpeed;
                                Double.isNaN(d3);
                                if (d < d3 * 0.9d) {
                                    if (FileUploadOperationStory.this.isIncreasing) {
                                        FileUploadOperationStory.this.isIncreasing = false;
                                        FileUploadOperationStory.access$420(FileUploadOperationStory.this, 2);
                                    } else {
                                        FileUploadOperationStory.this.isIncreasing = true;
                                        FileUploadOperationStory.access$412(FileUploadOperationStory.this, 2);
                                    }
                                    FileUploadOperationStory.this.lastMeasuredSpeed = j4;
                                    FileUploadOperationStory fileUploadOperationStory3 = FileUploadOperationStory.this;
                                    fileUploadOperationStory3.lastMeasuredSpeedMaxRequestCount = fileUploadOperationStory3.maxRequestsCount;
                                } else {
                                    FileUploadOperationStory.this.isIncreasing = true;
                                    FileUploadOperationStory.this.lastMeasuredSpeed = j4;
                                }
                            }
                            if (FileUploadOperationStory.this.maxRequestsCount < 0) {
                                FileUploadOperationStory.this.maxRequestsCount = 1;
                            }
                            if (FileUploadOperationStory.this.maxRequestsCount > 16) {
                                FileUploadOperationStory.this.maxRequestsCount = 16;
                            }
                            Log.e("Uploading Speed Measure", " Uploading Speed Measure maxRequestCountChanged:" + FileUploadOperationStory.this.maxRequestsCount);
                        }
                        if (FileUploadOperationStory.this.isLastPart && FileUploadOperationStory.this.currentUploadRequetsCount <= 0) {
                            FileUploadOperationStory fileUploadOperationStory4 = FileUploadOperationStory.this;
                            if (fileUploadOperationStory4.access_hash_rec != null && fileUploadOperationStory4.uploadingStatus == UploadingStatus.uploading && (!(z = (fileUploadOperationStory2 = FileUploadOperationStory.this).isVideoPreparedWithDelay) || (z && fileUploadOperationStory2.isFirstPartUploaded))) {
                                FileUploadOperationStory.this.uploadingStatus = UploadingStatus.done;
                                FileUploadOperationStory.this.delegate.onUploadCompleted(FileUploadOperationStory.this);
                                FileUploadOperationStory.this.cleanup();
                                return;
                            }
                        }
                        if (FileUploadOperationStory.this.currentUploadRequetsCount < FileUploadOperationStory.this.maxRequestsCount) {
                            Log.e("Uploading", "currentUploadRequetsCount:" + FileUploadOperationStory.this.currentUploadRequetsCount + " " + FileUploadOperationStory.this.maxRequestsCount);
                            FileUploadOperationStory.this.startUploadIfNeeded();
                        }
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                        MyLog.handleException(th);
                    }
                });
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) throws IOException {
                r2.callingApiCount--;
                FileUploadOperationStory.access$1110(FileUploadOperationStory.this);
                FileUploadOperationStory.this.uploadingStatus = UploadingStatus.error;
                FileUploadOperationStory.this.delegate.onUploadError(FileUploadOperationStory.this);
                FileUploadOperationStory.this.handler.removeCallbacksAndMessages(null);
                FileUploadOperationStory.this.cleanup();
                FileUploadOperationStory.this.compositeDisposable.dispose();
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener2
            public void onFailure(CallbackWithRetry callbackWithRetry, Throwable th) throws IOException {
                FileUploadOperationStory fileUploadOperationStory = FileUploadOperationStory.this;
                fileUploadOperationStory.callingApiCount--;
                if (i < (MyLog.isDebugAble ? 0 : 5)) {
                    CompositeDisposable compositeDisposable = fileUploadOperationStory.compositeDisposable;
                    Observable observableJust = Observable.just(0);
                    double d = FileUploadOperationStory.this.delayArray[i] * 1000;
                    double dRandom = Math.random() * 200.0d;
                    Double.isNaN(d);
                    compositeDisposable.add((Disposable) observableJust.delay((int) (d + dRandom), TimeUnit.MILLISECONDS).observeOn(Schedulers.io()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.insta.FileUploadOperationStory.3.2
                        @Override // io.reactivex.Observer
                        public void onComplete() {
                        }

                        @Override // io.reactivex.Observer
                        public void onError(Throwable th2) {
                        }

                        @Override // io.reactivex.Observer
                        public void onNext(Integer num) {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            FileUploadOperationStory.this.callRequest(i + 1, bArr, i2, i5, j, j2);
                        }
                    }));
                    return;
                }
                FileUploadOperationStory.access$1110(fileUploadOperationStory);
                FileUploadOperationStory.this.uploadingStatus = UploadingStatus.error;
                FileUploadOperationStory.this.delegate.onUploadError(FileUploadOperationStory.this);
                FileUploadOperationStory.this.handler.removeCallbacksAndMessages(null);
                FileUploadOperationStory.this.cleanup();
                FileUploadOperationStory.this.compositeDisposable.dispose();
            }
        });
    }

    public void startUploadIfNeeded() {
        synchronized (this.startNewUpload) {
            for (int i = this.currentUploadRequetsCount; i < this.maxRequestsCount && startUploadRequest(); i++) {
            }
        }
    }
}

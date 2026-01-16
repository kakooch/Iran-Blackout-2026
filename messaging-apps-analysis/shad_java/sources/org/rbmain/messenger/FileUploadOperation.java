package org.rbmain.messenger;

import android.content.SharedPreferences;
import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.NativeByteBuffer;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$InputEncryptedFile;
import org.rbmain.tgnet.TLRPC$InputFile;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_upload_saveBigFilePart;
import org.rbmain.tgnet.TLRPC$TL_upload_saveFilePart;

/* loaded from: classes4.dex */
public class FileUploadOperation {
    private static final int initialRequestsCount = 8;
    private static final int initialRequestsSlowNetworkCount = 1;
    private static final int maxUploadParts = 4000;
    private static final int maxUploadingKBytes = 2048;
    private static final int maxUploadingSlowNetworkKBytes = 32;
    private static final int minUploadChunkSize = 128;
    private static final int minUploadChunkSlowNetworkSize = 32;
    private String access_hash_rec;
    private final String access_hash_send;
    private long availableSize;
    private int currentAccount;
    private long currentFileId;
    private int currentPartNum;
    private int currentType;
    private int currentUploadRequetsCount;
    private final String dc_id;
    private FileUploadOperationDelegate delegate;
    private int estimatedSize;
    private String fileKey;
    private int fingerprint;
    private boolean forceSmallFile;
    private ArrayList<byte[]> freeRequestIvs;
    private boolean isBigFile;
    private boolean isEncrypted;
    private boolean isLastPart;
    private byte[] iv;
    private byte[] ivChange;
    private byte[] key;
    private long lastCheckedUploadingSpeedTime;
    protected long lastProgressUpdateTime;
    private int lastSavedPartNum;
    private boolean nextPartFirst;
    private int operationGuid;
    private SharedPreferences preferences;
    private byte[] readBuffer;
    private long readBytesCount;
    private int requestNum;
    private int saveInfoTimes;
    private boolean slowNetwork;
    private boolean started;
    private int state;
    private RandomAccessFile stream;
    private long totalFileSize;
    private int totalPartsCount;
    private boolean uploadFirstPartLater;
    private int uploadStartTime;
    private long uploadedBytesCount;
    private long uploadedBytesInMeasureSpeedPeriod;
    private String uploadingFilePath;
    private final String url;
    private int maxRequestsCount = 16;
    private long lastMeasuredSpeed = 0;
    private boolean isIncreasing = true;
    private int uploadChunkSize = MessagesController.UPDATE_MASK_REORDER;
    private SparseIntArray requestTokens = new SparseIntArray();
    private SparseArray<UploadCachedResult> cachedResults = new SparseArray<>();

    public interface FileUploadOperationDelegate {
        void didChangedUploadProgress(FileUploadOperation fileUploadOperation, long j, long j2);

        void didFailedUploadingFile(FileUploadOperation fileUploadOperation);

        void didFinishUploadingFile(FileUploadOperation fileUploadOperation, TLRPC$InputFile tLRPC$InputFile, TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile, byte[] bArr, byte[] bArr2);
    }

    private void storeFileUploadInfo() {
    }

    private static class UploadCachedResult {
        private long bytesOffset;
        private byte[] iv;

        private UploadCachedResult() {
        }
    }

    public FileUploadOperation(int i, String str, boolean z, int i2, int i3, String str2, String str3, String str4, String str5) {
        this.currentAccount = i;
        this.uploadingFilePath = str;
        this.isEncrypted = z;
        this.estimatedSize = i2;
        this.currentType = i3;
        this.uploadFirstPartLater = (i2 == 0 || z) ? false : true;
        this.currentFileId = Long.parseLong(str2);
        this.url = str3;
        this.access_hash_send = str4;
        this.dc_id = str5;
    }

    public long getTotalFileSize() {
        return this.totalFileSize;
    }

    public void setDelegate(FileUploadOperationDelegate fileUploadOperationDelegate) {
        this.delegate = fileUploadOperationDelegate;
    }

    public void start() {
        if (this.state != 0) {
            return;
        }
        this.state = 1;
        Utilities.fileQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileUploadOperation$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f$0.lambda$start$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$0() throws Exception {
        this.preferences = ApplicationLoader.applicationContext.getSharedPreferences("uploadinfo", 0);
        this.slowNetwork = false;
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("start upload on slow network = " + this.slowNetwork);
        }
        int i = this.slowNetwork ? 1 : 8;
        for (int i2 = 0; i2 < i; i2++) {
            startUploadRequest();
        }
    }

    protected void onNetworkChanged(final boolean z) {
        if (this.state != 1) {
            return;
        }
        Utilities.fileQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileUploadOperation$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f$0.lambda$onNetworkChanged$1(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onNetworkChanged$1(boolean z) throws Exception {
        if (this.slowNetwork != z) {
            this.slowNetwork = false;
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("network changed to slow = " + this.slowNetwork);
            }
            int i = 0;
            while (true) {
                if (i >= this.requestTokens.size()) {
                    break;
                }
                ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.requestTokens.valueAt(i), true);
                i++;
            }
            this.requestTokens.clear();
            cleanup();
            this.isLastPart = false;
            this.nextPartFirst = false;
            this.requestNum = 0;
            this.currentPartNum = 0;
            this.readBytesCount = 0L;
            this.uploadedBytesCount = 0L;
            this.saveInfoTimes = 0;
            this.key = null;
            this.iv = null;
            this.ivChange = null;
            this.currentUploadRequetsCount = 0;
            this.lastSavedPartNum = 0;
            this.uploadFirstPartLater = false;
            this.cachedResults.clear();
            this.operationGuid++;
            int i2 = this.slowNetwork ? 1 : 8;
            for (int i3 = 0; i3 < i2; i3++) {
                startUploadRequest();
            }
        }
    }

    public void cancel() {
        if (this.state == 3) {
            return;
        }
        this.state = 2;
        Utilities.fileQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileUploadOperation$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cancel$2();
            }
        });
        this.delegate.didFailedUploadingFile(this);
        cleanup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancel$2() {
        for (int i = 0; i < this.requestTokens.size(); i++) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.requestTokens.valueAt(i), true);
        }
    }

    private void cleanup() throws IOException {
        if (this.preferences == null) {
            this.preferences = ApplicationLoader.applicationContext.getSharedPreferences("uploadinfo", 0);
        }
        this.preferences.edit().remove(this.fileKey + "_time").remove(this.fileKey + "_size").remove(this.fileKey + "_uploaded").remove(this.fileKey + "_id").remove(this.fileKey + "_iv").remove(this.fileKey + "_key").remove(this.fileKey + "_ivc").apply();
        try {
            RandomAccessFile randomAccessFile = this.stream;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                this.stream = null;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    protected void checkNewDataAvailable(final long j, final long j2) {
        Utilities.fileQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileUploadOperation$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f$0.lambda$checkNewDataAvailable$3(j2, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkNewDataAvailable$3(long j, long j2) throws Exception {
        if (this.estimatedSize != 0 && j != 0) {
            this.estimatedSize = 0;
            this.totalFileSize = j;
            calcTotalPartsCount();
            if (!this.uploadFirstPartLater && this.started) {
                storeFileUploadInfo();
            }
        }
        if (j <= 0) {
            j = j2;
        }
        this.availableSize = j;
        if (this.currentUploadRequetsCount < this.maxRequestsCount) {
            startUploadRequest();
        }
    }

    private void calcTotalPartsCount() {
        if (this.uploadFirstPartLater) {
            if (this.isBigFile) {
                long j = this.totalFileSize;
                int i = this.uploadChunkSize;
                this.totalPartsCount = (((int) (((j - i) + i) - 1)) / i) + 1;
                return;
            } else {
                long j2 = this.totalFileSize - 1024;
                int i2 = this.uploadChunkSize;
                this.totalPartsCount = (((int) ((j2 + i2) - 1)) / i2) + 1;
                return;
            }
        }
        long j3 = this.totalFileSize;
        int i3 = this.uploadChunkSize;
        this.totalPartsCount = ((int) ((j3 + i3) - 1)) / i3;
    }

    public void setForceSmallFile() {
        this.forceSmallFile = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void startUploadRequest() throws Exception {
        int i;
        byte[] bArr;
        final int i2;
        TLRPC$TL_upload_saveFilePart tLRPC$TL_upload_saveFilePart;
        int i3;
        int i4;
        boolean zIsInternalUri;
        if (this.state != 1) {
            return;
        }
        try {
            this.started = true;
            if (this.stream == null) {
                File file = new File(this.uploadingFilePath);
                if (AndroidUtilities.isInternalUri(Uri.fromFile(file))) {
                    throw new Exception("trying to upload internal file");
                }
                this.stream = new RandomAccessFile(file, "r");
                try {
                    zIsInternalUri = AndroidUtilities.isInternalUri(((Integer) FileDescriptor.class.getDeclaredMethod("getInt$", new Class[0]).invoke(this.stream.getFD(), new Object[0])).intValue());
                } catch (Throwable th) {
                    FileLog.e(th);
                    zIsInternalUri = false;
                }
                if (zIsInternalUri) {
                    throw new Exception("trying to upload internal file");
                }
                int i5 = this.estimatedSize;
                if (i5 != 0) {
                    this.totalFileSize = i5;
                } else {
                    this.totalFileSize = file.length();
                }
                if (!this.forceSmallFile && this.totalFileSize > 10485760) {
                    this.isBigFile = true;
                }
                int iMax = (int) Math.max(this.slowNetwork ? 32L : 128L, ((this.totalFileSize + 4096000) - 1) / 4096000);
                this.uploadChunkSize = iMax;
                if (1024 % iMax != 0) {
                    int i6 = 64;
                    while (this.uploadChunkSize > i6) {
                        i6 *= 2;
                    }
                    this.uploadChunkSize = i6;
                }
                if (this.isEncrypted) {
                    this.freeRequestIvs = new ArrayList<>(this.maxRequestsCount);
                    for (int i7 = 0; i7 < this.maxRequestsCount; i7++) {
                        this.freeRequestIvs.add(new byte[32]);
                    }
                }
                this.uploadChunkSize *= 1024;
                calcTotalPartsCount();
                this.readBuffer = new byte[this.uploadChunkSize];
                StringBuilder sb = new StringBuilder();
                sb.append(this.uploadingFilePath);
                sb.append(this.isEncrypted ? "enc" : io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                this.fileKey = Utilities.MD5(sb.toString());
                this.uploadStartTime = (int) (System.currentTimeMillis() / 1000);
                if (this.isEncrypted) {
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                        byte[] bArr2 = new byte[64];
                        System.arraycopy(this.key, 0, bArr2, 0, 32);
                        System.arraycopy(this.iv, 0, bArr2, 32, 32);
                        byte[] bArrDigest = messageDigest.digest(bArr2);
                        for (int i8 = 0; i8 < 4; i8++) {
                            this.fingerprint |= ((bArrDigest[i8] ^ bArrDigest[i8 + 4]) & 255) << (i8 * 8);
                        }
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                }
                this.uploadedBytesCount = this.readBytesCount;
                this.lastSavedPartNum = this.currentPartNum;
                if (this.uploadFirstPartLater) {
                    if (this.isBigFile) {
                        this.stream.seek(this.uploadChunkSize);
                        this.readBytesCount = this.uploadChunkSize;
                    } else {
                        this.stream.seek(1024L);
                        this.readBytesCount = 1024L;
                    }
                    this.currentPartNum = 1;
                }
            }
            if (this.estimatedSize == 0 || this.readBytesCount + this.uploadChunkSize <= this.availableSize) {
                if (this.nextPartFirst) {
                    this.stream.seek(0L);
                    if (this.isBigFile) {
                        i = this.stream.read(this.readBuffer);
                    } else {
                        i = this.stream.read(this.readBuffer, 0, 1024);
                    }
                    this.currentPartNum = 0;
                } else {
                    i = this.stream.read(this.readBuffer);
                }
                final int i9 = i;
                if (i9 == -1) {
                    return;
                }
                int i10 = (!this.isEncrypted || i9 % 16 == 0) ? 0 : (16 - (i9 % 16)) + 0;
                int i11 = i9 + i10;
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(i11);
                if (this.nextPartFirst || i9 != this.uploadChunkSize || (this.estimatedSize == 0 && this.totalPartsCount == this.currentPartNum + 1)) {
                    if (this.uploadFirstPartLater) {
                        this.nextPartFirst = true;
                        this.uploadFirstPartLater = false;
                    } else {
                        this.isLastPart = true;
                    }
                }
                nativeByteBuffer.writeBytes(this.readBuffer, 0, i9);
                if (this.isEncrypted) {
                    for (int i12 = 0; i12 < i10; i12++) {
                        nativeByteBuffer.writeByte(0);
                    }
                    Utilities.aesIgeEncryption(nativeByteBuffer.buffer, this.key, this.ivChange, true, true, 0, i11);
                    bArr = this.freeRequestIvs.get(0);
                    System.arraycopy(this.ivChange, 0, bArr, 0, 32);
                    this.freeRequestIvs.remove(0);
                } else {
                    bArr = null;
                }
                final byte[] bArr3 = bArr;
                if (this.isBigFile) {
                    TLRPC$TL_upload_saveBigFilePart tLRPC$TL_upload_saveBigFilePart = new TLRPC$TL_upload_saveBigFilePart();
                    int i13 = this.currentPartNum;
                    tLRPC$TL_upload_saveBigFilePart.file_part = i13;
                    tLRPC$TL_upload_saveBigFilePart.file_id = this.currentFileId;
                    if (this.estimatedSize != 0) {
                        tLRPC$TL_upload_saveBigFilePart.file_total_parts = -1;
                    } else {
                        tLRPC$TL_upload_saveBigFilePart.file_total_parts = this.totalPartsCount;
                    }
                    tLRPC$TL_upload_saveBigFilePart.bytes = nativeByteBuffer;
                    i2 = i13;
                    tLRPC$TL_upload_saveFilePart = tLRPC$TL_upload_saveBigFilePart;
                } else {
                    TLRPC$TL_upload_saveFilePart tLRPC$TL_upload_saveFilePart2 = new TLRPC$TL_upload_saveFilePart();
                    int i14 = this.currentPartNum;
                    tLRPC$TL_upload_saveFilePart2.file_part = i14;
                    tLRPC$TL_upload_saveFilePart2.file_id = this.currentFileId;
                    tLRPC$TL_upload_saveFilePart2.bytes = nativeByteBuffer;
                    i2 = i14;
                    tLRPC$TL_upload_saveFilePart = tLRPC$TL_upload_saveFilePart2;
                }
                if (this.isLastPart && this.nextPartFirst) {
                    this.nextPartFirst = false;
                    this.currentPartNum = this.totalPartsCount - 1;
                    this.stream.seek(this.totalFileSize);
                }
                this.readBytesCount += i9;
                this.currentPartNum++;
                this.currentUploadRequetsCount++;
                final int i15 = this.requestNum;
                this.requestNum = i15 + 1;
                final long j = i2 + i9;
                final int objectSize = tLRPC$TL_upload_saveFilePart.getObjectSize() + 4;
                final int i16 = this.operationGuid;
                if (!this.slowNetwork) {
                    int i17 = i15 % 4;
                }
                if (tLRPC$TL_upload_saveFilePart instanceof TLRPC$TL_upload_saveFilePart) {
                    i4 = tLRPC$TL_upload_saveFilePart.file_part;
                    i3 = this.totalPartsCount;
                } else {
                    TLRPC$TL_upload_saveBigFilePart tLRPC$TL_upload_saveBigFilePart2 = (TLRPC$TL_upload_saveBigFilePart) tLRPC$TL_upload_saveFilePart;
                    int i18 = tLRPC$TL_upload_saveBigFilePart2.file_part;
                    i3 = tLRPC$TL_upload_saveBigFilePart2.file_total_parts;
                    i4 = i18;
                }
                final byte[] bArrCopyOfRange = Arrays.copyOfRange(this.readBuffer, 0, i9);
                tLRPC$TL_upload_saveFilePart.disableFree = false;
                tLRPC$TL_upload_saveFilePart.freeResources();
                this.requestTokens.put(i15, AccountInstance.getInstance(this.currentAccount).getFileProxy().uploadFile(this.url, bArrCopyOfRange, i4, i3, this.access_hash_send, String.valueOf(this.currentFileId), new RequestDelegate() { // from class: org.rbmain.messenger.FileUploadOperation$$ExternalSyntheticLambda4
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) throws Exception {
                        this.f$0.lambda$startUploadRequest$4(bArrCopyOfRange, i16, objectSize, bArr3, i15, i9, i2, j, tLObject, tLRPC$TL_error);
                    }
                }));
            }
        } catch (Exception e2) {
            FileLog.e(e2);
            this.state = 4;
            this.delegate.didFailedUploadingFile(this);
            cleanup();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$startUploadRequest$4(byte[] r20, int r21, int r22, byte[] r23, int r24, int r25, int r26, long r27, org.rbmain.tgnet.TLObject r29, org.rbmain.tgnet.TLRPC$TL_error r30) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 826
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.FileUploadOperation.lambda$startUploadRequest$4(byte[], int, int, byte[], int, int, int, long, org.rbmain.tgnet.TLObject, org.rbmain.tgnet.TLRPC$TL_error):void");
    }
}

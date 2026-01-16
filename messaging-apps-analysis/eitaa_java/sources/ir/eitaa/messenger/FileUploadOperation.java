package ir.eitaa.messenger;

import android.content.SharedPreferences;
import android.util.SparseArray;
import android.util.SparseIntArray;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$InputEncryptedFile;
import ir.eitaa.tgnet.TLRPC$InputFile;
import ir.eitaa.tgnet.TLRPC$TL_boolTrue;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputFile;
import ir.eitaa.tgnet.TLRPC$TL_inputFileBig;
import ir.eitaa.ui.Components.AlertsCreator;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FileUploadOperation {
    private static final int initialRequestsCount = 8;
    private static final int initialRequestsSlowNetworkCount = 1;
    private static final int maxUploadParts = 4000;
    private static final int maxUploadingKBytes = 2048;
    private static final int maxUploadingSlowNetworkKBytes = 32;
    private static final int minUploadChunkSize = 128;
    private static final int minUploadChunkSlowNetworkSize = 32;
    private long availableSize;
    private int currentAccount;
    private long currentFileId;
    private int currentPartNum;
    private int currentType;
    private int currentUploadRequetsCount;
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
    protected long lastProgressUpdateTime;
    private int lastSavedPartNum;
    private int maxRequestsCount;
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
    private String uploadingFilePath;
    private int uploadChunkSize = 65536;
    private SparseIntArray requestTokens = new SparseIntArray();
    private SparseArray<UploadCachedResult> cachedResults = new SparseArray<>();

    public interface FileUploadOperationDelegate {
        void didChangedUploadProgress(FileUploadOperation operation, long uploadedSize, long totalSize);

        void didFailedUploadingFile(FileUploadOperation operation);

        void didFinishUploadingFile(FileUploadOperation operation, TLRPC$InputFile inputFile, TLRPC$InputEncryptedFile inputEncryptedFile, byte[] key, byte[] iv);
    }

    private static class UploadCachedResult {
        private long bytesOffset;
        private byte[] iv;

        private UploadCachedResult() {
        }
    }

    public FileUploadOperation(int instance, String location, boolean encrypted, int estimated, int type) {
        this.currentAccount = instance;
        this.uploadingFilePath = location;
        this.isEncrypted = encrypted;
        this.estimatedSize = estimated;
        this.currentType = type;
        this.uploadFirstPartLater = (estimated == 0 || encrypted) ? false : true;
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
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileUploadOperation$4n04LooKauacPzWWwXCov5f-7-8
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f$0.lambda$start$0$FileUploadOperation();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$start$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$start$0$FileUploadOperation() throws Exception {
        this.preferences = ApplicationLoader.applicationContext.getSharedPreferences("uploadinfo", 0);
        this.slowNetwork = ApplicationLoader.isConnectionSlow();
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("start upload on slow network = " + this.slowNetwork);
        }
        int i = this.slowNetwork ? 1 : 8;
        for (int i2 = 0; i2 < i; i2++) {
            startUploadRequest();
        }
    }

    protected void onNetworkChanged(final boolean slow) {
        if (this.state != 1) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileUploadOperation$vVcOzvBQaQcuN3m4-WrJlL-9l2s
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f$0.lambda$onNetworkChanged$1$FileUploadOperation(slow);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onNetworkChanged$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onNetworkChanged$1$FileUploadOperation(boolean z) throws Exception {
        if (this.slowNetwork != z) {
            this.slowNetwork = z;
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
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileUploadOperation$oWRxzlI7zIxQd-gyOB17EGjQ83E
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cancel$2$FileUploadOperation();
            }
        });
        this.delegate.didFailedUploadingFile(this);
        cleanup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cancel$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$cancel$2$FileUploadOperation() {
        for (int i = 0; i < this.requestTokens.size(); i++) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.requestTokens.valueAt(i), true);
        }
    }

    private void cleanup() throws IOException {
        if (this.preferences == null) {
            this.preferences = ApplicationLoader.applicationContext.getSharedPreferences("uploadinfo", 0);
        }
        this.preferences.edit().remove(this.fileKey + "_time").remove(this.fileKey + "_size").remove(this.fileKey + "_uploaded").remove(this.fileKey + "_id").remove(this.fileKey + "_iv").remove(this.fileKey + "_key").remove(this.fileKey + "_ivc").commit();
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

    protected void checkNewDataAvailable(final long newAvailableSize, final long finalSize) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileUploadOperation$BzmNpYZ-3EZbKxNJFdBUZKtL2w8
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f$0.lambda$checkNewDataAvailable$3$FileUploadOperation(finalSize, newAvailableSize);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkNewDataAvailable$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkNewDataAvailable$3$FileUploadOperation(long j, long j2) throws Exception {
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

    private void storeFileUploadInfo() {
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        editorEdit.putInt(this.fileKey + "_time", this.uploadStartTime);
        editorEdit.putLong(this.fileKey + "_size", this.totalFileSize);
        editorEdit.putLong(this.fileKey + "_id", this.currentFileId);
        editorEdit.remove(this.fileKey + "_uploaded");
        if (this.isEncrypted) {
            editorEdit.putString(this.fileKey + "_iv", Utilities.bytesToHex(this.iv));
            editorEdit.putString(this.fileKey + "_ivc", Utilities.bytesToHex(this.ivChange));
            editorEdit.putString(this.fileKey + "_key", Utilities.bytesToHex(this.key));
        }
        editorEdit.commit();
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
    /* JADX WARN: Removed duplicated region for block: B:117:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02ac A[Catch: Exception -> 0x047d, TryCatch #1 {Exception -> 0x047d, blocks: (B:6:0x0009, B:8:0x0014, B:11:0x0027, B:17:0x0058, B:21:0x0069, B:22:0x006b, B:26:0x0074, B:29:0x008b, B:31:0x008f, B:32:0x0092, B:33:0x0094, B:37:0x009f, B:39:0x00ac, B:40:0x00b6, B:42:0x00ba, B:43:0x00c4, B:47:0x00e6, B:49:0x011a, B:51:0x011e, B:53:0x0122, B:55:0x0128, B:57:0x017a, B:60:0x01b0, B:63:0x01c2, B:65:0x01c5, B:67:0x01c8, B:72:0x01d7, B:74:0x01db, B:84:0x01fb, B:87:0x0208, B:89:0x0213, B:91:0x021f, B:93:0x0223, B:95:0x022a, B:97:0x0235, B:100:0x023e, B:104:0x024a, B:105:0x0250, B:106:0x0267, B:99:0x023c, B:107:0x026d, B:109:0x0276, B:111:0x0291, B:113:0x0299, B:115:0x029c, B:116:0x02a3, B:119:0x02ac, B:121:0x02b0, B:122:0x02cf, B:124:0x02db, B:126:0x02df, B:128:0x02e3, B:129:0x02e6, B:137:0x031b, B:139:0x0327, B:141:0x032b, B:143:0x0342, B:142:0x0339, B:136:0x0318, B:78:0x01e7, B:144:0x0345, B:145:0x034a, B:15:0x0052, B:146:0x034b, B:147:0x0350, B:148:0x0351, B:150:0x0355, B:153:0x0362, B:155:0x0366, B:157:0x0371, B:159:0x0384, B:164:0x0394, B:166:0x0398, B:168:0x039c, B:170:0x03a3, B:172:0x03ae, B:174:0x03b2, B:176:0x03b6, B:182:0x03c8, B:184:0x03cd, B:186:0x03de, B:188:0x03e5, B:190:0x0405, B:192:0x0409, B:194:0x040d, B:195:0x041b, B:187:0x03e1, B:189:0x03ef, B:178:0x03bd, B:180:0x03c1, B:181:0x03c6, B:158:0x037a, B:160:0x0387, B:12:0x0030, B:131:0x02ea, B:133:0x0303), top: B:211:0x0009, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0327 A[Catch: Exception -> 0x047d, TryCatch #1 {Exception -> 0x047d, blocks: (B:6:0x0009, B:8:0x0014, B:11:0x0027, B:17:0x0058, B:21:0x0069, B:22:0x006b, B:26:0x0074, B:29:0x008b, B:31:0x008f, B:32:0x0092, B:33:0x0094, B:37:0x009f, B:39:0x00ac, B:40:0x00b6, B:42:0x00ba, B:43:0x00c4, B:47:0x00e6, B:49:0x011a, B:51:0x011e, B:53:0x0122, B:55:0x0128, B:57:0x017a, B:60:0x01b0, B:63:0x01c2, B:65:0x01c5, B:67:0x01c8, B:72:0x01d7, B:74:0x01db, B:84:0x01fb, B:87:0x0208, B:89:0x0213, B:91:0x021f, B:93:0x0223, B:95:0x022a, B:97:0x0235, B:100:0x023e, B:104:0x024a, B:105:0x0250, B:106:0x0267, B:99:0x023c, B:107:0x026d, B:109:0x0276, B:111:0x0291, B:113:0x0299, B:115:0x029c, B:116:0x02a3, B:119:0x02ac, B:121:0x02b0, B:122:0x02cf, B:124:0x02db, B:126:0x02df, B:128:0x02e3, B:129:0x02e6, B:137:0x031b, B:139:0x0327, B:141:0x032b, B:143:0x0342, B:142:0x0339, B:136:0x0318, B:78:0x01e7, B:144:0x0345, B:145:0x034a, B:15:0x0052, B:146:0x034b, B:147:0x0350, B:148:0x0351, B:150:0x0355, B:153:0x0362, B:155:0x0366, B:157:0x0371, B:159:0x0384, B:164:0x0394, B:166:0x0398, B:168:0x039c, B:170:0x03a3, B:172:0x03ae, B:174:0x03b2, B:176:0x03b6, B:182:0x03c8, B:184:0x03cd, B:186:0x03de, B:188:0x03e5, B:190:0x0405, B:192:0x0409, B:194:0x040d, B:195:0x041b, B:187:0x03e1, B:189:0x03ef, B:178:0x03bd, B:180:0x03c1, B:181:0x03c6, B:158:0x037a, B:160:0x0387, B:12:0x0030, B:131:0x02ea, B:133:0x0303), top: B:211:0x0009, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d5 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void startUploadRequest() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1164
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.FileUploadOperation.startUploadRequest():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startUploadRequest$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startUploadRequest$4$FileUploadOperation(int i, int i2, byte[] bArr, int i3, int i4, int i5, long j, TLObject tLObject, TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) throws Exception {
        long jMax;
        TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile;
        TLRPC$InputFile tLRPC$TL_inputFile;
        byte[] bArr2 = bArr;
        if (i != this.operationGuid) {
            return;
        }
        int currentNetworkType = tLObject2 != null ? tLObject2.networkType : ApplicationLoader.getCurrentNetworkType();
        int i6 = this.currentType;
        if (i6 == 50331648) {
            StatsController.getInstance(this.currentAccount).incrementSentBytesCount(currentNetworkType, 3, i2);
        } else if (i6 == 33554432) {
            StatsController.getInstance(this.currentAccount).incrementSentBytesCount(currentNetworkType, 2, i2);
        } else if (i6 == 16777216) {
            StatsController.getInstance(this.currentAccount).incrementSentBytesCount(currentNetworkType, 4, i2);
        } else if (i6 == 67108864) {
            StatsController.getInstance(this.currentAccount).incrementSentBytesCount(currentNetworkType, 5, i2);
        }
        if (bArr2 != null) {
            this.freeRequestIvs.add(bArr2);
        }
        this.requestTokens.delete(i3);
        if (tLObject2 instanceof TLRPC$TL_boolTrue) {
            if (this.state != 1) {
                return;
            }
            this.uploadedBytesCount += i4;
            int i7 = this.estimatedSize;
            if (i7 != 0) {
                jMax = Math.max(this.availableSize, i7);
            } else {
                jMax = this.totalFileSize;
            }
            this.delegate.didChangedUploadProgress(this, this.uploadedBytesCount, jMax);
            int i8 = this.currentUploadRequetsCount - 1;
            this.currentUploadRequetsCount = i8;
            if (this.isLastPart && i8 == 0 && this.state == 1) {
                this.state = 3;
                if (this.key == null) {
                    if (this.isBigFile) {
                        tLRPC$TL_inputFile = new TLRPC$TL_inputFileBig();
                    } else {
                        tLRPC$TL_inputFile = new TLRPC$TL_inputFile();
                        tLRPC$TL_inputFile.md5_checksum = "";
                    }
                    tLRPC$TL_inputFile.parts = this.currentPartNum;
                    tLRPC$TL_inputFile.id = this.currentFileId;
                    String str = this.uploadingFilePath;
                    tLRPC$TL_inputFile.name = str.substring(str.lastIndexOf("/") + 1);
                    this.delegate.didFinishUploadingFile(this, tLRPC$TL_inputFile, null, null, null);
                    cleanup();
                } else {
                    if (this.isBigFile) {
                        tLRPC$InputEncryptedFile = new TLRPC$InputEncryptedFile() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputEncryptedFileBigUploaded
                            public static int constructor = 767652808;

                            @Override // ir.eitaa.tgnet.TLObject
                            public void readParams(AbstractSerializedData stream, boolean exception) {
                                this.id = stream.readInt64(exception);
                                this.parts = stream.readInt32(exception);
                                this.key_fingerprint = stream.readInt32(exception);
                            }

                            @Override // ir.eitaa.tgnet.TLObject
                            public void serializeToStream(AbstractSerializedData stream) {
                                stream.writeInt32(constructor);
                                stream.writeInt64(this.id);
                                stream.writeInt32(this.parts);
                                stream.writeInt32(this.key_fingerprint);
                            }
                        };
                    } else {
                        tLRPC$InputEncryptedFile = new TLRPC$InputEncryptedFile() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputEncryptedFileUploaded
                            public static int constructor = 1690108678;

                            @Override // ir.eitaa.tgnet.TLObject
                            public void readParams(AbstractSerializedData stream, boolean exception) {
                                this.id = stream.readInt64(exception);
                                this.parts = stream.readInt32(exception);
                                this.md5_checksum = stream.readString(exception);
                                this.key_fingerprint = stream.readInt32(exception);
                            }

                            @Override // ir.eitaa.tgnet.TLObject
                            public void serializeToStream(AbstractSerializedData stream) {
                                stream.writeInt32(constructor);
                                stream.writeInt64(this.id);
                                stream.writeInt32(this.parts);
                                stream.writeString(this.md5_checksum);
                                stream.writeInt32(this.key_fingerprint);
                            }
                        };
                        tLRPC$InputEncryptedFile.md5_checksum = "";
                    }
                    tLRPC$InputEncryptedFile.parts = this.currentPartNum;
                    tLRPC$InputEncryptedFile.id = this.currentFileId;
                    tLRPC$InputEncryptedFile.key_fingerprint = this.fingerprint;
                    this.delegate.didFinishUploadingFile(this, null, tLRPC$InputEncryptedFile, this.key, this.iv);
                    cleanup();
                }
                int i9 = this.currentType;
                if (i9 == 50331648) {
                    StatsController.getInstance(this.currentAccount).incrementSentItemsCount(ApplicationLoader.getCurrentNetworkType(), 3, 1);
                    return;
                }
                if (i9 == 33554432) {
                    StatsController.getInstance(this.currentAccount).incrementSentItemsCount(ApplicationLoader.getCurrentNetworkType(), 2, 1);
                    return;
                } else if (i9 == 16777216) {
                    StatsController.getInstance(this.currentAccount).incrementSentItemsCount(ApplicationLoader.getCurrentNetworkType(), 4, 1);
                    return;
                } else {
                    if (i9 == 67108864) {
                        StatsController.getInstance(this.currentAccount).incrementSentItemsCount(ApplicationLoader.getCurrentNetworkType(), 5, 1);
                        return;
                    }
                    return;
                }
            }
            if (i8 < this.maxRequestsCount) {
                if (this.estimatedSize == 0 && !this.uploadFirstPartLater && !this.nextPartFirst) {
                    if (this.saveInfoTimes >= 4) {
                        this.saveInfoTimes = 0;
                    }
                    int i10 = this.lastSavedPartNum;
                    if (i5 == i10) {
                        this.lastSavedPartNum = i10 + 1;
                        long j2 = j;
                        while (true) {
                            UploadCachedResult uploadCachedResult = this.cachedResults.get(this.lastSavedPartNum);
                            if (uploadCachedResult == null) {
                                break;
                            }
                            j2 = uploadCachedResult.bytesOffset;
                            bArr2 = uploadCachedResult.iv;
                            this.cachedResults.remove(this.lastSavedPartNum);
                            this.lastSavedPartNum++;
                        }
                        boolean z = this.isBigFile;
                        if ((z && j2 % 1048576 == 0) || (!z && this.saveInfoTimes == 0)) {
                            SharedPreferences.Editor editorEdit = this.preferences.edit();
                            editorEdit.putLong(this.fileKey + "_uploaded", j2);
                            if (this.isEncrypted) {
                                editorEdit.putString(this.fileKey + "_ivc", Utilities.bytesToHex(bArr2));
                            }
                            editorEdit.commit();
                        }
                    } else {
                        UploadCachedResult uploadCachedResult2 = new UploadCachedResult();
                        uploadCachedResult2.bytesOffset = j;
                        if (bArr2 != null) {
                            uploadCachedResult2.iv = new byte[32];
                            System.arraycopy(bArr2, 0, uploadCachedResult2.iv, 0, 32);
                        }
                        this.cachedResults.put(i5, uploadCachedResult2);
                    }
                    this.saveInfoTimes++;
                }
                startUploadRequest();
                return;
            }
            return;
        }
        if (tLRPC$TL_error != null) {
            AlertsCreator.processError(UserConfig.selectedAccount, tLRPC$TL_error, null, tLObject, new Object[0]);
        }
        this.state = 4;
        this.delegate.didFailedUploadingFile(this);
        cleanup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startUploadRequest$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startUploadRequest$6$FileUploadOperation() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileUploadOperation$1dy_Rix4FztGypKw4hVnQU7tOH8
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f$0.lambda$startUploadRequest$5$FileUploadOperation();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startUploadRequest$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startUploadRequest$5$FileUploadOperation() throws Exception {
        if (this.currentUploadRequetsCount < this.maxRequestsCount) {
            startUploadRequest();
        }
    }
}

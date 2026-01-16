package ir.resaneh1.iptv.upload;

import android.content.SharedPreferences;
import android.os.Handler;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.RequestSendFileMiniFunctionInput;
import ir.resaneh1.iptv.model.RequestSendFileMiniFunctionOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.HashMap;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.Utilities;
import retrofit2.Call;

/* loaded from: classes4.dex */
public class MiniFunctionFileUploadOperation {
    public String access_hash_rec;
    public String access_hash_send;
    final int currentAccount;
    private long currentFileId;
    private int currentPartNum;
    private int currentUploadRequetsCount;
    private FileUploadOperationDelegate delegate;
    private int estimatedSize;
    private String fileKey;
    public String file_id;
    private final String fineName;
    private boolean isBigFile;
    private int lastSavedPartNum;
    private MessageDigest mdEnc;
    private final String mime;
    private SharedPreferences preferences;
    private byte[] readBuffer;
    private long readBytesCount;
    private int requestNum;
    private String requestSendFileUrl;
    private int saveInfoTimes;
    private String serverUrl;
    private FileInputStream stream;
    private long totalFileSize;
    private int totalPartsCount;
    private final String trackId;
    private long uploadedBytesCount;
    private String uploadingFilePath;
    private Handler handler = new Handler();
    UploadingStatus uploadingStatus = UploadingStatus.notStarted;
    private boolean isLastPart = false;
    private int maxRequestsCount = 1;
    private int uploadChunkSize = MessagesController.UPDATE_MASK_CHECK;
    private HashMap<Integer, Integer> requestTokens = new HashMap<>();
    private int uploadStartTime = 0;
    private HashMap<Integer, UploadCachedResult> cachedResults = new HashMap<>();

    public interface FileUploadOperationDelegate {
        void onUploadCompleted(MiniFunctionFileUploadOperation miniFunctionFileUploadOperation);

        void onUploadError(MiniFunctionFileUploadOperation miniFunctionFileUploadOperation, UploadError uploadError);

        void onUploadProgress(MiniFunctionFileUploadOperation miniFunctionFileUploadOperation);

        void onUploadStart(MiniFunctionFileUploadOperation miniFunctionFileUploadOperation);
    }

    public enum UploadError {
        invalidUsername,
        internetProblem,
        canceled,
        serverProblem,
        unknow
    }

    enum UploadingStatus {
        notStarted,
        requestingSendFile,
        uploading,
        error,
        done,
        cancled
    }

    private void storeFileUploadInfo() {
    }

    static /* synthetic */ long access$1414(MiniFunctionFileUploadOperation miniFunctionFileUploadOperation, long j) {
        long j2 = miniFunctionFileUploadOperation.uploadedBytesCount + j;
        miniFunctionFileUploadOperation.uploadedBytesCount = j2;
        return j2;
    }

    static /* synthetic */ int access$1708(MiniFunctionFileUploadOperation miniFunctionFileUploadOperation) {
        int i = miniFunctionFileUploadOperation.saveInfoTimes;
        miniFunctionFileUploadOperation.saveInfoTimes = i + 1;
        return i;
    }

    static /* synthetic */ int access$1808(MiniFunctionFileUploadOperation miniFunctionFileUploadOperation) {
        int i = miniFunctionFileUploadOperation.lastSavedPartNum;
        miniFunctionFileUploadOperation.lastSavedPartNum = i + 1;
        return i;
    }

    static /* synthetic */ int access$810(MiniFunctionFileUploadOperation miniFunctionFileUploadOperation) {
        int i = miniFunctionFileUploadOperation.currentUploadRequetsCount;
        miniFunctionFileUploadOperation.currentUploadRequetsCount = i - 1;
        return i;
    }

    private class UploadCachedResult {
        private long bytesOffset;

        private UploadCachedResult(MiniFunctionFileUploadOperation miniFunctionFileUploadOperation) {
        }
    }

    public MiniFunctionFileUploadOperation(String str, String str2, String str3, String str4, String str5, int i) {
        this.uploadingFilePath = str2;
        this.fineName = str3;
        this.mime = str4;
        this.trackId = str5;
        this.requestSendFileUrl = str;
        this.currentAccount = i;
    }

    public long getUploadedBytesCount() {
        return this.uploadedBytesCount;
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
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.resaneh1.iptv.upload.MiniFunctionFileUploadOperation.1
            @Override // java.lang.Runnable
            public void run() {
                MiniFunctionFileUploadOperation.this.preferences = ApplicationLoader.applicationContext.getSharedPreferences("uploadinfo", 0);
                MiniFunctionFileUploadOperation.this.requestSendFile();
            }
        });
    }

    public void cancel() throws IOException {
        this.handler.removeCallbacksAndMessages(null);
        this.delegate.onUploadError(this, UploadError.canceled);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSendFile() {
        RequestSendFileMiniFunctionInput requestSendFileMiniFunctionInput = new RequestSendFileMiniFunctionInput();
        requestSendFileMiniFunctionInput.size = new File(this.uploadingFilePath).length();
        requestSendFileMiniFunctionInput.file_name = this.fineName;
        requestSendFileMiniFunctionInput.mime = this.mime;
        requestSendFileMiniFunctionInput.track_id = this.trackId;
        ApiRequestMessanger.getInstance(this.currentAccount).requestSendFileMiniFunction(this.requestSendFileUrl, requestSendFileMiniFunctionInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.upload.MiniFunctionFileUploadOperation.3
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) throws IOException {
                RequestSendFileMiniFunctionOutput requestSendFileMiniFunctionOutput = (RequestSendFileMiniFunctionOutput) obj;
                MiniFunctionFileUploadOperation miniFunctionFileUploadOperation = MiniFunctionFileUploadOperation.this;
                miniFunctionFileUploadOperation.access_hash_send = requestSendFileMiniFunctionOutput.access_hash_send;
                miniFunctionFileUploadOperation.file_id = requestSendFileMiniFunctionOutput.file_id;
                miniFunctionFileUploadOperation.serverUrl = requestSendFileMiniFunctionOutput.upload_url;
                MiniFunctionFileUploadOperation miniFunctionFileUploadOperation2 = MiniFunctionFileUploadOperation.this;
                miniFunctionFileUploadOperation2.uploadingStatus = UploadingStatus.uploading;
                miniFunctionFileUploadOperation2.startUploadRequest();
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.upload.MiniFunctionFileUploadOperation.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniFunctionFileUploadOperation miniFunctionFileUploadOperation = MiniFunctionFileUploadOperation.this;
                        miniFunctionFileUploadOperation.uploadingStatus = UploadingStatus.error;
                        miniFunctionFileUploadOperation.delegate.onUploadError(MiniFunctionFileUploadOperation.this, UploadError.internetProblem);
                    }
                });
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(final MessangerOutput messangerOutput) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.upload.MiniFunctionFileUploadOperation.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        MessangerOutput messangerOutput2 = messangerOutput;
                        if (messangerOutput2.status == MessangerOutput.EnumStatus.ERROR_ACTION && messangerOutput2.status_det == MessangerOutput.EnumStatusDet.USERNAME_NOT_EXIST) {
                            MiniFunctionFileUploadOperation.this.delegate.onUploadError(MiniFunctionFileUploadOperation.this, UploadError.invalidUsername);
                            return;
                        }
                        MiniFunctionFileUploadOperation miniFunctionFileUploadOperation = MiniFunctionFileUploadOperation.this;
                        miniFunctionFileUploadOperation.uploadingStatus = UploadingStatus.error;
                        miniFunctionFileUploadOperation.delegate.onUploadError(MiniFunctionFileUploadOperation.this, UploadError.serverProblem);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x017b A[Catch: Exception -> 0x0297, TryCatch #1 {Exception -> 0x0297, blocks: (B:5:0x0009, B:7:0x000f, B:9:0x0021, B:11:0x002b, B:13:0x0034, B:19:0x0044, B:22:0x005f, B:24:0x0063, B:25:0x0066, B:26:0x0068, B:28:0x00b1, B:30:0x00b7, B:32:0x0106, B:34:0x010a, B:44:0x0129, B:47:0x0136, B:49:0x0141, B:51:0x0151, B:54:0x015a, B:53:0x0158, B:55:0x0171, B:59:0x017b, B:61:0x0187, B:62:0x018a, B:38:0x0116, B:15:0x0037, B:18:0x0041, B:10:0x0025, B:63:0x0192, B:65:0x0196, B:68:0x01ab, B:71:0x01cd, B:73:0x01d7, B:75:0x01db, B:78:0x01e4, B:80:0x01f0, B:81:0x01f9, B:83:0x01fd, B:85:0x020e, B:87:0x0215, B:89:0x022f, B:86:0x0211, B:88:0x021c, B:77:0x01e2), top: B:97:0x0009, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void startUploadRequest() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 684
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.upload.MiniFunctionFileUploadOperation.startUploadRequest():void");
    }
}

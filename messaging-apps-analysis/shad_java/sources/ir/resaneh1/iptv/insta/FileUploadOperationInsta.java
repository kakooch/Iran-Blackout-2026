package ir.resaneh1.iptv.insta;

import android.content.SharedPreferences;
import android.os.Handler;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.RubinoRequestUploadFileInput;
import ir.resaneh1.iptv.model.RubinoRequestUploadFileOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.HashMap;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.Utilities;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class FileUploadOperationInsta {
    public String access_hash_rec;
    public String access_hash_send;
    private final int currentAccount;
    private long currentFileId;
    private int currentPartNum;
    private int currentUploadRequetsCount;
    public String dcId;
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
    private final String profile_id;
    private byte[] readBuffer;
    private long readBytesCount;
    private int requestNum;
    private final int rnd;
    private int saveInfoTimes;
    private String serverUrl;
    private FileInputStream stream;
    private long totalFileSize;
    private int totalPartsCount;
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
        void onUploadCompleted(FileUploadOperationInsta fileUploadOperationInsta);

        void onUploadError(FileUploadOperationInsta fileUploadOperationInsta, UploadError uploadError);

        void onUploadProgress(FileUploadOperationInsta fileUploadOperationInsta);

        void onUploadStart(FileUploadOperationInsta fileUploadOperationInsta);
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

    static /* synthetic */ long access$1414(FileUploadOperationInsta fileUploadOperationInsta, long j) {
        long j2 = fileUploadOperationInsta.uploadedBytesCount + j;
        fileUploadOperationInsta.uploadedBytesCount = j2;
        return j2;
    }

    static /* synthetic */ int access$1708(FileUploadOperationInsta fileUploadOperationInsta) {
        int i = fileUploadOperationInsta.saveInfoTimes;
        fileUploadOperationInsta.saveInfoTimes = i + 1;
        return i;
    }

    static /* synthetic */ int access$1808(FileUploadOperationInsta fileUploadOperationInsta) {
        int i = fileUploadOperationInsta.lastSavedPartNum;
        fileUploadOperationInsta.lastSavedPartNum = i + 1;
        return i;
    }

    static /* synthetic */ int access$810(FileUploadOperationInsta fileUploadOperationInsta) {
        int i = fileUploadOperationInsta.currentUploadRequetsCount;
        fileUploadOperationInsta.currentUploadRequetsCount = i - 1;
        return i;
    }

    private class UploadCachedResult {
        private long bytesOffset;

        private UploadCachedResult(FileUploadOperationInsta fileUploadOperationInsta) {
        }
    }

    public FileUploadOperationInsta(int i, String str, String str2, String str3, String str4, int i2) {
        this.uploadingFilePath = str;
        this.rnd = i;
        this.fineName = str2;
        this.mime = str3;
        this.profile_id = str4;
        this.currentAccount = i2;
    }

    public long getTotalFileSize() {
        return this.totalFileSize;
    }

    public long getUploadedBytesCount() {
        return this.uploadedBytesCount;
    }

    public int getRnd() {
        return this.rnd;
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
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.resaneh1.iptv.insta.FileUploadOperationInsta.1
            @Override // java.lang.Runnable
            public void run() {
                FileUploadOperationInsta.this.preferences = ApplicationLoader.applicationContext.getSharedPreferences("uploadinfo", 0);
                FileUploadOperationInsta.this.requestSendFile();
            }
        });
    }

    public void cancel() {
        this.handler.removeCallbacksAndMessages(null);
        this.delegate.onUploadError(this, UploadError.canceled);
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
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSendFile() {
        RubinoRequestUploadFileInput rubinoRequestUploadFileInput = new RubinoRequestUploadFileInput();
        rubinoRequestUploadFileInput.file_size = Long.valueOf(new File(this.uploadingFilePath).length());
        rubinoRequestUploadFileInput.file_name = this.fineName;
        if (this.mime.indexOf("jpg") >= 0) {
            rubinoRequestUploadFileInput.file_type = RubinoRequestUploadFileInput.FileType.Picture;
        }
        if (this.mime.indexOf("mp4") >= 0) {
            rubinoRequestUploadFileInput.file_type = RubinoRequestUploadFileInput.FileType.Video;
        }
        rubinoRequestUploadFileInput.profile_id = this.profile_id;
        ApiRequestMessanger.getInstance(this.currentAccount).instaRequestUploadFile(rubinoRequestUploadFileInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.insta.FileUploadOperationInsta.3
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) throws IOException {
                RubinoRequestUploadFileOutput rubinoRequestUploadFileOutput = (RubinoRequestUploadFileOutput) obj;
                FileUploadOperationInsta fileUploadOperationInsta = FileUploadOperationInsta.this;
                fileUploadOperationInsta.access_hash_send = rubinoRequestUploadFileOutput.hash_file_request;
                fileUploadOperationInsta.file_id = rubinoRequestUploadFileOutput.file_id;
                fileUploadOperationInsta.serverUrl = rubinoRequestUploadFileOutput.server_url;
                FileUploadOperationInsta fileUploadOperationInsta2 = FileUploadOperationInsta.this;
                fileUploadOperationInsta2.uploadingStatus = UploadingStatus.uploading;
                fileUploadOperationInsta2.startUploadRequest();
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.insta.FileUploadOperationInsta.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FileUploadOperationInsta fileUploadOperationInsta = FileUploadOperationInsta.this;
                        fileUploadOperationInsta.uploadingStatus = UploadingStatus.error;
                        fileUploadOperationInsta.delegate.onUploadError(FileUploadOperationInsta.this, UploadError.internetProblem);
                    }
                });
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(final MessangerOutput messangerOutput) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.insta.FileUploadOperationInsta.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        MessangerOutput messangerOutput2 = messangerOutput;
                        if (messangerOutput2.status == MessangerOutput.EnumStatus.ERROR_ACTION && messangerOutput2.status_det == MessangerOutput.EnumStatusDet.USERNAME_NOT_EXIST) {
                            FileUploadOperationInsta.this.delegate.onUploadError(FileUploadOperationInsta.this, UploadError.invalidUsername);
                            return;
                        }
                        FileUploadOperationInsta fileUploadOperationInsta = FileUploadOperationInsta.this;
                        fileUploadOperationInsta.uploadingStatus = UploadingStatus.error;
                        fileUploadOperationInsta.delegate.onUploadError(FileUploadOperationInsta.this, UploadError.serverProblem);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0176 A[Catch: Exception -> 0x0294, TryCatch #0 {Exception -> 0x0294, blocks: (B:5:0x0009, B:7:0x000f, B:9:0x0021, B:11:0x002b, B:13:0x0034, B:15:0x0037, B:17:0x0041, B:20:0x005a, B:22:0x005e, B:23:0x0061, B:24:0x0063, B:26:0x00ac, B:28:0x00b2, B:30:0x0101, B:32:0x0105, B:42:0x0124, B:45:0x0131, B:47:0x013c, B:49:0x014c, B:52:0x0155, B:51:0x0153, B:53:0x016c, B:57:0x0176, B:59:0x0182, B:60:0x0185, B:36:0x0111, B:10:0x0025, B:61:0x018d, B:63:0x0191, B:66:0x01a6, B:69:0x01c8, B:71:0x01d2, B:73:0x01d6, B:76:0x01df, B:78:0x01eb, B:79:0x01f4, B:81:0x01f8, B:83:0x0209, B:85:0x0210, B:87:0x022a, B:84:0x020c, B:86:0x0217, B:75:0x01dd), top: B:93:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void startUploadRequest() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 677
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.insta.FileUploadOperationInsta.startUploadRequest():void");
    }
}

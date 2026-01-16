package ir.resaneh1.iptv.insta;

import ir.appp.rghapp.DispatchQueue;
import ir.resaneh1.iptv.insta.FileUploadOperationInsta;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.LinkedList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.NotificationCenter;

/* loaded from: classes3.dex */
public class FileLoaderInsta extends BaseController {
    private static volatile FileLoaderInsta[] Instance = new FileLoaderInsta[3];
    private int currentUploadOperationsCount;
    FileUploadOperationInsta.FileUploadOperationDelegate fileUploadOperationDelegate;
    private volatile DispatchQueue fileUploaderQueue;
    private ConcurrentHashMap<Integer, FileUploadOperationInsta> uploadOperationPaths;
    private LinkedList<FileUploadOperationInsta> uploadOperationQueue;

    static /* synthetic */ int access$208(FileLoaderInsta fileLoaderInsta) {
        int i = fileLoaderInsta.currentUploadOperationsCount;
        fileLoaderInsta.currentUploadOperationsCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$210(FileLoaderInsta fileLoaderInsta) {
        int i = fileLoaderInsta.currentUploadOperationsCount;
        fileLoaderInsta.currentUploadOperationsCount = i - 1;
        return i;
    }

    public static FileLoaderInsta getInstance(int i) {
        FileLoaderInsta fileLoaderInsta = Instance[i];
        if (fileLoaderInsta == null) {
            synchronized (FileLoaderInsta.class) {
                fileLoaderInsta = Instance[i];
                if (fileLoaderInsta == null) {
                    FileLoaderInsta[] fileLoaderInstaArr = Instance;
                    FileLoaderInsta fileLoaderInsta2 = new FileLoaderInsta(i);
                    fileLoaderInstaArr[i] = fileLoaderInsta2;
                    fileLoaderInsta = fileLoaderInsta2;
                }
            }
        }
        return fileLoaderInsta;
    }

    FileLoaderInsta(int i) {
        super(i);
        new HashMap();
        this.fileUploaderQueue = new DispatchQueue("fileUploadQueueInsta");
        this.uploadOperationQueue = new LinkedList<>();
        this.uploadOperationPaths = new ConcurrentHashMap<>();
        this.currentUploadOperationsCount = 0;
        this.fileUploadOperationDelegate = new FileUploadOperationInsta.FileUploadOperationDelegate() { // from class: ir.resaneh1.iptv.insta.FileLoaderInsta.1
            @Override // ir.resaneh1.iptv.insta.FileUploadOperationInsta.FileUploadOperationDelegate
            public void onUploadStart(FileUploadOperationInsta fileUploadOperationInsta) {
            }

            @Override // ir.resaneh1.iptv.insta.FileUploadOperationInsta.FileUploadOperationDelegate
            public void onUploadProgress(final FileUploadOperationInsta fileUploadOperationInsta) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.insta.FileLoaderInsta.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NotificationCenter.getInstance(((BaseController) FileLoaderInsta.this).currentAccount).postNotificationName(NotificationCenter.myFileUploadProgressInsta, Integer.valueOf(fileUploadOperationInsta.getRnd()));
                    }
                });
            }

            @Override // ir.resaneh1.iptv.insta.FileUploadOperationInsta.FileUploadOperationDelegate
            public void onUploadCompleted(final FileUploadOperationInsta fileUploadOperationInsta) {
                FileLoaderInsta.this.uploadOperationPaths.remove(Integer.valueOf(fileUploadOperationInsta.getRnd()));
                FileLoaderInsta.access$210(FileLoaderInsta.this);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.insta.FileLoaderInsta.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        NotificationCenter notificationCenter = NotificationCenter.getInstance(((BaseController) FileLoaderInsta.this).currentAccount);
                        int i2 = NotificationCenter.myFileUploadDoneInsta;
                        FileUploadOperationInsta fileUploadOperationInsta2 = fileUploadOperationInsta;
                        notificationCenter.postNotificationName(i2, Integer.valueOf(fileUploadOperationInsta.getRnd()), fileUploadOperationInsta2.file_id, fileUploadOperationInsta2.dcId, fileUploadOperationInsta2.access_hash_rec);
                    }
                });
                FileLoaderInsta.this.startUploadFromQueue();
            }

            @Override // ir.resaneh1.iptv.insta.FileUploadOperationInsta.FileUploadOperationDelegate
            public void onUploadError(final FileUploadOperationInsta fileUploadOperationInsta, final FileUploadOperationInsta.UploadError uploadError) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.insta.FileLoaderInsta.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        NotificationCenter.getInstance(((BaseController) FileLoaderInsta.this).currentAccount).postNotificationName(NotificationCenter.myFileUploadFaildInsta, Integer.valueOf(fileUploadOperationInsta.getRnd()), uploadError);
                    }
                });
                FileLoaderInsta.this.uploadOperationPaths.remove(Integer.valueOf(fileUploadOperationInsta.getRnd()));
                FileLoaderInsta.access$210(FileLoaderInsta.this);
                FileLoaderInsta.this.startUploadFromQueue();
            }
        };
    }

    public void startUploadFromQueue() {
        FileUploadOperationInsta fileUploadOperationInstaPoll;
        if (this.currentUploadOperationsCount >= 1 || (fileUploadOperationInstaPoll = this.uploadOperationQueue.poll()) == null) {
            return;
        }
        this.currentUploadOperationsCount++;
        fileUploadOperationInstaPoll.start();
    }

    public int getUploadProgress(int i) {
        FileUploadOperationInsta fileUploadOperationInsta = this.uploadOperationPaths.get(Integer.valueOf(i));
        if (fileUploadOperationInsta == null) {
            return 99;
        }
        double uploadedBytesCount = fileUploadOperationInsta.getUploadedBytesCount();
        Double.isNaN(uploadedBytesCount);
        double totalFileSize = fileUploadOperationInsta.getTotalFileSize();
        Double.isNaN(totalFileSize);
        return (int) ((uploadedBytesCount * 100.0d) / totalFileSize);
    }

    public void cancelUploadFile(final int i) {
        this.fileUploaderQueue.postRunnable(new Runnable() { // from class: ir.resaneh1.iptv.insta.FileLoaderInsta.2
            @Override // java.lang.Runnable
            public void run() {
                FileUploadOperationInsta fileUploadOperationInsta = (FileUploadOperationInsta) FileLoaderInsta.this.uploadOperationPaths.get(Integer.valueOf(i));
                if (fileUploadOperationInsta != null) {
                    FileLoaderInsta.this.uploadOperationQueue.remove(fileUploadOperationInsta);
                    fileUploadOperationInsta.cancel();
                }
            }
        });
    }

    public void uploadFile(final int i, final String str, final String str2, final String str3, final String str4) {
        if (str == null) {
            return;
        }
        this.fileUploaderQueue.postRunnable(new Runnable() { // from class: ir.resaneh1.iptv.insta.FileLoaderInsta.3
            @Override // java.lang.Runnable
            public void run() {
                if (FileLoaderInsta.this.uploadOperationPaths.containsKey(Integer.valueOf(i))) {
                    return;
                }
                FileUploadOperationInsta fileUploadOperationInsta = new FileUploadOperationInsta(i, str, str2, str3, str4, ((BaseController) FileLoaderInsta.this).currentAccount);
                fileUploadOperationInsta.setDelegate(FileLoaderInsta.this.fileUploadOperationDelegate);
                FileLoaderInsta.this.uploadOperationPaths.put(Integer.valueOf(i), fileUploadOperationInsta);
                if (FileLoaderInsta.this.currentUploadOperationsCount >= 1) {
                    FileLoaderInsta.this.uploadOperationQueue.add(fileUploadOperationInsta);
                } else {
                    FileLoaderInsta.access$208(FileLoaderInsta.this);
                    fileUploadOperationInsta.start();
                }
            }
        });
    }
}

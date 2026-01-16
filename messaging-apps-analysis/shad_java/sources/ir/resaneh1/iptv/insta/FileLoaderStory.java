package ir.resaneh1.iptv.insta;

import ir.appp.rghapp.DispatchQueue;
import ir.resaneh1.iptv.insta.FileUploadOperationStory;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.StoryObject;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.LinkedList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.NotificationCenter;

/* loaded from: classes3.dex */
public class FileLoaderStory extends BaseController {
    private static volatile FileLoaderStory[] Instance = new FileLoaderStory[3];
    private int currentUploadOperationsCount;
    FileUploadOperationStory.FileUploadOperationDelegate fileUploadOperationDelegate;
    private volatile DispatchQueue fileUploaderQueue;
    private ConcurrentHashMap<Integer, FileUploadOperationStory> uploadOperationPaths;
    private LinkedList<FileUploadOperationStory> uploadOperationQueue;

    public static class UploadInfo {
        public long estimateSize;
        public String fileName;
        public String path;
        public int rnd;
        public StoryObject.StoryTypeEnum storyType;
    }

    static /* synthetic */ int access$308(FileLoaderStory fileLoaderStory) {
        int i = fileLoaderStory.currentUploadOperationsCount;
        fileLoaderStory.currentUploadOperationsCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$310(FileLoaderStory fileLoaderStory) {
        int i = fileLoaderStory.currentUploadOperationsCount;
        fileLoaderStory.currentUploadOperationsCount = i - 1;
        return i;
    }

    public static FileLoaderStory getInstance(int i) {
        FileLoaderStory fileLoaderStory = Instance[i];
        if (fileLoaderStory == null) {
            synchronized (FileLoaderStory.class) {
                fileLoaderStory = Instance[i];
                if (fileLoaderStory == null) {
                    FileLoaderStory[] fileLoaderStoryArr = Instance;
                    FileLoaderStory fileLoaderStory2 = new FileLoaderStory(i);
                    fileLoaderStoryArr[i] = fileLoaderStory2;
                    fileLoaderStory = fileLoaderStory2;
                }
            }
        }
        return fileLoaderStory;
    }

    public FileLoaderStory(int i) {
        super(i);
        new HashMap();
        this.fileUploaderQueue = new DispatchQueue("fileUploadQueueMessanger");
        this.uploadOperationQueue = new LinkedList<>();
        this.uploadOperationPaths = new ConcurrentHashMap<>();
        this.currentUploadOperationsCount = 0;
        this.fileUploadOperationDelegate = new AnonymousClass1();
    }

    /* renamed from: ir.resaneh1.iptv.insta.FileLoaderStory$1, reason: invalid class name */
    class AnonymousClass1 implements FileUploadOperationStory.FileUploadOperationDelegate {
        AnonymousClass1() {
        }

        @Override // ir.resaneh1.iptv.insta.FileUploadOperationStory.FileUploadOperationDelegate
        public void onUploadStart(FileUploadOperationStory fileUploadOperationStory) {
            FileLoaderStory.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storyFileUploadStarted, fileUploadOperationStory);
        }

        @Override // ir.resaneh1.iptv.insta.FileUploadOperationStory.FileUploadOperationDelegate
        public void onUploadProgress(final FileUploadOperationStory fileUploadOperationStory) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.insta.FileLoaderStory.1.1
                @Override // java.lang.Runnable
                public void run() {
                    FileLoaderStory.this.getNotificationCenter().postNotificationName(NotificationCenter.storyFileUploadProgress, fileUploadOperationStory, Float.valueOf((r3.getUploadedBytesCount() * 1.0f) / fileUploadOperationStory.getTotalFileSize()));
                }
            });
        }

        @Override // ir.resaneh1.iptv.insta.FileUploadOperationStory.FileUploadOperationDelegate
        public void onUploadCompleted(final FileUploadOperationStory fileUploadOperationStory) {
            FileLoaderStory.this.uploadOperationPaths.remove(Integer.valueOf(fileUploadOperationStory.getRnd()));
            FileLoaderStory.access$310(FileLoaderStory.this);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.insta.FileLoaderStory.1.2
                @Override // java.lang.Runnable
                public void run() {
                    FileLoaderStory.this.getNotificationCenter().postNotificationName(NotificationCenter.storyFileUploadDone, fileUploadOperationStory);
                }
            });
            FileLoaderStory.this.startUploadFromQueue();
        }

        @Override // ir.resaneh1.iptv.insta.FileUploadOperationStory.FileUploadOperationDelegate
        public void onUploadError(final FileUploadOperationStory fileUploadOperationStory) {
            FileLoaderStory.this.uploadOperationPaths.remove(Integer.valueOf(fileUploadOperationStory.getRnd()));
            FileLoaderStory.access$310(FileLoaderStory.this);
            FileLoaderStory.this.startUploadFromQueue();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.insta.FileLoaderStory$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onUploadError$0(fileUploadOperationStory);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onUploadError$0(FileUploadOperationStory fileUploadOperationStory) {
            FileLoaderStory.this.getNotificationCenter().postNotificationName(NotificationCenter.storyFileUploadFaild, Integer.valueOf(fileUploadOperationStory.getRnd()));
        }
    }

    public void startUploadFromQueue() {
        FileUploadOperationStory fileUploadOperationStoryPoll;
        if (this.currentUploadOperationsCount >= 1 || (fileUploadOperationStoryPoll = this.uploadOperationQueue.poll()) == null) {
            return;
        }
        this.currentUploadOperationsCount++;
        fileUploadOperationStoryPoll.start();
    }

    public boolean isUploading(int i) {
        return this.uploadOperationPaths.get(Integer.valueOf(i)) != null;
    }

    public void cancelUploadFile(final int i) {
        this.fileUploaderQueue.postRunnable(new Runnable() { // from class: ir.resaneh1.iptv.insta.FileLoaderStory.2
            @Override // java.lang.Runnable
            public void run() {
                MyLog.e("SendStoryHelper", "storyFileUpload cancel");
                FileUploadOperationStory fileUploadOperationStory = (FileUploadOperationStory) FileLoaderStory.this.uploadOperationPaths.remove(Integer.valueOf(i));
                if (fileUploadOperationStory != null) {
                    FileLoaderStory.this.uploadOperationQueue.remove(fileUploadOperationStory);
                    fileUploadOperationStory.cancel();
                }
            }
        });
    }

    public void uploadStory(int i, String str, String str2, long j, StoryObject.StoryTypeEnum storyTypeEnum, String str3, boolean z) {
        UploadInfo uploadInfo = new UploadInfo();
        uploadInfo.rnd = i;
        uploadInfo.path = str;
        uploadInfo.fileName = str2;
        uploadInfo.storyType = storyTypeEnum;
        uploadInfo.estimateSize = j;
        uploadFile(uploadInfo, z);
    }

    public void uploadSnapshotOrThumbnail(int i, String str, String str2, long j, String str3, boolean z) {
        UploadInfo uploadInfo = new UploadInfo();
        uploadInfo.rnd = i;
        uploadInfo.path = str;
        uploadInfo.fileName = str2;
        uploadInfo.storyType = StoryObject.StoryTypeEnum.Picture;
        uploadInfo.estimateSize = j;
        uploadFile(uploadInfo, z);
    }

    public void uploadFile(final UploadInfo uploadInfo, final boolean z) {
        if (uploadInfo == null || uploadInfo.path == null || uploadInfo.rnd == 0) {
            new FileUploadOperationStory(this.currentAccount, uploadInfo, z);
            NotificationCenter notificationCenter = getNotificationCenter();
            int i = NotificationCenter.storyFileUploadFaild;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(uploadInfo != null ? uploadInfo.rnd : 0);
            notificationCenter.postNotificationNameOnUIThread(i, objArr);
            return;
        }
        this.fileUploaderQueue.postRunnable(new Runnable() { // from class: ir.resaneh1.iptv.insta.FileLoaderStory.3
            @Override // java.lang.Runnable
            public void run() {
                if (FileLoaderStory.this.uploadOperationPaths.containsKey(Integer.valueOf(uploadInfo.rnd))) {
                    return;
                }
                FileUploadOperationStory fileUploadOperationStory = new FileUploadOperationStory(((BaseController) FileLoaderStory.this).currentAccount, uploadInfo, z);
                fileUploadOperationStory.setDelegate(FileLoaderStory.this.fileUploadOperationDelegate);
                FileLoaderStory.this.uploadOperationPaths.put(Integer.valueOf(uploadInfo.rnd), fileUploadOperationStory);
                FileLoaderStory.access$308(FileLoaderStory.this);
                fileUploadOperationStory.start();
            }
        });
    }
}

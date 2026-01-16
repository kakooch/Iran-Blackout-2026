package ir.appp.rghapp.rubinoPostSlider;

import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.rghapp.DispatchQueue;
import ir.appp.rghapp.rubinoPostSlider.FileLoadOperation;
import ir.resaneh1.iptv.helper.StorageHelper;
import ir.resaneh1.iptv.logger.MyLog;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.WebFile;
import org.rbmain.tgnet.TLRPC$FileLocation;

/* loaded from: classes3.dex */
public class FileLoaderRubinoPost extends BaseController {
    public static int MEDIA_DIR_WALLPAPER = 6;
    private ArrayList<FileLoadOperation> activeFileLoadOperation;
    private SparseArray<LinkedList<FileLoadOperation>> audioLoadOperationQueues;
    private SparseIntArray currentAudioLoadOperationsCount;
    private SparseIntArray currentLoadOperationsCount;
    private SparseIntArray currentPhotoLoadOperationsCount;
    private FileLoaderDelegate delegate;
    private ConcurrentHashMap<String, FileLoadOperation> loadOperationPaths;
    private ConcurrentHashMap<String, Boolean> loadOperationPathsUI;
    private SparseArray<LinkedList<FileLoadOperation>> loadOperationQueues;
    private SparseArray<LinkedList<FileLoadOperation>> photoLoadOperationQueues;
    private static volatile FileLoaderRubinoPost[] Instance = new FileLoaderRubinoPost[3];
    private static volatile DispatchQueue fileLoaderQueue = new DispatchQueue("fileUploadQueue");

    public interface FileLoaderDelegate {
        void fileDidFailedLoad(PhotoViewerObject photoViewerObject, boolean z);

        void fileDidLoaded(PhotoViewerObject photoViewerObject);

        void fileLoadProgressChanged(PhotoViewerObject photoViewerObject, float f);
    }

    private void pauseCurrentFileLoadOperations(FileLoadOperation fileLoadOperation) {
    }

    public static FileLoaderRubinoPost getInstance(int i) {
        FileLoaderRubinoPost fileLoaderRubinoPost = Instance[i];
        if (fileLoaderRubinoPost == null) {
            synchronized (FileLoaderRubinoPost.class) {
                fileLoaderRubinoPost = Instance[i];
                if (fileLoaderRubinoPost == null) {
                    FileLoaderRubinoPost[] fileLoaderRubinoPostArr = Instance;
                    FileLoaderRubinoPost fileLoaderRubinoPost2 = new FileLoaderRubinoPost(i);
                    fileLoaderRubinoPostArr[i] = fileLoaderRubinoPost2;
                    fileLoaderRubinoPost = fileLoaderRubinoPost2;
                }
            }
        }
        return fileLoaderRubinoPost;
    }

    public FileLoaderRubinoPost(int i) {
        super(i);
        this.loadOperationQueues = new SparseArray<>();
        this.audioLoadOperationQueues = new SparseArray<>();
        this.photoLoadOperationQueues = new SparseArray<>();
        this.currentLoadOperationsCount = new SparseIntArray();
        this.currentAudioLoadOperationsCount = new SparseIntArray();
        this.currentPhotoLoadOperationsCount = new SparseIntArray();
        this.loadOperationPaths = new ConcurrentHashMap<>();
        this.activeFileLoadOperation = new ArrayList<>();
        this.loadOperationPathsUI = new ConcurrentHashMap<>(10, 1.0f, 2);
        new HashMap();
        new HashMap();
        this.delegate = null;
    }

    public static File getDirectory(int i) {
        return StorageHelper.getDownloadDirectoryRubino();
    }

    private LinkedList<FileLoadOperation> getAudioLoadOperationQueue(int i) {
        LinkedList<FileLoadOperation> linkedList = this.audioLoadOperationQueues.get(i);
        if (linkedList != null) {
            return linkedList;
        }
        LinkedList<FileLoadOperation> linkedList2 = new LinkedList<>();
        this.audioLoadOperationQueues.put(i, linkedList2);
        return linkedList2;
    }

    private LinkedList<FileLoadOperation> getPhotoLoadOperationQueue(int i) {
        LinkedList<FileLoadOperation> linkedList = this.photoLoadOperationQueues.get(i);
        if (linkedList != null) {
            return linkedList;
        }
        LinkedList<FileLoadOperation> linkedList2 = new LinkedList<>();
        this.photoLoadOperationQueues.put(i, linkedList2);
        return linkedList2;
    }

    private LinkedList<FileLoadOperation> getLoadOperationQueue(int i) {
        LinkedList<FileLoadOperation> linkedList = this.loadOperationQueues.get(i);
        if (linkedList != null) {
            return linkedList;
        }
        LinkedList<FileLoadOperation> linkedList2 = new LinkedList<>();
        this.loadOperationQueues.put(i, linkedList2);
        return linkedList2;
    }

    public void cancelLoadFile(PhotoViewerObject photoViewerObject) {
        cancelLoadFile(photoViewerObject, null, null, null, null);
    }

    private void cancelLoadFile(final PhotoViewerObject photoViewerObject, Object obj, WebFile webFile, TLRPC$FileLocation tLRPC$FileLocation, String str) {
        final String attachFileName;
        if (tLRPC$FileLocation == null && photoViewerObject == null && webFile == null && obj == null) {
            return;
        }
        if (tLRPC$FileLocation != null) {
            attachFileName = getAttachFileName(tLRPC$FileLocation, str);
        } else if (photoViewerObject != null) {
            attachFileName = getAttachFileName(photoViewerObject);
        } else if (obj != null) {
            attachFileName = getAttachFileName(obj);
        } else {
            attachFileName = webFile != null ? getAttachFileName(webFile) : null;
        }
        if (attachFileName == null) {
            return;
        }
        this.loadOperationPathsUI.remove(attachFileName);
        fileLoaderQueue.postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FileLoaderRubinoPost$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cancelLoadFile$0(attachFileName, photoViewerObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancelLoadFile$0(String str, PhotoViewerObject photoViewerObject) {
        FileLoadOperation fileLoadOperationRemove = this.loadOperationPaths.remove(str);
        if (fileLoadOperationRemove != null) {
            int iHashCode = fileLoadOperationRemove.getDatacenterId().hashCode();
            if (photoViewerObject.isVideo) {
                if (!getLoadOperationQueue(iHashCode).remove(fileLoadOperationRemove)) {
                    this.currentLoadOperationsCount.put(iHashCode, r4.get(iHashCode) - 1);
                }
                this.activeFileLoadOperation.remove(fileLoadOperationRemove);
            } else if (!getPhotoLoadOperationQueue(iHashCode).remove(fileLoadOperationRemove)) {
                this.currentPhotoLoadOperationsCount.put(iHashCode, r4.get(iHashCode) - 1);
            }
            fileLoadOperationRemove.cancel();
        }
    }

    public boolean isLoadingFile(PhotoViewerObject photoViewerObject) {
        return isLoadingFile(photoViewerObject.getFileDownloadedName());
    }

    public boolean isPreloading(PhotoViewerObject photoViewerObject) {
        return this.loadOperationPaths.containsKey(photoViewerObject.getFileDownloadedName());
    }

    private boolean isLoadingFile(String str) {
        return str != null && this.loadOperationPathsUI.containsKey(str);
    }

    public void loadFile(PhotoViewerObject photoViewerObject, int i) {
        loadFile(photoViewerObject, null, i, 0);
    }

    public void loadFile(PhotoViewerObject photoViewerObject, Object obj, int i, int i2) {
        if (photoViewerObject == null) {
            return;
        }
        loadFile(photoViewerObject, null, null, null, null, obj, null, 0, i, i2);
    }

    boolean isHighPriorityFileDownloading() {
        for (int i = 0; i < this.activeFileLoadOperation.size(); i++) {
            try {
                if (this.activeFileLoadOperation.get(i).getPriority() != 0) {
                    return true;
                }
            } catch (Exception unused) {
                return true;
            }
        }
        return false;
    }

    private FileLoadOperation loadFileInternal(final PhotoViewerObject photoViewerObject, Object obj, final WebFile webFile, final Object obj2, ImageLocation imageLocation, Object obj3, String str, int i, int i2, FileLoadOperationStream fileLoadOperationStream, int i3, boolean z, final int i4) {
        String attachFileName;
        File directory;
        StringBuilder sb = new StringBuilder();
        sb.append("Load start ");
        sb.append(photoViewerObject.storyId);
        sb.append(" isPreload:");
        sb.append(i4 == 10);
        sb.append(" filePath ");
        sb.append(photoViewerObject.filePath);
        MyLog.e("StoryLogPreload44", sb.toString());
        if (obj2 != null) {
            attachFileName = getAttachFileName(obj2, str);
        } else if (obj != null) {
            attachFileName = getAttachFileName(obj);
        } else {
            attachFileName = getAttachFileName(photoViewerObject);
        }
        final String str2 = attachFileName;
        if (str2 == null || str2.contains("-2147483648")) {
            return null;
        }
        if (i4 != 10 && !TextUtils.isEmpty(str2) && !str2.contains("-2147483648")) {
            this.loadOperationPathsUI.put(str2, Boolean.TRUE);
        }
        FileLoadOperation fileLoadOperation = this.loadOperationPaths.get(str2);
        if (fileLoadOperation != null) {
            if (i4 != 10 && fileLoadOperation.isPreloadVideoOperation()) {
                fileLoadOperation.setIsPreloadVideoOperation(false);
            }
            if (fileLoadOperationStream != null || i2 > 0) {
                int iHashCode = fileLoadOperation.getDatacenterId().hashCode();
                LinkedList<FileLoadOperation> audioLoadOperationQueue = getAudioLoadOperationQueue(iHashCode);
                LinkedList<FileLoadOperation> photoLoadOperationQueue = getPhotoLoadOperationQueue(iHashCode);
                LinkedList<FileLoadOperation> loadOperationQueue = getLoadOperationQueue(iHashCode);
                fileLoadOperation.setForceRequest(true);
                LinkedList<FileLoadOperation> linkedList = photoViewerObject.isVideo ? loadOperationQueue : photoLoadOperationQueue;
                if (linkedList != null) {
                    int iIndexOf = linkedList.indexOf(fileLoadOperation);
                    if (iIndexOf >= 0) {
                        linkedList.remove(iIndexOf);
                        if (fileLoadOperationStream == null) {
                            linkedList.add(0, fileLoadOperation);
                        } else if (linkedList == audioLoadOperationQueue) {
                            if (fileLoadOperation.start(fileLoadOperationStream, i3, z)) {
                                SparseIntArray sparseIntArray = this.currentAudioLoadOperationsCount;
                                sparseIntArray.put(iHashCode, sparseIntArray.get(iHashCode) + 1);
                            }
                        } else if (linkedList == photoLoadOperationQueue) {
                            if (fileLoadOperation.start(fileLoadOperationStream, i3, z)) {
                                SparseIntArray sparseIntArray2 = this.currentPhotoLoadOperationsCount;
                                sparseIntArray2.put(iHashCode, sparseIntArray2.get(iHashCode) + 1);
                            }
                        } else {
                            if (fileLoadOperation.start(fileLoadOperationStream, i3, z)) {
                                SparseIntArray sparseIntArray3 = this.currentLoadOperationsCount;
                                sparseIntArray3.put(iHashCode, sparseIntArray3.get(iHashCode) + 1);
                            }
                            if (fileLoadOperation.wasStarted() && !this.activeFileLoadOperation.contains(fileLoadOperation)) {
                                pauseCurrentFileLoadOperations(fileLoadOperation);
                                this.activeFileLoadOperation.add(fileLoadOperation);
                            }
                        }
                    } else {
                        if (fileLoadOperationStream != null) {
                            pauseCurrentFileLoadOperations(fileLoadOperation);
                        }
                        fileLoadOperation.start(fileLoadOperationStream, i3, z);
                        if (linkedList == loadOperationQueue && !this.activeFileLoadOperation.contains(fileLoadOperation)) {
                            this.activeFileLoadOperation.add(fileLoadOperation);
                        }
                    }
                }
            }
            return fileLoadOperation;
        }
        File directory2 = getDirectory(4);
        FileLoadOperation fileLoadOperation2 = new FileLoadOperation(photoViewerObject, obj3);
        if (i4 == 0 || i4 == 10) {
            directory = getDirectory(3);
        } else {
            if (i4 == 2) {
                fileLoadOperation2.setEncryptFile(true);
            }
            directory = directory2;
        }
        fileLoadOperation2.setPaths(this.currentAccount, directory, directory2);
        if (i4 == 10) {
            fileLoadOperation2.setIsPreloadVideoOperation(true);
        }
        fileLoadOperation2.setDelegate(new FileLoadOperation.FileLoadOperationDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.FileLoaderRubinoPost.1
            @Override // ir.appp.rghapp.rubinoPostSlider.FileLoadOperation.FileLoadOperationDelegate
            public void didFinishLoadingFile(FileLoadOperation fileLoadOperation3, File file) {
                if (fileLoadOperation3.isPreloadVideoOperation() || !fileLoadOperation3.isPreloadFinished()) {
                    if (!fileLoadOperation3.isPreloadVideoOperation()) {
                        FileLoaderRubinoPost.this.loadOperationPathsUI.remove(str2);
                        if (FileLoaderRubinoPost.this.delegate != null) {
                            fileLoadOperation3.fileInlineObject.checkIsFileExist();
                            FileLoaderRubinoPost.this.delegate.fileDidLoaded(fileLoadOperation3.fileInlineObject);
                        }
                    }
                    FileLoaderRubinoPost.this.checkDownloadQueue(fileLoadOperation3.getDatacenterId().hashCode(), photoViewerObject, webFile, obj2, str2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Load Finish ");
                    sb2.append(fileLoadOperation3.fileInlineObject.storyId);
                    sb2.append(" isPreload:");
                    sb2.append(i4 == 10);
                    sb2.append(" filePath ");
                    sb2.append(fileLoadOperation3.fileInlineObject.filePath);
                    MyLog.e("StoryLogPreload44", sb2.toString());
                }
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.FileLoadOperation.FileLoadOperationDelegate
            public void didFailedLoadingFile(FileLoadOperation fileLoadOperation3, int i5) {
                FileLoaderRubinoPost.this.loadOperationPathsUI.remove(str2);
                FileLoaderRubinoPost.this.checkDownloadQueue(fileLoadOperation3.getDatacenterId().hashCode(), photoViewerObject, webFile, obj2, str2);
                if (FileLoaderRubinoPost.this.delegate != null) {
                    FileLoaderRubinoPost.this.delegate.fileDidFailedLoad(fileLoadOperation3.fileInlineObject, i5 == 1);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Load faild ");
                sb2.append(fileLoadOperation3.fileInlineObject.storyId);
                sb2.append(" isPreload:");
                sb2.append(i4 == 10);
                sb2.append(" filePath ");
                sb2.append(fileLoadOperation3.fileInlineObject.filePath);
                MyLog.e("StoryLogPreload44", sb2.toString());
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.FileLoadOperation.FileLoadOperationDelegate
            public void didChangedLoadProgress(FileLoadOperation fileLoadOperation3, long j, long j2) {
                if (FileLoaderRubinoPost.this.delegate != null) {
                    FileLoaderRubinoPost.this.delegate.fileLoadProgressChanged(fileLoadOperation3.fileInlineObject, (j * 1.0f) / j2);
                }
                AndroidUtilities.runOnUIThread(new Runnable(this) { // from class: ir.appp.rghapp.rubinoPostSlider.FileLoaderRubinoPost.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            }
        });
        int iHashCode2 = fileLoadOperation2.getDatacenterId().hashCode();
        getAudioLoadOperationQueue(iHashCode2);
        LinkedList<FileLoadOperation> photoLoadOperationQueue2 = getPhotoLoadOperationQueue(iHashCode2);
        LinkedList<FileLoadOperation> loadOperationQueue2 = getLoadOperationQueue(iHashCode2);
        this.loadOperationPaths.put(str2, fileLoadOperation2);
        fileLoadOperation2.setPriority(i2);
        if (3 == MEDIA_DIR_WALLPAPER || obj2 != null || MessageObject.isImageWebDocument(webFile)) {
            int i5 = i2 > 0 ? 6 : 2;
            int i6 = this.currentPhotoLoadOperationsCount.get(iHashCode2);
            if (fileLoadOperationStream != null || i6 < i5) {
                if (fileLoadOperation2.start(fileLoadOperationStream, i3, z)) {
                    this.currentPhotoLoadOperationsCount.put(iHashCode2, i6 + 1);
                }
            } else {
                addOperationToQueue(fileLoadOperation2, photoLoadOperationQueue2);
            }
        } else if (photoViewerObject.isVideo) {
            int i7 = i2 > 0 ? 4 : 2;
            int i8 = this.currentLoadOperationsCount.get(iHashCode2);
            if (fileLoadOperationStream != null || i8 < i7) {
                if (fileLoadOperation2.start(fileLoadOperationStream, i3, z)) {
                    this.currentLoadOperationsCount.put(iHashCode2, i8 + 1);
                    this.activeFileLoadOperation.add(fileLoadOperation2);
                }
                if (fileLoadOperation2.wasStarted() && fileLoadOperationStream != null) {
                    pauseCurrentFileLoadOperations(fileLoadOperation2);
                }
            } else {
                addOperationToQueue(fileLoadOperation2, loadOperationQueue2);
            }
        } else {
            int i9 = i2 > 0 ? 6 : 2;
            int i10 = this.currentPhotoLoadOperationsCount.get(iHashCode2);
            if (fileLoadOperationStream != null || i10 < i9) {
                if (fileLoadOperation2.start(fileLoadOperationStream, i3, z)) {
                    this.currentPhotoLoadOperationsCount.put(iHashCode2, i10 + 1);
                }
            } else {
                addOperationToQueue(fileLoadOperation2, photoLoadOperationQueue2);
            }
        }
        return fileLoadOperation2;
    }

    private void addOperationToQueue(FileLoadOperation fileLoadOperation, LinkedList<FileLoadOperation> linkedList) {
        int priority = fileLoadOperation.getPriority();
        if (priority > 0) {
            int size = linkedList.size();
            int i = 0;
            int size2 = linkedList.size();
            while (true) {
                if (i >= size2) {
                    break;
                }
                if (linkedList.get(i).getPriority() < priority) {
                    size = i;
                    break;
                }
                i++;
            }
            linkedList.add(size, fileLoadOperation);
            return;
        }
        linkedList.add(fileLoadOperation);
    }

    private void loadFile(final PhotoViewerObject photoViewerObject, final Object obj, final WebFile webFile, final Object obj2, final ImageLocation imageLocation, final Object obj3, final String str, final int i, final int i2, final int i3) {
        String attachFileName;
        if (obj2 != null) {
            attachFileName = getAttachFileName(obj2, str);
        } else if (photoViewerObject != null) {
            attachFileName = getAttachFileName(photoViewerObject);
        } else {
            attachFileName = webFile != null ? getAttachFileName(webFile) : null;
        }
        if (i3 != 10 && !TextUtils.isEmpty(attachFileName) && !attachFileName.contains("-2147483648")) {
            this.loadOperationPathsUI.put(attachFileName, Boolean.TRUE);
        }
        MyLog.e("FileLoader", "loadFile 1 fileLoaderQueue");
        StringBuilder sb = new StringBuilder();
        sb.append("loadFile is preload ?");
        sb.append(i3 == 10);
        MyLog.e("StoryLogPreload", sb.toString());
        fileLoaderQueue.postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FileLoaderRubinoPost$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadFile$1(photoViewerObject, obj, webFile, obj2, imageLocation, obj3, str, i, i2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadFile$1(PhotoViewerObject photoViewerObject, Object obj, WebFile webFile, Object obj2, ImageLocation imageLocation, Object obj3, String str, int i, int i2, int i3) {
        loadFileInternal(photoViewerObject, obj, webFile, obj2, imageLocation, obj3, str, i, i2, null, 0, false, i3);
    }

    protected FileLoadOperation loadStreamFile(final FileLoadOperationStream fileLoadOperationStream, final PhotoViewerObject photoViewerObject, final Object obj, final int i, final boolean z) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final FileLoadOperation[] fileLoadOperationArr = new FileLoadOperation[1];
        fileLoaderQueue.postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FileLoaderRubinoPost$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadStreamFile$2(fileLoadOperationArr, photoViewerObject, obj, fileLoadOperationStream, i, z, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
        return fileLoadOperationArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadStreamFile$2(FileLoadOperation[] fileLoadOperationArr, PhotoViewerObject photoViewerObject, Object obj, FileLoadOperationStream fileLoadOperationStream, int i, boolean z, CountDownLatch countDownLatch) {
        MyLog.e("FileLoader", "loadStreamFile 2 fileLoaderQueue");
        fileLoadOperationArr[0] = loadFileInternal(photoViewerObject, null, null, null, null, obj, null, 0, 1, fileLoadOperationStream, i, z, 0);
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkDownloadQueue(final int i, final PhotoViewerObject photoViewerObject, WebFile webFile, Object obj, final String str) {
        fileLoaderQueue.postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FileLoaderRubinoPost$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkDownloadQueue$3(i, str, photoViewerObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkDownloadQueue$3(int i, String str, PhotoViewerObject photoViewerObject) {
        getAudioLoadOperationQueue(i);
        LinkedList<FileLoadOperation> photoLoadOperationQueue = getPhotoLoadOperationQueue(i);
        LinkedList<FileLoadOperation> loadOperationQueue = getLoadOperationQueue(i);
        FileLoadOperation fileLoadOperationRemove = this.loadOperationPaths.remove(str);
        if (photoViewerObject.isVideo) {
            int i2 = this.currentLoadOperationsCount.get(i);
            if (fileLoadOperationRemove != null) {
                if (fileLoadOperationRemove.wasStarted()) {
                    i2--;
                    this.currentLoadOperationsCount.put(i, i2);
                } else {
                    loadOperationQueue.remove(fileLoadOperationRemove);
                }
                this.activeFileLoadOperation.remove(fileLoadOperationRemove);
            }
            while (!loadOperationQueue.isEmpty()) {
                if (i2 >= (loadOperationQueue.get(0).getPriority() != 0 ? 4 : 2)) {
                    return;
                }
                FileLoadOperation fileLoadOperationPoll = loadOperationQueue.poll();
                if (fileLoadOperationPoll != null && fileLoadOperationPoll.start()) {
                    i2++;
                    this.currentLoadOperationsCount.put(i, i2);
                    if (!this.activeFileLoadOperation.contains(fileLoadOperationPoll)) {
                        this.activeFileLoadOperation.add(fileLoadOperationPoll);
                    }
                }
            }
            return;
        }
        int i3 = this.currentPhotoLoadOperationsCount.get(i);
        if (fileLoadOperationRemove != null) {
            if (fileLoadOperationRemove.wasStarted()) {
                i3--;
                this.currentPhotoLoadOperationsCount.put(i, i3);
            } else {
                photoLoadOperationQueue.remove(fileLoadOperationRemove);
            }
        }
        while (!photoLoadOperationQueue.isEmpty()) {
            if (i3 >= (photoLoadOperationQueue.get(0).getPriority() != 0 ? 6 : 2)) {
                return;
            }
            FileLoadOperation fileLoadOperationPoll2 = photoLoadOperationQueue.poll();
            if (fileLoadOperationPoll2 != null && fileLoadOperationPoll2.start()) {
                i3++;
                this.currentPhotoLoadOperationsCount.put(i, i3);
            }
        }
    }

    public void setDelegate(FileLoaderDelegate fileLoaderDelegate) {
        this.delegate = fileLoaderDelegate;
    }

    public static File getInternalCacheDir() {
        return ApplicationLoader.applicationContext.getCacheDir();
    }

    public static String getAttachFileName(Object obj) {
        return getAttachFileName(obj, null);
    }

    public static String getAttachFileName(Object obj, String str) {
        return obj instanceof PhotoViewerObject ? ((PhotoViewerObject) obj).getFileDownloadedName() : BuildConfig.FLAVOR;
    }

    public static boolean copyFile(InputStream inputStream, File file, int i) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[4096];
        int i2 = 0;
        while (true) {
            int i3 = inputStream.read(bArr);
            if (i3 <= 0) {
                break;
            }
            Thread.yield();
            fileOutputStream.write(bArr, 0, i3);
            i2 += i3;
            if (i > 0 && i2 >= i) {
                break;
            }
        }
        fileOutputStream.getFD().sync();
        fileOutputStream.close();
        return true;
    }
}

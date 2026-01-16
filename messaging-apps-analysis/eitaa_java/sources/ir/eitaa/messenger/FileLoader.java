package ir.eitaa.messenger;

import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import ir.eitaa.messenger.FileUploadOperation;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$ChatPhoto;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$InputEncryptedFile;
import ir.eitaa.tgnet.TLRPC$InputFile;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeFilename;
import ir.eitaa.tgnet.TLRPC$TL_fileLocationToBeDeprecated;
import ir.eitaa.tgnet.TLRPC$TL_fileLocationUnavailable;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaInvoice;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaWebPage;
import ir.eitaa.tgnet.TLRPC$TL_messageService;
import ir.eitaa.tgnet.TLRPC$TL_photo;
import ir.eitaa.tgnet.TLRPC$TL_photoPathSize;
import ir.eitaa.tgnet.TLRPC$TL_photoStrippedSize;
import ir.eitaa.tgnet.TLRPC$TL_secureFile;
import ir.eitaa.tgnet.TLRPC$TL_videoSize;
import ir.eitaa.tgnet.TLRPC$UserProfilePhoto;
import ir.eitaa.tgnet.TLRPC$WebDocument;
import ir.eitaa.tgnet.TLRPC$WebPage;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class FileLoader extends BaseController {
    public static final int IMAGE_TYPE_ANIMATION = 2;
    public static final int IMAGE_TYPE_LOTTIE = 1;
    public static final int IMAGE_TYPE_SVG = 3;
    public static final int IMAGE_TYPE_SVG_WHITE = 4;
    public static final int IMAGE_TYPE_THEME_PREVIEW = 5;
    public static final long MAX_FILE_SIZE = 2097152000;
    public static final int MEDIA_DIR_AUDIO = 1;
    public static final int MEDIA_DIR_CACHE = 4;
    public static final int MEDIA_DIR_CACHE_TEMP = 57;
    public static final int MEDIA_DIR_DOCUMENT = 3;
    public static final int MEDIA_DIR_IMAGE = 0;
    public static final int MEDIA_DIR_VIDEO = 2;
    public static final int QUEUE_TYPE_AUDIO = 2;
    public static final int QUEUE_TYPE_FILE = 0;
    public static final int QUEUE_TYPE_IMAGE = 1;
    private ArrayList<FileLoadOperation> activeFileLoadOperation;
    private SparseArray<LinkedList<FileLoadOperation>> audioLoadOperationQueues;
    private SparseIntArray audioLoadOperationsCount;
    private int currentUploadOperationsCount;
    private int currentUploadSmallOperationsCount;
    private FileLoaderDelegate delegate;
    private SparseArray<LinkedList<FileLoadOperation>> fileLoadOperationQueues;
    private SparseIntArray fileLoadOperationsCount;
    private String forceLoadingFile;
    private SparseArray<LinkedList<FileLoadOperation>> imageLoadOperationQueues;
    private SparseIntArray imageLoadOperationsCount;
    private int lastReferenceId;
    private ConcurrentHashMap<String, FileLoadOperation> loadOperationPaths;
    private ConcurrentHashMap<String, Boolean> loadOperationPathsUI;
    private HashMap<String, Boolean> loadingVideos;
    private ConcurrentHashMap<Integer, Object> parentObjectReferences;
    private ConcurrentHashMap<String, FileUploadOperation> uploadOperationPaths;
    private ConcurrentHashMap<String, FileUploadOperation> uploadOperationPathsEnc;
    private LinkedList<FileUploadOperation> uploadOperationQueue;
    private HashMap<String, Long> uploadSizes;
    private LinkedList<FileUploadOperation> uploadSmallOperationQueue;
    private static volatile DispatchQueue fileLoaderQueue = new DispatchQueue("fileUploadQueue");
    private static SparseArray<File> mediaDirs = null;
    private static volatile FileLoader[] Instance = new FileLoader[3];

    public interface FileLoaderDelegate {
        void fileDidFailedLoad(String location, int state);

        void fileDidFailedUpload(String location, boolean isEncrypted);

        void fileDidLoaded(String location, File finalFile, int type);

        void fileDidUploaded(String location, TLRPC$InputFile inputFile, TLRPC$InputEncryptedFile inputEncryptedFile, byte[] key, byte[] iv, long totalFileSize);

        void fileLoadProgressChanged(FileLoadOperation operation, String location, long uploadedSize, long totalSize);

        void fileUploadProgressChanged(FileUploadOperation operation, String location, long uploadedSize, long totalSize, boolean isEncrypted);
    }

    static /* synthetic */ int access$608(FileLoader fileLoader) {
        int i = fileLoader.currentUploadSmallOperationsCount;
        fileLoader.currentUploadSmallOperationsCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$610(FileLoader fileLoader) {
        int i = fileLoader.currentUploadSmallOperationsCount;
        fileLoader.currentUploadSmallOperationsCount = i - 1;
        return i;
    }

    static /* synthetic */ int access$808(FileLoader fileLoader) {
        int i = fileLoader.currentUploadOperationsCount;
        fileLoader.currentUploadOperationsCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$810(FileLoader fileLoader) {
        int i = fileLoader.currentUploadOperationsCount;
        fileLoader.currentUploadOperationsCount = i - 1;
        return i;
    }

    public static FileLoader getInstance(int num) {
        FileLoader fileLoader = Instance[num];
        if (fileLoader == null) {
            synchronized (FileLoader.class) {
                fileLoader = Instance[num];
                if (fileLoader == null) {
                    FileLoader[] fileLoaderArr = Instance;
                    FileLoader fileLoader2 = new FileLoader(num);
                    fileLoaderArr[num] = fileLoader2;
                    fileLoader = fileLoader2;
                }
            }
        }
        return fileLoader;
    }

    public FileLoader(int instance) {
        super(instance);
        this.uploadOperationQueue = new LinkedList<>();
        this.uploadSmallOperationQueue = new LinkedList<>();
        this.uploadOperationPaths = new ConcurrentHashMap<>();
        this.uploadOperationPathsEnc = new ConcurrentHashMap<>();
        this.currentUploadOperationsCount = 0;
        this.currentUploadSmallOperationsCount = 0;
        this.fileLoadOperationQueues = new SparseArray<>();
        this.audioLoadOperationQueues = new SparseArray<>();
        this.imageLoadOperationQueues = new SparseArray<>();
        this.fileLoadOperationsCount = new SparseIntArray();
        this.audioLoadOperationsCount = new SparseIntArray();
        this.imageLoadOperationsCount = new SparseIntArray();
        this.loadOperationPaths = new ConcurrentHashMap<>();
        this.activeFileLoadOperation = new ArrayList<>();
        this.loadOperationPathsUI = new ConcurrentHashMap<>(10, 1.0f, 2);
        this.uploadSizes = new HashMap<>();
        this.loadingVideos = new HashMap<>();
        this.delegate = null;
        this.parentObjectReferences = new ConcurrentHashMap<>();
    }

    public static void setMediaDirs(SparseArray<File> dirs) {
        mediaDirs = dirs;
    }

    public static File checkDirectory(int type) {
        return mediaDirs.get(type);
    }

    public static File getDirectory(int type) {
        File file = mediaDirs.get(type);
        if (file == null && type != 4) {
            file = mediaDirs.get(4);
        }
        if (file != null) {
            try {
                if (!file.isDirectory()) {
                    file.mkdirs();
                }
            } catch (Exception unused) {
            }
        }
        return file;
    }

    public int getFileReference(Object parentObject) {
        int i = this.lastReferenceId;
        this.lastReferenceId = i + 1;
        this.parentObjectReferences.put(Integer.valueOf(i), parentObject);
        return i;
    }

    public Object getParentObject(int reference) {
        return this.parentObjectReferences.get(Integer.valueOf(reference));
    }

    /* renamed from: setLoadingVideoInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$setLoadingVideo$0$FileLoader(TLRPC$Document document, boolean player) {
        String attachFileName = getAttachFileName(document);
        StringBuilder sb = new StringBuilder();
        sb.append(attachFileName);
        sb.append(player ? "p" : "");
        this.loadingVideos.put(sb.toString(), Boolean.TRUE);
        getNotificationCenter().postNotificationName(NotificationCenter.videoLoadingStateChanged, attachFileName);
    }

    public void setLoadingVideo(final TLRPC$Document document, final boolean player, boolean schedule) {
        if (document == null) {
            return;
        }
        if (schedule) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLoader$9ByJ_bNfBuabGtinGFxPCbZk990
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setLoadingVideo$0$FileLoader(document, player);
                }
            });
        } else {
            lambda$setLoadingVideo$0(document, player);
        }
    }

    public void setLoadingVideoForPlayer(TLRPC$Document document, boolean player) {
        if (document == null) {
            return;
        }
        String attachFileName = getAttachFileName(document);
        HashMap<String, Boolean> map = this.loadingVideos;
        StringBuilder sb = new StringBuilder();
        sb.append(attachFileName);
        sb.append(player ? "" : "p");
        if (map.containsKey(sb.toString())) {
            HashMap<String, Boolean> map2 = this.loadingVideos;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(attachFileName);
            sb2.append(player ? "p" : "");
            map2.put(sb2.toString(), Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeLoadingVideoInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$removeLoadingVideo$1$FileLoader(TLRPC$Document document, boolean player) {
        String attachFileName = getAttachFileName(document);
        StringBuilder sb = new StringBuilder();
        sb.append(attachFileName);
        sb.append(player ? "p" : "");
        if (this.loadingVideos.remove(sb.toString()) != null) {
            getNotificationCenter().postNotificationName(NotificationCenter.videoLoadingStateChanged, attachFileName);
        }
    }

    public void removeLoadingVideo(final TLRPC$Document document, final boolean player, boolean schedule) {
        if (document == null) {
            return;
        }
        if (schedule) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLoader$v7NuW0ag5nZ1Or1qt5Xh8pv2ne8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeLoadingVideo$1$FileLoader(document, player);
                }
            });
        } else {
            lambda$removeLoadingVideo$1(document, player);
        }
    }

    public boolean isLoadingVideo(TLRPC$Document document, boolean player) {
        if (document != null) {
            HashMap<String, Boolean> map = this.loadingVideos;
            StringBuilder sb = new StringBuilder();
            sb.append(getAttachFileName(document));
            sb.append(player ? "p" : "");
            if (map.containsKey(sb.toString())) {
                return true;
            }
        }
        return false;
    }

    public boolean isLoadingVideoAny(TLRPC$Document document) {
        return isLoadingVideo(document, false) || isLoadingVideo(document, true);
    }

    public void cancelFileUpload(final String location, final boolean enc) {
        fileLoaderQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLoader$YWM4u4vVNqUbTmmfUINFIbdBLl4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cancelFileUpload$2$FileLoader(enc, location);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cancelFileUpload$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$cancelFileUpload$2$FileLoader(boolean z, String str) {
        FileUploadOperation fileUploadOperation;
        if (!z) {
            fileUploadOperation = (FileUploadOperation) this.uploadOperationPaths.get(str);
        } else {
            fileUploadOperation = (FileUploadOperation) this.uploadOperationPathsEnc.get(str);
        }
        this.uploadSizes.remove(str);
        if (fileUploadOperation != null) {
            this.uploadOperationPathsEnc.remove(str);
            this.uploadOperationQueue.remove(fileUploadOperation);
            this.uploadSmallOperationQueue.remove(fileUploadOperation);
            fileUploadOperation.cancel();
        }
    }

    public void checkUploadNewDataAvailable(final String location, final boolean encrypted, final long newAvailableSize, final long finalSize) {
        fileLoaderQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLoader$UnFxNUhLyIredRSq0uixhGPtrtk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkUploadNewDataAvailable$3$FileLoader(encrypted, location, newAvailableSize, finalSize);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkUploadNewDataAvailable$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkUploadNewDataAvailable$3$FileLoader(boolean z, String str, long j, long j2) {
        FileUploadOperation fileUploadOperation;
        if (z) {
            fileUploadOperation = (FileUploadOperation) this.uploadOperationPathsEnc.get(str);
        } else {
            fileUploadOperation = (FileUploadOperation) this.uploadOperationPaths.get(str);
        }
        if (fileUploadOperation != null) {
            fileUploadOperation.checkNewDataAvailable(j, j2);
        } else if (j2 != 0) {
            this.uploadSizes.put(str, Long.valueOf(j2));
        }
    }

    public void onNetworkChanged(final boolean slow) {
        fileLoaderQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLoader$5K8oUrua1nDXpLeJrDTC1TqRKBg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onNetworkChanged$4$FileLoader(slow);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onNetworkChanged$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onNetworkChanged$4$FileLoader(boolean z) {
        Iterator it = this.uploadOperationPaths.entrySet().iterator();
        while (it.hasNext()) {
            ((FileUploadOperation) ((Map.Entry) it.next()).getValue()).onNetworkChanged(z);
        }
        Iterator it2 = this.uploadOperationPathsEnc.entrySet().iterator();
        while (it2.hasNext()) {
            ((FileUploadOperation) ((Map.Entry) it2.next()).getValue()).onNetworkChanged(z);
        }
    }

    public void uploadFile(final String location, final boolean encrypted, final boolean small, final int type) {
        uploadFile(location, encrypted, small, 0, type, false);
    }

    public void uploadFile(final String location, final boolean encrypted, final boolean small, final int estimatedSize, final int type, final boolean forceSmallFile) {
        if (location == null) {
            return;
        }
        fileLoaderQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLoader$AVq54umZgoEDRVvpcA-W2KaHirw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$uploadFile$5$FileLoader(encrypted, location, estimatedSize, type, forceSmallFile, small);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$uploadFile$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$uploadFile$5$FileLoader(boolean z, String str, int i, int i2, boolean z2, boolean z3) {
        int i3;
        if (z) {
            if (this.uploadOperationPathsEnc.containsKey(str)) {
                return;
            }
        } else if (this.uploadOperationPaths.containsKey(str)) {
            return;
        }
        if (i == 0 || this.uploadSizes.get(str) == null) {
            i3 = i;
        } else {
            this.uploadSizes.remove(str);
            i3 = 0;
        }
        FileUploadOperation fileUploadOperation = new FileUploadOperation(this.currentAccount, str, z, i3, i2);
        FileLoaderDelegate fileLoaderDelegate = this.delegate;
        if (fileLoaderDelegate != null && i != 0) {
            fileLoaderDelegate.fileUploadProgressChanged(fileUploadOperation, str, 0L, i, z);
        }
        if (z) {
            this.uploadOperationPathsEnc.put(str, fileUploadOperation);
        } else {
            this.uploadOperationPaths.put(str, fileUploadOperation);
        }
        if (z2) {
            fileUploadOperation.setForceSmallFile();
        }
        fileUploadOperation.setDelegate(new AnonymousClass1(z, str, z3));
        if (z3) {
            int i4 = this.currentUploadSmallOperationsCount;
            if (i4 < 1) {
                this.currentUploadSmallOperationsCount = i4 + 1;
                fileUploadOperation.start();
                return;
            } else {
                this.uploadSmallOperationQueue.add(fileUploadOperation);
                return;
            }
        }
        int i5 = this.currentUploadOperationsCount;
        if (i5 < 1) {
            this.currentUploadOperationsCount = i5 + 1;
            fileUploadOperation.start();
        } else {
            this.uploadOperationQueue.add(fileUploadOperation);
        }
    }

    /* renamed from: ir.eitaa.messenger.FileLoader$1, reason: invalid class name */
    class AnonymousClass1 implements FileUploadOperation.FileUploadOperationDelegate {
        final /* synthetic */ boolean val$encrypted;
        final /* synthetic */ String val$location;
        final /* synthetic */ boolean val$small;

        AnonymousClass1(final boolean val$encrypted, final String val$location, final boolean val$small) {
            this.val$encrypted = val$encrypted;
            this.val$location = val$location;
            this.val$small = val$small;
        }

        @Override // ir.eitaa.messenger.FileUploadOperation.FileUploadOperationDelegate
        public void didFinishUploadingFile(final FileUploadOperation operation, final TLRPC$InputFile inputFile, final TLRPC$InputEncryptedFile inputEncryptedFile, final byte[] key, final byte[] iv) {
            DispatchQueue dispatchQueue = FileLoader.fileLoaderQueue;
            final boolean z = this.val$encrypted;
            final String str = this.val$location;
            final boolean z2 = this.val$small;
            dispatchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLoader$1$3RPOlia2YIckenBGDIUYhujfl6g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didFinishUploadingFile$0$FileLoader$1(z, str, z2, inputFile, inputEncryptedFile, key, iv, operation);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$didFinishUploadingFile$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$didFinishUploadingFile$0$FileLoader$1(boolean z, String str, boolean z2, TLRPC$InputFile tLRPC$InputFile, TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile, byte[] bArr, byte[] bArr2, FileUploadOperation fileUploadOperation) {
            FileUploadOperation fileUploadOperation2;
            FileUploadOperation fileUploadOperation3;
            if (z) {
                FileLoader.this.uploadOperationPathsEnc.remove(str);
            } else {
                FileLoader.this.uploadOperationPaths.remove(str);
            }
            if (z2) {
                FileLoader.access$610(FileLoader.this);
                if (FileLoader.this.currentUploadSmallOperationsCount < 1 && (fileUploadOperation3 = (FileUploadOperation) FileLoader.this.uploadSmallOperationQueue.poll()) != null) {
                    FileLoader.access$608(FileLoader.this);
                    fileUploadOperation3.start();
                }
            } else {
                FileLoader.access$810(FileLoader.this);
                if (FileLoader.this.currentUploadOperationsCount < 1 && (fileUploadOperation2 = (FileUploadOperation) FileLoader.this.uploadOperationQueue.poll()) != null) {
                    FileLoader.access$808(FileLoader.this);
                    fileUploadOperation2.start();
                }
            }
            if (FileLoader.this.delegate != null) {
                FileLoader.this.delegate.fileDidUploaded(str, tLRPC$InputFile, tLRPC$InputEncryptedFile, bArr, bArr2, fileUploadOperation.getTotalFileSize());
            }
        }

        @Override // ir.eitaa.messenger.FileUploadOperation.FileUploadOperationDelegate
        public void didFailedUploadingFile(final FileUploadOperation operation) {
            DispatchQueue dispatchQueue = FileLoader.fileLoaderQueue;
            final boolean z = this.val$encrypted;
            final String str = this.val$location;
            final boolean z2 = this.val$small;
            dispatchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLoader$1$uFUsHsbCX8USG9BQ7scFXerhvaw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didFailedUploadingFile$1$FileLoader$1(z, str, z2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$didFailedUploadingFile$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$didFailedUploadingFile$1$FileLoader$1(boolean z, String str, boolean z2) {
            FileUploadOperation fileUploadOperation;
            FileUploadOperation fileUploadOperation2;
            if (z) {
                FileLoader.this.uploadOperationPathsEnc.remove(str);
            } else {
                FileLoader.this.uploadOperationPaths.remove(str);
            }
            if (FileLoader.this.delegate != null) {
                FileLoader.this.delegate.fileDidFailedUpload(str, z);
            }
            if (z2) {
                FileLoader.access$610(FileLoader.this);
                if (FileLoader.this.currentUploadSmallOperationsCount >= 1 || (fileUploadOperation2 = (FileUploadOperation) FileLoader.this.uploadSmallOperationQueue.poll()) == null) {
                    return;
                }
                FileLoader.access$608(FileLoader.this);
                fileUploadOperation2.start();
                return;
            }
            FileLoader.access$810(FileLoader.this);
            if (FileLoader.this.currentUploadOperationsCount >= 1 || (fileUploadOperation = (FileUploadOperation) FileLoader.this.uploadOperationQueue.poll()) == null) {
                return;
            }
            FileLoader.access$808(FileLoader.this);
            fileUploadOperation.start();
        }

        @Override // ir.eitaa.messenger.FileUploadOperation.FileUploadOperationDelegate
        public void didChangedUploadProgress(FileUploadOperation operation, long uploadedSize, long totalSize) {
            if (FileLoader.this.delegate != null) {
                FileLoader.this.delegate.fileUploadProgressChanged(operation, this.val$location, uploadedSize, totalSize, this.val$encrypted);
            }
        }
    }

    private LinkedList<FileLoadOperation> getLoadOperationQueue(int datacenterId, int type) {
        SparseArray<LinkedList<FileLoadOperation>> sparseArray;
        if (type == 2) {
            sparseArray = this.audioLoadOperationQueues;
        } else if (type == 1) {
            sparseArray = this.imageLoadOperationQueues;
        } else {
            sparseArray = this.fileLoadOperationQueues;
        }
        LinkedList<FileLoadOperation> linkedList = sparseArray.get(datacenterId);
        if (linkedList != null) {
            return linkedList;
        }
        LinkedList<FileLoadOperation> linkedList2 = new LinkedList<>();
        sparseArray.put(datacenterId, linkedList2);
        return linkedList2;
    }

    private SparseIntArray getLoadOperationCount(int type) {
        if (type == 2) {
            return this.audioLoadOperationsCount;
        }
        if (type == 1) {
            return this.imageLoadOperationsCount;
        }
        return this.fileLoadOperationsCount;
    }

    public void setForceStreamLoadingFile(final TLRPC$FileLocation location, final String ext) {
        if (location == null) {
            return;
        }
        fileLoaderQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLoader$kuEf6pS0-9gEv9qH06s5KQYojUU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setForceStreamLoadingFile$6$FileLoader(location, ext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setForceStreamLoadingFile$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setForceStreamLoadingFile$6$FileLoader(TLRPC$FileLocation tLRPC$FileLocation, String str) {
        String attachFileName = getAttachFileName(tLRPC$FileLocation, str);
        this.forceLoadingFile = attachFileName;
        FileLoadOperation fileLoadOperation = (FileLoadOperation) this.loadOperationPaths.get(attachFileName);
        if (fileLoadOperation != null) {
            if (fileLoadOperation.isPreloadVideoOperation()) {
                fileLoadOperation.setIsPreloadVideoOperation(false);
            }
            fileLoadOperation.setForceRequest(true);
            int datacenterId = fileLoadOperation.getDatacenterId();
            int queueType = fileLoadOperation.getQueueType();
            LinkedList<FileLoadOperation> loadOperationQueue = getLoadOperationQueue(datacenterId, queueType);
            SparseIntArray loadOperationCount = getLoadOperationCount(queueType);
            int iIndexOf = loadOperationQueue.indexOf(fileLoadOperation);
            if (iIndexOf >= 0) {
                loadOperationQueue.remove(iIndexOf);
                if (fileLoadOperation.start()) {
                    loadOperationCount.put(datacenterId, loadOperationCount.get(datacenterId) + 1);
                }
                if (queueType == 0 && fileLoadOperation.wasStarted() && !this.activeFileLoadOperation.contains(fileLoadOperation)) {
                    pauseCurrentFileLoadOperations(fileLoadOperation);
                    this.activeFileLoadOperation.add(fileLoadOperation);
                    return;
                }
                return;
            }
            pauseCurrentFileLoadOperations(fileLoadOperation);
            fileLoadOperation.start();
            if (queueType != 0 || this.activeFileLoadOperation.contains(fileLoadOperation)) {
                return;
            }
            this.activeFileLoadOperation.add(fileLoadOperation);
        }
    }

    public void cancelLoadFile(TLRPC$Document document) {
        cancelLoadFile(document, false);
    }

    public void cancelLoadFile(TLRPC$Document document, boolean deleteFile) {
        cancelLoadFile(document, null, null, null, null, null, deleteFile);
    }

    public void cancelLoadFile(SecureDocument document) {
        cancelLoadFile(null, document, null, null, null, null, false);
    }

    public void cancelLoadFile(WebFile document) {
        cancelLoadFile(null, null, document, null, null, null, false);
    }

    public void cancelLoadFile(TLRPC$PhotoSize photo) {
        cancelLoadFile(photo, false);
    }

    public void cancelLoadFile(TLRPC$PhotoSize photo, boolean deleteFile) {
        cancelLoadFile(null, null, null, photo.location, null, null, deleteFile);
    }

    public void cancelLoadFile(TLRPC$FileLocation location, String ext) {
        cancelLoadFile(location, ext, false);
    }

    public void cancelLoadFile(TLRPC$FileLocation location, String ext, boolean deleteFile) {
        cancelLoadFile(null, null, null, location, ext, null, deleteFile);
    }

    public void cancelLoadFile(String fileName) {
        cancelLoadFile(null, null, null, null, null, fileName, true);
    }

    public void cancelLoadFiles(ArrayList<String> fileNames) {
        int size = fileNames.size();
        for (int i = 0; i < size; i++) {
            cancelLoadFile(null, null, null, null, null, fileNames.get(i), true);
        }
    }

    private void cancelLoadFile(final TLRPC$Document document, final SecureDocument secureDocument, final WebFile webDocument, final TLRPC$FileLocation location, final String locationExt, final String name, final boolean deleteFile) {
        if (location == null && document == null && webDocument == null && secureDocument == null && TextUtils.isEmpty(name)) {
            return;
        }
        if (location != null) {
            name = getAttachFileName(location, locationExt);
        } else if (document != null) {
            name = getAttachFileName(document);
        } else if (secureDocument != null) {
            name = getAttachFileName(secureDocument);
        } else if (webDocument != null) {
            name = getAttachFileName(webDocument);
        }
        this.loadOperationPathsUI.remove(name);
        fileLoaderQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLoader$OVJBn177CP0zfHlb7NRo6D3FTH0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cancelLoadFile$7$FileLoader(name, deleteFile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cancelLoadFile$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$cancelLoadFile$7$FileLoader(String str, boolean z) {
        FileLoadOperation fileLoadOperation = (FileLoadOperation) this.loadOperationPaths.remove(str);
        if (fileLoadOperation != null) {
            int queueType = fileLoadOperation.getQueueType();
            int datacenterId = fileLoadOperation.getDatacenterId();
            if (!getLoadOperationQueue(datacenterId, queueType).remove(fileLoadOperation)) {
                getLoadOperationCount(queueType).put(datacenterId, r2.get(datacenterId) - 1);
            }
            if (queueType == 0) {
                this.activeFileLoadOperation.remove(fileLoadOperation);
            }
            fileLoadOperation.cancel(z);
        }
    }

    public boolean isLoadingFile(final String fileName) {
        return fileName != null && this.loadOperationPathsUI.containsKey(fileName);
    }

    public float getBufferedProgressFromPosition(final float position, final String fileName) {
        FileLoadOperation fileLoadOperation;
        if (TextUtils.isEmpty(fileName) || (fileLoadOperation = (FileLoadOperation) this.loadOperationPaths.get(fileName)) == null) {
            return 0.0f;
        }
        return fileLoadOperation.getDownloadedLengthFromOffset(position);
    }

    public void loadFile(ImageLocation imageLocation, Object parentObject, String ext, int priority, int cacheType) {
        if (imageLocation == null) {
            return;
        }
        loadFile(imageLocation.document, imageLocation.secureDocument, imageLocation.webFile, imageLocation.location, imageLocation, parentObject, ext, imageLocation.getSize(), priority, (cacheType != 0 || (!imageLocation.isEncrypted() && (imageLocation.photoSize == null || imageLocation.getSize() != 0))) ? cacheType : 1);
    }

    public void loadFile(SecureDocument secureDocument, int priority) {
        if (secureDocument == null) {
            return;
        }
        loadFile(null, secureDocument, null, null, null, null, null, 0, priority, 1);
    }

    public void loadFile(TLRPC$Document document, Object parentObject, int priority, int cacheType) {
        if (document == null) {
            return;
        }
        loadFile(document, null, null, null, null, parentObject, null, 0, priority, (cacheType != 0 || document.key == null) ? cacheType : 1);
    }

    public void loadFile(WebFile document, int priority, int cacheType) {
        loadFile(null, null, document, null, null, null, null, 0, priority, cacheType);
    }

    private void pauseCurrentFileLoadOperations(FileLoadOperation newOperation) {
        int i = 0;
        while (i < this.activeFileLoadOperation.size()) {
            FileLoadOperation fileLoadOperation = this.activeFileLoadOperation.get(i);
            if (fileLoadOperation != newOperation && fileLoadOperation.getDatacenterId() == newOperation.getDatacenterId() && !fileLoadOperation.getFileName().equals(this.forceLoadingFile)) {
                this.activeFileLoadOperation.remove(fileLoadOperation);
                i--;
                int datacenterId = fileLoadOperation.getDatacenterId();
                int queueType = fileLoadOperation.getQueueType();
                LinkedList<FileLoadOperation> loadOperationQueue = getLoadOperationQueue(datacenterId, queueType);
                SparseIntArray loadOperationCount = getLoadOperationCount(queueType);
                loadOperationQueue.add(0, fileLoadOperation);
                if (fileLoadOperation.wasStarted()) {
                    loadOperationCount.put(datacenterId, loadOperationCount.get(datacenterId) - 1);
                }
                fileLoadOperation.pause();
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private ir.eitaa.messenger.FileLoadOperation loadFileInternal(final ir.eitaa.tgnet.TLRPC$Document r21, final ir.eitaa.messenger.SecureDocument r22, final ir.eitaa.messenger.WebFile r23, ir.eitaa.tgnet.TLRPC$TL_fileLocationToBeDeprecated r24, final ir.eitaa.messenger.ImageLocation r25, java.lang.Object r26, final java.lang.String r27, final int r28, final int r29, final ir.eitaa.messenger.FileLoadOperationStream r30, final int r31, boolean r32, final int r33) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.FileLoader.loadFileInternal(ir.eitaa.tgnet.TLRPC$Document, ir.eitaa.messenger.SecureDocument, ir.eitaa.messenger.WebFile, ir.eitaa.tgnet.TLRPC$TL_fileLocationToBeDeprecated, ir.eitaa.messenger.ImageLocation, java.lang.Object, java.lang.String, int, int, ir.eitaa.messenger.FileLoadOperationStream, int, boolean, int):ir.eitaa.messenger.FileLoadOperation");
    }

    private void addOperationToQueue(FileLoadOperation operation, LinkedList<FileLoadOperation> queue) {
        int priority = operation.getPriority();
        if (priority > 0) {
            int size = queue.size();
            int i = 0;
            int size2 = queue.size();
            while (true) {
                if (i >= size2) {
                    break;
                }
                if (queue.get(i).getPriority() < priority) {
                    size = i;
                    break;
                }
                i++;
            }
            queue.add(size, operation);
            return;
        }
        queue.add(operation);
    }

    private void loadFile(final TLRPC$Document document, final SecureDocument secureDocument, final WebFile webDocument, final TLRPC$TL_fileLocationToBeDeprecated location, final ImageLocation imageLocation, final Object parentObject, final String locationExt, final int locationSize, final int priority, final int cacheType) {
        String attachFileName;
        if (location != null) {
            attachFileName = getAttachFileName(location, locationExt);
        } else if (document != null) {
            attachFileName = getAttachFileName(document);
        } else {
            attachFileName = webDocument != null ? getAttachFileName(webDocument) : null;
        }
        if (cacheType != 10 && !TextUtils.isEmpty(attachFileName) && !attachFileName.contains("-2147483648")) {
            this.loadOperationPathsUI.put(attachFileName, Boolean.TRUE);
        }
        fileLoaderQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLoader$qiYdHaDytVHNm_N5kntBWF9wtfs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadFile$8$FileLoader(document, secureDocument, webDocument, location, imageLocation, parentObject, locationExt, locationSize, priority, cacheType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadFile$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadFile$8$FileLoader(TLRPC$Document tLRPC$Document, SecureDocument secureDocument, WebFile webFile, TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated, ImageLocation imageLocation, Object obj, String str, int i, int i2, int i3) {
        loadFileInternal(tLRPC$Document, secureDocument, webFile, tLRPC$TL_fileLocationToBeDeprecated, imageLocation, obj, str, i, i2, null, 0, false, i3);
    }

    protected FileLoadOperation loadStreamFile(final FileLoadOperationStream stream, final TLRPC$Document document, final ImageLocation location, final Object parentObject, final int offset, final boolean priority) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final FileLoadOperation[] fileLoadOperationArr = new FileLoadOperation[1];
        fileLoaderQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLoader$474TVxHFiTbsxvPVwWC1-lkX4ng
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadStreamFile$9$FileLoader(fileLoadOperationArr, document, location, parentObject, stream, offset, priority, countDownLatch);
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
    /* renamed from: lambda$loadStreamFile$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadStreamFile$9$FileLoader(FileLoadOperation[] fileLoadOperationArr, TLRPC$Document tLRPC$Document, ImageLocation imageLocation, Object obj, FileLoadOperationStream fileLoadOperationStream, int i, boolean z, CountDownLatch countDownLatch) {
        String str = null;
        TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated = (tLRPC$Document != null || imageLocation == null) ? null : imageLocation.location;
        if (tLRPC$Document == null && imageLocation != null) {
            str = "mp4";
        }
        fileLoadOperationArr[0] = loadFileInternal(tLRPC$Document, null, null, tLRPC$TL_fileLocationToBeDeprecated, imageLocation, obj, str, (tLRPC$Document != null || imageLocation == null) ? 0 : imageLocation.currentSize, 1, fileLoadOperationStream, i, z, tLRPC$Document == null ? 1 : 0);
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkDownloadQueue(final int datacenterId, final int queueType, final String fileName) {
        fileLoaderQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLoader$v4AXENtleX8DtusbRJe9tsvP80g
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkDownloadQueue$10$FileLoader(fileName, datacenterId, queueType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /* renamed from: lambda$checkDownloadQueue$10, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$checkDownloadQueue$10$FileLoader(java.lang.String r7, int r8, int r9) {
        /*
            r6 = this;
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, ir.eitaa.messenger.FileLoadOperation> r0 = r6.loadOperationPaths
            java.lang.Object r7 = r0.remove(r7)
            ir.eitaa.messenger.FileLoadOperation r7 = (ir.eitaa.messenger.FileLoadOperation) r7
            java.util.LinkedList r0 = r6.getLoadOperationQueue(r8, r9)
            android.util.SparseIntArray r1 = r6.getLoadOperationCount(r9)
            int r2 = r1.get(r8)
            if (r7 == 0) goto L2c
            boolean r3 = r7.wasStarted()
            if (r3 == 0) goto L22
            int r2 = r2 + (-1)
            r1.put(r8, r2)
            goto L25
        L22:
            r0.remove(r7)
        L25:
            if (r9 != 0) goto L2c
            java.util.ArrayList<ir.eitaa.messenger.FileLoadOperation> r3 = r6.activeFileLoadOperation
            r3.remove(r7)
        L2c:
            boolean r7 = r0.isEmpty()
            if (r7 != 0) goto L7d
            r7 = 0
            java.lang.Object r7 = r0.get(r7)
            ir.eitaa.messenger.FileLoadOperation r7 = (ir.eitaa.messenger.FileLoadOperation) r7
            r3 = 3
            r4 = 2
            r5 = 1
            if (r9 != r4) goto L47
            int r7 = r7.getPriority()
            if (r7 == 0) goto L45
            goto L58
        L45:
            r3 = 1
            goto L58
        L47:
            if (r9 != r5) goto L52
            int r7 = r7.getPriority()
            if (r7 == 0) goto L50
            r4 = 6
        L50:
            r3 = r4
            goto L58
        L52:
            boolean r7 = r7.isForceRequest()
            if (r7 == 0) goto L45
        L58:
            if (r2 >= r3) goto L7d
            java.lang.Object r7 = r0.poll()
            ir.eitaa.messenger.FileLoadOperation r7 = (ir.eitaa.messenger.FileLoadOperation) r7
            if (r7 == 0) goto L2c
            boolean r3 = r7.start()
            if (r3 == 0) goto L2c
            int r2 = r2 + 1
            r1.put(r8, r2)
            if (r9 != 0) goto L2c
            java.util.ArrayList<ir.eitaa.messenger.FileLoadOperation> r3 = r6.activeFileLoadOperation
            boolean r3 = r3.contains(r7)
            if (r3 != 0) goto L2c
            java.util.ArrayList<ir.eitaa.messenger.FileLoadOperation> r3 = r6.activeFileLoadOperation
            r3.add(r7)
            goto L2c
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.FileLoader.lambda$checkDownloadQueue$10$FileLoader(java.lang.String, int, int):void");
    }

    public void setDelegate(FileLoaderDelegate fileLoaderDelegate) {
        this.delegate = fileLoaderDelegate;
    }

    public static String getMessageFileName(TLRPC$Message message) {
        TLRPC$WebDocument tLRPC$WebDocument;
        TLRPC$PhotoSize closestPhotoSizeWithSize;
        TLRPC$PhotoSize closestPhotoSizeWithSize2;
        TLRPC$PhotoSize closestPhotoSizeWithSize3;
        if (message == null) {
            return "";
        }
        if (message instanceof TLRPC$TL_messageService) {
            TLRPC$Photo tLRPC$Photo = message.action.photo;
            if (tLRPC$Photo != null) {
                ArrayList<TLRPC$PhotoSize> arrayList = tLRPC$Photo.sizes;
                if (arrayList.size() > 0 && (closestPhotoSizeWithSize3 = getClosestPhotoSizeWithSize(arrayList, AndroidUtilities.getPhotoSize())) != null) {
                    return getAttachFileName(closestPhotoSizeWithSize3);
                }
            }
        } else {
            TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
            if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) {
                return getAttachFileName(tLRPC$MessageMedia.document);
            }
            if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) {
                ArrayList<TLRPC$PhotoSize> arrayList2 = tLRPC$MessageMedia.photo.sizes;
                if (arrayList2.size() > 0 && (closestPhotoSizeWithSize2 = getClosestPhotoSizeWithSize(arrayList2, AndroidUtilities.getPhotoSize(), false, null, true)) != null) {
                    return getAttachFileName(closestPhotoSizeWithSize2);
                }
            } else if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
                TLRPC$WebPage tLRPC$WebPage = tLRPC$MessageMedia.webpage;
                TLRPC$Document tLRPC$Document = tLRPC$WebPage.document;
                if (tLRPC$Document != null) {
                    return getAttachFileName(tLRPC$Document);
                }
                TLRPC$Photo tLRPC$Photo2 = tLRPC$WebPage.photo;
                if (tLRPC$Photo2 != null) {
                    ArrayList<TLRPC$PhotoSize> arrayList3 = tLRPC$Photo2.sizes;
                    if (arrayList3.size() > 0 && (closestPhotoSizeWithSize = getClosestPhotoSizeWithSize(arrayList3, AndroidUtilities.getPhotoSize())) != null) {
                        return getAttachFileName(closestPhotoSizeWithSize);
                    }
                }
            } else if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaInvoice) && (tLRPC$WebDocument = ((TLRPC$TL_messageMediaInvoice) tLRPC$MessageMedia).photo) != null) {
                return Utilities.MD5(tLRPC$WebDocument.url) + "." + ImageLoader.getHttpUrlExtension(tLRPC$WebDocument.url, getMimeTypePart(tLRPC$WebDocument.mime_type));
            }
        }
        return "";
    }

    public static File getPathToMessage(TLRPC$Message message) {
        TLRPC$PhotoSize closestPhotoSizeWithSize;
        TLRPC$PhotoSize closestPhotoSizeWithSize2;
        TLRPC$PhotoSize closestPhotoSizeWithSize3;
        if (message == null) {
            return new File("");
        }
        if (message instanceof TLRPC$TL_messageService) {
            TLRPC$Photo tLRPC$Photo = message.action.photo;
            if (tLRPC$Photo != null) {
                ArrayList<TLRPC$PhotoSize> arrayList = tLRPC$Photo.sizes;
                if (arrayList.size() > 0 && (closestPhotoSizeWithSize3 = getClosestPhotoSizeWithSize(arrayList, AndroidUtilities.getPhotoSize())) != null) {
                    return getPathToAttach(closestPhotoSizeWithSize3);
                }
            }
        } else {
            TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
            if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) {
                return getPathToAttach(tLRPC$MessageMedia.document, tLRPC$MessageMedia.ttl_seconds != 0);
            }
            if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) {
                ArrayList<TLRPC$PhotoSize> arrayList2 = tLRPC$MessageMedia.photo.sizes;
                if (arrayList2.size() > 0 && (closestPhotoSizeWithSize2 = getClosestPhotoSizeWithSize(arrayList2, AndroidUtilities.getPhotoSize(), false, null, true)) != null) {
                    return getPathToAttach(closestPhotoSizeWithSize2, message.media.ttl_seconds != 0);
                }
            } else if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
                TLRPC$WebPage tLRPC$WebPage = tLRPC$MessageMedia.webpage;
                TLRPC$Document tLRPC$Document = tLRPC$WebPage.document;
                if (tLRPC$Document != null) {
                    return getPathToAttach(tLRPC$Document);
                }
                TLRPC$Photo tLRPC$Photo2 = tLRPC$WebPage.photo;
                if (tLRPC$Photo2 != null) {
                    ArrayList<TLRPC$PhotoSize> arrayList3 = tLRPC$Photo2.sizes;
                    if (arrayList3.size() > 0 && (closestPhotoSizeWithSize = getClosestPhotoSizeWithSize(arrayList3, AndroidUtilities.getPhotoSize())) != null) {
                        return getPathToAttach(closestPhotoSizeWithSize);
                    }
                }
            } else if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaInvoice) {
                return getPathToAttach(((TLRPC$TL_messageMediaInvoice) tLRPC$MessageMedia).photo, true);
            }
        }
        return new File("");
    }

    public static File getPathToAttach(TLObject attach) {
        return getPathToAttach(attach, null, false);
    }

    public static File getPathToAttach(TLObject attach, boolean forceCache) {
        return getPathToAttach(attach, null, forceCache);
    }

    public static File getPathToAttach(TLObject attach, String ext, boolean forceCache) {
        return getPathToAttach(attach, null, ext, forceCache);
    }

    public static File getPathToAttach(TLObject attach, String size, String ext, boolean forceCache) {
        File directory;
        File directory2 = null;
        if (forceCache) {
            directory2 = getDirectory(4);
        } else {
            if (attach instanceof TLRPC$Document) {
                TLRPC$Document tLRPC$Document = (TLRPC$Document) attach;
                if (tLRPC$Document.key != null) {
                    directory = getDirectory(4);
                } else if (MessageObject.isVoiceDocument(tLRPC$Document)) {
                    directory = getDirectory(1);
                } else if (MessageObject.isVideoDocument(tLRPC$Document)) {
                    directory = getDirectory(2);
                } else {
                    directory = getDirectory(3);
                }
            } else {
                if (attach instanceof TLRPC$Photo) {
                    return getPathToAttach(getClosestPhotoSizeWithSize(((TLRPC$Photo) attach).sizes, AndroidUtilities.getPhotoSize()), ext, false);
                }
                if (attach instanceof TLRPC$PhotoSize) {
                    TLRPC$PhotoSize tLRPC$PhotoSize = (TLRPC$PhotoSize) attach;
                    if (!(tLRPC$PhotoSize instanceof TLRPC$TL_photoStrippedSize) && !(tLRPC$PhotoSize instanceof TLRPC$TL_photoPathSize)) {
                        TLRPC$FileLocation tLRPC$FileLocation = tLRPC$PhotoSize.location;
                        if (tLRPC$FileLocation == null || tLRPC$FileLocation.key != null || ((tLRPC$FileLocation.volume_id == -2147483648L && tLRPC$FileLocation.local_id < 0) || tLRPC$PhotoSize.size < 0)) {
                            directory = getDirectory(4);
                        } else {
                            directory = getDirectory(0);
                        }
                    }
                } else if (attach instanceof TLRPC$TL_videoSize) {
                    TLRPC$TL_videoSize tLRPC$TL_videoSize = (TLRPC$TL_videoSize) attach;
                    TLRPC$FileLocation tLRPC$FileLocation2 = tLRPC$TL_videoSize.location;
                    if (tLRPC$FileLocation2 == null || tLRPC$FileLocation2.key != null || ((tLRPC$FileLocation2.volume_id == -2147483648L && tLRPC$FileLocation2.local_id < 0) || tLRPC$TL_videoSize.size < 0)) {
                        directory = getDirectory(4);
                    } else {
                        directory = getDirectory(0);
                    }
                } else if (attach instanceof TLRPC$FileLocation) {
                    TLRPC$FileLocation tLRPC$FileLocation3 = (TLRPC$FileLocation) attach;
                    if (tLRPC$FileLocation3.key != null || (tLRPC$FileLocation3.volume_id == -2147483648L && tLRPC$FileLocation3.local_id < 0)) {
                        directory = getDirectory(4);
                    } else {
                        directory = getDirectory(0);
                    }
                } else if ((attach instanceof TLRPC$UserProfilePhoto) || (attach instanceof TLRPC$ChatPhoto)) {
                    if (size == null) {
                        size = "s";
                    }
                    if ("s".equals(size)) {
                        directory2 = getDirectory(4);
                    } else {
                        directory2 = getDirectory(0);
                    }
                } else if (attach instanceof WebFile) {
                    WebFile webFile = (WebFile) attach;
                    if (webFile.mime_type.startsWith("image/")) {
                        directory = getDirectory(0);
                    } else if (webFile.mime_type.startsWith("audio/")) {
                        directory = getDirectory(1);
                    } else if (webFile.mime_type.startsWith("video/")) {
                        directory = getDirectory(2);
                    } else {
                        directory = getDirectory(3);
                    }
                } else if ((attach instanceof TLRPC$TL_secureFile) || (attach instanceof SecureDocument)) {
                    directory2 = getDirectory(4);
                }
            }
            directory2 = directory;
        }
        if (directory2 == null) {
            return new File("");
        }
        return new File(directory2, getAttachFileName(attach, ext));
    }

    public static TLRPC$PhotoSize getClosestPhotoSizeWithSize(ArrayList<TLRPC$PhotoSize> sizes, int side) {
        return getClosestPhotoSizeWithSize(sizes, side, false);
    }

    public static TLRPC$PhotoSize getClosestPhotoSizeWithSize(ArrayList<TLRPC$PhotoSize> sizes, int side, boolean byMinSide) {
        return getClosestPhotoSizeWithSize(sizes, side, byMinSide, null, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x006b A[PHI: r6
      0x006b: PHI (r6v2 int) = (r6v1 int), (r6v1 int), (r6v1 int), (r6v1 int), (r6v4 int), (r6v4 int), (r6v4 int), (r6v4 int) binds: [B:36:0x0057, B:43:0x0065, B:45:0x0069, B:41:0x0061, B:24:0x003a, B:31:0x0048, B:33:0x004c, B:29:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ir.eitaa.tgnet.TLRPC$PhotoSize getClosestPhotoSizeWithSize(java.util.ArrayList<ir.eitaa.tgnet.TLRPC$PhotoSize> r8, int r9, boolean r10, ir.eitaa.tgnet.TLRPC$PhotoSize r11, boolean r12) {
        /*
            r0 = 0
            if (r8 == 0) goto L70
            boolean r1 = r8.isEmpty()
            if (r1 == 0) goto Lb
            goto L70
        Lb:
            r1 = 0
            r2 = 0
        Ld:
            int r3 = r8.size()
            if (r1 >= r3) goto L70
            java.lang.Object r3 = r8.get(r1)
            ir.eitaa.tgnet.TLRPC$PhotoSize r3 = (ir.eitaa.tgnet.TLRPC$PhotoSize) r3
            if (r3 == 0) goto L6d
            if (r3 == r11) goto L6d
            boolean r4 = r3 instanceof ir.eitaa.tgnet.TLRPC$TL_photoSizeEmpty
            if (r4 != 0) goto L6d
            boolean r4 = r3 instanceof ir.eitaa.tgnet.TLRPC$TL_photoPathSize
            if (r4 != 0) goto L6d
            if (r12 == 0) goto L2c
            boolean r4 = r3 instanceof ir.eitaa.tgnet.TLRPC$TL_photoStrippedSize
            if (r4 == 0) goto L2c
            goto L6d
        L2c:
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = 100
            if (r10 == 0) goto L4f
            int r6 = r3.h
            int r7 = r3.w
            int r6 = java.lang.Math.min(r6, r7)
            if (r0 == 0) goto L6b
            if (r9 <= r5) goto L46
            ir.eitaa.tgnet.TLRPC$FileLocation r5 = r0.location
            if (r5 == 0) goto L46
            int r5 = r5.dc_id
            if (r5 == r4) goto L6b
        L46:
            boolean r4 = r3 instanceof ir.eitaa.tgnet.TLRPC$TL_photoCachedSize
            if (r4 != 0) goto L6b
            if (r9 <= r2) goto L6d
            if (r2 >= r6) goto L6d
            goto L6b
        L4f:
            int r6 = r3.w
            int r7 = r3.h
            int r6 = java.lang.Math.max(r6, r7)
            if (r0 == 0) goto L6b
            if (r9 <= r5) goto L63
            ir.eitaa.tgnet.TLRPC$FileLocation r5 = r0.location
            if (r5 == 0) goto L63
            int r5 = r5.dc_id
            if (r5 == r4) goto L6b
        L63:
            boolean r4 = r3 instanceof ir.eitaa.tgnet.TLRPC$TL_photoCachedSize
            if (r4 != 0) goto L6b
            if (r6 > r9) goto L6d
            if (r2 >= r6) goto L6d
        L6b:
            r0 = r3
            r2 = r6
        L6d:
            int r1 = r1 + 1
            goto Ld
        L70:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.FileLoader.getClosestPhotoSizeWithSize(java.util.ArrayList, int, boolean, ir.eitaa.tgnet.TLRPC$PhotoSize, boolean):ir.eitaa.tgnet.TLRPC$PhotoSize");
    }

    public static TLRPC$TL_photoPathSize getPathPhotoSize(ArrayList<TLRPC$PhotoSize> sizes) {
        if (sizes != null && !sizes.isEmpty()) {
            for (int i = 0; i < sizes.size(); i++) {
                TLRPC$PhotoSize tLRPC$PhotoSize = sizes.get(i);
                if (!(tLRPC$PhotoSize instanceof TLRPC$TL_photoPathSize)) {
                    return (TLRPC$TL_photoPathSize) tLRPC$PhotoSize;
                }
            }
        }
        return null;
    }

    public static String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(46) + 1);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String fixFileName(String fileName) {
        return fileName != null ? fileName.replaceAll("[\u0001-\u001f<>\u202e:\"/\\\\|?*\u007f]+", "").trim() : fileName;
    }

    public static String getDocumentFileName(TLRPC$Document document) {
        String str = null;
        if (document != null) {
            String str2 = document.file_name;
            if (str2 != null) {
                str = str2;
            } else {
                for (int i = 0; i < document.attributes.size(); i++) {
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
                    if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeFilename) {
                        str = tLRPC$DocumentAttribute.file_name;
                    }
                }
            }
        }
        String strFixFileName = fixFileName(str);
        return strFixFileName != null ? strFixFileName : "";
    }

    public static String getMimeTypePart(String mime) {
        int iLastIndexOf = mime.lastIndexOf(47);
        return iLastIndexOf != -1 ? mime.substring(iLastIndexOf + 1) : "";
    }

    public static String getExtensionByMimeType(String mime) {
        if (mime == null) {
            return "";
        }
        switch (mime) {
            case "audio/ogg":
                return ".ogg";
            case "video/mp4":
                return ".mp4";
            case "video/x-matroska":
                return ".mkv";
            default:
                return "";
        }
    }

    public static File getInternalCacheDir() {
        return ApplicationLoader.applicationContext.getCacheDir();
    }

    public static String getDocumentExtension(TLRPC$Document document) {
        String documentFileName = getDocumentFileName(document);
        int iLastIndexOf = documentFileName.lastIndexOf(46);
        String strSubstring = iLastIndexOf != -1 ? documentFileName.substring(iLastIndexOf + 1) : null;
        if (strSubstring == null || strSubstring.length() == 0) {
            strSubstring = document.mime_type;
        }
        if (strSubstring == null) {
            strSubstring = "";
        }
        return strSubstring.toUpperCase();
    }

    public static String getAttachFileName(TLObject attach) {
        return getAttachFileName(attach, null);
    }

    public static String getAttachFileName(TLObject attach, String ext) {
        return getAttachFileName(attach, null, ext);
    }

    public static String getAttachFileName(TLObject attach, String size, String ext) {
        if (attach instanceof TLRPC$Document) {
            TLRPC$Document tLRPC$Document = (TLRPC$Document) attach;
            String documentFileName = getDocumentFileName(tLRPC$Document);
            int iLastIndexOf = documentFileName.lastIndexOf(46);
            String strSubstring = iLastIndexOf != -1 ? documentFileName.substring(iLastIndexOf) : "";
            if (strSubstring.length() <= 1) {
                strSubstring = getExtensionByMimeType(tLRPC$Document.mime_type);
            }
            if (strSubstring.length() > 1) {
                return tLRPC$Document.dc_id + "_" + tLRPC$Document.id + strSubstring;
            }
            return tLRPC$Document.dc_id + "_" + tLRPC$Document.id;
        }
        if (attach instanceof SecureDocument) {
            SecureDocument secureDocument = (SecureDocument) attach;
            return secureDocument.secureFile.dc_id + "_" + secureDocument.secureFile.id + ".jpg";
        }
        if (attach instanceof TLRPC$TL_secureFile) {
            TLRPC$TL_secureFile tLRPC$TL_secureFile = (TLRPC$TL_secureFile) attach;
            return tLRPC$TL_secureFile.dc_id + "_" + tLRPC$TL_secureFile.id + ".jpg";
        }
        if (attach instanceof WebFile) {
            WebFile webFile = (WebFile) attach;
            return Utilities.MD5(webFile.url) + "." + ImageLoader.getHttpUrlExtension(webFile.url, getMimeTypePart(webFile.mime_type));
        }
        if (attach instanceof TLRPC$PhotoSize) {
            TLRPC$PhotoSize tLRPC$PhotoSize = (TLRPC$PhotoSize) attach;
            TLRPC$FileLocation tLRPC$FileLocation = tLRPC$PhotoSize.location;
            if (tLRPC$FileLocation == null || (tLRPC$FileLocation instanceof TLRPC$TL_fileLocationUnavailable)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(tLRPC$PhotoSize.location.volume_id);
            sb.append("_");
            sb.append(tLRPC$PhotoSize.location.local_id);
            sb.append(".");
            if (ext == null) {
                ext = "jpg";
            }
            sb.append(ext);
            return sb.toString();
        }
        if (attach instanceof TLRPC$TL_videoSize) {
            TLRPC$TL_videoSize tLRPC$TL_videoSize = (TLRPC$TL_videoSize) attach;
            TLRPC$FileLocation tLRPC$FileLocation2 = tLRPC$TL_videoSize.location;
            if (tLRPC$FileLocation2 == null || (tLRPC$FileLocation2 instanceof TLRPC$TL_fileLocationUnavailable)) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(tLRPC$TL_videoSize.location.volume_id);
            sb2.append("_");
            sb2.append(tLRPC$TL_videoSize.location.local_id);
            sb2.append(".");
            if (ext == null) {
                ext = "mp4";
            }
            sb2.append(ext);
            return sb2.toString();
        }
        if (attach instanceof TLRPC$FileLocation) {
            if (attach instanceof TLRPC$TL_fileLocationUnavailable) {
                return "";
            }
            TLRPC$FileLocation tLRPC$FileLocation3 = (TLRPC$FileLocation) attach;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(tLRPC$FileLocation3.volume_id);
            sb3.append("_");
            sb3.append(tLRPC$FileLocation3.local_id);
            sb3.append(".");
            if (ext == null) {
                ext = "jpg";
            }
            sb3.append(ext);
            return sb3.toString();
        }
        if (attach instanceof TLRPC$UserProfilePhoto) {
            if (size == null) {
                size = "s";
            }
            TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = (TLRPC$UserProfilePhoto) attach;
            if (tLRPC$UserProfilePhoto.photo_small != null) {
                if ("s".equals(size)) {
                    return getAttachFileName(tLRPC$UserProfilePhoto.photo_small, ext);
                }
                return getAttachFileName(tLRPC$UserProfilePhoto.photo_big, ext);
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(tLRPC$UserProfilePhoto.photo_id);
            sb4.append("_");
            sb4.append(size);
            sb4.append(".");
            if (ext == null) {
                ext = "jpg";
            }
            sb4.append(ext);
            return sb4.toString();
        }
        if (!(attach instanceof TLRPC$ChatPhoto)) {
            return "";
        }
        TLRPC$ChatPhoto tLRPC$ChatPhoto = (TLRPC$ChatPhoto) attach;
        if (tLRPC$ChatPhoto.photo_small != null) {
            if ("s".equals(size)) {
                return getAttachFileName(tLRPC$ChatPhoto.photo_small, ext);
            }
            return getAttachFileName(tLRPC$ChatPhoto.photo_big, ext);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(tLRPC$ChatPhoto.photo_id);
        sb5.append("_");
        sb5.append(size);
        sb5.append(".");
        if (ext == null) {
            ext = "jpg";
        }
        sb5.append(ext);
        return sb5.toString();
    }

    public void deleteFiles(final ArrayList<File> files, final int type) {
        if (files == null || files.isEmpty()) {
            return;
        }
        fileLoaderQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLoader$RV4ARPGkKn30kqrBx23dCd1LY44
            @Override // java.lang.Runnable
            public final void run() {
                FileLoader.lambda$deleteFiles$11(files, type);
            }
        });
    }

    static /* synthetic */ void lambda$deleteFiles$11(ArrayList arrayList, int i) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            File file = (File) arrayList.get(i2);
            File file2 = new File(file.getAbsolutePath() + ".enc");
            if (file2.exists()) {
                try {
                    if (!file2.delete()) {
                        file2.deleteOnExit();
                    }
                } catch (Exception e) {
                    FileLog.e(e);
                }
                try {
                    File file3 = new File(getInternalCacheDir(), file.getName() + ".enc.key");
                    if (!file3.delete()) {
                        file3.deleteOnExit();
                    }
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            } else if (file.exists()) {
                try {
                    if (!file.delete()) {
                        file.deleteOnExit();
                    }
                } catch (Exception e3) {
                    FileLog.e(e3);
                }
            }
            try {
                File file4 = new File(file.getParentFile(), "q_" + file.getName());
                if (file4.exists() && !file4.delete()) {
                    file4.deleteOnExit();
                }
            } catch (Exception e4) {
                FileLog.e(e4);
            }
        }
        if (i == 2) {
            ImageLoader.getInstance().clearMemory();
        }
    }

    public static boolean isVideoMimeType(String mime) {
        return "video/mp4".equals(mime) || (SharedConfig.streamMkv && "video/x-matroska".equals(mime));
    }

    public static boolean copyFile(InputStream sourceFile, File destFile) throws IOException {
        return copyFile(sourceFile, destFile, -1);
    }

    public static boolean copyFile(InputStream sourceFile, File destFile, int maxSize) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(destFile);
        byte[] bArr = new byte[Factory.DEVICE_HAS_CRAPPY_AAUDIO];
        int i = 0;
        while (true) {
            int i2 = sourceFile.read(bArr);
            if (i2 <= 0) {
                break;
            }
            Thread.yield();
            fileOutputStream.write(bArr, 0, i2);
            i += i2;
            if (maxSize > 0 && i >= maxSize) {
                break;
            }
        }
        fileOutputStream.getFD().sync();
        fileOutputStream.close();
        return true;
    }

    public static boolean isSamePhoto(TLObject photo1, TLObject photo2) {
        if ((photo1 == null && photo2 != null) || (photo1 != null && photo2 == null)) {
            return false;
        }
        if (photo1 == null && photo2 == null) {
            return true;
        }
        if (photo1.getClass() != photo2.getClass()) {
            return false;
        }
        return photo1 instanceof TLRPC$UserProfilePhoto ? ((TLRPC$UserProfilePhoto) photo1).photo_id == ((TLRPC$UserProfilePhoto) photo2).photo_id : (photo1 instanceof TLRPC$ChatPhoto) && ((TLRPC$ChatPhoto) photo1).photo_id == ((TLRPC$ChatPhoto) photo2).photo_id;
    }

    public static boolean isSamePhoto(TLRPC$FileLocation location, TLRPC$Photo photo) {
        if (location != null && (photo instanceof TLRPC$TL_photo)) {
            int size = photo.sizes.size();
            for (int i = 0; i < size; i++) {
                TLRPC$FileLocation tLRPC$FileLocation = photo.sizes.get(i).location;
                if (tLRPC$FileLocation != null && tLRPC$FileLocation.local_id == location.local_id && tLRPC$FileLocation.volume_id == location.volume_id) {
                    return true;
                }
            }
            if ((-location.volume_id) == photo.id) {
                return true;
            }
        }
        return false;
    }

    public static long getPhotoId(TLObject object) {
        if (object instanceof TLRPC$Photo) {
            return ((TLRPC$Photo) object).id;
        }
        if (object instanceof TLRPC$ChatPhoto) {
            return ((TLRPC$ChatPhoto) object).photo_id;
        }
        if (object instanceof TLRPC$UserProfilePhoto) {
            return ((TLRPC$UserProfilePhoto) object).photo_id;
        }
        return 0L;
    }
}

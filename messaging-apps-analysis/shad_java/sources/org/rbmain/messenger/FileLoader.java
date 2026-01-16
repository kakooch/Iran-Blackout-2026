package org.rbmain.messenger;

import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidMessenger.proxy.IdStorage;
import androidMessenger.utilites.MessageConverter;
import androidMessenger.utilites.MyLog;
import ir.aaap.messengercore.LoadListener;
import ir.aaap.messengercore.model.api.RequestSendFileOutput;
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
import org.rbmain.messenger.FileUploadOperation;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$DocumentAttribute;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$InputEncryptedFile;
import org.rbmain.tgnet.TLRPC$InputFile;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$Photo;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeFilename;
import org.rbmain.tgnet.TLRPC$TL_fileLocationToBeDeprecated;
import org.rbmain.tgnet.TLRPC$TL_fileLocationUnavailable;
import org.rbmain.tgnet.TLRPC$TL_messageMediaDocument;
import org.rbmain.tgnet.TLRPC$TL_messageMediaInvoice;
import org.rbmain.tgnet.TLRPC$TL_messageMediaPhoto;
import org.rbmain.tgnet.TLRPC$TL_messageMediaWebPage;
import org.rbmain.tgnet.TLRPC$TL_messageService;
import org.rbmain.tgnet.TLRPC$TL_photo;
import org.rbmain.tgnet.TLRPC$TL_photoPathSize;
import org.rbmain.tgnet.TLRPC$TL_photoStrippedSize;
import org.rbmain.tgnet.TLRPC$TL_secureFile;
import org.rbmain.tgnet.TLRPC$TL_videoSize;
import org.rbmain.tgnet.TLRPC$TL_videoSizeEmojiMarkup;
import org.rbmain.tgnet.TLRPC$TL_videoSizeStickerMarkup;
import org.rbmain.tgnet.TLRPC$VideoSize;
import org.rbmain.tgnet.TLRPC$WebDocument;
import org.rbmain.tgnet.TLRPC$WebPage;

/* loaded from: classes4.dex */
public class FileLoader extends BaseController {
    public static final int IMAGE_TYPE_ANIMATION = 2;
    public static final int IMAGE_TYPE_LOTTIE = 1;
    public static final int IMAGE_TYPE_SVG = 3;
    public static final int IMAGE_TYPE_SVG_WHITE = 4;
    public static final int IMAGE_TYPE_THEME_PREVIEW = 5;
    public static long MAX_AUTO_DOWNLOAD_FILE_SIZE = 104857600;
    public static final long MAX_FILE_SIZE = 2097152000;
    public static final int MEDIA_DIR_AUDIO = 1;
    public static final int MEDIA_DIR_CACHE = 4;
    public static final int MEDIA_DIR_DOCUMENT = 3;
    public static final int MEDIA_DIR_IMAGE = 0;
    public static final int MEDIA_DIR_VIDEO = 2;
    public static final int PRELOAD_CACHE_TYPE = 11;
    public static final int PRIORITY_HIGH = 3;
    public static final int PRIORITY_LOW = 0;
    public static final int PRIORITY_NORMAL = 1;
    public static final int PRIORITY_NORMAL_UP = 2;
    private static final int PRIORITY_STREAM = 4;
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
        void fileDidFailedLoad(String str, int i);

        void fileDidFailedUpload(String str, boolean z);

        void fileDidLoaded(String str, File file, int i);

        void fileDidUploaded(String str, TLRPC$InputFile tLRPC$InputFile, TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile, byte[] bArr, byte[] bArr2, long j);

        void fileLoadProgressChanged(FileLoadOperation fileLoadOperation, String str, long j, long j2);

        void fileUploadProgressChanged(FileUploadOperation fileUploadOperation, String str, long j, long j2, boolean z);
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

    public static FileLoader getInstance(int i) {
        FileLoader fileLoader = Instance[i];
        if (fileLoader == null) {
            synchronized (FileLoader.class) {
                fileLoader = Instance[i];
                if (fileLoader == null) {
                    FileLoader[] fileLoaderArr = Instance;
                    FileLoader fileLoader2 = new FileLoader(i);
                    fileLoaderArr[i] = fileLoader2;
                    fileLoader = fileLoader2;
                }
            }
        }
        return fileLoader;
    }

    public FileLoader(int i) {
        super(i);
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

    public static void setMediaDirs(SparseArray<File> sparseArray) {
        mediaDirs = sparseArray;
    }

    public static File checkDirectory(int i) {
        return mediaDirs.get(i);
    }

    public static File getDirectory(int i) {
        File file = mediaDirs.get(i);
        if (file == null && i != 4) {
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

    public int getFileReference(Object obj) {
        int i = this.lastReferenceId;
        this.lastReferenceId = i + 1;
        this.parentObjectReferences.put(Integer.valueOf(i), obj);
        return i;
    }

    public Object getParentObject(int i) {
        return this.parentObjectReferences.get(Integer.valueOf(i));
    }

    /* renamed from: setLoadingVideoInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$setLoadingVideo$0(TLRPC$Document tLRPC$Document, boolean z) {
        String attachFileName = getAttachFileName(tLRPC$Document);
        StringBuilder sb = new StringBuilder();
        sb.append(attachFileName);
        sb.append(z ? "p" : io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
        this.loadingVideos.put(sb.toString(), Boolean.TRUE);
        getNotificationCenter().postNotificationName(NotificationCenter.videoLoadingStateChanged, attachFileName);
    }

    public void setLoadingVideo(final TLRPC$Document tLRPC$Document, final boolean z, boolean z2) {
        if (tLRPC$Document == null) {
            return;
        }
        if (z2) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.FileLoader$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setLoadingVideo$0(tLRPC$Document, z);
                }
            });
        } else {
            lambda$setLoadingVideo$0(tLRPC$Document, z);
        }
    }

    public void setLoadingVideoForPlayer(TLRPC$Document tLRPC$Document, boolean z) {
        if (tLRPC$Document == null) {
            return;
        }
        String attachFileName = getAttachFileName(tLRPC$Document);
        HashMap<String, Boolean> map = this.loadingVideos;
        StringBuilder sb = new StringBuilder();
        sb.append(attachFileName);
        String str = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        sb.append(z ? io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : "p");
        if (map.containsKey(sb.toString())) {
            HashMap<String, Boolean> map2 = this.loadingVideos;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(attachFileName);
            if (z) {
                str = "p";
            }
            sb2.append(str);
            map2.put(sb2.toString(), Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeLoadingVideoInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$removeLoadingVideo$1(TLRPC$Document tLRPC$Document, boolean z) {
        String attachFileName = getAttachFileName(tLRPC$Document);
        StringBuilder sb = new StringBuilder();
        sb.append(attachFileName);
        sb.append(z ? "p" : io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
        if (this.loadingVideos.remove(sb.toString()) != null) {
            getNotificationCenter().postNotificationName(NotificationCenter.videoLoadingStateChanged, attachFileName);
        }
    }

    public void removeLoadingVideo(final TLRPC$Document tLRPC$Document, final boolean z, boolean z2) {
        if (tLRPC$Document == null) {
            return;
        }
        if (z2) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.FileLoader$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeLoadingVideo$1(tLRPC$Document, z);
                }
            });
        } else {
            lambda$removeLoadingVideo$1(tLRPC$Document, z);
        }
    }

    public boolean isLoadingVideo(TLRPC$Document tLRPC$Document, boolean z) {
        if (tLRPC$Document != null) {
            HashMap<String, Boolean> map = this.loadingVideos;
            StringBuilder sb = new StringBuilder();
            sb.append(getAttachFileName(tLRPC$Document));
            sb.append(z ? "p" : io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
            if (map.containsKey(sb.toString())) {
                return true;
            }
        }
        return false;
    }

    public boolean isLoadingVideoAny(TLRPC$Document tLRPC$Document) {
        return isLoadingVideo(tLRPC$Document, false) || isLoadingVideo(tLRPC$Document, true);
    }

    public void cancelUploadFile(final String str, final boolean z) {
        fileLoaderQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoader$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cancelUploadFile$2(z, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancelUploadFile$2(boolean z, String str) {
        FileUploadOperation fileUploadOperation;
        if (!z) {
            fileUploadOperation = this.uploadOperationPaths.get(str);
        } else {
            fileUploadOperation = this.uploadOperationPathsEnc.get(str);
        }
        this.uploadSizes.remove(str);
        if (fileUploadOperation != null) {
            this.uploadOperationPathsEnc.remove(str);
            this.uploadOperationQueue.remove(fileUploadOperation);
            this.uploadSmallOperationQueue.remove(fileUploadOperation);
            fileUploadOperation.cancel();
        }
    }

    public void checkUploadNewDataAvailable(final String str, final boolean z, final long j, final long j2) {
        fileLoaderQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoader$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkUploadNewDataAvailable$3(z, str, j, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkUploadNewDataAvailable$3(boolean z, String str, long j, long j2) {
        FileUploadOperation fileUploadOperation;
        if (z) {
            fileUploadOperation = this.uploadOperationPathsEnc.get(str);
        } else {
            fileUploadOperation = this.uploadOperationPaths.get(str);
        }
        if (fileUploadOperation != null) {
            fileUploadOperation.checkNewDataAvailable(j, j2);
        } else if (j2 != 0) {
            this.uploadSizes.put(str, Long.valueOf(j2));
        }
    }

    public void onNetworkChanged(final boolean z) {
        fileLoaderQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoader$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onNetworkChanged$4(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onNetworkChanged$4(boolean z) {
        Iterator<Map.Entry<String, FileUploadOperation>> it = this.uploadOperationPaths.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onNetworkChanged(z);
        }
        Iterator<Map.Entry<String, FileUploadOperation>> it2 = this.uploadOperationPathsEnc.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().onNetworkChanged(z);
        }
    }

    public void uploadFile(String str, boolean z, boolean z2, int i, String str2) {
        uploadFile(str, z, z2, 0, i, false, str2);
    }

    public void uploadFile(final String str, final boolean z, final boolean z2, final int i, final int i2, boolean z3, final String str2) {
        if (str == null) {
            return;
        }
        fileLoaderQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoader$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$uploadFile$5(i, str, str2, i2, z, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadFile$5(final int i, final String str, String str2, final int i2, final boolean z, final boolean z2) {
        int length;
        if (i == 0) {
            try {
                length = (int) new File(str).length();
            } catch (Exception e) {
                if (MyLog.isDebugAble) {
                    MyLog.handleExceptionThrowOnDebug(e);
                    return;
                }
                return;
            }
        } else {
            length = i;
        }
        String fileNameAttached = MessageConverter.getFileNameAttached(str, str2, null);
        AccountInstance.getInstance(this.currentAccount).getCoreMainClass().requestSendFile(fileNameAttached, getMime(fileNameAttached), length, new LoadListener<RequestSendFileOutput>() { // from class: org.rbmain.messenger.FileLoader.1
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(RequestSendFileOutput requestSendFileOutput) {
                FileUploadOperation fileUploadOperation;
                FileUploadOperation fileUploadOperation2;
                if (requestSendFileOutput != null && requestSendFileOutput.access_hash_send != null) {
                    FileLoader.this.getFileLoader().uploadFile(str, false, false, i, i2, false, String.valueOf(requestSendFileOutput.id), requestSendFileOutput.upload_url, requestSendFileOutput.access_hash_send, requestSendFileOutput.dc_id);
                    return;
                }
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

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
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
                    if (FileLoader.this.currentUploadSmallOperationsCount < 1 && (fileUploadOperation2 = (FileUploadOperation) FileLoader.this.uploadSmallOperationQueue.poll()) != null) {
                        FileLoader.access$608(FileLoader.this);
                        fileUploadOperation2.start();
                    }
                } else {
                    FileLoader.access$810(FileLoader.this);
                    if (FileLoader.this.currentUploadOperationsCount < 1 && (fileUploadOperation = (FileUploadOperation) FileLoader.this.uploadOperationQueue.poll()) != null) {
                        FileLoader.access$808(FileLoader.this);
                        fileUploadOperation.start();
                    }
                }
                MyLog.e("MyTag", "RequestSendFile failed");
            }
        });
    }

    public void uploadFile(final String str, final boolean z, final boolean z2, final int i, final int i2, final boolean z3, final String str2, final String str3, final String str4, final String str5) {
        if (str == null) {
            return;
        }
        fileLoaderQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoader$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$uploadFile$6(z, str, i, i2, str2, str3, str4, str5, z3, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadFile$6(boolean z, String str, int i, int i2, String str2, String str3, String str4, String str5, boolean z2, boolean z3) {
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
        FileUploadOperation fileUploadOperation = new FileUploadOperation(this.currentAccount, str, z, i3, i2, str2, str3, str4, str5);
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
        fileUploadOperation.setDelegate(new AnonymousClass2(z, str, z3));
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

    /* renamed from: org.rbmain.messenger.FileLoader$2, reason: invalid class name */
    class AnonymousClass2 implements FileUploadOperation.FileUploadOperationDelegate {
        final /* synthetic */ boolean val$encrypted;
        final /* synthetic */ String val$location;
        final /* synthetic */ boolean val$small;

        AnonymousClass2(boolean z, String str, boolean z2) {
            this.val$encrypted = z;
            this.val$location = str;
            this.val$small = z2;
        }

        @Override // org.rbmain.messenger.FileUploadOperation.FileUploadOperationDelegate
        public void didFinishUploadingFile(final FileUploadOperation fileUploadOperation, final TLRPC$InputFile tLRPC$InputFile, final TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile, final byte[] bArr, final byte[] bArr2) {
            DispatchQueue dispatchQueue = FileLoader.fileLoaderQueue;
            final boolean z = this.val$encrypted;
            final String str = this.val$location;
            final boolean z2 = this.val$small;
            dispatchQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoader$2$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didFinishUploadingFile$0(z, str, z2, tLRPC$InputFile, tLRPC$InputEncryptedFile, bArr, bArr2, fileUploadOperation);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$didFinishUploadingFile$0(boolean z, String str, boolean z2, TLRPC$InputFile tLRPC$InputFile, TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile, byte[] bArr, byte[] bArr2, FileUploadOperation fileUploadOperation) {
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

        @Override // org.rbmain.messenger.FileUploadOperation.FileUploadOperationDelegate
        public void didFailedUploadingFile(FileUploadOperation fileUploadOperation) {
            DispatchQueue dispatchQueue = FileLoader.fileLoaderQueue;
            final boolean z = this.val$encrypted;
            final String str = this.val$location;
            final boolean z2 = this.val$small;
            dispatchQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoader$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didFailedUploadingFile$1(z, str, z2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$didFailedUploadingFile$1(boolean z, String str, boolean z2) {
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

        @Override // org.rbmain.messenger.FileUploadOperation.FileUploadOperationDelegate
        public void didChangedUploadProgress(FileUploadOperation fileUploadOperation, long j, long j2) {
            if (FileLoader.this.delegate != null) {
                FileLoader.this.delegate.fileUploadProgressChanged(fileUploadOperation, this.val$location, j, j2, this.val$encrypted);
            }
        }
    }

    private LinkedList<FileLoadOperation> getLoadOperationQueue(int i, int i2) {
        SparseArray<LinkedList<FileLoadOperation>> sparseArray;
        if (i2 == 2) {
            sparseArray = this.audioLoadOperationQueues;
        } else if (i2 == 1) {
            sparseArray = this.imageLoadOperationQueues;
        } else {
            sparseArray = this.fileLoadOperationQueues;
        }
        LinkedList<FileLoadOperation> linkedList = sparseArray.get(i);
        if (linkedList != null) {
            return linkedList;
        }
        LinkedList<FileLoadOperation> linkedList2 = new LinkedList<>();
        sparseArray.put(i, linkedList2);
        return linkedList2;
    }

    private SparseIntArray getLoadOperationCount(int i) {
        if (i == 2) {
            return this.audioLoadOperationsCount;
        }
        if (i == 1) {
            return this.imageLoadOperationsCount;
        }
        return this.fileLoadOperationsCount;
    }

    public void setForceStreamLoadingFile(final TLRPC$FileLocation tLRPC$FileLocation, final String str) {
        if (tLRPC$FileLocation == null) {
            return;
        }
        fileLoaderQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoader$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setForceStreamLoadingFile$7(tLRPC$FileLocation, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setForceStreamLoadingFile$7(TLRPC$FileLocation tLRPC$FileLocation, String str) {
        String attachFileName = getAttachFileName(tLRPC$FileLocation, str);
        this.forceLoadingFile = attachFileName;
        FileLoadOperation fileLoadOperation = this.loadOperationPaths.get(attachFileName);
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

    public void cancelLoadFile(TLRPC$Document tLRPC$Document) {
        cancelLoadFile(tLRPC$Document, false);
    }

    public void cancelLoadFile(TLRPC$Document tLRPC$Document, boolean z) {
        cancelLoadFile(tLRPC$Document, null, null, null, null, null, z);
    }

    public void cancelLoadFile(SecureDocument secureDocument) {
        cancelLoadFile(null, secureDocument, null, null, null, null, false);
    }

    public void cancelLoadFile(WebFile webFile) {
        cancelLoadFile(null, null, webFile, null, null, null, false);
    }

    public void cancelLoadFile(TLRPC$PhotoSize tLRPC$PhotoSize) {
        cancelLoadFile(tLRPC$PhotoSize, false);
    }

    public void cancelLoadFile(TLRPC$PhotoSize tLRPC$PhotoSize, boolean z) {
        cancelLoadFile(null, null, null, tLRPC$PhotoSize.location, null, null, z);
    }

    public void cancelLoadFile(TLRPC$FileLocation tLRPC$FileLocation, String str) {
        cancelLoadFile(tLRPC$FileLocation, str, false);
    }

    public void cancelLoadFile(TLRPC$FileLocation tLRPC$FileLocation, String str, boolean z) {
        cancelLoadFile(null, null, null, tLRPC$FileLocation, str, null, z);
    }

    public void cancelLoadFile(String str) {
        cancelLoadFile(null, null, null, null, null, str, true);
    }

    public void cancelLoadFiles(ArrayList<String> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            cancelLoadFile(null, null, null, null, null, arrayList.get(i), true);
        }
    }

    private void cancelLoadFile(TLRPC$Document tLRPC$Document, SecureDocument secureDocument, WebFile webFile, TLRPC$FileLocation tLRPC$FileLocation, String str, final String str2, final boolean z) {
        if (tLRPC$FileLocation == null && tLRPC$Document == null && webFile == null && secureDocument == null && TextUtils.isEmpty(str2)) {
            return;
        }
        if (tLRPC$FileLocation != null) {
            str2 = getAttachFileName(tLRPC$FileLocation, str);
        } else if (tLRPC$Document != null) {
            str2 = getAttachFileName(tLRPC$Document);
        } else if (secureDocument != null) {
            str2 = getAttachFileName(secureDocument);
        } else if (webFile != null) {
            str2 = getAttachFileName(webFile);
        }
        this.loadOperationPathsUI.remove(str2);
        fileLoaderQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoader$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cancelLoadFile$8(str2, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancelLoadFile$8(String str, boolean z) {
        FileLoadOperation fileLoadOperationRemove = this.loadOperationPaths.remove(str);
        if (fileLoadOperationRemove != null) {
            int queueType = fileLoadOperationRemove.getQueueType();
            int datacenterId = fileLoadOperationRemove.getDatacenterId();
            if (!getLoadOperationQueue(datacenterId, queueType).remove(fileLoadOperationRemove)) {
                getLoadOperationCount(queueType).put(datacenterId, r2.get(datacenterId) - 1);
            }
            if (queueType == 0) {
                this.activeFileLoadOperation.remove(fileLoadOperationRemove);
            }
            fileLoadOperationRemove.cancel(z);
        }
    }

    public boolean isLoadingFile(String str) {
        return str != null && this.loadOperationPathsUI.containsKey(str);
    }

    public float getBufferedProgressFromPosition(float f, String str) {
        FileLoadOperation fileLoadOperation;
        if (TextUtils.isEmpty(str) || (fileLoadOperation = this.loadOperationPaths.get(str)) == null) {
            return 0.0f;
        }
        return fileLoadOperation.getDownloadedLengthFromOffset(f);
    }

    public void loadFile(ImageLocation imageLocation, Object obj, String str, int i, int i2) {
        if (imageLocation == null) {
            return;
        }
        loadFile(imageLocation.document, imageLocation.secureDocument, imageLocation.webFile, imageLocation.location, imageLocation, obj, str, imageLocation.getSize(), i, (i2 != 0 || (!imageLocation.isEncrypted() && (imageLocation.photoSize == null || imageLocation.getSize() != 0))) ? i2 : 1);
    }

    public void loadFile(SecureDocument secureDocument, int i) {
        if (secureDocument == null) {
            return;
        }
        loadFile(null, secureDocument, null, null, null, null, null, 0, i, 1);
    }

    public void loadFile(TLRPC$Document tLRPC$Document, Object obj, int i, int i2) {
        if (tLRPC$Document == null) {
            return;
        }
        loadFile(tLRPC$Document, null, null, null, null, obj, null, 0, i, (i2 != 0 || tLRPC$Document.key == null) ? i2 : 1);
    }

    public void loadFile(WebFile webFile, int i, int i2) {
        loadFile(null, null, webFile, null, null, null, null, 0, i, i2);
    }

    private void pauseCurrentFileLoadOperations(FileLoadOperation fileLoadOperation) {
        int i = 0;
        while (i < this.activeFileLoadOperation.size()) {
            FileLoadOperation fileLoadOperation2 = this.activeFileLoadOperation.get(i);
            if (fileLoadOperation2 != fileLoadOperation && fileLoadOperation2.getDatacenterId() == fileLoadOperation.getDatacenterId() && !fileLoadOperation2.getFileName().equals(this.forceLoadingFile)) {
                this.activeFileLoadOperation.remove(fileLoadOperation2);
                i--;
                int datacenterId = fileLoadOperation2.getDatacenterId();
                int queueType = fileLoadOperation2.getQueueType();
                LinkedList<FileLoadOperation> loadOperationQueue = getLoadOperationQueue(datacenterId, queueType);
                SparseIntArray loadOperationCount = getLoadOperationCount(queueType);
                loadOperationQueue.add(0, fileLoadOperation2);
                if (fileLoadOperation2.wasStarted()) {
                    loadOperationCount.put(datacenterId, loadOperationCount.get(datacenterId) - 1);
                }
                fileLoadOperation2.pause();
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.rbmain.messenger.FileLoadOperation loadFileInternal(org.rbmain.tgnet.TLRPC$Document r21, org.rbmain.messenger.SecureDocument r22, org.rbmain.messenger.WebFile r23, org.rbmain.tgnet.TLRPC$TL_fileLocationToBeDeprecated r24, org.rbmain.messenger.ImageLocation r25, java.lang.Object r26, java.lang.String r27, int r28, int r29, org.rbmain.messenger.FileLoadOperationStream r30, int r31, boolean r32, int r33) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.FileLoader.loadFileInternal(org.rbmain.tgnet.TLRPC$Document, org.rbmain.messenger.SecureDocument, org.rbmain.messenger.WebFile, org.rbmain.tgnet.TLRPC$TL_fileLocationToBeDeprecated, org.rbmain.messenger.ImageLocation, java.lang.Object, java.lang.String, int, int, org.rbmain.messenger.FileLoadOperationStream, int, boolean, int):org.rbmain.messenger.FileLoadOperation");
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

    private void loadFile(final TLRPC$Document tLRPC$Document, final SecureDocument secureDocument, final WebFile webFile, final TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated, final ImageLocation imageLocation, final Object obj, final String str, final int i, final int i2, final int i3) {
        String attachFileName;
        if (tLRPC$TL_fileLocationToBeDeprecated != null) {
            attachFileName = getAttachFileName(tLRPC$TL_fileLocationToBeDeprecated, str);
        } else if (tLRPC$Document != null) {
            attachFileName = getAttachFileName(tLRPC$Document);
        } else {
            attachFileName = webFile != null ? getAttachFileName(webFile) : null;
        }
        if (i3 != 10 && !TextUtils.isEmpty(attachFileName) && !attachFileName.contains("-2147483648")) {
            this.loadOperationPathsUI.put(attachFileName, Boolean.TRUE);
        }
        fileLoaderQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoader$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadFile$9(tLRPC$Document, secureDocument, webFile, tLRPC$TL_fileLocationToBeDeprecated, imageLocation, obj, str, i, i2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadFile$9(TLRPC$Document tLRPC$Document, SecureDocument secureDocument, WebFile webFile, TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated, ImageLocation imageLocation, Object obj, String str, int i, int i2, int i3) {
        loadFileInternal(tLRPC$Document, secureDocument, webFile, tLRPC$TL_fileLocationToBeDeprecated, imageLocation, obj, str, i, i2, null, 0, false, i3);
    }

    protected FileLoadOperation loadStreamFile(final FileLoadOperationStream fileLoadOperationStream, final TLRPC$Document tLRPC$Document, final ImageLocation imageLocation, final Object obj, final int i, final boolean z) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final FileLoadOperation[] fileLoadOperationArr = new FileLoadOperation[1];
        fileLoaderQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoader$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadStreamFile$10(fileLoadOperationArr, tLRPC$Document, imageLocation, obj, fileLoadOperationStream, i, z, countDownLatch);
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
    public /* synthetic */ void lambda$loadStreamFile$10(FileLoadOperation[] fileLoadOperationArr, TLRPC$Document tLRPC$Document, ImageLocation imageLocation, Object obj, FileLoadOperationStream fileLoadOperationStream, int i, boolean z, CountDownLatch countDownLatch) {
        String str = null;
        TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated = (tLRPC$Document != null || imageLocation == null) ? null : imageLocation.location;
        if (tLRPC$Document == null && imageLocation != null) {
            str = "mp4";
        }
        fileLoadOperationArr[0] = loadFileInternal(tLRPC$Document, null, null, tLRPC$TL_fileLocationToBeDeprecated, imageLocation, obj, str, (tLRPC$Document != null || imageLocation == null) ? 0 : imageLocation.currentSize, 1, fileLoadOperationStream, i, z, tLRPC$Document == null ? 1 : 0);
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkDownloadQueue(final int i, final int i2, final String str) {
        fileLoaderQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoader$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkDownloadQueue$11(str, i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$checkDownloadQueue$11(java.lang.String r7, int r8, int r9) {
        /*
            r6 = this;
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, org.rbmain.messenger.FileLoadOperation> r0 = r6.loadOperationPaths
            java.lang.Object r7 = r0.remove(r7)
            org.rbmain.messenger.FileLoadOperation r7 = (org.rbmain.messenger.FileLoadOperation) r7
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
            java.util.ArrayList<org.rbmain.messenger.FileLoadOperation> r3 = r6.activeFileLoadOperation
            r3.remove(r7)
        L2c:
            boolean r7 = r0.isEmpty()
            if (r7 != 0) goto L7d
            r7 = 0
            java.lang.Object r7 = r0.get(r7)
            org.rbmain.messenger.FileLoadOperation r7 = (org.rbmain.messenger.FileLoadOperation) r7
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
            org.rbmain.messenger.FileLoadOperation r7 = (org.rbmain.messenger.FileLoadOperation) r7
            if (r7 == 0) goto L2c
            boolean r3 = r7.start()
            if (r3 == 0) goto L2c
            int r2 = r2 + 1
            r1.put(r8, r2)
            if (r9 != 0) goto L2c
            java.util.ArrayList<org.rbmain.messenger.FileLoadOperation> r3 = r6.activeFileLoadOperation
            boolean r3 = r3.contains(r7)
            if (r3 != 0) goto L2c
            java.util.ArrayList<org.rbmain.messenger.FileLoadOperation> r3 = r6.activeFileLoadOperation
            r3.add(r7)
            goto L2c
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.FileLoader.lambda$checkDownloadQueue$11(java.lang.String, int, int):void");
    }

    public void setDelegate(FileLoaderDelegate fileLoaderDelegate) {
        this.delegate = fileLoaderDelegate;
    }

    public static String getMessageFileName(TLRPC$Message tLRPC$Message) {
        TLRPC$WebDocument tLRPC$WebDocument;
        TLRPC$PhotoSize closestPhotoSizeWithSize;
        TLRPC$PhotoSize closestPhotoSizeWithSize2;
        TLRPC$PhotoSize closestPhotoSizeWithSize3;
        if (tLRPC$Message == null) {
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
        if (tLRPC$Message instanceof TLRPC$TL_messageService) {
            TLRPC$Photo tLRPC$Photo = tLRPC$Message.action.photo;
            if (tLRPC$Photo != null) {
                ArrayList<TLRPC$PhotoSize> arrayList = tLRPC$Photo.sizes;
                if (arrayList.size() > 0 && (closestPhotoSizeWithSize3 = getClosestPhotoSizeWithSize(arrayList, AndroidUtilities.getPhotoSize())) != null) {
                    return getAttachFileName(closestPhotoSizeWithSize3);
                }
            }
        } else {
            TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
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
            } else if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaInvoice) && (tLRPC$WebDocument = ((TLRPC$TL_messageMediaInvoice) tLRPC$MessageMedia).webPhoto) != null) {
                return Utilities.MD5(tLRPC$WebDocument.url) + "." + ImageLoader.getHttpUrlExtension(tLRPC$WebDocument.url, getMimeTypePart(tLRPC$WebDocument.mime_type));
            }
        }
        return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
    }

    public static File getPathToMessage(TLRPC$Message tLRPC$Message) {
        TLRPC$PhotoSize closestPhotoSizeWithSize;
        TLRPC$PhotoSize closestPhotoSizeWithSize2;
        TLRPC$PhotoSize closestPhotoSizeWithSize3;
        if (tLRPC$Message == null) {
            return new File(io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
        }
        if (tLRPC$Message instanceof TLRPC$TL_messageService) {
            TLRPC$Photo tLRPC$Photo = tLRPC$Message.action.photo;
            if (tLRPC$Photo != null) {
                ArrayList<TLRPC$PhotoSize> arrayList = tLRPC$Photo.sizes;
                if (arrayList.size() > 0 && (closestPhotoSizeWithSize3 = getClosestPhotoSizeWithSize(arrayList, AndroidUtilities.getPhotoSize())) != null) {
                    return getPathToAttach(closestPhotoSizeWithSize3);
                }
            }
        } else {
            TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
            if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) {
                return getPathToAttach(tLRPC$MessageMedia.document, tLRPC$MessageMedia.ttl_seconds != 0);
            }
            if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) {
                ArrayList<TLRPC$PhotoSize> arrayList2 = tLRPC$MessageMedia.photo.sizes;
                if (arrayList2.size() > 0 && (closestPhotoSizeWithSize2 = getClosestPhotoSizeWithSize(arrayList2, AndroidUtilities.getPhotoSize(), false, null, true)) != null) {
                    return getPathToAttach(closestPhotoSizeWithSize2, tLRPC$Message.media.ttl_seconds != 0);
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
                return getPathToAttach(((TLRPC$TL_messageMediaInvoice) tLRPC$MessageMedia).webPhoto, true);
            }
        }
        return new File(io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
    }

    public static File getPathToAttach(TLObject tLObject) {
        return getPathToAttach(tLObject, null, false);
    }

    public static File getPathToAttach(TLObject tLObject, boolean z) {
        return getPathToAttach(tLObject, null, z);
    }

    public static File getPathToAttach(TLObject tLObject, String str, boolean z) {
        File directory;
        File directory2 = null;
        if (z) {
            directory2 = getDirectory(4);
        } else {
            if (tLObject instanceof TLRPC$Document) {
                TLRPC$Document tLRPC$Document = (TLRPC$Document) tLObject;
                if (tLRPC$Document.key != null) {
                    directory = getDirectory(4);
                } else if (MessageObject.isVoiceDocument(tLRPC$Document)) {
                    directory = getDirectory(1);
                } else if (MessageObject.isVideoDocument(tLRPC$Document) || MessageObject.isVideoFileDocument(tLRPC$Document)) {
                    directory = getDirectory(2);
                } else {
                    directory = getDirectory(3);
                }
            } else {
                if (tLObject instanceof TLRPC$Photo) {
                    return getPathToAttach(getClosestPhotoSizeWithSize(((TLRPC$Photo) tLObject).sizes, AndroidUtilities.getPhotoSize()), str, false);
                }
                if (tLObject instanceof TLRPC$PhotoSize) {
                    TLRPC$PhotoSize tLRPC$PhotoSize = (TLRPC$PhotoSize) tLObject;
                    if (!(tLRPC$PhotoSize instanceof TLRPC$TL_photoStrippedSize) && !(tLRPC$PhotoSize instanceof TLRPC$TL_photoPathSize)) {
                        TLRPC$FileLocation tLRPC$FileLocation = tLRPC$PhotoSize.location;
                        if (tLRPC$FileLocation == null || tLRPC$FileLocation.key != null || ((tLRPC$FileLocation.volume_id == -2147483648L && tLRPC$FileLocation.local_id < 0) || tLRPC$PhotoSize.size < 0)) {
                            directory = getDirectory(4);
                        } else {
                            directory = getDirectory(0);
                        }
                    }
                } else if (tLObject instanceof TLRPC$TL_videoSize) {
                    TLRPC$TL_videoSize tLRPC$TL_videoSize = (TLRPC$TL_videoSize) tLObject;
                    TLRPC$FileLocation tLRPC$FileLocation2 = tLRPC$TL_videoSize.location;
                    if (tLRPC$FileLocation2 == null || tLRPC$FileLocation2.key != null || ((tLRPC$FileLocation2.volume_id == -2147483648L && tLRPC$FileLocation2.local_id < 0) || tLRPC$TL_videoSize.size < 0)) {
                        directory = getDirectory(4);
                    } else {
                        directory = getDirectory(0);
                    }
                } else if (tLObject instanceof TLRPC$FileLocation) {
                    TLRPC$FileLocation tLRPC$FileLocation3 = (TLRPC$FileLocation) tLObject;
                    if (tLRPC$FileLocation3.key != null || (tLRPC$FileLocation3.volume_id == -2147483648L && tLRPC$FileLocation3.local_id < 0)) {
                        directory = getDirectory(4);
                    } else {
                        directory = getDirectory(0);
                    }
                } else if (tLObject instanceof WebFile) {
                    WebFile webFile = (WebFile) tLObject;
                    if (webFile.mime_type.startsWith("image/")) {
                        directory = getDirectory(0);
                    } else if (webFile.mime_type.startsWith("audio/")) {
                        directory = getDirectory(1);
                    } else if (webFile.mime_type.startsWith("video/")) {
                        directory = getDirectory(2);
                    } else {
                        directory = getDirectory(3);
                    }
                } else if ((tLObject instanceof TLRPC$TL_secureFile) || (tLObject instanceof SecureDocument)) {
                    directory2 = getDirectory(4);
                }
            }
            directory2 = directory;
        }
        if (directory2 == null) {
            return new File(io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
        }
        return new File(directory2, getAttachFileName(tLObject, str));
    }

    public static TLRPC$PhotoSize getClosestPhotoSizeWithSize(ArrayList<TLRPC$PhotoSize> arrayList, int i) {
        return getClosestPhotoSizeWithSize(arrayList, i, false);
    }

    public static TLRPC$PhotoSize getClosestPhotoSizeWithSize(ArrayList<TLRPC$PhotoSize> arrayList, int i, boolean z) {
        return getClosestPhotoSizeWithSize(arrayList, i, z, null, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x006b A[PHI: r6
      0x006b: PHI (r6v2 int) = (r6v1 int), (r6v1 int), (r6v1 int), (r6v1 int), (r6v4 int), (r6v4 int), (r6v4 int), (r6v4 int) binds: [B:36:0x0057, B:43:0x0065, B:45:0x0069, B:41:0x0061, B:24:0x003a, B:31:0x0048, B:33:0x004c, B:29:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.rbmain.tgnet.TLRPC$PhotoSize getClosestPhotoSizeWithSize(java.util.ArrayList<org.rbmain.tgnet.TLRPC$PhotoSize> r8, int r9, boolean r10, org.rbmain.tgnet.TLRPC$PhotoSize r11, boolean r12) {
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
            org.rbmain.tgnet.TLRPC$PhotoSize r3 = (org.rbmain.tgnet.TLRPC$PhotoSize) r3
            if (r3 == 0) goto L6d
            if (r3 == r11) goto L6d
            boolean r4 = r3 instanceof org.rbmain.tgnet.TLRPC$TL_photoSizeEmpty
            if (r4 != 0) goto L6d
            boolean r4 = r3 instanceof org.rbmain.tgnet.TLRPC$TL_photoPathSize
            if (r4 != 0) goto L6d
            if (r12 == 0) goto L2c
            boolean r4 = r3 instanceof org.rbmain.tgnet.TLRPC$TL_photoStrippedSize
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
            org.rbmain.tgnet.TLRPC$FileLocation r5 = r0.location
            if (r5 == 0) goto L46
            int r5 = r5.dc_id
            if (r5 == r4) goto L6b
        L46:
            boolean r4 = r3 instanceof org.rbmain.tgnet.TLRPC$TL_photoCachedSize
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
            org.rbmain.tgnet.TLRPC$FileLocation r5 = r0.location
            if (r5 == 0) goto L63
            int r5 = r5.dc_id
            if (r5 == r4) goto L6b
        L63:
            boolean r4 = r3 instanceof org.rbmain.tgnet.TLRPC$TL_photoCachedSize
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
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.FileLoader.getClosestPhotoSizeWithSize(java.util.ArrayList, int, boolean, org.rbmain.tgnet.TLRPC$PhotoSize, boolean):org.rbmain.tgnet.TLRPC$PhotoSize");
    }

    public static TLRPC$TL_photoPathSize getPathPhotoSize(ArrayList<TLRPC$PhotoSize> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i = 0; i < arrayList.size(); i++) {
                TLRPC$PhotoSize tLRPC$PhotoSize = arrayList.get(i);
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
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
    }

    public static String fixFileName(String str) {
        return str != null ? str.replaceAll("[\u0001-\u001f<>\u202e:\"/\\\\|?*\u007f]+", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR).trim() : str;
    }

    public static String getDocumentFileName(TLRPC$Document tLRPC$Document) {
        String str = null;
        if (tLRPC$Document != null) {
            String str2 = tLRPC$Document.file_name;
            if (str2 != null) {
                str = str2;
            } else {
                for (int i = 0; i < tLRPC$Document.attributes.size(); i++) {
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute = tLRPC$Document.attributes.get(i);
                    if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeFilename) {
                        str = tLRPC$DocumentAttribute.file_name;
                    }
                }
            }
        }
        String strFixFileName = fixFileName(str);
        return strFixFileName != null ? strFixFileName : io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
    }

    public static String getMimeTypePart(String str) {
        int iLastIndexOf = str.lastIndexOf(47);
        return iLastIndexOf != -1 ? str.substring(iLastIndexOf + 1) : io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
    }

    public static String getMime(String str) {
        int iLastIndexOf;
        return (str == null || str.isEmpty() || (iLastIndexOf = str.lastIndexOf(46)) == -1) ? io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : str.substring(iLastIndexOf + 1);
    }

    public static String getExtensionByMimeType(String str) {
        if (str == null) {
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
        switch (str) {
            case "audio/ogg":
                return ".ogg";
            case "video/mp4":
                return ".mp4";
            case "video/x-matroska":
                return ".mkv";
            default:
                return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
    }

    public static File getInternalCacheDir() {
        return ApplicationLoader.applicationContext.getCacheDir();
    }

    public static String getDocumentExtension(TLRPC$Document tLRPC$Document) {
        String documentFileName = getDocumentFileName(tLRPC$Document);
        int iLastIndexOf = documentFileName.lastIndexOf(46);
        String strSubstring = iLastIndexOf != -1 ? documentFileName.substring(iLastIndexOf + 1) : null;
        if (strSubstring == null || strSubstring.length() == 0) {
            strSubstring = tLRPC$Document.mime_type;
        }
        if (strSubstring == null) {
            strSubstring = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
        return strSubstring.toUpperCase();
    }

    public static String getAttachFileName(TLObject tLObject) {
        return getAttachFileName(tLObject, null);
    }

    public static String getAttachFileName(TLObject tLObject, String str) {
        boolean z = tLObject instanceof TLRPC$Document;
        String extensionByMimeType = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        if (z) {
            TLRPC$Document tLRPC$Document = (TLRPC$Document) tLObject;
            String documentFileName = getDocumentFileName(tLRPC$Document);
            int iLastIndexOf = documentFileName.lastIndexOf(46);
            if (iLastIndexOf != -1) {
                extensionByMimeType = documentFileName.substring(iLastIndexOf);
            }
            if (extensionByMimeType.length() <= 1) {
                extensionByMimeType = getExtensionByMimeType(tLRPC$Document.mime_type);
            }
            String dcId = IdStorage.getInstance().getDcId(tLRPC$Document.dc_id);
            if (extensionByMimeType.length() > 1) {
                return dcId + "_" + tLRPC$Document.id + extensionByMimeType;
            }
            return dcId + "_" + tLRPC$Document.id;
        }
        if (tLObject instanceof SecureDocument) {
            SecureDocument secureDocument = (SecureDocument) tLObject;
            return secureDocument.secureFile.dc_id + "_" + secureDocument.secureFile.id + ".jpg";
        }
        if (tLObject instanceof TLRPC$TL_secureFile) {
            TLRPC$TL_secureFile tLRPC$TL_secureFile = (TLRPC$TL_secureFile) tLObject;
            return tLRPC$TL_secureFile.dc_id + "_" + tLRPC$TL_secureFile.id + ".jpg";
        }
        if (tLObject instanceof WebFile) {
            WebFile webFile = (WebFile) tLObject;
            return Utilities.MD5(webFile.url) + "." + ImageLoader.getHttpUrlExtension(webFile.url, getMimeTypePart(webFile.mime_type));
        }
        if (tLObject instanceof TLRPC$PhotoSize) {
            TLRPC$PhotoSize tLRPC$PhotoSize = (TLRPC$PhotoSize) tLObject;
            TLRPC$FileLocation tLRPC$FileLocation = tLRPC$PhotoSize.location;
            if (tLRPC$FileLocation == null || (tLRPC$FileLocation instanceof TLRPC$TL_fileLocationUnavailable)) {
                return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(tLRPC$PhotoSize.location.volume_id);
            sb.append("_");
            sb.append(tLRPC$PhotoSize.location.local_id);
            sb.append(".");
            if (str == null) {
                str = "jpg";
            }
            sb.append(str);
            return sb.toString();
        }
        if (tLObject instanceof TLRPC$TL_videoSize) {
            TLRPC$TL_videoSize tLRPC$TL_videoSize = (TLRPC$TL_videoSize) tLObject;
            TLRPC$FileLocation tLRPC$FileLocation2 = tLRPC$TL_videoSize.location;
            if (tLRPC$FileLocation2 == null || (tLRPC$FileLocation2 instanceof TLRPC$TL_fileLocationUnavailable)) {
                return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(tLRPC$TL_videoSize.location.volume_id);
            sb2.append("_");
            sb2.append(tLRPC$TL_videoSize.location.local_id);
            sb2.append(".");
            if (str == null) {
                str = "mp4";
            }
            sb2.append(str);
            return sb2.toString();
        }
        if (!(tLObject instanceof TLRPC$FileLocation) || (tLObject instanceof TLRPC$TL_fileLocationUnavailable)) {
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
        TLRPC$FileLocation tLRPC$FileLocation3 = (TLRPC$FileLocation) tLObject;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(tLRPC$FileLocation3.volume_id);
        sb3.append("_");
        sb3.append(tLRPC$FileLocation3.local_id);
        sb3.append(".");
        if (str == null) {
            str = "jpg";
        }
        sb3.append(str);
        return sb3.toString();
    }

    public void deleteFiles(final ArrayList<File> arrayList, final int i) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        fileLoaderQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FileLoader.lambda$deleteFiles$12(arrayList, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$deleteFiles$12(ArrayList arrayList, int i) {
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

    public static boolean isVideoMimeType(String str) {
        return "video/mp4".equals(str) || (SharedConfig.streamMkv && "video/x-matroska".equals(str));
    }

    public static boolean copyFile(InputStream inputStream, File file) throws IOException {
        return copyFile(inputStream, file, -1);
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

    public static boolean isSamePhoto(TLRPC$FileLocation tLRPC$FileLocation, TLRPC$Photo tLRPC$Photo) {
        if (tLRPC$FileLocation != null && (tLRPC$Photo instanceof TLRPC$TL_photo)) {
            int size = tLRPC$Photo.sizes.size();
            for (int i = 0; i < size; i++) {
                TLRPC$FileLocation tLRPC$FileLocation2 = tLRPC$Photo.sizes.get(i).location;
                if (tLRPC$FileLocation2 != null && tLRPC$FileLocation2.local_id == tLRPC$FileLocation.local_id && tLRPC$FileLocation2.volume_id == tLRPC$FileLocation.volume_id) {
                    return true;
                }
            }
        }
        return false;
    }

    public static TLRPC$VideoSize getEmojiMarkup(ArrayList<TLRPC$VideoSize> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if ((arrayList.get(i) instanceof TLRPC$TL_videoSizeEmojiMarkup) || (arrayList.get(i) instanceof TLRPC$TL_videoSizeStickerMarkup)) {
                return arrayList.get(i);
            }
        }
        return null;
    }

    public static TLRPC$VideoSize getClosestVideoSizeWithSize(ArrayList<TLRPC$VideoSize> arrayList, int i) {
        return getClosestVideoSizeWithSize(arrayList, i, false);
    }

    public static TLRPC$VideoSize getClosestVideoSizeWithSize(ArrayList<TLRPC$VideoSize> arrayList, int i, boolean z) {
        return getClosestVideoSizeWithSize(arrayList, i, z, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x005a A[PHI: r5
      0x005a: PHI (r5v2 int) = (r5v1 int), (r5v1 int), (r5v1 int), (r5v4 int), (r5v4 int), (r5v4 int) binds: [B:30:0x004a, B:37:0x0058, B:35:0x0054, B:20:0x0031, B:27:0x003f, B:25:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.rbmain.tgnet.TLRPC$VideoSize getClosestVideoSizeWithSize(java.util.ArrayList<org.rbmain.tgnet.TLRPC$VideoSize> r7, int r8, boolean r9, boolean r10) {
        /*
            r10 = 0
            if (r7 == 0) goto L5f
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto La
            goto L5f
        La:
            r0 = 0
            r1 = 0
        Lc:
            int r2 = r7.size()
            if (r0 >= r2) goto L5f
            java.lang.Object r2 = r7.get(r0)
            org.rbmain.tgnet.TLRPC$VideoSize r2 = (org.rbmain.tgnet.TLRPC$VideoSize) r2
            if (r2 == 0) goto L5c
            boolean r3 = r2 instanceof org.rbmain.tgnet.TLRPC$TL_videoSizeEmojiMarkup
            if (r3 != 0) goto L5c
            boolean r3 = r2 instanceof org.rbmain.tgnet.TLRPC$TL_videoSizeStickerMarkup
            if (r3 == 0) goto L23
            goto L5c
        L23:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 100
            if (r9 == 0) goto L42
            int r5 = r2.h
            int r6 = r2.w
            int r5 = java.lang.Math.min(r5, r6)
            if (r10 == 0) goto L5a
            if (r8 <= r4) goto L3d
            org.rbmain.tgnet.TLRPC$FileLocation r4 = r10.location
            if (r4 == 0) goto L3d
            int r4 = r4.dc_id
            if (r4 == r3) goto L5a
        L3d:
            if (r8 <= r1) goto L5c
            if (r1 >= r5) goto L5c
            goto L5a
        L42:
            int r5 = r2.w
            int r6 = r2.h
            int r5 = java.lang.Math.max(r5, r6)
            if (r10 == 0) goto L5a
            if (r8 <= r4) goto L56
            org.rbmain.tgnet.TLRPC$FileLocation r4 = r10.location
            if (r4 == 0) goto L56
            int r4 = r4.dc_id
            if (r4 == r3) goto L5a
        L56:
            if (r5 > r8) goto L5c
            if (r1 >= r5) goto L5c
        L5a:
            r10 = r2
            r1 = r5
        L5c:
            int r0 = r0 + 1
            goto Lc
        L5f:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.FileLoader.getClosestVideoSizeWithSize(java.util.ArrayList, int, boolean, boolean):org.rbmain.tgnet.TLRPC$VideoSize");
    }

    public static TLRPC$VideoSize getVectorMarkupVideoSize(TLRPC$Photo tLRPC$Photo) {
        if (tLRPC$Photo != null && tLRPC$Photo.video_sizes != null) {
            for (int i = 0; i < tLRPC$Photo.video_sizes.size(); i++) {
                TLRPC$VideoSize tLRPC$VideoSize = tLRPC$Photo.video_sizes.get(i);
                if ((tLRPC$VideoSize instanceof TLRPC$TL_videoSizeEmojiMarkup) || (tLRPC$VideoSize instanceof TLRPC$TL_videoSizeStickerMarkup)) {
                    return tLRPC$VideoSize;
                }
            }
        }
        return null;
    }
}

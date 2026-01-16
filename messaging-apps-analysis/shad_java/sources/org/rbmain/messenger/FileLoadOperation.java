package org.rbmain.messenger;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidMessenger.ServiceLocator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CountDownLatch;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import org.rbmain.messenger.FileLoadOperation;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.NativeByteBuffer;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$InputFileLocation;
import org.rbmain.tgnet.TLRPC$InputWebFileLocation;
import org.rbmain.tgnet.TLRPC$TL_document;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeVideo;
import org.rbmain.tgnet.TLRPC$TL_documentEncrypted;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_fileHash;
import org.rbmain.tgnet.TLRPC$TL_fileLocationToBeDeprecated;
import org.rbmain.tgnet.TLRPC$TL_inputDocumentFileLocation;
import org.rbmain.tgnet.TLRPC$TL_inputPeerPhotoFileLocation;
import org.rbmain.tgnet.TLRPC$TL_inputPhotoFileLocation;
import org.rbmain.tgnet.TLRPC$TL_secureFile;
import org.rbmain.tgnet.TLRPC$TL_theme;
import org.rbmain.tgnet.TLRPC$TL_upload_cdnFile;
import org.rbmain.tgnet.TLRPC$TL_upload_cdnFileReuploadNeeded;
import org.rbmain.tgnet.TLRPC$TL_upload_file;
import org.rbmain.tgnet.TLRPC$TL_upload_fileCdnRedirect;
import org.rbmain.tgnet.TLRPC$TL_upload_getCdnFile;
import org.rbmain.tgnet.TLRPC$TL_upload_getCdnFileHashes;
import org.rbmain.tgnet.TLRPC$TL_upload_getFile;
import org.rbmain.tgnet.TLRPC$TL_upload_getWebFile;
import org.rbmain.tgnet.TLRPC$TL_upload_reuploadCdnFile;
import org.rbmain.tgnet.TLRPC$TL_upload_webFile;
import org.rbmain.tgnet.TLRPC$Vector;
import org.rbmain.tgnet.TLRPC$WebPage;

/* loaded from: classes4.dex */
public class FileLoadOperation {
    private static final int bigFileSizeFrom = 1048576;
    private static final int cdnChunkCheckSize = 131072;
    private static final int downloadChunkSize = 65536;
    private static final int downloadChunkSizeBig = 262144;
    private static final int maxCdnParts = 8000;
    private static final int maxDownloadRequests = 4;
    private static final int maxDownloadRequestsBig = 8;
    private static final int preloadMaxBytes = 2097152;
    private static final int stateDownloading = 1;
    private static final int stateFailed = 2;
    private static final int stateFinished = 3;
    private static final int stateIdle = 0;
    private boolean allowDisordererFileSave;
    private int bytesCountPadding;
    private File cacheFileFinal;
    private File cacheFileGzipTemp;
    private File cacheFileParts;
    private File cacheFilePreload;
    private File cacheFileTemp;
    private File cacheIvTemp;
    private byte[] cdnCheckBytes;
    private int cdnDatacenterId;
    private SparseArray<TLRPC$TL_fileHash> cdnHashes;
    private byte[] cdnIv;
    private byte[] cdnKey;
    private byte[] cdnToken;
    private int currentAccount;
    private int currentDownloadChunkSize;
    private int currentMaxDownloadRequests;
    private int currentQueueType;
    private int currentType;
    private int datacenterId;
    private ArrayList<RequestInfo> delayedRequestInfos;
    private FileLoadOperationDelegate delegate;
    private int downloadedBytes;
    private boolean encryptFile;
    private byte[] encryptIv;
    private byte[] encryptKey;
    private String ext;
    private String fileName;
    private RandomAccessFile fileOutputStream;
    private RandomAccessFile filePartsStream;
    private RandomAccessFile fileReadStream;
    private RandomAccessFile fiv;
    private boolean forceBig;
    private int foundMoovSize;
    private int initialDatacenterId;
    private boolean isCdn;
    private boolean isForceRequest;
    private boolean isPreloadVideoOperation;
    private byte[] iv;
    private byte[] key;
    protected long lastProgressUpdateTime;
    protected TLRPC$InputFileLocation location;
    private int moovFound;
    private int nextAtomOffset;
    private boolean nextPartWasPreloaded;
    private int nextPreloadDownloadOffset;
    private ArrayList<Range> notCheckedCdnRanges;
    private ArrayList<Range> notLoadedBytesRanges;
    private volatile ArrayList<Range> notLoadedBytesRangesCopy;
    private ArrayList<Range> notRequestedBytesRanges;
    private Object parentObject;
    private volatile boolean paused;
    private boolean preloadFinished;
    private int preloadNotRequestedBytesCount;
    private RandomAccessFile preloadStream;
    private int preloadStreamFileOffset;
    private byte[] preloadTempBuffer;
    private int preloadTempBufferCount;
    private SparseArray<PreloadRange> preloadedBytesRanges;
    private int priority;
    private RequestInfo priorityRequestInfo;
    private int renameRetryCount;
    private ArrayList<RequestInfo> requestInfos;
    private int requestedBytesCount;
    private SparseIntArray requestedPreloadedBytesRanges;
    private boolean requestingCdnOffsets;
    protected boolean requestingReference;
    private int requestsCount;
    private boolean reuploadingCdn;
    private boolean started;
    private volatile int state;
    private File storePath;
    private ArrayList<FileLoadOperationStream> streamListeners;
    private int streamPriorityStartOffset;
    private int streamStartOffset;
    private boolean supportsPreloading;
    private File tempPath;
    private int tileCount;
    private int totalBytesCount;
    private int totalPreloadedBytes;
    private boolean ungzip;
    private WebFile webFile;
    private TLRPC$InputWebFileLocation webLocation;

    public interface FileLoadOperationDelegate {
        void didChangedLoadProgress(FileLoadOperation fileLoadOperation, long j, long j2);

        void didFailedLoadingFile(FileLoadOperation fileLoadOperation, int i);

        void didFinishLoadingFile(FileLoadOperation fileLoadOperation, File file);
    }

    protected static class RequestInfo {
        private int offset;
        private int requestToken;
        private TLRPC$TL_upload_file response;
        private TLRPC$TL_upload_cdnFile responseCdn;
        private TLRPC$TL_upload_webFile responseWeb;

        protected RequestInfo() {
        }
    }

    public static class Range {
        private int end;
        private int start;

        private Range(int i, int i2) {
            this.start = i;
            this.end = i2;
        }
    }

    private static class PreloadRange {
        private int fileOffset;
        private int length;

        private PreloadRange(int i, int i2) {
            this.fileOffset = i;
            this.length = i2;
        }
    }

    public FileLoadOperation(ImageLocation imageLocation, Object obj, String str, int i) {
        this.preloadTempBuffer = new byte[16];
        this.state = 0;
        this.parentObject = obj;
        this.forceBig = imageLocation.imageType == 2;
        if (imageLocation.isEncrypted()) {
            TLRPC$InputFileLocation tLRPC$InputFileLocation = new TLRPC$InputFileLocation() { // from class: org.rbmain.tgnet.TLRPC$TL_inputEncryptedFileLocation
                public static int constructor = -182231723;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
                    this.id = abstractSerializedData.readInt64(z);
                    this.access_hash = abstractSerializedData.readInt64(z);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                    abstractSerializedData.writeInt32(constructor);
                    abstractSerializedData.writeInt64(this.id);
                    abstractSerializedData.writeInt64(this.access_hash);
                }
            };
            this.location = tLRPC$InputFileLocation;
            TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated = imageLocation.location;
            long j = tLRPC$TL_fileLocationToBeDeprecated.volume_id;
            tLRPC$InputFileLocation.id = j;
            tLRPC$InputFileLocation.volume_id = j;
            tLRPC$InputFileLocation.local_id = tLRPC$TL_fileLocationToBeDeprecated.local_id;
            tLRPC$InputFileLocation.access_hash = imageLocation.access_hash;
            byte[] bArr = new byte[32];
            this.iv = bArr;
            System.arraycopy(imageLocation.iv, 0, bArr, 0, bArr.length);
            this.key = imageLocation.key;
        } else if (imageLocation.photoPeer != null) {
            TLRPC$TL_inputPeerPhotoFileLocation tLRPC$TL_inputPeerPhotoFileLocation = new TLRPC$TL_inputPeerPhotoFileLocation();
            this.location = tLRPC$TL_inputPeerPhotoFileLocation;
            TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated2 = imageLocation.location;
            long j2 = tLRPC$TL_fileLocationToBeDeprecated2.volume_id;
            tLRPC$TL_inputPeerPhotoFileLocation.id = j2;
            tLRPC$TL_inputPeerPhotoFileLocation.volume_id = j2;
            tLRPC$TL_inputPeerPhotoFileLocation.local_id = tLRPC$TL_fileLocationToBeDeprecated2.local_id;
            tLRPC$TL_inputPeerPhotoFileLocation.big = imageLocation.photoPeerType == 0;
            tLRPC$TL_inputPeerPhotoFileLocation.peer = imageLocation.photoPeer;
        } else if (imageLocation.stickerSet != null) {
            TLRPC$InputFileLocation tLRPC$InputFileLocation2 = new TLRPC$InputFileLocation() { // from class: org.rbmain.tgnet.TLRPC$TL_inputStickerSetThumb
                public static int constructor = 230353641;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
                    this.stickerset = TLRPC$InputStickerSet.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                    this.volume_id = abstractSerializedData.readInt64(z);
                    this.local_id = abstractSerializedData.readInt32(z);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                    abstractSerializedData.writeInt32(constructor);
                    this.stickerset.serializeToStream(abstractSerializedData);
                    abstractSerializedData.writeInt64(this.volume_id);
                    abstractSerializedData.writeInt32(this.local_id);
                }
            };
            this.location = tLRPC$InputFileLocation2;
            TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated3 = imageLocation.location;
            long j3 = tLRPC$TL_fileLocationToBeDeprecated3.volume_id;
            tLRPC$InputFileLocation2.id = j3;
            tLRPC$InputFileLocation2.volume_id = j3;
            tLRPC$InputFileLocation2.local_id = tLRPC$TL_fileLocationToBeDeprecated3.local_id;
            tLRPC$InputFileLocation2.stickerset = imageLocation.stickerSet;
        } else if (imageLocation.thumbSize != null) {
            if (imageLocation.photoId != 0) {
                TLRPC$TL_inputPhotoFileLocation tLRPC$TL_inputPhotoFileLocation = new TLRPC$TL_inputPhotoFileLocation();
                this.location = tLRPC$TL_inputPhotoFileLocation;
                tLRPC$TL_inputPhotoFileLocation.id = imageLocation.photoId;
                TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated4 = imageLocation.location;
                tLRPC$TL_inputPhotoFileLocation.volume_id = tLRPC$TL_fileLocationToBeDeprecated4.volume_id;
                tLRPC$TL_inputPhotoFileLocation.local_id = tLRPC$TL_fileLocationToBeDeprecated4.local_id;
                tLRPC$TL_inputPhotoFileLocation.access_hash = imageLocation.access_hash;
                tLRPC$TL_inputPhotoFileLocation.file_reference = imageLocation.file_reference;
                tLRPC$TL_inputPhotoFileLocation.thumb_size = imageLocation.thumbSize;
                if (imageLocation.imageType == 2) {
                    this.allowDisordererFileSave = true;
                }
            } else {
                TLRPC$TL_inputDocumentFileLocation tLRPC$TL_inputDocumentFileLocation = new TLRPC$TL_inputDocumentFileLocation();
                this.location = tLRPC$TL_inputDocumentFileLocation;
                tLRPC$TL_inputDocumentFileLocation.id = imageLocation.documentId;
                TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated5 = imageLocation.location;
                tLRPC$TL_inputDocumentFileLocation.volume_id = tLRPC$TL_fileLocationToBeDeprecated5.volume_id;
                tLRPC$TL_inputDocumentFileLocation.local_id = tLRPC$TL_fileLocationToBeDeprecated5.local_id;
                tLRPC$TL_inputDocumentFileLocation.access_hash = imageLocation.access_hash;
                tLRPC$TL_inputDocumentFileLocation.file_reference = imageLocation.file_reference;
                tLRPC$TL_inputDocumentFileLocation.thumb_size = imageLocation.thumbSize;
            }
            TLRPC$InputFileLocation tLRPC$InputFileLocation3 = this.location;
            if (tLRPC$InputFileLocation3.file_reference == null) {
                tLRPC$InputFileLocation3.file_reference = new byte[0];
            }
        } else {
            TLRPC$InputFileLocation tLRPC$InputFileLocation4 = new TLRPC$InputFileLocation() { // from class: org.rbmain.tgnet.TLRPC$TL_inputFileLocation
                public static int constructor = -539317279;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
                    this.volume_id = abstractSerializedData.readInt64(z);
                    this.local_id = abstractSerializedData.readInt32(z);
                    this.secret = abstractSerializedData.readInt64(z);
                    this.file_reference = abstractSerializedData.readByteArray(z);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                    abstractSerializedData.writeInt32(constructor);
                    abstractSerializedData.writeInt64(this.volume_id);
                    abstractSerializedData.writeInt32(this.local_id);
                    abstractSerializedData.writeInt64(this.secret);
                    abstractSerializedData.writeByteArray(this.file_reference);
                }
            };
            this.location = tLRPC$InputFileLocation4;
            tLRPC$InputFileLocation4.id = imageLocation.photoId;
            long j4 = imageLocation.access_hash;
            tLRPC$InputFileLocation4.access_hash = j4;
            TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated6 = imageLocation.location;
            tLRPC$InputFileLocation4.volume_id = tLRPC$TL_fileLocationToBeDeprecated6.volume_id;
            tLRPC$InputFileLocation4.local_id = tLRPC$TL_fileLocationToBeDeprecated6.local_id;
            tLRPC$InputFileLocation4.secret = j4;
            byte[] bArr2 = imageLocation.file_reference;
            tLRPC$InputFileLocation4.file_reference = bArr2;
            if (bArr2 == null) {
                tLRPC$InputFileLocation4.file_reference = new byte[0];
            }
            this.allowDisordererFileSave = true;
        }
        int i2 = imageLocation.imageType;
        this.ungzip = i2 == 1 || i2 == 3;
        int i3 = imageLocation.dc_id;
        this.datacenterId = i3;
        this.initialDatacenterId = i3;
        this.currentType = ConnectionsManager.FileTypePhoto;
        this.totalBytesCount = i;
        this.ext = str == null ? "jpg" : str;
        this.location.cdnTag = imageLocation.cdnTag;
    }

    public FileLoadOperation(SecureDocument secureDocument) {
        this.preloadTempBuffer = new byte[16];
        this.state = 0;
        TLRPC$InputFileLocation tLRPC$InputFileLocation = new TLRPC$InputFileLocation() { // from class: org.rbmain.tgnet.TLRPC$TL_inputSecureFileLocation
            public static int constructor = -876089816;

            @Override // org.rbmain.tgnet.TLObject
            public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
                this.id = abstractSerializedData.readInt64(z);
                this.access_hash = abstractSerializedData.readInt64(z);
            }

            @Override // org.rbmain.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                abstractSerializedData.writeInt32(constructor);
                abstractSerializedData.writeInt64(this.id);
                abstractSerializedData.writeInt64(this.access_hash);
            }
        };
        this.location = tLRPC$InputFileLocation;
        TLRPC$TL_secureFile tLRPC$TL_secureFile = secureDocument.secureFile;
        tLRPC$InputFileLocation.id = tLRPC$TL_secureFile.id;
        tLRPC$InputFileLocation.access_hash = tLRPC$TL_secureFile.access_hash;
        this.datacenterId = tLRPC$TL_secureFile.dc_id;
        this.totalBytesCount = tLRPC$TL_secureFile.size;
        this.allowDisordererFileSave = true;
        this.currentType = ConnectionsManager.FileTypeFile;
        this.ext = ".jpg";
    }

    public FileLoadOperation(int i, WebFile webFile) {
        this.preloadTempBuffer = new byte[16];
        this.state = 0;
        this.currentAccount = i;
        this.webFile = webFile;
        this.webLocation = webFile.location;
        this.totalBytesCount = webFile.size;
        int i2 = MessagesController.getInstance(i).webFileDatacenterId;
        this.datacenterId = i2;
        this.initialDatacenterId = i2;
        String mimeTypePart = FileLoader.getMimeTypePart(webFile.mime_type);
        if (webFile.mime_type.startsWith("image/")) {
            this.currentType = ConnectionsManager.FileTypePhoto;
        } else if (webFile.mime_type.equals("audio/ogg")) {
            this.currentType = ConnectionsManager.FileTypeAudio;
        } else if (webFile.mime_type.startsWith("video/")) {
            this.currentType = ConnectionsManager.FileTypeVideo;
        } else {
            this.currentType = ConnectionsManager.FileTypeFile;
        }
        this.allowDisordererFileSave = true;
        this.ext = ImageLoader.getHttpUrlExtension(webFile.url, mimeTypePart);
    }

    public FileLoadOperation(TLRPC$Document tLRPC$Document, Object obj) {
        int iLastIndexOf;
        this.preloadTempBuffer = new byte[16];
        this.state = 0;
        try {
            this.parentObject = obj;
            if (tLRPC$Document instanceof TLRPC$TL_documentEncrypted) {
                TLRPC$InputFileLocation tLRPC$InputFileLocation = new TLRPC$InputFileLocation() { // from class: org.rbmain.tgnet.TLRPC$TL_inputEncryptedFileLocation
                    public static int constructor = -182231723;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
                        this.id = abstractSerializedData.readInt64(z);
                        this.access_hash = abstractSerializedData.readInt64(z);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                        abstractSerializedData.writeInt32(constructor);
                        abstractSerializedData.writeInt64(this.id);
                        abstractSerializedData.writeInt64(this.access_hash);
                    }
                };
                this.location = tLRPC$InputFileLocation;
                tLRPC$InputFileLocation.id = tLRPC$Document.id;
                tLRPC$InputFileLocation.access_hash = tLRPC$Document.access_hash;
                int i = tLRPC$Document.dc_id;
                this.datacenterId = i;
                this.initialDatacenterId = i;
                byte[] bArr = new byte[32];
                this.iv = bArr;
                System.arraycopy(tLRPC$Document.iv, 0, bArr, 0, bArr.length);
                this.key = tLRPC$Document.key;
            } else if (tLRPC$Document instanceof TLRPC$TL_document) {
                TLRPC$TL_inputDocumentFileLocation tLRPC$TL_inputDocumentFileLocation = new TLRPC$TL_inputDocumentFileLocation();
                this.location = tLRPC$TL_inputDocumentFileLocation;
                tLRPC$TL_inputDocumentFileLocation.id = tLRPC$Document.id;
                tLRPC$TL_inputDocumentFileLocation.access_hash = tLRPC$Document.access_hash;
                byte[] bArr2 = tLRPC$Document.file_reference;
                tLRPC$TL_inputDocumentFileLocation.file_reference = bArr2;
                tLRPC$TL_inputDocumentFileLocation.thumb_size = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
                if (bArr2 == null) {
                    tLRPC$TL_inputDocumentFileLocation.file_reference = new byte[0];
                }
                int i2 = tLRPC$Document.dc_id;
                this.datacenterId = i2;
                this.initialDatacenterId = i2;
                this.allowDisordererFileSave = true;
                int size = tLRPC$Document.attributes.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    if (tLRPC$Document.attributes.get(i3) instanceof TLRPC$TL_documentAttributeVideo) {
                        this.supportsPreloading = true;
                        break;
                    }
                    i3++;
                }
            }
            this.ungzip = "application/x-tgsticker".equals(tLRPC$Document.mime_type) || "application/x-tgwallpattern".equals(tLRPC$Document.mime_type);
            int i4 = tLRPC$Document.size;
            this.totalBytesCount = i4;
            if (this.key != null && i4 % 16 != 0) {
                int i5 = 16 - (i4 % 16);
                this.bytesCountPadding = i5;
                this.totalBytesCount = i4 + i5;
            }
            this.location.cdnTag = tLRPC$Document.cdnTag;
            String documentFileName = FileLoader.getDocumentFileName(tLRPC$Document);
            this.ext = documentFileName;
            if (documentFileName == null || (iLastIndexOf = documentFileName.lastIndexOf(46)) == -1) {
                this.ext = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            } else {
                this.ext = this.ext.substring(iLastIndexOf);
            }
            if ("audio/ogg".equals(tLRPC$Document.mime_type)) {
                this.currentType = ConnectionsManager.FileTypeAudio;
            } else if (FileLoader.isVideoMimeType(tLRPC$Document.mime_type)) {
                this.currentType = ConnectionsManager.FileTypeVideo;
            } else {
                this.currentType = ConnectionsManager.FileTypeFile;
            }
            if (this.ext.length() <= 1) {
                this.ext = FileLoader.getExtensionByMimeType(tLRPC$Document.mime_type);
            }
        } catch (Exception e) {
            FileLog.e(e);
            onFail(true, 0);
        }
    }

    public void setEncryptFile(boolean z) {
        this.encryptFile = z;
        if (z) {
            this.allowDisordererFileSave = false;
        }
    }

    public int getDatacenterId() {
        return this.initialDatacenterId;
    }

    public void setForceRequest(boolean z) {
        this.isForceRequest = z;
    }

    public boolean isForceRequest() {
        return this.isForceRequest;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPaths(int i, String str, int i2, File file, File file2) {
        this.storePath = file;
        this.tempPath = file2;
        this.currentAccount = i;
        this.fileName = str;
        this.currentQueueType = i2;
    }

    public int getQueueType() {
        return this.currentQueueType;
    }

    public boolean wasStarted() {
        return this.started && !this.paused;
    }

    public int getCurrentType() {
        return this.currentType;
    }

    private void removePart(ArrayList<Range> arrayList, int i, int i2) {
        boolean z;
        if (arrayList == null || i2 < i) {
            return;
        }
        int size = arrayList.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Range range = arrayList.get(i4);
            if (i == range.end) {
                range.end = i2;
            } else if (i2 == range.start) {
                range.start = i;
            }
            z = true;
        }
        z = false;
        Collections.sort(arrayList, new Comparator() { // from class: org.rbmain.messenger.FileLoadOperation$$ExternalSyntheticLambda11
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return FileLoadOperation.lambda$removePart$0((FileLoadOperation.Range) obj, (FileLoadOperation.Range) obj2);
            }
        });
        while (i3 < arrayList.size() - 1) {
            Range range2 = arrayList.get(i3);
            int i5 = i3 + 1;
            Range range3 = arrayList.get(i5);
            if (range2.end == range3.start) {
                range2.end = range3.end;
                arrayList.remove(i5);
                i3--;
            }
            i3++;
        }
        if (z) {
            return;
        }
        arrayList.add(new Range(i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$removePart$0(Range range, Range range2) {
        if (range.start > range2.start) {
            return 1;
        }
        return range.start < range2.start ? -1 : 0;
    }

    private void addPart(ArrayList<Range> arrayList, int i, int i2, boolean z) throws IOException {
        boolean z2;
        if (arrayList == null || i2 < i) {
            return;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            z2 = true;
            if (i3 >= size) {
                z2 = false;
                break;
            }
            Range range = arrayList.get(i3);
            if (i <= range.start) {
                if (i2 < range.end) {
                    if (i2 > range.start) {
                        range.start = i2;
                        break;
                    }
                    i3++;
                } else {
                    arrayList.remove(i3);
                    break;
                }
            } else if (i2 >= range.end) {
                if (i < range.end) {
                    range.end = i;
                    break;
                }
                i3++;
            } else {
                arrayList.add(0, new Range(range.start, i));
                range.start = i2;
                break;
            }
        }
        if (z) {
            if (z2) {
                try {
                    this.filePartsStream.seek(0L);
                    int size2 = arrayList.size();
                    this.filePartsStream.writeInt(size2);
                    for (int i4 = 0; i4 < size2; i4++) {
                        Range range2 = arrayList.get(i4);
                        this.filePartsStream.writeInt(range2.start);
                        this.filePartsStream.writeInt(range2.end);
                    }
                } catch (Exception e) {
                    FileLog.e(e);
                }
                ArrayList<FileLoadOperationStream> arrayList2 = this.streamListeners;
                if (arrayList2 != null) {
                    int size3 = arrayList2.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        this.streamListeners.get(i5).newDataAvailable();
                    }
                    return;
                }
                return;
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e(this.cacheFileFinal + " downloaded duplicate file part " + i + " - " + i2);
            }
        }
    }

    protected File getCacheFileFinal() {
        return this.cacheFileFinal;
    }

    protected File getCurrentFile() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final File[] fileArr = new File[1];
        Utilities.fileQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoadOperation$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getCurrentFile$1(fileArr, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
        return fileArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCurrentFile$1(File[] fileArr, CountDownLatch countDownLatch) {
        if (this.state == 3) {
            fileArr[0] = this.cacheFileFinal;
        } else {
            fileArr[0] = this.cacheFileTemp;
        }
        countDownLatch.countDown();
    }

    private int getDownloadedLengthFromOffsetInternal(ArrayList<Range> arrayList, int i, int i2) {
        int i3;
        if (arrayList == null || this.state == 3 || arrayList.isEmpty()) {
            int i4 = this.downloadedBytes;
            return i4 == 0 ? i2 : Math.min(i2, Math.max(i4 - i, 0));
        }
        int size = arrayList.size();
        Range range = null;
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                i3 = i2;
                break;
            }
            Range range2 = arrayList.get(i5);
            if (i <= range2.start && (range == null || range2.start < range.start)) {
                range = range2;
            }
            if (range2.start <= i && range2.end > i) {
                i3 = 0;
                break;
            }
            i5++;
        }
        if (i3 == 0) {
            return 0;
        }
        if (range != null) {
            return Math.min(i2, range.start - i);
        }
        return Math.min(i2, Math.max(this.totalBytesCount - i, 0));
    }

    protected float getDownloadedLengthFromOffset(float f) {
        ArrayList<Range> arrayList = this.notLoadedBytesRangesCopy;
        if (this.totalBytesCount == 0 || arrayList == null) {
            return 0.0f;
        }
        return f + (getDownloadedLengthFromOffsetInternal(arrayList, (int) (r1 * f), r1) / this.totalBytesCount);
    }

    protected int[] getDownloadedLengthFromOffset(final int i, final int i2) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final int[] iArr = new int[2];
        Utilities.fileQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoadOperation$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getDownloadedLengthFromOffset$2(iArr, i, i2, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception unused) {
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDownloadedLengthFromOffset$2(int[] iArr, int i, int i2, CountDownLatch countDownLatch) {
        iArr[0] = getDownloadedLengthFromOffsetInternal(this.notLoadedBytesRanges, i, i2);
        if (this.state == 3) {
            iArr[1] = 1;
        }
        countDownLatch.countDown();
    }

    public String getFileName() {
        return this.fileName;
    }

    protected void removeStreamListener(final FileLoadOperationStream fileLoadOperationStream) {
        Utilities.fileQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoadOperation$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeStreamListener$3(fileLoadOperationStream);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeStreamListener$3(FileLoadOperationStream fileLoadOperationStream) {
        ArrayList<FileLoadOperationStream> arrayList = this.streamListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(fileLoadOperationStream);
    }

    private void copyNotLoadedRanges() {
        if (this.notLoadedBytesRanges == null) {
            return;
        }
        this.notLoadedBytesRangesCopy = new ArrayList<>(this.notLoadedBytesRanges);
    }

    public void pause() {
        if (this.state != 1) {
            return;
        }
        this.paused = true;
    }

    public boolean start() {
        return start(null, 0, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04b2 A[Catch: Exception -> 0x057e, TryCatch #0 {Exception -> 0x057e, blocks: (B:149:0x0499, B:151:0x04b2, B:155:0x04bd, B:156:0x04c0, B:158:0x04c5, B:161:0x04cd, B:164:0x04de, B:167:0x04e4, B:169:0x04f6, B:172:0x04fc, B:175:0x0512, B:177:0x051c, B:181:0x0527, B:183:0x052d, B:185:0x0543, B:186:0x054a, B:188:0x054e, B:189:0x0555, B:190:0x0575), top: B:293:0x0499 }] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x060e  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x068f  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x06fa  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x075e A[Catch: Exception -> 0x0763, TRY_LEAVE, TryCatch #7 {Exception -> 0x0763, blocks: (B:275:0x0751, B:277:0x075e), top: B:307:0x0751 }] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x076b  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0771  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x077f  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0591 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean start(final org.rbmain.messenger.FileLoadOperationStream r23, final int r24, final boolean r25) {
        /*
            Method dump skipped, instructions count: 1937
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.FileLoadOperation.start(org.rbmain.messenger.FileLoadOperationStream, int, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$4(boolean z, int i, FileLoadOperationStream fileLoadOperationStream, boolean z2) {
        if (this.streamListeners == null) {
            this.streamListeners = new ArrayList<>();
        }
        if (z) {
            int i2 = this.currentDownloadChunkSize;
            int i3 = (i / i2) * i2;
            RequestInfo requestInfo = this.priorityRequestInfo;
            if (requestInfo != null && requestInfo.offset != i3) {
                this.requestInfos.remove(this.priorityRequestInfo);
                this.requestedBytesCount -= this.currentDownloadChunkSize;
                removePart(this.notRequestedBytesRanges, this.priorityRequestInfo.offset, this.priorityRequestInfo.offset + this.currentDownloadChunkSize);
                if (this.priorityRequestInfo.requestToken != 0) {
                    ServiceLocator.getInstance(this.currentAccount).getFileLoadProxy().cancelRequest(this.priorityRequestInfo.requestToken);
                    this.requestsCount--;
                }
                if (BuildVars.DEBUG_VERSION) {
                    FileLog.d("frame get cancel request at offset " + this.priorityRequestInfo.offset);
                }
                this.priorityRequestInfo = null;
            }
            if (this.priorityRequestInfo == null) {
                this.streamPriorityStartOffset = i3;
            }
        } else {
            int i4 = this.currentDownloadChunkSize;
            this.streamStartOffset = (i / i4) * i4;
        }
        this.streamListeners.add(fileLoadOperationStream);
        if (z2) {
            if (this.preloadedBytesRanges != null && getDownloadedLengthFromOffsetInternal(this.notLoadedBytesRanges, this.streamStartOffset, 1) == 0 && this.preloadedBytesRanges.get(this.streamStartOffset) != null) {
                this.nextPartWasPreloaded = true;
            }
            startDownloadRequest();
            this.nextPartWasPreloaded = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$5(boolean[] zArr) {
        int i = this.totalBytesCount;
        if (i != 0 && ((this.isPreloadVideoOperation && zArr[0]) || this.downloadedBytes == i)) {
            try {
                onFinishLoadingFile(false);
                return;
            } catch (Exception unused) {
                onFail(true, 0);
                return;
            }
        }
        startDownloadRequest();
    }

    public void updateProgress() {
        int i;
        int i2;
        FileLoadOperationDelegate fileLoadOperationDelegate = this.delegate;
        if (fileLoadOperationDelegate == null || (i = this.downloadedBytes) == (i2 = this.totalBytesCount) || i2 <= 0) {
            return;
        }
        fileLoadOperationDelegate.didChangedLoadProgress(this, i, i2);
    }

    public boolean isPaused() {
        return this.paused;
    }

    public void setIsPreloadVideoOperation(final boolean z) {
        boolean z2 = this.isPreloadVideoOperation;
        if (z2 != z) {
            if (!z || this.totalBytesCount > preloadMaxBytes) {
                if (!z && z2) {
                    if (this.state == 3) {
                        this.isPreloadVideoOperation = z;
                        this.state = 0;
                        this.preloadFinished = false;
                        start();
                        return;
                    }
                    if (this.state == 1) {
                        Utilities.fileQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoadOperation$$ExternalSyntheticLambda6
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$setIsPreloadVideoOperation$6(z);
                            }
                        });
                        return;
                    } else {
                        this.isPreloadVideoOperation = z;
                        return;
                    }
                }
                this.isPreloadVideoOperation = z;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setIsPreloadVideoOperation$6(boolean z) {
        this.requestedBytesCount = 0;
        clearOperaion(null, true);
        this.isPreloadVideoOperation = z;
        startDownloadRequest();
    }

    public boolean isPreloadVideoOperation() {
        return this.isPreloadVideoOperation;
    }

    public boolean isPreloadFinished() {
        return this.preloadFinished;
    }

    public void cancel() {
        cancel(false);
    }

    public void cancel(final boolean z) {
        Utilities.fileQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoadOperation$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cancel$7(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancel$7(boolean z) {
        if (this.state != 3 && this.state != 2) {
            if (this.requestInfos != null) {
                for (int i = 0; i < this.requestInfos.size(); i++) {
                    RequestInfo requestInfo = this.requestInfos.get(i);
                    if (requestInfo.requestToken != 0) {
                        ServiceLocator.getInstance(this.currentAccount).getFileLoadProxy().cancelRequest(requestInfo.requestToken);
                    }
                }
            }
            onFail(false, 1);
        }
        if (z) {
            File file = this.cacheFileFinal;
            if (file != null) {
                try {
                    if (!file.delete()) {
                        this.cacheFileFinal.deleteOnExit();
                    }
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            File file2 = this.cacheFileTemp;
            if (file2 != null) {
                try {
                    if (!file2.delete()) {
                        this.cacheFileTemp.deleteOnExit();
                    }
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            }
            File file3 = this.cacheFileParts;
            if (file3 != null) {
                try {
                    if (!file3.delete()) {
                        this.cacheFileParts.deleteOnExit();
                    }
                } catch (Exception e3) {
                    FileLog.e(e3);
                }
            }
            File file4 = this.cacheIvTemp;
            if (file4 != null) {
                try {
                    if (!file4.delete()) {
                        this.cacheIvTemp.deleteOnExit();
                    }
                } catch (Exception e4) {
                    FileLog.e(e4);
                }
            }
            File file5 = this.cacheFilePreload;
            if (file5 != null) {
                try {
                    if (file5.delete()) {
                        return;
                    }
                    this.cacheFilePreload.deleteOnExit();
                } catch (Exception e5) {
                    FileLog.e(e5);
                }
            }
        }
    }

    private void cleanup() throws IOException {
        try {
            RandomAccessFile randomAccessFile = this.fileOutputStream;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.getChannel().close();
                } catch (Exception e) {
                    FileLog.e(e);
                }
                this.fileOutputStream.close();
                this.fileOutputStream = null;
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        try {
            RandomAccessFile randomAccessFile2 = this.preloadStream;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.getChannel().close();
                } catch (Exception e3) {
                    FileLog.e(e3);
                }
                this.preloadStream.close();
                this.preloadStream = null;
            }
        } catch (Exception e4) {
            FileLog.e(e4);
        }
        try {
            RandomAccessFile randomAccessFile3 = this.fileReadStream;
            if (randomAccessFile3 != null) {
                try {
                    randomAccessFile3.getChannel().close();
                } catch (Exception e5) {
                    FileLog.e(e5);
                }
                this.fileReadStream.close();
                this.fileReadStream = null;
            }
        } catch (Exception e6) {
            FileLog.e(e6);
        }
        try {
            RandomAccessFile randomAccessFile4 = this.filePartsStream;
            if (randomAccessFile4 != null) {
                try {
                    randomAccessFile4.getChannel().close();
                } catch (Exception e7) {
                    FileLog.e(e7);
                }
                this.filePartsStream.close();
                this.filePartsStream = null;
            }
        } catch (Exception e8) {
            FileLog.e(e8);
        }
        try {
            RandomAccessFile randomAccessFile5 = this.fiv;
            if (randomAccessFile5 != null) {
                randomAccessFile5.close();
                this.fiv = null;
            }
        } catch (Exception e9) {
            FileLog.e(e9);
        }
        if (this.delayedRequestInfos != null) {
            for (int i = 0; i < this.delayedRequestInfos.size(); i++) {
                RequestInfo requestInfo = this.delayedRequestInfos.get(i);
                if (requestInfo.response != null) {
                    requestInfo.response.disableFree = false;
                    requestInfo.response.freeResources();
                } else if (requestInfo.responseWeb != null) {
                    requestInfo.responseWeb.disableFree = false;
                    requestInfo.responseWeb.freeResources();
                } else if (requestInfo.responseCdn != null) {
                    requestInfo.responseCdn.disableFree = false;
                    requestInfo.responseCdn.freeResources();
                }
            }
            this.delayedRequestInfos.clear();
        }
    }

    private void onFinishLoadingFile(final boolean z) throws IOException {
        if (this.state != 1) {
            return;
        }
        this.state = 3;
        cleanup();
        if (this.isPreloadVideoOperation) {
            this.preloadFinished = true;
            if (BuildVars.DEBUG_VERSION) {
                FileLog.d("finished preloading file to " + this.cacheFileTemp + " loaded " + this.totalPreloadedBytes + " of " + this.totalBytesCount);
            }
        } else {
            File file = this.cacheIvTemp;
            if (file != null) {
                file.delete();
                this.cacheIvTemp = null;
            }
            File file2 = this.cacheFileParts;
            if (file2 != null) {
                file2.delete();
                this.cacheFileParts = null;
            }
            File file3 = this.cacheFilePreload;
            if (file3 != null) {
                file3.delete();
                this.cacheFilePreload = null;
            }
            if (this.cacheFileTemp != null) {
                boolean zRenameTo = false;
                if (this.ungzip) {
                    try {
                        GZIPInputStream gZIPInputStream = new GZIPInputStream(new FileInputStream(this.cacheFileTemp));
                        FileLoader.copyFile(gZIPInputStream, this.cacheFileGzipTemp, preloadMaxBytes);
                        gZIPInputStream.close();
                        this.cacheFileTemp.delete();
                        this.cacheFileTemp = this.cacheFileGzipTemp;
                        this.ungzip = false;
                    } catch (ZipException unused) {
                        this.ungzip = false;
                    } catch (Throwable th) {
                        FileLog.e(th);
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.e("unable to ungzip temp = " + this.cacheFileTemp + " to final = " + this.cacheFileFinal);
                        }
                    }
                }
                if (!this.ungzip) {
                    if (this.parentObject instanceof TLRPC$TL_theme) {
                        try {
                            zRenameTo = AndroidUtilities.copyFile(this.cacheFileTemp, this.cacheFileFinal);
                        } catch (Exception e) {
                            FileLog.e(e);
                        }
                    } else {
                        try {
                            zRenameTo = this.cacheFileTemp.renameTo(this.cacheFileFinal);
                        } catch (Exception e2) {
                            FileLog.e(e2);
                        }
                    }
                    if (!zRenameTo) {
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.e("unable to rename temp = " + this.cacheFileTemp + " to final = " + this.cacheFileFinal + " retry = " + this.renameRetryCount);
                        }
                        int i = this.renameRetryCount + 1;
                        this.renameRetryCount = i;
                        if (i < 3) {
                            this.state = 1;
                            Utilities.fileQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoadOperation$$ExternalSyntheticLambda5
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onFinishLoadingFile$8(z);
                                }
                            }, 200L);
                            return;
                        }
                        this.cacheFileFinal = this.cacheFileTemp;
                    }
                } else {
                    onFail(false, 0);
                    return;
                }
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("finished downloading file to " + this.cacheFileFinal);
            }
            if (z) {
                int i2 = this.currentType;
                if (i2 == 50331648) {
                    StatsController.getInstance(this.currentAccount).incrementReceivedItemsCount(ApplicationLoader.getCurrentNetworkType(), 3, 1);
                } else if (i2 == 33554432) {
                    StatsController.getInstance(this.currentAccount).incrementReceivedItemsCount(ApplicationLoader.getCurrentNetworkType(), 2, 1);
                } else if (i2 == 16777216) {
                    StatsController.getInstance(this.currentAccount).incrementReceivedItemsCount(ApplicationLoader.getCurrentNetworkType(), 4, 1);
                } else if (i2 == 67108864) {
                    StatsController.getInstance(this.currentAccount).incrementReceivedItemsCount(ApplicationLoader.getCurrentNetworkType(), 5, 1);
                }
            }
        }
        this.delegate.didFinishLoadingFile(this, this.cacheFileFinal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFinishLoadingFile$8(boolean z) {
        try {
            onFinishLoadingFile(z);
        } catch (Exception unused) {
            onFail(false, 0);
        }
    }

    private void delayRequestInfo(RequestInfo requestInfo) {
        this.delayedRequestInfos.add(requestInfo);
        if (requestInfo.response != null) {
            requestInfo.response.disableFree = true;
        } else if (requestInfo.responseWeb != null) {
            requestInfo.responseWeb.disableFree = true;
        } else if (requestInfo.responseCdn != null) {
            requestInfo.responseCdn.disableFree = true;
        }
    }

    private int findNextPreloadDownloadOffset(int i, int i2, NativeByteBuffer nativeByteBuffer) {
        int i3;
        int iLimit = nativeByteBuffer.limit();
        do {
            if (i < i2 - (this.preloadTempBuffer != null ? 16 : 0) || i >= (i3 = i2 + iLimit)) {
                return 0;
            }
            if (i >= i3 - 16) {
                this.preloadTempBufferCount = i3 - i;
                nativeByteBuffer.position(nativeByteBuffer.limit() - this.preloadTempBufferCount);
                nativeByteBuffer.readBytes(this.preloadTempBuffer, 0, this.preloadTempBufferCount, false);
                return i3;
            }
            if (this.preloadTempBufferCount != 0) {
                nativeByteBuffer.position(0);
                byte[] bArr = this.preloadTempBuffer;
                int i4 = this.preloadTempBufferCount;
                nativeByteBuffer.readBytes(bArr, i4, 16 - i4, false);
                this.preloadTempBufferCount = 0;
            } else {
                nativeByteBuffer.position(i - i2);
                nativeByteBuffer.readBytes(this.preloadTempBuffer, 0, 16, false);
            }
            byte[] bArr2 = this.preloadTempBuffer;
            int i5 = ((bArr2[0] & 255) << 24) + ((bArr2[1] & 255) << 16) + ((bArr2[2] & 255) << 8) + (bArr2[3] & 255);
            if (i5 == 0) {
                return 0;
            }
            if (i5 == 1) {
                i5 = ((bArr2[12] & 255) << 24) + ((bArr2[13] & 255) << 16) + ((bArr2[14] & 255) << 8) + (bArr2[15] & 255);
            }
            if (bArr2[4] == 109 && bArr2[5] == 111 && bArr2[6] == 111 && bArr2[7] == 118) {
                return -i5;
            }
            i += i5;
        } while (i < i3);
        return i;
    }

    private void requestFileOffsets(int i) {
        if (this.requestingCdnOffsets) {
            return;
        }
        this.requestingCdnOffsets = true;
        TLRPC$TL_upload_getCdnFileHashes tLRPC$TL_upload_getCdnFileHashes = new TLRPC$TL_upload_getCdnFileHashes();
        tLRPC$TL_upload_getCdnFileHashes.file_token = this.cdnToken;
        tLRPC$TL_upload_getCdnFileHashes.offset = i;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_upload_getCdnFileHashes, new RequestDelegate() { // from class: org.rbmain.messenger.FileLoadOperation$$ExternalSyntheticLambda12
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$requestFileOffsets$9(tLObject, tLRPC$TL_error);
            }
        }, null, null, 0, this.datacenterId, 1, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestFileOffsets$9(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            onFail(false, 0);
            return;
        }
        this.requestingCdnOffsets = false;
        TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
        if (!tLRPC$Vector.objects.isEmpty()) {
            if (this.cdnHashes == null) {
                this.cdnHashes = new SparseArray<>();
            }
            for (int i = 0; i < tLRPC$Vector.objects.size(); i++) {
                TLRPC$TL_fileHash tLRPC$TL_fileHash = (TLRPC$TL_fileHash) tLRPC$Vector.objects.get(i);
                this.cdnHashes.put(tLRPC$TL_fileHash.offset, tLRPC$TL_fileHash);
            }
        }
        for (int i2 = 0; i2 < this.delayedRequestInfos.size(); i2++) {
            RequestInfo requestInfo = this.delayedRequestInfos.get(i2);
            if (this.notLoadedBytesRanges != null || this.downloadedBytes == requestInfo.offset) {
                this.delayedRequestInfos.remove(i2);
                if (processRequestResult(requestInfo, null)) {
                    return;
                }
                if (requestInfo.response != null) {
                    requestInfo.response.disableFree = false;
                    requestInfo.response.freeResources();
                    return;
                } else if (requestInfo.responseWeb != null) {
                    requestInfo.responseWeb.disableFree = false;
                    requestInfo.responseWeb.freeResources();
                    return;
                } else {
                    if (requestInfo.responseCdn != null) {
                        requestInfo.responseCdn.disableFree = false;
                        requestInfo.responseCdn.freeResources();
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:175:0x0458 A[Catch: Exception -> 0x047a, TryCatch #0 {Exception -> 0x047a, blocks: (B:10:0x0046, B:12:0x004a, B:14:0x0052, B:16:0x0056, B:18:0x005c, B:27:0x0080, B:30:0x0088, B:32:0x0092, B:34:0x009d, B:37:0x00a7, B:39:0x00ae, B:41:0x00bc, B:42:0x00e9, B:44:0x00ed, B:46:0x0110, B:47:0x0138, B:49:0x013c, B:50:0x0143, B:52:0x0161, B:54:0x016d, B:56:0x017c, B:58:0x0190, B:60:0x019c, B:57:0x0187, B:59:0x0194, B:61:0x019e, B:63:0x01bd, B:65:0x01c1, B:67:0x01c5, B:69:0x01cb, B:75:0x01d5, B:155:0x03ef, B:157:0x03f7, B:159:0x0403, B:162:0x040c, B:163:0x040f, B:165:0x041b, B:167:0x0421, B:168:0x042f, B:170:0x0435, B:171:0x0443, B:173:0x0449, B:175:0x0458, B:177:0x0460, B:179:0x0466, B:176:0x045d, B:76:0x01e4, B:78:0x01e8, B:79:0x01f1, B:93:0x020f, B:95:0x0214, B:97:0x022d, B:99:0x0231, B:100:0x023b, B:102:0x023f, B:103:0x026e, B:105:0x0272, B:107:0x0280, B:108:0x02a0, B:110:0x02be, B:112:0x02ce, B:114:0x02dc, B:120:0x02ea, B:123:0x02f8, B:125:0x02fc, B:129:0x0304, B:131:0x0310, B:132:0x0321, B:134:0x033c, B:136:0x0340, B:138:0x0344, B:139:0x038d, B:141:0x0391, B:142:0x03af, B:144:0x03b8, B:117:0x02e4, B:145:0x03c4, B:147:0x03c8, B:148:0x03d4, B:150:0x03d8, B:152:0x03dd, B:83:0x01fd, B:86:0x0203, B:180:0x0475, B:19:0x0063, B:21:0x0069, B:22:0x0070, B:24:0x0076), top: B:216:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x045d A[Catch: Exception -> 0x047a, TryCatch #0 {Exception -> 0x047a, blocks: (B:10:0x0046, B:12:0x004a, B:14:0x0052, B:16:0x0056, B:18:0x005c, B:27:0x0080, B:30:0x0088, B:32:0x0092, B:34:0x009d, B:37:0x00a7, B:39:0x00ae, B:41:0x00bc, B:42:0x00e9, B:44:0x00ed, B:46:0x0110, B:47:0x0138, B:49:0x013c, B:50:0x0143, B:52:0x0161, B:54:0x016d, B:56:0x017c, B:58:0x0190, B:60:0x019c, B:57:0x0187, B:59:0x0194, B:61:0x019e, B:63:0x01bd, B:65:0x01c1, B:67:0x01c5, B:69:0x01cb, B:75:0x01d5, B:155:0x03ef, B:157:0x03f7, B:159:0x0403, B:162:0x040c, B:163:0x040f, B:165:0x041b, B:167:0x0421, B:168:0x042f, B:170:0x0435, B:171:0x0443, B:173:0x0449, B:175:0x0458, B:177:0x0460, B:179:0x0466, B:176:0x045d, B:76:0x01e4, B:78:0x01e8, B:79:0x01f1, B:93:0x020f, B:95:0x0214, B:97:0x022d, B:99:0x0231, B:100:0x023b, B:102:0x023f, B:103:0x026e, B:105:0x0272, B:107:0x0280, B:108:0x02a0, B:110:0x02be, B:112:0x02ce, B:114:0x02dc, B:120:0x02ea, B:123:0x02f8, B:125:0x02fc, B:129:0x0304, B:131:0x0310, B:132:0x0321, B:134:0x033c, B:136:0x0340, B:138:0x0344, B:139:0x038d, B:141:0x0391, B:142:0x03af, B:144:0x03b8, B:117:0x02e4, B:145:0x03c4, B:147:0x03c8, B:148:0x03d4, B:150:0x03d8, B:152:0x03dd, B:83:0x01fd, B:86:0x0203, B:180:0x0475, B:19:0x0063, B:21:0x0069, B:22:0x0070, B:24:0x0076), top: B:216:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0466 A[Catch: Exception -> 0x047a, TryCatch #0 {Exception -> 0x047a, blocks: (B:10:0x0046, B:12:0x004a, B:14:0x0052, B:16:0x0056, B:18:0x005c, B:27:0x0080, B:30:0x0088, B:32:0x0092, B:34:0x009d, B:37:0x00a7, B:39:0x00ae, B:41:0x00bc, B:42:0x00e9, B:44:0x00ed, B:46:0x0110, B:47:0x0138, B:49:0x013c, B:50:0x0143, B:52:0x0161, B:54:0x016d, B:56:0x017c, B:58:0x0190, B:60:0x019c, B:57:0x0187, B:59:0x0194, B:61:0x019e, B:63:0x01bd, B:65:0x01c1, B:67:0x01c5, B:69:0x01cb, B:75:0x01d5, B:155:0x03ef, B:157:0x03f7, B:159:0x0403, B:162:0x040c, B:163:0x040f, B:165:0x041b, B:167:0x0421, B:168:0x042f, B:170:0x0435, B:171:0x0443, B:173:0x0449, B:175:0x0458, B:177:0x0460, B:179:0x0466, B:176:0x045d, B:76:0x01e4, B:78:0x01e8, B:79:0x01f1, B:93:0x020f, B:95:0x0214, B:97:0x022d, B:99:0x0231, B:100:0x023b, B:102:0x023f, B:103:0x026e, B:105:0x0272, B:107:0x0280, B:108:0x02a0, B:110:0x02be, B:112:0x02ce, B:114:0x02dc, B:120:0x02ea, B:123:0x02f8, B:125:0x02fc, B:129:0x0304, B:131:0x0310, B:132:0x0321, B:134:0x033c, B:136:0x0340, B:138:0x0344, B:139:0x038d, B:141:0x0391, B:142:0x03af, B:144:0x03b8, B:117:0x02e4, B:145:0x03c4, B:147:0x03c8, B:148:0x03d4, B:150:0x03d8, B:152:0x03dd, B:83:0x01fd, B:86:0x0203, B:180:0x0475, B:19:0x0063, B:21:0x0069, B:22:0x0070, B:24:0x0076), top: B:216:0x0046 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean processRequestResult(org.rbmain.messenger.FileLoadOperation.RequestInfo r27, org.rbmain.tgnet.TLRPC$TL_error r28) {
        /*
            Method dump skipped, instructions count: 1395
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.FileLoadOperation.processRequestResult(org.rbmain.messenger.FileLoadOperation$RequestInfo, org.rbmain.tgnet.TLRPC$TL_error):boolean");
    }

    protected void onFail(boolean z, final int i) {
        cleanup();
        this.state = 2;
        if (z) {
            Utilities.fileQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoadOperation$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFail$10(i);
                }
            });
        } else {
            this.delegate.didFailedLoadingFile(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFail$10(int i) {
        this.delegate.didFailedLoadingFile(this, i);
    }

    private void clearOperaion(RequestInfo requestInfo, boolean z) {
        int iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
        for (int i = 0; i < this.requestInfos.size(); i++) {
            RequestInfo requestInfo2 = this.requestInfos.get(i);
            iMin = Math.min(requestInfo2.offset, iMin);
            if (this.isPreloadVideoOperation) {
                this.requestedPreloadedBytesRanges.delete(requestInfo2.offset);
            } else {
                removePart(this.notRequestedBytesRanges, requestInfo2.offset, requestInfo2.offset + this.currentDownloadChunkSize);
            }
            if (requestInfo != requestInfo2 && requestInfo2.requestToken != 0) {
                ServiceLocator.getInstance(this.currentAccount).getFileLoadProxy().cancelRequest(requestInfo2.requestToken);
            }
        }
        this.requestInfos.clear();
        for (int i2 = 0; i2 < this.delayedRequestInfos.size(); i2++) {
            RequestInfo requestInfo3 = this.delayedRequestInfos.get(i2);
            if (this.isPreloadVideoOperation) {
                this.requestedPreloadedBytesRanges.delete(requestInfo3.offset);
            } else {
                removePart(this.notRequestedBytesRanges, requestInfo3.offset, requestInfo3.offset + this.currentDownloadChunkSize);
            }
            if (requestInfo3.response != null) {
                requestInfo3.response.disableFree = false;
                requestInfo3.response.freeResources();
            } else if (requestInfo3.responseWeb != null) {
                requestInfo3.responseWeb.disableFree = false;
                requestInfo3.responseWeb.freeResources();
            } else if (requestInfo3.responseCdn != null) {
                requestInfo3.responseCdn.disableFree = false;
                requestInfo3.responseCdn.freeResources();
            }
            iMin = Math.min(requestInfo3.offset, iMin);
        }
        this.delayedRequestInfos.clear();
        this.requestsCount = 0;
        if (!z && this.isPreloadVideoOperation) {
            this.requestedBytesCount = this.totalPreloadedBytes;
        } else if (this.notLoadedBytesRanges == null) {
            this.downloadedBytes = iMin;
            this.requestedBytesCount = iMin;
        }
    }

    private void requestReference(RequestInfo requestInfo) {
        TLRPC$WebPage tLRPC$WebPage;
        if (this.requestingReference) {
            return;
        }
        clearOperaion(requestInfo, false);
        this.requestingReference = true;
        Object obj = this.parentObject;
        if (obj instanceof MessageObject) {
            MessageObject messageObject = (MessageObject) obj;
            if (messageObject.getId() < 0 && (tLRPC$WebPage = messageObject.messageOwner.media.webpage) != null) {
                this.parentObject = tLRPC$WebPage;
            }
        }
        FileRefController.getInstance(this.currentAccount).requestReference(this.parentObject, this.location, this, requestInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void startDownloadRequest() {
        int i;
        TLRPC$TL_upload_getFile tLRPC$TL_upload_getFile;
        SparseArray<PreloadRange> sparseArray;
        PreloadRange preloadRange;
        ArrayList<Range> arrayList;
        boolean z;
        if (this.paused || this.reuploadingCdn || this.state != 1) {
            return;
        }
        if (this.streamPriorityStartOffset == 0) {
            if (!this.nextPartWasPreloaded && this.requestInfos.size() + this.delayedRequestInfos.size() >= this.currentMaxDownloadRequests) {
                return;
            }
            if (this.isPreloadVideoOperation) {
                if (this.requestedBytesCount > preloadMaxBytes) {
                    return;
                }
                if (this.moovFound != 0 && this.requestInfos.size() > 0) {
                    return;
                }
            }
        }
        int iMax = (this.streamPriorityStartOffset != 0 || this.nextPartWasPreloaded || (this.isPreloadVideoOperation && this.moovFound == 0) || this.totalBytesCount <= 0) ? 1 : Math.max(0, this.currentMaxDownloadRequests - this.requestInfos.size());
        int i2 = 0;
        while (i2 < iMax) {
            if (this.isPreloadVideoOperation) {
                if (this.moovFound != 0 && this.preloadNotRequestedBytesCount <= 0) {
                    return;
                }
                i = this.nextPreloadDownloadOffset;
                if (i == -1) {
                    int i3 = 0;
                    for (int i4 = (preloadMaxBytes / this.currentDownloadChunkSize) + 2; i4 != 0; i4--) {
                        if (this.requestedPreloadedBytesRanges.get(i3, 0) == 0) {
                            i = i3;
                            z = true;
                            break;
                        }
                        int i5 = this.currentDownloadChunkSize;
                        i3 += i5;
                        int i6 = this.totalBytesCount;
                        if (i3 > i6) {
                            break;
                        }
                        if (this.moovFound == 2 && i3 == i5 * 8) {
                            i3 = ((i6 - bigFileSizeFrom) / i5) * i5;
                        }
                    }
                    i = i3;
                    z = false;
                    if (!z && this.requestInfos.isEmpty()) {
                        onFinishLoadingFile(false);
                    }
                }
                if (this.requestedPreloadedBytesRanges == null) {
                    this.requestedPreloadedBytesRanges = new SparseIntArray();
                }
                this.requestedPreloadedBytesRanges.put(i, 1);
                if (BuildVars.DEBUG_VERSION) {
                    FileLog.d("start next preload from " + i + " size " + this.totalBytesCount + " for " + this.cacheFilePreload);
                }
                this.preloadNotRequestedBytesCount -= this.currentDownloadChunkSize;
            } else {
                ArrayList<Range> arrayList2 = this.notRequestedBytesRanges;
                if (arrayList2 != null) {
                    int i7 = this.streamPriorityStartOffset;
                    if (i7 == 0) {
                        i7 = this.streamStartOffset;
                    }
                    int size = arrayList2.size();
                    int i8 = 0;
                    int i9 = ConnectionsManager.DEFAULT_DATACENTER_ID;
                    int iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
                    while (true) {
                        if (i8 >= size) {
                            i7 = i9;
                            break;
                        }
                        Range range = this.notRequestedBytesRanges.get(i8);
                        if (i7 != 0) {
                            if (range.start <= i7 && range.end > i7) {
                                iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
                                break;
                            } else if (i7 < range.start && range.start < i9) {
                                i9 = range.start;
                            }
                        }
                        iMin = Math.min(iMin, range.start);
                        i8++;
                    }
                    if (i7 != Integer.MAX_VALUE) {
                        i = i7;
                    } else if (iMin == Integer.MAX_VALUE) {
                        break;
                    } else {
                        i = iMin;
                    }
                } else {
                    i = this.requestedBytesCount;
                }
            }
            if (!this.isPreloadVideoOperation && (arrayList = this.notRequestedBytesRanges) != null) {
                addPart(arrayList, i, this.currentDownloadChunkSize + i, false);
            }
            int i10 = this.totalBytesCount;
            if (i10 > 0 && i >= i10) {
                break;
            }
            boolean z2 = i10 <= 0 || i2 == iMax + (-1) || (i10 > 0 && this.currentDownloadChunkSize + i >= i10);
            int i11 = this.requestsCount % 2 == 0 ? 2 : ConnectionsManager.ConnectionTypeDownload2;
            int i12 = this.isForceRequest ? 32 : 0;
            if (this.isCdn) {
                TLRPC$TL_upload_getCdnFile tLRPC$TL_upload_getCdnFile = new TLRPC$TL_upload_getCdnFile();
                tLRPC$TL_upload_getCdnFile.file_token = this.cdnToken;
                tLRPC$TL_upload_getCdnFile.offset = i;
                tLRPC$TL_upload_getCdnFile.limit = this.currentDownloadChunkSize;
                i12 |= 1;
                tLRPC$TL_upload_getFile = tLRPC$TL_upload_getCdnFile;
            } else if (this.webLocation != null) {
                TLRPC$TL_upload_getWebFile tLRPC$TL_upload_getWebFile = new TLRPC$TL_upload_getWebFile();
                tLRPC$TL_upload_getWebFile.location = this.webLocation;
                tLRPC$TL_upload_getWebFile.offset = i;
                tLRPC$TL_upload_getWebFile.limit = this.currentDownloadChunkSize;
                tLRPC$TL_upload_getFile = tLRPC$TL_upload_getWebFile;
            } else {
                TLRPC$TL_upload_getFile tLRPC$TL_upload_getFile2 = new TLRPC$TL_upload_getFile();
                tLRPC$TL_upload_getFile2.location = this.location;
                tLRPC$TL_upload_getFile2.offset = i;
                tLRPC$TL_upload_getFile2.limit = this.currentDownloadChunkSize;
                tLRPC$TL_upload_getFile2.cdn_supported = true;
                tLRPC$TL_upload_getFile = tLRPC$TL_upload_getFile2;
            }
            int i13 = i12;
            final TLRPC$TL_upload_getFile tLRPC$TL_upload_getFile3 = tLRPC$TL_upload_getFile;
            this.requestedBytesCount += this.currentDownloadChunkSize;
            final RequestInfo requestInfo = new RequestInfo();
            this.requestInfos.add(requestInfo);
            requestInfo.offset = i;
            if (!this.isPreloadVideoOperation && this.supportsPreloading && this.preloadStream != null && (sparseArray = this.preloadedBytesRanges) != null && (preloadRange = sparseArray.get(requestInfo.offset)) != null) {
                requestInfo.response = new TLRPC$TL_upload_file();
                try {
                    NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(preloadRange.length);
                    this.preloadStream.seek(preloadRange.fileOffset);
                    this.preloadStream.getChannel().read(nativeByteBuffer.buffer);
                    nativeByteBuffer.buffer.position(0);
                    requestInfo.response.bytes = nativeByteBuffer;
                    Utilities.fileQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLoadOperation$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$startDownloadRequest$11(requestInfo);
                        }
                    });
                } catch (Exception unused) {
                }
            } else {
                if (this.streamPriorityStartOffset != 0) {
                    if (BuildVars.DEBUG_VERSION) {
                        FileLog.d("frame get offset = " + this.streamPriorityStartOffset);
                    }
                    this.streamPriorityStartOffset = 0;
                    this.priorityRequestInfo = requestInfo;
                }
                requestInfo.requestToken = ServiceLocator.getInstance(this.currentAccount).getFileLoadProxy().sendRequest(tLRPC$TL_upload_getFile3, new RequestDelegate() { // from class: org.rbmain.messenger.FileLoadOperation$$ExternalSyntheticLambda14
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$startDownloadRequest$13(requestInfo, tLRPC$TL_upload_getFile3, tLObject, tLRPC$TL_error);
                    }
                }, null, null, i13, this.datacenterId, i11, z2);
            }
            i2++;
        }
        this.requestsCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startDownloadRequest$11(RequestInfo requestInfo) {
        processRequestResult(requestInfo, null);
        requestInfo.response.freeResources();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startDownloadRequest$13(final RequestInfo requestInfo, TLObject tLObject, TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
        byte[] bArr;
        if (this.requestInfos.contains(requestInfo)) {
            if (requestInfo == this.priorityRequestInfo) {
                if (BuildVars.DEBUG_VERSION) {
                    FileLog.d("frame get request completed " + this.priorityRequestInfo.offset);
                }
                this.priorityRequestInfo = null;
            }
            int i = 0;
            if (tLRPC$TL_error != null) {
                if (tLRPC$TL_error.text.toLowerCase().contains("FileDidntLoaded".toLowerCase())) {
                    onFail(true, 0);
                    return;
                }
                if (FileRefController.isFileRefError(tLRPC$TL_error.text)) {
                    requestReference(requestInfo);
                    return;
                } else if ((tLObject instanceof TLRPC$TL_upload_getCdnFile) && tLRPC$TL_error.text.equals("FILE_TOKEN_INVALID")) {
                    this.isCdn = false;
                    clearOperaion(requestInfo, false);
                    startDownloadRequest();
                    return;
                }
            }
            if (tLObject2 instanceof TLRPC$TL_upload_fileCdnRedirect) {
                TLRPC$TL_upload_fileCdnRedirect tLRPC$TL_upload_fileCdnRedirect = (TLRPC$TL_upload_fileCdnRedirect) tLObject2;
                if (!tLRPC$TL_upload_fileCdnRedirect.file_hashes.isEmpty()) {
                    if (this.cdnHashes == null) {
                        this.cdnHashes = new SparseArray<>();
                    }
                    for (int i2 = 0; i2 < tLRPC$TL_upload_fileCdnRedirect.file_hashes.size(); i2++) {
                        TLRPC$TL_fileHash tLRPC$TL_fileHash = tLRPC$TL_upload_fileCdnRedirect.file_hashes.get(i2);
                        this.cdnHashes.put(tLRPC$TL_fileHash.offset, tLRPC$TL_fileHash);
                    }
                }
                byte[] bArr2 = tLRPC$TL_upload_fileCdnRedirect.encryption_iv;
                if (bArr2 == null || (bArr = tLRPC$TL_upload_fileCdnRedirect.encryption_key) == null || bArr2.length != 16 || bArr.length != 32) {
                    TLRPC$TL_error tLRPC$TL_error2 = new TLRPC$TL_error();
                    tLRPC$TL_error2.text = "bad redirect response";
                    tLRPC$TL_error2.code = 400;
                    processRequestResult(requestInfo, tLRPC$TL_error2);
                    return;
                }
                this.isCdn = true;
                if (this.notCheckedCdnRanges == null) {
                    ArrayList<Range> arrayList = new ArrayList<>();
                    this.notCheckedCdnRanges = arrayList;
                    arrayList.add(new Range(i, maxCdnParts));
                }
                this.cdnDatacenterId = tLRPC$TL_upload_fileCdnRedirect.dc_id;
                this.cdnIv = tLRPC$TL_upload_fileCdnRedirect.encryption_iv;
                this.cdnKey = tLRPC$TL_upload_fileCdnRedirect.encryption_key;
                this.cdnToken = tLRPC$TL_upload_fileCdnRedirect.file_token;
                clearOperaion(requestInfo, false);
                startDownloadRequest();
                return;
            }
            if (tLObject2 instanceof TLRPC$TL_upload_cdnFileReuploadNeeded) {
                if (this.reuploadingCdn) {
                    return;
                }
                clearOperaion(requestInfo, false);
                this.reuploadingCdn = true;
                TLRPC$TL_upload_reuploadCdnFile tLRPC$TL_upload_reuploadCdnFile = new TLRPC$TL_upload_reuploadCdnFile();
                tLRPC$TL_upload_reuploadCdnFile.file_token = this.cdnToken;
                tLRPC$TL_upload_reuploadCdnFile.request_token = ((TLRPC$TL_upload_cdnFileReuploadNeeded) tLObject2).request_token;
                ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_upload_reuploadCdnFile, new RequestDelegate() { // from class: org.rbmain.messenger.FileLoadOperation$$ExternalSyntheticLambda13
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject3, TLRPC$TL_error tLRPC$TL_error3) {
                        this.f$0.lambda$startDownloadRequest$12(requestInfo, tLObject3, tLRPC$TL_error3);
                    }
                }, null, null, 0, this.datacenterId, 1, true);
                return;
            }
            if (tLObject2 instanceof TLRPC$TL_upload_file) {
                requestInfo.response = (TLRPC$TL_upload_file) tLObject2;
            } else if (tLObject2 instanceof TLRPC$TL_upload_webFile) {
                requestInfo.responseWeb = (TLRPC$TL_upload_webFile) tLObject2;
                if (requestInfo.responseWeb.size != 0) {
                    this.totalBytesCount = requestInfo.responseWeb.size;
                }
            } else {
                requestInfo.responseCdn = (TLRPC$TL_upload_cdnFile) tLObject2;
            }
            if (tLObject2 != null) {
                tLObject2.networkType = ApplicationLoader.getCurrentNetworkType();
                StatsController.getInstance(this.currentAccount).incrementReceivedBytesCount(tLObject2.networkType, 6, tLObject2.getObjectSize() + 4);
                int i3 = this.currentType;
                if (i3 == 50331648) {
                    StatsController.getInstance(this.currentAccount).incrementReceivedBytesCount(tLObject2.networkType, 3, tLObject2.getObjectSize() + 4);
                } else if (i3 == 33554432) {
                    StatsController.getInstance(this.currentAccount).incrementReceivedBytesCount(tLObject2.networkType, 2, tLObject2.getObjectSize() + 4);
                } else if (i3 == 16777216) {
                    StatsController.getInstance(this.currentAccount).incrementReceivedBytesCount(tLObject2.networkType, 4, tLObject2.getObjectSize() + 4);
                } else if (i3 == 67108864) {
                    StatsController.getInstance(this.currentAccount).incrementReceivedBytesCount(tLObject2.networkType, 5, tLObject2.getObjectSize() + 4);
                }
            }
            processRequestResult(requestInfo, tLRPC$TL_error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startDownloadRequest$12(RequestInfo requestInfo, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        this.reuploadingCdn = false;
        if (tLRPC$TL_error == null) {
            TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
            if (!tLRPC$Vector.objects.isEmpty()) {
                if (this.cdnHashes == null) {
                    this.cdnHashes = new SparseArray<>();
                }
                for (int i = 0; i < tLRPC$Vector.objects.size(); i++) {
                    TLRPC$TL_fileHash tLRPC$TL_fileHash = (TLRPC$TL_fileHash) tLRPC$Vector.objects.get(i);
                    this.cdnHashes.put(tLRPC$TL_fileHash.offset, tLRPC$TL_fileHash);
                }
            }
            startDownloadRequest();
            return;
        }
        if (tLRPC$TL_error.text.equals("FILE_TOKEN_INVALID") || tLRPC$TL_error.text.equals("REQUEST_TOKEN_INVALID")) {
            this.isCdn = false;
            clearOperaion(requestInfo, false);
            startDownloadRequest();
            return;
        }
        onFail(false, 0);
    }

    public void setDelegate(FileLoadOperationDelegate fileLoadOperationDelegate) {
        this.delegate = fileLoadOperationDelegate;
    }
}

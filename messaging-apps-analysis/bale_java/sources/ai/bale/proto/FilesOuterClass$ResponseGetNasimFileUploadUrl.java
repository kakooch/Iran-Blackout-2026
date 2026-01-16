package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class FilesOuterClass$ResponseGetNasimFileUploadUrl extends GeneratedMessageLite implements U64 {
    public static final int BLOCK_SIZE_FIELD_NUMBER = 5;
    public static final int CHUNK_SIZE_FIELD_NUMBER = 4;
    private static final FilesOuterClass$ResponseGetNasimFileUploadUrl DEFAULT_INSTANCE;
    public static final int DUPLICATE_FIELD_NUMBER = 3;
    public static final int FILE_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int URL_FIELD_NUMBER = 2;
    private long blockSize_;
    private int chunkSize_;
    private boolean duplicate_;
    private long fileId_;
    private String url_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(FilesOuterClass$ResponseGetNasimFileUploadUrl.DEFAULT_INSTANCE);
        }
    }

    static {
        FilesOuterClass$ResponseGetNasimFileUploadUrl filesOuterClass$ResponseGetNasimFileUploadUrl = new FilesOuterClass$ResponseGetNasimFileUploadUrl();
        DEFAULT_INSTANCE = filesOuterClass$ResponseGetNasimFileUploadUrl;
        GeneratedMessageLite.registerDefaultInstance(FilesOuterClass$ResponseGetNasimFileUploadUrl.class, filesOuterClass$ResponseGetNasimFileUploadUrl);
    }

    private FilesOuterClass$ResponseGetNasimFileUploadUrl() {
    }

    private void clearBlockSize() {
        this.blockSize_ = 0L;
    }

    private void clearChunkSize() {
        this.chunkSize_ = 0;
    }

    private void clearDuplicate() {
        this.duplicate_ = false;
    }

    private void clearFileId() {
        this.fileId_ = 0L;
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static FilesOuterClass$ResponseGetNasimFileUploadUrl getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static FilesOuterClass$ResponseGetNasimFileUploadUrl parseDelimitedFrom(InputStream inputStream) {
        return (FilesOuterClass$ResponseGetNasimFileUploadUrl) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesOuterClass$ResponseGetNasimFileUploadUrl parseFrom(ByteBuffer byteBuffer) {
        return (FilesOuterClass$ResponseGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBlockSize(long j) {
        this.blockSize_ = j;
    }

    private void setChunkSize(int i) {
        this.chunkSize_ = i;
    }

    private void setDuplicate(boolean z) {
        this.duplicate_ = z;
    }

    private void setFileId(long j) {
        this.fileId_ = j;
    }

    private void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1841b0.a[gVar.ordinal()]) {
            case 1:
                return new FilesOuterClass$ResponseGetNasimFileUploadUrl();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003\u0007\u0004\u0004\u0005\u0002", new Object[]{"fileId_", "url_", "duplicate_", "chunkSize_", "blockSize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FilesOuterClass$ResponseGetNasimFileUploadUrl.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public long getBlockSize() {
        return this.blockSize_;
    }

    public int getChunkSize() {
        return this.chunkSize_;
    }

    public boolean getDuplicate() {
        return this.duplicate_;
    }

    public long getFileId() {
        return this.fileId_;
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public static a newBuilder(FilesOuterClass$ResponseGetNasimFileUploadUrl filesOuterClass$ResponseGetNasimFileUploadUrl) {
        return (a) DEFAULT_INSTANCE.createBuilder(filesOuterClass$ResponseGetNasimFileUploadUrl);
    }

    public static FilesOuterClass$ResponseGetNasimFileUploadUrl parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFileUploadUrl) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFileUploadUrl parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFileUploadUrl parseFrom(AbstractC2383g abstractC2383g) {
        return (FilesOuterClass$ResponseGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static FilesOuterClass$ResponseGetNasimFileUploadUrl parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFileUploadUrl parseFrom(byte[] bArr) {
        return (FilesOuterClass$ResponseGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FilesOuterClass$ResponseGetNasimFileUploadUrl parseFrom(byte[] bArr, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFileUploadUrl parseFrom(InputStream inputStream) {
        return (FilesOuterClass$ResponseGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesOuterClass$ResponseGetNasimFileUploadUrl parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesOuterClass$ResponseGetNasimFileUploadUrl parseFrom(AbstractC2384h abstractC2384h) {
        return (FilesOuterClass$ResponseGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FilesOuterClass$ResponseGetNasimFileUploadUrl parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FilesOuterClass$ResponseGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

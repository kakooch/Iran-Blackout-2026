package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC6681On2;
import ir.nasim.InterfaceC7159Qn2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class FilesStruct$FileUrlDescription extends GeneratedMessageLite implements InterfaceC6681On2 {
    public static final int CHUNK_SIZE_FIELD_NUMBER = 7;
    private static final FilesStruct$FileUrlDescription DEFAULT_INSTANCE;
    public static final int FILE_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TIMEOUT_FIELD_NUMBER = 3;
    public static final int UNSIGNED_URL_FIELD_NUMBER = 5;
    public static final int UNSIGNED_URL_HEADERS_FIELD_NUMBER = 6;
    public static final int URL_FIELD_NUMBER = 2;
    private int bitField0_;
    private Int32Value chunkSize_;
    private long fileId_;
    private int timeout_;
    private StringValue unsignedUrl_;
    private String url_ = "";
    private B.j unsignedUrlHeaders_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC6681On2 {
        private a() {
            super(FilesStruct$FileUrlDescription.DEFAULT_INSTANCE);
        }
    }

    static {
        FilesStruct$FileUrlDescription filesStruct$FileUrlDescription = new FilesStruct$FileUrlDescription();
        DEFAULT_INSTANCE = filesStruct$FileUrlDescription;
        GeneratedMessageLite.registerDefaultInstance(FilesStruct$FileUrlDescription.class, filesStruct$FileUrlDescription);
    }

    private FilesStruct$FileUrlDescription() {
    }

    private void addAllUnsignedUrlHeaders(Iterable<? extends FilesStruct$HTTPHeader> iterable) {
        ensureUnsignedUrlHeadersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.unsignedUrlHeaders_);
    }

    private void addUnsignedUrlHeaders(FilesStruct$HTTPHeader filesStruct$HTTPHeader) {
        filesStruct$HTTPHeader.getClass();
        ensureUnsignedUrlHeadersIsMutable();
        this.unsignedUrlHeaders_.add(filesStruct$HTTPHeader);
    }

    private void clearChunkSize() {
        this.chunkSize_ = null;
        this.bitField0_ &= -3;
    }

    private void clearFileId() {
        this.fileId_ = 0L;
    }

    private void clearTimeout() {
        this.timeout_ = 0;
    }

    private void clearUnsignedUrl() {
        this.unsignedUrl_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUnsignedUrlHeaders() {
        this.unsignedUrlHeaders_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    private void ensureUnsignedUrlHeadersIsMutable() {
        B.j jVar = this.unsignedUrlHeaders_;
        if (jVar.u()) {
            return;
        }
        this.unsignedUrlHeaders_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static FilesStruct$FileUrlDescription getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeChunkSize(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.chunkSize_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.chunkSize_ = int32Value;
        } else {
            this.chunkSize_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.chunkSize_).v(int32Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeUnsignedUrl(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.unsignedUrl_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.unsignedUrl_ = stringValue;
        } else {
            this.unsignedUrl_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.unsignedUrl_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static FilesStruct$FileUrlDescription parseDelimitedFrom(InputStream inputStream) {
        return (FilesStruct$FileUrlDescription) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$FileUrlDescription parseFrom(ByteBuffer byteBuffer) {
        return (FilesStruct$FileUrlDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUnsignedUrlHeaders(int i) {
        ensureUnsignedUrlHeadersIsMutable();
        this.unsignedUrlHeaders_.remove(i);
    }

    private void setChunkSize(Int32Value int32Value) {
        int32Value.getClass();
        this.chunkSize_ = int32Value;
        this.bitField0_ |= 2;
    }

    private void setFileId(long j) {
        this.fileId_ = j;
    }

    private void setTimeout(int i) {
        this.timeout_ = i;
    }

    private void setUnsignedUrl(StringValue stringValue) {
        stringValue.getClass();
        this.unsignedUrl_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setUnsignedUrlHeaders(int i, FilesStruct$HTTPHeader filesStruct$HTTPHeader) {
        filesStruct$HTTPHeader.getClass();
        ensureUnsignedUrlHeadersIsMutable();
        this.unsignedUrlHeaders_.set(i, filesStruct$HTTPHeader);
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
        switch (AbstractC1844c0.a[gVar.ordinal()]) {
            case 1:
                return new FilesStruct$FileUrlDescription();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0001\u0000\u0001\u0002\u0002Ȉ\u0003\u0004\u0005ဉ\u0000\u0006\u001b\u0007ဉ\u0001", new Object[]{"bitField0_", "fileId_", "url_", "timeout_", "unsignedUrl_", "unsignedUrlHeaders_", FilesStruct$HTTPHeader.class, "chunkSize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FilesStruct$FileUrlDescription.class) {
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

    public Int32Value getChunkSize() {
        Int32Value int32Value = this.chunkSize_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public long getFileId() {
        return this.fileId_;
    }

    public int getTimeout() {
        return this.timeout_;
    }

    public StringValue getUnsignedUrl() {
        StringValue stringValue = this.unsignedUrl_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public FilesStruct$HTTPHeader getUnsignedUrlHeaders(int i) {
        return (FilesStruct$HTTPHeader) this.unsignedUrlHeaders_.get(i);
    }

    public int getUnsignedUrlHeadersCount() {
        return this.unsignedUrlHeaders_.size();
    }

    public List<FilesStruct$HTTPHeader> getUnsignedUrlHeadersList() {
        return this.unsignedUrlHeaders_;
    }

    public InterfaceC7159Qn2 getUnsignedUrlHeadersOrBuilder(int i) {
        return (InterfaceC7159Qn2) this.unsignedUrlHeaders_.get(i);
    }

    public List<? extends InterfaceC7159Qn2> getUnsignedUrlHeadersOrBuilderList() {
        return this.unsignedUrlHeaders_;
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public boolean hasChunkSize() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasUnsignedUrl() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(FilesStruct$FileUrlDescription filesStruct$FileUrlDescription) {
        return (a) DEFAULT_INSTANCE.createBuilder(filesStruct$FileUrlDescription);
    }

    public static FilesStruct$FileUrlDescription parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$FileUrlDescription) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$FileUrlDescription parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FilesStruct$FileUrlDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FilesStruct$FileUrlDescription parseFrom(AbstractC2383g abstractC2383g) {
        return (FilesStruct$FileUrlDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUnsignedUrlHeaders(int i, FilesStruct$HTTPHeader filesStruct$HTTPHeader) {
        filesStruct$HTTPHeader.getClass();
        ensureUnsignedUrlHeadersIsMutable();
        this.unsignedUrlHeaders_.add(i, filesStruct$HTTPHeader);
    }

    public static FilesStruct$FileUrlDescription parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FilesStruct$FileUrlDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FilesStruct$FileUrlDescription parseFrom(byte[] bArr) {
        return (FilesStruct$FileUrlDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FilesStruct$FileUrlDescription parseFrom(byte[] bArr, C2394s c2394s) {
        return (FilesStruct$FileUrlDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FilesStruct$FileUrlDescription parseFrom(InputStream inputStream) {
        return (FilesStruct$FileUrlDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$FileUrlDescription parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$FileUrlDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$FileUrlDescription parseFrom(AbstractC2384h abstractC2384h) {
        return (FilesStruct$FileUrlDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FilesStruct$FileUrlDescription parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FilesStruct$FileUrlDescription) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

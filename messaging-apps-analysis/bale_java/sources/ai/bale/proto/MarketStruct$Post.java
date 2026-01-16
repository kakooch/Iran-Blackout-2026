package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.KW4;
import ir.nasim.YT3;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketStruct$Post extends GeneratedMessageLite implements YT3 {
    public static final int ACCESSHASH_FIELD_NUMBER = 2;
    public static final int DATE_FIELD_NUMBER = 7;
    private static final MarketStruct$Post DEFAULT_INSTANCE;
    public static final int FILEID_FIELD_NUMBER = 1;
    public static final int FILENAME_FIELD_NUMBER = 3;
    public static final int FILESIZE_FIELD_NUMBER = 4;
    public static final int FILESTORAGEVERSION_FIELD_NUMBER = 5;
    public static final int MARKETID_FIELD_NUMBER = 8;
    private static volatile KW4 PARSER = null;
    public static final int RANDOMID_FIELD_NUMBER = 6;
    private long accessHash_;
    private int bitField0_;
    private long date_;
    private long fileId_;
    private String fileName_ = "";
    private int fileSize_;
    private Int32Value fileStorageVersion_;
    private int marketId_;
    private long randomId_;

    public static final class a extends GeneratedMessageLite.b implements YT3 {
        private a() {
            super(MarketStruct$Post.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketStruct$Post marketStruct$Post = new MarketStruct$Post();
        DEFAULT_INSTANCE = marketStruct$Post;
        GeneratedMessageLite.registerDefaultInstance(MarketStruct$Post.class, marketStruct$Post);
    }

    private MarketStruct$Post() {
    }

    private void clearAccessHash() {
        this.accessHash_ = 0L;
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearFileId() {
        this.fileId_ = 0L;
    }

    private void clearFileName() {
        this.fileName_ = getDefaultInstance().getFileName();
    }

    private void clearFileSize() {
        this.fileSize_ = 0;
    }

    private void clearFileStorageVersion() {
        this.fileStorageVersion_ = null;
        this.bitField0_ &= -2;
    }

    private void clearMarketId() {
        this.marketId_ = 0;
    }

    private void clearRandomId() {
        this.randomId_ = 0L;
    }

    public static MarketStruct$Post getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFileStorageVersion(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.fileStorageVersion_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.fileStorageVersion_ = int32Value;
        } else {
            this.fileStorageVersion_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.fileStorageVersion_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketStruct$Post parseDelimitedFrom(InputStream inputStream) {
        return (MarketStruct$Post) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$Post parseFrom(ByteBuffer byteBuffer) {
        return (MarketStruct$Post) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccessHash(long j) {
        this.accessHash_ = j;
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setFileId(long j) {
        this.fileId_ = j;
    }

    private void setFileName(String str) {
        str.getClass();
        this.fileName_ = str;
    }

    private void setFileNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.fileName_ = abstractC2383g.f0();
    }

    private void setFileSize(int i) {
        this.fileSize_ = i;
    }

    private void setFileStorageVersion(Int32Value int32Value) {
        int32Value.getClass();
        this.fileStorageVersion_ = int32Value;
        this.bitField0_ |= 1;
    }

    private void setMarketId(int i) {
        this.marketId_ = i;
    }

    private void setRandomId(long j) {
        this.randomId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D0.a[gVar.ordinal()]) {
            case 1:
                return new MarketStruct$Post();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003Ȉ\u0004\u0004\u0005ဉ\u0000\u0006\u0002\u0007\u0002\b\u0004", new Object[]{"bitField0_", "fileId_", "accessHash_", "fileName_", "fileSize_", "fileStorageVersion_", "randomId_", "date_", "marketId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketStruct$Post.class) {
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

    public long getAccessHash() {
        return this.accessHash_;
    }

    public long getDate() {
        return this.date_;
    }

    public long getFileId() {
        return this.fileId_;
    }

    public String getFileName() {
        return this.fileName_;
    }

    public AbstractC2383g getFileNameBytes() {
        return AbstractC2383g.N(this.fileName_);
    }

    public int getFileSize() {
        return this.fileSize_;
    }

    public Int32Value getFileStorageVersion() {
        Int32Value int32Value = this.fileStorageVersion_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public int getMarketId() {
        return this.marketId_;
    }

    public long getRandomId() {
        return this.randomId_;
    }

    public boolean hasFileStorageVersion() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MarketStruct$Post marketStruct$Post) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketStruct$Post);
    }

    public static MarketStruct$Post parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$Post) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$Post parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketStruct$Post) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketStruct$Post parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketStruct$Post) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketStruct$Post parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketStruct$Post) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketStruct$Post parseFrom(byte[] bArr) {
        return (MarketStruct$Post) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketStruct$Post parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketStruct$Post) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketStruct$Post parseFrom(InputStream inputStream) {
        return (MarketStruct$Post) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$Post parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$Post) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$Post parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketStruct$Post) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketStruct$Post parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketStruct$Post) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

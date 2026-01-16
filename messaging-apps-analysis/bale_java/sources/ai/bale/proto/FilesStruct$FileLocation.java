package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.InterfaceC6182Mn2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class FilesStruct$FileLocation extends GeneratedMessageLite implements InterfaceC6182Mn2 {
    public static final int ACCESS_HASH_FIELD_NUMBER = 2;
    private static final FilesStruct$FileLocation DEFAULT_INSTANCE;
    public static final int FILE_ID_FIELD_NUMBER = 1;
    public static final int FILE_STORAGE_VERSION_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private long accessHash_;
    private int bitField0_;
    private long fileId_;
    private Int32Value fileStorageVersion_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC6182Mn2 {
        public a A(long j) {
            q();
            ((FilesStruct$FileLocation) this.b).setAccessHash(j);
            return this;
        }

        public a B(long j) {
            q();
            ((FilesStruct$FileLocation) this.b).setFileId(j);
            return this;
        }

        public a C(Int32Value int32Value) {
            q();
            ((FilesStruct$FileLocation) this.b).setFileStorageVersion(int32Value);
            return this;
        }

        private a() {
            super(FilesStruct$FileLocation.DEFAULT_INSTANCE);
        }
    }

    static {
        FilesStruct$FileLocation filesStruct$FileLocation = new FilesStruct$FileLocation();
        DEFAULT_INSTANCE = filesStruct$FileLocation;
        GeneratedMessageLite.registerDefaultInstance(FilesStruct$FileLocation.class, filesStruct$FileLocation);
    }

    private FilesStruct$FileLocation() {
    }

    private void clearAccessHash() {
        this.accessHash_ = 0L;
    }

    private void clearFileId() {
        this.fileId_ = 0L;
    }

    private void clearFileStorageVersion() {
        this.fileStorageVersion_ = null;
        this.bitField0_ &= -2;
    }

    public static FilesStruct$FileLocation getDefaultInstance() {
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

    public static FilesStruct$FileLocation parseDelimitedFrom(InputStream inputStream) {
        return (FilesStruct$FileLocation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$FileLocation parseFrom(ByteBuffer byteBuffer) {
        return (FilesStruct$FileLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccessHash(long j) {
        this.accessHash_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileId(long j) {
        this.fileId_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileStorageVersion(Int32Value int32Value) {
        int32Value.getClass();
        this.fileStorageVersion_ = int32Value;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1844c0.a[gVar.ordinal()]) {
            case 1:
                return new FilesStruct$FileLocation();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003ဉ\u0000", new Object[]{"bitField0_", "fileId_", "accessHash_", "fileStorageVersion_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FilesStruct$FileLocation.class) {
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

    public long getFileId() {
        return this.fileId_;
    }

    public Int32Value getFileStorageVersion() {
        Int32Value int32Value = this.fileStorageVersion_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public boolean hasFileStorageVersion() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(FilesStruct$FileLocation filesStruct$FileLocation) {
        return (a) DEFAULT_INSTANCE.createBuilder(filesStruct$FileLocation);
    }

    public static FilesStruct$FileLocation parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$FileLocation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$FileLocation parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FilesStruct$FileLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FilesStruct$FileLocation parseFrom(AbstractC2383g abstractC2383g) {
        return (FilesStruct$FileLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static FilesStruct$FileLocation parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FilesStruct$FileLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FilesStruct$FileLocation parseFrom(byte[] bArr) {
        return (FilesStruct$FileLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FilesStruct$FileLocation parseFrom(byte[] bArr, C2394s c2394s) {
        return (FilesStruct$FileLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FilesStruct$FileLocation parseFrom(InputStream inputStream) {
        return (FilesStruct$FileLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$FileLocation parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$FileLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$FileLocation parseFrom(AbstractC2384h abstractC2384h) {
        return (FilesStruct$FileLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FilesStruct$FileLocation parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FilesStruct$FileLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

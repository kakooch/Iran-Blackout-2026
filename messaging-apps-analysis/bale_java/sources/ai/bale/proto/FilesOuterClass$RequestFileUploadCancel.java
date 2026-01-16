package ai.bale.proto;

import ai.bale.proto.FilesStruct$FileLocation;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class FilesOuterClass$RequestFileUploadCancel extends GeneratedMessageLite implements U64 {
    private static final FilesOuterClass$RequestFileUploadCancel DEFAULT_INSTANCE;
    public static final int FILE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private FilesStruct$FileLocation file_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(FilesStruct$FileLocation.a aVar) {
            q();
            ((FilesOuterClass$RequestFileUploadCancel) this.b).setFile((FilesStruct$FileLocation) aVar.a());
            return this;
        }

        private a() {
            super(FilesOuterClass$RequestFileUploadCancel.DEFAULT_INSTANCE);
        }
    }

    static {
        FilesOuterClass$RequestFileUploadCancel filesOuterClass$RequestFileUploadCancel = new FilesOuterClass$RequestFileUploadCancel();
        DEFAULT_INSTANCE = filesOuterClass$RequestFileUploadCancel;
        GeneratedMessageLite.registerDefaultInstance(FilesOuterClass$RequestFileUploadCancel.class, filesOuterClass$RequestFileUploadCancel);
    }

    private FilesOuterClass$RequestFileUploadCancel() {
    }

    private void clearFile() {
        this.file_ = null;
        this.bitField0_ &= -2;
    }

    public static FilesOuterClass$RequestFileUploadCancel getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFile(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.file_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.file_ = filesStruct$FileLocation;
        } else {
            this.file_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.file_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static FilesOuterClass$RequestFileUploadCancel parseDelimitedFrom(InputStream inputStream) {
        return (FilesOuterClass$RequestFileUploadCancel) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesOuterClass$RequestFileUploadCancel parseFrom(ByteBuffer byteBuffer) {
        return (FilesOuterClass$RequestFileUploadCancel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFile(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.file_ = filesStruct$FileLocation;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1841b0.a[gVar.ordinal()]) {
            case 1:
                return new FilesOuterClass$RequestFileUploadCancel();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "file_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FilesOuterClass$RequestFileUploadCancel.class) {
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

    public FilesStruct$FileLocation getFile() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.file_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public boolean hasFile() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(FilesOuterClass$RequestFileUploadCancel filesOuterClass$RequestFileUploadCancel) {
        return (a) DEFAULT_INSTANCE.createBuilder(filesOuterClass$RequestFileUploadCancel);
    }

    public static FilesOuterClass$RequestFileUploadCancel parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesOuterClass$RequestFileUploadCancel) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesOuterClass$RequestFileUploadCancel parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FilesOuterClass$RequestFileUploadCancel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FilesOuterClass$RequestFileUploadCancel parseFrom(AbstractC2383g abstractC2383g) {
        return (FilesOuterClass$RequestFileUploadCancel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static FilesOuterClass$RequestFileUploadCancel parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FilesOuterClass$RequestFileUploadCancel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FilesOuterClass$RequestFileUploadCancel parseFrom(byte[] bArr) {
        return (FilesOuterClass$RequestFileUploadCancel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FilesOuterClass$RequestFileUploadCancel parseFrom(byte[] bArr, C2394s c2394s) {
        return (FilesOuterClass$RequestFileUploadCancel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FilesOuterClass$RequestFileUploadCancel parseFrom(InputStream inputStream) {
        return (FilesOuterClass$RequestFileUploadCancel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesOuterClass$RequestFileUploadCancel parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesOuterClass$RequestFileUploadCancel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesOuterClass$RequestFileUploadCancel parseFrom(AbstractC2384h abstractC2384h) {
        return (FilesOuterClass$RequestFileUploadCancel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FilesOuterClass$RequestFileUploadCancel parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FilesOuterClass$RequestFileUploadCancel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

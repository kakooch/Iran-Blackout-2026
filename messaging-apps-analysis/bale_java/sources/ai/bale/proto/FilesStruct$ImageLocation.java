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
public final class FilesStruct$ImageLocation extends GeneratedMessageLite implements U64 {
    private static final FilesStruct$ImageLocation DEFAULT_INSTANCE;
    public static final int FILE_LOCATION_FIELD_NUMBER = 1;
    public static final int FILE_SIZE_FIELD_NUMBER = 4;
    public static final int HEIGHT_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int WIDTH_FIELD_NUMBER = 2;
    private int bitField0_;
    private FilesStruct$FileLocation fileLocation_;
    private int fileSize_;
    private int height_;
    private int width_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(FilesStruct$ImageLocation.DEFAULT_INSTANCE);
        }
    }

    static {
        FilesStruct$ImageLocation filesStruct$ImageLocation = new FilesStruct$ImageLocation();
        DEFAULT_INSTANCE = filesStruct$ImageLocation;
        GeneratedMessageLite.registerDefaultInstance(FilesStruct$ImageLocation.class, filesStruct$ImageLocation);
    }

    private FilesStruct$ImageLocation() {
    }

    private void clearFileLocation() {
        this.fileLocation_ = null;
        this.bitField0_ &= -2;
    }

    private void clearFileSize() {
        this.fileSize_ = 0;
    }

    private void clearHeight() {
        this.height_ = 0;
    }

    private void clearWidth() {
        this.width_ = 0;
    }

    public static FilesStruct$ImageLocation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.fileLocation_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.fileLocation_ = filesStruct$FileLocation;
        } else {
            this.fileLocation_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.fileLocation_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static FilesStruct$ImageLocation parseDelimitedFrom(InputStream inputStream) {
        return (FilesStruct$ImageLocation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$ImageLocation parseFrom(ByteBuffer byteBuffer) {
        return (FilesStruct$ImageLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.fileLocation_ = filesStruct$FileLocation;
        this.bitField0_ |= 1;
    }

    private void setFileSize(int i) {
        this.fileSize_ = i;
    }

    private void setHeight(int i) {
        this.height_ = i;
    }

    private void setWidth(int i) {
        this.width_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1844c0.a[gVar.ordinal()]) {
            case 1:
                return new FilesStruct$ImageLocation();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004\u0003\u0004\u0004\u0004", new Object[]{"bitField0_", "fileLocation_", "width_", "height_", "fileSize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FilesStruct$ImageLocation.class) {
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

    public FilesStruct$FileLocation getFileLocation() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.fileLocation_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public int getFileSize() {
        return this.fileSize_;
    }

    public int getHeight() {
        return this.height_;
    }

    public int getWidth() {
        return this.width_;
    }

    public boolean hasFileLocation() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        return (a) DEFAULT_INSTANCE.createBuilder(filesStruct$ImageLocation);
    }

    public static FilesStruct$ImageLocation parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$ImageLocation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$ImageLocation parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FilesStruct$ImageLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FilesStruct$ImageLocation parseFrom(AbstractC2383g abstractC2383g) {
        return (FilesStruct$ImageLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static FilesStruct$ImageLocation parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FilesStruct$ImageLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FilesStruct$ImageLocation parseFrom(byte[] bArr) {
        return (FilesStruct$ImageLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FilesStruct$ImageLocation parseFrom(byte[] bArr, C2394s c2394s) {
        return (FilesStruct$ImageLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FilesStruct$ImageLocation parseFrom(InputStream inputStream) {
        return (FilesStruct$ImageLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$ImageLocation parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$ImageLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$ImageLocation parseFrom(AbstractC2384h abstractC2384h) {
        return (FilesStruct$ImageLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FilesStruct$ImageLocation parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FilesStruct$ImageLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

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
public final class FilesStruct$FastThumb extends GeneratedMessageLite implements U64 {
    private static final FilesStruct$FastThumb DEFAULT_INSTANCE;
    public static final int H_FIELD_NUMBER = 2;
    public static final int OPT_FILE_LOCATION_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int THUMB_FIELD_NUMBER = 3;
    public static final int W_FIELD_NUMBER = 1;
    private int bitField0_;
    private int h_;
    private FilesStruct$FileLocation optFileLocation_;
    private AbstractC2383g thumb_ = AbstractC2383g.b;
    private int w_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(AbstractC2383g abstractC2383g) {
            q();
            ((FilesStruct$FastThumb) this.b).setThumb(abstractC2383g);
            return this;
        }

        private a() {
            super(FilesStruct$FastThumb.DEFAULT_INSTANCE);
        }
    }

    static {
        FilesStruct$FastThumb filesStruct$FastThumb = new FilesStruct$FastThumb();
        DEFAULT_INSTANCE = filesStruct$FastThumb;
        GeneratedMessageLite.registerDefaultInstance(FilesStruct$FastThumb.class, filesStruct$FastThumb);
    }

    private FilesStruct$FastThumb() {
    }

    private void clearH() {
        this.h_ = 0;
    }

    private void clearOptFileLocation() {
        this.optFileLocation_ = null;
        this.bitField0_ &= -2;
    }

    private void clearThumb() {
        this.thumb_ = getDefaultInstance().getThumb();
    }

    private void clearW() {
        this.w_ = 0;
    }

    public static FilesStruct$FastThumb getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeOptFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.optFileLocation_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.optFileLocation_ = filesStruct$FileLocation;
        } else {
            this.optFileLocation_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.optFileLocation_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static FilesStruct$FastThumb parseDelimitedFrom(InputStream inputStream) {
        return (FilesStruct$FastThumb) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$FastThumb parseFrom(ByteBuffer byteBuffer) {
        return (FilesStruct$FastThumb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setH(int i) {
        this.h_ = i;
    }

    private void setOptFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.optFileLocation_ = filesStruct$FileLocation;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumb(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.thumb_ = abstractC2383g;
    }

    private void setW(int i) {
        this.w_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1844c0.a[gVar.ordinal()]) {
            case 1:
                return new FilesStruct$FastThumb();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\n\u0004ဉ\u0000", new Object[]{"bitField0_", "w_", "h_", "thumb_", "optFileLocation_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FilesStruct$FastThumb.class) {
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

    public int getH() {
        return this.h_;
    }

    public FilesStruct$FileLocation getOptFileLocation() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.optFileLocation_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public AbstractC2383g getThumb() {
        return this.thumb_;
    }

    public int getW() {
        return this.w_;
    }

    public boolean hasOptFileLocation() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(FilesStruct$FastThumb filesStruct$FastThumb) {
        return (a) DEFAULT_INSTANCE.createBuilder(filesStruct$FastThumb);
    }

    public static FilesStruct$FastThumb parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$FastThumb) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$FastThumb parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FilesStruct$FastThumb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FilesStruct$FastThumb parseFrom(AbstractC2383g abstractC2383g) {
        return (FilesStruct$FastThumb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static FilesStruct$FastThumb parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FilesStruct$FastThumb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FilesStruct$FastThumb parseFrom(byte[] bArr) {
        return (FilesStruct$FastThumb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FilesStruct$FastThumb parseFrom(byte[] bArr, C2394s c2394s) {
        return (FilesStruct$FastThumb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FilesStruct$FastThumb parseFrom(InputStream inputStream) {
        return (FilesStruct$FastThumb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesStruct$FastThumb parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesStruct$FastThumb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesStruct$FastThumb parseFrom(AbstractC2384h abstractC2384h) {
        return (FilesStruct$FastThumb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FilesStruct$FastThumb parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FilesStruct$FastThumb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

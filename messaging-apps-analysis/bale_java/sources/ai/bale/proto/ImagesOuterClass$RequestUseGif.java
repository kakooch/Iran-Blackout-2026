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
public final class ImagesOuterClass$RequestUseGif extends GeneratedMessageLite implements U64 {
    private static final ImagesOuterClass$RequestUseGif DEFAULT_INSTANCE;
    public static final int GIF_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int USED_AT_FIELD_NUMBER = 2;
    private int bitField0_;
    private FilesStruct$FileLocation gif_;
    private long usedAt_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(FilesStruct$FileLocation filesStruct$FileLocation) {
            q();
            ((ImagesOuterClass$RequestUseGif) this.b).setGif(filesStruct$FileLocation);
            return this;
        }

        public a B(long j) {
            q();
            ((ImagesOuterClass$RequestUseGif) this.b).setUsedAt(j);
            return this;
        }

        private a() {
            super(ImagesOuterClass$RequestUseGif.DEFAULT_INSTANCE);
        }
    }

    static {
        ImagesOuterClass$RequestUseGif imagesOuterClass$RequestUseGif = new ImagesOuterClass$RequestUseGif();
        DEFAULT_INSTANCE = imagesOuterClass$RequestUseGif;
        GeneratedMessageLite.registerDefaultInstance(ImagesOuterClass$RequestUseGif.class, imagesOuterClass$RequestUseGif);
    }

    private ImagesOuterClass$RequestUseGif() {
    }

    private void clearGif() {
        this.gif_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUsedAt() {
        this.usedAt_ = 0L;
    }

    public static ImagesOuterClass$RequestUseGif getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGif(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.gif_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.gif_ = filesStruct$FileLocation;
        } else {
            this.gif_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.gif_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ImagesOuterClass$RequestUseGif parseDelimitedFrom(InputStream inputStream) {
        return (ImagesOuterClass$RequestUseGif) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$RequestUseGif parseFrom(ByteBuffer byteBuffer) {
        return (ImagesOuterClass$RequestUseGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGif(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.gif_ = filesStruct$FileLocation;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsedAt(long j) {
        this.usedAt_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1883p0.a[gVar.ordinal()]) {
            case 1:
                return new ImagesOuterClass$RequestUseGif();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002", new Object[]{"bitField0_", "gif_", "usedAt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ImagesOuterClass$RequestUseGif.class) {
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

    public FilesStruct$FileLocation getGif() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.gif_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public long getUsedAt() {
        return this.usedAt_;
    }

    public boolean hasGif() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ImagesOuterClass$RequestUseGif imagesOuterClass$RequestUseGif) {
        return (a) DEFAULT_INSTANCE.createBuilder(imagesOuterClass$RequestUseGif);
    }

    public static ImagesOuterClass$RequestUseGif parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$RequestUseGif) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$RequestUseGif parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ImagesOuterClass$RequestUseGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ImagesOuterClass$RequestUseGif parseFrom(AbstractC2383g abstractC2383g) {
        return (ImagesOuterClass$RequestUseGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ImagesOuterClass$RequestUseGif parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ImagesOuterClass$RequestUseGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ImagesOuterClass$RequestUseGif parseFrom(byte[] bArr) {
        return (ImagesOuterClass$RequestUseGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ImagesOuterClass$RequestUseGif parseFrom(byte[] bArr, C2394s c2394s) {
        return (ImagesOuterClass$RequestUseGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ImagesOuterClass$RequestUseGif parseFrom(InputStream inputStream) {
        return (ImagesOuterClass$RequestUseGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$RequestUseGif parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$RequestUseGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$RequestUseGif parseFrom(AbstractC2384h abstractC2384h) {
        return (ImagesOuterClass$RequestUseGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ImagesOuterClass$RequestUseGif parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ImagesOuterClass$RequestUseGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

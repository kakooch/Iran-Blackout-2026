package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$StringValue;
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
public final class ImagesOuterClass$RequestAddGif extends GeneratedMessageLite implements U64 {
    private static final ImagesOuterClass$RequestAddGif DEFAULT_INSTANCE;
    public static final int GIF_FIELD_NUMBER = 1;
    public static final int MIME_TYPE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int THUMB_FIELD_NUMBER = 2;
    private int bitField0_;
    private FilesStruct$FileLocation gif_;
    private CollectionsStruct$StringValue mimeType_;
    private AbstractC2383g thumb_ = AbstractC2383g.b;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(FilesStruct$FileLocation filesStruct$FileLocation) {
            q();
            ((ImagesOuterClass$RequestAddGif) this.b).setGif(filesStruct$FileLocation);
            return this;
        }

        public a B(CollectionsStruct$StringValue collectionsStruct$StringValue) {
            q();
            ((ImagesOuterClass$RequestAddGif) this.b).setMimeType(collectionsStruct$StringValue);
            return this;
        }

        public a C(AbstractC2383g abstractC2383g) {
            q();
            ((ImagesOuterClass$RequestAddGif) this.b).setThumb(abstractC2383g);
            return this;
        }

        private a() {
            super(ImagesOuterClass$RequestAddGif.DEFAULT_INSTANCE);
        }
    }

    static {
        ImagesOuterClass$RequestAddGif imagesOuterClass$RequestAddGif = new ImagesOuterClass$RequestAddGif();
        DEFAULT_INSTANCE = imagesOuterClass$RequestAddGif;
        GeneratedMessageLite.registerDefaultInstance(ImagesOuterClass$RequestAddGif.class, imagesOuterClass$RequestAddGif);
    }

    private ImagesOuterClass$RequestAddGif() {
    }

    private void clearGif() {
        this.gif_ = null;
        this.bitField0_ &= -2;
    }

    private void clearMimeType() {
        this.mimeType_ = null;
        this.bitField0_ &= -3;
    }

    private void clearThumb() {
        this.thumb_ = getDefaultInstance().getThumb();
    }

    public static ImagesOuterClass$RequestAddGif getDefaultInstance() {
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

    private void mergeMimeType(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.mimeType_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.mimeType_ = collectionsStruct$StringValue;
        } else {
            this.mimeType_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.mimeType_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ImagesOuterClass$RequestAddGif parseDelimitedFrom(InputStream inputStream) {
        return (ImagesOuterClass$RequestAddGif) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$RequestAddGif parseFrom(ByteBuffer byteBuffer) {
        return (ImagesOuterClass$RequestAddGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setMimeType(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.mimeType_ = collectionsStruct$StringValue;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumb(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.thumb_ = abstractC2383g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1883p0.a[gVar.ordinal()]) {
            case 1:
                return new ImagesOuterClass$RequestAddGif();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\n\u0003ဉ\u0001", new Object[]{"bitField0_", "gif_", "thumb_", "mimeType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ImagesOuterClass$RequestAddGif.class) {
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

    public CollectionsStruct$StringValue getMimeType() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.mimeType_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public AbstractC2383g getThumb() {
        return this.thumb_;
    }

    public boolean hasGif() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMimeType() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(ImagesOuterClass$RequestAddGif imagesOuterClass$RequestAddGif) {
        return (a) DEFAULT_INSTANCE.createBuilder(imagesOuterClass$RequestAddGif);
    }

    public static ImagesOuterClass$RequestAddGif parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$RequestAddGif) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$RequestAddGif parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ImagesOuterClass$RequestAddGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ImagesOuterClass$RequestAddGif parseFrom(AbstractC2383g abstractC2383g) {
        return (ImagesOuterClass$RequestAddGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ImagesOuterClass$RequestAddGif parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ImagesOuterClass$RequestAddGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ImagesOuterClass$RequestAddGif parseFrom(byte[] bArr) {
        return (ImagesOuterClass$RequestAddGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ImagesOuterClass$RequestAddGif parseFrom(byte[] bArr, C2394s c2394s) {
        return (ImagesOuterClass$RequestAddGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ImagesOuterClass$RequestAddGif parseFrom(InputStream inputStream) {
        return (ImagesOuterClass$RequestAddGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$RequestAddGif parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$RequestAddGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$RequestAddGif parseFrom(AbstractC2384h abstractC2384h) {
        return (ImagesOuterClass$RequestAddGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ImagesOuterClass$RequestAddGif parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ImagesOuterClass$RequestAddGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import ai.bale.proto.ImagesStruct$StickerCollection;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ImagesOuterClass$ResponseLoadStickerCollection extends GeneratedMessageLite implements U64 {
    public static final int COLLECTION_FIELD_NUMBER = 1;
    private static final ImagesOuterClass$ResponseLoadStickerCollection DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private ImagesStruct$StickerCollection collection_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ImagesOuterClass$ResponseLoadStickerCollection.DEFAULT_INSTANCE);
        }
    }

    static {
        ImagesOuterClass$ResponseLoadStickerCollection imagesOuterClass$ResponseLoadStickerCollection = new ImagesOuterClass$ResponseLoadStickerCollection();
        DEFAULT_INSTANCE = imagesOuterClass$ResponseLoadStickerCollection;
        GeneratedMessageLite.registerDefaultInstance(ImagesOuterClass$ResponseLoadStickerCollection.class, imagesOuterClass$ResponseLoadStickerCollection);
    }

    private ImagesOuterClass$ResponseLoadStickerCollection() {
    }

    private void clearCollection() {
        this.collection_ = null;
        this.bitField0_ &= -2;
    }

    public static ImagesOuterClass$ResponseLoadStickerCollection getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCollection(ImagesStruct$StickerCollection imagesStruct$StickerCollection) {
        imagesStruct$StickerCollection.getClass();
        ImagesStruct$StickerCollection imagesStruct$StickerCollection2 = this.collection_;
        if (imagesStruct$StickerCollection2 == null || imagesStruct$StickerCollection2 == ImagesStruct$StickerCollection.getDefaultInstance()) {
            this.collection_ = imagesStruct$StickerCollection;
        } else {
            this.collection_ = (ImagesStruct$StickerCollection) ((ImagesStruct$StickerCollection.a) ImagesStruct$StickerCollection.newBuilder(this.collection_).v(imagesStruct$StickerCollection)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ImagesOuterClass$ResponseLoadStickerCollection parseDelimitedFrom(InputStream inputStream) {
        return (ImagesOuterClass$ResponseLoadStickerCollection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$ResponseLoadStickerCollection parseFrom(ByteBuffer byteBuffer) {
        return (ImagesOuterClass$ResponseLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCollection(ImagesStruct$StickerCollection imagesStruct$StickerCollection) {
        imagesStruct$StickerCollection.getClass();
        this.collection_ = imagesStruct$StickerCollection;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1883p0.a[gVar.ordinal()]) {
            case 1:
                return new ImagesOuterClass$ResponseLoadStickerCollection();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "collection_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ImagesOuterClass$ResponseLoadStickerCollection.class) {
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

    public ImagesStruct$StickerCollection getCollection() {
        ImagesStruct$StickerCollection imagesStruct$StickerCollection = this.collection_;
        return imagesStruct$StickerCollection == null ? ImagesStruct$StickerCollection.getDefaultInstance() : imagesStruct$StickerCollection;
    }

    public boolean hasCollection() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ImagesOuterClass$ResponseLoadStickerCollection imagesOuterClass$ResponseLoadStickerCollection) {
        return (a) DEFAULT_INSTANCE.createBuilder(imagesOuterClass$ResponseLoadStickerCollection);
    }

    public static ImagesOuterClass$ResponseLoadStickerCollection parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$ResponseLoadStickerCollection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$ResponseLoadStickerCollection parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ImagesOuterClass$ResponseLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ImagesOuterClass$ResponseLoadStickerCollection parseFrom(AbstractC2383g abstractC2383g) {
        return (ImagesOuterClass$ResponseLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ImagesOuterClass$ResponseLoadStickerCollection parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ImagesOuterClass$ResponseLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ImagesOuterClass$ResponseLoadStickerCollection parseFrom(byte[] bArr) {
        return (ImagesOuterClass$ResponseLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ImagesOuterClass$ResponseLoadStickerCollection parseFrom(byte[] bArr, C2394s c2394s) {
        return (ImagesOuterClass$ResponseLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ImagesOuterClass$ResponseLoadStickerCollection parseFrom(InputStream inputStream) {
        return (ImagesOuterClass$ResponseLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$ResponseLoadStickerCollection parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$ResponseLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$ResponseLoadStickerCollection parseFrom(AbstractC2384h abstractC2384h) {
        return (ImagesOuterClass$ResponseLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ImagesOuterClass$ResponseLoadStickerCollection parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ImagesOuterClass$ResponseLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

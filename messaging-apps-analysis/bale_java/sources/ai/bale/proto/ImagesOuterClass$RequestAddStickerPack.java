package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ImagesOuterClass$RequestAddStickerPack extends GeneratedMessageLite implements U64 {
    private static final ImagesOuterClass$RequestAddStickerPack DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int id_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((ImagesOuterClass$RequestAddStickerPack) this.b).setId(i);
            return this;
        }

        private a() {
            super(ImagesOuterClass$RequestAddStickerPack.DEFAULT_INSTANCE);
        }
    }

    static {
        ImagesOuterClass$RequestAddStickerPack imagesOuterClass$RequestAddStickerPack = new ImagesOuterClass$RequestAddStickerPack();
        DEFAULT_INSTANCE = imagesOuterClass$RequestAddStickerPack;
        GeneratedMessageLite.registerDefaultInstance(ImagesOuterClass$RequestAddStickerPack.class, imagesOuterClass$RequestAddStickerPack);
    }

    private ImagesOuterClass$RequestAddStickerPack() {
    }

    private void clearId() {
        this.id_ = 0;
    }

    public static ImagesOuterClass$RequestAddStickerPack getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ImagesOuterClass$RequestAddStickerPack parseDelimitedFrom(InputStream inputStream) {
        return (ImagesOuterClass$RequestAddStickerPack) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$RequestAddStickerPack parseFrom(ByteBuffer byteBuffer) {
        return (ImagesOuterClass$RequestAddStickerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(int i) {
        this.id_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1883p0.a[gVar.ordinal()]) {
            case 1:
                return new ImagesOuterClass$RequestAddStickerPack();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"id_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ImagesOuterClass$RequestAddStickerPack.class) {
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

    public int getId() {
        return this.id_;
    }

    public static a newBuilder(ImagesOuterClass$RequestAddStickerPack imagesOuterClass$RequestAddStickerPack) {
        return (a) DEFAULT_INSTANCE.createBuilder(imagesOuterClass$RequestAddStickerPack);
    }

    public static ImagesOuterClass$RequestAddStickerPack parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$RequestAddStickerPack) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$RequestAddStickerPack parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ImagesOuterClass$RequestAddStickerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ImagesOuterClass$RequestAddStickerPack parseFrom(AbstractC2383g abstractC2383g) {
        return (ImagesOuterClass$RequestAddStickerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ImagesOuterClass$RequestAddStickerPack parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ImagesOuterClass$RequestAddStickerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ImagesOuterClass$RequestAddStickerPack parseFrom(byte[] bArr) {
        return (ImagesOuterClass$RequestAddStickerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ImagesOuterClass$RequestAddStickerPack parseFrom(byte[] bArr, C2394s c2394s) {
        return (ImagesOuterClass$RequestAddStickerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ImagesOuterClass$RequestAddStickerPack parseFrom(InputStream inputStream) {
        return (ImagesOuterClass$RequestAddStickerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$RequestAddStickerPack parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$RequestAddStickerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$RequestAddStickerPack parseFrom(AbstractC2384h abstractC2384h) {
        return (ImagesOuterClass$RequestAddStickerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ImagesOuterClass$RequestAddStickerPack parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ImagesOuterClass$RequestAddStickerPack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

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
public final class ImagesOuterClass$UpdateStickerPacksChanged extends GeneratedMessageLite implements U64 {
    private static final ImagesOuterClass$UpdateStickerPacksChanged DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ImagesOuterClass$UpdateStickerPacksChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        ImagesOuterClass$UpdateStickerPacksChanged imagesOuterClass$UpdateStickerPacksChanged = new ImagesOuterClass$UpdateStickerPacksChanged();
        DEFAULT_INSTANCE = imagesOuterClass$UpdateStickerPacksChanged;
        GeneratedMessageLite.registerDefaultInstance(ImagesOuterClass$UpdateStickerPacksChanged.class, imagesOuterClass$UpdateStickerPacksChanged);
    }

    private ImagesOuterClass$UpdateStickerPacksChanged() {
    }

    public static ImagesOuterClass$UpdateStickerPacksChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ImagesOuterClass$UpdateStickerPacksChanged parseDelimitedFrom(InputStream inputStream) {
        return (ImagesOuterClass$UpdateStickerPacksChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$UpdateStickerPacksChanged parseFrom(ByteBuffer byteBuffer) {
        return (ImagesOuterClass$UpdateStickerPacksChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1883p0.a[gVar.ordinal()]) {
            case 1:
                return new ImagesOuterClass$UpdateStickerPacksChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ImagesOuterClass$UpdateStickerPacksChanged.class) {
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

    public static a newBuilder(ImagesOuterClass$UpdateStickerPacksChanged imagesOuterClass$UpdateStickerPacksChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(imagesOuterClass$UpdateStickerPacksChanged);
    }

    public static ImagesOuterClass$UpdateStickerPacksChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$UpdateStickerPacksChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$UpdateStickerPacksChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ImagesOuterClass$UpdateStickerPacksChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ImagesOuterClass$UpdateStickerPacksChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (ImagesOuterClass$UpdateStickerPacksChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ImagesOuterClass$UpdateStickerPacksChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ImagesOuterClass$UpdateStickerPacksChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ImagesOuterClass$UpdateStickerPacksChanged parseFrom(byte[] bArr) {
        return (ImagesOuterClass$UpdateStickerPacksChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ImagesOuterClass$UpdateStickerPacksChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (ImagesOuterClass$UpdateStickerPacksChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ImagesOuterClass$UpdateStickerPacksChanged parseFrom(InputStream inputStream) {
        return (ImagesOuterClass$UpdateStickerPacksChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$UpdateStickerPacksChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$UpdateStickerPacksChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$UpdateStickerPacksChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (ImagesOuterClass$UpdateStickerPacksChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ImagesOuterClass$UpdateStickerPacksChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ImagesOuterClass$UpdateStickerPacksChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

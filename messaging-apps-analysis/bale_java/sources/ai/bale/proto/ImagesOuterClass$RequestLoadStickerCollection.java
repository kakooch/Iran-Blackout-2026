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
public final class ImagesOuterClass$RequestLoadStickerCollection extends GeneratedMessageLite implements U64 {
    public static final int ACCESS_HASH_FIELD_NUMBER = 2;
    private static final ImagesOuterClass$RequestLoadStickerCollection DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private long accessHash_;
    private int id_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((ImagesOuterClass$RequestLoadStickerCollection) this.b).setAccessHash(j);
            return this;
        }

        public a B(int i) {
            q();
            ((ImagesOuterClass$RequestLoadStickerCollection) this.b).setId(i);
            return this;
        }

        private a() {
            super(ImagesOuterClass$RequestLoadStickerCollection.DEFAULT_INSTANCE);
        }
    }

    static {
        ImagesOuterClass$RequestLoadStickerCollection imagesOuterClass$RequestLoadStickerCollection = new ImagesOuterClass$RequestLoadStickerCollection();
        DEFAULT_INSTANCE = imagesOuterClass$RequestLoadStickerCollection;
        GeneratedMessageLite.registerDefaultInstance(ImagesOuterClass$RequestLoadStickerCollection.class, imagesOuterClass$RequestLoadStickerCollection);
    }

    private ImagesOuterClass$RequestLoadStickerCollection() {
    }

    private void clearAccessHash() {
        this.accessHash_ = 0L;
    }

    private void clearId() {
        this.id_ = 0;
    }

    public static ImagesOuterClass$RequestLoadStickerCollection getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ImagesOuterClass$RequestLoadStickerCollection parseDelimitedFrom(InputStream inputStream) {
        return (ImagesOuterClass$RequestLoadStickerCollection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$RequestLoadStickerCollection parseFrom(ByteBuffer byteBuffer) {
        return (ImagesOuterClass$RequestLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccessHash(long j) {
        this.accessHash_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(int i) {
        this.id_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1883p0.a[gVar.ordinal()]) {
            case 1:
                return new ImagesOuterClass$RequestLoadStickerCollection();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0002", new Object[]{"id_", "accessHash_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ImagesOuterClass$RequestLoadStickerCollection.class) {
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

    public int getId() {
        return this.id_;
    }

    public static a newBuilder(ImagesOuterClass$RequestLoadStickerCollection imagesOuterClass$RequestLoadStickerCollection) {
        return (a) DEFAULT_INSTANCE.createBuilder(imagesOuterClass$RequestLoadStickerCollection);
    }

    public static ImagesOuterClass$RequestLoadStickerCollection parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$RequestLoadStickerCollection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$RequestLoadStickerCollection parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ImagesOuterClass$RequestLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ImagesOuterClass$RequestLoadStickerCollection parseFrom(AbstractC2383g abstractC2383g) {
        return (ImagesOuterClass$RequestLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ImagesOuterClass$RequestLoadStickerCollection parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ImagesOuterClass$RequestLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ImagesOuterClass$RequestLoadStickerCollection parseFrom(byte[] bArr) {
        return (ImagesOuterClass$RequestLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ImagesOuterClass$RequestLoadStickerCollection parseFrom(byte[] bArr, C2394s c2394s) {
        return (ImagesOuterClass$RequestLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ImagesOuterClass$RequestLoadStickerCollection parseFrom(InputStream inputStream) {
        return (ImagesOuterClass$RequestLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$RequestLoadStickerCollection parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$RequestLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$RequestLoadStickerCollection parseFrom(AbstractC2384h abstractC2384h) {
        return (ImagesOuterClass$RequestLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ImagesOuterClass$RequestLoadStickerCollection parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ImagesOuterClass$RequestLoadStickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

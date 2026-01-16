package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.O33;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class ImagesOuterClass$UpdateStickerCollectionsChanged extends GeneratedMessageLite implements U64 {
    public static final int COLLECTIONS_FIELD_NUMBER = 1;
    private static final ImagesOuterClass$UpdateStickerCollectionsChanged DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j collections_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ImagesOuterClass$UpdateStickerCollectionsChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        ImagesOuterClass$UpdateStickerCollectionsChanged imagesOuterClass$UpdateStickerCollectionsChanged = new ImagesOuterClass$UpdateStickerCollectionsChanged();
        DEFAULT_INSTANCE = imagesOuterClass$UpdateStickerCollectionsChanged;
        GeneratedMessageLite.registerDefaultInstance(ImagesOuterClass$UpdateStickerCollectionsChanged.class, imagesOuterClass$UpdateStickerCollectionsChanged);
    }

    private ImagesOuterClass$UpdateStickerCollectionsChanged() {
    }

    private void addAllCollections(Iterable<? extends ImagesStruct$StickerCollection> iterable) {
        ensureCollectionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.collections_);
    }

    private void addCollections(ImagesStruct$StickerCollection imagesStruct$StickerCollection) {
        imagesStruct$StickerCollection.getClass();
        ensureCollectionsIsMutable();
        this.collections_.add(imagesStruct$StickerCollection);
    }

    private void clearCollections() {
        this.collections_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureCollectionsIsMutable() {
        B.j jVar = this.collections_;
        if (jVar.u()) {
            return;
        }
        this.collections_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ImagesOuterClass$UpdateStickerCollectionsChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ImagesOuterClass$UpdateStickerCollectionsChanged parseDelimitedFrom(InputStream inputStream) {
        return (ImagesOuterClass$UpdateStickerCollectionsChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$UpdateStickerCollectionsChanged parseFrom(ByteBuffer byteBuffer) {
        return (ImagesOuterClass$UpdateStickerCollectionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCollections(int i) {
        ensureCollectionsIsMutable();
        this.collections_.remove(i);
    }

    private void setCollections(int i, ImagesStruct$StickerCollection imagesStruct$StickerCollection) {
        imagesStruct$StickerCollection.getClass();
        ensureCollectionsIsMutable();
        this.collections_.set(i, imagesStruct$StickerCollection);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1883p0.a[gVar.ordinal()]) {
            case 1:
                return new ImagesOuterClass$UpdateStickerCollectionsChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"collections_", ImagesStruct$StickerCollection.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ImagesOuterClass$UpdateStickerCollectionsChanged.class) {
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

    public ImagesStruct$StickerCollection getCollections(int i) {
        return (ImagesStruct$StickerCollection) this.collections_.get(i);
    }

    public int getCollectionsCount() {
        return this.collections_.size();
    }

    public List<ImagesStruct$StickerCollection> getCollectionsList() {
        return this.collections_;
    }

    public O33 getCollectionsOrBuilder(int i) {
        return (O33) this.collections_.get(i);
    }

    public List<? extends O33> getCollectionsOrBuilderList() {
        return this.collections_;
    }

    public static a newBuilder(ImagesOuterClass$UpdateStickerCollectionsChanged imagesOuterClass$UpdateStickerCollectionsChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(imagesOuterClass$UpdateStickerCollectionsChanged);
    }

    public static ImagesOuterClass$UpdateStickerCollectionsChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$UpdateStickerCollectionsChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$UpdateStickerCollectionsChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ImagesOuterClass$UpdateStickerCollectionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ImagesOuterClass$UpdateStickerCollectionsChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (ImagesOuterClass$UpdateStickerCollectionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCollections(int i, ImagesStruct$StickerCollection imagesStruct$StickerCollection) {
        imagesStruct$StickerCollection.getClass();
        ensureCollectionsIsMutable();
        this.collections_.add(i, imagesStruct$StickerCollection);
    }

    public static ImagesOuterClass$UpdateStickerCollectionsChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ImagesOuterClass$UpdateStickerCollectionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ImagesOuterClass$UpdateStickerCollectionsChanged parseFrom(byte[] bArr) {
        return (ImagesOuterClass$UpdateStickerCollectionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ImagesOuterClass$UpdateStickerCollectionsChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (ImagesOuterClass$UpdateStickerCollectionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ImagesOuterClass$UpdateStickerCollectionsChanged parseFrom(InputStream inputStream) {
        return (ImagesOuterClass$UpdateStickerCollectionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$UpdateStickerCollectionsChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$UpdateStickerCollectionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$UpdateStickerCollectionsChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (ImagesOuterClass$UpdateStickerCollectionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ImagesOuterClass$UpdateStickerCollectionsChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ImagesOuterClass$UpdateStickerCollectionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

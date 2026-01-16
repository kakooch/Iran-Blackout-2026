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
public final class ImagesOuterClass$ResponseStickersReponse extends GeneratedMessageLite implements U64 {
    public static final int COLLECTIONS_FIELD_NUMBER = 1;
    private static final ImagesOuterClass$ResponseStickersReponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SEQ_FIELD_NUMBER = 2;
    public static final int STATE_FIELD_NUMBER = 3;
    private int seq_;
    private B.j collections_ = GeneratedMessageLite.emptyProtobufList();
    private AbstractC2383g state_ = AbstractC2383g.b;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ImagesOuterClass$ResponseStickersReponse.DEFAULT_INSTANCE);
        }
    }

    static {
        ImagesOuterClass$ResponseStickersReponse imagesOuterClass$ResponseStickersReponse = new ImagesOuterClass$ResponseStickersReponse();
        DEFAULT_INSTANCE = imagesOuterClass$ResponseStickersReponse;
        GeneratedMessageLite.registerDefaultInstance(ImagesOuterClass$ResponseStickersReponse.class, imagesOuterClass$ResponseStickersReponse);
    }

    private ImagesOuterClass$ResponseStickersReponse() {
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

    private void clearSeq() {
        this.seq_ = 0;
    }

    private void clearState() {
        this.state_ = getDefaultInstance().getState();
    }

    private void ensureCollectionsIsMutable() {
        B.j jVar = this.collections_;
        if (jVar.u()) {
            return;
        }
        this.collections_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ImagesOuterClass$ResponseStickersReponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ImagesOuterClass$ResponseStickersReponse parseDelimitedFrom(InputStream inputStream) {
        return (ImagesOuterClass$ResponseStickersReponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$ResponseStickersReponse parseFrom(ByteBuffer byteBuffer) {
        return (ImagesOuterClass$ResponseStickersReponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setSeq(int i) {
        this.seq_ = i;
    }

    private void setState(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.state_ = abstractC2383g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1883p0.a[gVar.ordinal()]) {
            case 1:
                return new ImagesOuterClass$ResponseStickersReponse();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002\u0004\u0003\n", new Object[]{"collections_", ImagesStruct$StickerCollection.class, "seq_", "state_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ImagesOuterClass$ResponseStickersReponse.class) {
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

    public int getSeq() {
        return this.seq_;
    }

    public AbstractC2383g getState() {
        return this.state_;
    }

    public static a newBuilder(ImagesOuterClass$ResponseStickersReponse imagesOuterClass$ResponseStickersReponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(imagesOuterClass$ResponseStickersReponse);
    }

    public static ImagesOuterClass$ResponseStickersReponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$ResponseStickersReponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$ResponseStickersReponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ImagesOuterClass$ResponseStickersReponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ImagesOuterClass$ResponseStickersReponse parseFrom(AbstractC2383g abstractC2383g) {
        return (ImagesOuterClass$ResponseStickersReponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCollections(int i, ImagesStruct$StickerCollection imagesStruct$StickerCollection) {
        imagesStruct$StickerCollection.getClass();
        ensureCollectionsIsMutable();
        this.collections_.add(i, imagesStruct$StickerCollection);
    }

    public static ImagesOuterClass$ResponseStickersReponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ImagesOuterClass$ResponseStickersReponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ImagesOuterClass$ResponseStickersReponse parseFrom(byte[] bArr) {
        return (ImagesOuterClass$ResponseStickersReponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ImagesOuterClass$ResponseStickersReponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (ImagesOuterClass$ResponseStickersReponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ImagesOuterClass$ResponseStickersReponse parseFrom(InputStream inputStream) {
        return (ImagesOuterClass$ResponseStickersReponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$ResponseStickersReponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$ResponseStickersReponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$ResponseStickersReponse parseFrom(AbstractC2384h abstractC2384h) {
        return (ImagesOuterClass$ResponseStickersReponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ImagesOuterClass$ResponseStickersReponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ImagesOuterClass$ResponseStickersReponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$StringValue;
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
public final class ImagesOuterClass$ResponseLoadOwnStickers extends GeneratedMessageLite implements U64 {
    private static final ImagesOuterClass$ResponseLoadOwnStickers DEFAULT_INSTANCE;
    public static final int OFFSET_FIELD_NUMBER = 2;
    public static final int OWN_STICKERS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private CollectionsStruct$StringValue offset_;
    private B.j ownStickers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ImagesOuterClass$ResponseLoadOwnStickers.DEFAULT_INSTANCE);
        }
    }

    static {
        ImagesOuterClass$ResponseLoadOwnStickers imagesOuterClass$ResponseLoadOwnStickers = new ImagesOuterClass$ResponseLoadOwnStickers();
        DEFAULT_INSTANCE = imagesOuterClass$ResponseLoadOwnStickers;
        GeneratedMessageLite.registerDefaultInstance(ImagesOuterClass$ResponseLoadOwnStickers.class, imagesOuterClass$ResponseLoadOwnStickers);
    }

    private ImagesOuterClass$ResponseLoadOwnStickers() {
    }

    private void addAllOwnStickers(Iterable<? extends ImagesStruct$StickerCollection> iterable) {
        ensureOwnStickersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.ownStickers_);
    }

    private void addOwnStickers(ImagesStruct$StickerCollection imagesStruct$StickerCollection) {
        imagesStruct$StickerCollection.getClass();
        ensureOwnStickersIsMutable();
        this.ownStickers_.add(imagesStruct$StickerCollection);
    }

    private void clearOffset() {
        this.offset_ = null;
        this.bitField0_ &= -2;
    }

    private void clearOwnStickers() {
        this.ownStickers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureOwnStickersIsMutable() {
        B.j jVar = this.ownStickers_;
        if (jVar.u()) {
            return;
        }
        this.ownStickers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ImagesOuterClass$ResponseLoadOwnStickers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeOffset(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.offset_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.offset_ = collectionsStruct$StringValue;
        } else {
            this.offset_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.offset_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ImagesOuterClass$ResponseLoadOwnStickers parseDelimitedFrom(InputStream inputStream) {
        return (ImagesOuterClass$ResponseLoadOwnStickers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$ResponseLoadOwnStickers parseFrom(ByteBuffer byteBuffer) {
        return (ImagesOuterClass$ResponseLoadOwnStickers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeOwnStickers(int i) {
        ensureOwnStickersIsMutable();
        this.ownStickers_.remove(i);
    }

    private void setOffset(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.offset_ = collectionsStruct$StringValue;
        this.bitField0_ |= 1;
    }

    private void setOwnStickers(int i, ImagesStruct$StickerCollection imagesStruct$StickerCollection) {
        imagesStruct$StickerCollection.getClass();
        ensureOwnStickersIsMutable();
        this.ownStickers_.set(i, imagesStruct$StickerCollection);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1883p0.a[gVar.ordinal()]) {
            case 1:
                return new ImagesOuterClass$ResponseLoadOwnStickers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"bitField0_", "ownStickers_", ImagesStruct$StickerCollection.class, "offset_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ImagesOuterClass$ResponseLoadOwnStickers.class) {
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

    public CollectionsStruct$StringValue getOffset() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.offset_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public ImagesStruct$StickerCollection getOwnStickers(int i) {
        return (ImagesStruct$StickerCollection) this.ownStickers_.get(i);
    }

    public int getOwnStickersCount() {
        return this.ownStickers_.size();
    }

    public List<ImagesStruct$StickerCollection> getOwnStickersList() {
        return this.ownStickers_;
    }

    public O33 getOwnStickersOrBuilder(int i) {
        return (O33) this.ownStickers_.get(i);
    }

    public List<? extends O33> getOwnStickersOrBuilderList() {
        return this.ownStickers_;
    }

    public boolean hasOffset() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ImagesOuterClass$ResponseLoadOwnStickers imagesOuterClass$ResponseLoadOwnStickers) {
        return (a) DEFAULT_INSTANCE.createBuilder(imagesOuterClass$ResponseLoadOwnStickers);
    }

    public static ImagesOuterClass$ResponseLoadOwnStickers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$ResponseLoadOwnStickers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$ResponseLoadOwnStickers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ImagesOuterClass$ResponseLoadOwnStickers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ImagesOuterClass$ResponseLoadOwnStickers parseFrom(AbstractC2383g abstractC2383g) {
        return (ImagesOuterClass$ResponseLoadOwnStickers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addOwnStickers(int i, ImagesStruct$StickerCollection imagesStruct$StickerCollection) {
        imagesStruct$StickerCollection.getClass();
        ensureOwnStickersIsMutable();
        this.ownStickers_.add(i, imagesStruct$StickerCollection);
    }

    public static ImagesOuterClass$ResponseLoadOwnStickers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ImagesOuterClass$ResponseLoadOwnStickers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ImagesOuterClass$ResponseLoadOwnStickers parseFrom(byte[] bArr) {
        return (ImagesOuterClass$ResponseLoadOwnStickers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ImagesOuterClass$ResponseLoadOwnStickers parseFrom(byte[] bArr, C2394s c2394s) {
        return (ImagesOuterClass$ResponseLoadOwnStickers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ImagesOuterClass$ResponseLoadOwnStickers parseFrom(InputStream inputStream) {
        return (ImagesOuterClass$ResponseLoadOwnStickers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$ResponseLoadOwnStickers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$ResponseLoadOwnStickers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$ResponseLoadOwnStickers parseFrom(AbstractC2384h abstractC2384h) {
        return (ImagesOuterClass$ResponseLoadOwnStickers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ImagesOuterClass$ResponseLoadOwnStickers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ImagesOuterClass$ResponseLoadOwnStickers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

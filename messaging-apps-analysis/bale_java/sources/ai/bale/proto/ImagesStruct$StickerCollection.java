package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.K33;
import ir.nasim.KW4;
import ir.nasim.O33;
import ir.nasim.Q33;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class ImagesStruct$StickerCollection extends GeneratedMessageLite implements O33 {
    public static final int ACCESS_HASH_FIELD_NUMBER = 2;
    public static final int ANIMATED_FIELD_NUMBER = 4;
    public static final int ANIMATED_STICKERS_FIELD_NUMBER = 5;
    private static final ImagesStruct$StickerCollection DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int STICKERS_FIELD_NUMBER = 3;
    private long accessHash_;
    private BoolValue animated_;
    private int bitField0_;
    private int id_;
    private StringValue name_;
    private B.j stickers_ = GeneratedMessageLite.emptyProtobufList();
    private B.j animatedStickers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements O33 {
        private a() {
            super(ImagesStruct$StickerCollection.DEFAULT_INSTANCE);
        }
    }

    static {
        ImagesStruct$StickerCollection imagesStruct$StickerCollection = new ImagesStruct$StickerCollection();
        DEFAULT_INSTANCE = imagesStruct$StickerCollection;
        GeneratedMessageLite.registerDefaultInstance(ImagesStruct$StickerCollection.class, imagesStruct$StickerCollection);
    }

    private ImagesStruct$StickerCollection() {
    }

    private void addAllAnimatedStickers(Iterable<? extends ImagesStruct$AnimatedStickerDescriptor> iterable) {
        ensureAnimatedStickersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.animatedStickers_);
    }

    private void addAllStickers(Iterable<? extends ImagesStruct$StickerDescriptor> iterable) {
        ensureStickersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.stickers_);
    }

    private void addAnimatedStickers(ImagesStruct$AnimatedStickerDescriptor imagesStruct$AnimatedStickerDescriptor) {
        imagesStruct$AnimatedStickerDescriptor.getClass();
        ensureAnimatedStickersIsMutable();
        this.animatedStickers_.add(imagesStruct$AnimatedStickerDescriptor);
    }

    private void addStickers(ImagesStruct$StickerDescriptor imagesStruct$StickerDescriptor) {
        imagesStruct$StickerDescriptor.getClass();
        ensureStickersIsMutable();
        this.stickers_.add(imagesStruct$StickerDescriptor);
    }

    private void clearAccessHash() {
        this.accessHash_ = 0L;
    }

    private void clearAnimated() {
        this.animated_ = null;
        this.bitField0_ &= -2;
    }

    private void clearAnimatedStickers() {
        this.animatedStickers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearName() {
        this.name_ = null;
        this.bitField0_ &= -3;
    }

    private void clearStickers() {
        this.stickers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureAnimatedStickersIsMutable() {
        B.j jVar = this.animatedStickers_;
        if (jVar.u()) {
            return;
        }
        this.animatedStickers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureStickersIsMutable() {
        B.j jVar = this.stickers_;
        if (jVar.u()) {
            return;
        }
        this.stickers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ImagesStruct$StickerCollection getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAnimated(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.animated_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.animated_ = boolValue;
        } else {
            this.animated_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.animated_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeName(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.name_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.name_ = stringValue;
        } else {
            this.name_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.name_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ImagesStruct$StickerCollection parseDelimitedFrom(InputStream inputStream) {
        return (ImagesStruct$StickerCollection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesStruct$StickerCollection parseFrom(ByteBuffer byteBuffer) {
        return (ImagesStruct$StickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeAnimatedStickers(int i) {
        ensureAnimatedStickersIsMutable();
        this.animatedStickers_.remove(i);
    }

    private void removeStickers(int i) {
        ensureStickersIsMutable();
        this.stickers_.remove(i);
    }

    private void setAccessHash(long j) {
        this.accessHash_ = j;
    }

    private void setAnimated(BoolValue boolValue) {
        boolValue.getClass();
        this.animated_ = boolValue;
        this.bitField0_ |= 1;
    }

    private void setAnimatedStickers(int i, ImagesStruct$AnimatedStickerDescriptor imagesStruct$AnimatedStickerDescriptor) {
        imagesStruct$AnimatedStickerDescriptor.getClass();
        ensureAnimatedStickersIsMutable();
        this.animatedStickers_.set(i, imagesStruct$AnimatedStickerDescriptor);
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setName(StringValue stringValue) {
        stringValue.getClass();
        this.name_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setStickers(int i, ImagesStruct$StickerDescriptor imagesStruct$StickerDescriptor) {
        imagesStruct$StickerDescriptor.getClass();
        ensureStickersIsMutable();
        this.stickers_.set(i, imagesStruct$StickerDescriptor);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1886q0.a[gVar.ordinal()]) {
            case 1:
                return new ImagesStruct$StickerCollection();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001\u0004\u0002\u0002\u0003\u001b\u0004ဉ\u0000\u0005\u001b\u0006ဉ\u0001", new Object[]{"bitField0_", "id_", "accessHash_", "stickers_", ImagesStruct$StickerDescriptor.class, "animated_", "animatedStickers_", ImagesStruct$AnimatedStickerDescriptor.class, "name_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ImagesStruct$StickerCollection.class) {
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

    public BoolValue getAnimated() {
        BoolValue boolValue = this.animated_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public ImagesStruct$AnimatedStickerDescriptor getAnimatedStickers(int i) {
        return (ImagesStruct$AnimatedStickerDescriptor) this.animatedStickers_.get(i);
    }

    public int getAnimatedStickersCount() {
        return this.animatedStickers_.size();
    }

    public List<ImagesStruct$AnimatedStickerDescriptor> getAnimatedStickersList() {
        return this.animatedStickers_;
    }

    public K33 getAnimatedStickersOrBuilder(int i) {
        return (K33) this.animatedStickers_.get(i);
    }

    public List<? extends K33> getAnimatedStickersOrBuilderList() {
        return this.animatedStickers_;
    }

    public int getId() {
        return this.id_;
    }

    public StringValue getName() {
        StringValue stringValue = this.name_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public ImagesStruct$StickerDescriptor getStickers(int i) {
        return (ImagesStruct$StickerDescriptor) this.stickers_.get(i);
    }

    public int getStickersCount() {
        return this.stickers_.size();
    }

    public List<ImagesStruct$StickerDescriptor> getStickersList() {
        return this.stickers_;
    }

    public Q33 getStickersOrBuilder(int i) {
        return (Q33) this.stickers_.get(i);
    }

    public List<? extends Q33> getStickersOrBuilderList() {
        return this.stickers_;
    }

    public boolean hasAnimated() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasName() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(ImagesStruct$StickerCollection imagesStruct$StickerCollection) {
        return (a) DEFAULT_INSTANCE.createBuilder(imagesStruct$StickerCollection);
    }

    public static ImagesStruct$StickerCollection parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesStruct$StickerCollection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesStruct$StickerCollection parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ImagesStruct$StickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ImagesStruct$StickerCollection parseFrom(AbstractC2383g abstractC2383g) {
        return (ImagesStruct$StickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addAnimatedStickers(int i, ImagesStruct$AnimatedStickerDescriptor imagesStruct$AnimatedStickerDescriptor) {
        imagesStruct$AnimatedStickerDescriptor.getClass();
        ensureAnimatedStickersIsMutable();
        this.animatedStickers_.add(i, imagesStruct$AnimatedStickerDescriptor);
    }

    private void addStickers(int i, ImagesStruct$StickerDescriptor imagesStruct$StickerDescriptor) {
        imagesStruct$StickerDescriptor.getClass();
        ensureStickersIsMutable();
        this.stickers_.add(i, imagesStruct$StickerDescriptor);
    }

    public static ImagesStruct$StickerCollection parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ImagesStruct$StickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ImagesStruct$StickerCollection parseFrom(byte[] bArr) {
        return (ImagesStruct$StickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ImagesStruct$StickerCollection parseFrom(byte[] bArr, C2394s c2394s) {
        return (ImagesStruct$StickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ImagesStruct$StickerCollection parseFrom(InputStream inputStream) {
        return (ImagesStruct$StickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesStruct$StickerCollection parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesStruct$StickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesStruct$StickerCollection parseFrom(AbstractC2384h abstractC2384h) {
        return (ImagesStruct$StickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ImagesStruct$StickerCollection parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ImagesStruct$StickerCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

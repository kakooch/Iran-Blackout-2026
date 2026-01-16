package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$StringValue;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.M33;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class ImagesOuterClass$ResponseGetSavedGifs extends GeneratedMessageLite implements U64 {
    private static final ImagesOuterClass$ResponseGetSavedGifs DEFAULT_INSTANCE;
    public static final int GIFS_FIELD_NUMBER = 1;
    public static final int OFFSET_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private B.j gifs_ = GeneratedMessageLite.emptyProtobufList();
    private CollectionsStruct$StringValue offset_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ImagesOuterClass$ResponseGetSavedGifs.DEFAULT_INSTANCE);
        }
    }

    static {
        ImagesOuterClass$ResponseGetSavedGifs imagesOuterClass$ResponseGetSavedGifs = new ImagesOuterClass$ResponseGetSavedGifs();
        DEFAULT_INSTANCE = imagesOuterClass$ResponseGetSavedGifs;
        GeneratedMessageLite.registerDefaultInstance(ImagesOuterClass$ResponseGetSavedGifs.class, imagesOuterClass$ResponseGetSavedGifs);
    }

    private ImagesOuterClass$ResponseGetSavedGifs() {
    }

    private void addAllGifs(Iterable<? extends ImagesStruct$GifDescriptor> iterable) {
        ensureGifsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.gifs_);
    }

    private void addGifs(ImagesStruct$GifDescriptor imagesStruct$GifDescriptor) {
        imagesStruct$GifDescriptor.getClass();
        ensureGifsIsMutable();
        this.gifs_.add(imagesStruct$GifDescriptor);
    }

    private void clearGifs() {
        this.gifs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearOffset() {
        this.offset_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureGifsIsMutable() {
        B.j jVar = this.gifs_;
        if (jVar.u()) {
            return;
        }
        this.gifs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ImagesOuterClass$ResponseGetSavedGifs getDefaultInstance() {
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

    public static ImagesOuterClass$ResponseGetSavedGifs parseDelimitedFrom(InputStream inputStream) {
        return (ImagesOuterClass$ResponseGetSavedGifs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$ResponseGetSavedGifs parseFrom(ByteBuffer byteBuffer) {
        return (ImagesOuterClass$ResponseGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeGifs(int i) {
        ensureGifsIsMutable();
        this.gifs_.remove(i);
    }

    private void setGifs(int i, ImagesStruct$GifDescriptor imagesStruct$GifDescriptor) {
        imagesStruct$GifDescriptor.getClass();
        ensureGifsIsMutable();
        this.gifs_.set(i, imagesStruct$GifDescriptor);
    }

    private void setOffset(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.offset_ = collectionsStruct$StringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1883p0.a[gVar.ordinal()]) {
            case 1:
                return new ImagesOuterClass$ResponseGetSavedGifs();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"bitField0_", "gifs_", ImagesStruct$GifDescriptor.class, "offset_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ImagesOuterClass$ResponseGetSavedGifs.class) {
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

    public ImagesStruct$GifDescriptor getGifs(int i) {
        return (ImagesStruct$GifDescriptor) this.gifs_.get(i);
    }

    public int getGifsCount() {
        return this.gifs_.size();
    }

    public List<ImagesStruct$GifDescriptor> getGifsList() {
        return this.gifs_;
    }

    public M33 getGifsOrBuilder(int i) {
        return (M33) this.gifs_.get(i);
    }

    public List<? extends M33> getGifsOrBuilderList() {
        return this.gifs_;
    }

    public CollectionsStruct$StringValue getOffset() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.offset_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public boolean hasOffset() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ImagesOuterClass$ResponseGetSavedGifs imagesOuterClass$ResponseGetSavedGifs) {
        return (a) DEFAULT_INSTANCE.createBuilder(imagesOuterClass$ResponseGetSavedGifs);
    }

    public static ImagesOuterClass$ResponseGetSavedGifs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$ResponseGetSavedGifs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$ResponseGetSavedGifs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ImagesOuterClass$ResponseGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ImagesOuterClass$ResponseGetSavedGifs parseFrom(AbstractC2383g abstractC2383g) {
        return (ImagesOuterClass$ResponseGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addGifs(int i, ImagesStruct$GifDescriptor imagesStruct$GifDescriptor) {
        imagesStruct$GifDescriptor.getClass();
        ensureGifsIsMutable();
        this.gifs_.add(i, imagesStruct$GifDescriptor);
    }

    public static ImagesOuterClass$ResponseGetSavedGifs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ImagesOuterClass$ResponseGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ImagesOuterClass$ResponseGetSavedGifs parseFrom(byte[] bArr) {
        return (ImagesOuterClass$ResponseGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ImagesOuterClass$ResponseGetSavedGifs parseFrom(byte[] bArr, C2394s c2394s) {
        return (ImagesOuterClass$ResponseGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ImagesOuterClass$ResponseGetSavedGifs parseFrom(InputStream inputStream) {
        return (ImagesOuterClass$ResponseGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$ResponseGetSavedGifs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$ResponseGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$ResponseGetSavedGifs parseFrom(AbstractC2384h abstractC2384h) {
        return (ImagesOuterClass$ResponseGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ImagesOuterClass$ResponseGetSavedGifs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ImagesOuterClass$ResponseGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

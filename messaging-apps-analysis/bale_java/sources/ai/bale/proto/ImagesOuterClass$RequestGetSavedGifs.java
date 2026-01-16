package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$StringValue;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ImagesOuterClass$RequestGetSavedGifs extends GeneratedMessageLite implements U64 {
    private static final ImagesOuterClass$RequestGetSavedGifs DEFAULT_INSTANCE;
    public static final int OFFSET_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private CollectionsStruct$StringValue offset_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(CollectionsStruct$StringValue collectionsStruct$StringValue) {
            q();
            ((ImagesOuterClass$RequestGetSavedGifs) this.b).setOffset(collectionsStruct$StringValue);
            return this;
        }

        private a() {
            super(ImagesOuterClass$RequestGetSavedGifs.DEFAULT_INSTANCE);
        }
    }

    static {
        ImagesOuterClass$RequestGetSavedGifs imagesOuterClass$RequestGetSavedGifs = new ImagesOuterClass$RequestGetSavedGifs();
        DEFAULT_INSTANCE = imagesOuterClass$RequestGetSavedGifs;
        GeneratedMessageLite.registerDefaultInstance(ImagesOuterClass$RequestGetSavedGifs.class, imagesOuterClass$RequestGetSavedGifs);
    }

    private ImagesOuterClass$RequestGetSavedGifs() {
    }

    private void clearOffset() {
        this.offset_ = null;
        this.bitField0_ &= -2;
    }

    public static ImagesOuterClass$RequestGetSavedGifs getDefaultInstance() {
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

    public static ImagesOuterClass$RequestGetSavedGifs parseDelimitedFrom(InputStream inputStream) {
        return (ImagesOuterClass$RequestGetSavedGifs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$RequestGetSavedGifs parseFrom(ByteBuffer byteBuffer) {
        return (ImagesOuterClass$RequestGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOffset(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.offset_ = collectionsStruct$StringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1883p0.a[gVar.ordinal()]) {
            case 1:
                return new ImagesOuterClass$RequestGetSavedGifs();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "offset_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ImagesOuterClass$RequestGetSavedGifs.class) {
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

    public boolean hasOffset() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ImagesOuterClass$RequestGetSavedGifs imagesOuterClass$RequestGetSavedGifs) {
        return (a) DEFAULT_INSTANCE.createBuilder(imagesOuterClass$RequestGetSavedGifs);
    }

    public static ImagesOuterClass$RequestGetSavedGifs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$RequestGetSavedGifs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$RequestGetSavedGifs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ImagesOuterClass$RequestGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ImagesOuterClass$RequestGetSavedGifs parseFrom(AbstractC2383g abstractC2383g) {
        return (ImagesOuterClass$RequestGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ImagesOuterClass$RequestGetSavedGifs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ImagesOuterClass$RequestGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ImagesOuterClass$RequestGetSavedGifs parseFrom(byte[] bArr) {
        return (ImagesOuterClass$RequestGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ImagesOuterClass$RequestGetSavedGifs parseFrom(byte[] bArr, C2394s c2394s) {
        return (ImagesOuterClass$RequestGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ImagesOuterClass$RequestGetSavedGifs parseFrom(InputStream inputStream) {
        return (ImagesOuterClass$RequestGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ImagesOuterClass$RequestGetSavedGifs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ImagesOuterClass$RequestGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ImagesOuterClass$RequestGetSavedGifs parseFrom(AbstractC2384h abstractC2384h) {
        return (ImagesOuterClass$RequestGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ImagesOuterClass$RequestGetSavedGifs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ImagesOuterClass$RequestGetSavedGifs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

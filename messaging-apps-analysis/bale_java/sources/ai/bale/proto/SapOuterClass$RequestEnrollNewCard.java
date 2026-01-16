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

/* loaded from: classes.dex */
public final class SapOuterClass$RequestEnrollNewCard extends GeneratedMessageLite implements U64 {
    private static final SapOuterClass$RequestEnrollNewCard DEFAULT_INSTANCE;
    public static final int ORIGIN_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private CollectionsStruct$StringValue origin_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SapOuterClass$RequestEnrollNewCard.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$RequestEnrollNewCard sapOuterClass$RequestEnrollNewCard = new SapOuterClass$RequestEnrollNewCard();
        DEFAULT_INSTANCE = sapOuterClass$RequestEnrollNewCard;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$RequestEnrollNewCard.class, sapOuterClass$RequestEnrollNewCard);
    }

    private SapOuterClass$RequestEnrollNewCard() {
    }

    private void clearOrigin() {
        this.origin_ = null;
        this.bitField0_ &= -2;
    }

    public static SapOuterClass$RequestEnrollNewCard getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeOrigin(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.origin_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.origin_ = collectionsStruct$StringValue;
        } else {
            this.origin_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.origin_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$RequestEnrollNewCard parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$RequestEnrollNewCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestEnrollNewCard parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$RequestEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOrigin(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.origin_ = collectionsStruct$StringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$RequestEnrollNewCard();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "origin_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$RequestEnrollNewCard.class) {
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

    public CollectionsStruct$StringValue getOrigin() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.origin_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public boolean hasOrigin() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SapOuterClass$RequestEnrollNewCard sapOuterClass$RequestEnrollNewCard) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$RequestEnrollNewCard);
    }

    public static SapOuterClass$RequestEnrollNewCard parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestEnrollNewCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestEnrollNewCard parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$RequestEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$RequestEnrollNewCard parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$RequestEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapOuterClass$RequestEnrollNewCard parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$RequestEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$RequestEnrollNewCard parseFrom(byte[] bArr) {
        return (SapOuterClass$RequestEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$RequestEnrollNewCard parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$RequestEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$RequestEnrollNewCard parseFrom(InputStream inputStream) {
        return (SapOuterClass$RequestEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestEnrollNewCard parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestEnrollNewCard parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$RequestEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$RequestEnrollNewCard parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$RequestEnrollNewCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

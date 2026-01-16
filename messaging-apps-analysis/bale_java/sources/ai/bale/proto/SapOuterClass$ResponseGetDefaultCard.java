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
public final class SapOuterClass$ResponseGetDefaultCard extends GeneratedMessageLite implements U64 {
    public static final int CARD_ID_FIELD_NUMBER = 1;
    private static final SapOuterClass$ResponseGetDefaultCard DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private CollectionsStruct$StringValue cardId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SapOuterClass$ResponseGetDefaultCard.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$ResponseGetDefaultCard sapOuterClass$ResponseGetDefaultCard = new SapOuterClass$ResponseGetDefaultCard();
        DEFAULT_INSTANCE = sapOuterClass$ResponseGetDefaultCard;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$ResponseGetDefaultCard.class, sapOuterClass$ResponseGetDefaultCard);
    }

    private SapOuterClass$ResponseGetDefaultCard() {
    }

    private void clearCardId() {
        this.cardId_ = null;
        this.bitField0_ &= -2;
    }

    public static SapOuterClass$ResponseGetDefaultCard getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCardId(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.cardId_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.cardId_ = collectionsStruct$StringValue;
        } else {
            this.cardId_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.cardId_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$ResponseGetDefaultCard parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$ResponseGetDefaultCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$ResponseGetDefaultCard parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$ResponseGetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCardId(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.cardId_ = collectionsStruct$StringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$ResponseGetDefaultCard();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "cardId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$ResponseGetDefaultCard.class) {
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

    public CollectionsStruct$StringValue getCardId() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.cardId_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public boolean hasCardId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SapOuterClass$ResponseGetDefaultCard sapOuterClass$ResponseGetDefaultCard) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$ResponseGetDefaultCard);
    }

    public static SapOuterClass$ResponseGetDefaultCard parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$ResponseGetDefaultCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$ResponseGetDefaultCard parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$ResponseGetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$ResponseGetDefaultCard parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$ResponseGetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapOuterClass$ResponseGetDefaultCard parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$ResponseGetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$ResponseGetDefaultCard parseFrom(byte[] bArr) {
        return (SapOuterClass$ResponseGetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$ResponseGetDefaultCard parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$ResponseGetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$ResponseGetDefaultCard parseFrom(InputStream inputStream) {
        return (SapOuterClass$ResponseGetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$ResponseGetDefaultCard parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$ResponseGetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$ResponseGetDefaultCard parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$ResponseGetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$ResponseGetDefaultCard parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$ResponseGetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

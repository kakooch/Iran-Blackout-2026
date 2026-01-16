package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SapOuterClass$RequestSetDefaultCard extends GeneratedMessageLite implements U64 {
    public static final int CARD_ID_FIELD_NUMBER = 1;
    private static final SapOuterClass$RequestSetDefaultCard DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String cardId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SapOuterClass$RequestSetDefaultCard.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$RequestSetDefaultCard sapOuterClass$RequestSetDefaultCard = new SapOuterClass$RequestSetDefaultCard();
        DEFAULT_INSTANCE = sapOuterClass$RequestSetDefaultCard;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$RequestSetDefaultCard.class, sapOuterClass$RequestSetDefaultCard);
    }

    private SapOuterClass$RequestSetDefaultCard() {
    }

    private void clearCardId() {
        this.cardId_ = getDefaultInstance().getCardId();
    }

    public static SapOuterClass$RequestSetDefaultCard getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$RequestSetDefaultCard parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$RequestSetDefaultCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestSetDefaultCard parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$RequestSetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCardId(String str) {
        str.getClass();
        this.cardId_ = str;
    }

    private void setCardIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cardId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$RequestSetDefaultCard();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"cardId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$RequestSetDefaultCard.class) {
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

    public String getCardId() {
        return this.cardId_;
    }

    public AbstractC2383g getCardIdBytes() {
        return AbstractC2383g.N(this.cardId_);
    }

    public static a newBuilder(SapOuterClass$RequestSetDefaultCard sapOuterClass$RequestSetDefaultCard) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$RequestSetDefaultCard);
    }

    public static SapOuterClass$RequestSetDefaultCard parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestSetDefaultCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestSetDefaultCard parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$RequestSetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$RequestSetDefaultCard parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$RequestSetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapOuterClass$RequestSetDefaultCard parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$RequestSetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$RequestSetDefaultCard parseFrom(byte[] bArr) {
        return (SapOuterClass$RequestSetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$RequestSetDefaultCard parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$RequestSetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$RequestSetDefaultCard parseFrom(InputStream inputStream) {
        return (SapOuterClass$RequestSetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestSetDefaultCard parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestSetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestSetDefaultCard parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$RequestSetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$RequestSetDefaultCard parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$RequestSetDefaultCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

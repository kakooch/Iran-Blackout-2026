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
public final class SapOuterClass$RequestRemoveCard extends GeneratedMessageLite implements U64 {
    public static final int CARD_ID_FIELD_NUMBER = 1;
    private static final SapOuterClass$RequestRemoveCard DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String cardId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((SapOuterClass$RequestRemoveCard) this.b).setCardId(str);
            return this;
        }

        private a() {
            super(SapOuterClass$RequestRemoveCard.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$RequestRemoveCard sapOuterClass$RequestRemoveCard = new SapOuterClass$RequestRemoveCard();
        DEFAULT_INSTANCE = sapOuterClass$RequestRemoveCard;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$RequestRemoveCard.class, sapOuterClass$RequestRemoveCard);
    }

    private SapOuterClass$RequestRemoveCard() {
    }

    private void clearCardId() {
        this.cardId_ = getDefaultInstance().getCardId();
    }

    public static SapOuterClass$RequestRemoveCard getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$RequestRemoveCard parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$RequestRemoveCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestRemoveCard parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$RequestRemoveCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCardId(String str) {
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
                return new SapOuterClass$RequestRemoveCard();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"cardId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$RequestRemoveCard.class) {
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

    public static a newBuilder(SapOuterClass$RequestRemoveCard sapOuterClass$RequestRemoveCard) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$RequestRemoveCard);
    }

    public static SapOuterClass$RequestRemoveCard parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestRemoveCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestRemoveCard parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$RequestRemoveCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$RequestRemoveCard parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$RequestRemoveCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapOuterClass$RequestRemoveCard parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$RequestRemoveCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$RequestRemoveCard parseFrom(byte[] bArr) {
        return (SapOuterClass$RequestRemoveCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$RequestRemoveCard parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$RequestRemoveCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$RequestRemoveCard parseFrom(InputStream inputStream) {
        return (SapOuterClass$RequestRemoveCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestRemoveCard parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestRemoveCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestRemoveCard parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$RequestRemoveCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$RequestRemoveCard parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$RequestRemoveCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

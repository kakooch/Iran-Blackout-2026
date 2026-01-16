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

/* loaded from: classes9.dex */
public final class BankOuterClass$ResponseGetPayvandCard extends GeneratedMessageLite implements U64 {
    public static final int CARD_FIELD_NUMBER = 1;
    private static final BankOuterClass$ResponseGetPayvandCard DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String card_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$ResponseGetPayvandCard.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$ResponseGetPayvandCard bankOuterClass$ResponseGetPayvandCard = new BankOuterClass$ResponseGetPayvandCard();
        DEFAULT_INSTANCE = bankOuterClass$ResponseGetPayvandCard;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$ResponseGetPayvandCard.class, bankOuterClass$ResponseGetPayvandCard);
    }

    private BankOuterClass$ResponseGetPayvandCard() {
    }

    private void clearCard() {
        this.card_ = getDefaultInstance().getCard();
    }

    public static BankOuterClass$ResponseGetPayvandCard getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$ResponseGetPayvandCard parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseGetPayvandCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseGetPayvandCard parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$ResponseGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCard(String str) {
        str.getClass();
        this.card_ = str;
    }

    private void setCardBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.card_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$ResponseGetPayvandCard();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"card_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$ResponseGetPayvandCard.class) {
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

    public String getCard() {
        return this.card_;
    }

    public AbstractC2383g getCardBytes() {
        return AbstractC2383g.N(this.card_);
    }

    public static a newBuilder(BankOuterClass$ResponseGetPayvandCard bankOuterClass$ResponseGetPayvandCard) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$ResponseGetPayvandCard);
    }

    public static BankOuterClass$ResponseGetPayvandCard parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPayvandCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseGetPayvandCard parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$ResponseGetPayvandCard parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$ResponseGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$ResponseGetPayvandCard parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$ResponseGetPayvandCard parseFrom(byte[] bArr) {
        return (BankOuterClass$ResponseGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$ResponseGetPayvandCard parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$ResponseGetPayvandCard parseFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseGetPayvandCard parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseGetPayvandCard parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$ResponseGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$ResponseGetPayvandCard parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

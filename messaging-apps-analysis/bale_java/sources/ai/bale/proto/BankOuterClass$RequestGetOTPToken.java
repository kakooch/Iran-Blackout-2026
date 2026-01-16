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
public final class BankOuterClass$RequestGetOTPToken extends GeneratedMessageLite implements U64 {
    public static final int CARD_NUMBER_STARTING_SIX_FIELD_NUMBER = 1;
    private static final BankOuterClass$RequestGetOTPToken DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String cardNumberStartingSix_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((BankOuterClass$RequestGetOTPToken) this.b).setCardNumberStartingSix(str);
            return this;
        }

        private a() {
            super(BankOuterClass$RequestGetOTPToken.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$RequestGetOTPToken bankOuterClass$RequestGetOTPToken = new BankOuterClass$RequestGetOTPToken();
        DEFAULT_INSTANCE = bankOuterClass$RequestGetOTPToken;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$RequestGetOTPToken.class, bankOuterClass$RequestGetOTPToken);
    }

    private BankOuterClass$RequestGetOTPToken() {
    }

    private void clearCardNumberStartingSix() {
        this.cardNumberStartingSix_ = getDefaultInstance().getCardNumberStartingSix();
    }

    public static BankOuterClass$RequestGetOTPToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$RequestGetOTPToken parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGetOTPToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGetOTPToken parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$RequestGetOTPToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCardNumberStartingSix(String str) {
        str.getClass();
        this.cardNumberStartingSix_ = str;
    }

    private void setCardNumberStartingSixBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cardNumberStartingSix_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$RequestGetOTPToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"cardNumberStartingSix_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$RequestGetOTPToken.class) {
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

    public String getCardNumberStartingSix() {
        return this.cardNumberStartingSix_;
    }

    public AbstractC2383g getCardNumberStartingSixBytes() {
        return AbstractC2383g.N(this.cardNumberStartingSix_);
    }

    public static a newBuilder(BankOuterClass$RequestGetOTPToken bankOuterClass$RequestGetOTPToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$RequestGetOTPToken);
    }

    public static BankOuterClass$RequestGetOTPToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGetOTPToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGetOTPToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$RequestGetOTPToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$RequestGetOTPToken parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$RequestGetOTPToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$RequestGetOTPToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$RequestGetOTPToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$RequestGetOTPToken parseFrom(byte[] bArr) {
        return (BankOuterClass$RequestGetOTPToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$RequestGetOTPToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$RequestGetOTPToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$RequestGetOTPToken parseFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGetOTPToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGetOTPToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGetOTPToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGetOTPToken parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$RequestGetOTPToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$RequestGetOTPToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$RequestGetOTPToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

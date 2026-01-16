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
public final class BankOuterClass$RequestGetCardRemain extends GeneratedMessageLite implements U64 {
    public static final int CARD_NUMBER_FIELD_NUMBER = 1;
    public static final int CVV2_FIELD_NUMBER = 2;
    private static final BankOuterClass$RequestGetCardRemain DEFAULT_INSTANCE;
    public static final int EXPIRE_DATE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PIN2_FIELD_NUMBER = 4;
    private String cardNumber_ = "";
    private String cvv2_ = "";
    private String expireDate_ = "";
    private String pin2_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$RequestGetCardRemain.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$RequestGetCardRemain bankOuterClass$RequestGetCardRemain = new BankOuterClass$RequestGetCardRemain();
        DEFAULT_INSTANCE = bankOuterClass$RequestGetCardRemain;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$RequestGetCardRemain.class, bankOuterClass$RequestGetCardRemain);
    }

    private BankOuterClass$RequestGetCardRemain() {
    }

    private void clearCardNumber() {
        this.cardNumber_ = getDefaultInstance().getCardNumber();
    }

    private void clearCvv2() {
        this.cvv2_ = getDefaultInstance().getCvv2();
    }

    private void clearExpireDate() {
        this.expireDate_ = getDefaultInstance().getExpireDate();
    }

    private void clearPin2() {
        this.pin2_ = getDefaultInstance().getPin2();
    }

    public static BankOuterClass$RequestGetCardRemain getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$RequestGetCardRemain parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGetCardRemain) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGetCardRemain parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$RequestGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCardNumber(String str) {
        str.getClass();
        this.cardNumber_ = str;
    }

    private void setCardNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cardNumber_ = abstractC2383g.f0();
    }

    private void setCvv2(String str) {
        str.getClass();
        this.cvv2_ = str;
    }

    private void setCvv2Bytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cvv2_ = abstractC2383g.f0();
    }

    private void setExpireDate(String str) {
        str.getClass();
        this.expireDate_ = str;
    }

    private void setExpireDateBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.expireDate_ = abstractC2383g.f0();
    }

    private void setPin2(String str) {
        str.getClass();
        this.pin2_ = str;
    }

    private void setPin2Bytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.pin2_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$RequestGetCardRemain();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ", new Object[]{"cardNumber_", "cvv2_", "expireDate_", "pin2_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$RequestGetCardRemain.class) {
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

    public String getCardNumber() {
        return this.cardNumber_;
    }

    public AbstractC2383g getCardNumberBytes() {
        return AbstractC2383g.N(this.cardNumber_);
    }

    public String getCvv2() {
        return this.cvv2_;
    }

    public AbstractC2383g getCvv2Bytes() {
        return AbstractC2383g.N(this.cvv2_);
    }

    public String getExpireDate() {
        return this.expireDate_;
    }

    public AbstractC2383g getExpireDateBytes() {
        return AbstractC2383g.N(this.expireDate_);
    }

    public String getPin2() {
        return this.pin2_;
    }

    public AbstractC2383g getPin2Bytes() {
        return AbstractC2383g.N(this.pin2_);
    }

    public static a newBuilder(BankOuterClass$RequestGetCardRemain bankOuterClass$RequestGetCardRemain) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$RequestGetCardRemain);
    }

    public static BankOuterClass$RequestGetCardRemain parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGetCardRemain) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGetCardRemain parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$RequestGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$RequestGetCardRemain parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$RequestGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$RequestGetCardRemain parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$RequestGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$RequestGetCardRemain parseFrom(byte[] bArr) {
        return (BankOuterClass$RequestGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$RequestGetCardRemain parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$RequestGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$RequestGetCardRemain parseFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGetCardRemain parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGetCardRemain parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$RequestGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$RequestGetCardRemain parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$RequestGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

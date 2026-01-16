package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.V60;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BankStruct$PayvandCard extends GeneratedMessageLite implements V60 {
    public static final int BANK_CODE_FIELD_NUMBER = 2;
    private static final BankStruct$PayvandCard DEFAULT_INSTANCE;
    public static final int INDEX_FIELD_NUMBER = 1;
    public static final int LAST4_DIGIT_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private String index_ = "";
    private String bankCode_ = "";
    private String last4Digit_ = "";

    public static final class a extends GeneratedMessageLite.b implements V60 {
        private a() {
            super(BankStruct$PayvandCard.DEFAULT_INSTANCE);
        }
    }

    static {
        BankStruct$PayvandCard bankStruct$PayvandCard = new BankStruct$PayvandCard();
        DEFAULT_INSTANCE = bankStruct$PayvandCard;
        GeneratedMessageLite.registerDefaultInstance(BankStruct$PayvandCard.class, bankStruct$PayvandCard);
    }

    private BankStruct$PayvandCard() {
    }

    private void clearBankCode() {
        this.bankCode_ = getDefaultInstance().getBankCode();
    }

    private void clearIndex() {
        this.index_ = getDefaultInstance().getIndex();
    }

    private void clearLast4Digit() {
        this.last4Digit_ = getDefaultInstance().getLast4Digit();
    }

    public static BankStruct$PayvandCard getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankStruct$PayvandCard parseDelimitedFrom(InputStream inputStream) {
        return (BankStruct$PayvandCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankStruct$PayvandCard parseFrom(ByteBuffer byteBuffer) {
        return (BankStruct$PayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBankCode(String str) {
        str.getClass();
        this.bankCode_ = str;
    }

    private void setBankCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.bankCode_ = abstractC2383g.f0();
    }

    private void setIndex(String str) {
        str.getClass();
        this.index_ = str;
    }

    private void setIndexBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.index_ = abstractC2383g.f0();
    }

    private void setLast4Digit(String str) {
        str.getClass();
        this.last4Digit_ = str;
    }

    private void setLast4DigitBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.last4Digit_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1879o.a[gVar.ordinal()]) {
            case 1:
                return new BankStruct$PayvandCard();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"index_", "bankCode_", "last4Digit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankStruct$PayvandCard.class) {
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

    public String getBankCode() {
        return this.bankCode_;
    }

    public AbstractC2383g getBankCodeBytes() {
        return AbstractC2383g.N(this.bankCode_);
    }

    public String getIndex() {
        return this.index_;
    }

    public AbstractC2383g getIndexBytes() {
        return AbstractC2383g.N(this.index_);
    }

    public String getLast4Digit() {
        return this.last4Digit_;
    }

    public AbstractC2383g getLast4DigitBytes() {
        return AbstractC2383g.N(this.last4Digit_);
    }

    public static a newBuilder(BankStruct$PayvandCard bankStruct$PayvandCard) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankStruct$PayvandCard);
    }

    public static BankStruct$PayvandCard parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankStruct$PayvandCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankStruct$PayvandCard parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankStruct$PayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankStruct$PayvandCard parseFrom(AbstractC2383g abstractC2383g) {
        return (BankStruct$PayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankStruct$PayvandCard parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankStruct$PayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankStruct$PayvandCard parseFrom(byte[] bArr) {
        return (BankStruct$PayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankStruct$PayvandCard parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankStruct$PayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankStruct$PayvandCard parseFrom(InputStream inputStream) {
        return (BankStruct$PayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankStruct$PayvandCard parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankStruct$PayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankStruct$PayvandCard parseFrom(AbstractC2384h abstractC2384h) {
        return (BankStruct$PayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankStruct$PayvandCard parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankStruct$PayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

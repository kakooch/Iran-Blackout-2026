package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.E75;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PfmStruct$PfmUserAccount extends GeneratedMessageLite implements E75 {
    public static final int ACCOUNT_CARD_NUMBER_FIELD_NUMBER = 2;
    public static final int ACCOUNT_NUMBER_FIELD_NUMBER = 1;
    public static final int AMOUNT_FIELD_NUMBER = 3;
    private static final PfmStruct$PfmUserAccount DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private long accountNumber_;
    private String accountCardNumber_ = "";
    private String amount_ = "";

    public static final class a extends GeneratedMessageLite.b implements E75 {
        private a() {
            super(PfmStruct$PfmUserAccount.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmStruct$PfmUserAccount pfmStruct$PfmUserAccount = new PfmStruct$PfmUserAccount();
        DEFAULT_INSTANCE = pfmStruct$PfmUserAccount;
        GeneratedMessageLite.registerDefaultInstance(PfmStruct$PfmUserAccount.class, pfmStruct$PfmUserAccount);
    }

    private PfmStruct$PfmUserAccount() {
    }

    private void clearAccountCardNumber() {
        this.accountCardNumber_ = getDefaultInstance().getAccountCardNumber();
    }

    private void clearAccountNumber() {
        this.accountNumber_ = 0L;
    }

    private void clearAmount() {
        this.amount_ = getDefaultInstance().getAmount();
    }

    public static PfmStruct$PfmUserAccount getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmStruct$PfmUserAccount parseDelimitedFrom(InputStream inputStream) {
        return (PfmStruct$PfmUserAccount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmStruct$PfmUserAccount parseFrom(ByteBuffer byteBuffer) {
        return (PfmStruct$PfmUserAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccountCardNumber(String str) {
        str.getClass();
        this.accountCardNumber_ = str;
    }

    private void setAccountCardNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.accountCardNumber_ = abstractC2383g.f0();
    }

    private void setAccountNumber(long j) {
        this.accountNumber_ = j;
    }

    private void setAmount(String str) {
        str.getClass();
        this.amount_ = str;
    }

    private void setAmountBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.amount_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1851e1.a[gVar.ordinal()]) {
            case 1:
                return new PfmStruct$PfmUserAccount();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ", new Object[]{"accountNumber_", "accountCardNumber_", "amount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmStruct$PfmUserAccount.class) {
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

    public String getAccountCardNumber() {
        return this.accountCardNumber_;
    }

    public AbstractC2383g getAccountCardNumberBytes() {
        return AbstractC2383g.N(this.accountCardNumber_);
    }

    public long getAccountNumber() {
        return this.accountNumber_;
    }

    public String getAmount() {
        return this.amount_;
    }

    public AbstractC2383g getAmountBytes() {
        return AbstractC2383g.N(this.amount_);
    }

    public static a newBuilder(PfmStruct$PfmUserAccount pfmStruct$PfmUserAccount) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmStruct$PfmUserAccount);
    }

    public static PfmStruct$PfmUserAccount parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmStruct$PfmUserAccount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmStruct$PfmUserAccount parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmStruct$PfmUserAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmStruct$PfmUserAccount parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmStruct$PfmUserAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PfmStruct$PfmUserAccount parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmStruct$PfmUserAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmStruct$PfmUserAccount parseFrom(byte[] bArr) {
        return (PfmStruct$PfmUserAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmStruct$PfmUserAccount parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmStruct$PfmUserAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmStruct$PfmUserAccount parseFrom(InputStream inputStream) {
        return (PfmStruct$PfmUserAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmStruct$PfmUserAccount parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmStruct$PfmUserAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmStruct$PfmUserAccount parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmStruct$PfmUserAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmStruct$PfmUserAccount parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmStruct$PfmUserAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

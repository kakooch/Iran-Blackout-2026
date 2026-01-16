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
public final class BankOuterClass$ResponseGetCardRemain extends GeneratedMessageLite implements U64 {
    public static final int AVAILABLE_BALANCE_AMOUNT_FIELD_NUMBER = 2;
    public static final int CURRENT_BALANCE_AMOUNT_FIELD_NUMBER = 1;
    private static final BankOuterClass$ResponseGetCardRemain DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String currentBalanceAmount_ = "";
    private String availableBalanceAmount_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$ResponseGetCardRemain.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$ResponseGetCardRemain bankOuterClass$ResponseGetCardRemain = new BankOuterClass$ResponseGetCardRemain();
        DEFAULT_INSTANCE = bankOuterClass$ResponseGetCardRemain;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$ResponseGetCardRemain.class, bankOuterClass$ResponseGetCardRemain);
    }

    private BankOuterClass$ResponseGetCardRemain() {
    }

    private void clearAvailableBalanceAmount() {
        this.availableBalanceAmount_ = getDefaultInstance().getAvailableBalanceAmount();
    }

    private void clearCurrentBalanceAmount() {
        this.currentBalanceAmount_ = getDefaultInstance().getCurrentBalanceAmount();
    }

    public static BankOuterClass$ResponseGetCardRemain getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$ResponseGetCardRemain parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseGetCardRemain) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseGetCardRemain parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$ResponseGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAvailableBalanceAmount(String str) {
        str.getClass();
        this.availableBalanceAmount_ = str;
    }

    private void setAvailableBalanceAmountBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.availableBalanceAmount_ = abstractC2383g.f0();
    }

    private void setCurrentBalanceAmount(String str) {
        str.getClass();
        this.currentBalanceAmount_ = str;
    }

    private void setCurrentBalanceAmountBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.currentBalanceAmount_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$ResponseGetCardRemain();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"currentBalanceAmount_", "availableBalanceAmount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$ResponseGetCardRemain.class) {
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

    public String getAvailableBalanceAmount() {
        return this.availableBalanceAmount_;
    }

    public AbstractC2383g getAvailableBalanceAmountBytes() {
        return AbstractC2383g.N(this.availableBalanceAmount_);
    }

    public String getCurrentBalanceAmount() {
        return this.currentBalanceAmount_;
    }

    public AbstractC2383g getCurrentBalanceAmountBytes() {
        return AbstractC2383g.N(this.currentBalanceAmount_);
    }

    public static a newBuilder(BankOuterClass$ResponseGetCardRemain bankOuterClass$ResponseGetCardRemain) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$ResponseGetCardRemain);
    }

    public static BankOuterClass$ResponseGetCardRemain parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseGetCardRemain) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseGetCardRemain parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$ResponseGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$ResponseGetCardRemain parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$ResponseGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$ResponseGetCardRemain parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$ResponseGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$ResponseGetCardRemain parseFrom(byte[] bArr) {
        return (BankOuterClass$ResponseGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$ResponseGetCardRemain parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$ResponseGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$ResponseGetCardRemain parseFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseGetCardRemain parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseGetCardRemain parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$ResponseGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$ResponseGetCardRemain parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$ResponseGetCardRemain) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

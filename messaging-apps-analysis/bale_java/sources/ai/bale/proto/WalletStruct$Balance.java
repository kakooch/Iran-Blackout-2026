package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.M38;
import ir.nasim.N38;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class WalletStruct$Balance extends GeneratedMessageLite implements M38 {
    public static final int AMOUNT_FIELD_NUMBER = 2;
    public static final int CURRENCY_FIELD_NUMBER = 1;
    private static final WalletStruct$Balance DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private long amount_;
    private int currency_;

    public static final class a extends GeneratedMessageLite.b implements M38 {
        public a A(long j) {
            q();
            ((WalletStruct$Balance) this.b).setAmount(j);
            return this;
        }

        public a B(int i) {
            q();
            ((WalletStruct$Balance) this.b).setCurrencyValue(i);
            return this;
        }

        private a() {
            super(WalletStruct$Balance.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletStruct$Balance walletStruct$Balance = new WalletStruct$Balance();
        DEFAULT_INSTANCE = walletStruct$Balance;
        GeneratedMessageLite.registerDefaultInstance(WalletStruct$Balance.class, walletStruct$Balance);
    }

    private WalletStruct$Balance() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearCurrency() {
        this.currency_ = 0;
    }

    public static WalletStruct$Balance getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletStruct$Balance parseDelimitedFrom(InputStream inputStream) {
        return (WalletStruct$Balance) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletStruct$Balance parseFrom(ByteBuffer byteBuffer) {
        return (WalletStruct$Balance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAmount(long j) {
        this.amount_ = j;
    }

    private void setCurrency(N38 n38) {
        this.currency_ = n38.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrencyValue(int i) {
        this.currency_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (v2.a[gVar.ordinal()]) {
            case 1:
                return new WalletStruct$Balance();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u0002", new Object[]{"currency_", "amount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletStruct$Balance.class) {
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

    public long getAmount() {
        return this.amount_;
    }

    public N38 getCurrency() {
        N38 n38J = N38.j(this.currency_);
        return n38J == null ? N38.UNRECOGNIZED : n38J;
    }

    public int getCurrencyValue() {
        return this.currency_;
    }

    public static a newBuilder(WalletStruct$Balance walletStruct$Balance) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletStruct$Balance);
    }

    public static WalletStruct$Balance parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletStruct$Balance) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletStruct$Balance parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletStruct$Balance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletStruct$Balance parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletStruct$Balance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletStruct$Balance parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletStruct$Balance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletStruct$Balance parseFrom(byte[] bArr) {
        return (WalletStruct$Balance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletStruct$Balance parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletStruct$Balance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletStruct$Balance parseFrom(InputStream inputStream) {
        return (WalletStruct$Balance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletStruct$Balance parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletStruct$Balance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletStruct$Balance parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletStruct$Balance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletStruct$Balance parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletStruct$Balance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

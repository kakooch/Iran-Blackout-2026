package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.N38;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class WalletOuterClass$RequestPayByWallet extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 3;
    public static final int CURRENCY_FIELD_NUMBER = 4;
    private static final WalletOuterClass$RequestPayByWallet DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REGARDING_FIELD_NUMBER = 5;
    public static final int SOURCE_WALLET_FIELD_NUMBER = 1;
    public static final int TARGET_WALLET_FIELD_NUMBER = 2;
    private long amount_;
    private int bitField0_;
    private int currency_;
    private StringValue regarding_;
    private String sourceWallet_ = "";
    private String targetWallet_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((WalletOuterClass$RequestPayByWallet) this.b).setAmount(j);
            return this;
        }

        public a B(N38 n38) {
            q();
            ((WalletOuterClass$RequestPayByWallet) this.b).setCurrency(n38);
            return this;
        }

        public a C(StringValue stringValue) {
            q();
            ((WalletOuterClass$RequestPayByWallet) this.b).setRegarding(stringValue);
            return this;
        }

        public a D(String str) {
            q();
            ((WalletOuterClass$RequestPayByWallet) this.b).setSourceWallet(str);
            return this;
        }

        public a E(String str) {
            q();
            ((WalletOuterClass$RequestPayByWallet) this.b).setTargetWallet(str);
            return this;
        }

        private a() {
            super(WalletOuterClass$RequestPayByWallet.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$RequestPayByWallet walletOuterClass$RequestPayByWallet = new WalletOuterClass$RequestPayByWallet();
        DEFAULT_INSTANCE = walletOuterClass$RequestPayByWallet;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$RequestPayByWallet.class, walletOuterClass$RequestPayByWallet);
    }

    private WalletOuterClass$RequestPayByWallet() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearCurrency() {
        this.currency_ = 0;
    }

    private void clearRegarding() {
        this.regarding_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSourceWallet() {
        this.sourceWallet_ = getDefaultInstance().getSourceWallet();
    }

    private void clearTargetWallet() {
        this.targetWallet_ = getDefaultInstance().getTargetWallet();
    }

    public static WalletOuterClass$RequestPayByWallet getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeRegarding(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.regarding_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.regarding_ = stringValue;
        } else {
            this.regarding_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.regarding_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletOuterClass$RequestPayByWallet parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestPayByWallet) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestPayByWallet parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$RequestPayByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAmount(long j) {
        this.amount_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrency(N38 n38) {
        this.currency_ = n38.getNumber();
    }

    private void setCurrencyValue(int i) {
        this.currency_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegarding(StringValue stringValue) {
        stringValue.getClass();
        this.regarding_ = stringValue;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSourceWallet(String str) {
        str.getClass();
        this.sourceWallet_ = str;
    }

    private void setSourceWalletBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sourceWallet_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetWallet(String str) {
        str.getClass();
        this.targetWallet_ = str;
    }

    private void setTargetWalletBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.targetWallet_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (u2.a[gVar.ordinal()]) {
            case 1:
                return new WalletOuterClass$RequestPayByWallet();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004\f\u0005ဉ\u0000", new Object[]{"bitField0_", "sourceWallet_", "targetWallet_", "amount_", "currency_", "regarding_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$RequestPayByWallet.class) {
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

    public StringValue getRegarding() {
        StringValue stringValue = this.regarding_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getSourceWallet() {
        return this.sourceWallet_;
    }

    public AbstractC2383g getSourceWalletBytes() {
        return AbstractC2383g.N(this.sourceWallet_);
    }

    public String getTargetWallet() {
        return this.targetWallet_;
    }

    public AbstractC2383g getTargetWalletBytes() {
        return AbstractC2383g.N(this.targetWallet_);
    }

    public boolean hasRegarding() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(WalletOuterClass$RequestPayByWallet walletOuterClass$RequestPayByWallet) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$RequestPayByWallet);
    }

    public static WalletOuterClass$RequestPayByWallet parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestPayByWallet) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestPayByWallet parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$RequestPayByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$RequestPayByWallet parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$RequestPayByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletOuterClass$RequestPayByWallet parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$RequestPayByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$RequestPayByWallet parseFrom(byte[] bArr) {
        return (WalletOuterClass$RequestPayByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$RequestPayByWallet parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$RequestPayByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$RequestPayByWallet parseFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestPayByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestPayByWallet parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestPayByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestPayByWallet parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$RequestPayByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$RequestPayByWallet parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$RequestPayByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

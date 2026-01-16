package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class WalletOuterClass$RequestGetPaymentTokenByCard extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 2;
    private static final WalletOuterClass$RequestGetPaymentTokenByCard DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REGARDING_FIELD_NUMBER = 3;
    public static final int TARGET_WALLET_FIELD_NUMBER = 1;
    private long amount_;
    private int bitField0_;
    private StringValue regarding_;
    private String targetWallet_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((WalletOuterClass$RequestGetPaymentTokenByCard) this.b).setAmount(j);
            return this;
        }

        public a B(StringValue stringValue) {
            q();
            ((WalletOuterClass$RequestGetPaymentTokenByCard) this.b).setRegarding(stringValue);
            return this;
        }

        public a C(String str) {
            q();
            ((WalletOuterClass$RequestGetPaymentTokenByCard) this.b).setTargetWallet(str);
            return this;
        }

        private a() {
            super(WalletOuterClass$RequestGetPaymentTokenByCard.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$RequestGetPaymentTokenByCard walletOuterClass$RequestGetPaymentTokenByCard = new WalletOuterClass$RequestGetPaymentTokenByCard();
        DEFAULT_INSTANCE = walletOuterClass$RequestGetPaymentTokenByCard;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$RequestGetPaymentTokenByCard.class, walletOuterClass$RequestGetPaymentTokenByCard);
    }

    private WalletOuterClass$RequestGetPaymentTokenByCard() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearRegarding() {
        this.regarding_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTargetWallet() {
        this.targetWallet_ = getDefaultInstance().getTargetWallet();
    }

    public static WalletOuterClass$RequestGetPaymentTokenByCard getDefaultInstance() {
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

    public static WalletOuterClass$RequestGetPaymentTokenByCard parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestGetPaymentTokenByCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestGetPaymentTokenByCard parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$RequestGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAmount(long j) {
        this.amount_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegarding(StringValue stringValue) {
        stringValue.getClass();
        this.regarding_ = stringValue;
        this.bitField0_ |= 1;
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
                return new WalletOuterClass$RequestGetPaymentTokenByCard();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003ဉ\u0000", new Object[]{"bitField0_", "targetWallet_", "amount_", "regarding_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$RequestGetPaymentTokenByCard.class) {
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

    public StringValue getRegarding() {
        StringValue stringValue = this.regarding_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
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

    public static a newBuilder(WalletOuterClass$RequestGetPaymentTokenByCard walletOuterClass$RequestGetPaymentTokenByCard) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$RequestGetPaymentTokenByCard);
    }

    public static WalletOuterClass$RequestGetPaymentTokenByCard parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestGetPaymentTokenByCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestGetPaymentTokenByCard parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$RequestGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$RequestGetPaymentTokenByCard parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$RequestGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletOuterClass$RequestGetPaymentTokenByCard parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$RequestGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$RequestGetPaymentTokenByCard parseFrom(byte[] bArr) {
        return (WalletOuterClass$RequestGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$RequestGetPaymentTokenByCard parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$RequestGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$RequestGetPaymentTokenByCard parseFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestGetPaymentTokenByCard parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestGetPaymentTokenByCard parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$RequestGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$RequestGetPaymentTokenByCard parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$RequestGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

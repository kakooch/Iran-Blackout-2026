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
public final class WalletOuterClass$RequestGetWalletChargeToken extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 2;
    private static final WalletOuterClass$RequestGetWalletChargeToken DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int WALLET_ID_FIELD_NUMBER = 1;
    private long amount_;
    private String walletId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((WalletOuterClass$RequestGetWalletChargeToken) this.b).setAmount(j);
            return this;
        }

        public a B(String str) {
            q();
            ((WalletOuterClass$RequestGetWalletChargeToken) this.b).setWalletId(str);
            return this;
        }

        private a() {
            super(WalletOuterClass$RequestGetWalletChargeToken.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$RequestGetWalletChargeToken walletOuterClass$RequestGetWalletChargeToken = new WalletOuterClass$RequestGetWalletChargeToken();
        DEFAULT_INSTANCE = walletOuterClass$RequestGetWalletChargeToken;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$RequestGetWalletChargeToken.class, walletOuterClass$RequestGetWalletChargeToken);
    }

    private WalletOuterClass$RequestGetWalletChargeToken() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearWalletId() {
        this.walletId_ = getDefaultInstance().getWalletId();
    }

    public static WalletOuterClass$RequestGetWalletChargeToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletOuterClass$RequestGetWalletChargeToken parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestGetWalletChargeToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestGetWalletChargeToken parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$RequestGetWalletChargeToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAmount(long j) {
        this.amount_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWalletId(String str) {
        str.getClass();
        this.walletId_ = str;
    }

    private void setWalletIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.walletId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (u2.a[gVar.ordinal()]) {
            case 1:
                return new WalletOuterClass$RequestGetWalletChargeToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0002", new Object[]{"walletId_", "amount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$RequestGetWalletChargeToken.class) {
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

    public String getWalletId() {
        return this.walletId_;
    }

    public AbstractC2383g getWalletIdBytes() {
        return AbstractC2383g.N(this.walletId_);
    }

    public static a newBuilder(WalletOuterClass$RequestGetWalletChargeToken walletOuterClass$RequestGetWalletChargeToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$RequestGetWalletChargeToken);
    }

    public static WalletOuterClass$RequestGetWalletChargeToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestGetWalletChargeToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestGetWalletChargeToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$RequestGetWalletChargeToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$RequestGetWalletChargeToken parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$RequestGetWalletChargeToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletOuterClass$RequestGetWalletChargeToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$RequestGetWalletChargeToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$RequestGetWalletChargeToken parseFrom(byte[] bArr) {
        return (WalletOuterClass$RequestGetWalletChargeToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$RequestGetWalletChargeToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$RequestGetWalletChargeToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$RequestGetWalletChargeToken parseFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestGetWalletChargeToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestGetWalletChargeToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestGetWalletChargeToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestGetWalletChargeToken parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$RequestGetWalletChargeToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$RequestGetWalletChargeToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$RequestGetWalletChargeToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

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
public final class WalletOuterClass$RequestCashOutFromWallet extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 2;
    private static final WalletOuterClass$RequestCashOutFromWallet DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private long amount_;
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WalletOuterClass$RequestCashOutFromWallet.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$RequestCashOutFromWallet walletOuterClass$RequestCashOutFromWallet = new WalletOuterClass$RequestCashOutFromWallet();
        DEFAULT_INSTANCE = walletOuterClass$RequestCashOutFromWallet;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$RequestCashOutFromWallet.class, walletOuterClass$RequestCashOutFromWallet);
    }

    private WalletOuterClass$RequestCashOutFromWallet() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static WalletOuterClass$RequestCashOutFromWallet getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletOuterClass$RequestCashOutFromWallet parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestCashOutFromWallet) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestCashOutFromWallet parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$RequestCashOutFromWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    private void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (u2.a[gVar.ordinal()]) {
            case 1:
                return new WalletOuterClass$RequestCashOutFromWallet();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0002", new Object[]{"token_", "amount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$RequestCashOutFromWallet.class) {
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

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public static a newBuilder(WalletOuterClass$RequestCashOutFromWallet walletOuterClass$RequestCashOutFromWallet) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$RequestCashOutFromWallet);
    }

    public static WalletOuterClass$RequestCashOutFromWallet parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestCashOutFromWallet) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestCashOutFromWallet parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$RequestCashOutFromWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$RequestCashOutFromWallet parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$RequestCashOutFromWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletOuterClass$RequestCashOutFromWallet parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$RequestCashOutFromWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$RequestCashOutFromWallet parseFrom(byte[] bArr) {
        return (WalletOuterClass$RequestCashOutFromWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$RequestCashOutFromWallet parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$RequestCashOutFromWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$RequestCashOutFromWallet parseFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestCashOutFromWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestCashOutFromWallet parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestCashOutFromWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestCashOutFromWallet parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$RequestCashOutFromWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$RequestCashOutFromWallet parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$RequestCashOutFromWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

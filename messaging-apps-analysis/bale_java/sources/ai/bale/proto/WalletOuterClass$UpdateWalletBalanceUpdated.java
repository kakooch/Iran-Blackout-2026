package ai.bale.proto;

import ai.bale.proto.WalletStruct$Balance;
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
public final class WalletOuterClass$UpdateWalletBalanceUpdated extends GeneratedMessageLite implements U64 {
    private static final WalletOuterClass$UpdateWalletBalanceUpdated DEFAULT_INSTANCE;
    public static final int NEW_BALANCE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int WALLET_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private WalletStruct$Balance newBalance_;
    private String walletId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WalletOuterClass$UpdateWalletBalanceUpdated.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$UpdateWalletBalanceUpdated walletOuterClass$UpdateWalletBalanceUpdated = new WalletOuterClass$UpdateWalletBalanceUpdated();
        DEFAULT_INSTANCE = walletOuterClass$UpdateWalletBalanceUpdated;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$UpdateWalletBalanceUpdated.class, walletOuterClass$UpdateWalletBalanceUpdated);
    }

    private WalletOuterClass$UpdateWalletBalanceUpdated() {
    }

    private void clearNewBalance() {
        this.newBalance_ = null;
        this.bitField0_ &= -2;
    }

    private void clearWalletId() {
        this.walletId_ = getDefaultInstance().getWalletId();
    }

    public static WalletOuterClass$UpdateWalletBalanceUpdated getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeNewBalance(WalletStruct$Balance walletStruct$Balance) {
        walletStruct$Balance.getClass();
        WalletStruct$Balance walletStruct$Balance2 = this.newBalance_;
        if (walletStruct$Balance2 == null || walletStruct$Balance2 == WalletStruct$Balance.getDefaultInstance()) {
            this.newBalance_ = walletStruct$Balance;
        } else {
            this.newBalance_ = (WalletStruct$Balance) ((WalletStruct$Balance.a) WalletStruct$Balance.newBuilder(this.newBalance_).v(walletStruct$Balance)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletOuterClass$UpdateWalletBalanceUpdated parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$UpdateWalletBalanceUpdated) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$UpdateWalletBalanceUpdated parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$UpdateWalletBalanceUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setNewBalance(WalletStruct$Balance walletStruct$Balance) {
        walletStruct$Balance.getClass();
        this.newBalance_ = walletStruct$Balance;
        this.bitField0_ |= 1;
    }

    private void setWalletId(String str) {
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
                return new WalletOuterClass$UpdateWalletBalanceUpdated();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "walletId_", "newBalance_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$UpdateWalletBalanceUpdated.class) {
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

    public WalletStruct$Balance getNewBalance() {
        WalletStruct$Balance walletStruct$Balance = this.newBalance_;
        return walletStruct$Balance == null ? WalletStruct$Balance.getDefaultInstance() : walletStruct$Balance;
    }

    public String getWalletId() {
        return this.walletId_;
    }

    public AbstractC2383g getWalletIdBytes() {
        return AbstractC2383g.N(this.walletId_);
    }

    public boolean hasNewBalance() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(WalletOuterClass$UpdateWalletBalanceUpdated walletOuterClass$UpdateWalletBalanceUpdated) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$UpdateWalletBalanceUpdated);
    }

    public static WalletOuterClass$UpdateWalletBalanceUpdated parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$UpdateWalletBalanceUpdated) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$UpdateWalletBalanceUpdated parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$UpdateWalletBalanceUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$UpdateWalletBalanceUpdated parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$UpdateWalletBalanceUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletOuterClass$UpdateWalletBalanceUpdated parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$UpdateWalletBalanceUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$UpdateWalletBalanceUpdated parseFrom(byte[] bArr) {
        return (WalletOuterClass$UpdateWalletBalanceUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$UpdateWalletBalanceUpdated parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$UpdateWalletBalanceUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$UpdateWalletBalanceUpdated parseFrom(InputStream inputStream) {
        return (WalletOuterClass$UpdateWalletBalanceUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$UpdateWalletBalanceUpdated parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$UpdateWalletBalanceUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$UpdateWalletBalanceUpdated parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$UpdateWalletBalanceUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$UpdateWalletBalanceUpdated parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$UpdateWalletBalanceUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

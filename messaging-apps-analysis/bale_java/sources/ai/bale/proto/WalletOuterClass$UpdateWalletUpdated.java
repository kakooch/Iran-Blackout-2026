package ai.bale.proto;

import ai.bale.proto.WalletStruct$Wallet;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class WalletOuterClass$UpdateWalletUpdated extends GeneratedMessageLite implements U64 {
    private static final WalletOuterClass$UpdateWalletUpdated DEFAULT_INSTANCE;
    public static final int NEW_WALLET_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private WalletStruct$Wallet newWallet_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WalletOuterClass$UpdateWalletUpdated.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$UpdateWalletUpdated walletOuterClass$UpdateWalletUpdated = new WalletOuterClass$UpdateWalletUpdated();
        DEFAULT_INSTANCE = walletOuterClass$UpdateWalletUpdated;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$UpdateWalletUpdated.class, walletOuterClass$UpdateWalletUpdated);
    }

    private WalletOuterClass$UpdateWalletUpdated() {
    }

    private void clearNewWallet() {
        this.newWallet_ = null;
        this.bitField0_ &= -2;
    }

    public static WalletOuterClass$UpdateWalletUpdated getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeNewWallet(WalletStruct$Wallet walletStruct$Wallet) {
        walletStruct$Wallet.getClass();
        WalletStruct$Wallet walletStruct$Wallet2 = this.newWallet_;
        if (walletStruct$Wallet2 == null || walletStruct$Wallet2 == WalletStruct$Wallet.getDefaultInstance()) {
            this.newWallet_ = walletStruct$Wallet;
        } else {
            this.newWallet_ = (WalletStruct$Wallet) ((WalletStruct$Wallet.a) WalletStruct$Wallet.newBuilder(this.newWallet_).v(walletStruct$Wallet)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletOuterClass$UpdateWalletUpdated parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$UpdateWalletUpdated) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$UpdateWalletUpdated parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$UpdateWalletUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setNewWallet(WalletStruct$Wallet walletStruct$Wallet) {
        walletStruct$Wallet.getClass();
        this.newWallet_ = walletStruct$Wallet;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (u2.a[gVar.ordinal()]) {
            case 1:
                return new WalletOuterClass$UpdateWalletUpdated();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "newWallet_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$UpdateWalletUpdated.class) {
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

    public WalletStruct$Wallet getNewWallet() {
        WalletStruct$Wallet walletStruct$Wallet = this.newWallet_;
        return walletStruct$Wallet == null ? WalletStruct$Wallet.getDefaultInstance() : walletStruct$Wallet;
    }

    public boolean hasNewWallet() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(WalletOuterClass$UpdateWalletUpdated walletOuterClass$UpdateWalletUpdated) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$UpdateWalletUpdated);
    }

    public static WalletOuterClass$UpdateWalletUpdated parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$UpdateWalletUpdated) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$UpdateWalletUpdated parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$UpdateWalletUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$UpdateWalletUpdated parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$UpdateWalletUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletOuterClass$UpdateWalletUpdated parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$UpdateWalletUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$UpdateWalletUpdated parseFrom(byte[] bArr) {
        return (WalletOuterClass$UpdateWalletUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$UpdateWalletUpdated parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$UpdateWalletUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$UpdateWalletUpdated parseFrom(InputStream inputStream) {
        return (WalletOuterClass$UpdateWalletUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$UpdateWalletUpdated parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$UpdateWalletUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$UpdateWalletUpdated parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$UpdateWalletUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$UpdateWalletUpdated parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$UpdateWalletUpdated) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

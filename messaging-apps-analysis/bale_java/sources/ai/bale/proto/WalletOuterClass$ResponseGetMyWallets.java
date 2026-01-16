package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.T38;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class WalletOuterClass$ResponseGetMyWallets extends GeneratedMessageLite implements U64 {
    private static final WalletOuterClass$ResponseGetMyWallets DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int WALLETS_FIELD_NUMBER = 1;
    private B.j wallets_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WalletOuterClass$ResponseGetMyWallets.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$ResponseGetMyWallets walletOuterClass$ResponseGetMyWallets = new WalletOuterClass$ResponseGetMyWallets();
        DEFAULT_INSTANCE = walletOuterClass$ResponseGetMyWallets;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$ResponseGetMyWallets.class, walletOuterClass$ResponseGetMyWallets);
    }

    private WalletOuterClass$ResponseGetMyWallets() {
    }

    private void addAllWallets(Iterable<? extends WalletStruct$Wallet> iterable) {
        ensureWalletsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.wallets_);
    }

    private void addWallets(WalletStruct$Wallet walletStruct$Wallet) {
        walletStruct$Wallet.getClass();
        ensureWalletsIsMutable();
        this.wallets_.add(walletStruct$Wallet);
    }

    private void clearWallets() {
        this.wallets_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureWalletsIsMutable() {
        B.j jVar = this.wallets_;
        if (jVar.u()) {
            return;
        }
        this.wallets_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static WalletOuterClass$ResponseGetMyWallets getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletOuterClass$ResponseGetMyWallets parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$ResponseGetMyWallets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$ResponseGetMyWallets parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$ResponseGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeWallets(int i) {
        ensureWalletsIsMutable();
        this.wallets_.remove(i);
    }

    private void setWallets(int i, WalletStruct$Wallet walletStruct$Wallet) {
        walletStruct$Wallet.getClass();
        ensureWalletsIsMutable();
        this.wallets_.set(i, walletStruct$Wallet);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (u2.a[gVar.ordinal()]) {
            case 1:
                return new WalletOuterClass$ResponseGetMyWallets();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"wallets_", WalletStruct$Wallet.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$ResponseGetMyWallets.class) {
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

    public WalletStruct$Wallet getWallets(int i) {
        return (WalletStruct$Wallet) this.wallets_.get(i);
    }

    public int getWalletsCount() {
        return this.wallets_.size();
    }

    public List<WalletStruct$Wallet> getWalletsList() {
        return this.wallets_;
    }

    public T38 getWalletsOrBuilder(int i) {
        return (T38) this.wallets_.get(i);
    }

    public List<? extends T38> getWalletsOrBuilderList() {
        return this.wallets_;
    }

    public static a newBuilder(WalletOuterClass$ResponseGetMyWallets walletOuterClass$ResponseGetMyWallets) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$ResponseGetMyWallets);
    }

    public static WalletOuterClass$ResponseGetMyWallets parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetMyWallets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$ResponseGetMyWallets parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$ResponseGetMyWallets parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$ResponseGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addWallets(int i, WalletStruct$Wallet walletStruct$Wallet) {
        walletStruct$Wallet.getClass();
        ensureWalletsIsMutable();
        this.wallets_.add(i, walletStruct$Wallet);
    }

    public static WalletOuterClass$ResponseGetMyWallets parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$ResponseGetMyWallets parseFrom(byte[] bArr) {
        return (WalletOuterClass$ResponseGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$ResponseGetMyWallets parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$ResponseGetMyWallets parseFrom(InputStream inputStream) {
        return (WalletOuterClass$ResponseGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$ResponseGetMyWallets parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$ResponseGetMyWallets parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$ResponseGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$ResponseGetMyWallets parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

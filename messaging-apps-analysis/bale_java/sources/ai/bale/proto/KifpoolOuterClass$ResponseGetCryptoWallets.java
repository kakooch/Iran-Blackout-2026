package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7655Sq3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class KifpoolOuterClass$ResponseGetCryptoWallets extends GeneratedMessageLite implements U64 {
    private static final KifpoolOuterClass$ResponseGetCryptoWallets DEFAULT_INSTANCE;
    public static final int MY_CRYPTO_WALLETS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j myCryptoWallets_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$ResponseGetCryptoWallets.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$ResponseGetCryptoWallets kifpoolOuterClass$ResponseGetCryptoWallets = new KifpoolOuterClass$ResponseGetCryptoWallets();
        DEFAULT_INSTANCE = kifpoolOuterClass$ResponseGetCryptoWallets;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$ResponseGetCryptoWallets.class, kifpoolOuterClass$ResponseGetCryptoWallets);
    }

    private KifpoolOuterClass$ResponseGetCryptoWallets() {
    }

    private void addAllMyCryptoWallets(Iterable<? extends KifpoolStruct$CryptoPocket> iterable) {
        ensureMyCryptoWalletsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.myCryptoWallets_);
    }

    private void addMyCryptoWallets(KifpoolStruct$CryptoPocket kifpoolStruct$CryptoPocket) {
        kifpoolStruct$CryptoPocket.getClass();
        ensureMyCryptoWalletsIsMutable();
        this.myCryptoWallets_.add(kifpoolStruct$CryptoPocket);
    }

    private void clearMyCryptoWallets() {
        this.myCryptoWallets_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureMyCryptoWalletsIsMutable() {
        B.j jVar = this.myCryptoWallets_;
        if (jVar.u()) {
            return;
        }
        this.myCryptoWallets_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static KifpoolOuterClass$ResponseGetCryptoWallets getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$ResponseGetCryptoWallets parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseGetCryptoWallets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseGetCryptoWallets parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$ResponseGetCryptoWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMyCryptoWallets(int i) {
        ensureMyCryptoWalletsIsMutable();
        this.myCryptoWallets_.remove(i);
    }

    private void setMyCryptoWallets(int i, KifpoolStruct$CryptoPocket kifpoolStruct$CryptoPocket) {
        kifpoolStruct$CryptoPocket.getClass();
        ensureMyCryptoWalletsIsMutable();
        this.myCryptoWallets_.set(i, kifpoolStruct$CryptoPocket);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$ResponseGetCryptoWallets();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"myCryptoWallets_", KifpoolStruct$CryptoPocket.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$ResponseGetCryptoWallets.class) {
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

    public KifpoolStruct$CryptoPocket getMyCryptoWallets(int i) {
        return (KifpoolStruct$CryptoPocket) this.myCryptoWallets_.get(i);
    }

    public int getMyCryptoWalletsCount() {
        return this.myCryptoWallets_.size();
    }

    public List<KifpoolStruct$CryptoPocket> getMyCryptoWalletsList() {
        return this.myCryptoWallets_;
    }

    public InterfaceC7655Sq3 getMyCryptoWalletsOrBuilder(int i) {
        return (InterfaceC7655Sq3) this.myCryptoWallets_.get(i);
    }

    public List<? extends InterfaceC7655Sq3> getMyCryptoWalletsOrBuilderList() {
        return this.myCryptoWallets_;
    }

    public static a newBuilder(KifpoolOuterClass$ResponseGetCryptoWallets kifpoolOuterClass$ResponseGetCryptoWallets) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$ResponseGetCryptoWallets);
    }

    public static KifpoolOuterClass$ResponseGetCryptoWallets parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetCryptoWallets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetCryptoWallets parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetCryptoWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetCryptoWallets parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$ResponseGetCryptoWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMyCryptoWallets(int i, KifpoolStruct$CryptoPocket kifpoolStruct$CryptoPocket) {
        kifpoolStruct$CryptoPocket.getClass();
        ensureMyCryptoWalletsIsMutable();
        this.myCryptoWallets_.add(i, kifpoolStruct$CryptoPocket);
    }

    public static KifpoolOuterClass$ResponseGetCryptoWallets parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetCryptoWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetCryptoWallets parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$ResponseGetCryptoWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$ResponseGetCryptoWallets parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetCryptoWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetCryptoWallets parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseGetCryptoWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseGetCryptoWallets parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetCryptoWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetCryptoWallets parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$ResponseGetCryptoWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$ResponseGetCryptoWallets parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetCryptoWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

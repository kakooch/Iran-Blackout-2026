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
public final class KifpoolOuterClass$RequestGetKifpoolOwner extends GeneratedMessageLite implements U64 {
    private static final KifpoolOuterClass$RequestGetKifpoolOwner DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int WALLET_TOKEN_FIELD_NUMBER = 1;
    private String walletToken_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestGetKifpoolOwner.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestGetKifpoolOwner kifpoolOuterClass$RequestGetKifpoolOwner = new KifpoolOuterClass$RequestGetKifpoolOwner();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestGetKifpoolOwner;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestGetKifpoolOwner.class, kifpoolOuterClass$RequestGetKifpoolOwner);
    }

    private KifpoolOuterClass$RequestGetKifpoolOwner() {
    }

    private void clearWalletToken() {
        this.walletToken_ = getDefaultInstance().getWalletToken();
    }

    public static KifpoolOuterClass$RequestGetKifpoolOwner getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestGetKifpoolOwner parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestGetKifpoolOwner) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestGetKifpoolOwner parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setWalletToken(String str) {
        str.getClass();
        this.walletToken_ = str;
    }

    private void setWalletTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.walletToken_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$RequestGetKifpoolOwner();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"walletToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestGetKifpoolOwner.class) {
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

    public String getWalletToken() {
        return this.walletToken_;
    }

    public AbstractC2383g getWalletTokenBytes() {
        return AbstractC2383g.N(this.walletToken_);
    }

    public static a newBuilder(KifpoolOuterClass$RequestGetKifpoolOwner kifpoolOuterClass$RequestGetKifpoolOwner) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestGetKifpoolOwner);
    }

    public static KifpoolOuterClass$RequestGetKifpoolOwner parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetKifpoolOwner) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestGetKifpoolOwner parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestGetKifpoolOwner parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestGetKifpoolOwner parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestGetKifpoolOwner parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestGetKifpoolOwner parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestGetKifpoolOwner parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestGetKifpoolOwner parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestGetKifpoolOwner parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestGetKifpoolOwner parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

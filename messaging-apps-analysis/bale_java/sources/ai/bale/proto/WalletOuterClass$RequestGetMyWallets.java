package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class WalletOuterClass$RequestGetMyWallets extends GeneratedMessageLite implements U64 {
    private static final WalletOuterClass$RequestGetMyWallets DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WalletOuterClass$RequestGetMyWallets.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$RequestGetMyWallets walletOuterClass$RequestGetMyWallets = new WalletOuterClass$RequestGetMyWallets();
        DEFAULT_INSTANCE = walletOuterClass$RequestGetMyWallets;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$RequestGetMyWallets.class, walletOuterClass$RequestGetMyWallets);
    }

    private WalletOuterClass$RequestGetMyWallets() {
    }

    public static WalletOuterClass$RequestGetMyWallets getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletOuterClass$RequestGetMyWallets parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestGetMyWallets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestGetMyWallets parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$RequestGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (u2.a[gVar.ordinal()]) {
            case 1:
                return new WalletOuterClass$RequestGetMyWallets();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$RequestGetMyWallets.class) {
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

    public static a newBuilder(WalletOuterClass$RequestGetMyWallets walletOuterClass$RequestGetMyWallets) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$RequestGetMyWallets);
    }

    public static WalletOuterClass$RequestGetMyWallets parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestGetMyWallets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestGetMyWallets parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$RequestGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$RequestGetMyWallets parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$RequestGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletOuterClass$RequestGetMyWallets parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$RequestGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$RequestGetMyWallets parseFrom(byte[] bArr) {
        return (WalletOuterClass$RequestGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$RequestGetMyWallets parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$RequestGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$RequestGetMyWallets parseFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestGetMyWallets parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestGetMyWallets parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$RequestGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$RequestGetMyWallets parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$RequestGetMyWallets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

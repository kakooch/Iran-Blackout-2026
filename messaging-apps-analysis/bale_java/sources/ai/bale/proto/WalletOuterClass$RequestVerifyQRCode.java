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
public final class WalletOuterClass$RequestVerifyQRCode extends GeneratedMessageLite implements U64 {
    private static final WalletOuterClass$RequestVerifyQRCode DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TARGET_WALLET_ID_FIELD_NUMBER = 1;
    private String targetWalletId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((WalletOuterClass$RequestVerifyQRCode) this.b).setTargetWalletId(str);
            return this;
        }

        private a() {
            super(WalletOuterClass$RequestVerifyQRCode.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$RequestVerifyQRCode walletOuterClass$RequestVerifyQRCode = new WalletOuterClass$RequestVerifyQRCode();
        DEFAULT_INSTANCE = walletOuterClass$RequestVerifyQRCode;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$RequestVerifyQRCode.class, walletOuterClass$RequestVerifyQRCode);
    }

    private WalletOuterClass$RequestVerifyQRCode() {
    }

    private void clearTargetWalletId() {
        this.targetWalletId_ = getDefaultInstance().getTargetWalletId();
    }

    public static WalletOuterClass$RequestVerifyQRCode getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletOuterClass$RequestVerifyQRCode parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestVerifyQRCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestVerifyQRCode parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$RequestVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetWalletId(String str) {
        str.getClass();
        this.targetWalletId_ = str;
    }

    private void setTargetWalletIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.targetWalletId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (u2.a[gVar.ordinal()]) {
            case 1:
                return new WalletOuterClass$RequestVerifyQRCode();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"targetWalletId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$RequestVerifyQRCode.class) {
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

    public String getTargetWalletId() {
        return this.targetWalletId_;
    }

    public AbstractC2383g getTargetWalletIdBytes() {
        return AbstractC2383g.N(this.targetWalletId_);
    }

    public static a newBuilder(WalletOuterClass$RequestVerifyQRCode walletOuterClass$RequestVerifyQRCode) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$RequestVerifyQRCode);
    }

    public static WalletOuterClass$RequestVerifyQRCode parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestVerifyQRCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestVerifyQRCode parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$RequestVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$RequestVerifyQRCode parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$RequestVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletOuterClass$RequestVerifyQRCode parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$RequestVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$RequestVerifyQRCode parseFrom(byte[] bArr) {
        return (WalletOuterClass$RequestVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$RequestVerifyQRCode parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$RequestVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$RequestVerifyQRCode parseFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestVerifyQRCode parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestVerifyQRCode parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$RequestVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$RequestVerifyQRCode parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$RequestVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

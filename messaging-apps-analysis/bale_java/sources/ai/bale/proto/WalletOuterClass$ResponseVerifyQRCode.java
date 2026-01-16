package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class WalletOuterClass$ResponseVerifyQRCode extends GeneratedMessageLite implements U64 {
    private static final WalletOuterClass$ResponseVerifyQRCode DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TARGET_USER_ID_FIELD_NUMBER = 2;
    public static final int TARGET_WALLET_NAME_FIELD_NUMBER = 1;
    private int bitField0_;
    private Int32Value targetUserId_;
    private String targetWalletName_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WalletOuterClass$ResponseVerifyQRCode.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$ResponseVerifyQRCode walletOuterClass$ResponseVerifyQRCode = new WalletOuterClass$ResponseVerifyQRCode();
        DEFAULT_INSTANCE = walletOuterClass$ResponseVerifyQRCode;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$ResponseVerifyQRCode.class, walletOuterClass$ResponseVerifyQRCode);
    }

    private WalletOuterClass$ResponseVerifyQRCode() {
    }

    private void clearTargetUserId() {
        this.targetUserId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTargetWalletName() {
        this.targetWalletName_ = getDefaultInstance().getTargetWalletName();
    }

    public static WalletOuterClass$ResponseVerifyQRCode getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTargetUserId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.targetUserId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.targetUserId_ = int32Value;
        } else {
            this.targetUserId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.targetUserId_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletOuterClass$ResponseVerifyQRCode parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$ResponseVerifyQRCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$ResponseVerifyQRCode parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$ResponseVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setTargetUserId(Int32Value int32Value) {
        int32Value.getClass();
        this.targetUserId_ = int32Value;
        this.bitField0_ |= 1;
    }

    private void setTargetWalletName(String str) {
        str.getClass();
        this.targetWalletName_ = str;
    }

    private void setTargetWalletNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.targetWalletName_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (u2.a[gVar.ordinal()]) {
            case 1:
                return new WalletOuterClass$ResponseVerifyQRCode();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "targetWalletName_", "targetUserId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$ResponseVerifyQRCode.class) {
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

    public Int32Value getTargetUserId() {
        Int32Value int32Value = this.targetUserId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public String getTargetWalletName() {
        return this.targetWalletName_;
    }

    public AbstractC2383g getTargetWalletNameBytes() {
        return AbstractC2383g.N(this.targetWalletName_);
    }

    public boolean hasTargetUserId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(WalletOuterClass$ResponseVerifyQRCode walletOuterClass$ResponseVerifyQRCode) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$ResponseVerifyQRCode);
    }

    public static WalletOuterClass$ResponseVerifyQRCode parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$ResponseVerifyQRCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$ResponseVerifyQRCode parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$ResponseVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$ResponseVerifyQRCode parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$ResponseVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletOuterClass$ResponseVerifyQRCode parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$ResponseVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$ResponseVerifyQRCode parseFrom(byte[] bArr) {
        return (WalletOuterClass$ResponseVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$ResponseVerifyQRCode parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$ResponseVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$ResponseVerifyQRCode parseFrom(InputStream inputStream) {
        return (WalletOuterClass$ResponseVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$ResponseVerifyQRCode parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$ResponseVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$ResponseVerifyQRCode parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$ResponseVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$ResponseVerifyQRCode parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$ResponseVerifyQRCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

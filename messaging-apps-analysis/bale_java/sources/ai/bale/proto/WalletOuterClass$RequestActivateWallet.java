package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class WalletOuterClass$RequestActivateWallet extends GeneratedMessageLite implements U64 {
    private static final WalletOuterClass$RequestActivateWallet DEFAULT_INSTANCE;
    public static final int IS_AUTO_ACTIVATED_FIELD_NUMBER = 2;
    public static final int NATIONAL_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private BoolValue isAutoActivated_;
    private String nationalId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WalletOuterClass$RequestActivateWallet.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$RequestActivateWallet walletOuterClass$RequestActivateWallet = new WalletOuterClass$RequestActivateWallet();
        DEFAULT_INSTANCE = walletOuterClass$RequestActivateWallet;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$RequestActivateWallet.class, walletOuterClass$RequestActivateWallet);
    }

    private WalletOuterClass$RequestActivateWallet() {
    }

    private void clearIsAutoActivated() {
        this.isAutoActivated_ = null;
        this.bitField0_ &= -2;
    }

    private void clearNationalId() {
        this.nationalId_ = getDefaultInstance().getNationalId();
    }

    public static WalletOuterClass$RequestActivateWallet getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeIsAutoActivated(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isAutoActivated_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isAutoActivated_ = boolValue;
        } else {
            this.isAutoActivated_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isAutoActivated_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletOuterClass$RequestActivateWallet parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestActivateWallet) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestActivateWallet parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$RequestActivateWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsAutoActivated(BoolValue boolValue) {
        boolValue.getClass();
        this.isAutoActivated_ = boolValue;
        this.bitField0_ |= 1;
    }

    private void setNationalId(String str) {
        str.getClass();
        this.nationalId_ = str;
    }

    private void setNationalIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nationalId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (u2.a[gVar.ordinal()]) {
            case 1:
                return new WalletOuterClass$RequestActivateWallet();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "nationalId_", "isAutoActivated_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$RequestActivateWallet.class) {
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

    public BoolValue getIsAutoActivated() {
        BoolValue boolValue = this.isAutoActivated_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public String getNationalId() {
        return this.nationalId_;
    }

    public AbstractC2383g getNationalIdBytes() {
        return AbstractC2383g.N(this.nationalId_);
    }

    public boolean hasIsAutoActivated() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(WalletOuterClass$RequestActivateWallet walletOuterClass$RequestActivateWallet) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$RequestActivateWallet);
    }

    public static WalletOuterClass$RequestActivateWallet parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestActivateWallet) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestActivateWallet parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$RequestActivateWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$RequestActivateWallet parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$RequestActivateWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletOuterClass$RequestActivateWallet parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$RequestActivateWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$RequestActivateWallet parseFrom(byte[] bArr) {
        return (WalletOuterClass$RequestActivateWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$RequestActivateWallet parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$RequestActivateWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$RequestActivateWallet parseFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestActivateWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestActivateWallet parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestActivateWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestActivateWallet parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$RequestActivateWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$RequestActivateWallet parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$RequestActivateWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

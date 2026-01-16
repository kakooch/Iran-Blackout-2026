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
public final class WalletOuterClass$RequestVerifyCashOut extends GeneratedMessageLite implements U64 {
    public static final int ACCOUNT_NO_FIELD_NUMBER = 2;
    private static final WalletOuterClass$RequestVerifyCashOut DEFAULT_INSTANCE;
    public static final int NATIONAL_ID_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int WALLET_ID_FIELD_NUMBER = 1;
    private String walletId_ = "";
    private String accountNo_ = "";
    private String nationalId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WalletOuterClass$RequestVerifyCashOut.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$RequestVerifyCashOut walletOuterClass$RequestVerifyCashOut = new WalletOuterClass$RequestVerifyCashOut();
        DEFAULT_INSTANCE = walletOuterClass$RequestVerifyCashOut;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$RequestVerifyCashOut.class, walletOuterClass$RequestVerifyCashOut);
    }

    private WalletOuterClass$RequestVerifyCashOut() {
    }

    private void clearAccountNo() {
        this.accountNo_ = getDefaultInstance().getAccountNo();
    }

    private void clearNationalId() {
        this.nationalId_ = getDefaultInstance().getNationalId();
    }

    private void clearWalletId() {
        this.walletId_ = getDefaultInstance().getWalletId();
    }

    public static WalletOuterClass$RequestVerifyCashOut getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletOuterClass$RequestVerifyCashOut parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestVerifyCashOut) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestVerifyCashOut parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$RequestVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccountNo(String str) {
        str.getClass();
        this.accountNo_ = str;
    }

    private void setAccountNoBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.accountNo_ = abstractC2383g.f0();
    }

    private void setNationalId(String str) {
        str.getClass();
        this.nationalId_ = str;
    }

    private void setNationalIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nationalId_ = abstractC2383g.f0();
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
                return new WalletOuterClass$RequestVerifyCashOut();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"walletId_", "accountNo_", "nationalId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$RequestVerifyCashOut.class) {
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

    public String getAccountNo() {
        return this.accountNo_;
    }

    public AbstractC2383g getAccountNoBytes() {
        return AbstractC2383g.N(this.accountNo_);
    }

    public String getNationalId() {
        return this.nationalId_;
    }

    public AbstractC2383g getNationalIdBytes() {
        return AbstractC2383g.N(this.nationalId_);
    }

    public String getWalletId() {
        return this.walletId_;
    }

    public AbstractC2383g getWalletIdBytes() {
        return AbstractC2383g.N(this.walletId_);
    }

    public static a newBuilder(WalletOuterClass$RequestVerifyCashOut walletOuterClass$RequestVerifyCashOut) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$RequestVerifyCashOut);
    }

    public static WalletOuterClass$RequestVerifyCashOut parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestVerifyCashOut) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestVerifyCashOut parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$RequestVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$RequestVerifyCashOut parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$RequestVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletOuterClass$RequestVerifyCashOut parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$RequestVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$RequestVerifyCashOut parseFrom(byte[] bArr) {
        return (WalletOuterClass$RequestVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$RequestVerifyCashOut parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$RequestVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$RequestVerifyCashOut parseFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestVerifyCashOut parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestVerifyCashOut parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$RequestVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$RequestVerifyCashOut parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$RequestVerifyCashOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import ai.bale.proto.KifpoolStruct$CryptoPocket;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC8596Wq3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KifpoolStruct$Kifpool extends GeneratedMessageLite implements InterfaceC8596Wq3 {
    public static final int ACCOUNT_FIELD_NUMBER = 7;
    public static final int APP_FIELD_NUMBER = 2;
    public static final int BALANCE_FIELD_NUMBER = 3;
    public static final int CRYPTO_POCKET_FIELD_NUMBER = 8;
    private static final KifpoolStruct$Kifpool DEFAULT_INSTANCE;
    public static final int IS_MERCHANT_FIELD_NUMBER = 1;
    public static final int LEVEL_FIELD_NUMBER = 5;
    public static final int PAN_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 4;
    private StringValue account_;
    private long balance_;
    private int bitField0_;
    private KifpoolStruct$CryptoPocket cryptoPocket_;
    private boolean isMerchant_;
    private int level_;
    private StringValue pan_;
    private String app_ = "";
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC8596Wq3 {
        private a() {
            super(KifpoolStruct$Kifpool.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolStruct$Kifpool kifpoolStruct$Kifpool = new KifpoolStruct$Kifpool();
        DEFAULT_INSTANCE = kifpoolStruct$Kifpool;
        GeneratedMessageLite.registerDefaultInstance(KifpoolStruct$Kifpool.class, kifpoolStruct$Kifpool);
    }

    private KifpoolStruct$Kifpool() {
    }

    private void clearAccount() {
        this.account_ = null;
        this.bitField0_ &= -3;
    }

    private void clearApp() {
        this.app_ = getDefaultInstance().getApp();
    }

    private void clearBalance() {
        this.balance_ = 0L;
    }

    private void clearCryptoPocket() {
        this.cryptoPocket_ = null;
        this.bitField0_ &= -5;
    }

    private void clearIsMerchant() {
        this.isMerchant_ = false;
    }

    private void clearLevel() {
        this.level_ = 0;
    }

    private void clearPan() {
        this.pan_ = null;
        this.bitField0_ &= -2;
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static KifpoolStruct$Kifpool getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAccount(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.account_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.account_ = stringValue;
        } else {
            this.account_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.account_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeCryptoPocket(KifpoolStruct$CryptoPocket kifpoolStruct$CryptoPocket) {
        kifpoolStruct$CryptoPocket.getClass();
        KifpoolStruct$CryptoPocket kifpoolStruct$CryptoPocket2 = this.cryptoPocket_;
        if (kifpoolStruct$CryptoPocket2 == null || kifpoolStruct$CryptoPocket2 == KifpoolStruct$CryptoPocket.getDefaultInstance()) {
            this.cryptoPocket_ = kifpoolStruct$CryptoPocket;
        } else {
            this.cryptoPocket_ = (KifpoolStruct$CryptoPocket) ((KifpoolStruct$CryptoPocket.a) KifpoolStruct$CryptoPocket.newBuilder(this.cryptoPocket_).v(kifpoolStruct$CryptoPocket)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergePan(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.pan_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.pan_ = stringValue;
        } else {
            this.pan_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.pan_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolStruct$Kifpool parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolStruct$Kifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolStruct$Kifpool parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolStruct$Kifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccount(StringValue stringValue) {
        stringValue.getClass();
        this.account_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setApp(String str) {
        str.getClass();
        this.app_ = str;
    }

    private void setAppBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.app_ = abstractC2383g.f0();
    }

    private void setBalance(long j) {
        this.balance_ = j;
    }

    private void setCryptoPocket(KifpoolStruct$CryptoPocket kifpoolStruct$CryptoPocket) {
        kifpoolStruct$CryptoPocket.getClass();
        this.cryptoPocket_ = kifpoolStruct$CryptoPocket;
        this.bitField0_ |= 4;
    }

    private void setIsMerchant(boolean z) {
        this.isMerchant_ = z;
    }

    private void setLevel(int i) {
        this.level_ = i;
    }

    private void setPan(StringValue stringValue) {
        stringValue.getClass();
        this.pan_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    private void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1900v0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolStruct$Kifpool();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u0007\u0002Ȉ\u0003\u0002\u0004Ȉ\u0005\u0004\u0006ဉ\u0000\u0007ဉ\u0001\bဉ\u0002", new Object[]{"bitField0_", "isMerchant_", "app_", "balance_", "token_", "level_", "pan_", "account_", "cryptoPocket_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolStruct$Kifpool.class) {
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

    public StringValue getAccount() {
        StringValue stringValue = this.account_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getApp() {
        return this.app_;
    }

    public AbstractC2383g getAppBytes() {
        return AbstractC2383g.N(this.app_);
    }

    public long getBalance() {
        return this.balance_;
    }

    public KifpoolStruct$CryptoPocket getCryptoPocket() {
        KifpoolStruct$CryptoPocket kifpoolStruct$CryptoPocket = this.cryptoPocket_;
        return kifpoolStruct$CryptoPocket == null ? KifpoolStruct$CryptoPocket.getDefaultInstance() : kifpoolStruct$CryptoPocket;
    }

    public boolean getIsMerchant() {
        return this.isMerchant_;
    }

    public int getLevel() {
        return this.level_;
    }

    public StringValue getPan() {
        StringValue stringValue = this.pan_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public boolean hasAccount() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasCryptoPocket() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasPan() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KifpoolStruct$Kifpool kifpoolStruct$Kifpool) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolStruct$Kifpool);
    }

    public static KifpoolStruct$Kifpool parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolStruct$Kifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolStruct$Kifpool parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolStruct$Kifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolStruct$Kifpool parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolStruct$Kifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolStruct$Kifpool parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolStruct$Kifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolStruct$Kifpool parseFrom(byte[] bArr) {
        return (KifpoolStruct$Kifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolStruct$Kifpool parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolStruct$Kifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolStruct$Kifpool parseFrom(InputStream inputStream) {
        return (KifpoolStruct$Kifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolStruct$Kifpool parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolStruct$Kifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolStruct$Kifpool parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolStruct$Kifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolStruct$Kifpool parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolStruct$Kifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC9137Yq3;
import ir.nasim.InterfaceC7655Sq3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KifpoolStruct$CryptoPocket extends GeneratedMessageLite implements InterfaceC7655Sq3 {
    public static final int BALANCE_FIELD_NUMBER = 2;
    private static final KifpoolStruct$CryptoPocket DEFAULT_INSTANCE;
    public static final int IS_MERCHANT_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int POCKET_ID_FIELD_NUMBER = 1;
    public static final int POCKET_TYPE_FIELD_NUMBER = 4;
    public static final int TOKEN_FIELD_NUMBER = 3;
    private long balance_;
    private boolean isMerchant_;
    private int pocketType_;
    private String pocketId_ = "";
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC7655Sq3 {
        private a() {
            super(KifpoolStruct$CryptoPocket.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolStruct$CryptoPocket kifpoolStruct$CryptoPocket = new KifpoolStruct$CryptoPocket();
        DEFAULT_INSTANCE = kifpoolStruct$CryptoPocket;
        GeneratedMessageLite.registerDefaultInstance(KifpoolStruct$CryptoPocket.class, kifpoolStruct$CryptoPocket);
    }

    private KifpoolStruct$CryptoPocket() {
    }

    private void clearBalance() {
        this.balance_ = 0L;
    }

    private void clearIsMerchant() {
        this.isMerchant_ = false;
    }

    private void clearPocketId() {
        this.pocketId_ = getDefaultInstance().getPocketId();
    }

    private void clearPocketType() {
        this.pocketType_ = 0;
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static KifpoolStruct$CryptoPocket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolStruct$CryptoPocket parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolStruct$CryptoPocket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolStruct$CryptoPocket parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolStruct$CryptoPocket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBalance(long j) {
        this.balance_ = j;
    }

    private void setIsMerchant(boolean z) {
        this.isMerchant_ = z;
    }

    private void setPocketId(String str) {
        str.getClass();
        this.pocketId_ = str;
    }

    private void setPocketIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.pocketId_ = abstractC2383g.f0();
    }

    private void setPocketType(EnumC9137Yq3 enumC9137Yq3) {
        this.pocketType_ = enumC9137Yq3.getNumber();
    }

    private void setPocketTypeValue(int i) {
        this.pocketType_ = i;
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
                return new KifpoolStruct$CryptoPocket();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003Ȉ\u0004\f\u0005\u0007", new Object[]{"pocketId_", "balance_", "token_", "pocketType_", "isMerchant_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolStruct$CryptoPocket.class) {
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

    public long getBalance() {
        return this.balance_;
    }

    public boolean getIsMerchant() {
        return this.isMerchant_;
    }

    public String getPocketId() {
        return this.pocketId_;
    }

    public AbstractC2383g getPocketIdBytes() {
        return AbstractC2383g.N(this.pocketId_);
    }

    public EnumC9137Yq3 getPocketType() {
        EnumC9137Yq3 enumC9137Yq3J = EnumC9137Yq3.j(this.pocketType_);
        return enumC9137Yq3J == null ? EnumC9137Yq3.UNRECOGNIZED : enumC9137Yq3J;
    }

    public int getPocketTypeValue() {
        return this.pocketType_;
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public static a newBuilder(KifpoolStruct$CryptoPocket kifpoolStruct$CryptoPocket) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolStruct$CryptoPocket);
    }

    public static KifpoolStruct$CryptoPocket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolStruct$CryptoPocket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolStruct$CryptoPocket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolStruct$CryptoPocket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolStruct$CryptoPocket parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolStruct$CryptoPocket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolStruct$CryptoPocket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolStruct$CryptoPocket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolStruct$CryptoPocket parseFrom(byte[] bArr) {
        return (KifpoolStruct$CryptoPocket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolStruct$CryptoPocket parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolStruct$CryptoPocket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolStruct$CryptoPocket parseFrom(InputStream inputStream) {
        return (KifpoolStruct$CryptoPocket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolStruct$CryptoPocket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolStruct$CryptoPocket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolStruct$CryptoPocket parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolStruct$CryptoPocket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolStruct$CryptoPocket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolStruct$CryptoPocket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

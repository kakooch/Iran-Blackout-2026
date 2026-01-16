package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC9137Yq3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KifpoolOuterClass$RequestCryptoCashOutKifpool extends GeneratedMessageLite implements U64 {
    public static final int ACCOUNT_FIELD_NUMBER = 3;
    public static final int AMOUNT_FIELD_NUMBER = 2;
    private static final KifpoolOuterClass$RequestCryptoCashOutKifpool DEFAULT_INSTANCE;
    public static final int IS_MERCHANT_FIELD_NUMBER = 6;
    public static final int PAN_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int POCKET_TYPE_FIELD_NUMBER = 5;
    public static final int REQUEST_ID_FIELD_NUMBER = 1;
    private StringValue account_;
    private long amount_;
    private int bitField0_;
    private BoolValue isMerchant_;
    private StringValue pan_;
    private int pocketType_;
    private String requestId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestCryptoCashOutKifpool.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestCryptoCashOutKifpool kifpoolOuterClass$RequestCryptoCashOutKifpool = new KifpoolOuterClass$RequestCryptoCashOutKifpool();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestCryptoCashOutKifpool;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestCryptoCashOutKifpool.class, kifpoolOuterClass$RequestCryptoCashOutKifpool);
    }

    private KifpoolOuterClass$RequestCryptoCashOutKifpool() {
    }

    private void clearAccount() {
        this.account_ = null;
        this.bitField0_ &= -2;
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearIsMerchant() {
        this.isMerchant_ = null;
        this.bitField0_ &= -5;
    }

    private void clearPan() {
        this.pan_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPocketType() {
        this.pocketType_ = 0;
    }

    private void clearRequestId() {
        this.requestId_ = getDefaultInstance().getRequestId();
    }

    public static KifpoolOuterClass$RequestCryptoCashOutKifpool getDefaultInstance() {
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
        this.bitField0_ |= 1;
    }

    private void mergeIsMerchant(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isMerchant_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isMerchant_ = boolValue;
        } else {
            this.isMerchant_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isMerchant_).v(boolValue)).j();
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
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestCryptoCashOutKifpool parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestCryptoCashOutKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestCryptoCashOutKifpool parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestCryptoCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccount(StringValue stringValue) {
        stringValue.getClass();
        this.account_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setIsMerchant(BoolValue boolValue) {
        boolValue.getClass();
        this.isMerchant_ = boolValue;
        this.bitField0_ |= 4;
    }

    private void setPan(StringValue stringValue) {
        stringValue.getClass();
        this.pan_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setPocketType(EnumC9137Yq3 enumC9137Yq3) {
        this.pocketType_ = enumC9137Yq3.getNumber();
    }

    private void setPocketTypeValue(int i) {
        this.pocketType_ = i;
    }

    private void setRequestId(String str) {
        str.getClass();
        this.requestId_ = str;
    }

    private void setRequestIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.requestId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$RequestCryptoCashOutKifpool();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003ဉ\u0000\u0004ဉ\u0001\u0005\f\u0006ဉ\u0002", new Object[]{"bitField0_", "requestId_", "amount_", "account_", "pan_", "pocketType_", "isMerchant_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestCryptoCashOutKifpool.class) {
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

    public long getAmount() {
        return this.amount_;
    }

    public BoolValue getIsMerchant() {
        BoolValue boolValue = this.isMerchant_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public StringValue getPan() {
        StringValue stringValue = this.pan_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public EnumC9137Yq3 getPocketType() {
        EnumC9137Yq3 enumC9137Yq3J = EnumC9137Yq3.j(this.pocketType_);
        return enumC9137Yq3J == null ? EnumC9137Yq3.UNRECOGNIZED : enumC9137Yq3J;
    }

    public int getPocketTypeValue() {
        return this.pocketType_;
    }

    public String getRequestId() {
        return this.requestId_;
    }

    public AbstractC2383g getRequestIdBytes() {
        return AbstractC2383g.N(this.requestId_);
    }

    public boolean hasAccount() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasIsMerchant() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasPan() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(KifpoolOuterClass$RequestCryptoCashOutKifpool kifpoolOuterClass$RequestCryptoCashOutKifpool) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestCryptoCashOutKifpool);
    }

    public static KifpoolOuterClass$RequestCryptoCashOutKifpool parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoCashOutKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoCashOutKifpool parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoCashOutKifpool parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestCryptoCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestCryptoCashOutKifpool parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoCashOutKifpool parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestCryptoCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestCryptoCashOutKifpool parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoCashOutKifpool parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestCryptoCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestCryptoCashOutKifpool parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestCryptoCashOutKifpool parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestCryptoCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestCryptoCashOutKifpool parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCryptoCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

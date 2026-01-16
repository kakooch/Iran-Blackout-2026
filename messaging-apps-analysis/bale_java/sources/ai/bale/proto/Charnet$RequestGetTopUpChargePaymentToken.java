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

/* loaded from: classes9.dex */
public final class Charnet$RequestGetTopUpChargePaymentToken extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 3;
    private static final Charnet$RequestGetTopUpChargePaymentToken DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PROVIDER_CODE_FIELD_NUMBER = 1;
    public static final int TARGET_PHONE_NUMBER_FIELD_NUMBER = 4;
    public static final int TARGET_USER_ID_FIELD_NUMBER = 5;
    public static final int TOPUP_TYPE_FIELD_NUMBER = 2;
    private int amount_;
    private int bitField0_;
    private Int32Value targetUserId_;
    private String providerCode_ = "";
    private String topupType_ = "";
    private String targetPhoneNumber_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Charnet$RequestGetTopUpChargePaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        Charnet$RequestGetTopUpChargePaymentToken charnet$RequestGetTopUpChargePaymentToken = new Charnet$RequestGetTopUpChargePaymentToken();
        DEFAULT_INSTANCE = charnet$RequestGetTopUpChargePaymentToken;
        GeneratedMessageLite.registerDefaultInstance(Charnet$RequestGetTopUpChargePaymentToken.class, charnet$RequestGetTopUpChargePaymentToken);
    }

    private Charnet$RequestGetTopUpChargePaymentToken() {
    }

    private void clearAmount() {
        this.amount_ = 0;
    }

    private void clearProviderCode() {
        this.providerCode_ = getDefaultInstance().getProviderCode();
    }

    private void clearTargetPhoneNumber() {
        this.targetPhoneNumber_ = getDefaultInstance().getTargetPhoneNumber();
    }

    private void clearTargetUserId() {
        this.targetUserId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTopupType() {
        this.topupType_ = getDefaultInstance().getTopupType();
    }

    public static Charnet$RequestGetTopUpChargePaymentToken getDefaultInstance() {
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

    public static Charnet$RequestGetTopUpChargePaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (Charnet$RequestGetTopUpChargePaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$RequestGetTopUpChargePaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (Charnet$RequestGetTopUpChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(int i) {
        this.amount_ = i;
    }

    private void setProviderCode(String str) {
        str.getClass();
        this.providerCode_ = str;
    }

    private void setProviderCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.providerCode_ = abstractC2383g.f0();
    }

    private void setTargetPhoneNumber(String str) {
        str.getClass();
        this.targetPhoneNumber_ = str;
    }

    private void setTargetPhoneNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.targetPhoneNumber_ = abstractC2383g.f0();
    }

    private void setTargetUserId(Int32Value int32Value) {
        int32Value.getClass();
        this.targetUserId_ = int32Value;
        this.bitField0_ |= 1;
    }

    private void setTopupType(String str) {
        str.getClass();
        this.topupType_ = str;
    }

    private void setTopupTypeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.topupType_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1911z.a[gVar.ordinal()]) {
            case 1:
                return new Charnet$RequestGetTopUpChargePaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0004\u0004Ȉ\u0005ဉ\u0000", new Object[]{"bitField0_", "providerCode_", "topupType_", "amount_", "targetPhoneNumber_", "targetUserId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Charnet$RequestGetTopUpChargePaymentToken.class) {
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

    public int getAmount() {
        return this.amount_;
    }

    public String getProviderCode() {
        return this.providerCode_;
    }

    public AbstractC2383g getProviderCodeBytes() {
        return AbstractC2383g.N(this.providerCode_);
    }

    public String getTargetPhoneNumber() {
        return this.targetPhoneNumber_;
    }

    public AbstractC2383g getTargetPhoneNumberBytes() {
        return AbstractC2383g.N(this.targetPhoneNumber_);
    }

    public Int32Value getTargetUserId() {
        Int32Value int32Value = this.targetUserId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public String getTopupType() {
        return this.topupType_;
    }

    public AbstractC2383g getTopupTypeBytes() {
        return AbstractC2383g.N(this.topupType_);
    }

    public boolean hasTargetUserId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Charnet$RequestGetTopUpChargePaymentToken charnet$RequestGetTopUpChargePaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnet$RequestGetTopUpChargePaymentToken);
    }

    public static Charnet$RequestGetTopUpChargePaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$RequestGetTopUpChargePaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$RequestGetTopUpChargePaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Charnet$RequestGetTopUpChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Charnet$RequestGetTopUpChargePaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (Charnet$RequestGetTopUpChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Charnet$RequestGetTopUpChargePaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Charnet$RequestGetTopUpChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Charnet$RequestGetTopUpChargePaymentToken parseFrom(byte[] bArr) {
        return (Charnet$RequestGetTopUpChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Charnet$RequestGetTopUpChargePaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (Charnet$RequestGetTopUpChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Charnet$RequestGetTopUpChargePaymentToken parseFrom(InputStream inputStream) {
        return (Charnet$RequestGetTopUpChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$RequestGetTopUpChargePaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$RequestGetTopUpChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$RequestGetTopUpChargePaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (Charnet$RequestGetTopUpChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Charnet$RequestGetTopUpChargePaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Charnet$RequestGetTopUpChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

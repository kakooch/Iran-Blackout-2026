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
public final class Saba$RequestGetChargeVoucherPaymentToken extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 3;
    private static final Saba$RequestGetChargeVoucherPaymentToken DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PROVIDER_CODE_FIELD_NUMBER = 1;
    public static final int TARGET_USER_ID_FIELD_NUMBER = 4;
    private int amount_;
    private int bitField0_;
    private String providerCode_ = "";
    private Int32Value targetUserId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Saba$RequestGetChargeVoucherPaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        Saba$RequestGetChargeVoucherPaymentToken saba$RequestGetChargeVoucherPaymentToken = new Saba$RequestGetChargeVoucherPaymentToken();
        DEFAULT_INSTANCE = saba$RequestGetChargeVoucherPaymentToken;
        GeneratedMessageLite.registerDefaultInstance(Saba$RequestGetChargeVoucherPaymentToken.class, saba$RequestGetChargeVoucherPaymentToken);
    }

    private Saba$RequestGetChargeVoucherPaymentToken() {
    }

    private void clearAmount() {
        this.amount_ = 0;
    }

    private void clearProviderCode() {
        this.providerCode_ = getDefaultInstance().getProviderCode();
    }

    private void clearTargetUserId() {
        this.targetUserId_ = null;
        this.bitField0_ &= -2;
    }

    public static Saba$RequestGetChargeVoucherPaymentToken getDefaultInstance() {
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

    public static Saba$RequestGetChargeVoucherPaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (Saba$RequestGetChargeVoucherPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Saba$RequestGetChargeVoucherPaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (Saba$RequestGetChargeVoucherPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setTargetUserId(Int32Value int32Value) {
        int32Value.getClass();
        this.targetUserId_ = int32Value;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B1.a[gVar.ordinal()]) {
            case 1:
                return new Saba$RequestGetChargeVoucherPaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001Ȉ\u0003\u0004\u0004ဉ\u0000", new Object[]{"bitField0_", "providerCode_", "amount_", "targetUserId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Saba$RequestGetChargeVoucherPaymentToken.class) {
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

    public Int32Value getTargetUserId() {
        Int32Value int32Value = this.targetUserId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public boolean hasTargetUserId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Saba$RequestGetChargeVoucherPaymentToken saba$RequestGetChargeVoucherPaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(saba$RequestGetChargeVoucherPaymentToken);
    }

    public static Saba$RequestGetChargeVoucherPaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Saba$RequestGetChargeVoucherPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Saba$RequestGetChargeVoucherPaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Saba$RequestGetChargeVoucherPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Saba$RequestGetChargeVoucherPaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (Saba$RequestGetChargeVoucherPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Saba$RequestGetChargeVoucherPaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Saba$RequestGetChargeVoucherPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Saba$RequestGetChargeVoucherPaymentToken parseFrom(byte[] bArr) {
        return (Saba$RequestGetChargeVoucherPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Saba$RequestGetChargeVoucherPaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (Saba$RequestGetChargeVoucherPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Saba$RequestGetChargeVoucherPaymentToken parseFrom(InputStream inputStream) {
        return (Saba$RequestGetChargeVoucherPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Saba$RequestGetChargeVoucherPaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Saba$RequestGetChargeVoucherPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Saba$RequestGetChargeVoucherPaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (Saba$RequestGetChargeVoucherPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Saba$RequestGetChargeVoucherPaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Saba$RequestGetChargeVoucherPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

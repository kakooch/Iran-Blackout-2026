package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.XK0;
import ir.nasim.YK0;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Charnet$RequestBuyCharge extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 3;
    public static final int CHARGE_TYPE_FIELD_NUMBER = 6;
    private static final Charnet$RequestBuyCharge DEFAULT_INSTANCE;
    public static final int OPERATOR_TYPE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NUMBER_FIELD_NUMBER = 2;
    public static final int REMAINING_FIELD_NUMBER = 5;
    public static final int TARGET_USER_ID_FIELD_NUMBER = 7;
    public static final int VOUCHER_ID_FIELD_NUMBER = 8;
    public static final int WALLET_TOKEN_FIELD_NUMBER = 1;
    private long amount_;
    private int bitField0_;
    private int chargeType_;
    private int operatorType_;
    private CollectionsStruct$Int64Value remaining_;
    private Int32Value targetUserId_;
    private Int32Value voucherId_;
    private String walletToken_ = "";
    private String phoneNumber_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Charnet$RequestBuyCharge.DEFAULT_INSTANCE);
        }
    }

    static {
        Charnet$RequestBuyCharge charnet$RequestBuyCharge = new Charnet$RequestBuyCharge();
        DEFAULT_INSTANCE = charnet$RequestBuyCharge;
        GeneratedMessageLite.registerDefaultInstance(Charnet$RequestBuyCharge.class, charnet$RequestBuyCharge);
    }

    private Charnet$RequestBuyCharge() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearChargeType() {
        this.chargeType_ = 0;
    }

    private void clearOperatorType() {
        this.operatorType_ = 0;
    }

    private void clearPhoneNumber() {
        this.phoneNumber_ = getDefaultInstance().getPhoneNumber();
    }

    private void clearRemaining() {
        this.remaining_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTargetUserId() {
        this.targetUserId_ = null;
        this.bitField0_ &= -3;
    }

    private void clearVoucherId() {
        this.voucherId_ = null;
        this.bitField0_ &= -5;
    }

    private void clearWalletToken() {
        this.walletToken_ = getDefaultInstance().getWalletToken();
    }

    public static Charnet$RequestBuyCharge getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeRemaining(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.remaining_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.remaining_ = collectionsStruct$Int64Value;
        } else {
            this.remaining_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.remaining_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeTargetUserId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.targetUserId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.targetUserId_ = int32Value;
        } else {
            this.targetUserId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.targetUserId_).v(int32Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeVoucherId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.voucherId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.voucherId_ = int32Value;
        } else {
            this.voucherId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.voucherId_).v(int32Value)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Charnet$RequestBuyCharge parseDelimitedFrom(InputStream inputStream) {
        return (Charnet$RequestBuyCharge) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$RequestBuyCharge parseFrom(ByteBuffer byteBuffer) {
        return (Charnet$RequestBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setChargeType(YK0 yk0) {
        this.chargeType_ = yk0.getNumber();
    }

    private void setChargeTypeValue(int i) {
        this.chargeType_ = i;
    }

    private void setOperatorType(XK0 xk0) {
        this.operatorType_ = xk0.getNumber();
    }

    private void setOperatorTypeValue(int i) {
        this.operatorType_ = i;
    }

    private void setPhoneNumber(String str) {
        str.getClass();
        this.phoneNumber_ = str;
    }

    private void setPhoneNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.phoneNumber_ = abstractC2383g.f0();
    }

    private void setRemaining(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.remaining_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 1;
    }

    private void setTargetUserId(Int32Value int32Value) {
        int32Value.getClass();
        this.targetUserId_ = int32Value;
        this.bitField0_ |= 2;
    }

    private void setVoucherId(Int32Value int32Value) {
        int32Value.getClass();
        this.voucherId_ = int32Value;
        this.bitField0_ |= 4;
    }

    private void setWalletToken(String str) {
        str.getClass();
        this.walletToken_ = str;
    }

    private void setWalletTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.walletToken_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1911z.a[gVar.ordinal()]) {
            case 1:
                return new Charnet$RequestBuyCharge();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004\f\u0005ဉ\u0000\u0006\f\u0007ဉ\u0001\bဉ\u0002", new Object[]{"bitField0_", "walletToken_", "phoneNumber_", "amount_", "operatorType_", "remaining_", "chargeType_", "targetUserId_", "voucherId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Charnet$RequestBuyCharge.class) {
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

    public long getAmount() {
        return this.amount_;
    }

    public YK0 getChargeType() {
        YK0 yk0J = YK0.j(this.chargeType_);
        return yk0J == null ? YK0.UNRECOGNIZED : yk0J;
    }

    public int getChargeTypeValue() {
        return this.chargeType_;
    }

    public XK0 getOperatorType() {
        XK0 xk0J = XK0.j(this.operatorType_);
        return xk0J == null ? XK0.UNRECOGNIZED : xk0J;
    }

    public int getOperatorTypeValue() {
        return this.operatorType_;
    }

    public String getPhoneNumber() {
        return this.phoneNumber_;
    }

    public AbstractC2383g getPhoneNumberBytes() {
        return AbstractC2383g.N(this.phoneNumber_);
    }

    public CollectionsStruct$Int64Value getRemaining() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.remaining_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public Int32Value getTargetUserId() {
        Int32Value int32Value = this.targetUserId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public Int32Value getVoucherId() {
        Int32Value int32Value = this.voucherId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public String getWalletToken() {
        return this.walletToken_;
    }

    public AbstractC2383g getWalletTokenBytes() {
        return AbstractC2383g.N(this.walletToken_);
    }

    public boolean hasRemaining() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasTargetUserId() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasVoucherId() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(Charnet$RequestBuyCharge charnet$RequestBuyCharge) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnet$RequestBuyCharge);
    }

    public static Charnet$RequestBuyCharge parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$RequestBuyCharge) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$RequestBuyCharge parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Charnet$RequestBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Charnet$RequestBuyCharge parseFrom(AbstractC2383g abstractC2383g) {
        return (Charnet$RequestBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Charnet$RequestBuyCharge parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Charnet$RequestBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Charnet$RequestBuyCharge parseFrom(byte[] bArr) {
        return (Charnet$RequestBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Charnet$RequestBuyCharge parseFrom(byte[] bArr, C2394s c2394s) {
        return (Charnet$RequestBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Charnet$RequestBuyCharge parseFrom(InputStream inputStream) {
        return (Charnet$RequestBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$RequestBuyCharge parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$RequestBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$RequestBuyCharge parseFrom(AbstractC2384h abstractC2384h) {
        return (Charnet$RequestBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Charnet$RequestBuyCharge parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Charnet$RequestBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

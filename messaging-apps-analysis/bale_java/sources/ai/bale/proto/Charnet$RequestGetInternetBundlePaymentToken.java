package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.XK0;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Charnet$RequestGetInternetBundlePaymentToken extends GeneratedMessageLite implements U64 {
    public static final int BUNDLE_ID_FIELD_NUMBER = 2;
    private static final Charnet$RequestGetInternetBundlePaymentToken DEFAULT_INSTANCE;
    public static final int OPERATOR_TYPE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NUMBER_FIELD_NUMBER = 3;
    public static final int TARGET_USER_ID_FIELD_NUMBER = 4;
    private int bitField0_;
    private long bundleId_;
    private int operatorType_;
    private String phoneNumber_ = "";
    private Int32Value targetUserId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Charnet$RequestGetInternetBundlePaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        Charnet$RequestGetInternetBundlePaymentToken charnet$RequestGetInternetBundlePaymentToken = new Charnet$RequestGetInternetBundlePaymentToken();
        DEFAULT_INSTANCE = charnet$RequestGetInternetBundlePaymentToken;
        GeneratedMessageLite.registerDefaultInstance(Charnet$RequestGetInternetBundlePaymentToken.class, charnet$RequestGetInternetBundlePaymentToken);
    }

    private Charnet$RequestGetInternetBundlePaymentToken() {
    }

    private void clearBundleId() {
        this.bundleId_ = 0L;
    }

    private void clearOperatorType() {
        this.operatorType_ = 0;
    }

    private void clearPhoneNumber() {
        this.phoneNumber_ = getDefaultInstance().getPhoneNumber();
    }

    private void clearTargetUserId() {
        this.targetUserId_ = null;
        this.bitField0_ &= -2;
    }

    public static Charnet$RequestGetInternetBundlePaymentToken getDefaultInstance() {
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

    public static Charnet$RequestGetInternetBundlePaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (Charnet$RequestGetInternetBundlePaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$RequestGetInternetBundlePaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (Charnet$RequestGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBundleId(long j) {
        this.bundleId_ = j;
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

    private void setTargetUserId(Int32Value int32Value) {
        int32Value.getClass();
        this.targetUserId_ = int32Value;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1911z.a[gVar.ordinal()]) {
            case 1:
                return new Charnet$RequestGetInternetBundlePaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0002\u0002\u0003Ȉ\u0004ဉ\u0000", new Object[]{"bitField0_", "operatorType_", "bundleId_", "phoneNumber_", "targetUserId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Charnet$RequestGetInternetBundlePaymentToken.class) {
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

    public long getBundleId() {
        return this.bundleId_;
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

    public Int32Value getTargetUserId() {
        Int32Value int32Value = this.targetUserId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public boolean hasTargetUserId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Charnet$RequestGetInternetBundlePaymentToken charnet$RequestGetInternetBundlePaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnet$RequestGetInternetBundlePaymentToken);
    }

    public static Charnet$RequestGetInternetBundlePaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$RequestGetInternetBundlePaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$RequestGetInternetBundlePaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Charnet$RequestGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Charnet$RequestGetInternetBundlePaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (Charnet$RequestGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Charnet$RequestGetInternetBundlePaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Charnet$RequestGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Charnet$RequestGetInternetBundlePaymentToken parseFrom(byte[] bArr) {
        return (Charnet$RequestGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Charnet$RequestGetInternetBundlePaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (Charnet$RequestGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Charnet$RequestGetInternetBundlePaymentToken parseFrom(InputStream inputStream) {
        return (Charnet$RequestGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$RequestGetInternetBundlePaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$RequestGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$RequestGetInternetBundlePaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (Charnet$RequestGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Charnet$RequestGetInternetBundlePaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Charnet$RequestGetInternetBundlePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

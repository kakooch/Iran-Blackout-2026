package bale.smart_support.v1;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportOuterClass$RequestCreateOrder extends GeneratedMessageLite implements U64 {
    private static final SmartSupportOuterClass$RequestCreateOrder DEFAULT_INSTANCE;
    public static final int DISCOUNT_CODE_FIELD_NUMBER = 4;
    public static final int PACKAGE_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int USE_CREDIT_FIELD_NUMBER = 3;
    private int bitField0_;
    private StringValue discountCode_;
    private int packageId_;
    private boolean useCredit_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$RequestCreateOrder.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$RequestCreateOrder smartSupportOuterClass$RequestCreateOrder = new SmartSupportOuterClass$RequestCreateOrder();
        DEFAULT_INSTANCE = smartSupportOuterClass$RequestCreateOrder;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$RequestCreateOrder.class, smartSupportOuterClass$RequestCreateOrder);
    }

    private SmartSupportOuterClass$RequestCreateOrder() {
    }

    private void clearDiscountCode() {
        this.discountCode_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPackageId() {
        this.packageId_ = 0;
    }

    private void clearUseCredit() {
        this.useCredit_ = false;
    }

    public static SmartSupportOuterClass$RequestCreateOrder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDiscountCode(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.discountCode_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.discountCode_ = stringValue;
        } else {
            this.discountCode_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.discountCode_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$RequestCreateOrder parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestCreateOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestCreateOrder parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$RequestCreateOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDiscountCode(StringValue stringValue) {
        stringValue.getClass();
        this.discountCode_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setPackageId(int i) {
        this.packageId_ = i;
    }

    private void setUseCredit(boolean z) {
        this.useCredit_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$RequestCreateOrder();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0002\u0004\u0003\u0000\u0000\u0000\u0002\u0004\u0003\u0007\u0004ဉ\u0000", new Object[]{"bitField0_", "packageId_", "useCredit_", "discountCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$RequestCreateOrder.class) {
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

    public StringValue getDiscountCode() {
        StringValue stringValue = this.discountCode_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public int getPackageId() {
        return this.packageId_;
    }

    public boolean getUseCredit() {
        return this.useCredit_;
    }

    public boolean hasDiscountCode() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SmartSupportOuterClass$RequestCreateOrder smartSupportOuterClass$RequestCreateOrder) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$RequestCreateOrder);
    }

    public static SmartSupportOuterClass$RequestCreateOrder parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestCreateOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestCreateOrder parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestCreateOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$RequestCreateOrder parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$RequestCreateOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportOuterClass$RequestCreateOrder parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestCreateOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$RequestCreateOrder parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$RequestCreateOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$RequestCreateOrder parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestCreateOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$RequestCreateOrder parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestCreateOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestCreateOrder parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestCreateOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestCreateOrder parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$RequestCreateOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$RequestCreateOrder parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestCreateOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

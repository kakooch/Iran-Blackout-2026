package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KifpoolOuterClass$ResponseVerifyPurchaseMessage extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 1;
    private static final KifpoolOuterClass$ResponseVerifyPurchaseMessage DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_TITLE_FIELD_NUMBER = 3;
    public static final int PAYMENT_TYPE_TITLE_FIELD_NUMBER = 2;
    private CollectionsStruct$Int64Value amount_;
    private int bitField0_;
    private StringValue paymentTitle_;
    private StringValue paymentTypeTitle_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$ResponseVerifyPurchaseMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$ResponseVerifyPurchaseMessage kifpoolOuterClass$ResponseVerifyPurchaseMessage = new KifpoolOuterClass$ResponseVerifyPurchaseMessage();
        DEFAULT_INSTANCE = kifpoolOuterClass$ResponseVerifyPurchaseMessage;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$ResponseVerifyPurchaseMessage.class, kifpoolOuterClass$ResponseVerifyPurchaseMessage);
    }

    private KifpoolOuterClass$ResponseVerifyPurchaseMessage() {
    }

    private void clearAmount() {
        this.amount_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPaymentTitle() {
        this.paymentTitle_ = null;
        this.bitField0_ &= -5;
    }

    private void clearPaymentTypeTitle() {
        this.paymentTypeTitle_ = null;
        this.bitField0_ &= -3;
    }

    public static KifpoolOuterClass$ResponseVerifyPurchaseMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAmount(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.amount_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.amount_ = collectionsStruct$Int64Value;
        } else {
            this.amount_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.amount_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergePaymentTitle(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.paymentTitle_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.paymentTitle_ = stringValue;
        } else {
            this.paymentTitle_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.paymentTitle_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergePaymentTypeTitle(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.paymentTypeTitle_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.paymentTypeTitle_ = stringValue;
        } else {
            this.paymentTypeTitle_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.paymentTypeTitle_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$ResponseVerifyPurchaseMessage parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseVerifyPurchaseMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseVerifyPurchaseMessage parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$ResponseVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.amount_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 1;
    }

    private void setPaymentTitle(StringValue stringValue) {
        stringValue.getClass();
        this.paymentTitle_ = stringValue;
        this.bitField0_ |= 4;
    }

    private void setPaymentTypeTitle(StringValue stringValue) {
        stringValue.getClass();
        this.paymentTypeTitle_ = stringValue;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$ResponseVerifyPurchaseMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"bitField0_", "amount_", "paymentTypeTitle_", "paymentTitle_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$ResponseVerifyPurchaseMessage.class) {
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

    public CollectionsStruct$Int64Value getAmount() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.amount_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public StringValue getPaymentTitle() {
        StringValue stringValue = this.paymentTitle_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getPaymentTypeTitle() {
        StringValue stringValue = this.paymentTypeTitle_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasAmount() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPaymentTitle() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasPaymentTypeTitle() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(KifpoolOuterClass$ResponseVerifyPurchaseMessage kifpoolOuterClass$ResponseVerifyPurchaseMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$ResponseVerifyPurchaseMessage);
    }

    public static KifpoolOuterClass$ResponseVerifyPurchaseMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseVerifyPurchaseMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseVerifyPurchaseMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$ResponseVerifyPurchaseMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$ResponseVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$ResponseVerifyPurchaseMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$ResponseVerifyPurchaseMessage parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$ResponseVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$ResponseVerifyPurchaseMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$ResponseVerifyPurchaseMessage parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseVerifyPurchaseMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseVerifyPurchaseMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$ResponseVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$ResponseVerifyPurchaseMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseVerifyPurchaseMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

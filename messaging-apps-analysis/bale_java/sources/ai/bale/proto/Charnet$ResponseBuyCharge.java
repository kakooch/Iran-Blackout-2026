package ai.bale.proto;

import ai.bale.proto.CharnetStruct$BuyChargeReceipt;
import ai.bale.proto.CollectionsStruct$StringValue;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Charnet$ResponseBuyCharge extends GeneratedMessageLite implements U64 {
    private static final Charnet$ResponseBuyCharge DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_TOKEN_FIELD_NUMBER = 1;
    public static final int RECEIPT_FIELD_NUMBER = 2;
    private int bitField0_;
    private CollectionsStruct$StringValue paymentToken_;
    private CharnetStruct$BuyChargeReceipt receipt_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Charnet$ResponseBuyCharge.DEFAULT_INSTANCE);
        }
    }

    static {
        Charnet$ResponseBuyCharge charnet$ResponseBuyCharge = new Charnet$ResponseBuyCharge();
        DEFAULT_INSTANCE = charnet$ResponseBuyCharge;
        GeneratedMessageLite.registerDefaultInstance(Charnet$ResponseBuyCharge.class, charnet$ResponseBuyCharge);
    }

    private Charnet$ResponseBuyCharge() {
    }

    private void clearPaymentToken() {
        this.paymentToken_ = null;
        this.bitField0_ &= -2;
    }

    private void clearReceipt() {
        this.receipt_ = null;
        this.bitField0_ &= -3;
    }

    public static Charnet$ResponseBuyCharge getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePaymentToken(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.paymentToken_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.paymentToken_ = collectionsStruct$StringValue;
        } else {
            this.paymentToken_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.paymentToken_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeReceipt(CharnetStruct$BuyChargeReceipt charnetStruct$BuyChargeReceipt) {
        charnetStruct$BuyChargeReceipt.getClass();
        CharnetStruct$BuyChargeReceipt charnetStruct$BuyChargeReceipt2 = this.receipt_;
        if (charnetStruct$BuyChargeReceipt2 == null || charnetStruct$BuyChargeReceipt2 == CharnetStruct$BuyChargeReceipt.getDefaultInstance()) {
            this.receipt_ = charnetStruct$BuyChargeReceipt;
        } else {
            this.receipt_ = (CharnetStruct$BuyChargeReceipt) ((CharnetStruct$BuyChargeReceipt.a) CharnetStruct$BuyChargeReceipt.newBuilder(this.receipt_).v(charnetStruct$BuyChargeReceipt)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Charnet$ResponseBuyCharge parseDelimitedFrom(InputStream inputStream) {
        return (Charnet$ResponseBuyCharge) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$ResponseBuyCharge parseFrom(ByteBuffer byteBuffer) {
        return (Charnet$ResponseBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPaymentToken(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.paymentToken_ = collectionsStruct$StringValue;
        this.bitField0_ |= 1;
    }

    private void setReceipt(CharnetStruct$BuyChargeReceipt charnetStruct$BuyChargeReceipt) {
        charnetStruct$BuyChargeReceipt.getClass();
        this.receipt_ = charnetStruct$BuyChargeReceipt;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1911z.a[gVar.ordinal()]) {
            case 1:
                return new Charnet$ResponseBuyCharge();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "paymentToken_", "receipt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Charnet$ResponseBuyCharge.class) {
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

    public CollectionsStruct$StringValue getPaymentToken() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.paymentToken_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public CharnetStruct$BuyChargeReceipt getReceipt() {
        CharnetStruct$BuyChargeReceipt charnetStruct$BuyChargeReceipt = this.receipt_;
        return charnetStruct$BuyChargeReceipt == null ? CharnetStruct$BuyChargeReceipt.getDefaultInstance() : charnetStruct$BuyChargeReceipt;
    }

    public boolean hasPaymentToken() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasReceipt() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(Charnet$ResponseBuyCharge charnet$ResponseBuyCharge) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnet$ResponseBuyCharge);
    }

    public static Charnet$ResponseBuyCharge parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$ResponseBuyCharge) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$ResponseBuyCharge parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Charnet$ResponseBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Charnet$ResponseBuyCharge parseFrom(AbstractC2383g abstractC2383g) {
        return (Charnet$ResponseBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Charnet$ResponseBuyCharge parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Charnet$ResponseBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Charnet$ResponseBuyCharge parseFrom(byte[] bArr) {
        return (Charnet$ResponseBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Charnet$ResponseBuyCharge parseFrom(byte[] bArr, C2394s c2394s) {
        return (Charnet$ResponseBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Charnet$ResponseBuyCharge parseFrom(InputStream inputStream) {
        return (Charnet$ResponseBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$ResponseBuyCharge parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$ResponseBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$ResponseBuyCharge parseFrom(AbstractC2384h abstractC2384h) {
        return (Charnet$ResponseBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Charnet$ResponseBuyCharge parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Charnet$ResponseBuyCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

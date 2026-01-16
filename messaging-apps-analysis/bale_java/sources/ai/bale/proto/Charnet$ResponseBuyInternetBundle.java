package ai.bale.proto;

import ai.bale.proto.CharnetStruct$BuyInternetBundleReceipt;
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
public final class Charnet$ResponseBuyInternetBundle extends GeneratedMessageLite implements U64 {
    private static final Charnet$ResponseBuyInternetBundle DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_TOKEN_FIELD_NUMBER = 1;
    public static final int RECEIPT_FIELD_NUMBER = 2;
    private int bitField0_;
    private CollectionsStruct$StringValue paymentToken_;
    private CharnetStruct$BuyInternetBundleReceipt receipt_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Charnet$ResponseBuyInternetBundle.DEFAULT_INSTANCE);
        }
    }

    static {
        Charnet$ResponseBuyInternetBundle charnet$ResponseBuyInternetBundle = new Charnet$ResponseBuyInternetBundle();
        DEFAULT_INSTANCE = charnet$ResponseBuyInternetBundle;
        GeneratedMessageLite.registerDefaultInstance(Charnet$ResponseBuyInternetBundle.class, charnet$ResponseBuyInternetBundle);
    }

    private Charnet$ResponseBuyInternetBundle() {
    }

    private void clearPaymentToken() {
        this.paymentToken_ = null;
        this.bitField0_ &= -2;
    }

    private void clearReceipt() {
        this.receipt_ = null;
        this.bitField0_ &= -3;
    }

    public static Charnet$ResponseBuyInternetBundle getDefaultInstance() {
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

    private void mergeReceipt(CharnetStruct$BuyInternetBundleReceipt charnetStruct$BuyInternetBundleReceipt) {
        charnetStruct$BuyInternetBundleReceipt.getClass();
        CharnetStruct$BuyInternetBundleReceipt charnetStruct$BuyInternetBundleReceipt2 = this.receipt_;
        if (charnetStruct$BuyInternetBundleReceipt2 == null || charnetStruct$BuyInternetBundleReceipt2 == CharnetStruct$BuyInternetBundleReceipt.getDefaultInstance()) {
            this.receipt_ = charnetStruct$BuyInternetBundleReceipt;
        } else {
            this.receipt_ = (CharnetStruct$BuyInternetBundleReceipt) ((CharnetStruct$BuyInternetBundleReceipt.a) CharnetStruct$BuyInternetBundleReceipt.newBuilder(this.receipt_).v(charnetStruct$BuyInternetBundleReceipt)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Charnet$ResponseBuyInternetBundle parseDelimitedFrom(InputStream inputStream) {
        return (Charnet$ResponseBuyInternetBundle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$ResponseBuyInternetBundle parseFrom(ByteBuffer byteBuffer) {
        return (Charnet$ResponseBuyInternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPaymentToken(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.paymentToken_ = collectionsStruct$StringValue;
        this.bitField0_ |= 1;
    }

    private void setReceipt(CharnetStruct$BuyInternetBundleReceipt charnetStruct$BuyInternetBundleReceipt) {
        charnetStruct$BuyInternetBundleReceipt.getClass();
        this.receipt_ = charnetStruct$BuyInternetBundleReceipt;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1911z.a[gVar.ordinal()]) {
            case 1:
                return new Charnet$ResponseBuyInternetBundle();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "paymentToken_", "receipt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Charnet$ResponseBuyInternetBundle.class) {
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

    public CharnetStruct$BuyInternetBundleReceipt getReceipt() {
        CharnetStruct$BuyInternetBundleReceipt charnetStruct$BuyInternetBundleReceipt = this.receipt_;
        return charnetStruct$BuyInternetBundleReceipt == null ? CharnetStruct$BuyInternetBundleReceipt.getDefaultInstance() : charnetStruct$BuyInternetBundleReceipt;
    }

    public boolean hasPaymentToken() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasReceipt() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(Charnet$ResponseBuyInternetBundle charnet$ResponseBuyInternetBundle) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnet$ResponseBuyInternetBundle);
    }

    public static Charnet$ResponseBuyInternetBundle parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$ResponseBuyInternetBundle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$ResponseBuyInternetBundle parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Charnet$ResponseBuyInternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Charnet$ResponseBuyInternetBundle parseFrom(AbstractC2383g abstractC2383g) {
        return (Charnet$ResponseBuyInternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Charnet$ResponseBuyInternetBundle parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Charnet$ResponseBuyInternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Charnet$ResponseBuyInternetBundle parseFrom(byte[] bArr) {
        return (Charnet$ResponseBuyInternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Charnet$ResponseBuyInternetBundle parseFrom(byte[] bArr, C2394s c2394s) {
        return (Charnet$ResponseBuyInternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Charnet$ResponseBuyInternetBundle parseFrom(InputStream inputStream) {
        return (Charnet$ResponseBuyInternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$ResponseBuyInternetBundle parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$ResponseBuyInternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$ResponseBuyInternetBundle parseFrom(AbstractC2384h abstractC2384h) {
        return (Charnet$ResponseBuyInternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Charnet$ResponseBuyInternetBundle parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Charnet$ResponseBuyInternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

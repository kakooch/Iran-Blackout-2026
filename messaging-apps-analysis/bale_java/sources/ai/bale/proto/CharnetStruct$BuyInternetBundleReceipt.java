package ai.bale.proto;

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
public final class CharnetStruct$BuyInternetBundleReceipt extends GeneratedMessageLite implements U64 {
    public static final int BALE_CLUB_SCORE_FIELD_NUMBER = 2;
    private static final CharnetStruct$BuyInternetBundleReceipt DEFAULT_INSTANCE;
    public static final int ORDER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TRANSACTION_KEY_FIELD_NUMBER = 3;
    private long baleClubScore_;
    private int bitField0_;
    private long orderId_;
    private CollectionsStruct$StringValue transactionKey_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(CharnetStruct$BuyInternetBundleReceipt.DEFAULT_INSTANCE);
        }
    }

    static {
        CharnetStruct$BuyInternetBundleReceipt charnetStruct$BuyInternetBundleReceipt = new CharnetStruct$BuyInternetBundleReceipt();
        DEFAULT_INSTANCE = charnetStruct$BuyInternetBundleReceipt;
        GeneratedMessageLite.registerDefaultInstance(CharnetStruct$BuyInternetBundleReceipt.class, charnetStruct$BuyInternetBundleReceipt);
    }

    private CharnetStruct$BuyInternetBundleReceipt() {
    }

    private void clearBaleClubScore() {
        this.baleClubScore_ = 0L;
    }

    private void clearOrderId() {
        this.orderId_ = 0L;
    }

    private void clearTransactionKey() {
        this.transactionKey_ = null;
        this.bitField0_ &= -2;
    }

    public static CharnetStruct$BuyInternetBundleReceipt getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTransactionKey(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.transactionKey_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.transactionKey_ = collectionsStruct$StringValue;
        } else {
            this.transactionKey_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.transactionKey_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CharnetStruct$BuyInternetBundleReceipt parseDelimitedFrom(InputStream inputStream) {
        return (CharnetStruct$BuyInternetBundleReceipt) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CharnetStruct$BuyInternetBundleReceipt parseFrom(ByteBuffer byteBuffer) {
        return (CharnetStruct$BuyInternetBundleReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBaleClubScore(long j) {
        this.baleClubScore_ = j;
    }

    private void setOrderId(long j) {
        this.orderId_ = j;
    }

    private void setTransactionKey(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.transactionKey_ = collectionsStruct$StringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (A.a[gVar.ordinal()]) {
            case 1:
                return new CharnetStruct$BuyInternetBundleReceipt();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003ဉ\u0000", new Object[]{"bitField0_", "orderId_", "baleClubScore_", "transactionKey_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CharnetStruct$BuyInternetBundleReceipt.class) {
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

    public long getBaleClubScore() {
        return this.baleClubScore_;
    }

    public long getOrderId() {
        return this.orderId_;
    }

    public CollectionsStruct$StringValue getTransactionKey() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.transactionKey_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public boolean hasTransactionKey() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(CharnetStruct$BuyInternetBundleReceipt charnetStruct$BuyInternetBundleReceipt) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnetStruct$BuyInternetBundleReceipt);
    }

    public static CharnetStruct$BuyInternetBundleReceipt parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CharnetStruct$BuyInternetBundleReceipt) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CharnetStruct$BuyInternetBundleReceipt parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CharnetStruct$BuyInternetBundleReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CharnetStruct$BuyInternetBundleReceipt parseFrom(AbstractC2383g abstractC2383g) {
        return (CharnetStruct$BuyInternetBundleReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CharnetStruct$BuyInternetBundleReceipt parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CharnetStruct$BuyInternetBundleReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CharnetStruct$BuyInternetBundleReceipt parseFrom(byte[] bArr) {
        return (CharnetStruct$BuyInternetBundleReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CharnetStruct$BuyInternetBundleReceipt parseFrom(byte[] bArr, C2394s c2394s) {
        return (CharnetStruct$BuyInternetBundleReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CharnetStruct$BuyInternetBundleReceipt parseFrom(InputStream inputStream) {
        return (CharnetStruct$BuyInternetBundleReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CharnetStruct$BuyInternetBundleReceipt parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CharnetStruct$BuyInternetBundleReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CharnetStruct$BuyInternetBundleReceipt parseFrom(AbstractC2384h abstractC2384h) {
        return (CharnetStruct$BuyInternetBundleReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CharnetStruct$BuyInternetBundleReceipt parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CharnetStruct$BuyInternetBundleReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

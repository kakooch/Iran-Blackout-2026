package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import com.google.protobuf.AbstractC2377a;
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
public final class BankOuterClass$ResponseGetPaymentToken extends GeneratedMessageLite implements U64 {
    public static final int CARD_ACQ_ID_FIELD_NUMBER = 4;
    private static final BankOuterClass$ResponseGetPaymentToken DEFAULT_INSTANCE;
    public static final int ENDPOINT_FIELD_NUMBER = 2;
    public static final int ORDER_ID_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int TERMINAL_ID_FIELD_NUMBER = 3;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private int bitField0_;
    private StringValue cardAcqId_;
    private CollectionsStruct$Int64Value orderId_;
    private StringValue terminalId_;
    private String token_ = "";
    private String endpoint_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$ResponseGetPaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$ResponseGetPaymentToken bankOuterClass$ResponseGetPaymentToken = new BankOuterClass$ResponseGetPaymentToken();
        DEFAULT_INSTANCE = bankOuterClass$ResponseGetPaymentToken;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$ResponseGetPaymentToken.class, bankOuterClass$ResponseGetPaymentToken);
    }

    private BankOuterClass$ResponseGetPaymentToken() {
    }

    private void clearCardAcqId() {
        this.cardAcqId_ = null;
        this.bitField0_ &= -3;
    }

    private void clearEndpoint() {
        this.endpoint_ = getDefaultInstance().getEndpoint();
    }

    private void clearOrderId() {
        this.orderId_ = null;
        this.bitField0_ &= -5;
    }

    private void clearTerminalId() {
        this.terminalId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static BankOuterClass$ResponseGetPaymentToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCardAcqId(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.cardAcqId_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.cardAcqId_ = stringValue;
        } else {
            this.cardAcqId_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.cardAcqId_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeOrderId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.orderId_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.orderId_ = collectionsStruct$Int64Value;
        } else {
            this.orderId_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.orderId_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeTerminalId(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.terminalId_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.terminalId_ = stringValue;
        } else {
            this.terminalId_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.terminalId_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$ResponseGetPaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseGetPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseGetPaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$ResponseGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCardAcqId(StringValue stringValue) {
        stringValue.getClass();
        this.cardAcqId_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setEndpoint(String str) {
        str.getClass();
        this.endpoint_ = str;
    }

    private void setEndpointBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.endpoint_ = abstractC2383g.f0();
    }

    private void setOrderId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.orderId_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 4;
    }

    private void setTerminalId(StringValue stringValue) {
        stringValue.getClass();
        this.terminalId_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    private void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$ResponseGetPaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003ဉ\u0000\u0004ဉ\u0001\u0005ဉ\u0002", new Object[]{"bitField0_", "token_", "endpoint_", "terminalId_", "cardAcqId_", "orderId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$ResponseGetPaymentToken.class) {
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

    public StringValue getCardAcqId() {
        StringValue stringValue = this.cardAcqId_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getEndpoint() {
        return this.endpoint_;
    }

    public AbstractC2383g getEndpointBytes() {
        return AbstractC2383g.N(this.endpoint_);
    }

    public CollectionsStruct$Int64Value getOrderId() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.orderId_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public StringValue getTerminalId() {
        StringValue stringValue = this.terminalId_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public boolean hasCardAcqId() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasOrderId() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasTerminalId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BankOuterClass$ResponseGetPaymentToken bankOuterClass$ResponseGetPaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$ResponseGetPaymentToken);
    }

    public static BankOuterClass$ResponseGetPaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseGetPaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$ResponseGetPaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$ResponseGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$ResponseGetPaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$ResponseGetPaymentToken parseFrom(byte[] bArr) {
        return (BankOuterClass$ResponseGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$ResponseGetPaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$ResponseGetPaymentToken parseFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseGetPaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseGetPaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$ResponseGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$ResponseGetPaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SafirPanelMessageOuterClass$ResponseCreateMessageOrder extends GeneratedMessageLite implements U64 {
    private static final SafirPanelMessageOuterClass$ResponseCreateMessageOrder DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_TOKEN_FIELD_NUMBER = 1;
    private int bitField0_;
    private StringValue paymentToken_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SafirPanelMessageOuterClass$ResponseCreateMessageOrder.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirPanelMessageOuterClass$ResponseCreateMessageOrder safirPanelMessageOuterClass$ResponseCreateMessageOrder = new SafirPanelMessageOuterClass$ResponseCreateMessageOrder();
        DEFAULT_INSTANCE = safirPanelMessageOuterClass$ResponseCreateMessageOrder;
        GeneratedMessageLite.registerDefaultInstance(SafirPanelMessageOuterClass$ResponseCreateMessageOrder.class, safirPanelMessageOuterClass$ResponseCreateMessageOrder);
    }

    private SafirPanelMessageOuterClass$ResponseCreateMessageOrder() {
    }

    private void clearPaymentToken() {
        this.paymentToken_ = null;
        this.bitField0_ &= -2;
    }

    public static SafirPanelMessageOuterClass$ResponseCreateMessageOrder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePaymentToken(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.paymentToken_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.paymentToken_ = stringValue;
        } else {
            this.paymentToken_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.paymentToken_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SafirPanelMessageOuterClass$ResponseCreateMessageOrder parseDelimitedFrom(InputStream inputStream) {
        return (SafirPanelMessageOuterClass$ResponseCreateMessageOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirPanelMessageOuterClass$ResponseCreateMessageOrder parseFrom(ByteBuffer byteBuffer) {
        return (SafirPanelMessageOuterClass$ResponseCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPaymentToken(StringValue stringValue) {
        stringValue.getClass();
        this.paymentToken_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F1.a[gVar.ordinal()]) {
            case 1:
                return new SafirPanelMessageOuterClass$ResponseCreateMessageOrder();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "paymentToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirPanelMessageOuterClass$ResponseCreateMessageOrder.class) {
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

    public StringValue getPaymentToken() {
        StringValue stringValue = this.paymentToken_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasPaymentToken() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SafirPanelMessageOuterClass$ResponseCreateMessageOrder safirPanelMessageOuterClass$ResponseCreateMessageOrder) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirPanelMessageOuterClass$ResponseCreateMessageOrder);
    }

    public static SafirPanelMessageOuterClass$ResponseCreateMessageOrder parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$ResponseCreateMessageOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirPanelMessageOuterClass$ResponseCreateMessageOrder parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$ResponseCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirPanelMessageOuterClass$ResponseCreateMessageOrder parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirPanelMessageOuterClass$ResponseCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SafirPanelMessageOuterClass$ResponseCreateMessageOrder parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$ResponseCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirPanelMessageOuterClass$ResponseCreateMessageOrder parseFrom(byte[] bArr) {
        return (SafirPanelMessageOuterClass$ResponseCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirPanelMessageOuterClass$ResponseCreateMessageOrder parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$ResponseCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirPanelMessageOuterClass$ResponseCreateMessageOrder parseFrom(InputStream inputStream) {
        return (SafirPanelMessageOuterClass$ResponseCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirPanelMessageOuterClass$ResponseCreateMessageOrder parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$ResponseCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirPanelMessageOuterClass$ResponseCreateMessageOrder parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirPanelMessageOuterClass$ResponseCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirPanelMessageOuterClass$ResponseCreateMessageOrder parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$ResponseCreateMessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

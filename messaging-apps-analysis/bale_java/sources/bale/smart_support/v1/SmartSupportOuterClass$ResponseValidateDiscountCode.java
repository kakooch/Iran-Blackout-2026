package bale.smart_support.v1;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportOuterClass$ResponseValidateDiscountCode extends GeneratedMessageLite implements U64 {
    private static final SmartSupportOuterClass$ResponseValidateDiscountCode DEFAULT_INSTANCE;
    public static final int DISCOUNT_AMOUNT_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int discountAmount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$ResponseValidateDiscountCode.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$ResponseValidateDiscountCode smartSupportOuterClass$ResponseValidateDiscountCode = new SmartSupportOuterClass$ResponseValidateDiscountCode();
        DEFAULT_INSTANCE = smartSupportOuterClass$ResponseValidateDiscountCode;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$ResponseValidateDiscountCode.class, smartSupportOuterClass$ResponseValidateDiscountCode);
    }

    private SmartSupportOuterClass$ResponseValidateDiscountCode() {
    }

    private void clearDiscountAmount() {
        this.discountAmount_ = 0;
    }

    public static SmartSupportOuterClass$ResponseValidateDiscountCode getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$ResponseValidateDiscountCode parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$ResponseValidateDiscountCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$ResponseValidateDiscountCode parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$ResponseValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDiscountAmount(int i) {
        this.discountAmount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$ResponseValidateDiscountCode();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"discountAmount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$ResponseValidateDiscountCode.class) {
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

    public int getDiscountAmount() {
        return this.discountAmount_;
    }

    public static a newBuilder(SmartSupportOuterClass$ResponseValidateDiscountCode smartSupportOuterClass$ResponseValidateDiscountCode) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$ResponseValidateDiscountCode);
    }

    public static SmartSupportOuterClass$ResponseValidateDiscountCode parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseValidateDiscountCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$ResponseValidateDiscountCode parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$ResponseValidateDiscountCode parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$ResponseValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportOuterClass$ResponseValidateDiscountCode parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$ResponseValidateDiscountCode parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$ResponseValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$ResponseValidateDiscountCode parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$ResponseValidateDiscountCode parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$ResponseValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$ResponseValidateDiscountCode parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$ResponseValidateDiscountCode parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$ResponseValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$ResponseValidateDiscountCode parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

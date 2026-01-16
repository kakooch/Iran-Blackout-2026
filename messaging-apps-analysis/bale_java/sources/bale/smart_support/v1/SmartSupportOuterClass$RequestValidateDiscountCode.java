package bale.smart_support.v1;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportOuterClass$RequestValidateDiscountCode extends GeneratedMessageLite implements U64 {
    private static final SmartSupportOuterClass$RequestValidateDiscountCode DEFAULT_INSTANCE;
    public static final int DISCOUNT_CODE_FIELD_NUMBER = 2;
    public static final int PACKAGE_ID_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private String discountCode_ = "";
    private int packageId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$RequestValidateDiscountCode.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$RequestValidateDiscountCode smartSupportOuterClass$RequestValidateDiscountCode = new SmartSupportOuterClass$RequestValidateDiscountCode();
        DEFAULT_INSTANCE = smartSupportOuterClass$RequestValidateDiscountCode;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$RequestValidateDiscountCode.class, smartSupportOuterClass$RequestValidateDiscountCode);
    }

    private SmartSupportOuterClass$RequestValidateDiscountCode() {
    }

    private void clearDiscountCode() {
        this.discountCode_ = getDefaultInstance().getDiscountCode();
    }

    private void clearPackageId() {
        this.packageId_ = 0;
    }

    public static SmartSupportOuterClass$RequestValidateDiscountCode getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$RequestValidateDiscountCode parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestValidateDiscountCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestValidateDiscountCode parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$RequestValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDiscountCode(String str) {
        str.getClass();
        this.discountCode_ = str;
    }

    private void setDiscountCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.discountCode_ = abstractC2383g.f0();
    }

    private void setPackageId(int i) {
        this.packageId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$RequestValidateDiscountCode();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002Ȉ\u0003\u0004", new Object[]{"discountCode_", "packageId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$RequestValidateDiscountCode.class) {
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

    public String getDiscountCode() {
        return this.discountCode_;
    }

    public AbstractC2383g getDiscountCodeBytes() {
        return AbstractC2383g.N(this.discountCode_);
    }

    public int getPackageId() {
        return this.packageId_;
    }

    public static a newBuilder(SmartSupportOuterClass$RequestValidateDiscountCode smartSupportOuterClass$RequestValidateDiscountCode) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$RequestValidateDiscountCode);
    }

    public static SmartSupportOuterClass$RequestValidateDiscountCode parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestValidateDiscountCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestValidateDiscountCode parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$RequestValidateDiscountCode parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$RequestValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportOuterClass$RequestValidateDiscountCode parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$RequestValidateDiscountCode parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$RequestValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$RequestValidateDiscountCode parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$RequestValidateDiscountCode parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestValidateDiscountCode parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestValidateDiscountCode parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$RequestValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$RequestValidateDiscountCode parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestValidateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

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
public final class SmartSupportAdminOuterClass$ResponseCreateDiscountCode extends GeneratedMessageLite implements U64 {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final SmartSupportAdminOuterClass$ResponseCreateDiscountCode DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String code_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportAdminOuterClass$ResponseCreateDiscountCode.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportAdminOuterClass$ResponseCreateDiscountCode smartSupportAdminOuterClass$ResponseCreateDiscountCode = new SmartSupportAdminOuterClass$ResponseCreateDiscountCode();
        DEFAULT_INSTANCE = smartSupportAdminOuterClass$ResponseCreateDiscountCode;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportAdminOuterClass$ResponseCreateDiscountCode.class, smartSupportAdminOuterClass$ResponseCreateDiscountCode);
    }

    private SmartSupportAdminOuterClass$ResponseCreateDiscountCode() {
    }

    private void clearCode() {
        this.code_ = getDefaultInstance().getCode();
    }

    public static SmartSupportAdminOuterClass$ResponseCreateDiscountCode getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportAdminOuterClass$ResponseCreateDiscountCode parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportAdminOuterClass$ResponseCreateDiscountCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportAdminOuterClass$ResponseCreateDiscountCode parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportAdminOuterClass$ResponseCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCode(String str) {
        str.getClass();
        this.code_ = str;
    }

    private void setCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.code_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (bale.smart_support.v1.a.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportAdminOuterClass$ResponseCreateDiscountCode();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"code_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportAdminOuterClass$ResponseCreateDiscountCode.class) {
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

    public String getCode() {
        return this.code_;
    }

    public AbstractC2383g getCodeBytes() {
        return AbstractC2383g.N(this.code_);
    }

    public static a newBuilder(SmartSupportAdminOuterClass$ResponseCreateDiscountCode smartSupportAdminOuterClass$ResponseCreateDiscountCode) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportAdminOuterClass$ResponseCreateDiscountCode);
    }

    public static SmartSupportAdminOuterClass$ResponseCreateDiscountCode parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$ResponseCreateDiscountCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportAdminOuterClass$ResponseCreateDiscountCode parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$ResponseCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportAdminOuterClass$ResponseCreateDiscountCode parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportAdminOuterClass$ResponseCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportAdminOuterClass$ResponseCreateDiscountCode parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$ResponseCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportAdminOuterClass$ResponseCreateDiscountCode parseFrom(byte[] bArr) {
        return (SmartSupportAdminOuterClass$ResponseCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportAdminOuterClass$ResponseCreateDiscountCode parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$ResponseCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportAdminOuterClass$ResponseCreateDiscountCode parseFrom(InputStream inputStream) {
        return (SmartSupportAdminOuterClass$ResponseCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportAdminOuterClass$ResponseCreateDiscountCode parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$ResponseCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportAdminOuterClass$ResponseCreateDiscountCode parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportAdminOuterClass$ResponseCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportAdminOuterClass$ResponseCreateDiscountCode parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$ResponseCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ArbainexchangeStruct$VerifyByArbaeenNakhodaCode extends GeneratedMessageLite implements U64 {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final ArbainexchangeStruct$VerifyByArbaeenNakhodaCode DEFAULT_INSTANCE;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private String code_ = "";
    private String nationalCode_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ArbainexchangeStruct$VerifyByArbaeenNakhodaCode.DEFAULT_INSTANCE);
        }
    }

    static {
        ArbainexchangeStruct$VerifyByArbaeenNakhodaCode arbainexchangeStruct$VerifyByArbaeenNakhodaCode = new ArbainexchangeStruct$VerifyByArbaeenNakhodaCode();
        DEFAULT_INSTANCE = arbainexchangeStruct$VerifyByArbaeenNakhodaCode;
        GeneratedMessageLite.registerDefaultInstance(ArbainexchangeStruct$VerifyByArbaeenNakhodaCode.class, arbainexchangeStruct$VerifyByArbaeenNakhodaCode);
    }

    private ArbainexchangeStruct$VerifyByArbaeenNakhodaCode() {
    }

    private void clearCode() {
        this.code_ = getDefaultInstance().getCode();
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    public static ArbainexchangeStruct$VerifyByArbaeenNakhodaCode getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ArbainexchangeStruct$VerifyByArbaeenNakhodaCode parseDelimitedFrom(InputStream inputStream) {
        return (ArbainexchangeStruct$VerifyByArbaeenNakhodaCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ArbainexchangeStruct$VerifyByArbaeenNakhodaCode parseFrom(ByteBuffer byteBuffer) {
        return (ArbainexchangeStruct$VerifyByArbaeenNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setNationalCode(String str) {
        str.getClass();
        this.nationalCode_ = str;
    }

    private void setNationalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nationalCode_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1864j.a[gVar.ordinal()]) {
            case 1:
                return new ArbainexchangeStruct$VerifyByArbaeenNakhodaCode();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"code_", "nationalCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ArbainexchangeStruct$VerifyByArbaeenNakhodaCode.class) {
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

    public String getNationalCode() {
        return this.nationalCode_;
    }

    public AbstractC2383g getNationalCodeBytes() {
        return AbstractC2383g.N(this.nationalCode_);
    }

    public static a newBuilder(ArbainexchangeStruct$VerifyByArbaeenNakhodaCode arbainexchangeStruct$VerifyByArbaeenNakhodaCode) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchangeStruct$VerifyByArbaeenNakhodaCode);
    }

    public static ArbainexchangeStruct$VerifyByArbaeenNakhodaCode parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ArbainexchangeStruct$VerifyByArbaeenNakhodaCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ArbainexchangeStruct$VerifyByArbaeenNakhodaCode parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ArbainexchangeStruct$VerifyByArbaeenNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ArbainexchangeStruct$VerifyByArbaeenNakhodaCode parseFrom(AbstractC2383g abstractC2383g) {
        return (ArbainexchangeStruct$VerifyByArbaeenNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ArbainexchangeStruct$VerifyByArbaeenNakhodaCode parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ArbainexchangeStruct$VerifyByArbaeenNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ArbainexchangeStruct$VerifyByArbaeenNakhodaCode parseFrom(byte[] bArr) {
        return (ArbainexchangeStruct$VerifyByArbaeenNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ArbainexchangeStruct$VerifyByArbaeenNakhodaCode parseFrom(byte[] bArr, C2394s c2394s) {
        return (ArbainexchangeStruct$VerifyByArbaeenNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ArbainexchangeStruct$VerifyByArbaeenNakhodaCode parseFrom(InputStream inputStream) {
        return (ArbainexchangeStruct$VerifyByArbaeenNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ArbainexchangeStruct$VerifyByArbaeenNakhodaCode parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ArbainexchangeStruct$VerifyByArbaeenNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ArbainexchangeStruct$VerifyByArbaeenNakhodaCode parseFrom(AbstractC2384h abstractC2384h) {
        return (ArbainexchangeStruct$VerifyByArbaeenNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ArbainexchangeStruct$VerifyByArbaeenNakhodaCode parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ArbainexchangeStruct$VerifyByArbaeenNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

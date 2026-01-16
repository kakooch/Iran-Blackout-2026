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
public final class EvexStruct$VerifyByNakhodaCode extends GeneratedMessageLite implements U64 {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final EvexStruct$VerifyByNakhodaCode DEFAULT_INSTANCE;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private String code_ = "";
    private String nationalCode_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(EvexStruct$VerifyByNakhodaCode.DEFAULT_INSTANCE);
        }
    }

    static {
        EvexStruct$VerifyByNakhodaCode evexStruct$VerifyByNakhodaCode = new EvexStruct$VerifyByNakhodaCode();
        DEFAULT_INSTANCE = evexStruct$VerifyByNakhodaCode;
        GeneratedMessageLite.registerDefaultInstance(EvexStruct$VerifyByNakhodaCode.class, evexStruct$VerifyByNakhodaCode);
    }

    private EvexStruct$VerifyByNakhodaCode() {
    }

    private void clearCode() {
        this.code_ = getDefaultInstance().getCode();
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    public static EvexStruct$VerifyByNakhodaCode getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EvexStruct$VerifyByNakhodaCode parseDelimitedFrom(InputStream inputStream) {
        return (EvexStruct$VerifyByNakhodaCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexStruct$VerifyByNakhodaCode parseFrom(ByteBuffer byteBuffer) {
        return (EvexStruct$VerifyByNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
        switch (T.a[gVar.ordinal()]) {
            case 1:
                return new EvexStruct$VerifyByNakhodaCode();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"code_", "nationalCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EvexStruct$VerifyByNakhodaCode.class) {
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

    public static a newBuilder(EvexStruct$VerifyByNakhodaCode evexStruct$VerifyByNakhodaCode) {
        return (a) DEFAULT_INSTANCE.createBuilder(evexStruct$VerifyByNakhodaCode);
    }

    public static EvexStruct$VerifyByNakhodaCode parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexStruct$VerifyByNakhodaCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexStruct$VerifyByNakhodaCode parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EvexStruct$VerifyByNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EvexStruct$VerifyByNakhodaCode parseFrom(AbstractC2383g abstractC2383g) {
        return (EvexStruct$VerifyByNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static EvexStruct$VerifyByNakhodaCode parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EvexStruct$VerifyByNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EvexStruct$VerifyByNakhodaCode parseFrom(byte[] bArr) {
        return (EvexStruct$VerifyByNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EvexStruct$VerifyByNakhodaCode parseFrom(byte[] bArr, C2394s c2394s) {
        return (EvexStruct$VerifyByNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EvexStruct$VerifyByNakhodaCode parseFrom(InputStream inputStream) {
        return (EvexStruct$VerifyByNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexStruct$VerifyByNakhodaCode parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexStruct$VerifyByNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexStruct$VerifyByNakhodaCode parseFrom(AbstractC2384h abstractC2384h) {
        return (EvexStruct$VerifyByNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EvexStruct$VerifyByNakhodaCode parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EvexStruct$VerifyByNakhodaCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

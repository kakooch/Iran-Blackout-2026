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
public final class PassportStruct$PassportRegexValidation extends GeneratedMessageLite implements U64 {
    private static final PassportStruct$PassportRegexValidation DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REGEX_FIELD_NUMBER = 1;
    private String regex_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PassportStruct$PassportRegexValidation.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportStruct$PassportRegexValidation passportStruct$PassportRegexValidation = new PassportStruct$PassportRegexValidation();
        DEFAULT_INSTANCE = passportStruct$PassportRegexValidation;
        GeneratedMessageLite.registerDefaultInstance(PassportStruct$PassportRegexValidation.class, passportStruct$PassportRegexValidation);
    }

    private PassportStruct$PassportRegexValidation() {
    }

    private void clearRegex() {
        this.regex_ = getDefaultInstance().getRegex();
    }

    public static PassportStruct$PassportRegexValidation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportStruct$PassportRegexValidation parseDelimitedFrom(InputStream inputStream) {
        return (PassportStruct$PassportRegexValidation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportStruct$PassportRegexValidation parseFrom(ByteBuffer byteBuffer) {
        return (PassportStruct$PassportRegexValidation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setRegex(String str) {
        str.getClass();
        this.regex_ = str;
    }

    private void setRegexBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.regex_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Z0.a[gVar.ordinal()]) {
            case 1:
                return new PassportStruct$PassportRegexValidation();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"regex_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportStruct$PassportRegexValidation.class) {
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

    public String getRegex() {
        return this.regex_;
    }

    public AbstractC2383g getRegexBytes() {
        return AbstractC2383g.N(this.regex_);
    }

    public static a newBuilder(PassportStruct$PassportRegexValidation passportStruct$PassportRegexValidation) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportStruct$PassportRegexValidation);
    }

    public static PassportStruct$PassportRegexValidation parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportStruct$PassportRegexValidation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportStruct$PassportRegexValidation parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportStruct$PassportRegexValidation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportStruct$PassportRegexValidation parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportStruct$PassportRegexValidation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PassportStruct$PassportRegexValidation parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportStruct$PassportRegexValidation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportStruct$PassportRegexValidation parseFrom(byte[] bArr) {
        return (PassportStruct$PassportRegexValidation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportStruct$PassportRegexValidation parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportStruct$PassportRegexValidation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportStruct$PassportRegexValidation parseFrom(InputStream inputStream) {
        return (PassportStruct$PassportRegexValidation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportStruct$PassportRegexValidation parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportStruct$PassportRegexValidation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportStruct$PassportRegexValidation parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportStruct$PassportRegexValidation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportStruct$PassportRegexValidation parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportStruct$PassportRegexValidation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

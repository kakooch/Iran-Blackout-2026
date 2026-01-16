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
public final class OmreOuterClass$RequestGetUserOmreIcmsInfo extends GeneratedMessageLite implements U64 {
    public static final int BIRTH_DATE_FIELD_NUMBER = 2;
    private static final OmreOuterClass$RequestGetUserOmreIcmsInfo DEFAULT_INSTANCE;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String nationalCode_ = "";
    private String birthDate_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(OmreOuterClass$RequestGetUserOmreIcmsInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        OmreOuterClass$RequestGetUserOmreIcmsInfo omreOuterClass$RequestGetUserOmreIcmsInfo = new OmreOuterClass$RequestGetUserOmreIcmsInfo();
        DEFAULT_INSTANCE = omreOuterClass$RequestGetUserOmreIcmsInfo;
        GeneratedMessageLite.registerDefaultInstance(OmreOuterClass$RequestGetUserOmreIcmsInfo.class, omreOuterClass$RequestGetUserOmreIcmsInfo);
    }

    private OmreOuterClass$RequestGetUserOmreIcmsInfo() {
    }

    private void clearBirthDate() {
        this.birthDate_ = getDefaultInstance().getBirthDate();
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    public static OmreOuterClass$RequestGetUserOmreIcmsInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static OmreOuterClass$RequestGetUserOmreIcmsInfo parseDelimitedFrom(InputStream inputStream) {
        return (OmreOuterClass$RequestGetUserOmreIcmsInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$RequestGetUserOmreIcmsInfo parseFrom(ByteBuffer byteBuffer) {
        return (OmreOuterClass$RequestGetUserOmreIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBirthDate(String str) {
        str.getClass();
        this.birthDate_ = str;
    }

    private void setBirthDateBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.birthDate_ = abstractC2383g.f0();
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
        switch (U0.a[gVar.ordinal()]) {
            case 1:
                return new OmreOuterClass$RequestGetUserOmreIcmsInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"nationalCode_", "birthDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OmreOuterClass$RequestGetUserOmreIcmsInfo.class) {
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

    public String getBirthDate() {
        return this.birthDate_;
    }

    public AbstractC2383g getBirthDateBytes() {
        return AbstractC2383g.N(this.birthDate_);
    }

    public String getNationalCode() {
        return this.nationalCode_;
    }

    public AbstractC2383g getNationalCodeBytes() {
        return AbstractC2383g.N(this.nationalCode_);
    }

    public static a newBuilder(OmreOuterClass$RequestGetUserOmreIcmsInfo omreOuterClass$RequestGetUserOmreIcmsInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(omreOuterClass$RequestGetUserOmreIcmsInfo);
    }

    public static OmreOuterClass$RequestGetUserOmreIcmsInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$RequestGetUserOmreIcmsInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$RequestGetUserOmreIcmsInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OmreOuterClass$RequestGetUserOmreIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OmreOuterClass$RequestGetUserOmreIcmsInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (OmreOuterClass$RequestGetUserOmreIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static OmreOuterClass$RequestGetUserOmreIcmsInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OmreOuterClass$RequestGetUserOmreIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OmreOuterClass$RequestGetUserOmreIcmsInfo parseFrom(byte[] bArr) {
        return (OmreOuterClass$RequestGetUserOmreIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OmreOuterClass$RequestGetUserOmreIcmsInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (OmreOuterClass$RequestGetUserOmreIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OmreOuterClass$RequestGetUserOmreIcmsInfo parseFrom(InputStream inputStream) {
        return (OmreOuterClass$RequestGetUserOmreIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$RequestGetUserOmreIcmsInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$RequestGetUserOmreIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$RequestGetUserOmreIcmsInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (OmreOuterClass$RequestGetUserOmreIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OmreOuterClass$RequestGetUserOmreIcmsInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OmreOuterClass$RequestGetUserOmreIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

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
public final class ExchangeOuterClass$RequestGetUserIcmsInfo extends GeneratedMessageLite implements U64 {
    public static final int BIRTH_DATE_FIELD_NUMBER = 2;
    private static final ExchangeOuterClass$RequestGetUserIcmsInfo DEFAULT_INSTANCE;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String nationalCode_ = "";
    private String birthDate_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ExchangeOuterClass$RequestGetUserIcmsInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        ExchangeOuterClass$RequestGetUserIcmsInfo exchangeOuterClass$RequestGetUserIcmsInfo = new ExchangeOuterClass$RequestGetUserIcmsInfo();
        DEFAULT_INSTANCE = exchangeOuterClass$RequestGetUserIcmsInfo;
        GeneratedMessageLite.registerDefaultInstance(ExchangeOuterClass$RequestGetUserIcmsInfo.class, exchangeOuterClass$RequestGetUserIcmsInfo);
    }

    private ExchangeOuterClass$RequestGetUserIcmsInfo() {
    }

    private void clearBirthDate() {
        this.birthDate_ = getDefaultInstance().getBirthDate();
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    public static ExchangeOuterClass$RequestGetUserIcmsInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ExchangeOuterClass$RequestGetUserIcmsInfo parseDelimitedFrom(InputStream inputStream) {
        return (ExchangeOuterClass$RequestGetUserIcmsInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$RequestGetUserIcmsInfo parseFrom(ByteBuffer byteBuffer) {
        return (ExchangeOuterClass$RequestGetUserIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
        switch (U.a[gVar.ordinal()]) {
            case 1:
                return new ExchangeOuterClass$RequestGetUserIcmsInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"nationalCode_", "birthDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ExchangeOuterClass$RequestGetUserIcmsInfo.class) {
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

    public static a newBuilder(ExchangeOuterClass$RequestGetUserIcmsInfo exchangeOuterClass$RequestGetUserIcmsInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(exchangeOuterClass$RequestGetUserIcmsInfo);
    }

    public static ExchangeOuterClass$RequestGetUserIcmsInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetUserIcmsInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$RequestGetUserIcmsInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetUserIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ExchangeOuterClass$RequestGetUserIcmsInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (ExchangeOuterClass$RequestGetUserIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ExchangeOuterClass$RequestGetUserIcmsInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetUserIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ExchangeOuterClass$RequestGetUserIcmsInfo parseFrom(byte[] bArr) {
        return (ExchangeOuterClass$RequestGetUserIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ExchangeOuterClass$RequestGetUserIcmsInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetUserIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ExchangeOuterClass$RequestGetUserIcmsInfo parseFrom(InputStream inputStream) {
        return (ExchangeOuterClass$RequestGetUserIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$RequestGetUserIcmsInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetUserIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$RequestGetUserIcmsInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (ExchangeOuterClass$RequestGetUserIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ExchangeOuterClass$RequestGetUserIcmsInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetUserIcmsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

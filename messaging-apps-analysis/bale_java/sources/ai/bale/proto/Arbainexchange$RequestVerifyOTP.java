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
public final class Arbainexchange$RequestVerifyOTP extends GeneratedMessageLite implements U64 {
    public static final int CODE_FIELD_NUMBER = 2;
    private static final Arbainexchange$RequestVerifyOTP DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PHONENUMBER_FIELD_NUMBER = 1;
    private String phoneNumber_ = "";
    private String code_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$RequestVerifyOTP.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$RequestVerifyOTP arbainexchange$RequestVerifyOTP = new Arbainexchange$RequestVerifyOTP();
        DEFAULT_INSTANCE = arbainexchange$RequestVerifyOTP;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$RequestVerifyOTP.class, arbainexchange$RequestVerifyOTP);
    }

    private Arbainexchange$RequestVerifyOTP() {
    }

    private void clearCode() {
        this.code_ = getDefaultInstance().getCode();
    }

    private void clearPhoneNumber() {
        this.phoneNumber_ = getDefaultInstance().getPhoneNumber();
    }

    public static Arbainexchange$RequestVerifyOTP getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$RequestVerifyOTP parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$RequestVerifyOTP) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestVerifyOTP parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$RequestVerifyOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setPhoneNumber(String str) {
        str.getClass();
        this.phoneNumber_ = str;
    }

    private void setPhoneNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.phoneNumber_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$RequestVerifyOTP();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"phoneNumber_", "code_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$RequestVerifyOTP.class) {
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

    public String getPhoneNumber() {
        return this.phoneNumber_;
    }

    public AbstractC2383g getPhoneNumberBytes() {
        return AbstractC2383g.N(this.phoneNumber_);
    }

    public static a newBuilder(Arbainexchange$RequestVerifyOTP arbainexchange$RequestVerifyOTP) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$RequestVerifyOTP);
    }

    public static Arbainexchange$RequestVerifyOTP parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestVerifyOTP) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestVerifyOTP parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$RequestVerifyOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$RequestVerifyOTP parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$RequestVerifyOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Arbainexchange$RequestVerifyOTP parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$RequestVerifyOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$RequestVerifyOTP parseFrom(byte[] bArr) {
        return (Arbainexchange$RequestVerifyOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$RequestVerifyOTP parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$RequestVerifyOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$RequestVerifyOTP parseFrom(InputStream inputStream) {
        return (Arbainexchange$RequestVerifyOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestVerifyOTP parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestVerifyOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestVerifyOTP parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$RequestVerifyOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$RequestVerifyOTP parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$RequestVerifyOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

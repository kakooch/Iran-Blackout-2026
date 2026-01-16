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
public final class ReferralOuterClass$ResponseGetReferralCode extends GeneratedMessageLite implements U64 {
    private static final ReferralOuterClass$ResponseGetReferralCode DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REFERRAL_CODE_FIELD_NUMBER = 1;
    private String referralCode_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ReferralOuterClass$ResponseGetReferralCode.DEFAULT_INSTANCE);
        }
    }

    static {
        ReferralOuterClass$ResponseGetReferralCode referralOuterClass$ResponseGetReferralCode = new ReferralOuterClass$ResponseGetReferralCode();
        DEFAULT_INSTANCE = referralOuterClass$ResponseGetReferralCode;
        GeneratedMessageLite.registerDefaultInstance(ReferralOuterClass$ResponseGetReferralCode.class, referralOuterClass$ResponseGetReferralCode);
    }

    private ReferralOuterClass$ResponseGetReferralCode() {
    }

    private void clearReferralCode() {
        this.referralCode_ = getDefaultInstance().getReferralCode();
    }

    public static ReferralOuterClass$ResponseGetReferralCode getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ReferralOuterClass$ResponseGetReferralCode parseDelimitedFrom(InputStream inputStream) {
        return (ReferralOuterClass$ResponseGetReferralCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReferralOuterClass$ResponseGetReferralCode parseFrom(ByteBuffer byteBuffer) {
        return (ReferralOuterClass$ResponseGetReferralCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setReferralCode(String str) {
        str.getClass();
        this.referralCode_ = str;
    }

    private void setReferralCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.referralCode_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1898u1.a[gVar.ordinal()]) {
            case 1:
                return new ReferralOuterClass$ResponseGetReferralCode();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"referralCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ReferralOuterClass$ResponseGetReferralCode.class) {
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

    public String getReferralCode() {
        return this.referralCode_;
    }

    public AbstractC2383g getReferralCodeBytes() {
        return AbstractC2383g.N(this.referralCode_);
    }

    public static a newBuilder(ReferralOuterClass$ResponseGetReferralCode referralOuterClass$ResponseGetReferralCode) {
        return (a) DEFAULT_INSTANCE.createBuilder(referralOuterClass$ResponseGetReferralCode);
    }

    public static ReferralOuterClass$ResponseGetReferralCode parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ReferralOuterClass$ResponseGetReferralCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReferralOuterClass$ResponseGetReferralCode parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ReferralOuterClass$ResponseGetReferralCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ReferralOuterClass$ResponseGetReferralCode parseFrom(AbstractC2383g abstractC2383g) {
        return (ReferralOuterClass$ResponseGetReferralCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ReferralOuterClass$ResponseGetReferralCode parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ReferralOuterClass$ResponseGetReferralCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ReferralOuterClass$ResponseGetReferralCode parseFrom(byte[] bArr) {
        return (ReferralOuterClass$ResponseGetReferralCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ReferralOuterClass$ResponseGetReferralCode parseFrom(byte[] bArr, C2394s c2394s) {
        return (ReferralOuterClass$ResponseGetReferralCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ReferralOuterClass$ResponseGetReferralCode parseFrom(InputStream inputStream) {
        return (ReferralOuterClass$ResponseGetReferralCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReferralOuterClass$ResponseGetReferralCode parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ReferralOuterClass$ResponseGetReferralCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReferralOuterClass$ResponseGetReferralCode parseFrom(AbstractC2384h abstractC2384h) {
        return (ReferralOuterClass$ResponseGetReferralCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ReferralOuterClass$ResponseGetReferralCode parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ReferralOuterClass$ResponseGetReferralCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

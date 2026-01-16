package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC14053hG5;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class RamzOuterClass$RequestValidateOTP extends GeneratedMessageLite implements U64 {
    private static final RamzOuterClass$RequestValidateOTP DEFAULT_INSTANCE;
    public static final int OTP_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SERVICES_TYPE_FIELD_NUMBER = 2;
    private int otp_;
    private int servicesType_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((RamzOuterClass$RequestValidateOTP) this.b).setOtp(i);
            return this;
        }

        public a B(EnumC14053hG5 enumC14053hG5) {
            q();
            ((RamzOuterClass$RequestValidateOTP) this.b).setServicesType(enumC14053hG5);
            return this;
        }

        private a() {
            super(RamzOuterClass$RequestValidateOTP.DEFAULT_INSTANCE);
        }
    }

    static {
        RamzOuterClass$RequestValidateOTP ramzOuterClass$RequestValidateOTP = new RamzOuterClass$RequestValidateOTP();
        DEFAULT_INSTANCE = ramzOuterClass$RequestValidateOTP;
        GeneratedMessageLite.registerDefaultInstance(RamzOuterClass$RequestValidateOTP.class, ramzOuterClass$RequestValidateOTP);
    }

    private RamzOuterClass$RequestValidateOTP() {
    }

    private void clearOtp() {
        this.otp_ = 0;
    }

    private void clearServicesType() {
        this.servicesType_ = 0;
    }

    public static RamzOuterClass$RequestValidateOTP getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static RamzOuterClass$RequestValidateOTP parseDelimitedFrom(InputStream inputStream) {
        return (RamzOuterClass$RequestValidateOTP) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RamzOuterClass$RequestValidateOTP parseFrom(ByteBuffer byteBuffer) {
        return (RamzOuterClass$RequestValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOtp(int i) {
        this.otp_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServicesType(EnumC14053hG5 enumC14053hG5) {
        this.servicesType_ = enumC14053hG5.getNumber();
    }

    private void setServicesTypeValue(int i) {
        this.servicesType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1887q1.a[gVar.ordinal()]) {
            case 1:
                return new RamzOuterClass$RequestValidateOTP();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\f", new Object[]{"otp_", "servicesType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (RamzOuterClass$RequestValidateOTP.class) {
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

    public int getOtp() {
        return this.otp_;
    }

    public EnumC14053hG5 getServicesType() {
        EnumC14053hG5 enumC14053hG5J = EnumC14053hG5.j(this.servicesType_);
        return enumC14053hG5J == null ? EnumC14053hG5.UNRECOGNIZED : enumC14053hG5J;
    }

    public int getServicesTypeValue() {
        return this.servicesType_;
    }

    public static a newBuilder(RamzOuterClass$RequestValidateOTP ramzOuterClass$RequestValidateOTP) {
        return (a) DEFAULT_INSTANCE.createBuilder(ramzOuterClass$RequestValidateOTP);
    }

    public static RamzOuterClass$RequestValidateOTP parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (RamzOuterClass$RequestValidateOTP) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RamzOuterClass$RequestValidateOTP parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (RamzOuterClass$RequestValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static RamzOuterClass$RequestValidateOTP parseFrom(AbstractC2383g abstractC2383g) {
        return (RamzOuterClass$RequestValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static RamzOuterClass$RequestValidateOTP parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (RamzOuterClass$RequestValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static RamzOuterClass$RequestValidateOTP parseFrom(byte[] bArr) {
        return (RamzOuterClass$RequestValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RamzOuterClass$RequestValidateOTP parseFrom(byte[] bArr, C2394s c2394s) {
        return (RamzOuterClass$RequestValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static RamzOuterClass$RequestValidateOTP parseFrom(InputStream inputStream) {
        return (RamzOuterClass$RequestValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RamzOuterClass$RequestValidateOTP parseFrom(InputStream inputStream, C2394s c2394s) {
        return (RamzOuterClass$RequestValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RamzOuterClass$RequestValidateOTP parseFrom(AbstractC2384h abstractC2384h) {
        return (RamzOuterClass$RequestValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static RamzOuterClass$RequestValidateOTP parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (RamzOuterClass$RequestValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

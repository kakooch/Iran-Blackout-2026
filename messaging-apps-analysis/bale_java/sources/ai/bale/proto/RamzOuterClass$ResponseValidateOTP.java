package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class RamzOuterClass$ResponseValidateOTP extends GeneratedMessageLite implements U64 {
    private static final RamzOuterClass$ResponseValidateOTP DEFAULT_INSTANCE;
    public static final int OTP_VALID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private boolean otpValid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(RamzOuterClass$ResponseValidateOTP.DEFAULT_INSTANCE);
        }
    }

    static {
        RamzOuterClass$ResponseValidateOTP ramzOuterClass$ResponseValidateOTP = new RamzOuterClass$ResponseValidateOTP();
        DEFAULT_INSTANCE = ramzOuterClass$ResponseValidateOTP;
        GeneratedMessageLite.registerDefaultInstance(RamzOuterClass$ResponseValidateOTP.class, ramzOuterClass$ResponseValidateOTP);
    }

    private RamzOuterClass$ResponseValidateOTP() {
    }

    private void clearOtpValid() {
        this.otpValid_ = false;
    }

    public static RamzOuterClass$ResponseValidateOTP getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static RamzOuterClass$ResponseValidateOTP parseDelimitedFrom(InputStream inputStream) {
        return (RamzOuterClass$ResponseValidateOTP) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RamzOuterClass$ResponseValidateOTP parseFrom(ByteBuffer byteBuffer) {
        return (RamzOuterClass$ResponseValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOtpValid(boolean z) {
        this.otpValid_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1887q1.a[gVar.ordinal()]) {
            case 1:
                return new RamzOuterClass$ResponseValidateOTP();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"otpValid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (RamzOuterClass$ResponseValidateOTP.class) {
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

    public boolean getOtpValid() {
        return this.otpValid_;
    }

    public static a newBuilder(RamzOuterClass$ResponseValidateOTP ramzOuterClass$ResponseValidateOTP) {
        return (a) DEFAULT_INSTANCE.createBuilder(ramzOuterClass$ResponseValidateOTP);
    }

    public static RamzOuterClass$ResponseValidateOTP parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (RamzOuterClass$ResponseValidateOTP) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RamzOuterClass$ResponseValidateOTP parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (RamzOuterClass$ResponseValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static RamzOuterClass$ResponseValidateOTP parseFrom(AbstractC2383g abstractC2383g) {
        return (RamzOuterClass$ResponseValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static RamzOuterClass$ResponseValidateOTP parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (RamzOuterClass$ResponseValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static RamzOuterClass$ResponseValidateOTP parseFrom(byte[] bArr) {
        return (RamzOuterClass$ResponseValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RamzOuterClass$ResponseValidateOTP parseFrom(byte[] bArr, C2394s c2394s) {
        return (RamzOuterClass$ResponseValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static RamzOuterClass$ResponseValidateOTP parseFrom(InputStream inputStream) {
        return (RamzOuterClass$ResponseValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RamzOuterClass$ResponseValidateOTP parseFrom(InputStream inputStream, C2394s c2394s) {
        return (RamzOuterClass$ResponseValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RamzOuterClass$ResponseValidateOTP parseFrom(AbstractC2384h abstractC2384h) {
        return (RamzOuterClass$ResponseValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static RamzOuterClass$ResponseValidateOTP parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (RamzOuterClass$ResponseValidateOTP) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

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
public final class RamzOuterClass$RequestDeletePassword extends GeneratedMessageLite implements U64 {
    private static final RamzOuterClass$RequestDeletePassword DEFAULT_INSTANCE;
    public static final int OTP_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int otp_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((RamzOuterClass$RequestDeletePassword) this.b).setOtp(i);
            return this;
        }

        private a() {
            super(RamzOuterClass$RequestDeletePassword.DEFAULT_INSTANCE);
        }
    }

    static {
        RamzOuterClass$RequestDeletePassword ramzOuterClass$RequestDeletePassword = new RamzOuterClass$RequestDeletePassword();
        DEFAULT_INSTANCE = ramzOuterClass$RequestDeletePassword;
        GeneratedMessageLite.registerDefaultInstance(RamzOuterClass$RequestDeletePassword.class, ramzOuterClass$RequestDeletePassword);
    }

    private RamzOuterClass$RequestDeletePassword() {
    }

    private void clearOtp() {
        this.otp_ = 0;
    }

    public static RamzOuterClass$RequestDeletePassword getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static RamzOuterClass$RequestDeletePassword parseDelimitedFrom(InputStream inputStream) {
        return (RamzOuterClass$RequestDeletePassword) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RamzOuterClass$RequestDeletePassword parseFrom(ByteBuffer byteBuffer) {
        return (RamzOuterClass$RequestDeletePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOtp(int i) {
        this.otp_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1887q1.a[gVar.ordinal()]) {
            case 1:
                return new RamzOuterClass$RequestDeletePassword();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"otp_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (RamzOuterClass$RequestDeletePassword.class) {
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

    public static a newBuilder(RamzOuterClass$RequestDeletePassword ramzOuterClass$RequestDeletePassword) {
        return (a) DEFAULT_INSTANCE.createBuilder(ramzOuterClass$RequestDeletePassword);
    }

    public static RamzOuterClass$RequestDeletePassword parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (RamzOuterClass$RequestDeletePassword) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RamzOuterClass$RequestDeletePassword parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (RamzOuterClass$RequestDeletePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static RamzOuterClass$RequestDeletePassword parseFrom(AbstractC2383g abstractC2383g) {
        return (RamzOuterClass$RequestDeletePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static RamzOuterClass$RequestDeletePassword parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (RamzOuterClass$RequestDeletePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static RamzOuterClass$RequestDeletePassword parseFrom(byte[] bArr) {
        return (RamzOuterClass$RequestDeletePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RamzOuterClass$RequestDeletePassword parseFrom(byte[] bArr, C2394s c2394s) {
        return (RamzOuterClass$RequestDeletePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static RamzOuterClass$RequestDeletePassword parseFrom(InputStream inputStream) {
        return (RamzOuterClass$RequestDeletePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RamzOuterClass$RequestDeletePassword parseFrom(InputStream inputStream, C2394s c2394s) {
        return (RamzOuterClass$RequestDeletePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RamzOuterClass$RequestDeletePassword parseFrom(AbstractC2384h abstractC2384h) {
        return (RamzOuterClass$RequestDeletePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static RamzOuterClass$RequestDeletePassword parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (RamzOuterClass$RequestDeletePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

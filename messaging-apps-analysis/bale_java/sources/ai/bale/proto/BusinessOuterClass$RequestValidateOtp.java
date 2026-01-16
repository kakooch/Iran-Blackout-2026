package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessOuterClass$RequestValidateOtp extends GeneratedMessageLite implements U64 {
    private static final BusinessOuterClass$RequestValidateOtp DEFAULT_INSTANCE;
    public static final int OTP_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SIGNUP_SOURCE_FIELD_NUMBER = 4;
    public static final int TRANSACTION_HASH_FIELD_NUMBER = 3;
    public static final int USER_ID_FIELD_NUMBER = 2;
    private int bitField0_;
    private int otp_;
    private StringValue signupSource_;
    private String transactionHash_ = "";
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessOuterClass$RequestValidateOtp.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessOuterClass$RequestValidateOtp businessOuterClass$RequestValidateOtp = new BusinessOuterClass$RequestValidateOtp();
        DEFAULT_INSTANCE = businessOuterClass$RequestValidateOtp;
        GeneratedMessageLite.registerDefaultInstance(BusinessOuterClass$RequestValidateOtp.class, businessOuterClass$RequestValidateOtp);
    }

    private BusinessOuterClass$RequestValidateOtp() {
    }

    private void clearOtp() {
        this.otp_ = 0;
    }

    private void clearSignupSource() {
        this.signupSource_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTransactionHash() {
        this.transactionHash_ = getDefaultInstance().getTransactionHash();
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static BusinessOuterClass$RequestValidateOtp getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeSignupSource(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.signupSource_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.signupSource_ = stringValue;
        } else {
            this.signupSource_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.signupSource_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessOuterClass$RequestValidateOtp parseDelimitedFrom(InputStream inputStream) {
        return (BusinessOuterClass$RequestValidateOtp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$RequestValidateOtp parseFrom(ByteBuffer byteBuffer) {
        return (BusinessOuterClass$RequestValidateOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOtp(int i) {
        this.otp_ = i;
    }

    private void setSignupSource(StringValue stringValue) {
        stringValue.getClass();
        this.signupSource_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setTransactionHash(String str) {
        str.getClass();
        this.transactionHash_ = str;
    }

    private void setTransactionHashBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.transactionHash_ = abstractC2383g.f0();
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1896u.a[gVar.ordinal()]) {
            case 1:
                return new BusinessOuterClass$RequestValidateOtp();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003Ȉ\u0004ဉ\u0000", new Object[]{"bitField0_", "otp_", "userId_", "transactionHash_", "signupSource_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessOuterClass$RequestValidateOtp.class) {
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

    public StringValue getSignupSource() {
        StringValue stringValue = this.signupSource_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getTransactionHash() {
        return this.transactionHash_;
    }

    public AbstractC2383g getTransactionHashBytes() {
        return AbstractC2383g.N(this.transactionHash_);
    }

    public int getUserId() {
        return this.userId_;
    }

    public boolean hasSignupSource() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BusinessOuterClass$RequestValidateOtp businessOuterClass$RequestValidateOtp) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessOuterClass$RequestValidateOtp);
    }

    public static BusinessOuterClass$RequestValidateOtp parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$RequestValidateOtp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$RequestValidateOtp parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessOuterClass$RequestValidateOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessOuterClass$RequestValidateOtp parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessOuterClass$RequestValidateOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessOuterClass$RequestValidateOtp parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessOuterClass$RequestValidateOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessOuterClass$RequestValidateOtp parseFrom(byte[] bArr) {
        return (BusinessOuterClass$RequestValidateOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessOuterClass$RequestValidateOtp parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessOuterClass$RequestValidateOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessOuterClass$RequestValidateOtp parseFrom(InputStream inputStream) {
        return (BusinessOuterClass$RequestValidateOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$RequestValidateOtp parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$RequestValidateOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$RequestValidateOtp parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessOuterClass$RequestValidateOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessOuterClass$RequestValidateOtp parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessOuterClass$RequestValidateOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

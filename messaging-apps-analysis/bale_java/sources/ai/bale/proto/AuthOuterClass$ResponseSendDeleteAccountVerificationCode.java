package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC10305bR;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AuthOuterClass$ResponseSendDeleteAccountVerificationCode extends GeneratedMessageLite implements U64 {
    public static final int ACTIVATION_TYPE_FIELD_NUMBER = 3;
    private static final AuthOuterClass$ResponseSendDeleteAccountVerificationCode DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRANSACTION_HASH_FIELD_NUMBER = 1;
    private int activationType_;
    private String transactionHash_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AuthOuterClass$ResponseSendDeleteAccountVerificationCode.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$ResponseSendDeleteAccountVerificationCode authOuterClass$ResponseSendDeleteAccountVerificationCode = new AuthOuterClass$ResponseSendDeleteAccountVerificationCode();
        DEFAULT_INSTANCE = authOuterClass$ResponseSendDeleteAccountVerificationCode;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$ResponseSendDeleteAccountVerificationCode.class, authOuterClass$ResponseSendDeleteAccountVerificationCode);
    }

    private AuthOuterClass$ResponseSendDeleteAccountVerificationCode() {
    }

    private void clearActivationType() {
        this.activationType_ = 0;
    }

    private void clearTransactionHash() {
        this.transactionHash_ = getDefaultInstance().getTransactionHash();
    }

    public static AuthOuterClass$ResponseSendDeleteAccountVerificationCode getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$ResponseSendDeleteAccountVerificationCode parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$ResponseSendDeleteAccountVerificationCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$ResponseSendDeleteAccountVerificationCode parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$ResponseSendDeleteAccountVerificationCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setActivationType(EnumC10305bR enumC10305bR) {
        this.activationType_ = enumC10305bR.getNumber();
    }

    private void setActivationTypeValue(int i) {
        this.activationType_ = i;
    }

    private void setTransactionHash(String str) {
        str.getClass();
        this.transactionHash_ = str;
    }

    private void setTransactionHashBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.transactionHash_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$ResponseSendDeleteAccountVerificationCode();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001Ȉ\u0003\f", new Object[]{"transactionHash_", "activationType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$ResponseSendDeleteAccountVerificationCode.class) {
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

    public EnumC10305bR getActivationType() {
        EnumC10305bR enumC10305bRJ = EnumC10305bR.j(this.activationType_);
        return enumC10305bRJ == null ? EnumC10305bR.UNRECOGNIZED : enumC10305bRJ;
    }

    public int getActivationTypeValue() {
        return this.activationType_;
    }

    public String getTransactionHash() {
        return this.transactionHash_;
    }

    public AbstractC2383g getTransactionHashBytes() {
        return AbstractC2383g.N(this.transactionHash_);
    }

    public static a newBuilder(AuthOuterClass$ResponseSendDeleteAccountVerificationCode authOuterClass$ResponseSendDeleteAccountVerificationCode) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$ResponseSendDeleteAccountVerificationCode);
    }

    public static AuthOuterClass$ResponseSendDeleteAccountVerificationCode parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$ResponseSendDeleteAccountVerificationCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$ResponseSendDeleteAccountVerificationCode parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$ResponseSendDeleteAccountVerificationCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$ResponseSendDeleteAccountVerificationCode parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$ResponseSendDeleteAccountVerificationCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$ResponseSendDeleteAccountVerificationCode parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$ResponseSendDeleteAccountVerificationCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$ResponseSendDeleteAccountVerificationCode parseFrom(byte[] bArr) {
        return (AuthOuterClass$ResponseSendDeleteAccountVerificationCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$ResponseSendDeleteAccountVerificationCode parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$ResponseSendDeleteAccountVerificationCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$ResponseSendDeleteAccountVerificationCode parseFrom(InputStream inputStream) {
        return (AuthOuterClass$ResponseSendDeleteAccountVerificationCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$ResponseSendDeleteAccountVerificationCode parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$ResponseSendDeleteAccountVerificationCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$ResponseSendDeleteAccountVerificationCode parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$ResponseSendDeleteAccountVerificationCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$ResponseSendDeleteAccountVerificationCode parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$ResponseSendDeleteAccountVerificationCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

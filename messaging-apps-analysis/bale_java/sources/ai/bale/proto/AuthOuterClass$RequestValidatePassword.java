package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AuthOuterClass$RequestValidatePassword extends GeneratedMessageLite implements U64 {
    private static final AuthOuterClass$RequestValidatePassword DEFAULT_INSTANCE;
    public static final int IS_JWT_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PASSWORD_FIELD_NUMBER = 2;
    public static final int TRANSACTION_HASH_FIELD_NUMBER = 1;
    private int bitField0_;
    private BoolValue isJwt_;
    private String transactionHash_ = "";
    private String password_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((AuthOuterClass$RequestValidatePassword) this.b).setPassword(str);
            return this;
        }

        public a B(String str) {
            q();
            ((AuthOuterClass$RequestValidatePassword) this.b).setTransactionHash(str);
            return this;
        }

        private a() {
            super(AuthOuterClass$RequestValidatePassword.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$RequestValidatePassword authOuterClass$RequestValidatePassword = new AuthOuterClass$RequestValidatePassword();
        DEFAULT_INSTANCE = authOuterClass$RequestValidatePassword;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$RequestValidatePassword.class, authOuterClass$RequestValidatePassword);
    }

    private AuthOuterClass$RequestValidatePassword() {
    }

    private void clearIsJwt() {
        this.isJwt_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPassword() {
        this.password_ = getDefaultInstance().getPassword();
    }

    private void clearTransactionHash() {
        this.transactionHash_ = getDefaultInstance().getTransactionHash();
    }

    public static AuthOuterClass$RequestValidatePassword getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeIsJwt(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isJwt_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isJwt_ = boolValue;
        } else {
            this.isJwt_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isJwt_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$RequestValidatePassword parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestValidatePassword) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestValidatePassword parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$RequestValidatePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsJwt(BoolValue boolValue) {
        boolValue.getClass();
        this.isJwt_ = boolValue;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPassword(String str) {
        str.getClass();
        this.password_ = str;
    }

    private void setPasswordBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.password_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransactionHash(String str) {
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
                return new AuthOuterClass$RequestValidatePassword();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003ဉ\u0000", new Object[]{"bitField0_", "transactionHash_", "password_", "isJwt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$RequestValidatePassword.class) {
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

    public BoolValue getIsJwt() {
        BoolValue boolValue = this.isJwt_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public String getPassword() {
        return this.password_;
    }

    public AbstractC2383g getPasswordBytes() {
        return AbstractC2383g.N(this.password_);
    }

    public String getTransactionHash() {
        return this.transactionHash_;
    }

    public AbstractC2383g getTransactionHashBytes() {
        return AbstractC2383g.N(this.transactionHash_);
    }

    public boolean hasIsJwt() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AuthOuterClass$RequestValidatePassword authOuterClass$RequestValidatePassword) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$RequestValidatePassword);
    }

    public static AuthOuterClass$RequestValidatePassword parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestValidatePassword) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestValidatePassword parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$RequestValidatePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$RequestValidatePassword parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$RequestValidatePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$RequestValidatePassword parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$RequestValidatePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$RequestValidatePassword parseFrom(byte[] bArr) {
        return (AuthOuterClass$RequestValidatePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$RequestValidatePassword parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$RequestValidatePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$RequestValidatePassword parseFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestValidatePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestValidatePassword parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestValidatePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestValidatePassword parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$RequestValidatePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$RequestValidatePassword parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$RequestValidatePassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KM7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AuthOuterClass$RequestSignUp extends GeneratedMessageLite implements U64 {
    private static final AuthOuterClass$RequestSignUp DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PASSWORD_FIELD_NUMBER = 4;
    public static final int SEX_FIELD_NUMBER = 3;
    public static final int TRANSACTION_HASH_FIELD_NUMBER = 1;
    private int bitField0_;
    private StringValue password_;
    private int sex_;
    private String transactionHash_ = "";
    private String name_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((AuthOuterClass$RequestSignUp) this.b).setName(str);
            return this;
        }

        public a B(KM7 km7) {
            q();
            ((AuthOuterClass$RequestSignUp) this.b).setSex(km7);
            return this;
        }

        public a C(String str) {
            q();
            ((AuthOuterClass$RequestSignUp) this.b).setTransactionHash(str);
            return this;
        }

        private a() {
            super(AuthOuterClass$RequestSignUp.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$RequestSignUp authOuterClass$RequestSignUp = new AuthOuterClass$RequestSignUp();
        DEFAULT_INSTANCE = authOuterClass$RequestSignUp;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$RequestSignUp.class, authOuterClass$RequestSignUp);
    }

    private AuthOuterClass$RequestSignUp() {
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearPassword() {
        this.password_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSex() {
        this.sex_ = 0;
    }

    private void clearTransactionHash() {
        this.transactionHash_ = getDefaultInstance().getTransactionHash();
    }

    public static AuthOuterClass$RequestSignUp getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePassword(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.password_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.password_ = stringValue;
        } else {
            this.password_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.password_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$RequestSignUp parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestSignUp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestSignUp parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$RequestSignUp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    private void setPassword(StringValue stringValue) {
        stringValue.getClass();
        this.password_ = stringValue;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSex(KM7 km7) {
        this.sex_ = km7.getNumber();
    }

    private void setSexValue(int i) {
        this.sex_ = i;
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
                return new AuthOuterClass$RequestSignUp();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\f\u0004ဉ\u0000", new Object[]{"bitField0_", "transactionHash_", "name_", "sex_", "password_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$RequestSignUp.class) {
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

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public StringValue getPassword() {
        StringValue stringValue = this.password_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public KM7 getSex() {
        KM7 km7J = KM7.j(this.sex_);
        return km7J == null ? KM7.UNRECOGNIZED : km7J;
    }

    public int getSexValue() {
        return this.sex_;
    }

    public String getTransactionHash() {
        return this.transactionHash_;
    }

    public AbstractC2383g getTransactionHashBytes() {
        return AbstractC2383g.N(this.transactionHash_);
    }

    public boolean hasPassword() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AuthOuterClass$RequestSignUp authOuterClass$RequestSignUp) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$RequestSignUp);
    }

    public static AuthOuterClass$RequestSignUp parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestSignUp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestSignUp parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$RequestSignUp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$RequestSignUp parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$RequestSignUp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$RequestSignUp parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$RequestSignUp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$RequestSignUp parseFrom(byte[] bArr) {
        return (AuthOuterClass$RequestSignUp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$RequestSignUp parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$RequestSignUp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$RequestSignUp parseFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestSignUp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestSignUp parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestSignUp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestSignUp parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$RequestSignUp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$RequestSignUp parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$RequestSignUp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

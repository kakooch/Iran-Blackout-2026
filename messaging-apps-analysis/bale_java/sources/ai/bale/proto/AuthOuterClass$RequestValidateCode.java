package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class AuthOuterClass$RequestValidateCode extends GeneratedMessageLite implements U64 {
    public static final int CODE_FIELD_NUMBER = 2;
    private static final AuthOuterClass$RequestValidateCode DEFAULT_INSTANCE;
    public static final int FUTURE_AUTH_TOKENS_FIELD_NUMBER = 4;
    public static final int IS_JWT_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TRANSACTION_HASH_FIELD_NUMBER = 1;
    private int bitField0_;
    private BoolValue isJwt_;
    private String transactionHash_ = "";
    private String code_ = "";
    private B.j futureAuthTokens_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((AuthOuterClass$RequestValidateCode) this.b).addAllFutureAuthTokens(iterable);
            return this;
        }

        public a B(String str) {
            q();
            ((AuthOuterClass$RequestValidateCode) this.b).setCode(str);
            return this;
        }

        public a C(BoolValue boolValue) {
            q();
            ((AuthOuterClass$RequestValidateCode) this.b).setIsJwt(boolValue);
            return this;
        }

        public a D(String str) {
            q();
            ((AuthOuterClass$RequestValidateCode) this.b).setTransactionHash(str);
            return this;
        }

        private a() {
            super(AuthOuterClass$RequestValidateCode.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$RequestValidateCode authOuterClass$RequestValidateCode = new AuthOuterClass$RequestValidateCode();
        DEFAULT_INSTANCE = authOuterClass$RequestValidateCode;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$RequestValidateCode.class, authOuterClass$RequestValidateCode);
    }

    private AuthOuterClass$RequestValidateCode() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFutureAuthTokens(Iterable<String> iterable) {
        ensureFutureAuthTokensIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.futureAuthTokens_);
    }

    private void addFutureAuthTokens(String str) {
        str.getClass();
        ensureFutureAuthTokensIsMutable();
        this.futureAuthTokens_.add(str);
    }

    private void addFutureAuthTokensBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureFutureAuthTokensIsMutable();
        this.futureAuthTokens_.add(abstractC2383g.f0());
    }

    private void clearCode() {
        this.code_ = getDefaultInstance().getCode();
    }

    private void clearFutureAuthTokens() {
        this.futureAuthTokens_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearIsJwt() {
        this.isJwt_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTransactionHash() {
        this.transactionHash_ = getDefaultInstance().getTransactionHash();
    }

    private void ensureFutureAuthTokensIsMutable() {
        B.j jVar = this.futureAuthTokens_;
        if (jVar.u()) {
            return;
        }
        this.futureAuthTokens_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AuthOuterClass$RequestValidateCode getDefaultInstance() {
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

    public static AuthOuterClass$RequestValidateCode parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestValidateCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestValidateCode parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$RequestValidateCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCode(String str) {
        str.getClass();
        this.code_ = str;
    }

    private void setCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.code_ = abstractC2383g.f0();
    }

    private void setFutureAuthTokens(int i, String str) {
        str.getClass();
        ensureFutureAuthTokensIsMutable();
        this.futureAuthTokens_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsJwt(BoolValue boolValue) {
        boolValue.getClass();
        this.isJwt_ = boolValue;
        this.bitField0_ |= 1;
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
                return new AuthOuterClass$RequestValidateCode();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003ဉ\u0000\u0004Ț", new Object[]{"bitField0_", "transactionHash_", "code_", "isJwt_", "futureAuthTokens_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$RequestValidateCode.class) {
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

    public String getFutureAuthTokens(int i) {
        return (String) this.futureAuthTokens_.get(i);
    }

    public AbstractC2383g getFutureAuthTokensBytes(int i) {
        return AbstractC2383g.N((String) this.futureAuthTokens_.get(i));
    }

    public int getFutureAuthTokensCount() {
        return this.futureAuthTokens_.size();
    }

    public List<String> getFutureAuthTokensList() {
        return this.futureAuthTokens_;
    }

    public BoolValue getIsJwt() {
        BoolValue boolValue = this.isJwt_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
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

    public static a newBuilder(AuthOuterClass$RequestValidateCode authOuterClass$RequestValidateCode) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$RequestValidateCode);
    }

    public static AuthOuterClass$RequestValidateCode parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestValidateCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestValidateCode parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$RequestValidateCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$RequestValidateCode parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$RequestValidateCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$RequestValidateCode parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$RequestValidateCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$RequestValidateCode parseFrom(byte[] bArr) {
        return (AuthOuterClass$RequestValidateCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$RequestValidateCode parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$RequestValidateCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$RequestValidateCode parseFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestValidateCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestValidateCode parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestValidateCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestValidateCode parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$RequestValidateCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$RequestValidateCode parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$RequestValidateCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

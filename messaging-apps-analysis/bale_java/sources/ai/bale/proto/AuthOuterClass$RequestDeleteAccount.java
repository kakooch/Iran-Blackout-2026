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
public final class AuthOuterClass$RequestDeleteAccount extends GeneratedMessageLite implements U64 {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final AuthOuterClass$RequestDeleteAccount DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRANSACTION_HASH_FIELD_NUMBER = 2;
    private String code_ = "";
    private String transactionHash_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((AuthOuterClass$RequestDeleteAccount) this.b).setCode(str);
            return this;
        }

        public a B(String str) {
            q();
            ((AuthOuterClass$RequestDeleteAccount) this.b).setTransactionHash(str);
            return this;
        }

        private a() {
            super(AuthOuterClass$RequestDeleteAccount.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$RequestDeleteAccount authOuterClass$RequestDeleteAccount = new AuthOuterClass$RequestDeleteAccount();
        DEFAULT_INSTANCE = authOuterClass$RequestDeleteAccount;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$RequestDeleteAccount.class, authOuterClass$RequestDeleteAccount);
    }

    private AuthOuterClass$RequestDeleteAccount() {
    }

    private void clearCode() {
        this.code_ = getDefaultInstance().getCode();
    }

    private void clearTransactionHash() {
        this.transactionHash_ = getDefaultInstance().getTransactionHash();
    }

    public static AuthOuterClass$RequestDeleteAccount getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$RequestDeleteAccount parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestDeleteAccount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestDeleteAccount parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$RequestDeleteAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
                return new AuthOuterClass$RequestDeleteAccount();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"code_", "transactionHash_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$RequestDeleteAccount.class) {
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

    public String getTransactionHash() {
        return this.transactionHash_;
    }

    public AbstractC2383g getTransactionHashBytes() {
        return AbstractC2383g.N(this.transactionHash_);
    }

    public static a newBuilder(AuthOuterClass$RequestDeleteAccount authOuterClass$RequestDeleteAccount) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$RequestDeleteAccount);
    }

    public static AuthOuterClass$RequestDeleteAccount parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestDeleteAccount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestDeleteAccount parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$RequestDeleteAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$RequestDeleteAccount parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$RequestDeleteAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$RequestDeleteAccount parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$RequestDeleteAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$RequestDeleteAccount parseFrom(byte[] bArr) {
        return (AuthOuterClass$RequestDeleteAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$RequestDeleteAccount parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$RequestDeleteAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$RequestDeleteAccount parseFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestDeleteAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestDeleteAccount parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestDeleteAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestDeleteAccount parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$RequestDeleteAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$RequestDeleteAccount parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$RequestDeleteAccount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

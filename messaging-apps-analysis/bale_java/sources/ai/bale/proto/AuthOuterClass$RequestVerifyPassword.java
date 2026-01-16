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
public final class AuthOuterClass$RequestVerifyPassword extends GeneratedMessageLite implements U64 {
    private static final AuthOuterClass$RequestVerifyPassword DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PASSWORD_FIELD_NUMBER = 1;
    private String password_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((AuthOuterClass$RequestVerifyPassword) this.b).setPassword(str);
            return this;
        }

        private a() {
            super(AuthOuterClass$RequestVerifyPassword.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$RequestVerifyPassword authOuterClass$RequestVerifyPassword = new AuthOuterClass$RequestVerifyPassword();
        DEFAULT_INSTANCE = authOuterClass$RequestVerifyPassword;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$RequestVerifyPassword.class, authOuterClass$RequestVerifyPassword);
    }

    private AuthOuterClass$RequestVerifyPassword() {
    }

    private void clearPassword() {
        this.password_ = getDefaultInstance().getPassword();
    }

    public static AuthOuterClass$RequestVerifyPassword getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$RequestVerifyPassword parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestVerifyPassword) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestVerifyPassword parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$RequestVerifyPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$RequestVerifyPassword();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"password_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$RequestVerifyPassword.class) {
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

    public String getPassword() {
        return this.password_;
    }

    public AbstractC2383g getPasswordBytes() {
        return AbstractC2383g.N(this.password_);
    }

    public static a newBuilder(AuthOuterClass$RequestVerifyPassword authOuterClass$RequestVerifyPassword) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$RequestVerifyPassword);
    }

    public static AuthOuterClass$RequestVerifyPassword parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestVerifyPassword) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestVerifyPassword parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$RequestVerifyPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$RequestVerifyPassword parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$RequestVerifyPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$RequestVerifyPassword parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$RequestVerifyPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$RequestVerifyPassword parseFrom(byte[] bArr) {
        return (AuthOuterClass$RequestVerifyPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$RequestVerifyPassword parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$RequestVerifyPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$RequestVerifyPassword parseFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestVerifyPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestVerifyPassword parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestVerifyPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestVerifyPassword parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$RequestVerifyPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$RequestVerifyPassword parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$RequestVerifyPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

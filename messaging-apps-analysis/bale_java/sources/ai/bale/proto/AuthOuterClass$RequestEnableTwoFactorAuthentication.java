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
public final class AuthOuterClass$RequestEnableTwoFactorAuthentication extends GeneratedMessageLite implements U64 {
    private static final AuthOuterClass$RequestEnableTwoFactorAuthentication DEFAULT_INSTANCE;
    public static final int EMAIL_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PASSWORD_FIELD_NUMBER = 2;
    private String email_ = "";
    private String password_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((AuthOuterClass$RequestEnableTwoFactorAuthentication) this.b).setEmail(str);
            return this;
        }

        public a B(String str) {
            q();
            ((AuthOuterClass$RequestEnableTwoFactorAuthentication) this.b).setPassword(str);
            return this;
        }

        private a() {
            super(AuthOuterClass$RequestEnableTwoFactorAuthentication.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$RequestEnableTwoFactorAuthentication authOuterClass$RequestEnableTwoFactorAuthentication = new AuthOuterClass$RequestEnableTwoFactorAuthentication();
        DEFAULT_INSTANCE = authOuterClass$RequestEnableTwoFactorAuthentication;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$RequestEnableTwoFactorAuthentication.class, authOuterClass$RequestEnableTwoFactorAuthentication);
    }

    private AuthOuterClass$RequestEnableTwoFactorAuthentication() {
    }

    private void clearEmail() {
        this.email_ = getDefaultInstance().getEmail();
    }

    private void clearPassword() {
        this.password_ = getDefaultInstance().getPassword();
    }

    public static AuthOuterClass$RequestEnableTwoFactorAuthentication getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$RequestEnableTwoFactorAuthentication parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestEnableTwoFactorAuthentication) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestEnableTwoFactorAuthentication parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$RequestEnableTwoFactorAuthentication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEmail(String str) {
        str.getClass();
        this.email_ = str;
    }

    private void setEmailBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.email_ = abstractC2383g.f0();
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
                return new AuthOuterClass$RequestEnableTwoFactorAuthentication();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"email_", "password_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$RequestEnableTwoFactorAuthentication.class) {
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

    public String getEmail() {
        return this.email_;
    }

    public AbstractC2383g getEmailBytes() {
        return AbstractC2383g.N(this.email_);
    }

    public String getPassword() {
        return this.password_;
    }

    public AbstractC2383g getPasswordBytes() {
        return AbstractC2383g.N(this.password_);
    }

    public static a newBuilder(AuthOuterClass$RequestEnableTwoFactorAuthentication authOuterClass$RequestEnableTwoFactorAuthentication) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$RequestEnableTwoFactorAuthentication);
    }

    public static AuthOuterClass$RequestEnableTwoFactorAuthentication parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestEnableTwoFactorAuthentication) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestEnableTwoFactorAuthentication parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$RequestEnableTwoFactorAuthentication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$RequestEnableTwoFactorAuthentication parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$RequestEnableTwoFactorAuthentication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$RequestEnableTwoFactorAuthentication parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$RequestEnableTwoFactorAuthentication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$RequestEnableTwoFactorAuthentication parseFrom(byte[] bArr) {
        return (AuthOuterClass$RequestEnableTwoFactorAuthentication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$RequestEnableTwoFactorAuthentication parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$RequestEnableTwoFactorAuthentication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$RequestEnableTwoFactorAuthentication parseFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestEnableTwoFactorAuthentication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestEnableTwoFactorAuthentication parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestEnableTwoFactorAuthentication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestEnableTwoFactorAuthentication parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$RequestEnableTwoFactorAuthentication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$RequestEnableTwoFactorAuthentication parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$RequestEnableTwoFactorAuthentication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

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
public final class AuthOuterClass$ResponseRecoverPassword extends GeneratedMessageLite implements U64 {
    private static final AuthOuterClass$ResponseRecoverPassword DEFAULT_INSTANCE;
    public static final int EMAIL_PATTERN_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String emailPattern_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AuthOuterClass$ResponseRecoverPassword.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$ResponseRecoverPassword authOuterClass$ResponseRecoverPassword = new AuthOuterClass$ResponseRecoverPassword();
        DEFAULT_INSTANCE = authOuterClass$ResponseRecoverPassword;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$ResponseRecoverPassword.class, authOuterClass$ResponseRecoverPassword);
    }

    private AuthOuterClass$ResponseRecoverPassword() {
    }

    private void clearEmailPattern() {
        this.emailPattern_ = getDefaultInstance().getEmailPattern();
    }

    public static AuthOuterClass$ResponseRecoverPassword getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$ResponseRecoverPassword parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$ResponseRecoverPassword) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$ResponseRecoverPassword parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$ResponseRecoverPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEmailPattern(String str) {
        str.getClass();
        this.emailPattern_ = str;
    }

    private void setEmailPatternBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.emailPattern_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$ResponseRecoverPassword();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"emailPattern_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$ResponseRecoverPassword.class) {
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

    public String getEmailPattern() {
        return this.emailPattern_;
    }

    public AbstractC2383g getEmailPatternBytes() {
        return AbstractC2383g.N(this.emailPattern_);
    }

    public static a newBuilder(AuthOuterClass$ResponseRecoverPassword authOuterClass$ResponseRecoverPassword) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$ResponseRecoverPassword);
    }

    public static AuthOuterClass$ResponseRecoverPassword parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$ResponseRecoverPassword) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$ResponseRecoverPassword parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$ResponseRecoverPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$ResponseRecoverPassword parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$ResponseRecoverPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$ResponseRecoverPassword parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$ResponseRecoverPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$ResponseRecoverPassword parseFrom(byte[] bArr) {
        return (AuthOuterClass$ResponseRecoverPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$ResponseRecoverPassword parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$ResponseRecoverPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$ResponseRecoverPassword parseFrom(InputStream inputStream) {
        return (AuthOuterClass$ResponseRecoverPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$ResponseRecoverPassword parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$ResponseRecoverPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$ResponseRecoverPassword parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$ResponseRecoverPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$ResponseRecoverPassword parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$ResponseRecoverPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

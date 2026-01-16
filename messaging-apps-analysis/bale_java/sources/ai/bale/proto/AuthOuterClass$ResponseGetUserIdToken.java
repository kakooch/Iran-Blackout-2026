package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC11685dR;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AuthOuterClass$ResponseGetUserIdToken extends GeneratedMessageLite implements U64 {
    private static final AuthOuterClass$ResponseGetUserIdToken DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SERVICE_FIELD_NUMBER = 4;
    public static final int SOURCE_FIELD_NUMBER = 3;
    public static final int TOKEN_FIELD_NUMBER = 1;
    public static final int USER_ID_FIELD_NUMBER = 2;
    private int source_;
    private int userId_;
    private String token_ = "";
    private String service_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AuthOuterClass$ResponseGetUserIdToken.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$ResponseGetUserIdToken authOuterClass$ResponseGetUserIdToken = new AuthOuterClass$ResponseGetUserIdToken();
        DEFAULT_INSTANCE = authOuterClass$ResponseGetUserIdToken;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$ResponseGetUserIdToken.class, authOuterClass$ResponseGetUserIdToken);
    }

    private AuthOuterClass$ResponseGetUserIdToken() {
    }

    private void clearService() {
        this.service_ = getDefaultInstance().getService();
    }

    private void clearSource() {
        this.source_ = 0;
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static AuthOuterClass$ResponseGetUserIdToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$ResponseGetUserIdToken parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$ResponseGetUserIdToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$ResponseGetUserIdToken parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$ResponseGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setService(String str) {
        str.getClass();
        this.service_ = str;
    }

    private void setServiceBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.service_ = abstractC2383g.f0();
    }

    private void setSource(EnumC11685dR enumC11685dR) {
        this.source_ = enumC11685dR.getNumber();
    }

    private void setSourceValue(int i) {
        this.source_ = i;
    }

    private void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    private void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$ResponseGetUserIdToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003\f\u0004Ȉ", new Object[]{"token_", "userId_", "source_", "service_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$ResponseGetUserIdToken.class) {
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

    public String getService() {
        return this.service_;
    }

    public AbstractC2383g getServiceBytes() {
        return AbstractC2383g.N(this.service_);
    }

    public EnumC11685dR getSource() {
        EnumC11685dR enumC11685dRJ = EnumC11685dR.j(this.source_);
        return enumC11685dRJ == null ? EnumC11685dR.UNRECOGNIZED : enumC11685dRJ;
    }

    public int getSourceValue() {
        return this.source_;
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(AuthOuterClass$ResponseGetUserIdToken authOuterClass$ResponseGetUserIdToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$ResponseGetUserIdToken);
    }

    public static AuthOuterClass$ResponseGetUserIdToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetUserIdToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$ResponseGetUserIdToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$ResponseGetUserIdToken parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$ResponseGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$ResponseGetUserIdToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$ResponseGetUserIdToken parseFrom(byte[] bArr) {
        return (AuthOuterClass$ResponseGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$ResponseGetUserIdToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$ResponseGetUserIdToken parseFrom(InputStream inputStream) {
        return (AuthOuterClass$ResponseGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$ResponseGetUserIdToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$ResponseGetUserIdToken parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$ResponseGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$ResponseGetUserIdToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

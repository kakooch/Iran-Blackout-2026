package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.YQ;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class AuthOuterClass$ResponseGetAuthSessions extends GeneratedMessageLite implements U64 {
    private static final AuthOuterClass$ResponseGetAuthSessions DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_AUTHS_FIELD_NUMBER = 1;
    private B.j userAuths_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AuthOuterClass$ResponseGetAuthSessions.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$ResponseGetAuthSessions authOuterClass$ResponseGetAuthSessions = new AuthOuterClass$ResponseGetAuthSessions();
        DEFAULT_INSTANCE = authOuterClass$ResponseGetAuthSessions;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$ResponseGetAuthSessions.class, authOuterClass$ResponseGetAuthSessions);
    }

    private AuthOuterClass$ResponseGetAuthSessions() {
    }

    private void addAllUserAuths(Iterable<? extends AuthStruct$AuthSession> iterable) {
        ensureUserAuthsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userAuths_);
    }

    private void addUserAuths(AuthStruct$AuthSession authStruct$AuthSession) {
        authStruct$AuthSession.getClass();
        ensureUserAuthsIsMutable();
        this.userAuths_.add(authStruct$AuthSession);
    }

    private void clearUserAuths() {
        this.userAuths_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUserAuthsIsMutable() {
        B.j jVar = this.userAuths_;
        if (jVar.u()) {
            return;
        }
        this.userAuths_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AuthOuterClass$ResponseGetAuthSessions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$ResponseGetAuthSessions parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$ResponseGetAuthSessions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$ResponseGetAuthSessions parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$ResponseGetAuthSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUserAuths(int i) {
        ensureUserAuthsIsMutable();
        this.userAuths_.remove(i);
    }

    private void setUserAuths(int i, AuthStruct$AuthSession authStruct$AuthSession) {
        authStruct$AuthSession.getClass();
        ensureUserAuthsIsMutable();
        this.userAuths_.set(i, authStruct$AuthSession);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$ResponseGetAuthSessions();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"userAuths_", AuthStruct$AuthSession.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$ResponseGetAuthSessions.class) {
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

    public AuthStruct$AuthSession getUserAuths(int i) {
        return (AuthStruct$AuthSession) this.userAuths_.get(i);
    }

    public int getUserAuthsCount() {
        return this.userAuths_.size();
    }

    public List<AuthStruct$AuthSession> getUserAuthsList() {
        return this.userAuths_;
    }

    public YQ getUserAuthsOrBuilder(int i) {
        return (YQ) this.userAuths_.get(i);
    }

    public List<? extends YQ> getUserAuthsOrBuilderList() {
        return this.userAuths_;
    }

    public static a newBuilder(AuthOuterClass$ResponseGetAuthSessions authOuterClass$ResponseGetAuthSessions) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$ResponseGetAuthSessions);
    }

    public static AuthOuterClass$ResponseGetAuthSessions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetAuthSessions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$ResponseGetAuthSessions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetAuthSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$ResponseGetAuthSessions parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$ResponseGetAuthSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUserAuths(int i, AuthStruct$AuthSession authStruct$AuthSession) {
        authStruct$AuthSession.getClass();
        ensureUserAuthsIsMutable();
        this.userAuths_.add(i, authStruct$AuthSession);
    }

    public static AuthOuterClass$ResponseGetAuthSessions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetAuthSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$ResponseGetAuthSessions parseFrom(byte[] bArr) {
        return (AuthOuterClass$ResponseGetAuthSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$ResponseGetAuthSessions parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetAuthSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$ResponseGetAuthSessions parseFrom(InputStream inputStream) {
        return (AuthOuterClass$ResponseGetAuthSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$ResponseGetAuthSessions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetAuthSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$ResponseGetAuthSessions parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$ResponseGetAuthSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$ResponseGetAuthSessions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetAuthSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

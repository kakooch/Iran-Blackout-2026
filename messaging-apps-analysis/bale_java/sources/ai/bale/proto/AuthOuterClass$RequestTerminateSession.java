package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AuthOuterClass$RequestTerminateSession extends GeneratedMessageLite implements U64 {
    private static final AuthOuterClass$RequestTerminateSession DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int id_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((AuthOuterClass$RequestTerminateSession) this.b).setId(i);
            return this;
        }

        private a() {
            super(AuthOuterClass$RequestTerminateSession.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$RequestTerminateSession authOuterClass$RequestTerminateSession = new AuthOuterClass$RequestTerminateSession();
        DEFAULT_INSTANCE = authOuterClass$RequestTerminateSession;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$RequestTerminateSession.class, authOuterClass$RequestTerminateSession);
    }

    private AuthOuterClass$RequestTerminateSession() {
    }

    private void clearId() {
        this.id_ = 0;
    }

    public static AuthOuterClass$RequestTerminateSession getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$RequestTerminateSession parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestTerminateSession) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestTerminateSession parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$RequestTerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(int i) {
        this.id_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$RequestTerminateSession();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"id_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$RequestTerminateSession.class) {
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

    public int getId() {
        return this.id_;
    }

    public static a newBuilder(AuthOuterClass$RequestTerminateSession authOuterClass$RequestTerminateSession) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$RequestTerminateSession);
    }

    public static AuthOuterClass$RequestTerminateSession parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestTerminateSession) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestTerminateSession parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$RequestTerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$RequestTerminateSession parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$RequestTerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$RequestTerminateSession parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$RequestTerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$RequestTerminateSession parseFrom(byte[] bArr) {
        return (AuthOuterClass$RequestTerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$RequestTerminateSession parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$RequestTerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$RequestTerminateSession parseFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestTerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestTerminateSession parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestTerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestTerminateSession parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$RequestTerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$RequestTerminateSession parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$RequestTerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

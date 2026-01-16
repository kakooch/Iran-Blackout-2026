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
public final class AuthOuterClass$RequestGetUserIdToken extends GeneratedMessageLite implements U64 {
    private static final AuthOuterClass$RequestGetUserIdToken DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TICKET_FIELD_NUMBER = 1;
    private String ticket_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AuthOuterClass$RequestGetUserIdToken.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$RequestGetUserIdToken authOuterClass$RequestGetUserIdToken = new AuthOuterClass$RequestGetUserIdToken();
        DEFAULT_INSTANCE = authOuterClass$RequestGetUserIdToken;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$RequestGetUserIdToken.class, authOuterClass$RequestGetUserIdToken);
    }

    private AuthOuterClass$RequestGetUserIdToken() {
    }

    private void clearTicket() {
        this.ticket_ = getDefaultInstance().getTicket();
    }

    public static AuthOuterClass$RequestGetUserIdToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$RequestGetUserIdToken parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestGetUserIdToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestGetUserIdToken parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$RequestGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setTicket(String str) {
        str.getClass();
        this.ticket_ = str;
    }

    private void setTicketBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.ticket_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$RequestGetUserIdToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"ticket_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$RequestGetUserIdToken.class) {
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

    public String getTicket() {
        return this.ticket_;
    }

    public AbstractC2383g getTicketBytes() {
        return AbstractC2383g.N(this.ticket_);
    }

    public static a newBuilder(AuthOuterClass$RequestGetUserIdToken authOuterClass$RequestGetUserIdToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$RequestGetUserIdToken);
    }

    public static AuthOuterClass$RequestGetUserIdToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestGetUserIdToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestGetUserIdToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$RequestGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$RequestGetUserIdToken parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$RequestGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$RequestGetUserIdToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$RequestGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$RequestGetUserIdToken parseFrom(byte[] bArr) {
        return (AuthOuterClass$RequestGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$RequestGetUserIdToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$RequestGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$RequestGetUserIdToken parseFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestGetUserIdToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestGetUserIdToken parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$RequestGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$RequestGetUserIdToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$RequestGetUserIdToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

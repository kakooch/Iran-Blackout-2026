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
public final class AuthOuterClass$RequestGetJWTToken extends GeneratedMessageLite implements U64 {
    private static final AuthOuterClass$RequestGetJWTToken DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AuthOuterClass$RequestGetJWTToken.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$RequestGetJWTToken authOuterClass$RequestGetJWTToken = new AuthOuterClass$RequestGetJWTToken();
        DEFAULT_INSTANCE = authOuterClass$RequestGetJWTToken;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$RequestGetJWTToken.class, authOuterClass$RequestGetJWTToken);
    }

    private AuthOuterClass$RequestGetJWTToken() {
    }

    public static AuthOuterClass$RequestGetJWTToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$RequestGetJWTToken parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestGetJWTToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestGetJWTToken parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$RequestGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$RequestGetJWTToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$RequestGetJWTToken.class) {
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

    public static a newBuilder(AuthOuterClass$RequestGetJWTToken authOuterClass$RequestGetJWTToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$RequestGetJWTToken);
    }

    public static AuthOuterClass$RequestGetJWTToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestGetJWTToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestGetJWTToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$RequestGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$RequestGetJWTToken parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$RequestGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$RequestGetJWTToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$RequestGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$RequestGetJWTToken parseFrom(byte[] bArr) {
        return (AuthOuterClass$RequestGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$RequestGetJWTToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$RequestGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$RequestGetJWTToken parseFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestGetJWTToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestGetJWTToken parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$RequestGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$RequestGetJWTToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$RequestGetJWTToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

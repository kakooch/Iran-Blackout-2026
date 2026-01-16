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
public final class AuthOuterClass$RequestLogOut extends GeneratedMessageLite implements U64 {
    private static final AuthOuterClass$RequestLogOut DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AuthOuterClass$RequestLogOut.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$RequestLogOut authOuterClass$RequestLogOut = new AuthOuterClass$RequestLogOut();
        DEFAULT_INSTANCE = authOuterClass$RequestLogOut;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$RequestLogOut.class, authOuterClass$RequestLogOut);
    }

    private AuthOuterClass$RequestLogOut() {
    }

    public static AuthOuterClass$RequestLogOut getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$RequestLogOut parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestLogOut) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestLogOut parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$RequestLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$RequestLogOut();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$RequestLogOut.class) {
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

    public static a newBuilder(AuthOuterClass$RequestLogOut authOuterClass$RequestLogOut) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$RequestLogOut);
    }

    public static AuthOuterClass$RequestLogOut parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestLogOut) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestLogOut parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$RequestLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$RequestLogOut parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$RequestLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$RequestLogOut parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$RequestLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$RequestLogOut parseFrom(byte[] bArr) {
        return (AuthOuterClass$RequestLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$RequestLogOut parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$RequestLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$RequestLogOut parseFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestLogOut parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestLogOut parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$RequestLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$RequestLogOut parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$RequestLogOut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

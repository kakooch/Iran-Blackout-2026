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
public final class AuthOuterClass$UpdateAccountDeleted extends GeneratedMessageLite implements U64 {
    private static final AuthOuterClass$UpdateAccountDeleted DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AuthOuterClass$UpdateAccountDeleted.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$UpdateAccountDeleted authOuterClass$UpdateAccountDeleted = new AuthOuterClass$UpdateAccountDeleted();
        DEFAULT_INSTANCE = authOuterClass$UpdateAccountDeleted;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$UpdateAccountDeleted.class, authOuterClass$UpdateAccountDeleted);
    }

    private AuthOuterClass$UpdateAccountDeleted() {
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static AuthOuterClass$UpdateAccountDeleted getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$UpdateAccountDeleted parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$UpdateAccountDeleted) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$UpdateAccountDeleted parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$UpdateAccountDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$UpdateAccountDeleted();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"userId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$UpdateAccountDeleted.class) {
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

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(AuthOuterClass$UpdateAccountDeleted authOuterClass$UpdateAccountDeleted) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$UpdateAccountDeleted);
    }

    public static AuthOuterClass$UpdateAccountDeleted parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$UpdateAccountDeleted) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$UpdateAccountDeleted parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$UpdateAccountDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$UpdateAccountDeleted parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$UpdateAccountDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$UpdateAccountDeleted parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$UpdateAccountDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$UpdateAccountDeleted parseFrom(byte[] bArr) {
        return (AuthOuterClass$UpdateAccountDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$UpdateAccountDeleted parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$UpdateAccountDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$UpdateAccountDeleted parseFrom(InputStream inputStream) {
        return (AuthOuterClass$UpdateAccountDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$UpdateAccountDeleted parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$UpdateAccountDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$UpdateAccountDeleted parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$UpdateAccountDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$UpdateAccountDeleted parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$UpdateAccountDeleted) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

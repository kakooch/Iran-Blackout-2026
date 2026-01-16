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
public final class PushOuterClass$RequestRegisterGooglePush extends GeneratedMessageLite implements U64 {
    private static final PushOuterClass$RequestRegisterGooglePush DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PROJECT_ID_FIELD_NUMBER = 1;
    public static final int TOKEN_FIELD_NUMBER = 2;
    private long projectId_;
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PushOuterClass$RequestRegisterGooglePush.DEFAULT_INSTANCE);
        }
    }

    static {
        PushOuterClass$RequestRegisterGooglePush pushOuterClass$RequestRegisterGooglePush = new PushOuterClass$RequestRegisterGooglePush();
        DEFAULT_INSTANCE = pushOuterClass$RequestRegisterGooglePush;
        GeneratedMessageLite.registerDefaultInstance(PushOuterClass$RequestRegisterGooglePush.class, pushOuterClass$RequestRegisterGooglePush);
    }

    private PushOuterClass$RequestRegisterGooglePush() {
    }

    private void clearProjectId() {
        this.projectId_ = 0L;
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static PushOuterClass$RequestRegisterGooglePush getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PushOuterClass$RequestRegisterGooglePush parseDelimitedFrom(InputStream inputStream) {
        return (PushOuterClass$RequestRegisterGooglePush) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushOuterClass$RequestRegisterGooglePush parseFrom(ByteBuffer byteBuffer) {
        return (PushOuterClass$RequestRegisterGooglePush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setProjectId(long j) {
        this.projectId_ = j;
    }

    private void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    private void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1878n1.a[gVar.ordinal()]) {
            case 1:
                return new PushOuterClass$RequestRegisterGooglePush();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002Ȉ", new Object[]{"projectId_", "token_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PushOuterClass$RequestRegisterGooglePush.class) {
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

    public long getProjectId() {
        return this.projectId_;
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public static a newBuilder(PushOuterClass$RequestRegisterGooglePush pushOuterClass$RequestRegisterGooglePush) {
        return (a) DEFAULT_INSTANCE.createBuilder(pushOuterClass$RequestRegisterGooglePush);
    }

    public static PushOuterClass$RequestRegisterGooglePush parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PushOuterClass$RequestRegisterGooglePush) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushOuterClass$RequestRegisterGooglePush parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PushOuterClass$RequestRegisterGooglePush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PushOuterClass$RequestRegisterGooglePush parseFrom(AbstractC2383g abstractC2383g) {
        return (PushOuterClass$RequestRegisterGooglePush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PushOuterClass$RequestRegisterGooglePush parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PushOuterClass$RequestRegisterGooglePush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PushOuterClass$RequestRegisterGooglePush parseFrom(byte[] bArr) {
        return (PushOuterClass$RequestRegisterGooglePush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PushOuterClass$RequestRegisterGooglePush parseFrom(byte[] bArr, C2394s c2394s) {
        return (PushOuterClass$RequestRegisterGooglePush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PushOuterClass$RequestRegisterGooglePush parseFrom(InputStream inputStream) {
        return (PushOuterClass$RequestRegisterGooglePush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushOuterClass$RequestRegisterGooglePush parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PushOuterClass$RequestRegisterGooglePush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushOuterClass$RequestRegisterGooglePush parseFrom(AbstractC2384h abstractC2384h) {
        return (PushOuterClass$RequestRegisterGooglePush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PushOuterClass$RequestRegisterGooglePush parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PushOuterClass$RequestRegisterGooglePush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

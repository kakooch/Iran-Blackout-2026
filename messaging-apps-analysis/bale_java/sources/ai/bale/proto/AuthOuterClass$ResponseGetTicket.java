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
public final class AuthOuterClass$ResponseGetTicket extends GeneratedMessageLite implements U64 {
    private static final AuthOuterClass$ResponseGetTicket DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REDIRECT_URL_FIELD_NUMBER = 1;
    private String redirectUrl_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AuthOuterClass$ResponseGetTicket.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$ResponseGetTicket authOuterClass$ResponseGetTicket = new AuthOuterClass$ResponseGetTicket();
        DEFAULT_INSTANCE = authOuterClass$ResponseGetTicket;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$ResponseGetTicket.class, authOuterClass$ResponseGetTicket);
    }

    private AuthOuterClass$ResponseGetTicket() {
    }

    private void clearRedirectUrl() {
        this.redirectUrl_ = getDefaultInstance().getRedirectUrl();
    }

    public static AuthOuterClass$ResponseGetTicket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$ResponseGetTicket parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$ResponseGetTicket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$ResponseGetTicket parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$ResponseGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setRedirectUrl(String str) {
        str.getClass();
        this.redirectUrl_ = str;
    }

    private void setRedirectUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.redirectUrl_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$ResponseGetTicket();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"redirectUrl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$ResponseGetTicket.class) {
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

    public String getRedirectUrl() {
        return this.redirectUrl_;
    }

    public AbstractC2383g getRedirectUrlBytes() {
        return AbstractC2383g.N(this.redirectUrl_);
    }

    public static a newBuilder(AuthOuterClass$ResponseGetTicket authOuterClass$ResponseGetTicket) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$ResponseGetTicket);
    }

    public static AuthOuterClass$ResponseGetTicket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetTicket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$ResponseGetTicket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$ResponseGetTicket parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$ResponseGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$ResponseGetTicket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$ResponseGetTicket parseFrom(byte[] bArr) {
        return (AuthOuterClass$ResponseGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$ResponseGetTicket parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$ResponseGetTicket parseFrom(InputStream inputStream) {
        return (AuthOuterClass$ResponseGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$ResponseGetTicket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$ResponseGetTicket parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$ResponseGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$ResponseGetTicket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$ResponseGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

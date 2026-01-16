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
public final class AuthOuterClass$RequestGetTicket extends GeneratedMessageLite implements U64 {
    private static final AuthOuterClass$RequestGetTicket DEFAULT_INSTANCE;
    public static final int JSON_REQUEST_FIELD_NUMBER = 1;
    public static final int JSON_SIGN_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private String jsonRequest_ = "";
    private String jsonSign_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AuthOuterClass$RequestGetTicket.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$RequestGetTicket authOuterClass$RequestGetTicket = new AuthOuterClass$RequestGetTicket();
        DEFAULT_INSTANCE = authOuterClass$RequestGetTicket;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$RequestGetTicket.class, authOuterClass$RequestGetTicket);
    }

    private AuthOuterClass$RequestGetTicket() {
    }

    private void clearJsonRequest() {
        this.jsonRequest_ = getDefaultInstance().getJsonRequest();
    }

    private void clearJsonSign() {
        this.jsonSign_ = getDefaultInstance().getJsonSign();
    }

    public static AuthOuterClass$RequestGetTicket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$RequestGetTicket parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestGetTicket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestGetTicket parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$RequestGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setJsonRequest(String str) {
        str.getClass();
        this.jsonRequest_ = str;
    }

    private void setJsonRequestBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.jsonRequest_ = abstractC2383g.f0();
    }

    private void setJsonSign(String str) {
        str.getClass();
        this.jsonSign_ = str;
    }

    private void setJsonSignBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.jsonSign_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$RequestGetTicket();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"jsonRequest_", "jsonSign_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$RequestGetTicket.class) {
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

    public String getJsonRequest() {
        return this.jsonRequest_;
    }

    public AbstractC2383g getJsonRequestBytes() {
        return AbstractC2383g.N(this.jsonRequest_);
    }

    public String getJsonSign() {
        return this.jsonSign_;
    }

    public AbstractC2383g getJsonSignBytes() {
        return AbstractC2383g.N(this.jsonSign_);
    }

    public static a newBuilder(AuthOuterClass$RequestGetTicket authOuterClass$RequestGetTicket) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$RequestGetTicket);
    }

    public static AuthOuterClass$RequestGetTicket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestGetTicket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestGetTicket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$RequestGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$RequestGetTicket parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$RequestGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$RequestGetTicket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$RequestGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$RequestGetTicket parseFrom(byte[] bArr) {
        return (AuthOuterClass$RequestGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$RequestGetTicket parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$RequestGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$RequestGetTicket parseFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestGetTicket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestGetTicket parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$RequestGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$RequestGetTicket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$RequestGetTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

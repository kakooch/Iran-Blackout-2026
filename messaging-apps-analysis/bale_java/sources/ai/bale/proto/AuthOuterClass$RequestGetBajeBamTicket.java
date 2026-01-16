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
public final class AuthOuterClass$RequestGetBajeBamTicket extends GeneratedMessageLite implements U64 {
    private static final AuthOuterClass$RequestGetBajeBamTicket DEFAULT_INSTANCE;
    public static final int EXP_DATE_TIME_FIELD_NUMBER = 1;
    public static final int MOBILE_NO_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private long expDateTime_;
    private String mobileNo_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AuthOuterClass$RequestGetBajeBamTicket.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$RequestGetBajeBamTicket authOuterClass$RequestGetBajeBamTicket = new AuthOuterClass$RequestGetBajeBamTicket();
        DEFAULT_INSTANCE = authOuterClass$RequestGetBajeBamTicket;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$RequestGetBajeBamTicket.class, authOuterClass$RequestGetBajeBamTicket);
    }

    private AuthOuterClass$RequestGetBajeBamTicket() {
    }

    private void clearExpDateTime() {
        this.expDateTime_ = 0L;
    }

    private void clearMobileNo() {
        this.mobileNo_ = getDefaultInstance().getMobileNo();
    }

    public static AuthOuterClass$RequestGetBajeBamTicket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$RequestGetBajeBamTicket parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestGetBajeBamTicket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestGetBajeBamTicket parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$RequestGetBajeBamTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExpDateTime(long j) {
        this.expDateTime_ = j;
    }

    private void setMobileNo(String str) {
        str.getClass();
        this.mobileNo_ = str;
    }

    private void setMobileNoBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.mobileNo_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$RequestGetBajeBamTicket();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002Ȉ", new Object[]{"expDateTime_", "mobileNo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$RequestGetBajeBamTicket.class) {
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

    public long getExpDateTime() {
        return this.expDateTime_;
    }

    public String getMobileNo() {
        return this.mobileNo_;
    }

    public AbstractC2383g getMobileNoBytes() {
        return AbstractC2383g.N(this.mobileNo_);
    }

    public static a newBuilder(AuthOuterClass$RequestGetBajeBamTicket authOuterClass$RequestGetBajeBamTicket) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$RequestGetBajeBamTicket);
    }

    public static AuthOuterClass$RequestGetBajeBamTicket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestGetBajeBamTicket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestGetBajeBamTicket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$RequestGetBajeBamTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$RequestGetBajeBamTicket parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$RequestGetBajeBamTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$RequestGetBajeBamTicket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$RequestGetBajeBamTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$RequestGetBajeBamTicket parseFrom(byte[] bArr) {
        return (AuthOuterClass$RequestGetBajeBamTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$RequestGetBajeBamTicket parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$RequestGetBajeBamTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$RequestGetBajeBamTicket parseFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestGetBajeBamTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestGetBajeBamTicket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestGetBajeBamTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestGetBajeBamTicket parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$RequestGetBajeBamTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$RequestGetBajeBamTicket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$RequestGetBajeBamTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

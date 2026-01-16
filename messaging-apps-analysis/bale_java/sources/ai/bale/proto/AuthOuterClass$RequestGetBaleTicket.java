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
public final class AuthOuterClass$RequestGetBaleTicket extends GeneratedMessageLite implements U64 {
    public static final int CLIENT_ID_FIELD_NUMBER = 3;
    private static final AuthOuterClass$RequestGetBaleTicket DEFAULT_INSTANCE;
    public static final int EXP_DATE_TIME_FIELD_NUMBER = 1;
    public static final int MOBILE_NO_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private long expDateTime_;
    private String mobileNo_ = "";
    private String clientId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AuthOuterClass$RequestGetBaleTicket.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$RequestGetBaleTicket authOuterClass$RequestGetBaleTicket = new AuthOuterClass$RequestGetBaleTicket();
        DEFAULT_INSTANCE = authOuterClass$RequestGetBaleTicket;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$RequestGetBaleTicket.class, authOuterClass$RequestGetBaleTicket);
    }

    private AuthOuterClass$RequestGetBaleTicket() {
    }

    private void clearClientId() {
        this.clientId_ = getDefaultInstance().getClientId();
    }

    private void clearExpDateTime() {
        this.expDateTime_ = 0L;
    }

    private void clearMobileNo() {
        this.mobileNo_ = getDefaultInstance().getMobileNo();
    }

    public static AuthOuterClass$RequestGetBaleTicket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$RequestGetBaleTicket parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestGetBaleTicket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestGetBaleTicket parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$RequestGetBaleTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setClientId(String str) {
        str.getClass();
        this.clientId_ = str;
    }

    private void setClientIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.clientId_ = abstractC2383g.f0();
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
                return new AuthOuterClass$RequestGetBaleTicket();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ", new Object[]{"expDateTime_", "mobileNo_", "clientId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$RequestGetBaleTicket.class) {
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

    public String getClientId() {
        return this.clientId_;
    }

    public AbstractC2383g getClientIdBytes() {
        return AbstractC2383g.N(this.clientId_);
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

    public static a newBuilder(AuthOuterClass$RequestGetBaleTicket authOuterClass$RequestGetBaleTicket) {
        return (a) DEFAULT_INSTANCE.createBuilder(authOuterClass$RequestGetBaleTicket);
    }

    public static AuthOuterClass$RequestGetBaleTicket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestGetBaleTicket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestGetBaleTicket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$RequestGetBaleTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$RequestGetBaleTicket parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$RequestGetBaleTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$RequestGetBaleTicket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$RequestGetBaleTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$RequestGetBaleTicket parseFrom(byte[] bArr) {
        return (AuthOuterClass$RequestGetBaleTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$RequestGetBaleTicket parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$RequestGetBaleTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$RequestGetBaleTicket parseFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestGetBaleTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestGetBaleTicket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestGetBaleTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestGetBaleTicket parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$RequestGetBaleTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$RequestGetBaleTicket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$RequestGetBaleTicket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

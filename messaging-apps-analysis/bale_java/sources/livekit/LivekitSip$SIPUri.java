package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.FF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitSip$SIPUri extends GeneratedMessageLite implements U64 {
    private static final LivekitSip$SIPUri DEFAULT_INSTANCE;
    public static final int HOST_FIELD_NUMBER = 2;
    public static final int IP_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PORT_FIELD_NUMBER = 4;
    public static final int TRANSPORT_FIELD_NUMBER = 5;
    public static final int USER_FIELD_NUMBER = 1;
    private int port_;
    private int transport_;
    private String user_ = "";
    private String host_ = "";
    private String ip_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$SIPUri.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$SIPUri livekitSip$SIPUri = new LivekitSip$SIPUri();
        DEFAULT_INSTANCE = livekitSip$SIPUri;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$SIPUri.class, livekitSip$SIPUri);
    }

    private LivekitSip$SIPUri() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHost() {
        this.host_ = getDefaultInstance().getHost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIp() {
        this.ip_ = getDefaultInstance().getIp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPort() {
        this.port_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransport() {
        this.transport_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUser() {
        this.user_ = getDefaultInstance().getUser();
    }

    public static LivekitSip$SIPUri getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$SIPUri parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$SIPUri) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPUri parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$SIPUri) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHost(String str) {
        str.getClass();
        this.host_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHostBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.host_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIp(String str) {
        str.getClass();
        this.ip_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIpBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.ip_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPort(int i) {
        this.port_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransport(FF3 ff3) {
        this.transport_ = ff3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransportValue(int i) {
        this.transport_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUser(String str) {
        str.getClass();
        this.user_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.user_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$SIPUri();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u000b\u0005\f", new Object[]{"user_", "host_", "ip_", "port_", "transport_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$SIPUri.class) {
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

    public String getHost() {
        return this.host_;
    }

    public AbstractC2383g getHostBytes() {
        return AbstractC2383g.N(this.host_);
    }

    public String getIp() {
        return this.ip_;
    }

    public AbstractC2383g getIpBytes() {
        return AbstractC2383g.N(this.ip_);
    }

    public int getPort() {
        return this.port_;
    }

    public FF3 getTransport() {
        FF3 ff3J = FF3.j(this.transport_);
        return ff3J == null ? FF3.UNRECOGNIZED : ff3J;
    }

    public int getTransportValue() {
        return this.transport_;
    }

    public String getUser() {
        return this.user_;
    }

    public AbstractC2383g getUserBytes() {
        return AbstractC2383g.N(this.user_);
    }

    public static a newBuilder(LivekitSip$SIPUri livekitSip$SIPUri) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$SIPUri);
    }

    public static LivekitSip$SIPUri parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPUri) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPUri parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$SIPUri) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$SIPUri parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$SIPUri) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$SIPUri parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$SIPUri) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$SIPUri parseFrom(byte[] bArr) {
        return (LivekitSip$SIPUri) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$SIPUri parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$SIPUri) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$SIPUri parseFrom(InputStream inputStream) {
        return (LivekitSip$SIPUri) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPUri parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPUri) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPUri parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$SIPUri) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$SIPUri parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$SIPUri) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

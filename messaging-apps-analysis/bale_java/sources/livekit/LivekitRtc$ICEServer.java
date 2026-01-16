package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC16424lF3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitRtc$ICEServer extends GeneratedMessageLite implements InterfaceC16424lF3 {
    public static final int CREDENTIAL_FIELD_NUMBER = 3;
    private static final LivekitRtc$ICEServer DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int URLS_FIELD_NUMBER = 1;
    public static final int USERNAME_FIELD_NUMBER = 2;
    private B.j urls_ = GeneratedMessageLite.emptyProtobufList();
    private String username_ = "";
    private String credential_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC16424lF3 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$ICEServer.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$ICEServer livekitRtc$ICEServer = new LivekitRtc$ICEServer();
        DEFAULT_INSTANCE = livekitRtc$ICEServer;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$ICEServer.class, livekitRtc$ICEServer);
    }

    private LivekitRtc$ICEServer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllUrls(Iterable<String> iterable) {
        ensureUrlsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.urls_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addUrls(String str) {
        str.getClass();
        ensureUrlsIsMutable();
        this.urls_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addUrlsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureUrlsIsMutable();
        this.urls_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCredential() {
        this.credential_ = getDefaultInstance().getCredential();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUrls() {
        this.urls_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUsername() {
        this.username_ = getDefaultInstance().getUsername();
    }

    private void ensureUrlsIsMutable() {
        B.j jVar = this.urls_;
        if (jVar.u()) {
            return;
        }
        this.urls_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRtc$ICEServer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$ICEServer parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$ICEServer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$ICEServer parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$ICEServer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCredential(String str) {
        str.getClass();
        this.credential_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCredentialBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.credential_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrls(int i, String str) {
        str.getClass();
        ensureUrlsIsMutable();
        this.urls_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsername(String str) {
        str.getClass();
        this.username_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsernameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.username_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$ICEServer();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ț\u0002Ȉ\u0003Ȉ", new Object[]{"urls_", "username_", "credential_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$ICEServer.class) {
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

    public String getCredential() {
        return this.credential_;
    }

    public AbstractC2383g getCredentialBytes() {
        return AbstractC2383g.N(this.credential_);
    }

    public String getUrls(int i) {
        return (String) this.urls_.get(i);
    }

    public AbstractC2383g getUrlsBytes(int i) {
        return AbstractC2383g.N((String) this.urls_.get(i));
    }

    public int getUrlsCount() {
        return this.urls_.size();
    }

    public List<String> getUrlsList() {
        return this.urls_;
    }

    public String getUsername() {
        return this.username_;
    }

    public AbstractC2383g getUsernameBytes() {
        return AbstractC2383g.N(this.username_);
    }

    public static a newBuilder(LivekitRtc$ICEServer livekitRtc$ICEServer) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$ICEServer);
    }

    public static LivekitRtc$ICEServer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$ICEServer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$ICEServer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$ICEServer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$ICEServer parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$ICEServer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$ICEServer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$ICEServer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$ICEServer parseFrom(byte[] bArr) {
        return (LivekitRtc$ICEServer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$ICEServer parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$ICEServer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$ICEServer parseFrom(InputStream inputStream) {
        return (LivekitRtc$ICEServer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$ICEServer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$ICEServer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$ICEServer parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$ICEServer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$ICEServer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$ICEServer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

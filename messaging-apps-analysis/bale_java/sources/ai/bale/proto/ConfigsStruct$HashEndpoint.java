package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7764Tc1;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class ConfigsStruct$HashEndpoint extends GeneratedMessageLite implements InterfaceC7764Tc1 {
    private static final ConfigsStruct$HashEndpoint DEFAULT_INSTANCE;
    public static final int HOST_FIELD_NUMBER = 1;
    public static final int KNOWN_IP_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TLS_PUBLIC_KEY_HASH_FIELD_NUMBER = 3;
    private String host_ = "";
    private String knownIp_ = "";
    private B.j tlsPublicKeyHash_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC7764Tc1 {
        private a() {
            super(ConfigsStruct$HashEndpoint.DEFAULT_INSTANCE);
        }
    }

    static {
        ConfigsStruct$HashEndpoint configsStruct$HashEndpoint = new ConfigsStruct$HashEndpoint();
        DEFAULT_INSTANCE = configsStruct$HashEndpoint;
        GeneratedMessageLite.registerDefaultInstance(ConfigsStruct$HashEndpoint.class, configsStruct$HashEndpoint);
    }

    private ConfigsStruct$HashEndpoint() {
    }

    private void addAllTlsPublicKeyHash(Iterable<String> iterable) {
        ensureTlsPublicKeyHashIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.tlsPublicKeyHash_);
    }

    private void addTlsPublicKeyHash(String str) {
        str.getClass();
        ensureTlsPublicKeyHashIsMutable();
        this.tlsPublicKeyHash_.add(str);
    }

    private void addTlsPublicKeyHashBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureTlsPublicKeyHashIsMutable();
        this.tlsPublicKeyHash_.add(abstractC2383g.f0());
    }

    private void clearHost() {
        this.host_ = getDefaultInstance().getHost();
    }

    private void clearKnownIp() {
        this.knownIp_ = getDefaultInstance().getKnownIp();
    }

    private void clearTlsPublicKeyHash() {
        this.tlsPublicKeyHash_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureTlsPublicKeyHashIsMutable() {
        B.j jVar = this.tlsPublicKeyHash_;
        if (jVar.u()) {
            return;
        }
        this.tlsPublicKeyHash_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ConfigsStruct$HashEndpoint getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ConfigsStruct$HashEndpoint parseDelimitedFrom(InputStream inputStream) {
        return (ConfigsStruct$HashEndpoint) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigsStruct$HashEndpoint parseFrom(ByteBuffer byteBuffer) {
        return (ConfigsStruct$HashEndpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHost(String str) {
        str.getClass();
        this.host_ = str;
    }

    private void setHostBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.host_ = abstractC2383g.f0();
    }

    private void setKnownIp(String str) {
        str.getClass();
        this.knownIp_ = str;
    }

    private void setKnownIpBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.knownIp_ = abstractC2383g.f0();
    }

    private void setTlsPublicKeyHash(int i, String str) {
        str.getClass();
        ensureTlsPublicKeyHashIsMutable();
        this.tlsPublicKeyHash_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G.a[gVar.ordinal()]) {
            case 1:
                return new ConfigsStruct$HashEndpoint();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ț", new Object[]{"host_", "knownIp_", "tlsPublicKeyHash_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ConfigsStruct$HashEndpoint.class) {
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

    public String getKnownIp() {
        return this.knownIp_;
    }

    public AbstractC2383g getKnownIpBytes() {
        return AbstractC2383g.N(this.knownIp_);
    }

    public String getTlsPublicKeyHash(int i) {
        return (String) this.tlsPublicKeyHash_.get(i);
    }

    public AbstractC2383g getTlsPublicKeyHashBytes(int i) {
        return AbstractC2383g.N((String) this.tlsPublicKeyHash_.get(i));
    }

    public int getTlsPublicKeyHashCount() {
        return this.tlsPublicKeyHash_.size();
    }

    public List<String> getTlsPublicKeyHashList() {
        return this.tlsPublicKeyHash_;
    }

    public static a newBuilder(ConfigsStruct$HashEndpoint configsStruct$HashEndpoint) {
        return (a) DEFAULT_INSTANCE.createBuilder(configsStruct$HashEndpoint);
    }

    public static ConfigsStruct$HashEndpoint parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ConfigsStruct$HashEndpoint) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ConfigsStruct$HashEndpoint parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ConfigsStruct$HashEndpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ConfigsStruct$HashEndpoint parseFrom(AbstractC2383g abstractC2383g) {
        return (ConfigsStruct$HashEndpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ConfigsStruct$HashEndpoint parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ConfigsStruct$HashEndpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ConfigsStruct$HashEndpoint parseFrom(byte[] bArr) {
        return (ConfigsStruct$HashEndpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ConfigsStruct$HashEndpoint parseFrom(byte[] bArr, C2394s c2394s) {
        return (ConfigsStruct$HashEndpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ConfigsStruct$HashEndpoint parseFrom(InputStream inputStream) {
        return (ConfigsStruct$HashEndpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigsStruct$HashEndpoint parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ConfigsStruct$HashEndpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ConfigsStruct$HashEndpoint parseFrom(AbstractC2384h abstractC2384h) {
        return (ConfigsStruct$HashEndpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ConfigsStruct$HashEndpoint parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ConfigsStruct$HashEndpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

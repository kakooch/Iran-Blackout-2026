package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC7293Rc1;
import ir.nasim.InterfaceC7059Qc1;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class ConfigsStruct$Endpoint extends GeneratedMessageLite implements InterfaceC7059Qc1 {
    private static final ConfigsStruct$Endpoint DEFAULT_INSTANCE;
    public static final int HOST_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int KNOWN_IP_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PORT_FIELD_NUMBER = 3;
    public static final int TLS_PUBLIC_KEY_HASH_FIELD_NUMBER = 4;
    public static final int TYPE_FIELD_NUMBER = 6;
    private int id_;
    private int port_;
    private int type_;
    private String host_ = "";
    private B.j tlsPublicKeyHash_ = GeneratedMessageLite.emptyProtobufList();
    private String knownIp_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC7059Qc1 {
        private a() {
            super(ConfigsStruct$Endpoint.DEFAULT_INSTANCE);
        }
    }

    static {
        ConfigsStruct$Endpoint configsStruct$Endpoint = new ConfigsStruct$Endpoint();
        DEFAULT_INSTANCE = configsStruct$Endpoint;
        GeneratedMessageLite.registerDefaultInstance(ConfigsStruct$Endpoint.class, configsStruct$Endpoint);
    }

    private ConfigsStruct$Endpoint() {
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

    private void clearId() {
        this.id_ = 0;
    }

    private void clearKnownIp() {
        this.knownIp_ = getDefaultInstance().getKnownIp();
    }

    private void clearPort() {
        this.port_ = 0;
    }

    private void clearTlsPublicKeyHash() {
        this.tlsPublicKeyHash_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearType() {
        this.type_ = 0;
    }

    private void ensureTlsPublicKeyHashIsMutable() {
        B.j jVar = this.tlsPublicKeyHash_;
        if (jVar.u()) {
            return;
        }
        this.tlsPublicKeyHash_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ConfigsStruct$Endpoint getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ConfigsStruct$Endpoint parseDelimitedFrom(InputStream inputStream) {
        return (ConfigsStruct$Endpoint) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigsStruct$Endpoint parseFrom(ByteBuffer byteBuffer) {
        return (ConfigsStruct$Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setId(int i) {
        this.id_ = i;
    }

    private void setKnownIp(String str) {
        str.getClass();
        this.knownIp_ = str;
    }

    private void setKnownIpBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.knownIp_ = abstractC2383g.f0();
    }

    private void setPort(int i) {
        this.port_ = i;
    }

    private void setTlsPublicKeyHash(int i, String str) {
        str.getClass();
        ensureTlsPublicKeyHashIsMutable();
        this.tlsPublicKeyHash_.set(i, str);
    }

    private void setType(EnumC7293Rc1 enumC7293Rc1) {
        this.type_ = enumC7293Rc1.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G.a[gVar.ordinal()]) {
            case 1:
                return new ConfigsStruct$Endpoint();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003\u0004\u0004Ț\u0005Ȉ\u0006\f", new Object[]{"id_", "host_", "port_", "tlsPublicKeyHash_", "knownIp_", "type_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ConfigsStruct$Endpoint.class) {
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

    public int getId() {
        return this.id_;
    }

    public String getKnownIp() {
        return this.knownIp_;
    }

    public AbstractC2383g getKnownIpBytes() {
        return AbstractC2383g.N(this.knownIp_);
    }

    public int getPort() {
        return this.port_;
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

    public EnumC7293Rc1 getType() {
        EnumC7293Rc1 enumC7293Rc1J = EnumC7293Rc1.j(this.type_);
        return enumC7293Rc1J == null ? EnumC7293Rc1.UNRECOGNIZED : enumC7293Rc1J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public static a newBuilder(ConfigsStruct$Endpoint configsStruct$Endpoint) {
        return (a) DEFAULT_INSTANCE.createBuilder(configsStruct$Endpoint);
    }

    public static ConfigsStruct$Endpoint parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ConfigsStruct$Endpoint) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ConfigsStruct$Endpoint parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ConfigsStruct$Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ConfigsStruct$Endpoint parseFrom(AbstractC2383g abstractC2383g) {
        return (ConfigsStruct$Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ConfigsStruct$Endpoint parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ConfigsStruct$Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ConfigsStruct$Endpoint parseFrom(byte[] bArr) {
        return (ConfigsStruct$Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ConfigsStruct$Endpoint parseFrom(byte[] bArr, C2394s c2394s) {
        return (ConfigsStruct$Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ConfigsStruct$Endpoint parseFrom(InputStream inputStream) {
        return (ConfigsStruct$Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigsStruct$Endpoint parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ConfigsStruct$Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ConfigsStruct$Endpoint parseFrom(AbstractC2384h abstractC2384h) {
        return (ConfigsStruct$Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ConfigsStruct$Endpoint parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ConfigsStruct$Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

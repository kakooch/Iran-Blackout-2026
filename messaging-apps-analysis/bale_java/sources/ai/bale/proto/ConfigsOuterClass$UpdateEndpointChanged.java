package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7059Qc1;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class ConfigsOuterClass$UpdateEndpointChanged extends GeneratedMessageLite implements U64 {
    private static final ConfigsOuterClass$UpdateEndpointChanged DEFAULT_INSTANCE;
    public static final int ENDPOINTS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j endpoints_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ConfigsOuterClass$UpdateEndpointChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        ConfigsOuterClass$UpdateEndpointChanged configsOuterClass$UpdateEndpointChanged = new ConfigsOuterClass$UpdateEndpointChanged();
        DEFAULT_INSTANCE = configsOuterClass$UpdateEndpointChanged;
        GeneratedMessageLite.registerDefaultInstance(ConfigsOuterClass$UpdateEndpointChanged.class, configsOuterClass$UpdateEndpointChanged);
    }

    private ConfigsOuterClass$UpdateEndpointChanged() {
    }

    private void addAllEndpoints(Iterable<? extends ConfigsStruct$Endpoint> iterable) {
        ensureEndpointsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.endpoints_);
    }

    private void addEndpoints(ConfigsStruct$Endpoint configsStruct$Endpoint) {
        configsStruct$Endpoint.getClass();
        ensureEndpointsIsMutable();
        this.endpoints_.add(configsStruct$Endpoint);
    }

    private void clearEndpoints() {
        this.endpoints_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureEndpointsIsMutable() {
        B.j jVar = this.endpoints_;
        if (jVar.u()) {
            return;
        }
        this.endpoints_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ConfigsOuterClass$UpdateEndpointChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ConfigsOuterClass$UpdateEndpointChanged parseDelimitedFrom(InputStream inputStream) {
        return (ConfigsOuterClass$UpdateEndpointChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigsOuterClass$UpdateEndpointChanged parseFrom(ByteBuffer byteBuffer) {
        return (ConfigsOuterClass$UpdateEndpointChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeEndpoints(int i) {
        ensureEndpointsIsMutable();
        this.endpoints_.remove(i);
    }

    private void setEndpoints(int i, ConfigsStruct$Endpoint configsStruct$Endpoint) {
        configsStruct$Endpoint.getClass();
        ensureEndpointsIsMutable();
        this.endpoints_.set(i, configsStruct$Endpoint);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F.a[gVar.ordinal()]) {
            case 1:
                return new ConfigsOuterClass$UpdateEndpointChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"endpoints_", ConfigsStruct$Endpoint.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ConfigsOuterClass$UpdateEndpointChanged.class) {
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

    public ConfigsStruct$Endpoint getEndpoints(int i) {
        return (ConfigsStruct$Endpoint) this.endpoints_.get(i);
    }

    public int getEndpointsCount() {
        return this.endpoints_.size();
    }

    public List<ConfigsStruct$Endpoint> getEndpointsList() {
        return this.endpoints_;
    }

    public InterfaceC7059Qc1 getEndpointsOrBuilder(int i) {
        return (InterfaceC7059Qc1) this.endpoints_.get(i);
    }

    public List<? extends InterfaceC7059Qc1> getEndpointsOrBuilderList() {
        return this.endpoints_;
    }

    public static a newBuilder(ConfigsOuterClass$UpdateEndpointChanged configsOuterClass$UpdateEndpointChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(configsOuterClass$UpdateEndpointChanged);
    }

    public static ConfigsOuterClass$UpdateEndpointChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ConfigsOuterClass$UpdateEndpointChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ConfigsOuterClass$UpdateEndpointChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ConfigsOuterClass$UpdateEndpointChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ConfigsOuterClass$UpdateEndpointChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (ConfigsOuterClass$UpdateEndpointChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addEndpoints(int i, ConfigsStruct$Endpoint configsStruct$Endpoint) {
        configsStruct$Endpoint.getClass();
        ensureEndpointsIsMutable();
        this.endpoints_.add(i, configsStruct$Endpoint);
    }

    public static ConfigsOuterClass$UpdateEndpointChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ConfigsOuterClass$UpdateEndpointChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ConfigsOuterClass$UpdateEndpointChanged parseFrom(byte[] bArr) {
        return (ConfigsOuterClass$UpdateEndpointChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ConfigsOuterClass$UpdateEndpointChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (ConfigsOuterClass$UpdateEndpointChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ConfigsOuterClass$UpdateEndpointChanged parseFrom(InputStream inputStream) {
        return (ConfigsOuterClass$UpdateEndpointChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigsOuterClass$UpdateEndpointChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ConfigsOuterClass$UpdateEndpointChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ConfigsOuterClass$UpdateEndpointChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (ConfigsOuterClass$UpdateEndpointChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ConfigsOuterClass$UpdateEndpointChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ConfigsOuterClass$UpdateEndpointChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

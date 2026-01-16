package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC8234Vc1;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class ConfigsOuterClass$ResponseGetParameters extends GeneratedMessageLite implements U64 {
    private static final ConfigsOuterClass$ResponseGetParameters DEFAULT_INSTANCE;
    public static final int PARAMETERS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j parameters_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ConfigsOuterClass$ResponseGetParameters.DEFAULT_INSTANCE);
        }
    }

    static {
        ConfigsOuterClass$ResponseGetParameters configsOuterClass$ResponseGetParameters = new ConfigsOuterClass$ResponseGetParameters();
        DEFAULT_INSTANCE = configsOuterClass$ResponseGetParameters;
        GeneratedMessageLite.registerDefaultInstance(ConfigsOuterClass$ResponseGetParameters.class, configsOuterClass$ResponseGetParameters);
    }

    private ConfigsOuterClass$ResponseGetParameters() {
    }

    private void addAllParameters(Iterable<? extends ConfigsStruct$Parameter> iterable) {
        ensureParametersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.parameters_);
    }

    private void addParameters(ConfigsStruct$Parameter configsStruct$Parameter) {
        configsStruct$Parameter.getClass();
        ensureParametersIsMutable();
        this.parameters_.add(configsStruct$Parameter);
    }

    private void clearParameters() {
        this.parameters_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureParametersIsMutable() {
        B.j jVar = this.parameters_;
        if (jVar.u()) {
            return;
        }
        this.parameters_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ConfigsOuterClass$ResponseGetParameters getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ConfigsOuterClass$ResponseGetParameters parseDelimitedFrom(InputStream inputStream) {
        return (ConfigsOuterClass$ResponseGetParameters) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigsOuterClass$ResponseGetParameters parseFrom(ByteBuffer byteBuffer) {
        return (ConfigsOuterClass$ResponseGetParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeParameters(int i) {
        ensureParametersIsMutable();
        this.parameters_.remove(i);
    }

    private void setParameters(int i, ConfigsStruct$Parameter configsStruct$Parameter) {
        configsStruct$Parameter.getClass();
        ensureParametersIsMutable();
        this.parameters_.set(i, configsStruct$Parameter);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F.a[gVar.ordinal()]) {
            case 1:
                return new ConfigsOuterClass$ResponseGetParameters();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"parameters_", ConfigsStruct$Parameter.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ConfigsOuterClass$ResponseGetParameters.class) {
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

    public ConfigsStruct$Parameter getParameters(int i) {
        return (ConfigsStruct$Parameter) this.parameters_.get(i);
    }

    public int getParametersCount() {
        return this.parameters_.size();
    }

    public List<ConfigsStruct$Parameter> getParametersList() {
        return this.parameters_;
    }

    public InterfaceC8234Vc1 getParametersOrBuilder(int i) {
        return (InterfaceC8234Vc1) this.parameters_.get(i);
    }

    public List<? extends InterfaceC8234Vc1> getParametersOrBuilderList() {
        return this.parameters_;
    }

    public static a newBuilder(ConfigsOuterClass$ResponseGetParameters configsOuterClass$ResponseGetParameters) {
        return (a) DEFAULT_INSTANCE.createBuilder(configsOuterClass$ResponseGetParameters);
    }

    public static ConfigsOuterClass$ResponseGetParameters parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ConfigsOuterClass$ResponseGetParameters) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ConfigsOuterClass$ResponseGetParameters parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ConfigsOuterClass$ResponseGetParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ConfigsOuterClass$ResponseGetParameters parseFrom(AbstractC2383g abstractC2383g) {
        return (ConfigsOuterClass$ResponseGetParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addParameters(int i, ConfigsStruct$Parameter configsStruct$Parameter) {
        configsStruct$Parameter.getClass();
        ensureParametersIsMutable();
        this.parameters_.add(i, configsStruct$Parameter);
    }

    public static ConfigsOuterClass$ResponseGetParameters parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ConfigsOuterClass$ResponseGetParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ConfigsOuterClass$ResponseGetParameters parseFrom(byte[] bArr) {
        return (ConfigsOuterClass$ResponseGetParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ConfigsOuterClass$ResponseGetParameters parseFrom(byte[] bArr, C2394s c2394s) {
        return (ConfigsOuterClass$ResponseGetParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ConfigsOuterClass$ResponseGetParameters parseFrom(InputStream inputStream) {
        return (ConfigsOuterClass$ResponseGetParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigsOuterClass$ResponseGetParameters parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ConfigsOuterClass$ResponseGetParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ConfigsOuterClass$ResponseGetParameters parseFrom(AbstractC2384h abstractC2384h) {
        return (ConfigsOuterClass$ResponseGetParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ConfigsOuterClass$ResponseGetParameters parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ConfigsOuterClass$ResponseGetParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

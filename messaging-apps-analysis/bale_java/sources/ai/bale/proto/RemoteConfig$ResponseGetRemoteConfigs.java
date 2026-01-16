package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class RemoteConfig$ResponseGetRemoteConfigs extends GeneratedMessageLite implements U64 {
    public static final int CONFIGS_FIELD_NUMBER = 1;
    private static final RemoteConfig$ResponseGetRemoteConfigs DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j configs_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(RemoteConfig$ResponseGetRemoteConfigs.DEFAULT_INSTANCE);
        }
    }

    static {
        RemoteConfig$ResponseGetRemoteConfigs remoteConfig$ResponseGetRemoteConfigs = new RemoteConfig$ResponseGetRemoteConfigs();
        DEFAULT_INSTANCE = remoteConfig$ResponseGetRemoteConfigs;
        GeneratedMessageLite.registerDefaultInstance(RemoteConfig$ResponseGetRemoteConfigs.class, remoteConfig$ResponseGetRemoteConfigs);
    }

    private RemoteConfig$ResponseGetRemoteConfigs() {
    }

    private void addAllConfigs(Iterable<? extends RemoteConfigStruct$RemoteConfig> iterable) {
        ensureConfigsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.configs_);
    }

    private void addConfigs(RemoteConfigStruct$RemoteConfig remoteConfigStruct$RemoteConfig) {
        remoteConfigStruct$RemoteConfig.getClass();
        ensureConfigsIsMutable();
        this.configs_.add(remoteConfigStruct$RemoteConfig);
    }

    private void clearConfigs() {
        this.configs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureConfigsIsMutable() {
        B.j jVar = this.configs_;
        if (jVar.u()) {
            return;
        }
        this.configs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static RemoteConfig$ResponseGetRemoteConfigs getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static RemoteConfig$ResponseGetRemoteConfigs parseDelimitedFrom(InputStream inputStream) {
        return (RemoteConfig$ResponseGetRemoteConfigs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RemoteConfig$ResponseGetRemoteConfigs parseFrom(ByteBuffer byteBuffer) {
        return (RemoteConfig$ResponseGetRemoteConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeConfigs(int i) {
        ensureConfigsIsMutable();
        this.configs_.remove(i);
    }

    private void setConfigs(int i, RemoteConfigStruct$RemoteConfig remoteConfigStruct$RemoteConfig) {
        remoteConfigStruct$RemoteConfig.getClass();
        ensureConfigsIsMutable();
        this.configs_.set(i, remoteConfigStruct$RemoteConfig);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1901v1.a[gVar.ordinal()]) {
            case 1:
                return new RemoteConfig$ResponseGetRemoteConfigs();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"configs_", RemoteConfigStruct$RemoteConfig.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (RemoteConfig$ResponseGetRemoteConfigs.class) {
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

    public RemoteConfigStruct$RemoteConfig getConfigs(int i) {
        return (RemoteConfigStruct$RemoteConfig) this.configs_.get(i);
    }

    public int getConfigsCount() {
        return this.configs_.size();
    }

    public List<RemoteConfigStruct$RemoteConfig> getConfigsList() {
        return this.configs_;
    }

    public InterfaceC1907x1 getConfigsOrBuilder(int i) {
        return (InterfaceC1907x1) this.configs_.get(i);
    }

    public List<? extends InterfaceC1907x1> getConfigsOrBuilderList() {
        return this.configs_;
    }

    public static a newBuilder(RemoteConfig$ResponseGetRemoteConfigs remoteConfig$ResponseGetRemoteConfigs) {
        return (a) DEFAULT_INSTANCE.createBuilder(remoteConfig$ResponseGetRemoteConfigs);
    }

    public static RemoteConfig$ResponseGetRemoteConfigs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (RemoteConfig$ResponseGetRemoteConfigs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RemoteConfig$ResponseGetRemoteConfigs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (RemoteConfig$ResponseGetRemoteConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static RemoteConfig$ResponseGetRemoteConfigs parseFrom(AbstractC2383g abstractC2383g) {
        return (RemoteConfig$ResponseGetRemoteConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addConfigs(int i, RemoteConfigStruct$RemoteConfig remoteConfigStruct$RemoteConfig) {
        remoteConfigStruct$RemoteConfig.getClass();
        ensureConfigsIsMutable();
        this.configs_.add(i, remoteConfigStruct$RemoteConfig);
    }

    public static RemoteConfig$ResponseGetRemoteConfigs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (RemoteConfig$ResponseGetRemoteConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static RemoteConfig$ResponseGetRemoteConfigs parseFrom(byte[] bArr) {
        return (RemoteConfig$ResponseGetRemoteConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RemoteConfig$ResponseGetRemoteConfigs parseFrom(byte[] bArr, C2394s c2394s) {
        return (RemoteConfig$ResponseGetRemoteConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static RemoteConfig$ResponseGetRemoteConfigs parseFrom(InputStream inputStream) {
        return (RemoteConfig$ResponseGetRemoteConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RemoteConfig$ResponseGetRemoteConfigs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (RemoteConfig$ResponseGetRemoteConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RemoteConfig$ResponseGetRemoteConfigs parseFrom(AbstractC2384h abstractC2384h) {
        return (RemoteConfig$ResponseGetRemoteConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static RemoteConfig$ResponseGetRemoteConfigs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (RemoteConfig$ResponseGetRemoteConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

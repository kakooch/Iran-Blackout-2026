package bale.smart_support.v1;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.JE6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
public final class SmartSupportOuterClass$RequestAddDataSource extends GeneratedMessageLite implements U64 {
    public static final int AGENT_ID_FIELD_NUMBER = 2;
    public static final int DATASOURCES_FIELD_NUMBER = 3;
    private static final SmartSupportOuterClass$RequestAddDataSource DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int agentId_;
    private B.j dataSources_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$RequestAddDataSource.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$RequestAddDataSource smartSupportOuterClass$RequestAddDataSource = new SmartSupportOuterClass$RequestAddDataSource();
        DEFAULT_INSTANCE = smartSupportOuterClass$RequestAddDataSource;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$RequestAddDataSource.class, smartSupportOuterClass$RequestAddDataSource);
    }

    private SmartSupportOuterClass$RequestAddDataSource() {
    }

    private void addAllDataSources(Iterable<? extends SmartSupportOuterClass$DataSourceStruct> iterable) {
        ensureDataSourcesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.dataSources_);
    }

    private void addDataSources(SmartSupportOuterClass$DataSourceStruct smartSupportOuterClass$DataSourceStruct) {
        smartSupportOuterClass$DataSourceStruct.getClass();
        ensureDataSourcesIsMutable();
        this.dataSources_.add(smartSupportOuterClass$DataSourceStruct);
    }

    private void clearAgentId() {
        this.agentId_ = 0;
    }

    private void clearDataSources() {
        this.dataSources_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDataSourcesIsMutable() {
        B.j jVar = this.dataSources_;
        if (jVar.u()) {
            return;
        }
        this.dataSources_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SmartSupportOuterClass$RequestAddDataSource getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$RequestAddDataSource parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestAddDataSource) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestAddDataSource parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$RequestAddDataSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeDataSources(int i) {
        ensureDataSourcesIsMutable();
        this.dataSources_.remove(i);
    }

    private void setAgentId(int i) {
        this.agentId_ = i;
    }

    private void setDataSources(int i, SmartSupportOuterClass$DataSourceStruct smartSupportOuterClass$DataSourceStruct) {
        smartSupportOuterClass$DataSourceStruct.getClass();
        ensureDataSourcesIsMutable();
        this.dataSources_.set(i, smartSupportOuterClass$DataSourceStruct);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$RequestAddDataSource();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0001\u0000\u0002\u0004\u0003\u001b", new Object[]{"agentId_", "dataSources_", SmartSupportOuterClass$DataSourceStruct.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$RequestAddDataSource.class) {
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

    public int getAgentId() {
        return this.agentId_;
    }

    public SmartSupportOuterClass$DataSourceStruct getDataSources(int i) {
        return (SmartSupportOuterClass$DataSourceStruct) this.dataSources_.get(i);
    }

    public int getDataSourcesCount() {
        return this.dataSources_.size();
    }

    public List<SmartSupportOuterClass$DataSourceStruct> getDataSourcesList() {
        return this.dataSources_;
    }

    public JE6 getDataSourcesOrBuilder(int i) {
        return (JE6) this.dataSources_.get(i);
    }

    public List<? extends JE6> getDataSourcesOrBuilderList() {
        return this.dataSources_;
    }

    public static a newBuilder(SmartSupportOuterClass$RequestAddDataSource smartSupportOuterClass$RequestAddDataSource) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$RequestAddDataSource);
    }

    public static SmartSupportOuterClass$RequestAddDataSource parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestAddDataSource) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestAddDataSource parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestAddDataSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$RequestAddDataSource parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$RequestAddDataSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addDataSources(int i, SmartSupportOuterClass$DataSourceStruct smartSupportOuterClass$DataSourceStruct) {
        smartSupportOuterClass$DataSourceStruct.getClass();
        ensureDataSourcesIsMutable();
        this.dataSources_.add(i, smartSupportOuterClass$DataSourceStruct);
    }

    public static SmartSupportOuterClass$RequestAddDataSource parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestAddDataSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$RequestAddDataSource parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$RequestAddDataSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$RequestAddDataSource parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestAddDataSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$RequestAddDataSource parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestAddDataSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestAddDataSource parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestAddDataSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestAddDataSource parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$RequestAddDataSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$RequestAddDataSource parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestAddDataSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

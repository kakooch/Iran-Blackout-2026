package bale.smart_support.v1;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC16427lF6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
public final class SmartSupportOuterClass$ResponseGetAllDatasources extends GeneratedMessageLite implements U64 {
    public static final int DATASOURCES_FIELD_NUMBER = 1;
    private static final SmartSupportOuterClass$ResponseGetAllDatasources DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j datasources_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$ResponseGetAllDatasources.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$ResponseGetAllDatasources smartSupportOuterClass$ResponseGetAllDatasources = new SmartSupportOuterClass$ResponseGetAllDatasources();
        DEFAULT_INSTANCE = smartSupportOuterClass$ResponseGetAllDatasources;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$ResponseGetAllDatasources.class, smartSupportOuterClass$ResponseGetAllDatasources);
    }

    private SmartSupportOuterClass$ResponseGetAllDatasources() {
    }

    private void addAllDatasources(Iterable<? extends SmartSupportStruct$Datasource> iterable) {
        ensureDatasourcesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.datasources_);
    }

    private void addDatasources(SmartSupportStruct$Datasource smartSupportStruct$Datasource) {
        smartSupportStruct$Datasource.getClass();
        ensureDatasourcesIsMutable();
        this.datasources_.add(smartSupportStruct$Datasource);
    }

    private void clearDatasources() {
        this.datasources_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDatasourcesIsMutable() {
        B.j jVar = this.datasources_;
        if (jVar.u()) {
            return;
        }
        this.datasources_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SmartSupportOuterClass$ResponseGetAllDatasources getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$ResponseGetAllDatasources parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$ResponseGetAllDatasources) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$ResponseGetAllDatasources parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$ResponseGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeDatasources(int i) {
        ensureDatasourcesIsMutable();
        this.datasources_.remove(i);
    }

    private void setDatasources(int i, SmartSupportStruct$Datasource smartSupportStruct$Datasource) {
        smartSupportStruct$Datasource.getClass();
        ensureDatasourcesIsMutable();
        this.datasources_.set(i, smartSupportStruct$Datasource);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$ResponseGetAllDatasources();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"datasources_", SmartSupportStruct$Datasource.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$ResponseGetAllDatasources.class) {
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

    public SmartSupportStruct$Datasource getDatasources(int i) {
        return (SmartSupportStruct$Datasource) this.datasources_.get(i);
    }

    public int getDatasourcesCount() {
        return this.datasources_.size();
    }

    public List<SmartSupportStruct$Datasource> getDatasourcesList() {
        return this.datasources_;
    }

    public InterfaceC16427lF6 getDatasourcesOrBuilder(int i) {
        return (InterfaceC16427lF6) this.datasources_.get(i);
    }

    public List<? extends InterfaceC16427lF6> getDatasourcesOrBuilderList() {
        return this.datasources_;
    }

    public static a newBuilder(SmartSupportOuterClass$ResponseGetAllDatasources smartSupportOuterClass$ResponseGetAllDatasources) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$ResponseGetAllDatasources);
    }

    public static SmartSupportOuterClass$ResponseGetAllDatasources parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetAllDatasources) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetAllDatasources parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetAllDatasources parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$ResponseGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addDatasources(int i, SmartSupportStruct$Datasource smartSupportStruct$Datasource) {
        smartSupportStruct$Datasource.getClass();
        ensureDatasourcesIsMutable();
        this.datasources_.add(i, smartSupportStruct$Datasource);
    }

    public static SmartSupportOuterClass$ResponseGetAllDatasources parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetAllDatasources parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$ResponseGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$ResponseGetAllDatasources parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetAllDatasources parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$ResponseGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$ResponseGetAllDatasources parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetAllDatasources parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$ResponseGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$ResponseGetAllDatasources parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

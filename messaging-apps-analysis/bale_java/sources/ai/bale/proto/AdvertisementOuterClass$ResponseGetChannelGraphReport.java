package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC4713Gg;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetChannelGraphReport extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$ResponseGetChannelGraphReport DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VIEW_GRAPH_FIELD_NUMBER = 1;
    private B.j viewGraph_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetChannelGraphReport.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetChannelGraphReport advertisementOuterClass$ResponseGetChannelGraphReport = new AdvertisementOuterClass$ResponseGetChannelGraphReport();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetChannelGraphReport;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetChannelGraphReport.class, advertisementOuterClass$ResponseGetChannelGraphReport);
    }

    private AdvertisementOuterClass$ResponseGetChannelGraphReport() {
    }

    private void addAllViewGraph(Iterable<? extends AdvertisementStruct$ChannelViewGraph> iterable) {
        ensureViewGraphIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.viewGraph_);
    }

    private void addViewGraph(AdvertisementStruct$ChannelViewGraph advertisementStruct$ChannelViewGraph) {
        advertisementStruct$ChannelViewGraph.getClass();
        ensureViewGraphIsMutable();
        this.viewGraph_.add(advertisementStruct$ChannelViewGraph);
    }

    private void clearViewGraph() {
        this.viewGraph_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureViewGraphIsMutable() {
        B.j jVar = this.viewGraph_;
        if (jVar.u()) {
            return;
        }
        this.viewGraph_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementOuterClass$ResponseGetChannelGraphReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetChannelGraphReport parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetChannelGraphReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetChannelGraphReport parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetChannelGraphReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeViewGraph(int i) {
        ensureViewGraphIsMutable();
        this.viewGraph_.remove(i);
    }

    private void setViewGraph(int i, AdvertisementStruct$ChannelViewGraph advertisementStruct$ChannelViewGraph) {
        advertisementStruct$ChannelViewGraph.getClass();
        ensureViewGraphIsMutable();
        this.viewGraph_.set(i, advertisementStruct$ChannelViewGraph);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetChannelGraphReport();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"viewGraph_", AdvertisementStruct$ChannelViewGraph.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetChannelGraphReport.class) {
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

    public AdvertisementStruct$ChannelViewGraph getViewGraph(int i) {
        return (AdvertisementStruct$ChannelViewGraph) this.viewGraph_.get(i);
    }

    public int getViewGraphCount() {
        return this.viewGraph_.size();
    }

    public List<AdvertisementStruct$ChannelViewGraph> getViewGraphList() {
        return this.viewGraph_;
    }

    public InterfaceC4713Gg getViewGraphOrBuilder(int i) {
        return (InterfaceC4713Gg) this.viewGraph_.get(i);
    }

    public List<? extends InterfaceC4713Gg> getViewGraphOrBuilderList() {
        return this.viewGraph_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetChannelGraphReport advertisementOuterClass$ResponseGetChannelGraphReport) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetChannelGraphReport);
    }

    public static AdvertisementOuterClass$ResponseGetChannelGraphReport parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelGraphReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelGraphReport parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelGraphReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelGraphReport parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetChannelGraphReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addViewGraph(int i, AdvertisementStruct$ChannelViewGraph advertisementStruct$ChannelViewGraph) {
        advertisementStruct$ChannelViewGraph.getClass();
        ensureViewGraphIsMutable();
        this.viewGraph_.add(i, advertisementStruct$ChannelViewGraph);
    }

    public static AdvertisementOuterClass$ResponseGetChannelGraphReport parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelGraphReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelGraphReport parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetChannelGraphReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetChannelGraphReport parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelGraphReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelGraphReport parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetChannelGraphReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetChannelGraphReport parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelGraphReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelGraphReport parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetChannelGraphReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetChannelGraphReport parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelGraphReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

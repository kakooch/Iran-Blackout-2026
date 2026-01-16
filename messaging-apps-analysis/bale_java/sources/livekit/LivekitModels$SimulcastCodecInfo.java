package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC12224eF3;
import ir.nasim.KW4;
import ir.nasim.XE3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitModels$SimulcastCodecInfo extends GeneratedMessageLite implements XE3 {
    public static final int CID_FIELD_NUMBER = 3;
    private static final LivekitModels$SimulcastCodecInfo DEFAULT_INSTANCE;
    public static final int LAYERS_FIELD_NUMBER = 4;
    public static final int MID_FIELD_NUMBER = 2;
    public static final int MIME_TYPE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String mimeType_ = "";
    private String mid_ = "";
    private String cid_ = "";
    private B.j layers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements XE3 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$SimulcastCodecInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$SimulcastCodecInfo livekitModels$SimulcastCodecInfo = new LivekitModels$SimulcastCodecInfo();
        DEFAULT_INSTANCE = livekitModels$SimulcastCodecInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$SimulcastCodecInfo.class, livekitModels$SimulcastCodecInfo);
    }

    private LivekitModels$SimulcastCodecInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLayers(Iterable<? extends LivekitModels$VideoLayer> iterable) {
        ensureLayersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.layers_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLayers(LivekitModels$VideoLayer livekitModels$VideoLayer) {
        livekitModels$VideoLayer.getClass();
        ensureLayersIsMutable();
        this.layers_.add(livekitModels$VideoLayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCid() {
        this.cid_ = getDefaultInstance().getCid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLayers() {
        this.layers_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMid() {
        this.mid_ = getDefaultInstance().getMid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMimeType() {
        this.mimeType_ = getDefaultInstance().getMimeType();
    }

    private void ensureLayersIsMutable() {
        B.j jVar = this.layers_;
        if (jVar.u()) {
            return;
        }
        this.layers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitModels$SimulcastCodecInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$SimulcastCodecInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$SimulcastCodecInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$SimulcastCodecInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$SimulcastCodecInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLayers(int i) {
        ensureLayersIsMutable();
        this.layers_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCid(String str) {
        str.getClass();
        this.cid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cid_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayers(int i, LivekitModels$VideoLayer livekitModels$VideoLayer) {
        livekitModels$VideoLayer.getClass();
        ensureLayersIsMutable();
        this.layers_.set(i, livekitModels$VideoLayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMid(String str) {
        str.getClass();
        this.mid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.mid_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMimeType(String str) {
        str.getClass();
        this.mimeType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMimeTypeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.mimeType_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$SimulcastCodecInfo();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u001b", new Object[]{"mimeType_", "mid_", "cid_", "layers_", LivekitModels$VideoLayer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$SimulcastCodecInfo.class) {
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

    public String getCid() {
        return this.cid_;
    }

    public AbstractC2383g getCidBytes() {
        return AbstractC2383g.N(this.cid_);
    }

    public LivekitModels$VideoLayer getLayers(int i) {
        return (LivekitModels$VideoLayer) this.layers_.get(i);
    }

    public int getLayersCount() {
        return this.layers_.size();
    }

    public List<LivekitModels$VideoLayer> getLayersList() {
        return this.layers_;
    }

    public InterfaceC12224eF3 getLayersOrBuilder(int i) {
        return (InterfaceC12224eF3) this.layers_.get(i);
    }

    public List<? extends InterfaceC12224eF3> getLayersOrBuilderList() {
        return this.layers_;
    }

    public String getMid() {
        return this.mid_;
    }

    public AbstractC2383g getMidBytes() {
        return AbstractC2383g.N(this.mid_);
    }

    public String getMimeType() {
        return this.mimeType_;
    }

    public AbstractC2383g getMimeTypeBytes() {
        return AbstractC2383g.N(this.mimeType_);
    }

    public static a newBuilder(LivekitModels$SimulcastCodecInfo livekitModels$SimulcastCodecInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$SimulcastCodecInfo);
    }

    public static LivekitModels$SimulcastCodecInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$SimulcastCodecInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$SimulcastCodecInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$SimulcastCodecInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$SimulcastCodecInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$SimulcastCodecInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLayers(int i, LivekitModels$VideoLayer livekitModels$VideoLayer) {
        livekitModels$VideoLayer.getClass();
        ensureLayersIsMutable();
        this.layers_.add(i, livekitModels$VideoLayer);
    }

    public static LivekitModels$SimulcastCodecInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$SimulcastCodecInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$SimulcastCodecInfo parseFrom(byte[] bArr) {
        return (LivekitModels$SimulcastCodecInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$SimulcastCodecInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$SimulcastCodecInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$SimulcastCodecInfo parseFrom(InputStream inputStream) {
        return (LivekitModels$SimulcastCodecInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$SimulcastCodecInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$SimulcastCodecInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$SimulcastCodecInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$SimulcastCodecInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$SimulcastCodecInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$SimulcastCodecInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

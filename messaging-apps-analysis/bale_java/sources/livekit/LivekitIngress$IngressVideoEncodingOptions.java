package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC11581dF3;
import ir.nasim.InterfaceC12224eF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitIngress$IngressVideoEncodingOptions extends GeneratedMessageLite implements U64 {
    private static final LivekitIngress$IngressVideoEncodingOptions DEFAULT_INSTANCE;
    public static final int FRAME_RATE_FIELD_NUMBER = 2;
    public static final int LAYERS_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int VIDEO_CODEC_FIELD_NUMBER = 1;
    private double frameRate_;
    private B.j layers_ = GeneratedMessageLite.emptyProtobufList();
    private int videoCodec_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(l lVar) {
            this();
        }

        private a() {
            super(LivekitIngress$IngressVideoEncodingOptions.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitIngress$IngressVideoEncodingOptions livekitIngress$IngressVideoEncodingOptions = new LivekitIngress$IngressVideoEncodingOptions();
        DEFAULT_INSTANCE = livekitIngress$IngressVideoEncodingOptions;
        GeneratedMessageLite.registerDefaultInstance(LivekitIngress$IngressVideoEncodingOptions.class, livekitIngress$IngressVideoEncodingOptions);
    }

    private LivekitIngress$IngressVideoEncodingOptions() {
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
    public void clearFrameRate() {
        this.frameRate_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLayers() {
        this.layers_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVideoCodec() {
        this.videoCodec_ = 0;
    }

    private void ensureLayersIsMutable() {
        B.j jVar = this.layers_;
        if (jVar.u()) {
            return;
        }
        this.layers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitIngress$IngressVideoEncodingOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitIngress$IngressVideoEncodingOptions parseDelimitedFrom(InputStream inputStream) {
        return (LivekitIngress$IngressVideoEncodingOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$IngressVideoEncodingOptions parseFrom(ByteBuffer byteBuffer) {
        return (LivekitIngress$IngressVideoEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setFrameRate(double d) {
        this.frameRate_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayers(int i, LivekitModels$VideoLayer livekitModels$VideoLayer) {
        livekitModels$VideoLayer.getClass();
        ensureLayersIsMutable();
        this.layers_.set(i, livekitModels$VideoLayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoCodec(EnumC11581dF3 enumC11581dF3) {
        this.videoCodec_ = enumC11581dF3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoCodecValue(int i) {
        this.videoCodec_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        l lVar = null;
        switch (l.a[gVar.ordinal()]) {
            case 1:
                return new LivekitIngress$IngressVideoEncodingOptions();
            case 2:
                return new a(lVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\f\u0002\u0000\u0003\u001b", new Object[]{"videoCodec_", "frameRate_", "layers_", LivekitModels$VideoLayer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitIngress$IngressVideoEncodingOptions.class) {
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

    public double getFrameRate() {
        return this.frameRate_;
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

    public EnumC11581dF3 getVideoCodec() {
        EnumC11581dF3 enumC11581dF3J = EnumC11581dF3.j(this.videoCodec_);
        return enumC11581dF3J == null ? EnumC11581dF3.UNRECOGNIZED : enumC11581dF3J;
    }

    public int getVideoCodecValue() {
        return this.videoCodec_;
    }

    public static a newBuilder(LivekitIngress$IngressVideoEncodingOptions livekitIngress$IngressVideoEncodingOptions) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitIngress$IngressVideoEncodingOptions);
    }

    public static LivekitIngress$IngressVideoEncodingOptions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$IngressVideoEncodingOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$IngressVideoEncodingOptions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitIngress$IngressVideoEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitIngress$IngressVideoEncodingOptions parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitIngress$IngressVideoEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLayers(int i, LivekitModels$VideoLayer livekitModels$VideoLayer) {
        livekitModels$VideoLayer.getClass();
        ensureLayersIsMutable();
        this.layers_.add(i, livekitModels$VideoLayer);
    }

    public static LivekitIngress$IngressVideoEncodingOptions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitIngress$IngressVideoEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitIngress$IngressVideoEncodingOptions parseFrom(byte[] bArr) {
        return (LivekitIngress$IngressVideoEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitIngress$IngressVideoEncodingOptions parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitIngress$IngressVideoEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitIngress$IngressVideoEncodingOptions parseFrom(InputStream inputStream) {
        return (LivekitIngress$IngressVideoEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$IngressVideoEncodingOptions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$IngressVideoEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$IngressVideoEncodingOptions parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitIngress$IngressVideoEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitIngress$IngressVideoEncodingOptions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitIngress$IngressVideoEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

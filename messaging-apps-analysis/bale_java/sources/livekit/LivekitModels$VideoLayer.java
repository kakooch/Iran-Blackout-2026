package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC12833fF3;
import ir.nasim.InterfaceC12224eF3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitModels$VideoLayer extends GeneratedMessageLite implements InterfaceC12224eF3 {
    public static final int BITRATE_FIELD_NUMBER = 4;
    private static final LivekitModels$VideoLayer DEFAULT_INSTANCE;
    public static final int HEIGHT_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int QUALITY_FIELD_NUMBER = 1;
    public static final int RID_FIELD_NUMBER = 7;
    public static final int SPATIAL_LAYER_FIELD_NUMBER = 6;
    public static final int SSRC_FIELD_NUMBER = 5;
    public static final int WIDTH_FIELD_NUMBER = 2;
    private int bitrate_;
    private int height_;
    private int quality_;
    private String rid_ = "";
    private int spatialLayer_;
    private int ssrc_;
    private int width_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC12224eF3 {
        /* synthetic */ a(o oVar) {
            this();
        }

        public a A(int i) {
            q();
            ((LivekitModels$VideoLayer) this.b).setBitrate(i);
            return this;
        }

        public a B(int i) {
            q();
            ((LivekitModels$VideoLayer) this.b).setHeight(i);
            return this;
        }

        public a C(EnumC12833fF3 enumC12833fF3) {
            q();
            ((LivekitModels$VideoLayer) this.b).setQuality(enumC12833fF3);
            return this;
        }

        public a D(int i) {
            q();
            ((LivekitModels$VideoLayer) this.b).setSsrc(i);
            return this;
        }

        public a E(int i) {
            q();
            ((LivekitModels$VideoLayer) this.b).setWidth(i);
            return this;
        }

        private a() {
            super(LivekitModels$VideoLayer.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$VideoLayer livekitModels$VideoLayer = new LivekitModels$VideoLayer();
        DEFAULT_INSTANCE = livekitModels$VideoLayer;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$VideoLayer.class, livekitModels$VideoLayer);
    }

    private LivekitModels$VideoLayer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBitrate() {
        this.bitrate_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeight() {
        this.height_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearQuality() {
        this.quality_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRid() {
        this.rid_ = getDefaultInstance().getRid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSpatialLayer() {
        this.spatialLayer_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSsrc() {
        this.ssrc_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWidth() {
        this.width_ = 0;
    }

    public static LivekitModels$VideoLayer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$VideoLayer parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$VideoLayer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$VideoLayer parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$VideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBitrate(int i) {
        this.bitrate_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        this.height_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuality(EnumC12833fF3 enumC12833fF3) {
        this.quality_ = enumC12833fF3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQualityValue(int i) {
        this.quality_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRid(String str) {
        str.getClass();
        this.rid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.rid_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpatialLayer(int i) {
        this.spatialLayer_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSsrc(int i) {
        this.ssrc_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidth(int i) {
        this.width_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$VideoLayer();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\f\u0002\u000b\u0003\u000b\u0004\u000b\u0005\u000b\u0006\u0004\u0007Ȉ", new Object[]{"quality_", "width_", "height_", "bitrate_", "ssrc_", "spatialLayer_", "rid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$VideoLayer.class) {
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

    public int getBitrate() {
        return this.bitrate_;
    }

    public int getHeight() {
        return this.height_;
    }

    public EnumC12833fF3 getQuality() {
        EnumC12833fF3 enumC12833fF3J = EnumC12833fF3.j(this.quality_);
        return enumC12833fF3J == null ? EnumC12833fF3.UNRECOGNIZED : enumC12833fF3J;
    }

    public int getQualityValue() {
        return this.quality_;
    }

    public String getRid() {
        return this.rid_;
    }

    public AbstractC2383g getRidBytes() {
        return AbstractC2383g.N(this.rid_);
    }

    public int getSpatialLayer() {
        return this.spatialLayer_;
    }

    public int getSsrc() {
        return this.ssrc_;
    }

    public int getWidth() {
        return this.width_;
    }

    public static a newBuilder(LivekitModels$VideoLayer livekitModels$VideoLayer) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$VideoLayer);
    }

    public static LivekitModels$VideoLayer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$VideoLayer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$VideoLayer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$VideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$VideoLayer parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$VideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$VideoLayer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$VideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$VideoLayer parseFrom(byte[] bArr) {
        return (LivekitModels$VideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$VideoLayer parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$VideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$VideoLayer parseFrom(InputStream inputStream) {
        return (LivekitModels$VideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$VideoLayer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$VideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$VideoLayer parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$VideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$VideoLayer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$VideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

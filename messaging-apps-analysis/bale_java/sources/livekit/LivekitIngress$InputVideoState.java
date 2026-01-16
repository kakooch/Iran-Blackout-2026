package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitIngress$InputVideoState extends GeneratedMessageLite implements U64 {
    public static final int AVERAGE_BITRATE_FIELD_NUMBER = 2;
    private static final LivekitIngress$InputVideoState DEFAULT_INSTANCE;
    public static final int FRAMERATE_FIELD_NUMBER = 5;
    public static final int HEIGHT_FIELD_NUMBER = 4;
    public static final int MIME_TYPE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int WIDTH_FIELD_NUMBER = 3;
    private int averageBitrate_;
    private double framerate_;
    private int height_;
    private String mimeType_ = "";
    private int width_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(l lVar) {
            this();
        }

        private a() {
            super(LivekitIngress$InputVideoState.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitIngress$InputVideoState livekitIngress$InputVideoState = new LivekitIngress$InputVideoState();
        DEFAULT_INSTANCE = livekitIngress$InputVideoState;
        GeneratedMessageLite.registerDefaultInstance(LivekitIngress$InputVideoState.class, livekitIngress$InputVideoState);
    }

    private LivekitIngress$InputVideoState() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAverageBitrate() {
        this.averageBitrate_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFramerate() {
        this.framerate_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeight() {
        this.height_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMimeType() {
        this.mimeType_ = getDefaultInstance().getMimeType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWidth() {
        this.width_ = 0;
    }

    public static LivekitIngress$InputVideoState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitIngress$InputVideoState parseDelimitedFrom(InputStream inputStream) {
        return (LivekitIngress$InputVideoState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$InputVideoState parseFrom(ByteBuffer byteBuffer) {
        return (LivekitIngress$InputVideoState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAverageBitrate(int i) {
        this.averageBitrate_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFramerate(double d) {
        this.framerate_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        this.height_ = i;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidth(int i) {
        this.width_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        l lVar = null;
        switch (l.a[gVar.ordinal()]) {
            case 1:
                return new LivekitIngress$InputVideoState();
            case 2:
                return new a(lVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\u000b\u0003\u000b\u0004\u000b\u0005\u0000", new Object[]{"mimeType_", "averageBitrate_", "width_", "height_", "framerate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitIngress$InputVideoState.class) {
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

    public int getAverageBitrate() {
        return this.averageBitrate_;
    }

    public double getFramerate() {
        return this.framerate_;
    }

    public int getHeight() {
        return this.height_;
    }

    public String getMimeType() {
        return this.mimeType_;
    }

    public AbstractC2383g getMimeTypeBytes() {
        return AbstractC2383g.N(this.mimeType_);
    }

    public int getWidth() {
        return this.width_;
    }

    public static a newBuilder(LivekitIngress$InputVideoState livekitIngress$InputVideoState) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitIngress$InputVideoState);
    }

    public static LivekitIngress$InputVideoState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$InputVideoState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$InputVideoState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitIngress$InputVideoState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitIngress$InputVideoState parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitIngress$InputVideoState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitIngress$InputVideoState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitIngress$InputVideoState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitIngress$InputVideoState parseFrom(byte[] bArr) {
        return (LivekitIngress$InputVideoState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitIngress$InputVideoState parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitIngress$InputVideoState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitIngress$InputVideoState parseFrom(InputStream inputStream) {
        return (LivekitIngress$InputVideoState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$InputVideoState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$InputVideoState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$InputVideoState parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitIngress$InputVideoState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitIngress$InputVideoState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitIngress$InputVideoState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

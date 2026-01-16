package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC12833fF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitRtc$UpdateTrackSettings extends GeneratedMessageLite implements U64 {
    private static final LivekitRtc$UpdateTrackSettings DEFAULT_INSTANCE;
    public static final int DISABLED_FIELD_NUMBER = 3;
    public static final int FPS_FIELD_NUMBER = 7;
    public static final int HEIGHT_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int PRIORITY_FIELD_NUMBER = 8;
    public static final int QUALITY_FIELD_NUMBER = 4;
    public static final int TRACK_SIDS_FIELD_NUMBER = 1;
    public static final int WIDTH_FIELD_NUMBER = 5;
    private boolean disabled_;
    private int fps_;
    private int height_;
    private int priority_;
    private int quality_;
    private B.j trackSids_ = GeneratedMessageLite.emptyProtobufList();
    private int width_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        public a A(String str) {
            q();
            ((LivekitRtc$UpdateTrackSettings) this.b).addTrackSids(str);
            return this;
        }

        public a B(boolean z) {
            q();
            ((LivekitRtc$UpdateTrackSettings) this.b).setDisabled(z);
            return this;
        }

        public a C(int i) {
            q();
            ((LivekitRtc$UpdateTrackSettings) this.b).setFps(i);
            return this;
        }

        public a D(int i) {
            q();
            ((LivekitRtc$UpdateTrackSettings) this.b).setHeight(i);
            return this;
        }

        public a E(EnumC12833fF3 enumC12833fF3) {
            q();
            ((LivekitRtc$UpdateTrackSettings) this.b).setQuality(enumC12833fF3);
            return this;
        }

        public a F(int i) {
            q();
            ((LivekitRtc$UpdateTrackSettings) this.b).setWidth(i);
            return this;
        }

        private a() {
            super(LivekitRtc$UpdateTrackSettings.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$UpdateTrackSettings livekitRtc$UpdateTrackSettings = new LivekitRtc$UpdateTrackSettings();
        DEFAULT_INSTANCE = livekitRtc$UpdateTrackSettings;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$UpdateTrackSettings.class, livekitRtc$UpdateTrackSettings);
    }

    private LivekitRtc$UpdateTrackSettings() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTrackSids(Iterable<String> iterable) {
        ensureTrackSidsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.trackSids_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTrackSids(String str) {
        str.getClass();
        ensureTrackSidsIsMutable();
        this.trackSids_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTrackSidsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureTrackSidsIsMutable();
        this.trackSids_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisabled() {
        this.disabled_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFps() {
        this.fps_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeight() {
        this.height_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPriority() {
        this.priority_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearQuality() {
        this.quality_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSids() {
        this.trackSids_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWidth() {
        this.width_ = 0;
    }

    private void ensureTrackSidsIsMutable() {
        B.j jVar = this.trackSids_;
        if (jVar.u()) {
            return;
        }
        this.trackSids_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRtc$UpdateTrackSettings getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$UpdateTrackSettings parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$UpdateTrackSettings) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$UpdateTrackSettings parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$UpdateTrackSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisabled(boolean z) {
        this.disabled_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFps(int i) {
        this.fps_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        this.height_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPriority(int i) {
        this.priority_ = i;
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
    public void setTrackSids(int i, String str) {
        str.getClass();
        ensureTrackSidsIsMutable();
        this.trackSids_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidth(int i) {
        this.width_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$UpdateTrackSettings();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\b\u0007\u0000\u0001\u0000\u0001Ț\u0003\u0007\u0004\f\u0005\u000b\u0006\u000b\u0007\u000b\b\u000b", new Object[]{"trackSids_", "disabled_", "quality_", "width_", "height_", "fps_", "priority_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$UpdateTrackSettings.class) {
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

    public boolean getDisabled() {
        return this.disabled_;
    }

    public int getFps() {
        return this.fps_;
    }

    public int getHeight() {
        return this.height_;
    }

    public int getPriority() {
        return this.priority_;
    }

    public EnumC12833fF3 getQuality() {
        EnumC12833fF3 enumC12833fF3J = EnumC12833fF3.j(this.quality_);
        return enumC12833fF3J == null ? EnumC12833fF3.UNRECOGNIZED : enumC12833fF3J;
    }

    public int getQualityValue() {
        return this.quality_;
    }

    public String getTrackSids(int i) {
        return (String) this.trackSids_.get(i);
    }

    public AbstractC2383g getTrackSidsBytes(int i) {
        return AbstractC2383g.N((String) this.trackSids_.get(i));
    }

    public int getTrackSidsCount() {
        return this.trackSids_.size();
    }

    public List<String> getTrackSidsList() {
        return this.trackSids_;
    }

    public int getWidth() {
        return this.width_;
    }

    public static a newBuilder(LivekitRtc$UpdateTrackSettings livekitRtc$UpdateTrackSettings) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$UpdateTrackSettings);
    }

    public static LivekitRtc$UpdateTrackSettings parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$UpdateTrackSettings) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$UpdateTrackSettings parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$UpdateTrackSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$UpdateTrackSettings parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$UpdateTrackSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$UpdateTrackSettings parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$UpdateTrackSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$UpdateTrackSettings parseFrom(byte[] bArr) {
        return (LivekitRtc$UpdateTrackSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$UpdateTrackSettings parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$UpdateTrackSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$UpdateTrackSettings parseFrom(InputStream inputStream) {
        return (LivekitRtc$UpdateTrackSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$UpdateTrackSettings parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$UpdateTrackSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$UpdateTrackSettings parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$UpdateTrackSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$UpdateTrackSettings parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$UpdateTrackSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC11581dF3;
import ir.nasim.KW4;
import ir.nasim.LE3;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitEgress$EncodingOptions extends GeneratedMessageLite implements U64 {
    public static final int AUDIO_BITRATE_FIELD_NUMBER = 6;
    public static final int AUDIO_CODEC_FIELD_NUMBER = 5;
    public static final int AUDIO_FREQUENCY_FIELD_NUMBER = 7;
    public static final int AUDIO_QUALITY_FIELD_NUMBER = 11;
    private static final LivekitEgress$EncodingOptions DEFAULT_INSTANCE;
    public static final int DEPTH_FIELD_NUMBER = 3;
    public static final int FRAMERATE_FIELD_NUMBER = 4;
    public static final int HEIGHT_FIELD_NUMBER = 2;
    public static final int KEY_FRAME_INTERVAL_FIELD_NUMBER = 10;
    private static volatile KW4 PARSER = null;
    public static final int VIDEO_BITRATE_FIELD_NUMBER = 9;
    public static final int VIDEO_CODEC_FIELD_NUMBER = 8;
    public static final int VIDEO_QUALITY_FIELD_NUMBER = 12;
    public static final int WIDTH_FIELD_NUMBER = 1;
    private int audioBitrate_;
    private int audioCodec_;
    private int audioFrequency_;
    private int audioQuality_;
    private int depth_;
    private int framerate_;
    private int height_;
    private double keyFrameInterval_;
    private int videoBitrate_;
    private int videoCodec_;
    private int videoQuality_;
    private int width_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$EncodingOptions.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitEgress$EncodingOptions livekitEgress$EncodingOptions = new LivekitEgress$EncodingOptions();
        DEFAULT_INSTANCE = livekitEgress$EncodingOptions;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$EncodingOptions.class, livekitEgress$EncodingOptions);
    }

    private LivekitEgress$EncodingOptions() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudioBitrate() {
        this.audioBitrate_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudioCodec() {
        this.audioCodec_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudioFrequency() {
        this.audioFrequency_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudioQuality() {
        this.audioQuality_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDepth() {
        this.depth_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFramerate() {
        this.framerate_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeight() {
        this.height_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyFrameInterval() {
        this.keyFrameInterval_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVideoBitrate() {
        this.videoBitrate_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVideoCodec() {
        this.videoCodec_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVideoQuality() {
        this.videoQuality_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWidth() {
        this.width_ = 0;
    }

    public static LivekitEgress$EncodingOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$EncodingOptions parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$EncodingOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$EncodingOptions parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$EncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioBitrate(int i) {
        this.audioBitrate_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioCodec(LE3 le3) {
        this.audioCodec_ = le3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioCodecValue(int i) {
        this.audioCodec_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioFrequency(int i) {
        this.audioFrequency_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioQuality(int i) {
        this.audioQuality_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDepth(int i) {
        this.depth_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFramerate(int i) {
        this.framerate_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        this.height_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyFrameInterval(double d) {
        this.keyFrameInterval_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoBitrate(int i) {
        this.videoBitrate_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoCodec(EnumC11581dF3 enumC11581dF3) {
        this.videoCodec_ = enumC11581dF3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoCodecValue(int i) {
        this.videoCodec_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoQuality(int i) {
        this.videoQuality_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidth(int i) {
        this.width_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$EncodingOptions();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\f\u0000\u0000\u0001\f\f\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004\u0004\u0004\u0005\f\u0006\u0004\u0007\u0004\b\f\t\u0004\n\u0000\u000b\u0004\f\u0004", new Object[]{"width_", "height_", "depth_", "framerate_", "audioCodec_", "audioBitrate_", "audioFrequency_", "videoCodec_", "videoBitrate_", "keyFrameInterval_", "audioQuality_", "videoQuality_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$EncodingOptions.class) {
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

    public int getAudioBitrate() {
        return this.audioBitrate_;
    }

    public LE3 getAudioCodec() {
        LE3 le3J = LE3.j(this.audioCodec_);
        return le3J == null ? LE3.UNRECOGNIZED : le3J;
    }

    public int getAudioCodecValue() {
        return this.audioCodec_;
    }

    public int getAudioFrequency() {
        return this.audioFrequency_;
    }

    public int getAudioQuality() {
        return this.audioQuality_;
    }

    public int getDepth() {
        return this.depth_;
    }

    public int getFramerate() {
        return this.framerate_;
    }

    public int getHeight() {
        return this.height_;
    }

    public double getKeyFrameInterval() {
        return this.keyFrameInterval_;
    }

    public int getVideoBitrate() {
        return this.videoBitrate_;
    }

    public EnumC11581dF3 getVideoCodec() {
        EnumC11581dF3 enumC11581dF3J = EnumC11581dF3.j(this.videoCodec_);
        return enumC11581dF3J == null ? EnumC11581dF3.UNRECOGNIZED : enumC11581dF3J;
    }

    public int getVideoCodecValue() {
        return this.videoCodec_;
    }

    public int getVideoQuality() {
        return this.videoQuality_;
    }

    public int getWidth() {
        return this.width_;
    }

    public static a newBuilder(LivekitEgress$EncodingOptions livekitEgress$EncodingOptions) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$EncodingOptions);
    }

    public static LivekitEgress$EncodingOptions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$EncodingOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$EncodingOptions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$EncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$EncodingOptions parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$EncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitEgress$EncodingOptions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$EncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$EncodingOptions parseFrom(byte[] bArr) {
        return (LivekitEgress$EncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$EncodingOptions parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$EncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$EncodingOptions parseFrom(InputStream inputStream) {
        return (LivekitEgress$EncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$EncodingOptions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$EncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$EncodingOptions parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$EncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$EncodingOptions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$EncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

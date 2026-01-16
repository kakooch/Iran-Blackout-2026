package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.LE3;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitIngress$IngressAudioEncodingOptions extends GeneratedMessageLite implements U64 {
    public static final int AUDIO_CODEC_FIELD_NUMBER = 1;
    public static final int BITRATE_FIELD_NUMBER = 2;
    public static final int CHANNELS_FIELD_NUMBER = 4;
    private static final LivekitIngress$IngressAudioEncodingOptions DEFAULT_INSTANCE;
    public static final int DISABLE_DTX_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private int audioCodec_;
    private int bitrate_;
    private int channels_;
    private boolean disableDtx_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(l lVar) {
            this();
        }

        private a() {
            super(LivekitIngress$IngressAudioEncodingOptions.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitIngress$IngressAudioEncodingOptions livekitIngress$IngressAudioEncodingOptions = new LivekitIngress$IngressAudioEncodingOptions();
        DEFAULT_INSTANCE = livekitIngress$IngressAudioEncodingOptions;
        GeneratedMessageLite.registerDefaultInstance(LivekitIngress$IngressAudioEncodingOptions.class, livekitIngress$IngressAudioEncodingOptions);
    }

    private LivekitIngress$IngressAudioEncodingOptions() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudioCodec() {
        this.audioCodec_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBitrate() {
        this.bitrate_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChannels() {
        this.channels_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisableDtx() {
        this.disableDtx_ = false;
    }

    public static LivekitIngress$IngressAudioEncodingOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitIngress$IngressAudioEncodingOptions parseDelimitedFrom(InputStream inputStream) {
        return (LivekitIngress$IngressAudioEncodingOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$IngressAudioEncodingOptions parseFrom(ByteBuffer byteBuffer) {
        return (LivekitIngress$IngressAudioEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
    public void setBitrate(int i) {
        this.bitrate_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChannels(int i) {
        this.channels_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisableDtx(boolean z) {
        this.disableDtx_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        l lVar = null;
        switch (l.a[gVar.ordinal()]) {
            case 1:
                return new LivekitIngress$IngressAudioEncodingOptions();
            case 2:
                return new a(lVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0002\u000b\u0003\u0007\u0004\u000b", new Object[]{"audioCodec_", "bitrate_", "disableDtx_", "channels_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitIngress$IngressAudioEncodingOptions.class) {
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

    public LE3 getAudioCodec() {
        LE3 le3J = LE3.j(this.audioCodec_);
        return le3J == null ? LE3.UNRECOGNIZED : le3J;
    }

    public int getAudioCodecValue() {
        return this.audioCodec_;
    }

    public int getBitrate() {
        return this.bitrate_;
    }

    public int getChannels() {
        return this.channels_;
    }

    public boolean getDisableDtx() {
        return this.disableDtx_;
    }

    public static a newBuilder(LivekitIngress$IngressAudioEncodingOptions livekitIngress$IngressAudioEncodingOptions) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitIngress$IngressAudioEncodingOptions);
    }

    public static LivekitIngress$IngressAudioEncodingOptions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$IngressAudioEncodingOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$IngressAudioEncodingOptions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitIngress$IngressAudioEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitIngress$IngressAudioEncodingOptions parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitIngress$IngressAudioEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitIngress$IngressAudioEncodingOptions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitIngress$IngressAudioEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitIngress$IngressAudioEncodingOptions parseFrom(byte[] bArr) {
        return (LivekitIngress$IngressAudioEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitIngress$IngressAudioEncodingOptions parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitIngress$IngressAudioEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitIngress$IngressAudioEncodingOptions parseFrom(InputStream inputStream) {
        return (LivekitIngress$IngressAudioEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$IngressAudioEncodingOptions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$IngressAudioEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$IngressAudioEncodingOptions parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitIngress$IngressAudioEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitIngress$IngressAudioEncodingOptions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitIngress$IngressAudioEncodingOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

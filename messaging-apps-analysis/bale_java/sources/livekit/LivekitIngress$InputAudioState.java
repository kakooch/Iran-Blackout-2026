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
public final class LivekitIngress$InputAudioState extends GeneratedMessageLite implements U64 {
    public static final int AVERAGE_BITRATE_FIELD_NUMBER = 2;
    public static final int CHANNELS_FIELD_NUMBER = 3;
    private static final LivekitIngress$InputAudioState DEFAULT_INSTANCE;
    public static final int MIME_TYPE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SAMPLE_RATE_FIELD_NUMBER = 4;
    private int averageBitrate_;
    private int channels_;
    private String mimeType_ = "";
    private int sampleRate_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(l lVar) {
            this();
        }

        private a() {
            super(LivekitIngress$InputAudioState.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitIngress$InputAudioState livekitIngress$InputAudioState = new LivekitIngress$InputAudioState();
        DEFAULT_INSTANCE = livekitIngress$InputAudioState;
        GeneratedMessageLite.registerDefaultInstance(LivekitIngress$InputAudioState.class, livekitIngress$InputAudioState);
    }

    private LivekitIngress$InputAudioState() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAverageBitrate() {
        this.averageBitrate_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChannels() {
        this.channels_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMimeType() {
        this.mimeType_ = getDefaultInstance().getMimeType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSampleRate() {
        this.sampleRate_ = 0;
    }

    public static LivekitIngress$InputAudioState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitIngress$InputAudioState parseDelimitedFrom(InputStream inputStream) {
        return (LivekitIngress$InputAudioState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$InputAudioState parseFrom(ByteBuffer byteBuffer) {
        return (LivekitIngress$InputAudioState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAverageBitrate(int i) {
        this.averageBitrate_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChannels(int i) {
        this.channels_ = i;
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
    public void setSampleRate(int i) {
        this.sampleRate_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        l lVar = null;
        switch (l.a[gVar.ordinal()]) {
            case 1:
                return new LivekitIngress$InputAudioState();
            case 2:
                return new a(lVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\u000b\u0003\u000b\u0004\u000b", new Object[]{"mimeType_", "averageBitrate_", "channels_", "sampleRate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitIngress$InputAudioState.class) {
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

    public int getChannels() {
        return this.channels_;
    }

    public String getMimeType() {
        return this.mimeType_;
    }

    public AbstractC2383g getMimeTypeBytes() {
        return AbstractC2383g.N(this.mimeType_);
    }

    public int getSampleRate() {
        return this.sampleRate_;
    }

    public static a newBuilder(LivekitIngress$InputAudioState livekitIngress$InputAudioState) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitIngress$InputAudioState);
    }

    public static LivekitIngress$InputAudioState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$InputAudioState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$InputAudioState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitIngress$InputAudioState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitIngress$InputAudioState parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitIngress$InputAudioState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitIngress$InputAudioState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitIngress$InputAudioState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitIngress$InputAudioState parseFrom(byte[] bArr) {
        return (LivekitIngress$InputAudioState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitIngress$InputAudioState parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitIngress$InputAudioState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitIngress$InputAudioState parseFrom(InputStream inputStream) {
        return (LivekitIngress$InputAudioState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$InputAudioState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$InputAudioState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$InputAudioState parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitIngress$InputAudioState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitIngress$InputAudioState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitIngress$InputAudioState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

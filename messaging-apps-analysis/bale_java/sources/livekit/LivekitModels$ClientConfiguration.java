package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.OE3;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitModels$DisabledCodecs;
import livekit.LivekitModels$VideoConfiguration;

/* loaded from: classes8.dex */
public final class LivekitModels$ClientConfiguration extends GeneratedMessageLite implements U64 {
    private static final LivekitModels$ClientConfiguration DEFAULT_INSTANCE;
    public static final int DISABLED_CODECS_FIELD_NUMBER = 4;
    public static final int FORCE_RELAY_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int RESUME_CONNECTION_FIELD_NUMBER = 3;
    public static final int SCREEN_FIELD_NUMBER = 2;
    public static final int VIDEO_FIELD_NUMBER = 1;
    private LivekitModels$DisabledCodecs disabledCodecs_;
    private int forceRelay_;
    private int resumeConnection_;
    private LivekitModels$VideoConfiguration screen_;
    private LivekitModels$VideoConfiguration video_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$ClientConfiguration.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$ClientConfiguration livekitModels$ClientConfiguration = new LivekitModels$ClientConfiguration();
        DEFAULT_INSTANCE = livekitModels$ClientConfiguration;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$ClientConfiguration.class, livekitModels$ClientConfiguration);
    }

    private LivekitModels$ClientConfiguration() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisabledCodecs() {
        this.disabledCodecs_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearForceRelay() {
        this.forceRelay_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResumeConnection() {
        this.resumeConnection_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScreen() {
        this.screen_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVideo() {
        this.video_ = null;
    }

    public static LivekitModels$ClientConfiguration getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDisabledCodecs(LivekitModels$DisabledCodecs livekitModels$DisabledCodecs) {
        livekitModels$DisabledCodecs.getClass();
        LivekitModels$DisabledCodecs livekitModels$DisabledCodecs2 = this.disabledCodecs_;
        if (livekitModels$DisabledCodecs2 == null || livekitModels$DisabledCodecs2 == LivekitModels$DisabledCodecs.getDefaultInstance()) {
            this.disabledCodecs_ = livekitModels$DisabledCodecs;
        } else {
            this.disabledCodecs_ = (LivekitModels$DisabledCodecs) ((LivekitModels$DisabledCodecs.a) LivekitModels$DisabledCodecs.newBuilder(this.disabledCodecs_).v(livekitModels$DisabledCodecs)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeScreen(LivekitModels$VideoConfiguration livekitModels$VideoConfiguration) {
        livekitModels$VideoConfiguration.getClass();
        LivekitModels$VideoConfiguration livekitModels$VideoConfiguration2 = this.screen_;
        if (livekitModels$VideoConfiguration2 == null || livekitModels$VideoConfiguration2 == LivekitModels$VideoConfiguration.getDefaultInstance()) {
            this.screen_ = livekitModels$VideoConfiguration;
        } else {
            this.screen_ = (LivekitModels$VideoConfiguration) ((LivekitModels$VideoConfiguration.a) LivekitModels$VideoConfiguration.newBuilder(this.screen_).v(livekitModels$VideoConfiguration)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeVideo(LivekitModels$VideoConfiguration livekitModels$VideoConfiguration) {
        livekitModels$VideoConfiguration.getClass();
        LivekitModels$VideoConfiguration livekitModels$VideoConfiguration2 = this.video_;
        if (livekitModels$VideoConfiguration2 == null || livekitModels$VideoConfiguration2 == LivekitModels$VideoConfiguration.getDefaultInstance()) {
            this.video_ = livekitModels$VideoConfiguration;
        } else {
            this.video_ = (LivekitModels$VideoConfiguration) ((LivekitModels$VideoConfiguration.a) LivekitModels$VideoConfiguration.newBuilder(this.video_).v(livekitModels$VideoConfiguration)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$ClientConfiguration parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$ClientConfiguration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$ClientConfiguration parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$ClientConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisabledCodecs(LivekitModels$DisabledCodecs livekitModels$DisabledCodecs) {
        livekitModels$DisabledCodecs.getClass();
        this.disabledCodecs_ = livekitModels$DisabledCodecs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setForceRelay(OE3 oe3) {
        this.forceRelay_ = oe3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setForceRelayValue(int i) {
        this.forceRelay_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResumeConnection(OE3 oe3) {
        this.resumeConnection_ = oe3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResumeConnectionValue(int i) {
        this.resumeConnection_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScreen(LivekitModels$VideoConfiguration livekitModels$VideoConfiguration) {
        livekitModels$VideoConfiguration.getClass();
        this.screen_ = livekitModels$VideoConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideo(LivekitModels$VideoConfiguration livekitModels$VideoConfiguration) {
        livekitModels$VideoConfiguration.getClass();
        this.video_ = livekitModels$VideoConfiguration;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$ClientConfiguration();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f\u0004\t\u0005\f", new Object[]{"video_", "screen_", "resumeConnection_", "disabledCodecs_", "forceRelay_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$ClientConfiguration.class) {
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

    public LivekitModels$DisabledCodecs getDisabledCodecs() {
        LivekitModels$DisabledCodecs livekitModels$DisabledCodecs = this.disabledCodecs_;
        return livekitModels$DisabledCodecs == null ? LivekitModels$DisabledCodecs.getDefaultInstance() : livekitModels$DisabledCodecs;
    }

    public OE3 getForceRelay() {
        OE3 oe3J = OE3.j(this.forceRelay_);
        return oe3J == null ? OE3.UNRECOGNIZED : oe3J;
    }

    public int getForceRelayValue() {
        return this.forceRelay_;
    }

    public OE3 getResumeConnection() {
        OE3 oe3J = OE3.j(this.resumeConnection_);
        return oe3J == null ? OE3.UNRECOGNIZED : oe3J;
    }

    public int getResumeConnectionValue() {
        return this.resumeConnection_;
    }

    public LivekitModels$VideoConfiguration getScreen() {
        LivekitModels$VideoConfiguration livekitModels$VideoConfiguration = this.screen_;
        return livekitModels$VideoConfiguration == null ? LivekitModels$VideoConfiguration.getDefaultInstance() : livekitModels$VideoConfiguration;
    }

    public LivekitModels$VideoConfiguration getVideo() {
        LivekitModels$VideoConfiguration livekitModels$VideoConfiguration = this.video_;
        return livekitModels$VideoConfiguration == null ? LivekitModels$VideoConfiguration.getDefaultInstance() : livekitModels$VideoConfiguration;
    }

    public boolean hasDisabledCodecs() {
        return this.disabledCodecs_ != null;
    }

    public boolean hasScreen() {
        return this.screen_ != null;
    }

    public boolean hasVideo() {
        return this.video_ != null;
    }

    public static a newBuilder(LivekitModels$ClientConfiguration livekitModels$ClientConfiguration) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$ClientConfiguration);
    }

    public static LivekitModels$ClientConfiguration parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$ClientConfiguration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$ClientConfiguration parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$ClientConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$ClientConfiguration parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$ClientConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$ClientConfiguration parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$ClientConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$ClientConfiguration parseFrom(byte[] bArr) {
        return (LivekitModels$ClientConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$ClientConfiguration parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$ClientConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$ClientConfiguration parseFrom(InputStream inputStream) {
        return (LivekitModels$ClientConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$ClientConfiguration parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$ClientConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$ClientConfiguration parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$ClientConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$ClientConfiguration parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$ClientConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

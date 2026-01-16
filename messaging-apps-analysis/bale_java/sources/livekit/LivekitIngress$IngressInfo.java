package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.AE3;
import ir.nasim.BE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitIngress$IngressAudioOptions;
import livekit.LivekitIngress$IngressState;
import livekit.LivekitIngress$IngressVideoOptions;

/* loaded from: classes8.dex */
public final class LivekitIngress$IngressInfo extends GeneratedMessageLite implements AE3 {
    public static final int AUDIO_FIELD_NUMBER = 6;
    public static final int BYPASS_TRANSCODING_FIELD_NUMBER = 13;
    private static final LivekitIngress$IngressInfo DEFAULT_INSTANCE;
    public static final int ENABLED_FIELD_NUMBER = 16;
    public static final int ENABLE_TRANSCODING_FIELD_NUMBER = 15;
    public static final int INGRESS_ID_FIELD_NUMBER = 1;
    public static final int INPUT_TYPE_FIELD_NUMBER = 5;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_IDENTITY_FIELD_NUMBER = 9;
    public static final int PARTICIPANT_METADATA_FIELD_NUMBER = 14;
    public static final int PARTICIPANT_NAME_FIELD_NUMBER = 10;
    public static final int REUSABLE_FIELD_NUMBER = 11;
    public static final int ROOM_NAME_FIELD_NUMBER = 8;
    public static final int STATE_FIELD_NUMBER = 12;
    public static final int STREAM_KEY_FIELD_NUMBER = 3;
    public static final int URL_FIELD_NUMBER = 4;
    public static final int VIDEO_FIELD_NUMBER = 7;
    private LivekitIngress$IngressAudioOptions audio_;
    private int bitField0_;
    private boolean bypassTranscoding_;
    private boolean enableTranscoding_;
    private boolean enabled_;
    private int inputType_;
    private boolean reusable_;
    private LivekitIngress$IngressState state_;
    private LivekitIngress$IngressVideoOptions video_;
    private String ingressId_ = "";
    private String name_ = "";
    private String streamKey_ = "";
    private String url_ = "";
    private String roomName_ = "";
    private String participantIdentity_ = "";
    private String participantName_ = "";
    private String participantMetadata_ = "";

    public static final class a extends GeneratedMessageLite.b implements AE3 {
        /* synthetic */ a(l lVar) {
            this();
        }

        private a() {
            super(LivekitIngress$IngressInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitIngress$IngressInfo livekitIngress$IngressInfo = new LivekitIngress$IngressInfo();
        DEFAULT_INSTANCE = livekitIngress$IngressInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitIngress$IngressInfo.class, livekitIngress$IngressInfo);
    }

    private LivekitIngress$IngressInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudio() {
        this.audio_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBypassTranscoding() {
        this.bypassTranscoding_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEnableTranscoding() {
        this.bitField0_ &= -2;
        this.enableTranscoding_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEnabled() {
        this.bitField0_ &= -3;
        this.enabled_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIngressId() {
        this.ingressId_ = getDefaultInstance().getIngressId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInputType() {
        this.inputType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantIdentity() {
        this.participantIdentity_ = getDefaultInstance().getParticipantIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantMetadata() {
        this.participantMetadata_ = getDefaultInstance().getParticipantMetadata();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantName() {
        this.participantName_ = getDefaultInstance().getParticipantName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReusable() {
        this.reusable_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomName() {
        this.roomName_ = getDefaultInstance().getRoomName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        this.state_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStreamKey() {
        this.streamKey_ = getDefaultInstance().getStreamKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVideo() {
        this.video_ = null;
    }

    public static LivekitIngress$IngressInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAudio(LivekitIngress$IngressAudioOptions livekitIngress$IngressAudioOptions) {
        livekitIngress$IngressAudioOptions.getClass();
        LivekitIngress$IngressAudioOptions livekitIngress$IngressAudioOptions2 = this.audio_;
        if (livekitIngress$IngressAudioOptions2 == null || livekitIngress$IngressAudioOptions2 == LivekitIngress$IngressAudioOptions.getDefaultInstance()) {
            this.audio_ = livekitIngress$IngressAudioOptions;
        } else {
            this.audio_ = (LivekitIngress$IngressAudioOptions) ((LivekitIngress$IngressAudioOptions.a) LivekitIngress$IngressAudioOptions.newBuilder(this.audio_).v(livekitIngress$IngressAudioOptions)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeState(LivekitIngress$IngressState livekitIngress$IngressState) {
        livekitIngress$IngressState.getClass();
        LivekitIngress$IngressState livekitIngress$IngressState2 = this.state_;
        if (livekitIngress$IngressState2 == null || livekitIngress$IngressState2 == LivekitIngress$IngressState.getDefaultInstance()) {
            this.state_ = livekitIngress$IngressState;
        } else {
            this.state_ = (LivekitIngress$IngressState) ((LivekitIngress$IngressState.a) LivekitIngress$IngressState.newBuilder(this.state_).v(livekitIngress$IngressState)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeVideo(LivekitIngress$IngressVideoOptions livekitIngress$IngressVideoOptions) {
        livekitIngress$IngressVideoOptions.getClass();
        LivekitIngress$IngressVideoOptions livekitIngress$IngressVideoOptions2 = this.video_;
        if (livekitIngress$IngressVideoOptions2 == null || livekitIngress$IngressVideoOptions2 == LivekitIngress$IngressVideoOptions.getDefaultInstance()) {
            this.video_ = livekitIngress$IngressVideoOptions;
        } else {
            this.video_ = (LivekitIngress$IngressVideoOptions) ((LivekitIngress$IngressVideoOptions.a) LivekitIngress$IngressVideoOptions.newBuilder(this.video_).v(livekitIngress$IngressVideoOptions)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitIngress$IngressInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitIngress$IngressInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$IngressInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitIngress$IngressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudio(LivekitIngress$IngressAudioOptions livekitIngress$IngressAudioOptions) {
        livekitIngress$IngressAudioOptions.getClass();
        this.audio_ = livekitIngress$IngressAudioOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBypassTranscoding(boolean z) {
        this.bypassTranscoding_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnableTranscoding(boolean z) {
        this.bitField0_ |= 1;
        this.enableTranscoding_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnabled(boolean z) {
        this.bitField0_ |= 2;
        this.enabled_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIngressId(String str) {
        str.getClass();
        this.ingressId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIngressIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.ingressId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInputType(BE3 be3) {
        this.inputType_ = be3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInputTypeValue(int i) {
        this.inputType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantIdentity(String str) {
        str.getClass();
        this.participantIdentity_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantIdentityBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantIdentity_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantMetadata(String str) {
        str.getClass();
        this.participantMetadata_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantMetadataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantMetadata_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantName(String str) {
        str.getClass();
        this.participantName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantName_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReusable(boolean z) {
        this.reusable_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomName(String str) {
        str.getClass();
        this.roomName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.roomName_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(LivekitIngress$IngressState livekitIngress$IngressState) {
        livekitIngress$IngressState.getClass();
        this.state_ = livekitIngress$IngressState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreamKey(String str) {
        str.getClass();
        this.streamKey_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreamKeyBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.streamKey_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideo(LivekitIngress$IngressVideoOptions livekitIngress$IngressVideoOptions) {
        livekitIngress$IngressVideoOptions.getClass();
        this.video_ = livekitIngress$IngressVideoOptions;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        l lVar = null;
        switch (l.a[gVar.ordinal()]) {
            case 1:
                return new LivekitIngress$IngressInfo();
            case 2:
                return new a(lVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0010\u0000\u0001\u0001\u0010\u0010\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\f\u0006\t\u0007\t\bȈ\tȈ\nȈ\u000b\u0007\f\t\r\u0007\u000eȈ\u000fဇ\u0000\u0010ဇ\u0001", new Object[]{"bitField0_", "ingressId_", "name_", "streamKey_", "url_", "inputType_", "audio_", "video_", "roomName_", "participantIdentity_", "participantName_", "reusable_", "state_", "bypassTranscoding_", "participantMetadata_", "enableTranscoding_", "enabled_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitIngress$IngressInfo.class) {
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

    public LivekitIngress$IngressAudioOptions getAudio() {
        LivekitIngress$IngressAudioOptions livekitIngress$IngressAudioOptions = this.audio_;
        return livekitIngress$IngressAudioOptions == null ? LivekitIngress$IngressAudioOptions.getDefaultInstance() : livekitIngress$IngressAudioOptions;
    }

    @Deprecated
    public boolean getBypassTranscoding() {
        return this.bypassTranscoding_;
    }

    public boolean getEnableTranscoding() {
        return this.enableTranscoding_;
    }

    public boolean getEnabled() {
        return this.enabled_;
    }

    public String getIngressId() {
        return this.ingressId_;
    }

    public AbstractC2383g getIngressIdBytes() {
        return AbstractC2383g.N(this.ingressId_);
    }

    public BE3 getInputType() {
        BE3 be3J = BE3.j(this.inputType_);
        return be3J == null ? BE3.UNRECOGNIZED : be3J;
    }

    public int getInputTypeValue() {
        return this.inputType_;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getParticipantIdentity() {
        return this.participantIdentity_;
    }

    public AbstractC2383g getParticipantIdentityBytes() {
        return AbstractC2383g.N(this.participantIdentity_);
    }

    public String getParticipantMetadata() {
        return this.participantMetadata_;
    }

    public AbstractC2383g getParticipantMetadataBytes() {
        return AbstractC2383g.N(this.participantMetadata_);
    }

    public String getParticipantName() {
        return this.participantName_;
    }

    public AbstractC2383g getParticipantNameBytes() {
        return AbstractC2383g.N(this.participantName_);
    }

    public boolean getReusable() {
        return this.reusable_;
    }

    public String getRoomName() {
        return this.roomName_;
    }

    public AbstractC2383g getRoomNameBytes() {
        return AbstractC2383g.N(this.roomName_);
    }

    public LivekitIngress$IngressState getState() {
        LivekitIngress$IngressState livekitIngress$IngressState = this.state_;
        return livekitIngress$IngressState == null ? LivekitIngress$IngressState.getDefaultInstance() : livekitIngress$IngressState;
    }

    public String getStreamKey() {
        return this.streamKey_;
    }

    public AbstractC2383g getStreamKeyBytes() {
        return AbstractC2383g.N(this.streamKey_);
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public LivekitIngress$IngressVideoOptions getVideo() {
        LivekitIngress$IngressVideoOptions livekitIngress$IngressVideoOptions = this.video_;
        return livekitIngress$IngressVideoOptions == null ? LivekitIngress$IngressVideoOptions.getDefaultInstance() : livekitIngress$IngressVideoOptions;
    }

    public boolean hasAudio() {
        return this.audio_ != null;
    }

    public boolean hasEnableTranscoding() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasEnabled() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasState() {
        return this.state_ != null;
    }

    public boolean hasVideo() {
        return this.video_ != null;
    }

    public static a newBuilder(LivekitIngress$IngressInfo livekitIngress$IngressInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitIngress$IngressInfo);
    }

    public static LivekitIngress$IngressInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$IngressInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$IngressInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitIngress$IngressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitIngress$IngressInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitIngress$IngressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitIngress$IngressInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitIngress$IngressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitIngress$IngressInfo parseFrom(byte[] bArr) {
        return (LivekitIngress$IngressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitIngress$IngressInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitIngress$IngressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitIngress$IngressInfo parseFrom(InputStream inputStream) {
        return (LivekitIngress$IngressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$IngressInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$IngressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$IngressInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitIngress$IngressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitIngress$IngressInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitIngress$IngressInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

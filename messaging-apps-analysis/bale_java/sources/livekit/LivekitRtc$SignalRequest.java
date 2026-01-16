package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitRtc$AddTrackRequest;
import livekit.LivekitRtc$LeaveRequest;
import livekit.LivekitRtc$MuteTrackRequest;
import livekit.LivekitRtc$Ping;
import livekit.LivekitRtc$SessionDescription;
import livekit.LivekitRtc$SimulateScenario;
import livekit.LivekitRtc$SubscriptionPermission;
import livekit.LivekitRtc$SyncState;
import livekit.LivekitRtc$TrickleRequest;
import livekit.LivekitRtc$UpdateLocalAudioTrack;
import livekit.LivekitRtc$UpdateLocalVideoTrack;
import livekit.LivekitRtc$UpdateParticipantMetadata;
import livekit.LivekitRtc$UpdateSubscription;
import livekit.LivekitRtc$UpdateTrackSettings;
import livekit.LivekitRtc$UpdateVideoLayers;

/* loaded from: classes8.dex */
public final class LivekitRtc$SignalRequest extends GeneratedMessageLite implements U64 {
    public static final int ADD_TRACK_FIELD_NUMBER = 4;
    public static final int ANSWER_FIELD_NUMBER = 2;
    private static final LivekitRtc$SignalRequest DEFAULT_INSTANCE;
    public static final int LEAVE_FIELD_NUMBER = 8;
    public static final int MUTE_FIELD_NUMBER = 5;
    public static final int OFFER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PING_FIELD_NUMBER = 14;
    public static final int PING_REQ_FIELD_NUMBER = 16;
    public static final int SIMULATE_FIELD_NUMBER = 13;
    public static final int SUBSCRIPTION_FIELD_NUMBER = 6;
    public static final int SUBSCRIPTION_PERMISSION_FIELD_NUMBER = 11;
    public static final int SYNC_STATE_FIELD_NUMBER = 12;
    public static final int TRACK_SETTING_FIELD_NUMBER = 7;
    public static final int TRICKLE_FIELD_NUMBER = 3;
    public static final int UPDATE_AUDIO_TRACK_FIELD_NUMBER = 17;
    public static final int UPDATE_LAYERS_FIELD_NUMBER = 10;
    public static final int UPDATE_METADATA_FIELD_NUMBER = 15;
    public static final int UPDATE_VIDEO_TRACK_FIELD_NUMBER = 18;
    private int messageCase_ = 0;
    private Object message_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        public a A(LivekitRtc$AddTrackRequest.b bVar) {
            q();
            ((LivekitRtc$SignalRequest) this.b).setAddTrack((LivekitRtc$AddTrackRequest) bVar.a());
            return this;
        }

        public a B(LivekitRtc$SessionDescription livekitRtc$SessionDescription) {
            q();
            ((LivekitRtc$SignalRequest) this.b).setAnswer(livekitRtc$SessionDescription);
            return this;
        }

        public a C(LivekitRtc$LeaveRequest livekitRtc$LeaveRequest) {
            q();
            ((LivekitRtc$SignalRequest) this.b).setLeave(livekitRtc$LeaveRequest);
            return this;
        }

        public a D(LivekitRtc$MuteTrackRequest livekitRtc$MuteTrackRequest) {
            q();
            ((LivekitRtc$SignalRequest) this.b).setMute(livekitRtc$MuteTrackRequest);
            return this;
        }

        public a E(LivekitRtc$SessionDescription livekitRtc$SessionDescription) {
            q();
            ((LivekitRtc$SignalRequest) this.b).setOffer(livekitRtc$SessionDescription);
            return this;
        }

        public a F(long j) {
            q();
            ((LivekitRtc$SignalRequest) this.b).setPing(j);
            return this;
        }

        public a G(LivekitRtc$Ping livekitRtc$Ping) {
            q();
            ((LivekitRtc$SignalRequest) this.b).setPingReq(livekitRtc$Ping);
            return this;
        }

        public a H(LivekitRtc$SyncState livekitRtc$SyncState) {
            q();
            ((LivekitRtc$SignalRequest) this.b).setSyncState(livekitRtc$SyncState);
            return this;
        }

        public a I(LivekitRtc$UpdateTrackSettings.a aVar) {
            q();
            ((LivekitRtc$SignalRequest) this.b).setTrackSetting((LivekitRtc$UpdateTrackSettings) aVar.a());
            return this;
        }

        public a J(LivekitRtc$TrickleRequest livekitRtc$TrickleRequest) {
            q();
            ((LivekitRtc$SignalRequest) this.b).setTrickle(livekitRtc$TrickleRequest);
            return this;
        }

        public a K(LivekitRtc$UpdateLocalAudioTrack livekitRtc$UpdateLocalAudioTrack) {
            q();
            ((LivekitRtc$SignalRequest) this.b).setUpdateAudioTrack(livekitRtc$UpdateLocalAudioTrack);
            return this;
        }

        private a() {
            super(LivekitRtc$SignalRequest.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        OFFER(1),
        ANSWER(2),
        TRICKLE(3),
        ADD_TRACK(4),
        MUTE(5),
        SUBSCRIPTION(6),
        TRACK_SETTING(7),
        LEAVE(8),
        UPDATE_LAYERS(10),
        SUBSCRIPTION_PERMISSION(11),
        SYNC_STATE(12),
        SIMULATE(13),
        PING(14),
        UPDATE_METADATA(15),
        PING_REQ(16),
        UPDATE_AUDIO_TRACK(17),
        UPDATE_VIDEO_TRACK(18),
        MESSAGE_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            switch (i) {
                case 0:
                    return MESSAGE_NOT_SET;
                case 1:
                    return OFFER;
                case 2:
                    return ANSWER;
                case 3:
                    return TRICKLE;
                case 4:
                    return ADD_TRACK;
                case 5:
                    return MUTE;
                case 6:
                    return SUBSCRIPTION;
                case 7:
                    return TRACK_SETTING;
                case 8:
                    return LEAVE;
                case 9:
                default:
                    return null;
                case 10:
                    return UPDATE_LAYERS;
                case 11:
                    return SUBSCRIPTION_PERMISSION;
                case 12:
                    return SYNC_STATE;
                case 13:
                    return SIMULATE;
                case 14:
                    return PING;
                case 15:
                    return UPDATE_METADATA;
                case 16:
                    return PING_REQ;
                case 17:
                    return UPDATE_AUDIO_TRACK;
                case 18:
                    return UPDATE_VIDEO_TRACK;
            }
        }
    }

    static {
        LivekitRtc$SignalRequest livekitRtc$SignalRequest = new LivekitRtc$SignalRequest();
        DEFAULT_INSTANCE = livekitRtc$SignalRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$SignalRequest.class, livekitRtc$SignalRequest);
    }

    private LivekitRtc$SignalRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAddTrack() {
        if (this.messageCase_ == 4) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAnswer() {
        if (this.messageCase_ == 2) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLeave() {
        if (this.messageCase_ == 8) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.messageCase_ = 0;
        this.message_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMute() {
        if (this.messageCase_ == 5) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOffer() {
        if (this.messageCase_ == 1) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPing() {
        if (this.messageCase_ == 14) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPingReq() {
        if (this.messageCase_ == 16) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSimulate() {
        if (this.messageCase_ == 13) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubscription() {
        if (this.messageCase_ == 6) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubscriptionPermission() {
        if (this.messageCase_ == 11) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSyncState() {
        if (this.messageCase_ == 12) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSetting() {
        if (this.messageCase_ == 7) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrickle() {
        if (this.messageCase_ == 3) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdateAudioTrack() {
        if (this.messageCase_ == 17) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdateLayers() {
        if (this.messageCase_ == 10) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdateMetadata() {
        if (this.messageCase_ == 15) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdateVideoTrack() {
        if (this.messageCase_ == 18) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    public static LivekitRtc$SignalRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAddTrack(LivekitRtc$AddTrackRequest livekitRtc$AddTrackRequest) {
        livekitRtc$AddTrackRequest.getClass();
        if (this.messageCase_ != 4 || this.message_ == LivekitRtc$AddTrackRequest.getDefaultInstance()) {
            this.message_ = livekitRtc$AddTrackRequest;
        } else {
            this.message_ = ((LivekitRtc$AddTrackRequest.b) LivekitRtc$AddTrackRequest.newBuilder((LivekitRtc$AddTrackRequest) this.message_).v(livekitRtc$AddTrackRequest)).j();
        }
        this.messageCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAnswer(LivekitRtc$SessionDescription livekitRtc$SessionDescription) {
        livekitRtc$SessionDescription.getClass();
        if (this.messageCase_ != 2 || this.message_ == LivekitRtc$SessionDescription.getDefaultInstance()) {
            this.message_ = livekitRtc$SessionDescription;
        } else {
            this.message_ = ((LivekitRtc$SessionDescription.a) LivekitRtc$SessionDescription.newBuilder((LivekitRtc$SessionDescription) this.message_).v(livekitRtc$SessionDescription)).j();
        }
        this.messageCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLeave(LivekitRtc$LeaveRequest livekitRtc$LeaveRequest) {
        livekitRtc$LeaveRequest.getClass();
        if (this.messageCase_ != 8 || this.message_ == LivekitRtc$LeaveRequest.getDefaultInstance()) {
            this.message_ = livekitRtc$LeaveRequest;
        } else {
            this.message_ = ((LivekitRtc$LeaveRequest.b) LivekitRtc$LeaveRequest.newBuilder((LivekitRtc$LeaveRequest) this.message_).v(livekitRtc$LeaveRequest)).j();
        }
        this.messageCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMute(LivekitRtc$MuteTrackRequest livekitRtc$MuteTrackRequest) {
        livekitRtc$MuteTrackRequest.getClass();
        if (this.messageCase_ != 5 || this.message_ == LivekitRtc$MuteTrackRequest.getDefaultInstance()) {
            this.message_ = livekitRtc$MuteTrackRequest;
        } else {
            this.message_ = ((LivekitRtc$MuteTrackRequest.a) LivekitRtc$MuteTrackRequest.newBuilder((LivekitRtc$MuteTrackRequest) this.message_).v(livekitRtc$MuteTrackRequest)).j();
        }
        this.messageCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeOffer(LivekitRtc$SessionDescription livekitRtc$SessionDescription) {
        livekitRtc$SessionDescription.getClass();
        if (this.messageCase_ != 1 || this.message_ == LivekitRtc$SessionDescription.getDefaultInstance()) {
            this.message_ = livekitRtc$SessionDescription;
        } else {
            this.message_ = ((LivekitRtc$SessionDescription.a) LivekitRtc$SessionDescription.newBuilder((LivekitRtc$SessionDescription) this.message_).v(livekitRtc$SessionDescription)).j();
        }
        this.messageCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePingReq(LivekitRtc$Ping livekitRtc$Ping) {
        livekitRtc$Ping.getClass();
        if (this.messageCase_ != 16 || this.message_ == LivekitRtc$Ping.getDefaultInstance()) {
            this.message_ = livekitRtc$Ping;
        } else {
            this.message_ = ((LivekitRtc$Ping.a) LivekitRtc$Ping.newBuilder((LivekitRtc$Ping) this.message_).v(livekitRtc$Ping)).j();
        }
        this.messageCase_ = 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSimulate(LivekitRtc$SimulateScenario livekitRtc$SimulateScenario) {
        livekitRtc$SimulateScenario.getClass();
        if (this.messageCase_ != 13 || this.message_ == LivekitRtc$SimulateScenario.getDefaultInstance()) {
            this.message_ = livekitRtc$SimulateScenario;
        } else {
            this.message_ = ((LivekitRtc$SimulateScenario.a) LivekitRtc$SimulateScenario.newBuilder((LivekitRtc$SimulateScenario) this.message_).v(livekitRtc$SimulateScenario)).j();
        }
        this.messageCase_ = 13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSubscription(LivekitRtc$UpdateSubscription livekitRtc$UpdateSubscription) {
        livekitRtc$UpdateSubscription.getClass();
        if (this.messageCase_ != 6 || this.message_ == LivekitRtc$UpdateSubscription.getDefaultInstance()) {
            this.message_ = livekitRtc$UpdateSubscription;
        } else {
            this.message_ = ((LivekitRtc$UpdateSubscription.a) LivekitRtc$UpdateSubscription.newBuilder((LivekitRtc$UpdateSubscription) this.message_).v(livekitRtc$UpdateSubscription)).j();
        }
        this.messageCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSubscriptionPermission(LivekitRtc$SubscriptionPermission livekitRtc$SubscriptionPermission) {
        livekitRtc$SubscriptionPermission.getClass();
        if (this.messageCase_ != 11 || this.message_ == LivekitRtc$SubscriptionPermission.getDefaultInstance()) {
            this.message_ = livekitRtc$SubscriptionPermission;
        } else {
            this.message_ = ((LivekitRtc$SubscriptionPermission.a) LivekitRtc$SubscriptionPermission.newBuilder((LivekitRtc$SubscriptionPermission) this.message_).v(livekitRtc$SubscriptionPermission)).j();
        }
        this.messageCase_ = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSyncState(LivekitRtc$SyncState livekitRtc$SyncState) {
        livekitRtc$SyncState.getClass();
        if (this.messageCase_ != 12 || this.message_ == LivekitRtc$SyncState.getDefaultInstance()) {
            this.message_ = livekitRtc$SyncState;
        } else {
            this.message_ = ((LivekitRtc$SyncState.a) LivekitRtc$SyncState.newBuilder((LivekitRtc$SyncState) this.message_).v(livekitRtc$SyncState)).j();
        }
        this.messageCase_ = 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTrackSetting(LivekitRtc$UpdateTrackSettings livekitRtc$UpdateTrackSettings) {
        livekitRtc$UpdateTrackSettings.getClass();
        if (this.messageCase_ != 7 || this.message_ == LivekitRtc$UpdateTrackSettings.getDefaultInstance()) {
            this.message_ = livekitRtc$UpdateTrackSettings;
        } else {
            this.message_ = ((LivekitRtc$UpdateTrackSettings.a) LivekitRtc$UpdateTrackSettings.newBuilder((LivekitRtc$UpdateTrackSettings) this.message_).v(livekitRtc$UpdateTrackSettings)).j();
        }
        this.messageCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTrickle(LivekitRtc$TrickleRequest livekitRtc$TrickleRequest) {
        livekitRtc$TrickleRequest.getClass();
        if (this.messageCase_ != 3 || this.message_ == LivekitRtc$TrickleRequest.getDefaultInstance()) {
            this.message_ = livekitRtc$TrickleRequest;
        } else {
            this.message_ = ((LivekitRtc$TrickleRequest.a) LivekitRtc$TrickleRequest.newBuilder((LivekitRtc$TrickleRequest) this.message_).v(livekitRtc$TrickleRequest)).j();
        }
        this.messageCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdateAudioTrack(LivekitRtc$UpdateLocalAudioTrack livekitRtc$UpdateLocalAudioTrack) {
        livekitRtc$UpdateLocalAudioTrack.getClass();
        if (this.messageCase_ != 17 || this.message_ == LivekitRtc$UpdateLocalAudioTrack.getDefaultInstance()) {
            this.message_ = livekitRtc$UpdateLocalAudioTrack;
        } else {
            this.message_ = ((LivekitRtc$UpdateLocalAudioTrack.b) LivekitRtc$UpdateLocalAudioTrack.newBuilder((LivekitRtc$UpdateLocalAudioTrack) this.message_).v(livekitRtc$UpdateLocalAudioTrack)).j();
        }
        this.messageCase_ = 17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdateLayers(LivekitRtc$UpdateVideoLayers livekitRtc$UpdateVideoLayers) {
        livekitRtc$UpdateVideoLayers.getClass();
        if (this.messageCase_ != 10 || this.message_ == LivekitRtc$UpdateVideoLayers.getDefaultInstance()) {
            this.message_ = livekitRtc$UpdateVideoLayers;
        } else {
            this.message_ = ((LivekitRtc$UpdateVideoLayers.a) LivekitRtc$UpdateVideoLayers.newBuilder((LivekitRtc$UpdateVideoLayers) this.message_).v(livekitRtc$UpdateVideoLayers)).j();
        }
        this.messageCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdateMetadata(LivekitRtc$UpdateParticipantMetadata livekitRtc$UpdateParticipantMetadata) {
        livekitRtc$UpdateParticipantMetadata.getClass();
        if (this.messageCase_ != 15 || this.message_ == LivekitRtc$UpdateParticipantMetadata.getDefaultInstance()) {
            this.message_ = livekitRtc$UpdateParticipantMetadata;
        } else {
            this.message_ = ((LivekitRtc$UpdateParticipantMetadata.b) LivekitRtc$UpdateParticipantMetadata.newBuilder((LivekitRtc$UpdateParticipantMetadata) this.message_).v(livekitRtc$UpdateParticipantMetadata)).j();
        }
        this.messageCase_ = 15;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdateVideoTrack(LivekitRtc$UpdateLocalVideoTrack livekitRtc$UpdateLocalVideoTrack) {
        livekitRtc$UpdateLocalVideoTrack.getClass();
        if (this.messageCase_ != 18 || this.message_ == LivekitRtc$UpdateLocalVideoTrack.getDefaultInstance()) {
            this.message_ = livekitRtc$UpdateLocalVideoTrack;
        } else {
            this.message_ = ((LivekitRtc$UpdateLocalVideoTrack.a) LivekitRtc$UpdateLocalVideoTrack.newBuilder((LivekitRtc$UpdateLocalVideoTrack) this.message_).v(livekitRtc$UpdateLocalVideoTrack)).j();
        }
        this.messageCase_ = 18;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$SignalRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$SignalRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SignalRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$SignalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddTrack(LivekitRtc$AddTrackRequest livekitRtc$AddTrackRequest) {
        livekitRtc$AddTrackRequest.getClass();
        this.message_ = livekitRtc$AddTrackRequest;
        this.messageCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnswer(LivekitRtc$SessionDescription livekitRtc$SessionDescription) {
        livekitRtc$SessionDescription.getClass();
        this.message_ = livekitRtc$SessionDescription;
        this.messageCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLeave(LivekitRtc$LeaveRequest livekitRtc$LeaveRequest) {
        livekitRtc$LeaveRequest.getClass();
        this.message_ = livekitRtc$LeaveRequest;
        this.messageCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMute(LivekitRtc$MuteTrackRequest livekitRtc$MuteTrackRequest) {
        livekitRtc$MuteTrackRequest.getClass();
        this.message_ = livekitRtc$MuteTrackRequest;
        this.messageCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOffer(LivekitRtc$SessionDescription livekitRtc$SessionDescription) {
        livekitRtc$SessionDescription.getClass();
        this.message_ = livekitRtc$SessionDescription;
        this.messageCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPing(long j) {
        this.messageCase_ = 14;
        this.message_ = Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPingReq(LivekitRtc$Ping livekitRtc$Ping) {
        livekitRtc$Ping.getClass();
        this.message_ = livekitRtc$Ping;
        this.messageCase_ = 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSimulate(LivekitRtc$SimulateScenario livekitRtc$SimulateScenario) {
        livekitRtc$SimulateScenario.getClass();
        this.message_ = livekitRtc$SimulateScenario;
        this.messageCase_ = 13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubscription(LivekitRtc$UpdateSubscription livekitRtc$UpdateSubscription) {
        livekitRtc$UpdateSubscription.getClass();
        this.message_ = livekitRtc$UpdateSubscription;
        this.messageCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubscriptionPermission(LivekitRtc$SubscriptionPermission livekitRtc$SubscriptionPermission) {
        livekitRtc$SubscriptionPermission.getClass();
        this.message_ = livekitRtc$SubscriptionPermission;
        this.messageCase_ = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSyncState(LivekitRtc$SyncState livekitRtc$SyncState) {
        livekitRtc$SyncState.getClass();
        this.message_ = livekitRtc$SyncState;
        this.messageCase_ = 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackSetting(LivekitRtc$UpdateTrackSettings livekitRtc$UpdateTrackSettings) {
        livekitRtc$UpdateTrackSettings.getClass();
        this.message_ = livekitRtc$UpdateTrackSettings;
        this.messageCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrickle(LivekitRtc$TrickleRequest livekitRtc$TrickleRequest) {
        livekitRtc$TrickleRequest.getClass();
        this.message_ = livekitRtc$TrickleRequest;
        this.messageCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateAudioTrack(LivekitRtc$UpdateLocalAudioTrack livekitRtc$UpdateLocalAudioTrack) {
        livekitRtc$UpdateLocalAudioTrack.getClass();
        this.message_ = livekitRtc$UpdateLocalAudioTrack;
        this.messageCase_ = 17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateLayers(LivekitRtc$UpdateVideoLayers livekitRtc$UpdateVideoLayers) {
        livekitRtc$UpdateVideoLayers.getClass();
        this.message_ = livekitRtc$UpdateVideoLayers;
        this.messageCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateMetadata(LivekitRtc$UpdateParticipantMetadata livekitRtc$UpdateParticipantMetadata) {
        livekitRtc$UpdateParticipantMetadata.getClass();
        this.message_ = livekitRtc$UpdateParticipantMetadata;
        this.messageCase_ = 15;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateVideoTrack(LivekitRtc$UpdateLocalVideoTrack livekitRtc$UpdateLocalVideoTrack) {
        livekitRtc$UpdateLocalVideoTrack.getClass();
        this.message_ = livekitRtc$UpdateLocalVideoTrack;
        this.messageCase_ = 18;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$SignalRequest();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0011\u0001\u0000\u0001\u0012\u0011\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\n<\u0000\u000b<\u0000\f<\u0000\r<\u0000\u000e5\u0000\u000f<\u0000\u0010<\u0000\u0011<\u0000\u0012<\u0000", new Object[]{"message_", "messageCase_", LivekitRtc$SessionDescription.class, LivekitRtc$SessionDescription.class, LivekitRtc$TrickleRequest.class, LivekitRtc$AddTrackRequest.class, LivekitRtc$MuteTrackRequest.class, LivekitRtc$UpdateSubscription.class, LivekitRtc$UpdateTrackSettings.class, LivekitRtc$LeaveRequest.class, LivekitRtc$UpdateVideoLayers.class, LivekitRtc$SubscriptionPermission.class, LivekitRtc$SyncState.class, LivekitRtc$SimulateScenario.class, LivekitRtc$UpdateParticipantMetadata.class, LivekitRtc$Ping.class, LivekitRtc$UpdateLocalAudioTrack.class, LivekitRtc$UpdateLocalVideoTrack.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$SignalRequest.class) {
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

    public LivekitRtc$AddTrackRequest getAddTrack() {
        return this.messageCase_ == 4 ? (LivekitRtc$AddTrackRequest) this.message_ : LivekitRtc$AddTrackRequest.getDefaultInstance();
    }

    public LivekitRtc$SessionDescription getAnswer() {
        return this.messageCase_ == 2 ? (LivekitRtc$SessionDescription) this.message_ : LivekitRtc$SessionDescription.getDefaultInstance();
    }

    public LivekitRtc$LeaveRequest getLeave() {
        return this.messageCase_ == 8 ? (LivekitRtc$LeaveRequest) this.message_ : LivekitRtc$LeaveRequest.getDefaultInstance();
    }

    public b getMessageCase() {
        return b.j(this.messageCase_);
    }

    public LivekitRtc$MuteTrackRequest getMute() {
        return this.messageCase_ == 5 ? (LivekitRtc$MuteTrackRequest) this.message_ : LivekitRtc$MuteTrackRequest.getDefaultInstance();
    }

    public LivekitRtc$SessionDescription getOffer() {
        return this.messageCase_ == 1 ? (LivekitRtc$SessionDescription) this.message_ : LivekitRtc$SessionDescription.getDefaultInstance();
    }

    public long getPing() {
        if (this.messageCase_ == 14) {
            return ((Long) this.message_).longValue();
        }
        return 0L;
    }

    public LivekitRtc$Ping getPingReq() {
        return this.messageCase_ == 16 ? (LivekitRtc$Ping) this.message_ : LivekitRtc$Ping.getDefaultInstance();
    }

    public LivekitRtc$SimulateScenario getSimulate() {
        return this.messageCase_ == 13 ? (LivekitRtc$SimulateScenario) this.message_ : LivekitRtc$SimulateScenario.getDefaultInstance();
    }

    public LivekitRtc$UpdateSubscription getSubscription() {
        return this.messageCase_ == 6 ? (LivekitRtc$UpdateSubscription) this.message_ : LivekitRtc$UpdateSubscription.getDefaultInstance();
    }

    public LivekitRtc$SubscriptionPermission getSubscriptionPermission() {
        return this.messageCase_ == 11 ? (LivekitRtc$SubscriptionPermission) this.message_ : LivekitRtc$SubscriptionPermission.getDefaultInstance();
    }

    public LivekitRtc$SyncState getSyncState() {
        return this.messageCase_ == 12 ? (LivekitRtc$SyncState) this.message_ : LivekitRtc$SyncState.getDefaultInstance();
    }

    public LivekitRtc$UpdateTrackSettings getTrackSetting() {
        return this.messageCase_ == 7 ? (LivekitRtc$UpdateTrackSettings) this.message_ : LivekitRtc$UpdateTrackSettings.getDefaultInstance();
    }

    public LivekitRtc$TrickleRequest getTrickle() {
        return this.messageCase_ == 3 ? (LivekitRtc$TrickleRequest) this.message_ : LivekitRtc$TrickleRequest.getDefaultInstance();
    }

    public LivekitRtc$UpdateLocalAudioTrack getUpdateAudioTrack() {
        return this.messageCase_ == 17 ? (LivekitRtc$UpdateLocalAudioTrack) this.message_ : LivekitRtc$UpdateLocalAudioTrack.getDefaultInstance();
    }

    @Deprecated
    public LivekitRtc$UpdateVideoLayers getUpdateLayers() {
        return this.messageCase_ == 10 ? (LivekitRtc$UpdateVideoLayers) this.message_ : LivekitRtc$UpdateVideoLayers.getDefaultInstance();
    }

    public LivekitRtc$UpdateParticipantMetadata getUpdateMetadata() {
        return this.messageCase_ == 15 ? (LivekitRtc$UpdateParticipantMetadata) this.message_ : LivekitRtc$UpdateParticipantMetadata.getDefaultInstance();
    }

    public LivekitRtc$UpdateLocalVideoTrack getUpdateVideoTrack() {
        return this.messageCase_ == 18 ? (LivekitRtc$UpdateLocalVideoTrack) this.message_ : LivekitRtc$UpdateLocalVideoTrack.getDefaultInstance();
    }

    public boolean hasAddTrack() {
        return this.messageCase_ == 4;
    }

    public boolean hasAnswer() {
        return this.messageCase_ == 2;
    }

    public boolean hasLeave() {
        return this.messageCase_ == 8;
    }

    public boolean hasMute() {
        return this.messageCase_ == 5;
    }

    public boolean hasOffer() {
        return this.messageCase_ == 1;
    }

    public boolean hasPing() {
        return this.messageCase_ == 14;
    }

    public boolean hasPingReq() {
        return this.messageCase_ == 16;
    }

    public boolean hasSimulate() {
        return this.messageCase_ == 13;
    }

    public boolean hasSubscription() {
        return this.messageCase_ == 6;
    }

    public boolean hasSubscriptionPermission() {
        return this.messageCase_ == 11;
    }

    public boolean hasSyncState() {
        return this.messageCase_ == 12;
    }

    public boolean hasTrackSetting() {
        return this.messageCase_ == 7;
    }

    public boolean hasTrickle() {
        return this.messageCase_ == 3;
    }

    public boolean hasUpdateAudioTrack() {
        return this.messageCase_ == 17;
    }

    @Deprecated
    public boolean hasUpdateLayers() {
        return this.messageCase_ == 10;
    }

    public boolean hasUpdateMetadata() {
        return this.messageCase_ == 15;
    }

    public boolean hasUpdateVideoTrack() {
        return this.messageCase_ == 18;
    }

    public static a newBuilder(LivekitRtc$SignalRequest livekitRtc$SignalRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$SignalRequest);
    }

    public static LivekitRtc$SignalRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SignalRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SignalRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$SignalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$SignalRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$SignalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$SignalRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$SignalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$SignalRequest parseFrom(byte[] bArr) {
        return (LivekitRtc$SignalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$SignalRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$SignalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$SignalRequest parseFrom(InputStream inputStream) {
        return (LivekitRtc$SignalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SignalRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SignalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SignalRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$SignalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$SignalRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$SignalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

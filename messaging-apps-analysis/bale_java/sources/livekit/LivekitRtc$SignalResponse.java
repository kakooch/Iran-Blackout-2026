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
import livekit.LivekitRtc$ConnectionQualityUpdate;
import livekit.LivekitRtc$JoinResponse;
import livekit.LivekitRtc$LeaveRequest;
import livekit.LivekitRtc$MuteTrackRequest;
import livekit.LivekitRtc$ParticipantUpdate;
import livekit.LivekitRtc$Pong;
import livekit.LivekitRtc$ReconnectResponse;
import livekit.LivekitRtc$RequestResponse;
import livekit.LivekitRtc$RoomMovedResponse;
import livekit.LivekitRtc$RoomUpdate;
import livekit.LivekitRtc$SessionDescription;
import livekit.LivekitRtc$SpeakersChanged;
import livekit.LivekitRtc$StreamStateUpdate;
import livekit.LivekitRtc$SubscribedQualityUpdate;
import livekit.LivekitRtc$SubscriptionPermissionUpdate;
import livekit.LivekitRtc$SubscriptionResponse;
import livekit.LivekitRtc$TrackPublishedResponse;
import livekit.LivekitRtc$TrackSubscribed;
import livekit.LivekitRtc$TrackUnpublishedResponse;
import livekit.LivekitRtc$TrickleRequest;

/* loaded from: classes8.dex */
public final class LivekitRtc$SignalResponse extends GeneratedMessageLite implements U64 {
    public static final int ANSWER_FIELD_NUMBER = 2;
    public static final int CONNECTION_QUALITY_FIELD_NUMBER = 12;
    private static final LivekitRtc$SignalResponse DEFAULT_INSTANCE;
    public static final int JOIN_FIELD_NUMBER = 1;
    public static final int LEAVE_FIELD_NUMBER = 8;
    public static final int MUTE_FIELD_NUMBER = 9;
    public static final int OFFER_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PONG_FIELD_NUMBER = 18;
    public static final int PONG_RESP_FIELD_NUMBER = 20;
    public static final int RECONNECT_FIELD_NUMBER = 19;
    public static final int REFRESH_TOKEN_FIELD_NUMBER = 16;
    public static final int REQUEST_RESPONSE_FIELD_NUMBER = 22;
    public static final int ROOM_MOVED_FIELD_NUMBER = 24;
    public static final int ROOM_UPDATE_FIELD_NUMBER = 11;
    public static final int SPEAKERS_CHANGED_FIELD_NUMBER = 10;
    public static final int STREAM_STATE_UPDATE_FIELD_NUMBER = 13;
    public static final int SUBSCRIBED_QUALITY_UPDATE_FIELD_NUMBER = 14;
    public static final int SUBSCRIPTION_PERMISSION_UPDATE_FIELD_NUMBER = 15;
    public static final int SUBSCRIPTION_RESPONSE_FIELD_NUMBER = 21;
    public static final int TRACK_PUBLISHED_FIELD_NUMBER = 6;
    public static final int TRACK_SUBSCRIBED_FIELD_NUMBER = 23;
    public static final int TRACK_UNPUBLISHED_FIELD_NUMBER = 17;
    public static final int TRICKLE_FIELD_NUMBER = 4;
    public static final int UPDATE_FIELD_NUMBER = 5;
    private int messageCase_ = 0;
    private Object message_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$SignalResponse.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        JOIN(1),
        ANSWER(2),
        OFFER(3),
        TRICKLE(4),
        UPDATE(5),
        TRACK_PUBLISHED(6),
        LEAVE(8),
        MUTE(9),
        SPEAKERS_CHANGED(10),
        ROOM_UPDATE(11),
        CONNECTION_QUALITY(12),
        STREAM_STATE_UPDATE(13),
        SUBSCRIBED_QUALITY_UPDATE(14),
        SUBSCRIPTION_PERMISSION_UPDATE(15),
        REFRESH_TOKEN(16),
        TRACK_UNPUBLISHED(17),
        PONG(18),
        RECONNECT(19),
        PONG_RESP(20),
        SUBSCRIPTION_RESPONSE(21),
        REQUEST_RESPONSE(22),
        TRACK_SUBSCRIBED(23),
        ROOM_MOVED(24),
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
                    return JOIN;
                case 2:
                    return ANSWER;
                case 3:
                    return OFFER;
                case 4:
                    return TRICKLE;
                case 5:
                    return UPDATE;
                case 6:
                    return TRACK_PUBLISHED;
                case 7:
                default:
                    return null;
                case 8:
                    return LEAVE;
                case 9:
                    return MUTE;
                case 10:
                    return SPEAKERS_CHANGED;
                case 11:
                    return ROOM_UPDATE;
                case 12:
                    return CONNECTION_QUALITY;
                case 13:
                    return STREAM_STATE_UPDATE;
                case 14:
                    return SUBSCRIBED_QUALITY_UPDATE;
                case 15:
                    return SUBSCRIPTION_PERMISSION_UPDATE;
                case 16:
                    return REFRESH_TOKEN;
                case 17:
                    return TRACK_UNPUBLISHED;
                case 18:
                    return PONG;
                case 19:
                    return RECONNECT;
                case 20:
                    return PONG_RESP;
                case 21:
                    return SUBSCRIPTION_RESPONSE;
                case 22:
                    return REQUEST_RESPONSE;
                case 23:
                    return TRACK_SUBSCRIBED;
                case 24:
                    return ROOM_MOVED;
            }
        }
    }

    static {
        LivekitRtc$SignalResponse livekitRtc$SignalResponse = new LivekitRtc$SignalResponse();
        DEFAULT_INSTANCE = livekitRtc$SignalResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$SignalResponse.class, livekitRtc$SignalResponse);
    }

    private LivekitRtc$SignalResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAnswer() {
        if (this.messageCase_ == 2) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConnectionQuality() {
        if (this.messageCase_ == 12) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJoin() {
        if (this.messageCase_ == 1) {
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
        if (this.messageCase_ == 9) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOffer() {
        if (this.messageCase_ == 3) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPong() {
        if (this.messageCase_ == 18) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPongResp() {
        if (this.messageCase_ == 20) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReconnect() {
        if (this.messageCase_ == 19) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRefreshToken() {
        if (this.messageCase_ == 16) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestResponse() {
        if (this.messageCase_ == 22) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomMoved() {
        if (this.messageCase_ == 24) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomUpdate() {
        if (this.messageCase_ == 11) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSpeakersChanged() {
        if (this.messageCase_ == 10) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStreamStateUpdate() {
        if (this.messageCase_ == 13) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubscribedQualityUpdate() {
        if (this.messageCase_ == 14) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubscriptionPermissionUpdate() {
        if (this.messageCase_ == 15) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubscriptionResponse() {
        if (this.messageCase_ == 21) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackPublished() {
        if (this.messageCase_ == 6) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSubscribed() {
        if (this.messageCase_ == 23) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackUnpublished() {
        if (this.messageCase_ == 17) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrickle() {
        if (this.messageCase_ == 4) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdate() {
        if (this.messageCase_ == 5) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    public static LivekitRtc$SignalResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
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
    public void mergeConnectionQuality(LivekitRtc$ConnectionQualityUpdate livekitRtc$ConnectionQualityUpdate) {
        livekitRtc$ConnectionQualityUpdate.getClass();
        if (this.messageCase_ != 12 || this.message_ == LivekitRtc$ConnectionQualityUpdate.getDefaultInstance()) {
            this.message_ = livekitRtc$ConnectionQualityUpdate;
        } else {
            this.message_ = ((LivekitRtc$ConnectionQualityUpdate.a) LivekitRtc$ConnectionQualityUpdate.newBuilder((LivekitRtc$ConnectionQualityUpdate) this.message_).v(livekitRtc$ConnectionQualityUpdate)).j();
        }
        this.messageCase_ = 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeJoin(LivekitRtc$JoinResponse livekitRtc$JoinResponse) {
        livekitRtc$JoinResponse.getClass();
        if (this.messageCase_ != 1 || this.message_ == LivekitRtc$JoinResponse.getDefaultInstance()) {
            this.message_ = livekitRtc$JoinResponse;
        } else {
            this.message_ = ((LivekitRtc$JoinResponse.a) LivekitRtc$JoinResponse.newBuilder((LivekitRtc$JoinResponse) this.message_).v(livekitRtc$JoinResponse)).j();
        }
        this.messageCase_ = 1;
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
        if (this.messageCase_ != 9 || this.message_ == LivekitRtc$MuteTrackRequest.getDefaultInstance()) {
            this.message_ = livekitRtc$MuteTrackRequest;
        } else {
            this.message_ = ((LivekitRtc$MuteTrackRequest.a) LivekitRtc$MuteTrackRequest.newBuilder((LivekitRtc$MuteTrackRequest) this.message_).v(livekitRtc$MuteTrackRequest)).j();
        }
        this.messageCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeOffer(LivekitRtc$SessionDescription livekitRtc$SessionDescription) {
        livekitRtc$SessionDescription.getClass();
        if (this.messageCase_ != 3 || this.message_ == LivekitRtc$SessionDescription.getDefaultInstance()) {
            this.message_ = livekitRtc$SessionDescription;
        } else {
            this.message_ = ((LivekitRtc$SessionDescription.a) LivekitRtc$SessionDescription.newBuilder((LivekitRtc$SessionDescription) this.message_).v(livekitRtc$SessionDescription)).j();
        }
        this.messageCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePongResp(LivekitRtc$Pong livekitRtc$Pong) {
        livekitRtc$Pong.getClass();
        if (this.messageCase_ != 20 || this.message_ == LivekitRtc$Pong.getDefaultInstance()) {
            this.message_ = livekitRtc$Pong;
        } else {
            this.message_ = ((LivekitRtc$Pong.a) LivekitRtc$Pong.newBuilder((LivekitRtc$Pong) this.message_).v(livekitRtc$Pong)).j();
        }
        this.messageCase_ = 20;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeReconnect(LivekitRtc$ReconnectResponse livekitRtc$ReconnectResponse) {
        livekitRtc$ReconnectResponse.getClass();
        if (this.messageCase_ != 19 || this.message_ == LivekitRtc$ReconnectResponse.getDefaultInstance()) {
            this.message_ = livekitRtc$ReconnectResponse;
        } else {
            this.message_ = ((LivekitRtc$ReconnectResponse.a) LivekitRtc$ReconnectResponse.newBuilder((LivekitRtc$ReconnectResponse) this.message_).v(livekitRtc$ReconnectResponse)).j();
        }
        this.messageCase_ = 19;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRequestResponse(LivekitRtc$RequestResponse livekitRtc$RequestResponse) {
        livekitRtc$RequestResponse.getClass();
        if (this.messageCase_ != 22 || this.message_ == LivekitRtc$RequestResponse.getDefaultInstance()) {
            this.message_ = livekitRtc$RequestResponse;
        } else {
            this.message_ = ((LivekitRtc$RequestResponse.a) LivekitRtc$RequestResponse.newBuilder((LivekitRtc$RequestResponse) this.message_).v(livekitRtc$RequestResponse)).j();
        }
        this.messageCase_ = 22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRoomMoved(LivekitRtc$RoomMovedResponse livekitRtc$RoomMovedResponse) {
        livekitRtc$RoomMovedResponse.getClass();
        if (this.messageCase_ != 24 || this.message_ == LivekitRtc$RoomMovedResponse.getDefaultInstance()) {
            this.message_ = livekitRtc$RoomMovedResponse;
        } else {
            this.message_ = ((LivekitRtc$RoomMovedResponse.a) LivekitRtc$RoomMovedResponse.newBuilder((LivekitRtc$RoomMovedResponse) this.message_).v(livekitRtc$RoomMovedResponse)).j();
        }
        this.messageCase_ = 24;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRoomUpdate(LivekitRtc$RoomUpdate livekitRtc$RoomUpdate) {
        livekitRtc$RoomUpdate.getClass();
        if (this.messageCase_ != 11 || this.message_ == LivekitRtc$RoomUpdate.getDefaultInstance()) {
            this.message_ = livekitRtc$RoomUpdate;
        } else {
            this.message_ = ((LivekitRtc$RoomUpdate.a) LivekitRtc$RoomUpdate.newBuilder((LivekitRtc$RoomUpdate) this.message_).v(livekitRtc$RoomUpdate)).j();
        }
        this.messageCase_ = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSpeakersChanged(LivekitRtc$SpeakersChanged livekitRtc$SpeakersChanged) {
        livekitRtc$SpeakersChanged.getClass();
        if (this.messageCase_ != 10 || this.message_ == LivekitRtc$SpeakersChanged.getDefaultInstance()) {
            this.message_ = livekitRtc$SpeakersChanged;
        } else {
            this.message_ = ((LivekitRtc$SpeakersChanged.a) LivekitRtc$SpeakersChanged.newBuilder((LivekitRtc$SpeakersChanged) this.message_).v(livekitRtc$SpeakersChanged)).j();
        }
        this.messageCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStreamStateUpdate(LivekitRtc$StreamStateUpdate livekitRtc$StreamStateUpdate) {
        livekitRtc$StreamStateUpdate.getClass();
        if (this.messageCase_ != 13 || this.message_ == LivekitRtc$StreamStateUpdate.getDefaultInstance()) {
            this.message_ = livekitRtc$StreamStateUpdate;
        } else {
            this.message_ = ((LivekitRtc$StreamStateUpdate.a) LivekitRtc$StreamStateUpdate.newBuilder((LivekitRtc$StreamStateUpdate) this.message_).v(livekitRtc$StreamStateUpdate)).j();
        }
        this.messageCase_ = 13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSubscribedQualityUpdate(LivekitRtc$SubscribedQualityUpdate livekitRtc$SubscribedQualityUpdate) {
        livekitRtc$SubscribedQualityUpdate.getClass();
        if (this.messageCase_ != 14 || this.message_ == LivekitRtc$SubscribedQualityUpdate.getDefaultInstance()) {
            this.message_ = livekitRtc$SubscribedQualityUpdate;
        } else {
            this.message_ = ((LivekitRtc$SubscribedQualityUpdate.a) LivekitRtc$SubscribedQualityUpdate.newBuilder((LivekitRtc$SubscribedQualityUpdate) this.message_).v(livekitRtc$SubscribedQualityUpdate)).j();
        }
        this.messageCase_ = 14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSubscriptionPermissionUpdate(LivekitRtc$SubscriptionPermissionUpdate livekitRtc$SubscriptionPermissionUpdate) {
        livekitRtc$SubscriptionPermissionUpdate.getClass();
        if (this.messageCase_ != 15 || this.message_ == LivekitRtc$SubscriptionPermissionUpdate.getDefaultInstance()) {
            this.message_ = livekitRtc$SubscriptionPermissionUpdate;
        } else {
            this.message_ = ((LivekitRtc$SubscriptionPermissionUpdate.a) LivekitRtc$SubscriptionPermissionUpdate.newBuilder((LivekitRtc$SubscriptionPermissionUpdate) this.message_).v(livekitRtc$SubscriptionPermissionUpdate)).j();
        }
        this.messageCase_ = 15;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSubscriptionResponse(LivekitRtc$SubscriptionResponse livekitRtc$SubscriptionResponse) {
        livekitRtc$SubscriptionResponse.getClass();
        if (this.messageCase_ != 21 || this.message_ == LivekitRtc$SubscriptionResponse.getDefaultInstance()) {
            this.message_ = livekitRtc$SubscriptionResponse;
        } else {
            this.message_ = ((LivekitRtc$SubscriptionResponse.a) LivekitRtc$SubscriptionResponse.newBuilder((LivekitRtc$SubscriptionResponse) this.message_).v(livekitRtc$SubscriptionResponse)).j();
        }
        this.messageCase_ = 21;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTrackPublished(LivekitRtc$TrackPublishedResponse livekitRtc$TrackPublishedResponse) {
        livekitRtc$TrackPublishedResponse.getClass();
        if (this.messageCase_ != 6 || this.message_ == LivekitRtc$TrackPublishedResponse.getDefaultInstance()) {
            this.message_ = livekitRtc$TrackPublishedResponse;
        } else {
            this.message_ = ((LivekitRtc$TrackPublishedResponse.a) LivekitRtc$TrackPublishedResponse.newBuilder((LivekitRtc$TrackPublishedResponse) this.message_).v(livekitRtc$TrackPublishedResponse)).j();
        }
        this.messageCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTrackSubscribed(LivekitRtc$TrackSubscribed livekitRtc$TrackSubscribed) {
        livekitRtc$TrackSubscribed.getClass();
        if (this.messageCase_ != 23 || this.message_ == LivekitRtc$TrackSubscribed.getDefaultInstance()) {
            this.message_ = livekitRtc$TrackSubscribed;
        } else {
            this.message_ = ((LivekitRtc$TrackSubscribed.a) LivekitRtc$TrackSubscribed.newBuilder((LivekitRtc$TrackSubscribed) this.message_).v(livekitRtc$TrackSubscribed)).j();
        }
        this.messageCase_ = 23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTrackUnpublished(LivekitRtc$TrackUnpublishedResponse livekitRtc$TrackUnpublishedResponse) {
        livekitRtc$TrackUnpublishedResponse.getClass();
        if (this.messageCase_ != 17 || this.message_ == LivekitRtc$TrackUnpublishedResponse.getDefaultInstance()) {
            this.message_ = livekitRtc$TrackUnpublishedResponse;
        } else {
            this.message_ = ((LivekitRtc$TrackUnpublishedResponse.a) LivekitRtc$TrackUnpublishedResponse.newBuilder((LivekitRtc$TrackUnpublishedResponse) this.message_).v(livekitRtc$TrackUnpublishedResponse)).j();
        }
        this.messageCase_ = 17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTrickle(LivekitRtc$TrickleRequest livekitRtc$TrickleRequest) {
        livekitRtc$TrickleRequest.getClass();
        if (this.messageCase_ != 4 || this.message_ == LivekitRtc$TrickleRequest.getDefaultInstance()) {
            this.message_ = livekitRtc$TrickleRequest;
        } else {
            this.message_ = ((LivekitRtc$TrickleRequest.a) LivekitRtc$TrickleRequest.newBuilder((LivekitRtc$TrickleRequest) this.message_).v(livekitRtc$TrickleRequest)).j();
        }
        this.messageCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdate(LivekitRtc$ParticipantUpdate livekitRtc$ParticipantUpdate) {
        livekitRtc$ParticipantUpdate.getClass();
        if (this.messageCase_ != 5 || this.message_ == LivekitRtc$ParticipantUpdate.getDefaultInstance()) {
            this.message_ = livekitRtc$ParticipantUpdate;
        } else {
            this.message_ = ((LivekitRtc$ParticipantUpdate.a) LivekitRtc$ParticipantUpdate.newBuilder((LivekitRtc$ParticipantUpdate) this.message_).v(livekitRtc$ParticipantUpdate)).j();
        }
        this.messageCase_ = 5;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$SignalResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$SignalResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SignalResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$SignalResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnswer(LivekitRtc$SessionDescription livekitRtc$SessionDescription) {
        livekitRtc$SessionDescription.getClass();
        this.message_ = livekitRtc$SessionDescription;
        this.messageCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionQuality(LivekitRtc$ConnectionQualityUpdate livekitRtc$ConnectionQualityUpdate) {
        livekitRtc$ConnectionQualityUpdate.getClass();
        this.message_ = livekitRtc$ConnectionQualityUpdate;
        this.messageCase_ = 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJoin(LivekitRtc$JoinResponse livekitRtc$JoinResponse) {
        livekitRtc$JoinResponse.getClass();
        this.message_ = livekitRtc$JoinResponse;
        this.messageCase_ = 1;
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
        this.messageCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOffer(LivekitRtc$SessionDescription livekitRtc$SessionDescription) {
        livekitRtc$SessionDescription.getClass();
        this.message_ = livekitRtc$SessionDescription;
        this.messageCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPong(long j) {
        this.messageCase_ = 18;
        this.message_ = Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPongResp(LivekitRtc$Pong livekitRtc$Pong) {
        livekitRtc$Pong.getClass();
        this.message_ = livekitRtc$Pong;
        this.messageCase_ = 20;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReconnect(LivekitRtc$ReconnectResponse livekitRtc$ReconnectResponse) {
        livekitRtc$ReconnectResponse.getClass();
        this.message_ = livekitRtc$ReconnectResponse;
        this.messageCase_ = 19;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRefreshToken(String str) {
        str.getClass();
        this.messageCase_ = 16;
        this.message_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRefreshTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.message_ = abstractC2383g.f0();
        this.messageCase_ = 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestResponse(LivekitRtc$RequestResponse livekitRtc$RequestResponse) {
        livekitRtc$RequestResponse.getClass();
        this.message_ = livekitRtc$RequestResponse;
        this.messageCase_ = 22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomMoved(LivekitRtc$RoomMovedResponse livekitRtc$RoomMovedResponse) {
        livekitRtc$RoomMovedResponse.getClass();
        this.message_ = livekitRtc$RoomMovedResponse;
        this.messageCase_ = 24;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomUpdate(LivekitRtc$RoomUpdate livekitRtc$RoomUpdate) {
        livekitRtc$RoomUpdate.getClass();
        this.message_ = livekitRtc$RoomUpdate;
        this.messageCase_ = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpeakersChanged(LivekitRtc$SpeakersChanged livekitRtc$SpeakersChanged) {
        livekitRtc$SpeakersChanged.getClass();
        this.message_ = livekitRtc$SpeakersChanged;
        this.messageCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreamStateUpdate(LivekitRtc$StreamStateUpdate livekitRtc$StreamStateUpdate) {
        livekitRtc$StreamStateUpdate.getClass();
        this.message_ = livekitRtc$StreamStateUpdate;
        this.messageCase_ = 13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubscribedQualityUpdate(LivekitRtc$SubscribedQualityUpdate livekitRtc$SubscribedQualityUpdate) {
        livekitRtc$SubscribedQualityUpdate.getClass();
        this.message_ = livekitRtc$SubscribedQualityUpdate;
        this.messageCase_ = 14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubscriptionPermissionUpdate(LivekitRtc$SubscriptionPermissionUpdate livekitRtc$SubscriptionPermissionUpdate) {
        livekitRtc$SubscriptionPermissionUpdate.getClass();
        this.message_ = livekitRtc$SubscriptionPermissionUpdate;
        this.messageCase_ = 15;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubscriptionResponse(LivekitRtc$SubscriptionResponse livekitRtc$SubscriptionResponse) {
        livekitRtc$SubscriptionResponse.getClass();
        this.message_ = livekitRtc$SubscriptionResponse;
        this.messageCase_ = 21;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackPublished(LivekitRtc$TrackPublishedResponse livekitRtc$TrackPublishedResponse) {
        livekitRtc$TrackPublishedResponse.getClass();
        this.message_ = livekitRtc$TrackPublishedResponse;
        this.messageCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackSubscribed(LivekitRtc$TrackSubscribed livekitRtc$TrackSubscribed) {
        livekitRtc$TrackSubscribed.getClass();
        this.message_ = livekitRtc$TrackSubscribed;
        this.messageCase_ = 23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackUnpublished(LivekitRtc$TrackUnpublishedResponse livekitRtc$TrackUnpublishedResponse) {
        livekitRtc$TrackUnpublishedResponse.getClass();
        this.message_ = livekitRtc$TrackUnpublishedResponse;
        this.messageCase_ = 17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrickle(LivekitRtc$TrickleRequest livekitRtc$TrickleRequest) {
        livekitRtc$TrickleRequest.getClass();
        this.message_ = livekitRtc$TrickleRequest;
        this.messageCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdate(LivekitRtc$ParticipantUpdate livekitRtc$ParticipantUpdate) {
        livekitRtc$ParticipantUpdate.getClass();
        this.message_ = livekitRtc$ParticipantUpdate;
        this.messageCase_ = 5;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$SignalResponse();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0017\u0001\u0000\u0001\u0018\u0017\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b<\u0000\f<\u0000\r<\u0000\u000e<\u0000\u000f<\u0000\u0010Ȼ\u0000\u0011<\u0000\u00125\u0000\u0013<\u0000\u0014<\u0000\u0015<\u0000\u0016<\u0000\u0017<\u0000\u0018<\u0000", new Object[]{"message_", "messageCase_", LivekitRtc$JoinResponse.class, LivekitRtc$SessionDescription.class, LivekitRtc$SessionDescription.class, LivekitRtc$TrickleRequest.class, LivekitRtc$ParticipantUpdate.class, LivekitRtc$TrackPublishedResponse.class, LivekitRtc$LeaveRequest.class, LivekitRtc$MuteTrackRequest.class, LivekitRtc$SpeakersChanged.class, LivekitRtc$RoomUpdate.class, LivekitRtc$ConnectionQualityUpdate.class, LivekitRtc$StreamStateUpdate.class, LivekitRtc$SubscribedQualityUpdate.class, LivekitRtc$SubscriptionPermissionUpdate.class, LivekitRtc$TrackUnpublishedResponse.class, LivekitRtc$ReconnectResponse.class, LivekitRtc$Pong.class, LivekitRtc$SubscriptionResponse.class, LivekitRtc$RequestResponse.class, LivekitRtc$TrackSubscribed.class, LivekitRtc$RoomMovedResponse.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$SignalResponse.class) {
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

    public LivekitRtc$SessionDescription getAnswer() {
        return this.messageCase_ == 2 ? (LivekitRtc$SessionDescription) this.message_ : LivekitRtc$SessionDescription.getDefaultInstance();
    }

    public LivekitRtc$ConnectionQualityUpdate getConnectionQuality() {
        return this.messageCase_ == 12 ? (LivekitRtc$ConnectionQualityUpdate) this.message_ : LivekitRtc$ConnectionQualityUpdate.getDefaultInstance();
    }

    public LivekitRtc$JoinResponse getJoin() {
        return this.messageCase_ == 1 ? (LivekitRtc$JoinResponse) this.message_ : LivekitRtc$JoinResponse.getDefaultInstance();
    }

    public LivekitRtc$LeaveRequest getLeave() {
        return this.messageCase_ == 8 ? (LivekitRtc$LeaveRequest) this.message_ : LivekitRtc$LeaveRequest.getDefaultInstance();
    }

    public b getMessageCase() {
        return b.j(this.messageCase_);
    }

    public LivekitRtc$MuteTrackRequest getMute() {
        return this.messageCase_ == 9 ? (LivekitRtc$MuteTrackRequest) this.message_ : LivekitRtc$MuteTrackRequest.getDefaultInstance();
    }

    public LivekitRtc$SessionDescription getOffer() {
        return this.messageCase_ == 3 ? (LivekitRtc$SessionDescription) this.message_ : LivekitRtc$SessionDescription.getDefaultInstance();
    }

    public long getPong() {
        if (this.messageCase_ == 18) {
            return ((Long) this.message_).longValue();
        }
        return 0L;
    }

    public LivekitRtc$Pong getPongResp() {
        return this.messageCase_ == 20 ? (LivekitRtc$Pong) this.message_ : LivekitRtc$Pong.getDefaultInstance();
    }

    public LivekitRtc$ReconnectResponse getReconnect() {
        return this.messageCase_ == 19 ? (LivekitRtc$ReconnectResponse) this.message_ : LivekitRtc$ReconnectResponse.getDefaultInstance();
    }

    public String getRefreshToken() {
        return this.messageCase_ == 16 ? (String) this.message_ : "";
    }

    public AbstractC2383g getRefreshTokenBytes() {
        return AbstractC2383g.N(this.messageCase_ == 16 ? (String) this.message_ : "");
    }

    public LivekitRtc$RequestResponse getRequestResponse() {
        return this.messageCase_ == 22 ? (LivekitRtc$RequestResponse) this.message_ : LivekitRtc$RequestResponse.getDefaultInstance();
    }

    public LivekitRtc$RoomMovedResponse getRoomMoved() {
        return this.messageCase_ == 24 ? (LivekitRtc$RoomMovedResponse) this.message_ : LivekitRtc$RoomMovedResponse.getDefaultInstance();
    }

    public LivekitRtc$RoomUpdate getRoomUpdate() {
        return this.messageCase_ == 11 ? (LivekitRtc$RoomUpdate) this.message_ : LivekitRtc$RoomUpdate.getDefaultInstance();
    }

    public LivekitRtc$SpeakersChanged getSpeakersChanged() {
        return this.messageCase_ == 10 ? (LivekitRtc$SpeakersChanged) this.message_ : LivekitRtc$SpeakersChanged.getDefaultInstance();
    }

    public LivekitRtc$StreamStateUpdate getStreamStateUpdate() {
        return this.messageCase_ == 13 ? (LivekitRtc$StreamStateUpdate) this.message_ : LivekitRtc$StreamStateUpdate.getDefaultInstance();
    }

    public LivekitRtc$SubscribedQualityUpdate getSubscribedQualityUpdate() {
        return this.messageCase_ == 14 ? (LivekitRtc$SubscribedQualityUpdate) this.message_ : LivekitRtc$SubscribedQualityUpdate.getDefaultInstance();
    }

    public LivekitRtc$SubscriptionPermissionUpdate getSubscriptionPermissionUpdate() {
        return this.messageCase_ == 15 ? (LivekitRtc$SubscriptionPermissionUpdate) this.message_ : LivekitRtc$SubscriptionPermissionUpdate.getDefaultInstance();
    }

    public LivekitRtc$SubscriptionResponse getSubscriptionResponse() {
        return this.messageCase_ == 21 ? (LivekitRtc$SubscriptionResponse) this.message_ : LivekitRtc$SubscriptionResponse.getDefaultInstance();
    }

    public LivekitRtc$TrackPublishedResponse getTrackPublished() {
        return this.messageCase_ == 6 ? (LivekitRtc$TrackPublishedResponse) this.message_ : LivekitRtc$TrackPublishedResponse.getDefaultInstance();
    }

    public LivekitRtc$TrackSubscribed getTrackSubscribed() {
        return this.messageCase_ == 23 ? (LivekitRtc$TrackSubscribed) this.message_ : LivekitRtc$TrackSubscribed.getDefaultInstance();
    }

    public LivekitRtc$TrackUnpublishedResponse getTrackUnpublished() {
        return this.messageCase_ == 17 ? (LivekitRtc$TrackUnpublishedResponse) this.message_ : LivekitRtc$TrackUnpublishedResponse.getDefaultInstance();
    }

    public LivekitRtc$TrickleRequest getTrickle() {
        return this.messageCase_ == 4 ? (LivekitRtc$TrickleRequest) this.message_ : LivekitRtc$TrickleRequest.getDefaultInstance();
    }

    public LivekitRtc$ParticipantUpdate getUpdate() {
        return this.messageCase_ == 5 ? (LivekitRtc$ParticipantUpdate) this.message_ : LivekitRtc$ParticipantUpdate.getDefaultInstance();
    }

    public boolean hasAnswer() {
        return this.messageCase_ == 2;
    }

    public boolean hasConnectionQuality() {
        return this.messageCase_ == 12;
    }

    public boolean hasJoin() {
        return this.messageCase_ == 1;
    }

    public boolean hasLeave() {
        return this.messageCase_ == 8;
    }

    public boolean hasMute() {
        return this.messageCase_ == 9;
    }

    public boolean hasOffer() {
        return this.messageCase_ == 3;
    }

    public boolean hasPong() {
        return this.messageCase_ == 18;
    }

    public boolean hasPongResp() {
        return this.messageCase_ == 20;
    }

    public boolean hasReconnect() {
        return this.messageCase_ == 19;
    }

    public boolean hasRefreshToken() {
        return this.messageCase_ == 16;
    }

    public boolean hasRequestResponse() {
        return this.messageCase_ == 22;
    }

    public boolean hasRoomMoved() {
        return this.messageCase_ == 24;
    }

    public boolean hasRoomUpdate() {
        return this.messageCase_ == 11;
    }

    public boolean hasSpeakersChanged() {
        return this.messageCase_ == 10;
    }

    public boolean hasStreamStateUpdate() {
        return this.messageCase_ == 13;
    }

    public boolean hasSubscribedQualityUpdate() {
        return this.messageCase_ == 14;
    }

    public boolean hasSubscriptionPermissionUpdate() {
        return this.messageCase_ == 15;
    }

    public boolean hasSubscriptionResponse() {
        return this.messageCase_ == 21;
    }

    public boolean hasTrackPublished() {
        return this.messageCase_ == 6;
    }

    public boolean hasTrackSubscribed() {
        return this.messageCase_ == 23;
    }

    public boolean hasTrackUnpublished() {
        return this.messageCase_ == 17;
    }

    public boolean hasTrickle() {
        return this.messageCase_ == 4;
    }

    public boolean hasUpdate() {
        return this.messageCase_ == 5;
    }

    public static a newBuilder(LivekitRtc$SignalResponse livekitRtc$SignalResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$SignalResponse);
    }

    public static LivekitRtc$SignalResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SignalResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SignalResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$SignalResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$SignalResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$SignalResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$SignalResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$SignalResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$SignalResponse parseFrom(byte[] bArr) {
        return (LivekitRtc$SignalResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$SignalResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$SignalResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$SignalResponse parseFrom(InputStream inputStream) {
        return (LivekitRtc$SignalResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SignalResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SignalResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SignalResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$SignalResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$SignalResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$SignalResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

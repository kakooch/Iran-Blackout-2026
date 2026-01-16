package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitRoom$CreateRoomRequest;
import livekit.LivekitRoom$DeleteRoomRequest;
import livekit.LivekitRoom$ListParticipantsRequest;
import livekit.LivekitRoom$ListRoomsRequest;
import livekit.LivekitRoom$MuteRoomTrackRequest;
import livekit.LivekitRoom$RoomParticipantIdentity;
import livekit.LivekitRoom$SendDataRequest;
import livekit.LivekitRoom$UpdateParticipantRequest;
import livekit.LivekitRoom$UpdateRoomMetadataRequest;
import livekit.LivekitRoom$UpdateSubscriptionsRequest;

/* loaded from: classes8.dex */
public final class LivekitAnalytics$APICallRequest extends GeneratedMessageLite implements U64 {
    public static final int CREATE_ROOM_REQUEST_FIELD_NUMBER = 1;
    private static final LivekitAnalytics$APICallRequest DEFAULT_INSTANCE;
    public static final int DELETE_ROOM_REQUEST_FIELD_NUMBER = 3;
    public static final int LIST_PARTICIPANTS_REQUEST_FIELD_NUMBER = 4;
    public static final int LIST_ROOMS_REQUEST_FIELD_NUMBER = 2;
    public static final int MUTE_ROOM_TRACK_REQUEST_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int ROOM_PARTICIPANT_IDENTITY_FIELD_NUMBER = 5;
    public static final int SEND_DATA_REQUEST_FIELD_NUMBER = 9;
    public static final int UPDATE_PARTICIPANT_REQUEST_FIELD_NUMBER = 7;
    public static final int UPDATE_ROOM_METADATA_REQUEST_FIELD_NUMBER = 10;
    public static final int UPDATE_SUBSCRIPTIONS_REQUEST_FIELD_NUMBER = 8;
    private int messageCase_ = 0;
    private Object message_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(c cVar) {
            this();
        }

        private a() {
            super(LivekitAnalytics$APICallRequest.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        CREATE_ROOM_REQUEST(1),
        LIST_ROOMS_REQUEST(2),
        DELETE_ROOM_REQUEST(3),
        LIST_PARTICIPANTS_REQUEST(4),
        ROOM_PARTICIPANT_IDENTITY(5),
        MUTE_ROOM_TRACK_REQUEST(6),
        UPDATE_PARTICIPANT_REQUEST(7),
        UPDATE_SUBSCRIPTIONS_REQUEST(8),
        SEND_DATA_REQUEST(9),
        UPDATE_ROOM_METADATA_REQUEST(10),
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
                    return CREATE_ROOM_REQUEST;
                case 2:
                    return LIST_ROOMS_REQUEST;
                case 3:
                    return DELETE_ROOM_REQUEST;
                case 4:
                    return LIST_PARTICIPANTS_REQUEST;
                case 5:
                    return ROOM_PARTICIPANT_IDENTITY;
                case 6:
                    return MUTE_ROOM_TRACK_REQUEST;
                case 7:
                    return UPDATE_PARTICIPANT_REQUEST;
                case 8:
                    return UPDATE_SUBSCRIPTIONS_REQUEST;
                case 9:
                    return SEND_DATA_REQUEST;
                case 10:
                    return UPDATE_ROOM_METADATA_REQUEST;
                default:
                    return null;
            }
        }
    }

    static {
        LivekitAnalytics$APICallRequest livekitAnalytics$APICallRequest = new LivekitAnalytics$APICallRequest();
        DEFAULT_INSTANCE = livekitAnalytics$APICallRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitAnalytics$APICallRequest.class, livekitAnalytics$APICallRequest);
    }

    private LivekitAnalytics$APICallRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreateRoomRequest() {
        if (this.messageCase_ == 1) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeleteRoomRequest() {
        if (this.messageCase_ == 3) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearListParticipantsRequest() {
        if (this.messageCase_ == 4) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearListRoomsRequest() {
        if (this.messageCase_ == 2) {
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
    public void clearMuteRoomTrackRequest() {
        if (this.messageCase_ == 6) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomParticipantIdentity() {
        if (this.messageCase_ == 5) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSendDataRequest() {
        if (this.messageCase_ == 9) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdateParticipantRequest() {
        if (this.messageCase_ == 7) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdateRoomMetadataRequest() {
        if (this.messageCase_ == 10) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdateSubscriptionsRequest() {
        if (this.messageCase_ == 8) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    public static LivekitAnalytics$APICallRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCreateRoomRequest(LivekitRoom$CreateRoomRequest livekitRoom$CreateRoomRequest) {
        livekitRoom$CreateRoomRequest.getClass();
        if (this.messageCase_ != 1 || this.message_ == LivekitRoom$CreateRoomRequest.getDefaultInstance()) {
            this.message_ = livekitRoom$CreateRoomRequest;
        } else {
            this.message_ = ((LivekitRoom$CreateRoomRequest.a) LivekitRoom$CreateRoomRequest.newBuilder((LivekitRoom$CreateRoomRequest) this.message_).v(livekitRoom$CreateRoomRequest)).j();
        }
        this.messageCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDeleteRoomRequest(LivekitRoom$DeleteRoomRequest livekitRoom$DeleteRoomRequest) {
        livekitRoom$DeleteRoomRequest.getClass();
        if (this.messageCase_ != 3 || this.message_ == LivekitRoom$DeleteRoomRequest.getDefaultInstance()) {
            this.message_ = livekitRoom$DeleteRoomRequest;
        } else {
            this.message_ = ((LivekitRoom$DeleteRoomRequest.a) LivekitRoom$DeleteRoomRequest.newBuilder((LivekitRoom$DeleteRoomRequest) this.message_).v(livekitRoom$DeleteRoomRequest)).j();
        }
        this.messageCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeListParticipantsRequest(LivekitRoom$ListParticipantsRequest livekitRoom$ListParticipantsRequest) {
        livekitRoom$ListParticipantsRequest.getClass();
        if (this.messageCase_ != 4 || this.message_ == LivekitRoom$ListParticipantsRequest.getDefaultInstance()) {
            this.message_ = livekitRoom$ListParticipantsRequest;
        } else {
            this.message_ = ((LivekitRoom$ListParticipantsRequest.a) LivekitRoom$ListParticipantsRequest.newBuilder((LivekitRoom$ListParticipantsRequest) this.message_).v(livekitRoom$ListParticipantsRequest)).j();
        }
        this.messageCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeListRoomsRequest(LivekitRoom$ListRoomsRequest livekitRoom$ListRoomsRequest) {
        livekitRoom$ListRoomsRequest.getClass();
        if (this.messageCase_ != 2 || this.message_ == LivekitRoom$ListRoomsRequest.getDefaultInstance()) {
            this.message_ = livekitRoom$ListRoomsRequest;
        } else {
            this.message_ = ((LivekitRoom$ListRoomsRequest.a) LivekitRoom$ListRoomsRequest.newBuilder((LivekitRoom$ListRoomsRequest) this.message_).v(livekitRoom$ListRoomsRequest)).j();
        }
        this.messageCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMuteRoomTrackRequest(LivekitRoom$MuteRoomTrackRequest livekitRoom$MuteRoomTrackRequest) {
        livekitRoom$MuteRoomTrackRequest.getClass();
        if (this.messageCase_ != 6 || this.message_ == LivekitRoom$MuteRoomTrackRequest.getDefaultInstance()) {
            this.message_ = livekitRoom$MuteRoomTrackRequest;
        } else {
            this.message_ = ((LivekitRoom$MuteRoomTrackRequest.a) LivekitRoom$MuteRoomTrackRequest.newBuilder((LivekitRoom$MuteRoomTrackRequest) this.message_).v(livekitRoom$MuteRoomTrackRequest)).j();
        }
        this.messageCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRoomParticipantIdentity(LivekitRoom$RoomParticipantIdentity livekitRoom$RoomParticipantIdentity) {
        livekitRoom$RoomParticipantIdentity.getClass();
        if (this.messageCase_ != 5 || this.message_ == LivekitRoom$RoomParticipantIdentity.getDefaultInstance()) {
            this.message_ = livekitRoom$RoomParticipantIdentity;
        } else {
            this.message_ = ((LivekitRoom$RoomParticipantIdentity.a) LivekitRoom$RoomParticipantIdentity.newBuilder((LivekitRoom$RoomParticipantIdentity) this.message_).v(livekitRoom$RoomParticipantIdentity)).j();
        }
        this.messageCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSendDataRequest(LivekitRoom$SendDataRequest livekitRoom$SendDataRequest) {
        livekitRoom$SendDataRequest.getClass();
        if (this.messageCase_ != 9 || this.message_ == LivekitRoom$SendDataRequest.getDefaultInstance()) {
            this.message_ = livekitRoom$SendDataRequest;
        } else {
            this.message_ = ((LivekitRoom$SendDataRequest.a) LivekitRoom$SendDataRequest.newBuilder((LivekitRoom$SendDataRequest) this.message_).v(livekitRoom$SendDataRequest)).j();
        }
        this.messageCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdateParticipantRequest(LivekitRoom$UpdateParticipantRequest livekitRoom$UpdateParticipantRequest) {
        livekitRoom$UpdateParticipantRequest.getClass();
        if (this.messageCase_ != 7 || this.message_ == LivekitRoom$UpdateParticipantRequest.getDefaultInstance()) {
            this.message_ = livekitRoom$UpdateParticipantRequest;
        } else {
            this.message_ = ((LivekitRoom$UpdateParticipantRequest.b) LivekitRoom$UpdateParticipantRequest.newBuilder((LivekitRoom$UpdateParticipantRequest) this.message_).v(livekitRoom$UpdateParticipantRequest)).j();
        }
        this.messageCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdateRoomMetadataRequest(LivekitRoom$UpdateRoomMetadataRequest livekitRoom$UpdateRoomMetadataRequest) {
        livekitRoom$UpdateRoomMetadataRequest.getClass();
        if (this.messageCase_ != 10 || this.message_ == LivekitRoom$UpdateRoomMetadataRequest.getDefaultInstance()) {
            this.message_ = livekitRoom$UpdateRoomMetadataRequest;
        } else {
            this.message_ = ((LivekitRoom$UpdateRoomMetadataRequest.a) LivekitRoom$UpdateRoomMetadataRequest.newBuilder((LivekitRoom$UpdateRoomMetadataRequest) this.message_).v(livekitRoom$UpdateRoomMetadataRequest)).j();
        }
        this.messageCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdateSubscriptionsRequest(LivekitRoom$UpdateSubscriptionsRequest livekitRoom$UpdateSubscriptionsRequest) {
        livekitRoom$UpdateSubscriptionsRequest.getClass();
        if (this.messageCase_ != 8 || this.message_ == LivekitRoom$UpdateSubscriptionsRequest.getDefaultInstance()) {
            this.message_ = livekitRoom$UpdateSubscriptionsRequest;
        } else {
            this.message_ = ((LivekitRoom$UpdateSubscriptionsRequest.a) LivekitRoom$UpdateSubscriptionsRequest.newBuilder((LivekitRoom$UpdateSubscriptionsRequest) this.message_).v(livekitRoom$UpdateSubscriptionsRequest)).j();
        }
        this.messageCase_ = 8;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAnalytics$APICallRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAnalytics$APICallRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$APICallRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAnalytics$APICallRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreateRoomRequest(LivekitRoom$CreateRoomRequest livekitRoom$CreateRoomRequest) {
        livekitRoom$CreateRoomRequest.getClass();
        this.message_ = livekitRoom$CreateRoomRequest;
        this.messageCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeleteRoomRequest(LivekitRoom$DeleteRoomRequest livekitRoom$DeleteRoomRequest) {
        livekitRoom$DeleteRoomRequest.getClass();
        this.message_ = livekitRoom$DeleteRoomRequest;
        this.messageCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListParticipantsRequest(LivekitRoom$ListParticipantsRequest livekitRoom$ListParticipantsRequest) {
        livekitRoom$ListParticipantsRequest.getClass();
        this.message_ = livekitRoom$ListParticipantsRequest;
        this.messageCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListRoomsRequest(LivekitRoom$ListRoomsRequest livekitRoom$ListRoomsRequest) {
        livekitRoom$ListRoomsRequest.getClass();
        this.message_ = livekitRoom$ListRoomsRequest;
        this.messageCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMuteRoomTrackRequest(LivekitRoom$MuteRoomTrackRequest livekitRoom$MuteRoomTrackRequest) {
        livekitRoom$MuteRoomTrackRequest.getClass();
        this.message_ = livekitRoom$MuteRoomTrackRequest;
        this.messageCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomParticipantIdentity(LivekitRoom$RoomParticipantIdentity livekitRoom$RoomParticipantIdentity) {
        livekitRoom$RoomParticipantIdentity.getClass();
        this.message_ = livekitRoom$RoomParticipantIdentity;
        this.messageCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSendDataRequest(LivekitRoom$SendDataRequest livekitRoom$SendDataRequest) {
        livekitRoom$SendDataRequest.getClass();
        this.message_ = livekitRoom$SendDataRequest;
        this.messageCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateParticipantRequest(LivekitRoom$UpdateParticipantRequest livekitRoom$UpdateParticipantRequest) {
        livekitRoom$UpdateParticipantRequest.getClass();
        this.message_ = livekitRoom$UpdateParticipantRequest;
        this.messageCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateRoomMetadataRequest(LivekitRoom$UpdateRoomMetadataRequest livekitRoom$UpdateRoomMetadataRequest) {
        livekitRoom$UpdateRoomMetadataRequest.getClass();
        this.message_ = livekitRoom$UpdateRoomMetadataRequest;
        this.messageCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateSubscriptionsRequest(LivekitRoom$UpdateSubscriptionsRequest livekitRoom$UpdateSubscriptionsRequest) {
        livekitRoom$UpdateSubscriptionsRequest.getClass();
        this.message_ = livekitRoom$UpdateSubscriptionsRequest;
        this.messageCase_ = 8;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        c cVar = null;
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAnalytics$APICallRequest();
            case 2:
                return new a(cVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0001\u0000\u0001\n\n\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000\n<\u0000", new Object[]{"message_", "messageCase_", LivekitRoom$CreateRoomRequest.class, LivekitRoom$ListRoomsRequest.class, LivekitRoom$DeleteRoomRequest.class, LivekitRoom$ListParticipantsRequest.class, LivekitRoom$RoomParticipantIdentity.class, LivekitRoom$MuteRoomTrackRequest.class, LivekitRoom$UpdateParticipantRequest.class, LivekitRoom$UpdateSubscriptionsRequest.class, LivekitRoom$SendDataRequest.class, LivekitRoom$UpdateRoomMetadataRequest.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar2 = PARSER;
                if (cVar2 == null) {
                    synchronized (LivekitAnalytics$APICallRequest.class) {
                        try {
                            cVar2 = PARSER;
                            if (cVar2 == null) {
                                cVar2 = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar2;
                            }
                        } finally {
                        }
                    }
                }
                return cVar2;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public LivekitRoom$CreateRoomRequest getCreateRoomRequest() {
        return this.messageCase_ == 1 ? (LivekitRoom$CreateRoomRequest) this.message_ : LivekitRoom$CreateRoomRequest.getDefaultInstance();
    }

    public LivekitRoom$DeleteRoomRequest getDeleteRoomRequest() {
        return this.messageCase_ == 3 ? (LivekitRoom$DeleteRoomRequest) this.message_ : LivekitRoom$DeleteRoomRequest.getDefaultInstance();
    }

    public LivekitRoom$ListParticipantsRequest getListParticipantsRequest() {
        return this.messageCase_ == 4 ? (LivekitRoom$ListParticipantsRequest) this.message_ : LivekitRoom$ListParticipantsRequest.getDefaultInstance();
    }

    public LivekitRoom$ListRoomsRequest getListRoomsRequest() {
        return this.messageCase_ == 2 ? (LivekitRoom$ListRoomsRequest) this.message_ : LivekitRoom$ListRoomsRequest.getDefaultInstance();
    }

    public b getMessageCase() {
        return b.j(this.messageCase_);
    }

    public LivekitRoom$MuteRoomTrackRequest getMuteRoomTrackRequest() {
        return this.messageCase_ == 6 ? (LivekitRoom$MuteRoomTrackRequest) this.message_ : LivekitRoom$MuteRoomTrackRequest.getDefaultInstance();
    }

    public LivekitRoom$RoomParticipantIdentity getRoomParticipantIdentity() {
        return this.messageCase_ == 5 ? (LivekitRoom$RoomParticipantIdentity) this.message_ : LivekitRoom$RoomParticipantIdentity.getDefaultInstance();
    }

    public LivekitRoom$SendDataRequest getSendDataRequest() {
        return this.messageCase_ == 9 ? (LivekitRoom$SendDataRequest) this.message_ : LivekitRoom$SendDataRequest.getDefaultInstance();
    }

    public LivekitRoom$UpdateParticipantRequest getUpdateParticipantRequest() {
        return this.messageCase_ == 7 ? (LivekitRoom$UpdateParticipantRequest) this.message_ : LivekitRoom$UpdateParticipantRequest.getDefaultInstance();
    }

    public LivekitRoom$UpdateRoomMetadataRequest getUpdateRoomMetadataRequest() {
        return this.messageCase_ == 10 ? (LivekitRoom$UpdateRoomMetadataRequest) this.message_ : LivekitRoom$UpdateRoomMetadataRequest.getDefaultInstance();
    }

    public LivekitRoom$UpdateSubscriptionsRequest getUpdateSubscriptionsRequest() {
        return this.messageCase_ == 8 ? (LivekitRoom$UpdateSubscriptionsRequest) this.message_ : LivekitRoom$UpdateSubscriptionsRequest.getDefaultInstance();
    }

    public boolean hasCreateRoomRequest() {
        return this.messageCase_ == 1;
    }

    public boolean hasDeleteRoomRequest() {
        return this.messageCase_ == 3;
    }

    public boolean hasListParticipantsRequest() {
        return this.messageCase_ == 4;
    }

    public boolean hasListRoomsRequest() {
        return this.messageCase_ == 2;
    }

    public boolean hasMuteRoomTrackRequest() {
        return this.messageCase_ == 6;
    }

    public boolean hasRoomParticipantIdentity() {
        return this.messageCase_ == 5;
    }

    public boolean hasSendDataRequest() {
        return this.messageCase_ == 9;
    }

    public boolean hasUpdateParticipantRequest() {
        return this.messageCase_ == 7;
    }

    public boolean hasUpdateRoomMetadataRequest() {
        return this.messageCase_ == 10;
    }

    public boolean hasUpdateSubscriptionsRequest() {
        return this.messageCase_ == 8;
    }

    public static a newBuilder(LivekitAnalytics$APICallRequest livekitAnalytics$APICallRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAnalytics$APICallRequest);
    }

    public static LivekitAnalytics$APICallRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$APICallRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$APICallRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAnalytics$APICallRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAnalytics$APICallRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAnalytics$APICallRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAnalytics$APICallRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAnalytics$APICallRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAnalytics$APICallRequest parseFrom(byte[] bArr) {
        return (LivekitAnalytics$APICallRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAnalytics$APICallRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAnalytics$APICallRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAnalytics$APICallRequest parseFrom(InputStream inputStream) {
        return (LivekitAnalytics$APICallRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$APICallRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$APICallRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$APICallRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAnalytics$APICallRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAnalytics$APICallRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAnalytics$APICallRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import ai.bale.proto.AbacusOuterClass$UpdateMessageReactions;
import ai.bale.proto.ConfigsOuterClass$UpdateEndpointChanged;
import ai.bale.proto.ConfigsOuterClass$UpdateHashEndpointChanged;
import ai.bale.proto.MeetOuterClass$UpdateCallAction;
import ai.bale.proto.MeetOuterClass$UpdateCallReactionSent;
import ai.bale.proto.MessagingOuterClass$UpdateMessage;
import ai.bale.proto.MessagingOuterClass$UpdateMessageContentChanged;
import ai.bale.proto.MessagingOuterClass$UpdateMessageDelete;
import ai.bale.proto.PresenceOuterClass$UpdateGroupOnline;
import ai.bale.proto.PresenceOuterClass$UpdateTyping;
import ai.bale.proto.PresenceOuterClass$UpdateTypingStop;
import ai.bale.proto.PresenceOuterClass$UpdateUserLastSeen;
import ai.bale.proto.PresenceOuterClass$UpdateUserLastSeenUnknown;
import ai.bale.proto.PresenceOuterClass$UpdateUserOffline;
import ai.bale.proto.PresenceOuterClass$UpdateUserOnline;
import ai.bale.proto.TimcheOuterClass$UpdateAskBotReview;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MavizStreamOuterClass$WeakEvent extends GeneratedMessageLite implements U64 {
    public static final int ASK_BOT_REVIEW_FIELD_NUMBER = 14;
    public static final int CALL_ACTION_FIELD_NUMBER = 13;
    public static final int CALL_REACTION_SENT_FIELD_NUMBER = 8;
    private static final MavizStreamOuterClass$WeakEvent DEFAULT_INSTANCE;
    public static final int ENDPOINT_CHANGED_FIELD_NUMBER = 15;
    public static final int GROUP_ONLINE_FIELD_NUMBER = 7;
    public static final int HASH_ENDPOINT_CHANGED_FIELD_NUMBER = 16;
    public static final int MESSAGE_REACTION_FIELD_NUMBER = 9;
    private static volatile KW4 PARSER = null;
    public static final int THREAD_DELETE_MESSAGE_FIELD_NUMBER = 12;
    public static final int THREAD_EDIT_MESSAGE_FIELD_NUMBER = 11;
    public static final int THREAD_MESSAGE_FIELD_NUMBER = 10;
    public static final int TYPING_FIELD_NUMBER = 1;
    public static final int TYPING_STOP_FIELD_NUMBER = 2;
    public static final int USER_LAST_SEEN_FIELD_NUMBER = 6;
    public static final int USER_LAST_SEEN_UNKNOWN_FIELD_NUMBER = 5;
    public static final int USER_OFFLINE_FIELD_NUMBER = 4;
    public static final int USER_ONLINE_FIELD_NUMBER = 3;
    private int eventCase_ = 0;
    private Object event_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MavizStreamOuterClass$WeakEvent.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        TYPING(1),
        TYPING_STOP(2),
        USER_ONLINE(3),
        USER_OFFLINE(4),
        USER_LAST_SEEN_UNKNOWN(5),
        USER_LAST_SEEN(6),
        GROUP_ONLINE(7),
        CALL_REACTION_SENT(8),
        MESSAGE_REACTION(9),
        THREAD_MESSAGE(10),
        THREAD_EDIT_MESSAGE(11),
        THREAD_DELETE_MESSAGE(12),
        CALL_ACTION(13),
        ASK_BOT_REVIEW(14),
        ENDPOINT_CHANGED(15),
        HASH_ENDPOINT_CHANGED(16),
        EVENT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            switch (i) {
                case 0:
                    return EVENT_NOT_SET;
                case 1:
                    return TYPING;
                case 2:
                    return TYPING_STOP;
                case 3:
                    return USER_ONLINE;
                case 4:
                    return USER_OFFLINE;
                case 5:
                    return USER_LAST_SEEN_UNKNOWN;
                case 6:
                    return USER_LAST_SEEN;
                case 7:
                    return GROUP_ONLINE;
                case 8:
                    return CALL_REACTION_SENT;
                case 9:
                    return MESSAGE_REACTION;
                case 10:
                    return THREAD_MESSAGE;
                case 11:
                    return THREAD_EDIT_MESSAGE;
                case 12:
                    return THREAD_DELETE_MESSAGE;
                case 13:
                    return CALL_ACTION;
                case 14:
                    return ASK_BOT_REVIEW;
                case 15:
                    return ENDPOINT_CHANGED;
                case 16:
                    return HASH_ENDPOINT_CHANGED;
                default:
                    return null;
            }
        }
    }

    static {
        MavizStreamOuterClass$WeakEvent mavizStreamOuterClass$WeakEvent = new MavizStreamOuterClass$WeakEvent();
        DEFAULT_INSTANCE = mavizStreamOuterClass$WeakEvent;
        GeneratedMessageLite.registerDefaultInstance(MavizStreamOuterClass$WeakEvent.class, mavizStreamOuterClass$WeakEvent);
    }

    private MavizStreamOuterClass$WeakEvent() {
    }

    private void clearAskBotReview() {
        if (this.eventCase_ == 14) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    private void clearCallAction() {
        if (this.eventCase_ == 13) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    private void clearCallReactionSent() {
        if (this.eventCase_ == 8) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    private void clearEndpointChanged() {
        if (this.eventCase_ == 15) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    private void clearEvent() {
        this.eventCase_ = 0;
        this.event_ = null;
    }

    private void clearGroupOnline() {
        if (this.eventCase_ == 7) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    private void clearHashEndpointChanged() {
        if (this.eventCase_ == 16) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    private void clearMessageReaction() {
        if (this.eventCase_ == 9) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    private void clearThreadDeleteMessage() {
        if (this.eventCase_ == 12) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    private void clearThreadEditMessage() {
        if (this.eventCase_ == 11) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    private void clearThreadMessage() {
        if (this.eventCase_ == 10) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    private void clearTyping() {
        if (this.eventCase_ == 1) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    private void clearTypingStop() {
        if (this.eventCase_ == 2) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    private void clearUserLastSeen() {
        if (this.eventCase_ == 6) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    private void clearUserLastSeenUnknown() {
        if (this.eventCase_ == 5) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    private void clearUserOffline() {
        if (this.eventCase_ == 4) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    private void clearUserOnline() {
        if (this.eventCase_ == 3) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    public static MavizStreamOuterClass$WeakEvent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAskBotReview(TimcheOuterClass$UpdateAskBotReview timcheOuterClass$UpdateAskBotReview) {
        timcheOuterClass$UpdateAskBotReview.getClass();
        if (this.eventCase_ != 14 || this.event_ == TimcheOuterClass$UpdateAskBotReview.getDefaultInstance()) {
            this.event_ = timcheOuterClass$UpdateAskBotReview;
        } else {
            this.event_ = ((TimcheOuterClass$UpdateAskBotReview.a) TimcheOuterClass$UpdateAskBotReview.newBuilder((TimcheOuterClass$UpdateAskBotReview) this.event_).v(timcheOuterClass$UpdateAskBotReview)).j();
        }
        this.eventCase_ = 14;
    }

    private void mergeCallAction(MeetOuterClass$UpdateCallAction meetOuterClass$UpdateCallAction) {
        meetOuterClass$UpdateCallAction.getClass();
        if (this.eventCase_ != 13 || this.event_ == MeetOuterClass$UpdateCallAction.getDefaultInstance()) {
            this.event_ = meetOuterClass$UpdateCallAction;
        } else {
            this.event_ = ((MeetOuterClass$UpdateCallAction.a) MeetOuterClass$UpdateCallAction.newBuilder((MeetOuterClass$UpdateCallAction) this.event_).v(meetOuterClass$UpdateCallAction)).j();
        }
        this.eventCase_ = 13;
    }

    private void mergeCallReactionSent(MeetOuterClass$UpdateCallReactionSent meetOuterClass$UpdateCallReactionSent) {
        meetOuterClass$UpdateCallReactionSent.getClass();
        if (this.eventCase_ != 8 || this.event_ == MeetOuterClass$UpdateCallReactionSent.getDefaultInstance()) {
            this.event_ = meetOuterClass$UpdateCallReactionSent;
        } else {
            this.event_ = ((MeetOuterClass$UpdateCallReactionSent.a) MeetOuterClass$UpdateCallReactionSent.newBuilder((MeetOuterClass$UpdateCallReactionSent) this.event_).v(meetOuterClass$UpdateCallReactionSent)).j();
        }
        this.eventCase_ = 8;
    }

    private void mergeEndpointChanged(ConfigsOuterClass$UpdateEndpointChanged configsOuterClass$UpdateEndpointChanged) {
        configsOuterClass$UpdateEndpointChanged.getClass();
        if (this.eventCase_ != 15 || this.event_ == ConfigsOuterClass$UpdateEndpointChanged.getDefaultInstance()) {
            this.event_ = configsOuterClass$UpdateEndpointChanged;
        } else {
            this.event_ = ((ConfigsOuterClass$UpdateEndpointChanged.a) ConfigsOuterClass$UpdateEndpointChanged.newBuilder((ConfigsOuterClass$UpdateEndpointChanged) this.event_).v(configsOuterClass$UpdateEndpointChanged)).j();
        }
        this.eventCase_ = 15;
    }

    private void mergeGroupOnline(PresenceOuterClass$UpdateGroupOnline presenceOuterClass$UpdateGroupOnline) {
        presenceOuterClass$UpdateGroupOnline.getClass();
        if (this.eventCase_ != 7 || this.event_ == PresenceOuterClass$UpdateGroupOnline.getDefaultInstance()) {
            this.event_ = presenceOuterClass$UpdateGroupOnline;
        } else {
            this.event_ = ((PresenceOuterClass$UpdateGroupOnline.a) PresenceOuterClass$UpdateGroupOnline.newBuilder((PresenceOuterClass$UpdateGroupOnline) this.event_).v(presenceOuterClass$UpdateGroupOnline)).j();
        }
        this.eventCase_ = 7;
    }

    private void mergeHashEndpointChanged(ConfigsOuterClass$UpdateHashEndpointChanged configsOuterClass$UpdateHashEndpointChanged) {
        configsOuterClass$UpdateHashEndpointChanged.getClass();
        if (this.eventCase_ != 16 || this.event_ == ConfigsOuterClass$UpdateHashEndpointChanged.getDefaultInstance()) {
            this.event_ = configsOuterClass$UpdateHashEndpointChanged;
        } else {
            this.event_ = ((ConfigsOuterClass$UpdateHashEndpointChanged.a) ConfigsOuterClass$UpdateHashEndpointChanged.newBuilder((ConfigsOuterClass$UpdateHashEndpointChanged) this.event_).v(configsOuterClass$UpdateHashEndpointChanged)).j();
        }
        this.eventCase_ = 16;
    }

    private void mergeMessageReaction(AbacusOuterClass$UpdateMessageReactions abacusOuterClass$UpdateMessageReactions) {
        abacusOuterClass$UpdateMessageReactions.getClass();
        if (this.eventCase_ != 9 || this.event_ == AbacusOuterClass$UpdateMessageReactions.getDefaultInstance()) {
            this.event_ = abacusOuterClass$UpdateMessageReactions;
        } else {
            this.event_ = ((AbacusOuterClass$UpdateMessageReactions.a) AbacusOuterClass$UpdateMessageReactions.newBuilder((AbacusOuterClass$UpdateMessageReactions) this.event_).v(abacusOuterClass$UpdateMessageReactions)).j();
        }
        this.eventCase_ = 9;
    }

    private void mergeThreadDeleteMessage(MessagingOuterClass$UpdateMessageDelete messagingOuterClass$UpdateMessageDelete) {
        messagingOuterClass$UpdateMessageDelete.getClass();
        if (this.eventCase_ != 12 || this.event_ == MessagingOuterClass$UpdateMessageDelete.getDefaultInstance()) {
            this.event_ = messagingOuterClass$UpdateMessageDelete;
        } else {
            this.event_ = ((MessagingOuterClass$UpdateMessageDelete.a) MessagingOuterClass$UpdateMessageDelete.newBuilder((MessagingOuterClass$UpdateMessageDelete) this.event_).v(messagingOuterClass$UpdateMessageDelete)).j();
        }
        this.eventCase_ = 12;
    }

    private void mergeThreadEditMessage(MessagingOuterClass$UpdateMessageContentChanged messagingOuterClass$UpdateMessageContentChanged) {
        messagingOuterClass$UpdateMessageContentChanged.getClass();
        if (this.eventCase_ != 11 || this.event_ == MessagingOuterClass$UpdateMessageContentChanged.getDefaultInstance()) {
            this.event_ = messagingOuterClass$UpdateMessageContentChanged;
        } else {
            this.event_ = ((MessagingOuterClass$UpdateMessageContentChanged.a) MessagingOuterClass$UpdateMessageContentChanged.newBuilder((MessagingOuterClass$UpdateMessageContentChanged) this.event_).v(messagingOuterClass$UpdateMessageContentChanged)).j();
        }
        this.eventCase_ = 11;
    }

    private void mergeThreadMessage(MessagingOuterClass$UpdateMessage messagingOuterClass$UpdateMessage) {
        messagingOuterClass$UpdateMessage.getClass();
        if (this.eventCase_ != 10 || this.event_ == MessagingOuterClass$UpdateMessage.getDefaultInstance()) {
            this.event_ = messagingOuterClass$UpdateMessage;
        } else {
            this.event_ = ((MessagingOuterClass$UpdateMessage.a) MessagingOuterClass$UpdateMessage.newBuilder((MessagingOuterClass$UpdateMessage) this.event_).v(messagingOuterClass$UpdateMessage)).j();
        }
        this.eventCase_ = 10;
    }

    private void mergeTyping(PresenceOuterClass$UpdateTyping presenceOuterClass$UpdateTyping) {
        presenceOuterClass$UpdateTyping.getClass();
        if (this.eventCase_ != 1 || this.event_ == PresenceOuterClass$UpdateTyping.getDefaultInstance()) {
            this.event_ = presenceOuterClass$UpdateTyping;
        } else {
            this.event_ = ((PresenceOuterClass$UpdateTyping.a) PresenceOuterClass$UpdateTyping.newBuilder((PresenceOuterClass$UpdateTyping) this.event_).v(presenceOuterClass$UpdateTyping)).j();
        }
        this.eventCase_ = 1;
    }

    private void mergeTypingStop(PresenceOuterClass$UpdateTypingStop presenceOuterClass$UpdateTypingStop) {
        presenceOuterClass$UpdateTypingStop.getClass();
        if (this.eventCase_ != 2 || this.event_ == PresenceOuterClass$UpdateTypingStop.getDefaultInstance()) {
            this.event_ = presenceOuterClass$UpdateTypingStop;
        } else {
            this.event_ = ((PresenceOuterClass$UpdateTypingStop.a) PresenceOuterClass$UpdateTypingStop.newBuilder((PresenceOuterClass$UpdateTypingStop) this.event_).v(presenceOuterClass$UpdateTypingStop)).j();
        }
        this.eventCase_ = 2;
    }

    private void mergeUserLastSeen(PresenceOuterClass$UpdateUserLastSeen presenceOuterClass$UpdateUserLastSeen) {
        presenceOuterClass$UpdateUserLastSeen.getClass();
        if (this.eventCase_ != 6 || this.event_ == PresenceOuterClass$UpdateUserLastSeen.getDefaultInstance()) {
            this.event_ = presenceOuterClass$UpdateUserLastSeen;
        } else {
            this.event_ = ((PresenceOuterClass$UpdateUserLastSeen.a) PresenceOuterClass$UpdateUserLastSeen.newBuilder((PresenceOuterClass$UpdateUserLastSeen) this.event_).v(presenceOuterClass$UpdateUserLastSeen)).j();
        }
        this.eventCase_ = 6;
    }

    private void mergeUserLastSeenUnknown(PresenceOuterClass$UpdateUserLastSeenUnknown presenceOuterClass$UpdateUserLastSeenUnknown) {
        presenceOuterClass$UpdateUserLastSeenUnknown.getClass();
        if (this.eventCase_ != 5 || this.event_ == PresenceOuterClass$UpdateUserLastSeenUnknown.getDefaultInstance()) {
            this.event_ = presenceOuterClass$UpdateUserLastSeenUnknown;
        } else {
            this.event_ = ((PresenceOuterClass$UpdateUserLastSeenUnknown.a) PresenceOuterClass$UpdateUserLastSeenUnknown.newBuilder((PresenceOuterClass$UpdateUserLastSeenUnknown) this.event_).v(presenceOuterClass$UpdateUserLastSeenUnknown)).j();
        }
        this.eventCase_ = 5;
    }

    private void mergeUserOffline(PresenceOuterClass$UpdateUserOffline presenceOuterClass$UpdateUserOffline) {
        presenceOuterClass$UpdateUserOffline.getClass();
        if (this.eventCase_ != 4 || this.event_ == PresenceOuterClass$UpdateUserOffline.getDefaultInstance()) {
            this.event_ = presenceOuterClass$UpdateUserOffline;
        } else {
            this.event_ = ((PresenceOuterClass$UpdateUserOffline.a) PresenceOuterClass$UpdateUserOffline.newBuilder((PresenceOuterClass$UpdateUserOffline) this.event_).v(presenceOuterClass$UpdateUserOffline)).j();
        }
        this.eventCase_ = 4;
    }

    private void mergeUserOnline(PresenceOuterClass$UpdateUserOnline presenceOuterClass$UpdateUserOnline) {
        presenceOuterClass$UpdateUserOnline.getClass();
        if (this.eventCase_ != 3 || this.event_ == PresenceOuterClass$UpdateUserOnline.getDefaultInstance()) {
            this.event_ = presenceOuterClass$UpdateUserOnline;
        } else {
            this.event_ = ((PresenceOuterClass$UpdateUserOnline.a) PresenceOuterClass$UpdateUserOnline.newBuilder((PresenceOuterClass$UpdateUserOnline) this.event_).v(presenceOuterClass$UpdateUserOnline)).j();
        }
        this.eventCase_ = 3;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MavizStreamOuterClass$WeakEvent parseDelimitedFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$WeakEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$WeakEvent parseFrom(ByteBuffer byteBuffer) {
        return (MavizStreamOuterClass$WeakEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAskBotReview(TimcheOuterClass$UpdateAskBotReview timcheOuterClass$UpdateAskBotReview) {
        timcheOuterClass$UpdateAskBotReview.getClass();
        this.event_ = timcheOuterClass$UpdateAskBotReview;
        this.eventCase_ = 14;
    }

    private void setCallAction(MeetOuterClass$UpdateCallAction meetOuterClass$UpdateCallAction) {
        meetOuterClass$UpdateCallAction.getClass();
        this.event_ = meetOuterClass$UpdateCallAction;
        this.eventCase_ = 13;
    }

    private void setCallReactionSent(MeetOuterClass$UpdateCallReactionSent meetOuterClass$UpdateCallReactionSent) {
        meetOuterClass$UpdateCallReactionSent.getClass();
        this.event_ = meetOuterClass$UpdateCallReactionSent;
        this.eventCase_ = 8;
    }

    private void setEndpointChanged(ConfigsOuterClass$UpdateEndpointChanged configsOuterClass$UpdateEndpointChanged) {
        configsOuterClass$UpdateEndpointChanged.getClass();
        this.event_ = configsOuterClass$UpdateEndpointChanged;
        this.eventCase_ = 15;
    }

    private void setGroupOnline(PresenceOuterClass$UpdateGroupOnline presenceOuterClass$UpdateGroupOnline) {
        presenceOuterClass$UpdateGroupOnline.getClass();
        this.event_ = presenceOuterClass$UpdateGroupOnline;
        this.eventCase_ = 7;
    }

    private void setHashEndpointChanged(ConfigsOuterClass$UpdateHashEndpointChanged configsOuterClass$UpdateHashEndpointChanged) {
        configsOuterClass$UpdateHashEndpointChanged.getClass();
        this.event_ = configsOuterClass$UpdateHashEndpointChanged;
        this.eventCase_ = 16;
    }

    private void setMessageReaction(AbacusOuterClass$UpdateMessageReactions abacusOuterClass$UpdateMessageReactions) {
        abacusOuterClass$UpdateMessageReactions.getClass();
        this.event_ = abacusOuterClass$UpdateMessageReactions;
        this.eventCase_ = 9;
    }

    private void setThreadDeleteMessage(MessagingOuterClass$UpdateMessageDelete messagingOuterClass$UpdateMessageDelete) {
        messagingOuterClass$UpdateMessageDelete.getClass();
        this.event_ = messagingOuterClass$UpdateMessageDelete;
        this.eventCase_ = 12;
    }

    private void setThreadEditMessage(MessagingOuterClass$UpdateMessageContentChanged messagingOuterClass$UpdateMessageContentChanged) {
        messagingOuterClass$UpdateMessageContentChanged.getClass();
        this.event_ = messagingOuterClass$UpdateMessageContentChanged;
        this.eventCase_ = 11;
    }

    private void setThreadMessage(MessagingOuterClass$UpdateMessage messagingOuterClass$UpdateMessage) {
        messagingOuterClass$UpdateMessage.getClass();
        this.event_ = messagingOuterClass$UpdateMessage;
        this.eventCase_ = 10;
    }

    private void setTyping(PresenceOuterClass$UpdateTyping presenceOuterClass$UpdateTyping) {
        presenceOuterClass$UpdateTyping.getClass();
        this.event_ = presenceOuterClass$UpdateTyping;
        this.eventCase_ = 1;
    }

    private void setTypingStop(PresenceOuterClass$UpdateTypingStop presenceOuterClass$UpdateTypingStop) {
        presenceOuterClass$UpdateTypingStop.getClass();
        this.event_ = presenceOuterClass$UpdateTypingStop;
        this.eventCase_ = 2;
    }

    private void setUserLastSeen(PresenceOuterClass$UpdateUserLastSeen presenceOuterClass$UpdateUserLastSeen) {
        presenceOuterClass$UpdateUserLastSeen.getClass();
        this.event_ = presenceOuterClass$UpdateUserLastSeen;
        this.eventCase_ = 6;
    }

    private void setUserLastSeenUnknown(PresenceOuterClass$UpdateUserLastSeenUnknown presenceOuterClass$UpdateUserLastSeenUnknown) {
        presenceOuterClass$UpdateUserLastSeenUnknown.getClass();
        this.event_ = presenceOuterClass$UpdateUserLastSeenUnknown;
        this.eventCase_ = 5;
    }

    private void setUserOffline(PresenceOuterClass$UpdateUserOffline presenceOuterClass$UpdateUserOffline) {
        presenceOuterClass$UpdateUserOffline.getClass();
        this.event_ = presenceOuterClass$UpdateUserOffline;
        this.eventCase_ = 4;
    }

    private void setUserOnline(PresenceOuterClass$UpdateUserOnline presenceOuterClass$UpdateUserOnline) {
        presenceOuterClass$UpdateUserOnline.getClass();
        this.event_ = presenceOuterClass$UpdateUserOnline;
        this.eventCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (E0.a[gVar.ordinal()]) {
            case 1:
                return new MavizStreamOuterClass$WeakEvent();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0010\u0001\u0000\u0001\u0010\u0010\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b<\u0000\f<\u0000\r<\u0000\u000e<\u0000\u000f<\u0000\u0010<\u0000", new Object[]{"event_", "eventCase_", PresenceOuterClass$UpdateTyping.class, PresenceOuterClass$UpdateTypingStop.class, PresenceOuterClass$UpdateUserOnline.class, PresenceOuterClass$UpdateUserOffline.class, PresenceOuterClass$UpdateUserLastSeenUnknown.class, PresenceOuterClass$UpdateUserLastSeen.class, PresenceOuterClass$UpdateGroupOnline.class, MeetOuterClass$UpdateCallReactionSent.class, AbacusOuterClass$UpdateMessageReactions.class, MessagingOuterClass$UpdateMessage.class, MessagingOuterClass$UpdateMessageContentChanged.class, MessagingOuterClass$UpdateMessageDelete.class, MeetOuterClass$UpdateCallAction.class, TimcheOuterClass$UpdateAskBotReview.class, ConfigsOuterClass$UpdateEndpointChanged.class, ConfigsOuterClass$UpdateHashEndpointChanged.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MavizStreamOuterClass$WeakEvent.class) {
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

    public TimcheOuterClass$UpdateAskBotReview getAskBotReview() {
        return this.eventCase_ == 14 ? (TimcheOuterClass$UpdateAskBotReview) this.event_ : TimcheOuterClass$UpdateAskBotReview.getDefaultInstance();
    }

    public MeetOuterClass$UpdateCallAction getCallAction() {
        return this.eventCase_ == 13 ? (MeetOuterClass$UpdateCallAction) this.event_ : MeetOuterClass$UpdateCallAction.getDefaultInstance();
    }

    public MeetOuterClass$UpdateCallReactionSent getCallReactionSent() {
        return this.eventCase_ == 8 ? (MeetOuterClass$UpdateCallReactionSent) this.event_ : MeetOuterClass$UpdateCallReactionSent.getDefaultInstance();
    }

    public ConfigsOuterClass$UpdateEndpointChanged getEndpointChanged() {
        return this.eventCase_ == 15 ? (ConfigsOuterClass$UpdateEndpointChanged) this.event_ : ConfigsOuterClass$UpdateEndpointChanged.getDefaultInstance();
    }

    public b getEventCase() {
        return b.j(this.eventCase_);
    }

    public PresenceOuterClass$UpdateGroupOnline getGroupOnline() {
        return this.eventCase_ == 7 ? (PresenceOuterClass$UpdateGroupOnline) this.event_ : PresenceOuterClass$UpdateGroupOnline.getDefaultInstance();
    }

    public ConfigsOuterClass$UpdateHashEndpointChanged getHashEndpointChanged() {
        return this.eventCase_ == 16 ? (ConfigsOuterClass$UpdateHashEndpointChanged) this.event_ : ConfigsOuterClass$UpdateHashEndpointChanged.getDefaultInstance();
    }

    public AbacusOuterClass$UpdateMessageReactions getMessageReaction() {
        return this.eventCase_ == 9 ? (AbacusOuterClass$UpdateMessageReactions) this.event_ : AbacusOuterClass$UpdateMessageReactions.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateMessageDelete getThreadDeleteMessage() {
        return this.eventCase_ == 12 ? (MessagingOuterClass$UpdateMessageDelete) this.event_ : MessagingOuterClass$UpdateMessageDelete.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateMessageContentChanged getThreadEditMessage() {
        return this.eventCase_ == 11 ? (MessagingOuterClass$UpdateMessageContentChanged) this.event_ : MessagingOuterClass$UpdateMessageContentChanged.getDefaultInstance();
    }

    public MessagingOuterClass$UpdateMessage getThreadMessage() {
        return this.eventCase_ == 10 ? (MessagingOuterClass$UpdateMessage) this.event_ : MessagingOuterClass$UpdateMessage.getDefaultInstance();
    }

    public PresenceOuterClass$UpdateTyping getTyping() {
        return this.eventCase_ == 1 ? (PresenceOuterClass$UpdateTyping) this.event_ : PresenceOuterClass$UpdateTyping.getDefaultInstance();
    }

    public PresenceOuterClass$UpdateTypingStop getTypingStop() {
        return this.eventCase_ == 2 ? (PresenceOuterClass$UpdateTypingStop) this.event_ : PresenceOuterClass$UpdateTypingStop.getDefaultInstance();
    }

    public PresenceOuterClass$UpdateUserLastSeen getUserLastSeen() {
        return this.eventCase_ == 6 ? (PresenceOuterClass$UpdateUserLastSeen) this.event_ : PresenceOuterClass$UpdateUserLastSeen.getDefaultInstance();
    }

    public PresenceOuterClass$UpdateUserLastSeenUnknown getUserLastSeenUnknown() {
        return this.eventCase_ == 5 ? (PresenceOuterClass$UpdateUserLastSeenUnknown) this.event_ : PresenceOuterClass$UpdateUserLastSeenUnknown.getDefaultInstance();
    }

    public PresenceOuterClass$UpdateUserOffline getUserOffline() {
        return this.eventCase_ == 4 ? (PresenceOuterClass$UpdateUserOffline) this.event_ : PresenceOuterClass$UpdateUserOffline.getDefaultInstance();
    }

    public PresenceOuterClass$UpdateUserOnline getUserOnline() {
        return this.eventCase_ == 3 ? (PresenceOuterClass$UpdateUserOnline) this.event_ : PresenceOuterClass$UpdateUserOnline.getDefaultInstance();
    }

    public boolean hasAskBotReview() {
        return this.eventCase_ == 14;
    }

    public boolean hasCallAction() {
        return this.eventCase_ == 13;
    }

    public boolean hasCallReactionSent() {
        return this.eventCase_ == 8;
    }

    public boolean hasEndpointChanged() {
        return this.eventCase_ == 15;
    }

    public boolean hasGroupOnline() {
        return this.eventCase_ == 7;
    }

    public boolean hasHashEndpointChanged() {
        return this.eventCase_ == 16;
    }

    public boolean hasMessageReaction() {
        return this.eventCase_ == 9;
    }

    public boolean hasThreadDeleteMessage() {
        return this.eventCase_ == 12;
    }

    public boolean hasThreadEditMessage() {
        return this.eventCase_ == 11;
    }

    public boolean hasThreadMessage() {
        return this.eventCase_ == 10;
    }

    public boolean hasTyping() {
        return this.eventCase_ == 1;
    }

    public boolean hasTypingStop() {
        return this.eventCase_ == 2;
    }

    public boolean hasUserLastSeen() {
        return this.eventCase_ == 6;
    }

    public boolean hasUserLastSeenUnknown() {
        return this.eventCase_ == 5;
    }

    public boolean hasUserOffline() {
        return this.eventCase_ == 4;
    }

    public boolean hasUserOnline() {
        return this.eventCase_ == 3;
    }

    public static a newBuilder(MavizStreamOuterClass$WeakEvent mavizStreamOuterClass$WeakEvent) {
        return (a) DEFAULT_INSTANCE.createBuilder(mavizStreamOuterClass$WeakEvent);
    }

    public static MavizStreamOuterClass$WeakEvent parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$WeakEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$WeakEvent parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MavizStreamOuterClass$WeakEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MavizStreamOuterClass$WeakEvent parseFrom(AbstractC2383g abstractC2383g) {
        return (MavizStreamOuterClass$WeakEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MavizStreamOuterClass$WeakEvent parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MavizStreamOuterClass$WeakEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MavizStreamOuterClass$WeakEvent parseFrom(byte[] bArr) {
        return (MavizStreamOuterClass$WeakEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MavizStreamOuterClass$WeakEvent parseFrom(byte[] bArr, C2394s c2394s) {
        return (MavizStreamOuterClass$WeakEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MavizStreamOuterClass$WeakEvent parseFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$WeakEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$WeakEvent parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$WeakEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$WeakEvent parseFrom(AbstractC2384h abstractC2384h) {
        return (MavizStreamOuterClass$WeakEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MavizStreamOuterClass$WeakEvent parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MavizStreamOuterClass$WeakEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

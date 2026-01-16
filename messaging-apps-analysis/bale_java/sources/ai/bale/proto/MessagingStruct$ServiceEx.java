package ai.bale.proto;

import ai.bale.proto.MessagingStruct$ServiceExAnonymousContact;
import ai.bale.proto.MessagingStruct$ServiceExBecameOrphaned;
import ai.bale.proto.MessagingStruct$ServiceExCallRecordStateChanged;
import ai.bale.proto.MessagingStruct$ServiceExChangedAbout;
import ai.bale.proto.MessagingStruct$ServiceExChangedAvatar;
import ai.bale.proto.MessagingStruct$ServiceExChangedNick;
import ai.bale.proto.MessagingStruct$ServiceExChangedTitle;
import ai.bale.proto.MessagingStruct$ServiceExChangedTopic;
import ai.bale.proto.MessagingStruct$ServiceExChatArchived;
import ai.bale.proto.MessagingStruct$ServiceExChatRestored;
import ai.bale.proto.MessagingStruct$ServiceExContactRegistered;
import ai.bale.proto.MessagingStruct$ServiceExGiftPacketOpened;
import ai.bale.proto.MessagingStruct$ServiceExGiftPacketOpenedCompact;
import ai.bale.proto.MessagingStruct$ServiceExGroupCallEnded;
import ai.bale.proto.MessagingStruct$ServiceExGroupCallStarted;
import ai.bale.proto.MessagingStruct$ServiceExGroupCreated;
import ai.bale.proto.MessagingStruct$ServiceExMiniAppDataSent;
import ai.bale.proto.MessagingStruct$ServiceExNewUserWelcome;
import ai.bale.proto.MessagingStruct$ServiceExPassportDataSent;
import ai.bale.proto.MessagingStruct$ServiceExPhoneCall;
import ai.bale.proto.MessagingStruct$ServiceExPhoneMissed;
import ai.bale.proto.MessagingStruct$ServiceExUserInvited;
import ai.bale.proto.MessagingStruct$ServiceExUserJoined;
import ai.bale.proto.MessagingStruct$ServiceExUserKicked;
import ai.bale.proto.MessagingStruct$ServiceExUserLeft;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$ServiceEx extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$ServiceEx DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SERVICE_EX_ANONYMOUS_CONTACT_FIELD_NUMBER = 24;
    public static final int SERVICE_EX_BECAME_ORPHANED_FIELD_NUMBER = 1;
    public static final int SERVICE_EX_CALL_RECORD_STATE_CHANGED_FIELD_NUMBER = 22;
    public static final int SERVICE_EX_CHANGED_ABOUT_FIELD_NUMBER = 2;
    public static final int SERVICE_EX_CHANGED_AVATAR_FIELD_NUMBER = 3;
    public static final int SERVICE_EX_CHANGED_NICK_FIELD_NUMBER = 4;
    public static final int SERVICE_EX_CHANGED_TITLE_FIELD_NUMBER = 5;
    public static final int SERVICE_EX_CHANGED_TOPIC_FIELD_NUMBER = 6;
    public static final int SERVICE_EX_CHAT_ARCHIVED_FIELD_NUMBER = 7;
    public static final int SERVICE_EX_CHAT_RESTORED_FIELD_NUMBER = 8;
    public static final int SERVICE_EX_CONTACT_REGISTERED_FIELD_NUMBER = 9;
    public static final int SERVICE_EX_GIFT_PACKET_OPENED_COMPACT_FIELD_NUMBER = 18;
    public static final int SERVICE_EX_GIFT_PACKET_OPENED_FIELD_NUMBER = 17;
    public static final int SERVICE_EX_GROUP_CALL_ENDED_FIELD_NUMBER = 21;
    public static final int SERVICE_EX_GROUP_CALL_STARTED_FIELD_NUMBER = 20;
    public static final int SERVICE_EX_GROUP_CREATED_FIELD_NUMBER = 10;
    public static final int SERVICE_EX_MINI_APP_DATA_SENT_FIELD_NUMBER = 23;
    public static final int SERVICE_EX_NEW_USER_WELCOME_FIELD_NUMBER = 19;
    public static final int SERVICE_EX_PASSPORT_DATA_SENT_FIELD_NUMBER = 25;
    public static final int SERVICE_EX_PHONE_CALL_FIELD_NUMBER = 11;
    public static final int SERVICE_EX_PHONE_MISSED_FIELD_NUMBER = 12;
    public static final int SERVICE_EX_USER_INVITED_FIELD_NUMBER = 13;
    public static final int SERVICE_EX_USER_JOINED_FIELD_NUMBER = 14;
    public static final int SERVICE_EX_USER_KICKED_FIELD_NUMBER = 15;
    public static final int SERVICE_EX_USER_LEFT_FIELD_NUMBER = 16;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ServiceEx.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        SERVICE_EX_BECAME_ORPHANED(1),
        SERVICE_EX_CHANGED_ABOUT(2),
        SERVICE_EX_CHANGED_AVATAR(3),
        SERVICE_EX_CHANGED_NICK(4),
        SERVICE_EX_CHANGED_TITLE(5),
        SERVICE_EX_CHANGED_TOPIC(6),
        SERVICE_EX_CHAT_ARCHIVED(7),
        SERVICE_EX_CHAT_RESTORED(8),
        SERVICE_EX_CONTACT_REGISTERED(9),
        SERVICE_EX_GROUP_CREATED(10),
        SERVICE_EX_PHONE_CALL(11),
        SERVICE_EX_PHONE_MISSED(12),
        SERVICE_EX_USER_INVITED(13),
        SERVICE_EX_USER_JOINED(14),
        SERVICE_EX_USER_KICKED(15),
        SERVICE_EX_USER_LEFT(16),
        SERVICE_EX_GIFT_PACKET_OPENED(17),
        SERVICE_EX_GIFT_PACKET_OPENED_COMPACT(18),
        SERVICE_EX_NEW_USER_WELCOME(19),
        SERVICE_EX_GROUP_CALL_STARTED(20),
        SERVICE_EX_GROUP_CALL_ENDED(21),
        SERVICE_EX_CALL_RECORD_STATE_CHANGED(22),
        SERVICE_EX_MINI_APP_DATA_SENT(23),
        SERVICE_EX_ANONYMOUS_CONTACT(24),
        SERVICE_EX_PASSPORT_DATA_SENT(25),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            switch (i) {
                case 0:
                    return TRAIT_NOT_SET;
                case 1:
                    return SERVICE_EX_BECAME_ORPHANED;
                case 2:
                    return SERVICE_EX_CHANGED_ABOUT;
                case 3:
                    return SERVICE_EX_CHANGED_AVATAR;
                case 4:
                    return SERVICE_EX_CHANGED_NICK;
                case 5:
                    return SERVICE_EX_CHANGED_TITLE;
                case 6:
                    return SERVICE_EX_CHANGED_TOPIC;
                case 7:
                    return SERVICE_EX_CHAT_ARCHIVED;
                case 8:
                    return SERVICE_EX_CHAT_RESTORED;
                case 9:
                    return SERVICE_EX_CONTACT_REGISTERED;
                case 10:
                    return SERVICE_EX_GROUP_CREATED;
                case 11:
                    return SERVICE_EX_PHONE_CALL;
                case 12:
                    return SERVICE_EX_PHONE_MISSED;
                case 13:
                    return SERVICE_EX_USER_INVITED;
                case 14:
                    return SERVICE_EX_USER_JOINED;
                case 15:
                    return SERVICE_EX_USER_KICKED;
                case 16:
                    return SERVICE_EX_USER_LEFT;
                case 17:
                    return SERVICE_EX_GIFT_PACKET_OPENED;
                case 18:
                    return SERVICE_EX_GIFT_PACKET_OPENED_COMPACT;
                case 19:
                    return SERVICE_EX_NEW_USER_WELCOME;
                case 20:
                    return SERVICE_EX_GROUP_CALL_STARTED;
                case 21:
                    return SERVICE_EX_GROUP_CALL_ENDED;
                case 22:
                    return SERVICE_EX_CALL_RECORD_STATE_CHANGED;
                case 23:
                    return SERVICE_EX_MINI_APP_DATA_SENT;
                case 24:
                    return SERVICE_EX_ANONYMOUS_CONTACT;
                case 25:
                    return SERVICE_EX_PASSPORT_DATA_SENT;
                default:
                    return null;
            }
        }
    }

    static {
        MessagingStruct$ServiceEx messagingStruct$ServiceEx = new MessagingStruct$ServiceEx();
        DEFAULT_INSTANCE = messagingStruct$ServiceEx;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ServiceEx.class, messagingStruct$ServiceEx);
    }

    private MessagingStruct$ServiceEx() {
    }

    private void clearServiceExAnonymousContact() {
        if (this.traitCase_ == 24) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExBecameOrphaned() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExCallRecordStateChanged() {
        if (this.traitCase_ == 22) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExChangedAbout() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExChangedAvatar() {
        if (this.traitCase_ == 3) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExChangedNick() {
        if (this.traitCase_ == 4) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExChangedTitle() {
        if (this.traitCase_ == 5) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExChangedTopic() {
        if (this.traitCase_ == 6) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExChatArchived() {
        if (this.traitCase_ == 7) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExChatRestored() {
        if (this.traitCase_ == 8) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExContactRegistered() {
        if (this.traitCase_ == 9) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExGiftPacketOpened() {
        if (this.traitCase_ == 17) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExGiftPacketOpenedCompact() {
        if (this.traitCase_ == 18) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExGroupCallEnded() {
        if (this.traitCase_ == 21) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExGroupCallStarted() {
        if (this.traitCase_ == 20) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExGroupCreated() {
        if (this.traitCase_ == 10) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExMiniAppDataSent() {
        if (this.traitCase_ == 23) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExNewUserWelcome() {
        if (this.traitCase_ == 19) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExPassportDataSent() {
        if (this.traitCase_ == 25) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExPhoneCall() {
        if (this.traitCase_ == 11) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExPhoneMissed() {
        if (this.traitCase_ == 12) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExUserInvited() {
        if (this.traitCase_ == 13) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExUserJoined() {
        if (this.traitCase_ == 14) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExUserKicked() {
        if (this.traitCase_ == 15) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceExUserLeft() {
        if (this.traitCase_ == 16) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static MessagingStruct$ServiceEx getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeServiceExAnonymousContact(MessagingStruct$ServiceExAnonymousContact messagingStruct$ServiceExAnonymousContact) {
        messagingStruct$ServiceExAnonymousContact.getClass();
        if (this.traitCase_ != 24 || this.trait_ == MessagingStruct$ServiceExAnonymousContact.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExAnonymousContact;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExAnonymousContact.a) MessagingStruct$ServiceExAnonymousContact.newBuilder((MessagingStruct$ServiceExAnonymousContact) this.trait_).v(messagingStruct$ServiceExAnonymousContact)).j();
        }
        this.traitCase_ = 24;
    }

    private void mergeServiceExBecameOrphaned(MessagingStruct$ServiceExBecameOrphaned messagingStruct$ServiceExBecameOrphaned) {
        messagingStruct$ServiceExBecameOrphaned.getClass();
        if (this.traitCase_ != 1 || this.trait_ == MessagingStruct$ServiceExBecameOrphaned.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExBecameOrphaned;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExBecameOrphaned.a) MessagingStruct$ServiceExBecameOrphaned.newBuilder((MessagingStruct$ServiceExBecameOrphaned) this.trait_).v(messagingStruct$ServiceExBecameOrphaned)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergeServiceExCallRecordStateChanged(MessagingStruct$ServiceExCallRecordStateChanged messagingStruct$ServiceExCallRecordStateChanged) {
        messagingStruct$ServiceExCallRecordStateChanged.getClass();
        if (this.traitCase_ != 22 || this.trait_ == MessagingStruct$ServiceExCallRecordStateChanged.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExCallRecordStateChanged;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExCallRecordStateChanged.a) MessagingStruct$ServiceExCallRecordStateChanged.newBuilder((MessagingStruct$ServiceExCallRecordStateChanged) this.trait_).v(messagingStruct$ServiceExCallRecordStateChanged)).j();
        }
        this.traitCase_ = 22;
    }

    private void mergeServiceExChangedAbout(MessagingStruct$ServiceExChangedAbout messagingStruct$ServiceExChangedAbout) {
        messagingStruct$ServiceExChangedAbout.getClass();
        if (this.traitCase_ != 2 || this.trait_ == MessagingStruct$ServiceExChangedAbout.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExChangedAbout;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExChangedAbout.a) MessagingStruct$ServiceExChangedAbout.newBuilder((MessagingStruct$ServiceExChangedAbout) this.trait_).v(messagingStruct$ServiceExChangedAbout)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergeServiceExChangedAvatar(MessagingStruct$ServiceExChangedAvatar messagingStruct$ServiceExChangedAvatar) {
        messagingStruct$ServiceExChangedAvatar.getClass();
        if (this.traitCase_ != 3 || this.trait_ == MessagingStruct$ServiceExChangedAvatar.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExChangedAvatar;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExChangedAvatar.a) MessagingStruct$ServiceExChangedAvatar.newBuilder((MessagingStruct$ServiceExChangedAvatar) this.trait_).v(messagingStruct$ServiceExChangedAvatar)).j();
        }
        this.traitCase_ = 3;
    }

    private void mergeServiceExChangedNick(MessagingStruct$ServiceExChangedNick messagingStruct$ServiceExChangedNick) {
        messagingStruct$ServiceExChangedNick.getClass();
        if (this.traitCase_ != 4 || this.trait_ == MessagingStruct$ServiceExChangedNick.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExChangedNick;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExChangedNick.a) MessagingStruct$ServiceExChangedNick.newBuilder((MessagingStruct$ServiceExChangedNick) this.trait_).v(messagingStruct$ServiceExChangedNick)).j();
        }
        this.traitCase_ = 4;
    }

    private void mergeServiceExChangedTitle(MessagingStruct$ServiceExChangedTitle messagingStruct$ServiceExChangedTitle) {
        messagingStruct$ServiceExChangedTitle.getClass();
        if (this.traitCase_ != 5 || this.trait_ == MessagingStruct$ServiceExChangedTitle.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExChangedTitle;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExChangedTitle.a) MessagingStruct$ServiceExChangedTitle.newBuilder((MessagingStruct$ServiceExChangedTitle) this.trait_).v(messagingStruct$ServiceExChangedTitle)).j();
        }
        this.traitCase_ = 5;
    }

    private void mergeServiceExChangedTopic(MessagingStruct$ServiceExChangedTopic messagingStruct$ServiceExChangedTopic) {
        messagingStruct$ServiceExChangedTopic.getClass();
        if (this.traitCase_ != 6 || this.trait_ == MessagingStruct$ServiceExChangedTopic.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExChangedTopic;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExChangedTopic.a) MessagingStruct$ServiceExChangedTopic.newBuilder((MessagingStruct$ServiceExChangedTopic) this.trait_).v(messagingStruct$ServiceExChangedTopic)).j();
        }
        this.traitCase_ = 6;
    }

    private void mergeServiceExChatArchived(MessagingStruct$ServiceExChatArchived messagingStruct$ServiceExChatArchived) {
        messagingStruct$ServiceExChatArchived.getClass();
        if (this.traitCase_ != 7 || this.trait_ == MessagingStruct$ServiceExChatArchived.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExChatArchived;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExChatArchived.a) MessagingStruct$ServiceExChatArchived.newBuilder((MessagingStruct$ServiceExChatArchived) this.trait_).v(messagingStruct$ServiceExChatArchived)).j();
        }
        this.traitCase_ = 7;
    }

    private void mergeServiceExChatRestored(MessagingStruct$ServiceExChatRestored messagingStruct$ServiceExChatRestored) {
        messagingStruct$ServiceExChatRestored.getClass();
        if (this.traitCase_ != 8 || this.trait_ == MessagingStruct$ServiceExChatRestored.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExChatRestored;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExChatRestored.a) MessagingStruct$ServiceExChatRestored.newBuilder((MessagingStruct$ServiceExChatRestored) this.trait_).v(messagingStruct$ServiceExChatRestored)).j();
        }
        this.traitCase_ = 8;
    }

    private void mergeServiceExContactRegistered(MessagingStruct$ServiceExContactRegistered messagingStruct$ServiceExContactRegistered) {
        messagingStruct$ServiceExContactRegistered.getClass();
        if (this.traitCase_ != 9 || this.trait_ == MessagingStruct$ServiceExContactRegistered.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExContactRegistered;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExContactRegistered.a) MessagingStruct$ServiceExContactRegistered.newBuilder((MessagingStruct$ServiceExContactRegistered) this.trait_).v(messagingStruct$ServiceExContactRegistered)).j();
        }
        this.traitCase_ = 9;
    }

    private void mergeServiceExGiftPacketOpened(MessagingStruct$ServiceExGiftPacketOpened messagingStruct$ServiceExGiftPacketOpened) {
        messagingStruct$ServiceExGiftPacketOpened.getClass();
        if (this.traitCase_ != 17 || this.trait_ == MessagingStruct$ServiceExGiftPacketOpened.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExGiftPacketOpened;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExGiftPacketOpened.a) MessagingStruct$ServiceExGiftPacketOpened.newBuilder((MessagingStruct$ServiceExGiftPacketOpened) this.trait_).v(messagingStruct$ServiceExGiftPacketOpened)).j();
        }
        this.traitCase_ = 17;
    }

    private void mergeServiceExGiftPacketOpenedCompact(MessagingStruct$ServiceExGiftPacketOpenedCompact messagingStruct$ServiceExGiftPacketOpenedCompact) {
        messagingStruct$ServiceExGiftPacketOpenedCompact.getClass();
        if (this.traitCase_ != 18 || this.trait_ == MessagingStruct$ServiceExGiftPacketOpenedCompact.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExGiftPacketOpenedCompact;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExGiftPacketOpenedCompact.a) MessagingStruct$ServiceExGiftPacketOpenedCompact.newBuilder((MessagingStruct$ServiceExGiftPacketOpenedCompact) this.trait_).v(messagingStruct$ServiceExGiftPacketOpenedCompact)).j();
        }
        this.traitCase_ = 18;
    }

    private void mergeServiceExGroupCallEnded(MessagingStruct$ServiceExGroupCallEnded messagingStruct$ServiceExGroupCallEnded) {
        messagingStruct$ServiceExGroupCallEnded.getClass();
        if (this.traitCase_ != 21 || this.trait_ == MessagingStruct$ServiceExGroupCallEnded.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExGroupCallEnded;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExGroupCallEnded.a) MessagingStruct$ServiceExGroupCallEnded.newBuilder((MessagingStruct$ServiceExGroupCallEnded) this.trait_).v(messagingStruct$ServiceExGroupCallEnded)).j();
        }
        this.traitCase_ = 21;
    }

    private void mergeServiceExGroupCallStarted(MessagingStruct$ServiceExGroupCallStarted messagingStruct$ServiceExGroupCallStarted) {
        messagingStruct$ServiceExGroupCallStarted.getClass();
        if (this.traitCase_ != 20 || this.trait_ == MessagingStruct$ServiceExGroupCallStarted.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExGroupCallStarted;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExGroupCallStarted.a) MessagingStruct$ServiceExGroupCallStarted.newBuilder((MessagingStruct$ServiceExGroupCallStarted) this.trait_).v(messagingStruct$ServiceExGroupCallStarted)).j();
        }
        this.traitCase_ = 20;
    }

    private void mergeServiceExGroupCreated(MessagingStruct$ServiceExGroupCreated messagingStruct$ServiceExGroupCreated) {
        messagingStruct$ServiceExGroupCreated.getClass();
        if (this.traitCase_ != 10 || this.trait_ == MessagingStruct$ServiceExGroupCreated.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExGroupCreated;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExGroupCreated.a) MessagingStruct$ServiceExGroupCreated.newBuilder((MessagingStruct$ServiceExGroupCreated) this.trait_).v(messagingStruct$ServiceExGroupCreated)).j();
        }
        this.traitCase_ = 10;
    }

    private void mergeServiceExMiniAppDataSent(MessagingStruct$ServiceExMiniAppDataSent messagingStruct$ServiceExMiniAppDataSent) {
        messagingStruct$ServiceExMiniAppDataSent.getClass();
        if (this.traitCase_ != 23 || this.trait_ == MessagingStruct$ServiceExMiniAppDataSent.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExMiniAppDataSent;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExMiniAppDataSent.a) MessagingStruct$ServiceExMiniAppDataSent.newBuilder((MessagingStruct$ServiceExMiniAppDataSent) this.trait_).v(messagingStruct$ServiceExMiniAppDataSent)).j();
        }
        this.traitCase_ = 23;
    }

    private void mergeServiceExNewUserWelcome(MessagingStruct$ServiceExNewUserWelcome messagingStruct$ServiceExNewUserWelcome) {
        messagingStruct$ServiceExNewUserWelcome.getClass();
        if (this.traitCase_ != 19 || this.trait_ == MessagingStruct$ServiceExNewUserWelcome.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExNewUserWelcome;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExNewUserWelcome.a) MessagingStruct$ServiceExNewUserWelcome.newBuilder((MessagingStruct$ServiceExNewUserWelcome) this.trait_).v(messagingStruct$ServiceExNewUserWelcome)).j();
        }
        this.traitCase_ = 19;
    }

    private void mergeServiceExPassportDataSent(MessagingStruct$ServiceExPassportDataSent messagingStruct$ServiceExPassportDataSent) {
        messagingStruct$ServiceExPassportDataSent.getClass();
        if (this.traitCase_ != 25 || this.trait_ == MessagingStruct$ServiceExPassportDataSent.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExPassportDataSent;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExPassportDataSent.a) MessagingStruct$ServiceExPassportDataSent.newBuilder((MessagingStruct$ServiceExPassportDataSent) this.trait_).v(messagingStruct$ServiceExPassportDataSent)).j();
        }
        this.traitCase_ = 25;
    }

    private void mergeServiceExPhoneCall(MessagingStruct$ServiceExPhoneCall messagingStruct$ServiceExPhoneCall) {
        messagingStruct$ServiceExPhoneCall.getClass();
        if (this.traitCase_ != 11 || this.trait_ == MessagingStruct$ServiceExPhoneCall.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExPhoneCall;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExPhoneCall.a) MessagingStruct$ServiceExPhoneCall.newBuilder((MessagingStruct$ServiceExPhoneCall) this.trait_).v(messagingStruct$ServiceExPhoneCall)).j();
        }
        this.traitCase_ = 11;
    }

    private void mergeServiceExPhoneMissed(MessagingStruct$ServiceExPhoneMissed messagingStruct$ServiceExPhoneMissed) {
        messagingStruct$ServiceExPhoneMissed.getClass();
        if (this.traitCase_ != 12 || this.trait_ == MessagingStruct$ServiceExPhoneMissed.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExPhoneMissed;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExPhoneMissed.a) MessagingStruct$ServiceExPhoneMissed.newBuilder((MessagingStruct$ServiceExPhoneMissed) this.trait_).v(messagingStruct$ServiceExPhoneMissed)).j();
        }
        this.traitCase_ = 12;
    }

    private void mergeServiceExUserInvited(MessagingStruct$ServiceExUserInvited messagingStruct$ServiceExUserInvited) {
        messagingStruct$ServiceExUserInvited.getClass();
        if (this.traitCase_ != 13 || this.trait_ == MessagingStruct$ServiceExUserInvited.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExUserInvited;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExUserInvited.a) MessagingStruct$ServiceExUserInvited.newBuilder((MessagingStruct$ServiceExUserInvited) this.trait_).v(messagingStruct$ServiceExUserInvited)).j();
        }
        this.traitCase_ = 13;
    }

    private void mergeServiceExUserJoined(MessagingStruct$ServiceExUserJoined messagingStruct$ServiceExUserJoined) {
        messagingStruct$ServiceExUserJoined.getClass();
        if (this.traitCase_ != 14 || this.trait_ == MessagingStruct$ServiceExUserJoined.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExUserJoined;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExUserJoined.a) MessagingStruct$ServiceExUserJoined.newBuilder((MessagingStruct$ServiceExUserJoined) this.trait_).v(messagingStruct$ServiceExUserJoined)).j();
        }
        this.traitCase_ = 14;
    }

    private void mergeServiceExUserKicked(MessagingStruct$ServiceExUserKicked messagingStruct$ServiceExUserKicked) {
        messagingStruct$ServiceExUserKicked.getClass();
        if (this.traitCase_ != 15 || this.trait_ == MessagingStruct$ServiceExUserKicked.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExUserKicked;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExUserKicked.a) MessagingStruct$ServiceExUserKicked.newBuilder((MessagingStruct$ServiceExUserKicked) this.trait_).v(messagingStruct$ServiceExUserKicked)).j();
        }
        this.traitCase_ = 15;
    }

    private void mergeServiceExUserLeft(MessagingStruct$ServiceExUserLeft messagingStruct$ServiceExUserLeft) {
        messagingStruct$ServiceExUserLeft.getClass();
        if (this.traitCase_ != 16 || this.trait_ == MessagingStruct$ServiceExUserLeft.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceExUserLeft;
        } else {
            this.trait_ = ((MessagingStruct$ServiceExUserLeft.a) MessagingStruct$ServiceExUserLeft.newBuilder((MessagingStruct$ServiceExUserLeft) this.trait_).v(messagingStruct$ServiceExUserLeft)).j();
        }
        this.traitCase_ = 16;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ServiceEx parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceEx) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceEx parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ServiceEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setServiceExAnonymousContact(MessagingStruct$ServiceExAnonymousContact messagingStruct$ServiceExAnonymousContact) {
        messagingStruct$ServiceExAnonymousContact.getClass();
        this.trait_ = messagingStruct$ServiceExAnonymousContact;
        this.traitCase_ = 24;
    }

    private void setServiceExBecameOrphaned(MessagingStruct$ServiceExBecameOrphaned messagingStruct$ServiceExBecameOrphaned) {
        messagingStruct$ServiceExBecameOrphaned.getClass();
        this.trait_ = messagingStruct$ServiceExBecameOrphaned;
        this.traitCase_ = 1;
    }

    private void setServiceExCallRecordStateChanged(MessagingStruct$ServiceExCallRecordStateChanged messagingStruct$ServiceExCallRecordStateChanged) {
        messagingStruct$ServiceExCallRecordStateChanged.getClass();
        this.trait_ = messagingStruct$ServiceExCallRecordStateChanged;
        this.traitCase_ = 22;
    }

    private void setServiceExChangedAbout(MessagingStruct$ServiceExChangedAbout messagingStruct$ServiceExChangedAbout) {
        messagingStruct$ServiceExChangedAbout.getClass();
        this.trait_ = messagingStruct$ServiceExChangedAbout;
        this.traitCase_ = 2;
    }

    private void setServiceExChangedAvatar(MessagingStruct$ServiceExChangedAvatar messagingStruct$ServiceExChangedAvatar) {
        messagingStruct$ServiceExChangedAvatar.getClass();
        this.trait_ = messagingStruct$ServiceExChangedAvatar;
        this.traitCase_ = 3;
    }

    private void setServiceExChangedNick(MessagingStruct$ServiceExChangedNick messagingStruct$ServiceExChangedNick) {
        messagingStruct$ServiceExChangedNick.getClass();
        this.trait_ = messagingStruct$ServiceExChangedNick;
        this.traitCase_ = 4;
    }

    private void setServiceExChangedTitle(MessagingStruct$ServiceExChangedTitle messagingStruct$ServiceExChangedTitle) {
        messagingStruct$ServiceExChangedTitle.getClass();
        this.trait_ = messagingStruct$ServiceExChangedTitle;
        this.traitCase_ = 5;
    }

    private void setServiceExChangedTopic(MessagingStruct$ServiceExChangedTopic messagingStruct$ServiceExChangedTopic) {
        messagingStruct$ServiceExChangedTopic.getClass();
        this.trait_ = messagingStruct$ServiceExChangedTopic;
        this.traitCase_ = 6;
    }

    private void setServiceExChatArchived(MessagingStruct$ServiceExChatArchived messagingStruct$ServiceExChatArchived) {
        messagingStruct$ServiceExChatArchived.getClass();
        this.trait_ = messagingStruct$ServiceExChatArchived;
        this.traitCase_ = 7;
    }

    private void setServiceExChatRestored(MessagingStruct$ServiceExChatRestored messagingStruct$ServiceExChatRestored) {
        messagingStruct$ServiceExChatRestored.getClass();
        this.trait_ = messagingStruct$ServiceExChatRestored;
        this.traitCase_ = 8;
    }

    private void setServiceExContactRegistered(MessagingStruct$ServiceExContactRegistered messagingStruct$ServiceExContactRegistered) {
        messagingStruct$ServiceExContactRegistered.getClass();
        this.trait_ = messagingStruct$ServiceExContactRegistered;
        this.traitCase_ = 9;
    }

    private void setServiceExGiftPacketOpened(MessagingStruct$ServiceExGiftPacketOpened messagingStruct$ServiceExGiftPacketOpened) {
        messagingStruct$ServiceExGiftPacketOpened.getClass();
        this.trait_ = messagingStruct$ServiceExGiftPacketOpened;
        this.traitCase_ = 17;
    }

    private void setServiceExGiftPacketOpenedCompact(MessagingStruct$ServiceExGiftPacketOpenedCompact messagingStruct$ServiceExGiftPacketOpenedCompact) {
        messagingStruct$ServiceExGiftPacketOpenedCompact.getClass();
        this.trait_ = messagingStruct$ServiceExGiftPacketOpenedCompact;
        this.traitCase_ = 18;
    }

    private void setServiceExGroupCallEnded(MessagingStruct$ServiceExGroupCallEnded messagingStruct$ServiceExGroupCallEnded) {
        messagingStruct$ServiceExGroupCallEnded.getClass();
        this.trait_ = messagingStruct$ServiceExGroupCallEnded;
        this.traitCase_ = 21;
    }

    private void setServiceExGroupCallStarted(MessagingStruct$ServiceExGroupCallStarted messagingStruct$ServiceExGroupCallStarted) {
        messagingStruct$ServiceExGroupCallStarted.getClass();
        this.trait_ = messagingStruct$ServiceExGroupCallStarted;
        this.traitCase_ = 20;
    }

    private void setServiceExGroupCreated(MessagingStruct$ServiceExGroupCreated messagingStruct$ServiceExGroupCreated) {
        messagingStruct$ServiceExGroupCreated.getClass();
        this.trait_ = messagingStruct$ServiceExGroupCreated;
        this.traitCase_ = 10;
    }

    private void setServiceExMiniAppDataSent(MessagingStruct$ServiceExMiniAppDataSent messagingStruct$ServiceExMiniAppDataSent) {
        messagingStruct$ServiceExMiniAppDataSent.getClass();
        this.trait_ = messagingStruct$ServiceExMiniAppDataSent;
        this.traitCase_ = 23;
    }

    private void setServiceExNewUserWelcome(MessagingStruct$ServiceExNewUserWelcome messagingStruct$ServiceExNewUserWelcome) {
        messagingStruct$ServiceExNewUserWelcome.getClass();
        this.trait_ = messagingStruct$ServiceExNewUserWelcome;
        this.traitCase_ = 19;
    }

    private void setServiceExPassportDataSent(MessagingStruct$ServiceExPassportDataSent messagingStruct$ServiceExPassportDataSent) {
        messagingStruct$ServiceExPassportDataSent.getClass();
        this.trait_ = messagingStruct$ServiceExPassportDataSent;
        this.traitCase_ = 25;
    }

    private void setServiceExPhoneCall(MessagingStruct$ServiceExPhoneCall messagingStruct$ServiceExPhoneCall) {
        messagingStruct$ServiceExPhoneCall.getClass();
        this.trait_ = messagingStruct$ServiceExPhoneCall;
        this.traitCase_ = 11;
    }

    private void setServiceExPhoneMissed(MessagingStruct$ServiceExPhoneMissed messagingStruct$ServiceExPhoneMissed) {
        messagingStruct$ServiceExPhoneMissed.getClass();
        this.trait_ = messagingStruct$ServiceExPhoneMissed;
        this.traitCase_ = 12;
    }

    private void setServiceExUserInvited(MessagingStruct$ServiceExUserInvited messagingStruct$ServiceExUserInvited) {
        messagingStruct$ServiceExUserInvited.getClass();
        this.trait_ = messagingStruct$ServiceExUserInvited;
        this.traitCase_ = 13;
    }

    private void setServiceExUserJoined(MessagingStruct$ServiceExUserJoined messagingStruct$ServiceExUserJoined) {
        messagingStruct$ServiceExUserJoined.getClass();
        this.trait_ = messagingStruct$ServiceExUserJoined;
        this.traitCase_ = 14;
    }

    private void setServiceExUserKicked(MessagingStruct$ServiceExUserKicked messagingStruct$ServiceExUserKicked) {
        messagingStruct$ServiceExUserKicked.getClass();
        this.trait_ = messagingStruct$ServiceExUserKicked;
        this.traitCase_ = 15;
    }

    private void setServiceExUserLeft(MessagingStruct$ServiceExUserLeft messagingStruct$ServiceExUserLeft) {
        messagingStruct$ServiceExUserLeft.getClass();
        this.trait_ = messagingStruct$ServiceExUserLeft;
        this.traitCase_ = 16;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ServiceEx();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0019\u0001\u0000\u0001\u0019\u0019\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b<\u0000\f<\u0000\r<\u0000\u000e<\u0000\u000f<\u0000\u0010<\u0000\u0011<\u0000\u0012<\u0000\u0013<\u0000\u0014<\u0000\u0015<\u0000\u0016<\u0000\u0017<\u0000\u0018<\u0000\u0019<\u0000", new Object[]{"trait_", "traitCase_", MessagingStruct$ServiceExBecameOrphaned.class, MessagingStruct$ServiceExChangedAbout.class, MessagingStruct$ServiceExChangedAvatar.class, MessagingStruct$ServiceExChangedNick.class, MessagingStruct$ServiceExChangedTitle.class, MessagingStruct$ServiceExChangedTopic.class, MessagingStruct$ServiceExChatArchived.class, MessagingStruct$ServiceExChatRestored.class, MessagingStruct$ServiceExContactRegistered.class, MessagingStruct$ServiceExGroupCreated.class, MessagingStruct$ServiceExPhoneCall.class, MessagingStruct$ServiceExPhoneMissed.class, MessagingStruct$ServiceExUserInvited.class, MessagingStruct$ServiceExUserJoined.class, MessagingStruct$ServiceExUserKicked.class, MessagingStruct$ServiceExUserLeft.class, MessagingStruct$ServiceExGiftPacketOpened.class, MessagingStruct$ServiceExGiftPacketOpenedCompact.class, MessagingStruct$ServiceExNewUserWelcome.class, MessagingStruct$ServiceExGroupCallStarted.class, MessagingStruct$ServiceExGroupCallEnded.class, MessagingStruct$ServiceExCallRecordStateChanged.class, MessagingStruct$ServiceExMiniAppDataSent.class, MessagingStruct$ServiceExAnonymousContact.class, MessagingStruct$ServiceExPassportDataSent.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ServiceEx.class) {
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

    public MessagingStruct$ServiceExAnonymousContact getServiceExAnonymousContact() {
        return this.traitCase_ == 24 ? (MessagingStruct$ServiceExAnonymousContact) this.trait_ : MessagingStruct$ServiceExAnonymousContact.getDefaultInstance();
    }

    public MessagingStruct$ServiceExBecameOrphaned getServiceExBecameOrphaned() {
        return this.traitCase_ == 1 ? (MessagingStruct$ServiceExBecameOrphaned) this.trait_ : MessagingStruct$ServiceExBecameOrphaned.getDefaultInstance();
    }

    public MessagingStruct$ServiceExCallRecordStateChanged getServiceExCallRecordStateChanged() {
        return this.traitCase_ == 22 ? (MessagingStruct$ServiceExCallRecordStateChanged) this.trait_ : MessagingStruct$ServiceExCallRecordStateChanged.getDefaultInstance();
    }

    public MessagingStruct$ServiceExChangedAbout getServiceExChangedAbout() {
        return this.traitCase_ == 2 ? (MessagingStruct$ServiceExChangedAbout) this.trait_ : MessagingStruct$ServiceExChangedAbout.getDefaultInstance();
    }

    public MessagingStruct$ServiceExChangedAvatar getServiceExChangedAvatar() {
        return this.traitCase_ == 3 ? (MessagingStruct$ServiceExChangedAvatar) this.trait_ : MessagingStruct$ServiceExChangedAvatar.getDefaultInstance();
    }

    public MessagingStruct$ServiceExChangedNick getServiceExChangedNick() {
        return this.traitCase_ == 4 ? (MessagingStruct$ServiceExChangedNick) this.trait_ : MessagingStruct$ServiceExChangedNick.getDefaultInstance();
    }

    public MessagingStruct$ServiceExChangedTitle getServiceExChangedTitle() {
        return this.traitCase_ == 5 ? (MessagingStruct$ServiceExChangedTitle) this.trait_ : MessagingStruct$ServiceExChangedTitle.getDefaultInstance();
    }

    public MessagingStruct$ServiceExChangedTopic getServiceExChangedTopic() {
        return this.traitCase_ == 6 ? (MessagingStruct$ServiceExChangedTopic) this.trait_ : MessagingStruct$ServiceExChangedTopic.getDefaultInstance();
    }

    public MessagingStruct$ServiceExChatArchived getServiceExChatArchived() {
        return this.traitCase_ == 7 ? (MessagingStruct$ServiceExChatArchived) this.trait_ : MessagingStruct$ServiceExChatArchived.getDefaultInstance();
    }

    public MessagingStruct$ServiceExChatRestored getServiceExChatRestored() {
        return this.traitCase_ == 8 ? (MessagingStruct$ServiceExChatRestored) this.trait_ : MessagingStruct$ServiceExChatRestored.getDefaultInstance();
    }

    public MessagingStruct$ServiceExContactRegistered getServiceExContactRegistered() {
        return this.traitCase_ == 9 ? (MessagingStruct$ServiceExContactRegistered) this.trait_ : MessagingStruct$ServiceExContactRegistered.getDefaultInstance();
    }

    public MessagingStruct$ServiceExGiftPacketOpened getServiceExGiftPacketOpened() {
        return this.traitCase_ == 17 ? (MessagingStruct$ServiceExGiftPacketOpened) this.trait_ : MessagingStruct$ServiceExGiftPacketOpened.getDefaultInstance();
    }

    public MessagingStruct$ServiceExGiftPacketOpenedCompact getServiceExGiftPacketOpenedCompact() {
        return this.traitCase_ == 18 ? (MessagingStruct$ServiceExGiftPacketOpenedCompact) this.trait_ : MessagingStruct$ServiceExGiftPacketOpenedCompact.getDefaultInstance();
    }

    public MessagingStruct$ServiceExGroupCallEnded getServiceExGroupCallEnded() {
        return this.traitCase_ == 21 ? (MessagingStruct$ServiceExGroupCallEnded) this.trait_ : MessagingStruct$ServiceExGroupCallEnded.getDefaultInstance();
    }

    public MessagingStruct$ServiceExGroupCallStarted getServiceExGroupCallStarted() {
        return this.traitCase_ == 20 ? (MessagingStruct$ServiceExGroupCallStarted) this.trait_ : MessagingStruct$ServiceExGroupCallStarted.getDefaultInstance();
    }

    public MessagingStruct$ServiceExGroupCreated getServiceExGroupCreated() {
        return this.traitCase_ == 10 ? (MessagingStruct$ServiceExGroupCreated) this.trait_ : MessagingStruct$ServiceExGroupCreated.getDefaultInstance();
    }

    public MessagingStruct$ServiceExMiniAppDataSent getServiceExMiniAppDataSent() {
        return this.traitCase_ == 23 ? (MessagingStruct$ServiceExMiniAppDataSent) this.trait_ : MessagingStruct$ServiceExMiniAppDataSent.getDefaultInstance();
    }

    public MessagingStruct$ServiceExNewUserWelcome getServiceExNewUserWelcome() {
        return this.traitCase_ == 19 ? (MessagingStruct$ServiceExNewUserWelcome) this.trait_ : MessagingStruct$ServiceExNewUserWelcome.getDefaultInstance();
    }

    public MessagingStruct$ServiceExPassportDataSent getServiceExPassportDataSent() {
        return this.traitCase_ == 25 ? (MessagingStruct$ServiceExPassportDataSent) this.trait_ : MessagingStruct$ServiceExPassportDataSent.getDefaultInstance();
    }

    public MessagingStruct$ServiceExPhoneCall getServiceExPhoneCall() {
        return this.traitCase_ == 11 ? (MessagingStruct$ServiceExPhoneCall) this.trait_ : MessagingStruct$ServiceExPhoneCall.getDefaultInstance();
    }

    public MessagingStruct$ServiceExPhoneMissed getServiceExPhoneMissed() {
        return this.traitCase_ == 12 ? (MessagingStruct$ServiceExPhoneMissed) this.trait_ : MessagingStruct$ServiceExPhoneMissed.getDefaultInstance();
    }

    public MessagingStruct$ServiceExUserInvited getServiceExUserInvited() {
        return this.traitCase_ == 13 ? (MessagingStruct$ServiceExUserInvited) this.trait_ : MessagingStruct$ServiceExUserInvited.getDefaultInstance();
    }

    public MessagingStruct$ServiceExUserJoined getServiceExUserJoined() {
        return this.traitCase_ == 14 ? (MessagingStruct$ServiceExUserJoined) this.trait_ : MessagingStruct$ServiceExUserJoined.getDefaultInstance();
    }

    public MessagingStruct$ServiceExUserKicked getServiceExUserKicked() {
        return this.traitCase_ == 15 ? (MessagingStruct$ServiceExUserKicked) this.trait_ : MessagingStruct$ServiceExUserKicked.getDefaultInstance();
    }

    public MessagingStruct$ServiceExUserLeft getServiceExUserLeft() {
        return this.traitCase_ == 16 ? (MessagingStruct$ServiceExUserLeft) this.trait_ : MessagingStruct$ServiceExUserLeft.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasServiceExAnonymousContact() {
        return this.traitCase_ == 24;
    }

    public boolean hasServiceExBecameOrphaned() {
        return this.traitCase_ == 1;
    }

    public boolean hasServiceExCallRecordStateChanged() {
        return this.traitCase_ == 22;
    }

    public boolean hasServiceExChangedAbout() {
        return this.traitCase_ == 2;
    }

    public boolean hasServiceExChangedAvatar() {
        return this.traitCase_ == 3;
    }

    public boolean hasServiceExChangedNick() {
        return this.traitCase_ == 4;
    }

    public boolean hasServiceExChangedTitle() {
        return this.traitCase_ == 5;
    }

    public boolean hasServiceExChangedTopic() {
        return this.traitCase_ == 6;
    }

    public boolean hasServiceExChatArchived() {
        return this.traitCase_ == 7;
    }

    public boolean hasServiceExChatRestored() {
        return this.traitCase_ == 8;
    }

    public boolean hasServiceExContactRegistered() {
        return this.traitCase_ == 9;
    }

    public boolean hasServiceExGiftPacketOpened() {
        return this.traitCase_ == 17;
    }

    public boolean hasServiceExGiftPacketOpenedCompact() {
        return this.traitCase_ == 18;
    }

    public boolean hasServiceExGroupCallEnded() {
        return this.traitCase_ == 21;
    }

    public boolean hasServiceExGroupCallStarted() {
        return this.traitCase_ == 20;
    }

    public boolean hasServiceExGroupCreated() {
        return this.traitCase_ == 10;
    }

    public boolean hasServiceExMiniAppDataSent() {
        return this.traitCase_ == 23;
    }

    public boolean hasServiceExNewUserWelcome() {
        return this.traitCase_ == 19;
    }

    public boolean hasServiceExPassportDataSent() {
        return this.traitCase_ == 25;
    }

    public boolean hasServiceExPhoneCall() {
        return this.traitCase_ == 11;
    }

    public boolean hasServiceExPhoneMissed() {
        return this.traitCase_ == 12;
    }

    public boolean hasServiceExUserInvited() {
        return this.traitCase_ == 13;
    }

    public boolean hasServiceExUserJoined() {
        return this.traitCase_ == 14;
    }

    public boolean hasServiceExUserKicked() {
        return this.traitCase_ == 15;
    }

    public boolean hasServiceExUserLeft() {
        return this.traitCase_ == 16;
    }

    public static a newBuilder(MessagingStruct$ServiceEx messagingStruct$ServiceEx) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ServiceEx);
    }

    public static MessagingStruct$ServiceEx parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceEx) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceEx parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ServiceEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ServiceEx parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ServiceEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ServiceEx parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ServiceEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ServiceEx parseFrom(byte[] bArr) {
        return (MessagingStruct$ServiceEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ServiceEx parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ServiceEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ServiceEx parseFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceEx parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceEx parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ServiceEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ServiceEx parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ServiceEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

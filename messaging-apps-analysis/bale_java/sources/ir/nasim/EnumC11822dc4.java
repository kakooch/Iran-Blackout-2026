package ir.nasim;

import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import com.google.protobuf.B;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.dc4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC11822dc4 implements B.c {
    MessageContentType_UNKNOWN(0),
    MessageContentType_BANK_MONEY_TRANSFER(1),
    MessageContentType_BANK_REMAIN(2),
    MessageContentType_BANK_TRANSACTION(3),
    MessageContentType_BANK_RECEIPT_MESSAGE(4),
    MessageContentType_BANK_DEPRECATED_RECEIPT(5),
    MessageContentType_BANK_DEPRECATED_RECEIPT_MESSAGE(6),
    MessageContentType_BINARY(7),
    MessageContentType_DELETED(8),
    MessageContentType_DOCUMENT(9),
    MessageContentType_DOCUMENT_MEDIA(10),
    MessageContentType_DOCUMENT_VOICE(11),
    MessageContentType_DOCUMENT_AUDIO(12),
    MessageContentType_DOCUMENT_GIF(13),
    MessageContentType_EMPTY(14),
    MessageContentType_JSON(15),
    MessageContentType_NASIM_ENCRYPTED(16),
    MessageContentType_ORDER(17),
    MessageContentType_ORDER_BILL(18),
    MessageContentType_ORDER_CHARGE(19),
    MessageContentType_ORDER_PROXY(20),
    MessageContentType_PURCHASE(21),
    MessageContentType_SERVICE_MESSAGE_BECAME_ORPHAND(22),
    MessageContentType_SERVICE_MESSAGE_CHANGED_ABOUT(23),
    MessageContentType_SERVICE_MESSAGE_CHANGED_AVATAR(24),
    MessageContentType_SERVICE_MESSAGE_CHANGED_NICK(25),
    MessageContentType_SERVICE_MESSAGE_CHANGED_TITLE(26),
    MessageContentType_SERVICE_MESSAGE_CHANGED_TOPIC(27),
    MessageContentType_SERVICE_MESSAGE_CHAT_ARCHIVED(28),
    MessageContentType_SERVICE_MESSAGE_RESTORED(29),
    MessageContentType_SERVICE_MESSAGE_CONTACT_REGISTERED(30),
    MessageContentType_SERVICE_MESSAGE_GROUP_CREATED(31),
    MessageContentType_SERVICE_MESSAGE_PHONE_CALL(32),
    MessageContentType_SERVICE_MESSAGE_PHONE_MISSED(33),
    MessageContentType_SERVICE_MESSAGE_USER_INVITED(34),
    MessageContentType_SERVICE_MESSAGE_USER_JOINED(35),
    MessageContentType_SERVICE_MESSAGE_USER_KICKED(36),
    MessageContentType_SERVICE_MESSAGE_USER_LEFT(37),
    MessageContentType_SERVICE_MESSAGE_GIFT_PACKET_OPENED(38),
    MessageContentType_SERVICE_MESSAGE_GIFT_PACKET_OPENED_COMPACT(39),
    MessageContentType_SERVICE_MESSAGE_NEW_USER_WELCOME(40),
    MessageContentType_SERVICE_MESSAGE_GROUP_CALL_STARTED(41),
    MessageContentType_SERVICE_MESSAGE_GROUP_CALL_ENDED(42),
    MessageContentType_STICKER(43),
    MessageContentType_TEMPLATE(44),
    MessageContentType_TEMPLATE_RESPONSE(45),
    MessageContentType_TEXT(46),
    MessageContentType_UNSUPPORTED(47),
    MessageContentType_GIFT_PACKET(48),
    MessageContentType_PREMIUM(49),
    MessageContentType_NEW_PREMIUM(50),
    MessageContentType_BOUGHT_PREMIUM(51),
    MessageContentType_ADVERTISEMENT(52),
    MessageContentType_CROWD_FUNDING(53),
    MessageContentType_ANIMATED_STICKER(54),
    MessageContentType_STORY_REFERENCE(55),
    MessageContentType_BANK_MESSAGE(56),
    MessageContentType_DOCUMENT_PHOTO(57),
    MessageContentType_DOCUMENT_VIDEO(58),
    MessageContentType_BANNED(59),
    MessageContentType_SERVICE_MESSAGE_CALL_RECORD_STATE_CHANGED(60),
    MessageContentType_LIVE(61),
    MessageContentType_PROTECTED_MESSAGE(62),
    MessageContentType_SERVICE_MESSAGE_MINI_APP_DATA_SENT(63),
    MessageContentType_GOLD_GIFT_PACKET(64),
    MessageContentType_SERVICE_MESSAGE_ANONYMOUS_CONTACT(65),
    MessageContentType_POLL(66),
    MessageContentType_SERVICE_MESSAGE_PASSPORT_DATA_SENT(67),
    UNRECOGNIZED(-1);

    private static final B.d j1 = new B.d() { // from class: ir.nasim.dc4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC11822dc4 a(int i) {
            return EnumC11822dc4.j(i);
        }
    };
    private final int a;

    EnumC11822dc4(int i) {
        this.a = i;
    }

    public static EnumC11822dc4 j(int i) {
        switch (i) {
            case 0:
                return MessageContentType_UNKNOWN;
            case 1:
                return MessageContentType_BANK_MONEY_TRANSFER;
            case 2:
                return MessageContentType_BANK_REMAIN;
            case 3:
                return MessageContentType_BANK_TRANSACTION;
            case 4:
                return MessageContentType_BANK_RECEIPT_MESSAGE;
            case 5:
                return MessageContentType_BANK_DEPRECATED_RECEIPT;
            case 6:
                return MessageContentType_BANK_DEPRECATED_RECEIPT_MESSAGE;
            case 7:
                return MessageContentType_BINARY;
            case 8:
                return MessageContentType_DELETED;
            case 9:
                return MessageContentType_DOCUMENT;
            case 10:
                return MessageContentType_DOCUMENT_MEDIA;
            case 11:
                return MessageContentType_DOCUMENT_VOICE;
            case 12:
                return MessageContentType_DOCUMENT_AUDIO;
            case 13:
                return MessageContentType_DOCUMENT_GIF;
            case 14:
                return MessageContentType_EMPTY;
            case 15:
                return MessageContentType_JSON;
            case 16:
                return MessageContentType_NASIM_ENCRYPTED;
            case 17:
                return MessageContentType_ORDER;
            case 18:
                return MessageContentType_ORDER_BILL;
            case 19:
                return MessageContentType_ORDER_CHARGE;
            case 20:
                return MessageContentType_ORDER_PROXY;
            case 21:
                return MessageContentType_PURCHASE;
            case 22:
                return MessageContentType_SERVICE_MESSAGE_BECAME_ORPHAND;
            case 23:
                return MessageContentType_SERVICE_MESSAGE_CHANGED_ABOUT;
            case 24:
                return MessageContentType_SERVICE_MESSAGE_CHANGED_AVATAR;
            case 25:
                return MessageContentType_SERVICE_MESSAGE_CHANGED_NICK;
            case 26:
                return MessageContentType_SERVICE_MESSAGE_CHANGED_TITLE;
            case 27:
                return MessageContentType_SERVICE_MESSAGE_CHANGED_TOPIC;
            case 28:
                return MessageContentType_SERVICE_MESSAGE_CHAT_ARCHIVED;
            case 29:
                return MessageContentType_SERVICE_MESSAGE_RESTORED;
            case 30:
                return MessageContentType_SERVICE_MESSAGE_CONTACT_REGISTERED;
            case 31:
                return MessageContentType_SERVICE_MESSAGE_GROUP_CREATED;
            case 32:
                return MessageContentType_SERVICE_MESSAGE_PHONE_CALL;
            case 33:
                return MessageContentType_SERVICE_MESSAGE_PHONE_MISSED;
            case 34:
                return MessageContentType_SERVICE_MESSAGE_USER_INVITED;
            case 35:
                return MessageContentType_SERVICE_MESSAGE_USER_JOINED;
            case 36:
                return MessageContentType_SERVICE_MESSAGE_USER_KICKED;
            case 37:
                return MessageContentType_SERVICE_MESSAGE_USER_LEFT;
            case 38:
                return MessageContentType_SERVICE_MESSAGE_GIFT_PACKET_OPENED;
            case 39:
                return MessageContentType_SERVICE_MESSAGE_GIFT_PACKET_OPENED_COMPACT;
            case 40:
                return MessageContentType_SERVICE_MESSAGE_NEW_USER_WELCOME;
            case 41:
                return MessageContentType_SERVICE_MESSAGE_GROUP_CALL_STARTED;
            case 42:
                return MessageContentType_SERVICE_MESSAGE_GROUP_CALL_ENDED;
            case 43:
                return MessageContentType_STICKER;
            case 44:
                return MessageContentType_TEMPLATE;
            case 45:
                return MessageContentType_TEMPLATE_RESPONSE;
            case 46:
                return MessageContentType_TEXT;
            case 47:
                return MessageContentType_UNSUPPORTED;
            case 48:
                return MessageContentType_GIFT_PACKET;
            case 49:
                return MessageContentType_PREMIUM;
            case 50:
                return MessageContentType_NEW_PREMIUM;
            case 51:
                return MessageContentType_BOUGHT_PREMIUM;
            case Type.TLSA /* 52 */:
                return MessageContentType_ADVERTISEMENT;
            case 53:
                return MessageContentType_CROWD_FUNDING;
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                return MessageContentType_ANIMATED_STICKER;
            case 55:
                return MessageContentType_STORY_REFERENCE;
            case Type.NINFO /* 56 */:
                return MessageContentType_BANK_MESSAGE;
            case 57:
                return MessageContentType_DOCUMENT_PHOTO;
            case 58:
                return MessageContentType_DOCUMENT_VIDEO;
            case 59:
                return MessageContentType_BANNED;
            case 60:
                return MessageContentType_SERVICE_MESSAGE_CALL_RECORD_STATE_CHANGED;
            case 61:
                return MessageContentType_LIVE;
            case 62:
                return MessageContentType_PROTECTED_MESSAGE;
            case 63:
                return MessageContentType_SERVICE_MESSAGE_MINI_APP_DATA_SENT;
            case 64:
                return MessageContentType_GOLD_GIFT_PACKET;
            case 65:
                return MessageContentType_SERVICE_MESSAGE_ANONYMOUS_CONTACT;
            case WKSRecord.Protocol.RVD /* 66 */:
                return MessageContentType_POLL;
            case 67:
                return MessageContentType_SERVICE_MESSAGE_PASSPORT_DATA_SENT;
            default:
                return null;
        }
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

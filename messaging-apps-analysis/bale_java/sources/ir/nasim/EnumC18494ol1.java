package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.ol1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public enum EnumC18494ol1 {
    TEXT(2),
    NONE(1),
    BANK(26),
    BANK_TRANSFER_MONEY(27),
    BANK_REMAIN(28),
    BANK_TRANSACTION(29),
    BANK_RECEIPT(33),
    ORDER(30),
    ORDER_CHARGE(31),
    ORDER_BILL(32),
    PROXY_ORDER(35),
    PURCHASE_CONTENT(34),
    DOCUMENT(3),
    DOCUMENT_PHOTO(4),
    DOCUMENT_VIDEO(5),
    DOCUMENT_GIF(39),
    DOCUMENT_VOICE(17),
    CONTACT(18),
    LOCATION(19),
    STICKER(20),
    SERVICE(6, true),
    SERVICE_ADD(7, true),
    SERVICE_KICK(8, true),
    SERVICE_LEAVE(9, true),
    SERVICE_REGISTERED(10, true),
    SERVICE_CREATED(11, true),
    SERVICE_JOINED(16, true),
    SERVICE_TITLE(12, true),
    SERVICE_AVATAR(13, true),
    SERVICE_AVATAR_REMOVED(14, true),
    CUSTOM_JSON_MESSAGE(21),
    SERVICE_CALL_ENDED(22, true),
    SERVICE_CALL_MISSED(23, true),
    SERVICE_TOPIC(24, true),
    SERVICE_ABOUT(25, true),
    SERVICE_BAM_LOGIN_REQUESTED(36, true),
    REPLY_KEYBOARD_MARKUP(37),
    INLINE_KEYBOARD_MARKUP(38),
    ENCRYPTED(100),
    DELETED(101),
    EMPTY_CONTENT(102),
    TEMPLATE(103),
    TEMPLATE_RESPONSE(104),
    UNSUPPORTED(105),
    SERVICE_ORPHANED(Type.L64, true),
    SERVICE_INVITED(107, true),
    DOCUMENT_AUDIO(Type.EUI48),
    GIFT_PACKET(109),
    SERVICE_GIFT_PACKET_OPENED(110, true),
    SERVICE_GIFT_PACKET_OPENED_COMPACT(WKSRecord.Service.SUNRPC, true),
    REPLY_KEYBOARD_REMOVE(SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER),
    ADVERTISEMENT_CONTENT(116),
    CROWDFUNDING_CONTENT(WKSRecord.Service.UUCP_PATH),
    UNKNOWN_CONTENT(15),
    ANIMATED_STICKER(40),
    SERVICE_NEW_USER_WELCOME(41, true),
    SERVICE_VIDEO_CALL_ENDED(42, true),
    LIVE(43);

    final int a;
    final boolean b;

    EnumC18494ol1(int i) {
        this(i, false);
    }

    public static EnumC18494ol1 j(int i) {
        if (i == 117) {
            return CROWDFUNDING_CONTENT;
        }
        switch (i) {
            case 2:
                return TEXT;
            case 3:
                return DOCUMENT;
            case 4:
                return DOCUMENT_PHOTO;
            case 5:
                return DOCUMENT_VIDEO;
            case 6:
                return SERVICE;
            case 7:
                return SERVICE_ADD;
            case 8:
                return SERVICE_KICK;
            case 9:
                return SERVICE_LEAVE;
            case 10:
                return SERVICE_REGISTERED;
            case 11:
                return SERVICE_CREATED;
            case 12:
                return SERVICE_TITLE;
            case 13:
                return SERVICE_AVATAR;
            case 14:
                return SERVICE_AVATAR_REMOVED;
            default:
                switch (i) {
                    case 16:
                        return SERVICE_JOINED;
                    case 17:
                        return DOCUMENT_VOICE;
                    case 18:
                        return CONTACT;
                    case 19:
                        return LOCATION;
                    case 20:
                        return STICKER;
                    case 21:
                        return CUSTOM_JSON_MESSAGE;
                    case 22:
                        return SERVICE_CALL_ENDED;
                    case 23:
                        return SERVICE_CALL_MISSED;
                    case 24:
                        return SERVICE_TOPIC;
                    case 25:
                        return SERVICE_ABOUT;
                    case 26:
                        return BANK;
                    case 27:
                        return BANK_TRANSFER_MONEY;
                    case 28:
                        return BANK_REMAIN;
                    case 29:
                        return BANK_TRANSACTION;
                    case 30:
                        return ORDER;
                    case 31:
                        return ORDER_CHARGE;
                    case 32:
                        return ORDER_BILL;
                    case 33:
                        return BANK_RECEIPT;
                    case 34:
                        return PURCHASE_CONTENT;
                    case 35:
                        return PROXY_ORDER;
                    case 36:
                        return SERVICE_BAM_LOGIN_REQUESTED;
                    case 37:
                        return REPLY_KEYBOARD_MARKUP;
                    case 38:
                        return INLINE_KEYBOARD_MARKUP;
                    case 39:
                        return DOCUMENT_GIF;
                    case 40:
                        return ANIMATED_STICKER;
                    case 41:
                        return SERVICE_NEW_USER_WELCOME;
                    case 42:
                        return SERVICE_VIDEO_CALL_ENDED;
                    case 43:
                        return LIVE;
                    default:
                        switch (i) {
                            case 101:
                                return DELETED;
                            case 102:
                                return EMPTY_CONTENT;
                            case 103:
                                return TEMPLATE;
                            case 104:
                                return TEMPLATE_RESPONSE;
                            case 105:
                                return UNSUPPORTED;
                            case Type.L64 /* 106 */:
                                return SERVICE_ORPHANED;
                            case 107:
                                return SERVICE_INVITED;
                            default:
                                switch (i) {
                                    case 109:
                                        return GIFT_PACKET;
                                    case 110:
                                        return SERVICE_GIFT_PACKET_OPENED;
                                    case WKSRecord.Service.SUNRPC /* 111 */:
                                        return SERVICE_GIFT_PACKET_OPENED_COMPACT;
                                    default:
                                        return NONE;
                                }
                        }
                }
        }
    }

    public int p() {
        return this.a;
    }

    public boolean q() {
        return this.b;
    }

    EnumC18494ol1(int i, boolean z) {
        this.a = i;
        this.b = z;
    }
}

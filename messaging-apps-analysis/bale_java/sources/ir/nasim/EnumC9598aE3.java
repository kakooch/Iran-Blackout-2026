package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.aE3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC9598aE3 implements B.c {
    ROOM_CREATED(0),
    ROOM_ENDED(1),
    PARTICIPANT_JOINED(2),
    PARTICIPANT_LEFT(3),
    TRACK_PUBLISHED(4),
    TRACK_PUBLISH_REQUESTED(20),
    TRACK_UNPUBLISHED(5),
    TRACK_SUBSCRIBED(6),
    TRACK_SUBSCRIBE_REQUESTED(21),
    TRACK_SUBSCRIBE_FAILED(25),
    TRACK_UNSUBSCRIBED(7),
    TRACK_PUBLISHED_UPDATE(10),
    TRACK_MUTED(23),
    TRACK_UNMUTED(24),
    TRACK_PUBLISH_STATS(26),
    TRACK_SUBSCRIBE_STATS(27),
    PARTICIPANT_ACTIVE(11),
    PARTICIPANT_RESUMED(22),
    EGRESS_STARTED(12),
    EGRESS_ENDED(13),
    EGRESS_UPDATED(28),
    TRACK_MAX_SUBSCRIBED_VIDEO_QUALITY(14),
    RECONNECTED(15),
    INGRESS_CREATED(18),
    INGRESS_DELETED(19),
    INGRESS_STARTED(16),
    INGRESS_ENDED(17),
    INGRESS_UPDATED(29),
    SIP_INBOUND_TRUNK_CREATED(30),
    SIP_INBOUND_TRUNK_DELETED(31),
    SIP_OUTBOUND_TRUNK_CREATED(32),
    SIP_OUTBOUND_TRUNK_DELETED(33),
    SIP_DISPATCH_RULE_CREATED(34),
    SIP_DISPATCH_RULE_DELETED(35),
    SIP_PARTICIPANT_CREATED(36),
    SIP_CALL_INCOMING(37),
    SIP_CALL_STARTED(38),
    SIP_CALL_ENDED(39),
    SIP_TRANSFER_REQUESTED(43),
    SIP_TRANSFER_COMPLETE(44),
    REPORT(40),
    API_CALL(41),
    WEBHOOK(42),
    UNRECOGNIZED(-1);

    private static final B.d K0 = new B.d() { // from class: ir.nasim.aE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC9598aE3 a(int i) {
            return EnumC9598aE3.j(i);
        }
    };
    private final int a;

    EnumC9598aE3(int i) {
        this.a = i;
    }

    public static EnumC9598aE3 j(int i) {
        switch (i) {
            case 0:
                return ROOM_CREATED;
            case 1:
                return ROOM_ENDED;
            case 2:
                return PARTICIPANT_JOINED;
            case 3:
                return PARTICIPANT_LEFT;
            case 4:
                return TRACK_PUBLISHED;
            case 5:
                return TRACK_UNPUBLISHED;
            case 6:
                return TRACK_SUBSCRIBED;
            case 7:
                return TRACK_UNSUBSCRIBED;
            case 8:
            case 9:
            default:
                return null;
            case 10:
                return TRACK_PUBLISHED_UPDATE;
            case 11:
                return PARTICIPANT_ACTIVE;
            case 12:
                return EGRESS_STARTED;
            case 13:
                return EGRESS_ENDED;
            case 14:
                return TRACK_MAX_SUBSCRIBED_VIDEO_QUALITY;
            case 15:
                return RECONNECTED;
            case 16:
                return INGRESS_STARTED;
            case 17:
                return INGRESS_ENDED;
            case 18:
                return INGRESS_CREATED;
            case 19:
                return INGRESS_DELETED;
            case 20:
                return TRACK_PUBLISH_REQUESTED;
            case 21:
                return TRACK_SUBSCRIBE_REQUESTED;
            case 22:
                return PARTICIPANT_RESUMED;
            case 23:
                return TRACK_MUTED;
            case 24:
                return TRACK_UNMUTED;
            case 25:
                return TRACK_SUBSCRIBE_FAILED;
            case 26:
                return TRACK_PUBLISH_STATS;
            case 27:
                return TRACK_SUBSCRIBE_STATS;
            case 28:
                return EGRESS_UPDATED;
            case 29:
                return INGRESS_UPDATED;
            case 30:
                return SIP_INBOUND_TRUNK_CREATED;
            case 31:
                return SIP_INBOUND_TRUNK_DELETED;
            case 32:
                return SIP_OUTBOUND_TRUNK_CREATED;
            case 33:
                return SIP_OUTBOUND_TRUNK_DELETED;
            case 34:
                return SIP_DISPATCH_RULE_CREATED;
            case 35:
                return SIP_DISPATCH_RULE_DELETED;
            case 36:
                return SIP_PARTICIPANT_CREATED;
            case 37:
                return SIP_CALL_INCOMING;
            case 38:
                return SIP_CALL_STARTED;
            case 39:
                return SIP_CALL_ENDED;
            case 40:
                return REPORT;
            case 41:
                return API_CALL;
            case 42:
                return WEBHOOK;
            case 43:
                return SIP_TRANSFER_REQUESTED;
            case 44:
                return SIP_TRANSFER_COMPLETE;
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

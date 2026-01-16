package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum RE3 implements B.c {
    UNKNOWN_REASON(0),
    CLIENT_INITIATED(1),
    DUPLICATE_IDENTITY(2),
    SERVER_SHUTDOWN(3),
    PARTICIPANT_REMOVED(4),
    ROOM_DELETED(5),
    STATE_MISMATCH(6),
    JOIN_FAILURE(7),
    MIGRATION(8),
    SIGNAL_CLOSE(9),
    ROOM_CLOSED(10),
    USER_UNAVAILABLE(11),
    USER_REJECTED(12),
    SIP_TRUNK_FAILURE(13),
    CONNECTION_TIMEOUT(14),
    MEDIA_FAILURE(15),
    UNRECOGNIZED(-1);

    private static final B.d s = new B.d() { // from class: ir.nasim.RE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RE3 a(int i) {
            return RE3.j(i);
        }
    };
    private final int a;

    RE3(int i) {
        this.a = i;
    }

    public static RE3 j(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_REASON;
            case 1:
                return CLIENT_INITIATED;
            case 2:
                return DUPLICATE_IDENTITY;
            case 3:
                return SERVER_SHUTDOWN;
            case 4:
                return PARTICIPANT_REMOVED;
            case 5:
                return ROOM_DELETED;
            case 6:
                return STATE_MISMATCH;
            case 7:
                return JOIN_FAILURE;
            case 8:
                return MIGRATION;
            case 9:
                return SIGNAL_CLOSE;
            case 10:
                return ROOM_CLOSED;
            case 11:
                return USER_UNAVAILABLE;
            case 12:
                return USER_REJECTED;
            case 13:
                return SIP_TRUNK_FAILURE;
            case 14:
                return CONNECTION_TIMEOUT;
            case 15:
                return MEDIA_FAILURE;
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

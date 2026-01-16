package ir.nasim;

/* renamed from: ir.nasim.jD, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC15220jD {
    UNKNOWN(0),
    NONE(1),
    STRIP_ENTITIES(2),
    ENABLE_COMBINED(3),
    FASTER_MESSAGES(4),
    STRIP_COUNTERS(5),
    COMPACT_USERS(6),
    GROUPS_V2(7),
    STRIP_MESSAGES(8),
    STRIP_USER_UPDATES(9),
    STRIP_TOTAL_UPDATES(10),
    STRIP_UNREAD_COUNTS(11),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC15220jD(int i) {
        this.a = i;
    }

    public static EnumC15220jD p(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return NONE;
            case 2:
                return STRIP_ENTITIES;
            case 3:
                return ENABLE_COMBINED;
            case 4:
                return FASTER_MESSAGES;
            case 5:
                return STRIP_COUNTERS;
            case 6:
                return COMPACT_USERS;
            case 7:
                return GROUPS_V2;
            case 8:
                return STRIP_MESSAGES;
            case 9:
                return STRIP_USER_UPDATES;
            case 10:
                return STRIP_TOTAL_UPDATES;
            case 11:
                return STRIP_UNREAD_COUNTS;
            default:
                return UNSUPPORTED_VALUE;
        }
    }

    public int j() {
        return this.a;
    }
}

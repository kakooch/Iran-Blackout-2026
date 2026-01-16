package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.m35, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC16902m35 implements B.c {
    UpdateOptimization_UNKNOWN(0),
    UpdateOptimization_NONE(1),
    UpdateOptimization_STRIP_ENTITIES(2),
    UpdateOptimization_ENABLE_COMBINED(3),
    UpdateOptimization_FASTER_MESSAGES(4),
    UpdateOptimization_STRIP_COUNTERS(5),
    UpdateOptimization_COMPACT_USERS(6),
    UpdateOptimization_GROUPS_V2(7),
    UpdateOptimization_STRIP_MESSAGES(8),
    UpdateOptimization_STRIP_USER_UPDATES(9),
    UpdateOptimization_STRIP_TOTAL_UPDATES(10),
    UpdateOptimization_STRIP_UNREAD_COUNTS(11),
    UNRECOGNIZED(-1);

    private static final B.d o = new B.d() { // from class: ir.nasim.m35.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC16902m35 a(int i) {
            return EnumC16902m35.j(i);
        }
    };
    private final int a;

    EnumC16902m35(int i) {
        this.a = i;
    }

    public static EnumC16902m35 j(int i) {
        switch (i) {
            case 0:
                return UpdateOptimization_UNKNOWN;
            case 1:
                return UpdateOptimization_NONE;
            case 2:
                return UpdateOptimization_STRIP_ENTITIES;
            case 3:
                return UpdateOptimization_ENABLE_COMBINED;
            case 4:
                return UpdateOptimization_FASTER_MESSAGES;
            case 5:
                return UpdateOptimization_STRIP_COUNTERS;
            case 6:
                return UpdateOptimization_COMPACT_USERS;
            case 7:
                return UpdateOptimization_GROUPS_V2;
            case 8:
                return UpdateOptimization_STRIP_MESSAGES;
            case 9:
                return UpdateOptimization_STRIP_USER_UPDATES;
            case 10:
                return UpdateOptimization_STRIP_TOTAL_UPDATES;
            case 11:
                return UpdateOptimization_STRIP_UNREAD_COUNTS;
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

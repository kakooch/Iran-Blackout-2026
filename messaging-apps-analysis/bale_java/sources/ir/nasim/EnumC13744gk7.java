package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.gk7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC13744gk7 implements B.c {
    TasksUserLevel_UNKNOWN(0),
    TasksUserLevel_COPER(1),
    TasksUserLevel_SILVER(2),
    TasksUserLevel_GOLD(3),
    TasksUserLevel_DIAMOND(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.gk7.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC13744gk7 a(int i2) {
            return EnumC13744gk7.j(i2);
        }
    };
    private final int a;

    EnumC13744gk7(int i2) {
        this.a = i2;
    }

    public static EnumC13744gk7 j(int i2) {
        if (i2 == 0) {
            return TasksUserLevel_UNKNOWN;
        }
        if (i2 == 1) {
            return TasksUserLevel_COPER;
        }
        if (i2 == 2) {
            return TasksUserLevel_SILVER;
        }
        if (i2 == 3) {
            return TasksUserLevel_GOLD;
        }
        if (i2 != 4) {
            return null;
        }
        return TasksUserLevel_DIAMOND;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

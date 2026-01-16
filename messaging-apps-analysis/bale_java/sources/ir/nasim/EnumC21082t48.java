package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.t48, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC21082t48 implements B.c {
    WarriorLevel_UNKNOWN(0),
    WarriorLevel_BRAVE(1),
    WarriorLevel_COMBATANT(2),
    WarriorLevel_HERO(3),
    WarriorLevel_WARRIOR(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.t48.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC21082t48 a(int i2) {
            return EnumC21082t48.j(i2);
        }
    };
    private final int a;

    EnumC21082t48(int i2) {
        this.a = i2;
    }

    public static EnumC21082t48 j(int i2) {
        if (i2 == 0) {
            return WarriorLevel_UNKNOWN;
        }
        if (i2 == 1) {
            return WarriorLevel_BRAVE;
        }
        if (i2 == 2) {
            return WarriorLevel_COMBATANT;
        }
        if (i2 == 3) {
            return WarriorLevel_HERO;
        }
        if (i2 != 4) {
            return null;
        }
        return WarriorLevel_WARRIOR;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.b96, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC10149b96 implements B.c {
    LevelType_NONE(0),
    LevelType_BRONZE(1),
    LevelType_SILVER(2),
    LevelType_GOLDEN(3),
    LevelType_DIAMOND(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.b96.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC10149b96 a(int i2) {
            return EnumC10149b96.j(i2);
        }
    };
    private final int a;

    EnumC10149b96(int i2) {
        this.a = i2;
    }

    public static EnumC10149b96 j(int i2) {
        if (i2 == 0) {
            return LevelType_NONE;
        }
        if (i2 == 1) {
            return LevelType_BRONZE;
        }
        if (i2 == 2) {
            return LevelType_SILVER;
        }
        if (i2 == 3) {
            return LevelType_GOLDEN;
        }
        if (i2 != 4) {
            return null;
        }
        return LevelType_DIAMOND;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

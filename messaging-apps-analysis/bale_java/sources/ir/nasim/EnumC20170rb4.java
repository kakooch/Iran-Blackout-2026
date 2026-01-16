package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.rb4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC20170rb4 implements B.c {
    DialogType_UNKNOWN(0),
    DialogType_PRIVATE(1),
    DialogType_GROUP(2),
    DialogType_CHANNEL(3),
    DialogType_BOT(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.rb4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC20170rb4 a(int i2) {
            return EnumC20170rb4.j(i2);
        }
    };
    private final int a;

    EnumC20170rb4(int i2) {
        this.a = i2;
    }

    public static EnumC20170rb4 j(int i2) {
        if (i2 == 0) {
            return DialogType_UNKNOWN;
        }
        if (i2 == 1) {
            return DialogType_PRIVATE;
        }
        if (i2 == 2) {
            return DialogType_GROUP;
        }
        if (i2 == 3) {
            return DialogType_CHANNEL;
        }
        if (i2 != 4) {
            return null;
        }
        return DialogType_BOT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.zS2, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC24932zS2 implements B.c {
    GroupType_GROUP(0),
    GroupType_CHANNEL(1),
    GroupType_SUPER_GROUP(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.zS2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC24932zS2 a(int i) {
            return EnumC24932zS2.j(i);
        }
    };
    private final int a;

    EnumC24932zS2(int i) {
        this.a = i;
    }

    public static EnumC24932zS2 j(int i) {
        if (i == 0) {
            return GroupType_GROUP;
        }
        if (i == 1) {
            return GroupType_CHANNEL;
        }
        if (i != 2) {
            return null;
        }
        return GroupType_SUPER_GROUP;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

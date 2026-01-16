package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.bU3, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC10336bU3 implements B.c {
    UserGender_MALE(0),
    UserGender_FEMALE(1),
    UserGender_UNKNOWN(3),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.bU3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC10336bU3 a(int i) {
            return EnumC10336bU3.j(i);
        }
    };
    private final int a;

    EnumC10336bU3(int i) {
        this.a = i;
    }

    public static EnumC10336bU3 j(int i) {
        if (i == 0) {
            return UserGender_MALE;
        }
        if (i == 1) {
            return UserGender_FEMALE;
        }
        if (i != 3) {
            return null;
        }
        return UserGender_UNKNOWN;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

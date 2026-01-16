package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Kh, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC5658Kh implements B.c {
    UserDataState_UNKNOWN(0),
    UserDataState_UNDERREVIEW(1),
    UserDataState_CONFIRMED(2),
    UserDataState_REJECTED(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.Kh.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC5658Kh a(int i) {
            return EnumC5658Kh.j(i);
        }
    };
    private final int a;

    EnumC5658Kh(int i) {
        this.a = i;
    }

    public static EnumC5658Kh j(int i) {
        if (i == 0) {
            return UserDataState_UNKNOWN;
        }
        if (i == 1) {
            return UserDataState_UNDERREVIEW;
        }
        if (i == 2) {
            return UserDataState_CONFIRMED;
        }
        if (i != 3) {
            return null;
        }
        return UserDataState_REJECTED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

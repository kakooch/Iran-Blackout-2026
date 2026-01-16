package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Lh, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC5892Lh implements B.c {
    UserStatus_NOTREGISTERED(0),
    UserStatus_WAITING(1),
    UserStatus_ACCEPTED(2),
    UserStatus_REJECTED(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.Lh.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC5892Lh a(int i) {
            return EnumC5892Lh.j(i);
        }
    };
    private final int a;

    EnumC5892Lh(int i) {
        this.a = i;
    }

    public static EnumC5892Lh j(int i) {
        if (i == 0) {
            return UserStatus_NOTREGISTERED;
        }
        if (i == 1) {
            return UserStatus_WAITING;
        }
        if (i == 2) {
            return UserStatus_ACCEPTED;
        }
        if (i != 3) {
            return null;
        }
        return UserStatus_REJECTED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

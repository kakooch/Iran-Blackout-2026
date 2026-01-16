package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.gh, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC13706gh implements B.c {
    EarnMoneyStatus_NOTALLOWED(0),
    EarnMoneyStatus_ALLOWED(1),
    EarnMoneyStatus_WAITING(2),
    EarnMoneyStatus_ACCEPTED(3),
    EarnMoneyStatus_REJECTED(4),
    EarnMoneyStatus_NO_AD(5),
    UNRECOGNIZED(-1);

    private static final B.d i = new B.d() { // from class: ir.nasim.gh.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC13706gh a(int i2) {
            return EnumC13706gh.j(i2);
        }
    };
    private final int a;

    EnumC13706gh(int i2) {
        this.a = i2;
    }

    public static EnumC13706gh j(int i2) {
        if (i2 == 0) {
            return EarnMoneyStatus_NOTALLOWED;
        }
        if (i2 == 1) {
            return EarnMoneyStatus_ALLOWED;
        }
        if (i2 == 2) {
            return EarnMoneyStatus_WAITING;
        }
        if (i2 == 3) {
            return EarnMoneyStatus_ACCEPTED;
        }
        if (i2 == 4) {
            return EarnMoneyStatus_REJECTED;
        }
        if (i2 != 5) {
            return null;
        }
        return EarnMoneyStatus_NO_AD;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

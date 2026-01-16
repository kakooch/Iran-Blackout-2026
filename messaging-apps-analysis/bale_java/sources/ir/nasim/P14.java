package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum P14 implements B.c {
    LoanType_UNKNOWN(0),
    LoanType_NONE_INSTALLMENT_FACILITIES(1),
    LoanType_NORMALL_INSTALLMENT_FACILITIES(2),
    LoanType_STAGE_INSTALLMENT_FACILITIES(3),
    LoanType_OTHER_FACILITITES(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.P14.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public P14 a(int i2) {
            return P14.j(i2);
        }
    };
    private final int a;

    P14(int i2) {
        this.a = i2;
    }

    public static P14 j(int i2) {
        if (i2 == 0) {
            return LoanType_UNKNOWN;
        }
        if (i2 == 1) {
            return LoanType_NONE_INSTALLMENT_FACILITIES;
        }
        if (i2 == 2) {
            return LoanType_NORMALL_INSTALLMENT_FACILITIES;
        }
        if (i2 == 3) {
            return LoanType_STAGE_INSTALLMENT_FACILITIES;
        }
        if (i2 != 4) {
            return null;
        }
        return LoanType_OTHER_FACILITITES;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

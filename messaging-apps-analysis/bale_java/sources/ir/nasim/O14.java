package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum O14 implements B.c {
    LoanStatus_UNKNOWN(0),
    LoanStatus_NORMAL(1),
    LoanStatus_OUTDATE(2),
    LoanStatus_DOUBTFUL(3),
    LoanStatus_CURRENT_DATE(4),
    LoanStatus_CLEARING(5),
    LoanStatus_DEFFERED_CLAIMS(6),
    LoanStatus_OUTDATED(7),
    LoanStatus_DATE_EXTENSION(8),
    LoanStatus_BUYING(9),
    LoanStatus_OPEN_NEW_ACCOUNT(10),
    UNRECOGNIZED(-1);

    private static final B.d n = new B.d() { // from class: ir.nasim.O14.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public O14 a(int i) {
            return O14.j(i);
        }
    };
    private final int a;

    O14(int i) {
        this.a = i;
    }

    public static O14 j(int i) {
        switch (i) {
            case 0:
                return LoanStatus_UNKNOWN;
            case 1:
                return LoanStatus_NORMAL;
            case 2:
                return LoanStatus_OUTDATE;
            case 3:
                return LoanStatus_DOUBTFUL;
            case 4:
                return LoanStatus_CURRENT_DATE;
            case 5:
                return LoanStatus_CLEARING;
            case 6:
                return LoanStatus_DEFFERED_CLAIMS;
            case 7:
                return LoanStatus_OUTDATED;
            case 8:
                return LoanStatus_DATE_EXTENSION;
            case 9:
                return LoanStatus_BUYING;
            case 10:
                return LoanStatus_OPEN_NEW_ACCOUNT;
            default:
                return null;
        }
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

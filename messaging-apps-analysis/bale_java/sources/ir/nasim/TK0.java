package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum TK0 implements B.c {
    InternetBundleListType_DAILY(0),
    InternetBundleListType_WEEKLY(1),
    InternetBundleListType_MONTHLY(2),
    InternetBundleListType_TRIMESTER(3),
    InternetBundleListType_SEMIANNUAL(4),
    InternetBundleListType_ANNUAL(5),
    InternetBundleListType_OTHERS(6),
    InternetBundleListType_THREEDAYS(7),
    InternetBundleListType_FIFTEENDAYS(8),
    InternetBundleListType_REASON(9),
    InternetBundleListType_TWOMONTH(10),
    InternetBundleListType_FOURMONTH(11),
    UNRECOGNIZED(-1);

    private static final B.d o = new B.d() { // from class: ir.nasim.TK0.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TK0 a(int i) {
            return TK0.j(i);
        }
    };
    private final int a;

    TK0(int i) {
        this.a = i;
    }

    public static TK0 j(int i) {
        switch (i) {
            case 0:
                return InternetBundleListType_DAILY;
            case 1:
                return InternetBundleListType_WEEKLY;
            case 2:
                return InternetBundleListType_MONTHLY;
            case 3:
                return InternetBundleListType_TRIMESTER;
            case 4:
                return InternetBundleListType_SEMIANNUAL;
            case 5:
                return InternetBundleListType_ANNUAL;
            case 6:
                return InternetBundleListType_OTHERS;
            case 7:
                return InternetBundleListType_THREEDAYS;
            case 8:
                return InternetBundleListType_FIFTEENDAYS;
            case 9:
                return InternetBundleListType_REASON;
            case 10:
                return InternetBundleListType_TWOMONTH;
            case 11:
                return InternetBundleListType_FOURMONTH;
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

package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes.dex */
public enum MP5 implements B.c {
    ReportKind_UNKNOWN(0),
    ReportKind_SCAM(1),
    ReportKind_INAPPROPRIATE_CONTENT(2),
    ReportKind_OTHER(3),
    ReportKind_VIOLENCE(4),
    ReportKind_SPAM(5),
    ReportKind_FALSE_INFORMATION(6),
    UNRECOGNIZED(-1);

    private static final B.d j = new B.d() { // from class: ir.nasim.MP5.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MP5 a(int i) {
            return MP5.j(i);
        }
    };
    private final int a;

    MP5(int i) {
        this.a = i;
    }

    public static MP5 j(int i) {
        switch (i) {
            case 0:
                return ReportKind_UNKNOWN;
            case 1:
                return ReportKind_SCAM;
            case 2:
                return ReportKind_INAPPROPRIATE_CONTENT;
            case 3:
                return ReportKind_OTHER;
            case 4:
                return ReportKind_VIOLENCE;
            case 5:
                return ReportKind_SPAM;
            case 6:
                return ReportKind_FALSE_INFORMATION;
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

package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.sg, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC20824sg implements B.c {
    CRMIssueType_UNKNOWN(0),
    CRMIssueType_SIGN_UP(1),
    CRMIssueType_EXPIRED_PAYMENT(2),
    CRMIssueType_CHURNED(3),
    CRMIssueType_CUSTOME(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.sg.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC20824sg a(int i2) {
            return EnumC20824sg.j(i2);
        }
    };
    private final int a;

    EnumC20824sg(int i2) {
        this.a = i2;
    }

    public static EnumC20824sg j(int i2) {
        if (i2 == 0) {
            return CRMIssueType_UNKNOWN;
        }
        if (i2 == 1) {
            return CRMIssueType_SIGN_UP;
        }
        if (i2 == 2) {
            return CRMIssueType_EXPIRED_PAYMENT;
        }
        if (i2 == 3) {
            return CRMIssueType_CHURNED;
        }
        if (i2 != 4) {
            return null;
        }
        return CRMIssueType_CUSTOME;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

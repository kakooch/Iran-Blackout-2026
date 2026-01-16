package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.ng, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC17851ng implements B.c {
    BusinessAdState_AWAITINGAPPROVAL(0),
    BusinessAdState_NOTANSWERED(1),
    BusinessAdState_AWAITINGPAYMENT(2),
    BusinessAdState_DONE(3),
    BusinessAdState_REJECTED(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.ng.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC17851ng a(int i2) {
            return EnumC17851ng.j(i2);
        }
    };
    private final int a;

    EnumC17851ng(int i2) {
        this.a = i2;
    }

    public static EnumC17851ng j(int i2) {
        if (i2 == 0) {
            return BusinessAdState_AWAITINGAPPROVAL;
        }
        if (i2 == 1) {
            return BusinessAdState_NOTANSWERED;
        }
        if (i2 == 2) {
            return BusinessAdState_AWAITINGPAYMENT;
        }
        if (i2 == 3) {
            return BusinessAdState_DONE;
        }
        if (i2 != 4) {
            return null;
        }
        return BusinessAdState_REJECTED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

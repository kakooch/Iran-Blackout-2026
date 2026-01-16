package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Qc2, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC7060Qc2 implements B.c {
    UNKNOWN(0),
    PAYMENT_PENDING(1),
    PAYMENT_DONE(2),
    REFUNDED(3),
    CANCELED(4),
    SUCCESSFUL(5),
    SHOULD_VISIT_BANK(6),
    UNRECOGNIZED(-1);

    private static final B.d j = new B.d() { // from class: ir.nasim.Qc2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC7060Qc2 a(int i) {
            return EnumC7060Qc2.j(i);
        }
    };
    private final int a;

    EnumC7060Qc2(int i) {
        this.a = i;
    }

    public static EnumC7060Qc2 j(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return PAYMENT_PENDING;
            case 2:
                return PAYMENT_DONE;
            case 3:
                return REFUNDED;
            case 4:
                return CANCELED;
            case 5:
                return SUCCESSFUL;
            case 6:
                return SHOULD_VISIT_BANK;
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

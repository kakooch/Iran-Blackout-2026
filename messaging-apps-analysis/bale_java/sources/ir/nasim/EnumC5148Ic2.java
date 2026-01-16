package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Ic2, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC5148Ic2 implements B.c {
    unpaid_stage(0),
    payed(1),
    done(2),
    refunded(3),
    refunded_by_delay(4),
    puya_code_not_received(5),
    payment_had_failed(6),
    payment_start_stage(7),
    UNRECOGNIZED(-1);

    private static final B.d k = new B.d() { // from class: ir.nasim.Ic2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC5148Ic2 a(int i) {
            return EnumC5148Ic2.j(i);
        }
    };
    private final int a;

    EnumC5148Ic2(int i) {
        this.a = i;
    }

    public static EnumC5148Ic2 j(int i) {
        switch (i) {
            case 0:
                return unpaid_stage;
            case 1:
                return payed;
            case 2:
                return done;
            case 3:
                return refunded;
            case 4:
                return refunded_by_delay;
            case 5:
                return puya_code_not_received;
            case 6:
                return payment_had_failed;
            case 7:
                return payment_start_stage;
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

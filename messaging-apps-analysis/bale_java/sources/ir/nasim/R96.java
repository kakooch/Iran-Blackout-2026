package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes.dex */
public enum R96 implements B.c {
    OrderStatus_UNKNOWN(0),
    OrderStatus_FAILED(1),
    OrderStatus_DONE(2),
    OrderStatus_IS_PROCESSING(3),
    OrderStatus_WAIT_FOR_PAYMENT(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.R96.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public R96 a(int i2) {
            return R96.j(i2);
        }
    };
    private final int a;

    R96(int i2) {
        this.a = i2;
    }

    public static R96 j(int i2) {
        if (i2 == 0) {
            return OrderStatus_UNKNOWN;
        }
        if (i2 == 1) {
            return OrderStatus_FAILED;
        }
        if (i2 == 2) {
            return OrderStatus_DONE;
        }
        if (i2 == 3) {
            return OrderStatus_IS_PROCESSING;
        }
        if (i2 != 4) {
            return null;
        }
        return OrderStatus_WAIT_FOR_PAYMENT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

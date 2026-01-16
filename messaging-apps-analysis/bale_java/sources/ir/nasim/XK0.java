package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum XK0 implements B.c {
    OperatorType_UNKNOWN(0),
    OperatorType_MCI(1),
    OperatorType_IRANCELL(2),
    OperatorType_RIGHTEL(3),
    OperatorType_IRANCELL_TD_LTE(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.XK0.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public XK0 a(int i2) {
            return XK0.j(i2);
        }
    };
    private final int a;

    XK0(int i2) {
        this.a = i2;
    }

    public static XK0 j(int i2) {
        if (i2 == 0) {
            return OperatorType_UNKNOWN;
        }
        if (i2 == 1) {
            return OperatorType_MCI;
        }
        if (i2 == 2) {
            return OperatorType_IRANCELL;
        }
        if (i2 == 3) {
            return OperatorType_RIGHTEL;
        }
        if (i2 != 4) {
            return null;
        }
        return OperatorType_IRANCELL_TD_LTE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

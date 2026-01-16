package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.pc4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC18998pc4 implements B.c {
    MoneyRequestType_NORMAL(0),
    MoneyRequestType_BILL(1),
    MoneyRequestType_PAYMENT(2),
    MoneyRequestType_MELLI_LOAN(3),
    MoneyRequestType_WALLET(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.pc4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC18998pc4 a(int i2) {
            return EnumC18998pc4.j(i2);
        }
    };
    private final int a;

    EnumC18998pc4(int i2) {
        this.a = i2;
    }

    public static EnumC18998pc4 j(int i2) {
        if (i2 == 0) {
            return MoneyRequestType_NORMAL;
        }
        if (i2 == 1) {
            return MoneyRequestType_BILL;
        }
        if (i2 == 2) {
            return MoneyRequestType_PAYMENT;
        }
        if (i2 == 3) {
            return MoneyRequestType_MELLI_LOAN;
        }
        if (i2 != 4) {
            return null;
        }
        return MoneyRequestType_WALLET;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

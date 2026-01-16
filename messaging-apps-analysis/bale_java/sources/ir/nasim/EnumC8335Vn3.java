package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Vn3, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC8335Vn3 implements B.c {
    Unknown(0),
    AlreadyPaid(1),
    PaymentInProgress(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.Vn3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC8335Vn3 a(int i) {
            return EnumC8335Vn3.j(i);
        }
    };
    private final int a;

    EnumC8335Vn3(int i) {
        this.a = i;
    }

    public static EnumC8335Vn3 j(int i) {
        if (i == 0) {
            return Unknown;
        }
        if (i == 1) {
            return AlreadyPaid;
        }
        if (i != 2) {
            return null;
        }
        return PaymentInProgress;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

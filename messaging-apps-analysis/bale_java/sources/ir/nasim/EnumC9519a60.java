package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.a60, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC9519a60 implements B.c {
    CardStatement(0),
    LoanPayment(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.a60.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC9519a60 a(int i) {
            return EnumC9519a60.j(i);
        }
    };
    private final int a;

    EnumC9519a60(int i) {
        this.a = i;
    }

    public static EnumC9519a60 j(int i) {
        if (i == 0) {
            return CardStatement;
        }
        if (i != 1) {
            return null;
        }
        return LoanPayment;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

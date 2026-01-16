package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.qn0, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC19695qn0 implements B.c {
    TransactionAction_UNKNOWN(0),
    TransactionAction_DEBIT(1),
    TransactionAction_CREDIT(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.qn0.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC19695qn0 a(int i) {
            return EnumC19695qn0.j(i);
        }
    };
    private final int a;

    EnumC19695qn0(int i) {
        this.a = i;
    }

    public static EnumC19695qn0 j(int i) {
        if (i == 0) {
            return TransactionAction_UNKNOWN;
        }
        if (i == 1) {
            return TransactionAction_DEBIT;
        }
        if (i != 2) {
            return null;
        }
        return TransactionAction_CREDIT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

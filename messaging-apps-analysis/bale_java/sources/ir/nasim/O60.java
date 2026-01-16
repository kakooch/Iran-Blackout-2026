package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum O60 implements B.c {
    BamServiceType_CARD_STATEMENT(0),
    BamServiceType_LOAN_PAYMENT(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.O60.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public O60 a(int i) {
            return O60.j(i);
        }
    };
    private final int a;

    O60(int i) {
        this.a = i;
    }

    public static O60 j(int i) {
        if (i == 0) {
            return BamServiceType_CARD_STATEMENT;
        }
        if (i != 1) {
            return null;
        }
        return BamServiceType_LOAN_PAYMENT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

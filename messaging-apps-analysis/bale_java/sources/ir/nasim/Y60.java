package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum Y60 implements B.c {
    ReactionType_PAYMENT_UNKNOWN(0),
    ReactionType_PAYMENT_COUNT(1),
    ReactionType_PAYMENT_AMOUNT(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.Y60.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Y60 a(int i) {
            return Y60.j(i);
        }
    };
    private final int a;

    Y60(int i) {
        this.a = i;
    }

    public static Y60 j(int i) {
        if (i == 0) {
            return ReactionType_PAYMENT_UNKNOWN;
        }
        if (i == 1) {
            return ReactionType_PAYMENT_COUNT;
        }
        if (i != 2) {
            return null;
        }
        return ReactionType_PAYMENT_AMOUNT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum AI implements B.c {
    ArbaeenDeliveryStationType_UNKNOWN(0),
    ArbaeenDeliveryStationType_AIRPORT(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.AI.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AI a(int i) {
            return AI.j(i);
        }
    };
    private final int a;

    AI(int i) {
        this.a = i;
    }

    public static AI j(int i) {
        if (i == 0) {
            return ArbaeenDeliveryStationType_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return ArbaeenDeliveryStationType_AIRPORT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

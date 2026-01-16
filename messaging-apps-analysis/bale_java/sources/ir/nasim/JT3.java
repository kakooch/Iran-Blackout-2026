package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum JT3 implements B.c {
    MarketJoinRequest_PENDING(0),
    MarketJoinRequest_REJECTED(1),
    MarketJoinRequest_ACCEPTED(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.JT3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public JT3 a(int i) {
            return JT3.j(i);
        }
    };
    private final int a;

    JT3(int i) {
        this.a = i;
    }

    public static JT3 j(int i) {
        if (i == 0) {
            return MarketJoinRequest_PENDING;
        }
        if (i == 1) {
            return MarketJoinRequest_REJECTED;
        }
        if (i != 2) {
            return null;
        }
        return MarketJoinRequest_ACCEPTED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

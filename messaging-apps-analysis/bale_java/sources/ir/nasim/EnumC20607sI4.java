package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.sI4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC20607sI4 implements B.c {
    ExchangingReason_UNKNOWN(0),
    ExchangingReason_AIR_TRAVEL(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.sI4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC20607sI4 a(int i) {
            return EnumC20607sI4.j(i);
        }
    };
    private final int a;

    EnumC20607sI4(int i) {
        this.a = i;
    }

    public static EnumC20607sI4 j(int i) {
        if (i == 0) {
            return ExchangingReason_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return ExchangingReason_AIR_TRAVEL;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

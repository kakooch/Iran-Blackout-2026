package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.vF3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC22446vF3 implements B.c {
    SCD_UNKNOWN(0),
    SCD_INBOUND(1),
    SCD_OUTBOUND(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.vF3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC22446vF3 a(int i) {
            return EnumC22446vF3.j(i);
        }
    };
    private final int a;

    EnumC22446vF3(int i) {
        this.a = i;
    }

    public static EnumC22446vF3 j(int i) {
        if (i == 0) {
            return SCD_UNKNOWN;
        }
        if (i == 1) {
            return SCD_INBOUND;
        }
        if (i != 2) {
            return null;
        }
        return SCD_OUTBOUND;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

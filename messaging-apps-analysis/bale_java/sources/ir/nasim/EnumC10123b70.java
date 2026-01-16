package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.b70, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC10123b70 implements B.c {
    ServiceOperator_UNKNOWN(0),
    ServiceOperator_MCI(1),
    ServiceOperator_IRANCELL(2),
    ServiceOperator_RIGHTEL(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.b70.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC10123b70 a(int i) {
            return EnumC10123b70.j(i);
        }
    };
    private final int a;

    EnumC10123b70(int i) {
        this.a = i;
    }

    public static EnumC10123b70 j(int i) {
        if (i == 0) {
            return ServiceOperator_UNKNOWN;
        }
        if (i == 1) {
            return ServiceOperator_MCI;
        }
        if (i == 2) {
            return ServiceOperator_IRANCELL;
        }
        if (i != 3) {
            return null;
        }
        return ServiceOperator_RIGHTEL;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

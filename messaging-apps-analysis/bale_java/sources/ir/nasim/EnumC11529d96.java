package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.d96, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC11529d96 implements B.c {
    OperatorCode_UNKNOWN(0),
    OperatorCode_MCI(1),
    OperatorCode_IRANCELL(2),
    OperatorCode_RIGHTEL(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.d96.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC11529d96 a(int i) {
            return EnumC11529d96.j(i);
        }
    };
    private final int a;

    EnumC11529d96(int i) {
        this.a = i;
    }

    public static EnumC11529d96 j(int i) {
        if (i == 0) {
            return OperatorCode_UNKNOWN;
        }
        if (i == 1) {
            return OperatorCode_MCI;
        }
        if (i == 2) {
            return OperatorCode_IRANCELL;
        }
        if (i != 3) {
            return null;
        }
        return OperatorCode_RIGHTEL;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

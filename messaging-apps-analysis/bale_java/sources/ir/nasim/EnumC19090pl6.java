package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.pl6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC19090pl6 implements B.c {
    Gender_UNKNOWN(0),
    Gender_MAN(1),
    Gender_WOMAN(2),
    Gender_OTHERS(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.pl6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC19090pl6 a(int i) {
            return EnumC19090pl6.j(i);
        }
    };
    private final int a;

    EnumC19090pl6(int i) {
        this.a = i;
    }

    public static EnumC19090pl6 j(int i) {
        if (i == 0) {
            return Gender_UNKNOWN;
        }
        if (i == 1) {
            return Gender_MAN;
        }
        if (i == 2) {
            return Gender_WOMAN;
        }
        if (i != 3) {
            return null;
        }
        return Gender_OTHERS;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

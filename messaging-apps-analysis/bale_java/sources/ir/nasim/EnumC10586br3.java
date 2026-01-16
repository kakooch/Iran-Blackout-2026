package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.br3, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC10586br3 implements B.c {
    PointChangeOperationType_NULL(0),
    PointChangeOperationType_INCREASE(1),
    PointChangeOperationType_DECREASE(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.br3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC10586br3 a(int i) {
            return EnumC10586br3.j(i);
        }
    };
    private final int a;

    EnumC10586br3(int i) {
        this.a = i;
    }

    public static EnumC10586br3 j(int i) {
        if (i == 0) {
            return PointChangeOperationType_NULL;
        }
        if (i == 1) {
            return PointChangeOperationType_INCREASE;
        }
        if (i != 2) {
            return null;
        }
        return PointChangeOperationType_DECREASE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

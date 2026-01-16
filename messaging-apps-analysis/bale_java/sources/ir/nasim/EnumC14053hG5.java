package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.hG5, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC14053hG5 implements B.c {
    C2C(0),
    Bot(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.hG5.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC14053hG5 a(int i) {
            return EnumC14053hG5.j(i);
        }
    };
    private final int a;

    EnumC14053hG5(int i) {
        this.a = i;
    }

    public static EnumC14053hG5 j(int i) {
        if (i == 0) {
            return C2C;
        }
        if (i != 1) {
            return null;
        }
        return Bot;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

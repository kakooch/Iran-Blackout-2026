package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Fb2, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC4422Fb2 implements B.c {
    UNKNOWN(0),
    Saderat(1),
    Melli(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.Fb2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC4422Fb2 a(int i) {
            return EnumC4422Fb2.j(i);
        }
    };
    private final int a;

    EnumC4422Fb2(int i) {
        this.a = i;
    }

    public static EnumC4422Fb2 j(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return Saderat;
        }
        if (i != 2) {
            return null;
        }
        return Melli;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

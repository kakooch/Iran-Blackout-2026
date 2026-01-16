package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Jn2, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC5481Jn2 implements B.c {
    Colors_RED(0),
    Colors_YELLOW(1),
    Colors_GREEN(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.Jn2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC5481Jn2 a(int i) {
            return EnumC5481Jn2.j(i);
        }
    };
    private final int a;

    EnumC5481Jn2(int i) {
        this.a = i;
    }

    public static EnumC5481Jn2 j(int i) {
        if (i == 0) {
            return Colors_RED;
        }
        if (i == 1) {
            return Colors_YELLOW;
        }
        if (i != 2) {
            return null;
        }
        return Colors_GREEN;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

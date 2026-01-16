package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.vM7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC22513vM7 implements B.c {
    ItemType_SIMPLEITEM(0),
    ItemType_NESTED(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.vM7.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC22513vM7 a(int i) {
            return EnumC22513vM7.j(i);
        }
    };
    private final int a;

    EnumC22513vM7(int i) {
        this.a = i;
    }

    public static EnumC22513vM7 j(int i) {
        if (i == 0) {
            return ItemType_SIMPLEITEM;
        }
        if (i != 1) {
            return null;
        }
        return ItemType_NESTED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

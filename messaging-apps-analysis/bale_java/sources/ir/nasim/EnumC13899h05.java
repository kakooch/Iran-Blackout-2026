package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.h05, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC13899h05 implements B.c {
    NONE(0),
    NATIONAL_CODE(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.h05.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC13899h05 a(int i) {
            return EnumC13899h05.j(i);
        }
    };
    private final int a;

    EnumC13899h05(int i) {
        this.a = i;
    }

    public static EnumC13899h05 j(int i) {
        if (i == 0) {
            return NONE;
        }
        if (i != 1) {
            return null;
        }
        return NATIONAL_CODE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

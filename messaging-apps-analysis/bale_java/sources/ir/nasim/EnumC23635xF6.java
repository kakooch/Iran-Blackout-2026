package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.xF6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public enum EnumC23635xF6 implements B.c {
    Disabled(0),
    Reserved(1),
    Enabled(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.xF6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC23635xF6 a(int i) {
            return EnumC23635xF6.j(i);
        }
    };
    private final int a;

    EnumC23635xF6(int i) {
        this.a = i;
    }

    public static EnumC23635xF6 j(int i) {
        if (i == 0) {
            return Disabled;
        }
        if (i == 1) {
            return Reserved;
        }
        if (i != 2) {
            return null;
        }
        return Enabled;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

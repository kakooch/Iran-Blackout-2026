package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Nn3, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC6422Nn3 implements B.c {
    Pin(0),
    Alert(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.Nn3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC6422Nn3 a(int i) {
            return EnumC6422Nn3.j(i);
        }
    };
    private final int a;

    EnumC6422Nn3(int i) {
        this.a = i;
    }

    public static EnumC6422Nn3 j(int i) {
        if (i == 0) {
            return Pin;
        }
        if (i != 1) {
            return null;
        }
        return Alert;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

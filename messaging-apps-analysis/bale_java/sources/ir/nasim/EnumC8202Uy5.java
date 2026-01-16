package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Uy5, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC8202Uy5 implements B.c {
    GlobalConfigType_UNKNOWN(0),
    GlobalConfigType_USERMUTED(1),
    GlobalConfigType_GROUPMUTED(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.Uy5.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC8202Uy5 a(int i) {
            return EnumC8202Uy5.j(i);
        }
    };
    private final int a;

    EnumC8202Uy5(int i) {
        this.a = i;
    }

    public static EnumC8202Uy5 j(int i) {
        if (i == 0) {
            return GlobalConfigType_UNKNOWN;
        }
        if (i == 1) {
            return GlobalConfigType_USERMUTED;
        }
        if (i != 2) {
            return null;
        }
        return GlobalConfigType_GROUPMUTED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.wI, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC23065wI implements B.c {
    UNKNOWN(0),
    Saderat(1),
    Melli(2),
    Post(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.wI.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC23065wI a(int i) {
            return EnumC23065wI.j(i);
        }
    };
    private final int a;

    EnumC23065wI(int i) {
        this.a = i;
    }

    public static EnumC23065wI j(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return Saderat;
        }
        if (i == 2) {
            return Melli;
        }
        if (i != 3) {
            return null;
        }
        return Post;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

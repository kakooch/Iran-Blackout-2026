package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.yF3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC24222yF3 implements B.c {
    NONE(0),
    KRISP_ENABLED(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.yF3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC24222yF3 a(int i) {
            return EnumC24222yF3.j(i);
        }
    };
    private final int a;

    EnumC24222yF3(int i) {
        this.a = i;
    }

    public static EnumC24222yF3 j(int i) {
        if (i == 0) {
            return NONE;
        }
        if (i != 1) {
            return null;
        }
        return KRISP_ENABLED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

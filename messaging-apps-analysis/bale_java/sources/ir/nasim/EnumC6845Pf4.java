package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Pf4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC6845Pf4 implements B.c {
    ListLoadMode_UNKNOWN(0),
    ListLoadMode_FORWARD(1),
    ListLoadMode_BACKWARD(2),
    ListLoadMode_BOTH(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.Pf4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC6845Pf4 a(int i) {
            return EnumC6845Pf4.j(i);
        }
    };
    private final int a;

    EnumC6845Pf4(int i) {
        this.a = i;
    }

    public static EnumC6845Pf4 j(int i) {
        if (i == 0) {
            return ListLoadMode_UNKNOWN;
        }
        if (i == 1) {
            return ListLoadMode_FORWARD;
        }
        if (i == 2) {
            return ListLoadMode_BACKWARD;
        }
        if (i != 3) {
            return null;
        }
        return ListLoadMode_BOTH;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

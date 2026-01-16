package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.pF3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC18788pF3 implements B.c {
    ACTIVE(0),
    PAUSED(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.pF3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC18788pF3 a(int i) {
            return EnumC18788pF3.j(i);
        }
    };
    private final int a;

    EnumC18788pF3(int i) {
        this.a = i;
    }

    public static EnumC18788pF3 j(int i) {
        if (i == 0) {
            return ACTIVE;
        }
        if (i != 1) {
            return null;
        }
        return PAUSED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

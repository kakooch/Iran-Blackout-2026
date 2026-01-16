package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.fF3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC12833fF3 implements B.c {
    LOW(0),
    MEDIUM(1),
    HIGH(2),
    OFF(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.fF3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC12833fF3 a(int i) {
            return EnumC12833fF3.j(i);
        }
    };
    private final int a;

    EnumC12833fF3(int i) {
        this.a = i;
    }

    public static EnumC12833fF3 j(int i) {
        if (i == 0) {
            return LOW;
        }
        if (i == 1) {
            return MEDIUM;
        }
        if (i == 2) {
            return HIGH;
        }
        if (i != 3) {
            return null;
        }
        return OFF;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

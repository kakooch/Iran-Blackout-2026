package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.vE3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC22437vE3 implements B.c {
    INDEX(0),
    TIMESTAMP(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.vE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC22437vE3 a(int i) {
            return EnumC22437vE3.j(i);
        }
    };
    private final int a;

    EnumC22437vE3(int i) {
        this.a = i;
    }

    public static EnumC22437vE3 j(int i) {
        if (i == 0) {
            return INDEX;
        }
        if (i != 1) {
            return null;
        }
        return TIMESTAMP;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

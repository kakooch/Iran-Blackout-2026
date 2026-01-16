package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.bF3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC10201bF3 implements B.c {
    AUDIO(0),
    VIDEO(1),
    DATA(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.bF3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC10201bF3 a(int i) {
            return EnumC10201bF3.j(i);
        }
    };
    private final int a;

    EnumC10201bF3(int i) {
        this.a = i;
    }

    public static EnumC10201bF3 j(int i) {
        if (i == 0) {
            return AUDIO;
        }
        if (i == 1) {
            return VIDEO;
        }
        if (i != 2) {
            return null;
        }
        return DATA;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

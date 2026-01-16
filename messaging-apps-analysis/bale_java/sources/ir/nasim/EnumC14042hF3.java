package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.hF3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC14042hF3 implements B.c {
    UDP(0),
    TCP(1),
    TLS(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.hF3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC14042hF3 a(int i) {
            return EnumC14042hF3.j(i);
        }
    };
    private final int a;

    EnumC14042hF3(int i) {
        this.a = i;
    }

    public static EnumC14042hF3 j(int i) {
        if (i == 0) {
            return UDP;
        }
        if (i == 1) {
            return TCP;
        }
        if (i != 2) {
            return null;
        }
        return TLS;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

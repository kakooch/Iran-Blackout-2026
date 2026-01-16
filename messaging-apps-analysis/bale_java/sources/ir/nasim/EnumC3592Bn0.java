package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Bn0, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC3592Bn0 implements B.c {
    RequestType_UNKNOWN(0),
    RequestType_SAFIR(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.Bn0.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC3592Bn0 a(int i) {
            return EnumC3592Bn0.j(i);
        }
    };
    private final int a;

    EnumC3592Bn0(int i) {
        this.a = i;
    }

    public static EnumC3592Bn0 j(int i) {
        if (i == 0) {
            return RequestType_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return RequestType_SAFIR;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

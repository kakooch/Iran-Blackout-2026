package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Rc1, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC7293Rc1 implements B.c {
    EndpointType_TLS(0),
    EndpointType_TCP(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.Rc1.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC7293Rc1 a(int i) {
            return EnumC7293Rc1.j(i);
        }
    };
    private final int a;

    EnumC7293Rc1(int i) {
        this.a = i;
    }

    public static EnumC7293Rc1 j(int i) {
        if (i == 0) {
            return EndpointType_TLS;
        }
        if (i != 1) {
            return null;
        }
        return EndpointType_TCP;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

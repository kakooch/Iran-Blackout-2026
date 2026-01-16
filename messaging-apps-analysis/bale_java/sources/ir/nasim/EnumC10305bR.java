package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.bR, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC10305bR implements B.c {
    PhoneActivationType_CODE(0),
    PhoneActivationType_PASSWORD(1),
    PhoneActivationType_FUTURE_AUTH_TOKEN(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.bR.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC10305bR a(int i) {
            return EnumC10305bR.j(i);
        }
    };
    private final int a;

    EnumC10305bR(int i) {
        this.a = i;
    }

    public static EnumC10305bR j(int i) {
        if (i == 0) {
            return PhoneActivationType_CODE;
        }
        if (i == 1) {
            return PhoneActivationType_PASSWORD;
        }
        if (i != 2) {
            return null;
        }
        return PhoneActivationType_FUTURE_AUTH_TOKEN;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

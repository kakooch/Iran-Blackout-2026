package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Zg, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC9277Zg implements B.c {
    CustomerType_B2CUSTOMER(0),
    CustomerType_B2BUSINESS(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.Zg.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC9277Zg a(int i) {
            return EnumC9277Zg.j(i);
        }
    };
    private final int a;

    EnumC9277Zg(int i) {
        this.a = i;
    }

    public static EnumC9277Zg j(int i) {
        if (i == 0) {
            return CustomerType_B2CUSTOMER;
        }
        if (i != 1) {
            return null;
        }
        return CustomerType_B2BUSINESS;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

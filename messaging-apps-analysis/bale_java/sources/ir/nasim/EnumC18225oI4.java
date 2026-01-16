package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.oI4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC18225oI4 implements B.c {
    DeliveryStationType_UNKNOWN(0),
    DeliveryStationType_AIRPORT(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.oI4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC18225oI4 a(int i) {
            return EnumC18225oI4.j(i);
        }
    };
    private final int a;

    EnumC18225oI4(int i) {
        this.a = i;
    }

    public static EnumC18225oI4 j(int i) {
        if (i == 0) {
            return DeliveryStationType_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return DeliveryStationType_AIRPORT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

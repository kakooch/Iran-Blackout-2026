package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.tT3, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC21325tT3 implements B.c {
    CategoryItemsType_PRODUCT_ONLY(0),
    CategoryItemsType_MARKET_ONLY(1),
    CategoryItemsType_FOR_YOU_PRODUCT_ONLY(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.tT3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC21325tT3 a(int i) {
            return EnumC21325tT3.j(i);
        }
    };
    private final int a;

    EnumC21325tT3(int i) {
        this.a = i;
    }

    public static EnumC21325tT3 j(int i) {
        if (i == 0) {
            return CategoryItemsType_PRODUCT_ONLY;
        }
        if (i == 1) {
            return CategoryItemsType_MARKET_ONLY;
        }
        if (i != 2) {
            return null;
        }
        return CategoryItemsType_FOR_YOU_PRODUCT_ONLY;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

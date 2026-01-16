package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.vM4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC22510vM4 implements B.c {
    PackageItem_UNKNOWN(0),
    PackageItem_GROUP_JOIN(1),
    PackageItem_ORGANIZATIONAL_CONTACT(2),
    PackageItem_FILE_SEARCH(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.vM4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC22510vM4 a(int i) {
            return EnumC22510vM4.j(i);
        }
    };
    private final int a;

    EnumC22510vM4(int i) {
        this.a = i;
    }

    public static EnumC22510vM4 j(int i) {
        if (i == 0) {
            return PackageItem_UNKNOWN;
        }
        if (i == 1) {
            return PackageItem_GROUP_JOIN;
        }
        if (i == 2) {
            return PackageItem_ORGANIZATIONAL_CONTACT;
        }
        if (i != 3) {
            return null;
        }
        return PackageItem_FILE_SEARCH;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

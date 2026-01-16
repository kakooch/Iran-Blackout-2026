package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Uf, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC8025Uf implements B.c {
    AdvertisementType_NONE(0),
    AdvertisementType_BANNER(1),
    AdvertisementType_NATIVE(2),
    AdvertisementType_BANNER_AND_NATIVE(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.Uf.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC8025Uf a(int i) {
            return EnumC8025Uf.j(i);
        }
    };
    private final int a;

    EnumC8025Uf(int i) {
        this.a = i;
    }

    public static EnumC8025Uf j(int i) {
        if (i == 0) {
            return AdvertisementType_NONE;
        }
        if (i == 1) {
            return AdvertisementType_BANNER;
        }
        if (i == 2) {
            return AdvertisementType_NATIVE;
        }
        if (i != 3) {
            return null;
        }
        return AdvertisementType_BANNER_AND_NATIVE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

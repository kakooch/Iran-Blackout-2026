package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.yg, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC24467yg implements B.c {
    CampaignPackageType_NOPACKAGE(0),
    CampaignPackageType_BASIC(1),
    CampaignPackageType_ADVANCED(2),
    CampaignPackageType_BUSINESS(3),
    CampaignPackageType_CUSTOME(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.yg.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC24467yg a(int i2) {
            return EnumC24467yg.j(i2);
        }
    };
    private final int a;

    EnumC24467yg(int i2) {
        this.a = i2;
    }

    public static EnumC24467yg j(int i2) {
        if (i2 == 0) {
            return CampaignPackageType_NOPACKAGE;
        }
        if (i2 == 1) {
            return CampaignPackageType_BASIC;
        }
        if (i2 == 2) {
            return CampaignPackageType_ADVANCED;
        }
        if (i2 == 3) {
            return CampaignPackageType_BUSINESS;
        }
        if (i2 != 4) {
            return null;
        }
        return CampaignPackageType_CUSTOME;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

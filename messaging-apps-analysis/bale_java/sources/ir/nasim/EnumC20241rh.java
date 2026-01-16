package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.rh, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC20241rh implements B.c {
    OnboardingCategory_UNKNOWN(0),
    OnboardingCategory_COCKING(1),
    OnboardingCategory_SPORT(2),
    OnboardingCategory_PARENTING(3),
    OnboardingCategory_ART(4),
    OnboardingCategory_NEWS(5),
    OnboardingCategory_EDUCATION(6),
    OnboardingCategory_CULTURE(7),
    OnboardingCategory_MOVIE(8),
    OnboardingCategory_MUSIC(9),
    OnboardingCategory_SCIENCE(10),
    OnboardingCategory_PHOTO(11),
    OnboardingCategory_FUN(12),
    OnboardingCategory_CHARITY(13),
    OnboardingCategory_TOURISM(14),
    OnboardingCategory_RELIGION(15),
    OnboardingCategory_PSYCHOLOGY(16),
    OnboardingCategory_LITERATURE(17),
    OnboardingCategory_HEALTH(18),
    OnboardingCategory_INFO(19),
    OnboardingCategory_DAILY(20),
    OnboardingCategory_ECON(21),
    UNRECOGNIZED(-1);

    private static final B.d y = new B.d() { // from class: ir.nasim.rh.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC20241rh a(int i) {
            return EnumC20241rh.j(i);
        }
    };
    private final int a;

    EnumC20241rh(int i) {
        this.a = i;
    }

    public static EnumC20241rh j(int i) {
        switch (i) {
            case 0:
                return OnboardingCategory_UNKNOWN;
            case 1:
                return OnboardingCategory_COCKING;
            case 2:
                return OnboardingCategory_SPORT;
            case 3:
                return OnboardingCategory_PARENTING;
            case 4:
                return OnboardingCategory_ART;
            case 5:
                return OnboardingCategory_NEWS;
            case 6:
                return OnboardingCategory_EDUCATION;
            case 7:
                return OnboardingCategory_CULTURE;
            case 8:
                return OnboardingCategory_MOVIE;
            case 9:
                return OnboardingCategory_MUSIC;
            case 10:
                return OnboardingCategory_SCIENCE;
            case 11:
                return OnboardingCategory_PHOTO;
            case 12:
                return OnboardingCategory_FUN;
            case 13:
                return OnboardingCategory_CHARITY;
            case 14:
                return OnboardingCategory_TOURISM;
            case 15:
                return OnboardingCategory_RELIGION;
            case 16:
                return OnboardingCategory_PSYCHOLOGY;
            case 17:
                return OnboardingCategory_LITERATURE;
            case 18:
                return OnboardingCategory_HEALTH;
            case 19:
                return OnboardingCategory_INFO;
            case 20:
                return OnboardingCategory_DAILY;
            case 21:
                return OnboardingCategory_ECON;
            default:
                return null;
        }
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

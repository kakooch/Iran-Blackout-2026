package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.qh, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC19634qh implements B.c {
    OnBoardingScenario_UNKNOWN(0),
    OnBoardingScenario_ATLOGIN(1),
    OnBoardingScenario_ONBOARDING(2),
    OnBoardingScenario_CONTACTS(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.qh.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC19634qh a(int i) {
            return EnumC19634qh.j(i);
        }
    };
    private final int a;

    EnumC19634qh(int i) {
        this.a = i;
    }

    public static EnumC19634qh j(int i) {
        if (i == 0) {
            return OnBoardingScenario_UNKNOWN;
        }
        if (i == 1) {
            return OnBoardingScenario_ATLOGIN;
        }
        if (i == 2) {
            return OnBoardingScenario_ONBOARDING;
        }
        if (i != 3) {
            return null;
        }
        return OnBoardingScenario_CONTACTS;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

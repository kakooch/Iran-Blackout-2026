package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.wh, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC23297wh implements B.c {
    OnboardingSpot_UNKNOWN(0),
    OnboardingSpot_SIGNUP(1),
    OnboardingSpot_DIALOGBANNER(2),
    OnboardingSpot_INTERACTIVEDIALOGBANNER(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.wh.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC23297wh a(int i) {
            return EnumC23297wh.j(i);
        }
    };
    private final int a;

    EnumC23297wh(int i) {
        this.a = i;
    }

    public static EnumC23297wh j(int i) {
        if (i == 0) {
            return OnboardingSpot_UNKNOWN;
        }
        if (i == 1) {
            return OnboardingSpot_SIGNUP;
        }
        if (i == 2) {
            return OnboardingSpot_DIALOGBANNER;
        }
        if (i != 3) {
            return null;
        }
        return OnboardingSpot_INTERACTIVEDIALOGBANNER;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

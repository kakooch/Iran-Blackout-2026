package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum UT3 implements B.c {
    OnboardingStatus_InComplete(0),
    OnboardingStatus_Complete(1),
    OnboardingStatus_Skipped(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.UT3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public UT3 a(int i) {
            return UT3.j(i);
        }
    };
    private final int a;

    UT3(int i) {
        this.a = i;
    }

    public static UT3 j(int i) {
        if (i == 0) {
            return OnboardingStatus_InComplete;
        }
        if (i == 1) {
            return OnboardingStatus_Complete;
        }
        if (i != 2) {
            return null;
        }
        return OnboardingStatus_Skipped;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

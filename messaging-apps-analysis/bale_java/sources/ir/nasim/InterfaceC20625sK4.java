package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.features.onboarding.data.model.OnboardingBannerType;
import ir.nasim.features.onboarding.data.model.OnboardingSpot;

/* renamed from: ir.nasim.sK4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC20625sK4 {

    /* renamed from: ir.nasim.sK4$a */
    public static final class a implements InterfaceC20625sK4 {
        public static final a a = new a();

        private a() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 517682626;
        }

        public String toString() {
            return "Disabled";
        }
    }

    /* renamed from: ir.nasim.sK4$c */
    public static final class c implements InterfaceC20625sK4 {
        public static final c a = new c();

        private c() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -897397222;
        }

        public String toString() {
            return "Idle";
        }
    }

    /* renamed from: ir.nasim.sK4$b */
    public static final class b implements InterfaceC20625sK4 {
        public static final a e = new a(null);
        private static boolean f = true;
        private final int a;
        private final String b;
        private final OnboardingBannerType c;
        private final OnboardingSpot d;

        /* renamed from: ir.nasim.sK4$b$a */
        public static final class a {
            private a() {
            }

            public final boolean a() {
                return b.f;
            }

            public final void b(boolean z) {
                b.f = z;
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        public b(int i, String str, OnboardingBannerType onboardingBannerType, OnboardingSpot onboardingSpot) {
            AbstractC13042fc3.i(str, "bannerUrl");
            AbstractC13042fc3.i(onboardingBannerType, "bannerType");
            AbstractC13042fc3.i(onboardingSpot, "onboardingSpot");
            this.a = i;
            this.b = str;
            this.c = onboardingBannerType;
            this.d = onboardingSpot;
        }

        public final OnboardingBannerType c() {
            return this.c;
        }

        public final String d() {
            return this.b;
        }

        public final int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && AbstractC13042fc3.d(this.b, bVar.b) && AbstractC13042fc3.d(this.c, bVar.c) && AbstractC13042fc3.d(this.d, bVar.d);
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "Enabled(scenarioId=" + this.a + ", bannerUrl=" + this.b + ", bannerType=" + this.c + ", onboardingSpot=" + this.d + Separators.RPAREN;
        }

        public /* synthetic */ b(int i, String str, OnboardingBannerType onboardingBannerType, OnboardingSpot onboardingSpot, int i2, ED1 ed1) {
            this(i, str, (i2 & 4) != 0 ? OnboardingBannerType.ImageCard.b : onboardingBannerType, (i2 & 8) != 0 ? OnboardingSpot.DialogBanner.a : onboardingSpot);
        }
    }
}

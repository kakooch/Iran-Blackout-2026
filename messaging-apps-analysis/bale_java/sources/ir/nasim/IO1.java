package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public interface IO1 {

    public static final class a implements IO1 {
        private final AbstractC23684xL1 a;

        public a(AbstractC23684xL1 abstractC23684xL1) {
            AbstractC13042fc3.i(abstractC23684xL1, "adUiAction");
            this.a = abstractC23684xL1;
        }

        public final AbstractC23684xL1 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "AdvertisementAction(adUiAction=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b implements IO1 {
        private final InterfaceC18834pK4 a;

        public b(InterfaceC18834pK4 interfaceC18834pK4) {
            AbstractC13042fc3.i(interfaceC18834pK4, "bannerAction");
            this.a = interfaceC18834pK4;
        }

        public final InterfaceC18834pK4 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "OnboardingBannerAction(bannerAction=" + this.a + Separators.RPAREN;
        }
    }
}

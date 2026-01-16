package ir.nasim;

import android.graphics.ColorSpace;
import coil.memory.MemoryCache;

/* loaded from: classes2.dex */
public abstract class U92 {
    private static final T92 a = new a();

    public static final class a implements T92 {
        a() {
        }

        @Override // ir.nasim.T92
        public int b(Object obj) {
            if (!(obj instanceof W23)) {
                if (obj != null) {
                    return obj.hashCode();
                }
                return 0;
            }
            W23 w23 = (W23) obj;
            int iHashCode = ((w23.l().hashCode() * 31) + w23.m().hashCode()) * 31;
            MemoryCache.Key keyG = w23.G();
            int iHashCode2 = (iHashCode + (keyG != null ? keyG.hashCode() : 0)) * 31;
            MemoryCache.Key keyB = w23.B();
            int iHashCode3 = (iHashCode2 + (keyB != null ? keyB.hashCode() : 0)) * 31;
            String strR = w23.r();
            int iHashCode4 = (((iHashCode3 + (strR != null ? strR.hashCode() : 0)) * 31) + w23.j().hashCode()) * 31;
            ColorSpace colorSpaceK = w23.k();
            return ((((((((((((((((((((((((((iHashCode4 + (colorSpaceK != null ? colorSpaceK.hashCode() : 0)) * 31) + w23.O().hashCode()) * 31) + w23.x().hashCode()) * 31) + Boolean.hashCode(w23.g())) * 31) + Boolean.hashCode(w23.h())) * 31) + Boolean.hashCode(w23.i())) * 31) + Boolean.hashCode(w23.I())) * 31) + w23.C().hashCode()) * 31) + w23.s().hashCode()) * 31) + w23.D().hashCode()) * 31) + w23.K().hashCode()) * 31) + w23.J().hashCode()) * 31) + w23.H().hashCode()) * 31) + w23.E().hashCode();
        }

        @Override // ir.nasim.T92
        public boolean c(Object obj, Object obj2) {
            if (obj == obj2) {
                return true;
            }
            if (!(obj instanceof W23) || !(obj2 instanceof W23)) {
                return AbstractC13042fc3.d(obj, obj2);
            }
            W23 w23 = (W23) obj;
            W23 w232 = (W23) obj2;
            return AbstractC13042fc3.d(w23.l(), w232.l()) && AbstractC13042fc3.d(w23.m(), w232.m()) && AbstractC13042fc3.d(w23.G(), w232.G()) && AbstractC13042fc3.d(w23.B(), w232.B()) && AbstractC13042fc3.d(w23.r(), w232.r()) && w23.j() == w232.j() && AbstractC13042fc3.d(w23.k(), w232.k()) && AbstractC13042fc3.d(w23.O(), w232.O()) && AbstractC13042fc3.d(w23.x(), w232.x()) && w23.g() == w232.g() && w23.h() == w232.h() && w23.i() == w232.i() && w23.I() == w232.I() && w23.C() == w232.C() && w23.s() == w232.s() && w23.D() == w232.D() && AbstractC13042fc3.d(w23.K(), w232.K()) && w23.J() == w232.J() && w23.H() == w232.H() && AbstractC13042fc3.d(w23.E(), w232.E());
        }
    }

    public static final T92 a() {
        return a;
    }
}

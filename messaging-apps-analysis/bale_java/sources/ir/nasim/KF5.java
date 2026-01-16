package ir.nasim;

import android.graphics.Shader;
import java.util.List;

/* loaded from: classes2.dex */
public final class KF5 extends AbstractC4147Dw6 {
    private final List e;
    private final List f;
    private final long g;
    private final float h;
    private final int i;

    public /* synthetic */ KF5(List list, List list2, long j, float f, int i, ED1 ed1) {
        this(list, list2, j, f, i);
    }

    @Override // ir.nasim.AbstractC4147Dw6
    public Shader b(long j) {
        float fIntBitsToFloat;
        float fIntBitsToFloat2;
        long j2 = this.g;
        if ((9223372034707292159L & j2) == 9205357640488583168L) {
            long jB = UD6.b(j);
            fIntBitsToFloat = Float.intBitsToFloat((int) (jB >> 32));
            fIntBitsToFloat2 = Float.intBitsToFloat((int) (jB & 4294967295L));
        } else {
            fIntBitsToFloat = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (j2 >> 32)) == Float.POSITIVE_INFINITY ? j >> 32 : this.g >> 32));
            fIntBitsToFloat2 = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (this.g & 4294967295L)) == Float.POSITIVE_INFINITY ? j & 4294967295L : this.g & 4294967295L));
        }
        List list = this.e;
        List list2 = this.f;
        long jE = ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (4294967295L & Float.floatToRawIntBits(fIntBitsToFloat2)));
        float f = this.h;
        return AbstractC4615Fw6.b(jE, f == Float.POSITIVE_INFINITY ? OD6.h(j) / 2 : f, list, list2, this.i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KF5)) {
            return false;
        }
        KF5 kf5 = (KF5) obj;
        return AbstractC13042fc3.d(this.e, kf5.e) && AbstractC13042fc3.d(this.f, kf5.f) && ZG4.j(this.g, kf5.g) && this.h == kf5.h && AbstractC4553Fp7.f(this.i, kf5.i);
    }

    public int hashCode() {
        int iHashCode = this.e.hashCode() * 31;
        List list = this.f;
        return ((((((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + ZG4.o(this.g)) * 31) + Float.hashCode(this.h)) * 31) + AbstractC4553Fp7.g(this.i);
    }

    public String toString() {
        String str;
        String str2 = "";
        if ((this.g & 9223372034707292159L) != 9205357640488583168L) {
            str = "center=" + ((Object) ZG4.s(this.g)) + ", ";
        } else {
            str = "";
        }
        if ((Float.floatToRawIntBits(this.h) & Integer.MAX_VALUE) < 2139095040) {
            str2 = "radius=" + this.h + ", ";
        }
        return "RadialGradient(colors=" + this.e + ", stops=" + this.f + ", " + str + str2 + "tileMode=" + ((Object) AbstractC4553Fp7.h(this.i)) + ')';
    }

    private KF5(List list, List list2, long j, float f, int i) {
        this.e = list;
        this.f = list2;
        this.g = j;
        this.h = f;
        this.i = i;
    }
}

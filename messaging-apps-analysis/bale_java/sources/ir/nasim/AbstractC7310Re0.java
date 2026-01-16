package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Re0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC7310Re0 {
    public static final a f = new a(null);
    private final int[] a;
    private final int b;
    private final int c;
    private final int d;
    private final List e;

    /* renamed from: ir.nasim.Re0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public AbstractC7310Re0(int... iArr) {
        AbstractC13042fc3.i(iArr, "numbers");
        this.a = iArr;
        Integer numM0 = AbstractC10242bK.m0(iArr, 0);
        this.b = numM0 == null ? -1 : numM0.intValue();
        Integer numM02 = AbstractC10242bK.m0(iArr, 1);
        this.c = numM02 == null ? -1 : numM02.intValue();
        Integer numM03 = AbstractC10242bK.m0(iArr, 2);
        this.d = numM03 != null ? numM03.intValue() : -1;
        this.e = iArr.length > 3 ? AbstractC15401jX0.m1(AbstractC9648aK.c(iArr).subList(3, iArr.length)) : AbstractC10360bX0.m();
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final boolean c(int i, int i2, int i3) {
        int i4 = this.b;
        if (i4 > i) {
            return true;
        }
        if (i4 < i) {
            return false;
        }
        int i5 = this.c;
        if (i5 > i2) {
            return true;
        }
        return i5 >= i2 && this.d >= i3;
    }

    public final boolean d(AbstractC7310Re0 abstractC7310Re0) {
        AbstractC13042fc3.i(abstractC7310Re0, ParameterNames.VERSION);
        return c(abstractC7310Re0.b, abstractC7310Re0.c, abstractC7310Re0.d);
    }

    public final boolean e(int i, int i2, int i3) {
        int i4 = this.b;
        if (i4 < i) {
            return true;
        }
        if (i4 > i) {
            return false;
        }
        int i5 = this.c;
        if (i5 < i2) {
            return true;
        }
        return i5 <= i2 && this.d <= i3;
    }

    public boolean equals(Object obj) {
        if (obj != null && AbstractC13042fc3.d(getClass(), obj.getClass())) {
            AbstractC7310Re0 abstractC7310Re0 = (AbstractC7310Re0) obj;
            if (this.b == abstractC7310Re0.b && this.c == abstractC7310Re0.c && this.d == abstractC7310Re0.d && AbstractC13042fc3.d(this.e, abstractC7310Re0.e)) {
                return true;
            }
        }
        return false;
    }

    protected final boolean f(AbstractC7310Re0 abstractC7310Re0) {
        AbstractC13042fc3.i(abstractC7310Re0, "ourVersion");
        int i = this.b;
        if (i == 0) {
            if (abstractC7310Re0.b != 0 || this.c != abstractC7310Re0.c) {
                return false;
            }
        } else if (i != abstractC7310Re0.b || this.c > abstractC7310Re0.c) {
            return false;
        }
        return true;
    }

    public final int[] g() {
        return this.a;
    }

    public int hashCode() {
        int i = this.b;
        int i2 = i + (i * 31) + this.c;
        int i3 = i2 + (i2 * 31) + this.d;
        return i3 + (i3 * 31) + this.e.hashCode();
    }

    public String toString() {
        int[] iArrG = g();
        ArrayList arrayList = new ArrayList();
        for (int i : iArrG) {
            if (i == -1) {
                break;
            }
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList.isEmpty() ? CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE : AbstractC15401jX0.A0(arrayList, Separators.DOT, null, null, 0, null, null, 62, null);
    }
}

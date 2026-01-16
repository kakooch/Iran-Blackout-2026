package ir.nasim;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.UK6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Zd1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC9252Zd1 {
    private int b;
    private final List a = new ArrayList();
    private final int c = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
    private int d = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;

    /* renamed from: ir.nasim.Zd1$a */
    public static final class a {
        private final Object a;

        public a(Object obj) {
            AbstractC13042fc3.i(obj, "id");
            this.a = obj;
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
            return "BaselineAnchor(id=" + this.a + ')';
        }
    }

    /* renamed from: ir.nasim.Zd1$b */
    public static final class b {
        private final Object a;
        private final int b;

        public b(Object obj, int i) {
            AbstractC13042fc3.i(obj, "id");
            this.a = obj;
            this.b = i;
        }

        public final Object a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && this.b == bVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "HorizontalAnchor(id=" + this.a + ", index=" + this.b + ')';
        }
    }

    /* renamed from: ir.nasim.Zd1$c */
    public static final class c {
        private final Object a;
        private final int b;

        public c(Object obj, int i) {
            AbstractC13042fc3.i(obj, "id");
            this.a = obj;
            this.b = i;
        }

        public final Object a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.a, cVar.a) && this.b == cVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "VerticalAnchor(id=" + this.a + ", index=" + this.b + ')';
        }
    }

    /* renamed from: ir.nasim.Zd1$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int e;
        final /* synthetic */ float f;
        final /* synthetic */ C7773Td1[] g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(int i, float f, C7773Td1[] c7773Td1Arr) {
            super(1);
            this.e = i;
            this.f = f;
            this.g = c7773Td1Arr;
        }

        public final void a(TK6 tk6) {
            AbstractC13042fc3.i(tk6, "state");
            C12166e90 c12166e90B = tk6.b(Integer.valueOf(this.e), UK6.d.BOTTOM);
            C7773Td1[] c7773Td1Arr = this.g;
            ArrayList arrayList = new ArrayList(c7773Td1Arr.length);
            for (C7773Td1 c7773Td1 : c7773Td1Arr) {
                arrayList.add(c7773Td1.c());
            }
            Object[] array = arrayList.toArray(new Object[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            c12166e90B.W(Arrays.copyOf(array, array.length));
            c12166e90B.A(tk6.d(C17784nZ1.j(this.f)));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((TK6) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zd1$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int e;
        final /* synthetic */ C7773Td1[] f;
        final /* synthetic */ C14066hI0 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(int i, C7773Td1[] c7773Td1Arr, C14066hI0 c14066hI0) {
            super(1);
            this.e = i;
            this.f = c7773Td1Arr;
            this.g = c14066hI0;
        }

        public final void a(TK6 tk6) {
            AbstractC13042fc3.i(tk6, "state");
            C17749nV2 c17749nV2H = tk6.h(Integer.valueOf(this.e), UK6.e.HORIZONTAL_CHAIN);
            if (c17749nV2H == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.core.state.helpers.HorizontalChainReference");
            }
            JY2 jy2 = (JY2) c17749nV2H;
            C7773Td1[] c7773Td1Arr = this.f;
            ArrayList arrayList = new ArrayList(c7773Td1Arr.length);
            for (C7773Td1 c7773Td1 : c7773Td1Arr) {
                arrayList.add(c7773Td1.c());
            }
            Object[] array = arrayList.toArray(new Object[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            jy2.W(Arrays.copyOf(array, array.length));
            jy2.Y(this.g.b());
            jy2.apply();
            if (this.g.a() != null) {
                tk6.c(this.f[0].c()).w(this.g.a().floatValue());
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((TK6) obj);
            return C19938rB7.a;
        }
    }

    public static /* synthetic */ b c(AbstractC9252Zd1 abstractC9252Zd1, C7773Td1[] c7773Td1Arr, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createBottomBarrier-3ABfNKs");
        }
        if ((i & 2) != 0) {
            f = C17784nZ1.q(0);
        }
        return abstractC9252Zd1.b(c7773Td1Arr, f);
    }

    private final int d() {
        int i = this.d;
        this.d = i + 1;
        return i;
    }

    private final void h(int i) {
        this.b = ((this.b * 1009) + i) % 1000000007;
    }

    public final void a(TK6 tk6) {
        AbstractC13042fc3.i(tk6, "state");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((UA2) it.next()).invoke(tk6);
        }
    }

    public final b b(C7773Td1[] c7773Td1Arr, float f) {
        AbstractC13042fc3.i(c7773Td1Arr, "elements");
        int iD = d();
        this.a.add(new d(iD, f, c7773Td1Arr));
        h(15);
        for (C7773Td1 c7773Td1 : c7773Td1Arr) {
            h(c7773Td1.hashCode());
        }
        h(C17784nZ1.t(f));
        return new b(Integer.valueOf(iD), 0);
    }

    public final KY2 e(C7773Td1[] c7773Td1Arr, C14066hI0 c14066hI0) {
        AbstractC13042fc3.i(c7773Td1Arr, "elements");
        AbstractC13042fc3.i(c14066hI0, "chainStyle");
        int iD = d();
        this.a.add(new e(iD, c7773Td1Arr, c14066hI0));
        h(16);
        for (C7773Td1 c7773Td1 : c7773Td1Arr) {
            h(c7773Td1.hashCode());
        }
        h(c14066hI0.hashCode());
        return new KY2(Integer.valueOf(iD));
    }

    public final int f() {
        return this.b;
    }

    public void g() {
        this.a.clear();
        this.d = this.c;
        this.b = 0;
    }
}

package ir.nasim;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.hj7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14325hj7 extends RecyclerView.y {
    public static final a r = new a(null);
    public static final int s = 8;
    private final c i;
    private final float j;
    private b k;
    private final LinearInterpolator l;
    private final DecelerateInterpolator m;
    private final float n;
    private int o;
    private int p;
    private int q;

    /* renamed from: ir.nasim.hj7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.hj7$b */
    public interface b {
        void a();

        void b();

        void f();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.hj7$c */
    public static final class c {
        public static final a a;
        public static final c b = new c("START", 0);
        public static final c c = new c("MIDDLE", 1);
        public static final c d = new c("END", 2);
        public static final c e = new c("NO_GRAVITY", 3);
        private static final /* synthetic */ c[] f;
        private static final /* synthetic */ F92 g;

        /* renamed from: ir.nasim.hj7$c$a */
        public static final class a {

            /* renamed from: ir.nasim.hj7$c$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C1272a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[c.values().length];
                    try {
                        iArr[c.b.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[c.c.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[c.e.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[c.d.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    a = iArr;
                }
            }

            private a() {
            }

            public final c a(c cVar, int i) {
                AbstractC13042fc3.i(cVar, "<this>");
                int i2 = C1272a.a[cVar.ordinal()];
                if (i2 == 1) {
                    return i == 1 ? c.d : c.b;
                }
                if (i2 == 2) {
                    return c.c;
                }
                if (i2 == 3) {
                    return c.e;
                }
                if (i2 == 4) {
                    return i == 1 ? c.b : c.d;
                }
                throw new NoWhenBranchMatchedException();
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        static {
            c[] cVarArrA = a();
            f = cVarArrA;
            g = G92.a(cVarArrA);
            a = new a(null);
        }

        private c(String str, int i) {
        }

        private static final /* synthetic */ c[] a() {
            return new c[]{b, c, d, e};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f.clone();
        }
    }

    /* renamed from: ir.nasim.hj7$d */
    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            try {
                iArr[c.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[c.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[c.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[c.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    public /* synthetic */ C14325hj7(Context context, c cVar, float f, int i, ED1 ed1) {
        this(context, cVar, (i & 4) != 0 ? 1.0f : f);
    }

    private final int s(View view) {
        RecyclerView.p pVarE = e();
        if (pVarE == null || !pVarE.l()) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        int iR = pVarE.R(view) - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
        int iU = pVarE.U(view) + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
        int i = iU - iR;
        int iF0 = pVarE.f0();
        int iP0 = pVarE.p0() - pVarE.g0();
        int i2 = iP0 - iF0;
        int i3 = d.a[c.a.a(this.i, pVarE.a0()).ordinal()];
        if (i3 == 1) {
            return ((iF0 + this.q) - iR) - iR;
        }
        if (i3 == 2) {
            return ((i2 - i) / 2) - iR;
        }
        if (i3 == 3) {
            return ((iP0 - this.q) - i) - iR;
        }
        if (i3 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        int i4 = this.q;
        if (iR > iF0 + i4 && iU < iP0 - i4) {
            return 0;
        }
        int i5 = (iF0 + i4) - iR;
        int i6 = ((iP0 - i4) - i) - iR;
        return Math.abs(i5) < Math.abs(i6) ? i5 : i6;
    }

    private final int t(int i) {
        return (int) Math.ceil(u(i) / 0.3356d);
    }

    private final int u(int i) {
        return (int) Math.ceil(Math.abs(i) * this.n);
    }

    private final int v(int i, int i2) {
        if ((i - i2) * i <= 0) {
            return 0;
        }
        return i;
    }

    private final void w() {
        b bVar = this.k;
        if (bVar != null) {
            bVar.a();
        }
    }

    private final void z(RecyclerView.y.a aVar) {
        PointF pointFA = a(f());
        if (pointFA == null || (pointFA.x == 0.0f && pointFA.y == 0.0f)) {
            aVar.b(f());
            r();
            return;
        }
        i(pointFA);
        float f = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND;
        this.o = (int) (pointFA.x * f);
        this.p = (int) (f * pointFA.y);
        aVar.d((int) (this.o * 1.2f), (int) (this.p * 1.2f), (int) (u(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND) * 1.2f), this.l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public PointF a(int i) {
        Object objE = e();
        RecyclerView.y.b bVar = objE instanceof RecyclerView.y.b ? (RecyclerView.y.b) objE : null;
        if (bVar != null) {
            return bVar.a(i);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    protected void l(int i, int i2, RecyclerView.z zVar, RecyclerView.y.a aVar) {
        AbstractC13042fc3.i(zVar, "state");
        AbstractC13042fc3.i(aVar, "action");
        if (c() == 0) {
            r();
            return;
        }
        this.o = v(this.o, i);
        int iV = v(this.p, i2);
        this.p = iV;
        if (this.o == 0 && iV == 0) {
            z(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    protected void m() {
        b bVar = this.k;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    protected void n() {
        this.p = 0;
        this.o = 0;
        w();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    protected void o(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
        AbstractC13042fc3.i(view, "targetView");
        AbstractC13042fc3.i(zVar, "state");
        AbstractC13042fc3.i(aVar, "action");
        int iS = s(view);
        int iT = t(iS);
        if (iT > 0) {
            aVar.d(-iS, 0, Math.max((int) (200 * this.j), iT), this.m);
            return;
        }
        b bVar = this.k;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final void x(b bVar) {
        this.k = bVar;
    }

    public final void y(int i) {
        this.q = i;
    }

    public C14325hj7(Context context, c cVar, float f) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(cVar, "positioning");
        this.i = cVar;
        this.j = f;
        this.l = new LinearInterpolator();
        this.m = new DecelerateInterpolator(1.5f);
        this.n = 20.0f / context.getResources().getDisplayMetrics().densityDpi;
    }
}

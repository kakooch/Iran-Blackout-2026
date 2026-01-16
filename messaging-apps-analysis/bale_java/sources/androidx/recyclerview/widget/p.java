package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes2.dex */
public class p extends RecyclerView.y {
    protected PointF k;
    private final float l;
    private int o;
    private int q;
    protected final LinearInterpolator i = new LinearInterpolator();
    protected final DecelerateInterpolator j = new DecelerateInterpolator(1.5f);
    protected int m = 0;
    protected int n = 0;
    private float p = 1.0f;

    public p(Context context, int i) {
        this.l = 25.0f / context.getResources().getDisplayMetrics().densityDpi;
        this.o = i;
    }

    private int v(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public PointF a(int i) {
        Object objE = e();
        if (objE instanceof RecyclerView.y.b) {
            return ((RecyclerView.y.b) objE).a(i);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    protected void l(int i, int i2, RecyclerView.z zVar, RecyclerView.y.a aVar) {
        if (c() == 0) {
            r();
            return;
        }
        this.m = v(this.m, i);
        int iV = v(this.n, i2);
        this.n = iV;
        if (this.m == 0 && iV == 0) {
            y(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    protected void m() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    protected void n() {
        this.n = 0;
        this.m = 0;
        this.k = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    protected void o(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
        int iS = s(view);
        int iT = t(iS);
        if (iT > 0) {
            aVar.d(0, -iS, Math.max((int) (this.p * 400.0f), iT), this.j);
        } else {
            w();
        }
    }

    public int s(View view) {
        RecyclerView.p pVarE = e();
        if (pVarE != null && pVarE.m()) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            int iV = pVarE.V(view) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            int iP = pVarE.P(view) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            int iX = (pVarE.X() - pVarE.e0()) - pVarE.h0();
            int i = iP - iV;
            int i2 = this.o;
            int iH0 = i2 == 2 ? pVarE.h0() + this.q : i > iX ? 0 : i2 == 0 ? (iX - i) / 2 : (pVarE.h0() + this.q) - AbstractC21455b.F(88.0f);
            int i3 = i + iH0;
            int i4 = iH0 - iV;
            if (i4 > 0) {
                return i4;
            }
            int i5 = i3 - iP;
            if (i5 < 0) {
                return i5;
            }
        }
        return 0;
    }

    protected int t(int i) {
        return (int) Math.ceil(u(i) / 0.3356d);
    }

    protected int u(int i) {
        return (int) Math.ceil(Math.abs(i) * this.l);
    }

    public void w() {
    }

    public void x(int i) {
        this.q = i;
    }

    protected void y(RecyclerView.y.a aVar) {
        PointF pointFA = a(f());
        if (pointFA == null || (pointFA.x == 0.0f && pointFA.y == 0.0f)) {
            aVar.b(f());
            r();
            return;
        }
        i(pointFA);
        this.k = pointFA;
        this.m = (int) (pointFA.x * 10000.0f);
        this.n = (int) (pointFA.y * 10000.0f);
        aVar.d((int) (this.m * 1.2f), (int) (this.n * 1.2f), (int) (u(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND) * 1.2f), this.i);
    }
}

package ir.nasim;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;

/* renamed from: ir.nasim.Vz3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC8443Vz3 extends RecyclerView.y {
    protected PointF k;
    private final float l;
    protected final LinearInterpolator i = new LinearInterpolator();
    protected final DecelerateInterpolator j = new DecelerateInterpolator(1.5f);
    protected int m = 0;
    protected int n = 0;

    public AbstractC8443Vz3(Context context) {
        this.l = 25.0f / context.getResources().getDisplayMetrics().densityDpi;
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
            w(aVar);
        }
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
            aVar.d(-iS, 0, Math.max(400, iT), this.j);
        }
    }

    public int s(View view) {
        RecyclerView.p pVarE = e();
        if (pVarE != null && pVarE.l()) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            int iR = pVarE.R(view) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            int iU = pVarE.U(view) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            int iF0 = pVarE.f0();
            int iP0 = pVarE.p0() - pVarE.g0();
            if (iR > iF0 && iU < iP0) {
                return 0;
            }
            int i = iU - iR;
            int i2 = (iP0 - iF0) - i;
            int i3 = i + i2;
            int i4 = i2 - iR;
            if (i4 > 0) {
                return i4;
            }
            int i5 = i3 - iU;
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

    protected void w(RecyclerView.y.a aVar) {
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

    @Override // androidx.recyclerview.widget.RecyclerView.y
    protected void m() {
    }
}

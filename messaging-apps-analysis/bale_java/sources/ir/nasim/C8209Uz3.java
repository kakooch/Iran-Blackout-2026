package ir.nasim;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;

/* renamed from: ir.nasim.Uz3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C8209Uz3 extends RecyclerView.y {
    private final float k;
    private int n;
    private int p;
    protected final LinearInterpolator i = new LinearInterpolator();
    protected final DecelerateInterpolator j = new DecelerateInterpolator(1.5f);
    protected int l = 0;
    protected int m = 0;
    private float o = 1.0f;

    public C8209Uz3(Context context, int i) {
        this.k = 25.0f / context.getResources().getDisplayMetrics().densityDpi;
        this.n = i;
    }

    private int w(int i, int i2) {
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
        this.l = w(this.l, i);
        int iW = w(this.m, i2);
        this.m = iW;
        if (this.l == 0 && iW == 0) {
            y(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    protected void n() {
        this.m = 0;
        this.l = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    protected void o(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
        int iT = t(view);
        int iU = u(iT);
        int iS = s(view);
        int iU2 = u(iS);
        if (iU > 0) {
            aVar.d(0, -iT, Math.max((int) (this.o * 400.0f), iU), this.j);
        } else if (iU2 > 0) {
            aVar.d(-iS, 0, Math.max((int) (this.o * 400.0f), iU2), this.j);
        }
    }

    public int s(View view) {
        RecyclerView.p pVarE = e();
        if (pVarE != null && pVarE.l()) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            int iR = pVarE.R(view) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            int iU = pVarE.U(view) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            int iP0 = (pVarE.p0() - pVarE.g0()) - pVarE.f0();
            int i = iU - iR;
            int i2 = this.n;
            int iF0 = i2 == 2 ? pVarE.f0() + this.p : i > iP0 ? 0 : i2 == 0 ? (iP0 - i) / 2 : (pVarE.f0() + this.p) - C5161Id6.d(88.0f, view.getContext());
            int i3 = i + iF0;
            int i4 = iF0 - iR;
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

    public int t(View view) {
        RecyclerView.p pVarE = e();
        if (pVarE != null && pVarE.m()) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            int iV = pVarE.V(view) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            int iP = pVarE.P(view) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            int iX = (pVarE.X() - pVarE.e0()) - pVarE.h0();
            int i = iP - iV;
            int i2 = this.n;
            int iH0 = i2 == 2 ? pVarE.h0() + this.p : i > iX ? 0 : i2 == 0 ? (iX - i) / 2 : (pVarE.h0() + this.p) - C5161Id6.d(88.0f, view.getContext());
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

    protected int u(int i) {
        return (int) Math.ceil(v(i) / 0.3356d);
    }

    protected int v(int i) {
        return (int) Math.ceil(Math.abs(i) * this.k);
    }

    public void x(int i) {
        this.p = i;
    }

    protected void y(RecyclerView.y.a aVar) {
        PointF pointFA = a(f());
        if (pointFA == null || (pointFA.x == 0.0f && pointFA.y == 0.0f)) {
            aVar.b(f());
            r();
            return;
        }
        i(pointFA);
        this.l = (int) (pointFA.x * 10000.0f);
        this.m = (int) (pointFA.y * 10000.0f);
        aVar.d((int) (this.l * 1.2f), (int) (this.m * 1.2f), (int) (v(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND) * 1.2f), this.i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    protected void m() {
    }
}

package ir.nasim;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;

/* renamed from: ir.nasim.Wz3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C8697Wz3 extends RecyclerView.y {
    private final float k;
    protected final LinearInterpolator i = new LinearInterpolator();
    protected final DecelerateInterpolator j = new DecelerateInterpolator(1.5f);
    protected int l = 0;
    protected int m = 0;

    public C8697Wz3(Context context) {
        this.k = 10.0f / context.getResources().getDisplayMetrics().densityDpi;
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
        this.l = v(this.l, i);
        int iV = v(this.m, i2);
        this.m = iV;
        if (this.l == 0 && iV == 0) {
            w(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    protected void n() {
        this.m = 0;
        this.l = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    protected void o(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
        int iS = s(view);
        int iT = t(iS);
        if (iT > 0) {
            aVar.d(0, -iS, Math.max(400, iT), this.j);
        }
    }

    public int s(View view) {
        RecyclerView.p pVarE = e();
        if (pVarE != null && pVarE.m()) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            int iV = pVarE.V(view) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            int iP = pVarE.P(view) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            int iH0 = pVarE.h0();
            int iX = pVarE.X() - pVarE.e0();
            if (iV > iH0 && iP < iX) {
                return 0;
            }
            int i = iP - iV;
            int i2 = ((iX - iH0) - i) / 2;
            int i3 = i + i2;
            int i4 = i2 - iV;
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
        return (int) Math.ceil(Math.abs(i) * this.k);
    }

    protected void w(RecyclerView.y.a aVar) {
        PointF pointFA = a(f());
        if (pointFA == null || (pointFA.x == 0.0f && pointFA.y == 0.0f)) {
            aVar.b(f());
            r();
            return;
        }
        i(pointFA);
        this.l = (int) (pointFA.x * 10000.0f);
        this.m = (int) (pointFA.y * 10000.0f);
        aVar.d((int) (this.l * 1.2f), (int) (this.m * 1.2f), (int) (u(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND) * 1.2f), this.i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    protected void m() {
    }
}

package ir.nasim.chat.util;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.t;

/* loaded from: classes4.dex */
abstract class a {
    static int a(RecyclerView.z zVar, t tVar, View view, View view2, RecyclerView.p pVar, boolean z) {
        if (pVar.K() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(pVar.i0(view) - pVar.i0(view2)) + 1;
        }
        return Math.min(tVar.n(), tVar.d(view2) - tVar.g(view));
    }

    static int b(RecyclerView.z zVar, t tVar, View view, View view2, RecyclerView.p pVar, boolean z, boolean z2) {
        if (pVar.K() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (zVar.b() - Math.max(pVar.i0(view), pVar.i0(view2))) - 1) : Math.max(0, Math.min(pVar.i0(view), pVar.i0(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(tVar.d(view2) - tVar.g(view)) / (Math.abs(pVar.i0(view) - pVar.i0(view2)) + 1))) + (tVar.m() - tVar.g(view)));
        }
        return iMax;
    }

    static int c(RecyclerView.z zVar, t tVar, View view, View view2, RecyclerView.p pVar, boolean z) {
        if (pVar.K() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return zVar.b();
        }
        return (int) (((tVar.d(view2) - tVar.g(view)) / (Math.abs(pVar.i0(view) - pVar.i0(view2)) + 1)) * zVar.b());
    }
}

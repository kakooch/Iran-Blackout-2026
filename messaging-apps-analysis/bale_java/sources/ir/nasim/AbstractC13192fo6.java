package ir.nasim;

import android.graphics.Rect;
import android.graphics.Region;
import android.view.View;
import androidx.compose.ui.platform.AndroidViewsHandler;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import ir.nasim.B26;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.fo6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC13192fo6 {
    private static final CK5 a = new CK5(0.0f, 0.0f, 10.0f, 10.0f);

    public static final C8482Wd6 a(List list, int i) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C8482Wd6) list.get(i2)).d() == i) {
                return (C8482Wd6) list.get(i2);
            }
        }
        return null;
    }

    public static final AbstractC20768sa3 b(C8572Wn6 c8572Wn6) {
        C7631Sn6 c7631Sn6D = c8572Wn6.d();
        if (!c7631Sn6D.q().o() || !c7631Sn6D.q().b()) {
            return AbstractC21388ta3.a();
        }
        C16734lm4 c16734lm4 = new C16734lm4(48);
        CK5 ck5I = c7631Sn6D.i();
        c(new Region(Math.round(ck5I.i()), Math.round(ck5I.l()), Math.round(ck5I.j()), Math.round(ck5I.e())), c7631Sn6D, c16734lm4, c7631Sn6D, new Region());
        return c16734lm4;
    }

    private static final void c(Region region, C7631Sn6 c7631Sn6, C16734lm4 c16734lm4, C7631Sn6 c7631Sn62, Region region2) {
        InterfaceC16813lu3 interfaceC16813lu3P;
        boolean z = (c7631Sn62.q().o() && c7631Sn62.q().b()) ? false : true;
        if (!region.isEmpty() || c7631Sn62.o() == c7631Sn6.o()) {
            if (!z || c7631Sn62.x()) {
                CK5 ck5V = c7631Sn62.v();
                int iRound = Math.round(ck5V.i());
                int iRound2 = Math.round(ck5V.l());
                int iRound3 = Math.round(ck5V.j());
                int iRound4 = Math.round(ck5V.e());
                region2.set(iRound, iRound2, iRound3, iRound4);
                int iO = c7631Sn62.o() == c7631Sn6.o() ? -1 : c7631Sn62.o();
                if (!region2.op(region, Region.Op.INTERSECT)) {
                    if (c7631Sn62.x()) {
                        C7631Sn6 c7631Sn6R = c7631Sn62.r();
                        CK5 ck5I = (c7631Sn6R == null || (interfaceC16813lu3P = c7631Sn6R.p()) == null || !interfaceC16813lu3P.o()) ? a : c7631Sn6R.i();
                        c16734lm4.r(iO, new C8338Vn6(c7631Sn62, new Rect(Math.round(ck5I.i()), Math.round(ck5I.l()), Math.round(ck5I.j()), Math.round(ck5I.e()))));
                        return;
                    } else {
                        if (iO == -1) {
                            c16734lm4.r(iO, new C8338Vn6(c7631Sn62, region2.getBounds()));
                            return;
                        }
                        return;
                    }
                }
                c16734lm4.r(iO, new C8338Vn6(c7631Sn62, region2.getBounds()));
                List listT = c7631Sn62.t();
                for (int size = listT.size() - 1; -1 < size; size--) {
                    if (!((C7631Sn6) listT.get(size)).n().i(C8838Xn6.a.w())) {
                        c(region, c7631Sn6, c16734lm4, (C7631Sn6) listT.get(size), region2);
                    }
                }
                if (g(c7631Sn62)) {
                    region.op(iRound, iRound2, iRound3, iRound4, Region.Op.DIFFERENCE);
                }
            }
        }
    }

    public static final Float d(SemanticsConfiguration semanticsConfiguration) {
        UA2 ua2;
        ArrayList arrayList = new ArrayList();
        C20450s2 c20450s2 = (C20450s2) AbstractC5719Kn6.a(semanticsConfiguration, C5485Jn6.a.h());
        if (c20450s2 == null || (ua2 = (UA2) c20450s2.a()) == null || !((Boolean) ua2.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (Float) arrayList.get(0);
    }

    public static final C13774gn7 e(SemanticsConfiguration semanticsConfiguration) {
        UA2 ua2;
        ArrayList arrayList = new ArrayList();
        C20450s2 c20450s2 = (C20450s2) AbstractC5719Kn6.a(semanticsConfiguration, C5485Jn6.a.i());
        if (c20450s2 == null || (ua2 = (UA2) c20450s2.a()) == null || !((Boolean) ua2.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (C13774gn7) arrayList.get(0);
    }

    public static final boolean f(C7631Sn6 c7631Sn6) {
        if (!c7631Sn6.z()) {
            SemanticsConfiguration semanticsConfigurationW = c7631Sn6.w();
            C8838Xn6 c8838Xn6 = C8838Xn6.a;
            if (!semanticsConfigurationW.i(c8838Xn6.k()) && !c7631Sn6.w().i(c8838Xn6.p())) {
                return false;
            }
        }
        return true;
    }

    public static final boolean g(C7631Sn6 c7631Sn6) {
        return !f(c7631Sn6) && (c7631Sn6.w().C() || c7631Sn6.w().j());
    }

    public static final View h(AndroidViewsHandler androidViewsHandler, int i) {
        Object next;
        Iterator<T> it = androidViewsHandler.getLayoutNodeToHolder().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((C3419Au3) ((Map.Entry) next).getKey()).d() == i) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (AndroidViewHolder) entry.getValue();
        }
        return null;
    }

    public static final String i(int i) {
        B26.a aVar = B26.b;
        if (B26.m(i, aVar.a())) {
            return "android.widget.Button";
        }
        if (B26.m(i, aVar.c())) {
            return "android.widget.CheckBox";
        }
        if (B26.m(i, aVar.f())) {
            return "android.widget.RadioButton";
        }
        if (B26.m(i, aVar.e())) {
            return "android.widget.ImageView";
        }
        if (B26.m(i, aVar.d())) {
            return "android.widget.Spinner";
        }
        if (B26.m(i, aVar.i())) {
            return "android.widget.NumberPicker";
        }
        return null;
    }
}

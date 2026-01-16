package io.sentry.android.replay.viewhierarchy;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import io.sentry.C3155n3;
import io.sentry.Y2;
import io.sentry.android.replay.util.k;
import io.sentry.android.replay.util.n;
import io.sentry.android.replay.util.p;
import io.sentry.android.replay.v;
import io.sentry.android.replay.viewhierarchy.b;
import ir.nasim.AbstractC12000du3;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC5719Kn6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C13183fn7;
import ir.nasim.C13193fo7;
import ir.nasim.C13774gn7;
import ir.nasim.C20450s2;
import ir.nasim.C24381yX0;
import ir.nasim.C3419Au3;
import ir.nasim.C5485Jn6;
import ir.nasim.C8838Xn6;
import ir.nasim.C9348Zn7;
import ir.nasim.DX0;
import ir.nasim.EV4;
import ir.nasim.InterfaceC11379cu3;
import ir.nasim.InterfaceC23714xO4;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;
import ir.nasim.UA2;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class a {
    private static boolean c;
    private static WeakReference d;
    public static final a a = new a();
    private static final InterfaceC9173Yu3 b = AbstractC13269fw3.a(C0243a.e);
    public static final int e = 8;

    /* renamed from: io.sentry.android.replay.viewhierarchy.a$a, reason: collision with other inner class name */
    static final class C0243a extends AbstractC8614Ws3 implements SA2 {
        public static final C0243a e = new C0243a();

        C0243a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Method invoke() {
            try {
                Method declaredMethod = C3419Au3.class.getDeclaredMethod("e", null);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    private a() {
    }

    private final b a(C3419Au3 c3419Au3, b bVar, int i, boolean z, C3155n3 c3155n3) {
        C13183fn7 c13183fn7L;
        C9348Zn7 c9348Zn7I;
        C13183fn7 c13183fn7L2;
        C9348Zn7 c9348Zn7I2;
        C20450s2 c20450s2;
        UA2 ua2;
        if (!c3419Au3.o() || !c3419Au3.b()) {
            return null;
        }
        if (z) {
            d = new WeakReference(AbstractC12000du3.d(c3419Au3.s()));
        }
        InterfaceC11379cu3 interfaceC11379cu3S = c3419Au3.s();
        WeakReference weakReference = d;
        Rect rectA = k.a(interfaceC11379cu3S, weakReference != null ? (InterfaceC11379cu3) weakReference.get() : null);
        try {
            SemanticsConfiguration semanticsConfigurationE = e(c3419Au3);
            boolean z2 = !c3419Au3.w0().X2() && (semanticsConfigurationE == null || !semanticsConfigurationE.i(C8838Xn6.a.p())) && rectA.height() > 0 && rectA.width() > 0;
            boolean z3 = (semanticsConfigurationE != null && semanticsConfigurationE.i(C5485Jn6.a.z())) || (semanticsConfigurationE != null && semanticsConfigurationE.i(C8838Xn6.a.g()));
            if ((semanticsConfigurationE == null || !semanticsConfigurationE.i(C8838Xn6.a.H())) && !z3) {
                EV4 ev4B = k.b(c3419Au3);
                if (ev4B == null) {
                    return new b.C0244b(rectA.left, rectA.top, c3419Au3.getWidth(), c3419Au3.getHeight(), bVar != null ? bVar.a() : 0.0f, i, bVar, z2 && f(semanticsConfigurationE, false, c3155n3), false, z2, rectA);
                }
                boolean z4 = z2 && f(semanticsConfigurationE, true, c3155n3);
                if (bVar != null) {
                    bVar.g(true);
                }
                return new b.c(rectA.left, rectA.top, c3419Au3.getWidth(), c3419Au3.getHeight(), bVar != null ? bVar.a() : 0.0f, i, bVar, z4 && k.d(ev4B), true, z2, rectA);
            }
            boolean z5 = z2 && f(semanticsConfigurationE, false, c3155n3);
            if (bVar != null) {
                bVar.g(true);
            }
            ArrayList arrayList = new ArrayList();
            if (semanticsConfigurationE != null && (c20450s2 = (C20450s2) AbstractC5719Kn6.a(semanticsConfigurationE, C5485Jn6.a.i())) != null && (ua2 = (UA2) c20450s2.a()) != null) {
            }
            n nVarC = k.c(c3419Au3);
            C24381yX0 c24381yX0A = nVarC.a();
            boolean zB = nVarC.b();
            C13774gn7 c13774gn7 = (C13774gn7) AbstractC15401jX0.s0(arrayList);
            C24381yX0 c24381yX0K = (c13774gn7 == null || (c13183fn7L2 = c13774gn7.l()) == null || (c9348Zn7I2 = c13183fn7L2.i()) == null) ? null : C24381yX0.k(c9348Zn7I2.h());
            if (c24381yX0K == null || c24381yX0K.y() != C24381yX0.b.i()) {
                c24381yX0A = c24381yX0K;
            }
            C13193fo7 c13193fo7B = (c13774gn7 == null || (c13183fn7L = c13774gn7.l()) == null || (c9348Zn7I = c13183fn7L.i()) == null) ? null : C13193fo7.b(c9348Zn7I.l());
            return new b.d((c13774gn7 == null || z3 || !((c13193fo7B != null ? C13193fo7.e(c13193fo7B.k(), C13193fo7.b.a()) : false) ^ true)) ? null : new io.sentry.android.replay.util.b(c13774gn7, zB), c24381yX0A != null ? Integer.valueOf(p.j(DX0.k(c24381yX0A.y()))) : null, 0, 0, rectA.left, rectA.top, c3419Au3.getWidth(), c3419Au3.getHeight(), bVar != null ? bVar.a() : 0.0f, i, bVar, z5, true, z2, rectA, 12, null);
        } catch (Throwable th) {
            if (!c) {
                c = true;
                c3155n3.getLogger().a(Y2.ERROR, th, "Error retrieving semantics information from Compose tree. Most likely you're using\nan unsupported version of androidx.compose.ui:ui. The supported\nversion range is 1.5.0 - 1.8.0.\nIf you're using a newer version, please open a github issue with the version\nyou're using, so we can add support for it.", new Object[0]);
            }
            return new b.C0244b(rectA.left, rectA.top, c3419Au3.getWidth(), c3419Au3.getHeight(), bVar != null ? bVar.a() : 0.0f, i, bVar, true, false, !c3419Au3.w0().X2() && rectA.height() > 0 && rectA.width() > 0, rectA);
        }
    }

    private final Method c() {
        return (Method) b.getValue();
    }

    private final String d(boolean z, SemanticsConfiguration semanticsConfiguration) {
        if (z) {
            return "android.widget.ImageView";
        }
        if (semanticsConfiguration != null) {
            C8838Xn6 c8838Xn6 = C8838Xn6.a;
            if (semanticsConfiguration.i(c8838Xn6.H()) || semanticsConfiguration.i(C5485Jn6.a.z()) || semanticsConfiguration.i(c8838Xn6.g())) {
                return "android.widget.TextView";
            }
        }
        return "android.view.View";
    }

    public static final SemanticsConfiguration e(C3419Au3 c3419Au3) {
        AbstractC13042fc3.i(c3419Au3, "node");
        Method methodC = a.c();
        return methodC != null ? (SemanticsConfiguration) methodC.invoke(c3419Au3, null) : c3419Au3.getCollapsedSemantics$ui_release();
    }

    private final boolean f(SemanticsConfiguration semanticsConfiguration, boolean z, C3155n3 c3155n3) {
        String str = semanticsConfiguration != null ? (String) AbstractC5719Kn6.a(semanticsConfiguration, v.a.a()) : null;
        if (AbstractC13042fc3.d(str, "unmask")) {
            return false;
        }
        if (AbstractC13042fc3.d(str, "mask")) {
            return true;
        }
        String strD = d(z, semanticsConfiguration);
        if (c3155n3.getSessionReplay().m().contains(strD)) {
            return false;
        }
        return c3155n3.getSessionReplay().e().contains(strD);
    }

    private final void g(C3419Au3 c3419Au3, b bVar, boolean z, C3155n3 c3155n3) {
        List listR = c3419Au3.R();
        if (listR.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(listR.size());
        int size = listR.size();
        for (int i = 0; i < size; i++) {
            C3419Au3 c3419Au32 = (C3419Au3) listR.get(i);
            b bVarA = a(c3419Au32, bVar, i, z, c3155n3);
            if (bVarA != null) {
                arrayList.add(bVarA);
                g(c3419Au32, bVarA, false, c3155n3);
            }
        }
        bVar.f(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b(View view, b bVar, C3155n3 c3155n3) {
        C3419Au3 root;
        AbstractC13042fc3.i(view, "view");
        AbstractC13042fc3.i(c3155n3, "options");
        String name = view.getClass().getName();
        AbstractC13042fc3.h(name, "view::class.java.name");
        if (!AbstractC20762sZ6.X(name, "AndroidComposeView", false, 2, null) || bVar == null) {
            return false;
        }
        try {
            InterfaceC23714xO4 interfaceC23714xO4 = view instanceof InterfaceC23714xO4 ? (InterfaceC23714xO4) view : null;
            if (interfaceC23714xO4 != null && (root = interfaceC23714xO4.getRoot()) != null) {
                g(root, bVar, true, c3155n3);
                return true;
            }
            return false;
        } catch (Throwable th) {
            c3155n3.getLogger().a(Y2.ERROR, th, "Error traversing Compose tree. Most likely you're using an unsupported version of\nandroidx.compose.ui:ui. The minimum supported version is 1.5.0. If it's a newer\nversion, please open a github issue with the version you're using, so we can add\nsupport for it.", new Object[0]);
            return false;
        }
    }
}

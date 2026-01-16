package ir.nasim;

import android.view.ViewGroup;

/* renamed from: ir.nasim.xW7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC23789xW7 {

    /* renamed from: ir.nasim.xW7$a */
    static class a {
        static int a(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        static boolean b(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        static void c(ViewGroup viewGroup, boolean z) {
            viewGroup.setTransitionGroup(z);
        }
    }

    public static boolean a(ViewGroup viewGroup) {
        return a.b(viewGroup);
    }
}

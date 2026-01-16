package ir.nasim;

import android.view.View;

/* loaded from: classes2.dex */
public abstract class VX7 {

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final View invoke(View view) {
            AbstractC13042fc3.i(view, "currentView");
            Object parent = view.getParent();
            if (parent instanceof View) {
                return (View) parent;
            }
            return null;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC18633oz3 invoke(View view) {
            AbstractC13042fc3.i(view, "viewParent");
            Object tag = view.getTag(PB5.view_tree_lifecycle_owner);
            if (tag instanceof InterfaceC18633oz3) {
                return (InterfaceC18633oz3) tag;
            }
            return null;
        }
    }

    public static final InterfaceC18633oz3 a(View view) {
        AbstractC13042fc3.i(view, "<this>");
        return (InterfaceC18633oz3) AbstractC11342cq6.v(AbstractC11342cq6.E(AbstractC9962aq6.j(view, a.e), b.e));
    }

    public static final void b(View view, InterfaceC18633oz3 interfaceC18633oz3) {
        AbstractC13042fc3.i(view, "<this>");
        view.setTag(PB5.view_tree_lifecycle_owner, interfaceC18633oz3);
    }
}

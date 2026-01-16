package ir.nasim;

import android.view.View;

/* loaded from: classes2.dex */
public abstract class XX7 {

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final View invoke(View view) {
            AbstractC13042fc3.i(view, "view");
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
        public final InterfaceC7760Tb6 invoke(View view) {
            AbstractC13042fc3.i(view, "view");
            Object tag = view.getTag(SB5.view_tree_saved_state_registry_owner);
            if (tag instanceof InterfaceC7760Tb6) {
                return (InterfaceC7760Tb6) tag;
            }
            return null;
        }
    }

    public static final InterfaceC7760Tb6 a(View view) {
        AbstractC13042fc3.i(view, "<this>");
        return (InterfaceC7760Tb6) AbstractC11342cq6.v(AbstractC11342cq6.E(AbstractC9962aq6.j(view, a.e), b.e));
    }

    public static final void b(View view, InterfaceC7760Tb6 interfaceC7760Tb6) {
        AbstractC13042fc3.i(view, "<this>");
        view.setTag(SB5.view_tree_saved_state_registry_owner, interfaceC7760Tb6);
    }
}

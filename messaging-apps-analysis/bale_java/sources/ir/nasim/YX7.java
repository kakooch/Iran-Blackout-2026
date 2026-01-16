package ir.nasim;

import android.view.View;

/* loaded from: classes2.dex */
public abstract class YX7 {

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
        public final InterfaceC15408jX7 invoke(View view) {
            AbstractC13042fc3.i(view, "view");
            Object tag = view.getTag(QB5.view_tree_view_model_store_owner);
            if (tag instanceof InterfaceC15408jX7) {
                return (InterfaceC15408jX7) tag;
            }
            return null;
        }
    }

    public static final InterfaceC15408jX7 a(View view) {
        AbstractC13042fc3.i(view, "<this>");
        return (InterfaceC15408jX7) AbstractC11342cq6.v(AbstractC11342cq6.E(AbstractC9962aq6.j(view, a.e), b.e));
    }

    public static final void b(View view, InterfaceC15408jX7 interfaceC15408jX7) {
        AbstractC13042fc3.i(view, "<this>");
        view.setTag(QB5.view_tree_view_model_store_owner, interfaceC15408jX7);
    }
}

package ir.nasim;

import android.view.View;

/* loaded from: classes.dex */
public abstract class WX7 {

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final View invoke(View view) {
            AbstractC13042fc3.i(view, "it");
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
        public final AI4 invoke(View view) {
            AbstractC13042fc3.i(view, "it");
            Object tag = view.getTag(ZB5.view_tree_on_back_pressed_dispatcher_owner);
            if (tag instanceof AI4) {
                return (AI4) tag;
            }
            return null;
        }
    }

    public static final AI4 a(View view) {
        AbstractC13042fc3.i(view, "<this>");
        return (AI4) AbstractC11342cq6.v(AbstractC11342cq6.E(AbstractC9962aq6.j(view, a.e), b.e));
    }

    public static final void b(View view, AI4 ai4) {
        AbstractC13042fc3.i(view, "<this>");
        AbstractC13042fc3.i(ai4, "onBackPressedDispatcherOwner");
        view.setTag(ZB5.view_tree_on_back_pressed_dispatcher_owner, ai4);
    }
}

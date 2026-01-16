package ir.nasim;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import ir.nasim.O98;

/* renamed from: ir.nasim.z98, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC24762z98 {

    /* renamed from: ir.nasim.z98$a */
    public static final class a implements View.OnAttachStateChangeListener {
        final /* synthetic */ UA2 a;

        a(UA2 ua2) {
            this.a = ua2;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            AbstractC13042fc3.i(view, "v");
            view.removeOnAttachStateChangeListener(this);
            this.a.invoke(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            AbstractC13042fc3.i(view, "v");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static C19938rB7 C4(InterfaceC24762z98 interfaceC24762z98, View view, View view2, View view3) {
        AbstractC13042fc3.i(interfaceC24762z98, "this$0");
        AbstractC13042fc3.i(view, "$insetView");
        AbstractC13042fc3.i(view2, "$paddingView");
        AbstractC13042fc3.i(view3, "it");
        interfaceC24762z98.o1(view, view2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static O98 a2(InterfaceC24762z98 interfaceC24762z98, View view, View view2, View view3, O98 o98) {
        AbstractC13042fc3.i(interfaceC24762z98, "this$0");
        AbstractC13042fc3.i(view, "$insetTargetView");
        AbstractC13042fc3.i(view2, "$paddingTargetView");
        AbstractC13042fc3.i(view3, "<unused var>");
        AbstractC13042fc3.i(o98, "insets");
        interfaceC24762z98.z3(o98, view, view2);
        return o98;
    }

    private default void o1(final View view, final View view2) {
        O98 o98H = AbstractC12990fW7.H(view);
        if (o98H != null) {
            z3(o98H, view, view2);
        }
        AbstractC12990fW7.E0(view, new InterfaceC22474vI4() { // from class: ir.nasim.y98
            @Override // ir.nasim.InterfaceC22474vI4
            public final O98 b(View view3, O98 o98) {
                return InterfaceC24762z98.a2(this.a, view, view2, view3, o98);
            }
        });
    }

    private default void o3(ViewGroup viewGroup, WindowInsets windowInsets) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).dispatchApplyWindowInsets(windowInsets);
        }
    }

    private default void z3(O98 o98, View view, View view2) {
        int paddingBottom;
        if (getAutoSystemBarBottom() || getAutoSystemBarTop() || getAutoIme()) {
            L93 l93F = o98.f(O98.m.h());
            AbstractC13042fc3.h(l93F, "getInsets(...)");
            L93 l93F2 = o98.f(O98.m.g());
            AbstractC13042fc3.h(l93F2, "getInsets(...)");
            L93 l93F3 = o98.f(O98.m.d());
            AbstractC13042fc3.h(l93F3, "getInsets(...)");
            int paddingTop = getAutoSystemBarTop() ? l93F.b : view2.getPaddingTop();
            if (getAutoIme()) {
                paddingBottom = l93F3.d;
                if (paddingBottom <= 0) {
                    paddingBottom = l93F2.d;
                }
            } else {
                paddingBottom = getAutoSystemBarBottom() ? l93F2.d : view2.getPaddingBottom();
            }
            view2.setPadding(l93F2.a, paddingTop, l93F2.c, paddingBottom);
            ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
            if (viewGroup != null) {
                o3(viewGroup, o98.y());
            }
        }
    }

    /* renamed from: F0 */
    default boolean getAutoSystemBarTop() {
        return false;
    }

    default void N3(View view, UA2 ua2) {
        AbstractC13042fc3.i(view, "view");
        AbstractC13042fc3.i(ua2, "onAttached");
        if (view.isAttachedToWindow()) {
            ua2.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new a(ua2));
        }
    }

    /* renamed from: P0 */
    default boolean getAutoSystemBarBottom() {
        return true;
    }

    /* renamed from: l2 */
    default boolean getAutoIme() {
        return true;
    }

    default void l4(final View view, final View view2) {
        AbstractC13042fc3.i(view, "insetView");
        AbstractC13042fc3.i(view2, "paddingView");
        N3(view, new UA2() { // from class: ir.nasim.x98
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return InterfaceC24762z98.C4(this.a, view, view2, (View) obj);
            }
        });
    }
}

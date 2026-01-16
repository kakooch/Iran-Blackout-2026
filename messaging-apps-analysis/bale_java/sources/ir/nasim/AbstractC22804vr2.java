package ir.nasim;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: ir.nasim.vr2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22804vr2 {

    /* renamed from: ir.nasim.vr2$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ View e;
        final /* synthetic */ View f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, View view2) {
            super(1);
            this.e = view;
            this.f = view2;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(View view) {
            return Boolean.valueOf(AbstractC22804vr2.i(this.e, view, view.getNextFocusForwardId()) == this.f);
        }
    }

    /* renamed from: ir.nasim.vr2$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i) {
            super(1);
            this.e = i;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(View view) {
            return Boolean.valueOf(view.getId() == this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(View view, C3587Bm4 c3587Bm4, int i) {
        e(view, c3587Bm4, i, view.isInTouchMode());
    }

    private static final void e(View view, C3587Bm4 c3587Bm4, int i, boolean z) {
        if (view.getVisibility() == 0 && view.isFocusable() && view.isEnabled() && view.getWidth() > 0 && view.getHeight() > 0 && (!z || view.isFocusableInTouchMode())) {
            c3587Bm4.n(view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                e(viewGroup.getChildAt(i2), c3587Bm4, i, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View f(View view, View view2, int i) {
        int nextFocusForwardId;
        if (i == 1) {
            if (view.getId() == -1) {
                return null;
            }
            return g(view2, view, new a(view2, view));
        }
        if (i == 2 && (nextFocusForwardId = view.getNextFocusForwardId()) != -1) {
            return i(view2, view, nextFocusForwardId);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final android.view.View g(android.view.View r4, android.view.View r5, ir.nasim.UA2 r6) {
        /*
            r0 = 0
            r1 = r0
        L2:
            android.view.View r1 = h(r5, r6, r1)
            if (r1 != 0) goto L1d
            if (r5 != r4) goto Lb
            goto L1d
        Lb:
            android.view.ViewParent r1 = r5.getParent()
            if (r1 == 0) goto L1c
            boolean r2 = r1 instanceof android.view.View
            if (r2 != 0) goto L16
            goto L1c
        L16:
            android.view.View r1 = (android.view.View) r1
            r3 = r1
            r1 = r5
            r5 = r3
            goto L2
        L1c:
            return r0
        L1d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC22804vr2.g(android.view.View, android.view.View, ir.nasim.UA2):android.view.View");
    }

    private static final View h(View view, UA2 ua2, View view2) {
        View viewH;
        if (((Boolean) ua2.invoke(view)).booleanValue()) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != view2 && (viewH = h(childAt, ua2, view2)) != null) {
                return viewH;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View i(View view, View view2, int i) {
        return g(view, view2, new b(i));
    }
}

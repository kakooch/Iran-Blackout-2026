package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewGroup;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC22421vC5;
import ir.nasim.AbstractC23483x0;
import ir.nasim.AbstractC7050Qb1;
import ir.nasim.AbstractC8459Wb1;
import ir.nasim.C21217tJ2;
import ir.nasim.C3419Au3;
import ir.nasim.IA7;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC6806Pb1;
import ir.nasim.Q93;
import java.util.Collections;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public abstract class A {
    private static final ViewGroup.LayoutParams a = new ViewGroup.LayoutParams(-2, -2);

    public static final AbstractC23483x0 a(C3419Au3 c3419Au3) {
        return new IA7(c3419Au3);
    }

    private static final InterfaceC6806Pb1 b(AndroidComposeView androidComposeView, AbstractC7050Qb1 abstractC7050Qb1, InterfaceC14603iB2 interfaceC14603iB2) {
        if (Q93.b() && androidComposeView.getTag(AbstractC22421vC5.inspection_slot_table_set) == null) {
            androidComposeView.setTag(AbstractC22421vC5.inspection_slot_table_set, Collections.newSetFromMap(new WeakHashMap()));
        }
        Object tag = androidComposeView.getView().getTag(AbstractC22421vC5.wrapped_composition_tag);
        z zVar = tag instanceof z ? (z) tag : null;
        if (zVar == null) {
            zVar = new z(androidComposeView, AbstractC8459Wb1.a(new IA7(androidComposeView.getRoot()), abstractC7050Qb1));
            androidComposeView.getView().setTag(AbstractC22421vC5.wrapped_composition_tag, zVar);
        }
        zVar.l(interfaceC14603iB2);
        if (!AbstractC13042fc3.d(androidComposeView.getCoroutineContext(), abstractC7050Qb1.h())) {
            androidComposeView.setCoroutineContext(abstractC7050Qb1.h());
        }
        return zVar;
    }

    public static final InterfaceC6806Pb1 c(AbstractComposeView abstractComposeView, AbstractC7050Qb1 abstractC7050Qb1, InterfaceC14603iB2 interfaceC14603iB2) {
        C21217tJ2.a.b();
        AndroidComposeView androidComposeView = null;
        if (abstractComposeView.getChildCount() > 0) {
            View childAt = abstractComposeView.getChildAt(0);
            if (childAt instanceof AndroidComposeView) {
                androidComposeView = (AndroidComposeView) childAt;
            }
        } else {
            abstractComposeView.removeAllViews();
        }
        if (androidComposeView == null) {
            androidComposeView = new AndroidComposeView(abstractComposeView.getContext(), abstractC7050Qb1.h());
            abstractComposeView.addView(androidComposeView.getView(), a);
        }
        return b(androidComposeView, abstractC7050Qb1, interfaceC14603iB2);
    }
}

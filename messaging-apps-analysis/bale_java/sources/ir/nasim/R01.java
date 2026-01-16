package ir.nasim;

import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.compose.ui.platform.ComposeView;

/* loaded from: classes.dex */
public abstract class R01 {
    private static final ViewGroup.LayoutParams a = new ViewGroup.LayoutParams(-2, -2);

    public static final void a(ComponentActivity componentActivity, AbstractC7050Qb1 abstractC7050Qb1, InterfaceC14603iB2 interfaceC14603iB2) {
        View childAt = ((ViewGroup) componentActivity.getWindow().getDecorView().findViewById(android.R.id.content)).getChildAt(0);
        ComposeView composeView = childAt instanceof ComposeView ? (ComposeView) childAt : null;
        if (composeView != null) {
            composeView.setParentCompositionContext(abstractC7050Qb1);
            composeView.setContent(interfaceC14603iB2);
            return;
        }
        ComposeView composeView2 = new ComposeView(componentActivity, null, 0, 6, null);
        composeView2.setParentCompositionContext(abstractC7050Qb1);
        composeView2.setContent(interfaceC14603iB2);
        c(componentActivity);
        componentActivity.setContentView(composeView2, a);
    }

    public static /* synthetic */ void b(ComponentActivity componentActivity, AbstractC7050Qb1 abstractC7050Qb1, InterfaceC14603iB2 interfaceC14603iB2, int i, Object obj) {
        if ((i & 1) != 0) {
            abstractC7050Qb1 = null;
        }
        a(componentActivity, abstractC7050Qb1, interfaceC14603iB2);
    }

    private static final void c(ComponentActivity componentActivity) {
        View decorView = componentActivity.getWindow().getDecorView();
        if (VX7.a(decorView) == null) {
            VX7.b(decorView, componentActivity);
        }
        if (YX7.a(decorView) == null) {
            YX7.b(decorView, componentActivity);
        }
        if (XX7.a(decorView) == null) {
            XX7.b(decorView, componentActivity);
        }
    }
}

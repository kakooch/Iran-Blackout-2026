package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.vz2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C22886vz2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final View b;
    public final ComposeView c;

    private C22886vz2(ConstraintLayout constraintLayout, View view, ComposeView composeView) {
        this.a = constraintLayout;
        this.b = view;
        this.c = composeView;
    }

    public static C22886vz2 a(View view) {
        int i = AbstractC18172oC5.snack_bar_anchor_view;
        View viewA = AbstractC11738dW7.a(view, i);
        if (viewA != null) {
            i = AbstractC18172oC5.story_adder_compose_view;
            ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
            if (composeView != null) {
                return new C22886vz2((ConstraintLayout) view, viewA, composeView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C22886vz2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(RC5.fragment_story_adder, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}

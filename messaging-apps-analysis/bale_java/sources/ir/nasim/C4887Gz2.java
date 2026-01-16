package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.Gz2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C4887Gz2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ComposeView b;

    private C4887Gz2(ConstraintLayout constraintLayout, ComposeView composeView) {
        this.a = constraintLayout;
        this.b = composeView;
    }

    public static C4887Gz2 a(View view) {
        int i = AbstractC18172oC5.afkarEditText;
        ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
        if (composeView != null) {
            return new C4887Gz2((ConstraintLayout) view, composeView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C4887Gz2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(RC5.fragment_text_story, viewGroup, false);
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

package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.az2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C10045az2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;

    private C10045az2(ConstraintLayout constraintLayout) {
        this.a = constraintLayout;
    }

    public static C10045az2 a(View view) {
        if (view != null) {
            return new C10045az2((ConstraintLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static C10045az2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(RC5.fragment_post_to_story, viewGroup, false);
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

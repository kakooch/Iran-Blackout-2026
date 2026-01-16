package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.hZ7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14226hZ7 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final RecyclerView c;
    public final TextView d;

    private C14226hZ7(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TextView textView) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = recyclerView;
        this.d = textView;
    }

    public static C14226hZ7 a(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = AbstractC12808fC5.vitrin_items_rv;
        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
        if (recyclerView != null) {
            i = AbstractC12808fC5.vitrin_title_tv;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                return new C14226hZ7(constraintLayout, constraintLayout, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C14226hZ7 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.vitrin_row_holder, viewGroup, false);
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

package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Bx2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C3684Bx2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final View b;
    public final RecyclerView c;

    private C3684Bx2(ConstraintLayout constraintLayout, View view, RecyclerView recyclerView) {
        this.a = constraintLayout;
        this.b = view;
        this.c = recyclerView;
    }

    public static C3684Bx2 a(View view) {
        int i = YB5.anchor_toast;
        View viewA = AbstractC11738dW7.a(view, i);
        if (viewA != null) {
            i = YB5.rv;
            RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
            if (recyclerView != null) {
                return new C3684Bx2((ConstraintLayout) view, viewA, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C3684Bx2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC9591aD5.fragment_call_logs, viewGroup, false);
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

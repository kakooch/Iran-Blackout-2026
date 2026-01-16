package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.lP5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16516lP5 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final RecyclerView c;
    public final TextView d;

    private C16516lP5(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, RecyclerView recyclerView, TextView textView) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = recyclerView;
        this.d = textView;
    }

    public static C16516lP5 a(View view) {
        int i = AbstractC16399lC5.closeImageView;
        AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
        if (appCompatImageView != null) {
            i = AbstractC16399lC5.itemsRecyclerView;
            RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
            if (recyclerView != null) {
                i = AbstractC16399lC5.titleTextView;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    return new C16516lP5((ConstraintLayout) view, appCompatImageView, recyclerView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C16516lP5 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(NC5.report_bottom_sheet, viewGroup, false);
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

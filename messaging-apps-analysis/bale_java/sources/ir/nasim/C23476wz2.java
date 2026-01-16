package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.wz2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C23476wz2 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final GridLayout b;
    public final RecyclerView c;

    private C23476wz2(FrameLayout frameLayout, GridLayout gridLayout, RecyclerView recyclerView) {
        this.a = frameLayout;
        this.b = gridLayout;
        this.c = recyclerView;
    }

    public static C23476wz2 a(View view) {
        int i = AbstractC18172oC5.llShimmerStoryList;
        GridLayout gridLayout = (GridLayout) AbstractC11738dW7.a(view, i);
        if (gridLayout != null) {
            i = AbstractC18172oC5.rcStoriesList;
            RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
            if (recyclerView != null) {
                return new C23476wz2((FrameLayout) view, gridLayout, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C23476wz2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(RC5.fragment_story, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}

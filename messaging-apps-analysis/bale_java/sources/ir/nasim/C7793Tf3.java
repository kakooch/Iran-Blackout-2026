package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.shimmer.ShimmerFrameLayout;

/* renamed from: ir.nasim.Tf3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7793Tf3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ShimmerFrameLayout b;
    public final ShimmerFrameLayout c;
    public final ShimmerFrameLayout d;
    public final ConstraintLayout e;
    public final ShimmerFrameLayout f;

    private C7793Tf3(ConstraintLayout constraintLayout, ShimmerFrameLayout shimmerFrameLayout, ShimmerFrameLayout shimmerFrameLayout2, ShimmerFrameLayout shimmerFrameLayout3, ConstraintLayout constraintLayout2, ShimmerFrameLayout shimmerFrameLayout4) {
        this.a = constraintLayout;
        this.b = shimmerFrameLayout;
        this.c = shimmerFrameLayout2;
        this.d = shimmerFrameLayout3;
        this.e = constraintLayout2;
        this.f = shimmerFrameLayout4;
    }

    public static C7793Tf3 a(View view) {
        int i = AbstractC14017hC5.avatar;
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
        if (shimmerFrameLayout != null) {
            i = AbstractC14017hC5.circle;
            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
            if (shimmerFrameLayout2 != null) {
                i = AbstractC14017hC5.description;
                ShimmerFrameLayout shimmerFrameLayout3 = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
                if (shimmerFrameLayout3 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = AbstractC14017hC5.titleLayout;
                    ShimmerFrameLayout shimmerFrameLayout4 = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
                    if (shimmerFrameLayout4 != null) {
                        return new C7793Tf3(constraintLayout, shimmerFrameLayout, shimmerFrameLayout2, shimmerFrameLayout3, constraintLayout, shimmerFrameLayout4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C7793Tf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(JC5.item_search_result_peer_shimmer, viewGroup, false);
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

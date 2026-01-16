package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.shimmer.ShimmerFrameLayout;

/* renamed from: ir.nasim.gy2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13877gy2 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final ComposeView b;
    public final LinearLayout c;
    public final RecyclerView d;
    public final ShimmerFrameLayout e;

    private C13877gy2(FrameLayout frameLayout, ComposeView composeView, LinearLayout linearLayout, RecyclerView recyclerView, ShimmerFrameLayout shimmerFrameLayout) {
        this.a = frameLayout;
        this.b = composeView;
        this.c = linearLayout;
        this.d = recyclerView;
        this.e = shimmerFrameLayout;
    }

    public static C13877gy2 a(View view) {
        int i = AbstractC12808fC5.feedCategory;
        ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
        if (composeView != null) {
            i = AbstractC12808fC5.magazineView;
            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
            if (linearLayout != null) {
                i = AbstractC12808fC5.rv_feeds;
                RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                if (recyclerView != null) {
                    i = AbstractC12808fC5.shimmer_feed;
                    ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
                    if (shimmerFrameLayout != null) {
                        return new C13877gy2((FrameLayout) view, composeView, linearLayout, recyclerView, shimmerFrameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C13877gy2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.fragment_feeds, viewGroup, false);
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

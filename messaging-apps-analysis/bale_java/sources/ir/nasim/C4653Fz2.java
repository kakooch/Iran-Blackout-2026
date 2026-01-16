package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.Fz2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4653Fz2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final Group b;
    public final AppBarLayout c;
    public final View d;
    public final ImageView e;
    public final ImageView f;
    public final TextView g;
    public final FrameLayout h;
    public final TextView i;
    public final RecyclerView j;
    public final ShimmerFrameLayout k;
    public final TextView l;
    public final BaleToolbar m;

    private C4653Fz2(ConstraintLayout constraintLayout, Group group, AppBarLayout appBarLayout, View view, ImageView imageView, ImageView imageView2, TextView textView, FrameLayout frameLayout, TextView textView2, RecyclerView recyclerView, ShimmerFrameLayout shimmerFrameLayout, TextView textView3, BaleToolbar baleToolbar) {
        this.a = constraintLayout;
        this.b = group;
        this.c = appBarLayout;
        this.d = view;
        this.e = imageView;
        this.f = imageView2;
        this.g = textView;
        this.h = frameLayout;
        this.i = textView2;
        this.j = recyclerView;
        this.k = shimmerFrameLayout;
        this.l = textView3;
        this.m = baleToolbar;
    }

    public static C4653Fz2 a(View view) {
        View viewA;
        int i = AbstractC12808fC5.group_banner;
        Group group = (Group) AbstractC11738dW7.a(view, i);
        if (group != null) {
            i = AbstractC12808fC5.suggesters_appbar;
            AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
            if (appBarLayout != null && (viewA = AbstractC11738dW7.a(view, (i = AbstractC12808fC5.suggesters_banner))) != null) {
                i = AbstractC12808fC5.suggesters_banner_close;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = AbstractC12808fC5.suggesters_banner_icon;
                    ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView2 != null) {
                        i = AbstractC12808fC5.suggesters_banner_title;
                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView != null) {
                            i = AbstractC12808fC5.suggesters_header;
                            FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                            if (frameLayout != null) {
                                i = AbstractC12808fC5.suggesters_member;
                                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView2 != null) {
                                    i = AbstractC12808fC5.suggesters_rv;
                                    RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                                    if (recyclerView != null) {
                                        i = AbstractC12808fC5.suggesters_shimmer_rv;
                                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
                                        if (shimmerFrameLayout != null) {
                                            i = AbstractC12808fC5.suggesters_title;
                                            TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView3 != null) {
                                                i = AbstractC12808fC5.suggesters_toolbar;
                                                BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                                if (baleToolbar != null) {
                                                    return new C4653Fz2((ConstraintLayout) view, group, appBarLayout, viewA, imageView, imageView2, textView, frameLayout, textView2, recyclerView, shimmerFrameLayout, textView3, baleToolbar);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C4653Fz2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.fragment_suggesters, viewGroup, false);
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

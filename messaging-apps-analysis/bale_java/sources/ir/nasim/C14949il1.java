package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.il1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14949il1 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final ShimmerFrameLayout b;
    public final AvatarViewGlide c;
    public final MaterialCardView d;
    public final LinearLayout e;
    public final TextView f;
    public final ShimmerFrameLayout g;
    public final ShimmerFrameLayout h;
    public final ShimmerFrameLayout i;
    public final TextView j;
    public final ImageView k;
    public final MaterialCardView l;
    public final ShimmerFrameLayout m;
    public final Guideline n;
    public final ConstraintLayout o;
    public final TextView p;
    public final TextView q;
    public final ShimmerFrameLayout r;
    public final ShimmerFrameLayout s;
    public final TextView t;
    public final TextView u;
    public final MaterialCardView v;

    private C14949il1(FrameLayout frameLayout, ShimmerFrameLayout shimmerFrameLayout, AvatarViewGlide avatarViewGlide, MaterialCardView materialCardView, LinearLayout linearLayout, TextView textView, ShimmerFrameLayout shimmerFrameLayout2, ShimmerFrameLayout shimmerFrameLayout3, ShimmerFrameLayout shimmerFrameLayout4, TextView textView2, ImageView imageView, MaterialCardView materialCardView2, ShimmerFrameLayout shimmerFrameLayout5, Guideline guideline, ConstraintLayout constraintLayout, TextView textView3, TextView textView4, ShimmerFrameLayout shimmerFrameLayout6, ShimmerFrameLayout shimmerFrameLayout7, TextView textView5, TextView textView6, MaterialCardView materialCardView3) {
        this.a = frameLayout;
        this.b = shimmerFrameLayout;
        this.c = avatarViewGlide;
        this.d = materialCardView;
        this.e = linearLayout;
        this.f = textView;
        this.g = shimmerFrameLayout2;
        this.h = shimmerFrameLayout3;
        this.i = shimmerFrameLayout4;
        this.j = textView2;
        this.k = imageView;
        this.l = materialCardView2;
        this.m = shimmerFrameLayout5;
        this.n = guideline;
        this.o = constraintLayout;
        this.p = textView3;
        this.q = textView4;
        this.r = shimmerFrameLayout6;
        this.s = shimmerFrameLayout7;
        this.t = textView5;
        this.u = textView6;
        this.v = materialCardView3;
    }

    public static C14949il1 a(View view) {
        int i = AbstractC12808fC5.avatar_loading;
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
        if (shimmerFrameLayout != null) {
            i = AbstractC12808fC5.avatar_view;
            AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
            if (avatarViewGlide != null) {
                i = AbstractC12808fC5.card;
                MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
                if (materialCardView != null) {
                    i = AbstractC12808fC5.content_container;
                    LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                    if (linearLayout != null) {
                        i = AbstractC12808fC5.date;
                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView != null) {
                            i = AbstractC12808fC5.detail1_loading;
                            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
                            if (shimmerFrameLayout2 != null) {
                                i = AbstractC12808fC5.detail2_loading;
                                ShimmerFrameLayout shimmerFrameLayout3 = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
                                if (shimmerFrameLayout3 != null) {
                                    i = AbstractC12808fC5.detail3_loading;
                                    ShimmerFrameLayout shimmerFrameLayout4 = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
                                    if (shimmerFrameLayout4 != null) {
                                        i = AbstractC12808fC5.detail_txv;
                                        TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView2 != null) {
                                            i = AbstractC12808fC5.image;
                                            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                                            if (imageView != null) {
                                                i = AbstractC12808fC5.image_container;
                                                MaterialCardView materialCardView2 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                if (materialCardView2 != null) {
                                                    i = AbstractC12808fC5.image_container_shimmer;
                                                    ShimmerFrameLayout shimmerFrameLayout5 = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
                                                    if (shimmerFrameLayout5 != null) {
                                                        i = AbstractC12808fC5.image_guideline;
                                                        Guideline guideline = (Guideline) AbstractC11738dW7.a(view, i);
                                                        if (guideline != null) {
                                                            i = AbstractC12808fC5.loading_container;
                                                            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                            if (constraintLayout != null) {
                                                                i = AbstractC12808fC5.member_divider;
                                                                TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                                                if (textView3 != null) {
                                                                    i = AbstractC12808fC5.members_count;
                                                                    TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                                                    if (textView4 != null) {
                                                                        i = AbstractC12808fC5.shimmer;
                                                                        ShimmerFrameLayout shimmerFrameLayout6 = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
                                                                        if (shimmerFrameLayout6 != null) {
                                                                            i = AbstractC12808fC5.title_loading;
                                                                            ShimmerFrameLayout shimmerFrameLayout7 = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
                                                                            if (shimmerFrameLayout7 != null) {
                                                                                i = AbstractC12808fC5.title_tv;
                                                                                TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                if (textView5 != null) {
                                                                                    i = AbstractC12808fC5.title_txv;
                                                                                    TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                    if (textView6 != null) {
                                                                                        i = AbstractC12808fC5.video_label;
                                                                                        MaterialCardView materialCardView3 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                                                        if (materialCardView3 != null) {
                                                                                            return new C14949il1((FrameLayout) view, shimmerFrameLayout, avatarViewGlide, materialCardView, linearLayout, textView, shimmerFrameLayout2, shimmerFrameLayout3, shimmerFrameLayout4, textView2, imageView, materialCardView2, shimmerFrameLayout5, guideline, constraintLayout, textView3, textView4, shimmerFrameLayout6, shimmerFrameLayout7, textView5, textView6, materialCardView3);
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

    public static C14949il1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.content_search_result_view_holder, viewGroup, false);
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

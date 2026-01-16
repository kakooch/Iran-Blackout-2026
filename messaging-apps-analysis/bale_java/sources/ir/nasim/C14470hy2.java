package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;

/* renamed from: ir.nasim.hy2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14470hy2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ImageView b;
    public final ViewPager2 c;
    public final I37 d;
    public final LinearLayout e;
    public final TextView f;

    private C14470hy2(ConstraintLayout constraintLayout, ImageView imageView, ViewPager2 viewPager2, I37 i37, LinearLayout linearLayout, TextView textView) {
        this.a = constraintLayout;
        this.b = imageView;
        this.c = viewPager2;
        this.d = i37;
        this.e = linearLayout;
        this.f = textView;
    }

    public static C14470hy2 a(View view) {
        View viewA;
        int i = AbstractC12808fC5.arrow_up;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            i = AbstractC12808fC5.feed_full_screen_view_pager;
            ViewPager2 viewPager2 = (ViewPager2) AbstractC11738dW7.a(view, i);
            if (viewPager2 != null && (viewA = AbstractC11738dW7.a(view, (i = AbstractC12808fC5.similar_post_onboarding_animation))) != null) {
                I37 i37A = I37.a(viewA);
                i = AbstractC12808fC5.similar_post_teaching;
                LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                if (linearLayout != null) {
                    i = AbstractC12808fC5.text;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        return new C14470hy2((ConstraintLayout) view, imageView, viewPager2, i37A, linearLayout, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C14470hy2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.fragment_full_screen_feed, viewGroup, false);
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

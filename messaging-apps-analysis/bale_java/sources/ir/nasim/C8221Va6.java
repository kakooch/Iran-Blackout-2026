package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.Va6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8221Va6 implements InterfaceC9764aW7 {
    private final ScrollView a;
    public final TextView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final ConstraintLayout h;
    public final TextView i;
    public final TextView j;
    public final TextView k;

    private C8221Va6(ScrollView scrollView, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ConstraintLayout constraintLayout, TextView textView6, TextView textView7, TextView textView8) {
        this.a = scrollView;
        this.b = textView;
        this.c = imageView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
        this.g = textView5;
        this.h = constraintLayout;
        this.i = textView6;
        this.j = textView7;
        this.k = textView8;
    }

    public static C8221Va6 a(View view) {
        int i = BC5.desc_empty_state_sapta_tv;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            i = BC5.image_empty_state_sapta_iv;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = BC5.item1_empty_state_sapta_tv;
                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView2 != null) {
                    i = BC5.item2_empty_state_sapta_tv;
                    TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView3 != null) {
                        i = BC5.item3_empty_state_sapta_tv;
                        TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView4 != null) {
                            i = BC5.item4_empty_state_sapta_tv;
                            TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView5 != null) {
                                i = BC5.main_empty_container;
                                ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                if (constraintLayout != null) {
                                    i = BC5.title1_empty_state_sapta_tv;
                                    TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView6 != null) {
                                        i = BC5.title2_empty_state_sapta_tv;
                                        TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView7 != null) {
                                            i = BC5.title_empty_state_sapta_tv;
                                            TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView8 != null) {
                                                return new C8221Va6((ScrollView) view, textView, imageView, textView2, textView3, textView4, textView5, constraintLayout, textView6, textView7, textView8);
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

    public static C8221Va6 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.sapta_bot_empty_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.a;
    }
}

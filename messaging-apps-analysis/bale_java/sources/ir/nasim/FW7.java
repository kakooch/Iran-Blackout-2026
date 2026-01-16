package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes5.dex */
public final class FW7 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final LinearLayout b;
    public final ImageView c;
    public final MaterialCardView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final ImageView i;
    public final TextView j;
    public final TextView k;
    public final View l;
    public final LinearLayout m;
    public final ImageView n;
    public final LinearLayout o;
    public final TextView p;
    public final TextView q;

    private FW7(ConstraintLayout constraintLayout, LinearLayout linearLayout, ImageView imageView, MaterialCardView materialCardView, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView2, TextView textView5, TextView textView6, View view, LinearLayout linearLayout2, ImageView imageView3, LinearLayout linearLayout3, TextView textView7, TextView textView8) {
        this.a = constraintLayout;
        this.b = linearLayout;
        this.c = imageView;
        this.d = materialCardView;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
        this.i = imageView2;
        this.j = textView5;
        this.k = textView6;
        this.l = view;
        this.m = linearLayout2;
        this.n = imageView3;
        this.o = linearLayout3;
        this.p = textView7;
        this.q = textView8;
    }

    public static FW7 a(View view) {
        View viewA;
        int i = BC5.description_container;
        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
        if (linearLayout != null) {
            i = BC5.imageView_more;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = BC5.mainCard_container;
                MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
                if (materialCardView != null) {
                    i = BC5.pfm_about_text;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        i = BC5.pfm_amount_text;
                        TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView2 != null) {
                            i = BC5.pfm_status_text;
                            TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView3 != null) {
                                i = BC5.pfm_sub_tag_tv;
                                TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView4 != null) {
                                    i = BC5.pfm_tag_iv;
                                    ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                    if (imageView2 != null) {
                                        i = BC5.pfm_tag_tv;
                                        TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView5 != null) {
                                            i = BC5.pfm_time_text;
                                            TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView6 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.second_divider))) != null) {
                                                i = BC5.sub_tag_linearContainer;
                                                LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                if (linearLayout2 != null) {
                                                    i = BC5.tag_edit_iv;
                                                    ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                                    if (imageView3 != null) {
                                                        i = BC5.tag_linearContainer;
                                                        LinearLayout linearLayout3 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                        if (linearLayout3 != null) {
                                                            i = BC5.textView7;
                                                            TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                            if (textView7 != null) {
                                                                i = BC5.textView_description_tag;
                                                                TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                                if (textView8 != null) {
                                                                    return new FW7((ConstraintLayout) view, linearLayout, imageView, materialCardView, textView, textView2, textView3, textView4, imageView2, textView5, textView6, viewA, linearLayout2, imageView3, linearLayout3, textView7, textView8);
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

    public static FW7 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.view_holder_p_f_m, viewGroup, false);
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

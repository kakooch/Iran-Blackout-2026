package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.card.MaterialCardView;

/* renamed from: ir.nasim.It4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5303It4 implements InterfaceC9764aW7 {
    private final RelativeLayout a;
    public final MaterialCardView b;
    public final ImageView c;
    public final LinearLayout d;
    public final TextView e;
    public final ConstraintLayout f;
    public final MaterialCardView g;
    public final MaterialCardView h;
    public final MaterialCardView i;
    public final MaterialCardView j;
    public final MaterialCardView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final EditText o;
    public final ImageView p;
    public final ImageView q;
    public final ImageView r;
    public final ImageView s;
    public final TextView t;
    public final RelativeLayout u;
    public final NestedScrollView v;
    public final TextView w;

    private C5303It4(RelativeLayout relativeLayout, MaterialCardView materialCardView, ImageView imageView, LinearLayout linearLayout, TextView textView, ConstraintLayout constraintLayout, MaterialCardView materialCardView2, MaterialCardView materialCardView3, MaterialCardView materialCardView4, MaterialCardView materialCardView5, MaterialCardView materialCardView6, TextView textView2, TextView textView3, TextView textView4, EditText editText, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView5, RelativeLayout relativeLayout2, NestedScrollView nestedScrollView, TextView textView6) {
        this.a = relativeLayout;
        this.b = materialCardView;
        this.c = imageView;
        this.d = linearLayout;
        this.e = textView;
        this.f = constraintLayout;
        this.g = materialCardView2;
        this.h = materialCardView3;
        this.i = materialCardView4;
        this.j = materialCardView5;
        this.k = materialCardView6;
        this.l = textView2;
        this.m = textView3;
        this.n = textView4;
        this.o = editText;
        this.p = imageView2;
        this.q = imageView3;
        this.r = imageView4;
        this.s = imageView5;
        this.t = textView5;
        this.u = relativeLayout2;
        this.v = nestedScrollView;
        this.w = textView6;
    }

    public static C5303It4 a(View view) {
        int i = BC5.auth_avatar;
        MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
        if (materialCardView != null) {
            i = BC5.auth_avatar_img;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = BC5.avatar_selector;
                LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                if (linearLayout != null) {
                    i = BC5.button_confirm_text;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        i = BC5.button_confirm_view;
                        ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                        if (constraintLayout != null) {
                            i = BC5.card_man_1;
                            MaterialCardView materialCardView2 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                            if (materialCardView2 != null) {
                                i = BC5.card_man_2;
                                MaterialCardView materialCardView3 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                if (materialCardView3 != null) {
                                    i = BC5.card_username;
                                    MaterialCardView materialCardView4 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                    if (materialCardView4 != null) {
                                        i = BC5.card_woman_1;
                                        MaterialCardView materialCardView5 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                        if (materialCardView5 != null) {
                                            i = BC5.card_woman_2;
                                            MaterialCardView materialCardView6 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                            if (materialCardView6 != null) {
                                                i = BC5.complete_profile;
                                                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                                if (textView2 != null) {
                                                    i = BC5.error_username;
                                                    TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                                    if (textView3 != null) {
                                                        i = BC5.hint_username;
                                                        TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView4 != null) {
                                                            i = BC5.input_username;
                                                            EditText editText = (EditText) AbstractC11738dW7.a(view, i);
                                                            if (editText != null) {
                                                                i = BC5.iv_man_1;
                                                                ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                if (imageView2 != null) {
                                                                    i = BC5.iv_man_2;
                                                                    ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                    if (imageView3 != null) {
                                                                        i = BC5.iv_woman_1;
                                                                        ImageView imageView4 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                        if (imageView4 != null) {
                                                                            i = BC5.iv_woman_2;
                                                                            ImageView imageView5 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                            if (imageView5 != null) {
                                                                                i = BC5.profile;
                                                                                TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                if (textView5 != null) {
                                                                                    RelativeLayout relativeLayout = (RelativeLayout) view;
                                                                                    i = BC5.scroll_view;
                                                                                    NestedScrollView nestedScrollView = (NestedScrollView) AbstractC11738dW7.a(view, i);
                                                                                    if (nestedScrollView != null) {
                                                                                        i = BC5.select_profile;
                                                                                        TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                        if (textView6 != null) {
                                                                                            return new C5303It4(relativeLayout, materialCardView, imageView, linearLayout, textView, constraintLayout, materialCardView2, materialCardView3, materialCardView4, materialCardView5, materialCardView6, textView2, textView3, textView4, editText, imageView2, imageView3, imageView4, imageView5, textView5, relativeLayout, nestedScrollView, textView6);
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

    public static C5303It4 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.new_fragment_sign_up, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}

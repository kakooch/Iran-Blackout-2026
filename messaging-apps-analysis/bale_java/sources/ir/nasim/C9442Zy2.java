package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.radiobutton.MaterialRadioButton;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.button.FullWidthButtonPrimary;

/* renamed from: ir.nasim.Zy2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9442Zy2 implements InterfaceC9764aW7 {
    public final TextView A;
    public final G75 B;
    private final RelativeLayout a;
    public final MaterialRadioButton b;
    public final TextView c;
    public final MaterialRadioButton d;
    public final TextView e;
    public final G75 f;
    public final View g;
    public final FullWidthButtonPrimary h;
    public final NestedScrollView i;
    public final TextView j;
    public final MaterialCardView k;
    public final ConstraintLayout l;
    public final AppBarLayout m;
    public final BaleToolbar n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final EditText r;
    public final ImageView s;
    public final TextView t;
    public final TextView u;
    public final RadioGroup v;
    public final TextView w;
    public final ConstraintLayout x;
    public final TextView y;
    public final MaterialRadioButton z;

    private C9442Zy2(RelativeLayout relativeLayout, MaterialRadioButton materialRadioButton, TextView textView, MaterialRadioButton materialRadioButton2, TextView textView2, G75 g75, View view, FullWidthButtonPrimary fullWidthButtonPrimary, NestedScrollView nestedScrollView, TextView textView3, MaterialCardView materialCardView, ConstraintLayout constraintLayout, AppBarLayout appBarLayout, BaleToolbar baleToolbar, TextView textView4, TextView textView5, TextView textView6, EditText editText, ImageView imageView, TextView textView7, TextView textView8, RadioGroup radioGroup, TextView textView9, ConstraintLayout constraintLayout2, TextView textView10, MaterialRadioButton materialRadioButton3, TextView textView11, G75 g752) {
        this.a = relativeLayout;
        this.b = materialRadioButton;
        this.c = textView;
        this.d = materialRadioButton2;
        this.e = textView2;
        this.f = g75;
        this.g = view;
        this.h = fullWidthButtonPrimary;
        this.i = nestedScrollView;
        this.j = textView3;
        this.k = materialCardView;
        this.l = constraintLayout;
        this.m = appBarLayout;
        this.n = baleToolbar;
        this.o = textView4;
        this.p = textView5;
        this.q = textView6;
        this.r = editText;
        this.s = imageView;
        this.t = textView7;
        this.u = textView8;
        this.v = radioGroup;
        this.w = textView9;
        this.x = constraintLayout2;
        this.y = textView10;
        this.z = materialRadioButton3;
        this.A = textView11;
        this.B = g752;
    }

    public static C9442Zy2 a(View view) {
        View viewA;
        View viewA2;
        int i = BC5.all_trans_filter_rb;
        MaterialRadioButton materialRadioButton = (MaterialRadioButton) AbstractC11738dW7.a(view, i);
        if (materialRadioButton != null) {
            i = BC5.deposit_filter_counter;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.deposit_filter_rb;
                MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) AbstractC11738dW7.a(view, i);
                if (materialRadioButton2 != null) {
                    i = BC5.deposit_filter_title;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.deposit_filters))) != null) {
                        G75 g75A = G75.a(viewA);
                        i = BC5.divider;
                        View viewA3 = AbstractC11738dW7.a(view, i);
                        if (viewA3 != null) {
                            i = BC5.do_filter_btn;
                            FullWidthButtonPrimary fullWidthButtonPrimary = (FullWidthButtonPrimary) AbstractC11738dW7.a(view, i);
                            if (fullWidthButtonPrimary != null) {
                                i = BC5.filter_scroll_view;
                                NestedScrollView nestedScrollView = (NestedScrollView) AbstractC11738dW7.a(view, i);
                                if (nestedScrollView != null) {
                                    i = BC5.no_find_tag;
                                    TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView3 != null) {
                                        i = BC5.pfm_search_cv;
                                        MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                        if (materialCardView != null) {
                                            i = BC5.pfm_search_inner_container;
                                            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                            if (constraintLayout != null) {
                                                i = BC5.pfm_trans_filter_appbar;
                                                AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
                                                if (appBarLayout != null) {
                                                    i = BC5.pfm_trans_filter_toolbar;
                                                    BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                                    if (baleToolbar != null) {
                                                        i = BC5.remove_all_filter;
                                                        TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView4 != null) {
                                                            i = BC5.selected_filter_counter;
                                                            TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                            if (textView5 != null) {
                                                                i = BC5.selected_filter_title;
                                                                TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                                if (textView6 != null) {
                                                                    i = BC5.tag_search_et;
                                                                    EditText editText = (EditText) AbstractC11738dW7.a(view, i);
                                                                    if (editText != null) {
                                                                        i = BC5.tag_search_icon;
                                                                        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                                                                        if (imageView != null) {
                                                                            i = BC5.tags_sub_title;
                                                                            TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                                            if (textView7 != null) {
                                                                                i = BC5.tags_title;
                                                                                TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                if (textView8 != null) {
                                                                                    i = BC5.trans_filter_rg;
                                                                                    RadioGroup radioGroup = (RadioGroup) AbstractC11738dW7.a(view, i);
                                                                                    if (radioGroup != null) {
                                                                                        i = BC5.transaction_type_title;
                                                                                        TextView textView9 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                        if (textView9 != null) {
                                                                                            i = BC5.view_fix;
                                                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                            if (constraintLayout2 != null) {
                                                                                                i = BC5.withdraw_filter_counter;
                                                                                                TextView textView10 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                if (textView10 != null) {
                                                                                                    i = BC5.withdraw_filter_rb;
                                                                                                    MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) AbstractC11738dW7.a(view, i);
                                                                                                    if (materialRadioButton3 != null) {
                                                                                                        i = BC5.withdraw_filter_title;
                                                                                                        TextView textView11 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                        if (textView11 != null && (viewA2 = AbstractC11738dW7.a(view, (i = BC5.withdraw_filters))) != null) {
                                                                                                            return new C9442Zy2((RelativeLayout) view, materialRadioButton, textView, materialRadioButton2, textView2, g75A, viewA3, fullWidthButtonPrimary, nestedScrollView, textView3, materialCardView, constraintLayout, appBarLayout, baleToolbar, textView4, textView5, textView6, editText, imageView, textView7, textView8, radioGroup, textView9, constraintLayout2, textView10, materialRadioButton3, textView11, G75.a(viewA2));
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C9442Zy2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_pfm_trans_filter, viewGroup, false);
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

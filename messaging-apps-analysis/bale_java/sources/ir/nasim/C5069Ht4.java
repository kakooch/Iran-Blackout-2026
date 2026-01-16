package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.designsystem.button.FullWidthButtonPrimary;

/* renamed from: ir.nasim.Ht4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5069Ht4 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ComposeView b;
    public final View c;
    public final FullWidthButtonPrimary d;
    public final TextView e;
    public final ConstraintLayout f;
    public final CardView g;
    public final ConstraintLayout h;
    public final EditText i;
    public final View j;
    public final CardView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final ScrollView p;
    public final TextView q;

    private C5069Ht4(ConstraintLayout constraintLayout, ComposeView composeView, View view, FullWidthButtonPrimary fullWidthButtonPrimary, TextView textView, ConstraintLayout constraintLayout2, CardView cardView, ConstraintLayout constraintLayout3, EditText editText, View view2, CardView cardView2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ScrollView scrollView, TextView textView6) {
        this.a = constraintLayout;
        this.b = composeView;
        this.c = view;
        this.d = fullWidthButtonPrimary;
        this.e = textView;
        this.f = constraintLayout2;
        this.g = cardView;
        this.h = constraintLayout3;
        this.i = editText;
        this.j = view2;
        this.k = cardView2;
        this.l = textView2;
        this.m = textView3;
        this.n = textView4;
        this.o = textView5;
        this.p = scrollView;
        this.q = textView6;
    }

    public static C5069Ht4 a(View view) {
        View viewA;
        View viewA2;
        int i = BC5.bottom_sheet;
        ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
        if (composeView != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.bottom_view))) != null) {
            i = BC5.button_continue;
            FullWidthButtonPrimary fullWidthButtonPrimary = (FullWidthButtonPrimary) AbstractC11738dW7.a(view, i);
            if (fullWidthButtonPrimary != null) {
                i = BC5.button_country_select_title;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = BC5.cv_country_select;
                    CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
                    if (cardView != null) {
                        i = BC5.email_login_form;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                        if (constraintLayout2 != null) {
                            i = BC5.et_phone_number;
                            EditText editText = (EditText) AbstractC11738dW7.a(view, i);
                            if (editText != null && (viewA2 = AbstractC11738dW7.a(view, (i = BC5.path))) != null) {
                                i = BC5.phone_number_card_view;
                                CardView cardView2 = (CardView) AbstractC11738dW7.a(view, i);
                                if (cardView2 != null) {
                                    i = BC5.phone_sign_hint;
                                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView2 != null) {
                                        i = BC5.plus;
                                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView3 != null) {
                                            i = BC5.separator;
                                            TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView4 != null) {
                                                i = BC5.sign_in_number_description;
                                                TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                if (textView5 != null) {
                                                    i = BC5.signPhoneRoot;
                                                    ScrollView scrollView = (ScrollView) AbstractC11738dW7.a(view, i);
                                                    if (scrollView != null) {
                                                        i = BC5.tv_country_code;
                                                        TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView6 != null) {
                                                            return new C5069Ht4(constraintLayout, composeView, viewA, fullWidthButtonPrimary, textView, constraintLayout, cardView, constraintLayout2, editText, viewA2, cardView2, textView2, textView3, textView4, textView5, scrollView, textView6);
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

    public static C5069Ht4 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.new_fragment_sign_phone, viewGroup, false);
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

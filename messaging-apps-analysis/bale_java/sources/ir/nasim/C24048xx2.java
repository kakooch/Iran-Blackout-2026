package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.components.textfield.view.CustomInputView;
import ir.nasim.designsystem.button.FullWidthButtonPrimary;

/* renamed from: ir.nasim.xx2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24048xx2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final CustomInputView b;
    public final MaterialCardView c;
    public final RecyclerView d;
    public final FullWidthButtonPrimary e;
    public final CustomInputView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final View j;
    public final MaterialButton k;
    public final TextView l;
    public final Guideline m;
    public final ConstraintLayout n;
    public final CustomInputView o;
    public final NestedScrollView p;
    public final CustomInputView q;
    public final MaterialCardView r;
    public final TextView s;
    public final TextView t;
    public final CustomInputView u;

    private C24048xx2(ConstraintLayout constraintLayout, CustomInputView customInputView, MaterialCardView materialCardView, RecyclerView recyclerView, FullWidthButtonPrimary fullWidthButtonPrimary, CustomInputView customInputView2, TextView textView, TextView textView2, TextView textView3, View view, MaterialButton materialButton, TextView textView4, Guideline guideline, ConstraintLayout constraintLayout2, CustomInputView customInputView3, NestedScrollView nestedScrollView, CustomInputView customInputView4, MaterialCardView materialCardView2, TextView textView5, TextView textView6, CustomInputView customInputView5) {
        this.a = constraintLayout;
        this.b = customInputView;
        this.c = materialCardView;
        this.d = recyclerView;
        this.e = fullWidthButtonPrimary;
        this.f = customInputView2;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
        this.j = view;
        this.k = materialButton;
        this.l = textView4;
        this.m = guideline;
        this.n = constraintLayout2;
        this.o = customInputView3;
        this.p = nestedScrollView;
        this.q = customInputView4;
        this.r = materialCardView2;
        this.s = textView5;
        this.t = textView6;
        this.u = customInputView5;
    }

    public static C24048xx2 a(View view) {
        View viewA;
        int i = BC5.cardNumberInput;
        CustomInputView customInputView = (CustomInputView) AbstractC11738dW7.a(view, i);
        if (customInputView != null) {
            i = BC5.cardSuggestionCard;
            MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
            if (materialCardView != null) {
                i = BC5.cardSuggestionRecycler;
                RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                if (recyclerView != null) {
                    i = BC5.continueCard;
                    FullWidthButtonPrimary fullWidthButtonPrimary = (FullWidthButtonPrimary) AbstractC11738dW7.a(view, i);
                    if (fullWidthButtonPrimary != null) {
                        i = BC5.cvv2Input;
                        CustomInputView customInputView2 = (CustomInputView) AbstractC11738dW7.a(view, i);
                        if (customInputView2 != null) {
                            i = BC5.dateDividerTxt;
                            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView != null) {
                                i = BC5.descriptionTxt;
                                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView2 != null) {
                                    i = BC5.descriptionTxt2;
                                    TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView3 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.divider))) != null) {
                                        i = BC5.dynamicPasswordBtn;
                                        MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
                                        if (materialButton != null) {
                                            i = BC5.dynamicPasswordDescTxt;
                                            TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView4 != null) {
                                                i = BC5.guideline6;
                                                Guideline guideline = (Guideline) AbstractC11738dW7.a(view, i);
                                                if (guideline != null) {
                                                    i = BC5.layoutSupportedBankTitle;
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                    if (constraintLayout != null) {
                                                        i = BC5.monthInput;
                                                        CustomInputView customInputView3 = (CustomInputView) AbstractC11738dW7.a(view, i);
                                                        if (customInputView3 != null) {
                                                            i = BC5.nestedScrollView;
                                                            NestedScrollView nestedScrollView = (NestedScrollView) AbstractC11738dW7.a(view, i);
                                                            if (nestedScrollView != null) {
                                                                i = BC5.pin2Input;
                                                                CustomInputView customInputView4 = (CustomInputView) AbstractC11738dW7.a(view, i);
                                                                if (customInputView4 != null) {
                                                                    i = BC5.secondPasswordCard;
                                                                    MaterialCardView materialCardView2 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                                    if (materialCardView2 != null) {
                                                                        i = BC5.textTitleSupportedBank;
                                                                        TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                                        if (textView5 != null) {
                                                                            i = BC5.textTitleSupportedBankComingSoon;
                                                                            TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                                            if (textView6 != null) {
                                                                                i = BC5.yearInput;
                                                                                CustomInputView customInputView5 = (CustomInputView) AbstractC11738dW7.a(view, i);
                                                                                if (customInputView5 != null) {
                                                                                    return new C24048xx2((ConstraintLayout) view, customInputView, materialCardView, recyclerView, fullWidthButtonPrimary, customInputView2, textView, textView2, textView3, viewA, materialButton, textView4, guideline, constraintLayout, customInputView3, nestedScrollView, customInputView4, materialCardView2, textView5, textView6, customInputView5);
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

    public static C24048xx2 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C24048xx2 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_balance, viewGroup, false);
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

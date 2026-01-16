package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.components.textfield.view.CustomInputView;

/* renamed from: ir.nasim.Jz2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5589Jz2 implements InterfaceC9764aW7 {
    public final CheckBox A;
    public final MaterialCardView B;
    public final ImageView C;
    public final MaterialCardView D;
    public final TextView E;
    public final ConstraintLayout F;
    public final CustomInputView G;
    private final ConstraintLayout a;
    public final TextView b;
    public final CustomInputView c;
    public final CustomInputView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final ImageView i;
    public final MaterialCardView j;
    public final TextView k;
    public final TextView l;
    public final View m;
    public final View n;
    public final MaterialButton o;
    public final TextView p;
    public final Guideline q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final CustomInputView v;
    public final NestedScrollView w;
    public final MaterialCardView x;
    public final TextView y;
    public final CustomInputView z;

    private C5589Jz2(ConstraintLayout constraintLayout, TextView textView, CustomInputView customInputView, CustomInputView customInputView2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ImageView imageView, MaterialCardView materialCardView, TextView textView6, TextView textView7, View view, View view2, MaterialButton materialButton, TextView textView8, Guideline guideline, TextView textView9, TextView textView10, TextView textView11, TextView textView12, CustomInputView customInputView3, NestedScrollView nestedScrollView, MaterialCardView materialCardView2, TextView textView13, CustomInputView customInputView4, CheckBox checkBox, MaterialCardView materialCardView3, ImageView imageView2, MaterialCardView materialCardView4, TextView textView14, ConstraintLayout constraintLayout2, CustomInputView customInputView5) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = customInputView;
        this.d = customInputView2;
        this.e = textView2;
        this.f = textView3;
        this.g = textView4;
        this.h = textView5;
        this.i = imageView;
        this.j = materialCardView;
        this.k = textView6;
        this.l = textView7;
        this.m = view;
        this.n = view2;
        this.o = materialButton;
        this.p = textView8;
        this.q = guideline;
        this.r = textView9;
        this.s = textView10;
        this.t = textView11;
        this.u = textView12;
        this.v = customInputView3;
        this.w = nestedScrollView;
        this.x = materialCardView2;
        this.y = textView13;
        this.z = customInputView4;
        this.A = checkBox;
        this.B = materialCardView3;
        this.C = imageView2;
        this.D = materialCardView4;
        this.E = textView14;
        this.F = constraintLayout2;
        this.G = customInputView5;
    }

    public static C5589Jz2 a(View view) {
        View viewA;
        View viewA2;
        int i = BC5.amountTxt;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            i = BC5.confirmCodeInput;
            CustomInputView customInputView = (CustomInputView) AbstractC11738dW7.a(view, i);
            if (customInputView != null) {
                i = BC5.cvv2Input;
                CustomInputView customInputView2 = (CustomInputView) AbstractC11738dW7.a(view, i);
                if (customInputView2 != null) {
                    i = BC5.dateDividerTxt;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        i = BC5.descInsertVerifyCodeTxt;
                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView3 != null) {
                            i = BC5.descSendVerifyCodeTxt;
                            TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView4 != null) {
                                i = BC5.descriptionTxt;
                                TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView5 != null) {
                                    i = BC5.destinationBankLogoImg;
                                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                                    if (imageView != null) {
                                        i = BC5.destinationCard;
                                        MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                        if (materialCardView != null) {
                                            i = BC5.destinationNumberTxt;
                                            TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView6 != null) {
                                                i = BC5.destinationOwnerNameTxt;
                                                TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                if (textView7 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.divider))) != null && (viewA2 = AbstractC11738dW7.a(view, (i = BC5.dividerCheckBox))) != null) {
                                                    i = BC5.dynamicPasswordBtn;
                                                    MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
                                                    if (materialButton != null) {
                                                        i = BC5.dynamicPasswordDescTxt;
                                                        TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView8 != null) {
                                                            i = BC5.guideline6;
                                                            Guideline guideline = (Guideline) AbstractC11738dW7.a(view, i);
                                                            if (guideline != null) {
                                                                i = BC5.lblAmountTxt;
                                                                TextView textView9 = (TextView) AbstractC11738dW7.a(view, i);
                                                                if (textView9 != null) {
                                                                    i = BC5.lblDestinationNumberTxt;
                                                                    TextView textView10 = (TextView) AbstractC11738dW7.a(view, i);
                                                                    if (textView10 != null) {
                                                                        i = BC5.lblDestinationOwnerNameTxt;
                                                                        TextView textView11 = (TextView) AbstractC11738dW7.a(view, i);
                                                                        if (textView11 != null) {
                                                                            i = BC5.lblSourceNumberTxt;
                                                                            TextView textView12 = (TextView) AbstractC11738dW7.a(view, i);
                                                                            if (textView12 != null) {
                                                                                i = BC5.monthInput;
                                                                                CustomInputView customInputView3 = (CustomInputView) AbstractC11738dW7.a(view, i);
                                                                                if (customInputView3 != null) {
                                                                                    i = BC5.nestedScrollView;
                                                                                    NestedScrollView nestedScrollView = (NestedScrollView) AbstractC11738dW7.a(view, i);
                                                                                    if (nestedScrollView != null) {
                                                                                        i = BC5.paymentCard;
                                                                                        MaterialCardView materialCardView2 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                                                        if (materialCardView2 != null) {
                                                                                            i = BC5.paymentTxt;
                                                                                            TextView textView13 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                            if (textView13 != null) {
                                                                                                i = BC5.pin2Input;
                                                                                                CustomInputView customInputView4 = (CustomInputView) AbstractC11738dW7.a(view, i);
                                                                                                if (customInputView4 != null) {
                                                                                                    i = BC5.saveDestinationCheckBox;
                                                                                                    CheckBox checkBox = (CheckBox) AbstractC11738dW7.a(view, i);
                                                                                                    if (checkBox != null) {
                                                                                                        i = BC5.secondPasswordCard;
                                                                                                        MaterialCardView materialCardView3 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                                                                        if (materialCardView3 != null) {
                                                                                                            i = BC5.sourceBankLogoImg;
                                                                                                            ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                            if (imageView2 != null) {
                                                                                                                i = BC5.sourceCard;
                                                                                                                MaterialCardView materialCardView4 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                                                                                if (materialCardView4 != null) {
                                                                                                                    i = BC5.sourceNumberTxt;
                                                                                                                    TextView textView14 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                    if (textView14 != null) {
                                                                                                                        i = BC5.verifyLayout;
                                                                                                                        ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                                                        if (constraintLayout != null) {
                                                                                                                            i = BC5.yearInput;
                                                                                                                            CustomInputView customInputView5 = (CustomInputView) AbstractC11738dW7.a(view, i);
                                                                                                                            if (customInputView5 != null) {
                                                                                                                                return new C5589Jz2((ConstraintLayout) view, textView, customInputView, customInputView2, textView2, textView3, textView4, textView5, imageView, materialCardView, textView6, textView7, viewA, viewA2, materialButton, textView8, guideline, textView9, textView10, textView11, textView12, customInputView3, nestedScrollView, materialCardView2, textView13, customInputView4, checkBox, materialCardView3, imageView2, materialCardView4, textView14, constraintLayout, customInputView5);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C5589Jz2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_verify_new, viewGroup, false);
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

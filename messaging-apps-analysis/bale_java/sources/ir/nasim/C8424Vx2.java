package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.makeramen.roundedimageview.RoundedImageView;
import ir.nasim.components.textfield.view.CustomInputView;

/* renamed from: ir.nasim.Vx2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8424Vx2 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final MaterialCardView b;
    public final CardView c;
    public final ImageButton d;
    public final RoundedImageView e;
    public final TextView f;
    public final ConstraintLayout g;
    public final CustomInputView h;
    public final CustomInputView i;
    public final MaterialCardView j;
    public final RecyclerView k;
    public final View l;
    public final LinearLayout m;
    public final NestedScrollView n;
    public final MaterialCardView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final CustomInputView t;
    public final Switch u;
    public final TextView v;

    private C8424Vx2(FrameLayout frameLayout, MaterialCardView materialCardView, CardView cardView, ImageButton imageButton, RoundedImageView roundedImageView, TextView textView, ConstraintLayout constraintLayout, CustomInputView customInputView, CustomInputView customInputView2, MaterialCardView materialCardView2, RecyclerView recyclerView, View view, LinearLayout linearLayout, NestedScrollView nestedScrollView, MaterialCardView materialCardView3, TextView textView2, TextView textView3, TextView textView4, TextView textView5, CustomInputView customInputView3, Switch r23, TextView textView6) {
        this.a = frameLayout;
        this.b = materialCardView;
        this.c = cardView;
        this.d = imageButton;
        this.e = roundedImageView;
        this.f = textView;
        this.g = constraintLayout;
        this.h = customInputView;
        this.i = customInputView2;
        this.j = materialCardView2;
        this.k = recyclerView;
        this.l = view;
        this.m = linearLayout;
        this.n = nestedScrollView;
        this.o = materialCardView3;
        this.p = textView2;
        this.q = textView3;
        this.r = textView4;
        this.s = textView5;
        this.t = customInputView3;
        this.u = r23;
        this.v = textView6;
    }

    public static C8424Vx2 a(View view) {
        View viewA;
        int i = BC5.amountCard;
        MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
        if (materialCardView != null) {
            i = BC5.attachCard;
            CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
            if (cardView != null) {
                i = BC5.attachDeleteImgBtn;
                ImageButton imageButton = (ImageButton) AbstractC11738dW7.a(view, i);
                if (imageButton != null) {
                    i = BC5.attachImg;
                    RoundedImageView roundedImageView = (RoundedImageView) AbstractC11738dW7.a(view, i);
                    if (roundedImageView != null) {
                        i = BC5.attachTitleTxt;
                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView != null) {
                            i = BC5.create_container;
                            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                            if (constraintLayout != null) {
                                i = BC5.descriptionInput;
                                CustomInputView customInputView = (CustomInputView) AbstractC11738dW7.a(view, i);
                                if (customInputView != null) {
                                    i = BC5.destinationCardNumberInput;
                                    CustomInputView customInputView2 = (CustomInputView) AbstractC11738dW7.a(view, i);
                                    if (customInputView2 != null) {
                                        i = BC5.destinationSuggestionCard;
                                        MaterialCardView materialCardView2 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                        if (materialCardView2 != null) {
                                            i = BC5.destinationSuggestionRecycler;
                                            RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                                            if (recyclerView != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.divider))) != null) {
                                                i = BC5.l_info_container;
                                                LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                if (linearLayout != null) {
                                                    i = BC5.nestedScrollView;
                                                    NestedScrollView nestedScrollView = (NestedScrollView) AbstractC11738dW7.a(view, i);
                                                    if (nestedScrollView != null) {
                                                        i = BC5.sendMessageCard;
                                                        MaterialCardView materialCardView3 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                        if (materialCardView3 != null) {
                                                            i = BC5.sendMessageTxt;
                                                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                                            if (textView2 != null) {
                                                                i = BC5.txt_description_text;
                                                                TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                                                if (textView3 != null) {
                                                                    i = BC5.txt_description_title;
                                                                    TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                                                    if (textView4 != null) {
                                                                        i = BC5.variableAmountHintTxt;
                                                                        TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                                        if (textView5 != null) {
                                                                            i = BC5.variableAmountInput;
                                                                            CustomInputView customInputView3 = (CustomInputView) AbstractC11738dW7.a(view, i);
                                                                            if (customInputView3 != null) {
                                                                                i = BC5.variableAmountSwitch;
                                                                                Switch r24 = (Switch) AbstractC11738dW7.a(view, i);
                                                                                if (r24 != null) {
                                                                                    i = BC5.variableAmountTitleTxt;
                                                                                    TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                    if (textView6 != null) {
                                                                                        return new C8424Vx2((FrameLayout) view, materialCardView, cardView, imageButton, roundedImageView, textView, constraintLayout, customInputView, customInputView2, materialCardView2, recyclerView, viewA, linearLayout, nestedScrollView, materialCardView3, textView2, textView3, textView4, textView5, customInputView3, r24, textView6);
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

    public static C8424Vx2 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C8424Vx2 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_create_money_request, viewGroup, false);
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

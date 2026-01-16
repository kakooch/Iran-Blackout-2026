package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.components.textfield.view.CustomInputView;
import ir.nasim.features.payment.widget.LockableNestedScrollView;

/* renamed from: ir.nasim.Sx2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7717Sx2 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final MaterialCardView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final ImageView g;
    public final ConstraintLayout h;
    public final ImageView i;
    public final MaterialCardView j;
    public final TextView k;
    public final ConstraintLayout l;
    public final CustomInputView m;
    public final CustomInputView n;
    public final MaterialCardView o;
    public final RecyclerView p;
    public final LinearLayout q;
    public final LockableNestedScrollView r;
    public final MaterialCardView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final CustomInputView w;
    public final CustomInputView x;
    public final TextView y;
    public final TextView z;

    private C7717Sx2(FrameLayout frameLayout, MaterialCardView materialCardView, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView, ConstraintLayout constraintLayout, ImageView imageView2, MaterialCardView materialCardView2, TextView textView5, ConstraintLayout constraintLayout2, CustomInputView customInputView, CustomInputView customInputView2, MaterialCardView materialCardView3, RecyclerView recyclerView, LinearLayout linearLayout, LockableNestedScrollView lockableNestedScrollView, MaterialCardView materialCardView4, TextView textView6, TextView textView7, TextView textView8, CustomInputView customInputView3, CustomInputView customInputView4, TextView textView9, TextView textView10) {
        this.a = frameLayout;
        this.b = materialCardView;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
        this.g = imageView;
        this.h = constraintLayout;
        this.i = imageView2;
        this.j = materialCardView2;
        this.k = textView5;
        this.l = constraintLayout2;
        this.m = customInputView;
        this.n = customInputView2;
        this.o = materialCardView3;
        this.p = recyclerView;
        this.q = linearLayout;
        this.r = lockableNestedScrollView;
        this.s = materialCardView4;
        this.t = textView6;
        this.u = textView7;
        this.v = textView8;
        this.w = customInputView3;
        this.x = customInputView4;
        this.y = textView9;
        this.z = textView10;
    }

    public static C7717Sx2 a(View view) {
        int i = BC5.activityDurationCard;
        MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
        if (materialCardView != null) {
            i = BC5.activityDurationOptionTxt;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.activityDurationTitleTxt;
                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView2 != null) {
                    i = BC5.attachDeleteImgBtn;
                    TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView3 != null) {
                        i = BC5.attachImageTxt;
                        TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView4 != null) {
                            i = BC5.attachImg;
                            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                            if (imageView != null) {
                                i = BC5.attachLayout;
                                ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                if (constraintLayout != null) {
                                    i = BC5.attachedImg;
                                    ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                    if (imageView2 != null) {
                                        i = BC5.continueCard;
                                        MaterialCardView materialCardView2 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                        if (materialCardView2 != null) {
                                            i = BC5.continueTxt;
                                            TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView5 != null) {
                                                i = BC5.create_cr_container;
                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                if (constraintLayout2 != null) {
                                                    i = BC5.description_input;
                                                    CustomInputView customInputView = (CustomInputView) AbstractC11738dW7.a(view, i);
                                                    if (customInputView != null) {
                                                        i = BC5.destinationCardNumberInput;
                                                        CustomInputView customInputView2 = (CustomInputView) AbstractC11738dW7.a(view, i);
                                                        if (customInputView2 != null) {
                                                            i = BC5.destinationSuggestionCard;
                                                            MaterialCardView materialCardView3 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                            if (materialCardView3 != null) {
                                                                i = BC5.destinationSuggestionRecycler;
                                                                RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                                                                if (recyclerView != null) {
                                                                    i = BC5.l_info_container;
                                                                    LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                                    if (linearLayout != null) {
                                                                        i = BC5.nestedScrollView;
                                                                        LockableNestedScrollView lockableNestedScrollView = (LockableNestedScrollView) AbstractC11738dW7.a(view, i);
                                                                        if (lockableNestedScrollView != null) {
                                                                            i = BC5.quotaAmountCard;
                                                                            MaterialCardView materialCardView4 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                                            if (materialCardView4 != null) {
                                                                                i = BC5.quotaAmountOptionTxt;
                                                                                TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                if (textView6 != null) {
                                                                                    i = BC5.quotaAmountTitleTxt;
                                                                                    TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                    if (textView7 != null) {
                                                                                        i = BC5.quotaCountTxt;
                                                                                        TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                        if (textView8 != null) {
                                                                                            i = BC5.targetAmountInput;
                                                                                            CustomInputView customInputView3 = (CustomInputView) AbstractC11738dW7.a(view, i);
                                                                                            if (customInputView3 != null) {
                                                                                                i = BC5.titleInput;
                                                                                                CustomInputView customInputView4 = (CustomInputView) AbstractC11738dW7.a(view, i);
                                                                                                if (customInputView4 != null) {
                                                                                                    i = BC5.txt_description_text;
                                                                                                    TextView textView9 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                    if (textView9 != null) {
                                                                                                        i = BC5.txt_description_title;
                                                                                                        TextView textView10 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                        if (textView10 != null) {
                                                                                                            return new C7717Sx2((FrameLayout) view, materialCardView, textView, textView2, textView3, textView4, imageView, constraintLayout, imageView2, materialCardView2, textView5, constraintLayout2, customInputView, customInputView2, materialCardView3, recyclerView, linearLayout, lockableNestedScrollView, materialCardView4, textView6, textView7, textView8, customInputView3, customInputView4, textView9, textView10);
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

    public static C7717Sx2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_create_crowdfunding, viewGroup, false);
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

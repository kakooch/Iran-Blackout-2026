package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.makeramen.roundedimageview.RoundedImageView;
import ir.nasim.components.textfield.view.CustomInputView;
import ir.nasim.designsystem.button.FullWidthButtonPrimary;

/* renamed from: ir.nasim.ky2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16259ky2 implements InterfaceC9764aW7 {
    public final RecyclerView A;
    public final TextView B;
    public final TextView C;
    public final ImageView D;
    public final View E;
    private final ConstraintLayout a;
    public final RoundedImageView b;
    public final LinearLayout c;
    public final ImageView d;
    public final TextView e;
    public final ConstraintLayout f;
    public final ImageView g;
    public final TextView h;
    public final TextView i;
    public final FullWidthButtonPrimary j;
    public final MaterialCardView k;
    public final RecyclerView l;
    public final View m;
    public final ImageView n;
    public final CustomInputView o;
    public final CustomInputView p;
    public final CustomInputView q;
    public final CustomInputView r;
    public final ConstraintLayout s;
    public final NestedScrollView t;
    public final MaterialButton u;
    public final MaterialCardView v;
    public final LinearLayout w;
    public final TextView x;
    public final RecyclerView y;
    public final MaterialCardView z;

    private C16259ky2(ConstraintLayout constraintLayout, RoundedImageView roundedImageView, LinearLayout linearLayout, ImageView imageView, TextView textView, ConstraintLayout constraintLayout2, ImageView imageView2, TextView textView2, TextView textView3, FullWidthButtonPrimary fullWidthButtonPrimary, MaterialCardView materialCardView, RecyclerView recyclerView, View view, ImageView imageView3, CustomInputView customInputView, CustomInputView customInputView2, CustomInputView customInputView3, CustomInputView customInputView4, ConstraintLayout constraintLayout3, NestedScrollView nestedScrollView, MaterialButton materialButton, MaterialCardView materialCardView2, LinearLayout linearLayout2, TextView textView4, RecyclerView recyclerView2, MaterialCardView materialCardView3, RecyclerView recyclerView3, TextView textView5, TextView textView6, ImageView imageView4, View view2) {
        this.a = constraintLayout;
        this.b = roundedImageView;
        this.c = linearLayout;
        this.d = imageView;
        this.e = textView;
        this.f = constraintLayout2;
        this.g = imageView2;
        this.h = textView2;
        this.i = textView3;
        this.j = fullWidthButtonPrimary;
        this.k = materialCardView;
        this.l = recyclerView;
        this.m = view;
        this.n = imageView3;
        this.o = customInputView;
        this.p = customInputView2;
        this.q = customInputView3;
        this.r = customInputView4;
        this.s = constraintLayout3;
        this.t = nestedScrollView;
        this.u = materialButton;
        this.v = materialCardView2;
        this.w = linearLayout2;
        this.x = textView4;
        this.y = recyclerView2;
        this.z = materialCardView3;
        this.A = recyclerView3;
        this.B = textView5;
        this.C = textView6;
        this.D = imageView4;
        this.E = view2;
    }

    public static C16259ky2 a(View view) {
        View viewA;
        View viewA2;
        int i = BC5.avatarImg;
        RoundedImageView roundedImageView = (RoundedImageView) AbstractC11738dW7.a(view, i);
        if (roundedImageView != null) {
            i = BC5.avoidClickLayout;
            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
            if (linearLayout != null) {
                i = BC5.bankClipboardLogo;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = BC5.cardNumberClipBoardTxt;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        i = BC5.clipboardLayout;
                        ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                        if (constraintLayout != null) {
                            i = BC5.closeClipboardImg;
                            ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                            if (imageView2 != null) {
                                i = BC5.contactNameTitleTxt;
                                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView2 != null) {
                                    i = BC5.contactNameTxt;
                                    TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView3 != null) {
                                        i = BC5.continueCard;
                                        FullWidthButtonPrimary fullWidthButtonPrimary = (FullWidthButtonPrimary) AbstractC11738dW7.a(view, i);
                                        if (fullWidthButtonPrimary != null) {
                                            i = BC5.destCardSuggestionCard;
                                            MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                            if (materialCardView != null) {
                                                i = BC5.destCardSuggestionRecycler;
                                                RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                                                if (recyclerView != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.divider))) != null) {
                                                    i = BC5.imageView10;
                                                    ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                                    if (imageView3 != null) {
                                                        i = BC5.inputAmount;
                                                        CustomInputView customInputView = (CustomInputView) AbstractC11738dW7.a(view, i);
                                                        if (customInputView != null) {
                                                            i = BC5.inputDescription;
                                                            CustomInputView customInputView2 = (CustomInputView) AbstractC11738dW7.a(view, i);
                                                            if (customInputView2 != null) {
                                                                i = BC5.inputDestinationCardNumber;
                                                                CustomInputView customInputView3 = (CustomInputView) AbstractC11738dW7.a(view, i);
                                                                if (customInputView3 != null) {
                                                                    i = BC5.inputSourceCardNumber;
                                                                    CustomInputView customInputView4 = (CustomInputView) AbstractC11738dW7.a(view, i);
                                                                    if (customInputView4 != null) {
                                                                        i = BC5.layoutSupportedBankTitle;
                                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                        if (constraintLayout2 != null) {
                                                                            i = BC5.nestedScrollView;
                                                                            NestedScrollView nestedScrollView = (NestedScrollView) AbstractC11738dW7.a(view, i);
                                                                            if (nestedScrollView != null) {
                                                                                i = BC5.pasteBtn;
                                                                                MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
                                                                                if (materialButton != null) {
                                                                                    i = BC5.peerCard;
                                                                                    MaterialCardView materialCardView2 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                                                    if (materialCardView2 != null) {
                                                                                        i = BC5.placeHolderLayout;
                                                                                        LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                                                        if (linearLayout2 != null) {
                                                                                            i = BC5.placeHolderTxt;
                                                                                            TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                            if (textView4 != null) {
                                                                                                i = BC5.recyclerSupportedBankLogoSlider;
                                                                                                RecyclerView recyclerView2 = (RecyclerView) AbstractC11738dW7.a(view, i);
                                                                                                if (recyclerView2 != null) {
                                                                                                    i = BC5.sourceCardSuggestionCard;
                                                                                                    MaterialCardView materialCardView3 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                                                                    if (materialCardView3 != null) {
                                                                                                        i = BC5.sourceCardSuggestionRecycler;
                                                                                                        RecyclerView recyclerView3 = (RecyclerView) AbstractC11738dW7.a(view, i);
                                                                                                        if (recyclerView3 != null) {
                                                                                                            i = BC5.textTitleSupportedBank;
                                                                                                            TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                            if (textView5 != null) {
                                                                                                                i = BC5.textTitleSupportedBankComingSoon;
                                                                                                                TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                if (textView6 != null) {
                                                                                                                    i = BC5.unselectContact;
                                                                                                                    ImageView imageView4 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                                    if (imageView4 != null && (viewA2 = AbstractC11738dW7.a(view, (i = BC5.view3))) != null) {
                                                                                                                        return new C16259ky2((ConstraintLayout) view, roundedImageView, linearLayout, imageView, textView, constraintLayout, imageView2, textView2, textView3, fullWidthButtonPrimary, materialCardView, recyclerView, viewA, imageView3, customInputView, customInputView2, customInputView3, customInputView4, constraintLayout2, nestedScrollView, materialButton, materialCardView2, linearLayout2, textView4, recyclerView2, materialCardView3, recyclerView3, textView5, textView6, imageView4, viewA2);
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

    public static C16259ky2 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C16259ky2 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_information, viewGroup, false);
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

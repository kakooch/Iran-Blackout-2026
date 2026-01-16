package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;

/* renamed from: ir.nasim.Pe3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6835Pe3 implements InterfaceC9764aW7 {
    private final MaterialCardView a;
    public final LinearLayout b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final ImageView f;
    public final TextView g;
    public final View h;
    public final MaterialCardView i;
    public final ImageButton j;
    public final TextView k;
    public final MaterialCardView l;
    public final TextView m;
    public final MaterialCardView n;
    public final TextView o;

    private C6835Pe3(MaterialCardView materialCardView, LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, TextView textView3, View view, MaterialCardView materialCardView2, ImageButton imageButton, TextView textView4, MaterialCardView materialCardView3, TextView textView5, MaterialCardView materialCardView4, TextView textView6) {
        this.a = materialCardView;
        this.b = linearLayout;
        this.c = imageView;
        this.d = textView;
        this.e = textView2;
        this.f = imageView2;
        this.g = textView3;
        this.h = view;
        this.i = materialCardView2;
        this.j = imageButton;
        this.k = textView4;
        this.l = materialCardView3;
        this.m = textView5;
        this.n = materialCardView4;
        this.o = textView6;
    }

    public static C6835Pe3 a(View view) {
        View viewA;
        int i = BC5.authentication_container;
        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
        if (linearLayout != null) {
            i = BC5.authentication_img;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = BC5.authentication_tv;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.badgeTxt;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        i = BC5.bankLogo;
                        ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                        if (imageView2 != null) {
                            i = BC5.cardNumberTxt;
                            TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView3 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.divider))) != null) {
                                i = BC5.materialCardView3;
                                MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                if (materialCardView != null) {
                                    i = BC5.more;
                                    ImageButton imageButton = (ImageButton) AbstractC11738dW7.a(view, i);
                                    if (imageButton != null) {
                                        i = BC5.nameTxt;
                                        TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView4 != null) {
                                            i = BC5.need_verfied_container;
                                            MaterialCardView materialCardView2 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                            if (materialCardView2 != null) {
                                                i = BC5.need_verfied_tv;
                                                TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                if (textView5 != null) {
                                                    i = BC5.verfied_container;
                                                    MaterialCardView materialCardView3 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                    if (materialCardView3 != null) {
                                                        i = BC5.verfied_tv;
                                                        TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView6 != null) {
                                                            return new C6835Pe3((MaterialCardView) view, linearLayout, imageView, textView, textView2, imageView2, textView3, viewA, materialCardView, imageButton, textView4, materialCardView2, textView5, materialCardView3, textView6);
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

    public static C6835Pe3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_card_payment_management_card_saved, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public MaterialCardView getRoot() {
        return this.a;
    }
}

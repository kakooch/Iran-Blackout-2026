package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.card.MaterialCardView;

/* renamed from: ir.nasim.g6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13362g6 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ImageButton b;
    public final MaterialCardView c;
    public final TextView d;
    public final FrameLayout e;
    public final ImageView f;
    public final CardView g;
    public final ImageButton h;
    public final View i;
    public final TextView j;
    public final TextView k;

    private C13362g6(ConstraintLayout constraintLayout, ImageButton imageButton, MaterialCardView materialCardView, TextView textView, FrameLayout frameLayout, ImageView imageView, CardView cardView, ImageButton imageButton2, View view, TextView textView2, TextView textView3) {
        this.a = constraintLayout;
        this.b = imageButton;
        this.c = materialCardView;
        this.d = textView;
        this.e = frameLayout;
        this.f = imageView;
        this.g = cardView;
        this.h = imageButton2;
        this.i = view;
        this.j = textView2;
        this.k = textView3;
    }

    public static C13362g6 a(View view) {
        View viewA;
        int i = BC5.back;
        ImageButton imageButton = (ImageButton) AbstractC11738dW7.a(view, i);
        if (imageButton != null) {
            i = BC5.card_toolbar;
            MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
            if (materialCardView != null) {
                i = BC5.close;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.fragment_container;
                    FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                    if (frameLayout != null) {
                        i = BC5.img_app_bar_info;
                        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                        if (imageView != null) {
                            i = BC5.info_container;
                            CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
                            if (cardView != null) {
                                i = BC5.more;
                                ImageButton imageButton2 = (ImageButton) AbstractC11738dW7.a(view, i);
                                if (imageButton2 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.statusBar_background))) != null) {
                                    i = BC5.titleTxt;
                                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView2 != null) {
                                        i = BC5.txt_app_bar_info;
                                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView3 != null) {
                                            return new C13362g6((ConstraintLayout) view, imageButton, materialCardView, textView, frameLayout, imageView, cardView, imageButton2, viewA, textView2, textView3);
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

    public static C13362g6 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C13362g6 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.activity_crowdfunding, viewGroup, false);
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

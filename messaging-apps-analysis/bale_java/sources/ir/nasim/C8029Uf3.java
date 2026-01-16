package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.Uf3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C8029Uf3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final CardView b;
    public final ImageView c;
    public final ImageView d;
    public final ConstraintLayout e;

    private C8029Uf3(ConstraintLayout constraintLayout, CardView cardView, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2) {
        this.a = constraintLayout;
        this.b = cardView;
        this.c = imageView;
        this.d = imageView2;
        this.e = constraintLayout2;
    }

    public static C8029Uf3 a(View view) {
        int i = AbstractC14017hC5.card;
        CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
        if (cardView != null) {
            i = AbstractC14017hC5.image;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = AbstractC14017hC5.placeHolder;
                ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    return new C8029Uf3(constraintLayout, cardView, imageView, imageView2, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C8029Uf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(JC5.item_search_result_post, viewGroup, false);
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

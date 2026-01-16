package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;

/* renamed from: ir.nasim.Dx2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4152Dx2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final MaterialButton b;
    public final TextView c;
    public final ImageView d;
    public final ConstraintLayout e;
    public final TextView f;
    public final MaterialButton g;
    public final ConstraintLayout h;
    public final RecyclerView i;

    private C4152Dx2(ConstraintLayout constraintLayout, MaterialButton materialButton, TextView textView, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView2, MaterialButton materialButton2, ConstraintLayout constraintLayout3, RecyclerView recyclerView) {
        this.a = constraintLayout;
        this.b = materialButton;
        this.c = textView;
        this.d = imageView;
        this.e = constraintLayout2;
        this.f = textView2;
        this.g = materialButton2;
        this.h = constraintLayout3;
        this.i = recyclerView;
    }

    public static C4152Dx2 a(View view) {
        int i = BC5.emptyAddBtn;
        MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
        if (materialButton != null) {
            i = BC5.emptyDescriptionTxt;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.emptyIconImg;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = BC5.emptyLayout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                    if (constraintLayout != null) {
                        i = BC5.emptyTitleTxt;
                        TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView2 != null) {
                            i = BC5.listAddBtn;
                            MaterialButton materialButton2 = (MaterialButton) AbstractC11738dW7.a(view, i);
                            if (materialButton2 != null) {
                                i = BC5.listLayout;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                if (constraintLayout2 != null) {
                                    i = BC5.listRecycler;
                                    RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                                    if (recyclerView != null) {
                                        return new C4152Dx2((ConstraintLayout) view, materialButton, textView, imageView, constraintLayout, textView2, materialButton2, constraintLayout2, recyclerView);
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

    public static C4152Dx2 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C4152Dx2 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_card_management, viewGroup, false);
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

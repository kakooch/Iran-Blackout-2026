package ir.nasim;

import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textview.MaterialTextView;

/* loaded from: classes5.dex */
public final class E17 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ImageView b;
    public final GridLayout c;
    public final ConstraintLayout d;
    public final RecyclerView e;
    public final MaterialTextView f;

    private E17(ConstraintLayout constraintLayout, ImageView imageView, GridLayout gridLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, MaterialTextView materialTextView) {
        this.a = constraintLayout;
        this.b = imageView;
        this.c = gridLayout;
        this.d = constraintLayout2;
        this.e = recyclerView;
        this.f = materialTextView;
    }

    public static E17 a(View view) {
        int i = BC5.closeRecommendedChannels;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            i = BC5.shimmer;
            GridLayout gridLayout = (GridLayout) AbstractC11738dW7.a(view, i);
            if (gridLayout != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = BC5.suggestedChannelsList;
                RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                if (recyclerView != null) {
                    i = BC5.textViewRecommendedChannels;
                    MaterialTextView materialTextView = (MaterialTextView) AbstractC11738dW7.a(view, i);
                    if (materialTextView != null) {
                        return new E17(constraintLayout, imageView, gridLayout, constraintLayout, recyclerView, materialTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}

package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

/* renamed from: ir.nasim.Xi1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8788Xi1 implements InterfaceC9764aW7 {
    private final MaterialCardView a;
    public final ShapeableImageView b;
    public final MaterialButton c;
    public final TextView d;
    public final TextView e;

    private C8788Xi1(MaterialCardView materialCardView, ShapeableImageView shapeableImageView, MaterialButton materialButton, TextView textView, TextView textView2) {
        this.a = materialCardView;
        this.b = shapeableImageView;
        this.c = materialButton;
        this.d = textView;
        this.e = textView2;
    }

    public static C8788Xi1 a(View view) {
        int i = BC5.alert_icon;
        ShapeableImageView shapeableImageView = (ShapeableImageView) AbstractC11738dW7.a(view, i);
        if (shapeableImageView != null) {
            i = BC5.button;
            MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
            if (materialButton != null) {
                i = BC5.description;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.title;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        return new C8788Xi1((MaterialCardView) view, shapeableImageView, materialButton, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C8788Xi1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.contacts_notic_card, viewGroup, false);
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

package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes5.dex */
public final class IG implements InterfaceC9764aW7 {
    private final MaterialCardView a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public final MaterialCardView e;
    public final MaterialButton f;
    public final MaterialButton g;

    private IG(MaterialCardView materialCardView, ImageView imageView, TextView textView, TextView textView2, MaterialCardView materialCardView2, MaterialButton materialButton, MaterialButton materialButton2) {
        this.a = materialCardView;
        this.b = imageView;
        this.c = textView;
        this.d = textView2;
        this.e = materialCardView2;
        this.f = materialButton;
        this.g = materialButton2;
    }

    public static IG a(View view) {
        int i = BC5.arbaeen_flag_iv;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            i = BC5.arbaeen_help_tv;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.arbaeen_title_tv;
                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView2 != null) {
                    MaterialCardView materialCardView = (MaterialCardView) view;
                    i = BC5.submit_status;
                    MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
                    if (materialButton != null) {
                        i = BC5.viewStatus;
                        MaterialButton materialButton2 = (MaterialButton) AbstractC11738dW7.a(view, i);
                        if (materialButton2 != null) {
                            return new IG(materialCardView, imageView, textView, textView2, materialCardView, materialButton, materialButton2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static IG c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static IG d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.arbaeen_fragemnt, viewGroup, false);
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

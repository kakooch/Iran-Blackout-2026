package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.eu4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12614eu4 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ImageView b;
    public final LinearLayout c;
    public final ConstraintLayout d;
    public final TextView e;
    public final TextView f;
    public final TextView g;

    private C12614eu4(ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.a = constraintLayout;
        this.b = imageView;
        this.c = linearLayout;
        this.d = constraintLayout2;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
    }

    public static C12614eu4 a(View view) {
        int i = BC5.btn_done;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            i = BC5.pagerBulletIndicator;
            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
            if (linearLayout != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = BC5.pagerBulletIndicatorText;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.text_btn_next;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        i = BC5.text_previous_next;
                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView3 != null) {
                            return new C12614eu4(constraintLayout, imageView, linearLayout, constraintLayout, textView, textView2, textView3);
                        }
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

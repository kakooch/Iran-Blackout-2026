package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.qx2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19796qx2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final Button b;
    public final Button c;
    public final TextView d;
    public final ImageView e;
    public final TextView f;

    private C19796qx2(ConstraintLayout constraintLayout, Button button, Button button2, TextView textView, ImageView imageView, TextView textView2) {
        this.a = constraintLayout;
        this.b = button;
        this.c = button2;
        this.d = textView;
        this.e = imageView;
        this.f = textView2;
    }

    public static C19796qx2 a(View view) {
        int i = BC5.confirmButton;
        Button button = (Button) AbstractC11738dW7.a(view, i);
        if (button != null) {
            i = BC5.declineButton;
            Button button2 = (Button) AbstractC11738dW7.a(view, i);
            if (button2 != null) {
                i = BC5.descriptionTxt;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.imageView;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null) {
                        i = BC5.title;
                        TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView2 != null) {
                            return new C19796qx2((ConstraintLayout) view, button, button2, textView, imageView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C19796qx2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_arbaeen_add_to_story_dialog, viewGroup, false);
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

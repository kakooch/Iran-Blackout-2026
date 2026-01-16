package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;

/* renamed from: ir.nasim.ay2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10036ay2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final MaterialButton b;
    public final MaterialButton c;
    public final TextView d;
    public final TextView e;

    private C10036ay2(LinearLayout linearLayout, MaterialButton materialButton, MaterialButton materialButton2, TextView textView, TextView textView2) {
        this.a = linearLayout;
        this.b = materialButton;
        this.c = materialButton2;
        this.d = textView;
        this.e = textView2;
    }

    public static C10036ay2 a(View view) {
        int i = BC5.cancel;
        MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
        if (materialButton != null) {
            i = BC5.cardRemove;
            MaterialButton materialButton2 = (MaterialButton) AbstractC11738dW7.a(view, i);
            if (materialButton2 != null) {
                i = BC5.description;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.title;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        return new C10036ay2((LinearLayout) view, materialButton, materialButton2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C10036ay2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_delete_card, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}

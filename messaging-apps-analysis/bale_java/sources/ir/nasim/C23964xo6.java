package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.xo6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23964xo6 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final Button c;
    public final CardView d;
    public final TextView e;
    public final Button f;

    private C23964xo6(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Button button, CardView cardView, TextView textView, Button button2) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = button;
        this.d = cardView;
        this.e = textView;
        this.f = button2;
    }

    public static C23964xo6 a(View view) {
        int i = BC5.send_gift_packet_button_constraint;
        ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
        if (constraintLayout != null) {
            i = BC5.send_gift_packet_cancel;
            Button button = (Button) AbstractC11738dW7.a(view, i);
            if (button != null) {
                i = BC5.send_gift_packet_loading;
                CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
                if (cardView != null) {
                    i = BC5.send_gift_packet_message;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        i = BC5.send_gift_packet_retry;
                        Button button2 = (Button) AbstractC11738dW7.a(view, i);
                        if (button2 != null) {
                            return new C23964xo6((ConstraintLayout) view, constraintLayout, button, cardView, textView, button2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C23964xo6 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.send_gift_packet_layout, viewGroup, false);
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

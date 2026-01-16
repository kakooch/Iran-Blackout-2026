package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.Qj1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7122Qj1 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final LinearLayout b;
    public final TextView c;
    public final TextView d;
    public final LinearLayout e;
    public final LinearLayout f;
    public final TextView g;
    public final LinearLayout h;
    public final TextView i;
    public final LinearLayout j;
    public final TextView k;

    private C7122Qj1(ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView3, LinearLayout linearLayout4, TextView textView4, LinearLayout linearLayout5, TextView textView5) {
        this.a = constraintLayout;
        this.b = linearLayout;
        this.c = textView;
        this.d = textView2;
        this.e = linearLayout2;
        this.f = linearLayout3;
        this.g = textView3;
        this.h = linearLayout4;
        this.i = textView4;
        this.j = linearLayout5;
        this.k = textView5;
    }

    public static C7122Qj1 a(View view) {
        int i = BC5.add_contact_item;
        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
        if (linearLayout != null) {
            i = BC5.add_contact_text;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.channel_text;
                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView2 != null) {
                    i = BC5.create_channel_item;
                    LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                    if (linearLayout2 != null) {
                        i = BC5.create_group_item;
                        LinearLayout linearLayout3 = (LinearLayout) AbstractC11738dW7.a(view, i);
                        if (linearLayout3 != null) {
                            i = BC5.group_text;
                            TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView3 != null) {
                                i = BC5.organization_item;
                                LinearLayout linearLayout4 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                if (linearLayout4 != null) {
                                    i = BC5.organization_text;
                                    TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView4 != null) {
                                        i = BC5.organization_title;
                                        LinearLayout linearLayout5 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                        if (linearLayout5 != null) {
                                            i = BC5.title;
                                            TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView5 != null) {
                                                return new C7122Qj1((ConstraintLayout) view, linearLayout, textView, textView2, linearLayout2, linearLayout3, textView3, linearLayout4, textView4, linearLayout5, textView5);
                                            }
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

    public static C7122Qj1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.contacts_top_options, viewGroup, false);
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

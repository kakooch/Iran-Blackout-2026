package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.h38, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13932h38 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final View b;
    public final O50 c;
    public final M18 d;
    public final C16314l38 e;
    public final C16905m38 f;
    public final C14530i38 g;

    private C13932h38(ConstraintLayout constraintLayout, View view, O50 o50, M18 m18, C16314l38 c16314l38, C16905m38 c16905m38, C14530i38 c14530i38) {
        this.a = constraintLayout;
        this.b = view;
        this.c = o50;
        this.d = m18;
        this.e = c16314l38;
        this.f = c16905m38;
        this.g = c14530i38;
    }

    public static C13932h38 a(View view) {
        View viewA;
        int i = BC5.loading_shadow_1;
        View viewA2 = AbstractC11738dW7.a(view, i);
        if (viewA2 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.progress_bar_view_1))) != null) {
            O50 o50A = O50.a(viewA);
            i = BC5.wallet_charge_type_view;
            View viewA3 = AbstractC11738dW7.a(view, i);
            if (viewA3 != null) {
                M18 m18A = M18.a(viewA3);
                i = BC5.wallet_pay_tab_views;
                View viewA4 = AbstractC11738dW7.a(view, i);
                if (viewA4 != null) {
                    C16314l38 c16314l38A = C16314l38.a(viewA4);
                    i = BC5.wallet_pay_transfer_type_view;
                    View viewA5 = AbstractC11738dW7.a(view, i);
                    if (viewA5 != null) {
                        C16905m38 c16905m38A = C16905m38.a(viewA5);
                        i = BC5.wallet_pay_verify_view;
                        View viewA6 = AbstractC11738dW7.a(view, i);
                        if (viewA6 != null) {
                            return new C13932h38((ConstraintLayout) view, viewA2, o50A, m18A, c16314l38A, c16905m38A, C14530i38.a(viewA6));
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C13932h38 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C13932h38 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.wallet_pay_layout, viewGroup, false);
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

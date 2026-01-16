package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.tabs.TabLayout;

/* renamed from: ir.nasim.l38, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16314l38 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ImageView b;
    public final TextView c;
    public final C13341g38 d;
    public final C15132j38 e;
    public final C15723k38 f;
    public final TextView g;
    public final TabLayout h;

    private C16314l38(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, C13341g38 c13341g38, C15132j38 c15132j38, C15723k38 c15723k38, TextView textView2, TabLayout tabLayout) {
        this.a = constraintLayout;
        this.b = imageView;
        this.c = textView;
        this.d = c13341g38;
        this.e = c15132j38;
        this.f = c15723k38;
        this.g = textView2;
        this.h = tabLayout;
    }

    public static C16314l38 a(View view) {
        View viewA;
        int i = BC5.wallet_pay_bottomsheet_flashlight;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            i = BC5.wallet_pay_bottomsheet_title;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.wallet_pay_enter_barcode_view))) != null) {
                C13341g38 c13341g38A = C13341g38.a(viewA);
                i = BC5.wallet_pay_my_barcode_view;
                View viewA2 = AbstractC11738dW7.a(view, i);
                if (viewA2 != null) {
                    C15132j38 c15132j38A = C15132j38.a(viewA2);
                    i = BC5.wallet_pay_scan_barcode_view;
                    View viewA3 = AbstractC11738dW7.a(view, i);
                    if (viewA3 != null) {
                        C15723k38 c15723k38A = C15723k38.a(viewA3);
                        i = BC5.wallet_pay_tab_bottomsheet_close;
                        TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView2 != null) {
                            i = BC5.wallet_pay_tabs;
                            TabLayout tabLayout = (TabLayout) AbstractC11738dW7.a(view, i);
                            if (tabLayout != null) {
                                return new C16314l38((ConstraintLayout) view, imageView, textView, c13341g38A, c15132j38A, c15723k38A, textView2, tabLayout);
                            }
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

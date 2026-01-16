package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/* renamed from: ir.nasim.k38, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15723k38 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ZXingScannerView b;
    public final ConstraintLayout c;
    public final ConstraintLayout d;
    public final ImageView e;
    public final TextView f;

    private C15723k38(ConstraintLayout constraintLayout, ZXingScannerView zXingScannerView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, TextView textView) {
        this.a = constraintLayout;
        this.b = zXingScannerView;
        this.c = constraintLayout2;
        this.d = constraintLayout3;
        this.e = imageView;
        this.f = textView;
    }

    public static C15723k38 a(View view) {
        int i = BC5.wallet_pay_scanner;
        ZXingScannerView zXingScannerView = (ZXingScannerView) AbstractC11738dW7.a(view, i);
        if (zXingScannerView != null) {
            i = BC5.wallet_pay_with_wallet_id;
            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
            if (constraintLayout != null) {
                i = BC5.wallet_pay_with_wallet_id_container;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                if (constraintLayout2 != null) {
                    i = BC5.wallet_pay_with_wallet_id_icon;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null) {
                        i = BC5.wallet_pay_with_wallet_id_text;
                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView != null) {
                            return new C15723k38((ConstraintLayout) view, zXingScannerView, constraintLayout, constraintLayout2, imageView, textView);
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

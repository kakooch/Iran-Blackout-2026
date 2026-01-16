package ir.nasim.core.network.sslpinning;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import ir.nasim.C15990kW7;
import ir.nasim.InterfaceC25088zi6;
import ir.nasim.ME2;
import ir.nasim.SB7;

/* loaded from: classes5.dex */
public abstract class Hilt_SecureWebView extends WebView implements ME2 {
    private C15990kW7 a;
    private boolean b;

    Hilt_SecureWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        if (isInEditMode()) {
            return;
        }
        c();
    }

    @Override // ir.nasim.LE2
    public final Object N2() {
        return E4().N2();
    }

    @Override // ir.nasim.ME2
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C15990kW7 E4() {
        if (this.a == null) {
            this.a = b();
        }
        return this.a;
    }

    protected C15990kW7 b() {
        return new C15990kW7(this, false);
    }

    protected void c() {
        if (this.b) {
            return;
        }
        this.b = true;
        ((InterfaceC25088zi6) N2()).b((SecureWebView) SB7.a(this));
    }
}

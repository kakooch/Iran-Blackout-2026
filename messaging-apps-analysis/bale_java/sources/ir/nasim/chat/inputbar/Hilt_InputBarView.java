package ir.nasim.chat.inputbar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import ir.nasim.C15990kW7;
import ir.nasim.InterfaceC12169e93;
import ir.nasim.ME2;
import ir.nasim.SB7;

/* loaded from: classes4.dex */
public abstract class Hilt_InputBarView extends FrameLayout implements ME2 {
    private C15990kW7 a;
    private boolean b;

    Hilt_InputBarView(Context context) {
        super(context);
        if (isInEditMode()) {
            return;
        }
        n();
    }

    @Override // ir.nasim.LE2
    public final Object N2() {
        return E4().N2();
    }

    @Override // ir.nasim.ME2
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final C15990kW7 E4() {
        if (this.a == null) {
            this.a = l();
        }
        return this.a;
    }

    protected C15990kW7 l() {
        return new C15990kW7(this, false);
    }

    protected void n() {
        if (this.b) {
            return;
        }
        this.b = true;
        ((InterfaceC12169e93) N2()).a((InputBarView) SB7.a(this));
    }

    Hilt_InputBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (isInEditMode()) {
            return;
        }
        n();
    }

    Hilt_InputBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (isInEditMode()) {
            return;
        }
        n();
    }
}

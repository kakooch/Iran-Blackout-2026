package ir.nasim;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* renamed from: ir.nasim.u2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21727u2 extends ClickableSpan {
    private final int a;
    private final X2 b;
    private final int c;

    public C21727u2(int i, X2 x2, int i2) {
        this.a = i;
        this.b = x2;
        this.c = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.a);
        this.b.d0(this.c, bundle);
    }
}

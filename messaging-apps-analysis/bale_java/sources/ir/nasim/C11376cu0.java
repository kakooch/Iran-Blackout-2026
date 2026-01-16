package ir.nasim;

import android.text.style.ClickableSpan;
import android.view.View;

/* renamed from: ir.nasim.cu0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11376cu0 extends ClickableSpan {
    private SA2 a;

    public final void a(SA2 sa2) {
        this.a = sa2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        AbstractC13042fc3.i(view, "widget");
        SA2 sa2 = this.a;
        if (sa2 != null) {
            sa2.invoke();
        }
    }
}

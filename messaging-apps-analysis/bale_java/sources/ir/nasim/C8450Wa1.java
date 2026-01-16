package ir.nasim;

import android.text.style.ClickableSpan;
import android.view.View;

/* renamed from: ir.nasim.Wa1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C8450Wa1 extends ClickableSpan {
    private final AbstractC13406gA3 a;

    public C8450Wa1(AbstractC13406gA3 abstractC13406gA3) {
        this.a = abstractC13406gA3;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        InterfaceC16379lA3 interfaceC16379lA3A = this.a.a();
        if (interfaceC16379lA3A != null) {
            interfaceC16379lA3A.a(this.a);
        }
    }
}

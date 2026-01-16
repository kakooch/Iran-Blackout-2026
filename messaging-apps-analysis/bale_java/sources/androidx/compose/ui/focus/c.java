package androidx.compose.ui.focus;

import androidx.compose.ui.e;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC20937sr2;
import ir.nasim.InterfaceC5517Jr2;
import ir.nasim.UA2;

/* loaded from: classes2.dex */
final class c extends e.c implements InterfaceC20937sr2 {
    private UA2 o;
    private InterfaceC5517Jr2 p;

    public c(UA2 ua2) {
        this.o = ua2;
    }

    @Override // ir.nasim.InterfaceC20937sr2
    public void O(InterfaceC5517Jr2 interfaceC5517Jr2) {
        if (AbstractC13042fc3.d(this.p, interfaceC5517Jr2)) {
            return;
        }
        this.p = interfaceC5517Jr2;
        this.o.invoke(interfaceC5517Jr2);
    }

    public final void v2(UA2 ua2) {
        this.o = ua2;
    }
}

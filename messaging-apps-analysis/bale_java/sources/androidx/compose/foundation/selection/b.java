package androidx.compose.foundation.selection;

import androidx.compose.foundation.f;
import ir.nasim.AbstractC7397Rn6;
import ir.nasim.AbstractC9939ao6;
import ir.nasim.B26;
import ir.nasim.ED1;
import ir.nasim.InterfaceC11943do6;
import ir.nasim.InterfaceC17521n63;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.SA2;

/* loaded from: classes.dex */
final class b extends f {
    private boolean A0;

    public /* synthetic */ b(boolean z, InterfaceC18507om4 interfaceC18507om4, InterfaceC17521n63 interfaceC17521n63, boolean z2, B26 b26, SA2 sa2, ED1 ed1) {
        this(z, interfaceC18507om4, interfaceC17521n63, z2, b26, sa2);
    }

    @Override // androidx.compose.foundation.a
    public void I2(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC9939ao6.q0(interfaceC11943do6, this.A0);
    }

    public final void b3(boolean z, InterfaceC18507om4 interfaceC18507om4, InterfaceC17521n63 interfaceC17521n63, boolean z2, B26 b26, SA2 sa2) {
        if (this.A0 != z) {
            this.A0 = z;
            AbstractC7397Rn6.b(this);
        }
        super.a3(interfaceC18507om4, interfaceC17521n63, z2, null, b26, sa2);
    }

    private b(boolean z, InterfaceC18507om4 interfaceC18507om4, InterfaceC17521n63 interfaceC17521n63, boolean z2, B26 b26, SA2 sa2) {
        super(interfaceC18507om4, interfaceC17521n63, z2, null, b26, sa2, null);
        this.A0 = z;
    }
}

package androidx.compose.foundation.selection;

import androidx.compose.foundation.f;
import ir.nasim.AbstractC22809vr7;
import ir.nasim.AbstractC7397Rn6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9939ao6;
import ir.nasim.B26;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC11943do6;
import ir.nasim.InterfaceC17521n63;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.SA2;
import ir.nasim.UA2;

/* loaded from: classes.dex */
final class d extends f {
    private boolean A0;
    private UA2 B0;
    private final SA2 C0;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(UA2 ua2, boolean z) {
            super(0);
            this.e = ua2;
            this.f = z;
        }

        public final void a() {
            this.e.invoke(Boolean.valueOf(!this.f));
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        public final void a() {
            d.this.B0.invoke(Boolean.valueOf(!d.this.A0));
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public /* synthetic */ d(boolean z, InterfaceC18507om4 interfaceC18507om4, InterfaceC17521n63 interfaceC17521n63, boolean z2, B26 b26, UA2 ua2, ED1 ed1) {
        this(z, interfaceC18507om4, interfaceC17521n63, z2, b26, ua2);
    }

    @Override // androidx.compose.foundation.a
    public void I2(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC9939ao6.D0(interfaceC11943do6, AbstractC22809vr7.a(this.A0));
    }

    public final void d3(boolean z, InterfaceC18507om4 interfaceC18507om4, InterfaceC17521n63 interfaceC17521n63, boolean z2, B26 b26, UA2 ua2) {
        if (this.A0 != z) {
            this.A0 = z;
            AbstractC7397Rn6.b(this);
        }
        this.B0 = ua2;
        super.a3(interfaceC18507om4, interfaceC17521n63, z2, null, b26, this.C0);
    }

    private d(boolean z, InterfaceC18507om4 interfaceC18507om4, InterfaceC17521n63 interfaceC17521n63, boolean z2, B26 b26, UA2 ua2) {
        super(interfaceC18507om4, interfaceC17521n63, z2, null, b26, new a(ua2, z), null);
        this.A0 = z;
        this.B0 = ua2;
        this.C0 = new b();
    }
}

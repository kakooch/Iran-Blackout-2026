package ir.nasim;

import ir.nasim.InterfaceC16050kd1;
import ir.nasim.core.runtime.mtproto.ConnectionEndpoint;
import java.util.ArrayList;

/* renamed from: ir.nasim.oN3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC18269oN3 implements InterfaceC17375mr4 {
    private final AK a;
    private final ArrayList b = new ArrayList();

    /* renamed from: ir.nasim.oN3$a */
    class a implements InterfaceC17087mN3 {
        final /* synthetic */ InterfaceC6449Np1 a;

        a(InterfaceC6449Np1 interfaceC6449Np1) {
            this.a = interfaceC6449Np1;
        }

        @Override // ir.nasim.InterfaceC17087mN3
        public void a(C15905kN3 c15905kN3, InterfaceC16050kd1.a aVar) {
            this.a.b(aVar);
            synchronized (AbstractC18269oN3.this.b) {
                AbstractC18269oN3.this.b.remove(c15905kN3);
            }
        }

        @Override // ir.nasim.InterfaceC17087mN3
        public void b(C15905kN3 c15905kN3) {
            this.a.a(c15905kN3);
            synchronized (AbstractC18269oN3.this.b) {
                AbstractC18269oN3.this.b.remove(c15905kN3);
            }
        }
    }

    public AbstractC18269oN3(AK ak) {
        this.a = ak;
    }

    @Override // ir.nasim.InterfaceC17375mr4
    public void a(int i, int i2, int i3, int i4, ConnectionEndpoint connectionEndpoint, InterfaceC17232md1 interfaceC17232md1, InterfaceC6449Np1 interfaceC6449Np1) {
        C19406qI3.a("ConnectionLog", "Connection#" + i + ": Managed network provider create connection begin", new Object[0]);
        C15905kN3 c15905kN3 = new C15905kN3(i, i2, i3, i4, connectionEndpoint, interfaceC17232md1, new a(interfaceC6449Np1), this.a);
        synchronized (this.b) {
            this.b.add(c15905kN3);
        }
        C19406qI3.a("ConnectionLog", "Connection#" + i + ": Managed network provider create connection end", new Object[0]);
    }
}

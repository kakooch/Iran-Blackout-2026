package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.qs, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C19744qs implements InterfaceC4104Ds {
    private final List a;

    public C19744qs(List list) {
        this.a = list;
    }

    @Override // ir.nasim.InterfaceC4104Ds
    public boolean i() {
        return this.a.size() == 1 && ((C24561yp3) this.a.get(0)).i();
    }

    @Override // ir.nasim.InterfaceC4104Ds
    public AbstractC24408ya0 j() {
        return ((C24561yp3) this.a.get(0)).i() ? new C24473yg5(this.a) : new C16882m15(this.a);
    }

    @Override // ir.nasim.InterfaceC4104Ds
    public List k() {
        return this.a;
    }
}

package ir.nasim;

import java.util.List;

/* loaded from: classes2.dex */
public abstract class D07 extends KB1 implements InterfaceC24081y07 {
    private InterfaceC24081y07 d;
    private long e;

    @Override // ir.nasim.InterfaceC24081y07
    public int a(long j) {
        return ((InterfaceC24081y07) AbstractC20011rK.e(this.d)).a(j - this.e);
    }

    @Override // ir.nasim.InterfaceC24081y07
    public List h(long j) {
        return ((InterfaceC24081y07) AbstractC20011rK.e(this.d)).h(j - this.e);
    }

    @Override // ir.nasim.InterfaceC24081y07
    public long i(int i) {
        return ((InterfaceC24081y07) AbstractC20011rK.e(this.d)).i(i) + this.e;
    }

    @Override // ir.nasim.InterfaceC24081y07
    public int j() {
        return ((InterfaceC24081y07) AbstractC20011rK.e(this.d)).j();
    }

    @Override // ir.nasim.AbstractC5461Jl0
    public void p() {
        super.p();
        this.d = null;
    }

    public void z(long j, InterfaceC24081y07 interfaceC24081y07, long j2) {
        this.b = j;
        this.d = interfaceC24081y07;
        if (j2 != Long.MAX_VALUE) {
            j = j2;
        }
        this.e = j;
    }
}

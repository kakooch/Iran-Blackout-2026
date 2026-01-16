package ir.nasim;

import androidx.compose.ui.e;

/* renamed from: ir.nasim.su3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20968su3 extends e.c implements InterfaceC21655tu3 {
    private InterfaceC15796kB2 o;

    public C20968su3(InterfaceC15796kB2 interfaceC15796kB2) {
        this.o = interfaceC15796kB2;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        return (InterfaceC11734dW3) this.o.q(interfaceC12377eW3, zv3, C17833ne1.a(j));
    }

    public String toString() {
        return "LayoutModifierImpl(measureBlock=" + this.o + ')';
    }

    public final void v2(InterfaceC15796kB2 interfaceC15796kB2) {
        this.o = interfaceC15796kB2;
    }
}

package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.a22, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9481a22 extends WC6 {
    private final C10075b22 o;

    public C9481a22(List list) {
        super("DvbDecoder");
        EW4 ew4 = new EW4((byte[]) list.get(0));
        this.o = new C10075b22(ew4.L(), ew4.L());
    }

    @Override // ir.nasim.WC6
    protected InterfaceC24081y07 A(byte[] bArr, int i, boolean z) {
        if (z) {
            this.o.r();
        }
        return new C10691c22(this.o.b(bArr, i));
    }
}

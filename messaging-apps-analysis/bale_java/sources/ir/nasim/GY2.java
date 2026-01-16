package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.InterfaceC12529em;

/* loaded from: classes.dex */
public final class GY2 extends e.c implements InterfaceC24970zW4 {
    private InterfaceC12529em.b o;

    public GY2(InterfaceC12529em.b bVar) {
        this.o = bVar;
    }

    @Override // ir.nasim.InterfaceC24970zW4
    /* renamed from: v2, reason: merged with bridge method [inline-methods] */
    public I66 C(WH1 wh1, Object obj) {
        I66 i66 = obj instanceof I66 ? (I66) obj : null;
        if (i66 == null) {
            i66 = new I66(0.0f, false, null, null, 15, null);
        }
        i66.e(AbstractC5075Hu1.a.a(this.o));
        return i66;
    }

    public final void w2(InterfaceC12529em.b bVar) {
        this.o = bVar;
    }
}

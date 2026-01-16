package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.InterfaceC12529em;

/* renamed from: ir.nasim.gS7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C13572gS7 extends e.c implements InterfaceC24970zW4 {
    private InterfaceC12529em.c o;

    public C13572gS7(InterfaceC12529em.c cVar) {
        this.o = cVar;
    }

    @Override // ir.nasim.InterfaceC24970zW4
    /* renamed from: v2, reason: merged with bridge method [inline-methods] */
    public I66 C(WH1 wh1, Object obj) {
        I66 i66 = obj instanceof I66 ? (I66) obj : null;
        if (i66 == null) {
            i66 = new I66(0.0f, false, null, null, 15, null);
        }
        i66.e(AbstractC5075Hu1.a.b(this.o));
        return i66;
    }

    public final void w2(InterfaceC12529em.c cVar) {
        this.o = cVar;
    }
}

package ir.nasim;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class XH7 implements InterfaceC20817sf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;
    private final InterfaceC7720Sx5 d;
    private final InterfaceC7720Sx5 e;
    private final InterfaceC7720Sx5 f;
    private final InterfaceC7720Sx5 g;
    private final InterfaceC7720Sx5 h;
    private final InterfaceC7720Sx5 i;

    public XH7(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55, InterfaceC7720Sx5 interfaceC7720Sx56, InterfaceC7720Sx5 interfaceC7720Sx57, InterfaceC7720Sx5 interfaceC7720Sx58, InterfaceC7720Sx5 interfaceC7720Sx59) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
        this.d = interfaceC7720Sx54;
        this.e = interfaceC7720Sx55;
        this.f = interfaceC7720Sx56;
        this.g = interfaceC7720Sx57;
        this.h = interfaceC7720Sx58;
        this.i = interfaceC7720Sx59;
    }

    public static XH7 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55, InterfaceC7720Sx5 interfaceC7720Sx56, InterfaceC7720Sx5 interfaceC7720Sx57, InterfaceC7720Sx5 interfaceC7720Sx58, InterfaceC7720Sx5 interfaceC7720Sx59) {
        return new XH7(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53, interfaceC7720Sx54, interfaceC7720Sx55, interfaceC7720Sx56, interfaceC7720Sx57, interfaceC7720Sx58, interfaceC7720Sx59);
    }

    public static WH7 c(Context context, XV xv, InterfaceC13031fb2 interfaceC13031fb2, InterfaceC16628lb8 interfaceC16628lb8, Executor executor, InterfaceC17505n47 interfaceC17505n47, QV0 qv0, QV0 qv02, InterfaceC21340tV0 interfaceC21340tV0) {
        return new WH7(context, xv, interfaceC13031fb2, interfaceC16628lb8, executor, interfaceC17505n47, qv0, qv02, interfaceC21340tV0);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public WH7 get() {
        return c((Context) this.a.get(), (XV) this.b.get(), (InterfaceC13031fb2) this.c.get(), (InterfaceC16628lb8) this.d.get(), (Executor) this.e.get(), (InterfaceC17505n47) this.f.get(), (QV0) this.g.get(), (QV0) this.h.get(), (InterfaceC21340tV0) this.i.get());
    }
}

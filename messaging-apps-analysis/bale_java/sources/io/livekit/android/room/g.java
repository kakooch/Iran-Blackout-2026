package io.livekit.android.room;

import io.livekit.android.room.a;
import ir.nasim.AbstractC13778go1;
import ir.nasim.FF5;
import ir.nasim.InterfaceC19617qf2;
import ir.nasim.InterfaceC7720Sx5;

/* loaded from: classes3.dex */
public final class g implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;
    private final InterfaceC7720Sx5 d;

    public g(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
        this.d = interfaceC7720Sx54;
    }

    public static g a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54) {
        return new g(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53, interfaceC7720Sx54);
    }

    public static f c(l lVar, a.InterfaceC0209a interfaceC0209a, AbstractC13778go1 abstractC13778go1, FF5 ff5) {
        return new f(lVar, interfaceC0209a, abstractC13778go1, ff5);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f get() {
        return c((l) this.a.get(), (a.InterfaceC0209a) this.b.get(), (AbstractC13778go1) this.c.get(), (FF5) this.d.get());
    }
}

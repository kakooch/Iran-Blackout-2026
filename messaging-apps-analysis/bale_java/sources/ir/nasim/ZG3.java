package ir.nasim;

import android.content.Context;
import ir.nasim.C11599dH3;
import ir.nasim.C22464vH3;
import ir.nasim.HG3;
import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.PeerConnectionFactory;

/* loaded from: classes3.dex */
public final class ZG3 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;
    private final InterfaceC7720Sx5 d;
    private final InterfaceC7720Sx5 e;
    private final InterfaceC7720Sx5 f;
    private final InterfaceC7720Sx5 g;
    private final InterfaceC7720Sx5 h;
    private final InterfaceC7720Sx5 i;
    private final InterfaceC7720Sx5 j;
    private final InterfaceC7720Sx5 k;

    public ZG3(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55, InterfaceC7720Sx5 interfaceC7720Sx56, InterfaceC7720Sx5 interfaceC7720Sx57, InterfaceC7720Sx5 interfaceC7720Sx58, InterfaceC7720Sx5 interfaceC7720Sx59, InterfaceC7720Sx5 interfaceC7720Sx510, InterfaceC7720Sx5 interfaceC7720Sx511) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
        this.d = interfaceC7720Sx54;
        this.e = interfaceC7720Sx55;
        this.f = interfaceC7720Sx56;
        this.g = interfaceC7720Sx57;
        this.h = interfaceC7720Sx58;
        this.i = interfaceC7720Sx59;
        this.j = interfaceC7720Sx510;
        this.k = interfaceC7720Sx511;
    }

    public static ZG3 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55, InterfaceC7720Sx5 interfaceC7720Sx56, InterfaceC7720Sx5 interfaceC7720Sx57, InterfaceC7720Sx5 interfaceC7720Sx58, InterfaceC7720Sx5 interfaceC7720Sx59, InterfaceC7720Sx5 interfaceC7720Sx510, InterfaceC7720Sx5 interfaceC7720Sx511) {
        return new ZG3(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53, interfaceC7720Sx54, interfaceC7720Sx55, interfaceC7720Sx56, interfaceC7720Sx57, interfaceC7720Sx58, interfaceC7720Sx59, interfaceC7720Sx510, interfaceC7720Sx511);
    }

    public static io.livekit.android.room.participant.a c(boolean z, io.livekit.android.room.f fVar, PeerConnectionFactory peerConnectionFactory, Context context, EglBase eglBase, C11599dH3.c cVar, C22464vH3.b bVar, HG3.b bVar2, C19977rG1 c19977rG1, AbstractC13778go1 abstractC13778go1, UA2 ua2, SM4 sm4) {
        return new io.livekit.android.room.participant.a(z, fVar, peerConnectionFactory, context, eglBase, cVar, bVar, bVar2, c19977rG1, abstractC13778go1, ua2, sm4);
    }

    public io.livekit.android.room.participant.a b(boolean z) {
        return c(z, (io.livekit.android.room.f) this.a.get(), (PeerConnectionFactory) this.b.get(), (Context) this.c.get(), (EglBase) this.d.get(), (C11599dH3.c) this.e.get(), (C22464vH3.b) this.f.get(), (HG3.b) this.g.get(), (C19977rG1) this.h.get(), (AbstractC13778go1) this.i.get(), (UA2) this.j.get(), (SM4) this.k.get());
    }
}

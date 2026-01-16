package io.livekit.android.room;

import io.livekit.android.room.a;
import ir.nasim.AbstractC13778go1;
import ir.nasim.C25048ze6;
import ir.nasim.FF5;
import ir.nasim.InterfaceC7720Sx5;
import livekit.org.webrtc.PeerConnection;
import livekit.org.webrtc.PeerConnectionFactory;

/* loaded from: classes3.dex */
public final class c {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;
    private final InterfaceC7720Sx5 d;

    public c(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
        this.d = interfaceC7720Sx54;
    }

    public static c a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54) {
        return new c(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53, interfaceC7720Sx54);
    }

    public static a c(PeerConnection.RTCConfiguration rTCConfiguration, PeerConnection.Observer observer, a.b bVar, AbstractC13778go1 abstractC13778go1, PeerConnectionFactory peerConnectionFactory, C25048ze6 c25048ze6, FF5 ff5) {
        return new a(rTCConfiguration, observer, bVar, abstractC13778go1, peerConnectionFactory, c25048ze6, ff5);
    }

    public a b(PeerConnection.RTCConfiguration rTCConfiguration, PeerConnection.Observer observer, a.b bVar) {
        return c(rTCConfiguration, observer, bVar, (AbstractC13778go1) this.a.get(), (PeerConnectionFactory) this.b.get(), (C25048ze6) this.c.get(), (FF5) this.d.get());
    }
}

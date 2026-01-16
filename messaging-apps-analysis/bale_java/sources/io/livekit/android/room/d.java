package io.livekit.android.room;

import io.livekit.android.room.a;
import ir.nasim.C11006ca3;
import ir.nasim.InterfaceC7720Sx5;
import livekit.org.webrtc.PeerConnection;

/* loaded from: classes3.dex */
public final class d implements a.InterfaceC0209a {
    private final c a;

    d(c cVar) {
        this.a = cVar;
    }

    public static InterfaceC7720Sx5 b(c cVar) {
        return C11006ca3.a(new d(cVar));
    }

    @Override // io.livekit.android.room.a.InterfaceC0209a
    public a a(PeerConnection.RTCConfiguration rTCConfiguration, PeerConnection.Observer observer, a.b bVar) {
        return this.a.b(rTCConfiguration, observer, bVar);
    }
}

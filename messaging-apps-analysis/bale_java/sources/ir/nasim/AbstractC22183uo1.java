package ir.nasim;

import livekit.org.webrtc.MediaConstraints;
import livekit.org.webrtc.PeerConnection;
import livekit.org.webrtc.SessionDescription;

/* renamed from: ir.nasim.uo1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC22183uo1 {
    public static final Object a(PeerConnection peerConnection, MediaConstraints mediaConstraints, InterfaceC20295rm1 interfaceC20295rm1) {
        C21593to1 c21593to1 = new C21593to1();
        peerConnection.createAnswer(c21593to1, mediaConstraints);
        return c21593to1.h(interfaceC20295rm1);
    }

    public static final Object b(PeerConnection peerConnection, MediaConstraints mediaConstraints, InterfaceC20295rm1 interfaceC20295rm1) {
        C21593to1 c21593to1 = new C21593to1();
        peerConnection.createOffer(c21593to1, mediaConstraints);
        return c21593to1.h(interfaceC20295rm1);
    }

    public static final Object c(PeerConnection peerConnection, SessionDescription sessionDescription, InterfaceC20295rm1 interfaceC20295rm1) {
        C21593to1 c21593to1 = new C21593to1();
        peerConnection.setLocalDescription(c21593to1, sessionDescription);
        return c21593to1.i(interfaceC20295rm1);
    }

    public static final Object d(PeerConnection peerConnection, SessionDescription sessionDescription, InterfaceC20295rm1 interfaceC20295rm1) {
        C21593to1 c21593to1 = new C21593to1();
        peerConnection.setRemoteDescription(c21593to1, sessionDescription);
        return c21593to1.i(interfaceC20295rm1);
    }
}

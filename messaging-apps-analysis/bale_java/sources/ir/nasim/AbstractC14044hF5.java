package ir.nasim;

import livekit.LivekitRtc$ICEServer;
import livekit.org.webrtc.PeerConnection;

/* renamed from: ir.nasim.hF5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC14044hF5 {
    public static final PeerConnection.IceServer a(LivekitRtc$ICEServer livekitRtc$ICEServer) {
        AbstractC13042fc3.i(livekitRtc$ICEServer, "<this>");
        PeerConnection.IceServer.Builder builder = PeerConnection.IceServer.builder(livekitRtc$ICEServer.getUrlsList());
        String username = livekitRtc$ICEServer.getUsername();
        if (username == null) {
            username = "";
        }
        PeerConnection.IceServer.Builder username2 = builder.setUsername(username);
        String credential = livekitRtc$ICEServer.getCredential();
        PeerConnection.IceServer iceServerCreateIceServer = username2.setPassword(credential != null ? credential : "").setTlsAlpnProtocols(AbstractC10360bX0.m()).setTlsEllipticCurves(AbstractC10360bX0.m()).createIceServer();
        AbstractC13042fc3.h(iceServerCreateIceServer, "createIceServer(...)");
        return iceServerCreateIceServer;
    }
}

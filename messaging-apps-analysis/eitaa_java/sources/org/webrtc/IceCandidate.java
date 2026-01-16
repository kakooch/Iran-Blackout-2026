package org.webrtc;

import java.util.Arrays;
import org.webrtc.PeerConnection;

/* loaded from: classes3.dex */
public class IceCandidate {
    public final PeerConnection.AdapterType adapterType;
    public final String sdp;
    public final int sdpMLineIndex;
    public final String sdpMid;
    public final String serverUrl;

    public IceCandidate(String sdpMid, int sdpMLineIndex, String sdp) {
        this.sdpMid = sdpMid;
        this.sdpMLineIndex = sdpMLineIndex;
        this.sdp = sdp;
        this.serverUrl = "";
        this.adapterType = PeerConnection.AdapterType.UNKNOWN;
    }

    @CalledByNative
    IceCandidate(String sdpMid, int sdpMLineIndex, String sdp, String serverUrl, PeerConnection.AdapterType adapterType) {
        this.sdpMid = sdpMid;
        this.sdpMLineIndex = sdpMLineIndex;
        this.sdp = sdp;
        this.serverUrl = serverUrl;
        this.adapterType = adapterType;
    }

    public String toString() {
        return this.sdpMid + ":" + this.sdpMLineIndex + ":" + this.sdp + ":" + this.serverUrl + ":" + this.adapterType.toString();
    }

    @CalledByNative
    String getSdpMid() {
        return this.sdpMid;
    }

    @CalledByNative
    String getSdp() {
        return this.sdp;
    }

    public boolean equals(Object object) {
        if (!(object instanceof IceCandidate)) {
            return false;
        }
        IceCandidate iceCandidate = (IceCandidate) object;
        return objectEquals(this.sdpMid, iceCandidate.sdpMid) && this.sdpMLineIndex == iceCandidate.sdpMLineIndex && objectEquals(this.sdp, iceCandidate.sdp);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sdpMid, Integer.valueOf(this.sdpMLineIndex), this.sdp});
    }

    private static boolean objectEquals(Object o1, Object o2) {
        if (o1 == null) {
            return o2 == null;
        }
        return o1.equals(o2);
    }
}

package ir.nasim;

import livekit.org.webrtc.PeerConnection;

/* renamed from: ir.nasim.w25, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC22919w25 {

    /* renamed from: ir.nasim.w25$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PeerConnection.PeerConnectionState.values().length];
            try {
                iArr[PeerConnection.PeerConnectionState.FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PeerConnection.PeerConnectionState.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public static final PeerConnection.RTCConfiguration a(PeerConnection.RTCConfiguration rTCConfiguration) {
        AbstractC13042fc3.i(rTCConfiguration, "<this>");
        PeerConnection.RTCConfiguration rTCConfiguration2 = new PeerConnection.RTCConfiguration(AbstractC10360bX0.m());
        b(rTCConfiguration2, rTCConfiguration);
        return rTCConfiguration2;
    }

    public static final void b(PeerConnection.RTCConfiguration rTCConfiguration, PeerConnection.RTCConfiguration rTCConfiguration2) {
        AbstractC13042fc3.i(rTCConfiguration, "<this>");
        AbstractC13042fc3.i(rTCConfiguration2, "config");
        rTCConfiguration.activeResetSrtpParams = rTCConfiguration2.activeResetSrtpParams;
        rTCConfiguration.audioJitterBufferFastAccelerate = rTCConfiguration2.audioJitterBufferFastAccelerate;
        rTCConfiguration.audioJitterBufferMaxPackets = rTCConfiguration2.audioJitterBufferMaxPackets;
        rTCConfiguration.bundlePolicy = rTCConfiguration2.bundlePolicy;
        rTCConfiguration.candidateNetworkPolicy = rTCConfiguration2.candidateNetworkPolicy;
        rTCConfiguration.certificate = rTCConfiguration2.certificate;
        rTCConfiguration.continualGatheringPolicy = rTCConfiguration2.continualGatheringPolicy;
        rTCConfiguration.cryptoOptions = rTCConfiguration2.cryptoOptions;
        rTCConfiguration.disableIPv6OnWifi = rTCConfiguration2.disableIPv6OnWifi;
        rTCConfiguration.enableCpuOveruseDetection = rTCConfiguration2.enableCpuOveruseDetection;
        rTCConfiguration.enableDscp = rTCConfiguration2.enableDscp;
        rTCConfiguration.enableIceGatheringOnAnyAddressPorts = rTCConfiguration2.enableIceGatheringOnAnyAddressPorts;
        rTCConfiguration.enableImplicitRollback = rTCConfiguration2.enableImplicitRollback;
        rTCConfiguration.iceBackupCandidatePairPingInterval = rTCConfiguration2.iceBackupCandidatePairPingInterval;
        rTCConfiguration.iceCandidatePoolSize = rTCConfiguration2.iceCandidatePoolSize;
        rTCConfiguration.iceCheckIntervalStrongConnectivityMs = rTCConfiguration2.iceCheckIntervalStrongConnectivityMs;
        rTCConfiguration.iceCheckIntervalWeakConnectivityMs = rTCConfiguration2.iceCheckIntervalWeakConnectivityMs;
        rTCConfiguration.iceCheckMinInterval = rTCConfiguration2.iceCheckMinInterval;
        rTCConfiguration.iceConnectionReceivingTimeout = rTCConfiguration2.iceConnectionReceivingTimeout;
        rTCConfiguration.iceServers = rTCConfiguration2.iceServers;
        rTCConfiguration.iceTransportsType = rTCConfiguration2.iceTransportsType;
        rTCConfiguration.iceUnwritableMinChecks = rTCConfiguration2.iceUnwritableMinChecks;
        rTCConfiguration.iceUnwritableTimeMs = rTCConfiguration2.iceUnwritableTimeMs;
        rTCConfiguration.keyType = rTCConfiguration2.keyType;
        rTCConfiguration.maxIPv6Networks = rTCConfiguration2.maxIPv6Networks;
        rTCConfiguration.networkPreference = rTCConfiguration2.networkPreference;
        rTCConfiguration.offerExtmapAllowMixed = rTCConfiguration2.offerExtmapAllowMixed;
        rTCConfiguration.portAllocatorFlags = rTCConfiguration2.portAllocatorFlags;
        rTCConfiguration.portAllocatorMaxPort = rTCConfiguration2.portAllocatorMaxPort;
        rTCConfiguration.portAllocatorMinPort = rTCConfiguration2.portAllocatorMinPort;
        rTCConfiguration.presumeWritableWhenFullyRelayed = rTCConfiguration2.presumeWritableWhenFullyRelayed;
        rTCConfiguration.pruneTurnPorts = rTCConfiguration2.pruneTurnPorts;
        rTCConfiguration.rtcpMuxPolicy = rTCConfiguration2.rtcpMuxPolicy;
        rTCConfiguration.screencastMinBitrate = rTCConfiguration2.screencastMinBitrate;
        rTCConfiguration.sdpSemantics = rTCConfiguration2.sdpSemantics;
        rTCConfiguration.stableWritableConnectionPingIntervalMs = rTCConfiguration2.stableWritableConnectionPingIntervalMs;
        rTCConfiguration.stunCandidateKeepaliveIntervalMs = rTCConfiguration2.stunCandidateKeepaliveIntervalMs;
        rTCConfiguration.surfaceIceCandidatesOnIceTransportTypeChanged = rTCConfiguration2.surfaceIceCandidatesOnIceTransportTypeChanged;
        rTCConfiguration.suspendBelowMinBitrate = rTCConfiguration2.suspendBelowMinBitrate;
        rTCConfiguration.tcpCandidatePolicy = rTCConfiguration2.tcpCandidatePolicy;
        rTCConfiguration.turnCustomizer = rTCConfiguration2.turnCustomizer;
        rTCConfiguration.turnLoggingId = rTCConfiguration2.turnLoggingId;
        rTCConfiguration.turnPortPrunePolicy = rTCConfiguration2.turnPortPrunePolicy;
    }

    public static final boolean c(PeerConnection.PeerConnectionState peerConnectionState) {
        AbstractC13042fc3.i(peerConnectionState, "<this>");
        return peerConnectionState == PeerConnection.PeerConnectionState.CONNECTED;
    }

    public static final boolean d(PeerConnection peerConnection) {
        AbstractC13042fc3.i(peerConnection, "<this>");
        PeerConnection.PeerConnectionState peerConnectionStateConnectionState = peerConnection.connectionState();
        AbstractC13042fc3.h(peerConnectionStateConnectionState, "connectionState(...)");
        return c(peerConnectionStateConnectionState);
    }

    public static final boolean e(PeerConnection.PeerConnectionState peerConnectionState) {
        AbstractC13042fc3.i(peerConnectionState, "<this>");
        int i = a.a[peerConnectionState.ordinal()];
        return i == 1 || i == 2;
    }
}

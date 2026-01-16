package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.EnumC12833fF3;
import ir.nasim.EnumC9598aE3;
import ir.nasim.KW4;
import ir.nasim.ZD3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitAnalytics$APICallInfo;
import livekit.LivekitAnalytics$AnalyticsClientMeta;
import livekit.LivekitAnalytics$ReportInfo;
import livekit.LivekitAnalytics$WebhookInfo;
import livekit.LivekitEgress$EgressInfo;
import livekit.LivekitIngress$IngressInfo;
import livekit.LivekitModels$ClientInfo;
import livekit.LivekitModels$ParticipantInfo;
import livekit.LivekitModels$RTPStats;
import livekit.LivekitModels$Room;
import livekit.LivekitModels$TrackInfo;
import livekit.LivekitSip$SIPCallInfo;
import livekit.LivekitSip$SIPDispatchRuleInfo;
import livekit.LivekitSip$SIPInboundTrunkInfo;
import livekit.LivekitSip$SIPOutboundTrunkInfo;
import livekit.LivekitSip$SIPTransferInfo;

/* loaded from: classes8.dex */
public final class LivekitAnalytics$AnalyticsEvent extends GeneratedMessageLite implements ZD3 {
    public static final int ANALYTICS_KEY_FIELD_NUMBER = 10;
    public static final int API_CALL_FIELD_NUMBER = 34;
    public static final int CLIENT_INFO_FIELD_NUMBER = 11;
    public static final int CLIENT_META_FIELD_NUMBER = 12;
    private static final LivekitAnalytics$AnalyticsEvent DEFAULT_INSTANCE;
    public static final int EGRESS_FIELD_NUMBER = 17;
    public static final int EGRESS_ID_FIELD_NUMBER = 13;
    public static final int ERROR_FIELD_NUMBER = 20;
    public static final int ID_FIELD_NUMBER = 25;
    public static final int INGRESS_FIELD_NUMBER = 18;
    public static final int INGRESS_ID_FIELD_NUMBER = 19;
    public static final int MAX_SUBSCRIBED_VIDEO_QUALITY_FIELD_NUMBER = 14;
    public static final int MIME_FIELD_NUMBER = 16;
    public static final int NODE_ID_FIELD_NUMBER = 24;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_FIELD_NUMBER = 6;
    public static final int PARTICIPANT_ID_FIELD_NUMBER = 5;
    public static final int PUBLISHER_FIELD_NUMBER = 15;
    public static final int REPORT_FIELD_NUMBER = 33;
    public static final int ROOM_FIELD_NUMBER = 4;
    public static final int ROOM_ID_FIELD_NUMBER = 3;
    public static final int RTP_STATS_FIELD_NUMBER = 21;
    public static final int SIP_CALL_FIELD_NUMBER = 27;
    public static final int SIP_CALL_ID_FIELD_NUMBER = 26;
    public static final int SIP_DISPATCH_RULE_FIELD_NUMBER = 32;
    public static final int SIP_DISPATCH_RULE_ID_FIELD_NUMBER = 31;
    public static final int SIP_INBOUND_TRUNK_FIELD_NUMBER = 29;
    public static final int SIP_OUTBOUND_TRUNK_FIELD_NUMBER = 30;
    public static final int SIP_TRANSFER_FIELD_NUMBER = 36;
    public static final int SIP_TRUNK_ID_FIELD_NUMBER = 28;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    public static final int TRACK_FIELD_NUMBER = 8;
    public static final int TRACK_ID_FIELD_NUMBER = 7;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int VIDEO_LAYER_FIELD_NUMBER = 22;
    public static final int WEBHOOK_FIELD_NUMBER = 35;
    private LivekitAnalytics$APICallInfo apiCall_;
    private LivekitModels$ClientInfo clientInfo_;
    private LivekitAnalytics$AnalyticsClientMeta clientMeta_;
    private LivekitEgress$EgressInfo egress_;
    private LivekitIngress$IngressInfo ingress_;
    private int maxSubscribedVideoQuality_;
    private LivekitModels$ParticipantInfo participant_;
    private LivekitModels$ParticipantInfo publisher_;
    private LivekitAnalytics$ReportInfo report_;
    private LivekitModels$Room room_;
    private LivekitModels$RTPStats rtpStats_;
    private LivekitSip$SIPCallInfo sipCall_;
    private LivekitSip$SIPDispatchRuleInfo sipDispatchRule_;
    private LivekitSip$SIPInboundTrunkInfo sipInboundTrunk_;
    private LivekitSip$SIPOutboundTrunkInfo sipOutboundTrunk_;
    private LivekitSip$SIPTransferInfo sipTransfer_;
    private Timestamp timestamp_;
    private LivekitModels$TrackInfo track_;
    private int type_;
    private int videoLayer_;
    private LivekitAnalytics$WebhookInfo webhook_;
    private String id_ = "";
    private String roomId_ = "";
    private String participantId_ = "";
    private String trackId_ = "";
    private String analyticsKey_ = "";
    private String egressId_ = "";
    private String ingressId_ = "";
    private String mime_ = "";
    private String error_ = "";
    private String nodeId_ = "";
    private String sipCallId_ = "";
    private String sipTrunkId_ = "";
    private String sipDispatchRuleId_ = "";

    public static final class a extends GeneratedMessageLite.b implements ZD3 {
        /* synthetic */ a(c cVar) {
            this();
        }

        private a() {
            super(LivekitAnalytics$AnalyticsEvent.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAnalytics$AnalyticsEvent livekitAnalytics$AnalyticsEvent = new LivekitAnalytics$AnalyticsEvent();
        DEFAULT_INSTANCE = livekitAnalytics$AnalyticsEvent;
        GeneratedMessageLite.registerDefaultInstance(LivekitAnalytics$AnalyticsEvent.class, livekitAnalytics$AnalyticsEvent);
    }

    private LivekitAnalytics$AnalyticsEvent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAnalyticsKey() {
        this.analyticsKey_ = getDefaultInstance().getAnalyticsKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearApiCall() {
        this.apiCall_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClientInfo() {
        this.clientInfo_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClientMeta() {
        this.clientMeta_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEgress() {
        this.egress_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEgressId() {
        this.egressId_ = getDefaultInstance().getEgressId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIngress() {
        this.ingress_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIngressId() {
        this.ingressId_ = getDefaultInstance().getIngressId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaxSubscribedVideoQuality() {
        this.maxSubscribedVideoQuality_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMime() {
        this.mime_ = getDefaultInstance().getMime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNodeId() {
        this.nodeId_ = getDefaultInstance().getNodeId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipant() {
        this.participant_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantId() {
        this.participantId_ = getDefaultInstance().getParticipantId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPublisher() {
        this.publisher_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReport() {
        this.report_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoom() {
        this.room_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomId() {
        this.roomId_ = getDefaultInstance().getRoomId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRtpStats() {
        this.rtpStats_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSipCall() {
        this.sipCall_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSipCallId() {
        this.sipCallId_ = getDefaultInstance().getSipCallId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSipDispatchRule() {
        this.sipDispatchRule_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSipDispatchRuleId() {
        this.sipDispatchRuleId_ = getDefaultInstance().getSipDispatchRuleId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSipInboundTrunk() {
        this.sipInboundTrunk_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSipOutboundTrunk() {
        this.sipOutboundTrunk_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSipTransfer() {
        this.sipTransfer_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSipTrunkId() {
        this.sipTrunkId_ = getDefaultInstance().getSipTrunkId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestamp() {
        this.timestamp_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrack() {
        this.track_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackId() {
        this.trackId_ = getDefaultInstance().getTrackId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.type_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVideoLayer() {
        this.videoLayer_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWebhook() {
        this.webhook_ = null;
    }

    public static LivekitAnalytics$AnalyticsEvent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeApiCall(LivekitAnalytics$APICallInfo livekitAnalytics$APICallInfo) {
        livekitAnalytics$APICallInfo.getClass();
        LivekitAnalytics$APICallInfo livekitAnalytics$APICallInfo2 = this.apiCall_;
        if (livekitAnalytics$APICallInfo2 == null || livekitAnalytics$APICallInfo2 == LivekitAnalytics$APICallInfo.getDefaultInstance()) {
            this.apiCall_ = livekitAnalytics$APICallInfo;
        } else {
            this.apiCall_ = (LivekitAnalytics$APICallInfo) ((LivekitAnalytics$APICallInfo.a) LivekitAnalytics$APICallInfo.newBuilder(this.apiCall_).v(livekitAnalytics$APICallInfo)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeClientInfo(LivekitModels$ClientInfo livekitModels$ClientInfo) {
        livekitModels$ClientInfo.getClass();
        LivekitModels$ClientInfo livekitModels$ClientInfo2 = this.clientInfo_;
        if (livekitModels$ClientInfo2 == null || livekitModels$ClientInfo2 == LivekitModels$ClientInfo.getDefaultInstance()) {
            this.clientInfo_ = livekitModels$ClientInfo;
        } else {
            this.clientInfo_ = (LivekitModels$ClientInfo) ((LivekitModels$ClientInfo.a) LivekitModels$ClientInfo.newBuilder(this.clientInfo_).v(livekitModels$ClientInfo)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeClientMeta(LivekitAnalytics$AnalyticsClientMeta livekitAnalytics$AnalyticsClientMeta) {
        livekitAnalytics$AnalyticsClientMeta.getClass();
        LivekitAnalytics$AnalyticsClientMeta livekitAnalytics$AnalyticsClientMeta2 = this.clientMeta_;
        if (livekitAnalytics$AnalyticsClientMeta2 == null || livekitAnalytics$AnalyticsClientMeta2 == LivekitAnalytics$AnalyticsClientMeta.getDefaultInstance()) {
            this.clientMeta_ = livekitAnalytics$AnalyticsClientMeta;
        } else {
            this.clientMeta_ = (LivekitAnalytics$AnalyticsClientMeta) ((LivekitAnalytics$AnalyticsClientMeta.a) LivekitAnalytics$AnalyticsClientMeta.newBuilder(this.clientMeta_).v(livekitAnalytics$AnalyticsClientMeta)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeEgress(LivekitEgress$EgressInfo livekitEgress$EgressInfo) {
        livekitEgress$EgressInfo.getClass();
        LivekitEgress$EgressInfo livekitEgress$EgressInfo2 = this.egress_;
        if (livekitEgress$EgressInfo2 == null || livekitEgress$EgressInfo2 == LivekitEgress$EgressInfo.getDefaultInstance()) {
            this.egress_ = livekitEgress$EgressInfo;
        } else {
            this.egress_ = (LivekitEgress$EgressInfo) ((LivekitEgress$EgressInfo.a) LivekitEgress$EgressInfo.newBuilder(this.egress_).v(livekitEgress$EgressInfo)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeIngress(LivekitIngress$IngressInfo livekitIngress$IngressInfo) {
        livekitIngress$IngressInfo.getClass();
        LivekitIngress$IngressInfo livekitIngress$IngressInfo2 = this.ingress_;
        if (livekitIngress$IngressInfo2 == null || livekitIngress$IngressInfo2 == LivekitIngress$IngressInfo.getDefaultInstance()) {
            this.ingress_ = livekitIngress$IngressInfo;
        } else {
            this.ingress_ = (LivekitIngress$IngressInfo) ((LivekitIngress$IngressInfo.a) LivekitIngress$IngressInfo.newBuilder(this.ingress_).v(livekitIngress$IngressInfo)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParticipant(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        LivekitModels$ParticipantInfo livekitModels$ParticipantInfo2 = this.participant_;
        if (livekitModels$ParticipantInfo2 == null || livekitModels$ParticipantInfo2 == LivekitModels$ParticipantInfo.getDefaultInstance()) {
            this.participant_ = livekitModels$ParticipantInfo;
        } else {
            this.participant_ = (LivekitModels$ParticipantInfo) ((LivekitModels$ParticipantInfo.c) LivekitModels$ParticipantInfo.newBuilder(this.participant_).v(livekitModels$ParticipantInfo)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePublisher(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        LivekitModels$ParticipantInfo livekitModels$ParticipantInfo2 = this.publisher_;
        if (livekitModels$ParticipantInfo2 == null || livekitModels$ParticipantInfo2 == LivekitModels$ParticipantInfo.getDefaultInstance()) {
            this.publisher_ = livekitModels$ParticipantInfo;
        } else {
            this.publisher_ = (LivekitModels$ParticipantInfo) ((LivekitModels$ParticipantInfo.c) LivekitModels$ParticipantInfo.newBuilder(this.publisher_).v(livekitModels$ParticipantInfo)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeReport(LivekitAnalytics$ReportInfo livekitAnalytics$ReportInfo) {
        livekitAnalytics$ReportInfo.getClass();
        LivekitAnalytics$ReportInfo livekitAnalytics$ReportInfo2 = this.report_;
        if (livekitAnalytics$ReportInfo2 == null || livekitAnalytics$ReportInfo2 == LivekitAnalytics$ReportInfo.getDefaultInstance()) {
            this.report_ = livekitAnalytics$ReportInfo;
        } else {
            this.report_ = (LivekitAnalytics$ReportInfo) ((LivekitAnalytics$ReportInfo.a) LivekitAnalytics$ReportInfo.newBuilder(this.report_).v(livekitAnalytics$ReportInfo)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRoom(LivekitModels$Room livekitModels$Room) {
        livekitModels$Room.getClass();
        LivekitModels$Room livekitModels$Room2 = this.room_;
        if (livekitModels$Room2 == null || livekitModels$Room2 == LivekitModels$Room.getDefaultInstance()) {
            this.room_ = livekitModels$Room;
        } else {
            this.room_ = (LivekitModels$Room) ((LivekitModels$Room.a) LivekitModels$Room.newBuilder(this.room_).v(livekitModels$Room)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRtpStats(LivekitModels$RTPStats livekitModels$RTPStats) {
        livekitModels$RTPStats.getClass();
        LivekitModels$RTPStats livekitModels$RTPStats2 = this.rtpStats_;
        if (livekitModels$RTPStats2 == null || livekitModels$RTPStats2 == LivekitModels$RTPStats.getDefaultInstance()) {
            this.rtpStats_ = livekitModels$RTPStats;
        } else {
            this.rtpStats_ = (LivekitModels$RTPStats) ((LivekitModels$RTPStats.a) LivekitModels$RTPStats.newBuilder(this.rtpStats_).v(livekitModels$RTPStats)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSipCall(LivekitSip$SIPCallInfo livekitSip$SIPCallInfo) {
        livekitSip$SIPCallInfo.getClass();
        LivekitSip$SIPCallInfo livekitSip$SIPCallInfo2 = this.sipCall_;
        if (livekitSip$SIPCallInfo2 == null || livekitSip$SIPCallInfo2 == LivekitSip$SIPCallInfo.getDefaultInstance()) {
            this.sipCall_ = livekitSip$SIPCallInfo;
        } else {
            this.sipCall_ = (LivekitSip$SIPCallInfo) ((LivekitSip$SIPCallInfo.b) LivekitSip$SIPCallInfo.newBuilder(this.sipCall_).v(livekitSip$SIPCallInfo)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSipDispatchRule(LivekitSip$SIPDispatchRuleInfo livekitSip$SIPDispatchRuleInfo) {
        livekitSip$SIPDispatchRuleInfo.getClass();
        LivekitSip$SIPDispatchRuleInfo livekitSip$SIPDispatchRuleInfo2 = this.sipDispatchRule_;
        if (livekitSip$SIPDispatchRuleInfo2 == null || livekitSip$SIPDispatchRuleInfo2 == LivekitSip$SIPDispatchRuleInfo.getDefaultInstance()) {
            this.sipDispatchRule_ = livekitSip$SIPDispatchRuleInfo;
        } else {
            this.sipDispatchRule_ = (LivekitSip$SIPDispatchRuleInfo) ((LivekitSip$SIPDispatchRuleInfo.b) LivekitSip$SIPDispatchRuleInfo.newBuilder(this.sipDispatchRule_).v(livekitSip$SIPDispatchRuleInfo)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSipInboundTrunk(LivekitSip$SIPInboundTrunkInfo livekitSip$SIPInboundTrunkInfo) {
        livekitSip$SIPInboundTrunkInfo.getClass();
        LivekitSip$SIPInboundTrunkInfo livekitSip$SIPInboundTrunkInfo2 = this.sipInboundTrunk_;
        if (livekitSip$SIPInboundTrunkInfo2 == null || livekitSip$SIPInboundTrunkInfo2 == LivekitSip$SIPInboundTrunkInfo.getDefaultInstance()) {
            this.sipInboundTrunk_ = livekitSip$SIPInboundTrunkInfo;
        } else {
            this.sipInboundTrunk_ = (LivekitSip$SIPInboundTrunkInfo) ((LivekitSip$SIPInboundTrunkInfo.b) LivekitSip$SIPInboundTrunkInfo.newBuilder(this.sipInboundTrunk_).v(livekitSip$SIPInboundTrunkInfo)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSipOutboundTrunk(LivekitSip$SIPOutboundTrunkInfo livekitSip$SIPOutboundTrunkInfo) {
        livekitSip$SIPOutboundTrunkInfo.getClass();
        LivekitSip$SIPOutboundTrunkInfo livekitSip$SIPOutboundTrunkInfo2 = this.sipOutboundTrunk_;
        if (livekitSip$SIPOutboundTrunkInfo2 == null || livekitSip$SIPOutboundTrunkInfo2 == LivekitSip$SIPOutboundTrunkInfo.getDefaultInstance()) {
            this.sipOutboundTrunk_ = livekitSip$SIPOutboundTrunkInfo;
        } else {
            this.sipOutboundTrunk_ = (LivekitSip$SIPOutboundTrunkInfo) ((LivekitSip$SIPOutboundTrunkInfo.b) LivekitSip$SIPOutboundTrunkInfo.newBuilder(this.sipOutboundTrunk_).v(livekitSip$SIPOutboundTrunkInfo)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSipTransfer(LivekitSip$SIPTransferInfo livekitSip$SIPTransferInfo) {
        livekitSip$SIPTransferInfo.getClass();
        LivekitSip$SIPTransferInfo livekitSip$SIPTransferInfo2 = this.sipTransfer_;
        if (livekitSip$SIPTransferInfo2 == null || livekitSip$SIPTransferInfo2 == LivekitSip$SIPTransferInfo.getDefaultInstance()) {
            this.sipTransfer_ = livekitSip$SIPTransferInfo;
        } else {
            this.sipTransfer_ = (LivekitSip$SIPTransferInfo) ((LivekitSip$SIPTransferInfo.a) LivekitSip$SIPTransferInfo.newBuilder(this.sipTransfer_).v(livekitSip$SIPTransferInfo)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTimestamp(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.timestamp_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.timestamp_ = timestamp;
        } else {
            this.timestamp_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.timestamp_).v(timestamp)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTrack(LivekitModels$TrackInfo livekitModels$TrackInfo) {
        livekitModels$TrackInfo.getClass();
        LivekitModels$TrackInfo livekitModels$TrackInfo2 = this.track_;
        if (livekitModels$TrackInfo2 == null || livekitModels$TrackInfo2 == LivekitModels$TrackInfo.getDefaultInstance()) {
            this.track_ = livekitModels$TrackInfo;
        } else {
            this.track_ = (LivekitModels$TrackInfo) ((LivekitModels$TrackInfo.b) LivekitModels$TrackInfo.newBuilder(this.track_).v(livekitModels$TrackInfo)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeWebhook(LivekitAnalytics$WebhookInfo livekitAnalytics$WebhookInfo) {
        livekitAnalytics$WebhookInfo.getClass();
        LivekitAnalytics$WebhookInfo livekitAnalytics$WebhookInfo2 = this.webhook_;
        if (livekitAnalytics$WebhookInfo2 == null || livekitAnalytics$WebhookInfo2 == LivekitAnalytics$WebhookInfo.getDefaultInstance()) {
            this.webhook_ = livekitAnalytics$WebhookInfo;
        } else {
            this.webhook_ = (LivekitAnalytics$WebhookInfo) ((LivekitAnalytics$WebhookInfo.a) LivekitAnalytics$WebhookInfo.newBuilder(this.webhook_).v(livekitAnalytics$WebhookInfo)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAnalytics$AnalyticsEvent parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsEvent parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAnalytics$AnalyticsEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnalyticsKey(String str) {
        str.getClass();
        this.analyticsKey_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnalyticsKeyBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.analyticsKey_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setApiCall(LivekitAnalytics$APICallInfo livekitAnalytics$APICallInfo) {
        livekitAnalytics$APICallInfo.getClass();
        this.apiCall_ = livekitAnalytics$APICallInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientInfo(LivekitModels$ClientInfo livekitModels$ClientInfo) {
        livekitModels$ClientInfo.getClass();
        this.clientInfo_ = livekitModels$ClientInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientMeta(LivekitAnalytics$AnalyticsClientMeta livekitAnalytics$AnalyticsClientMeta) {
        livekitAnalytics$AnalyticsClientMeta.getClass();
        this.clientMeta_ = livekitAnalytics$AnalyticsClientMeta;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEgress(LivekitEgress$EgressInfo livekitEgress$EgressInfo) {
        livekitEgress$EgressInfo.getClass();
        this.egress_ = livekitEgress$EgressInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEgressId(String str) {
        str.getClass();
        this.egressId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEgressIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.egressId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(String str) {
        str.getClass();
        this.error_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.error_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIngress(LivekitIngress$IngressInfo livekitIngress$IngressInfo) {
        livekitIngress$IngressInfo.getClass();
        this.ingress_ = livekitIngress$IngressInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIngressId(String str) {
        str.getClass();
        this.ingressId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIngressIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.ingressId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaxSubscribedVideoQuality(EnumC12833fF3 enumC12833fF3) {
        this.maxSubscribedVideoQuality_ = enumC12833fF3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaxSubscribedVideoQualityValue(int i) {
        this.maxSubscribedVideoQuality_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMime(String str) {
        str.getClass();
        this.mime_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMimeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.mime_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNodeId(String str) {
        str.getClass();
        this.nodeId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNodeIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nodeId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipant(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        this.participant_ = livekitModels$ParticipantInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantId(String str) {
        str.getClass();
        this.participantId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPublisher(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        this.publisher_ = livekitModels$ParticipantInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReport(LivekitAnalytics$ReportInfo livekitAnalytics$ReportInfo) {
        livekitAnalytics$ReportInfo.getClass();
        this.report_ = livekitAnalytics$ReportInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoom(LivekitModels$Room livekitModels$Room) {
        livekitModels$Room.getClass();
        this.room_ = livekitModels$Room;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomId(String str) {
        str.getClass();
        this.roomId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.roomId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRtpStats(LivekitModels$RTPStats livekitModels$RTPStats) {
        livekitModels$RTPStats.getClass();
        this.rtpStats_ = livekitModels$RTPStats;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipCall(LivekitSip$SIPCallInfo livekitSip$SIPCallInfo) {
        livekitSip$SIPCallInfo.getClass();
        this.sipCall_ = livekitSip$SIPCallInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipCallId(String str) {
        str.getClass();
        this.sipCallId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipCallIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sipCallId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipDispatchRule(LivekitSip$SIPDispatchRuleInfo livekitSip$SIPDispatchRuleInfo) {
        livekitSip$SIPDispatchRuleInfo.getClass();
        this.sipDispatchRule_ = livekitSip$SIPDispatchRuleInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipDispatchRuleId(String str) {
        str.getClass();
        this.sipDispatchRuleId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipDispatchRuleIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sipDispatchRuleId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipInboundTrunk(LivekitSip$SIPInboundTrunkInfo livekitSip$SIPInboundTrunkInfo) {
        livekitSip$SIPInboundTrunkInfo.getClass();
        this.sipInboundTrunk_ = livekitSip$SIPInboundTrunkInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipOutboundTrunk(LivekitSip$SIPOutboundTrunkInfo livekitSip$SIPOutboundTrunkInfo) {
        livekitSip$SIPOutboundTrunkInfo.getClass();
        this.sipOutboundTrunk_ = livekitSip$SIPOutboundTrunkInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipTransfer(LivekitSip$SIPTransferInfo livekitSip$SIPTransferInfo) {
        livekitSip$SIPTransferInfo.getClass();
        this.sipTransfer_ = livekitSip$SIPTransferInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipTrunkId(String str) {
        str.getClass();
        this.sipTrunkId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipTrunkIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sipTrunkId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestamp(Timestamp timestamp) {
        timestamp.getClass();
        this.timestamp_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrack(LivekitModels$TrackInfo livekitModels$TrackInfo) {
        livekitModels$TrackInfo.getClass();
        this.track_ = livekitModels$TrackInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackId(String str) {
        str.getClass();
        this.trackId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.trackId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(EnumC9598aE3 enumC9598aE3) {
        this.type_ = enumC9598aE3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeValue(int i) {
        this.type_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoLayer(int i) {
        this.videoLayer_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWebhook(LivekitAnalytics$WebhookInfo livekitAnalytics$WebhookInfo) {
        livekitAnalytics$WebhookInfo.getClass();
        this.webhook_ = livekitAnalytics$WebhookInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        c cVar = null;
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAnalytics$AnalyticsEvent();
            case 2:
                return new a(cVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\"\u0000\u0000\u0001$\"\u0000\u0000\u0000\u0001\f\u0002\t\u0003Ȉ\u0004\t\u0005Ȉ\u0006\t\u0007Ȉ\b\t\nȈ\u000b\t\f\t\rȈ\u000e\f\u000f\t\u0010Ȉ\u0011\t\u0012\t\u0013Ȉ\u0014Ȉ\u0015\t\u0016\u0004\u0018Ȉ\u0019Ȉ\u001aȈ\u001b\t\u001cȈ\u001d\t\u001e\t\u001fȈ \t!\t\"\t#\t$\t", new Object[]{"type_", "timestamp_", "roomId_", "room_", "participantId_", "participant_", "trackId_", "track_", "analyticsKey_", "clientInfo_", "clientMeta_", "egressId_", "maxSubscribedVideoQuality_", "publisher_", "mime_", "egress_", "ingress_", "ingressId_", "error_", "rtpStats_", "videoLayer_", "nodeId_", "id_", "sipCallId_", "sipCall_", "sipTrunkId_", "sipInboundTrunk_", "sipOutboundTrunk_", "sipDispatchRuleId_", "sipDispatchRule_", "report_", "apiCall_", "webhook_", "sipTransfer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar2 = PARSER;
                if (cVar2 == null) {
                    synchronized (LivekitAnalytics$AnalyticsEvent.class) {
                        try {
                            cVar2 = PARSER;
                            if (cVar2 == null) {
                                cVar2 = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar2;
                            }
                        } finally {
                        }
                    }
                }
                return cVar2;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public String getAnalyticsKey() {
        return this.analyticsKey_;
    }

    public AbstractC2383g getAnalyticsKeyBytes() {
        return AbstractC2383g.N(this.analyticsKey_);
    }

    public LivekitAnalytics$APICallInfo getApiCall() {
        LivekitAnalytics$APICallInfo livekitAnalytics$APICallInfo = this.apiCall_;
        return livekitAnalytics$APICallInfo == null ? LivekitAnalytics$APICallInfo.getDefaultInstance() : livekitAnalytics$APICallInfo;
    }

    public LivekitModels$ClientInfo getClientInfo() {
        LivekitModels$ClientInfo livekitModels$ClientInfo = this.clientInfo_;
        return livekitModels$ClientInfo == null ? LivekitModels$ClientInfo.getDefaultInstance() : livekitModels$ClientInfo;
    }

    public LivekitAnalytics$AnalyticsClientMeta getClientMeta() {
        LivekitAnalytics$AnalyticsClientMeta livekitAnalytics$AnalyticsClientMeta = this.clientMeta_;
        return livekitAnalytics$AnalyticsClientMeta == null ? LivekitAnalytics$AnalyticsClientMeta.getDefaultInstance() : livekitAnalytics$AnalyticsClientMeta;
    }

    public LivekitEgress$EgressInfo getEgress() {
        LivekitEgress$EgressInfo livekitEgress$EgressInfo = this.egress_;
        return livekitEgress$EgressInfo == null ? LivekitEgress$EgressInfo.getDefaultInstance() : livekitEgress$EgressInfo;
    }

    public String getEgressId() {
        return this.egressId_;
    }

    public AbstractC2383g getEgressIdBytes() {
        return AbstractC2383g.N(this.egressId_);
    }

    public String getError() {
        return this.error_;
    }

    public AbstractC2383g getErrorBytes() {
        return AbstractC2383g.N(this.error_);
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public LivekitIngress$IngressInfo getIngress() {
        LivekitIngress$IngressInfo livekitIngress$IngressInfo = this.ingress_;
        return livekitIngress$IngressInfo == null ? LivekitIngress$IngressInfo.getDefaultInstance() : livekitIngress$IngressInfo;
    }

    public String getIngressId() {
        return this.ingressId_;
    }

    public AbstractC2383g getIngressIdBytes() {
        return AbstractC2383g.N(this.ingressId_);
    }

    public EnumC12833fF3 getMaxSubscribedVideoQuality() {
        EnumC12833fF3 enumC12833fF3J = EnumC12833fF3.j(this.maxSubscribedVideoQuality_);
        return enumC12833fF3J == null ? EnumC12833fF3.UNRECOGNIZED : enumC12833fF3J;
    }

    public int getMaxSubscribedVideoQualityValue() {
        return this.maxSubscribedVideoQuality_;
    }

    public String getMime() {
        return this.mime_;
    }

    public AbstractC2383g getMimeBytes() {
        return AbstractC2383g.N(this.mime_);
    }

    public String getNodeId() {
        return this.nodeId_;
    }

    public AbstractC2383g getNodeIdBytes() {
        return AbstractC2383g.N(this.nodeId_);
    }

    public LivekitModels$ParticipantInfo getParticipant() {
        LivekitModels$ParticipantInfo livekitModels$ParticipantInfo = this.participant_;
        return livekitModels$ParticipantInfo == null ? LivekitModels$ParticipantInfo.getDefaultInstance() : livekitModels$ParticipantInfo;
    }

    public String getParticipantId() {
        return this.participantId_;
    }

    public AbstractC2383g getParticipantIdBytes() {
        return AbstractC2383g.N(this.participantId_);
    }

    public LivekitModels$ParticipantInfo getPublisher() {
        LivekitModels$ParticipantInfo livekitModels$ParticipantInfo = this.publisher_;
        return livekitModels$ParticipantInfo == null ? LivekitModels$ParticipantInfo.getDefaultInstance() : livekitModels$ParticipantInfo;
    }

    public LivekitAnalytics$ReportInfo getReport() {
        LivekitAnalytics$ReportInfo livekitAnalytics$ReportInfo = this.report_;
        return livekitAnalytics$ReportInfo == null ? LivekitAnalytics$ReportInfo.getDefaultInstance() : livekitAnalytics$ReportInfo;
    }

    public LivekitModels$Room getRoom() {
        LivekitModels$Room livekitModels$Room = this.room_;
        return livekitModels$Room == null ? LivekitModels$Room.getDefaultInstance() : livekitModels$Room;
    }

    public String getRoomId() {
        return this.roomId_;
    }

    public AbstractC2383g getRoomIdBytes() {
        return AbstractC2383g.N(this.roomId_);
    }

    public LivekitModels$RTPStats getRtpStats() {
        LivekitModels$RTPStats livekitModels$RTPStats = this.rtpStats_;
        return livekitModels$RTPStats == null ? LivekitModels$RTPStats.getDefaultInstance() : livekitModels$RTPStats;
    }

    public LivekitSip$SIPCallInfo getSipCall() {
        LivekitSip$SIPCallInfo livekitSip$SIPCallInfo = this.sipCall_;
        return livekitSip$SIPCallInfo == null ? LivekitSip$SIPCallInfo.getDefaultInstance() : livekitSip$SIPCallInfo;
    }

    public String getSipCallId() {
        return this.sipCallId_;
    }

    public AbstractC2383g getSipCallIdBytes() {
        return AbstractC2383g.N(this.sipCallId_);
    }

    public LivekitSip$SIPDispatchRuleInfo getSipDispatchRule() {
        LivekitSip$SIPDispatchRuleInfo livekitSip$SIPDispatchRuleInfo = this.sipDispatchRule_;
        return livekitSip$SIPDispatchRuleInfo == null ? LivekitSip$SIPDispatchRuleInfo.getDefaultInstance() : livekitSip$SIPDispatchRuleInfo;
    }

    public String getSipDispatchRuleId() {
        return this.sipDispatchRuleId_;
    }

    public AbstractC2383g getSipDispatchRuleIdBytes() {
        return AbstractC2383g.N(this.sipDispatchRuleId_);
    }

    public LivekitSip$SIPInboundTrunkInfo getSipInboundTrunk() {
        LivekitSip$SIPInboundTrunkInfo livekitSip$SIPInboundTrunkInfo = this.sipInboundTrunk_;
        return livekitSip$SIPInboundTrunkInfo == null ? LivekitSip$SIPInboundTrunkInfo.getDefaultInstance() : livekitSip$SIPInboundTrunkInfo;
    }

    public LivekitSip$SIPOutboundTrunkInfo getSipOutboundTrunk() {
        LivekitSip$SIPOutboundTrunkInfo livekitSip$SIPOutboundTrunkInfo = this.sipOutboundTrunk_;
        return livekitSip$SIPOutboundTrunkInfo == null ? LivekitSip$SIPOutboundTrunkInfo.getDefaultInstance() : livekitSip$SIPOutboundTrunkInfo;
    }

    public LivekitSip$SIPTransferInfo getSipTransfer() {
        LivekitSip$SIPTransferInfo livekitSip$SIPTransferInfo = this.sipTransfer_;
        return livekitSip$SIPTransferInfo == null ? LivekitSip$SIPTransferInfo.getDefaultInstance() : livekitSip$SIPTransferInfo;
    }

    public String getSipTrunkId() {
        return this.sipTrunkId_;
    }

    public AbstractC2383g getSipTrunkIdBytes() {
        return AbstractC2383g.N(this.sipTrunkId_);
    }

    public Timestamp getTimestamp() {
        Timestamp timestamp = this.timestamp_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public LivekitModels$TrackInfo getTrack() {
        LivekitModels$TrackInfo livekitModels$TrackInfo = this.track_;
        return livekitModels$TrackInfo == null ? LivekitModels$TrackInfo.getDefaultInstance() : livekitModels$TrackInfo;
    }

    public String getTrackId() {
        return this.trackId_;
    }

    public AbstractC2383g getTrackIdBytes() {
        return AbstractC2383g.N(this.trackId_);
    }

    public EnumC9598aE3 getType() {
        EnumC9598aE3 enumC9598aE3J = EnumC9598aE3.j(this.type_);
        return enumC9598aE3J == null ? EnumC9598aE3.UNRECOGNIZED : enumC9598aE3J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public int getVideoLayer() {
        return this.videoLayer_;
    }

    public LivekitAnalytics$WebhookInfo getWebhook() {
        LivekitAnalytics$WebhookInfo livekitAnalytics$WebhookInfo = this.webhook_;
        return livekitAnalytics$WebhookInfo == null ? LivekitAnalytics$WebhookInfo.getDefaultInstance() : livekitAnalytics$WebhookInfo;
    }

    public boolean hasApiCall() {
        return this.apiCall_ != null;
    }

    public boolean hasClientInfo() {
        return this.clientInfo_ != null;
    }

    public boolean hasClientMeta() {
        return this.clientMeta_ != null;
    }

    public boolean hasEgress() {
        return this.egress_ != null;
    }

    public boolean hasIngress() {
        return this.ingress_ != null;
    }

    public boolean hasParticipant() {
        return this.participant_ != null;
    }

    public boolean hasPublisher() {
        return this.publisher_ != null;
    }

    public boolean hasReport() {
        return this.report_ != null;
    }

    public boolean hasRoom() {
        return this.room_ != null;
    }

    public boolean hasRtpStats() {
        return this.rtpStats_ != null;
    }

    public boolean hasSipCall() {
        return this.sipCall_ != null;
    }

    public boolean hasSipDispatchRule() {
        return this.sipDispatchRule_ != null;
    }

    public boolean hasSipInboundTrunk() {
        return this.sipInboundTrunk_ != null;
    }

    public boolean hasSipOutboundTrunk() {
        return this.sipOutboundTrunk_ != null;
    }

    public boolean hasSipTransfer() {
        return this.sipTransfer_ != null;
    }

    public boolean hasTimestamp() {
        return this.timestamp_ != null;
    }

    public boolean hasTrack() {
        return this.track_ != null;
    }

    public boolean hasWebhook() {
        return this.webhook_ != null;
    }

    public static a newBuilder(LivekitAnalytics$AnalyticsEvent livekitAnalytics$AnalyticsEvent) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAnalytics$AnalyticsEvent);
    }

    public static LivekitAnalytics$AnalyticsEvent parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsEvent parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAnalytics$AnalyticsEvent parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAnalytics$AnalyticsEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAnalytics$AnalyticsEvent parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAnalytics$AnalyticsEvent parseFrom(byte[] bArr) {
        return (LivekitAnalytics$AnalyticsEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAnalytics$AnalyticsEvent parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAnalytics$AnalyticsEvent parseFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsEvent parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsEvent parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAnalytics$AnalyticsEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAnalytics$AnalyticsEvent parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

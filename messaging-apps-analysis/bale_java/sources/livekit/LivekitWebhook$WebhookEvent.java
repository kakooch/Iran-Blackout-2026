package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitEgress$EgressInfo;
import livekit.LivekitIngress$IngressInfo;
import livekit.LivekitModels$ParticipantInfo;
import livekit.LivekitModels$Room;
import livekit.LivekitModels$TrackInfo;

/* loaded from: classes8.dex */
public final class LivekitWebhook$WebhookEvent extends GeneratedMessageLite implements U64 {
    public static final int CREATED_AT_FIELD_NUMBER = 7;
    private static final LivekitWebhook$WebhookEvent DEFAULT_INSTANCE;
    public static final int EGRESS_INFO_FIELD_NUMBER = 9;
    public static final int EVENT_FIELD_NUMBER = 1;
    public static final int ID_FIELD_NUMBER = 6;
    public static final int INGRESS_INFO_FIELD_NUMBER = 10;
    public static final int NUM_DROPPED_FIELD_NUMBER = 11;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_FIELD_NUMBER = 3;
    public static final int ROOM_FIELD_NUMBER = 2;
    public static final int TRACK_FIELD_NUMBER = 8;
    private long createdAt_;
    private LivekitEgress$EgressInfo egressInfo_;
    private String event_ = "";
    private String id_ = "";
    private LivekitIngress$IngressInfo ingressInfo_;
    private int numDropped_;
    private LivekitModels$ParticipantInfo participant_;
    private LivekitModels$Room room_;
    private LivekitModels$TrackInfo track_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
            super(LivekitWebhook$WebhookEvent.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitWebhook$WebhookEvent livekitWebhook$WebhookEvent = new LivekitWebhook$WebhookEvent();
        DEFAULT_INSTANCE = livekitWebhook$WebhookEvent;
        GeneratedMessageLite.registerDefaultInstance(LivekitWebhook$WebhookEvent.class, livekitWebhook$WebhookEvent);
    }

    private LivekitWebhook$WebhookEvent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEgressInfo() {
        this.egressInfo_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEvent() {
        this.event_ = getDefaultInstance().getEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIngressInfo() {
        this.ingressInfo_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumDropped() {
        this.numDropped_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipant() {
        this.participant_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoom() {
        this.room_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrack() {
        this.track_ = null;
    }

    public static LivekitWebhook$WebhookEvent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeEgressInfo(LivekitEgress$EgressInfo livekitEgress$EgressInfo) {
        livekitEgress$EgressInfo.getClass();
        LivekitEgress$EgressInfo livekitEgress$EgressInfo2 = this.egressInfo_;
        if (livekitEgress$EgressInfo2 == null || livekitEgress$EgressInfo2 == LivekitEgress$EgressInfo.getDefaultInstance()) {
            this.egressInfo_ = livekitEgress$EgressInfo;
        } else {
            this.egressInfo_ = (LivekitEgress$EgressInfo) ((LivekitEgress$EgressInfo.a) LivekitEgress$EgressInfo.newBuilder(this.egressInfo_).v(livekitEgress$EgressInfo)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeIngressInfo(LivekitIngress$IngressInfo livekitIngress$IngressInfo) {
        livekitIngress$IngressInfo.getClass();
        LivekitIngress$IngressInfo livekitIngress$IngressInfo2 = this.ingressInfo_;
        if (livekitIngress$IngressInfo2 == null || livekitIngress$IngressInfo2 == LivekitIngress$IngressInfo.getDefaultInstance()) {
            this.ingressInfo_ = livekitIngress$IngressInfo;
        } else {
            this.ingressInfo_ = (LivekitIngress$IngressInfo) ((LivekitIngress$IngressInfo.a) LivekitIngress$IngressInfo.newBuilder(this.ingressInfo_).v(livekitIngress$IngressInfo)).j();
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
    public void mergeTrack(LivekitModels$TrackInfo livekitModels$TrackInfo) {
        livekitModels$TrackInfo.getClass();
        LivekitModels$TrackInfo livekitModels$TrackInfo2 = this.track_;
        if (livekitModels$TrackInfo2 == null || livekitModels$TrackInfo2 == LivekitModels$TrackInfo.getDefaultInstance()) {
            this.track_ = livekitModels$TrackInfo;
        } else {
            this.track_ = (LivekitModels$TrackInfo) ((LivekitModels$TrackInfo.b) LivekitModels$TrackInfo.newBuilder(this.track_).v(livekitModels$TrackInfo)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitWebhook$WebhookEvent parseDelimitedFrom(InputStream inputStream) {
        return (LivekitWebhook$WebhookEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitWebhook$WebhookEvent parseFrom(ByteBuffer byteBuffer) {
        return (LivekitWebhook$WebhookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEgressInfo(LivekitEgress$EgressInfo livekitEgress$EgressInfo) {
        livekitEgress$EgressInfo.getClass();
        this.egressInfo_ = livekitEgress$EgressInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEvent(String str) {
        str.getClass();
        this.event_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.event_ = abstractC2383g.f0();
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
    public void setIngressInfo(LivekitIngress$IngressInfo livekitIngress$IngressInfo) {
        livekitIngress$IngressInfo.getClass();
        this.ingressInfo_ = livekitIngress$IngressInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumDropped(int i) {
        this.numDropped_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipant(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        livekitModels$ParticipantInfo.getClass();
        this.participant_ = livekitModels$ParticipantInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoom(LivekitModels$Room livekitModels$Room) {
        livekitModels$Room.getClass();
        this.room_ = livekitModels$Room;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrack(LivekitModels$TrackInfo livekitModels$TrackInfo) {
        livekitModels$TrackInfo.getClass();
        this.track_ = livekitModels$TrackInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        v vVar = null;
        switch (v.a[gVar.ordinal()]) {
            case 1:
                return new LivekitWebhook$WebhookEvent();
            case 2:
                return new a(vVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\u000b\t\u0000\u0000\u0000\u0001Ȉ\u0002\t\u0003\t\u0006Ȉ\u0007\u0002\b\t\t\t\n\t\u000b\u0004", new Object[]{"event_", "room_", "participant_", "id_", "createdAt_", "track_", "egressInfo_", "ingressInfo_", "numDropped_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitWebhook$WebhookEvent.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public LivekitEgress$EgressInfo getEgressInfo() {
        LivekitEgress$EgressInfo livekitEgress$EgressInfo = this.egressInfo_;
        return livekitEgress$EgressInfo == null ? LivekitEgress$EgressInfo.getDefaultInstance() : livekitEgress$EgressInfo;
    }

    public String getEvent() {
        return this.event_;
    }

    public AbstractC2383g getEventBytes() {
        return AbstractC2383g.N(this.event_);
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public LivekitIngress$IngressInfo getIngressInfo() {
        LivekitIngress$IngressInfo livekitIngress$IngressInfo = this.ingressInfo_;
        return livekitIngress$IngressInfo == null ? LivekitIngress$IngressInfo.getDefaultInstance() : livekitIngress$IngressInfo;
    }

    @Deprecated
    public int getNumDropped() {
        return this.numDropped_;
    }

    public LivekitModels$ParticipantInfo getParticipant() {
        LivekitModels$ParticipantInfo livekitModels$ParticipantInfo = this.participant_;
        return livekitModels$ParticipantInfo == null ? LivekitModels$ParticipantInfo.getDefaultInstance() : livekitModels$ParticipantInfo;
    }

    public LivekitModels$Room getRoom() {
        LivekitModels$Room livekitModels$Room = this.room_;
        return livekitModels$Room == null ? LivekitModels$Room.getDefaultInstance() : livekitModels$Room;
    }

    public LivekitModels$TrackInfo getTrack() {
        LivekitModels$TrackInfo livekitModels$TrackInfo = this.track_;
        return livekitModels$TrackInfo == null ? LivekitModels$TrackInfo.getDefaultInstance() : livekitModels$TrackInfo;
    }

    public boolean hasEgressInfo() {
        return this.egressInfo_ != null;
    }

    public boolean hasIngressInfo() {
        return this.ingressInfo_ != null;
    }

    public boolean hasParticipant() {
        return this.participant_ != null;
    }

    public boolean hasRoom() {
        return this.room_ != null;
    }

    public boolean hasTrack() {
        return this.track_ != null;
    }

    public static a newBuilder(LivekitWebhook$WebhookEvent livekitWebhook$WebhookEvent) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitWebhook$WebhookEvent);
    }

    public static LivekitWebhook$WebhookEvent parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitWebhook$WebhookEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitWebhook$WebhookEvent parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitWebhook$WebhookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitWebhook$WebhookEvent parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitWebhook$WebhookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitWebhook$WebhookEvent parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitWebhook$WebhookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitWebhook$WebhookEvent parseFrom(byte[] bArr) {
        return (LivekitWebhook$WebhookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitWebhook$WebhookEvent parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitWebhook$WebhookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitWebhook$WebhookEvent parseFrom(InputStream inputStream) {
        return (LivekitWebhook$WebhookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitWebhook$WebhookEvent parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitWebhook$WebhookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitWebhook$WebhookEvent parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitWebhook$WebhookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitWebhook$WebhookEvent parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitWebhook$WebhookEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

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

/* loaded from: classes8.dex */
public final class LivekitRtc$SubscriptionPermissionUpdate extends GeneratedMessageLite implements U64 {
    public static final int ALLOWED_FIELD_NUMBER = 3;
    private static final LivekitRtc$SubscriptionPermissionUpdate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_SID_FIELD_NUMBER = 1;
    public static final int TRACK_SID_FIELD_NUMBER = 2;
    private boolean allowed_;
    private String participantSid_ = "";
    private String trackSid_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$SubscriptionPermissionUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$SubscriptionPermissionUpdate livekitRtc$SubscriptionPermissionUpdate = new LivekitRtc$SubscriptionPermissionUpdate();
        DEFAULT_INSTANCE = livekitRtc$SubscriptionPermissionUpdate;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$SubscriptionPermissionUpdate.class, livekitRtc$SubscriptionPermissionUpdate);
    }

    private LivekitRtc$SubscriptionPermissionUpdate() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAllowed() {
        this.allowed_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantSid() {
        this.participantSid_ = getDefaultInstance().getParticipantSid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSid() {
        this.trackSid_ = getDefaultInstance().getTrackSid();
    }

    public static LivekitRtc$SubscriptionPermissionUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$SubscriptionPermissionUpdate parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$SubscriptionPermissionUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SubscriptionPermissionUpdate parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$SubscriptionPermissionUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAllowed(boolean z) {
        this.allowed_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantSid(String str) {
        str.getClass();
        this.participantSid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantSidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantSid_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackSid(String str) {
        str.getClass();
        this.trackSid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackSidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.trackSid_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$SubscriptionPermissionUpdate();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007", new Object[]{"participantSid_", "trackSid_", "allowed_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$SubscriptionPermissionUpdate.class) {
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

    public boolean getAllowed() {
        return this.allowed_;
    }

    public String getParticipantSid() {
        return this.participantSid_;
    }

    public AbstractC2383g getParticipantSidBytes() {
        return AbstractC2383g.N(this.participantSid_);
    }

    public String getTrackSid() {
        return this.trackSid_;
    }

    public AbstractC2383g getTrackSidBytes() {
        return AbstractC2383g.N(this.trackSid_);
    }

    public static a newBuilder(LivekitRtc$SubscriptionPermissionUpdate livekitRtc$SubscriptionPermissionUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$SubscriptionPermissionUpdate);
    }

    public static LivekitRtc$SubscriptionPermissionUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SubscriptionPermissionUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SubscriptionPermissionUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$SubscriptionPermissionUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$SubscriptionPermissionUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$SubscriptionPermissionUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$SubscriptionPermissionUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$SubscriptionPermissionUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$SubscriptionPermissionUpdate parseFrom(byte[] bArr) {
        return (LivekitRtc$SubscriptionPermissionUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$SubscriptionPermissionUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$SubscriptionPermissionUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$SubscriptionPermissionUpdate parseFrom(InputStream inputStream) {
        return (LivekitRtc$SubscriptionPermissionUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SubscriptionPermissionUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SubscriptionPermissionUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SubscriptionPermissionUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$SubscriptionPermissionUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$SubscriptionPermissionUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$SubscriptionPermissionUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

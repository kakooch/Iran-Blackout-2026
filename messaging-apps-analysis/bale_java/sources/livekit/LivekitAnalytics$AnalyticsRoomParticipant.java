package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitModels$ParticipantInfo;

/* loaded from: classes8.dex */
public final class LivekitAnalytics$AnalyticsRoomParticipant extends GeneratedMessageLite implements d {
    private static final LivekitAnalytics$AnalyticsRoomParticipant DEFAULT_INSTANCE;
    public static final int IDENTITY_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int JOINED_AT_FIELD_NUMBER = 5;
    public static final int NAME_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int STATE_FIELD_NUMBER = 4;
    private Timestamp joinedAt_;
    private int state_;
    private String id_ = "";
    private String identity_ = "";
    private String name_ = "";

    public static final class a extends GeneratedMessageLite.b implements d {
        /* synthetic */ a(c cVar) {
            this();
        }

        private a() {
            super(LivekitAnalytics$AnalyticsRoomParticipant.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAnalytics$AnalyticsRoomParticipant livekitAnalytics$AnalyticsRoomParticipant = new LivekitAnalytics$AnalyticsRoomParticipant();
        DEFAULT_INSTANCE = livekitAnalytics$AnalyticsRoomParticipant;
        GeneratedMessageLite.registerDefaultInstance(LivekitAnalytics$AnalyticsRoomParticipant.class, livekitAnalytics$AnalyticsRoomParticipant);
    }

    private LivekitAnalytics$AnalyticsRoomParticipant() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIdentity() {
        this.identity_ = getDefaultInstance().getIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJoinedAt() {
        this.joinedAt_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        this.state_ = 0;
    }

    public static LivekitAnalytics$AnalyticsRoomParticipant getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeJoinedAt(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.joinedAt_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.joinedAt_ = timestamp;
        } else {
            this.joinedAt_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.joinedAt_).v(timestamp)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAnalytics$AnalyticsRoomParticipant parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsRoomParticipant) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsRoomParticipant parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAnalytics$AnalyticsRoomParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
    public void setIdentity(String str) {
        str.getClass();
        this.identity_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdentityBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.identity_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJoinedAt(Timestamp timestamp) {
        timestamp.getClass();
        this.joinedAt_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(LivekitModels$ParticipantInfo.f fVar) {
        this.state_ = fVar.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStateValue(int i) {
        this.state_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        c cVar = null;
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAnalytics$AnalyticsRoomParticipant();
            case 2:
                return new a(cVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\f\u0005\t", new Object[]{"id_", "identity_", "name_", "state_", "joinedAt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar2 = PARSER;
                if (cVar2 == null) {
                    synchronized (LivekitAnalytics$AnalyticsRoomParticipant.class) {
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

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public String getIdentity() {
        return this.identity_;
    }

    public AbstractC2383g getIdentityBytes() {
        return AbstractC2383g.N(this.identity_);
    }

    public Timestamp getJoinedAt() {
        Timestamp timestamp = this.joinedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public LivekitModels$ParticipantInfo.f getState() {
        LivekitModels$ParticipantInfo.f fVarJ = LivekitModels$ParticipantInfo.f.j(this.state_);
        return fVarJ == null ? LivekitModels$ParticipantInfo.f.UNRECOGNIZED : fVarJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public boolean hasJoinedAt() {
        return this.joinedAt_ != null;
    }

    public static a newBuilder(LivekitAnalytics$AnalyticsRoomParticipant livekitAnalytics$AnalyticsRoomParticipant) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAnalytics$AnalyticsRoomParticipant);
    }

    public static LivekitAnalytics$AnalyticsRoomParticipant parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsRoomParticipant) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsRoomParticipant parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsRoomParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAnalytics$AnalyticsRoomParticipant parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAnalytics$AnalyticsRoomParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAnalytics$AnalyticsRoomParticipant parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsRoomParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAnalytics$AnalyticsRoomParticipant parseFrom(byte[] bArr) {
        return (LivekitAnalytics$AnalyticsRoomParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAnalytics$AnalyticsRoomParticipant parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsRoomParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAnalytics$AnalyticsRoomParticipant parseFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsRoomParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsRoomParticipant parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsRoomParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsRoomParticipant parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAnalytics$AnalyticsRoomParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAnalytics$AnalyticsRoomParticipant parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsRoomParticipant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

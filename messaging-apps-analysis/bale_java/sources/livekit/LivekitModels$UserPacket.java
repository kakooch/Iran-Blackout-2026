package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitModels$UserPacket extends GeneratedMessageLite implements U64 {
    private static final LivekitModels$UserPacket DEFAULT_INSTANCE;
    public static final int DESTINATION_IDENTITIES_FIELD_NUMBER = 6;
    public static final int DESTINATION_SIDS_FIELD_NUMBER = 3;
    public static final int END_TIME_FIELD_NUMBER = 10;
    public static final int ID_FIELD_NUMBER = 8;
    public static final int NONCE_FIELD_NUMBER = 11;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_IDENTITY_FIELD_NUMBER = 5;
    public static final int PARTICIPANT_SID_FIELD_NUMBER = 1;
    public static final int PAYLOAD_FIELD_NUMBER = 2;
    public static final int START_TIME_FIELD_NUMBER = 9;
    public static final int TOPIC_FIELD_NUMBER = 4;
    private int bitField0_;
    private B.j destinationIdentities_;
    private B.j destinationSids_;
    private long endTime_;
    private String id_;
    private AbstractC2383g nonce_;
    private AbstractC2383g payload_;
    private long startTime_;
    private String topic_;
    private String participantSid_ = "";
    private String participantIdentity_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$UserPacket.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$UserPacket livekitModels$UserPacket = new LivekitModels$UserPacket();
        DEFAULT_INSTANCE = livekitModels$UserPacket;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$UserPacket.class, livekitModels$UserPacket);
    }

    private LivekitModels$UserPacket() {
        AbstractC2383g abstractC2383g = AbstractC2383g.b;
        this.payload_ = abstractC2383g;
        this.destinationSids_ = GeneratedMessageLite.emptyProtobufList();
        this.destinationIdentities_ = GeneratedMessageLite.emptyProtobufList();
        this.topic_ = "";
        this.id_ = "";
        this.nonce_ = abstractC2383g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDestinationIdentities(Iterable<String> iterable) {
        ensureDestinationIdentitiesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.destinationIdentities_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDestinationSids(Iterable<String> iterable) {
        ensureDestinationSidsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.destinationSids_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDestinationIdentities(String str) {
        str.getClass();
        ensureDestinationIdentitiesIsMutable();
        this.destinationIdentities_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDestinationIdentitiesBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureDestinationIdentitiesIsMutable();
        this.destinationIdentities_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDestinationSids(String str) {
        str.getClass();
        ensureDestinationSidsIsMutable();
        this.destinationSids_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDestinationSidsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureDestinationSidsIsMutable();
        this.destinationSids_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDestinationIdentities() {
        this.destinationIdentities_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDestinationSids() {
        this.destinationSids_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndTime() {
        this.bitField0_ &= -9;
        this.endTime_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.bitField0_ &= -3;
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNonce() {
        this.nonce_ = getDefaultInstance().getNonce();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantIdentity() {
        this.participantIdentity_ = getDefaultInstance().getParticipantIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantSid() {
        this.participantSid_ = getDefaultInstance().getParticipantSid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPayload() {
        this.payload_ = getDefaultInstance().getPayload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartTime() {
        this.bitField0_ &= -5;
        this.startTime_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTopic() {
        this.bitField0_ &= -2;
        this.topic_ = getDefaultInstance().getTopic();
    }

    private void ensureDestinationIdentitiesIsMutable() {
        B.j jVar = this.destinationIdentities_;
        if (jVar.u()) {
            return;
        }
        this.destinationIdentities_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureDestinationSidsIsMutable() {
        B.j jVar = this.destinationSids_;
        if (jVar.u()) {
            return;
        }
        this.destinationSids_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitModels$UserPacket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$UserPacket parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$UserPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$UserPacket parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$UserPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestinationIdentities(int i, String str) {
        str.getClass();
        ensureDestinationIdentitiesIsMutable();
        this.destinationIdentities_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestinationSids(int i, String str) {
        str.getClass();
        ensureDestinationSidsIsMutable();
        this.destinationSids_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndTime(long j) {
        this.bitField0_ |= 8;
        this.endTime_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNonce(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.nonce_ = abstractC2383g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantIdentity(String str) {
        str.getClass();
        this.participantIdentity_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantIdentityBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantIdentity_ = abstractC2383g.f0();
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
    public void setPayload(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.payload_ = abstractC2383g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartTime(long j) {
        this.bitField0_ |= 4;
        this.startTime_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTopic(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.topic_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTopicBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.topic_ = abstractC2383g.f0();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$UserPacket();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0001\u0001\u000b\n\u0000\u0002\u0000\u0001Ȉ\u0002\n\u0003Ț\u0004ለ\u0000\u0005Ȉ\u0006Ț\bለ\u0001\tဃ\u0002\nဃ\u0003\u000b\n", new Object[]{"bitField0_", "participantSid_", "payload_", "destinationSids_", "topic_", "participantIdentity_", "destinationIdentities_", "id_", "startTime_", "endTime_", "nonce_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$UserPacket.class) {
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

    @Deprecated
    public String getDestinationIdentities(int i) {
        return (String) this.destinationIdentities_.get(i);
    }

    @Deprecated
    public AbstractC2383g getDestinationIdentitiesBytes(int i) {
        return AbstractC2383g.N((String) this.destinationIdentities_.get(i));
    }

    @Deprecated
    public int getDestinationIdentitiesCount() {
        return this.destinationIdentities_.size();
    }

    @Deprecated
    public List<String> getDestinationIdentitiesList() {
        return this.destinationIdentities_;
    }

    @Deprecated
    public String getDestinationSids(int i) {
        return (String) this.destinationSids_.get(i);
    }

    @Deprecated
    public AbstractC2383g getDestinationSidsBytes(int i) {
        return AbstractC2383g.N((String) this.destinationSids_.get(i));
    }

    @Deprecated
    public int getDestinationSidsCount() {
        return this.destinationSids_.size();
    }

    @Deprecated
    public List<String> getDestinationSidsList() {
        return this.destinationSids_;
    }

    public long getEndTime() {
        return this.endTime_;
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public AbstractC2383g getNonce() {
        return this.nonce_;
    }

    @Deprecated
    public String getParticipantIdentity() {
        return this.participantIdentity_;
    }

    @Deprecated
    public AbstractC2383g getParticipantIdentityBytes() {
        return AbstractC2383g.N(this.participantIdentity_);
    }

    @Deprecated
    public String getParticipantSid() {
        return this.participantSid_;
    }

    @Deprecated
    public AbstractC2383g getParticipantSidBytes() {
        return AbstractC2383g.N(this.participantSid_);
    }

    public AbstractC2383g getPayload() {
        return this.payload_;
    }

    public long getStartTime() {
        return this.startTime_;
    }

    public String getTopic() {
        return this.topic_;
    }

    public AbstractC2383g getTopicBytes() {
        return AbstractC2383g.N(this.topic_);
    }

    public boolean hasEndTime() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasId() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasStartTime() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasTopic() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(LivekitModels$UserPacket livekitModels$UserPacket) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$UserPacket);
    }

    public static LivekitModels$UserPacket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$UserPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$UserPacket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$UserPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$UserPacket parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$UserPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$UserPacket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$UserPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$UserPacket parseFrom(byte[] bArr) {
        return (LivekitModels$UserPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$UserPacket parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$UserPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$UserPacket parseFrom(InputStream inputStream) {
        return (LivekitModels$UserPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$UserPacket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$UserPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$UserPacket parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$UserPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$UserPacket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$UserPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

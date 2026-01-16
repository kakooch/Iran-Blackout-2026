package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.PE3;
import ir.nasim.WE3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import livekit.LivekitModels$TimedVersion;

/* loaded from: classes8.dex */
public final class LivekitModels$Room extends GeneratedMessageLite implements WE3 {
    public static final int ACTIVE_RECORDING_FIELD_NUMBER = 10;
    public static final int CREATION_TIME_FIELD_NUMBER = 5;
    public static final int CREATION_TIME_MS_FIELD_NUMBER = 15;
    private static final LivekitModels$Room DEFAULT_INSTANCE;
    public static final int DEPARTURE_TIMEOUT_FIELD_NUMBER = 14;
    public static final int EMPTY_TIMEOUT_FIELD_NUMBER = 3;
    public static final int ENABLED_CODECS_FIELD_NUMBER = 7;
    public static final int MAX_PARTICIPANTS_FIELD_NUMBER = 4;
    public static final int METADATA_FIELD_NUMBER = 8;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int NUM_PARTICIPANTS_FIELD_NUMBER = 9;
    public static final int NUM_PUBLISHERS_FIELD_NUMBER = 11;
    private static volatile KW4 PARSER = null;
    public static final int SID_FIELD_NUMBER = 1;
    public static final int TURN_PASSWORD_FIELD_NUMBER = 6;
    public static final int VERSION_FIELD_NUMBER = 13;
    private boolean activeRecording_;
    private long creationTimeMs_;
    private long creationTime_;
    private int departureTimeout_;
    private int emptyTimeout_;
    private int maxParticipants_;
    private int numParticipants_;
    private int numPublishers_;
    private LivekitModels$TimedVersion version_;
    private String sid_ = "";
    private String name_ = "";
    private String turnPassword_ = "";
    private B.j enabledCodecs_ = GeneratedMessageLite.emptyProtobufList();
    private String metadata_ = "";

    public static final class a extends GeneratedMessageLite.b implements WE3 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$Room.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$Room livekitModels$Room = new LivekitModels$Room();
        DEFAULT_INSTANCE = livekitModels$Room;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$Room.class, livekitModels$Room);
    }

    private LivekitModels$Room() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllEnabledCodecs(Iterable<? extends LivekitModels$Codec> iterable) {
        ensureEnabledCodecsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.enabledCodecs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnabledCodecs(LivekitModels$Codec livekitModels$Codec) {
        livekitModels$Codec.getClass();
        ensureEnabledCodecsIsMutable();
        this.enabledCodecs_.add(livekitModels$Codec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearActiveRecording() {
        this.activeRecording_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreationTime() {
        this.creationTime_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreationTimeMs() {
        this.creationTimeMs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDepartureTimeout() {
        this.departureTimeout_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEmptyTimeout() {
        this.emptyTimeout_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEnabledCodecs() {
        this.enabledCodecs_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaxParticipants() {
        this.maxParticipants_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = getDefaultInstance().getMetadata();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumParticipants() {
        this.numParticipants_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumPublishers() {
        this.numPublishers_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSid() {
        this.sid_ = getDefaultInstance().getSid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTurnPassword() {
        this.turnPassword_ = getDefaultInstance().getTurnPassword();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = null;
    }

    private void ensureEnabledCodecsIsMutable() {
        B.j jVar = this.enabledCodecs_;
        if (jVar.u()) {
            return;
        }
        this.enabledCodecs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitModels$Room getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeVersion(LivekitModels$TimedVersion livekitModels$TimedVersion) {
        livekitModels$TimedVersion.getClass();
        LivekitModels$TimedVersion livekitModels$TimedVersion2 = this.version_;
        if (livekitModels$TimedVersion2 == null || livekitModels$TimedVersion2 == LivekitModels$TimedVersion.getDefaultInstance()) {
            this.version_ = livekitModels$TimedVersion;
        } else {
            this.version_ = (LivekitModels$TimedVersion) ((LivekitModels$TimedVersion.a) LivekitModels$TimedVersion.newBuilder(this.version_).v(livekitModels$TimedVersion)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$Room parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$Room) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$Room parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$Room) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeEnabledCodecs(int i) {
        ensureEnabledCodecsIsMutable();
        this.enabledCodecs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActiveRecording(boolean z) {
        this.activeRecording_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreationTime(long j) {
        this.creationTime_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreationTimeMs(long j) {
        this.creationTimeMs_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDepartureTimeout(int i) {
        this.departureTimeout_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEmptyTimeout(int i) {
        this.emptyTimeout_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnabledCodecs(int i, LivekitModels$Codec livekitModels$Codec) {
        livekitModels$Codec.getClass();
        ensureEnabledCodecsIsMutable();
        this.enabledCodecs_.set(i, livekitModels$Codec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaxParticipants(int i) {
        this.maxParticipants_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadata(String str) {
        str.getClass();
        this.metadata_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.metadata_ = abstractC2383g.f0();
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
    public void setNumParticipants(int i) {
        this.numParticipants_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumPublishers(int i) {
        this.numPublishers_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSid(String str) {
        str.getClass();
        this.sid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sid_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTurnPassword(String str) {
        str.getClass();
        this.turnPassword_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTurnPasswordBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.turnPassword_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(LivekitModels$TimedVersion livekitModels$TimedVersion) {
        livekitModels$TimedVersion.getClass();
        this.version_ = livekitModels$TimedVersion;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$Room();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000e\u0000\u0000\u0001\u000f\u000e\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u000b\u0005\u0002\u0006Ȉ\u0007\u001b\bȈ\t\u000b\n\u0007\u000b\u000b\r\t\u000e\u000b\u000f\u0002", new Object[]{"sid_", "name_", "emptyTimeout_", "maxParticipants_", "creationTime_", "turnPassword_", "enabledCodecs_", LivekitModels$Codec.class, "metadata_", "numParticipants_", "activeRecording_", "numPublishers_", "version_", "departureTimeout_", "creationTimeMs_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$Room.class) {
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

    public boolean getActiveRecording() {
        return this.activeRecording_;
    }

    public long getCreationTime() {
        return this.creationTime_;
    }

    public long getCreationTimeMs() {
        return this.creationTimeMs_;
    }

    public int getDepartureTimeout() {
        return this.departureTimeout_;
    }

    public int getEmptyTimeout() {
        return this.emptyTimeout_;
    }

    public LivekitModels$Codec getEnabledCodecs(int i) {
        return (LivekitModels$Codec) this.enabledCodecs_.get(i);
    }

    public int getEnabledCodecsCount() {
        return this.enabledCodecs_.size();
    }

    public List<LivekitModels$Codec> getEnabledCodecsList() {
        return this.enabledCodecs_;
    }

    public PE3 getEnabledCodecsOrBuilder(int i) {
        return (PE3) this.enabledCodecs_.get(i);
    }

    public List<? extends PE3> getEnabledCodecsOrBuilderList() {
        return this.enabledCodecs_;
    }

    public int getMaxParticipants() {
        return this.maxParticipants_;
    }

    public String getMetadata() {
        return this.metadata_;
    }

    public AbstractC2383g getMetadataBytes() {
        return AbstractC2383g.N(this.metadata_);
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public int getNumParticipants() {
        return this.numParticipants_;
    }

    public int getNumPublishers() {
        return this.numPublishers_;
    }

    public String getSid() {
        return this.sid_;
    }

    public AbstractC2383g getSidBytes() {
        return AbstractC2383g.N(this.sid_);
    }

    public String getTurnPassword() {
        return this.turnPassword_;
    }

    public AbstractC2383g getTurnPasswordBytes() {
        return AbstractC2383g.N(this.turnPassword_);
    }

    public LivekitModels$TimedVersion getVersion() {
        LivekitModels$TimedVersion livekitModels$TimedVersion = this.version_;
        return livekitModels$TimedVersion == null ? LivekitModels$TimedVersion.getDefaultInstance() : livekitModels$TimedVersion;
    }

    public boolean hasVersion() {
        return this.version_ != null;
    }

    public static a newBuilder(LivekitModels$Room livekitModels$Room) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$Room);
    }

    public static LivekitModels$Room parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$Room) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$Room parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$Room) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$Room parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$Room) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnabledCodecs(int i, LivekitModels$Codec livekitModels$Codec) {
        livekitModels$Codec.getClass();
        ensureEnabledCodecsIsMutable();
        this.enabledCodecs_.add(i, livekitModels$Codec);
    }

    public static LivekitModels$Room parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$Room) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$Room parseFrom(byte[] bArr) {
        return (LivekitModels$Room) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$Room parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$Room) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$Room parseFrom(InputStream inputStream) {
        return (LivekitModels$Room) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$Room parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$Room) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$Room parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$Room) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$Room parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$Room) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

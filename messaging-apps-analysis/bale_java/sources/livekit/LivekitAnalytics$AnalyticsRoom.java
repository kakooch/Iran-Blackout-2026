package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.InterfaceC10192bE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitAnalytics$AnalyticsRoom extends GeneratedMessageLite implements InterfaceC10192bE3 {
    public static final int CREATED_AT_FIELD_NUMBER = 3;
    private static final LivekitAnalytics$AnalyticsRoom DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANTS_FIELD_NUMBER = 4;
    public static final int PROJECT_ID_FIELD_NUMBER = 5;
    private Timestamp createdAt_;
    private String id_ = "";
    private String name_ = "";
    private String projectId_ = "";
    private B.j participants_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC10192bE3 {
        /* synthetic */ a(c cVar) {
            this();
        }

        private a() {
            super(LivekitAnalytics$AnalyticsRoom.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAnalytics$AnalyticsRoom livekitAnalytics$AnalyticsRoom = new LivekitAnalytics$AnalyticsRoom();
        DEFAULT_INSTANCE = livekitAnalytics$AnalyticsRoom;
        GeneratedMessageLite.registerDefaultInstance(LivekitAnalytics$AnalyticsRoom.class, livekitAnalytics$AnalyticsRoom);
    }

    private LivekitAnalytics$AnalyticsRoom() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllParticipants(Iterable<? extends LivekitAnalytics$AnalyticsRoomParticipant> iterable) {
        ensureParticipantsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.participants_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParticipants(LivekitAnalytics$AnalyticsRoomParticipant livekitAnalytics$AnalyticsRoomParticipant) {
        livekitAnalytics$AnalyticsRoomParticipant.getClass();
        ensureParticipantsIsMutable();
        this.participants_.add(livekitAnalytics$AnalyticsRoomParticipant);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreatedAt() {
        this.createdAt_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipants() {
        this.participants_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProjectId() {
        this.projectId_ = getDefaultInstance().getProjectId();
    }

    private void ensureParticipantsIsMutable() {
        B.j jVar = this.participants_;
        if (jVar.u()) {
            return;
        }
        this.participants_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitAnalytics$AnalyticsRoom getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCreatedAt(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.createdAt_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.createdAt_ = timestamp;
        } else {
            this.createdAt_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.createdAt_).v(timestamp)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAnalytics$AnalyticsRoom parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsRoom) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsRoom parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAnalytics$AnalyticsRoom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeParticipants(int i) {
        ensureParticipantsIsMutable();
        this.participants_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreatedAt(Timestamp timestamp) {
        timestamp.getClass();
        this.createdAt_ = timestamp;
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
    public void setParticipants(int i, LivekitAnalytics$AnalyticsRoomParticipant livekitAnalytics$AnalyticsRoomParticipant) {
        livekitAnalytics$AnalyticsRoomParticipant.getClass();
        ensureParticipantsIsMutable();
        this.participants_.set(i, livekitAnalytics$AnalyticsRoomParticipant);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProjectId(String str) {
        str.getClass();
        this.projectId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProjectIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.projectId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        c cVar = null;
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAnalytics$AnalyticsRoom();
            case 2:
                return new a(cVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\t\u0004\u001b\u0005Ȉ", new Object[]{"id_", "name_", "createdAt_", "participants_", LivekitAnalytics$AnalyticsRoomParticipant.class, "projectId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar2 = PARSER;
                if (cVar2 == null) {
                    synchronized (LivekitAnalytics$AnalyticsRoom.class) {
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

    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public LivekitAnalytics$AnalyticsRoomParticipant getParticipants(int i) {
        return (LivekitAnalytics$AnalyticsRoomParticipant) this.participants_.get(i);
    }

    public int getParticipantsCount() {
        return this.participants_.size();
    }

    public List<LivekitAnalytics$AnalyticsRoomParticipant> getParticipantsList() {
        return this.participants_;
    }

    public d getParticipantsOrBuilder(int i) {
        return (d) this.participants_.get(i);
    }

    public List<? extends d> getParticipantsOrBuilderList() {
        return this.participants_;
    }

    public String getProjectId() {
        return this.projectId_;
    }

    public AbstractC2383g getProjectIdBytes() {
        return AbstractC2383g.N(this.projectId_);
    }

    public boolean hasCreatedAt() {
        return this.createdAt_ != null;
    }

    public static a newBuilder(LivekitAnalytics$AnalyticsRoom livekitAnalytics$AnalyticsRoom) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAnalytics$AnalyticsRoom);
    }

    public static LivekitAnalytics$AnalyticsRoom parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsRoom) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsRoom parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsRoom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAnalytics$AnalyticsRoom parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAnalytics$AnalyticsRoom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParticipants(int i, LivekitAnalytics$AnalyticsRoomParticipant livekitAnalytics$AnalyticsRoomParticipant) {
        livekitAnalytics$AnalyticsRoomParticipant.getClass();
        ensureParticipantsIsMutable();
        this.participants_.add(i, livekitAnalytics$AnalyticsRoomParticipant);
    }

    public static LivekitAnalytics$AnalyticsRoom parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsRoom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAnalytics$AnalyticsRoom parseFrom(byte[] bArr) {
        return (LivekitAnalytics$AnalyticsRoom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAnalytics$AnalyticsRoom parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsRoom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAnalytics$AnalyticsRoom parseFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsRoom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsRoom parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsRoom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsRoom parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAnalytics$AnalyticsRoom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAnalytics$AnalyticsRoom parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsRoom) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

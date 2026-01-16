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
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitAnalytics$AnalyticsNodeRooms extends GeneratedMessageLite implements U64 {
    private static final LivekitAnalytics$AnalyticsNodeRooms DEFAULT_INSTANCE;
    public static final int NODE_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int ROOMS_FIELD_NUMBER = 4;
    public static final int SEQUENCE_NUMBER_FIELD_NUMBER = 2;
    public static final int TIMESTAMP_FIELD_NUMBER = 3;
    private String nodeId_ = "";
    private B.j rooms_ = GeneratedMessageLite.emptyProtobufList();
    private long sequenceNumber_;
    private Timestamp timestamp_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(c cVar) {
            this();
        }

        private a() {
            super(LivekitAnalytics$AnalyticsNodeRooms.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAnalytics$AnalyticsNodeRooms livekitAnalytics$AnalyticsNodeRooms = new LivekitAnalytics$AnalyticsNodeRooms();
        DEFAULT_INSTANCE = livekitAnalytics$AnalyticsNodeRooms;
        GeneratedMessageLite.registerDefaultInstance(LivekitAnalytics$AnalyticsNodeRooms.class, livekitAnalytics$AnalyticsNodeRooms);
    }

    private LivekitAnalytics$AnalyticsNodeRooms() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRooms(Iterable<? extends LivekitAnalytics$AnalyticsRoom> iterable) {
        ensureRoomsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.rooms_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRooms(LivekitAnalytics$AnalyticsRoom livekitAnalytics$AnalyticsRoom) {
        livekitAnalytics$AnalyticsRoom.getClass();
        ensureRoomsIsMutable();
        this.rooms_.add(livekitAnalytics$AnalyticsRoom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNodeId() {
        this.nodeId_ = getDefaultInstance().getNodeId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRooms() {
        this.rooms_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSequenceNumber() {
        this.sequenceNumber_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestamp() {
        this.timestamp_ = null;
    }

    private void ensureRoomsIsMutable() {
        B.j jVar = this.rooms_;
        if (jVar.u()) {
            return;
        }
        this.rooms_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitAnalytics$AnalyticsNodeRooms getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAnalytics$AnalyticsNodeRooms parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsNodeRooms) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsNodeRooms parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAnalytics$AnalyticsNodeRooms) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRooms(int i) {
        ensureRoomsIsMutable();
        this.rooms_.remove(i);
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
    public void setRooms(int i, LivekitAnalytics$AnalyticsRoom livekitAnalytics$AnalyticsRoom) {
        livekitAnalytics$AnalyticsRoom.getClass();
        ensureRoomsIsMutable();
        this.rooms_.set(i, livekitAnalytics$AnalyticsRoom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSequenceNumber(long j) {
        this.sequenceNumber_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestamp(Timestamp timestamp) {
        timestamp.getClass();
        this.timestamp_ = timestamp;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        c cVar = null;
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAnalytics$AnalyticsNodeRooms();
            case 2:
                return new a(cVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\u0003\u0003\t\u0004\u001b", new Object[]{"nodeId_", "sequenceNumber_", "timestamp_", "rooms_", LivekitAnalytics$AnalyticsRoom.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar2 = PARSER;
                if (cVar2 == null) {
                    synchronized (LivekitAnalytics$AnalyticsNodeRooms.class) {
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

    public String getNodeId() {
        return this.nodeId_;
    }

    public AbstractC2383g getNodeIdBytes() {
        return AbstractC2383g.N(this.nodeId_);
    }

    public LivekitAnalytics$AnalyticsRoom getRooms(int i) {
        return (LivekitAnalytics$AnalyticsRoom) this.rooms_.get(i);
    }

    public int getRoomsCount() {
        return this.rooms_.size();
    }

    public List<LivekitAnalytics$AnalyticsRoom> getRoomsList() {
        return this.rooms_;
    }

    public InterfaceC10192bE3 getRoomsOrBuilder(int i) {
        return (InterfaceC10192bE3) this.rooms_.get(i);
    }

    public List<? extends InterfaceC10192bE3> getRoomsOrBuilderList() {
        return this.rooms_;
    }

    public long getSequenceNumber() {
        return this.sequenceNumber_;
    }

    public Timestamp getTimestamp() {
        Timestamp timestamp = this.timestamp_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public boolean hasTimestamp() {
        return this.timestamp_ != null;
    }

    public static a newBuilder(LivekitAnalytics$AnalyticsNodeRooms livekitAnalytics$AnalyticsNodeRooms) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAnalytics$AnalyticsNodeRooms);
    }

    public static LivekitAnalytics$AnalyticsNodeRooms parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsNodeRooms) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsNodeRooms parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsNodeRooms) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAnalytics$AnalyticsNodeRooms parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAnalytics$AnalyticsNodeRooms) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRooms(int i, LivekitAnalytics$AnalyticsRoom livekitAnalytics$AnalyticsRoom) {
        livekitAnalytics$AnalyticsRoom.getClass();
        ensureRoomsIsMutable();
        this.rooms_.add(i, livekitAnalytics$AnalyticsRoom);
    }

    public static LivekitAnalytics$AnalyticsNodeRooms parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsNodeRooms) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAnalytics$AnalyticsNodeRooms parseFrom(byte[] bArr) {
        return (LivekitAnalytics$AnalyticsNodeRooms) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAnalytics$AnalyticsNodeRooms parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsNodeRooms) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAnalytics$AnalyticsNodeRooms parseFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsNodeRooms) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsNodeRooms parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsNodeRooms) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsNodeRooms parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAnalytics$AnalyticsNodeRooms) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAnalytics$AnalyticsNodeRooms parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsNodeRooms) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

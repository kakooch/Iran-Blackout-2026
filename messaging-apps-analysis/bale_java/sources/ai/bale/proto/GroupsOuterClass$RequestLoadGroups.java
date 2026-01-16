package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11468d35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$RequestLoadGroups extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$RequestLoadGroups DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEERS_FIELD_NUMBER = 1;
    private B.j peers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$RequestLoadGroups.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestLoadGroups groupsOuterClass$RequestLoadGroups = new GroupsOuterClass$RequestLoadGroups();
        DEFAULT_INSTANCE = groupsOuterClass$RequestLoadGroups;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestLoadGroups.class, groupsOuterClass$RequestLoadGroups);
    }

    private GroupsOuterClass$RequestLoadGroups() {
    }

    private void addAllPeers(Iterable<? extends PeersStruct$GroupOutPeer> iterable) {
        ensurePeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.peers_);
    }

    private void addPeers(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.add(peersStruct$GroupOutPeer);
    }

    private void clearPeers() {
        this.peers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePeersIsMutable() {
        B.j jVar = this.peers_;
        if (jVar.u()) {
            return;
        }
        this.peers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GroupsOuterClass$RequestLoadGroups getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestLoadGroups parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestLoadGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestLoadGroups parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestLoadGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePeers(int i) {
        ensurePeersIsMutable();
        this.peers_.remove(i);
    }

    private void setPeers(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.set(i, peersStruct$GroupOutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestLoadGroups();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"peers_", PeersStruct$GroupOutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestLoadGroups.class) {
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

    public PeersStruct$GroupOutPeer getPeers(int i) {
        return (PeersStruct$GroupOutPeer) this.peers_.get(i);
    }

    public int getPeersCount() {
        return this.peers_.size();
    }

    public List<PeersStruct$GroupOutPeer> getPeersList() {
        return this.peers_;
    }

    public InterfaceC11468d35 getPeersOrBuilder(int i) {
        return (InterfaceC11468d35) this.peers_.get(i);
    }

    public List<? extends InterfaceC11468d35> getPeersOrBuilderList() {
        return this.peers_;
    }

    public static a newBuilder(GroupsOuterClass$RequestLoadGroups groupsOuterClass$RequestLoadGroups) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestLoadGroups);
    }

    public static GroupsOuterClass$RequestLoadGroups parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestLoadGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestLoadGroups parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestLoadGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestLoadGroups parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestLoadGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPeers(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.add(i, peersStruct$GroupOutPeer);
    }

    public static GroupsOuterClass$RequestLoadGroups parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestLoadGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestLoadGroups parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestLoadGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestLoadGroups parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestLoadGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestLoadGroups parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestLoadGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestLoadGroups parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestLoadGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestLoadGroups parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestLoadGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestLoadGroups parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestLoadGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC9494a35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryOuterClass$RequestGetStoriesByList extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$RequestGetStoriesByList DEFAULT_INSTANCE;
    public static final int EX_PEERS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j exPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryOuterClass$RequestGetStoriesByList.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$RequestGetStoriesByList storyOuterClass$RequestGetStoriesByList = new StoryOuterClass$RequestGetStoriesByList();
        DEFAULT_INSTANCE = storyOuterClass$RequestGetStoriesByList;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$RequestGetStoriesByList.class, storyOuterClass$RequestGetStoriesByList);
    }

    private StoryOuterClass$RequestGetStoriesByList() {
    }

    private void addAllExPeers(Iterable<? extends PeersStruct$ExPeer> iterable) {
        ensureExPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.exPeers_);
    }

    private void addExPeers(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureExPeersIsMutable();
        this.exPeers_.add(peersStruct$ExPeer);
    }

    private void clearExPeers() {
        this.exPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureExPeersIsMutable() {
        B.j jVar = this.exPeers_;
        if (jVar.u()) {
            return;
        }
        this.exPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static StoryOuterClass$RequestGetStoriesByList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$RequestGetStoriesByList parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestGetStoriesByList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestGetStoriesByList parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$RequestGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeExPeers(int i) {
        ensureExPeersIsMutable();
        this.exPeers_.remove(i);
    }

    private void setExPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureExPeersIsMutable();
        this.exPeers_.set(i, peersStruct$ExPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$RequestGetStoriesByList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"exPeers_", PeersStruct$ExPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$RequestGetStoriesByList.class) {
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

    public PeersStruct$ExPeer getExPeers(int i) {
        return (PeersStruct$ExPeer) this.exPeers_.get(i);
    }

    public int getExPeersCount() {
        return this.exPeers_.size();
    }

    public List<PeersStruct$ExPeer> getExPeersList() {
        return this.exPeers_;
    }

    public InterfaceC9494a35 getExPeersOrBuilder(int i) {
        return (InterfaceC9494a35) this.exPeers_.get(i);
    }

    public List<? extends InterfaceC9494a35> getExPeersOrBuilderList() {
        return this.exPeers_;
    }

    public static a newBuilder(StoryOuterClass$RequestGetStoriesByList storyOuterClass$RequestGetStoriesByList) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$RequestGetStoriesByList);
    }

    public static StoryOuterClass$RequestGetStoriesByList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStoriesByList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestGetStoriesByList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$RequestGetStoriesByList parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$RequestGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addExPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureExPeersIsMutable();
        this.exPeers_.add(i, peersStruct$ExPeer);
    }

    public static StoryOuterClass$RequestGetStoriesByList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$RequestGetStoriesByList parseFrom(byte[] bArr) {
        return (StoryOuterClass$RequestGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$RequestGetStoriesByList parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$RequestGetStoriesByList parseFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestGetStoriesByList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestGetStoriesByList parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$RequestGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$RequestGetStoriesByList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

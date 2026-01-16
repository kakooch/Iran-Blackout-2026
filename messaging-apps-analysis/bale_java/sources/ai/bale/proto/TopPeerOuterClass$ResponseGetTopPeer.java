package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7677Ss7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class TopPeerOuterClass$ResponseGetTopPeer extends GeneratedMessageLite implements U64 {
    private static final TopPeerOuterClass$ResponseGetTopPeer DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TOP_PEERS_FIELD_NUMBER = 1;
    private B.j topPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(TopPeerOuterClass$ResponseGetTopPeer.DEFAULT_INSTANCE);
        }
    }

    static {
        TopPeerOuterClass$ResponseGetTopPeer topPeerOuterClass$ResponseGetTopPeer = new TopPeerOuterClass$ResponseGetTopPeer();
        DEFAULT_INSTANCE = topPeerOuterClass$ResponseGetTopPeer;
        GeneratedMessageLite.registerDefaultInstance(TopPeerOuterClass$ResponseGetTopPeer.class, topPeerOuterClass$ResponseGetTopPeer);
    }

    private TopPeerOuterClass$ResponseGetTopPeer() {
    }

    private void addAllTopPeers(Iterable<? extends TopPeerOuterClass$TopPeerMetaData> iterable) {
        ensureTopPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.topPeers_);
    }

    private void addTopPeers(TopPeerOuterClass$TopPeerMetaData topPeerOuterClass$TopPeerMetaData) {
        topPeerOuterClass$TopPeerMetaData.getClass();
        ensureTopPeersIsMutable();
        this.topPeers_.add(topPeerOuterClass$TopPeerMetaData);
    }

    private void clearTopPeers() {
        this.topPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureTopPeersIsMutable() {
        B.j jVar = this.topPeers_;
        if (jVar.u()) {
            return;
        }
        this.topPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static TopPeerOuterClass$ResponseGetTopPeer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TopPeerOuterClass$ResponseGetTopPeer parseDelimitedFrom(InputStream inputStream) {
        return (TopPeerOuterClass$ResponseGetTopPeer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TopPeerOuterClass$ResponseGetTopPeer parseFrom(ByteBuffer byteBuffer) {
        return (TopPeerOuterClass$ResponseGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeTopPeers(int i) {
        ensureTopPeersIsMutable();
        this.topPeers_.remove(i);
    }

    private void setTopPeers(int i, TopPeerOuterClass$TopPeerMetaData topPeerOuterClass$TopPeerMetaData) {
        topPeerOuterClass$TopPeerMetaData.getClass();
        ensureTopPeersIsMutable();
        this.topPeers_.set(i, topPeerOuterClass$TopPeerMetaData);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (l2.a[gVar.ordinal()]) {
            case 1:
                return new TopPeerOuterClass$ResponseGetTopPeer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"topPeers_", TopPeerOuterClass$TopPeerMetaData.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TopPeerOuterClass$ResponseGetTopPeer.class) {
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

    public TopPeerOuterClass$TopPeerMetaData getTopPeers(int i) {
        return (TopPeerOuterClass$TopPeerMetaData) this.topPeers_.get(i);
    }

    public int getTopPeersCount() {
        return this.topPeers_.size();
    }

    public List<TopPeerOuterClass$TopPeerMetaData> getTopPeersList() {
        return this.topPeers_;
    }

    public InterfaceC7677Ss7 getTopPeersOrBuilder(int i) {
        return (InterfaceC7677Ss7) this.topPeers_.get(i);
    }

    public List<? extends InterfaceC7677Ss7> getTopPeersOrBuilderList() {
        return this.topPeers_;
    }

    public static a newBuilder(TopPeerOuterClass$ResponseGetTopPeer topPeerOuterClass$ResponseGetTopPeer) {
        return (a) DEFAULT_INSTANCE.createBuilder(topPeerOuterClass$ResponseGetTopPeer);
    }

    public static TopPeerOuterClass$ResponseGetTopPeer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TopPeerOuterClass$ResponseGetTopPeer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TopPeerOuterClass$ResponseGetTopPeer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TopPeerOuterClass$ResponseGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TopPeerOuterClass$ResponseGetTopPeer parseFrom(AbstractC2383g abstractC2383g) {
        return (TopPeerOuterClass$ResponseGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addTopPeers(int i, TopPeerOuterClass$TopPeerMetaData topPeerOuterClass$TopPeerMetaData) {
        topPeerOuterClass$TopPeerMetaData.getClass();
        ensureTopPeersIsMutable();
        this.topPeers_.add(i, topPeerOuterClass$TopPeerMetaData);
    }

    public static TopPeerOuterClass$ResponseGetTopPeer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TopPeerOuterClass$ResponseGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TopPeerOuterClass$ResponseGetTopPeer parseFrom(byte[] bArr) {
        return (TopPeerOuterClass$ResponseGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TopPeerOuterClass$ResponseGetTopPeer parseFrom(byte[] bArr, C2394s c2394s) {
        return (TopPeerOuterClass$ResponseGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TopPeerOuterClass$ResponseGetTopPeer parseFrom(InputStream inputStream) {
        return (TopPeerOuterClass$ResponseGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TopPeerOuterClass$ResponseGetTopPeer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TopPeerOuterClass$ResponseGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TopPeerOuterClass$ResponseGetTopPeer parseFrom(AbstractC2384h abstractC2384h) {
        return (TopPeerOuterClass$ResponseGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TopPeerOuterClass$ResponseGetTopPeer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TopPeerOuterClass$ResponseGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

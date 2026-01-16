package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC18084o35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class UsersOuterClass$RequestLoadUsers extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$RequestLoadUsers DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEERS_FIELD_NUMBER = 1;
    private B.j peers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$RequestLoadUsers.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$RequestLoadUsers usersOuterClass$RequestLoadUsers = new UsersOuterClass$RequestLoadUsers();
        DEFAULT_INSTANCE = usersOuterClass$RequestLoadUsers;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$RequestLoadUsers.class, usersOuterClass$RequestLoadUsers);
    }

    private UsersOuterClass$RequestLoadUsers() {
    }

    private void addAllPeers(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensurePeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.peers_);
    }

    private void addPeers(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.add(peersStruct$UserOutPeer);
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

    public static UsersOuterClass$RequestLoadUsers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$RequestLoadUsers parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestLoadUsers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestLoadUsers parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$RequestLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePeers(int i) {
        ensurePeersIsMutable();
        this.peers_.remove(i);
    }

    private void setPeers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.set(i, peersStruct$UserOutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$RequestLoadUsers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"peers_", PeersStruct$UserOutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$RequestLoadUsers.class) {
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

    public PeersStruct$UserOutPeer getPeers(int i) {
        return (PeersStruct$UserOutPeer) this.peers_.get(i);
    }

    public int getPeersCount() {
        return this.peers_.size();
    }

    public List<PeersStruct$UserOutPeer> getPeersList() {
        return this.peers_;
    }

    public InterfaceC18084o35 getPeersOrBuilder(int i) {
        return (InterfaceC18084o35) this.peers_.get(i);
    }

    public List<? extends InterfaceC18084o35> getPeersOrBuilderList() {
        return this.peers_;
    }

    public static a newBuilder(UsersOuterClass$RequestLoadUsers usersOuterClass$RequestLoadUsers) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$RequestLoadUsers);
    }

    public static UsersOuterClass$RequestLoadUsers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestLoadUsers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestLoadUsers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$RequestLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$RequestLoadUsers parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$RequestLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPeers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.add(i, peersStruct$UserOutPeer);
    }

    public static UsersOuterClass$RequestLoadUsers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$RequestLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$RequestLoadUsers parseFrom(byte[] bArr) {
        return (UsersOuterClass$RequestLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$RequestLoadUsers parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$RequestLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$RequestLoadUsers parseFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestLoadUsers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestLoadUsers parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$RequestLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$RequestLoadUsers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$RequestLoadUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

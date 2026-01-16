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

/* loaded from: classes9.dex */
public final class OrganizationsOuterClass$ResponseGetUserOrganizationalContacts extends GeneratedMessageLite implements U64 {
    private static final OrganizationsOuterClass$ResponseGetUserOrganizationalContacts DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_PEERS_FIELD_NUMBER = 1;
    private B.j userPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(OrganizationsOuterClass$ResponseGetUserOrganizationalContacts.DEFAULT_INSTANCE);
        }
    }

    static {
        OrganizationsOuterClass$ResponseGetUserOrganizationalContacts organizationsOuterClass$ResponseGetUserOrganizationalContacts = new OrganizationsOuterClass$ResponseGetUserOrganizationalContacts();
        DEFAULT_INSTANCE = organizationsOuterClass$ResponseGetUserOrganizationalContacts;
        GeneratedMessageLite.registerDefaultInstance(OrganizationsOuterClass$ResponseGetUserOrganizationalContacts.class, organizationsOuterClass$ResponseGetUserOrganizationalContacts);
    }

    private OrganizationsOuterClass$ResponseGetUserOrganizationalContacts() {
    }

    private void addAllUserPeers(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureUserPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userPeers_);
    }

    private void addUserPeers(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUserPeersIsMutable();
        this.userPeers_.add(peersStruct$UserOutPeer);
    }

    private void clearUserPeers() {
        this.userPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUserPeersIsMutable() {
        B.j jVar = this.userPeers_;
        if (jVar.u()) {
            return;
        }
        this.userPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationalContacts getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationalContacts parseDelimitedFrom(InputStream inputStream) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationalContacts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationalContacts parseFrom(ByteBuffer byteBuffer) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationalContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUserPeers(int i) {
        ensureUserPeersIsMutable();
        this.userPeers_.remove(i);
    }

    private void setUserPeers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUserPeersIsMutable();
        this.userPeers_.set(i, peersStruct$UserOutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (W0.a[gVar.ordinal()]) {
            case 1:
                return new OrganizationsOuterClass$ResponseGetUserOrganizationalContacts();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"userPeers_", PeersStruct$UserOutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OrganizationsOuterClass$ResponseGetUserOrganizationalContacts.class) {
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

    public PeersStruct$UserOutPeer getUserPeers(int i) {
        return (PeersStruct$UserOutPeer) this.userPeers_.get(i);
    }

    public int getUserPeersCount() {
        return this.userPeers_.size();
    }

    public List<PeersStruct$UserOutPeer> getUserPeersList() {
        return this.userPeers_;
    }

    public InterfaceC18084o35 getUserPeersOrBuilder(int i) {
        return (InterfaceC18084o35) this.userPeers_.get(i);
    }

    public List<? extends InterfaceC18084o35> getUserPeersOrBuilderList() {
        return this.userPeers_;
    }

    public static a newBuilder(OrganizationsOuterClass$ResponseGetUserOrganizationalContacts organizationsOuterClass$ResponseGetUserOrganizationalContacts) {
        return (a) DEFAULT_INSTANCE.createBuilder(organizationsOuterClass$ResponseGetUserOrganizationalContacts);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationalContacts parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationalContacts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationalContacts parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationalContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationalContacts parseFrom(AbstractC2383g abstractC2383g) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationalContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUserPeers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUserPeersIsMutable();
        this.userPeers_.add(i, peersStruct$UserOutPeer);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationalContacts parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationalContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationalContacts parseFrom(byte[] bArr) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationalContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationalContacts parseFrom(byte[] bArr, C2394s c2394s) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationalContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationalContacts parseFrom(InputStream inputStream) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationalContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationalContacts parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationalContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationalContacts parseFrom(AbstractC2384h abstractC2384h) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationalContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationalContacts parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationalContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

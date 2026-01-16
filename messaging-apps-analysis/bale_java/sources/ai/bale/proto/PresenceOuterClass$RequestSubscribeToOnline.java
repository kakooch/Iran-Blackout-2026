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
public final class PresenceOuterClass$RequestSubscribeToOnline extends GeneratedMessageLite implements U64 {
    private static final PresenceOuterClass$RequestSubscribeToOnline DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USERS_FIELD_NUMBER = 1;
    private B.j users_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((PresenceOuterClass$RequestSubscribeToOnline) this.b).addAllUsers(iterable);
            return this;
        }

        public a B(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
            q();
            ((PresenceOuterClass$RequestSubscribeToOnline) this.b).addUsers(peersStruct$UserOutPeer);
            return this;
        }

        private a() {
            super(PresenceOuterClass$RequestSubscribeToOnline.DEFAULT_INSTANCE);
        }
    }

    static {
        PresenceOuterClass$RequestSubscribeToOnline presenceOuterClass$RequestSubscribeToOnline = new PresenceOuterClass$RequestSubscribeToOnline();
        DEFAULT_INSTANCE = presenceOuterClass$RequestSubscribeToOnline;
        GeneratedMessageLite.registerDefaultInstance(PresenceOuterClass$RequestSubscribeToOnline.class, presenceOuterClass$RequestSubscribeToOnline);
    }

    private PresenceOuterClass$RequestSubscribeToOnline() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllUsers(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.users_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addUsers(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersIsMutable();
        this.users_.add(peersStruct$UserOutPeer);
    }

    private void clearUsers() {
        this.users_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUsersIsMutable() {
        B.j jVar = this.users_;
        if (jVar.u()) {
            return;
        }
        this.users_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PresenceOuterClass$RequestSubscribeToOnline getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PresenceOuterClass$RequestSubscribeToOnline parseDelimitedFrom(InputStream inputStream) {
        return (PresenceOuterClass$RequestSubscribeToOnline) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$RequestSubscribeToOnline parseFrom(ByteBuffer byteBuffer) {
        return (PresenceOuterClass$RequestSubscribeToOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUsers(int i) {
        ensureUsersIsMutable();
        this.users_.remove(i);
    }

    private void setUsers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersIsMutable();
        this.users_.set(i, peersStruct$UserOutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1866j1.a[gVar.ordinal()]) {
            case 1:
                return new PresenceOuterClass$RequestSubscribeToOnline();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"users_", PeersStruct$UserOutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PresenceOuterClass$RequestSubscribeToOnline.class) {
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

    public PeersStruct$UserOutPeer getUsers(int i) {
        return (PeersStruct$UserOutPeer) this.users_.get(i);
    }

    public int getUsersCount() {
        return this.users_.size();
    }

    public List<PeersStruct$UserOutPeer> getUsersList() {
        return this.users_;
    }

    public InterfaceC18084o35 getUsersOrBuilder(int i) {
        return (InterfaceC18084o35) this.users_.get(i);
    }

    public List<? extends InterfaceC18084o35> getUsersOrBuilderList() {
        return this.users_;
    }

    public static a newBuilder(PresenceOuterClass$RequestSubscribeToOnline presenceOuterClass$RequestSubscribeToOnline) {
        return (a) DEFAULT_INSTANCE.createBuilder(presenceOuterClass$RequestSubscribeToOnline);
    }

    public static PresenceOuterClass$RequestSubscribeToOnline parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$RequestSubscribeToOnline) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$RequestSubscribeToOnline parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PresenceOuterClass$RequestSubscribeToOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PresenceOuterClass$RequestSubscribeToOnline parseFrom(AbstractC2383g abstractC2383g) {
        return (PresenceOuterClass$RequestSubscribeToOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUsers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersIsMutable();
        this.users_.add(i, peersStruct$UserOutPeer);
    }

    public static PresenceOuterClass$RequestSubscribeToOnline parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PresenceOuterClass$RequestSubscribeToOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PresenceOuterClass$RequestSubscribeToOnline parseFrom(byte[] bArr) {
        return (PresenceOuterClass$RequestSubscribeToOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PresenceOuterClass$RequestSubscribeToOnline parseFrom(byte[] bArr, C2394s c2394s) {
        return (PresenceOuterClass$RequestSubscribeToOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PresenceOuterClass$RequestSubscribeToOnline parseFrom(InputStream inputStream) {
        return (PresenceOuterClass$RequestSubscribeToOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$RequestSubscribeToOnline parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$RequestSubscribeToOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$RequestSubscribeToOnline parseFrom(AbstractC2384h abstractC2384h) {
        return (PresenceOuterClass$RequestSubscribeToOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PresenceOuterClass$RequestSubscribeToOnline parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PresenceOuterClass$RequestSubscribeToOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

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
public final class PresenceOuterClass$RequestSubscribeFromGroupOnline extends GeneratedMessageLite implements U64 {
    private static final PresenceOuterClass$RequestSubscribeFromGroupOnline DEFAULT_INSTANCE;
    public static final int GROUPS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j groups_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PresenceOuterClass$RequestSubscribeFromGroupOnline.DEFAULT_INSTANCE);
        }
    }

    static {
        PresenceOuterClass$RequestSubscribeFromGroupOnline presenceOuterClass$RequestSubscribeFromGroupOnline = new PresenceOuterClass$RequestSubscribeFromGroupOnline();
        DEFAULT_INSTANCE = presenceOuterClass$RequestSubscribeFromGroupOnline;
        GeneratedMessageLite.registerDefaultInstance(PresenceOuterClass$RequestSubscribeFromGroupOnline.class, presenceOuterClass$RequestSubscribeFromGroupOnline);
    }

    private PresenceOuterClass$RequestSubscribeFromGroupOnline() {
    }

    private void addAllGroups(Iterable<? extends PeersStruct$GroupOutPeer> iterable) {
        ensureGroupsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groups_);
    }

    private void addGroups(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(peersStruct$GroupOutPeer);
    }

    private void clearGroups() {
        this.groups_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureGroupsIsMutable() {
        B.j jVar = this.groups_;
        if (jVar.u()) {
            return;
        }
        this.groups_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PresenceOuterClass$RequestSubscribeFromGroupOnline getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PresenceOuterClass$RequestSubscribeFromGroupOnline parseDelimitedFrom(InputStream inputStream) {
        return (PresenceOuterClass$RequestSubscribeFromGroupOnline) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$RequestSubscribeFromGroupOnline parseFrom(ByteBuffer byteBuffer) {
        return (PresenceOuterClass$RequestSubscribeFromGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeGroups(int i) {
        ensureGroupsIsMutable();
        this.groups_.remove(i);
    }

    private void setGroups(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupsIsMutable();
        this.groups_.set(i, peersStruct$GroupOutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1866j1.a[gVar.ordinal()]) {
            case 1:
                return new PresenceOuterClass$RequestSubscribeFromGroupOnline();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"groups_", PeersStruct$GroupOutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PresenceOuterClass$RequestSubscribeFromGroupOnline.class) {
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

    public PeersStruct$GroupOutPeer getGroups(int i) {
        return (PeersStruct$GroupOutPeer) this.groups_.get(i);
    }

    public int getGroupsCount() {
        return this.groups_.size();
    }

    public List<PeersStruct$GroupOutPeer> getGroupsList() {
        return this.groups_;
    }

    public InterfaceC11468d35 getGroupsOrBuilder(int i) {
        return (InterfaceC11468d35) this.groups_.get(i);
    }

    public List<? extends InterfaceC11468d35> getGroupsOrBuilderList() {
        return this.groups_;
    }

    public static a newBuilder(PresenceOuterClass$RequestSubscribeFromGroupOnline presenceOuterClass$RequestSubscribeFromGroupOnline) {
        return (a) DEFAULT_INSTANCE.createBuilder(presenceOuterClass$RequestSubscribeFromGroupOnline);
    }

    public static PresenceOuterClass$RequestSubscribeFromGroupOnline parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$RequestSubscribeFromGroupOnline) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$RequestSubscribeFromGroupOnline parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PresenceOuterClass$RequestSubscribeFromGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PresenceOuterClass$RequestSubscribeFromGroupOnline parseFrom(AbstractC2383g abstractC2383g) {
        return (PresenceOuterClass$RequestSubscribeFromGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addGroups(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(i, peersStruct$GroupOutPeer);
    }

    public static PresenceOuterClass$RequestSubscribeFromGroupOnline parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PresenceOuterClass$RequestSubscribeFromGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PresenceOuterClass$RequestSubscribeFromGroupOnline parseFrom(byte[] bArr) {
        return (PresenceOuterClass$RequestSubscribeFromGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PresenceOuterClass$RequestSubscribeFromGroupOnline parseFrom(byte[] bArr, C2394s c2394s) {
        return (PresenceOuterClass$RequestSubscribeFromGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PresenceOuterClass$RequestSubscribeFromGroupOnline parseFrom(InputStream inputStream) {
        return (PresenceOuterClass$RequestSubscribeFromGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$RequestSubscribeFromGroupOnline parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$RequestSubscribeFromGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$RequestSubscribeFromGroupOnline parseFrom(AbstractC2384h abstractC2384h) {
        return (PresenceOuterClass$RequestSubscribeFromGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PresenceOuterClass$RequestSubscribeFromGroupOnline parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PresenceOuterClass$RequestSubscribeFromGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

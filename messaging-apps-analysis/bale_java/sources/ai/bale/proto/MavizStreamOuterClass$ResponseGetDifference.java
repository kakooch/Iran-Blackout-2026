package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.r0;
import ir.nasim.InterfaceC11468d35;
import ir.nasim.InterfaceC18084o35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes9.dex */
public final class MavizStreamOuterClass$ResponseGetDifference extends GeneratedMessageLite implements U64 {
    private static final MavizStreamOuterClass$ResponseGetDifference DEFAULT_INSTANCE;
    public static final int GROUPS_REFS_FIELD_NUMBER = 3;
    public static final int GROUP_EVENTS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int USERS_REFS_FIELD_NUMBER = 2;
    private com.google.protobuf.J groupEvents_ = com.google.protobuf.J.e();
    private B.j usersRefs_ = GeneratedMessageLite.emptyProtobufList();
    private B.j groupsRefs_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MavizStreamOuterClass$ResponseGetDifference.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final com.google.protobuf.I a = com.google.protobuf.I.d(r0.b.g, 0, r0.b.m, MavizStreamOuterClass$GroupEvents.getDefaultInstance());
    }

    static {
        MavizStreamOuterClass$ResponseGetDifference mavizStreamOuterClass$ResponseGetDifference = new MavizStreamOuterClass$ResponseGetDifference();
        DEFAULT_INSTANCE = mavizStreamOuterClass$ResponseGetDifference;
        GeneratedMessageLite.registerDefaultInstance(MavizStreamOuterClass$ResponseGetDifference.class, mavizStreamOuterClass$ResponseGetDifference);
    }

    private MavizStreamOuterClass$ResponseGetDifference() {
    }

    private void addAllGroupsRefs(Iterable<? extends PeersStruct$GroupOutPeer> iterable) {
        ensureGroupsRefsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groupsRefs_);
    }

    private void addAllUsersRefs(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureUsersRefsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.usersRefs_);
    }

    private void addGroupsRefs(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupsRefsIsMutable();
        this.groupsRefs_.add(peersStruct$GroupOutPeer);
    }

    private void addUsersRefs(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersRefsIsMutable();
        this.usersRefs_.add(peersStruct$UserOutPeer);
    }

    private void clearGroupsRefs() {
        this.groupsRefs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUsersRefs() {
        this.usersRefs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureGroupsRefsIsMutable() {
        B.j jVar = this.groupsRefs_;
        if (jVar.u()) {
            return;
        }
        this.groupsRefs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUsersRefsIsMutable() {
        B.j jVar = this.usersRefs_;
        if (jVar.u()) {
            return;
        }
        this.usersRefs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MavizStreamOuterClass$ResponseGetDifference getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map<Integer, MavizStreamOuterClass$GroupEvents> getMutableGroupEventsMap() {
        return internalGetMutableGroupEvents();
    }

    private com.google.protobuf.J internalGetGroupEvents() {
        return this.groupEvents_;
    }

    private com.google.protobuf.J internalGetMutableGroupEvents() {
        if (!this.groupEvents_.n()) {
            this.groupEvents_ = this.groupEvents_.s();
        }
        return this.groupEvents_;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MavizStreamOuterClass$ResponseGetDifference parseDelimitedFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$ResponseGetDifference) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$ResponseGetDifference parseFrom(ByteBuffer byteBuffer) {
        return (MavizStreamOuterClass$ResponseGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeGroupsRefs(int i) {
        ensureGroupsRefsIsMutable();
        this.groupsRefs_.remove(i);
    }

    private void removeUsersRefs(int i) {
        ensureUsersRefsIsMutable();
        this.usersRefs_.remove(i);
    }

    private void setGroupsRefs(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupsRefsIsMutable();
        this.groupsRefs_.set(i, peersStruct$GroupOutPeer);
    }

    private void setUsersRefs(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersRefsIsMutable();
        this.usersRefs_.set(i, peersStruct$UserOutPeer);
    }

    public boolean containsGroupEvents(int i) {
        return internalGetGroupEvents().containsKey(Integer.valueOf(i));
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (E0.a[gVar.ordinal()]) {
            case 1:
                return new MavizStreamOuterClass$ResponseGetDifference();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0001\u0002\u0000\u00012\u0002\u001b\u0003\u001b", new Object[]{"groupEvents_", b.a, "usersRefs_", PeersStruct$UserOutPeer.class, "groupsRefs_", PeersStruct$GroupOutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MavizStreamOuterClass$ResponseGetDifference.class) {
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

    @Deprecated
    public Map<Integer, MavizStreamOuterClass$GroupEvents> getGroupEvents() {
        return getGroupEventsMap();
    }

    public int getGroupEventsCount() {
        return internalGetGroupEvents().size();
    }

    public Map<Integer, MavizStreamOuterClass$GroupEvents> getGroupEventsMap() {
        return Collections.unmodifiableMap(internalGetGroupEvents());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MavizStreamOuterClass$GroupEvents getGroupEventsOrDefault(int i, MavizStreamOuterClass$GroupEvents mavizStreamOuterClass$GroupEvents) {
        com.google.protobuf.J jInternalGetGroupEvents = internalGetGroupEvents();
        return jInternalGetGroupEvents.containsKey(Integer.valueOf(i)) ? (MavizStreamOuterClass$GroupEvents) jInternalGetGroupEvents.get(Integer.valueOf(i)) : mavizStreamOuterClass$GroupEvents;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MavizStreamOuterClass$GroupEvents getGroupEventsOrThrow(int i) {
        com.google.protobuf.J jInternalGetGroupEvents = internalGetGroupEvents();
        if (jInternalGetGroupEvents.containsKey(Integer.valueOf(i))) {
            return (MavizStreamOuterClass$GroupEvents) jInternalGetGroupEvents.get(Integer.valueOf(i));
        }
        throw new IllegalArgumentException();
    }

    public PeersStruct$GroupOutPeer getGroupsRefs(int i) {
        return (PeersStruct$GroupOutPeer) this.groupsRefs_.get(i);
    }

    public int getGroupsRefsCount() {
        return this.groupsRefs_.size();
    }

    public List<PeersStruct$GroupOutPeer> getGroupsRefsList() {
        return this.groupsRefs_;
    }

    public InterfaceC11468d35 getGroupsRefsOrBuilder(int i) {
        return (InterfaceC11468d35) this.groupsRefs_.get(i);
    }

    public List<? extends InterfaceC11468d35> getGroupsRefsOrBuilderList() {
        return this.groupsRefs_;
    }

    public PeersStruct$UserOutPeer getUsersRefs(int i) {
        return (PeersStruct$UserOutPeer) this.usersRefs_.get(i);
    }

    public int getUsersRefsCount() {
        return this.usersRefs_.size();
    }

    public List<PeersStruct$UserOutPeer> getUsersRefsList() {
        return this.usersRefs_;
    }

    public InterfaceC18084o35 getUsersRefsOrBuilder(int i) {
        return (InterfaceC18084o35) this.usersRefs_.get(i);
    }

    public List<? extends InterfaceC18084o35> getUsersRefsOrBuilderList() {
        return this.usersRefs_;
    }

    public static a newBuilder(MavizStreamOuterClass$ResponseGetDifference mavizStreamOuterClass$ResponseGetDifference) {
        return (a) DEFAULT_INSTANCE.createBuilder(mavizStreamOuterClass$ResponseGetDifference);
    }

    public static MavizStreamOuterClass$ResponseGetDifference parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$ResponseGetDifference) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$ResponseGetDifference parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MavizStreamOuterClass$ResponseGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MavizStreamOuterClass$ResponseGetDifference parseFrom(AbstractC2383g abstractC2383g) {
        return (MavizStreamOuterClass$ResponseGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addGroupsRefs(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupsRefsIsMutable();
        this.groupsRefs_.add(i, peersStruct$GroupOutPeer);
    }

    private void addUsersRefs(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersRefsIsMutable();
        this.usersRefs_.add(i, peersStruct$UserOutPeer);
    }

    public static MavizStreamOuterClass$ResponseGetDifference parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MavizStreamOuterClass$ResponseGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MavizStreamOuterClass$ResponseGetDifference parseFrom(byte[] bArr) {
        return (MavizStreamOuterClass$ResponseGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MavizStreamOuterClass$ResponseGetDifference parseFrom(byte[] bArr, C2394s c2394s) {
        return (MavizStreamOuterClass$ResponseGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MavizStreamOuterClass$ResponseGetDifference parseFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$ResponseGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$ResponseGetDifference parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$ResponseGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$ResponseGetDifference parseFrom(AbstractC2384h abstractC2384h) {
        return (MavizStreamOuterClass$ResponseGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MavizStreamOuterClass$ResponseGetDifference parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MavizStreamOuterClass$ResponseGetDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

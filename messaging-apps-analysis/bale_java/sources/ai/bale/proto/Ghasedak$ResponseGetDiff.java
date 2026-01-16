package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11468d35;
import ir.nasim.InterfaceC18084o35;
import ir.nasim.JG2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Ghasedak$ResponseGetDiff extends GeneratedMessageLite implements U64 {
    private static final Ghasedak$ResponseGetDiff DEFAULT_INSTANCE;
    public static final int GROUPS_REFS_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int UPDATES_FIELD_NUMBER = 1;
    public static final int USERS_REFS_FIELD_NUMBER = 2;
    private B.j updates_ = GeneratedMessageLite.emptyProtobufList();
    private B.j usersRefs_ = GeneratedMessageLite.emptyProtobufList();
    private B.j groupsRefs_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Ghasedak$ResponseGetDiff.DEFAULT_INSTANCE);
        }
    }

    static {
        Ghasedak$ResponseGetDiff ghasedak$ResponseGetDiff = new Ghasedak$ResponseGetDiff();
        DEFAULT_INSTANCE = ghasedak$ResponseGetDiff;
        GeneratedMessageLite.registerDefaultInstance(Ghasedak$ResponseGetDiff.class, ghasedak$ResponseGetDiff);
    }

    private Ghasedak$ResponseGetDiff() {
    }

    private void addAllGroupsRefs(Iterable<? extends PeersStruct$GroupOutPeer> iterable) {
        ensureGroupsRefsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groupsRefs_);
    }

    private void addAllUpdates(Iterable<? extends Ghasedak$GroupUpdates> iterable) {
        ensureUpdatesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.updates_);
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

    private void addUpdates(Ghasedak$GroupUpdates ghasedak$GroupUpdates) {
        ghasedak$GroupUpdates.getClass();
        ensureUpdatesIsMutable();
        this.updates_.add(ghasedak$GroupUpdates);
    }

    private void addUsersRefs(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersRefsIsMutable();
        this.usersRefs_.add(peersStruct$UserOutPeer);
    }

    private void clearGroupsRefs() {
        this.groupsRefs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUpdates() {
        this.updates_ = GeneratedMessageLite.emptyProtobufList();
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

    private void ensureUpdatesIsMutable() {
        B.j jVar = this.updates_;
        if (jVar.u()) {
            return;
        }
        this.updates_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUsersRefsIsMutable() {
        B.j jVar = this.usersRefs_;
        if (jVar.u()) {
            return;
        }
        this.usersRefs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Ghasedak$ResponseGetDiff getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Ghasedak$ResponseGetDiff parseDelimitedFrom(InputStream inputStream) {
        return (Ghasedak$ResponseGetDiff) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ghasedak$ResponseGetDiff parseFrom(ByteBuffer byteBuffer) {
        return (Ghasedak$ResponseGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeGroupsRefs(int i) {
        ensureGroupsRefsIsMutable();
        this.groupsRefs_.remove(i);
    }

    private void removeUpdates(int i) {
        ensureUpdatesIsMutable();
        this.updates_.remove(i);
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

    private void setUpdates(int i, Ghasedak$GroupUpdates ghasedak$GroupUpdates) {
        ghasedak$GroupUpdates.getClass();
        ensureUpdatesIsMutable();
        this.updates_.set(i, ghasedak$GroupUpdates);
    }

    private void setUsersRefs(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersRefsIsMutable();
        this.usersRefs_.set(i, peersStruct$UserOutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1862i0.a[gVar.ordinal()]) {
            case 1:
                return new Ghasedak$ResponseGetDiff();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0003\u0000\u0001\u001b\u0002\u001b\u0003\u001b", new Object[]{"updates_", Ghasedak$GroupUpdates.class, "usersRefs_", PeersStruct$UserOutPeer.class, "groupsRefs_", PeersStruct$GroupOutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Ghasedak$ResponseGetDiff.class) {
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

    public Ghasedak$GroupUpdates getUpdates(int i) {
        return (Ghasedak$GroupUpdates) this.updates_.get(i);
    }

    public int getUpdatesCount() {
        return this.updates_.size();
    }

    public List<Ghasedak$GroupUpdates> getUpdatesList() {
        return this.updates_;
    }

    public JG2 getUpdatesOrBuilder(int i) {
        return (JG2) this.updates_.get(i);
    }

    public List<? extends JG2> getUpdatesOrBuilderList() {
        return this.updates_;
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

    public static a newBuilder(Ghasedak$ResponseGetDiff ghasedak$ResponseGetDiff) {
        return (a) DEFAULT_INSTANCE.createBuilder(ghasedak$ResponseGetDiff);
    }

    public static Ghasedak$ResponseGetDiff parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Ghasedak$ResponseGetDiff) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ghasedak$ResponseGetDiff parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Ghasedak$ResponseGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Ghasedak$ResponseGetDiff parseFrom(AbstractC2383g abstractC2383g) {
        return (Ghasedak$ResponseGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addGroupsRefs(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupsRefsIsMutable();
        this.groupsRefs_.add(i, peersStruct$GroupOutPeer);
    }

    private void addUpdates(int i, Ghasedak$GroupUpdates ghasedak$GroupUpdates) {
        ghasedak$GroupUpdates.getClass();
        ensureUpdatesIsMutable();
        this.updates_.add(i, ghasedak$GroupUpdates);
    }

    private void addUsersRefs(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersRefsIsMutable();
        this.usersRefs_.add(i, peersStruct$UserOutPeer);
    }

    public static Ghasedak$ResponseGetDiff parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Ghasedak$ResponseGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Ghasedak$ResponseGetDiff parseFrom(byte[] bArr) {
        return (Ghasedak$ResponseGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Ghasedak$ResponseGetDiff parseFrom(byte[] bArr, C2394s c2394s) {
        return (Ghasedak$ResponseGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Ghasedak$ResponseGetDiff parseFrom(InputStream inputStream) {
        return (Ghasedak$ResponseGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ghasedak$ResponseGetDiff parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Ghasedak$ResponseGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ghasedak$ResponseGetDiff parseFrom(AbstractC2384h abstractC2384h) {
        return (Ghasedak$ResponseGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Ghasedak$ResponseGetDiff parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Ghasedak$ResponseGetDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

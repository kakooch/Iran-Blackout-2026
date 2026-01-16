package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC23158wS2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$ResponseLoadFullGroups extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$ResponseLoadFullGroups DEFAULT_INSTANCE;
    public static final int GROUPS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j groups_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$ResponseLoadFullGroups.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$ResponseLoadFullGroups groupsOuterClass$ResponseLoadFullGroups = new GroupsOuterClass$ResponseLoadFullGroups();
        DEFAULT_INSTANCE = groupsOuterClass$ResponseLoadFullGroups;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$ResponseLoadFullGroups.class, groupsOuterClass$ResponseLoadFullGroups);
    }

    private GroupsOuterClass$ResponseLoadFullGroups() {
    }

    private void addAllGroups(Iterable<? extends GroupsStruct$GroupFull> iterable) {
        ensureGroupsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groups_);
    }

    private void addGroups(GroupsStruct$GroupFull groupsStruct$GroupFull) {
        groupsStruct$GroupFull.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(groupsStruct$GroupFull);
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

    public static GroupsOuterClass$ResponseLoadFullGroups getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$ResponseLoadFullGroups parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseLoadFullGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseLoadFullGroups parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$ResponseLoadFullGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeGroups(int i) {
        ensureGroupsIsMutable();
        this.groups_.remove(i);
    }

    private void setGroups(int i, GroupsStruct$GroupFull groupsStruct$GroupFull) {
        groupsStruct$GroupFull.getClass();
        ensureGroupsIsMutable();
        this.groups_.set(i, groupsStruct$GroupFull);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$ResponseLoadFullGroups();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"groups_", GroupsStruct$GroupFull.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$ResponseLoadFullGroups.class) {
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

    public GroupsStruct$GroupFull getGroups(int i) {
        return (GroupsStruct$GroupFull) this.groups_.get(i);
    }

    public int getGroupsCount() {
        return this.groups_.size();
    }

    public List<GroupsStruct$GroupFull> getGroupsList() {
        return this.groups_;
    }

    public InterfaceC23158wS2 getGroupsOrBuilder(int i) {
        return (InterfaceC23158wS2) this.groups_.get(i);
    }

    public List<? extends InterfaceC23158wS2> getGroupsOrBuilderList() {
        return this.groups_;
    }

    public static a newBuilder(GroupsOuterClass$ResponseLoadFullGroups groupsOuterClass$ResponseLoadFullGroups) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$ResponseLoadFullGroups);
    }

    public static GroupsOuterClass$ResponseLoadFullGroups parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseLoadFullGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseLoadFullGroups parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$ResponseLoadFullGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$ResponseLoadFullGroups parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$ResponseLoadFullGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addGroups(int i, GroupsStruct$GroupFull groupsStruct$GroupFull) {
        groupsStruct$GroupFull.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(i, groupsStruct$GroupFull);
    }

    public static GroupsOuterClass$ResponseLoadFullGroups parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$ResponseLoadFullGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$ResponseLoadFullGroups parseFrom(byte[] bArr) {
        return (GroupsOuterClass$ResponseLoadFullGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$ResponseLoadFullGroups parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$ResponseLoadFullGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$ResponseLoadFullGroups parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseLoadFullGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseLoadFullGroups parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseLoadFullGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseLoadFullGroups parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$ResponseLoadFullGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$ResponseLoadFullGroups parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$ResponseLoadFullGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

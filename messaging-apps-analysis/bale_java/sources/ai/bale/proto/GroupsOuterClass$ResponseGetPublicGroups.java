package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.FS2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$ResponseGetPublicGroups extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$ResponseGetPublicGroups DEFAULT_INSTANCE;
    public static final int GROUPS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j groups_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$ResponseGetPublicGroups.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$ResponseGetPublicGroups groupsOuterClass$ResponseGetPublicGroups = new GroupsOuterClass$ResponseGetPublicGroups();
        DEFAULT_INSTANCE = groupsOuterClass$ResponseGetPublicGroups;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$ResponseGetPublicGroups.class, groupsOuterClass$ResponseGetPublicGroups);
    }

    private GroupsOuterClass$ResponseGetPublicGroups() {
    }

    private void addAllGroups(Iterable<? extends GroupsStruct$PublicGroup> iterable) {
        ensureGroupsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groups_);
    }

    private void addGroups(GroupsStruct$PublicGroup groupsStruct$PublicGroup) {
        groupsStruct$PublicGroup.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(groupsStruct$PublicGroup);
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

    public static GroupsOuterClass$ResponseGetPublicGroups getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$ResponseGetPublicGroups parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseGetPublicGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseGetPublicGroups parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$ResponseGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeGroups(int i) {
        ensureGroupsIsMutable();
        this.groups_.remove(i);
    }

    private void setGroups(int i, GroupsStruct$PublicGroup groupsStruct$PublicGroup) {
        groupsStruct$PublicGroup.getClass();
        ensureGroupsIsMutable();
        this.groups_.set(i, groupsStruct$PublicGroup);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$ResponseGetPublicGroups();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"groups_", GroupsStruct$PublicGroup.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$ResponseGetPublicGroups.class) {
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

    public GroupsStruct$PublicGroup getGroups(int i) {
        return (GroupsStruct$PublicGroup) this.groups_.get(i);
    }

    public int getGroupsCount() {
        return this.groups_.size();
    }

    public List<GroupsStruct$PublicGroup> getGroupsList() {
        return this.groups_;
    }

    public FS2 getGroupsOrBuilder(int i) {
        return (FS2) this.groups_.get(i);
    }

    public List<? extends FS2> getGroupsOrBuilderList() {
        return this.groups_;
    }

    public static a newBuilder(GroupsOuterClass$ResponseGetPublicGroups groupsOuterClass$ResponseGetPublicGroups) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$ResponseGetPublicGroups);
    }

    public static GroupsOuterClass$ResponseGetPublicGroups parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetPublicGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseGetPublicGroups parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$ResponseGetPublicGroups parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$ResponseGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addGroups(int i, GroupsStruct$PublicGroup groupsStruct$PublicGroup) {
        groupsStruct$PublicGroup.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(i, groupsStruct$PublicGroup);
    }

    public static GroupsOuterClass$ResponseGetPublicGroups parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$ResponseGetPublicGroups parseFrom(byte[] bArr) {
        return (GroupsOuterClass$ResponseGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$ResponseGetPublicGroups parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$ResponseGetPublicGroups parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseGetPublicGroups parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseGetPublicGroups parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$ResponseGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$ResponseGetPublicGroups parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

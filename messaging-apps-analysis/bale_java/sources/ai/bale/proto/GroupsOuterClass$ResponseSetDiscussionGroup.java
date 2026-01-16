package ai.bale.proto;

import ai.bale.proto.GroupsStruct$Group;
import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$ResponseSetDiscussionGroup extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$ResponseSetDiscussionGroup DEFAULT_INSTANCE;
    public static final int DISCUSSION_GROUP_FIELD_NUMBER = 1;
    public static final int GROUP_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private PeersStruct$GroupOutPeer discussionGroup_;
    private GroupsStruct$Group group_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$ResponseSetDiscussionGroup.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$ResponseSetDiscussionGroup groupsOuterClass$ResponseSetDiscussionGroup = new GroupsOuterClass$ResponseSetDiscussionGroup();
        DEFAULT_INSTANCE = groupsOuterClass$ResponseSetDiscussionGroup;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$ResponseSetDiscussionGroup.class, groupsOuterClass$ResponseSetDiscussionGroup);
    }

    private GroupsOuterClass$ResponseSetDiscussionGroup() {
    }

    private void clearDiscussionGroup() {
        this.discussionGroup_ = null;
        this.bitField0_ &= -2;
    }

    private void clearGroup() {
        this.group_ = null;
        this.bitField0_ &= -3;
    }

    public static GroupsOuterClass$ResponseSetDiscussionGroup getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDiscussionGroup(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer2 = this.discussionGroup_;
        if (peersStruct$GroupOutPeer2 == null || peersStruct$GroupOutPeer2 == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.discussionGroup_ = peersStruct$GroupOutPeer;
        } else {
            this.discussionGroup_ = (PeersStruct$GroupOutPeer) ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder(this.discussionGroup_).v(peersStruct$GroupOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeGroup(GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        GroupsStruct$Group groupsStruct$Group2 = this.group_;
        if (groupsStruct$Group2 == null || groupsStruct$Group2 == GroupsStruct$Group.getDefaultInstance()) {
            this.group_ = groupsStruct$Group;
        } else {
            this.group_ = (GroupsStruct$Group) ((GroupsStruct$Group.a) GroupsStruct$Group.newBuilder(this.group_).v(groupsStruct$Group)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$ResponseSetDiscussionGroup parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseSetDiscussionGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseSetDiscussionGroup parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$ResponseSetDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDiscussionGroup(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.discussionGroup_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    private void setGroup(GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        this.group_ = groupsStruct$Group;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$ResponseSetDiscussionGroup();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "discussionGroup_", "group_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$ResponseSetDiscussionGroup.class) {
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

    public PeersStruct$GroupOutPeer getDiscussionGroup() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.discussionGroup_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public GroupsStruct$Group getGroup() {
        GroupsStruct$Group groupsStruct$Group = this.group_;
        return groupsStruct$Group == null ? GroupsStruct$Group.getDefaultInstance() : groupsStruct$Group;
    }

    public boolean hasDiscussionGroup() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasGroup() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(GroupsOuterClass$ResponseSetDiscussionGroup groupsOuterClass$ResponseSetDiscussionGroup) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$ResponseSetDiscussionGroup);
    }

    public static GroupsOuterClass$ResponseSetDiscussionGroup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseSetDiscussionGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseSetDiscussionGroup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$ResponseSetDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$ResponseSetDiscussionGroup parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$ResponseSetDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$ResponseSetDiscussionGroup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$ResponseSetDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$ResponseSetDiscussionGroup parseFrom(byte[] bArr) {
        return (GroupsOuterClass$ResponseSetDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$ResponseSetDiscussionGroup parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$ResponseSetDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$ResponseSetDiscussionGroup parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseSetDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseSetDiscussionGroup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseSetDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseSetDiscussionGroup parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$ResponseSetDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$ResponseSetDiscussionGroup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$ResponseSetDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

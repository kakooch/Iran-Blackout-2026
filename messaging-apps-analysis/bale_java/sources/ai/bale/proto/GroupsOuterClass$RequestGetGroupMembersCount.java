package ai.bale.proto;

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
public final class GroupsOuterClass$RequestGetGroupMembersCount extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$RequestGetGroupMembersCount DEFAULT_INSTANCE;
    public static final int GROUP_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private PeersStruct$GroupOutPeer group_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$RequestGetGroupMembersCount.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestGetGroupMembersCount groupsOuterClass$RequestGetGroupMembersCount = new GroupsOuterClass$RequestGetGroupMembersCount();
        DEFAULT_INSTANCE = groupsOuterClass$RequestGetGroupMembersCount;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestGetGroupMembersCount.class, groupsOuterClass$RequestGetGroupMembersCount);
    }

    private GroupsOuterClass$RequestGetGroupMembersCount() {
    }

    private void clearGroup() {
        this.group_ = null;
        this.bitField0_ &= -2;
    }

    public static GroupsOuterClass$RequestGetGroupMembersCount getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGroup(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer2 = this.group_;
        if (peersStruct$GroupOutPeer2 == null || peersStruct$GroupOutPeer2 == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.group_ = peersStruct$GroupOutPeer;
        } else {
            this.group_ = (PeersStruct$GroupOutPeer) ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder(this.group_).v(peersStruct$GroupOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestGetGroupMembersCount parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestGetGroupMembersCount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestGetGroupMembersCount parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestGetGroupMembersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroup(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.group_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestGetGroupMembersCount();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "group_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestGetGroupMembersCount.class) {
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

    public PeersStruct$GroupOutPeer getGroup() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.group_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public boolean hasGroup() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$RequestGetGroupMembersCount groupsOuterClass$RequestGetGroupMembersCount) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestGetGroupMembersCount);
    }

    public static GroupsOuterClass$RequestGetGroupMembersCount parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupMembersCount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupMembersCount parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupMembersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupMembersCount parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestGetGroupMembersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestGetGroupMembersCount parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupMembersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupMembersCount parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestGetGroupMembersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestGetGroupMembersCount parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupMembersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupMembersCount parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestGetGroupMembersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestGetGroupMembersCount parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupMembersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupMembersCount parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestGetGroupMembersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestGetGroupMembersCount parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupMembersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

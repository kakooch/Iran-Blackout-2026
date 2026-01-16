package ai.bale.proto;

import ai.bale.proto.GroupsStruct$LoadMembersCondition;
import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BytesValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$RequestLoadMembers extends GeneratedMessageLite implements U64 {
    public static final int CONDITION_FIELD_NUMBER = 4;
    private static final GroupsOuterClass$RequestLoadMembers DEFAULT_INSTANCE;
    public static final int GROUP_FIELD_NUMBER = 1;
    public static final int LIMIT_FIELD_NUMBER = 2;
    public static final int NEXT_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private GroupsStruct$LoadMembersCondition condition_;
    private PeersStruct$GroupOutPeer group_;
    private int limit_;
    private BytesValue next_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(GroupsStruct$LoadMembersCondition groupsStruct$LoadMembersCondition) {
            q();
            ((GroupsOuterClass$RequestLoadMembers) this.b).setCondition(groupsStruct$LoadMembersCondition);
            return this;
        }

        public a B(PeersStruct$GroupOutPeer.a aVar) {
            q();
            ((GroupsOuterClass$RequestLoadMembers) this.b).setGroup((PeersStruct$GroupOutPeer) aVar.a());
            return this;
        }

        public a C(int i) {
            q();
            ((GroupsOuterClass$RequestLoadMembers) this.b).setLimit(i);
            return this;
        }

        public a D(BytesValue bytesValue) {
            q();
            ((GroupsOuterClass$RequestLoadMembers) this.b).setNext(bytesValue);
            return this;
        }

        private a() {
            super(GroupsOuterClass$RequestLoadMembers.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestLoadMembers groupsOuterClass$RequestLoadMembers = new GroupsOuterClass$RequestLoadMembers();
        DEFAULT_INSTANCE = groupsOuterClass$RequestLoadMembers;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestLoadMembers.class, groupsOuterClass$RequestLoadMembers);
    }

    private GroupsOuterClass$RequestLoadMembers() {
    }

    private void clearCondition() {
        this.condition_ = null;
        this.bitField0_ &= -5;
    }

    private void clearGroup() {
        this.group_ = null;
        this.bitField0_ &= -2;
    }

    private void clearLimit() {
        this.limit_ = 0;
    }

    private void clearNext() {
        this.next_ = null;
        this.bitField0_ &= -3;
    }

    public static GroupsOuterClass$RequestLoadMembers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCondition(GroupsStruct$LoadMembersCondition groupsStruct$LoadMembersCondition) {
        groupsStruct$LoadMembersCondition.getClass();
        GroupsStruct$LoadMembersCondition groupsStruct$LoadMembersCondition2 = this.condition_;
        if (groupsStruct$LoadMembersCondition2 == null || groupsStruct$LoadMembersCondition2 == GroupsStruct$LoadMembersCondition.getDefaultInstance()) {
            this.condition_ = groupsStruct$LoadMembersCondition;
        } else {
            this.condition_ = (GroupsStruct$LoadMembersCondition) ((GroupsStruct$LoadMembersCondition.a) GroupsStruct$LoadMembersCondition.newBuilder(this.condition_).v(groupsStruct$LoadMembersCondition)).j();
        }
        this.bitField0_ |= 4;
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

    private void mergeNext(BytesValue bytesValue) {
        bytesValue.getClass();
        BytesValue bytesValue2 = this.next_;
        if (bytesValue2 == null || bytesValue2 == BytesValue.getDefaultInstance()) {
            this.next_ = bytesValue;
        } else {
            this.next_ = (BytesValue) ((BytesValue.b) BytesValue.newBuilder(this.next_).v(bytesValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestLoadMembers parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestLoadMembers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestLoadMembers parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestLoadMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCondition(GroupsStruct$LoadMembersCondition groupsStruct$LoadMembersCondition) {
        groupsStruct$LoadMembersCondition.getClass();
        this.condition_ = groupsStruct$LoadMembersCondition;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroup(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.group_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLimit(int i) {
        this.limit_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNext(BytesValue bytesValue) {
        bytesValue.getClass();
        this.next_ = bytesValue;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestLoadMembers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004\u0003ဉ\u0001\u0004ဉ\u0002", new Object[]{"bitField0_", "group_", "limit_", "next_", "condition_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestLoadMembers.class) {
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

    public GroupsStruct$LoadMembersCondition getCondition() {
        GroupsStruct$LoadMembersCondition groupsStruct$LoadMembersCondition = this.condition_;
        return groupsStruct$LoadMembersCondition == null ? GroupsStruct$LoadMembersCondition.getDefaultInstance() : groupsStruct$LoadMembersCondition;
    }

    public PeersStruct$GroupOutPeer getGroup() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.group_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public int getLimit() {
        return this.limit_;
    }

    public BytesValue getNext() {
        BytesValue bytesValue = this.next_;
        return bytesValue == null ? BytesValue.getDefaultInstance() : bytesValue;
    }

    public boolean hasCondition() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasGroup() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasNext() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(GroupsOuterClass$RequestLoadMembers groupsOuterClass$RequestLoadMembers) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestLoadMembers);
    }

    public static GroupsOuterClass$RequestLoadMembers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestLoadMembers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestLoadMembers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestLoadMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestLoadMembers parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestLoadMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestLoadMembers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestLoadMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestLoadMembers parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestLoadMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestLoadMembers parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestLoadMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestLoadMembers parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestLoadMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestLoadMembers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestLoadMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestLoadMembers parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestLoadMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestLoadMembers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestLoadMembers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

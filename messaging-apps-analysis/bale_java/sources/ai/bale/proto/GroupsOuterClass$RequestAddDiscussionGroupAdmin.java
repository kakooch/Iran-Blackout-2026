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
public final class GroupsOuterClass$RequestAddDiscussionGroupAdmin extends GeneratedMessageLite implements U64 {
    public static final int CHANNEL_FIELD_NUMBER = 1;
    private static final GroupsOuterClass$RequestAddDiscussionGroupAdmin DEFAULT_INSTANCE;
    public static final int DISCUSSION_GROUP_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private PeersStruct$GroupOutPeer channel_;
    private PeersStruct$GroupOutPeer discussionGroup_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((GroupsOuterClass$RequestAddDiscussionGroupAdmin) this.b).setChannel(peersStruct$GroupOutPeer);
            return this;
        }

        public a B(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((GroupsOuterClass$RequestAddDiscussionGroupAdmin) this.b).setDiscussionGroup(peersStruct$GroupOutPeer);
            return this;
        }

        private a() {
            super(GroupsOuterClass$RequestAddDiscussionGroupAdmin.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestAddDiscussionGroupAdmin groupsOuterClass$RequestAddDiscussionGroupAdmin = new GroupsOuterClass$RequestAddDiscussionGroupAdmin();
        DEFAULT_INSTANCE = groupsOuterClass$RequestAddDiscussionGroupAdmin;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestAddDiscussionGroupAdmin.class, groupsOuterClass$RequestAddDiscussionGroupAdmin);
    }

    private GroupsOuterClass$RequestAddDiscussionGroupAdmin() {
    }

    private void clearChannel() {
        this.channel_ = null;
        this.bitField0_ &= -2;
    }

    private void clearDiscussionGroup() {
        this.discussionGroup_ = null;
        this.bitField0_ &= -3;
    }

    public static GroupsOuterClass$RequestAddDiscussionGroupAdmin getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeChannel(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer2 = this.channel_;
        if (peersStruct$GroupOutPeer2 == null || peersStruct$GroupOutPeer2 == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.channel_ = peersStruct$GroupOutPeer;
        } else {
            this.channel_ = (PeersStruct$GroupOutPeer) ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder(this.channel_).v(peersStruct$GroupOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeDiscussionGroup(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer2 = this.discussionGroup_;
        if (peersStruct$GroupOutPeer2 == null || peersStruct$GroupOutPeer2 == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.discussionGroup_ = peersStruct$GroupOutPeer;
        } else {
            this.discussionGroup_ = (PeersStruct$GroupOutPeer) ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder(this.discussionGroup_).v(peersStruct$GroupOutPeer)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestAddDiscussionGroupAdmin parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestAddDiscussionGroupAdmin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestAddDiscussionGroupAdmin parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestAddDiscussionGroupAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChannel(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.channel_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDiscussionGroup(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.discussionGroup_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestAddDiscussionGroupAdmin();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "channel_", "discussionGroup_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestAddDiscussionGroupAdmin.class) {
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

    public PeersStruct$GroupOutPeer getChannel() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.channel_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public PeersStruct$GroupOutPeer getDiscussionGroup() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.discussionGroup_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public boolean hasChannel() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasDiscussionGroup() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(GroupsOuterClass$RequestAddDiscussionGroupAdmin groupsOuterClass$RequestAddDiscussionGroupAdmin) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestAddDiscussionGroupAdmin);
    }

    public static GroupsOuterClass$RequestAddDiscussionGroupAdmin parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestAddDiscussionGroupAdmin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestAddDiscussionGroupAdmin parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestAddDiscussionGroupAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestAddDiscussionGroupAdmin parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestAddDiscussionGroupAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestAddDiscussionGroupAdmin parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestAddDiscussionGroupAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestAddDiscussionGroupAdmin parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestAddDiscussionGroupAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestAddDiscussionGroupAdmin parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestAddDiscussionGroupAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestAddDiscussionGroupAdmin parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestAddDiscussionGroupAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestAddDiscussionGroupAdmin parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestAddDiscussionGroupAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestAddDiscussionGroupAdmin parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestAddDiscussionGroupAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestAddDiscussionGroupAdmin parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestAddDiscussionGroupAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

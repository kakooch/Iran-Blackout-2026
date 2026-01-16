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
public final class GroupsOuterClass$RequestRemoveDiscussionGroup extends GeneratedMessageLite implements U64 {
    public static final int CHANNEL_FIELD_NUMBER = 2;
    private static final GroupsOuterClass$RequestRemoveDiscussionGroup DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int RID_FIELD_NUMBER = 1;
    private int bitField0_;
    private PeersStruct$GroupOutPeer channel_;
    private long rid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$GroupOutPeer.a aVar) {
            q();
            ((GroupsOuterClass$RequestRemoveDiscussionGroup) this.b).setChannel((PeersStruct$GroupOutPeer) aVar.a());
            return this;
        }

        public a B(long j) {
            q();
            ((GroupsOuterClass$RequestRemoveDiscussionGroup) this.b).setRid(j);
            return this;
        }

        private a() {
            super(GroupsOuterClass$RequestRemoveDiscussionGroup.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestRemoveDiscussionGroup groupsOuterClass$RequestRemoveDiscussionGroup = new GroupsOuterClass$RequestRemoveDiscussionGroup();
        DEFAULT_INSTANCE = groupsOuterClass$RequestRemoveDiscussionGroup;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestRemoveDiscussionGroup.class, groupsOuterClass$RequestRemoveDiscussionGroup);
    }

    private GroupsOuterClass$RequestRemoveDiscussionGroup() {
    }

    private void clearChannel() {
        this.channel_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    public static GroupsOuterClass$RequestRemoveDiscussionGroup getDefaultInstance() {
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

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestRemoveDiscussionGroup parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestRemoveDiscussionGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestRemoveDiscussionGroup parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestRemoveDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setRid(long j) {
        this.rid_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestRemoveDiscussionGroup();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002ဉ\u0000", new Object[]{"bitField0_", "rid_", "channel_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestRemoveDiscussionGroup.class) {
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

    public long getRid() {
        return this.rid_;
    }

    public boolean hasChannel() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$RequestRemoveDiscussionGroup groupsOuterClass$RequestRemoveDiscussionGroup) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestRemoveDiscussionGroup);
    }

    public static GroupsOuterClass$RequestRemoveDiscussionGroup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestRemoveDiscussionGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestRemoveDiscussionGroup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestRemoveDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestRemoveDiscussionGroup parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestRemoveDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestRemoveDiscussionGroup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestRemoveDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestRemoveDiscussionGroup parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestRemoveDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestRemoveDiscussionGroup parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestRemoveDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestRemoveDiscussionGroup parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestRemoveDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestRemoveDiscussionGroup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestRemoveDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestRemoveDiscussionGroup parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestRemoveDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestRemoveDiscussionGroup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestRemoveDiscussionGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

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
public final class GroupsOuterClass$RequestSetCanSeeMessages extends GeneratedMessageLite implements U64 {
    public static final int CAN_SEE_MESSAGES_FIELD_NUMBER = 3;
    private static final GroupsOuterClass$RequestSetCanSeeMessages DEFAULT_INSTANCE;
    public static final int GROUP_PEER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 2;
    private int bitField0_;
    private boolean canSeeMessages_;
    private PeersStruct$GroupOutPeer groupPeer_;
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(boolean z) {
            q();
            ((GroupsOuterClass$RequestSetCanSeeMessages) this.b).setCanSeeMessages(z);
            return this;
        }

        public a B(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((GroupsOuterClass$RequestSetCanSeeMessages) this.b).setGroupPeer(peersStruct$GroupOutPeer);
            return this;
        }

        public a C(int i) {
            q();
            ((GroupsOuterClass$RequestSetCanSeeMessages) this.b).setUserId(i);
            return this;
        }

        private a() {
            super(GroupsOuterClass$RequestSetCanSeeMessages.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestSetCanSeeMessages groupsOuterClass$RequestSetCanSeeMessages = new GroupsOuterClass$RequestSetCanSeeMessages();
        DEFAULT_INSTANCE = groupsOuterClass$RequestSetCanSeeMessages;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestSetCanSeeMessages.class, groupsOuterClass$RequestSetCanSeeMessages);
    }

    private GroupsOuterClass$RequestSetCanSeeMessages() {
    }

    private void clearCanSeeMessages() {
        this.canSeeMessages_ = false;
    }

    private void clearGroupPeer() {
        this.groupPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static GroupsOuterClass$RequestSetCanSeeMessages getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGroupPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer2 = this.groupPeer_;
        if (peersStruct$GroupOutPeer2 == null || peersStruct$GroupOutPeer2 == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.groupPeer_ = peersStruct$GroupOutPeer;
        } else {
            this.groupPeer_ = (PeersStruct$GroupOutPeer) ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder(this.groupPeer_).v(peersStruct$GroupOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestSetCanSeeMessages parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestSetCanSeeMessages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestSetCanSeeMessages parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestSetCanSeeMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanSeeMessages(boolean z) {
        this.canSeeMessages_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroupPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.groupPeer_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestSetCanSeeMessages();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004\u0003\u0007", new Object[]{"bitField0_", "groupPeer_", "userId_", "canSeeMessages_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestSetCanSeeMessages.class) {
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

    public boolean getCanSeeMessages() {
        return this.canSeeMessages_;
    }

    public PeersStruct$GroupOutPeer getGroupPeer() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.groupPeer_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public int getUserId() {
        return this.userId_;
    }

    public boolean hasGroupPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$RequestSetCanSeeMessages groupsOuterClass$RequestSetCanSeeMessages) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestSetCanSeeMessages);
    }

    public static GroupsOuterClass$RequestSetCanSeeMessages parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetCanSeeMessages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestSetCanSeeMessages parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetCanSeeMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestSetCanSeeMessages parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestSetCanSeeMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestSetCanSeeMessages parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetCanSeeMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestSetCanSeeMessages parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestSetCanSeeMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestSetCanSeeMessages parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetCanSeeMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestSetCanSeeMessages parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestSetCanSeeMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestSetCanSeeMessages parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetCanSeeMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestSetCanSeeMessages parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestSetCanSeeMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestSetCanSeeMessages parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetCanSeeMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

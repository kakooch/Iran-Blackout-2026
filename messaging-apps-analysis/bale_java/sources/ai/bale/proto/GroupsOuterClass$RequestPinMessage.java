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
public final class GroupsOuterClass$RequestPinMessage extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 3;
    private static final GroupsOuterClass$RequestPinMessage DEFAULT_INSTANCE;
    public static final int GROUP_PEER_FIELD_NUMBER = 2;
    public static final int MSG_RID_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int SENDER_USER_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private long date_;
    private PeersStruct$GroupOutPeer groupPeer_;
    private long msgRid_;
    private int senderUserId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((GroupsOuterClass$RequestPinMessage) this.b).setDate(j);
            return this;
        }

        public a B(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((GroupsOuterClass$RequestPinMessage) this.b).setGroupPeer(peersStruct$GroupOutPeer);
            return this;
        }

        public a C(long j) {
            q();
            ((GroupsOuterClass$RequestPinMessage) this.b).setMsgRid(j);
            return this;
        }

        public a D(int i) {
            q();
            ((GroupsOuterClass$RequestPinMessage) this.b).setSenderUserId(i);
            return this;
        }

        private a() {
            super(GroupsOuterClass$RequestPinMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestPinMessage groupsOuterClass$RequestPinMessage = new GroupsOuterClass$RequestPinMessage();
        DEFAULT_INSTANCE = groupsOuterClass$RequestPinMessage;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestPinMessage.class, groupsOuterClass$RequestPinMessage);
    }

    private GroupsOuterClass$RequestPinMessage() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearGroupPeer() {
        this.groupPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearMsgRid() {
        this.msgRid_ = 0L;
    }

    private void clearSenderUserId() {
        this.senderUserId_ = 0;
    }

    public static GroupsOuterClass$RequestPinMessage getDefaultInstance() {
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

    public static GroupsOuterClass$RequestPinMessage parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestPinMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestPinMessage parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestPinMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(long j) {
        this.date_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroupPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.groupPeer_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMsgRid(long j) {
        this.msgRid_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSenderUserId(int i) {
        this.senderUserId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestPinMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000\u0003\u0002\u0004\u0002", new Object[]{"bitField0_", "senderUserId_", "groupPeer_", "date_", "msgRid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestPinMessage.class) {
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

    public long getDate() {
        return this.date_;
    }

    public PeersStruct$GroupOutPeer getGroupPeer() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.groupPeer_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public long getMsgRid() {
        return this.msgRid_;
    }

    public int getSenderUserId() {
        return this.senderUserId_;
    }

    public boolean hasGroupPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$RequestPinMessage groupsOuterClass$RequestPinMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestPinMessage);
    }

    public static GroupsOuterClass$RequestPinMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestPinMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestPinMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestPinMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestPinMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestPinMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestPinMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestPinMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestPinMessage parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestPinMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestPinMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestPinMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestPinMessage parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestPinMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestPinMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestPinMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestPinMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestPinMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestPinMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestPinMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$RequestEditChannelNick extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$RequestEditChannelNick DEFAULT_INSTANCE;
    public static final int GROUP_PEER_FIELD_NUMBER = 1;
    public static final int NICK_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int RANDOM_ID_FIELD_NUMBER = 3;
    private int bitField0_;
    private PeersStruct$GroupOutPeer groupPeer_;
    private String nick_ = "";
    private long randomId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((GroupsOuterClass$RequestEditChannelNick) this.b).setGroupPeer(peersStruct$GroupOutPeer);
            return this;
        }

        public a B(String str) {
            q();
            ((GroupsOuterClass$RequestEditChannelNick) this.b).setNick(str);
            return this;
        }

        public a C(long j) {
            q();
            ((GroupsOuterClass$RequestEditChannelNick) this.b).setRandomId(j);
            return this;
        }

        private a() {
            super(GroupsOuterClass$RequestEditChannelNick.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestEditChannelNick groupsOuterClass$RequestEditChannelNick = new GroupsOuterClass$RequestEditChannelNick();
        DEFAULT_INSTANCE = groupsOuterClass$RequestEditChannelNick;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestEditChannelNick.class, groupsOuterClass$RequestEditChannelNick);
    }

    private GroupsOuterClass$RequestEditChannelNick() {
    }

    private void clearGroupPeer() {
        this.groupPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearNick() {
        this.nick_ = getDefaultInstance().getNick();
    }

    private void clearRandomId() {
        this.randomId_ = 0L;
    }

    public static GroupsOuterClass$RequestEditChannelNick getDefaultInstance() {
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

    public static GroupsOuterClass$RequestEditChannelNick parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestEditChannelNick) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestEditChannelNick parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestEditChannelNick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroupPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.groupPeer_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNick(String str) {
        str.getClass();
        this.nick_ = str;
    }

    private void setNickBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nick_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRandomId(long j) {
        this.randomId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestEditChannelNick();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ\u0003\u0002", new Object[]{"bitField0_", "groupPeer_", "nick_", "randomId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestEditChannelNick.class) {
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

    public PeersStruct$GroupOutPeer getGroupPeer() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.groupPeer_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public String getNick() {
        return this.nick_;
    }

    public AbstractC2383g getNickBytes() {
        return AbstractC2383g.N(this.nick_);
    }

    public long getRandomId() {
        return this.randomId_;
    }

    public boolean hasGroupPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$RequestEditChannelNick groupsOuterClass$RequestEditChannelNick) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestEditChannelNick);
    }

    public static GroupsOuterClass$RequestEditChannelNick parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestEditChannelNick) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestEditChannelNick parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestEditChannelNick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestEditChannelNick parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestEditChannelNick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestEditChannelNick parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestEditChannelNick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestEditChannelNick parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestEditChannelNick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestEditChannelNick parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestEditChannelNick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestEditChannelNick parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestEditChannelNick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestEditChannelNick parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestEditChannelNick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestEditChannelNick parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestEditChannelNick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestEditChannelNick parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestEditChannelNick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

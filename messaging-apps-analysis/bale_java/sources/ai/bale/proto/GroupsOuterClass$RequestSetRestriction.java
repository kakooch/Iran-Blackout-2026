package ai.bale.proto;

import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.GS2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$RequestSetRestriction extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$RequestSetRestriction DEFAULT_INSTANCE;
    public static final int GROUP_OUT_PEER_FIELD_NUMBER = 1;
    public static final int NICK_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int RESTRICTION_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$GroupOutPeer groupOutPeer_;
    private StringValue nick_;
    private int restriction_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((GroupsOuterClass$RequestSetRestriction) this.b).setGroupOutPeer(peersStruct$GroupOutPeer);
            return this;
        }

        public a B(StringValue stringValue) {
            q();
            ((GroupsOuterClass$RequestSetRestriction) this.b).setNick(stringValue);
            return this;
        }

        public a C(GS2 gs2) {
            q();
            ((GroupsOuterClass$RequestSetRestriction) this.b).setRestriction(gs2);
            return this;
        }

        private a() {
            super(GroupsOuterClass$RequestSetRestriction.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestSetRestriction groupsOuterClass$RequestSetRestriction = new GroupsOuterClass$RequestSetRestriction();
        DEFAULT_INSTANCE = groupsOuterClass$RequestSetRestriction;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestSetRestriction.class, groupsOuterClass$RequestSetRestriction);
    }

    private GroupsOuterClass$RequestSetRestriction() {
    }

    private void clearGroupOutPeer() {
        this.groupOutPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearNick() {
        this.nick_ = null;
        this.bitField0_ &= -3;
    }

    private void clearRestriction() {
        this.restriction_ = 0;
    }

    public static GroupsOuterClass$RequestSetRestriction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGroupOutPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer2 = this.groupOutPeer_;
        if (peersStruct$GroupOutPeer2 == null || peersStruct$GroupOutPeer2 == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.groupOutPeer_ = peersStruct$GroupOutPeer;
        } else {
            this.groupOutPeer_ = (PeersStruct$GroupOutPeer) ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder(this.groupOutPeer_).v(peersStruct$GroupOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeNick(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.nick_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.nick_ = stringValue;
        } else {
            this.nick_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.nick_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestSetRestriction parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestSetRestriction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestSetRestriction parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestSetRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroupOutPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.groupOutPeer_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNick(StringValue stringValue) {
        stringValue.getClass();
        this.nick_ = stringValue;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRestriction(GS2 gs2) {
        this.restriction_ = gs2.getNumber();
    }

    private void setRestrictionValue(int i) {
        this.restriction_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestSetRestriction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003ဉ\u0001", new Object[]{"bitField0_", "groupOutPeer_", "restriction_", "nick_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestSetRestriction.class) {
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

    public PeersStruct$GroupOutPeer getGroupOutPeer() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.groupOutPeer_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public StringValue getNick() {
        StringValue stringValue = this.nick_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public GS2 getRestriction() {
        GS2 gs2J = GS2.j(this.restriction_);
        return gs2J == null ? GS2.UNRECOGNIZED : gs2J;
    }

    public int getRestrictionValue() {
        return this.restriction_;
    }

    public boolean hasGroupOutPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasNick() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(GroupsOuterClass$RequestSetRestriction groupsOuterClass$RequestSetRestriction) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestSetRestriction);
    }

    public static GroupsOuterClass$RequestSetRestriction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetRestriction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestSetRestriction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestSetRestriction parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestSetRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestSetRestriction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestSetRestriction parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestSetRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestSetRestriction parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestSetRestriction parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestSetRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestSetRestriction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestSetRestriction parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestSetRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestSetRestriction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

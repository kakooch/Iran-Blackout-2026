package ai.bale.proto;

import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$RequestSetAvailableReactions extends GeneratedMessageLite implements U64 {
    public static final int CODES_FIELD_NUMBER = 2;
    private static final GroupsOuterClass$RequestSetAvailableReactions DEFAULT_INSTANCE;
    public static final int GROUP_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private B.j codes_ = GeneratedMessageLite.emptyProtobufList();
    private PeersStruct$GroupOutPeer group_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((GroupsOuterClass$RequestSetAvailableReactions) this.b).addAllCodes(iterable);
            return this;
        }

        public a B(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((GroupsOuterClass$RequestSetAvailableReactions) this.b).setGroup(peersStruct$GroupOutPeer);
            return this;
        }

        private a() {
            super(GroupsOuterClass$RequestSetAvailableReactions.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestSetAvailableReactions groupsOuterClass$RequestSetAvailableReactions = new GroupsOuterClass$RequestSetAvailableReactions();
        DEFAULT_INSTANCE = groupsOuterClass$RequestSetAvailableReactions;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestSetAvailableReactions.class, groupsOuterClass$RequestSetAvailableReactions);
    }

    private GroupsOuterClass$RequestSetAvailableReactions() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCodes(Iterable<String> iterable) {
        ensureCodesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.codes_);
    }

    private void addCodes(String str) {
        str.getClass();
        ensureCodesIsMutable();
        this.codes_.add(str);
    }

    private void addCodesBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureCodesIsMutable();
        this.codes_.add(abstractC2383g.f0());
    }

    private void clearCodes() {
        this.codes_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearGroup() {
        this.group_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureCodesIsMutable() {
        B.j jVar = this.codes_;
        if (jVar.u()) {
            return;
        }
        this.codes_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GroupsOuterClass$RequestSetAvailableReactions getDefaultInstance() {
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

    public static GroupsOuterClass$RequestSetAvailableReactions parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestSetAvailableReactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestSetAvailableReactions parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestSetAvailableReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCodes(int i, String str) {
        str.getClass();
        ensureCodesIsMutable();
        this.codes_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroup(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.group_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestSetAvailableReactions();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002Ț", new Object[]{"bitField0_", "group_", "codes_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestSetAvailableReactions.class) {
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

    public String getCodes(int i) {
        return (String) this.codes_.get(i);
    }

    public AbstractC2383g getCodesBytes(int i) {
        return AbstractC2383g.N((String) this.codes_.get(i));
    }

    public int getCodesCount() {
        return this.codes_.size();
    }

    public List<String> getCodesList() {
        return this.codes_;
    }

    public PeersStruct$GroupOutPeer getGroup() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.group_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public boolean hasGroup() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$RequestSetAvailableReactions groupsOuterClass$RequestSetAvailableReactions) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestSetAvailableReactions);
    }

    public static GroupsOuterClass$RequestSetAvailableReactions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetAvailableReactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestSetAvailableReactions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetAvailableReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestSetAvailableReactions parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestSetAvailableReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestSetAvailableReactions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetAvailableReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestSetAvailableReactions parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestSetAvailableReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestSetAvailableReactions parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetAvailableReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestSetAvailableReactions parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestSetAvailableReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestSetAvailableReactions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetAvailableReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestSetAvailableReactions parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestSetAvailableReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestSetAvailableReactions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestSetAvailableReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

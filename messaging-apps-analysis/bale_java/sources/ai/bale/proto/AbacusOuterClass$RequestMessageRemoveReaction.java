package ai.bale.proto;

import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class AbacusOuterClass$RequestMessageRemoveReaction extends GeneratedMessageLite implements U64 {
    public static final int CODE_FIELD_NUMBER = 3;
    public static final int DATE_FIELD_NUMBER = 4;
    private static final AbacusOuterClass$RequestMessageRemoveReaction DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int RID_FIELD_NUMBER = 2;
    private int bitField0_;
    private String code_ = "";
    private long date_;
    private PeersStruct$OutPeer peer_;
    private long rid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((AbacusOuterClass$RequestMessageRemoveReaction) this.b).setCode(str);
            return this;
        }

        public a B(long j) {
            q();
            ((AbacusOuterClass$RequestMessageRemoveReaction) this.b).setDate(j);
            return this;
        }

        public a C(PeersStruct$OutPeer peersStruct$OutPeer) {
            q();
            ((AbacusOuterClass$RequestMessageRemoveReaction) this.b).setPeer(peersStruct$OutPeer);
            return this;
        }

        public a D(long j) {
            q();
            ((AbacusOuterClass$RequestMessageRemoveReaction) this.b).setRid(j);
            return this;
        }

        private a() {
            super(AbacusOuterClass$RequestMessageRemoveReaction.DEFAULT_INSTANCE);
        }
    }

    static {
        AbacusOuterClass$RequestMessageRemoveReaction abacusOuterClass$RequestMessageRemoveReaction = new AbacusOuterClass$RequestMessageRemoveReaction();
        DEFAULT_INSTANCE = abacusOuterClass$RequestMessageRemoveReaction;
        GeneratedMessageLite.registerDefaultInstance(AbacusOuterClass$RequestMessageRemoveReaction.class, abacusOuterClass$RequestMessageRemoveReaction);
    }

    private AbacusOuterClass$RequestMessageRemoveReaction() {
    }

    private void clearCode() {
        this.code_ = getDefaultInstance().getCode();
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    public static AbacusOuterClass$RequestMessageRemoveReaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        PeersStruct$OutPeer peersStruct$OutPeer2 = this.peer_;
        if (peersStruct$OutPeer2 == null || peersStruct$OutPeer2 == PeersStruct$OutPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$OutPeer;
        } else {
            this.peer_ = (PeersStruct$OutPeer) ((PeersStruct$OutPeer.a) PeersStruct$OutPeer.newBuilder(this.peer_).v(peersStruct$OutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AbacusOuterClass$RequestMessageRemoveReaction parseDelimitedFrom(InputStream inputStream) {
        return (AbacusOuterClass$RequestMessageRemoveReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$RequestMessageRemoveReaction parseFrom(ByteBuffer byteBuffer) {
        return (AbacusOuterClass$RequestMessageRemoveReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCode(String str) {
        str.getClass();
        this.code_ = str;
    }

    private void setCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.code_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(long j) {
        this.date_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.peer_ = peersStruct$OutPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRid(long j) {
        this.rid_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1837a.a[gVar.ordinal()]) {
            case 1:
                return new AbacusOuterClass$RequestMessageRemoveReaction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003Ȉ\u0004\u0002", new Object[]{"bitField0_", "peer_", "rid_", "code_", "date_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AbacusOuterClass$RequestMessageRemoveReaction.class) {
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

    public String getCode() {
        return this.code_;
    }

    public AbstractC2383g getCodeBytes() {
        return AbstractC2383g.N(this.code_);
    }

    public long getDate() {
        return this.date_;
    }

    public PeersStruct$OutPeer getPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.peer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public long getRid() {
        return this.rid_;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AbacusOuterClass$RequestMessageRemoveReaction abacusOuterClass$RequestMessageRemoveReaction) {
        return (a) DEFAULT_INSTANCE.createBuilder(abacusOuterClass$RequestMessageRemoveReaction);
    }

    public static AbacusOuterClass$RequestMessageRemoveReaction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$RequestMessageRemoveReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$RequestMessageRemoveReaction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AbacusOuterClass$RequestMessageRemoveReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AbacusOuterClass$RequestMessageRemoveReaction parseFrom(AbstractC2383g abstractC2383g) {
        return (AbacusOuterClass$RequestMessageRemoveReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AbacusOuterClass$RequestMessageRemoveReaction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AbacusOuterClass$RequestMessageRemoveReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AbacusOuterClass$RequestMessageRemoveReaction parseFrom(byte[] bArr) {
        return (AbacusOuterClass$RequestMessageRemoveReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AbacusOuterClass$RequestMessageRemoveReaction parseFrom(byte[] bArr, C2394s c2394s) {
        return (AbacusOuterClass$RequestMessageRemoveReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AbacusOuterClass$RequestMessageRemoveReaction parseFrom(InputStream inputStream) {
        return (AbacusOuterClass$RequestMessageRemoveReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$RequestMessageRemoveReaction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$RequestMessageRemoveReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$RequestMessageRemoveReaction parseFrom(AbstractC2384h abstractC2384h) {
        return (AbacusOuterClass$RequestMessageRemoveReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AbacusOuterClass$RequestMessageRemoveReaction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AbacusOuterClass$RequestMessageRemoveReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

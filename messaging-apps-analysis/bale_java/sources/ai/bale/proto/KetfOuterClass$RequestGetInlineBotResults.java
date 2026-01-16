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

/* loaded from: classes9.dex */
public final class KetfOuterClass$RequestGetInlineBotResults extends GeneratedMessageLite implements U64 {
    public static final int BOT_USER_ID_FIELD_NUMBER = 3;
    private static final KetfOuterClass$RequestGetInlineBotResults DEFAULT_INSTANCE;
    public static final int OFFSET_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 2;
    public static final int QUERY_FIELD_NUMBER = 1;
    private int bitField0_;
    private int botUserId_;
    private PeersStruct$OutPeer peer_;
    private String query_ = "";
    private String offset_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfOuterClass$RequestGetInlineBotResults.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfOuterClass$RequestGetInlineBotResults ketfOuterClass$RequestGetInlineBotResults = new KetfOuterClass$RequestGetInlineBotResults();
        DEFAULT_INSTANCE = ketfOuterClass$RequestGetInlineBotResults;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$RequestGetInlineBotResults.class, ketfOuterClass$RequestGetInlineBotResults);
    }

    private KetfOuterClass$RequestGetInlineBotResults() {
    }

    private void clearBotUserId() {
        this.botUserId_ = 0;
    }

    private void clearOffset() {
        this.offset_ = getDefaultInstance().getOffset();
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearQuery() {
        this.query_ = getDefaultInstance().getQuery();
    }

    public static KetfOuterClass$RequestGetInlineBotResults getDefaultInstance() {
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

    public static KetfOuterClass$RequestGetInlineBotResults parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestGetInlineBotResults) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestGetInlineBotResults parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$RequestGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotUserId(int i) {
        this.botUserId_ = i;
    }

    private void setOffset(String str) {
        str.getClass();
        this.offset_ = str;
    }

    private void setOffsetBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.offset_ = abstractC2383g.f0();
    }

    private void setPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.peer_ = peersStruct$OutPeer;
        this.bitField0_ |= 1;
    }

    private void setQuery(String str) {
        str.getClass();
        this.query_ = str;
    }

    private void setQueryBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.query_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$RequestGetInlineBotResults();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003\u0004\u0004Ȉ", new Object[]{"bitField0_", "query_", "peer_", "botUserId_", "offset_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$RequestGetInlineBotResults.class) {
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

    public int getBotUserId() {
        return this.botUserId_;
    }

    public String getOffset() {
        return this.offset_;
    }

    public AbstractC2383g getOffsetBytes() {
        return AbstractC2383g.N(this.offset_);
    }

    public PeersStruct$OutPeer getPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.peer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public String getQuery() {
        return this.query_;
    }

    public AbstractC2383g getQueryBytes() {
        return AbstractC2383g.N(this.query_);
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KetfOuterClass$RequestGetInlineBotResults ketfOuterClass$RequestGetInlineBotResults) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$RequestGetInlineBotResults);
    }

    public static KetfOuterClass$RequestGetInlineBotResults parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestGetInlineBotResults) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestGetInlineBotResults parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$RequestGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$RequestGetInlineBotResults parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$RequestGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfOuterClass$RequestGetInlineBotResults parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$RequestGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$RequestGetInlineBotResults parseFrom(byte[] bArr) {
        return (KetfOuterClass$RequestGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$RequestGetInlineBotResults parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$RequestGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$RequestGetInlineBotResults parseFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestGetInlineBotResults parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestGetInlineBotResults parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$RequestGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$RequestGetInlineBotResults parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$RequestGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.PeersStruct$Peer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SearchStruct$MessageSearchResult extends GeneratedMessageLite implements U64 {
    public static final int CONTENT_FIELD_NUMBER = 5;
    public static final int DATE_FIELD_NUMBER = 3;
    private static final SearchStruct$MessageSearchResult DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int RID_FIELD_NUMBER = 2;
    public static final int SENDER_ID_FIELD_NUMBER = 4;
    private int bitField0_;
    private MessagingStruct$Message content_;
    private long date_;
    private PeersStruct$Peer peer_;
    private long rid_;
    private int senderId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SearchStruct$MessageSearchResult.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchStruct$MessageSearchResult searchStruct$MessageSearchResult = new SearchStruct$MessageSearchResult();
        DEFAULT_INSTANCE = searchStruct$MessageSearchResult;
        GeneratedMessageLite.registerDefaultInstance(SearchStruct$MessageSearchResult.class, searchStruct$MessageSearchResult);
    }

    private SearchStruct$MessageSearchResult() {
    }

    private void clearContent() {
        this.content_ = null;
        this.bitField0_ &= -3;
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

    private void clearSenderId() {
        this.senderId_ = 0;
    }

    public static SearchStruct$MessageSearchResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeContent(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        MessagingStruct$Message messagingStruct$Message2 = this.content_;
        if (messagingStruct$Message2 == null || messagingStruct$Message2 == MessagingStruct$Message.getDefaultInstance()) {
            this.content_ = messagingStruct$Message;
        } else {
            this.content_ = (MessagingStruct$Message) ((MessagingStruct$Message.a) MessagingStruct$Message.newBuilder(this.content_).v(messagingStruct$Message)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergePeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        PeersStruct$Peer peersStruct$Peer2 = this.peer_;
        if (peersStruct$Peer2 == null || peersStruct$Peer2 == PeersStruct$Peer.getDefaultInstance()) {
            this.peer_ = peersStruct$Peer;
        } else {
            this.peer_ = (PeersStruct$Peer) ((PeersStruct$Peer.a) PeersStruct$Peer.newBuilder(this.peer_).v(peersStruct$Peer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchStruct$MessageSearchResult parseDelimitedFrom(InputStream inputStream) {
        return (SearchStruct$MessageSearchResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$MessageSearchResult parseFrom(ByteBuffer byteBuffer) {
        return (SearchStruct$MessageSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setContent(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.content_ = messagingStruct$Message;
        this.bitField0_ |= 2;
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setPeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        this.peer_ = peersStruct$Peer;
        this.bitField0_ |= 1;
    }

    private void setRid(long j) {
        this.rid_ = j;
    }

    private void setSenderId(int i) {
        this.senderId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M1.a[gVar.ordinal()]) {
            case 1:
                return new SearchStruct$MessageSearchResult();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003\u0002\u0004\u0004\u0005ဉ\u0001", new Object[]{"bitField0_", "peer_", "rid_", "date_", "senderId_", "content_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchStruct$MessageSearchResult.class) {
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

    public MessagingStruct$Message getContent() {
        MessagingStruct$Message messagingStruct$Message = this.content_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public long getDate() {
        return this.date_;
    }

    public PeersStruct$Peer getPeer() {
        PeersStruct$Peer peersStruct$Peer = this.peer_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public long getRid() {
        return this.rid_;
    }

    public int getSenderId() {
        return this.senderId_;
    }

    public boolean hasContent() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SearchStruct$MessageSearchResult searchStruct$MessageSearchResult) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchStruct$MessageSearchResult);
    }

    public static SearchStruct$MessageSearchResult parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$MessageSearchResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$MessageSearchResult parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchStruct$MessageSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchStruct$MessageSearchResult parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchStruct$MessageSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchStruct$MessageSearchResult parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchStruct$MessageSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchStruct$MessageSearchResult parseFrom(byte[] bArr) {
        return (SearchStruct$MessageSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchStruct$MessageSearchResult parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchStruct$MessageSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchStruct$MessageSearchResult parseFrom(InputStream inputStream) {
        return (SearchStruct$MessageSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$MessageSearchResult parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$MessageSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$MessageSearchResult parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchStruct$MessageSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchStruct$MessageSearchResult parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchStruct$MessageSearchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

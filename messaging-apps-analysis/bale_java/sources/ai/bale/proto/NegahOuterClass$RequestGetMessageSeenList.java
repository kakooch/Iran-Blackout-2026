package ai.bale.proto;

import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class NegahOuterClass$RequestGetMessageSeenList extends GeneratedMessageLite implements U64 {
    private static final NegahOuterClass$RequestGetMessageSeenList DEFAULT_INSTANCE;
    public static final int LIMIT_FIELD_NUMBER = 4;
    public static final int MESSAGE_ID_FIELD_NUMBER = 2;
    public static final int PAGE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    private int bitField0_;
    private int limit_;
    private MessagingStruct$MessageId messageId_;
    private int page_;
    private PeersStruct$ExPeer peer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((NegahOuterClass$RequestGetMessageSeenList) this.b).setLimit(i);
            return this;
        }

        public a B(MessagingStruct$MessageId messagingStruct$MessageId) {
            q();
            ((NegahOuterClass$RequestGetMessageSeenList) this.b).setMessageId(messagingStruct$MessageId);
            return this;
        }

        public a C(int i) {
            q();
            ((NegahOuterClass$RequestGetMessageSeenList) this.b).setPage(i);
            return this;
        }

        public a D(PeersStruct$ExPeer peersStruct$ExPeer) {
            q();
            ((NegahOuterClass$RequestGetMessageSeenList) this.b).setPeer(peersStruct$ExPeer);
            return this;
        }

        private a() {
            super(NegahOuterClass$RequestGetMessageSeenList.DEFAULT_INSTANCE);
        }
    }

    static {
        NegahOuterClass$RequestGetMessageSeenList negahOuterClass$RequestGetMessageSeenList = new NegahOuterClass$RequestGetMessageSeenList();
        DEFAULT_INSTANCE = negahOuterClass$RequestGetMessageSeenList;
        GeneratedMessageLite.registerDefaultInstance(NegahOuterClass$RequestGetMessageSeenList.class, negahOuterClass$RequestGetMessageSeenList);
    }

    private NegahOuterClass$RequestGetMessageSeenList() {
    }

    private void clearLimit() {
        this.limit_ = 0;
    }

    private void clearMessageId() {
        this.messageId_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPage() {
        this.page_ = 0;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    public static NegahOuterClass$RequestGetMessageSeenList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        MessagingStruct$MessageId messagingStruct$MessageId2 = this.messageId_;
        if (messagingStruct$MessageId2 == null || messagingStruct$MessageId2 == MessagingStruct$MessageId.getDefaultInstance()) {
            this.messageId_ = messagingStruct$MessageId;
        } else {
            this.messageId_ = (MessagingStruct$MessageId) ((MessagingStruct$MessageId.a) MessagingStruct$MessageId.newBuilder(this.messageId_).v(messagingStruct$MessageId)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergePeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.peer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$ExPeer;
        } else {
            this.peer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.peer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static NegahOuterClass$RequestGetMessageSeenList parseDelimitedFrom(InputStream inputStream) {
        return (NegahOuterClass$RequestGetMessageSeenList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NegahOuterClass$RequestGetMessageSeenList parseFrom(ByteBuffer byteBuffer) {
        return (NegahOuterClass$RequestGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLimit(int i) {
        this.limit_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.messageId_ = messagingStruct$MessageId;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPage(int i) {
        this.page_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.peer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S0.a[gVar.ordinal()]) {
            case 1:
                return new NegahOuterClass$RequestGetMessageSeenList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u0004\u0004\u0004", new Object[]{"bitField0_", "peer_", "messageId_", "page_", "limit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (NegahOuterClass$RequestGetMessageSeenList.class) {
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

    public int getLimit() {
        return this.limit_;
    }

    public MessagingStruct$MessageId getMessageId() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.messageId_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    public int getPage() {
        return this.page_;
    }

    public PeersStruct$ExPeer getPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.peer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public boolean hasMessageId() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(NegahOuterClass$RequestGetMessageSeenList negahOuterClass$RequestGetMessageSeenList) {
        return (a) DEFAULT_INSTANCE.createBuilder(negahOuterClass$RequestGetMessageSeenList);
    }

    public static NegahOuterClass$RequestGetMessageSeenList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (NegahOuterClass$RequestGetMessageSeenList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static NegahOuterClass$RequestGetMessageSeenList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (NegahOuterClass$RequestGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static NegahOuterClass$RequestGetMessageSeenList parseFrom(AbstractC2383g abstractC2383g) {
        return (NegahOuterClass$RequestGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static NegahOuterClass$RequestGetMessageSeenList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (NegahOuterClass$RequestGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static NegahOuterClass$RequestGetMessageSeenList parseFrom(byte[] bArr) {
        return (NegahOuterClass$RequestGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NegahOuterClass$RequestGetMessageSeenList parseFrom(byte[] bArr, C2394s c2394s) {
        return (NegahOuterClass$RequestGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static NegahOuterClass$RequestGetMessageSeenList parseFrom(InputStream inputStream) {
        return (NegahOuterClass$RequestGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NegahOuterClass$RequestGetMessageSeenList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (NegahOuterClass$RequestGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static NegahOuterClass$RequestGetMessageSeenList parseFrom(AbstractC2384h abstractC2384h) {
        return (NegahOuterClass$RequestGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static NegahOuterClass$RequestGetMessageSeenList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (NegahOuterClass$RequestGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

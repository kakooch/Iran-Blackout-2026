package ai.bale.proto;

import ai.bale.proto.MessagingStruct$Dates;
import ai.bale.proto.PeersStruct$Peer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13043fc4;
import ir.nasim.InterfaceC18947pX0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$UpdateMessageDelete extends GeneratedMessageLite implements U64 {
    public static final int DATES_FIELD_NUMBER = 3;
    private static final MessagingOuterClass$UpdateMessageDelete DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int QUOTED_COMMENT_REPLY_SENDER_IDS_FIELD_NUMBER = 5;
    public static final int RIDS_FIELD_NUMBER = 2;
    public static final int THREAD_IDS_FIELD_NUMBER = 4;
    private int bitField0_;
    private MessagingStruct$Dates dates_;
    private PeersStruct$Peer peer_;
    private int ridsMemoizedSerializedSize = -1;
    private B.i rids_ = GeneratedMessageLite.emptyLongList();
    private B.j threadIds_ = GeneratedMessageLite.emptyProtobufList();
    private B.j quotedCommentReplySenderIds_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$UpdateMessageDelete.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$UpdateMessageDelete messagingOuterClass$UpdateMessageDelete = new MessagingOuterClass$UpdateMessageDelete();
        DEFAULT_INSTANCE = messagingOuterClass$UpdateMessageDelete;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$UpdateMessageDelete.class, messagingOuterClass$UpdateMessageDelete);
    }

    private MessagingOuterClass$UpdateMessageDelete() {
    }

    private void addAllQuotedCommentReplySenderIds(Iterable<? extends CollectionsStruct$Int32Value> iterable) {
        ensureQuotedCommentReplySenderIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.quotedCommentReplySenderIds_);
    }

    private void addAllRids(Iterable<? extends Long> iterable) {
        ensureRidsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.rids_);
    }

    private void addAllThreadIds(Iterable<? extends MessagingStruct$MessageId> iterable) {
        ensureThreadIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.threadIds_);
    }

    private void addQuotedCommentReplySenderIds(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        ensureQuotedCommentReplySenderIdsIsMutable();
        this.quotedCommentReplySenderIds_.add(collectionsStruct$Int32Value);
    }

    private void addRids(long j) {
        ensureRidsIsMutable();
        this.rids_.l1(j);
    }

    private void addThreadIds(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureThreadIdsIsMutable();
        this.threadIds_.add(messagingStruct$MessageId);
    }

    private void clearDates() {
        this.dates_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearQuotedCommentReplySenderIds() {
        this.quotedCommentReplySenderIds_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearRids() {
        this.rids_ = GeneratedMessageLite.emptyLongList();
    }

    private void clearThreadIds() {
        this.threadIds_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureQuotedCommentReplySenderIdsIsMutable() {
        B.j jVar = this.quotedCommentReplySenderIds_;
        if (jVar.u()) {
            return;
        }
        this.quotedCommentReplySenderIds_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureRidsIsMutable() {
        B.i iVar = this.rids_;
        if (iVar.u()) {
            return;
        }
        this.rids_ = GeneratedMessageLite.mutableCopy(iVar);
    }

    private void ensureThreadIdsIsMutable() {
        B.j jVar = this.threadIds_;
        if (jVar.u()) {
            return;
        }
        this.threadIds_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingOuterClass$UpdateMessageDelete getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDates(MessagingStruct$Dates messagingStruct$Dates) {
        messagingStruct$Dates.getClass();
        MessagingStruct$Dates messagingStruct$Dates2 = this.dates_;
        if (messagingStruct$Dates2 == null || messagingStruct$Dates2 == MessagingStruct$Dates.getDefaultInstance()) {
            this.dates_ = messagingStruct$Dates;
        } else {
            this.dates_ = (MessagingStruct$Dates) ((MessagingStruct$Dates.a) MessagingStruct$Dates.newBuilder(this.dates_).v(messagingStruct$Dates)).j();
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

    public static MessagingOuterClass$UpdateMessageDelete parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateMessageDelete) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateMessageDelete parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$UpdateMessageDelete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeQuotedCommentReplySenderIds(int i) {
        ensureQuotedCommentReplySenderIdsIsMutable();
        this.quotedCommentReplySenderIds_.remove(i);
    }

    private void removeThreadIds(int i) {
        ensureThreadIdsIsMutable();
        this.threadIds_.remove(i);
    }

    private void setDates(MessagingStruct$Dates messagingStruct$Dates) {
        messagingStruct$Dates.getClass();
        this.dates_ = messagingStruct$Dates;
        this.bitField0_ |= 2;
    }

    private void setPeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        this.peer_ = peersStruct$Peer;
        this.bitField0_ |= 1;
    }

    private void setQuotedCommentReplySenderIds(int i, CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        ensureQuotedCommentReplySenderIdsIsMutable();
        this.quotedCommentReplySenderIds_.set(i, collectionsStruct$Int32Value);
    }

    private void setRids(int i, long j) {
        ensureRidsIsMutable();
        this.rids_.z1(i, j);
    }

    private void setThreadIds(int i, MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureThreadIdsIsMutable();
        this.threadIds_.set(i, messagingStruct$MessageId);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$UpdateMessageDelete();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001ဉ\u0000\u0002%\u0003ဉ\u0001\u0004\u001b\u0005\u001b", new Object[]{"bitField0_", "peer_", "rids_", "dates_", "threadIds_", MessagingStruct$MessageId.class, "quotedCommentReplySenderIds_", CollectionsStruct$Int32Value.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$UpdateMessageDelete.class) {
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

    public MessagingStruct$Dates getDates() {
        MessagingStruct$Dates messagingStruct$Dates = this.dates_;
        return messagingStruct$Dates == null ? MessagingStruct$Dates.getDefaultInstance() : messagingStruct$Dates;
    }

    public PeersStruct$Peer getPeer() {
        PeersStruct$Peer peersStruct$Peer = this.peer_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public CollectionsStruct$Int32Value getQuotedCommentReplySenderIds(int i) {
        return (CollectionsStruct$Int32Value) this.quotedCommentReplySenderIds_.get(i);
    }

    public int getQuotedCommentReplySenderIdsCount() {
        return this.quotedCommentReplySenderIds_.size();
    }

    public List<CollectionsStruct$Int32Value> getQuotedCommentReplySenderIdsList() {
        return this.quotedCommentReplySenderIds_;
    }

    public InterfaceC18947pX0 getQuotedCommentReplySenderIdsOrBuilder(int i) {
        return (InterfaceC18947pX0) this.quotedCommentReplySenderIds_.get(i);
    }

    public List<? extends InterfaceC18947pX0> getQuotedCommentReplySenderIdsOrBuilderList() {
        return this.quotedCommentReplySenderIds_;
    }

    public long getRids(int i) {
        return this.rids_.getLong(i);
    }

    public int getRidsCount() {
        return this.rids_.size();
    }

    public List<Long> getRidsList() {
        return this.rids_;
    }

    public MessagingStruct$MessageId getThreadIds(int i) {
        return (MessagingStruct$MessageId) this.threadIds_.get(i);
    }

    public int getThreadIdsCount() {
        return this.threadIds_.size();
    }

    public List<MessagingStruct$MessageId> getThreadIdsList() {
        return this.threadIds_;
    }

    public InterfaceC13043fc4 getThreadIdsOrBuilder(int i) {
        return (InterfaceC13043fc4) this.threadIds_.get(i);
    }

    public List<? extends InterfaceC13043fc4> getThreadIdsOrBuilderList() {
        return this.threadIds_;
    }

    public boolean hasDates() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingOuterClass$UpdateMessageDelete messagingOuterClass$UpdateMessageDelete) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$UpdateMessageDelete);
    }

    public static MessagingOuterClass$UpdateMessageDelete parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageDelete) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageDelete parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageDelete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageDelete parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$UpdateMessageDelete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addQuotedCommentReplySenderIds(int i, CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        ensureQuotedCommentReplySenderIdsIsMutable();
        this.quotedCommentReplySenderIds_.add(i, collectionsStruct$Int32Value);
    }

    private void addThreadIds(int i, MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureThreadIdsIsMutable();
        this.threadIds_.add(i, messagingStruct$MessageId);
    }

    public static MessagingOuterClass$UpdateMessageDelete parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageDelete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageDelete parseFrom(byte[] bArr) {
        return (MessagingOuterClass$UpdateMessageDelete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$UpdateMessageDelete parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageDelete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageDelete parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateMessageDelete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateMessageDelete parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageDelete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageDelete parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$UpdateMessageDelete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$UpdateMessageDelete parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageDelete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

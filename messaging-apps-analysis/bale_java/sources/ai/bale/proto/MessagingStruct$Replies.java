package ai.bale.proto;

import ai.bale.proto.MessagingStruct$MessageId;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC18084o35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingStruct$Replies extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$Replies DEFAULT_INSTANCE;
    public static final int LAST_MESSAGE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int RECENT_REPLIERS_FIELD_NUMBER = 2;
    public static final int REPLIES_COUNT_FIELD_NUMBER = 1;
    private int bitField0_;
    private MessagingStruct$MessageId lastMessage_;
    private B.j recentRepliers_ = GeneratedMessageLite.emptyProtobufList();
    private int repliesCount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$Replies.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$Replies messagingStruct$Replies = new MessagingStruct$Replies();
        DEFAULT_INSTANCE = messagingStruct$Replies;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$Replies.class, messagingStruct$Replies);
    }

    private MessagingStruct$Replies() {
    }

    private void addAllRecentRepliers(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureRecentRepliersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.recentRepliers_);
    }

    private void addRecentRepliers(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureRecentRepliersIsMutable();
        this.recentRepliers_.add(peersStruct$UserOutPeer);
    }

    private void clearLastMessage() {
        this.lastMessage_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRecentRepliers() {
        this.recentRepliers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearRepliesCount() {
        this.repliesCount_ = 0;
    }

    private void ensureRecentRepliersIsMutable() {
        B.j jVar = this.recentRepliers_;
        if (jVar.u()) {
            return;
        }
        this.recentRepliers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingStruct$Replies getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLastMessage(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        MessagingStruct$MessageId messagingStruct$MessageId2 = this.lastMessage_;
        if (messagingStruct$MessageId2 == null || messagingStruct$MessageId2 == MessagingStruct$MessageId.getDefaultInstance()) {
            this.lastMessage_ = messagingStruct$MessageId;
        } else {
            this.lastMessage_ = (MessagingStruct$MessageId) ((MessagingStruct$MessageId.a) MessagingStruct$MessageId.newBuilder(this.lastMessage_).v(messagingStruct$MessageId)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$Replies parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$Replies) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$Replies parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$Replies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeRecentRepliers(int i) {
        ensureRecentRepliersIsMutable();
        this.recentRepliers_.remove(i);
    }

    private void setLastMessage(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.lastMessage_ = messagingStruct$MessageId;
        this.bitField0_ |= 1;
    }

    private void setRecentRepliers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureRecentRepliersIsMutable();
        this.recentRepliers_.set(i, peersStruct$UserOutPeer);
    }

    private void setRepliesCount(int i) {
        this.repliesCount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$Replies();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0004\u0002\u001b\u0003ဉ\u0000", new Object[]{"bitField0_", "repliesCount_", "recentRepliers_", PeersStruct$UserOutPeer.class, "lastMessage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$Replies.class) {
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

    public MessagingStruct$MessageId getLastMessage() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.lastMessage_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    public PeersStruct$UserOutPeer getRecentRepliers(int i) {
        return (PeersStruct$UserOutPeer) this.recentRepliers_.get(i);
    }

    public int getRecentRepliersCount() {
        return this.recentRepliers_.size();
    }

    public List<PeersStruct$UserOutPeer> getRecentRepliersList() {
        return this.recentRepliers_;
    }

    public InterfaceC18084o35 getRecentRepliersOrBuilder(int i) {
        return (InterfaceC18084o35) this.recentRepliers_.get(i);
    }

    public List<? extends InterfaceC18084o35> getRecentRepliersOrBuilderList() {
        return this.recentRepliers_;
    }

    public int getRepliesCount() {
        return this.repliesCount_;
    }

    public boolean hasLastMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$Replies messagingStruct$Replies) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$Replies);
    }

    public static MessagingStruct$Replies parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$Replies) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$Replies parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$Replies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$Replies parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$Replies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addRecentRepliers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureRecentRepliersIsMutable();
        this.recentRepliers_.add(i, peersStruct$UserOutPeer);
    }

    public static MessagingStruct$Replies parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$Replies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$Replies parseFrom(byte[] bArr) {
        return (MessagingStruct$Replies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$Replies parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$Replies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$Replies parseFrom(InputStream inputStream) {
        return (MessagingStruct$Replies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$Replies parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$Replies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$Replies parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$Replies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$Replies parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$Replies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

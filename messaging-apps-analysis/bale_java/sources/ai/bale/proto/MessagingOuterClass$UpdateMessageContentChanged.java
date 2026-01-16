package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int32Value;
import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.PeersStruct$Peer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$UpdateMessageContentChanged extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 4;
    private static final MessagingOuterClass$UpdateMessageContentChanged DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 9;
    public static final int MESSAGE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int QUOTED_COMMENT_REPLY_SENDER_ID_FIELD_NUMBER = 7;
    public static final int RID_FIELD_NUMBER = 2;
    public static final int THREAD_ID_FIELD_NUMBER = 6;
    public static final int UPDATED_CONTENT_TYPE_MESSAGE_FIELD_NUMBER = 8;
    public static final int UPDATER_USER_ID_FIELD_NUMBER = 5;
    private int bitField0_;
    private CollectionsStruct$Int64Value date_;
    private PeersStruct$ExPeer exPeer_;
    private MessagingStruct$Message message_;
    private PeersStruct$Peer peer_;
    private CollectionsStruct$Int32Value quotedCommentReplySenderId_;
    private long rid_;
    private MessagingStruct$MessageId threadId_;
    private MessagingStruct$Message updatedContentTypeMessage_;
    private Int32Value updaterUserId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$UpdateMessageContentChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$UpdateMessageContentChanged messagingOuterClass$UpdateMessageContentChanged = new MessagingOuterClass$UpdateMessageContentChanged();
        DEFAULT_INSTANCE = messagingOuterClass$UpdateMessageContentChanged;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$UpdateMessageContentChanged.class, messagingOuterClass$UpdateMessageContentChanged);
    }

    private MessagingOuterClass$UpdateMessageContentChanged() {
    }

    private void clearDate() {
        this.date_ = null;
        this.bitField0_ &= -5;
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -129;
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearQuotedCommentReplySenderId() {
        this.quotedCommentReplySenderId_ = null;
        this.bitField0_ &= -33;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearThreadId() {
        this.threadId_ = null;
        this.bitField0_ &= -17;
    }

    private void clearUpdatedContentTypeMessage() {
        this.updatedContentTypeMessage_ = null;
        this.bitField0_ &= -65;
    }

    private void clearUpdaterUserId() {
        this.updaterUserId_ = null;
        this.bitField0_ &= -9;
    }

    public static MessagingOuterClass$UpdateMessageContentChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.date_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.date_ = collectionsStruct$Int64Value;
        } else {
            this.date_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.date_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.exPeer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.exPeer_ = peersStruct$ExPeer;
        } else {
            this.exPeer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.exPeer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 128;
    }

    private void mergeMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        MessagingStruct$Message messagingStruct$Message2 = this.message_;
        if (messagingStruct$Message2 == null || messagingStruct$Message2 == MessagingStruct$Message.getDefaultInstance()) {
            this.message_ = messagingStruct$Message;
        } else {
            this.message_ = (MessagingStruct$Message) ((MessagingStruct$Message.a) MessagingStruct$Message.newBuilder(this.message_).v(messagingStruct$Message)).j();
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

    private void mergeQuotedCommentReplySenderId(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        CollectionsStruct$Int32Value collectionsStruct$Int32Value2 = this.quotedCommentReplySenderId_;
        if (collectionsStruct$Int32Value2 == null || collectionsStruct$Int32Value2 == CollectionsStruct$Int32Value.getDefaultInstance()) {
            this.quotedCommentReplySenderId_ = collectionsStruct$Int32Value;
        } else {
            this.quotedCommentReplySenderId_ = (CollectionsStruct$Int32Value) ((CollectionsStruct$Int32Value.a) CollectionsStruct$Int32Value.newBuilder(this.quotedCommentReplySenderId_).v(collectionsStruct$Int32Value)).j();
        }
        this.bitField0_ |= 32;
    }

    private void mergeThreadId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        MessagingStruct$MessageId messagingStruct$MessageId2 = this.threadId_;
        if (messagingStruct$MessageId2 == null || messagingStruct$MessageId2 == MessagingStruct$MessageId.getDefaultInstance()) {
            this.threadId_ = messagingStruct$MessageId;
        } else {
            this.threadId_ = (MessagingStruct$MessageId) ((MessagingStruct$MessageId.a) MessagingStruct$MessageId.newBuilder(this.threadId_).v(messagingStruct$MessageId)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeUpdatedContentTypeMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        MessagingStruct$Message messagingStruct$Message2 = this.updatedContentTypeMessage_;
        if (messagingStruct$Message2 == null || messagingStruct$Message2 == MessagingStruct$Message.getDefaultInstance()) {
            this.updatedContentTypeMessage_ = messagingStruct$Message;
        } else {
            this.updatedContentTypeMessage_ = (MessagingStruct$Message) ((MessagingStruct$Message.a) MessagingStruct$Message.newBuilder(this.updatedContentTypeMessage_).v(messagingStruct$Message)).j();
        }
        this.bitField0_ |= 64;
    }

    private void mergeUpdaterUserId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.updaterUserId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.updaterUserId_ = int32Value;
        } else {
            this.updaterUserId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.updaterUserId_).v(int32Value)).j();
        }
        this.bitField0_ |= 8;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$UpdateMessageContentChanged parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateMessageContentChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateMessageContentChanged parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$UpdateMessageContentChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.date_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 4;
    }

    private void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 128;
    }

    private void setMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.message_ = messagingStruct$Message;
        this.bitField0_ |= 2;
    }

    private void setPeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        this.peer_ = peersStruct$Peer;
        this.bitField0_ |= 1;
    }

    private void setQuotedCommentReplySenderId(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        this.quotedCommentReplySenderId_ = collectionsStruct$Int32Value;
        this.bitField0_ |= 32;
    }

    private void setRid(long j) {
        this.rid_ = j;
    }

    private void setThreadId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.threadId_ = messagingStruct$MessageId;
        this.bitField0_ |= 16;
    }

    private void setUpdatedContentTypeMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.updatedContentTypeMessage_ = messagingStruct$Message;
        this.bitField0_ |= 64;
    }

    private void setUpdaterUserId(Int32Value int32Value) {
        int32Value.getClass();
        this.updaterUserId_ = int32Value;
        this.bitField0_ |= 8;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$UpdateMessageContentChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003ဉ\u0001\u0004ဉ\u0002\u0005ဉ\u0003\u0006ဉ\u0004\u0007ဉ\u0005\bဉ\u0006\tဉ\u0007", new Object[]{"bitField0_", "peer_", "rid_", "message_", "date_", "updaterUserId_", "threadId_", "quotedCommentReplySenderId_", "updatedContentTypeMessage_", "exPeer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$UpdateMessageContentChanged.class) {
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

    public CollectionsStruct$Int64Value getDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.date_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public MessagingStruct$Message getMessage() {
        MessagingStruct$Message messagingStruct$Message = this.message_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public PeersStruct$Peer getPeer() {
        PeersStruct$Peer peersStruct$Peer = this.peer_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public CollectionsStruct$Int32Value getQuotedCommentReplySenderId() {
        CollectionsStruct$Int32Value collectionsStruct$Int32Value = this.quotedCommentReplySenderId_;
        return collectionsStruct$Int32Value == null ? CollectionsStruct$Int32Value.getDefaultInstance() : collectionsStruct$Int32Value;
    }

    public long getRid() {
        return this.rid_;
    }

    public MessagingStruct$MessageId getThreadId() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.threadId_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    public MessagingStruct$Message getUpdatedContentTypeMessage() {
        MessagingStruct$Message messagingStruct$Message = this.updatedContentTypeMessage_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public Int32Value getUpdaterUserId() {
        Int32Value int32Value = this.updaterUserId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public boolean hasDate() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasQuotedCommentReplySenderId() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasThreadId() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasUpdatedContentTypeMessage() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasUpdaterUserId() {
        return (this.bitField0_ & 8) != 0;
    }

    public static a newBuilder(MessagingOuterClass$UpdateMessageContentChanged messagingOuterClass$UpdateMessageContentChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$UpdateMessageContentChanged);
    }

    public static MessagingOuterClass$UpdateMessageContentChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageContentChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageContentChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageContentChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageContentChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$UpdateMessageContentChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$UpdateMessageContentChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageContentChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageContentChanged parseFrom(byte[] bArr) {
        return (MessagingOuterClass$UpdateMessageContentChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$UpdateMessageContentChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageContentChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageContentChanged parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateMessageContentChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateMessageContentChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageContentChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateMessageContentChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$UpdateMessageContentChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$UpdateMessageContentChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessageContentChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

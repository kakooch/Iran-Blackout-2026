package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$MessageAttributes;
import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.MessagingStruct$QuotedMessage;
import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.PeersStruct$Peer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$UpdateMessage extends GeneratedMessageLite implements U64 {
    public static final int ATTRIBUTES_FIELD_NUMBER = 6;
    public static final int DATE_FIELD_NUMBER = 3;
    private static final MessagingOuterClass$UpdateMessage DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 14;
    public static final int GROUPED_ID_FIELD_NUMBER = 10;
    public static final int HAS_COMMENT_FIELD_NUMBER = 12;
    public static final int IS_SILENT_FIELD_NUMBER = 11;
    public static final int MESSAGE_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int PREVIOUS_MESSAGE_ID_FIELD_NUMBER = 9;
    public static final int QUOTED_MESSAGE_FIELD_NUMBER = 7;
    public static final int RID_FIELD_NUMBER = 4;
    public static final int SENDER_UID_FIELD_NUMBER = 2;
    public static final int THREAD_ID_FIELD_NUMBER = 13;
    private MessagingStruct$MessageAttributes attributes_;
    private int bitField0_;
    private long date_;
    private PeersStruct$ExPeer exPeer_;
    private CollectionsStruct$Int64Value groupedId_;
    private boolean hasComment_;
    private boolean isSilent_;
    private MessagingStruct$Message message_;
    private PeersStruct$Peer peer_;
    private MessagingStruct$MessageId previousMessageId_;
    private MessagingStruct$QuotedMessage quotedMessage_;
    private long rid_;
    private int senderUid_;
    private MessagingStruct$MessageId threadId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$UpdateMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$UpdateMessage messagingOuterClass$UpdateMessage = new MessagingOuterClass$UpdateMessage();
        DEFAULT_INSTANCE = messagingOuterClass$UpdateMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$UpdateMessage.class, messagingOuterClass$UpdateMessage);
    }

    private MessagingOuterClass$UpdateMessage() {
    }

    private void clearAttributes() {
        this.attributes_ = null;
        this.bitField0_ &= -5;
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -129;
    }

    private void clearGroupedId() {
        this.groupedId_ = null;
        this.bitField0_ &= -33;
    }

    private void clearHasComment() {
        this.hasComment_ = false;
    }

    private void clearIsSilent() {
        this.isSilent_ = false;
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPreviousMessageId() {
        this.previousMessageId_ = null;
        this.bitField0_ &= -17;
    }

    private void clearQuotedMessage() {
        this.quotedMessage_ = null;
        this.bitField0_ &= -9;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearSenderUid() {
        this.senderUid_ = 0;
    }

    private void clearThreadId() {
        this.threadId_ = null;
        this.bitField0_ &= -65;
    }

    public static MessagingOuterClass$UpdateMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAttributes(MessagingStruct$MessageAttributes messagingStruct$MessageAttributes) {
        messagingStruct$MessageAttributes.getClass();
        MessagingStruct$MessageAttributes messagingStruct$MessageAttributes2 = this.attributes_;
        if (messagingStruct$MessageAttributes2 == null || messagingStruct$MessageAttributes2 == MessagingStruct$MessageAttributes.getDefaultInstance()) {
            this.attributes_ = messagingStruct$MessageAttributes;
        } else {
            this.attributes_ = (MessagingStruct$MessageAttributes) ((MessagingStruct$MessageAttributes.a) MessagingStruct$MessageAttributes.newBuilder(this.attributes_).v(messagingStruct$MessageAttributes)).j();
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

    private void mergeGroupedId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.groupedId_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.groupedId_ = collectionsStruct$Int64Value;
        } else {
            this.groupedId_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.groupedId_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 32;
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

    private void mergePreviousMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        MessagingStruct$MessageId messagingStruct$MessageId2 = this.previousMessageId_;
        if (messagingStruct$MessageId2 == null || messagingStruct$MessageId2 == MessagingStruct$MessageId.getDefaultInstance()) {
            this.previousMessageId_ = messagingStruct$MessageId;
        } else {
            this.previousMessageId_ = (MessagingStruct$MessageId) ((MessagingStruct$MessageId.a) MessagingStruct$MessageId.newBuilder(this.previousMessageId_).v(messagingStruct$MessageId)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeQuotedMessage(MessagingStruct$QuotedMessage messagingStruct$QuotedMessage) {
        messagingStruct$QuotedMessage.getClass();
        MessagingStruct$QuotedMessage messagingStruct$QuotedMessage2 = this.quotedMessage_;
        if (messagingStruct$QuotedMessage2 == null || messagingStruct$QuotedMessage2 == MessagingStruct$QuotedMessage.getDefaultInstance()) {
            this.quotedMessage_ = messagingStruct$QuotedMessage;
        } else {
            this.quotedMessage_ = (MessagingStruct$QuotedMessage) ((MessagingStruct$QuotedMessage.a) MessagingStruct$QuotedMessage.newBuilder(this.quotedMessage_).v(messagingStruct$QuotedMessage)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeThreadId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        MessagingStruct$MessageId messagingStruct$MessageId2 = this.threadId_;
        if (messagingStruct$MessageId2 == null || messagingStruct$MessageId2 == MessagingStruct$MessageId.getDefaultInstance()) {
            this.threadId_ = messagingStruct$MessageId;
        } else {
            this.threadId_ = (MessagingStruct$MessageId) ((MessagingStruct$MessageId.a) MessagingStruct$MessageId.newBuilder(this.threadId_).v(messagingStruct$MessageId)).j();
        }
        this.bitField0_ |= 64;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$UpdateMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$UpdateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAttributes(MessagingStruct$MessageAttributes messagingStruct$MessageAttributes) {
        messagingStruct$MessageAttributes.getClass();
        this.attributes_ = messagingStruct$MessageAttributes;
        this.bitField0_ |= 4;
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 128;
    }

    private void setGroupedId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.groupedId_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 32;
    }

    private void setHasComment(boolean z) {
        this.hasComment_ = z;
    }

    private void setIsSilent(boolean z) {
        this.isSilent_ = z;
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

    private void setPreviousMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.previousMessageId_ = messagingStruct$MessageId;
        this.bitField0_ |= 16;
    }

    private void setQuotedMessage(MessagingStruct$QuotedMessage messagingStruct$QuotedMessage) {
        messagingStruct$QuotedMessage.getClass();
        this.quotedMessage_ = messagingStruct$QuotedMessage;
        this.bitField0_ |= 8;
    }

    private void setRid(long j) {
        this.rid_ = j;
    }

    private void setSenderUid(int i) {
        this.senderUid_ = i;
    }

    private void setThreadId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.threadId_ = messagingStruct$MessageId;
        this.bitField0_ |= 64;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$UpdateMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\r\u0000\u0001\u0001\u000e\r\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004\u0003\u0002\u0004\u0002\u0005ဉ\u0001\u0006ဉ\u0002\u0007ဉ\u0003\tဉ\u0004\nဉ\u0005\u000b\u0007\f\u0007\rဉ\u0006\u000eဉ\u0007", new Object[]{"bitField0_", "peer_", "senderUid_", "date_", "rid_", "message_", "attributes_", "quotedMessage_", "previousMessageId_", "groupedId_", "isSilent_", "hasComment_", "threadId_", "exPeer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$UpdateMessage.class) {
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

    @Deprecated
    public MessagingStruct$MessageAttributes getAttributes() {
        MessagingStruct$MessageAttributes messagingStruct$MessageAttributes = this.attributes_;
        return messagingStruct$MessageAttributes == null ? MessagingStruct$MessageAttributes.getDefaultInstance() : messagingStruct$MessageAttributes;
    }

    public long getDate() {
        return this.date_;
    }

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public CollectionsStruct$Int64Value getGroupedId() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.groupedId_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public boolean getHasComment() {
        return this.hasComment_;
    }

    public boolean getIsSilent() {
        return this.isSilent_;
    }

    public MessagingStruct$Message getMessage() {
        MessagingStruct$Message messagingStruct$Message = this.message_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public PeersStruct$Peer getPeer() {
        PeersStruct$Peer peersStruct$Peer = this.peer_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public MessagingStruct$MessageId getPreviousMessageId() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.previousMessageId_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    public MessagingStruct$QuotedMessage getQuotedMessage() {
        MessagingStruct$QuotedMessage messagingStruct$QuotedMessage = this.quotedMessage_;
        return messagingStruct$QuotedMessage == null ? MessagingStruct$QuotedMessage.getDefaultInstance() : messagingStruct$QuotedMessage;
    }

    public long getRid() {
        return this.rid_;
    }

    public int getSenderUid() {
        return this.senderUid_;
    }

    public MessagingStruct$MessageId getThreadId() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.threadId_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    @Deprecated
    public boolean hasAttributes() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasGroupedId() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPreviousMessageId() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasQuotedMessage() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasThreadId() {
        return (this.bitField0_ & 64) != 0;
    }

    public static a newBuilder(MessagingOuterClass$UpdateMessage messagingOuterClass$UpdateMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$UpdateMessage);
    }

    public static MessagingOuterClass$UpdateMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$UpdateMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$UpdateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$UpdateMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$UpdateMessage parseFrom(byte[] bArr) {
        return (MessagingOuterClass$UpdateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$UpdateMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$UpdateMessage parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$UpdateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$UpdateMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

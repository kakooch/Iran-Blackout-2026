package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$MessageAttributes;
import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.MessagingStruct$QuotedMessage;
import ai.bale.proto.MessagingStruct$Replies;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.EnumC16043kc4;
import ir.nasim.InterfaceC11027cc4;
import ir.nasim.InterfaceC15452jc4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingStruct$MessageContainer extends GeneratedMessageLite implements InterfaceC11027cc4 {
    public static final int ATTRIBUTE_FIELD_NUMBER = 7;
    public static final int DATE_FIELD_NUMBER = 3;
    private static final MessagingStruct$MessageContainer DEFAULT_INSTANCE;
    public static final int EDITED_AT_FIELD_NUMBER = 12;
    public static final int EDITOR_USER_ID_FIELD_NUMBER = 13;
    public static final int GROUPED_ID_FIELD_NUMBER = 14;
    public static final int HAS_COMMENT_FIELD_NUMBER = 15;
    public static final int MESSAGE_FIELD_NUMBER = 4;
    public static final int NEXT_MESSAGE_ID_FIELD_NUMBER = 11;
    private static volatile KW4 PARSER = null;
    public static final int PREVIOUS_MESSAGE_ID_FIELD_NUMBER = 10;
    public static final int QUOTED_MESSAGE_FIELD_NUMBER = 8;
    public static final int REACTIONS_FIELD_NUMBER = 6;
    public static final int REPLIES_FIELD_NUMBER = 16;
    public static final int REPLY_TO_TOP_ID_FIELD_NUMBER = 17;
    public static final int RID_FIELD_NUMBER = 2;
    public static final int SENDER_UID_FIELD_NUMBER = 1;
    public static final int SEQ_FIELD_NUMBER = 9;
    public static final int STATE_FIELD_NUMBER = 5;
    private MessagingStruct$MessageAttributes attribute_;
    private int bitField0_;
    private long date_;
    private CollectionsStruct$Int64Value editedAt_;
    private Int32Value editorUserId_;
    private CollectionsStruct$Int64Value groupedId_;
    private BoolValue hasComment_;
    private MessagingStruct$Message message_;
    private MessagingStruct$MessageId nextMessageId_;
    private MessagingStruct$MessageId previousMessageId_;
    private MessagingStruct$QuotedMessage quotedMessage_;
    private B.j reactions_ = GeneratedMessageLite.emptyProtobufList();
    private MessagingStruct$Replies replies_;
    private MessagingStruct$MessageId replyToTopId_;
    private long rid_;
    private int senderUid_;
    private CollectionsStruct$Int64Value seq_;
    private int state_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC11027cc4 {
        public a A(long j) {
            q();
            ((MessagingStruct$MessageContainer) this.b).setDate(j);
            return this;
        }

        public a B(MessagingStruct$Message messagingStruct$Message) {
            q();
            ((MessagingStruct$MessageContainer) this.b).setMessage(messagingStruct$Message);
            return this;
        }

        public a C(long j) {
            q();
            ((MessagingStruct$MessageContainer) this.b).setRid(j);
            return this;
        }

        public a D(int i) {
            q();
            ((MessagingStruct$MessageContainer) this.b).setSenderUid(i);
            return this;
        }

        private a() {
            super(MessagingStruct$MessageContainer.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$MessageContainer messagingStruct$MessageContainer = new MessagingStruct$MessageContainer();
        DEFAULT_INSTANCE = messagingStruct$MessageContainer;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$MessageContainer.class, messagingStruct$MessageContainer);
    }

    private MessagingStruct$MessageContainer() {
    }

    private void addAllReactions(Iterable<? extends MessagingStruct$MessageReaction> iterable) {
        ensureReactionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.reactions_);
    }

    private void addReactions(MessagingStruct$MessageReaction messagingStruct$MessageReaction) {
        messagingStruct$MessageReaction.getClass();
        ensureReactionsIsMutable();
        this.reactions_.add(messagingStruct$MessageReaction);
    }

    private void clearAttribute() {
        this.attribute_ = null;
        this.bitField0_ &= -3;
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearEditedAt() {
        this.editedAt_ = null;
        this.bitField0_ &= -65;
    }

    private void clearEditorUserId() {
        this.editorUserId_ = null;
        this.bitField0_ &= -129;
    }

    private void clearGroupedId() {
        this.groupedId_ = null;
        this.bitField0_ &= -257;
    }

    private void clearHasComment() {
        this.hasComment_ = null;
        this.bitField0_ &= -513;
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -2;
    }

    private void clearNextMessageId() {
        this.nextMessageId_ = null;
        this.bitField0_ &= -33;
    }

    private void clearPreviousMessageId() {
        this.previousMessageId_ = null;
        this.bitField0_ &= -17;
    }

    private void clearQuotedMessage() {
        this.quotedMessage_ = null;
        this.bitField0_ &= -5;
    }

    private void clearReactions() {
        this.reactions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearReplies() {
        this.replies_ = null;
        this.bitField0_ &= -1025;
    }

    private void clearReplyToTopId() {
        this.replyToTopId_ = null;
        this.bitField0_ &= -2049;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearSenderUid() {
        this.senderUid_ = 0;
    }

    private void clearSeq() {
        this.seq_ = null;
        this.bitField0_ &= -9;
    }

    private void clearState() {
        this.state_ = 0;
    }

    private void ensureReactionsIsMutable() {
        B.j jVar = this.reactions_;
        if (jVar.u()) {
            return;
        }
        this.reactions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingStruct$MessageContainer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAttribute(MessagingStruct$MessageAttributes messagingStruct$MessageAttributes) {
        messagingStruct$MessageAttributes.getClass();
        MessagingStruct$MessageAttributes messagingStruct$MessageAttributes2 = this.attribute_;
        if (messagingStruct$MessageAttributes2 == null || messagingStruct$MessageAttributes2 == MessagingStruct$MessageAttributes.getDefaultInstance()) {
            this.attribute_ = messagingStruct$MessageAttributes;
        } else {
            this.attribute_ = (MessagingStruct$MessageAttributes) ((MessagingStruct$MessageAttributes.a) MessagingStruct$MessageAttributes.newBuilder(this.attribute_).v(messagingStruct$MessageAttributes)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeEditedAt(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.editedAt_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.editedAt_ = collectionsStruct$Int64Value;
        } else {
            this.editedAt_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.editedAt_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 64;
    }

    private void mergeEditorUserId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.editorUserId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.editorUserId_ = int32Value;
        } else {
            this.editorUserId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.editorUserId_).v(int32Value)).j();
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
        this.bitField0_ |= 256;
    }

    private void mergeHasComment(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.hasComment_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.hasComment_ = boolValue;
        } else {
            this.hasComment_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.hasComment_).v(boolValue)).j();
        }
        this.bitField0_ |= 512;
    }

    private void mergeMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        MessagingStruct$Message messagingStruct$Message2 = this.message_;
        if (messagingStruct$Message2 == null || messagingStruct$Message2 == MessagingStruct$Message.getDefaultInstance()) {
            this.message_ = messagingStruct$Message;
        } else {
            this.message_ = (MessagingStruct$Message) ((MessagingStruct$Message.a) MessagingStruct$Message.newBuilder(this.message_).v(messagingStruct$Message)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeNextMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        MessagingStruct$MessageId messagingStruct$MessageId2 = this.nextMessageId_;
        if (messagingStruct$MessageId2 == null || messagingStruct$MessageId2 == MessagingStruct$MessageId.getDefaultInstance()) {
            this.nextMessageId_ = messagingStruct$MessageId;
        } else {
            this.nextMessageId_ = (MessagingStruct$MessageId) ((MessagingStruct$MessageId.a) MessagingStruct$MessageId.newBuilder(this.nextMessageId_).v(messagingStruct$MessageId)).j();
        }
        this.bitField0_ |= 32;
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
        this.bitField0_ |= 4;
    }

    private void mergeReplies(MessagingStruct$Replies messagingStruct$Replies) {
        messagingStruct$Replies.getClass();
        MessagingStruct$Replies messagingStruct$Replies2 = this.replies_;
        if (messagingStruct$Replies2 == null || messagingStruct$Replies2 == MessagingStruct$Replies.getDefaultInstance()) {
            this.replies_ = messagingStruct$Replies;
        } else {
            this.replies_ = (MessagingStruct$Replies) ((MessagingStruct$Replies.a) MessagingStruct$Replies.newBuilder(this.replies_).v(messagingStruct$Replies)).j();
        }
        this.bitField0_ |= 1024;
    }

    private void mergeReplyToTopId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        MessagingStruct$MessageId messagingStruct$MessageId2 = this.replyToTopId_;
        if (messagingStruct$MessageId2 == null || messagingStruct$MessageId2 == MessagingStruct$MessageId.getDefaultInstance()) {
            this.replyToTopId_ = messagingStruct$MessageId;
        } else {
            this.replyToTopId_ = (MessagingStruct$MessageId) ((MessagingStruct$MessageId.a) MessagingStruct$MessageId.newBuilder(this.replyToTopId_).v(messagingStruct$MessageId)).j();
        }
        this.bitField0_ |= 2048;
    }

    private void mergeSeq(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.seq_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.seq_ = collectionsStruct$Int64Value;
        } else {
            this.seq_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.seq_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 8;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$MessageContainer parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$MessageContainer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$MessageContainer parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$MessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeReactions(int i) {
        ensureReactionsIsMutable();
        this.reactions_.remove(i);
    }

    private void setAttribute(MessagingStruct$MessageAttributes messagingStruct$MessageAttributes) {
        messagingStruct$MessageAttributes.getClass();
        this.attribute_ = messagingStruct$MessageAttributes;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(long j) {
        this.date_ = j;
    }

    private void setEditedAt(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.editedAt_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 64;
    }

    private void setEditorUserId(Int32Value int32Value) {
        int32Value.getClass();
        this.editorUserId_ = int32Value;
        this.bitField0_ |= 128;
    }

    private void setGroupedId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.groupedId_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 256;
    }

    private void setHasComment(BoolValue boolValue) {
        boolValue.getClass();
        this.hasComment_ = boolValue;
        this.bitField0_ |= 512;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.message_ = messagingStruct$Message;
        this.bitField0_ |= 1;
    }

    private void setNextMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.nextMessageId_ = messagingStruct$MessageId;
        this.bitField0_ |= 32;
    }

    private void setPreviousMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.previousMessageId_ = messagingStruct$MessageId;
        this.bitField0_ |= 16;
    }

    private void setQuotedMessage(MessagingStruct$QuotedMessage messagingStruct$QuotedMessage) {
        messagingStruct$QuotedMessage.getClass();
        this.quotedMessage_ = messagingStruct$QuotedMessage;
        this.bitField0_ |= 4;
    }

    private void setReactions(int i, MessagingStruct$MessageReaction messagingStruct$MessageReaction) {
        messagingStruct$MessageReaction.getClass();
        ensureReactionsIsMutable();
        this.reactions_.set(i, messagingStruct$MessageReaction);
    }

    private void setReplies(MessagingStruct$Replies messagingStruct$Replies) {
        messagingStruct$Replies.getClass();
        this.replies_ = messagingStruct$Replies;
        this.bitField0_ |= 1024;
    }

    private void setReplyToTopId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.replyToTopId_ = messagingStruct$MessageId;
        this.bitField0_ |= 2048;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRid(long j) {
        this.rid_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSenderUid(int i) {
        this.senderUid_ = i;
    }

    private void setSeq(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.seq_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 8;
    }

    private void setState(EnumC16043kc4 enumC16043kc4) {
        this.state_ = enumC16043kc4.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$MessageContainer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0011\u0000\u0001\u0001\u0011\u0011\u0000\u0001\u0000\u0001\u0004\u0002\u0002\u0003\u0002\u0004ဉ\u0000\u0005\f\u0006\u001b\u0007ဉ\u0001\bဉ\u0002\tဉ\u0003\nဉ\u0004\u000bဉ\u0005\fဉ\u0006\rဉ\u0007\u000eဉ\b\u000fဉ\t\u0010ဉ\n\u0011ဉ\u000b", new Object[]{"bitField0_", "senderUid_", "rid_", "date_", "message_", "state_", "reactions_", MessagingStruct$MessageReaction.class, "attribute_", "quotedMessage_", "seq_", "previousMessageId_", "nextMessageId_", "editedAt_", "editorUserId_", "groupedId_", "hasComment_", "replies_", "replyToTopId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$MessageContainer.class) {
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
    public MessagingStruct$MessageAttributes getAttribute() {
        MessagingStruct$MessageAttributes messagingStruct$MessageAttributes = this.attribute_;
        return messagingStruct$MessageAttributes == null ? MessagingStruct$MessageAttributes.getDefaultInstance() : messagingStruct$MessageAttributes;
    }

    public long getDate() {
        return this.date_;
    }

    public CollectionsStruct$Int64Value getEditedAt() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.editedAt_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public Int32Value getEditorUserId() {
        Int32Value int32Value = this.editorUserId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public CollectionsStruct$Int64Value getGroupedId() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.groupedId_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public BoolValue getHasComment() {
        BoolValue boolValue = this.hasComment_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public MessagingStruct$Message getMessage() {
        MessagingStruct$Message messagingStruct$Message = this.message_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public MessagingStruct$MessageId getNextMessageId() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.nextMessageId_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    public MessagingStruct$MessageId getPreviousMessageId() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.previousMessageId_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    public MessagingStruct$QuotedMessage getQuotedMessage() {
        MessagingStruct$QuotedMessage messagingStruct$QuotedMessage = this.quotedMessage_;
        return messagingStruct$QuotedMessage == null ? MessagingStruct$QuotedMessage.getDefaultInstance() : messagingStruct$QuotedMessage;
    }

    public MessagingStruct$MessageReaction getReactions(int i) {
        return (MessagingStruct$MessageReaction) this.reactions_.get(i);
    }

    public int getReactionsCount() {
        return this.reactions_.size();
    }

    public List<MessagingStruct$MessageReaction> getReactionsList() {
        return this.reactions_;
    }

    public InterfaceC15452jc4 getReactionsOrBuilder(int i) {
        return (InterfaceC15452jc4) this.reactions_.get(i);
    }

    public List<? extends InterfaceC15452jc4> getReactionsOrBuilderList() {
        return this.reactions_;
    }

    public MessagingStruct$Replies getReplies() {
        MessagingStruct$Replies messagingStruct$Replies = this.replies_;
        return messagingStruct$Replies == null ? MessagingStruct$Replies.getDefaultInstance() : messagingStruct$Replies;
    }

    public MessagingStruct$MessageId getReplyToTopId() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.replyToTopId_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    public long getRid() {
        return this.rid_;
    }

    public int getSenderUid() {
        return this.senderUid_;
    }

    public CollectionsStruct$Int64Value getSeq() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.seq_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public EnumC16043kc4 getState() {
        EnumC16043kc4 enumC16043kc4J = EnumC16043kc4.j(this.state_);
        return enumC16043kc4J == null ? EnumC16043kc4.UNRECOGNIZED : enumC16043kc4J;
    }

    public int getStateValue() {
        return this.state_;
    }

    @Deprecated
    public boolean hasAttribute() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasEditedAt() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasEditorUserId() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasGroupedId() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasHasComment() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasNextMessageId() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasPreviousMessageId() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasQuotedMessage() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasReplies() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasReplyToTopId() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasSeq() {
        return (this.bitField0_ & 8) != 0;
    }

    public static a newBuilder(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$MessageContainer);
    }

    public static MessagingStruct$MessageContainer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$MessageContainer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$MessageContainer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$MessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$MessageContainer parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$MessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addReactions(int i, MessagingStruct$MessageReaction messagingStruct$MessageReaction) {
        messagingStruct$MessageReaction.getClass();
        ensureReactionsIsMutable();
        this.reactions_.add(i, messagingStruct$MessageReaction);
    }

    public static MessagingStruct$MessageContainer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$MessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$MessageContainer parseFrom(byte[] bArr) {
        return (MessagingStruct$MessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$MessageContainer parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$MessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$MessageContainer parseFrom(InputStream inputStream) {
        return (MessagingStruct$MessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$MessageContainer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$MessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$MessageContainer parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$MessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$MessageContainer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$MessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

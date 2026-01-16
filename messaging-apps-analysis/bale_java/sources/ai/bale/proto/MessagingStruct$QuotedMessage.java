package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$StoryReference;
import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.InterfaceC4916Hc4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$QuotedMessage extends GeneratedMessageLite implements InterfaceC4916Hc4 {
    private static final MessagingStruct$QuotedMessage DEFAULT_INSTANCE;
    public static final int MESSAGE_DATE_FIELD_NUMBER = 4;
    public static final int MESSAGE_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PUBLIC_GROUP_ID_FIELD_NUMBER = 2;
    public static final int QUOTED_MESSAGE_CONTENT_FIELD_NUMBER = 5;
    public static final int QUOTED_PEER_FIELD_NUMBER = 6;
    public static final int SENDER_USER_ID_FIELD_NUMBER = 3;
    public static final int STORY_FIELD_NUMBER = 8;
    private int bitField0_;
    private long messageDate_;
    private CollectionsStruct$Int64Value messageId_;
    private Int32Value publicGroupId_;
    private MessagingStruct$Message quotedMessageContent_;
    private PeersStruct$OutPeer quotedPeer_;
    private int senderUserId_;
    private MessagingStruct$StoryReference story_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC4916Hc4 {
        private a() {
            super(MessagingStruct$QuotedMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$QuotedMessage messagingStruct$QuotedMessage = new MessagingStruct$QuotedMessage();
        DEFAULT_INSTANCE = messagingStruct$QuotedMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$QuotedMessage.class, messagingStruct$QuotedMessage);
    }

    private MessagingStruct$QuotedMessage() {
    }

    private void clearMessageDate() {
        this.messageDate_ = 0L;
    }

    private void clearMessageId() {
        this.messageId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPublicGroupId() {
        this.publicGroupId_ = null;
        this.bitField0_ &= -3;
    }

    private void clearQuotedMessageContent() {
        this.quotedMessageContent_ = null;
        this.bitField0_ &= -5;
    }

    private void clearQuotedPeer() {
        this.quotedPeer_ = null;
        this.bitField0_ &= -9;
    }

    private void clearSenderUserId() {
        this.senderUserId_ = 0;
    }

    private void clearStory() {
        this.story_ = null;
        this.bitField0_ &= -17;
    }

    public static MessagingStruct$QuotedMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMessageId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.messageId_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.messageId_ = collectionsStruct$Int64Value;
        } else {
            this.messageId_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.messageId_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergePublicGroupId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.publicGroupId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.publicGroupId_ = int32Value;
        } else {
            this.publicGroupId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.publicGroupId_).v(int32Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeQuotedMessageContent(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        MessagingStruct$Message messagingStruct$Message2 = this.quotedMessageContent_;
        if (messagingStruct$Message2 == null || messagingStruct$Message2 == MessagingStruct$Message.getDefaultInstance()) {
            this.quotedMessageContent_ = messagingStruct$Message;
        } else {
            this.quotedMessageContent_ = (MessagingStruct$Message) ((MessagingStruct$Message.a) MessagingStruct$Message.newBuilder(this.quotedMessageContent_).v(messagingStruct$Message)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeQuotedPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        PeersStruct$OutPeer peersStruct$OutPeer2 = this.quotedPeer_;
        if (peersStruct$OutPeer2 == null || peersStruct$OutPeer2 == PeersStruct$OutPeer.getDefaultInstance()) {
            this.quotedPeer_ = peersStruct$OutPeer;
        } else {
            this.quotedPeer_ = (PeersStruct$OutPeer) ((PeersStruct$OutPeer.a) PeersStruct$OutPeer.newBuilder(this.quotedPeer_).v(peersStruct$OutPeer)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeStory(MessagingStruct$StoryReference messagingStruct$StoryReference) {
        messagingStruct$StoryReference.getClass();
        MessagingStruct$StoryReference messagingStruct$StoryReference2 = this.story_;
        if (messagingStruct$StoryReference2 == null || messagingStruct$StoryReference2 == MessagingStruct$StoryReference.getDefaultInstance()) {
            this.story_ = messagingStruct$StoryReference;
        } else {
            this.story_ = (MessagingStruct$StoryReference) ((MessagingStruct$StoryReference.a) MessagingStruct$StoryReference.newBuilder(this.story_).v(messagingStruct$StoryReference)).j();
        }
        this.bitField0_ |= 16;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$QuotedMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$QuotedMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$QuotedMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$QuotedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMessageDate(long j) {
        this.messageDate_ = j;
    }

    private void setMessageId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.messageId_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 1;
    }

    private void setPublicGroupId(Int32Value int32Value) {
        int32Value.getClass();
        this.publicGroupId_ = int32Value;
        this.bitField0_ |= 2;
    }

    private void setQuotedMessageContent(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.quotedMessageContent_ = messagingStruct$Message;
        this.bitField0_ |= 4;
    }

    private void setQuotedPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.quotedPeer_ = peersStruct$OutPeer;
        this.bitField0_ |= 8;
    }

    private void setSenderUserId(int i) {
        this.senderUserId_ = i;
    }

    private void setStory(MessagingStruct$StoryReference messagingStruct$StoryReference) {
        messagingStruct$StoryReference.getClass();
        this.story_ = messagingStruct$StoryReference;
        this.bitField0_ |= 16;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$QuotedMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\b\u0007\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u0004\u0004\u0002\u0005ဉ\u0002\u0006ဉ\u0003\bဉ\u0004", new Object[]{"bitField0_", "messageId_", "publicGroupId_", "senderUserId_", "messageDate_", "quotedMessageContent_", "quotedPeer_", "story_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$QuotedMessage.class) {
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

    public long getMessageDate() {
        return this.messageDate_;
    }

    public CollectionsStruct$Int64Value getMessageId() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.messageId_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public Int32Value getPublicGroupId() {
        Int32Value int32Value = this.publicGroupId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public MessagingStruct$Message getQuotedMessageContent() {
        MessagingStruct$Message messagingStruct$Message = this.quotedMessageContent_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public PeersStruct$OutPeer getQuotedPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.quotedPeer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public int getSenderUserId() {
        return this.senderUserId_;
    }

    public MessagingStruct$StoryReference getStory() {
        MessagingStruct$StoryReference messagingStruct$StoryReference = this.story_;
        return messagingStruct$StoryReference == null ? MessagingStruct$StoryReference.getDefaultInstance() : messagingStruct$StoryReference;
    }

    public boolean hasMessageId() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPublicGroupId() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasQuotedMessageContent() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasQuotedPeer() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasStory() {
        return (this.bitField0_ & 16) != 0;
    }

    public static a newBuilder(MessagingStruct$QuotedMessage messagingStruct$QuotedMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$QuotedMessage);
    }

    public static MessagingStruct$QuotedMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$QuotedMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$QuotedMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$QuotedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$QuotedMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$QuotedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$QuotedMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$QuotedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$QuotedMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$QuotedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$QuotedMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$QuotedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$QuotedMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$QuotedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$QuotedMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$QuotedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$QuotedMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$QuotedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$QuotedMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$QuotedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

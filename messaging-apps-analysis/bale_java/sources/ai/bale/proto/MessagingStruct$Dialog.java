package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$MessageAttributes;
import ai.bale.proto.PeersStruct$ExInfo;
import ai.bale.proto.PeersStruct$Peer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC16043kc4;
import ir.nasim.InterfaceC13043fc4;
import ir.nasim.InterfaceC18397ob4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingStruct$Dialog extends GeneratedMessageLite implements InterfaceC18397ob4 {
    public static final int ATTRIBUTES_FIELD_NUMBER = 10;
    public static final int DATE_FIELD_NUMBER = 6;
    private static final MessagingStruct$Dialog DEFAULT_INSTANCE;
    public static final int EX_INFO_FIELD_NUMBER = 13;
    public static final int FIRST_UNREAD_DATE_FIELD_NUMBER = 9;
    public static final int IS_MESSAGE_FORWARDED_FIELD_NUMBER = 14;
    public static final int IS_MUTE_FIELD_NUMBER = 18;
    public static final int MARKED_AS_UNREAD_FIELD_NUMBER = 17;
    public static final int MESSAGE_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int RID_FIELD_NUMBER = 5;
    public static final int SENDER_UID_FIELD_NUMBER = 4;
    public static final int SORT_DATE_FIELD_NUMBER = 3;
    public static final int STATE_FIELD_NUMBER = 8;
    public static final int UNREAD_COUNT_FIELD_NUMBER = 2;
    public static final int UNREAD_MENTIONS_FIELD_NUMBER = 15;
    public static final int UNREAD_REACTIONS_FIELD_NUMBER = 16;
    private MessagingStruct$MessageAttributes attributes_;
    private int bitField0_;
    private long date_;
    private PeersStruct$ExInfo exInfo_;
    private CollectionsStruct$Int64Value firstUnreadDate_;
    private boolean isMessageForwarded_;
    private boolean isMute_;
    private boolean markedAsUnread_;
    private MessagingStruct$Message message_;
    private PeersStruct$Peer peer_;
    private long rid_;
    private int senderUid_;
    private long sortDate_;
    private int state_;
    private int unreadCount_;
    private B.j unreadMentions_ = GeneratedMessageLite.emptyProtobufList();
    private B.j unreadReactions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC18397ob4 {
        private a() {
            super(MessagingStruct$Dialog.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$Dialog messagingStruct$Dialog = new MessagingStruct$Dialog();
        DEFAULT_INSTANCE = messagingStruct$Dialog;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$Dialog.class, messagingStruct$Dialog);
    }

    private MessagingStruct$Dialog() {
    }

    private void addAllUnreadMentions(Iterable<? extends MessagingStruct$MessageId> iterable) {
        ensureUnreadMentionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.unreadMentions_);
    }

    private void addAllUnreadReactions(Iterable<? extends MessagingStruct$MessageId> iterable) {
        ensureUnreadReactionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.unreadReactions_);
    }

    private void addUnreadMentions(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureUnreadMentionsIsMutable();
        this.unreadMentions_.add(messagingStruct$MessageId);
    }

    private void addUnreadReactions(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureUnreadReactionsIsMutable();
        this.unreadReactions_.add(messagingStruct$MessageId);
    }

    private void clearAttributes() {
        this.attributes_ = null;
        this.bitField0_ &= -9;
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearExInfo() {
        this.exInfo_ = null;
        this.bitField0_ &= -17;
    }

    private void clearFirstUnreadDate() {
        this.firstUnreadDate_ = null;
        this.bitField0_ &= -5;
    }

    private void clearIsMessageForwarded() {
        this.isMessageForwarded_ = false;
    }

    private void clearIsMute() {
        this.isMute_ = false;
    }

    private void clearMarkedAsUnread() {
        this.markedAsUnread_ = false;
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearSenderUid() {
        this.senderUid_ = 0;
    }

    private void clearSortDate() {
        this.sortDate_ = 0L;
    }

    private void clearState() {
        this.state_ = 0;
    }

    private void clearUnreadCount() {
        this.unreadCount_ = 0;
    }

    private void clearUnreadMentions() {
        this.unreadMentions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUnreadReactions() {
        this.unreadReactions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUnreadMentionsIsMutable() {
        B.j jVar = this.unreadMentions_;
        if (jVar.u()) {
            return;
        }
        this.unreadMentions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUnreadReactionsIsMutable() {
        B.j jVar = this.unreadReactions_;
        if (jVar.u()) {
            return;
        }
        this.unreadReactions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingStruct$Dialog getDefaultInstance() {
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
        this.bitField0_ |= 8;
    }

    private void mergeExInfo(PeersStruct$ExInfo peersStruct$ExInfo) {
        peersStruct$ExInfo.getClass();
        PeersStruct$ExInfo peersStruct$ExInfo2 = this.exInfo_;
        if (peersStruct$ExInfo2 == null || peersStruct$ExInfo2 == PeersStruct$ExInfo.getDefaultInstance()) {
            this.exInfo_ = peersStruct$ExInfo;
        } else {
            this.exInfo_ = (PeersStruct$ExInfo) ((PeersStruct$ExInfo.a) PeersStruct$ExInfo.newBuilder(this.exInfo_).v(peersStruct$ExInfo)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeFirstUnreadDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.firstUnreadDate_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.firstUnreadDate_ = collectionsStruct$Int64Value;
        } else {
            this.firstUnreadDate_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.firstUnreadDate_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 4;
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

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$Dialog parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$Dialog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$Dialog parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$Dialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUnreadMentions(int i) {
        ensureUnreadMentionsIsMutable();
        this.unreadMentions_.remove(i);
    }

    private void removeUnreadReactions(int i) {
        ensureUnreadReactionsIsMutable();
        this.unreadReactions_.remove(i);
    }

    private void setAttributes(MessagingStruct$MessageAttributes messagingStruct$MessageAttributes) {
        messagingStruct$MessageAttributes.getClass();
        this.attributes_ = messagingStruct$MessageAttributes;
        this.bitField0_ |= 8;
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setExInfo(PeersStruct$ExInfo peersStruct$ExInfo) {
        peersStruct$ExInfo.getClass();
        this.exInfo_ = peersStruct$ExInfo;
        this.bitField0_ |= 16;
    }

    private void setFirstUnreadDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.firstUnreadDate_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 4;
    }

    private void setIsMessageForwarded(boolean z) {
        this.isMessageForwarded_ = z;
    }

    private void setIsMute(boolean z) {
        this.isMute_ = z;
    }

    private void setMarkedAsUnread(boolean z) {
        this.markedAsUnread_ = z;
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

    private void setRid(long j) {
        this.rid_ = j;
    }

    private void setSenderUid(int i) {
        this.senderUid_ = i;
    }

    private void setSortDate(long j) {
        this.sortDate_ = j;
    }

    private void setState(EnumC16043kc4 enumC16043kc4) {
        this.state_ = enumC16043kc4.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    private void setUnreadCount(int i) {
        this.unreadCount_ = i;
    }

    private void setUnreadMentions(int i, MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureUnreadMentionsIsMutable();
        this.unreadMentions_.set(i, messagingStruct$MessageId);
    }

    private void setUnreadReactions(int i, MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureUnreadReactionsIsMutable();
        this.unreadReactions_.set(i, messagingStruct$MessageId);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$Dialog();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0010\u0000\u0001\u0001\u0012\u0010\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u0004\u0003\u0002\u0004\u0004\u0005\u0002\u0006\u0002\u0007ဉ\u0001\b\f\tဉ\u0002\nဉ\u0003\rဉ\u0004\u000e\u0007\u000f\u001b\u0010\u001b\u0011\u0007\u0012\u0007", new Object[]{"bitField0_", "peer_", "unreadCount_", "sortDate_", "senderUid_", "rid_", "date_", "message_", "state_", "firstUnreadDate_", "attributes_", "exInfo_", "isMessageForwarded_", "unreadMentions_", MessagingStruct$MessageId.class, "unreadReactions_", MessagingStruct$MessageId.class, "markedAsUnread_", "isMute_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$Dialog.class) {
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

    public MessagingStruct$MessageAttributes getAttributes() {
        MessagingStruct$MessageAttributes messagingStruct$MessageAttributes = this.attributes_;
        return messagingStruct$MessageAttributes == null ? MessagingStruct$MessageAttributes.getDefaultInstance() : messagingStruct$MessageAttributes;
    }

    public long getDate() {
        return this.date_;
    }

    public PeersStruct$ExInfo getExInfo() {
        PeersStruct$ExInfo peersStruct$ExInfo = this.exInfo_;
        return peersStruct$ExInfo == null ? PeersStruct$ExInfo.getDefaultInstance() : peersStruct$ExInfo;
    }

    public CollectionsStruct$Int64Value getFirstUnreadDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.firstUnreadDate_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public boolean getIsMessageForwarded() {
        return this.isMessageForwarded_;
    }

    public boolean getIsMute() {
        return this.isMute_;
    }

    public boolean getMarkedAsUnread() {
        return this.markedAsUnread_;
    }

    public MessagingStruct$Message getMessage() {
        MessagingStruct$Message messagingStruct$Message = this.message_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public PeersStruct$Peer getPeer() {
        PeersStruct$Peer peersStruct$Peer = this.peer_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public long getRid() {
        return this.rid_;
    }

    public int getSenderUid() {
        return this.senderUid_;
    }

    public long getSortDate() {
        return this.sortDate_;
    }

    public EnumC16043kc4 getState() {
        EnumC16043kc4 enumC16043kc4J = EnumC16043kc4.j(this.state_);
        return enumC16043kc4J == null ? EnumC16043kc4.UNRECOGNIZED : enumC16043kc4J;
    }

    public int getStateValue() {
        return this.state_;
    }

    public int getUnreadCount() {
        return this.unreadCount_;
    }

    public MessagingStruct$MessageId getUnreadMentions(int i) {
        return (MessagingStruct$MessageId) this.unreadMentions_.get(i);
    }

    public int getUnreadMentionsCount() {
        return this.unreadMentions_.size();
    }

    public List<MessagingStruct$MessageId> getUnreadMentionsList() {
        return this.unreadMentions_;
    }

    public InterfaceC13043fc4 getUnreadMentionsOrBuilder(int i) {
        return (InterfaceC13043fc4) this.unreadMentions_.get(i);
    }

    public List<? extends InterfaceC13043fc4> getUnreadMentionsOrBuilderList() {
        return this.unreadMentions_;
    }

    public MessagingStruct$MessageId getUnreadReactions(int i) {
        return (MessagingStruct$MessageId) this.unreadReactions_.get(i);
    }

    public int getUnreadReactionsCount() {
        return this.unreadReactions_.size();
    }

    public List<MessagingStruct$MessageId> getUnreadReactionsList() {
        return this.unreadReactions_;
    }

    public InterfaceC13043fc4 getUnreadReactionsOrBuilder(int i) {
        return (InterfaceC13043fc4) this.unreadReactions_.get(i);
    }

    public List<? extends InterfaceC13043fc4> getUnreadReactionsOrBuilderList() {
        return this.unreadReactions_;
    }

    public boolean hasAttributes() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasExInfo() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasFirstUnreadDate() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$Dialog messagingStruct$Dialog) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$Dialog);
    }

    public static MessagingStruct$Dialog parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$Dialog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$Dialog parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$Dialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$Dialog parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$Dialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUnreadMentions(int i, MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureUnreadMentionsIsMutable();
        this.unreadMentions_.add(i, messagingStruct$MessageId);
    }

    private void addUnreadReactions(int i, MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureUnreadReactionsIsMutable();
        this.unreadReactions_.add(i, messagingStruct$MessageId);
    }

    public static MessagingStruct$Dialog parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$Dialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$Dialog parseFrom(byte[] bArr) {
        return (MessagingStruct$Dialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$Dialog parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$Dialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$Dialog parseFrom(InputStream inputStream) {
        return (MessagingStruct$Dialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$Dialog parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$Dialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$Dialog parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$Dialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$Dialog parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$Dialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$BooleanValue;
import ai.bale.proto.CollectionsStruct$Int32Value;
import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.CollectionsStruct$MultiLanguageTag;
import ai.bale.proto.CollectionsStruct$StringValue;
import ai.bale.proto.MagazineStruct$FeedMessage;
import ai.bale.proto.MessagingStruct$Replies;
import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.BM3;
import ir.nasim.InterfaceC15452jc4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MagazineStruct$FeedMessageContainer extends GeneratedMessageLite implements BM3 {
    public static final int CATEGORY_FIELD_NUMBER = 11;
    public static final int DATE_FIELD_NUMBER = 3;
    private static final MagazineStruct$FeedMessageContainer DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 5;
    public static final int FORWARDED_COUNT_FIELD_NUMBER = 8;
    public static final int GROUPED_ID_FIELD_NUMBER = 12;
    public static final int HAS_COMMENT_FIELD_NUMBER = 14;
    public static final int ISUPVOTEDBYME_FIELD_NUMBER = 10;
    public static final int MESSAGE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int REACTIONS_FIELD_NUMBER = 6;
    public static final int REPLIES_INFO_FIELD_NUMBER = 13;
    public static final int RID_FIELD_NUMBER = 2;
    public static final int SENDER_UID_FIELD_NUMBER = 1;
    public static final int TAG_FIELD_NUMBER = 7;
    public static final int UPVOTE_COUNT_FIELD_NUMBER = 9;
    private int bitField0_;
    private CollectionsStruct$StringValue category_;
    private long date_;
    private PeersStruct$ExPeer exPeer_;
    private CollectionsStruct$Int32Value forwardedCount_;
    private CollectionsStruct$Int64Value groupedId_;
    private CollectionsStruct$BooleanValue hasComment_;
    private CollectionsStruct$BooleanValue isUpvotedByMe_;
    private MagazineStruct$FeedMessage message_;
    private B.j reactions_ = GeneratedMessageLite.emptyProtobufList();
    private MessagingStruct$Replies repliesInfo_;
    private long rid_;
    private int senderUid_;
    private CollectionsStruct$MultiLanguageTag tag_;
    private CollectionsStruct$Int32Value upvoteCount_;

    public static final class a extends GeneratedMessageLite.b implements BM3 {
        private a() {
            super(MagazineStruct$FeedMessageContainer.DEFAULT_INSTANCE);
        }
    }

    static {
        MagazineStruct$FeedMessageContainer magazineStruct$FeedMessageContainer = new MagazineStruct$FeedMessageContainer();
        DEFAULT_INSTANCE = magazineStruct$FeedMessageContainer;
        GeneratedMessageLite.registerDefaultInstance(MagazineStruct$FeedMessageContainer.class, magazineStruct$FeedMessageContainer);
    }

    private MagazineStruct$FeedMessageContainer() {
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

    private void clearCategory() {
        this.category_ = null;
        this.bitField0_ &= -65;
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -3;
    }

    private void clearForwardedCount() {
        this.forwardedCount_ = null;
        this.bitField0_ &= -9;
    }

    private void clearGroupedId() {
        this.groupedId_ = null;
        this.bitField0_ &= -129;
    }

    private void clearHasComment() {
        this.hasComment_ = null;
        this.bitField0_ &= -513;
    }

    private void clearIsUpvotedByMe() {
        this.isUpvotedByMe_ = null;
        this.bitField0_ &= -33;
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -2;
    }

    private void clearReactions() {
        this.reactions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearRepliesInfo() {
        this.repliesInfo_ = null;
        this.bitField0_ &= -257;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearSenderUid() {
        this.senderUid_ = 0;
    }

    private void clearTag() {
        this.tag_ = null;
        this.bitField0_ &= -5;
    }

    private void clearUpvoteCount() {
        this.upvoteCount_ = null;
        this.bitField0_ &= -17;
    }

    private void ensureReactionsIsMutable() {
        B.j jVar = this.reactions_;
        if (jVar.u()) {
            return;
        }
        this.reactions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MagazineStruct$FeedMessageContainer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCategory(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.category_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.category_ = collectionsStruct$StringValue;
        } else {
            this.category_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.category_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 64;
    }

    private void mergeExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.exPeer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.exPeer_ = peersStruct$ExPeer;
        } else {
            this.exPeer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.exPeer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeForwardedCount(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        CollectionsStruct$Int32Value collectionsStruct$Int32Value2 = this.forwardedCount_;
        if (collectionsStruct$Int32Value2 == null || collectionsStruct$Int32Value2 == CollectionsStruct$Int32Value.getDefaultInstance()) {
            this.forwardedCount_ = collectionsStruct$Int32Value;
        } else {
            this.forwardedCount_ = (CollectionsStruct$Int32Value) ((CollectionsStruct$Int32Value.a) CollectionsStruct$Int32Value.newBuilder(this.forwardedCount_).v(collectionsStruct$Int32Value)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeGroupedId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.groupedId_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.groupedId_ = collectionsStruct$Int64Value;
        } else {
            this.groupedId_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.groupedId_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 128;
    }

    private void mergeHasComment(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue2 = this.hasComment_;
        if (collectionsStruct$BooleanValue2 == null || collectionsStruct$BooleanValue2 == CollectionsStruct$BooleanValue.getDefaultInstance()) {
            this.hasComment_ = collectionsStruct$BooleanValue;
        } else {
            this.hasComment_ = (CollectionsStruct$BooleanValue) ((CollectionsStruct$BooleanValue.a) CollectionsStruct$BooleanValue.newBuilder(this.hasComment_).v(collectionsStruct$BooleanValue)).j();
        }
        this.bitField0_ |= 512;
    }

    private void mergeIsUpvotedByMe(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue2 = this.isUpvotedByMe_;
        if (collectionsStruct$BooleanValue2 == null || collectionsStruct$BooleanValue2 == CollectionsStruct$BooleanValue.getDefaultInstance()) {
            this.isUpvotedByMe_ = collectionsStruct$BooleanValue;
        } else {
            this.isUpvotedByMe_ = (CollectionsStruct$BooleanValue) ((CollectionsStruct$BooleanValue.a) CollectionsStruct$BooleanValue.newBuilder(this.isUpvotedByMe_).v(collectionsStruct$BooleanValue)).j();
        }
        this.bitField0_ |= 32;
    }

    private void mergeMessage(MagazineStruct$FeedMessage magazineStruct$FeedMessage) {
        magazineStruct$FeedMessage.getClass();
        MagazineStruct$FeedMessage magazineStruct$FeedMessage2 = this.message_;
        if (magazineStruct$FeedMessage2 == null || magazineStruct$FeedMessage2 == MagazineStruct$FeedMessage.getDefaultInstance()) {
            this.message_ = magazineStruct$FeedMessage;
        } else {
            this.message_ = (MagazineStruct$FeedMessage) ((MagazineStruct$FeedMessage.a) MagazineStruct$FeedMessage.newBuilder(this.message_).v(magazineStruct$FeedMessage)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeRepliesInfo(MessagingStruct$Replies messagingStruct$Replies) {
        messagingStruct$Replies.getClass();
        MessagingStruct$Replies messagingStruct$Replies2 = this.repliesInfo_;
        if (messagingStruct$Replies2 == null || messagingStruct$Replies2 == MessagingStruct$Replies.getDefaultInstance()) {
            this.repliesInfo_ = messagingStruct$Replies;
        } else {
            this.repliesInfo_ = (MessagingStruct$Replies) ((MessagingStruct$Replies.a) MessagingStruct$Replies.newBuilder(this.repliesInfo_).v(messagingStruct$Replies)).j();
        }
        this.bitField0_ |= 256;
    }

    private void mergeTag(CollectionsStruct$MultiLanguageTag collectionsStruct$MultiLanguageTag) {
        collectionsStruct$MultiLanguageTag.getClass();
        CollectionsStruct$MultiLanguageTag collectionsStruct$MultiLanguageTag2 = this.tag_;
        if (collectionsStruct$MultiLanguageTag2 == null || collectionsStruct$MultiLanguageTag2 == CollectionsStruct$MultiLanguageTag.getDefaultInstance()) {
            this.tag_ = collectionsStruct$MultiLanguageTag;
        } else {
            this.tag_ = (CollectionsStruct$MultiLanguageTag) ((CollectionsStruct$MultiLanguageTag.a) CollectionsStruct$MultiLanguageTag.newBuilder(this.tag_).v(collectionsStruct$MultiLanguageTag)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeUpvoteCount(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        CollectionsStruct$Int32Value collectionsStruct$Int32Value2 = this.upvoteCount_;
        if (collectionsStruct$Int32Value2 == null || collectionsStruct$Int32Value2 == CollectionsStruct$Int32Value.getDefaultInstance()) {
            this.upvoteCount_ = collectionsStruct$Int32Value;
        } else {
            this.upvoteCount_ = (CollectionsStruct$Int32Value) ((CollectionsStruct$Int32Value.a) CollectionsStruct$Int32Value.newBuilder(this.upvoteCount_).v(collectionsStruct$Int32Value)).j();
        }
        this.bitField0_ |= 16;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MagazineStruct$FeedMessageContainer parseDelimitedFrom(InputStream inputStream) {
        return (MagazineStruct$FeedMessageContainer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineStruct$FeedMessageContainer parseFrom(ByteBuffer byteBuffer) {
        return (MagazineStruct$FeedMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeReactions(int i) {
        ensureReactionsIsMutable();
        this.reactions_.remove(i);
    }

    private void setCategory(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.category_ = collectionsStruct$StringValue;
        this.bitField0_ |= 64;
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 2;
    }

    private void setForwardedCount(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        this.forwardedCount_ = collectionsStruct$Int32Value;
        this.bitField0_ |= 8;
    }

    private void setGroupedId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.groupedId_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 128;
    }

    private void setHasComment(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        this.hasComment_ = collectionsStruct$BooleanValue;
        this.bitField0_ |= 512;
    }

    private void setIsUpvotedByMe(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        this.isUpvotedByMe_ = collectionsStruct$BooleanValue;
        this.bitField0_ |= 32;
    }

    private void setMessage(MagazineStruct$FeedMessage magazineStruct$FeedMessage) {
        magazineStruct$FeedMessage.getClass();
        this.message_ = magazineStruct$FeedMessage;
        this.bitField0_ |= 1;
    }

    private void setReactions(int i, MessagingStruct$MessageReaction messagingStruct$MessageReaction) {
        messagingStruct$MessageReaction.getClass();
        ensureReactionsIsMutable();
        this.reactions_.set(i, messagingStruct$MessageReaction);
    }

    private void setRepliesInfo(MessagingStruct$Replies messagingStruct$Replies) {
        messagingStruct$Replies.getClass();
        this.repliesInfo_ = messagingStruct$Replies;
        this.bitField0_ |= 256;
    }

    private void setRid(long j) {
        this.rid_ = j;
    }

    private void setSenderUid(int i) {
        this.senderUid_ = i;
    }

    private void setTag(CollectionsStruct$MultiLanguageTag collectionsStruct$MultiLanguageTag) {
        collectionsStruct$MultiLanguageTag.getClass();
        this.tag_ = collectionsStruct$MultiLanguageTag;
        this.bitField0_ |= 4;
    }

    private void setUpvoteCount(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        this.upvoteCount_ = collectionsStruct$Int32Value;
        this.bitField0_ |= 16;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B0.a[gVar.ordinal()]) {
            case 1:
                return new MagazineStruct$FeedMessageContainer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0001\u0000\u0001\u0004\u0002\u0002\u0003\u0002\u0004ဉ\u0000\u0005ဉ\u0001\u0006\u001b\u0007ဉ\u0002\bဉ\u0003\tဉ\u0004\nဉ\u0005\u000bဉ\u0006\fဉ\u0007\rဉ\b\u000eဉ\t", new Object[]{"bitField0_", "senderUid_", "rid_", "date_", "message_", "exPeer_", "reactions_", MessagingStruct$MessageReaction.class, "tag_", "forwardedCount_", "upvoteCount_", "isUpvotedByMe_", "category_", "groupedId_", "repliesInfo_", "hasComment_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MagazineStruct$FeedMessageContainer.class) {
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

    public CollectionsStruct$StringValue getCategory() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.category_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public long getDate() {
        return this.date_;
    }

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public CollectionsStruct$Int32Value getForwardedCount() {
        CollectionsStruct$Int32Value collectionsStruct$Int32Value = this.forwardedCount_;
        return collectionsStruct$Int32Value == null ? CollectionsStruct$Int32Value.getDefaultInstance() : collectionsStruct$Int32Value;
    }

    public CollectionsStruct$Int64Value getGroupedId() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.groupedId_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public CollectionsStruct$BooleanValue getHasComment() {
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue = this.hasComment_;
        return collectionsStruct$BooleanValue == null ? CollectionsStruct$BooleanValue.getDefaultInstance() : collectionsStruct$BooleanValue;
    }

    public CollectionsStruct$BooleanValue getIsUpvotedByMe() {
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue = this.isUpvotedByMe_;
        return collectionsStruct$BooleanValue == null ? CollectionsStruct$BooleanValue.getDefaultInstance() : collectionsStruct$BooleanValue;
    }

    public MagazineStruct$FeedMessage getMessage() {
        MagazineStruct$FeedMessage magazineStruct$FeedMessage = this.message_;
        return magazineStruct$FeedMessage == null ? MagazineStruct$FeedMessage.getDefaultInstance() : magazineStruct$FeedMessage;
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

    public MessagingStruct$Replies getRepliesInfo() {
        MessagingStruct$Replies messagingStruct$Replies = this.repliesInfo_;
        return messagingStruct$Replies == null ? MessagingStruct$Replies.getDefaultInstance() : messagingStruct$Replies;
    }

    public long getRid() {
        return this.rid_;
    }

    public int getSenderUid() {
        return this.senderUid_;
    }

    public CollectionsStruct$MultiLanguageTag getTag() {
        CollectionsStruct$MultiLanguageTag collectionsStruct$MultiLanguageTag = this.tag_;
        return collectionsStruct$MultiLanguageTag == null ? CollectionsStruct$MultiLanguageTag.getDefaultInstance() : collectionsStruct$MultiLanguageTag;
    }

    public CollectionsStruct$Int32Value getUpvoteCount() {
        CollectionsStruct$Int32Value collectionsStruct$Int32Value = this.upvoteCount_;
        return collectionsStruct$Int32Value == null ? CollectionsStruct$Int32Value.getDefaultInstance() : collectionsStruct$Int32Value;
    }

    public boolean hasCategory() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasForwardedCount() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasGroupedId() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasHasComment() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasIsUpvotedByMe() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasRepliesInfo() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasTag() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasUpvoteCount() {
        return (this.bitField0_ & 16) != 0;
    }

    public static a newBuilder(MagazineStruct$FeedMessageContainer magazineStruct$FeedMessageContainer) {
        return (a) DEFAULT_INSTANCE.createBuilder(magazineStruct$FeedMessageContainer);
    }

    public static MagazineStruct$FeedMessageContainer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineStruct$FeedMessageContainer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineStruct$FeedMessageContainer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MagazineStruct$FeedMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MagazineStruct$FeedMessageContainer parseFrom(AbstractC2383g abstractC2383g) {
        return (MagazineStruct$FeedMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addReactions(int i, MessagingStruct$MessageReaction messagingStruct$MessageReaction) {
        messagingStruct$MessageReaction.getClass();
        ensureReactionsIsMutable();
        this.reactions_.add(i, messagingStruct$MessageReaction);
    }

    public static MagazineStruct$FeedMessageContainer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MagazineStruct$FeedMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MagazineStruct$FeedMessageContainer parseFrom(byte[] bArr) {
        return (MagazineStruct$FeedMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MagazineStruct$FeedMessageContainer parseFrom(byte[] bArr, C2394s c2394s) {
        return (MagazineStruct$FeedMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MagazineStruct$FeedMessageContainer parseFrom(InputStream inputStream) {
        return (MagazineStruct$FeedMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineStruct$FeedMessageContainer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineStruct$FeedMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineStruct$FeedMessageContainer parseFrom(AbstractC2384h abstractC2384h) {
        return (MagazineStruct$FeedMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MagazineStruct$FeedMessageContainer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MagazineStruct$FeedMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

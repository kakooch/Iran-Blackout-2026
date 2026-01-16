package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.StoryStruct$MediaStory;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC15380jU6;
import ir.nasim.JU6;
import ir.nasim.KW4;
import ir.nasim.OU6;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryStruct$BotStory extends GeneratedMessageLite implements InterfaceC15380jU6 {
    public static final int CREATED_AT_FIELD_NUMBER = 4;
    private static final StoryStruct$BotStory DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 7;
    public static final int HAS_REPLY_FIELD_NUMBER = 6;
    public static final int HAS_WIDGET_FIELD_NUMBER = 8;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_HIDDEN_FIELD_NUMBER = 12;
    public static final int OWNER_USER_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int REACTIONS_FIELD_NUMBER = 11;
    public static final int REACTION_FIELD_NUMBER = 3;
    public static final int STORY_CONTENT_FIELD_NUMBER = 5;
    public static final int STORY_CONTENT_TYPE_FIELD_NUMBER = 10;
    public static final int TAG_IDS_FIELD_NUMBER = 9;
    private int bitField0_;
    private long createdAt_;
    private PeersStruct$ExPeer exPeer_;
    private boolean hasReply_;
    private boolean hasWidget_;
    private boolean isHidden_;
    private int ownerUserId_;
    private StringValue reaction_;
    private int storyContentType_;
    private StoryStruct$MediaStory storyContent_;
    private int tagIdsMemoizedSerializedSize = -1;
    private String id_ = "";
    private B.g tagIds_ = GeneratedMessageLite.emptyIntList();
    private B.j reactions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC15380jU6 {
        private a() {
            super(StoryStruct$BotStory.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$BotStory storyStruct$BotStory = new StoryStruct$BotStory();
        DEFAULT_INSTANCE = storyStruct$BotStory;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$BotStory.class, storyStruct$BotStory);
    }

    private StoryStruct$BotStory() {
    }

    private void addAllReactions(Iterable<? extends StoryStruct$StoryReaction> iterable) {
        ensureReactionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.reactions_);
    }

    private void addAllTagIds(Iterable<? extends Integer> iterable) {
        ensureTagIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.tagIds_);
    }

    private void addReactions(StoryStruct$StoryReaction storyStruct$StoryReaction) {
        storyStruct$StoryReaction.getClass();
        ensureReactionsIsMutable();
        this.reactions_.add(storyStruct$StoryReaction);
    }

    private void addTagIds(int i) {
        ensureTagIdsIsMutable();
        this.tagIds_.b1(i);
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -5;
    }

    private void clearHasReply() {
        this.hasReply_ = false;
    }

    private void clearHasWidget() {
        this.hasWidget_ = false;
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearIsHidden() {
        this.isHidden_ = false;
    }

    private void clearOwnerUserId() {
        this.ownerUserId_ = 0;
    }

    private void clearReaction() {
        this.reaction_ = null;
        this.bitField0_ &= -2;
    }

    private void clearReactions() {
        this.reactions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearStoryContent() {
        this.storyContent_ = null;
        this.bitField0_ &= -3;
    }

    private void clearStoryContentType() {
        this.storyContentType_ = 0;
    }

    private void clearTagIds() {
        this.tagIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureReactionsIsMutable() {
        B.j jVar = this.reactions_;
        if (jVar.u()) {
            return;
        }
        this.reactions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureTagIdsIsMutable() {
        B.g gVar = this.tagIds_;
        if (gVar.u()) {
            return;
        }
        this.tagIds_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static StoryStruct$BotStory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.exPeer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.exPeer_ = peersStruct$ExPeer;
        } else {
            this.exPeer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.exPeer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeReaction(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.reaction_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.reaction_ = stringValue;
        } else {
            this.reaction_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.reaction_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeStoryContent(StoryStruct$MediaStory storyStruct$MediaStory) {
        storyStruct$MediaStory.getClass();
        StoryStruct$MediaStory storyStruct$MediaStory2 = this.storyContent_;
        if (storyStruct$MediaStory2 == null || storyStruct$MediaStory2 == StoryStruct$MediaStory.getDefaultInstance()) {
            this.storyContent_ = storyStruct$MediaStory;
        } else {
            this.storyContent_ = (StoryStruct$MediaStory) ((StoryStruct$MediaStory.a) StoryStruct$MediaStory.newBuilder(this.storyContent_).v(storyStruct$MediaStory)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$BotStory parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$BotStory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$BotStory parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$BotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeReactions(int i) {
        ensureReactionsIsMutable();
        this.reactions_.remove(i);
    }

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    private void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 4;
    }

    private void setHasReply(boolean z) {
        this.hasReply_ = z;
    }

    private void setHasWidget(boolean z) {
        this.hasWidget_ = z;
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setIsHidden(boolean z) {
        this.isHidden_ = z;
    }

    private void setOwnerUserId(int i) {
        this.ownerUserId_ = i;
    }

    private void setReaction(StringValue stringValue) {
        stringValue.getClass();
        this.reaction_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setReactions(int i, StoryStruct$StoryReaction storyStruct$StoryReaction) {
        storyStruct$StoryReaction.getClass();
        ensureReactionsIsMutable();
        this.reactions_.set(i, storyStruct$StoryReaction);
    }

    private void setStoryContent(StoryStruct$MediaStory storyStruct$MediaStory) {
        storyStruct$MediaStory.getClass();
        this.storyContent_ = storyStruct$MediaStory;
        this.bitField0_ |= 2;
    }

    private void setStoryContentType(JU6 ju6) {
        this.storyContentType_ = ju6.getNumber();
    }

    private void setStoryContentTypeValue(int i) {
        this.storyContentType_ = i;
    }

    private void setTagIds(int i, int i2) {
        ensureTagIdsIsMutable();
        this.tagIds_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$BotStory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\f\u0000\u0001\u0001\f\f\u0000\u0002\u0000\u0001Ȉ\u0002\u0004\u0003ဉ\u0000\u0004\u0002\u0005ဉ\u0001\u0006\u0007\u0007ဉ\u0002\b\u0007\t'\n\f\u000b\u001b\f\u0007", new Object[]{"bitField0_", "id_", "ownerUserId_", "reaction_", "createdAt_", "storyContent_", "hasReply_", "exPeer_", "hasWidget_", "tagIds_", "storyContentType_", "reactions_", StoryStruct$StoryReaction.class, "isHidden_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$BotStory.class) {
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

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public boolean getHasReply() {
        return this.hasReply_;
    }

    public boolean getHasWidget() {
        return this.hasWidget_;
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public boolean getIsHidden() {
        return this.isHidden_;
    }

    public int getOwnerUserId() {
        return this.ownerUserId_;
    }

    public StringValue getReaction() {
        StringValue stringValue = this.reaction_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StoryStruct$StoryReaction getReactions(int i) {
        return (StoryStruct$StoryReaction) this.reactions_.get(i);
    }

    public int getReactionsCount() {
        return this.reactions_.size();
    }

    public List<StoryStruct$StoryReaction> getReactionsList() {
        return this.reactions_;
    }

    public OU6 getReactionsOrBuilder(int i) {
        return (OU6) this.reactions_.get(i);
    }

    public List<? extends OU6> getReactionsOrBuilderList() {
        return this.reactions_;
    }

    public StoryStruct$MediaStory getStoryContent() {
        StoryStruct$MediaStory storyStruct$MediaStory = this.storyContent_;
        return storyStruct$MediaStory == null ? StoryStruct$MediaStory.getDefaultInstance() : storyStruct$MediaStory;
    }

    public JU6 getStoryContentType() {
        JU6 ju6J = JU6.j(this.storyContentType_);
        return ju6J == null ? JU6.UNRECOGNIZED : ju6J;
    }

    public int getStoryContentTypeValue() {
        return this.storyContentType_;
    }

    public int getTagIds(int i) {
        return this.tagIds_.getInt(i);
    }

    public int getTagIdsCount() {
        return this.tagIds_.size();
    }

    public List<Integer> getTagIdsList() {
        return this.tagIds_;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasReaction() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasStoryContent() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(StoryStruct$BotStory storyStruct$BotStory) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$BotStory);
    }

    public static StoryStruct$BotStory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$BotStory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$BotStory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$BotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$BotStory parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$BotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addReactions(int i, StoryStruct$StoryReaction storyStruct$StoryReaction) {
        storyStruct$StoryReaction.getClass();
        ensureReactionsIsMutable();
        this.reactions_.add(i, storyStruct$StoryReaction);
    }

    public static StoryStruct$BotStory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$BotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$BotStory parseFrom(byte[] bArr) {
        return (StoryStruct$BotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$BotStory parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$BotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$BotStory parseFrom(InputStream inputStream) {
        return (StoryStruct$BotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$BotStory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$BotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$BotStory parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$BotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$BotStory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$BotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

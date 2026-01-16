package ai.bale.proto;

import ai.bale.proto.StoryStruct$StoryContent;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC21337tU6;
import ir.nasim.JU6;
import ir.nasim.KW4;
import ir.nasim.MU6;
import ir.nasim.OU6;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryStruct$Story extends GeneratedMessageLite implements MU6 {
    public static final int CREATED_AT_FIELD_NUMBER = 4;
    private static final StoryStruct$Story DEFAULT_INSTANCE;
    public static final int EXCEPTION_TYPE_FIELD_NUMBER = 13;
    public static final int HAS_REPLY_FIELD_NUMBER = 7;
    public static final int HAS_WIDGET_FIELD_NUMBER = 6;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_HIDDEN_FIELD_NUMBER = 8;
    public static final int IS_MUTUAL_FIELD_NUMBER = 9;
    public static final int OWNER_USER_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int REACTIONS_FIELD_NUMBER = 12;
    public static final int REACTION_FIELD_NUMBER = 3;
    public static final int STORY_CONTENT_FIELD_NUMBER = 5;
    public static final int STORY_CONTENT_TYPE_FIELD_NUMBER = 11;
    public static final int TAG_IDS_FIELD_NUMBER = 10;
    private int bitField0_;
    private long createdAt_;
    private int exceptionType_;
    private boolean hasReply_;
    private boolean hasWidget_;
    private boolean isHidden_;
    private boolean isMutual_;
    private int ownerUserId_;
    private StringValue reaction_;
    private int storyContentType_;
    private StoryStruct$StoryContent storyContent_;
    private int tagIdsMemoizedSerializedSize = -1;
    private String id_ = "";
    private B.g tagIds_ = GeneratedMessageLite.emptyIntList();
    private B.j reactions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements MU6 {
        private a() {
            super(StoryStruct$Story.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$Story storyStruct$Story = new StoryStruct$Story();
        DEFAULT_INSTANCE = storyStruct$Story;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$Story.class, storyStruct$Story);
    }

    private StoryStruct$Story() {
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

    private void clearExceptionType() {
        this.exceptionType_ = 0;
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

    private void clearIsMutual() {
        this.isMutual_ = false;
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

    public static StoryStruct$Story getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    private void mergeStoryContent(StoryStruct$StoryContent storyStruct$StoryContent) {
        storyStruct$StoryContent.getClass();
        StoryStruct$StoryContent storyStruct$StoryContent2 = this.storyContent_;
        if (storyStruct$StoryContent2 == null || storyStruct$StoryContent2 == StoryStruct$StoryContent.getDefaultInstance()) {
            this.storyContent_ = storyStruct$StoryContent;
        } else {
            this.storyContent_ = (StoryStruct$StoryContent) ((StoryStruct$StoryContent.a) StoryStruct$StoryContent.newBuilder(this.storyContent_).v(storyStruct$StoryContent)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$Story parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$Story) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$Story parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$Story) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setExceptionType(EnumC21337tU6 enumC21337tU6) {
        this.exceptionType_ = enumC21337tU6.getNumber();
    }

    private void setExceptionTypeValue(int i) {
        this.exceptionType_ = i;
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

    private void setIsMutual(boolean z) {
        this.isMutual_ = z;
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

    private void setStoryContent(StoryStruct$StoryContent storyStruct$StoryContent) {
        storyStruct$StoryContent.getClass();
        this.storyContent_ = storyStruct$StoryContent;
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
                return new StoryStruct$Story();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\r\u0000\u0001\u0001\r\r\u0000\u0002\u0000\u0001Ȉ\u0002\u0004\u0003ဉ\u0000\u0004\u0002\u0005ဉ\u0001\u0006\u0007\u0007\u0007\b\u0007\t\u0007\n'\u000b\f\f\u001b\r\f", new Object[]{"bitField0_", "id_", "ownerUserId_", "reaction_", "createdAt_", "storyContent_", "hasWidget_", "hasReply_", "isHidden_", "isMutual_", "tagIds_", "storyContentType_", "reactions_", StoryStruct$StoryReaction.class, "exceptionType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$Story.class) {
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

    public EnumC21337tU6 getExceptionType() {
        EnumC21337tU6 enumC21337tU6J = EnumC21337tU6.j(this.exceptionType_);
        return enumC21337tU6J == null ? EnumC21337tU6.UNRECOGNIZED : enumC21337tU6J;
    }

    public int getExceptionTypeValue() {
        return this.exceptionType_;
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

    public boolean getIsMutual() {
        return this.isMutual_;
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

    public StoryStruct$StoryContent getStoryContent() {
        StoryStruct$StoryContent storyStruct$StoryContent = this.storyContent_;
        return storyStruct$StoryContent == null ? StoryStruct$StoryContent.getDefaultInstance() : storyStruct$StoryContent;
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

    public boolean hasReaction() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasStoryContent() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(StoryStruct$Story storyStruct$Story) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$Story);
    }

    public static StoryStruct$Story parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$Story) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$Story parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$Story) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$Story parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$Story) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addReactions(int i, StoryStruct$StoryReaction storyStruct$StoryReaction) {
        storyStruct$StoryReaction.getClass();
        ensureReactionsIsMutable();
        this.reactions_.add(i, storyStruct$StoryReaction);
    }

    public static StoryStruct$Story parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$Story) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$Story parseFrom(byte[] bArr) {
        return (StoryStruct$Story) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$Story parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$Story) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$Story parseFrom(InputStream inputStream) {
        return (StoryStruct$Story) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$Story parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$Story) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$Story parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$Story) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$Story parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$Story) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

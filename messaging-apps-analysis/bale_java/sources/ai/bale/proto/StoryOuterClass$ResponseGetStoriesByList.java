package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC15380jU6;
import ir.nasim.InterfaceC16562lU6;
import ir.nasim.KW4;
import ir.nasim.MU6;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryOuterClass$ResponseGetStoriesByList extends GeneratedMessageLite implements U64 {
    public static final int BOT_STORIES_FIELD_NUMBER = 3;
    public static final int CHANNEL_STORIES_FIELD_NUMBER = 2;
    private static final StoryOuterClass$ResponseGetStoriesByList DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_STORIES_FIELD_NUMBER = 1;
    private B.j userStories_ = GeneratedMessageLite.emptyProtobufList();
    private B.j channelStories_ = GeneratedMessageLite.emptyProtobufList();
    private B.j botStories_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryOuterClass$ResponseGetStoriesByList.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$ResponseGetStoriesByList storyOuterClass$ResponseGetStoriesByList = new StoryOuterClass$ResponseGetStoriesByList();
        DEFAULT_INSTANCE = storyOuterClass$ResponseGetStoriesByList;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$ResponseGetStoriesByList.class, storyOuterClass$ResponseGetStoriesByList);
    }

    private StoryOuterClass$ResponseGetStoriesByList() {
    }

    private void addAllBotStories(Iterable<? extends StoryStruct$BotStory> iterable) {
        ensureBotStoriesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.botStories_);
    }

    private void addAllChannelStories(Iterable<? extends StoryStruct$ChannelStory> iterable) {
        ensureChannelStoriesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.channelStories_);
    }

    private void addAllUserStories(Iterable<? extends StoryStruct$Story> iterable) {
        ensureUserStoriesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userStories_);
    }

    private void addBotStories(StoryStruct$BotStory storyStruct$BotStory) {
        storyStruct$BotStory.getClass();
        ensureBotStoriesIsMutable();
        this.botStories_.add(storyStruct$BotStory);
    }

    private void addChannelStories(StoryStruct$ChannelStory storyStruct$ChannelStory) {
        storyStruct$ChannelStory.getClass();
        ensureChannelStoriesIsMutable();
        this.channelStories_.add(storyStruct$ChannelStory);
    }

    private void addUserStories(StoryStruct$Story storyStruct$Story) {
        storyStruct$Story.getClass();
        ensureUserStoriesIsMutable();
        this.userStories_.add(storyStruct$Story);
    }

    private void clearBotStories() {
        this.botStories_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearChannelStories() {
        this.channelStories_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUserStories() {
        this.userStories_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureBotStoriesIsMutable() {
        B.j jVar = this.botStories_;
        if (jVar.u()) {
            return;
        }
        this.botStories_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureChannelStoriesIsMutable() {
        B.j jVar = this.channelStories_;
        if (jVar.u()) {
            return;
        }
        this.channelStories_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUserStoriesIsMutable() {
        B.j jVar = this.userStories_;
        if (jVar.u()) {
            return;
        }
        this.userStories_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static StoryOuterClass$ResponseGetStoriesByList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$ResponseGetStoriesByList parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetStoriesByList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetStoriesByList parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$ResponseGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBotStories(int i) {
        ensureBotStoriesIsMutable();
        this.botStories_.remove(i);
    }

    private void removeChannelStories(int i) {
        ensureChannelStoriesIsMutable();
        this.channelStories_.remove(i);
    }

    private void removeUserStories(int i) {
        ensureUserStoriesIsMutable();
        this.userStories_.remove(i);
    }

    private void setBotStories(int i, StoryStruct$BotStory storyStruct$BotStory) {
        storyStruct$BotStory.getClass();
        ensureBotStoriesIsMutable();
        this.botStories_.set(i, storyStruct$BotStory);
    }

    private void setChannelStories(int i, StoryStruct$ChannelStory storyStruct$ChannelStory) {
        storyStruct$ChannelStory.getClass();
        ensureChannelStoriesIsMutable();
        this.channelStories_.set(i, storyStruct$ChannelStory);
    }

    private void setUserStories(int i, StoryStruct$Story storyStruct$Story) {
        storyStruct$Story.getClass();
        ensureUserStoriesIsMutable();
        this.userStories_.set(i, storyStruct$Story);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$ResponseGetStoriesByList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0003\u0000\u0001\u001b\u0002\u001b\u0003\u001b", new Object[]{"userStories_", StoryStruct$Story.class, "channelStories_", StoryStruct$ChannelStory.class, "botStories_", StoryStruct$BotStory.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$ResponseGetStoriesByList.class) {
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

    public StoryStruct$BotStory getBotStories(int i) {
        return (StoryStruct$BotStory) this.botStories_.get(i);
    }

    public int getBotStoriesCount() {
        return this.botStories_.size();
    }

    public List<StoryStruct$BotStory> getBotStoriesList() {
        return this.botStories_;
    }

    public InterfaceC15380jU6 getBotStoriesOrBuilder(int i) {
        return (InterfaceC15380jU6) this.botStories_.get(i);
    }

    public List<? extends InterfaceC15380jU6> getBotStoriesOrBuilderList() {
        return this.botStories_;
    }

    public StoryStruct$ChannelStory getChannelStories(int i) {
        return (StoryStruct$ChannelStory) this.channelStories_.get(i);
    }

    public int getChannelStoriesCount() {
        return this.channelStories_.size();
    }

    public List<StoryStruct$ChannelStory> getChannelStoriesList() {
        return this.channelStories_;
    }

    public InterfaceC16562lU6 getChannelStoriesOrBuilder(int i) {
        return (InterfaceC16562lU6) this.channelStories_.get(i);
    }

    public List<? extends InterfaceC16562lU6> getChannelStoriesOrBuilderList() {
        return this.channelStories_;
    }

    public StoryStruct$Story getUserStories(int i) {
        return (StoryStruct$Story) this.userStories_.get(i);
    }

    public int getUserStoriesCount() {
        return this.userStories_.size();
    }

    public List<StoryStruct$Story> getUserStoriesList() {
        return this.userStories_;
    }

    public MU6 getUserStoriesOrBuilder(int i) {
        return (MU6) this.userStories_.get(i);
    }

    public List<? extends MU6> getUserStoriesOrBuilderList() {
        return this.userStories_;
    }

    public static a newBuilder(StoryOuterClass$ResponseGetStoriesByList storyOuterClass$ResponseGetStoriesByList) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$ResponseGetStoriesByList);
    }

    public static StoryOuterClass$ResponseGetStoriesByList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoriesByList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoriesByList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoriesByList parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$ResponseGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBotStories(int i, StoryStruct$BotStory storyStruct$BotStory) {
        storyStruct$BotStory.getClass();
        ensureBotStoriesIsMutable();
        this.botStories_.add(i, storyStruct$BotStory);
    }

    private void addChannelStories(int i, StoryStruct$ChannelStory storyStruct$ChannelStory) {
        storyStruct$ChannelStory.getClass();
        ensureChannelStoriesIsMutable();
        this.channelStories_.add(i, storyStruct$ChannelStory);
    }

    private void addUserStories(int i, StoryStruct$Story storyStruct$Story) {
        storyStruct$Story.getClass();
        ensureUserStoriesIsMutable();
        this.userStories_.add(i, storyStruct$Story);
    }

    public static StoryOuterClass$ResponseGetStoriesByList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoriesByList parseFrom(byte[] bArr) {
        return (StoryOuterClass$ResponseGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$ResponseGetStoriesByList parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoriesByList parseFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetStoriesByList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoriesByList parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$ResponseGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$ResponseGetStoriesByList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoriesByList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

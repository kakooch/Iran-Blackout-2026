package ai.bale.proto;

import ai.bale.proto.StoryStruct$BotStory;
import ai.bale.proto.StoryStruct$ChannelStory;
import ai.bale.proto.StoryStruct$Story;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StoryOuterClass$ResponseGetStoryById extends GeneratedMessageLite implements U64 {
    public static final int BOT_STORY_RESULT_FIELD_NUMBER = 3;
    public static final int CHANNEL_STORY_RESULT_FIELD_NUMBER = 2;
    private static final StoryOuterClass$ResponseGetStoryById DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int RESULT_FIELD_NUMBER = 1;
    private int bitField0_;
    private StoryStruct$BotStory botStoryResult_;
    private StoryStruct$ChannelStory channelStoryResult_;
    private StoryStruct$Story result_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryOuterClass$ResponseGetStoryById.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$ResponseGetStoryById storyOuterClass$ResponseGetStoryById = new StoryOuterClass$ResponseGetStoryById();
        DEFAULT_INSTANCE = storyOuterClass$ResponseGetStoryById;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$ResponseGetStoryById.class, storyOuterClass$ResponseGetStoryById);
    }

    private StoryOuterClass$ResponseGetStoryById() {
    }

    private void clearBotStoryResult() {
        this.botStoryResult_ = null;
        this.bitField0_ &= -5;
    }

    private void clearChannelStoryResult() {
        this.channelStoryResult_ = null;
        this.bitField0_ &= -3;
    }

    private void clearResult() {
        this.result_ = null;
        this.bitField0_ &= -2;
    }

    public static StoryOuterClass$ResponseGetStoryById getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBotStoryResult(StoryStruct$BotStory storyStruct$BotStory) {
        storyStruct$BotStory.getClass();
        StoryStruct$BotStory storyStruct$BotStory2 = this.botStoryResult_;
        if (storyStruct$BotStory2 == null || storyStruct$BotStory2 == StoryStruct$BotStory.getDefaultInstance()) {
            this.botStoryResult_ = storyStruct$BotStory;
        } else {
            this.botStoryResult_ = (StoryStruct$BotStory) ((StoryStruct$BotStory.a) StoryStruct$BotStory.newBuilder(this.botStoryResult_).v(storyStruct$BotStory)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeChannelStoryResult(StoryStruct$ChannelStory storyStruct$ChannelStory) {
        storyStruct$ChannelStory.getClass();
        StoryStruct$ChannelStory storyStruct$ChannelStory2 = this.channelStoryResult_;
        if (storyStruct$ChannelStory2 == null || storyStruct$ChannelStory2 == StoryStruct$ChannelStory.getDefaultInstance()) {
            this.channelStoryResult_ = storyStruct$ChannelStory;
        } else {
            this.channelStoryResult_ = (StoryStruct$ChannelStory) ((StoryStruct$ChannelStory.a) StoryStruct$ChannelStory.newBuilder(this.channelStoryResult_).v(storyStruct$ChannelStory)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeResult(StoryStruct$Story storyStruct$Story) {
        storyStruct$Story.getClass();
        StoryStruct$Story storyStruct$Story2 = this.result_;
        if (storyStruct$Story2 == null || storyStruct$Story2 == StoryStruct$Story.getDefaultInstance()) {
            this.result_ = storyStruct$Story;
        } else {
            this.result_ = (StoryStruct$Story) ((StoryStruct$Story.a) StoryStruct$Story.newBuilder(this.result_).v(storyStruct$Story)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$ResponseGetStoryById parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetStoryById) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetStoryById parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$ResponseGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotStoryResult(StoryStruct$BotStory storyStruct$BotStory) {
        storyStruct$BotStory.getClass();
        this.botStoryResult_ = storyStruct$BotStory;
        this.bitField0_ |= 4;
    }

    private void setChannelStoryResult(StoryStruct$ChannelStory storyStruct$ChannelStory) {
        storyStruct$ChannelStory.getClass();
        this.channelStoryResult_ = storyStruct$ChannelStory;
        this.bitField0_ |= 2;
    }

    private void setResult(StoryStruct$Story storyStruct$Story) {
        storyStruct$Story.getClass();
        this.result_ = storyStruct$Story;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$ResponseGetStoryById();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"bitField0_", "result_", "channelStoryResult_", "botStoryResult_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$ResponseGetStoryById.class) {
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

    public StoryStruct$BotStory getBotStoryResult() {
        StoryStruct$BotStory storyStruct$BotStory = this.botStoryResult_;
        return storyStruct$BotStory == null ? StoryStruct$BotStory.getDefaultInstance() : storyStruct$BotStory;
    }

    public StoryStruct$ChannelStory getChannelStoryResult() {
        StoryStruct$ChannelStory storyStruct$ChannelStory = this.channelStoryResult_;
        return storyStruct$ChannelStory == null ? StoryStruct$ChannelStory.getDefaultInstance() : storyStruct$ChannelStory;
    }

    public StoryStruct$Story getResult() {
        StoryStruct$Story storyStruct$Story = this.result_;
        return storyStruct$Story == null ? StoryStruct$Story.getDefaultInstance() : storyStruct$Story;
    }

    public boolean hasBotStoryResult() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasChannelStoryResult() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasResult() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(StoryOuterClass$ResponseGetStoryById storyOuterClass$ResponseGetStoryById) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$ResponseGetStoryById);
    }

    public static StoryOuterClass$ResponseGetStoryById parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoryById) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoryById parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoryById parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$ResponseGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryOuterClass$ResponseGetStoryById parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoryById parseFrom(byte[] bArr) {
        return (StoryOuterClass$ResponseGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$ResponseGetStoryById parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoryById parseFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetStoryById parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoryById parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$ResponseGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$ResponseGetStoryById parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

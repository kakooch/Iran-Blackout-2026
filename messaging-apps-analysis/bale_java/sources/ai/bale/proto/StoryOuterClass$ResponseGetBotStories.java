package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC15380jU6;
import ir.nasim.InterfaceC20717sU6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryOuterClass$ResponseGetBotStories extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$ResponseGetBotStories DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int POPULARITY_LIST_FIELD_NUMBER = 2;
    public static final int RESULT_FIELD_NUMBER = 1;
    private B.j result_ = GeneratedMessageLite.emptyProtobufList();
    private B.j popularityList_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryOuterClass$ResponseGetBotStories.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$ResponseGetBotStories storyOuterClass$ResponseGetBotStories = new StoryOuterClass$ResponseGetBotStories();
        DEFAULT_INSTANCE = storyOuterClass$ResponseGetBotStories;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$ResponseGetBotStories.class, storyOuterClass$ResponseGetBotStories);
    }

    private StoryOuterClass$ResponseGetBotStories() {
    }

    private void addAllPopularityList(Iterable<? extends StoryStruct$ExPeerPopularity> iterable) {
        ensurePopularityListIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.popularityList_);
    }

    private void addAllResult(Iterable<? extends StoryStruct$BotStory> iterable) {
        ensureResultIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.result_);
    }

    private void addPopularityList(StoryStruct$ExPeerPopularity storyStruct$ExPeerPopularity) {
        storyStruct$ExPeerPopularity.getClass();
        ensurePopularityListIsMutable();
        this.popularityList_.add(storyStruct$ExPeerPopularity);
    }

    private void addResult(StoryStruct$BotStory storyStruct$BotStory) {
        storyStruct$BotStory.getClass();
        ensureResultIsMutable();
        this.result_.add(storyStruct$BotStory);
    }

    private void clearPopularityList() {
        this.popularityList_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearResult() {
        this.result_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePopularityListIsMutable() {
        B.j jVar = this.popularityList_;
        if (jVar.u()) {
            return;
        }
        this.popularityList_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureResultIsMutable() {
        B.j jVar = this.result_;
        if (jVar.u()) {
            return;
        }
        this.result_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static StoryOuterClass$ResponseGetBotStories getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$ResponseGetBotStories parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetBotStories) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetBotStories parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$ResponseGetBotStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePopularityList(int i) {
        ensurePopularityListIsMutable();
        this.popularityList_.remove(i);
    }

    private void removeResult(int i) {
        ensureResultIsMutable();
        this.result_.remove(i);
    }

    private void setPopularityList(int i, StoryStruct$ExPeerPopularity storyStruct$ExPeerPopularity) {
        storyStruct$ExPeerPopularity.getClass();
        ensurePopularityListIsMutable();
        this.popularityList_.set(i, storyStruct$ExPeerPopularity);
    }

    private void setResult(int i, StoryStruct$BotStory storyStruct$BotStory) {
        storyStruct$BotStory.getClass();
        ensureResultIsMutable();
        this.result_.set(i, storyStruct$BotStory);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$ResponseGetBotStories();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"result_", StoryStruct$BotStory.class, "popularityList_", StoryStruct$ExPeerPopularity.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$ResponseGetBotStories.class) {
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

    public StoryStruct$ExPeerPopularity getPopularityList(int i) {
        return (StoryStruct$ExPeerPopularity) this.popularityList_.get(i);
    }

    public int getPopularityListCount() {
        return this.popularityList_.size();
    }

    public List<StoryStruct$ExPeerPopularity> getPopularityListList() {
        return this.popularityList_;
    }

    public InterfaceC20717sU6 getPopularityListOrBuilder(int i) {
        return (InterfaceC20717sU6) this.popularityList_.get(i);
    }

    public List<? extends InterfaceC20717sU6> getPopularityListOrBuilderList() {
        return this.popularityList_;
    }

    public StoryStruct$BotStory getResult(int i) {
        return (StoryStruct$BotStory) this.result_.get(i);
    }

    public int getResultCount() {
        return this.result_.size();
    }

    public List<StoryStruct$BotStory> getResultList() {
        return this.result_;
    }

    public InterfaceC15380jU6 getResultOrBuilder(int i) {
        return (InterfaceC15380jU6) this.result_.get(i);
    }

    public List<? extends InterfaceC15380jU6> getResultOrBuilderList() {
        return this.result_;
    }

    public static a newBuilder(StoryOuterClass$ResponseGetBotStories storyOuterClass$ResponseGetBotStories) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$ResponseGetBotStories);
    }

    public static StoryOuterClass$ResponseGetBotStories parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetBotStories) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetBotStories parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetBotStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$ResponseGetBotStories parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$ResponseGetBotStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPopularityList(int i, StoryStruct$ExPeerPopularity storyStruct$ExPeerPopularity) {
        storyStruct$ExPeerPopularity.getClass();
        ensurePopularityListIsMutable();
        this.popularityList_.add(i, storyStruct$ExPeerPopularity);
    }

    private void addResult(int i, StoryStruct$BotStory storyStruct$BotStory) {
        storyStruct$BotStory.getClass();
        ensureResultIsMutable();
        this.result_.add(i, storyStruct$BotStory);
    }

    public static StoryOuterClass$ResponseGetBotStories parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetBotStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$ResponseGetBotStories parseFrom(byte[] bArr) {
        return (StoryOuterClass$ResponseGetBotStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$ResponseGetBotStories parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetBotStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$ResponseGetBotStories parseFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetBotStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetBotStories parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetBotStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetBotStories parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$ResponseGetBotStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$ResponseGetBotStories parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetBotStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

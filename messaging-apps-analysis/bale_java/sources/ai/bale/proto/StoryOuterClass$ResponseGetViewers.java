package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11728dV6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryOuterClass$ResponseGetViewers extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$ResponseGetViewers DEFAULT_INSTANCE;
    public static final int EMOJI_COUNT_FIELD_NUMBER = 5;
    public static final int LIKE_COUNT_FIELD_NUMBER = 3;
    public static final int LINK_CLICK_COUNT_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int RESTORY_COUNT_FIELD_NUMBER = 6;
    public static final int VIEWERS_FIELD_NUMBER = 1;
    public static final int VIEW_COUNT_FIELD_NUMBER = 2;
    private int emojiCount_;
    private int likeCount_;
    private int linkClickCount_;
    private int restoryCount_;
    private int viewCount_;
    private B.j viewers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryOuterClass$ResponseGetViewers.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$ResponseGetViewers storyOuterClass$ResponseGetViewers = new StoryOuterClass$ResponseGetViewers();
        DEFAULT_INSTANCE = storyOuterClass$ResponseGetViewers;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$ResponseGetViewers.class, storyOuterClass$ResponseGetViewers);
    }

    private StoryOuterClass$ResponseGetViewers() {
    }

    private void addAllViewers(Iterable<? extends StoryStruct$Viewer> iterable) {
        ensureViewersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.viewers_);
    }

    private void addViewers(StoryStruct$Viewer storyStruct$Viewer) {
        storyStruct$Viewer.getClass();
        ensureViewersIsMutable();
        this.viewers_.add(storyStruct$Viewer);
    }

    private void clearEmojiCount() {
        this.emojiCount_ = 0;
    }

    private void clearLikeCount() {
        this.likeCount_ = 0;
    }

    private void clearLinkClickCount() {
        this.linkClickCount_ = 0;
    }

    private void clearRestoryCount() {
        this.restoryCount_ = 0;
    }

    private void clearViewCount() {
        this.viewCount_ = 0;
    }

    private void clearViewers() {
        this.viewers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureViewersIsMutable() {
        B.j jVar = this.viewers_;
        if (jVar.u()) {
            return;
        }
        this.viewers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static StoryOuterClass$ResponseGetViewers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$ResponseGetViewers parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetViewers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetViewers parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$ResponseGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeViewers(int i) {
        ensureViewersIsMutable();
        this.viewers_.remove(i);
    }

    private void setEmojiCount(int i) {
        this.emojiCount_ = i;
    }

    private void setLikeCount(int i) {
        this.likeCount_ = i;
    }

    private void setLinkClickCount(int i) {
        this.linkClickCount_ = i;
    }

    private void setRestoryCount(int i) {
        this.restoryCount_ = i;
    }

    private void setViewCount(int i) {
        this.viewCount_ = i;
    }

    private void setViewers(int i, StoryStruct$Viewer storyStruct$Viewer) {
        storyStruct$Viewer.getClass();
        ensureViewersIsMutable();
        this.viewers_.set(i, storyStruct$Viewer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$ResponseGetViewers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u001b\u0002\u0004\u0003\u0004\u0004\u0004\u0005\u0004\u0006\u0004", new Object[]{"viewers_", StoryStruct$Viewer.class, "viewCount_", "likeCount_", "linkClickCount_", "emojiCount_", "restoryCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$ResponseGetViewers.class) {
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

    public int getEmojiCount() {
        return this.emojiCount_;
    }

    public int getLikeCount() {
        return this.likeCount_;
    }

    public int getLinkClickCount() {
        return this.linkClickCount_;
    }

    public int getRestoryCount() {
        return this.restoryCount_;
    }

    public int getViewCount() {
        return this.viewCount_;
    }

    public StoryStruct$Viewer getViewers(int i) {
        return (StoryStruct$Viewer) this.viewers_.get(i);
    }

    public int getViewersCount() {
        return this.viewers_.size();
    }

    public List<StoryStruct$Viewer> getViewersList() {
        return this.viewers_;
    }

    public InterfaceC11728dV6 getViewersOrBuilder(int i) {
        return (InterfaceC11728dV6) this.viewers_.get(i);
    }

    public List<? extends InterfaceC11728dV6> getViewersOrBuilderList() {
        return this.viewers_;
    }

    public static a newBuilder(StoryOuterClass$ResponseGetViewers storyOuterClass$ResponseGetViewers) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$ResponseGetViewers);
    }

    public static StoryOuterClass$ResponseGetViewers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetViewers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetViewers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$ResponseGetViewers parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$ResponseGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addViewers(int i, StoryStruct$Viewer storyStruct$Viewer) {
        storyStruct$Viewer.getClass();
        ensureViewersIsMutable();
        this.viewers_.add(i, storyStruct$Viewer);
    }

    public static StoryOuterClass$ResponseGetViewers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$ResponseGetViewers parseFrom(byte[] bArr) {
        return (StoryOuterClass$ResponseGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$ResponseGetViewers parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$ResponseGetViewers parseFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetViewers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetViewers parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$ResponseGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$ResponseGetViewers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StoryOuterClass$ResponseGetViewersCount extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$ResponseGetViewersCount DEFAULT_INSTANCE;
    public static final int EMOJI_COUNT_FIELD_NUMBER = 4;
    public static final int LIKE_COUNT_FIELD_NUMBER = 2;
    public static final int LINK_CLICK_COUNT_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int RESTORY_COUNT_FIELD_NUMBER = 5;
    public static final int VIEW_COUNT_FIELD_NUMBER = 1;
    private int emojiCount_;
    private int likeCount_;
    private int linkClickCount_;
    private int restoryCount_;
    private int viewCount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryOuterClass$ResponseGetViewersCount.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$ResponseGetViewersCount storyOuterClass$ResponseGetViewersCount = new StoryOuterClass$ResponseGetViewersCount();
        DEFAULT_INSTANCE = storyOuterClass$ResponseGetViewersCount;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$ResponseGetViewersCount.class, storyOuterClass$ResponseGetViewersCount);
    }

    private StoryOuterClass$ResponseGetViewersCount() {
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

    public static StoryOuterClass$ResponseGetViewersCount getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$ResponseGetViewersCount parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetViewersCount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetViewersCount parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$ResponseGetViewersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$ResponseGetViewersCount();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004\u0004\u0004\u0005\u0004", new Object[]{"viewCount_", "likeCount_", "linkClickCount_", "emojiCount_", "restoryCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$ResponseGetViewersCount.class) {
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

    public static a newBuilder(StoryOuterClass$ResponseGetViewersCount storyOuterClass$ResponseGetViewersCount) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$ResponseGetViewersCount);
    }

    public static StoryOuterClass$ResponseGetViewersCount parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetViewersCount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetViewersCount parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetViewersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$ResponseGetViewersCount parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$ResponseGetViewersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryOuterClass$ResponseGetViewersCount parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetViewersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$ResponseGetViewersCount parseFrom(byte[] bArr) {
        return (StoryOuterClass$ResponseGetViewersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$ResponseGetViewersCount parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetViewersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$ResponseGetViewersCount parseFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetViewersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetViewersCount parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetViewersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetViewersCount parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$ResponseGetViewersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$ResponseGetViewersCount parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetViewersCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

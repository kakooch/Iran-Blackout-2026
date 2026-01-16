package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC19517qU6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryOuterClass$ResponseGetStoryReactionEmojis extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$ResponseGetStoryReactionEmojis DEFAULT_INSTANCE;
    public static final int EMOJIS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j emojis_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryOuterClass$ResponseGetStoryReactionEmojis.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$ResponseGetStoryReactionEmojis storyOuterClass$ResponseGetStoryReactionEmojis = new StoryOuterClass$ResponseGetStoryReactionEmojis();
        DEFAULT_INSTANCE = storyOuterClass$ResponseGetStoryReactionEmojis;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$ResponseGetStoryReactionEmojis.class, storyOuterClass$ResponseGetStoryReactionEmojis);
    }

    private StoryOuterClass$ResponseGetStoryReactionEmojis() {
    }

    private void addAllEmojis(Iterable<? extends StoryStruct$Emoji> iterable) {
        ensureEmojisIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.emojis_);
    }

    private void addEmojis(StoryStruct$Emoji storyStruct$Emoji) {
        storyStruct$Emoji.getClass();
        ensureEmojisIsMutable();
        this.emojis_.add(storyStruct$Emoji);
    }

    private void clearEmojis() {
        this.emojis_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureEmojisIsMutable() {
        B.j jVar = this.emojis_;
        if (jVar.u()) {
            return;
        }
        this.emojis_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static StoryOuterClass$ResponseGetStoryReactionEmojis getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$ResponseGetStoryReactionEmojis parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetStoryReactionEmojis) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetStoryReactionEmojis parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$ResponseGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeEmojis(int i) {
        ensureEmojisIsMutable();
        this.emojis_.remove(i);
    }

    private void setEmojis(int i, StoryStruct$Emoji storyStruct$Emoji) {
        storyStruct$Emoji.getClass();
        ensureEmojisIsMutable();
        this.emojis_.set(i, storyStruct$Emoji);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$ResponseGetStoryReactionEmojis();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"emojis_", StoryStruct$Emoji.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$ResponseGetStoryReactionEmojis.class) {
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

    public StoryStruct$Emoji getEmojis(int i) {
        return (StoryStruct$Emoji) this.emojis_.get(i);
    }

    public int getEmojisCount() {
        return this.emojis_.size();
    }

    public List<StoryStruct$Emoji> getEmojisList() {
        return this.emojis_;
    }

    public InterfaceC19517qU6 getEmojisOrBuilder(int i) {
        return (InterfaceC19517qU6) this.emojis_.get(i);
    }

    public List<? extends InterfaceC19517qU6> getEmojisOrBuilderList() {
        return this.emojis_;
    }

    public static a newBuilder(StoryOuterClass$ResponseGetStoryReactionEmojis storyOuterClass$ResponseGetStoryReactionEmojis) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$ResponseGetStoryReactionEmojis);
    }

    public static StoryOuterClass$ResponseGetStoryReactionEmojis parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoryReactionEmojis) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoryReactionEmojis parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoryReactionEmojis parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$ResponseGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addEmojis(int i, StoryStruct$Emoji storyStruct$Emoji) {
        storyStruct$Emoji.getClass();
        ensureEmojisIsMutable();
        this.emojis_.add(i, storyStruct$Emoji);
    }

    public static StoryOuterClass$ResponseGetStoryReactionEmojis parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoryReactionEmojis parseFrom(byte[] bArr) {
        return (StoryOuterClass$ResponseGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$ResponseGetStoryReactionEmojis parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoryReactionEmojis parseFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetStoryReactionEmojis parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoryReactionEmojis parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$ResponseGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$ResponseGetStoryReactionEmojis parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

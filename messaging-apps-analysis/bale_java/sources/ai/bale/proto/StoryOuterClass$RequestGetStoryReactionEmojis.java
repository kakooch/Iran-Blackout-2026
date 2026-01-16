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
public final class StoryOuterClass$RequestGetStoryReactionEmojis extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$RequestGetStoryReactionEmojis DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryOuterClass$RequestGetStoryReactionEmojis.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$RequestGetStoryReactionEmojis storyOuterClass$RequestGetStoryReactionEmojis = new StoryOuterClass$RequestGetStoryReactionEmojis();
        DEFAULT_INSTANCE = storyOuterClass$RequestGetStoryReactionEmojis;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$RequestGetStoryReactionEmojis.class, storyOuterClass$RequestGetStoryReactionEmojis);
    }

    private StoryOuterClass$RequestGetStoryReactionEmojis() {
    }

    public static StoryOuterClass$RequestGetStoryReactionEmojis getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$RequestGetStoryReactionEmojis parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestGetStoryReactionEmojis) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestGetStoryReactionEmojis parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$RequestGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$RequestGetStoryReactionEmojis();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$RequestGetStoryReactionEmojis.class) {
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

    public static a newBuilder(StoryOuterClass$RequestGetStoryReactionEmojis storyOuterClass$RequestGetStoryReactionEmojis) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$RequestGetStoryReactionEmojis);
    }

    public static StoryOuterClass$RequestGetStoryReactionEmojis parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStoryReactionEmojis) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestGetStoryReactionEmojis parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$RequestGetStoryReactionEmojis parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$RequestGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryOuterClass$RequestGetStoryReactionEmojis parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$RequestGetStoryReactionEmojis parseFrom(byte[] bArr) {
        return (StoryOuterClass$RequestGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$RequestGetStoryReactionEmojis parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$RequestGetStoryReactionEmojis parseFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestGetStoryReactionEmojis parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestGetStoryReactionEmojis parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$RequestGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$RequestGetStoryReactionEmojis parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStoryReactionEmojis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

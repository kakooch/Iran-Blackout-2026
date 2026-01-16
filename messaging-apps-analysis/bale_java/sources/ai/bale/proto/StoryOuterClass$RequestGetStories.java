package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StoryOuterClass$RequestGetStories extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$RequestGetStories DEFAULT_INSTANCE;
    public static final int GET_UNMUTUAL_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private BoolValue getUnmutual_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryOuterClass$RequestGetStories.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$RequestGetStories storyOuterClass$RequestGetStories = new StoryOuterClass$RequestGetStories();
        DEFAULT_INSTANCE = storyOuterClass$RequestGetStories;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$RequestGetStories.class, storyOuterClass$RequestGetStories);
    }

    private StoryOuterClass$RequestGetStories() {
    }

    private void clearGetUnmutual() {
        this.getUnmutual_ = null;
        this.bitField0_ &= -2;
    }

    public static StoryOuterClass$RequestGetStories getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGetUnmutual(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.getUnmutual_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.getUnmutual_ = boolValue;
        } else {
            this.getUnmutual_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.getUnmutual_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$RequestGetStories parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestGetStories) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestGetStories parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$RequestGetStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGetUnmutual(BoolValue boolValue) {
        boolValue.getClass();
        this.getUnmutual_ = boolValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$RequestGetStories();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "getUnmutual_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$RequestGetStories.class) {
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

    public BoolValue getGetUnmutual() {
        BoolValue boolValue = this.getUnmutual_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public boolean hasGetUnmutual() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(StoryOuterClass$RequestGetStories storyOuterClass$RequestGetStories) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$RequestGetStories);
    }

    public static StoryOuterClass$RequestGetStories parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStories) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestGetStories parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$RequestGetStories parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$RequestGetStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryOuterClass$RequestGetStories parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$RequestGetStories parseFrom(byte[] bArr) {
        return (StoryOuterClass$RequestGetStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$RequestGetStories parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$RequestGetStories parseFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestGetStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestGetStories parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestGetStories parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$RequestGetStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$RequestGetStories parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

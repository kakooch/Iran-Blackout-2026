package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.LU6;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StoryOuterClass$RequestGetMostPopularStories extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$RequestGetMostPopularStories DEFAULT_INSTANCE;
    public static final int GET_SPECIAL_STORIES_FIELD_NUMBER = 1;
    public static final int OPTIMIZATION_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private BoolValue getSpecialStories_;
    private int optimization_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(LU6 lu6) {
            q();
            ((StoryOuterClass$RequestGetMostPopularStories) this.b).setOptimization(lu6);
            return this;
        }

        private a() {
            super(StoryOuterClass$RequestGetMostPopularStories.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$RequestGetMostPopularStories storyOuterClass$RequestGetMostPopularStories = new StoryOuterClass$RequestGetMostPopularStories();
        DEFAULT_INSTANCE = storyOuterClass$RequestGetMostPopularStories;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$RequestGetMostPopularStories.class, storyOuterClass$RequestGetMostPopularStories);
    }

    private StoryOuterClass$RequestGetMostPopularStories() {
    }

    private void clearGetSpecialStories() {
        this.getSpecialStories_ = null;
        this.bitField0_ &= -2;
    }

    private void clearOptimization() {
        this.optimization_ = 0;
    }

    public static StoryOuterClass$RequestGetMostPopularStories getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGetSpecialStories(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.getSpecialStories_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.getSpecialStories_ = boolValue;
        } else {
            this.getSpecialStories_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.getSpecialStories_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$RequestGetMostPopularStories parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestGetMostPopularStories) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestGetMostPopularStories parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$RequestGetMostPopularStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGetSpecialStories(BoolValue boolValue) {
        boolValue.getClass();
        this.getSpecialStories_ = boolValue;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOptimization(LU6 lu6) {
        this.optimization_ = lu6.getNumber();
    }

    private void setOptimizationValue(int i) {
        this.optimization_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$RequestGetMostPopularStories();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f", new Object[]{"bitField0_", "getSpecialStories_", "optimization_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$RequestGetMostPopularStories.class) {
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

    public BoolValue getGetSpecialStories() {
        BoolValue boolValue = this.getSpecialStories_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public LU6 getOptimization() {
        LU6 lu6J = LU6.j(this.optimization_);
        return lu6J == null ? LU6.UNRECOGNIZED : lu6J;
    }

    public int getOptimizationValue() {
        return this.optimization_;
    }

    public boolean hasGetSpecialStories() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(StoryOuterClass$RequestGetMostPopularStories storyOuterClass$RequestGetMostPopularStories) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$RequestGetMostPopularStories);
    }

    public static StoryOuterClass$RequestGetMostPopularStories parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestGetMostPopularStories) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestGetMostPopularStories parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$RequestGetMostPopularStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$RequestGetMostPopularStories parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$RequestGetMostPopularStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryOuterClass$RequestGetMostPopularStories parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$RequestGetMostPopularStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$RequestGetMostPopularStories parseFrom(byte[] bArr) {
        return (StoryOuterClass$RequestGetMostPopularStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$RequestGetMostPopularStories parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$RequestGetMostPopularStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$RequestGetMostPopularStories parseFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestGetMostPopularStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestGetMostPopularStories parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestGetMostPopularStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestGetMostPopularStories parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$RequestGetMostPopularStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$RequestGetMostPopularStories parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$RequestGetMostPopularStories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

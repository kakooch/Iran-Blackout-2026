package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.OU6;
import ir.nasim.PU6;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StoryStruct$StoryReaction extends GeneratedMessageLite implements OU6 {
    private static final StoryStruct$StoryReaction DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REACTION_TEXT_FIELD_NUMBER = 2;
    public static final int REACTION_TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private StringValue reactionText_;
    private int reactionType_;

    public static final class a extends GeneratedMessageLite.b implements OU6 {
        private a() {
            super(StoryStruct$StoryReaction.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$StoryReaction storyStruct$StoryReaction = new StoryStruct$StoryReaction();
        DEFAULT_INSTANCE = storyStruct$StoryReaction;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$StoryReaction.class, storyStruct$StoryReaction);
    }

    private StoryStruct$StoryReaction() {
    }

    private void clearReactionText() {
        this.reactionText_ = null;
        this.bitField0_ &= -2;
    }

    private void clearReactionType() {
        this.reactionType_ = 0;
    }

    public static StoryStruct$StoryReaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeReactionText(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.reactionText_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.reactionText_ = stringValue;
        } else {
            this.reactionText_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.reactionText_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$StoryReaction parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$StoryReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$StoryReaction parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$StoryReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setReactionText(StringValue stringValue) {
        stringValue.getClass();
        this.reactionText_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setReactionType(PU6 pu6) {
        this.reactionType_ = pu6.getNumber();
    }

    private void setReactionTypeValue(int i) {
        this.reactionType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$StoryReaction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000", new Object[]{"bitField0_", "reactionType_", "reactionText_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$StoryReaction.class) {
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

    public StringValue getReactionText() {
        StringValue stringValue = this.reactionText_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public PU6 getReactionType() {
        PU6 pu6J = PU6.j(this.reactionType_);
        return pu6J == null ? PU6.UNRECOGNIZED : pu6J;
    }

    public int getReactionTypeValue() {
        return this.reactionType_;
    }

    public boolean hasReactionText() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(StoryStruct$StoryReaction storyStruct$StoryReaction) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$StoryReaction);
    }

    public static StoryStruct$StoryReaction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$StoryReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$StoryReaction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$StoryReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$StoryReaction parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$StoryReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryStruct$StoryReaction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$StoryReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$StoryReaction parseFrom(byte[] bArr) {
        return (StoryStruct$StoryReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$StoryReaction parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$StoryReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$StoryReaction parseFrom(InputStream inputStream) {
        return (StoryStruct$StoryReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$StoryReaction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$StoryReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$StoryReaction parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$StoryReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$StoryReaction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$StoryReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

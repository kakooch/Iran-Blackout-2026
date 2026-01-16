package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.PU6;
import ir.nasim.QU6;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StoryOuterClass$RequestReactToStory extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$RequestReactToStory DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REACTION_FIELD_NUMBER = 2;
    public static final int REACTION_TEXT_FIELD_NUMBER = 5;
    public static final int REACTION_TYPE_FIELD_NUMBER = 4;
    public static final int STORY_ID_FIELD_NUMBER = 1;
    public static final int TYPE_FIELD_NUMBER = 3;
    private int bitField0_;
    private StringValue reactionText_;
    private int reactionType_;
    private int type_;
    private String storyId_ = "";
    private String reaction_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((StoryOuterClass$RequestReactToStory) this.b).setReaction(str);
            return this;
        }

        public a B(StringValue stringValue) {
            q();
            ((StoryOuterClass$RequestReactToStory) this.b).setReactionText(stringValue);
            return this;
        }

        public a C(PU6 pu6) {
            q();
            ((StoryOuterClass$RequestReactToStory) this.b).setReactionType(pu6);
            return this;
        }

        public a D(String str) {
            q();
            ((StoryOuterClass$RequestReactToStory) this.b).setStoryId(str);
            return this;
        }

        public a E(QU6 qu6) {
            q();
            ((StoryOuterClass$RequestReactToStory) this.b).setType(qu6);
            return this;
        }

        private a() {
            super(StoryOuterClass$RequestReactToStory.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$RequestReactToStory storyOuterClass$RequestReactToStory = new StoryOuterClass$RequestReactToStory();
        DEFAULT_INSTANCE = storyOuterClass$RequestReactToStory;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$RequestReactToStory.class, storyOuterClass$RequestReactToStory);
    }

    private StoryOuterClass$RequestReactToStory() {
    }

    private void clearReaction() {
        this.reaction_ = getDefaultInstance().getReaction();
    }

    private void clearReactionText() {
        this.reactionText_ = null;
        this.bitField0_ &= -2;
    }

    private void clearReactionType() {
        this.reactionType_ = 0;
    }

    private void clearStoryId() {
        this.storyId_ = getDefaultInstance().getStoryId();
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static StoryOuterClass$RequestReactToStory getDefaultInstance() {
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

    public static StoryOuterClass$RequestReactToStory parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestReactToStory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestReactToStory parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$RequestReactToStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReaction(String str) {
        str.getClass();
        this.reaction_ = str;
    }

    private void setReactionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.reaction_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReactionText(StringValue stringValue) {
        stringValue.getClass();
        this.reactionText_ = stringValue;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReactionType(PU6 pu6) {
        this.reactionType_ = pu6.getNumber();
    }

    private void setReactionTypeValue(int i) {
        this.reactionType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStoryId(String str) {
        str.getClass();
        this.storyId_ = str;
    }

    private void setStoryIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.storyId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(QU6 qu6) {
        this.type_ = qu6.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$RequestReactToStory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\f\u0004\f\u0005ဉ\u0000", new Object[]{"bitField0_", "storyId_", "reaction_", "type_", "reactionType_", "reactionText_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$RequestReactToStory.class) {
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

    public String getReaction() {
        return this.reaction_;
    }

    public AbstractC2383g getReactionBytes() {
        return AbstractC2383g.N(this.reaction_);
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

    public String getStoryId() {
        return this.storyId_;
    }

    public AbstractC2383g getStoryIdBytes() {
        return AbstractC2383g.N(this.storyId_);
    }

    public QU6 getType() {
        QU6 qu6J = QU6.j(this.type_);
        return qu6J == null ? QU6.UNRECOGNIZED : qu6J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public boolean hasReactionText() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(StoryOuterClass$RequestReactToStory storyOuterClass$RequestReactToStory) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$RequestReactToStory);
    }

    public static StoryOuterClass$RequestReactToStory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestReactToStory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestReactToStory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$RequestReactToStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$RequestReactToStory parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$RequestReactToStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryOuterClass$RequestReactToStory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$RequestReactToStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$RequestReactToStory parseFrom(byte[] bArr) {
        return (StoryOuterClass$RequestReactToStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$RequestReactToStory parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$RequestReactToStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$RequestReactToStory parseFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestReactToStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestReactToStory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestReactToStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestReactToStory parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$RequestReactToStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$RequestReactToStory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$RequestReactToStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

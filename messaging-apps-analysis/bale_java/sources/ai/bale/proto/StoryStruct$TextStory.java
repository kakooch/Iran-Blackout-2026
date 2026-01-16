package ai.bale.proto;

import ai.bale.proto.StoryStruct$TextConfig;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StoryStruct$TextStory extends GeneratedMessageLite implements U64 {
    public static final int CONFIG_FIELD_NUMBER = 2;
    private static final StoryStruct$TextStory DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 1;
    private int bitField0_;
    private StoryStruct$TextConfig config_;
    private String text_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((StoryStruct$TextStory) this.b).setText(str);
            return this;
        }

        private a() {
            super(StoryStruct$TextStory.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$TextStory storyStruct$TextStory = new StoryStruct$TextStory();
        DEFAULT_INSTANCE = storyStruct$TextStory;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$TextStory.class, storyStruct$TextStory);
    }

    private StoryStruct$TextStory() {
    }

    private void clearConfig() {
        this.config_ = null;
        this.bitField0_ &= -2;
    }

    private void clearText() {
        this.text_ = getDefaultInstance().getText();
    }

    public static StoryStruct$TextStory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeConfig(StoryStruct$TextConfig storyStruct$TextConfig) {
        storyStruct$TextConfig.getClass();
        StoryStruct$TextConfig storyStruct$TextConfig2 = this.config_;
        if (storyStruct$TextConfig2 == null || storyStruct$TextConfig2 == StoryStruct$TextConfig.getDefaultInstance()) {
            this.config_ = storyStruct$TextConfig;
        } else {
            this.config_ = (StoryStruct$TextConfig) ((StoryStruct$TextConfig.a) StoryStruct$TextConfig.newBuilder(this.config_).v(storyStruct$TextConfig)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$TextStory parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$TextStory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$TextStory parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$TextStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setConfig(StoryStruct$TextConfig storyStruct$TextConfig) {
        storyStruct$TextConfig.getClass();
        this.config_ = storyStruct$TextConfig;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setText(String str) {
        str.getClass();
        this.text_ = str;
    }

    private void setTextBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.text_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$TextStory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "text_", "config_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$TextStory.class) {
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

    public StoryStruct$TextConfig getConfig() {
        StoryStruct$TextConfig storyStruct$TextConfig = this.config_;
        return storyStruct$TextConfig == null ? StoryStruct$TextConfig.getDefaultInstance() : storyStruct$TextConfig;
    }

    public String getText() {
        return this.text_;
    }

    public AbstractC2383g getTextBytes() {
        return AbstractC2383g.N(this.text_);
    }

    public boolean hasConfig() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(StoryStruct$TextStory storyStruct$TextStory) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$TextStory);
    }

    public static StoryStruct$TextStory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$TextStory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$TextStory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$TextStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$TextStory parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$TextStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryStruct$TextStory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$TextStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$TextStory parseFrom(byte[] bArr) {
        return (StoryStruct$TextStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$TextStory parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$TextStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$TextStory parseFrom(InputStream inputStream) {
        return (StoryStruct$TextStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$TextStory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$TextStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$TextStory parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$TextStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$TextStory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$TextStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

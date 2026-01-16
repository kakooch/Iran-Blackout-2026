package ai.bale.proto;

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
public final class StoryStruct$TextConfig extends GeneratedMessageLite implements U64 {
    public static final int BACKGROUND_COLOR_FIELD_NUMBER = 2;
    private static final StoryStruct$TextConfig DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TEXT_COLOR_FIELD_NUMBER = 3;
    public static final int TEXT_FONT_FIELD_NUMBER = 1;
    private String textFont_ = "";
    private String backgroundColor_ = "";
    private String textColor_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryStruct$TextConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$TextConfig storyStruct$TextConfig = new StoryStruct$TextConfig();
        DEFAULT_INSTANCE = storyStruct$TextConfig;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$TextConfig.class, storyStruct$TextConfig);
    }

    private StoryStruct$TextConfig() {
    }

    private void clearBackgroundColor() {
        this.backgroundColor_ = getDefaultInstance().getBackgroundColor();
    }

    private void clearTextColor() {
        this.textColor_ = getDefaultInstance().getTextColor();
    }

    private void clearTextFont() {
        this.textFont_ = getDefaultInstance().getTextFont();
    }

    public static StoryStruct$TextConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$TextConfig parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$TextConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$TextConfig parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$TextConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBackgroundColor(String str) {
        str.getClass();
        this.backgroundColor_ = str;
    }

    private void setBackgroundColorBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.backgroundColor_ = abstractC2383g.f0();
    }

    private void setTextColor(String str) {
        str.getClass();
        this.textColor_ = str;
    }

    private void setTextColorBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.textColor_ = abstractC2383g.f0();
    }

    private void setTextFont(String str) {
        str.getClass();
        this.textFont_ = str;
    }

    private void setTextFontBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.textFont_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$TextConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"textFont_", "backgroundColor_", "textColor_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$TextConfig.class) {
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

    public String getBackgroundColor() {
        return this.backgroundColor_;
    }

    public AbstractC2383g getBackgroundColorBytes() {
        return AbstractC2383g.N(this.backgroundColor_);
    }

    public String getTextColor() {
        return this.textColor_;
    }

    public AbstractC2383g getTextColorBytes() {
        return AbstractC2383g.N(this.textColor_);
    }

    public String getTextFont() {
        return this.textFont_;
    }

    public AbstractC2383g getTextFontBytes() {
        return AbstractC2383g.N(this.textFont_);
    }

    public static a newBuilder(StoryStruct$TextConfig storyStruct$TextConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$TextConfig);
    }

    public static StoryStruct$TextConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$TextConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$TextConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$TextConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$TextConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$TextConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryStruct$TextConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$TextConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$TextConfig parseFrom(byte[] bArr) {
        return (StoryStruct$TextConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$TextConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$TextConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$TextConfig parseFrom(InputStream inputStream) {
        return (StoryStruct$TextConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$TextConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$TextConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$TextConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$TextConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$TextConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$TextConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

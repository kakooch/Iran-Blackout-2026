package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.SU6;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StoryStruct$Tag extends GeneratedMessageLite implements SU6 {
    public static final int COLOR_FIELD_NUMBER = 3;
    private static final StoryStruct$Tag DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 2;
    private int id_;
    private String title_ = "";
    private String color_ = "";

    public static final class a extends GeneratedMessageLite.b implements SU6 {
        private a() {
            super(StoryStruct$Tag.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$Tag storyStruct$Tag = new StoryStruct$Tag();
        DEFAULT_INSTANCE = storyStruct$Tag;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$Tag.class, storyStruct$Tag);
    }

    private StoryStruct$Tag() {
    }

    private void clearColor() {
        this.color_ = getDefaultInstance().getColor();
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static StoryStruct$Tag getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$Tag parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$Tag) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$Tag parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$Tag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setColor(String str) {
        str.getClass();
        this.color_ = str;
    }

    private void setColorBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.color_ = abstractC2383g.f0();
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$Tag();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ", new Object[]{"id_", "title_", "color_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$Tag.class) {
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

    public String getColor() {
        return this.color_;
    }

    public AbstractC2383g getColorBytes() {
        return AbstractC2383g.N(this.color_);
    }

    public int getId() {
        return this.id_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public static a newBuilder(StoryStruct$Tag storyStruct$Tag) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$Tag);
    }

    public static StoryStruct$Tag parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$Tag) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$Tag parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$Tag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$Tag parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$Tag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryStruct$Tag parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$Tag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$Tag parseFrom(byte[] bArr) {
        return (StoryStruct$Tag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$Tag parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$Tag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$Tag parseFrom(InputStream inputStream) {
        return (StoryStruct$Tag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$Tag parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$Tag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$Tag parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$Tag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$Tag parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$Tag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

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
public final class StoryStruct$PollWidget extends GeneratedMessageLite implements U64 {
    private static final StoryStruct$PollWidget DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int QUESTION_FIELD_NUMBER = 1;
    private String question_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryStruct$PollWidget.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$PollWidget storyStruct$PollWidget = new StoryStruct$PollWidget();
        DEFAULT_INSTANCE = storyStruct$PollWidget;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$PollWidget.class, storyStruct$PollWidget);
    }

    private StoryStruct$PollWidget() {
    }

    private void clearQuestion() {
        this.question_ = getDefaultInstance().getQuestion();
    }

    public static StoryStruct$PollWidget getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$PollWidget parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$PollWidget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$PollWidget parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$PollWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setQuestion(String str) {
        str.getClass();
        this.question_ = str;
    }

    private void setQuestionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.question_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$PollWidget();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"question_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$PollWidget.class) {
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

    public String getQuestion() {
        return this.question_;
    }

    public AbstractC2383g getQuestionBytes() {
        return AbstractC2383g.N(this.question_);
    }

    public static a newBuilder(StoryStruct$PollWidget storyStruct$PollWidget) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$PollWidget);
    }

    public static StoryStruct$PollWidget parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$PollWidget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$PollWidget parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$PollWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$PollWidget parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$PollWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryStruct$PollWidget parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$PollWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$PollWidget parseFrom(byte[] bArr) {
        return (StoryStruct$PollWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$PollWidget parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$PollWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$PollWidget parseFrom(InputStream inputStream) {
        return (StoryStruct$PollWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$PollWidget parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$PollWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$PollWidget parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$PollWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$PollWidget parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$PollWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

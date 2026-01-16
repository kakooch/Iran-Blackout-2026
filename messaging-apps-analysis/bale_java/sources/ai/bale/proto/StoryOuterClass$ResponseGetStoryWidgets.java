package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryOuterClass$ResponseGetStoryWidgets extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$ResponseGetStoryWidgets DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int WIDGETS_FIELD_NUMBER = 1;
    private B.j widgets_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryOuterClass$ResponseGetStoryWidgets.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$ResponseGetStoryWidgets storyOuterClass$ResponseGetStoryWidgets = new StoryOuterClass$ResponseGetStoryWidgets();
        DEFAULT_INSTANCE = storyOuterClass$ResponseGetStoryWidgets;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$ResponseGetStoryWidgets.class, storyOuterClass$ResponseGetStoryWidgets);
    }

    private StoryOuterClass$ResponseGetStoryWidgets() {
    }

    private void addAllWidgets(Iterable<? extends StoryStruct$Widget> iterable) {
        ensureWidgetsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.widgets_);
    }

    private void addWidgets(StoryStruct$Widget storyStruct$Widget) {
        storyStruct$Widget.getClass();
        ensureWidgetsIsMutable();
        this.widgets_.add(storyStruct$Widget);
    }

    private void clearWidgets() {
        this.widgets_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureWidgetsIsMutable() {
        B.j jVar = this.widgets_;
        if (jVar.u()) {
            return;
        }
        this.widgets_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static StoryOuterClass$ResponseGetStoryWidgets getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$ResponseGetStoryWidgets parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetStoryWidgets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetStoryWidgets parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$ResponseGetStoryWidgets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeWidgets(int i) {
        ensureWidgetsIsMutable();
        this.widgets_.remove(i);
    }

    private void setWidgets(int i, StoryStruct$Widget storyStruct$Widget) {
        storyStruct$Widget.getClass();
        ensureWidgetsIsMutable();
        this.widgets_.set(i, storyStruct$Widget);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$ResponseGetStoryWidgets();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"widgets_", StoryStruct$Widget.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$ResponseGetStoryWidgets.class) {
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

    public StoryStruct$Widget getWidgets(int i) {
        return (StoryStruct$Widget) this.widgets_.get(i);
    }

    public int getWidgetsCount() {
        return this.widgets_.size();
    }

    public List<StoryStruct$Widget> getWidgetsList() {
        return this.widgets_;
    }

    public f2 getWidgetsOrBuilder(int i) {
        return (f2) this.widgets_.get(i);
    }

    public List<? extends f2> getWidgetsOrBuilderList() {
        return this.widgets_;
    }

    public static a newBuilder(StoryOuterClass$ResponseGetStoryWidgets storyOuterClass$ResponseGetStoryWidgets) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$ResponseGetStoryWidgets);
    }

    public static StoryOuterClass$ResponseGetStoryWidgets parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoryWidgets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoryWidgets parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoryWidgets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoryWidgets parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$ResponseGetStoryWidgets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addWidgets(int i, StoryStruct$Widget storyStruct$Widget) {
        storyStruct$Widget.getClass();
        ensureWidgetsIsMutable();
        this.widgets_.add(i, storyStruct$Widget);
    }

    public static StoryOuterClass$ResponseGetStoryWidgets parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoryWidgets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoryWidgets parseFrom(byte[] bArr) {
        return (StoryOuterClass$ResponseGetStoryWidgets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$ResponseGetStoryWidgets parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoryWidgets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoryWidgets parseFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetStoryWidgets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetStoryWidgets parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoryWidgets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetStoryWidgets parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$ResponseGetStoryWidgets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$ResponseGetStoryWidgets parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetStoryWidgets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

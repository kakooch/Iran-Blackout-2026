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
public final class StoryStruct$PostWidget extends GeneratedMessageLite implements U64 {
    private static final StoryStruct$PostWidget DEFAULT_INSTANCE;
    public static final int LINK_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String link_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((StoryStruct$PostWidget) this.b).setLink(str);
            return this;
        }

        private a() {
            super(StoryStruct$PostWidget.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$PostWidget storyStruct$PostWidget = new StoryStruct$PostWidget();
        DEFAULT_INSTANCE = storyStruct$PostWidget;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$PostWidget.class, storyStruct$PostWidget);
    }

    private StoryStruct$PostWidget() {
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    public static StoryStruct$PostWidget getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$PostWidget parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$PostWidget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$PostWidget parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$PostWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLink(String str) {
        str.getClass();
        this.link_ = str;
    }

    private void setLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.link_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$PostWidget();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"link_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$PostWidget.class) {
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

    public String getLink() {
        return this.link_;
    }

    public AbstractC2383g getLinkBytes() {
        return AbstractC2383g.N(this.link_);
    }

    public static a newBuilder(StoryStruct$PostWidget storyStruct$PostWidget) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$PostWidget);
    }

    public static StoryStruct$PostWidget parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$PostWidget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$PostWidget parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$PostWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$PostWidget parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$PostWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryStruct$PostWidget parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$PostWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$PostWidget parseFrom(byte[] bArr) {
        return (StoryStruct$PostWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$PostWidget parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$PostWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$PostWidget parseFrom(InputStream inputStream) {
        return (StoryStruct$PostWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$PostWidget parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$PostWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$PostWidget parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$PostWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$PostWidget parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$PostWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

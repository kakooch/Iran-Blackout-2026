package ai.bale.proto;

import ai.bale.proto.StoryStruct$LinkWidget;
import ai.bale.proto.StoryStruct$PollWidget;
import ai.bale.proto.StoryStruct$Position;
import ai.bale.proto.StoryStruct$PostWidget;
import ai.bale.proto.StoryStruct$ReStoryWidget;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC13598gV6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StoryStruct$Widget extends GeneratedMessageLite implements f2 {
    private static final StoryStruct$Widget DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int LINK_WIDGET_FIELD_NUMBER = 20;
    private static volatile KW4 PARSER = null;
    public static final int POLL_WIDGET_FIELD_NUMBER = 21;
    public static final int POSITION_FIELD_NUMBER = 3;
    public static final int POST_WIDGET_FIELD_NUMBER = 22;
    public static final int RESTORY_WIDGET_FIELD_NUMBER = 23;
    public static final int TYPE_FIELD_NUMBER = 2;
    private int bitField0_;
    private StoryStruct$Position position_;
    private Object trait_;
    private int type_;
    private int traitCase_ = 0;
    private String id_ = "";

    public static final class a extends GeneratedMessageLite.b implements f2 {
        public a A(StoryStruct$LinkWidget storyStruct$LinkWidget) {
            q();
            ((StoryStruct$Widget) this.b).setLinkWidget(storyStruct$LinkWidget);
            return this;
        }

        public a B(StoryStruct$Position storyStruct$Position) {
            q();
            ((StoryStruct$Widget) this.b).setPosition(storyStruct$Position);
            return this;
        }

        public a C(StoryStruct$PostWidget storyStruct$PostWidget) {
            q();
            ((StoryStruct$Widget) this.b).setPostWidget(storyStruct$PostWidget);
            return this;
        }

        public a D(EnumC13598gV6 enumC13598gV6) {
            q();
            ((StoryStruct$Widget) this.b).setType(enumC13598gV6);
            return this;
        }

        private a() {
            super(StoryStruct$Widget.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        LINK_WIDGET(20),
        POLL_WIDGET(21),
        POST_WIDGET(22),
        RESTORY_WIDGET(23),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            switch (i) {
                case 20:
                    return LINK_WIDGET;
                case 21:
                    return POLL_WIDGET;
                case 22:
                    return POST_WIDGET;
                case 23:
                    return RESTORY_WIDGET;
                default:
                    return null;
            }
        }
    }

    static {
        StoryStruct$Widget storyStruct$Widget = new StoryStruct$Widget();
        DEFAULT_INSTANCE = storyStruct$Widget;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$Widget.class, storyStruct$Widget);
    }

    private StoryStruct$Widget() {
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearLinkWidget() {
        if (this.traitCase_ == 20) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPollWidget() {
        if (this.traitCase_ == 21) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPosition() {
        this.position_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPostWidget() {
        if (this.traitCase_ == 22) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRestoryWidget() {
        if (this.traitCase_ == 23) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static StoryStruct$Widget getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLinkWidget(StoryStruct$LinkWidget storyStruct$LinkWidget) {
        storyStruct$LinkWidget.getClass();
        if (this.traitCase_ != 20 || this.trait_ == StoryStruct$LinkWidget.getDefaultInstance()) {
            this.trait_ = storyStruct$LinkWidget;
        } else {
            this.trait_ = ((StoryStruct$LinkWidget.a) StoryStruct$LinkWidget.newBuilder((StoryStruct$LinkWidget) this.trait_).v(storyStruct$LinkWidget)).j();
        }
        this.traitCase_ = 20;
    }

    private void mergePollWidget(StoryStruct$PollWidget storyStruct$PollWidget) {
        storyStruct$PollWidget.getClass();
        if (this.traitCase_ != 21 || this.trait_ == StoryStruct$PollWidget.getDefaultInstance()) {
            this.trait_ = storyStruct$PollWidget;
        } else {
            this.trait_ = ((StoryStruct$PollWidget.a) StoryStruct$PollWidget.newBuilder((StoryStruct$PollWidget) this.trait_).v(storyStruct$PollWidget)).j();
        }
        this.traitCase_ = 21;
    }

    private void mergePosition(StoryStruct$Position storyStruct$Position) {
        storyStruct$Position.getClass();
        StoryStruct$Position storyStruct$Position2 = this.position_;
        if (storyStruct$Position2 == null || storyStruct$Position2 == StoryStruct$Position.getDefaultInstance()) {
            this.position_ = storyStruct$Position;
        } else {
            this.position_ = (StoryStruct$Position) ((StoryStruct$Position.a) StoryStruct$Position.newBuilder(this.position_).v(storyStruct$Position)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergePostWidget(StoryStruct$PostWidget storyStruct$PostWidget) {
        storyStruct$PostWidget.getClass();
        if (this.traitCase_ != 22 || this.trait_ == StoryStruct$PostWidget.getDefaultInstance()) {
            this.trait_ = storyStruct$PostWidget;
        } else {
            this.trait_ = ((StoryStruct$PostWidget.a) StoryStruct$PostWidget.newBuilder((StoryStruct$PostWidget) this.trait_).v(storyStruct$PostWidget)).j();
        }
        this.traitCase_ = 22;
    }

    private void mergeRestoryWidget(StoryStruct$ReStoryWidget storyStruct$ReStoryWidget) {
        storyStruct$ReStoryWidget.getClass();
        if (this.traitCase_ != 23 || this.trait_ == StoryStruct$ReStoryWidget.getDefaultInstance()) {
            this.trait_ = storyStruct$ReStoryWidget;
        } else {
            this.trait_ = ((StoryStruct$ReStoryWidget.a) StoryStruct$ReStoryWidget.newBuilder((StoryStruct$ReStoryWidget) this.trait_).v(storyStruct$ReStoryWidget)).j();
        }
        this.traitCase_ = 23;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$Widget parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$Widget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$Widget parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$Widget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLinkWidget(StoryStruct$LinkWidget storyStruct$LinkWidget) {
        storyStruct$LinkWidget.getClass();
        this.trait_ = storyStruct$LinkWidget;
        this.traitCase_ = 20;
    }

    private void setPollWidget(StoryStruct$PollWidget storyStruct$PollWidget) {
        storyStruct$PollWidget.getClass();
        this.trait_ = storyStruct$PollWidget;
        this.traitCase_ = 21;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPosition(StoryStruct$Position storyStruct$Position) {
        storyStruct$Position.getClass();
        this.position_ = storyStruct$Position;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPostWidget(StoryStruct$PostWidget storyStruct$PostWidget) {
        storyStruct$PostWidget.getClass();
        this.trait_ = storyStruct$PostWidget;
        this.traitCase_ = 22;
    }

    private void setRestoryWidget(StoryStruct$ReStoryWidget storyStruct$ReStoryWidget) {
        storyStruct$ReStoryWidget.getClass();
        this.trait_ = storyStruct$ReStoryWidget;
        this.traitCase_ = 23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(EnumC13598gV6 enumC13598gV6) {
        this.type_ = enumC13598gV6.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$Widget();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0001\u0001\u0017\u0007\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003ဉ\u0000\u0014<\u0000\u0015<\u0000\u0016<\u0000\u0017<\u0000", new Object[]{"trait_", "traitCase_", "bitField0_", "id_", "type_", "position_", StoryStruct$LinkWidget.class, StoryStruct$PollWidget.class, StoryStruct$PostWidget.class, StoryStruct$ReStoryWidget.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$Widget.class) {
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

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public StoryStruct$LinkWidget getLinkWidget() {
        return this.traitCase_ == 20 ? (StoryStruct$LinkWidget) this.trait_ : StoryStruct$LinkWidget.getDefaultInstance();
    }

    public StoryStruct$PollWidget getPollWidget() {
        return this.traitCase_ == 21 ? (StoryStruct$PollWidget) this.trait_ : StoryStruct$PollWidget.getDefaultInstance();
    }

    public StoryStruct$Position getPosition() {
        StoryStruct$Position storyStruct$Position = this.position_;
        return storyStruct$Position == null ? StoryStruct$Position.getDefaultInstance() : storyStruct$Position;
    }

    public StoryStruct$PostWidget getPostWidget() {
        return this.traitCase_ == 22 ? (StoryStruct$PostWidget) this.trait_ : StoryStruct$PostWidget.getDefaultInstance();
    }

    public StoryStruct$ReStoryWidget getRestoryWidget() {
        return this.traitCase_ == 23 ? (StoryStruct$ReStoryWidget) this.trait_ : StoryStruct$ReStoryWidget.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public EnumC13598gV6 getType() {
        EnumC13598gV6 enumC13598gV6J = EnumC13598gV6.j(this.type_);
        return enumC13598gV6J == null ? EnumC13598gV6.UNRECOGNIZED : enumC13598gV6J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public boolean hasLinkWidget() {
        return this.traitCase_ == 20;
    }

    public boolean hasPollWidget() {
        return this.traitCase_ == 21;
    }

    public boolean hasPosition() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPostWidget() {
        return this.traitCase_ == 22;
    }

    public boolean hasRestoryWidget() {
        return this.traitCase_ == 23;
    }

    public static a newBuilder(StoryStruct$Widget storyStruct$Widget) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$Widget);
    }

    public static StoryStruct$Widget parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$Widget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$Widget parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$Widget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$Widget parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$Widget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryStruct$Widget parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$Widget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$Widget parseFrom(byte[] bArr) {
        return (StoryStruct$Widget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$Widget parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$Widget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$Widget parseFrom(InputStream inputStream) {
        return (StoryStruct$Widget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$Widget parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$Widget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$Widget parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$Widget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$Widget parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$Widget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

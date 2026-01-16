package ai.bale.proto;

import ai.bale.proto.StoryStruct$ViewersPagination;
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
public final class StoryOuterClass$RequestGetViewers extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$RequestGetViewers DEFAULT_INSTANCE;
    public static final int PAGINATION_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int STORY_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private StoryStruct$ViewersPagination pagination_;
    private String storyId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(StoryStruct$ViewersPagination storyStruct$ViewersPagination) {
            q();
            ((StoryOuterClass$RequestGetViewers) this.b).setPagination(storyStruct$ViewersPagination);
            return this;
        }

        public a B(String str) {
            q();
            ((StoryOuterClass$RequestGetViewers) this.b).setStoryId(str);
            return this;
        }

        private a() {
            super(StoryOuterClass$RequestGetViewers.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$RequestGetViewers storyOuterClass$RequestGetViewers = new StoryOuterClass$RequestGetViewers();
        DEFAULT_INSTANCE = storyOuterClass$RequestGetViewers;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$RequestGetViewers.class, storyOuterClass$RequestGetViewers);
    }

    private StoryOuterClass$RequestGetViewers() {
    }

    private void clearPagination() {
        this.pagination_ = null;
        this.bitField0_ &= -2;
    }

    private void clearStoryId() {
        this.storyId_ = getDefaultInstance().getStoryId();
    }

    public static StoryOuterClass$RequestGetViewers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePagination(StoryStruct$ViewersPagination storyStruct$ViewersPagination) {
        storyStruct$ViewersPagination.getClass();
        StoryStruct$ViewersPagination storyStruct$ViewersPagination2 = this.pagination_;
        if (storyStruct$ViewersPagination2 == null || storyStruct$ViewersPagination2 == StoryStruct$ViewersPagination.getDefaultInstance()) {
            this.pagination_ = storyStruct$ViewersPagination;
        } else {
            this.pagination_ = (StoryStruct$ViewersPagination) ((StoryStruct$ViewersPagination.a) StoryStruct$ViewersPagination.newBuilder(this.pagination_).v(storyStruct$ViewersPagination)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$RequestGetViewers parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestGetViewers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestGetViewers parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$RequestGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPagination(StoryStruct$ViewersPagination storyStruct$ViewersPagination) {
        storyStruct$ViewersPagination.getClass();
        this.pagination_ = storyStruct$ViewersPagination;
        this.bitField0_ |= 1;
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$RequestGetViewers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "storyId_", "pagination_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$RequestGetViewers.class) {
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

    public StoryStruct$ViewersPagination getPagination() {
        StoryStruct$ViewersPagination storyStruct$ViewersPagination = this.pagination_;
        return storyStruct$ViewersPagination == null ? StoryStruct$ViewersPagination.getDefaultInstance() : storyStruct$ViewersPagination;
    }

    public String getStoryId() {
        return this.storyId_;
    }

    public AbstractC2383g getStoryIdBytes() {
        return AbstractC2383g.N(this.storyId_);
    }

    public boolean hasPagination() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(StoryOuterClass$RequestGetViewers storyOuterClass$RequestGetViewers) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$RequestGetViewers);
    }

    public static StoryOuterClass$RequestGetViewers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestGetViewers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestGetViewers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$RequestGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$RequestGetViewers parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$RequestGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryOuterClass$RequestGetViewers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$RequestGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$RequestGetViewers parseFrom(byte[] bArr) {
        return (StoryOuterClass$RequestGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$RequestGetViewers parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$RequestGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$RequestGetViewers parseFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestGetViewers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestGetViewers parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$RequestGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$RequestGetViewers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$RequestGetViewers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

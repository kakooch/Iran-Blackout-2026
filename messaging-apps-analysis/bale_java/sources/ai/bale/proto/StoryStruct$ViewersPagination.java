package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StoryStruct$ViewersPagination extends GeneratedMessageLite implements U64 {
    private static final StoryStruct$ViewersPagination DEFAULT_INSTANCE;
    public static final int LIMIT_FIELD_NUMBER = 2;
    public static final int PAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int limit_;
    private int page_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((StoryStruct$ViewersPagination) this.b).setLimit(i);
            return this;
        }

        public a B(int i) {
            q();
            ((StoryStruct$ViewersPagination) this.b).setPage(i);
            return this;
        }

        private a() {
            super(StoryStruct$ViewersPagination.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$ViewersPagination storyStruct$ViewersPagination = new StoryStruct$ViewersPagination();
        DEFAULT_INSTANCE = storyStruct$ViewersPagination;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$ViewersPagination.class, storyStruct$ViewersPagination);
    }

    private StoryStruct$ViewersPagination() {
    }

    private void clearLimit() {
        this.limit_ = 0;
    }

    private void clearPage() {
        this.page_ = 0;
    }

    public static StoryStruct$ViewersPagination getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$ViewersPagination parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$ViewersPagination) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$ViewersPagination parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$ViewersPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLimit(int i) {
        this.limit_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPage(int i) {
        this.page_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$ViewersPagination();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"page_", "limit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$ViewersPagination.class) {
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

    public int getLimit() {
        return this.limit_;
    }

    public int getPage() {
        return this.page_;
    }

    public static a newBuilder(StoryStruct$ViewersPagination storyStruct$ViewersPagination) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$ViewersPagination);
    }

    public static StoryStruct$ViewersPagination parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$ViewersPagination) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$ViewersPagination parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$ViewersPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$ViewersPagination parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$ViewersPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryStruct$ViewersPagination parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$ViewersPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$ViewersPagination parseFrom(byte[] bArr) {
        return (StoryStruct$ViewersPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$ViewersPagination parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$ViewersPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$ViewersPagination parseFrom(InputStream inputStream) {
        return (StoryStruct$ViewersPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$ViewersPagination parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$ViewersPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$ViewersPagination parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$ViewersPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$ViewersPagination parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$ViewersPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

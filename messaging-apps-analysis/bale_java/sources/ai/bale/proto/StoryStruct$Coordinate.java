package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC18335oU6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StoryStruct$Coordinate extends GeneratedMessageLite implements InterfaceC18335oU6 {
    private static final StoryStruct$Coordinate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int X_FIELD_NUMBER = 1;
    public static final int Y_FIELD_NUMBER = 2;
    private float x_;
    private float y_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC18335oU6 {
        public a A(float f) {
            q();
            ((StoryStruct$Coordinate) this.b).setX(f);
            return this;
        }

        public a B(float f) {
            q();
            ((StoryStruct$Coordinate) this.b).setY(f);
            return this;
        }

        private a() {
            super(StoryStruct$Coordinate.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$Coordinate storyStruct$Coordinate = new StoryStruct$Coordinate();
        DEFAULT_INSTANCE = storyStruct$Coordinate;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$Coordinate.class, storyStruct$Coordinate);
    }

    private StoryStruct$Coordinate() {
    }

    private void clearX() {
        this.x_ = 0.0f;
    }

    private void clearY() {
        this.y_ = 0.0f;
    }

    public static StoryStruct$Coordinate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$Coordinate parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$Coordinate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$Coordinate parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$Coordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setX(float f) {
        this.x_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setY(float f) {
        this.y_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$Coordinate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0001\u0002\u0001", new Object[]{"x_", "y_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$Coordinate.class) {
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

    public float getX() {
        return this.x_;
    }

    public float getY() {
        return this.y_;
    }

    public static a newBuilder(StoryStruct$Coordinate storyStruct$Coordinate) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$Coordinate);
    }

    public static StoryStruct$Coordinate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$Coordinate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$Coordinate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$Coordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$Coordinate parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$Coordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryStruct$Coordinate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$Coordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$Coordinate parseFrom(byte[] bArr) {
        return (StoryStruct$Coordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$Coordinate parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$Coordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$Coordinate parseFrom(InputStream inputStream) {
        return (StoryStruct$Coordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$Coordinate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$Coordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$Coordinate parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$Coordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$Coordinate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$Coordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

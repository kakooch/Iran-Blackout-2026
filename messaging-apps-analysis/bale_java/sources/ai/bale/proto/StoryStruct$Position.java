package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC18335oU6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryStruct$Position extends GeneratedMessageLite implements U64 {
    public static final int COORDINATES_FIELD_NUMBER = 1;
    private static final StoryStruct$Position DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j coordinates_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((StoryStruct$Position) this.b).addAllCoordinates(iterable);
            return this;
        }

        private a() {
            super(StoryStruct$Position.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$Position storyStruct$Position = new StoryStruct$Position();
        DEFAULT_INSTANCE = storyStruct$Position;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$Position.class, storyStruct$Position);
    }

    private StoryStruct$Position() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCoordinates(Iterable<? extends StoryStruct$Coordinate> iterable) {
        ensureCoordinatesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.coordinates_);
    }

    private void addCoordinates(StoryStruct$Coordinate storyStruct$Coordinate) {
        storyStruct$Coordinate.getClass();
        ensureCoordinatesIsMutable();
        this.coordinates_.add(storyStruct$Coordinate);
    }

    private void clearCoordinates() {
        this.coordinates_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureCoordinatesIsMutable() {
        B.j jVar = this.coordinates_;
        if (jVar.u()) {
            return;
        }
        this.coordinates_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static StoryStruct$Position getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$Position parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$Position) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$Position parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCoordinates(int i) {
        ensureCoordinatesIsMutable();
        this.coordinates_.remove(i);
    }

    private void setCoordinates(int i, StoryStruct$Coordinate storyStruct$Coordinate) {
        storyStruct$Coordinate.getClass();
        ensureCoordinatesIsMutable();
        this.coordinates_.set(i, storyStruct$Coordinate);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$Position();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"coordinates_", StoryStruct$Coordinate.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$Position.class) {
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

    public StoryStruct$Coordinate getCoordinates(int i) {
        return (StoryStruct$Coordinate) this.coordinates_.get(i);
    }

    public int getCoordinatesCount() {
        return this.coordinates_.size();
    }

    public List<StoryStruct$Coordinate> getCoordinatesList() {
        return this.coordinates_;
    }

    public InterfaceC18335oU6 getCoordinatesOrBuilder(int i) {
        return (InterfaceC18335oU6) this.coordinates_.get(i);
    }

    public List<? extends InterfaceC18335oU6> getCoordinatesOrBuilderList() {
        return this.coordinates_;
    }

    public static a newBuilder(StoryStruct$Position storyStruct$Position) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$Position);
    }

    public static StoryStruct$Position parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$Position) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$Position parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$Position parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCoordinates(int i, StoryStruct$Coordinate storyStruct$Coordinate) {
        storyStruct$Coordinate.getClass();
        ensureCoordinatesIsMutable();
        this.coordinates_.add(i, storyStruct$Coordinate);
    }

    public static StoryStruct$Position parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$Position parseFrom(byte[] bArr) {
        return (StoryStruct$Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$Position parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$Position parseFrom(InputStream inputStream) {
        return (StoryStruct$Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$Position parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$Position parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$Position parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

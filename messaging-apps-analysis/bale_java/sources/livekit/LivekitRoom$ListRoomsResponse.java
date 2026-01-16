package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.WE3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitRoom$ListRoomsResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitRoom$ListRoomsResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int ROOMS_FIELD_NUMBER = 1;
    private B.j rooms_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(r rVar) {
            this();
        }

        private a() {
            super(LivekitRoom$ListRoomsResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRoom$ListRoomsResponse livekitRoom$ListRoomsResponse = new LivekitRoom$ListRoomsResponse();
        DEFAULT_INSTANCE = livekitRoom$ListRoomsResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitRoom$ListRoomsResponse.class, livekitRoom$ListRoomsResponse);
    }

    private LivekitRoom$ListRoomsResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRooms(Iterable<? extends LivekitModels$Room> iterable) {
        ensureRoomsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.rooms_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRooms(LivekitModels$Room livekitModels$Room) {
        livekitModels$Room.getClass();
        ensureRoomsIsMutable();
        this.rooms_.add(livekitModels$Room);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRooms() {
        this.rooms_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureRoomsIsMutable() {
        B.j jVar = this.rooms_;
        if (jVar.u()) {
            return;
        }
        this.rooms_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRoom$ListRoomsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRoom$ListRoomsResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRoom$ListRoomsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$ListRoomsResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRoom$ListRoomsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRooms(int i) {
        ensureRoomsIsMutable();
        this.rooms_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRooms(int i, LivekitModels$Room livekitModels$Room) {
        livekitModels$Room.getClass();
        ensureRoomsIsMutable();
        this.rooms_.set(i, livekitModels$Room);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        r rVar = null;
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRoom$ListRoomsResponse();
            case 2:
                return new a(rVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"rooms_", LivekitModels$Room.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRoom$ListRoomsResponse.class) {
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

    public LivekitModels$Room getRooms(int i) {
        return (LivekitModels$Room) this.rooms_.get(i);
    }

    public int getRoomsCount() {
        return this.rooms_.size();
    }

    public List<LivekitModels$Room> getRoomsList() {
        return this.rooms_;
    }

    public WE3 getRoomsOrBuilder(int i) {
        return (WE3) this.rooms_.get(i);
    }

    public List<? extends WE3> getRoomsOrBuilderList() {
        return this.rooms_;
    }

    public static a newBuilder(LivekitRoom$ListRoomsResponse livekitRoom$ListRoomsResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRoom$ListRoomsResponse);
    }

    public static LivekitRoom$ListRoomsResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$ListRoomsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$ListRoomsResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRoom$ListRoomsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRoom$ListRoomsResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRoom$ListRoomsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRooms(int i, LivekitModels$Room livekitModels$Room) {
        livekitModels$Room.getClass();
        ensureRoomsIsMutable();
        this.rooms_.add(i, livekitModels$Room);
    }

    public static LivekitRoom$ListRoomsResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRoom$ListRoomsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRoom$ListRoomsResponse parseFrom(byte[] bArr) {
        return (LivekitRoom$ListRoomsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRoom$ListRoomsResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRoom$ListRoomsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRoom$ListRoomsResponse parseFrom(InputStream inputStream) {
        return (LivekitRoom$ListRoomsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRoom$ListRoomsResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRoom$ListRoomsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRoom$ListRoomsResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRoom$ListRoomsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRoom$ListRoomsResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRoom$ListRoomsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

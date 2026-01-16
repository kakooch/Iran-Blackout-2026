package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC19379qF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitRtc$StreamStateUpdate extends GeneratedMessageLite implements U64 {
    private static final LivekitRtc$StreamStateUpdate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STREAM_STATES_FIELD_NUMBER = 1;
    private B.j streamStates_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$StreamStateUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$StreamStateUpdate livekitRtc$StreamStateUpdate = new LivekitRtc$StreamStateUpdate();
        DEFAULT_INSTANCE = livekitRtc$StreamStateUpdate;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$StreamStateUpdate.class, livekitRtc$StreamStateUpdate);
    }

    private LivekitRtc$StreamStateUpdate() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllStreamStates(Iterable<? extends LivekitRtc$StreamStateInfo> iterable) {
        ensureStreamStatesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.streamStates_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStreamStates(LivekitRtc$StreamStateInfo livekitRtc$StreamStateInfo) {
        livekitRtc$StreamStateInfo.getClass();
        ensureStreamStatesIsMutable();
        this.streamStates_.add(livekitRtc$StreamStateInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStreamStates() {
        this.streamStates_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureStreamStatesIsMutable() {
        B.j jVar = this.streamStates_;
        if (jVar.u()) {
            return;
        }
        this.streamStates_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRtc$StreamStateUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$StreamStateUpdate parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$StreamStateUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$StreamStateUpdate parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$StreamStateUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeStreamStates(int i) {
        ensureStreamStatesIsMutable();
        this.streamStates_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreamStates(int i, LivekitRtc$StreamStateInfo livekitRtc$StreamStateInfo) {
        livekitRtc$StreamStateInfo.getClass();
        ensureStreamStatesIsMutable();
        this.streamStates_.set(i, livekitRtc$StreamStateInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$StreamStateUpdate();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"streamStates_", LivekitRtc$StreamStateInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$StreamStateUpdate.class) {
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

    public LivekitRtc$StreamStateInfo getStreamStates(int i) {
        return (LivekitRtc$StreamStateInfo) this.streamStates_.get(i);
    }

    public int getStreamStatesCount() {
        return this.streamStates_.size();
    }

    public List<LivekitRtc$StreamStateInfo> getStreamStatesList() {
        return this.streamStates_;
    }

    public InterfaceC19379qF3 getStreamStatesOrBuilder(int i) {
        return (InterfaceC19379qF3) this.streamStates_.get(i);
    }

    public List<? extends InterfaceC19379qF3> getStreamStatesOrBuilderList() {
        return this.streamStates_;
    }

    public static a newBuilder(LivekitRtc$StreamStateUpdate livekitRtc$StreamStateUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$StreamStateUpdate);
    }

    public static LivekitRtc$StreamStateUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$StreamStateUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$StreamStateUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$StreamStateUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$StreamStateUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$StreamStateUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStreamStates(int i, LivekitRtc$StreamStateInfo livekitRtc$StreamStateInfo) {
        livekitRtc$StreamStateInfo.getClass();
        ensureStreamStatesIsMutable();
        this.streamStates_.add(i, livekitRtc$StreamStateInfo);
    }

    public static LivekitRtc$StreamStateUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$StreamStateUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$StreamStateUpdate parseFrom(byte[] bArr) {
        return (LivekitRtc$StreamStateUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$StreamStateUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$StreamStateUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$StreamStateUpdate parseFrom(InputStream inputStream) {
        return (LivekitRtc$StreamStateUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$StreamStateUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$StreamStateUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$StreamStateUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$StreamStateUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$StreamStateUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$StreamStateUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

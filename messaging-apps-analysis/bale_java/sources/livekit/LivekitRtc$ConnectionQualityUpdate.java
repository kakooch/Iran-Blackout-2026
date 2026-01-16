package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC14644iF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitRtc$ConnectionQualityUpdate extends GeneratedMessageLite implements U64 {
    private static final LivekitRtc$ConnectionQualityUpdate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UPDATES_FIELD_NUMBER = 1;
    private B.j updates_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$ConnectionQualityUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$ConnectionQualityUpdate livekitRtc$ConnectionQualityUpdate = new LivekitRtc$ConnectionQualityUpdate();
        DEFAULT_INSTANCE = livekitRtc$ConnectionQualityUpdate;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$ConnectionQualityUpdate.class, livekitRtc$ConnectionQualityUpdate);
    }

    private LivekitRtc$ConnectionQualityUpdate() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllUpdates(Iterable<? extends LivekitRtc$ConnectionQualityInfo> iterable) {
        ensureUpdatesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.updates_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addUpdates(LivekitRtc$ConnectionQualityInfo livekitRtc$ConnectionQualityInfo) {
        livekitRtc$ConnectionQualityInfo.getClass();
        ensureUpdatesIsMutable();
        this.updates_.add(livekitRtc$ConnectionQualityInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdates() {
        this.updates_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUpdatesIsMutable() {
        B.j jVar = this.updates_;
        if (jVar.u()) {
            return;
        }
        this.updates_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRtc$ConnectionQualityUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$ConnectionQualityUpdate parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$ConnectionQualityUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$ConnectionQualityUpdate parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$ConnectionQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeUpdates(int i) {
        ensureUpdatesIsMutable();
        this.updates_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdates(int i, LivekitRtc$ConnectionQualityInfo livekitRtc$ConnectionQualityInfo) {
        livekitRtc$ConnectionQualityInfo.getClass();
        ensureUpdatesIsMutable();
        this.updates_.set(i, livekitRtc$ConnectionQualityInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$ConnectionQualityUpdate();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"updates_", LivekitRtc$ConnectionQualityInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$ConnectionQualityUpdate.class) {
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

    public LivekitRtc$ConnectionQualityInfo getUpdates(int i) {
        return (LivekitRtc$ConnectionQualityInfo) this.updates_.get(i);
    }

    public int getUpdatesCount() {
        return this.updates_.size();
    }

    public List<LivekitRtc$ConnectionQualityInfo> getUpdatesList() {
        return this.updates_;
    }

    public InterfaceC14644iF3 getUpdatesOrBuilder(int i) {
        return (InterfaceC14644iF3) this.updates_.get(i);
    }

    public List<? extends InterfaceC14644iF3> getUpdatesOrBuilderList() {
        return this.updates_;
    }

    public static a newBuilder(LivekitRtc$ConnectionQualityUpdate livekitRtc$ConnectionQualityUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$ConnectionQualityUpdate);
    }

    public static LivekitRtc$ConnectionQualityUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$ConnectionQualityUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$ConnectionQualityUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$ConnectionQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$ConnectionQualityUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$ConnectionQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addUpdates(int i, LivekitRtc$ConnectionQualityInfo livekitRtc$ConnectionQualityInfo) {
        livekitRtc$ConnectionQualityInfo.getClass();
        ensureUpdatesIsMutable();
        this.updates_.add(i, livekitRtc$ConnectionQualityInfo);
    }

    public static LivekitRtc$ConnectionQualityUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$ConnectionQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$ConnectionQualityUpdate parseFrom(byte[] bArr) {
        return (LivekitRtc$ConnectionQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$ConnectionQualityUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$ConnectionQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$ConnectionQualityUpdate parseFrom(InputStream inputStream) {
        return (LivekitRtc$ConnectionQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$ConnectionQualityUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$ConnectionQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$ConnectionQualityUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$ConnectionQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$ConnectionQualityUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$ConnectionQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

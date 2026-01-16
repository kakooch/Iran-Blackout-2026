package livekit;

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

@Deprecated
/* loaded from: classes8.dex */
public final class LivekitEgress$StreamInfoList extends GeneratedMessageLite implements U64 {
    private static final LivekitEgress$StreamInfoList DEFAULT_INSTANCE;
    public static final int INFO_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j info_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$StreamInfoList.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitEgress$StreamInfoList livekitEgress$StreamInfoList = new LivekitEgress$StreamInfoList();
        DEFAULT_INSTANCE = livekitEgress$StreamInfoList;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$StreamInfoList.class, livekitEgress$StreamInfoList);
    }

    private LivekitEgress$StreamInfoList() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllInfo(Iterable<? extends LivekitEgress$StreamInfo> iterable) {
        ensureInfoIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.info_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addInfo(LivekitEgress$StreamInfo livekitEgress$StreamInfo) {
        livekitEgress$StreamInfo.getClass();
        ensureInfoIsMutable();
        this.info_.add(livekitEgress$StreamInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInfo() {
        this.info_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureInfoIsMutable() {
        B.j jVar = this.info_;
        if (jVar.u()) {
            return;
        }
        this.info_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitEgress$StreamInfoList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$StreamInfoList parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$StreamInfoList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$StreamInfoList parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$StreamInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeInfo(int i) {
        ensureInfoIsMutable();
        this.info_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInfo(int i, LivekitEgress$StreamInfo livekitEgress$StreamInfo) {
        livekitEgress$StreamInfo.getClass();
        ensureInfoIsMutable();
        this.info_.set(i, livekitEgress$StreamInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$StreamInfoList();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"info_", LivekitEgress$StreamInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$StreamInfoList.class) {
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

    public LivekitEgress$StreamInfo getInfo(int i) {
        return (LivekitEgress$StreamInfo) this.info_.get(i);
    }

    public int getInfoCount() {
        return this.info_.size();
    }

    public List<LivekitEgress$StreamInfo> getInfoList() {
        return this.info_;
    }

    public k getInfoOrBuilder(int i) {
        return (k) this.info_.get(i);
    }

    public List<? extends k> getInfoOrBuilderList() {
        return this.info_;
    }

    public static a newBuilder(LivekitEgress$StreamInfoList livekitEgress$StreamInfoList) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$StreamInfoList);
    }

    public static LivekitEgress$StreamInfoList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$StreamInfoList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$StreamInfoList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$StreamInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$StreamInfoList parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$StreamInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addInfo(int i, LivekitEgress$StreamInfo livekitEgress$StreamInfo) {
        livekitEgress$StreamInfo.getClass();
        ensureInfoIsMutable();
        this.info_.add(i, livekitEgress$StreamInfo);
    }

    public static LivekitEgress$StreamInfoList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$StreamInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$StreamInfoList parseFrom(byte[] bArr) {
        return (LivekitEgress$StreamInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$StreamInfoList parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$StreamInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$StreamInfoList parseFrom(InputStream inputStream) {
        return (LivekitEgress$StreamInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$StreamInfoList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$StreamInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$StreamInfoList parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$StreamInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$StreamInfoList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$StreamInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

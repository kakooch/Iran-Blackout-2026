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

/* loaded from: classes8.dex */
public final class LivekitEgress$ListEgressResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitEgress$ListEgressResponse DEFAULT_INSTANCE;
    public static final int ITEMS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j items_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$ListEgressResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitEgress$ListEgressResponse livekitEgress$ListEgressResponse = new LivekitEgress$ListEgressResponse();
        DEFAULT_INSTANCE = livekitEgress$ListEgressResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$ListEgressResponse.class, livekitEgress$ListEgressResponse);
    }

    private LivekitEgress$ListEgressResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllItems(Iterable<? extends LivekitEgress$EgressInfo> iterable) {
        ensureItemsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.items_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addItems(LivekitEgress$EgressInfo livekitEgress$EgressInfo) {
        livekitEgress$EgressInfo.getClass();
        ensureItemsIsMutable();
        this.items_.add(livekitEgress$EgressInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearItems() {
        this.items_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureItemsIsMutable() {
        B.j jVar = this.items_;
        if (jVar.u()) {
            return;
        }
        this.items_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitEgress$ListEgressResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$ListEgressResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$ListEgressResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$ListEgressResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$ListEgressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeItems(int i) {
        ensureItemsIsMutable();
        this.items_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItems(int i, LivekitEgress$EgressInfo livekitEgress$EgressInfo) {
        livekitEgress$EgressInfo.getClass();
        ensureItemsIsMutable();
        this.items_.set(i, livekitEgress$EgressInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$ListEgressResponse();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"items_", LivekitEgress$EgressInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$ListEgressResponse.class) {
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

    public LivekitEgress$EgressInfo getItems(int i) {
        return (LivekitEgress$EgressInfo) this.items_.get(i);
    }

    public int getItemsCount() {
        return this.items_.size();
    }

    public List<LivekitEgress$EgressInfo> getItemsList() {
        return this.items_;
    }

    public g getItemsOrBuilder(int i) {
        return (g) this.items_.get(i);
    }

    public List<? extends g> getItemsOrBuilderList() {
        return this.items_;
    }

    public static a newBuilder(LivekitEgress$ListEgressResponse livekitEgress$ListEgressResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$ListEgressResponse);
    }

    public static LivekitEgress$ListEgressResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$ListEgressResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$ListEgressResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$ListEgressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$ListEgressResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$ListEgressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addItems(int i, LivekitEgress$EgressInfo livekitEgress$EgressInfo) {
        livekitEgress$EgressInfo.getClass();
        ensureItemsIsMutable();
        this.items_.add(i, livekitEgress$EgressInfo);
    }

    public static LivekitEgress$ListEgressResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$ListEgressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$ListEgressResponse parseFrom(byte[] bArr) {
        return (LivekitEgress$ListEgressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$ListEgressResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$ListEgressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$ListEgressResponse parseFrom(InputStream inputStream) {
        return (LivekitEgress$ListEgressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$ListEgressResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$ListEgressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$ListEgressResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$ListEgressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$ListEgressResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$ListEgressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

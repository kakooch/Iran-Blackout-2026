package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.AE3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitIngress$ListIngressResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitIngress$ListIngressResponse DEFAULT_INSTANCE;
    public static final int ITEMS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j items_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(l lVar) {
            this();
        }

        private a() {
            super(LivekitIngress$ListIngressResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitIngress$ListIngressResponse livekitIngress$ListIngressResponse = new LivekitIngress$ListIngressResponse();
        DEFAULT_INSTANCE = livekitIngress$ListIngressResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitIngress$ListIngressResponse.class, livekitIngress$ListIngressResponse);
    }

    private LivekitIngress$ListIngressResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllItems(Iterable<? extends LivekitIngress$IngressInfo> iterable) {
        ensureItemsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.items_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addItems(LivekitIngress$IngressInfo livekitIngress$IngressInfo) {
        livekitIngress$IngressInfo.getClass();
        ensureItemsIsMutable();
        this.items_.add(livekitIngress$IngressInfo);
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

    public static LivekitIngress$ListIngressResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitIngress$ListIngressResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitIngress$ListIngressResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$ListIngressResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitIngress$ListIngressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setItems(int i, LivekitIngress$IngressInfo livekitIngress$IngressInfo) {
        livekitIngress$IngressInfo.getClass();
        ensureItemsIsMutable();
        this.items_.set(i, livekitIngress$IngressInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        l lVar = null;
        switch (l.a[gVar.ordinal()]) {
            case 1:
                return new LivekitIngress$ListIngressResponse();
            case 2:
                return new a(lVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"items_", LivekitIngress$IngressInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitIngress$ListIngressResponse.class) {
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

    public LivekitIngress$IngressInfo getItems(int i) {
        return (LivekitIngress$IngressInfo) this.items_.get(i);
    }

    public int getItemsCount() {
        return this.items_.size();
    }

    public List<LivekitIngress$IngressInfo> getItemsList() {
        return this.items_;
    }

    public AE3 getItemsOrBuilder(int i) {
        return (AE3) this.items_.get(i);
    }

    public List<? extends AE3> getItemsOrBuilderList() {
        return this.items_;
    }

    public static a newBuilder(LivekitIngress$ListIngressResponse livekitIngress$ListIngressResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitIngress$ListIngressResponse);
    }

    public static LivekitIngress$ListIngressResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$ListIngressResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$ListIngressResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitIngress$ListIngressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitIngress$ListIngressResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitIngress$ListIngressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addItems(int i, LivekitIngress$IngressInfo livekitIngress$IngressInfo) {
        livekitIngress$IngressInfo.getClass();
        ensureItemsIsMutable();
        this.items_.add(i, livekitIngress$IngressInfo);
    }

    public static LivekitIngress$ListIngressResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitIngress$ListIngressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitIngress$ListIngressResponse parseFrom(byte[] bArr) {
        return (LivekitIngress$ListIngressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitIngress$ListIngressResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitIngress$ListIngressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitIngress$ListIngressResponse parseFrom(InputStream inputStream) {
        return (LivekitIngress$ListIngressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitIngress$ListIngressResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitIngress$ListIngressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitIngress$ListIngressResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitIngress$ListIngressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitIngress$ListIngressResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitIngress$ListIngressResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

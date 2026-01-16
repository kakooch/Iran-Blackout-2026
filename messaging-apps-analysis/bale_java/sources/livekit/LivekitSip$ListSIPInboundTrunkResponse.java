package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.AF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitSip$ListSIPInboundTrunkResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitSip$ListSIPInboundTrunkResponse DEFAULT_INSTANCE;
    public static final int ITEMS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j items_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$ListSIPInboundTrunkResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$ListSIPInboundTrunkResponse livekitSip$ListSIPInboundTrunkResponse = new LivekitSip$ListSIPInboundTrunkResponse();
        DEFAULT_INSTANCE = livekitSip$ListSIPInboundTrunkResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$ListSIPInboundTrunkResponse.class, livekitSip$ListSIPInboundTrunkResponse);
    }

    private LivekitSip$ListSIPInboundTrunkResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllItems(Iterable<? extends LivekitSip$SIPInboundTrunkInfo> iterable) {
        ensureItemsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.items_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addItems(LivekitSip$SIPInboundTrunkInfo livekitSip$SIPInboundTrunkInfo) {
        livekitSip$SIPInboundTrunkInfo.getClass();
        ensureItemsIsMutable();
        this.items_.add(livekitSip$SIPInboundTrunkInfo);
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

    public static LivekitSip$ListSIPInboundTrunkResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$ListSIPInboundTrunkResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$ListSIPInboundTrunkResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$ListSIPInboundTrunkResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$ListSIPInboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setItems(int i, LivekitSip$SIPInboundTrunkInfo livekitSip$SIPInboundTrunkInfo) {
        livekitSip$SIPInboundTrunkInfo.getClass();
        ensureItemsIsMutable();
        this.items_.set(i, livekitSip$SIPInboundTrunkInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$ListSIPInboundTrunkResponse();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"items_", LivekitSip$SIPInboundTrunkInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$ListSIPInboundTrunkResponse.class) {
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

    public LivekitSip$SIPInboundTrunkInfo getItems(int i) {
        return (LivekitSip$SIPInboundTrunkInfo) this.items_.get(i);
    }

    public int getItemsCount() {
        return this.items_.size();
    }

    public List<LivekitSip$SIPInboundTrunkInfo> getItemsList() {
        return this.items_;
    }

    public AF3 getItemsOrBuilder(int i) {
        return (AF3) this.items_.get(i);
    }

    public List<? extends AF3> getItemsOrBuilderList() {
        return this.items_;
    }

    public static a newBuilder(LivekitSip$ListSIPInboundTrunkResponse livekitSip$ListSIPInboundTrunkResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$ListSIPInboundTrunkResponse);
    }

    public static LivekitSip$ListSIPInboundTrunkResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$ListSIPInboundTrunkResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$ListSIPInboundTrunkResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$ListSIPInboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$ListSIPInboundTrunkResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$ListSIPInboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addItems(int i, LivekitSip$SIPInboundTrunkInfo livekitSip$SIPInboundTrunkInfo) {
        livekitSip$SIPInboundTrunkInfo.getClass();
        ensureItemsIsMutable();
        this.items_.add(i, livekitSip$SIPInboundTrunkInfo);
    }

    public static LivekitSip$ListSIPInboundTrunkResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$ListSIPInboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$ListSIPInboundTrunkResponse parseFrom(byte[] bArr) {
        return (LivekitSip$ListSIPInboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$ListSIPInboundTrunkResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$ListSIPInboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$ListSIPInboundTrunkResponse parseFrom(InputStream inputStream) {
        return (LivekitSip$ListSIPInboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$ListSIPInboundTrunkResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$ListSIPInboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$ListSIPInboundTrunkResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$ListSIPInboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$ListSIPInboundTrunkResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$ListSIPInboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

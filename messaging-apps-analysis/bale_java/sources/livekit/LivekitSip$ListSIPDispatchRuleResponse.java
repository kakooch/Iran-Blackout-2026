package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC23632xF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitSip$ListSIPDispatchRuleResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitSip$ListSIPDispatchRuleResponse DEFAULT_INSTANCE;
    public static final int ITEMS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j items_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$ListSIPDispatchRuleResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$ListSIPDispatchRuleResponse livekitSip$ListSIPDispatchRuleResponse = new LivekitSip$ListSIPDispatchRuleResponse();
        DEFAULT_INSTANCE = livekitSip$ListSIPDispatchRuleResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$ListSIPDispatchRuleResponse.class, livekitSip$ListSIPDispatchRuleResponse);
    }

    private LivekitSip$ListSIPDispatchRuleResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllItems(Iterable<? extends LivekitSip$SIPDispatchRuleInfo> iterable) {
        ensureItemsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.items_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addItems(LivekitSip$SIPDispatchRuleInfo livekitSip$SIPDispatchRuleInfo) {
        livekitSip$SIPDispatchRuleInfo.getClass();
        ensureItemsIsMutable();
        this.items_.add(livekitSip$SIPDispatchRuleInfo);
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

    public static LivekitSip$ListSIPDispatchRuleResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$ListSIPDispatchRuleResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$ListSIPDispatchRuleResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$ListSIPDispatchRuleResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$ListSIPDispatchRuleResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setItems(int i, LivekitSip$SIPDispatchRuleInfo livekitSip$SIPDispatchRuleInfo) {
        livekitSip$SIPDispatchRuleInfo.getClass();
        ensureItemsIsMutable();
        this.items_.set(i, livekitSip$SIPDispatchRuleInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$ListSIPDispatchRuleResponse();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"items_", LivekitSip$SIPDispatchRuleInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$ListSIPDispatchRuleResponse.class) {
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

    public LivekitSip$SIPDispatchRuleInfo getItems(int i) {
        return (LivekitSip$SIPDispatchRuleInfo) this.items_.get(i);
    }

    public int getItemsCount() {
        return this.items_.size();
    }

    public List<LivekitSip$SIPDispatchRuleInfo> getItemsList() {
        return this.items_;
    }

    public InterfaceC23632xF3 getItemsOrBuilder(int i) {
        return (InterfaceC23632xF3) this.items_.get(i);
    }

    public List<? extends InterfaceC23632xF3> getItemsOrBuilderList() {
        return this.items_;
    }

    public static a newBuilder(LivekitSip$ListSIPDispatchRuleResponse livekitSip$ListSIPDispatchRuleResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$ListSIPDispatchRuleResponse);
    }

    public static LivekitSip$ListSIPDispatchRuleResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$ListSIPDispatchRuleResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$ListSIPDispatchRuleResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$ListSIPDispatchRuleResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$ListSIPDispatchRuleResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$ListSIPDispatchRuleResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addItems(int i, LivekitSip$SIPDispatchRuleInfo livekitSip$SIPDispatchRuleInfo) {
        livekitSip$SIPDispatchRuleInfo.getClass();
        ensureItemsIsMutable();
        this.items_.add(i, livekitSip$SIPDispatchRuleInfo);
    }

    public static LivekitSip$ListSIPDispatchRuleResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$ListSIPDispatchRuleResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$ListSIPDispatchRuleResponse parseFrom(byte[] bArr) {
        return (LivekitSip$ListSIPDispatchRuleResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$ListSIPDispatchRuleResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$ListSIPDispatchRuleResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$ListSIPDispatchRuleResponse parseFrom(InputStream inputStream) {
        return (LivekitSip$ListSIPDispatchRuleResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$ListSIPDispatchRuleResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$ListSIPDispatchRuleResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$ListSIPDispatchRuleResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$ListSIPDispatchRuleResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$ListSIPDispatchRuleResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$ListSIPDispatchRuleResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

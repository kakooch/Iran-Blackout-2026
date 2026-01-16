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
import livekit.LivekitModels$Pagination;

/* loaded from: classes8.dex */
public final class LivekitSip$ListSIPInboundTrunkRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitSip$ListSIPInboundTrunkRequest DEFAULT_INSTANCE;
    public static final int NUMBERS_FIELD_NUMBER = 2;
    public static final int PAGE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TRUNK_IDS_FIELD_NUMBER = 1;
    private LivekitModels$Pagination page_;
    private B.j trunkIds_ = GeneratedMessageLite.emptyProtobufList();
    private B.j numbers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$ListSIPInboundTrunkRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$ListSIPInboundTrunkRequest livekitSip$ListSIPInboundTrunkRequest = new LivekitSip$ListSIPInboundTrunkRequest();
        DEFAULT_INSTANCE = livekitSip$ListSIPInboundTrunkRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$ListSIPInboundTrunkRequest.class, livekitSip$ListSIPInboundTrunkRequest);
    }

    private LivekitSip$ListSIPInboundTrunkRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllNumbers(Iterable<String> iterable) {
        ensureNumbersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.numbers_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTrunkIds(Iterable<String> iterable) {
        ensureTrunkIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.trunkIds_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNumbers(String str) {
        str.getClass();
        ensureNumbersIsMutable();
        this.numbers_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNumbersBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureNumbersIsMutable();
        this.numbers_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTrunkIds(String str) {
        str.getClass();
        ensureTrunkIdsIsMutable();
        this.trunkIds_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTrunkIdsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureTrunkIdsIsMutable();
        this.trunkIds_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumbers() {
        this.numbers_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPage() {
        this.page_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrunkIds() {
        this.trunkIds_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureNumbersIsMutable() {
        B.j jVar = this.numbers_;
        if (jVar.u()) {
            return;
        }
        this.numbers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureTrunkIdsIsMutable() {
        B.j jVar = this.trunkIds_;
        if (jVar.u()) {
            return;
        }
        this.trunkIds_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitSip$ListSIPInboundTrunkRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePage(LivekitModels$Pagination livekitModels$Pagination) {
        livekitModels$Pagination.getClass();
        LivekitModels$Pagination livekitModels$Pagination2 = this.page_;
        if (livekitModels$Pagination2 == null || livekitModels$Pagination2 == LivekitModels$Pagination.getDefaultInstance()) {
            this.page_ = livekitModels$Pagination;
        } else {
            this.page_ = (LivekitModels$Pagination) ((LivekitModels$Pagination.a) LivekitModels$Pagination.newBuilder(this.page_).v(livekitModels$Pagination)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$ListSIPInboundTrunkRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$ListSIPInboundTrunkRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$ListSIPInboundTrunkRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$ListSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumbers(int i, String str) {
        str.getClass();
        ensureNumbersIsMutable();
        this.numbers_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPage(LivekitModels$Pagination livekitModels$Pagination) {
        livekitModels$Pagination.getClass();
        this.page_ = livekitModels$Pagination;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrunkIds(int i, String str) {
        str.getClass();
        ensureTrunkIdsIsMutable();
        this.trunkIds_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$ListSIPInboundTrunkRequest();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0002\u0000\u0001Ț\u0002Ț\u0003\t", new Object[]{"trunkIds_", "numbers_", "page_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$ListSIPInboundTrunkRequest.class) {
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

    public String getNumbers(int i) {
        return (String) this.numbers_.get(i);
    }

    public AbstractC2383g getNumbersBytes(int i) {
        return AbstractC2383g.N((String) this.numbers_.get(i));
    }

    public int getNumbersCount() {
        return this.numbers_.size();
    }

    public List<String> getNumbersList() {
        return this.numbers_;
    }

    public LivekitModels$Pagination getPage() {
        LivekitModels$Pagination livekitModels$Pagination = this.page_;
        return livekitModels$Pagination == null ? LivekitModels$Pagination.getDefaultInstance() : livekitModels$Pagination;
    }

    public String getTrunkIds(int i) {
        return (String) this.trunkIds_.get(i);
    }

    public AbstractC2383g getTrunkIdsBytes(int i) {
        return AbstractC2383g.N((String) this.trunkIds_.get(i));
    }

    public int getTrunkIdsCount() {
        return this.trunkIds_.size();
    }

    public List<String> getTrunkIdsList() {
        return this.trunkIds_;
    }

    public boolean hasPage() {
        return this.page_ != null;
    }

    public static a newBuilder(LivekitSip$ListSIPInboundTrunkRequest livekitSip$ListSIPInboundTrunkRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$ListSIPInboundTrunkRequest);
    }

    public static LivekitSip$ListSIPInboundTrunkRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$ListSIPInboundTrunkRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$ListSIPInboundTrunkRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$ListSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$ListSIPInboundTrunkRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$ListSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$ListSIPInboundTrunkRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$ListSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$ListSIPInboundTrunkRequest parseFrom(byte[] bArr) {
        return (LivekitSip$ListSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$ListSIPInboundTrunkRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$ListSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$ListSIPInboundTrunkRequest parseFrom(InputStream inputStream) {
        return (LivekitSip$ListSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$ListSIPInboundTrunkRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$ListSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$ListSIPInboundTrunkRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$ListSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$ListSIPInboundTrunkRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$ListSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

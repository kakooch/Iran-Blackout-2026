package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.CollectionsStruct$StringValue;
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

/* loaded from: classes9.dex */
public final class KetfOuterClass$ResponseGetInlineBotResults extends GeneratedMessageLite implements U64 {
    private static final KetfOuterClass$ResponseGetInlineBotResults DEFAULT_INSTANCE;
    public static final int IS_GALLERY_FIELD_NUMBER = 4;
    public static final int NEXT_OFFSET_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int QUERY_ID_FIELD_NUMBER = 3;
    public static final int RESULTS_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean isGallery_;
    private CollectionsStruct$StringValue nextOffset_;
    private CollectionsStruct$Int64Value queryId_;
    private B.j results_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfOuterClass$ResponseGetInlineBotResults.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfOuterClass$ResponseGetInlineBotResults ketfOuterClass$ResponseGetInlineBotResults = new KetfOuterClass$ResponseGetInlineBotResults();
        DEFAULT_INSTANCE = ketfOuterClass$ResponseGetInlineBotResults;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$ResponseGetInlineBotResults.class, ketfOuterClass$ResponseGetInlineBotResults);
    }

    private KetfOuterClass$ResponseGetInlineBotResults() {
    }

    private void addAllResults(Iterable<? extends KetfStruct$BotResult> iterable) {
        ensureResultsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.results_);
    }

    private void addResults(KetfStruct$BotResult ketfStruct$BotResult) {
        ketfStruct$BotResult.getClass();
        ensureResultsIsMutable();
        this.results_.add(ketfStruct$BotResult);
    }

    private void clearIsGallery() {
        this.isGallery_ = false;
    }

    private void clearNextOffset() {
        this.nextOffset_ = null;
        this.bitField0_ &= -2;
    }

    private void clearQueryId() {
        this.queryId_ = null;
        this.bitField0_ &= -3;
    }

    private void clearResults() {
        this.results_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureResultsIsMutable() {
        B.j jVar = this.results_;
        if (jVar.u()) {
            return;
        }
        this.results_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static KetfOuterClass$ResponseGetInlineBotResults getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeNextOffset(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.nextOffset_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.nextOffset_ = collectionsStruct$StringValue;
        } else {
            this.nextOffset_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.nextOffset_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeQueryId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.queryId_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.queryId_ = collectionsStruct$Int64Value;
        } else {
            this.queryId_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.queryId_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$ResponseGetInlineBotResults parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseGetInlineBotResults) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseGetInlineBotResults parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$ResponseGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeResults(int i) {
        ensureResultsIsMutable();
        this.results_.remove(i);
    }

    private void setIsGallery(boolean z) {
        this.isGallery_ = z;
    }

    private void setNextOffset(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.nextOffset_ = collectionsStruct$StringValue;
        this.bitField0_ |= 1;
    }

    private void setQueryId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.queryId_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 2;
    }

    private void setResults(int i, KetfStruct$BotResult ketfStruct$BotResult) {
        ketfStruct$BotResult.getClass();
        ensureResultsIsMutable();
        this.results_.set(i, ketfStruct$BotResult);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$ResponseGetInlineBotResults();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003ဉ\u0001\u0004\u0007", new Object[]{"bitField0_", "results_", KetfStruct$BotResult.class, "nextOffset_", "queryId_", "isGallery_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$ResponseGetInlineBotResults.class) {
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

    public boolean getIsGallery() {
        return this.isGallery_;
    }

    public CollectionsStruct$StringValue getNextOffset() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.nextOffset_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public CollectionsStruct$Int64Value getQueryId() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.queryId_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public KetfStruct$BotResult getResults(int i) {
        return (KetfStruct$BotResult) this.results_.get(i);
    }

    public int getResultsCount() {
        return this.results_.size();
    }

    public List<KetfStruct$BotResult> getResultsList() {
        return this.results_;
    }

    public InterfaceC1894t0 getResultsOrBuilder(int i) {
        return (InterfaceC1894t0) this.results_.get(i);
    }

    public List<? extends InterfaceC1894t0> getResultsOrBuilderList() {
        return this.results_;
    }

    public boolean hasNextOffset() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasQueryId() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(KetfOuterClass$ResponseGetInlineBotResults ketfOuterClass$ResponseGetInlineBotResults) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$ResponseGetInlineBotResults);
    }

    public static KetfOuterClass$ResponseGetInlineBotResults parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetInlineBotResults) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseGetInlineBotResults parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$ResponseGetInlineBotResults parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$ResponseGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addResults(int i, KetfStruct$BotResult ketfStruct$BotResult) {
        ketfStruct$BotResult.getClass();
        ensureResultsIsMutable();
        this.results_.add(i, ketfStruct$BotResult);
    }

    public static KetfOuterClass$ResponseGetInlineBotResults parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$ResponseGetInlineBotResults parseFrom(byte[] bArr) {
        return (KetfOuterClass$ResponseGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$ResponseGetInlineBotResults parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$ResponseGetInlineBotResults parseFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseGetInlineBotResults parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseGetInlineBotResults parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$ResponseGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$ResponseGetInlineBotResults parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetInlineBotResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

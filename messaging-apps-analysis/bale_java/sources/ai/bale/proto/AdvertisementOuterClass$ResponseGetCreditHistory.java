package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC8268Vg;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetCreditHistory extends GeneratedMessageLite implements U64 {
    public static final int CREDIT_HISTORIES_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetCreditHistory DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j creditHistories_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetCreditHistory.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetCreditHistory advertisementOuterClass$ResponseGetCreditHistory = new AdvertisementOuterClass$ResponseGetCreditHistory();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetCreditHistory;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetCreditHistory.class, advertisementOuterClass$ResponseGetCreditHistory);
    }

    private AdvertisementOuterClass$ResponseGetCreditHistory() {
    }

    private void addAllCreditHistories(Iterable<? extends AdvertisementStruct$CreditHistoryData> iterable) {
        ensureCreditHistoriesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.creditHistories_);
    }

    private void addCreditHistories(int i, AdvertisementStruct$CreditHistoryData advertisementStruct$CreditHistoryData) {
        advertisementStruct$CreditHistoryData.getClass();
        ensureCreditHistoriesIsMutable();
        this.creditHistories_.add(i, advertisementStruct$CreditHistoryData);
    }

    private void clearCreditHistories() {
        this.creditHistories_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureCreditHistoriesIsMutable() {
        B.j jVar = this.creditHistories_;
        if (jVar.u()) {
            return;
        }
        this.creditHistories_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementOuterClass$ResponseGetCreditHistory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetCreditHistory parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetCreditHistory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetCreditHistory parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCreditHistories(int i) {
        ensureCreditHistoriesIsMutable();
        this.creditHistories_.remove(i);
    }

    private void setCreditHistories(int i, AdvertisementStruct$CreditHistoryData advertisementStruct$CreditHistoryData) {
        advertisementStruct$CreditHistoryData.getClass();
        ensureCreditHistoriesIsMutable();
        this.creditHistories_.set(i, advertisementStruct$CreditHistoryData);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetCreditHistory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"creditHistories_", AdvertisementStruct$CreditHistoryData.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetCreditHistory.class) {
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

    public AdvertisementStruct$CreditHistoryData getCreditHistories(int i) {
        return (AdvertisementStruct$CreditHistoryData) this.creditHistories_.get(i);
    }

    public int getCreditHistoriesCount() {
        return this.creditHistories_.size();
    }

    public List<AdvertisementStruct$CreditHistoryData> getCreditHistoriesList() {
        return this.creditHistories_;
    }

    public InterfaceC8268Vg getCreditHistoriesOrBuilder(int i) {
        return (InterfaceC8268Vg) this.creditHistories_.get(i);
    }

    public List<? extends InterfaceC8268Vg> getCreditHistoriesOrBuilderList() {
        return this.creditHistories_;
    }

    private void addCreditHistories(AdvertisementStruct$CreditHistoryData advertisementStruct$CreditHistoryData) {
        advertisementStruct$CreditHistoryData.getClass();
        ensureCreditHistoriesIsMutable();
        this.creditHistories_.add(advertisementStruct$CreditHistoryData);
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetCreditHistory advertisementOuterClass$ResponseGetCreditHistory) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetCreditHistory);
    }

    public static AdvertisementOuterClass$ResponseGetCreditHistory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCreditHistory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCreditHistory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCreditHistory parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetCreditHistory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCreditHistory parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetCreditHistory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCreditHistory parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static AdvertisementOuterClass$ResponseGetCreditHistory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCreditHistory parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetCreditHistory parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCreditHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}

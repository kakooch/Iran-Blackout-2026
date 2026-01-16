package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC8768Xg;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetCustomIncomes extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$ResponseGetCustomIncomes DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int RECORDS_FIELD_NUMBER = 1;
    private B.j records_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetCustomIncomes.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetCustomIncomes advertisementOuterClass$ResponseGetCustomIncomes = new AdvertisementOuterClass$ResponseGetCustomIncomes();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetCustomIncomes;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetCustomIncomes.class, advertisementOuterClass$ResponseGetCustomIncomes);
    }

    private AdvertisementOuterClass$ResponseGetCustomIncomes() {
    }

    private void addAllRecords(Iterable<? extends AdvertisementStruct$CustomIncomeRecord> iterable) {
        ensureRecordsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.records_);
    }

    private void addRecords(int i, AdvertisementStruct$CustomIncomeRecord advertisementStruct$CustomIncomeRecord) {
        advertisementStruct$CustomIncomeRecord.getClass();
        ensureRecordsIsMutable();
        this.records_.add(i, advertisementStruct$CustomIncomeRecord);
    }

    private void clearRecords() {
        this.records_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureRecordsIsMutable() {
        B.j jVar = this.records_;
        if (jVar.u()) {
            return;
        }
        this.records_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementOuterClass$ResponseGetCustomIncomes getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetCustomIncomes parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetCustomIncomes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetCustomIncomes parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeRecords(int i) {
        ensureRecordsIsMutable();
        this.records_.remove(i);
    }

    private void setRecords(int i, AdvertisementStruct$CustomIncomeRecord advertisementStruct$CustomIncomeRecord) {
        advertisementStruct$CustomIncomeRecord.getClass();
        ensureRecordsIsMutable();
        this.records_.set(i, advertisementStruct$CustomIncomeRecord);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetCustomIncomes();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"records_", AdvertisementStruct$CustomIncomeRecord.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetCustomIncomes.class) {
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

    public AdvertisementStruct$CustomIncomeRecord getRecords(int i) {
        return (AdvertisementStruct$CustomIncomeRecord) this.records_.get(i);
    }

    public int getRecordsCount() {
        return this.records_.size();
    }

    public List<AdvertisementStruct$CustomIncomeRecord> getRecordsList() {
        return this.records_;
    }

    public InterfaceC8768Xg getRecordsOrBuilder(int i) {
        return (InterfaceC8768Xg) this.records_.get(i);
    }

    public List<? extends InterfaceC8768Xg> getRecordsOrBuilderList() {
        return this.records_;
    }

    private void addRecords(AdvertisementStruct$CustomIncomeRecord advertisementStruct$CustomIncomeRecord) {
        advertisementStruct$CustomIncomeRecord.getClass();
        ensureRecordsIsMutable();
        this.records_.add(advertisementStruct$CustomIncomeRecord);
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetCustomIncomes advertisementOuterClass$ResponseGetCustomIncomes) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetCustomIncomes);
    }

    public static AdvertisementOuterClass$ResponseGetCustomIncomes parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCustomIncomes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCustomIncomes parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCustomIncomes parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetCustomIncomes parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCustomIncomes parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetCustomIncomes parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCustomIncomes parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static AdvertisementOuterClass$ResponseGetCustomIncomes parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCustomIncomes parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetCustomIncomes parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCustomIncomes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}

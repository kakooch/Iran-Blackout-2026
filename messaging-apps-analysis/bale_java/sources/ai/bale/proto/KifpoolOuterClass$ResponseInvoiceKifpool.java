package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC8128Uq3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class KifpoolOuterClass$ResponseInvoiceKifpool extends GeneratedMessageLite implements U64 {
    private static final KifpoolOuterClass$ResponseInvoiceKifpool DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int RECORDS_FIELD_NUMBER = 1;
    private B.j records_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$ResponseInvoiceKifpool.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$ResponseInvoiceKifpool kifpoolOuterClass$ResponseInvoiceKifpool = new KifpoolOuterClass$ResponseInvoiceKifpool();
        DEFAULT_INSTANCE = kifpoolOuterClass$ResponseInvoiceKifpool;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$ResponseInvoiceKifpool.class, kifpoolOuterClass$ResponseInvoiceKifpool);
    }

    private KifpoolOuterClass$ResponseInvoiceKifpool() {
    }

    private void addAllRecords(Iterable<? extends KifpoolStruct$InvoiceRecord> iterable) {
        ensureRecordsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.records_);
    }

    private void addRecords(KifpoolStruct$InvoiceRecord kifpoolStruct$InvoiceRecord) {
        kifpoolStruct$InvoiceRecord.getClass();
        ensureRecordsIsMutable();
        this.records_.add(kifpoolStruct$InvoiceRecord);
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

    public static KifpoolOuterClass$ResponseInvoiceKifpool getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$ResponseInvoiceKifpool parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseInvoiceKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseInvoiceKifpool parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$ResponseInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeRecords(int i) {
        ensureRecordsIsMutable();
        this.records_.remove(i);
    }

    private void setRecords(int i, KifpoolStruct$InvoiceRecord kifpoolStruct$InvoiceRecord) {
        kifpoolStruct$InvoiceRecord.getClass();
        ensureRecordsIsMutable();
        this.records_.set(i, kifpoolStruct$InvoiceRecord);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$ResponseInvoiceKifpool();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"records_", KifpoolStruct$InvoiceRecord.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$ResponseInvoiceKifpool.class) {
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

    public KifpoolStruct$InvoiceRecord getRecords(int i) {
        return (KifpoolStruct$InvoiceRecord) this.records_.get(i);
    }

    public int getRecordsCount() {
        return this.records_.size();
    }

    public List<KifpoolStruct$InvoiceRecord> getRecordsList() {
        return this.records_;
    }

    public InterfaceC8128Uq3 getRecordsOrBuilder(int i) {
        return (InterfaceC8128Uq3) this.records_.get(i);
    }

    public List<? extends InterfaceC8128Uq3> getRecordsOrBuilderList() {
        return this.records_;
    }

    public static a newBuilder(KifpoolOuterClass$ResponseInvoiceKifpool kifpoolOuterClass$ResponseInvoiceKifpool) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$ResponseInvoiceKifpool);
    }

    public static KifpoolOuterClass$ResponseInvoiceKifpool parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseInvoiceKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseInvoiceKifpool parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$ResponseInvoiceKifpool parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$ResponseInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addRecords(int i, KifpoolStruct$InvoiceRecord kifpoolStruct$InvoiceRecord) {
        kifpoolStruct$InvoiceRecord.getClass();
        ensureRecordsIsMutable();
        this.records_.add(i, kifpoolStruct$InvoiceRecord);
    }

    public static KifpoolOuterClass$ResponseInvoiceKifpool parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$ResponseInvoiceKifpool parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$ResponseInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$ResponseInvoiceKifpool parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$ResponseInvoiceKifpool parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseInvoiceKifpool parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseInvoiceKifpool parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$ResponseInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$ResponseInvoiceKifpool parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

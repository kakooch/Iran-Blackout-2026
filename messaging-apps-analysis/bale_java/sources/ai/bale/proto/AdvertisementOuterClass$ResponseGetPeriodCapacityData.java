package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC10482bh;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetPeriodCapacityData extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetPeriodCapacityData DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j data_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetPeriodCapacityData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetPeriodCapacityData advertisementOuterClass$ResponseGetPeriodCapacityData = new AdvertisementOuterClass$ResponseGetPeriodCapacityData();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetPeriodCapacityData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetPeriodCapacityData.class, advertisementOuterClass$ResponseGetPeriodCapacityData);
    }

    private AdvertisementOuterClass$ResponseGetPeriodCapacityData() {
    }

    private void addAllData(Iterable<? extends AdvertisementStruct$DayCapacityData> iterable) {
        ensureDataIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.data_);
    }

    private void addData(AdvertisementStruct$DayCapacityData advertisementStruct$DayCapacityData) {
        advertisementStruct$DayCapacityData.getClass();
        ensureDataIsMutable();
        this.data_.add(advertisementStruct$DayCapacityData);
    }

    private void clearData() {
        this.data_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDataIsMutable() {
        B.j jVar = this.data_;
        if (jVar.u()) {
            return;
        }
        this.data_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementOuterClass$ResponseGetPeriodCapacityData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetPeriodCapacityData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetPeriodCapacityData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetPeriodCapacityData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeData(int i) {
        ensureDataIsMutable();
        this.data_.remove(i);
    }

    private void setData(int i, AdvertisementStruct$DayCapacityData advertisementStruct$DayCapacityData) {
        advertisementStruct$DayCapacityData.getClass();
        ensureDataIsMutable();
        this.data_.set(i, advertisementStruct$DayCapacityData);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetPeriodCapacityData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"data_", AdvertisementStruct$DayCapacityData.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetPeriodCapacityData.class) {
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

    public AdvertisementStruct$DayCapacityData getData(int i) {
        return (AdvertisementStruct$DayCapacityData) this.data_.get(i);
    }

    public int getDataCount() {
        return this.data_.size();
    }

    public List<AdvertisementStruct$DayCapacityData> getDataList() {
        return this.data_;
    }

    public InterfaceC10482bh getDataOrBuilder(int i) {
        return (InterfaceC10482bh) this.data_.get(i);
    }

    public List<? extends InterfaceC10482bh> getDataOrBuilderList() {
        return this.data_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetPeriodCapacityData advertisementOuterClass$ResponseGetPeriodCapacityData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetPeriodCapacityData);
    }

    public static AdvertisementOuterClass$ResponseGetPeriodCapacityData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetPeriodCapacityData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetPeriodCapacityData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetPeriodCapacityData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addData(int i, AdvertisementStruct$DayCapacityData advertisementStruct$DayCapacityData) {
        advertisementStruct$DayCapacityData.getClass();
        ensureDataIsMutable();
        this.data_.add(i, advertisementStruct$DayCapacityData);
    }

    public static AdvertisementOuterClass$ResponseGetPeriodCapacityData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetPeriodCapacityData parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetPeriodCapacityData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetPeriodCapacityData parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetPeriodCapacityData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetPeriodCapacityData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetPeriodCapacityData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetPeriodCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

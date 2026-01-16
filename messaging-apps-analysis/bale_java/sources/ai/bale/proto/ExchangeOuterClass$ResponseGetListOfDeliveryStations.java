package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7528Sc2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class ExchangeOuterClass$ResponseGetListOfDeliveryStations extends GeneratedMessageLite implements U64 {
    private static final ExchangeOuterClass$ResponseGetListOfDeliveryStations DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STATIONS_FIELD_NUMBER = 1;
    private B.j stations_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ExchangeOuterClass$ResponseGetListOfDeliveryStations.DEFAULT_INSTANCE);
        }
    }

    static {
        ExchangeOuterClass$ResponseGetListOfDeliveryStations exchangeOuterClass$ResponseGetListOfDeliveryStations = new ExchangeOuterClass$ResponseGetListOfDeliveryStations();
        DEFAULT_INSTANCE = exchangeOuterClass$ResponseGetListOfDeliveryStations;
        GeneratedMessageLite.registerDefaultInstance(ExchangeOuterClass$ResponseGetListOfDeliveryStations.class, exchangeOuterClass$ResponseGetListOfDeliveryStations);
    }

    private ExchangeOuterClass$ResponseGetListOfDeliveryStations() {
    }

    private void addAllStations(Iterable<? extends ExchangeStruct$Station> iterable) {
        ensureStationsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.stations_);
    }

    private void addStations(ExchangeStruct$Station exchangeStruct$Station) {
        exchangeStruct$Station.getClass();
        ensureStationsIsMutable();
        this.stations_.add(exchangeStruct$Station);
    }

    private void clearStations() {
        this.stations_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureStationsIsMutable() {
        B.j jVar = this.stations_;
        if (jVar.u()) {
            return;
        }
        this.stations_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ExchangeOuterClass$ResponseGetListOfDeliveryStations getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ExchangeOuterClass$ResponseGetListOfDeliveryStations parseDelimitedFrom(InputStream inputStream) {
        return (ExchangeOuterClass$ResponseGetListOfDeliveryStations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$ResponseGetListOfDeliveryStations parseFrom(ByteBuffer byteBuffer) {
        return (ExchangeOuterClass$ResponseGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeStations(int i) {
        ensureStationsIsMutable();
        this.stations_.remove(i);
    }

    private void setStations(int i, ExchangeStruct$Station exchangeStruct$Station) {
        exchangeStruct$Station.getClass();
        ensureStationsIsMutable();
        this.stations_.set(i, exchangeStruct$Station);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (U.a[gVar.ordinal()]) {
            case 1:
                return new ExchangeOuterClass$ResponseGetListOfDeliveryStations();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"stations_", ExchangeStruct$Station.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ExchangeOuterClass$ResponseGetListOfDeliveryStations.class) {
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

    public ExchangeStruct$Station getStations(int i) {
        return (ExchangeStruct$Station) this.stations_.get(i);
    }

    public int getStationsCount() {
        return this.stations_.size();
    }

    public List<ExchangeStruct$Station> getStationsList() {
        return this.stations_;
    }

    public InterfaceC7528Sc2 getStationsOrBuilder(int i) {
        return (InterfaceC7528Sc2) this.stations_.get(i);
    }

    public List<? extends InterfaceC7528Sc2> getStationsOrBuilderList() {
        return this.stations_;
    }

    public static a newBuilder(ExchangeOuterClass$ResponseGetListOfDeliveryStations exchangeOuterClass$ResponseGetListOfDeliveryStations) {
        return (a) DEFAULT_INSTANCE.createBuilder(exchangeOuterClass$ResponseGetListOfDeliveryStations);
    }

    public static ExchangeOuterClass$ResponseGetListOfDeliveryStations parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetListOfDeliveryStations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetListOfDeliveryStations parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetListOfDeliveryStations parseFrom(AbstractC2383g abstractC2383g) {
        return (ExchangeOuterClass$ResponseGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addStations(int i, ExchangeStruct$Station exchangeStruct$Station) {
        exchangeStruct$Station.getClass();
        ensureStationsIsMutable();
        this.stations_.add(i, exchangeStruct$Station);
    }

    public static ExchangeOuterClass$ResponseGetListOfDeliveryStations parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetListOfDeliveryStations parseFrom(byte[] bArr) {
        return (ExchangeOuterClass$ResponseGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ExchangeOuterClass$ResponseGetListOfDeliveryStations parseFrom(byte[] bArr, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetListOfDeliveryStations parseFrom(InputStream inputStream) {
        return (ExchangeOuterClass$ResponseGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$ResponseGetListOfDeliveryStations parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetListOfDeliveryStations parseFrom(AbstractC2384h abstractC2384h) {
        return (ExchangeOuterClass$ResponseGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ExchangeOuterClass$ResponseGetListOfDeliveryStations parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

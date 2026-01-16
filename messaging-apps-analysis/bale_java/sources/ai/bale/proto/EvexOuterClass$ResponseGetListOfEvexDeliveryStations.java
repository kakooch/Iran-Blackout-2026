package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC6568Ob2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class EvexOuterClass$ResponseGetListOfEvexDeliveryStations extends GeneratedMessageLite implements U64 {
    private static final EvexOuterClass$ResponseGetListOfEvexDeliveryStations DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STATIONS_FIELD_NUMBER = 1;
    private B.j stations_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(EvexOuterClass$ResponseGetListOfEvexDeliveryStations.DEFAULT_INSTANCE);
        }
    }

    static {
        EvexOuterClass$ResponseGetListOfEvexDeliveryStations evexOuterClass$ResponseGetListOfEvexDeliveryStations = new EvexOuterClass$ResponseGetListOfEvexDeliveryStations();
        DEFAULT_INSTANCE = evexOuterClass$ResponseGetListOfEvexDeliveryStations;
        GeneratedMessageLite.registerDefaultInstance(EvexOuterClass$ResponseGetListOfEvexDeliveryStations.class, evexOuterClass$ResponseGetListOfEvexDeliveryStations);
    }

    private EvexOuterClass$ResponseGetListOfEvexDeliveryStations() {
    }

    private void addAllStations(Iterable<? extends EvexStruct$EvexStation> iterable) {
        ensureStationsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.stations_);
    }

    private void addStations(EvexStruct$EvexStation evexStruct$EvexStation) {
        evexStruct$EvexStation.getClass();
        ensureStationsIsMutable();
        this.stations_.add(evexStruct$EvexStation);
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

    public static EvexOuterClass$ResponseGetListOfEvexDeliveryStations getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EvexOuterClass$ResponseGetListOfEvexDeliveryStations parseDelimitedFrom(InputStream inputStream) {
        return (EvexOuterClass$ResponseGetListOfEvexDeliveryStations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$ResponseGetListOfEvexDeliveryStations parseFrom(ByteBuffer byteBuffer) {
        return (EvexOuterClass$ResponseGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeStations(int i) {
        ensureStationsIsMutable();
        this.stations_.remove(i);
    }

    private void setStations(int i, EvexStruct$EvexStation evexStruct$EvexStation) {
        evexStruct$EvexStation.getClass();
        ensureStationsIsMutable();
        this.stations_.set(i, evexStruct$EvexStation);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S.a[gVar.ordinal()]) {
            case 1:
                return new EvexOuterClass$ResponseGetListOfEvexDeliveryStations();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"stations_", EvexStruct$EvexStation.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EvexOuterClass$ResponseGetListOfEvexDeliveryStations.class) {
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

    public EvexStruct$EvexStation getStations(int i) {
        return (EvexStruct$EvexStation) this.stations_.get(i);
    }

    public int getStationsCount() {
        return this.stations_.size();
    }

    public List<EvexStruct$EvexStation> getStationsList() {
        return this.stations_;
    }

    public InterfaceC6568Ob2 getStationsOrBuilder(int i) {
        return (InterfaceC6568Ob2) this.stations_.get(i);
    }

    public List<? extends InterfaceC6568Ob2> getStationsOrBuilderList() {
        return this.stations_;
    }

    public static a newBuilder(EvexOuterClass$ResponseGetListOfEvexDeliveryStations evexOuterClass$ResponseGetListOfEvexDeliveryStations) {
        return (a) DEFAULT_INSTANCE.createBuilder(evexOuterClass$ResponseGetListOfEvexDeliveryStations);
    }

    public static EvexOuterClass$ResponseGetListOfEvexDeliveryStations parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetListOfEvexDeliveryStations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$ResponseGetListOfEvexDeliveryStations parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EvexOuterClass$ResponseGetListOfEvexDeliveryStations parseFrom(AbstractC2383g abstractC2383g) {
        return (EvexOuterClass$ResponseGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addStations(int i, EvexStruct$EvexStation evexStruct$EvexStation) {
        evexStruct$EvexStation.getClass();
        ensureStationsIsMutable();
        this.stations_.add(i, evexStruct$EvexStation);
    }

    public static EvexOuterClass$ResponseGetListOfEvexDeliveryStations parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EvexOuterClass$ResponseGetListOfEvexDeliveryStations parseFrom(byte[] bArr) {
        return (EvexOuterClass$ResponseGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EvexOuterClass$ResponseGetListOfEvexDeliveryStations parseFrom(byte[] bArr, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EvexOuterClass$ResponseGetListOfEvexDeliveryStations parseFrom(InputStream inputStream) {
        return (EvexOuterClass$ResponseGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$ResponseGetListOfEvexDeliveryStations parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$ResponseGetListOfEvexDeliveryStations parseFrom(AbstractC2384h abstractC2384h) {
        return (EvexOuterClass$ResponseGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EvexOuterClass$ResponseGetListOfEvexDeliveryStations parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

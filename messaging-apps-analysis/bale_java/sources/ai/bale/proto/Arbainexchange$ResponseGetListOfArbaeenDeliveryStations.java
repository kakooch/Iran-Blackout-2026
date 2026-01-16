package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.JI;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Arbainexchange$ResponseGetListOfArbaeenDeliveryStations extends GeneratedMessageLite implements U64 {
    private static final Arbainexchange$ResponseGetListOfArbaeenDeliveryStations DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STATIONS_FIELD_NUMBER = 1;
    private B.j stations_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$ResponseGetListOfArbaeenDeliveryStations.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$ResponseGetListOfArbaeenDeliveryStations arbainexchange$ResponseGetListOfArbaeenDeliveryStations = new Arbainexchange$ResponseGetListOfArbaeenDeliveryStations();
        DEFAULT_INSTANCE = arbainexchange$ResponseGetListOfArbaeenDeliveryStations;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$ResponseGetListOfArbaeenDeliveryStations.class, arbainexchange$ResponseGetListOfArbaeenDeliveryStations);
    }

    private Arbainexchange$ResponseGetListOfArbaeenDeliveryStations() {
    }

    private void addAllStations(Iterable<? extends ArbainexchangeStruct$ArbaeenStation> iterable) {
        ensureStationsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.stations_);
    }

    private void addStations(ArbainexchangeStruct$ArbaeenStation arbainexchangeStruct$ArbaeenStation) {
        arbainexchangeStruct$ArbaeenStation.getClass();
        ensureStationsIsMutable();
        this.stations_.add(arbainexchangeStruct$ArbaeenStation);
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

    public static Arbainexchange$ResponseGetListOfArbaeenDeliveryStations getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$ResponseGetListOfArbaeenDeliveryStations parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseGetListOfArbaeenDeliveryStations parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$ResponseGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeStations(int i) {
        ensureStationsIsMutable();
        this.stations_.remove(i);
    }

    private void setStations(int i, ArbainexchangeStruct$ArbaeenStation arbainexchangeStruct$ArbaeenStation) {
        arbainexchangeStruct$ArbaeenStation.getClass();
        ensureStationsIsMutable();
        this.stations_.set(i, arbainexchangeStruct$ArbaeenStation);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$ResponseGetListOfArbaeenDeliveryStations();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"stations_", ArbainexchangeStruct$ArbaeenStation.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$ResponseGetListOfArbaeenDeliveryStations.class) {
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

    public ArbainexchangeStruct$ArbaeenStation getStations(int i) {
        return (ArbainexchangeStruct$ArbaeenStation) this.stations_.get(i);
    }

    public int getStationsCount() {
        return this.stations_.size();
    }

    public List<ArbainexchangeStruct$ArbaeenStation> getStationsList() {
        return this.stations_;
    }

    public JI getStationsOrBuilder(int i) {
        return (JI) this.stations_.get(i);
    }

    public List<? extends JI> getStationsOrBuilderList() {
        return this.stations_;
    }

    public static a newBuilder(Arbainexchange$ResponseGetListOfArbaeenDeliveryStations arbainexchange$ResponseGetListOfArbaeenDeliveryStations) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$ResponseGetListOfArbaeenDeliveryStations);
    }

    public static Arbainexchange$ResponseGetListOfArbaeenDeliveryStations parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfArbaeenDeliveryStations parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfArbaeenDeliveryStations parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$ResponseGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addStations(int i, ArbainexchangeStruct$ArbaeenStation arbainexchangeStruct$ArbaeenStation) {
        arbainexchangeStruct$ArbaeenStation.getClass();
        ensureStationsIsMutable();
        this.stations_.add(i, arbainexchangeStruct$ArbaeenStation);
    }

    public static Arbainexchange$ResponseGetListOfArbaeenDeliveryStations parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfArbaeenDeliveryStations parseFrom(byte[] bArr) {
        return (Arbainexchange$ResponseGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$ResponseGetListOfArbaeenDeliveryStations parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfArbaeenDeliveryStations parseFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseGetListOfArbaeenDeliveryStations parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfArbaeenDeliveryStations parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$ResponseGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$ResponseGetListOfArbaeenDeliveryStations parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfArbaeenDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

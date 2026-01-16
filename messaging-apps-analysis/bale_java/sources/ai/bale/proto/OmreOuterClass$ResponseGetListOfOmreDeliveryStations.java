package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC19998rI4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class OmreOuterClass$ResponseGetListOfOmreDeliveryStations extends GeneratedMessageLite implements U64 {
    private static final OmreOuterClass$ResponseGetListOfOmreDeliveryStations DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STATIONS_FIELD_NUMBER = 1;
    private B.j stations_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(OmreOuterClass$ResponseGetListOfOmreDeliveryStations.DEFAULT_INSTANCE);
        }
    }

    static {
        OmreOuterClass$ResponseGetListOfOmreDeliveryStations omreOuterClass$ResponseGetListOfOmreDeliveryStations = new OmreOuterClass$ResponseGetListOfOmreDeliveryStations();
        DEFAULT_INSTANCE = omreOuterClass$ResponseGetListOfOmreDeliveryStations;
        GeneratedMessageLite.registerDefaultInstance(OmreOuterClass$ResponseGetListOfOmreDeliveryStations.class, omreOuterClass$ResponseGetListOfOmreDeliveryStations);
    }

    private OmreOuterClass$ResponseGetListOfOmreDeliveryStations() {
    }

    private void addAllStations(Iterable<? extends OmreStruct$OmreStation> iterable) {
        ensureStationsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.stations_);
    }

    private void addStations(OmreStruct$OmreStation omreStruct$OmreStation) {
        omreStruct$OmreStation.getClass();
        ensureStationsIsMutable();
        this.stations_.add(omreStruct$OmreStation);
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

    public static OmreOuterClass$ResponseGetListOfOmreDeliveryStations getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static OmreOuterClass$ResponseGetListOfOmreDeliveryStations parseDelimitedFrom(InputStream inputStream) {
        return (OmreOuterClass$ResponseGetListOfOmreDeliveryStations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$ResponseGetListOfOmreDeliveryStations parseFrom(ByteBuffer byteBuffer) {
        return (OmreOuterClass$ResponseGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeStations(int i) {
        ensureStationsIsMutable();
        this.stations_.remove(i);
    }

    private void setStations(int i, OmreStruct$OmreStation omreStruct$OmreStation) {
        omreStruct$OmreStation.getClass();
        ensureStationsIsMutable();
        this.stations_.set(i, omreStruct$OmreStation);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (U0.a[gVar.ordinal()]) {
            case 1:
                return new OmreOuterClass$ResponseGetListOfOmreDeliveryStations();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"stations_", OmreStruct$OmreStation.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OmreOuterClass$ResponseGetListOfOmreDeliveryStations.class) {
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

    public OmreStruct$OmreStation getStations(int i) {
        return (OmreStruct$OmreStation) this.stations_.get(i);
    }

    public int getStationsCount() {
        return this.stations_.size();
    }

    public List<OmreStruct$OmreStation> getStationsList() {
        return this.stations_;
    }

    public InterfaceC19998rI4 getStationsOrBuilder(int i) {
        return (InterfaceC19998rI4) this.stations_.get(i);
    }

    public List<? extends InterfaceC19998rI4> getStationsOrBuilderList() {
        return this.stations_;
    }

    public static a newBuilder(OmreOuterClass$ResponseGetListOfOmreDeliveryStations omreOuterClass$ResponseGetListOfOmreDeliveryStations) {
        return (a) DEFAULT_INSTANCE.createBuilder(omreOuterClass$ResponseGetListOfOmreDeliveryStations);
    }

    public static OmreOuterClass$ResponseGetListOfOmreDeliveryStations parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetListOfOmreDeliveryStations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$ResponseGetListOfOmreDeliveryStations parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OmreOuterClass$ResponseGetListOfOmreDeliveryStations parseFrom(AbstractC2383g abstractC2383g) {
        return (OmreOuterClass$ResponseGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addStations(int i, OmreStruct$OmreStation omreStruct$OmreStation) {
        omreStruct$OmreStation.getClass();
        ensureStationsIsMutable();
        this.stations_.add(i, omreStruct$OmreStation);
    }

    public static OmreOuterClass$ResponseGetListOfOmreDeliveryStations parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OmreOuterClass$ResponseGetListOfOmreDeliveryStations parseFrom(byte[] bArr) {
        return (OmreOuterClass$ResponseGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OmreOuterClass$ResponseGetListOfOmreDeliveryStations parseFrom(byte[] bArr, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OmreOuterClass$ResponseGetListOfOmreDeliveryStations parseFrom(InputStream inputStream) {
        return (OmreOuterClass$ResponseGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$ResponseGetListOfOmreDeliveryStations parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$ResponseGetListOfOmreDeliveryStations parseFrom(AbstractC2384h abstractC2384h) {
        return (OmreOuterClass$ResponseGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OmreOuterClass$ResponseGetListOfOmreDeliveryStations parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

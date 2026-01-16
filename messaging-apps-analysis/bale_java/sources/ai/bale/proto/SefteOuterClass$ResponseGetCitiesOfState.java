package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC18499ol6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SefteOuterClass$ResponseGetCitiesOfState extends GeneratedMessageLite implements U64 {
    public static final int CITIES_FIELD_NUMBER = 1;
    private static final SefteOuterClass$ResponseGetCitiesOfState DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j cities_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SefteOuterClass$ResponseGetCitiesOfState.DEFAULT_INSTANCE);
        }
    }

    static {
        SefteOuterClass$ResponseGetCitiesOfState sefteOuterClass$ResponseGetCitiesOfState = new SefteOuterClass$ResponseGetCitiesOfState();
        DEFAULT_INSTANCE = sefteOuterClass$ResponseGetCitiesOfState;
        GeneratedMessageLite.registerDefaultInstance(SefteOuterClass$ResponseGetCitiesOfState.class, sefteOuterClass$ResponseGetCitiesOfState);
    }

    private SefteOuterClass$ResponseGetCitiesOfState() {
    }

    private void addAllCities(Iterable<? extends SefteStruct$CityInfo> iterable) {
        ensureCitiesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.cities_);
    }

    private void addCities(SefteStruct$CityInfo sefteStruct$CityInfo) {
        sefteStruct$CityInfo.getClass();
        ensureCitiesIsMutable();
        this.cities_.add(sefteStruct$CityInfo);
    }

    private void clearCities() {
        this.cities_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureCitiesIsMutable() {
        B.j jVar = this.cities_;
        if (jVar.u()) {
            return;
        }
        this.cities_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SefteOuterClass$ResponseGetCitiesOfState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SefteOuterClass$ResponseGetCitiesOfState parseDelimitedFrom(InputStream inputStream) {
        return (SefteOuterClass$ResponseGetCitiesOfState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$ResponseGetCitiesOfState parseFrom(ByteBuffer byteBuffer) {
        return (SefteOuterClass$ResponseGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCities(int i) {
        ensureCitiesIsMutable();
        this.cities_.remove(i);
    }

    private void setCities(int i, SefteStruct$CityInfo sefteStruct$CityInfo) {
        sefteStruct$CityInfo.getClass();
        ensureCitiesIsMutable();
        this.cities_.set(i, sefteStruct$CityInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P1.a[gVar.ordinal()]) {
            case 1:
                return new SefteOuterClass$ResponseGetCitiesOfState();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"cities_", SefteStruct$CityInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SefteOuterClass$ResponseGetCitiesOfState.class) {
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

    public SefteStruct$CityInfo getCities(int i) {
        return (SefteStruct$CityInfo) this.cities_.get(i);
    }

    public int getCitiesCount() {
        return this.cities_.size();
    }

    public List<SefteStruct$CityInfo> getCitiesList() {
        return this.cities_;
    }

    public InterfaceC18499ol6 getCitiesOrBuilder(int i) {
        return (InterfaceC18499ol6) this.cities_.get(i);
    }

    public List<? extends InterfaceC18499ol6> getCitiesOrBuilderList() {
        return this.cities_;
    }

    public static a newBuilder(SefteOuterClass$ResponseGetCitiesOfState sefteOuterClass$ResponseGetCitiesOfState) {
        return (a) DEFAULT_INSTANCE.createBuilder(sefteOuterClass$ResponseGetCitiesOfState);
    }

    public static SefteOuterClass$ResponseGetCitiesOfState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetCitiesOfState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$ResponseGetCitiesOfState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SefteOuterClass$ResponseGetCitiesOfState parseFrom(AbstractC2383g abstractC2383g) {
        return (SefteOuterClass$ResponseGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCities(int i, SefteStruct$CityInfo sefteStruct$CityInfo) {
        sefteStruct$CityInfo.getClass();
        ensureCitiesIsMutable();
        this.cities_.add(i, sefteStruct$CityInfo);
    }

    public static SefteOuterClass$ResponseGetCitiesOfState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SefteOuterClass$ResponseGetCitiesOfState parseFrom(byte[] bArr) {
        return (SefteOuterClass$ResponseGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SefteOuterClass$ResponseGetCitiesOfState parseFrom(byte[] bArr, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SefteOuterClass$ResponseGetCitiesOfState parseFrom(InputStream inputStream) {
        return (SefteOuterClass$ResponseGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$ResponseGetCitiesOfState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$ResponseGetCitiesOfState parseFrom(AbstractC2384h abstractC2384h) {
        return (SefteOuterClass$ResponseGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SefteOuterClass$ResponseGetCitiesOfState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetCitiesOfState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KG0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Car$ResponseGetPlates extends GeneratedMessageLite implements U64 {
    private static final Car$ResponseGetPlates DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PLATES_FIELD_NUMBER = 1;
    private B.j plates_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Car$ResponseGetPlates.DEFAULT_INSTANCE);
        }
    }

    static {
        Car$ResponseGetPlates car$ResponseGetPlates = new Car$ResponseGetPlates();
        DEFAULT_INSTANCE = car$ResponseGetPlates;
        GeneratedMessageLite.registerDefaultInstance(Car$ResponseGetPlates.class, car$ResponseGetPlates);
    }

    private Car$ResponseGetPlates() {
    }

    private void addAllPlates(Iterable<? extends CarStruct$Plate> iterable) {
        ensurePlatesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.plates_);
    }

    private void addPlates(CarStruct$Plate carStruct$Plate) {
        carStruct$Plate.getClass();
        ensurePlatesIsMutable();
        this.plates_.add(carStruct$Plate);
    }

    private void clearPlates() {
        this.plates_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePlatesIsMutable() {
        B.j jVar = this.plates_;
        if (jVar.u()) {
            return;
        }
        this.plates_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Car$ResponseGetPlates getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Car$ResponseGetPlates parseDelimitedFrom(InputStream inputStream) {
        return (Car$ResponseGetPlates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Car$ResponseGetPlates parseFrom(ByteBuffer byteBuffer) {
        return (Car$ResponseGetPlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePlates(int i) {
        ensurePlatesIsMutable();
        this.plates_.remove(i);
    }

    private void setPlates(int i, CarStruct$Plate carStruct$Plate) {
        carStruct$Plate.getClass();
        ensurePlatesIsMutable();
        this.plates_.set(i, carStruct$Plate);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1905x.a[gVar.ordinal()]) {
            case 1:
                return new Car$ResponseGetPlates();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"plates_", CarStruct$Plate.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Car$ResponseGetPlates.class) {
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

    public CarStruct$Plate getPlates(int i) {
        return (CarStruct$Plate) this.plates_.get(i);
    }

    public int getPlatesCount() {
        return this.plates_.size();
    }

    public List<CarStruct$Plate> getPlatesList() {
        return this.plates_;
    }

    public KG0 getPlatesOrBuilder(int i) {
        return (KG0) this.plates_.get(i);
    }

    public List<? extends KG0> getPlatesOrBuilderList() {
        return this.plates_;
    }

    public static a newBuilder(Car$ResponseGetPlates car$ResponseGetPlates) {
        return (a) DEFAULT_INSTANCE.createBuilder(car$ResponseGetPlates);
    }

    public static Car$ResponseGetPlates parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Car$ResponseGetPlates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Car$ResponseGetPlates parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Car$ResponseGetPlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Car$ResponseGetPlates parseFrom(AbstractC2383g abstractC2383g) {
        return (Car$ResponseGetPlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPlates(int i, CarStruct$Plate carStruct$Plate) {
        carStruct$Plate.getClass();
        ensurePlatesIsMutable();
        this.plates_.add(i, carStruct$Plate);
    }

    public static Car$ResponseGetPlates parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Car$ResponseGetPlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Car$ResponseGetPlates parseFrom(byte[] bArr) {
        return (Car$ResponseGetPlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Car$ResponseGetPlates parseFrom(byte[] bArr, C2394s c2394s) {
        return (Car$ResponseGetPlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Car$ResponseGetPlates parseFrom(InputStream inputStream) {
        return (Car$ResponseGetPlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Car$ResponseGetPlates parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Car$ResponseGetPlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Car$ResponseGetPlates parseFrom(AbstractC2384h abstractC2384h) {
        return (Car$ResponseGetPlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Car$ResponseGetPlates parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Car$ResponseGetPlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

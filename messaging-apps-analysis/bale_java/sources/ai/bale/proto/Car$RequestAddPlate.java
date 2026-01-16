package ai.bale.proto;

import ai.bale.proto.CarStruct$Plate;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Car$RequestAddPlate extends GeneratedMessageLite implements U64 {
    private static final Car$RequestAddPlate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PLATE_FIELD_NUMBER = 1;
    private int bitField0_;
    private CarStruct$Plate plate_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Car$RequestAddPlate.DEFAULT_INSTANCE);
        }
    }

    static {
        Car$RequestAddPlate car$RequestAddPlate = new Car$RequestAddPlate();
        DEFAULT_INSTANCE = car$RequestAddPlate;
        GeneratedMessageLite.registerDefaultInstance(Car$RequestAddPlate.class, car$RequestAddPlate);
    }

    private Car$RequestAddPlate() {
    }

    private void clearPlate() {
        this.plate_ = null;
        this.bitField0_ &= -2;
    }

    public static Car$RequestAddPlate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePlate(CarStruct$Plate carStruct$Plate) {
        carStruct$Plate.getClass();
        CarStruct$Plate carStruct$Plate2 = this.plate_;
        if (carStruct$Plate2 == null || carStruct$Plate2 == CarStruct$Plate.getDefaultInstance()) {
            this.plate_ = carStruct$Plate;
        } else {
            this.plate_ = (CarStruct$Plate) ((CarStruct$Plate.a) CarStruct$Plate.newBuilder(this.plate_).v(carStruct$Plate)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Car$RequestAddPlate parseDelimitedFrom(InputStream inputStream) {
        return (Car$RequestAddPlate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Car$RequestAddPlate parseFrom(ByteBuffer byteBuffer) {
        return (Car$RequestAddPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPlate(CarStruct$Plate carStruct$Plate) {
        carStruct$Plate.getClass();
        this.plate_ = carStruct$Plate;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1905x.a[gVar.ordinal()]) {
            case 1:
                return new Car$RequestAddPlate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "plate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Car$RequestAddPlate.class) {
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

    public CarStruct$Plate getPlate() {
        CarStruct$Plate carStruct$Plate = this.plate_;
        return carStruct$Plate == null ? CarStruct$Plate.getDefaultInstance() : carStruct$Plate;
    }

    public boolean hasPlate() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Car$RequestAddPlate car$RequestAddPlate) {
        return (a) DEFAULT_INSTANCE.createBuilder(car$RequestAddPlate);
    }

    public static Car$RequestAddPlate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Car$RequestAddPlate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Car$RequestAddPlate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Car$RequestAddPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Car$RequestAddPlate parseFrom(AbstractC2383g abstractC2383g) {
        return (Car$RequestAddPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Car$RequestAddPlate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Car$RequestAddPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Car$RequestAddPlate parseFrom(byte[] bArr) {
        return (Car$RequestAddPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Car$RequestAddPlate parseFrom(byte[] bArr, C2394s c2394s) {
        return (Car$RequestAddPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Car$RequestAddPlate parseFrom(InputStream inputStream) {
        return (Car$RequestAddPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Car$RequestAddPlate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Car$RequestAddPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Car$RequestAddPlate parseFrom(AbstractC2384h abstractC2384h) {
        return (Car$RequestAddPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Car$RequestAddPlate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Car$RequestAddPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

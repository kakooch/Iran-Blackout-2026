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
public final class Car$RequestEditPlate extends GeneratedMessageLite implements U64 {
    private static final Car$RequestEditPlate DEFAULT_INSTANCE;
    public static final int NEW_PLATE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private CarStruct$Plate newPlate_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Car$RequestEditPlate.DEFAULT_INSTANCE);
        }
    }

    static {
        Car$RequestEditPlate car$RequestEditPlate = new Car$RequestEditPlate();
        DEFAULT_INSTANCE = car$RequestEditPlate;
        GeneratedMessageLite.registerDefaultInstance(Car$RequestEditPlate.class, car$RequestEditPlate);
    }

    private Car$RequestEditPlate() {
    }

    private void clearNewPlate() {
        this.newPlate_ = null;
        this.bitField0_ &= -2;
    }

    public static Car$RequestEditPlate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeNewPlate(CarStruct$Plate carStruct$Plate) {
        carStruct$Plate.getClass();
        CarStruct$Plate carStruct$Plate2 = this.newPlate_;
        if (carStruct$Plate2 == null || carStruct$Plate2 == CarStruct$Plate.getDefaultInstance()) {
            this.newPlate_ = carStruct$Plate;
        } else {
            this.newPlate_ = (CarStruct$Plate) ((CarStruct$Plate.a) CarStruct$Plate.newBuilder(this.newPlate_).v(carStruct$Plate)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Car$RequestEditPlate parseDelimitedFrom(InputStream inputStream) {
        return (Car$RequestEditPlate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Car$RequestEditPlate parseFrom(ByteBuffer byteBuffer) {
        return (Car$RequestEditPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setNewPlate(CarStruct$Plate carStruct$Plate) {
        carStruct$Plate.getClass();
        this.newPlate_ = carStruct$Plate;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1905x.a[gVar.ordinal()]) {
            case 1:
                return new Car$RequestEditPlate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "newPlate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Car$RequestEditPlate.class) {
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

    public CarStruct$Plate getNewPlate() {
        CarStruct$Plate carStruct$Plate = this.newPlate_;
        return carStruct$Plate == null ? CarStruct$Plate.getDefaultInstance() : carStruct$Plate;
    }

    public boolean hasNewPlate() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Car$RequestEditPlate car$RequestEditPlate) {
        return (a) DEFAULT_INSTANCE.createBuilder(car$RequestEditPlate);
    }

    public static Car$RequestEditPlate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Car$RequestEditPlate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Car$RequestEditPlate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Car$RequestEditPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Car$RequestEditPlate parseFrom(AbstractC2383g abstractC2383g) {
        return (Car$RequestEditPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Car$RequestEditPlate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Car$RequestEditPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Car$RequestEditPlate parseFrom(byte[] bArr) {
        return (Car$RequestEditPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Car$RequestEditPlate parseFrom(byte[] bArr, C2394s c2394s) {
        return (Car$RequestEditPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Car$RequestEditPlate parseFrom(InputStream inputStream) {
        return (Car$RequestEditPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Car$RequestEditPlate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Car$RequestEditPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Car$RequestEditPlate parseFrom(AbstractC2384h abstractC2384h) {
        return (Car$RequestEditPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Car$RequestEditPlate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Car$RequestEditPlate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

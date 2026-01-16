package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KG0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class CarStruct$Plate extends GeneratedMessageLite implements KG0 {
    private static final CarStruct$Plate DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_DEFAULT_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PLATE_NUMBER_FIELD_NUMBER = 3;
    private boolean isDefault_;
    private String id_ = "";
    private String name_ = "";
    private String plateNumber_ = "";

    public static final class a extends GeneratedMessageLite.b implements KG0 {
        private a() {
            super(CarStruct$Plate.DEFAULT_INSTANCE);
        }
    }

    static {
        CarStruct$Plate carStruct$Plate = new CarStruct$Plate();
        DEFAULT_INSTANCE = carStruct$Plate;
        GeneratedMessageLite.registerDefaultInstance(CarStruct$Plate.class, carStruct$Plate);
    }

    private CarStruct$Plate() {
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearIsDefault() {
        this.isDefault_ = false;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearPlateNumber() {
        this.plateNumber_ = getDefaultInstance().getPlateNumber();
    }

    public static CarStruct$Plate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CarStruct$Plate parseDelimitedFrom(InputStream inputStream) {
        return (CarStruct$Plate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CarStruct$Plate parseFrom(ByteBuffer byteBuffer) {
        return (CarStruct$Plate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setIsDefault(boolean z) {
        this.isDefault_ = z;
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    private void setPlateNumber(String str) {
        str.getClass();
        this.plateNumber_ = str;
    }

    private void setPlateNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.plateNumber_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1908y.a[gVar.ordinal()]) {
            case 1:
                return new CarStruct$Plate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u0007", new Object[]{"id_", "name_", "plateNumber_", "isDefault_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CarStruct$Plate.class) {
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

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public boolean getIsDefault() {
        return this.isDefault_;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getPlateNumber() {
        return this.plateNumber_;
    }

    public AbstractC2383g getPlateNumberBytes() {
        return AbstractC2383g.N(this.plateNumber_);
    }

    public static a newBuilder(CarStruct$Plate carStruct$Plate) {
        return (a) DEFAULT_INSTANCE.createBuilder(carStruct$Plate);
    }

    public static CarStruct$Plate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CarStruct$Plate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CarStruct$Plate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CarStruct$Plate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CarStruct$Plate parseFrom(AbstractC2383g abstractC2383g) {
        return (CarStruct$Plate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CarStruct$Plate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CarStruct$Plate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CarStruct$Plate parseFrom(byte[] bArr) {
        return (CarStruct$Plate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CarStruct$Plate parseFrom(byte[] bArr, C2394s c2394s) {
        return (CarStruct$Plate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CarStruct$Plate parseFrom(InputStream inputStream) {
        return (CarStruct$Plate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CarStruct$Plate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CarStruct$Plate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CarStruct$Plate parseFrom(AbstractC2384h abstractC2384h) {
        return (CarStruct$Plate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CarStruct$Plate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CarStruct$Plate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

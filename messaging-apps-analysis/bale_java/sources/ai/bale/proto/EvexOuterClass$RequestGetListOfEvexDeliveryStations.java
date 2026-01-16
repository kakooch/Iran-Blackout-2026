package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC4422Fb2;
import ir.nasim.EnumC5373Jb2;
import ir.nasim.EnumC5607Kb2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class EvexOuterClass$RequestGetListOfEvexDeliveryStations extends GeneratedMessageLite implements U64 {
    public static final int BANK_TYPE_FIELD_NUMBER = 4;
    private static final EvexOuterClass$RequestGetListOfEvexDeliveryStations DEFAULT_INSTANCE;
    public static final int DELIVERY_STATION_TYPE_FIELD_NUMBER = 1;
    public static final int EXITDATE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 2;
    public static final int SHOULD_RETURN_CAPACITY_FIELD_NUMBER = 5;
    private int bankType_;
    private int bitField0_;
    private int deliveryStationType_;
    private String exitDate_ = "";
    private int reason_;
    private BoolValue shouldReturnCapacity_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(EvexOuterClass$RequestGetListOfEvexDeliveryStations.DEFAULT_INSTANCE);
        }
    }

    static {
        EvexOuterClass$RequestGetListOfEvexDeliveryStations evexOuterClass$RequestGetListOfEvexDeliveryStations = new EvexOuterClass$RequestGetListOfEvexDeliveryStations();
        DEFAULT_INSTANCE = evexOuterClass$RequestGetListOfEvexDeliveryStations;
        GeneratedMessageLite.registerDefaultInstance(EvexOuterClass$RequestGetListOfEvexDeliveryStations.class, evexOuterClass$RequestGetListOfEvexDeliveryStations);
    }

    private EvexOuterClass$RequestGetListOfEvexDeliveryStations() {
    }

    private void clearBankType() {
        this.bankType_ = 0;
    }

    private void clearDeliveryStationType() {
        this.deliveryStationType_ = 0;
    }

    private void clearExitDate() {
        this.exitDate_ = getDefaultInstance().getExitDate();
    }

    private void clearReason() {
        this.reason_ = 0;
    }

    private void clearShouldReturnCapacity() {
        this.shouldReturnCapacity_ = null;
        this.bitField0_ &= -2;
    }

    public static EvexOuterClass$RequestGetListOfEvexDeliveryStations getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeShouldReturnCapacity(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.shouldReturnCapacity_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.shouldReturnCapacity_ = boolValue;
        } else {
            this.shouldReturnCapacity_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.shouldReturnCapacity_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EvexOuterClass$RequestGetListOfEvexDeliveryStations parseDelimitedFrom(InputStream inputStream) {
        return (EvexOuterClass$RequestGetListOfEvexDeliveryStations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$RequestGetListOfEvexDeliveryStations parseFrom(ByteBuffer byteBuffer) {
        return (EvexOuterClass$RequestGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBankType(EnumC4422Fb2 enumC4422Fb2) {
        this.bankType_ = enumC4422Fb2.getNumber();
    }

    private void setBankTypeValue(int i) {
        this.bankType_ = i;
    }

    private void setDeliveryStationType(EnumC5373Jb2 enumC5373Jb2) {
        this.deliveryStationType_ = enumC5373Jb2.getNumber();
    }

    private void setDeliveryStationTypeValue(int i) {
        this.deliveryStationType_ = i;
    }

    private void setExitDate(String str) {
        str.getClass();
        this.exitDate_ = str;
    }

    private void setExitDateBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.exitDate_ = abstractC2383g.f0();
    }

    private void setReason(EnumC5607Kb2 enumC5607Kb2) {
        this.reason_ = enumC5607Kb2.getNumber();
    }

    private void setReasonValue(int i) {
        this.reason_ = i;
    }

    private void setShouldReturnCapacity(BoolValue boolValue) {
        boolValue.getClass();
        this.shouldReturnCapacity_ = boolValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S.a[gVar.ordinal()]) {
            case 1:
                return new EvexOuterClass$RequestGetListOfEvexDeliveryStations();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0002\f\u0003Ȉ\u0004\f\u0005ဉ\u0000", new Object[]{"bitField0_", "deliveryStationType_", "reason_", "exitDate_", "bankType_", "shouldReturnCapacity_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EvexOuterClass$RequestGetListOfEvexDeliveryStations.class) {
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

    public EnumC4422Fb2 getBankType() {
        EnumC4422Fb2 enumC4422Fb2J = EnumC4422Fb2.j(this.bankType_);
        return enumC4422Fb2J == null ? EnumC4422Fb2.UNRECOGNIZED : enumC4422Fb2J;
    }

    public int getBankTypeValue() {
        return this.bankType_;
    }

    public EnumC5373Jb2 getDeliveryStationType() {
        EnumC5373Jb2 enumC5373Jb2J = EnumC5373Jb2.j(this.deliveryStationType_);
        return enumC5373Jb2J == null ? EnumC5373Jb2.UNRECOGNIZED : enumC5373Jb2J;
    }

    public int getDeliveryStationTypeValue() {
        return this.deliveryStationType_;
    }

    public String getExitDate() {
        return this.exitDate_;
    }

    public AbstractC2383g getExitDateBytes() {
        return AbstractC2383g.N(this.exitDate_);
    }

    public EnumC5607Kb2 getReason() {
        EnumC5607Kb2 enumC5607Kb2J = EnumC5607Kb2.j(this.reason_);
        return enumC5607Kb2J == null ? EnumC5607Kb2.UNRECOGNIZED : enumC5607Kb2J;
    }

    public int getReasonValue() {
        return this.reason_;
    }

    public BoolValue getShouldReturnCapacity() {
        BoolValue boolValue = this.shouldReturnCapacity_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public boolean hasShouldReturnCapacity() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(EvexOuterClass$RequestGetListOfEvexDeliveryStations evexOuterClass$RequestGetListOfEvexDeliveryStations) {
        return (a) DEFAULT_INSTANCE.createBuilder(evexOuterClass$RequestGetListOfEvexDeliveryStations);
    }

    public static EvexOuterClass$RequestGetListOfEvexDeliveryStations parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$RequestGetListOfEvexDeliveryStations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$RequestGetListOfEvexDeliveryStations parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EvexOuterClass$RequestGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EvexOuterClass$RequestGetListOfEvexDeliveryStations parseFrom(AbstractC2383g abstractC2383g) {
        return (EvexOuterClass$RequestGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static EvexOuterClass$RequestGetListOfEvexDeliveryStations parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EvexOuterClass$RequestGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EvexOuterClass$RequestGetListOfEvexDeliveryStations parseFrom(byte[] bArr) {
        return (EvexOuterClass$RequestGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EvexOuterClass$RequestGetListOfEvexDeliveryStations parseFrom(byte[] bArr, C2394s c2394s) {
        return (EvexOuterClass$RequestGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EvexOuterClass$RequestGetListOfEvexDeliveryStations parseFrom(InputStream inputStream) {
        return (EvexOuterClass$RequestGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$RequestGetListOfEvexDeliveryStations parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$RequestGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$RequestGetListOfEvexDeliveryStations parseFrom(AbstractC2384h abstractC2384h) {
        return (EvexOuterClass$RequestGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EvexOuterClass$RequestGetListOfEvexDeliveryStations parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EvexOuterClass$RequestGetListOfEvexDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

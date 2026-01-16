package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC5850Lc2;
import ir.nasim.EnumC6816Pc2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ExchangeOuterClass$RequestGetListOfDeliveryStations extends GeneratedMessageLite implements U64 {
    private static final ExchangeOuterClass$RequestGetListOfDeliveryStations DEFAULT_INSTANCE;
    public static final int DELIVERY_STATION_TYPE_FIELD_NUMBER = 1;
    public static final int EXITDATE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 2;
    private int deliveryStationType_;
    private String exitDate_ = "";
    private int reason_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ExchangeOuterClass$RequestGetListOfDeliveryStations.DEFAULT_INSTANCE);
        }
    }

    static {
        ExchangeOuterClass$RequestGetListOfDeliveryStations exchangeOuterClass$RequestGetListOfDeliveryStations = new ExchangeOuterClass$RequestGetListOfDeliveryStations();
        DEFAULT_INSTANCE = exchangeOuterClass$RequestGetListOfDeliveryStations;
        GeneratedMessageLite.registerDefaultInstance(ExchangeOuterClass$RequestGetListOfDeliveryStations.class, exchangeOuterClass$RequestGetListOfDeliveryStations);
    }

    private ExchangeOuterClass$RequestGetListOfDeliveryStations() {
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

    public static ExchangeOuterClass$RequestGetListOfDeliveryStations getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ExchangeOuterClass$RequestGetListOfDeliveryStations parseDelimitedFrom(InputStream inputStream) {
        return (ExchangeOuterClass$RequestGetListOfDeliveryStations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$RequestGetListOfDeliveryStations parseFrom(ByteBuffer byteBuffer) {
        return (ExchangeOuterClass$RequestGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDeliveryStationType(EnumC5850Lc2 enumC5850Lc2) {
        this.deliveryStationType_ = enumC5850Lc2.getNumber();
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

    private void setReason(EnumC6816Pc2 enumC6816Pc2) {
        this.reason_ = enumC6816Pc2.getNumber();
    }

    private void setReasonValue(int i) {
        this.reason_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (U.a[gVar.ordinal()]) {
            case 1:
                return new ExchangeOuterClass$RequestGetListOfDeliveryStations();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003Ȉ", new Object[]{"deliveryStationType_", "reason_", "exitDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ExchangeOuterClass$RequestGetListOfDeliveryStations.class) {
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

    public EnumC5850Lc2 getDeliveryStationType() {
        EnumC5850Lc2 enumC5850Lc2J = EnumC5850Lc2.j(this.deliveryStationType_);
        return enumC5850Lc2J == null ? EnumC5850Lc2.UNRECOGNIZED : enumC5850Lc2J;
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

    public EnumC6816Pc2 getReason() {
        EnumC6816Pc2 enumC6816Pc2J = EnumC6816Pc2.j(this.reason_);
        return enumC6816Pc2J == null ? EnumC6816Pc2.UNRECOGNIZED : enumC6816Pc2J;
    }

    public int getReasonValue() {
        return this.reason_;
    }

    public static a newBuilder(ExchangeOuterClass$RequestGetListOfDeliveryStations exchangeOuterClass$RequestGetListOfDeliveryStations) {
        return (a) DEFAULT_INSTANCE.createBuilder(exchangeOuterClass$RequestGetListOfDeliveryStations);
    }

    public static ExchangeOuterClass$RequestGetListOfDeliveryStations parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetListOfDeliveryStations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$RequestGetListOfDeliveryStations parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ExchangeOuterClass$RequestGetListOfDeliveryStations parseFrom(AbstractC2383g abstractC2383g) {
        return (ExchangeOuterClass$RequestGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ExchangeOuterClass$RequestGetListOfDeliveryStations parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ExchangeOuterClass$RequestGetListOfDeliveryStations parseFrom(byte[] bArr) {
        return (ExchangeOuterClass$RequestGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ExchangeOuterClass$RequestGetListOfDeliveryStations parseFrom(byte[] bArr, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ExchangeOuterClass$RequestGetListOfDeliveryStations parseFrom(InputStream inputStream) {
        return (ExchangeOuterClass$RequestGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$RequestGetListOfDeliveryStations parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$RequestGetListOfDeliveryStations parseFrom(AbstractC2384h abstractC2384h) {
        return (ExchangeOuterClass$RequestGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ExchangeOuterClass$RequestGetListOfDeliveryStations parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetListOfDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

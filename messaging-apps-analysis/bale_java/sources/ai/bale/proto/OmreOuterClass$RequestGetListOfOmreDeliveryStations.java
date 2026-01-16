package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC18225oI4;
import ir.nasim.EnumC20607sI4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class OmreOuterClass$RequestGetListOfOmreDeliveryStations extends GeneratedMessageLite implements U64 {
    private static final OmreOuterClass$RequestGetListOfOmreDeliveryStations DEFAULT_INSTANCE;
    public static final int DELIVERY_STATION_TYPE_FIELD_NUMBER = 1;
    public static final int EXITDATE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 2;
    private int deliveryStationType_;
    private String exitDate_ = "";
    private int reason_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(OmreOuterClass$RequestGetListOfOmreDeliveryStations.DEFAULT_INSTANCE);
        }
    }

    static {
        OmreOuterClass$RequestGetListOfOmreDeliveryStations omreOuterClass$RequestGetListOfOmreDeliveryStations = new OmreOuterClass$RequestGetListOfOmreDeliveryStations();
        DEFAULT_INSTANCE = omreOuterClass$RequestGetListOfOmreDeliveryStations;
        GeneratedMessageLite.registerDefaultInstance(OmreOuterClass$RequestGetListOfOmreDeliveryStations.class, omreOuterClass$RequestGetListOfOmreDeliveryStations);
    }

    private OmreOuterClass$RequestGetListOfOmreDeliveryStations() {
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

    public static OmreOuterClass$RequestGetListOfOmreDeliveryStations getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static OmreOuterClass$RequestGetListOfOmreDeliveryStations parseDelimitedFrom(InputStream inputStream) {
        return (OmreOuterClass$RequestGetListOfOmreDeliveryStations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$RequestGetListOfOmreDeliveryStations parseFrom(ByteBuffer byteBuffer) {
        return (OmreOuterClass$RequestGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDeliveryStationType(EnumC18225oI4 enumC18225oI4) {
        this.deliveryStationType_ = enumC18225oI4.getNumber();
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

    private void setReason(EnumC20607sI4 enumC20607sI4) {
        this.reason_ = enumC20607sI4.getNumber();
    }

    private void setReasonValue(int i) {
        this.reason_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (U0.a[gVar.ordinal()]) {
            case 1:
                return new OmreOuterClass$RequestGetListOfOmreDeliveryStations();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003Ȉ", new Object[]{"deliveryStationType_", "reason_", "exitDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OmreOuterClass$RequestGetListOfOmreDeliveryStations.class) {
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

    public EnumC18225oI4 getDeliveryStationType() {
        EnumC18225oI4 enumC18225oI4J = EnumC18225oI4.j(this.deliveryStationType_);
        return enumC18225oI4J == null ? EnumC18225oI4.UNRECOGNIZED : enumC18225oI4J;
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

    public EnumC20607sI4 getReason() {
        EnumC20607sI4 enumC20607sI4J = EnumC20607sI4.j(this.reason_);
        return enumC20607sI4J == null ? EnumC20607sI4.UNRECOGNIZED : enumC20607sI4J;
    }

    public int getReasonValue() {
        return this.reason_;
    }

    public static a newBuilder(OmreOuterClass$RequestGetListOfOmreDeliveryStations omreOuterClass$RequestGetListOfOmreDeliveryStations) {
        return (a) DEFAULT_INSTANCE.createBuilder(omreOuterClass$RequestGetListOfOmreDeliveryStations);
    }

    public static OmreOuterClass$RequestGetListOfOmreDeliveryStations parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$RequestGetListOfOmreDeliveryStations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$RequestGetListOfOmreDeliveryStations parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OmreOuterClass$RequestGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OmreOuterClass$RequestGetListOfOmreDeliveryStations parseFrom(AbstractC2383g abstractC2383g) {
        return (OmreOuterClass$RequestGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static OmreOuterClass$RequestGetListOfOmreDeliveryStations parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OmreOuterClass$RequestGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OmreOuterClass$RequestGetListOfOmreDeliveryStations parseFrom(byte[] bArr) {
        return (OmreOuterClass$RequestGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OmreOuterClass$RequestGetListOfOmreDeliveryStations parseFrom(byte[] bArr, C2394s c2394s) {
        return (OmreOuterClass$RequestGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OmreOuterClass$RequestGetListOfOmreDeliveryStations parseFrom(InputStream inputStream) {
        return (OmreOuterClass$RequestGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$RequestGetListOfOmreDeliveryStations parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$RequestGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$RequestGetListOfOmreDeliveryStations parseFrom(AbstractC2384h abstractC2384h) {
        return (OmreOuterClass$RequestGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OmreOuterClass$RequestGetListOfOmreDeliveryStations parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OmreOuterClass$RequestGetListOfOmreDeliveryStations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

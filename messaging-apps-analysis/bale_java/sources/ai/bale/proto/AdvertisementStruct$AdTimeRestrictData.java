package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$AdTimeRestrictData extends GeneratedMessageLite implements U64 {
    private static final AdvertisementStruct$AdTimeRestrictData DEFAULT_INSTANCE;
    public static final int END_HOUR_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int SHOW_WITH_TIME_LIMIT_FIELD_NUMBER = 1;
    public static final int START_HOUR_FIELD_NUMBER = 2;
    private int bitField0_;
    private Int32Value endHour_;
    private boolean showWithTimeLimit_;
    private Int32Value startHour_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$AdTimeRestrictData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$AdTimeRestrictData advertisementStruct$AdTimeRestrictData = new AdvertisementStruct$AdTimeRestrictData();
        DEFAULT_INSTANCE = advertisementStruct$AdTimeRestrictData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$AdTimeRestrictData.class, advertisementStruct$AdTimeRestrictData);
    }

    private AdvertisementStruct$AdTimeRestrictData() {
    }

    private void clearEndHour() {
        this.endHour_ = null;
        this.bitField0_ &= -3;
    }

    private void clearShowWithTimeLimit() {
        this.showWithTimeLimit_ = false;
    }

    private void clearStartHour() {
        this.startHour_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementStruct$AdTimeRestrictData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeEndHour(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.endHour_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.endHour_ = int32Value;
        } else {
            this.endHour_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.endHour_).v(int32Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeStartHour(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.startHour_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.startHour_ = int32Value;
        } else {
            this.startHour_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.startHour_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$AdTimeRestrictData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$AdTimeRestrictData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AdTimeRestrictData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$AdTimeRestrictData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEndHour(Int32Value int32Value) {
        int32Value.getClass();
        this.endHour_ = int32Value;
        this.bitField0_ |= 2;
    }

    private void setShowWithTimeLimit(boolean z) {
        this.showWithTimeLimit_ = z;
    }

    private void setStartHour(Int32Value int32Value) {
        int32Value.getClass();
        this.startHour_ = int32Value;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$AdTimeRestrictData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0007\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"bitField0_", "showWithTimeLimit_", "startHour_", "endHour_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$AdTimeRestrictData.class) {
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

    public Int32Value getEndHour() {
        Int32Value int32Value = this.endHour_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public boolean getShowWithTimeLimit() {
        return this.showWithTimeLimit_;
    }

    public Int32Value getStartHour() {
        Int32Value int32Value = this.startHour_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public boolean hasEndHour() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasStartHour() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementStruct$AdTimeRestrictData advertisementStruct$AdTimeRestrictData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$AdTimeRestrictData);
    }

    public static AdvertisementStruct$AdTimeRestrictData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AdTimeRestrictData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AdTimeRestrictData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$AdTimeRestrictData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$AdTimeRestrictData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$AdTimeRestrictData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$AdTimeRestrictData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$AdTimeRestrictData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$AdTimeRestrictData parseFrom(byte[] bArr) {
        return (AdvertisementStruct$AdTimeRestrictData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$AdTimeRestrictData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$AdTimeRestrictData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$AdTimeRestrictData parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$AdTimeRestrictData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AdTimeRestrictData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AdTimeRestrictData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AdTimeRestrictData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$AdTimeRestrictData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$AdTimeRestrictData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$AdTimeRestrictData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

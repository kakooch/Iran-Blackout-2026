package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC7798Tg;
import ir.nasim.InterfaceC8268Vg;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AdvertisementStruct$CreditHistoryData extends GeneratedMessageLite implements InterfaceC8268Vg {
    public static final int AMOUNT_FIELD_NUMBER = 1;
    public static final int DATE_FIELD_NUMBER = 2;
    private static final AdvertisementStruct$CreditHistoryData DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 3;
    private long amount_;
    private long date_;
    private int reason_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC8268Vg {
        private a() {
            super(AdvertisementStruct$CreditHistoryData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$CreditHistoryData advertisementStruct$CreditHistoryData = new AdvertisementStruct$CreditHistoryData();
        DEFAULT_INSTANCE = advertisementStruct$CreditHistoryData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$CreditHistoryData.class, advertisementStruct$CreditHistoryData);
    }

    private AdvertisementStruct$CreditHistoryData() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearReason() {
        this.reason_ = 0;
    }

    public static AdvertisementStruct$CreditHistoryData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$CreditHistoryData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$CreditHistoryData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$CreditHistoryData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$CreditHistoryData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setReason(EnumC7798Tg enumC7798Tg) {
        this.reason_ = enumC7798Tg.getNumber();
    }

    private void setReasonValue(int i) {
        this.reason_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$CreditHistoryData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\f", new Object[]{"amount_", "date_", "reason_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$CreditHistoryData.class) {
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

    public long getAmount() {
        return this.amount_;
    }

    public long getDate() {
        return this.date_;
    }

    public EnumC7798Tg getReason() {
        EnumC7798Tg enumC7798TgJ = EnumC7798Tg.j(this.reason_);
        return enumC7798TgJ == null ? EnumC7798Tg.UNRECOGNIZED : enumC7798TgJ;
    }

    public int getReasonValue() {
        return this.reason_;
    }

    public static a newBuilder(AdvertisementStruct$CreditHistoryData advertisementStruct$CreditHistoryData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$CreditHistoryData);
    }

    public static AdvertisementStruct$CreditHistoryData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$CreditHistoryData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$CreditHistoryData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$CreditHistoryData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$CreditHistoryData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$CreditHistoryData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$CreditHistoryData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$CreditHistoryData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$CreditHistoryData parseFrom(byte[] bArr) {
        return (AdvertisementStruct$CreditHistoryData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$CreditHistoryData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$CreditHistoryData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$CreditHistoryData parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$CreditHistoryData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$CreditHistoryData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$CreditHistoryData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$CreditHistoryData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$CreditHistoryData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$CreditHistoryData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$CreditHistoryData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

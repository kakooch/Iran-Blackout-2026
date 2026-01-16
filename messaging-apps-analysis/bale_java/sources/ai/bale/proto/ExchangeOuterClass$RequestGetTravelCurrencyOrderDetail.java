package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail extends GeneratedMessageLite implements U64 {
    private static final ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail DEFAULT_INSTANCE;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NUMBER_FIELD_NUMBER = 1;
    public static final int USER_ID_FIELD_NUMBER = 3;
    private int searchByCase_ = 0;
    private Object searchBy_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        PHONE_NUMBER(1),
        NATIONAL_CODE(2),
        USER_ID(3),
        SEARCHBY_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return SEARCHBY_NOT_SET;
            }
            if (i == 1) {
                return PHONE_NUMBER;
            }
            if (i == 2) {
                return NATIONAL_CODE;
            }
            if (i != 3) {
                return null;
            }
            return USER_ID;
        }
    }

    static {
        ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail exchangeOuterClass$RequestGetTravelCurrencyOrderDetail = new ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail();
        DEFAULT_INSTANCE = exchangeOuterClass$RequestGetTravelCurrencyOrderDetail;
        GeneratedMessageLite.registerDefaultInstance(ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail.class, exchangeOuterClass$RequestGetTravelCurrencyOrderDetail);
    }

    private ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail() {
    }

    private void clearNationalCode() {
        if (this.searchByCase_ == 2) {
            this.searchByCase_ = 0;
            this.searchBy_ = null;
        }
    }

    private void clearPhoneNumber() {
        if (this.searchByCase_ == 1) {
            this.searchByCase_ = 0;
            this.searchBy_ = null;
        }
    }

    private void clearSearchBy() {
        this.searchByCase_ = 0;
        this.searchBy_ = null;
    }

    private void clearUserId() {
        if (this.searchByCase_ == 3) {
            this.searchByCase_ = 0;
            this.searchBy_ = null;
        }
    }

    public static ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail parseDelimitedFrom(InputStream inputStream) {
        return (ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail parseFrom(ByteBuffer byteBuffer) {
        return (ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setNationalCode(String str) {
        str.getClass();
        this.searchByCase_ = 2;
        this.searchBy_ = str;
    }

    private void setNationalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.searchBy_ = abstractC2383g.f0();
        this.searchByCase_ = 2;
    }

    private void setPhoneNumber(String str) {
        str.getClass();
        this.searchByCase_ = 1;
        this.searchBy_ = str;
    }

    private void setPhoneNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.searchBy_ = abstractC2383g.f0();
        this.searchByCase_ = 1;
    }

    private void setUserId(int i) {
        this.searchByCase_ = 3;
        this.searchBy_ = Integer.valueOf(i);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (U.a[gVar.ordinal()]) {
            case 1:
                return new ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȼ\u0000\u0002Ȼ\u0000\u00037\u0000", new Object[]{"searchBy_", "searchByCase_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail.class) {
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

    public String getNationalCode() {
        return this.searchByCase_ == 2 ? (String) this.searchBy_ : "";
    }

    public AbstractC2383g getNationalCodeBytes() {
        return AbstractC2383g.N(this.searchByCase_ == 2 ? (String) this.searchBy_ : "");
    }

    public String getPhoneNumber() {
        return this.searchByCase_ == 1 ? (String) this.searchBy_ : "";
    }

    public AbstractC2383g getPhoneNumberBytes() {
        return AbstractC2383g.N(this.searchByCase_ == 1 ? (String) this.searchBy_ : "");
    }

    public b getSearchByCase() {
        return b.j(this.searchByCase_);
    }

    public int getUserId() {
        if (this.searchByCase_ == 3) {
            return ((Integer) this.searchBy_).intValue();
        }
        return 0;
    }

    public boolean hasNationalCode() {
        return this.searchByCase_ == 2;
    }

    public boolean hasPhoneNumber() {
        return this.searchByCase_ == 1;
    }

    public boolean hasUserId() {
        return this.searchByCase_ == 3;
    }

    public static a newBuilder(ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail exchangeOuterClass$RequestGetTravelCurrencyOrderDetail) {
        return (a) DEFAULT_INSTANCE.createBuilder(exchangeOuterClass$RequestGetTravelCurrencyOrderDetail);
    }

    public static ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail parseFrom(AbstractC2383g abstractC2383g) {
        return (ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail parseFrom(byte[] bArr) {
        return (ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail parseFrom(byte[] bArr, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail parseFrom(InputStream inputStream) {
        return (ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail parseFrom(AbstractC2384h abstractC2384h) {
        return (ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

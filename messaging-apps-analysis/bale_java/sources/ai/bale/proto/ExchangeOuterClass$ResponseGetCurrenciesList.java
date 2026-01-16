package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC5616Kc2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class ExchangeOuterClass$ResponseGetCurrenciesList extends GeneratedMessageLite implements U64 {
    public static final int CURRENCIES_FIELD_NUMBER = 1;
    private static final ExchangeOuterClass$ResponseGetCurrenciesList DEFAULT_INSTANCE;
    public static final int ICMS_WAGE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private B.j currencies_ = GeneratedMessageLite.emptyProtobufList();
    private int icmsWage_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ExchangeOuterClass$ResponseGetCurrenciesList.DEFAULT_INSTANCE);
        }
    }

    static {
        ExchangeOuterClass$ResponseGetCurrenciesList exchangeOuterClass$ResponseGetCurrenciesList = new ExchangeOuterClass$ResponseGetCurrenciesList();
        DEFAULT_INSTANCE = exchangeOuterClass$ResponseGetCurrenciesList;
        GeneratedMessageLite.registerDefaultInstance(ExchangeOuterClass$ResponseGetCurrenciesList.class, exchangeOuterClass$ResponseGetCurrenciesList);
    }

    private ExchangeOuterClass$ResponseGetCurrenciesList() {
    }

    private void addAllCurrencies(Iterable<? extends ExchangeStruct$CurrencyInfo> iterable) {
        ensureCurrenciesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.currencies_);
    }

    private void addCurrencies(ExchangeStruct$CurrencyInfo exchangeStruct$CurrencyInfo) {
        exchangeStruct$CurrencyInfo.getClass();
        ensureCurrenciesIsMutable();
        this.currencies_.add(exchangeStruct$CurrencyInfo);
    }

    private void clearCurrencies() {
        this.currencies_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearIcmsWage() {
        this.icmsWage_ = 0;
    }

    private void ensureCurrenciesIsMutable() {
        B.j jVar = this.currencies_;
        if (jVar.u()) {
            return;
        }
        this.currencies_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ExchangeOuterClass$ResponseGetCurrenciesList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ExchangeOuterClass$ResponseGetCurrenciesList parseDelimitedFrom(InputStream inputStream) {
        return (ExchangeOuterClass$ResponseGetCurrenciesList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$ResponseGetCurrenciesList parseFrom(ByteBuffer byteBuffer) {
        return (ExchangeOuterClass$ResponseGetCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCurrencies(int i) {
        ensureCurrenciesIsMutable();
        this.currencies_.remove(i);
    }

    private void setCurrencies(int i, ExchangeStruct$CurrencyInfo exchangeStruct$CurrencyInfo) {
        exchangeStruct$CurrencyInfo.getClass();
        ensureCurrenciesIsMutable();
        this.currencies_.set(i, exchangeStruct$CurrencyInfo);
    }

    private void setIcmsWage(int i) {
        this.icmsWage_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (U.a[gVar.ordinal()]) {
            case 1:
                return new ExchangeOuterClass$ResponseGetCurrenciesList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0004", new Object[]{"currencies_", ExchangeStruct$CurrencyInfo.class, "icmsWage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ExchangeOuterClass$ResponseGetCurrenciesList.class) {
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

    public ExchangeStruct$CurrencyInfo getCurrencies(int i) {
        return (ExchangeStruct$CurrencyInfo) this.currencies_.get(i);
    }

    public int getCurrenciesCount() {
        return this.currencies_.size();
    }

    public List<ExchangeStruct$CurrencyInfo> getCurrenciesList() {
        return this.currencies_;
    }

    public InterfaceC5616Kc2 getCurrenciesOrBuilder(int i) {
        return (InterfaceC5616Kc2) this.currencies_.get(i);
    }

    public List<? extends InterfaceC5616Kc2> getCurrenciesOrBuilderList() {
        return this.currencies_;
    }

    public int getIcmsWage() {
        return this.icmsWage_;
    }

    public static a newBuilder(ExchangeOuterClass$ResponseGetCurrenciesList exchangeOuterClass$ResponseGetCurrenciesList) {
        return (a) DEFAULT_INSTANCE.createBuilder(exchangeOuterClass$ResponseGetCurrenciesList);
    }

    public static ExchangeOuterClass$ResponseGetCurrenciesList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetCurrenciesList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetCurrenciesList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetCurrenciesList parseFrom(AbstractC2383g abstractC2383g) {
        return (ExchangeOuterClass$ResponseGetCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCurrencies(int i, ExchangeStruct$CurrencyInfo exchangeStruct$CurrencyInfo) {
        exchangeStruct$CurrencyInfo.getClass();
        ensureCurrenciesIsMutable();
        this.currencies_.add(i, exchangeStruct$CurrencyInfo);
    }

    public static ExchangeOuterClass$ResponseGetCurrenciesList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetCurrenciesList parseFrom(byte[] bArr) {
        return (ExchangeOuterClass$ResponseGetCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ExchangeOuterClass$ResponseGetCurrenciesList parseFrom(byte[] bArr, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetCurrenciesList parseFrom(InputStream inputStream) {
        return (ExchangeOuterClass$ResponseGetCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$ResponseGetCurrenciesList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetCurrenciesList parseFrom(AbstractC2384h abstractC2384h) {
        return (ExchangeOuterClass$ResponseGetCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ExchangeOuterClass$ResponseGetCurrenciesList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

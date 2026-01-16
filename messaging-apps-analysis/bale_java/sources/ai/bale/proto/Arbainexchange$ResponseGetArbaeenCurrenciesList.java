package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC24245yI;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Arbainexchange$ResponseGetArbaeenCurrenciesList extends GeneratedMessageLite implements U64 {
    public static final int CURRENCIES_FIELD_NUMBER = 1;
    private static final Arbainexchange$ResponseGetArbaeenCurrenciesList DEFAULT_INSTANCE;
    public static final int ICMS_WAGE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private B.j currencies_ = GeneratedMessageLite.emptyProtobufList();
    private int icmsWage_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$ResponseGetArbaeenCurrenciesList.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$ResponseGetArbaeenCurrenciesList arbainexchange$ResponseGetArbaeenCurrenciesList = new Arbainexchange$ResponseGetArbaeenCurrenciesList();
        DEFAULT_INSTANCE = arbainexchange$ResponseGetArbaeenCurrenciesList;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$ResponseGetArbaeenCurrenciesList.class, arbainexchange$ResponseGetArbaeenCurrenciesList);
    }

    private Arbainexchange$ResponseGetArbaeenCurrenciesList() {
    }

    private void addAllCurrencies(Iterable<? extends ArbainexchangeStruct$ArbaeenCurrencyInfo> iterable) {
        ensureCurrenciesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.currencies_);
    }

    private void addCurrencies(ArbainexchangeStruct$ArbaeenCurrencyInfo arbainexchangeStruct$ArbaeenCurrencyInfo) {
        arbainexchangeStruct$ArbaeenCurrencyInfo.getClass();
        ensureCurrenciesIsMutable();
        this.currencies_.add(arbainexchangeStruct$ArbaeenCurrencyInfo);
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

    public static Arbainexchange$ResponseGetArbaeenCurrenciesList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$ResponseGetArbaeenCurrenciesList parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseGetArbaeenCurrenciesList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrenciesList parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$ResponseGetArbaeenCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCurrencies(int i) {
        ensureCurrenciesIsMutable();
        this.currencies_.remove(i);
    }

    private void setCurrencies(int i, ArbainexchangeStruct$ArbaeenCurrencyInfo arbainexchangeStruct$ArbaeenCurrencyInfo) {
        arbainexchangeStruct$ArbaeenCurrencyInfo.getClass();
        ensureCurrenciesIsMutable();
        this.currencies_.set(i, arbainexchangeStruct$ArbaeenCurrencyInfo);
    }

    private void setIcmsWage(int i) {
        this.icmsWage_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$ResponseGetArbaeenCurrenciesList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0004", new Object[]{"currencies_", ArbainexchangeStruct$ArbaeenCurrencyInfo.class, "icmsWage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$ResponseGetArbaeenCurrenciesList.class) {
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

    public ArbainexchangeStruct$ArbaeenCurrencyInfo getCurrencies(int i) {
        return (ArbainexchangeStruct$ArbaeenCurrencyInfo) this.currencies_.get(i);
    }

    public int getCurrenciesCount() {
        return this.currencies_.size();
    }

    public List<ArbainexchangeStruct$ArbaeenCurrencyInfo> getCurrenciesList() {
        return this.currencies_;
    }

    public InterfaceC24245yI getCurrenciesOrBuilder(int i) {
        return (InterfaceC24245yI) this.currencies_.get(i);
    }

    public List<? extends InterfaceC24245yI> getCurrenciesOrBuilderList() {
        return this.currencies_;
    }

    public int getIcmsWage() {
        return this.icmsWage_;
    }

    public static a newBuilder(Arbainexchange$ResponseGetArbaeenCurrenciesList arbainexchange$ResponseGetArbaeenCurrenciesList) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$ResponseGetArbaeenCurrenciesList);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrenciesList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseGetArbaeenCurrenciesList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrenciesList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$ResponseGetArbaeenCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrenciesList parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$ResponseGetArbaeenCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCurrencies(int i, ArbainexchangeStruct$ArbaeenCurrencyInfo arbainexchangeStruct$ArbaeenCurrencyInfo) {
        arbainexchangeStruct$ArbaeenCurrencyInfo.getClass();
        ensureCurrenciesIsMutable();
        this.currencies_.add(i, arbainexchangeStruct$ArbaeenCurrencyInfo);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrenciesList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$ResponseGetArbaeenCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrenciesList parseFrom(byte[] bArr) {
        return (Arbainexchange$ResponseGetArbaeenCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrenciesList parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$ResponseGetArbaeenCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrenciesList parseFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseGetArbaeenCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrenciesList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseGetArbaeenCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrenciesList parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$ResponseGetArbaeenCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrenciesList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$ResponseGetArbaeenCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

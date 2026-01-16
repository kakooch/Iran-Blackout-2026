package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC4905Hb2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class EvexOuterClass$ResponseGetEvexCurrenciesList extends GeneratedMessageLite implements U64 {
    public static final int CURRENCIES_FIELD_NUMBER = 1;
    private static final EvexOuterClass$ResponseGetEvexCurrenciesList DEFAULT_INSTANCE;
    public static final int ICMS_WAGE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private B.j currencies_ = GeneratedMessageLite.emptyProtobufList();
    private int icmsWage_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(EvexOuterClass$ResponseGetEvexCurrenciesList.DEFAULT_INSTANCE);
        }
    }

    static {
        EvexOuterClass$ResponseGetEvexCurrenciesList evexOuterClass$ResponseGetEvexCurrenciesList = new EvexOuterClass$ResponseGetEvexCurrenciesList();
        DEFAULT_INSTANCE = evexOuterClass$ResponseGetEvexCurrenciesList;
        GeneratedMessageLite.registerDefaultInstance(EvexOuterClass$ResponseGetEvexCurrenciesList.class, evexOuterClass$ResponseGetEvexCurrenciesList);
    }

    private EvexOuterClass$ResponseGetEvexCurrenciesList() {
    }

    private void addAllCurrencies(Iterable<? extends EvexStruct$EvexCurrencyInfo> iterable) {
        ensureCurrenciesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.currencies_);
    }

    private void addCurrencies(EvexStruct$EvexCurrencyInfo evexStruct$EvexCurrencyInfo) {
        evexStruct$EvexCurrencyInfo.getClass();
        ensureCurrenciesIsMutable();
        this.currencies_.add(evexStruct$EvexCurrencyInfo);
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

    public static EvexOuterClass$ResponseGetEvexCurrenciesList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EvexOuterClass$ResponseGetEvexCurrenciesList parseDelimitedFrom(InputStream inputStream) {
        return (EvexOuterClass$ResponseGetEvexCurrenciesList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$ResponseGetEvexCurrenciesList parseFrom(ByteBuffer byteBuffer) {
        return (EvexOuterClass$ResponseGetEvexCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCurrencies(int i) {
        ensureCurrenciesIsMutable();
        this.currencies_.remove(i);
    }

    private void setCurrencies(int i, EvexStruct$EvexCurrencyInfo evexStruct$EvexCurrencyInfo) {
        evexStruct$EvexCurrencyInfo.getClass();
        ensureCurrenciesIsMutable();
        this.currencies_.set(i, evexStruct$EvexCurrencyInfo);
    }

    private void setIcmsWage(int i) {
        this.icmsWage_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S.a[gVar.ordinal()]) {
            case 1:
                return new EvexOuterClass$ResponseGetEvexCurrenciesList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0004", new Object[]{"currencies_", EvexStruct$EvexCurrencyInfo.class, "icmsWage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EvexOuterClass$ResponseGetEvexCurrenciesList.class) {
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

    public EvexStruct$EvexCurrencyInfo getCurrencies(int i) {
        return (EvexStruct$EvexCurrencyInfo) this.currencies_.get(i);
    }

    public int getCurrenciesCount() {
        return this.currencies_.size();
    }

    public List<EvexStruct$EvexCurrencyInfo> getCurrenciesList() {
        return this.currencies_;
    }

    public InterfaceC4905Hb2 getCurrenciesOrBuilder(int i) {
        return (InterfaceC4905Hb2) this.currencies_.get(i);
    }

    public List<? extends InterfaceC4905Hb2> getCurrenciesOrBuilderList() {
        return this.currencies_;
    }

    public int getIcmsWage() {
        return this.icmsWage_;
    }

    public static a newBuilder(EvexOuterClass$ResponseGetEvexCurrenciesList evexOuterClass$ResponseGetEvexCurrenciesList) {
        return (a) DEFAULT_INSTANCE.createBuilder(evexOuterClass$ResponseGetEvexCurrenciesList);
    }

    public static EvexOuterClass$ResponseGetEvexCurrenciesList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetEvexCurrenciesList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$ResponseGetEvexCurrenciesList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetEvexCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EvexOuterClass$ResponseGetEvexCurrenciesList parseFrom(AbstractC2383g abstractC2383g) {
        return (EvexOuterClass$ResponseGetEvexCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCurrencies(int i, EvexStruct$EvexCurrencyInfo evexStruct$EvexCurrencyInfo) {
        evexStruct$EvexCurrencyInfo.getClass();
        ensureCurrenciesIsMutable();
        this.currencies_.add(i, evexStruct$EvexCurrencyInfo);
    }

    public static EvexOuterClass$ResponseGetEvexCurrenciesList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetEvexCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EvexOuterClass$ResponseGetEvexCurrenciesList parseFrom(byte[] bArr) {
        return (EvexOuterClass$ResponseGetEvexCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EvexOuterClass$ResponseGetEvexCurrenciesList parseFrom(byte[] bArr, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetEvexCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EvexOuterClass$ResponseGetEvexCurrenciesList parseFrom(InputStream inputStream) {
        return (EvexOuterClass$ResponseGetEvexCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$ResponseGetEvexCurrenciesList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetEvexCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$ResponseGetEvexCurrenciesList parseFrom(AbstractC2384h abstractC2384h) {
        return (EvexOuterClass$ResponseGetEvexCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EvexOuterClass$ResponseGetEvexCurrenciesList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetEvexCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC17043mI4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class OmreOuterClass$ResponseGetOmreCurrenciesList extends GeneratedMessageLite implements U64 {
    public static final int CURRENCIES_FIELD_NUMBER = 1;
    private static final OmreOuterClass$ResponseGetOmreCurrenciesList DEFAULT_INSTANCE;
    public static final int ICMS_WAGE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private B.j currencies_ = GeneratedMessageLite.emptyProtobufList();
    private int icmsWage_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(OmreOuterClass$ResponseGetOmreCurrenciesList.DEFAULT_INSTANCE);
        }
    }

    static {
        OmreOuterClass$ResponseGetOmreCurrenciesList omreOuterClass$ResponseGetOmreCurrenciesList = new OmreOuterClass$ResponseGetOmreCurrenciesList();
        DEFAULT_INSTANCE = omreOuterClass$ResponseGetOmreCurrenciesList;
        GeneratedMessageLite.registerDefaultInstance(OmreOuterClass$ResponseGetOmreCurrenciesList.class, omreOuterClass$ResponseGetOmreCurrenciesList);
    }

    private OmreOuterClass$ResponseGetOmreCurrenciesList() {
    }

    private void addAllCurrencies(Iterable<? extends OmreStruct$OmreCurrencyInfo> iterable) {
        ensureCurrenciesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.currencies_);
    }

    private void addCurrencies(OmreStruct$OmreCurrencyInfo omreStruct$OmreCurrencyInfo) {
        omreStruct$OmreCurrencyInfo.getClass();
        ensureCurrenciesIsMutable();
        this.currencies_.add(omreStruct$OmreCurrencyInfo);
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

    public static OmreOuterClass$ResponseGetOmreCurrenciesList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static OmreOuterClass$ResponseGetOmreCurrenciesList parseDelimitedFrom(InputStream inputStream) {
        return (OmreOuterClass$ResponseGetOmreCurrenciesList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$ResponseGetOmreCurrenciesList parseFrom(ByteBuffer byteBuffer) {
        return (OmreOuterClass$ResponseGetOmreCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCurrencies(int i) {
        ensureCurrenciesIsMutable();
        this.currencies_.remove(i);
    }

    private void setCurrencies(int i, OmreStruct$OmreCurrencyInfo omreStruct$OmreCurrencyInfo) {
        omreStruct$OmreCurrencyInfo.getClass();
        ensureCurrenciesIsMutable();
        this.currencies_.set(i, omreStruct$OmreCurrencyInfo);
    }

    private void setIcmsWage(int i) {
        this.icmsWage_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (U0.a[gVar.ordinal()]) {
            case 1:
                return new OmreOuterClass$ResponseGetOmreCurrenciesList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0004", new Object[]{"currencies_", OmreStruct$OmreCurrencyInfo.class, "icmsWage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OmreOuterClass$ResponseGetOmreCurrenciesList.class) {
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

    public OmreStruct$OmreCurrencyInfo getCurrencies(int i) {
        return (OmreStruct$OmreCurrencyInfo) this.currencies_.get(i);
    }

    public int getCurrenciesCount() {
        return this.currencies_.size();
    }

    public List<OmreStruct$OmreCurrencyInfo> getCurrenciesList() {
        return this.currencies_;
    }

    public InterfaceC17043mI4 getCurrenciesOrBuilder(int i) {
        return (InterfaceC17043mI4) this.currencies_.get(i);
    }

    public List<? extends InterfaceC17043mI4> getCurrenciesOrBuilderList() {
        return this.currencies_;
    }

    public int getIcmsWage() {
        return this.icmsWage_;
    }

    public static a newBuilder(OmreOuterClass$ResponseGetOmreCurrenciesList omreOuterClass$ResponseGetOmreCurrenciesList) {
        return (a) DEFAULT_INSTANCE.createBuilder(omreOuterClass$ResponseGetOmreCurrenciesList);
    }

    public static OmreOuterClass$ResponseGetOmreCurrenciesList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetOmreCurrenciesList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$ResponseGetOmreCurrenciesList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetOmreCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OmreOuterClass$ResponseGetOmreCurrenciesList parseFrom(AbstractC2383g abstractC2383g) {
        return (OmreOuterClass$ResponseGetOmreCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCurrencies(int i, OmreStruct$OmreCurrencyInfo omreStruct$OmreCurrencyInfo) {
        omreStruct$OmreCurrencyInfo.getClass();
        ensureCurrenciesIsMutable();
        this.currencies_.add(i, omreStruct$OmreCurrencyInfo);
    }

    public static OmreOuterClass$ResponseGetOmreCurrenciesList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetOmreCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OmreOuterClass$ResponseGetOmreCurrenciesList parseFrom(byte[] bArr) {
        return (OmreOuterClass$ResponseGetOmreCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OmreOuterClass$ResponseGetOmreCurrenciesList parseFrom(byte[] bArr, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetOmreCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OmreOuterClass$ResponseGetOmreCurrenciesList parseFrom(InputStream inputStream) {
        return (OmreOuterClass$ResponseGetOmreCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$ResponseGetOmreCurrenciesList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetOmreCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$ResponseGetOmreCurrenciesList parseFrom(AbstractC2384h abstractC2384h) {
        return (OmreOuterClass$ResponseGetOmreCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OmreOuterClass$ResponseGetOmreCurrenciesList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetOmreCurrenciesList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC17634nI4;
import ir.nasim.InterfaceC17043mI4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class OmreStruct$OmreCurrencyInfo extends GeneratedMessageLite implements InterfaceC17043mI4 {
    public static final int AVAILABLE_AMOUNTS_FIELD_NUMBER = 3;
    public static final int CURRENCY_TYPE_FIELD_NUMBER = 1;
    private static final OmreStruct$OmreCurrencyInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int availableAmountsMemoizedSerializedSize = -1;
    private B.g availableAmounts_ = GeneratedMessageLite.emptyIntList();
    private int currencyType_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC17043mI4 {
        private a() {
            super(OmreStruct$OmreCurrencyInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        OmreStruct$OmreCurrencyInfo omreStruct$OmreCurrencyInfo = new OmreStruct$OmreCurrencyInfo();
        DEFAULT_INSTANCE = omreStruct$OmreCurrencyInfo;
        GeneratedMessageLite.registerDefaultInstance(OmreStruct$OmreCurrencyInfo.class, omreStruct$OmreCurrencyInfo);
    }

    private OmreStruct$OmreCurrencyInfo() {
    }

    private void addAllAvailableAmounts(Iterable<? extends Integer> iterable) {
        ensureAvailableAmountsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.availableAmounts_);
    }

    private void addAvailableAmounts(int i) {
        ensureAvailableAmountsIsMutable();
        this.availableAmounts_.b1(i);
    }

    private void clearAvailableAmounts() {
        this.availableAmounts_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearCurrencyType() {
        this.currencyType_ = 0;
    }

    private void ensureAvailableAmountsIsMutable() {
        B.g gVar = this.availableAmounts_;
        if (gVar.u()) {
            return;
        }
        this.availableAmounts_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static OmreStruct$OmreCurrencyInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static OmreStruct$OmreCurrencyInfo parseDelimitedFrom(InputStream inputStream) {
        return (OmreStruct$OmreCurrencyInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreStruct$OmreCurrencyInfo parseFrom(ByteBuffer byteBuffer) {
        return (OmreStruct$OmreCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAvailableAmounts(int i, int i2) {
        ensureAvailableAmountsIsMutable();
        this.availableAmounts_.U(i, i2);
    }

    private void setCurrencyType(EnumC17634nI4 enumC17634nI4) {
        this.currencyType_ = enumC17634nI4.getNumber();
    }

    private void setCurrencyTypeValue(int i) {
        this.currencyType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (V0.a[gVar.ordinal()]) {
            case 1:
                return new OmreStruct$OmreCurrencyInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0001\u0000\u0001\f\u0003'", new Object[]{"currencyType_", "availableAmounts_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OmreStruct$OmreCurrencyInfo.class) {
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

    public int getAvailableAmounts(int i) {
        return this.availableAmounts_.getInt(i);
    }

    public int getAvailableAmountsCount() {
        return this.availableAmounts_.size();
    }

    public List<Integer> getAvailableAmountsList() {
        return this.availableAmounts_;
    }

    public EnumC17634nI4 getCurrencyType() {
        EnumC17634nI4 enumC17634nI4J = EnumC17634nI4.j(this.currencyType_);
        return enumC17634nI4J == null ? EnumC17634nI4.UNRECOGNIZED : enumC17634nI4J;
    }

    public int getCurrencyTypeValue() {
        return this.currencyType_;
    }

    public static a newBuilder(OmreStruct$OmreCurrencyInfo omreStruct$OmreCurrencyInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(omreStruct$OmreCurrencyInfo);
    }

    public static OmreStruct$OmreCurrencyInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreStruct$OmreCurrencyInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreStruct$OmreCurrencyInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OmreStruct$OmreCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OmreStruct$OmreCurrencyInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (OmreStruct$OmreCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static OmreStruct$OmreCurrencyInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OmreStruct$OmreCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OmreStruct$OmreCurrencyInfo parseFrom(byte[] bArr) {
        return (OmreStruct$OmreCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OmreStruct$OmreCurrencyInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (OmreStruct$OmreCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OmreStruct$OmreCurrencyInfo parseFrom(InputStream inputStream) {
        return (OmreStruct$OmreCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreStruct$OmreCurrencyInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreStruct$OmreCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreStruct$OmreCurrencyInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (OmreStruct$OmreCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OmreStruct$OmreCurrencyInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OmreStruct$OmreCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

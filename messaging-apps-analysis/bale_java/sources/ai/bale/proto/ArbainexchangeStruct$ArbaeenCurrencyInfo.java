package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC24839zI;
import ir.nasim.InterfaceC24245yI;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class ArbainexchangeStruct$ArbaeenCurrencyInfo extends GeneratedMessageLite implements InterfaceC24245yI {
    public static final int AVAILABLE_AMOUNTS_FIELD_NUMBER = 3;
    public static final int CURRENCY_TYPE_FIELD_NUMBER = 1;
    private static final ArbainexchangeStruct$ArbaeenCurrencyInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int availableAmountsMemoizedSerializedSize = -1;
    private B.g availableAmounts_ = GeneratedMessageLite.emptyIntList();
    private int currencyType_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC24245yI {
        private a() {
            super(ArbainexchangeStruct$ArbaeenCurrencyInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        ArbainexchangeStruct$ArbaeenCurrencyInfo arbainexchangeStruct$ArbaeenCurrencyInfo = new ArbainexchangeStruct$ArbaeenCurrencyInfo();
        DEFAULT_INSTANCE = arbainexchangeStruct$ArbaeenCurrencyInfo;
        GeneratedMessageLite.registerDefaultInstance(ArbainexchangeStruct$ArbaeenCurrencyInfo.class, arbainexchangeStruct$ArbaeenCurrencyInfo);
    }

    private ArbainexchangeStruct$ArbaeenCurrencyInfo() {
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

    public static ArbainexchangeStruct$ArbaeenCurrencyInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ArbainexchangeStruct$ArbaeenCurrencyInfo parseDelimitedFrom(InputStream inputStream) {
        return (ArbainexchangeStruct$ArbaeenCurrencyInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ArbainexchangeStruct$ArbaeenCurrencyInfo parseFrom(ByteBuffer byteBuffer) {
        return (ArbainexchangeStruct$ArbaeenCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAvailableAmounts(int i, int i2) {
        ensureAvailableAmountsIsMutable();
        this.availableAmounts_.U(i, i2);
    }

    private void setCurrencyType(EnumC24839zI enumC24839zI) {
        this.currencyType_ = enumC24839zI.getNumber();
    }

    private void setCurrencyTypeValue(int i) {
        this.currencyType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1864j.a[gVar.ordinal()]) {
            case 1:
                return new ArbainexchangeStruct$ArbaeenCurrencyInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0001\u0000\u0001\f\u0003'", new Object[]{"currencyType_", "availableAmounts_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ArbainexchangeStruct$ArbaeenCurrencyInfo.class) {
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

    public EnumC24839zI getCurrencyType() {
        EnumC24839zI enumC24839zIJ = EnumC24839zI.j(this.currencyType_);
        return enumC24839zIJ == null ? EnumC24839zI.UNRECOGNIZED : enumC24839zIJ;
    }

    public int getCurrencyTypeValue() {
        return this.currencyType_;
    }

    public static a newBuilder(ArbainexchangeStruct$ArbaeenCurrencyInfo arbainexchangeStruct$ArbaeenCurrencyInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchangeStruct$ArbaeenCurrencyInfo);
    }

    public static ArbainexchangeStruct$ArbaeenCurrencyInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenCurrencyInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenCurrencyInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenCurrencyInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (ArbainexchangeStruct$ArbaeenCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ArbainexchangeStruct$ArbaeenCurrencyInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenCurrencyInfo parseFrom(byte[] bArr) {
        return (ArbainexchangeStruct$ArbaeenCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ArbainexchangeStruct$ArbaeenCurrencyInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenCurrencyInfo parseFrom(InputStream inputStream) {
        return (ArbainexchangeStruct$ArbaeenCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ArbainexchangeStruct$ArbaeenCurrencyInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenCurrencyInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (ArbainexchangeStruct$ArbaeenCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ArbainexchangeStruct$ArbaeenCurrencyInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

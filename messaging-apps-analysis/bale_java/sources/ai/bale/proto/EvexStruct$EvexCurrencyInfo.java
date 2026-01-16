package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC5139Ib2;
import ir.nasim.InterfaceC4905Hb2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class EvexStruct$EvexCurrencyInfo extends GeneratedMessageLite implements InterfaceC4905Hb2 {
    public static final int AVAILABLE_AMOUNTS_FIELD_NUMBER = 3;
    public static final int CURRENCY_TYPE_FIELD_NUMBER = 1;
    private static final EvexStruct$EvexCurrencyInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int availableAmountsMemoizedSerializedSize = -1;
    private B.g availableAmounts_ = GeneratedMessageLite.emptyIntList();
    private int currencyType_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC4905Hb2 {
        private a() {
            super(EvexStruct$EvexCurrencyInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        EvexStruct$EvexCurrencyInfo evexStruct$EvexCurrencyInfo = new EvexStruct$EvexCurrencyInfo();
        DEFAULT_INSTANCE = evexStruct$EvexCurrencyInfo;
        GeneratedMessageLite.registerDefaultInstance(EvexStruct$EvexCurrencyInfo.class, evexStruct$EvexCurrencyInfo);
    }

    private EvexStruct$EvexCurrencyInfo() {
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

    public static EvexStruct$EvexCurrencyInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EvexStruct$EvexCurrencyInfo parseDelimitedFrom(InputStream inputStream) {
        return (EvexStruct$EvexCurrencyInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexStruct$EvexCurrencyInfo parseFrom(ByteBuffer byteBuffer) {
        return (EvexStruct$EvexCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAvailableAmounts(int i, int i2) {
        ensureAvailableAmountsIsMutable();
        this.availableAmounts_.U(i, i2);
    }

    private void setCurrencyType(EnumC5139Ib2 enumC5139Ib2) {
        this.currencyType_ = enumC5139Ib2.getNumber();
    }

    private void setCurrencyTypeValue(int i) {
        this.currencyType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (T.a[gVar.ordinal()]) {
            case 1:
                return new EvexStruct$EvexCurrencyInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0001\u0000\u0001\f\u0003'", new Object[]{"currencyType_", "availableAmounts_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EvexStruct$EvexCurrencyInfo.class) {
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

    public EnumC5139Ib2 getCurrencyType() {
        EnumC5139Ib2 enumC5139Ib2J = EnumC5139Ib2.j(this.currencyType_);
        return enumC5139Ib2J == null ? EnumC5139Ib2.UNRECOGNIZED : enumC5139Ib2J;
    }

    public int getCurrencyTypeValue() {
        return this.currencyType_;
    }

    public static a newBuilder(EvexStruct$EvexCurrencyInfo evexStruct$EvexCurrencyInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(evexStruct$EvexCurrencyInfo);
    }

    public static EvexStruct$EvexCurrencyInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexStruct$EvexCurrencyInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexStruct$EvexCurrencyInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EvexStruct$EvexCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EvexStruct$EvexCurrencyInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (EvexStruct$EvexCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static EvexStruct$EvexCurrencyInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EvexStruct$EvexCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EvexStruct$EvexCurrencyInfo parseFrom(byte[] bArr) {
        return (EvexStruct$EvexCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EvexStruct$EvexCurrencyInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (EvexStruct$EvexCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EvexStruct$EvexCurrencyInfo parseFrom(InputStream inputStream) {
        return (EvexStruct$EvexCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexStruct$EvexCurrencyInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexStruct$EvexCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexStruct$EvexCurrencyInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (EvexStruct$EvexCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EvexStruct$EvexCurrencyInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EvexStruct$EvexCurrencyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

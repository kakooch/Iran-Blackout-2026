package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.EnumC23065wI;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ArbainexchangeStruct$ArbaeenBankApprovalText extends GeneratedMessageLite implements U64 {
    public static final int BANK_TYPE_FIELD_NUMBER = 2;
    private static final ArbainexchangeStruct$ArbaeenBankApprovalText DEFAULT_INSTANCE;
    public static final int MAXIMUMDAYS_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 1;
    private int bankType_;
    private int bitField0_;
    private Int32Value maximumDays_;
    private String text_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ArbainexchangeStruct$ArbaeenBankApprovalText.DEFAULT_INSTANCE);
        }
    }

    static {
        ArbainexchangeStruct$ArbaeenBankApprovalText arbainexchangeStruct$ArbaeenBankApprovalText = new ArbainexchangeStruct$ArbaeenBankApprovalText();
        DEFAULT_INSTANCE = arbainexchangeStruct$ArbaeenBankApprovalText;
        GeneratedMessageLite.registerDefaultInstance(ArbainexchangeStruct$ArbaeenBankApprovalText.class, arbainexchangeStruct$ArbaeenBankApprovalText);
    }

    private ArbainexchangeStruct$ArbaeenBankApprovalText() {
    }

    private void clearBankType() {
        this.bankType_ = 0;
    }

    private void clearMaximumDays() {
        this.maximumDays_ = null;
        this.bitField0_ &= -2;
    }

    private void clearText() {
        this.text_ = getDefaultInstance().getText();
    }

    public static ArbainexchangeStruct$ArbaeenBankApprovalText getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMaximumDays(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.maximumDays_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.maximumDays_ = int32Value;
        } else {
            this.maximumDays_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.maximumDays_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ArbainexchangeStruct$ArbaeenBankApprovalText parseDelimitedFrom(InputStream inputStream) {
        return (ArbainexchangeStruct$ArbaeenBankApprovalText) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ArbainexchangeStruct$ArbaeenBankApprovalText parseFrom(ByteBuffer byteBuffer) {
        return (ArbainexchangeStruct$ArbaeenBankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBankType(EnumC23065wI enumC23065wI) {
        this.bankType_ = enumC23065wI.getNumber();
    }

    private void setBankTypeValue(int i) {
        this.bankType_ = i;
    }

    private void setMaximumDays(Int32Value int32Value) {
        int32Value.getClass();
        this.maximumDays_ = int32Value;
        this.bitField0_ |= 1;
    }

    private void setText(String str) {
        str.getClass();
        this.text_ = str;
    }

    private void setTextBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.text_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1864j.a[gVar.ordinal()]) {
            case 1:
                return new ArbainexchangeStruct$ArbaeenBankApprovalText();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003ဉ\u0000", new Object[]{"bitField0_", "text_", "bankType_", "maximumDays_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ArbainexchangeStruct$ArbaeenBankApprovalText.class) {
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

    public EnumC23065wI getBankType() {
        EnumC23065wI enumC23065wIJ = EnumC23065wI.j(this.bankType_);
        return enumC23065wIJ == null ? EnumC23065wI.UNRECOGNIZED : enumC23065wIJ;
    }

    public int getBankTypeValue() {
        return this.bankType_;
    }

    public Int32Value getMaximumDays() {
        Int32Value int32Value = this.maximumDays_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public String getText() {
        return this.text_;
    }

    public AbstractC2383g getTextBytes() {
        return AbstractC2383g.N(this.text_);
    }

    public boolean hasMaximumDays() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ArbainexchangeStruct$ArbaeenBankApprovalText arbainexchangeStruct$ArbaeenBankApprovalText) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchangeStruct$ArbaeenBankApprovalText);
    }

    public static ArbainexchangeStruct$ArbaeenBankApprovalText parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenBankApprovalText) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenBankApprovalText parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenBankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenBankApprovalText parseFrom(AbstractC2383g abstractC2383g) {
        return (ArbainexchangeStruct$ArbaeenBankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ArbainexchangeStruct$ArbaeenBankApprovalText parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenBankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenBankApprovalText parseFrom(byte[] bArr) {
        return (ArbainexchangeStruct$ArbaeenBankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ArbainexchangeStruct$ArbaeenBankApprovalText parseFrom(byte[] bArr, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenBankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenBankApprovalText parseFrom(InputStream inputStream) {
        return (ArbainexchangeStruct$ArbaeenBankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ArbainexchangeStruct$ArbaeenBankApprovalText parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenBankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenBankApprovalText parseFrom(AbstractC2384h abstractC2384h) {
        return (ArbainexchangeStruct$ArbaeenBankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ArbainexchangeStruct$ArbaeenBankApprovalText parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenBankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

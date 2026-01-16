package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC4422Fb2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class EvexStruct$BankApprovalText extends GeneratedMessageLite implements U64 {
    public static final int BANK_TYPE_FIELD_NUMBER = 2;
    private static final EvexStruct$BankApprovalText DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 1;
    private int bankType_;
    private String text_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(EvexStruct$BankApprovalText.DEFAULT_INSTANCE);
        }
    }

    static {
        EvexStruct$BankApprovalText evexStruct$BankApprovalText = new EvexStruct$BankApprovalText();
        DEFAULT_INSTANCE = evexStruct$BankApprovalText;
        GeneratedMessageLite.registerDefaultInstance(EvexStruct$BankApprovalText.class, evexStruct$BankApprovalText);
    }

    private EvexStruct$BankApprovalText() {
    }

    private void clearBankType() {
        this.bankType_ = 0;
    }

    private void clearText() {
        this.text_ = getDefaultInstance().getText();
    }

    public static EvexStruct$BankApprovalText getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EvexStruct$BankApprovalText parseDelimitedFrom(InputStream inputStream) {
        return (EvexStruct$BankApprovalText) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexStruct$BankApprovalText parseFrom(ByteBuffer byteBuffer) {
        return (EvexStruct$BankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBankType(EnumC4422Fb2 enumC4422Fb2) {
        this.bankType_ = enumC4422Fb2.getNumber();
    }

    private void setBankTypeValue(int i) {
        this.bankType_ = i;
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
        switch (T.a[gVar.ordinal()]) {
            case 1:
                return new EvexStruct$BankApprovalText();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\f", new Object[]{"text_", "bankType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EvexStruct$BankApprovalText.class) {
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

    public EnumC4422Fb2 getBankType() {
        EnumC4422Fb2 enumC4422Fb2J = EnumC4422Fb2.j(this.bankType_);
        return enumC4422Fb2J == null ? EnumC4422Fb2.UNRECOGNIZED : enumC4422Fb2J;
    }

    public int getBankTypeValue() {
        return this.bankType_;
    }

    public String getText() {
        return this.text_;
    }

    public AbstractC2383g getTextBytes() {
        return AbstractC2383g.N(this.text_);
    }

    public static a newBuilder(EvexStruct$BankApprovalText evexStruct$BankApprovalText) {
        return (a) DEFAULT_INSTANCE.createBuilder(evexStruct$BankApprovalText);
    }

    public static EvexStruct$BankApprovalText parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexStruct$BankApprovalText) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexStruct$BankApprovalText parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EvexStruct$BankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EvexStruct$BankApprovalText parseFrom(AbstractC2383g abstractC2383g) {
        return (EvexStruct$BankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static EvexStruct$BankApprovalText parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EvexStruct$BankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EvexStruct$BankApprovalText parseFrom(byte[] bArr) {
        return (EvexStruct$BankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EvexStruct$BankApprovalText parseFrom(byte[] bArr, C2394s c2394s) {
        return (EvexStruct$BankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EvexStruct$BankApprovalText parseFrom(InputStream inputStream) {
        return (EvexStruct$BankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexStruct$BankApprovalText parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexStruct$BankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexStruct$BankApprovalText parseFrom(AbstractC2384h abstractC2384h) {
        return (EvexStruct$BankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EvexStruct$BankApprovalText parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EvexStruct$BankApprovalText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC10765c96;
import ir.nasim.EnumC11529d96;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Saba$RequestGetChargeAmounts extends GeneratedMessageLite implements U64 {
    public static final int CHARGE_TYPE_FIELD_NUMBER = 2;
    private static final Saba$RequestGetChargeAmounts DEFAULT_INSTANCE;
    public static final int OPERATOR_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int chargeType_;
    private int operator_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Saba$RequestGetChargeAmounts.DEFAULT_INSTANCE);
        }
    }

    static {
        Saba$RequestGetChargeAmounts saba$RequestGetChargeAmounts = new Saba$RequestGetChargeAmounts();
        DEFAULT_INSTANCE = saba$RequestGetChargeAmounts;
        GeneratedMessageLite.registerDefaultInstance(Saba$RequestGetChargeAmounts.class, saba$RequestGetChargeAmounts);
    }

    private Saba$RequestGetChargeAmounts() {
    }

    private void clearChargeType() {
        this.chargeType_ = 0;
    }

    private void clearOperator() {
        this.operator_ = 0;
    }

    public static Saba$RequestGetChargeAmounts getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Saba$RequestGetChargeAmounts parseDelimitedFrom(InputStream inputStream) {
        return (Saba$RequestGetChargeAmounts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Saba$RequestGetChargeAmounts parseFrom(ByteBuffer byteBuffer) {
        return (Saba$RequestGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setChargeType(EnumC10765c96 enumC10765c96) {
        this.chargeType_ = enumC10765c96.getNumber();
    }

    private void setChargeTypeValue(int i) {
        this.chargeType_ = i;
    }

    private void setOperator(EnumC11529d96 enumC11529d96) {
        this.operator_ = enumC11529d96.getNumber();
    }

    private void setOperatorValue(int i) {
        this.operator_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B1.a[gVar.ordinal()]) {
            case 1:
                return new Saba$RequestGetChargeAmounts();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\f", new Object[]{"operator_", "chargeType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Saba$RequestGetChargeAmounts.class) {
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

    public EnumC10765c96 getChargeType() {
        EnumC10765c96 enumC10765c96J = EnumC10765c96.j(this.chargeType_);
        return enumC10765c96J == null ? EnumC10765c96.UNRECOGNIZED : enumC10765c96J;
    }

    public int getChargeTypeValue() {
        return this.chargeType_;
    }

    public EnumC11529d96 getOperator() {
        EnumC11529d96 enumC11529d96J = EnumC11529d96.j(this.operator_);
        return enumC11529d96J == null ? EnumC11529d96.UNRECOGNIZED : enumC11529d96J;
    }

    public int getOperatorValue() {
        return this.operator_;
    }

    public static a newBuilder(Saba$RequestGetChargeAmounts saba$RequestGetChargeAmounts) {
        return (a) DEFAULT_INSTANCE.createBuilder(saba$RequestGetChargeAmounts);
    }

    public static Saba$RequestGetChargeAmounts parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Saba$RequestGetChargeAmounts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Saba$RequestGetChargeAmounts parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Saba$RequestGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Saba$RequestGetChargeAmounts parseFrom(AbstractC2383g abstractC2383g) {
        return (Saba$RequestGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Saba$RequestGetChargeAmounts parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Saba$RequestGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Saba$RequestGetChargeAmounts parseFrom(byte[] bArr) {
        return (Saba$RequestGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Saba$RequestGetChargeAmounts parseFrom(byte[] bArr, C2394s c2394s) {
        return (Saba$RequestGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Saba$RequestGetChargeAmounts parseFrom(InputStream inputStream) {
        return (Saba$RequestGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Saba$RequestGetChargeAmounts parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Saba$RequestGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Saba$RequestGetChargeAmounts parseFrom(AbstractC2384h abstractC2384h) {
        return (Saba$RequestGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Saba$RequestGetChargeAmounts parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Saba$RequestGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

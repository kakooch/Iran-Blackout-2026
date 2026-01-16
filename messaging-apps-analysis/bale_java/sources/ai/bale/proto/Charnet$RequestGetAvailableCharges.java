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

/* loaded from: classes9.dex */
public final class Charnet$RequestGetAvailableCharges extends GeneratedMessageLite implements U64 {
    public static final int CHARGE_TYPE_FIELD_NUMBER = 2;
    private static final Charnet$RequestGetAvailableCharges DEFAULT_INSTANCE;
    public static final int OPERATOR_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int chargeType_;
    private int operator_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Charnet$RequestGetAvailableCharges.DEFAULT_INSTANCE);
        }
    }

    static {
        Charnet$RequestGetAvailableCharges charnet$RequestGetAvailableCharges = new Charnet$RequestGetAvailableCharges();
        DEFAULT_INSTANCE = charnet$RequestGetAvailableCharges;
        GeneratedMessageLite.registerDefaultInstance(Charnet$RequestGetAvailableCharges.class, charnet$RequestGetAvailableCharges);
    }

    private Charnet$RequestGetAvailableCharges() {
    }

    private void clearChargeType() {
        this.chargeType_ = 0;
    }

    private void clearOperator() {
        this.operator_ = 0;
    }

    public static Charnet$RequestGetAvailableCharges getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Charnet$RequestGetAvailableCharges parseDelimitedFrom(InputStream inputStream) {
        return (Charnet$RequestGetAvailableCharges) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$RequestGetAvailableCharges parseFrom(ByteBuffer byteBuffer) {
        return (Charnet$RequestGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
        switch (AbstractC1911z.a[gVar.ordinal()]) {
            case 1:
                return new Charnet$RequestGetAvailableCharges();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\f", new Object[]{"operator_", "chargeType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Charnet$RequestGetAvailableCharges.class) {
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

    public static a newBuilder(Charnet$RequestGetAvailableCharges charnet$RequestGetAvailableCharges) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnet$RequestGetAvailableCharges);
    }

    public static Charnet$RequestGetAvailableCharges parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$RequestGetAvailableCharges) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$RequestGetAvailableCharges parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Charnet$RequestGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Charnet$RequestGetAvailableCharges parseFrom(AbstractC2383g abstractC2383g) {
        return (Charnet$RequestGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Charnet$RequestGetAvailableCharges parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Charnet$RequestGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Charnet$RequestGetAvailableCharges parseFrom(byte[] bArr) {
        return (Charnet$RequestGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Charnet$RequestGetAvailableCharges parseFrom(byte[] bArr, C2394s c2394s) {
        return (Charnet$RequestGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Charnet$RequestGetAvailableCharges parseFrom(InputStream inputStream) {
        return (Charnet$RequestGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$RequestGetAvailableCharges parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$RequestGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$RequestGetAvailableCharges parseFrom(AbstractC2384h abstractC2384h) {
        return (Charnet$RequestGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Charnet$RequestGetAvailableCharges parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Charnet$RequestGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.EnumC4422Fb2;
import ir.nasim.InterfaceC6568Ob2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class EvexStruct$EvexStation extends GeneratedMessageLite implements InterfaceC6568Ob2 {
    public static final int ADDRESS_FIELD_NUMBER = 3;
    public static final int BANK_TYPE_FIELD_NUMBER = 4;
    public static final int CAPACITY_FIELD_NUMBER = 6;
    private static final EvexStruct$EvexStation DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int STATE_NAME_FIELD_NUMBER = 5;
    private int bankType_;
    private int bitField0_;
    private Int32Value capacity_;
    private String name_ = "";
    private String id_ = "";
    private String address_ = "";
    private String stateName_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC6568Ob2 {
        private a() {
            super(EvexStruct$EvexStation.DEFAULT_INSTANCE);
        }
    }

    static {
        EvexStruct$EvexStation evexStruct$EvexStation = new EvexStruct$EvexStation();
        DEFAULT_INSTANCE = evexStruct$EvexStation;
        GeneratedMessageLite.registerDefaultInstance(EvexStruct$EvexStation.class, evexStruct$EvexStation);
    }

    private EvexStruct$EvexStation() {
    }

    private void clearAddress() {
        this.address_ = getDefaultInstance().getAddress();
    }

    private void clearBankType() {
        this.bankType_ = 0;
    }

    private void clearCapacity() {
        this.capacity_ = null;
        this.bitField0_ &= -2;
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearStateName() {
        this.stateName_ = getDefaultInstance().getStateName();
    }

    public static EvexStruct$EvexStation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCapacity(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.capacity_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.capacity_ = int32Value;
        } else {
            this.capacity_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.capacity_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EvexStruct$EvexStation parseDelimitedFrom(InputStream inputStream) {
        return (EvexStruct$EvexStation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexStruct$EvexStation parseFrom(ByteBuffer byteBuffer) {
        return (EvexStruct$EvexStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAddress(String str) {
        str.getClass();
        this.address_ = str;
    }

    private void setAddressBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.address_ = abstractC2383g.f0();
    }

    private void setBankType(EnumC4422Fb2 enumC4422Fb2) {
        this.bankType_ = enumC4422Fb2.getNumber();
    }

    private void setBankTypeValue(int i) {
        this.bankType_ = i;
    }

    private void setCapacity(Int32Value int32Value) {
        int32Value.getClass();
        this.capacity_ = int32Value;
        this.bitField0_ |= 1;
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    private void setStateName(String str) {
        str.getClass();
        this.stateName_ = str;
    }

    private void setStateNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.stateName_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (T.a[gVar.ordinal()]) {
            case 1:
                return new EvexStruct$EvexStation();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\f\u0005Ȉ\u0006ဉ\u0000", new Object[]{"bitField0_", "name_", "id_", "address_", "bankType_", "stateName_", "capacity_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EvexStruct$EvexStation.class) {
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

    public String getAddress() {
        return this.address_;
    }

    public AbstractC2383g getAddressBytes() {
        return AbstractC2383g.N(this.address_);
    }

    public EnumC4422Fb2 getBankType() {
        EnumC4422Fb2 enumC4422Fb2J = EnumC4422Fb2.j(this.bankType_);
        return enumC4422Fb2J == null ? EnumC4422Fb2.UNRECOGNIZED : enumC4422Fb2J;
    }

    public int getBankTypeValue() {
        return this.bankType_;
    }

    public Int32Value getCapacity() {
        Int32Value int32Value = this.capacity_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getStateName() {
        return this.stateName_;
    }

    public AbstractC2383g getStateNameBytes() {
        return AbstractC2383g.N(this.stateName_);
    }

    public boolean hasCapacity() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(EvexStruct$EvexStation evexStruct$EvexStation) {
        return (a) DEFAULT_INSTANCE.createBuilder(evexStruct$EvexStation);
    }

    public static EvexStruct$EvexStation parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexStruct$EvexStation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexStruct$EvexStation parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EvexStruct$EvexStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EvexStruct$EvexStation parseFrom(AbstractC2383g abstractC2383g) {
        return (EvexStruct$EvexStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static EvexStruct$EvexStation parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EvexStruct$EvexStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EvexStruct$EvexStation parseFrom(byte[] bArr) {
        return (EvexStruct$EvexStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EvexStruct$EvexStation parseFrom(byte[] bArr, C2394s c2394s) {
        return (EvexStruct$EvexStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EvexStruct$EvexStation parseFrom(InputStream inputStream) {
        return (EvexStruct$EvexStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexStruct$EvexStation parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexStruct$EvexStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexStruct$EvexStation parseFrom(AbstractC2384h abstractC2384h) {
        return (EvexStruct$EvexStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EvexStruct$EvexStation parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EvexStruct$EvexStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

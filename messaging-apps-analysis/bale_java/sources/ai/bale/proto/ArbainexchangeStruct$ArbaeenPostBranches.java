package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.FI;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ArbainexchangeStruct$ArbaeenPostBranches extends GeneratedMessageLite implements FI {
    public static final int ADDRESS_FIELD_NUMBER = 5;
    public static final int CAPACITY_FIELD_NUMBER = 7;
    private static final ArbainexchangeStruct$ArbaeenPostBranches DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int PARENTBRANCH_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int STATEID_FIELD_NUMBER = 1;
    public static final int STATE_NAME_FIELD_NUMBER = 6;
    public static final int STATIONID_FIELD_NUMBER = 3;
    private int bitField0_;
    private Int32Value capacity_;
    private String stateId_ = "";
    private String parentBranch_ = "";
    private String stationId_ = "";
    private String name_ = "";
    private String address_ = "";
    private String stateName_ = "";

    public static final class a extends GeneratedMessageLite.b implements FI {
        private a() {
            super(ArbainexchangeStruct$ArbaeenPostBranches.DEFAULT_INSTANCE);
        }
    }

    static {
        ArbainexchangeStruct$ArbaeenPostBranches arbainexchangeStruct$ArbaeenPostBranches = new ArbainexchangeStruct$ArbaeenPostBranches();
        DEFAULT_INSTANCE = arbainexchangeStruct$ArbaeenPostBranches;
        GeneratedMessageLite.registerDefaultInstance(ArbainexchangeStruct$ArbaeenPostBranches.class, arbainexchangeStruct$ArbaeenPostBranches);
    }

    private ArbainexchangeStruct$ArbaeenPostBranches() {
    }

    private void clearAddress() {
        this.address_ = getDefaultInstance().getAddress();
    }

    private void clearCapacity() {
        this.capacity_ = null;
        this.bitField0_ &= -2;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearParentBranch() {
        this.parentBranch_ = getDefaultInstance().getParentBranch();
    }

    private void clearStateId() {
        this.stateId_ = getDefaultInstance().getStateId();
    }

    private void clearStateName() {
        this.stateName_ = getDefaultInstance().getStateName();
    }

    private void clearStationId() {
        this.stationId_ = getDefaultInstance().getStationId();
    }

    public static ArbainexchangeStruct$ArbaeenPostBranches getDefaultInstance() {
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

    public static ArbainexchangeStruct$ArbaeenPostBranches parseDelimitedFrom(InputStream inputStream) {
        return (ArbainexchangeStruct$ArbaeenPostBranches) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ArbainexchangeStruct$ArbaeenPostBranches parseFrom(ByteBuffer byteBuffer) {
        return (ArbainexchangeStruct$ArbaeenPostBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setCapacity(Int32Value int32Value) {
        int32Value.getClass();
        this.capacity_ = int32Value;
        this.bitField0_ |= 1;
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    private void setParentBranch(String str) {
        str.getClass();
        this.parentBranch_ = str;
    }

    private void setParentBranchBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.parentBranch_ = abstractC2383g.f0();
    }

    private void setStateId(String str) {
        str.getClass();
        this.stateId_ = str;
    }

    private void setStateIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.stateId_ = abstractC2383g.f0();
    }

    private void setStateName(String str) {
        str.getClass();
        this.stateName_ = str;
    }

    private void setStateNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.stateName_ = abstractC2383g.f0();
    }

    private void setStationId(String str) {
        str.getClass();
        this.stationId_ = str;
    }

    private void setStationIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.stationId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1864j.a[gVar.ordinal()]) {
            case 1:
                return new ArbainexchangeStruct$ArbaeenPostBranches();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007ဉ\u0000", new Object[]{"bitField0_", "stateId_", "parentBranch_", "stationId_", "name_", "address_", "stateName_", "capacity_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ArbainexchangeStruct$ArbaeenPostBranches.class) {
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

    public Int32Value getCapacity() {
        Int32Value int32Value = this.capacity_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getParentBranch() {
        return this.parentBranch_;
    }

    public AbstractC2383g getParentBranchBytes() {
        return AbstractC2383g.N(this.parentBranch_);
    }

    public String getStateId() {
        return this.stateId_;
    }

    public AbstractC2383g getStateIdBytes() {
        return AbstractC2383g.N(this.stateId_);
    }

    public String getStateName() {
        return this.stateName_;
    }

    public AbstractC2383g getStateNameBytes() {
        return AbstractC2383g.N(this.stateName_);
    }

    public String getStationId() {
        return this.stationId_;
    }

    public AbstractC2383g getStationIdBytes() {
        return AbstractC2383g.N(this.stationId_);
    }

    public boolean hasCapacity() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ArbainexchangeStruct$ArbaeenPostBranches arbainexchangeStruct$ArbaeenPostBranches) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchangeStruct$ArbaeenPostBranches);
    }

    public static ArbainexchangeStruct$ArbaeenPostBranches parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenPostBranches) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenPostBranches parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenPostBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenPostBranches parseFrom(AbstractC2383g abstractC2383g) {
        return (ArbainexchangeStruct$ArbaeenPostBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ArbainexchangeStruct$ArbaeenPostBranches parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenPostBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenPostBranches parseFrom(byte[] bArr) {
        return (ArbainexchangeStruct$ArbaeenPostBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ArbainexchangeStruct$ArbaeenPostBranches parseFrom(byte[] bArr, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenPostBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenPostBranches parseFrom(InputStream inputStream) {
        return (ArbainexchangeStruct$ArbaeenPostBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ArbainexchangeStruct$ArbaeenPostBranches parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenPostBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ArbainexchangeStruct$ArbaeenPostBranches parseFrom(AbstractC2384h abstractC2384h) {
        return (ArbainexchangeStruct$ArbaeenPostBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ArbainexchangeStruct$ArbaeenPostBranches parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ArbainexchangeStruct$ArbaeenPostBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

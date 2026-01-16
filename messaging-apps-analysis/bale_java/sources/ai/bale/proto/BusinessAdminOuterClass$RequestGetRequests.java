package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC3353An0;
import ir.nasim.EnumC3592Bn0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class BusinessAdminOuterClass$RequestGetRequests extends GeneratedMessageLite implements U64 {
    private static final BusinessAdminOuterClass$RequestGetRequests DEFAULT_INSTANCE;
    public static final int OWNER_USER_ID_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int REQ_STATUS_FIELD_NUMBER = 2;
    public static final int REQ_TYPE_FIELD_NUMBER = 1;
    private static final B.h.a reqStatus_converter_ = new a();
    private int bitField0_;
    private int ownerUserId_;
    private int reqStatusMemoizedSerializedSize;
    private B.g reqStatus_ = GeneratedMessageLite.emptyIntList();
    private int reqType_;

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC3353An0 a(Integer num) {
            EnumC3353An0 enumC3353An0J = EnumC3353An0.j(num.intValue());
            return enumC3353An0J == null ? EnumC3353An0.UNRECOGNIZED : enumC3353An0J;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        private b() {
            super(BusinessAdminOuterClass$RequestGetRequests.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessAdminOuterClass$RequestGetRequests businessAdminOuterClass$RequestGetRequests = new BusinessAdminOuterClass$RequestGetRequests();
        DEFAULT_INSTANCE = businessAdminOuterClass$RequestGetRequests;
        GeneratedMessageLite.registerDefaultInstance(BusinessAdminOuterClass$RequestGetRequests.class, businessAdminOuterClass$RequestGetRequests);
    }

    private BusinessAdminOuterClass$RequestGetRequests() {
    }

    private void addAllReqStatus(Iterable<? extends EnumC3353An0> iterable) {
        ensureReqStatusIsMutable();
        Iterator<? extends EnumC3353An0> it = iterable.iterator();
        while (it.hasNext()) {
            this.reqStatus_.b1(it.next().getNumber());
        }
    }

    private void addAllReqStatusValue(Iterable<Integer> iterable) {
        ensureReqStatusIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.reqStatus_.b1(it.next().intValue());
        }
    }

    private void addReqStatus(EnumC3353An0 enumC3353An0) {
        enumC3353An0.getClass();
        ensureReqStatusIsMutable();
        this.reqStatus_.b1(enumC3353An0.getNumber());
    }

    private void addReqStatusValue(int i) {
        ensureReqStatusIsMutable();
        this.reqStatus_.b1(i);
    }

    private void clearOwnerUserId() {
        this.bitField0_ &= -2;
        this.ownerUserId_ = 0;
    }

    private void clearReqStatus() {
        this.reqStatus_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearReqType() {
        this.reqType_ = 0;
    }

    private void ensureReqStatusIsMutable() {
        B.g gVar = this.reqStatus_;
        if (gVar.u()) {
            return;
        }
        this.reqStatus_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static BusinessAdminOuterClass$RequestGetRequests getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessAdminOuterClass$RequestGetRequests parseDelimitedFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$RequestGetRequests) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$RequestGetRequests parseFrom(ByteBuffer byteBuffer) {
        return (BusinessAdminOuterClass$RequestGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOwnerUserId(int i) {
        this.bitField0_ |= 1;
        this.ownerUserId_ = i;
    }

    private void setReqStatus(int i, EnumC3353An0 enumC3353An0) {
        enumC3353An0.getClass();
        ensureReqStatusIsMutable();
        this.reqStatus_.U(i, enumC3353An0.getNumber());
    }

    private void setReqStatusValue(int i, int i2) {
        ensureReqStatusIsMutable();
        this.reqStatus_.U(i, i2);
    }

    private void setReqType(EnumC3592Bn0 enumC3592Bn0) {
        this.reqType_ = enumC3592Bn0.getNumber();
    }

    private void setReqTypeValue(int i) {
        this.reqType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1893t.a[gVar.ordinal()]) {
            case 1:
                return new BusinessAdminOuterClass$RequestGetRequests();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\f\u0002,\u0003င\u0000", new Object[]{"bitField0_", "reqType_", "reqStatus_", "ownerUserId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessAdminOuterClass$RequestGetRequests.class) {
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

    public int getOwnerUserId() {
        return this.ownerUserId_;
    }

    public EnumC3353An0 getReqStatus(int i) {
        EnumC3353An0 enumC3353An0J = EnumC3353An0.j(this.reqStatus_.getInt(i));
        return enumC3353An0J == null ? EnumC3353An0.UNRECOGNIZED : enumC3353An0J;
    }

    public int getReqStatusCount() {
        return this.reqStatus_.size();
    }

    public List<EnumC3353An0> getReqStatusList() {
        return new B.h(this.reqStatus_, reqStatus_converter_);
    }

    public int getReqStatusValue(int i) {
        return this.reqStatus_.getInt(i);
    }

    public List<Integer> getReqStatusValueList() {
        return this.reqStatus_;
    }

    public EnumC3592Bn0 getReqType() {
        EnumC3592Bn0 enumC3592Bn0J = EnumC3592Bn0.j(this.reqType_);
        return enumC3592Bn0J == null ? EnumC3592Bn0.UNRECOGNIZED : enumC3592Bn0J;
    }

    public int getReqTypeValue() {
        return this.reqType_;
    }

    public boolean hasOwnerUserId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static b newBuilder(BusinessAdminOuterClass$RequestGetRequests businessAdminOuterClass$RequestGetRequests) {
        return (b) DEFAULT_INSTANCE.createBuilder(businessAdminOuterClass$RequestGetRequests);
    }

    public static BusinessAdminOuterClass$RequestGetRequests parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestGetRequests) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$RequestGetRequests parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessAdminOuterClass$RequestGetRequests parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessAdminOuterClass$RequestGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessAdminOuterClass$RequestGetRequests parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessAdminOuterClass$RequestGetRequests parseFrom(byte[] bArr) {
        return (BusinessAdminOuterClass$RequestGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessAdminOuterClass$RequestGetRequests parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessAdminOuterClass$RequestGetRequests parseFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$RequestGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$RequestGetRequests parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$RequestGetRequests parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessAdminOuterClass$RequestGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessAdminOuterClass$RequestGetRequests parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestGetRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class CouponCreditOuterClass$GetByGroupMerchantIds extends GeneratedMessageLite implements U64 {
    private static final CouponCreditOuterClass$GetByGroupMerchantIds DEFAULT_INSTANCE;
    public static final int GROUP_MERCHANT_IDS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int groupMerchantIdsMemoizedSerializedSize = -1;
    private B.g groupMerchantIds_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(CouponCreditOuterClass$GetByGroupMerchantIds.DEFAULT_INSTANCE);
        }
    }

    static {
        CouponCreditOuterClass$GetByGroupMerchantIds couponCreditOuterClass$GetByGroupMerchantIds = new CouponCreditOuterClass$GetByGroupMerchantIds();
        DEFAULT_INSTANCE = couponCreditOuterClass$GetByGroupMerchantIds;
        GeneratedMessageLite.registerDefaultInstance(CouponCreditOuterClass$GetByGroupMerchantIds.class, couponCreditOuterClass$GetByGroupMerchantIds);
    }

    private CouponCreditOuterClass$GetByGroupMerchantIds() {
    }

    private void addAllGroupMerchantIds(Iterable<? extends Integer> iterable) {
        ensureGroupMerchantIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groupMerchantIds_);
    }

    private void addGroupMerchantIds(int i) {
        ensureGroupMerchantIdsIsMutable();
        this.groupMerchantIds_.b1(i);
    }

    private void clearGroupMerchantIds() {
        this.groupMerchantIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureGroupMerchantIdsIsMutable() {
        B.g gVar = this.groupMerchantIds_;
        if (gVar.u()) {
            return;
        }
        this.groupMerchantIds_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static CouponCreditOuterClass$GetByGroupMerchantIds getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CouponCreditOuterClass$GetByGroupMerchantIds parseDelimitedFrom(InputStream inputStream) {
        return (CouponCreditOuterClass$GetByGroupMerchantIds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CouponCreditOuterClass$GetByGroupMerchantIds parseFrom(ByteBuffer byteBuffer) {
        return (CouponCreditOuterClass$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroupMerchantIds(int i, int i2) {
        ensureGroupMerchantIdsIsMutable();
        this.groupMerchantIds_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (I.a[gVar.ordinal()]) {
            case 1:
                return new CouponCreditOuterClass$GetByGroupMerchantIds();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001'", new Object[]{"groupMerchantIds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CouponCreditOuterClass$GetByGroupMerchantIds.class) {
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

    public int getGroupMerchantIds(int i) {
        return this.groupMerchantIds_.getInt(i);
    }

    public int getGroupMerchantIdsCount() {
        return this.groupMerchantIds_.size();
    }

    public List<Integer> getGroupMerchantIdsList() {
        return this.groupMerchantIds_;
    }

    public static a newBuilder(CouponCreditOuterClass$GetByGroupMerchantIds couponCreditOuterClass$GetByGroupMerchantIds) {
        return (a) DEFAULT_INSTANCE.createBuilder(couponCreditOuterClass$GetByGroupMerchantIds);
    }

    public static CouponCreditOuterClass$GetByGroupMerchantIds parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CouponCreditOuterClass$GetByGroupMerchantIds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CouponCreditOuterClass$GetByGroupMerchantIds parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CouponCreditOuterClass$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CouponCreditOuterClass$GetByGroupMerchantIds parseFrom(AbstractC2383g abstractC2383g) {
        return (CouponCreditOuterClass$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CouponCreditOuterClass$GetByGroupMerchantIds parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CouponCreditOuterClass$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CouponCreditOuterClass$GetByGroupMerchantIds parseFrom(byte[] bArr) {
        return (CouponCreditOuterClass$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CouponCreditOuterClass$GetByGroupMerchantIds parseFrom(byte[] bArr, C2394s c2394s) {
        return (CouponCreditOuterClass$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CouponCreditOuterClass$GetByGroupMerchantIds parseFrom(InputStream inputStream) {
        return (CouponCreditOuterClass$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CouponCreditOuterClass$GetByGroupMerchantIds parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CouponCreditOuterClass$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CouponCreditOuterClass$GetByGroupMerchantIds parseFrom(AbstractC2384h abstractC2384h) {
        return (CouponCreditOuterClass$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CouponCreditOuterClass$GetByGroupMerchantIds parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CouponCreditOuterClass$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

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
public final class CouponCredit$GetByGroupMerchantIds extends GeneratedMessageLite implements U64 {
    private static final CouponCredit$GetByGroupMerchantIds DEFAULT_INSTANCE;
    public static final int GROUP_MERCHANT_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int groupMerchantIdMemoizedSerializedSize = -1;
    private B.g groupMerchantId_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(CouponCredit$GetByGroupMerchantIds.DEFAULT_INSTANCE);
        }
    }

    static {
        CouponCredit$GetByGroupMerchantIds couponCredit$GetByGroupMerchantIds = new CouponCredit$GetByGroupMerchantIds();
        DEFAULT_INSTANCE = couponCredit$GetByGroupMerchantIds;
        GeneratedMessageLite.registerDefaultInstance(CouponCredit$GetByGroupMerchantIds.class, couponCredit$GetByGroupMerchantIds);
    }

    private CouponCredit$GetByGroupMerchantIds() {
    }

    private void addAllGroupMerchantId(Iterable<? extends Integer> iterable) {
        ensureGroupMerchantIdIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groupMerchantId_);
    }

    private void addGroupMerchantId(int i) {
        ensureGroupMerchantIdIsMutable();
        this.groupMerchantId_.b1(i);
    }

    private void clearGroupMerchantId() {
        this.groupMerchantId_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureGroupMerchantIdIsMutable() {
        B.g gVar = this.groupMerchantId_;
        if (gVar.u()) {
            return;
        }
        this.groupMerchantId_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static CouponCredit$GetByGroupMerchantIds getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CouponCredit$GetByGroupMerchantIds parseDelimitedFrom(InputStream inputStream) {
        return (CouponCredit$GetByGroupMerchantIds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CouponCredit$GetByGroupMerchantIds parseFrom(ByteBuffer byteBuffer) {
        return (CouponCredit$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroupMerchantId(int i, int i2) {
        ensureGroupMerchantIdIsMutable();
        this.groupMerchantId_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H.a[gVar.ordinal()]) {
            case 1:
                return new CouponCredit$GetByGroupMerchantIds();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001'", new Object[]{"groupMerchantId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CouponCredit$GetByGroupMerchantIds.class) {
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

    public int getGroupMerchantId(int i) {
        return this.groupMerchantId_.getInt(i);
    }

    public int getGroupMerchantIdCount() {
        return this.groupMerchantId_.size();
    }

    public List<Integer> getGroupMerchantIdList() {
        return this.groupMerchantId_;
    }

    public static a newBuilder(CouponCredit$GetByGroupMerchantIds couponCredit$GetByGroupMerchantIds) {
        return (a) DEFAULT_INSTANCE.createBuilder(couponCredit$GetByGroupMerchantIds);
    }

    public static CouponCredit$GetByGroupMerchantIds parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CouponCredit$GetByGroupMerchantIds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CouponCredit$GetByGroupMerchantIds parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CouponCredit$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CouponCredit$GetByGroupMerchantIds parseFrom(AbstractC2383g abstractC2383g) {
        return (CouponCredit$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CouponCredit$GetByGroupMerchantIds parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CouponCredit$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CouponCredit$GetByGroupMerchantIds parseFrom(byte[] bArr) {
        return (CouponCredit$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CouponCredit$GetByGroupMerchantIds parseFrom(byte[] bArr, C2394s c2394s) {
        return (CouponCredit$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CouponCredit$GetByGroupMerchantIds parseFrom(InputStream inputStream) {
        return (CouponCredit$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CouponCredit$GetByGroupMerchantIds parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CouponCredit$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CouponCredit$GetByGroupMerchantIds parseFrom(AbstractC2384h abstractC2384h) {
        return (CouponCredit$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CouponCredit$GetByGroupMerchantIds parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CouponCredit$GetByGroupMerchantIds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

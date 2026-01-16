package ai.bale.proto;

import ai.bale.proto.PfmStruct$PfmTransactionTag;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC19306q75;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PfmStruct$PfmSplitUnit extends GeneratedMessageLite implements InterfaceC19306q75 {
    public static final int AMOUNT_FIELD_NUMBER = 1;
    private static final PfmStruct$PfmSplitUnit DEFAULT_INSTANCE;
    public static final int DETAIL_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TAG_FIELD_NUMBER = 2;
    private int bitField0_;
    private PfmStruct$PfmTransactionTag tag_;
    private String amount_ = "";
    private String detail_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC19306q75 {
        private a() {
            super(PfmStruct$PfmSplitUnit.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmStruct$PfmSplitUnit pfmStruct$PfmSplitUnit = new PfmStruct$PfmSplitUnit();
        DEFAULT_INSTANCE = pfmStruct$PfmSplitUnit;
        GeneratedMessageLite.registerDefaultInstance(PfmStruct$PfmSplitUnit.class, pfmStruct$PfmSplitUnit);
    }

    private PfmStruct$PfmSplitUnit() {
    }

    private void clearAmount() {
        this.amount_ = getDefaultInstance().getAmount();
    }

    private void clearDetail() {
        this.detail_ = getDefaultInstance().getDetail();
    }

    private void clearTag() {
        this.tag_ = null;
        this.bitField0_ &= -2;
    }

    public static PfmStruct$PfmSplitUnit getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTag(PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
        pfmStruct$PfmTransactionTag.getClass();
        PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag2 = this.tag_;
        if (pfmStruct$PfmTransactionTag2 == null || pfmStruct$PfmTransactionTag2 == PfmStruct$PfmTransactionTag.getDefaultInstance()) {
            this.tag_ = pfmStruct$PfmTransactionTag;
        } else {
            this.tag_ = (PfmStruct$PfmTransactionTag) ((PfmStruct$PfmTransactionTag.a) PfmStruct$PfmTransactionTag.newBuilder(this.tag_).v(pfmStruct$PfmTransactionTag)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmStruct$PfmSplitUnit parseDelimitedFrom(InputStream inputStream) {
        return (PfmStruct$PfmSplitUnit) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmStruct$PfmSplitUnit parseFrom(ByteBuffer byteBuffer) {
        return (PfmStruct$PfmSplitUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(String str) {
        str.getClass();
        this.amount_ = str;
    }

    private void setAmountBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.amount_ = abstractC2383g.f0();
    }

    private void setDetail(String str) {
        str.getClass();
        this.detail_ = str;
    }

    private void setDetailBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.detail_ = abstractC2383g.f0();
    }

    private void setTag(PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
        pfmStruct$PfmTransactionTag.getClass();
        this.tag_ = pfmStruct$PfmTransactionTag;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1851e1.a[gVar.ordinal()]) {
            case 1:
                return new PfmStruct$PfmSplitUnit();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003Ȉ", new Object[]{"bitField0_", "amount_", "tag_", "detail_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmStruct$PfmSplitUnit.class) {
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

    public String getAmount() {
        return this.amount_;
    }

    public AbstractC2383g getAmountBytes() {
        return AbstractC2383g.N(this.amount_);
    }

    public String getDetail() {
        return this.detail_;
    }

    public AbstractC2383g getDetailBytes() {
        return AbstractC2383g.N(this.detail_);
    }

    public PfmStruct$PfmTransactionTag getTag() {
        PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag = this.tag_;
        return pfmStruct$PfmTransactionTag == null ? PfmStruct$PfmTransactionTag.getDefaultInstance() : pfmStruct$PfmTransactionTag;
    }

    public boolean hasTag() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PfmStruct$PfmSplitUnit pfmStruct$PfmSplitUnit) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmStruct$PfmSplitUnit);
    }

    public static PfmStruct$PfmSplitUnit parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmStruct$PfmSplitUnit) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmStruct$PfmSplitUnit parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmStruct$PfmSplitUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmStruct$PfmSplitUnit parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmStruct$PfmSplitUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PfmStruct$PfmSplitUnit parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmStruct$PfmSplitUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmStruct$PfmSplitUnit parseFrom(byte[] bArr) {
        return (PfmStruct$PfmSplitUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmStruct$PfmSplitUnit parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmStruct$PfmSplitUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmStruct$PfmSplitUnit parseFrom(InputStream inputStream) {
        return (PfmStruct$PfmSplitUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmStruct$PfmSplitUnit parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmStruct$PfmSplitUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmStruct$PfmSplitUnit parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmStruct$PfmSplitUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmStruct$PfmSplitUnit parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmStruct$PfmSplitUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

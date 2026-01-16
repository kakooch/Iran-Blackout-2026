package ai.bale.proto;

import ai.bale.proto.PfmStruct$PfmTransactionTag;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.C75;
import ir.nasim.InterfaceC20506s75;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PfmStruct$PfmTotalAmount extends GeneratedMessageLite implements InterfaceC20506s75 {
    public static final int AMOUNT_FIELD_NUMBER = 3;
    private static final PfmStruct$PfmTotalAmount DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TAG_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    private String amount_ = "";
    private int bitField0_;
    private PfmStruct$PfmTransactionTag tag_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC20506s75 {
        public a A(String str) {
            q();
            ((PfmStruct$PfmTotalAmount) this.b).setAmount(str);
            return this;
        }

        public a B(PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
            q();
            ((PfmStruct$PfmTotalAmount) this.b).setTag(pfmStruct$PfmTransactionTag);
            return this;
        }

        public a C(C75 c75) {
            q();
            ((PfmStruct$PfmTotalAmount) this.b).setType(c75);
            return this;
        }

        private a() {
            super(PfmStruct$PfmTotalAmount.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmStruct$PfmTotalAmount pfmStruct$PfmTotalAmount = new PfmStruct$PfmTotalAmount();
        DEFAULT_INSTANCE = pfmStruct$PfmTotalAmount;
        GeneratedMessageLite.registerDefaultInstance(PfmStruct$PfmTotalAmount.class, pfmStruct$PfmTotalAmount);
    }

    private PfmStruct$PfmTotalAmount() {
    }

    private void clearAmount() {
        this.amount_ = getDefaultInstance().getAmount();
    }

    private void clearTag() {
        this.tag_ = null;
        this.bitField0_ &= -2;
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static PfmStruct$PfmTotalAmount getDefaultInstance() {
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

    public static PfmStruct$PfmTotalAmount parseDelimitedFrom(InputStream inputStream) {
        return (PfmStruct$PfmTotalAmount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmStruct$PfmTotalAmount parseFrom(ByteBuffer byteBuffer) {
        return (PfmStruct$PfmTotalAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAmount(String str) {
        str.getClass();
        this.amount_ = str;
    }

    private void setAmountBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.amount_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTag(PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
        pfmStruct$PfmTransactionTag.getClass();
        this.tag_ = pfmStruct$PfmTransactionTag;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(C75 c75) {
        this.type_ = c75.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1851e1.a[gVar.ordinal()]) {
            case 1:
                return new PfmStruct$PfmTotalAmount();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000\u0003Ȉ", new Object[]{"bitField0_", "type_", "tag_", "amount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmStruct$PfmTotalAmount.class) {
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

    public PfmStruct$PfmTransactionTag getTag() {
        PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag = this.tag_;
        return pfmStruct$PfmTransactionTag == null ? PfmStruct$PfmTransactionTag.getDefaultInstance() : pfmStruct$PfmTransactionTag;
    }

    public C75 getType() {
        C75 c75J = C75.j(this.type_);
        return c75J == null ? C75.UNRECOGNIZED : c75J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public boolean hasTag() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PfmStruct$PfmTotalAmount pfmStruct$PfmTotalAmount) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmStruct$PfmTotalAmount);
    }

    public static PfmStruct$PfmTotalAmount parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmStruct$PfmTotalAmount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmStruct$PfmTotalAmount parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmStruct$PfmTotalAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmStruct$PfmTotalAmount parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmStruct$PfmTotalAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PfmStruct$PfmTotalAmount parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmStruct$PfmTotalAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmStruct$PfmTotalAmount parseFrom(byte[] bArr) {
        return (PfmStruct$PfmTotalAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmStruct$PfmTotalAmount parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmStruct$PfmTotalAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmStruct$PfmTotalAmount parseFrom(InputStream inputStream) {
        return (PfmStruct$PfmTotalAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmStruct$PfmTotalAmount parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmStruct$PfmTotalAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmStruct$PfmTotalAmount parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmStruct$PfmTotalAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmStruct$PfmTotalAmount parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmStruct$PfmTotalAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

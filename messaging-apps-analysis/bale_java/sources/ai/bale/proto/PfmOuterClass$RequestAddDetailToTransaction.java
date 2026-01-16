package ai.bale.proto;

import ai.bale.proto.PfmStruct$PfmTransactionId;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PfmOuterClass$RequestAddDetailToTransaction extends GeneratedMessageLite implements U64 {
    private static final PfmOuterClass$RequestAddDetailToTransaction DEFAULT_INSTANCE;
    public static final int DETAIL_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private String detail_ = "";
    private PfmStruct$PfmTransactionId id_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((PfmOuterClass$RequestAddDetailToTransaction) this.b).setDetail(str);
            return this;
        }

        public a B(PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
            q();
            ((PfmOuterClass$RequestAddDetailToTransaction) this.b).setId(pfmStruct$PfmTransactionId);
            return this;
        }

        private a() {
            super(PfmOuterClass$RequestAddDetailToTransaction.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmOuterClass$RequestAddDetailToTransaction pfmOuterClass$RequestAddDetailToTransaction = new PfmOuterClass$RequestAddDetailToTransaction();
        DEFAULT_INSTANCE = pfmOuterClass$RequestAddDetailToTransaction;
        GeneratedMessageLite.registerDefaultInstance(PfmOuterClass$RequestAddDetailToTransaction.class, pfmOuterClass$RequestAddDetailToTransaction);
    }

    private PfmOuterClass$RequestAddDetailToTransaction() {
    }

    private void clearDetail() {
        this.detail_ = getDefaultInstance().getDetail();
    }

    private void clearId() {
        this.id_ = null;
        this.bitField0_ &= -2;
    }

    public static PfmOuterClass$RequestAddDetailToTransaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeId(PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId2 = this.id_;
        if (pfmStruct$PfmTransactionId2 == null || pfmStruct$PfmTransactionId2 == PfmStruct$PfmTransactionId.getDefaultInstance()) {
            this.id_ = pfmStruct$PfmTransactionId;
        } else {
            this.id_ = (PfmStruct$PfmTransactionId) ((PfmStruct$PfmTransactionId.a) PfmStruct$PfmTransactionId.newBuilder(this.id_).v(pfmStruct$PfmTransactionId)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmOuterClass$RequestAddDetailToTransaction parseDelimitedFrom(InputStream inputStream) {
        return (PfmOuterClass$RequestAddDetailToTransaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$RequestAddDetailToTransaction parseFrom(ByteBuffer byteBuffer) {
        return (PfmOuterClass$RequestAddDetailToTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetail(String str) {
        str.getClass();
        this.detail_ = str;
    }

    private void setDetailBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.detail_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        pfmStruct$PfmTransactionId.getClass();
        this.id_ = pfmStruct$PfmTransactionId;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1848d1.a[gVar.ordinal()]) {
            case 1:
                return new PfmOuterClass$RequestAddDetailToTransaction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ", new Object[]{"bitField0_", "id_", "detail_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmOuterClass$RequestAddDetailToTransaction.class) {
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

    public String getDetail() {
        return this.detail_;
    }

    public AbstractC2383g getDetailBytes() {
        return AbstractC2383g.N(this.detail_);
    }

    public PfmStruct$PfmTransactionId getId() {
        PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId = this.id_;
        return pfmStruct$PfmTransactionId == null ? PfmStruct$PfmTransactionId.getDefaultInstance() : pfmStruct$PfmTransactionId;
    }

    public boolean hasId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PfmOuterClass$RequestAddDetailToTransaction pfmOuterClass$RequestAddDetailToTransaction) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmOuterClass$RequestAddDetailToTransaction);
    }

    public static PfmOuterClass$RequestAddDetailToTransaction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$RequestAddDetailToTransaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$RequestAddDetailToTransaction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmOuterClass$RequestAddDetailToTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmOuterClass$RequestAddDetailToTransaction parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmOuterClass$RequestAddDetailToTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PfmOuterClass$RequestAddDetailToTransaction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmOuterClass$RequestAddDetailToTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmOuterClass$RequestAddDetailToTransaction parseFrom(byte[] bArr) {
        return (PfmOuterClass$RequestAddDetailToTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmOuterClass$RequestAddDetailToTransaction parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmOuterClass$RequestAddDetailToTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmOuterClass$RequestAddDetailToTransaction parseFrom(InputStream inputStream) {
        return (PfmOuterClass$RequestAddDetailToTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$RequestAddDetailToTransaction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$RequestAddDetailToTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$RequestAddDetailToTransaction parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmOuterClass$RequestAddDetailToTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmOuterClass$RequestAddDetailToTransaction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmOuterClass$RequestAddDetailToTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

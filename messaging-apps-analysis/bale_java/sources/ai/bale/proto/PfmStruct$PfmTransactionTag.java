package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.B75;
import ir.nasim.C75;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PfmStruct$PfmTransactionTag extends GeneratedMessageLite implements B75 {
    public static final int COLOR_FIELD_NUMBER = 6;
    private static final PfmStruct$PfmTransactionTag DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 2;
    public static final int LABEL_FIELD_NUMBER = 3;
    public static final int PARENT_TAG_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int TRANSACTION_TYPE_FIELD_NUMBER = 4;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private StringValue color_;
    private long id_;
    private String label_ = "";
    private PfmStruct$PfmTransactionTag parentTag_;
    private int transactionType_;
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements B75 {
        public a A(StringValue stringValue) {
            q();
            ((PfmStruct$PfmTransactionTag) this.b).setColor(stringValue);
            return this;
        }

        public a B(long j) {
            q();
            ((PfmStruct$PfmTransactionTag) this.b).setId(j);
            return this;
        }

        public a C(String str) {
            q();
            ((PfmStruct$PfmTransactionTag) this.b).setLabel(str);
            return this;
        }

        public a D(PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
            q();
            ((PfmStruct$PfmTransactionTag) this.b).setParentTag(pfmStruct$PfmTransactionTag);
            return this;
        }

        public a E(C75 c75) {
            q();
            ((PfmStruct$PfmTransactionTag) this.b).setTransactionType(c75);
            return this;
        }

        public a F(int i) {
            q();
            ((PfmStruct$PfmTransactionTag) this.b).setUserId(i);
            return this;
        }

        private a() {
            super(PfmStruct$PfmTransactionTag.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag = new PfmStruct$PfmTransactionTag();
        DEFAULT_INSTANCE = pfmStruct$PfmTransactionTag;
        GeneratedMessageLite.registerDefaultInstance(PfmStruct$PfmTransactionTag.class, pfmStruct$PfmTransactionTag);
    }

    private PfmStruct$PfmTransactionTag() {
    }

    private void clearColor() {
        this.color_ = null;
        this.bitField0_ &= -3;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearLabel() {
        this.label_ = getDefaultInstance().getLabel();
    }

    private void clearParentTag() {
        this.parentTag_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTransactionType() {
        this.transactionType_ = 0;
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static PfmStruct$PfmTransactionTag getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeColor(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.color_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.color_ = stringValue;
        } else {
            this.color_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.color_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeParentTag(PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
        pfmStruct$PfmTransactionTag.getClass();
        PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag2 = this.parentTag_;
        if (pfmStruct$PfmTransactionTag2 == null || pfmStruct$PfmTransactionTag2 == getDefaultInstance()) {
            this.parentTag_ = pfmStruct$PfmTransactionTag;
        } else {
            this.parentTag_ = (PfmStruct$PfmTransactionTag) ((a) newBuilder(this.parentTag_).v(pfmStruct$PfmTransactionTag)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmStruct$PfmTransactionTag parseDelimitedFrom(InputStream inputStream) {
        return (PfmStruct$PfmTransactionTag) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmStruct$PfmTransactionTag parseFrom(ByteBuffer byteBuffer) {
        return (PfmStruct$PfmTransactionTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColor(StringValue stringValue) {
        stringValue.getClass();
        this.color_ = stringValue;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(long j) {
        this.id_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLabel(String str) {
        str.getClass();
        this.label_ = str;
    }

    private void setLabelBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.label_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParentTag(PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
        pfmStruct$PfmTransactionTag.getClass();
        this.parentTag_ = pfmStruct$PfmTransactionTag;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransactionType(C75 c75) {
        this.transactionType_ = c75.getNumber();
    }

    private void setTransactionTypeValue(int i) {
        this.transactionType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1851e1.a[gVar.ordinal()]) {
            case 1:
                return new PfmStruct$PfmTransactionTag();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003Ȉ\u0004\f\u0005ဉ\u0000\u0006ဉ\u0001", new Object[]{"bitField0_", "userId_", "id_", "label_", "transactionType_", "parentTag_", "color_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmStruct$PfmTransactionTag.class) {
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

    public StringValue getColor() {
        StringValue stringValue = this.color_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public long getId() {
        return this.id_;
    }

    public String getLabel() {
        return this.label_;
    }

    public AbstractC2383g getLabelBytes() {
        return AbstractC2383g.N(this.label_);
    }

    public PfmStruct$PfmTransactionTag getParentTag() {
        PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag = this.parentTag_;
        return pfmStruct$PfmTransactionTag == null ? getDefaultInstance() : pfmStruct$PfmTransactionTag;
    }

    public C75 getTransactionType() {
        C75 c75J = C75.j(this.transactionType_);
        return c75J == null ? C75.UNRECOGNIZED : c75J;
    }

    public int getTransactionTypeValue() {
        return this.transactionType_;
    }

    public int getUserId() {
        return this.userId_;
    }

    public boolean hasColor() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasParentTag() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmStruct$PfmTransactionTag);
    }

    public static PfmStruct$PfmTransactionTag parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmStruct$PfmTransactionTag) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmStruct$PfmTransactionTag parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmStruct$PfmTransactionTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmStruct$PfmTransactionTag parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmStruct$PfmTransactionTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PfmStruct$PfmTransactionTag parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmStruct$PfmTransactionTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmStruct$PfmTransactionTag parseFrom(byte[] bArr) {
        return (PfmStruct$PfmTransactionTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmStruct$PfmTransactionTag parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmStruct$PfmTransactionTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmStruct$PfmTransactionTag parseFrom(InputStream inputStream) {
        return (PfmStruct$PfmTransactionTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmStruct$PfmTransactionTag parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmStruct$PfmTransactionTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmStruct$PfmTransactionTag parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmStruct$PfmTransactionTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmStruct$PfmTransactionTag parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmStruct$PfmTransactionTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

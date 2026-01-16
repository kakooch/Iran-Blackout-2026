package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.InterfaceC6588Od4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$Transaction extends GeneratedMessageLite implements InterfaceC6588Od4 {
    public static final int BRNO_FIELD_NUMBER = 9;
    public static final int CATEGORY_ID_FIELD_NUMBER = 7;
    public static final int COMMENT_FIELD_NUMBER = 8;
    private static final MessagingStruct$Transaction DEFAULT_INSTANCE;
    public static final int HYPER_LINK_FIELD_NUMBER = 11;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TRANSACTION_AMOUNT_WITH_SIGN_FIELD_NUMBER = 5;
    public static final int TRANSACTION_CHANNEL_FIELD_NUMBER = 3;
    public static final int TRANSACTION_DATE_FIELD_NUMBER = 4;
    public static final int TRANSACTION_NAME_FIELD_NUMBER = 2;
    public static final int TRANSACTION_TRACE_FIELD_NUMBER = 10;
    public static final int TRANSACTION_TYPE_FIELD_NUMBER = 6;
    private int bitField0_;
    private int brno_;
    private int categoryId_;
    private Int32Value hyperLink_;
    private long id_;
    private long transactionDate_;
    private String transactionName_ = "";
    private String transactionChannel_ = "";
    private String transactionAmountWithSign_ = "";
    private String transactionType_ = "";
    private String comment_ = "";
    private String transactionTrace_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC6588Od4 {
        private a() {
            super(MessagingStruct$Transaction.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$Transaction messagingStruct$Transaction = new MessagingStruct$Transaction();
        DEFAULT_INSTANCE = messagingStruct$Transaction;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$Transaction.class, messagingStruct$Transaction);
    }

    private MessagingStruct$Transaction() {
    }

    private void clearBrno() {
        this.brno_ = 0;
    }

    private void clearCategoryId() {
        this.categoryId_ = 0;
    }

    private void clearComment() {
        this.comment_ = getDefaultInstance().getComment();
    }

    private void clearHyperLink() {
        this.hyperLink_ = null;
        this.bitField0_ &= -2;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearTransactionAmountWithSign() {
        this.transactionAmountWithSign_ = getDefaultInstance().getTransactionAmountWithSign();
    }

    private void clearTransactionChannel() {
        this.transactionChannel_ = getDefaultInstance().getTransactionChannel();
    }

    private void clearTransactionDate() {
        this.transactionDate_ = 0L;
    }

    private void clearTransactionName() {
        this.transactionName_ = getDefaultInstance().getTransactionName();
    }

    private void clearTransactionTrace() {
        this.transactionTrace_ = getDefaultInstance().getTransactionTrace();
    }

    private void clearTransactionType() {
        this.transactionType_ = getDefaultInstance().getTransactionType();
    }

    public static MessagingStruct$Transaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeHyperLink(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.hyperLink_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.hyperLink_ = int32Value;
        } else {
            this.hyperLink_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.hyperLink_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$Transaction parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$Transaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$Transaction parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$Transaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBrno(int i) {
        this.brno_ = i;
    }

    private void setCategoryId(int i) {
        this.categoryId_ = i;
    }

    private void setComment(String str) {
        str.getClass();
        this.comment_ = str;
    }

    private void setCommentBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.comment_ = abstractC2383g.f0();
    }

    private void setHyperLink(Int32Value int32Value) {
        int32Value.getClass();
        this.hyperLink_ = int32Value;
        this.bitField0_ |= 1;
    }

    private void setId(long j) {
        this.id_ = j;
    }

    private void setTransactionAmountWithSign(String str) {
        str.getClass();
        this.transactionAmountWithSign_ = str;
    }

    private void setTransactionAmountWithSignBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.transactionAmountWithSign_ = abstractC2383g.f0();
    }

    private void setTransactionChannel(String str) {
        str.getClass();
        this.transactionChannel_ = str;
    }

    private void setTransactionChannelBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.transactionChannel_ = abstractC2383g.f0();
    }

    private void setTransactionDate(long j) {
        this.transactionDate_ = j;
    }

    private void setTransactionName(String str) {
        str.getClass();
        this.transactionName_ = str;
    }

    private void setTransactionNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.transactionName_ = abstractC2383g.f0();
    }

    private void setTransactionTrace(String str) {
        str.getClass();
        this.transactionTrace_ = str;
    }

    private void setTransactionTraceBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.transactionTrace_ = abstractC2383g.f0();
    }

    private void setTransactionType(String str) {
        str.getClass();
        this.transactionType_ = str;
    }

    private void setTransactionTypeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.transactionType_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$Transaction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ\u0004\u0002\u0005Ȉ\u0006Ȉ\u0007\u0004\bȈ\t\u0004\nȈ\u000bဉ\u0000", new Object[]{"bitField0_", "id_", "transactionName_", "transactionChannel_", "transactionDate_", "transactionAmountWithSign_", "transactionType_", "categoryId_", "comment_", "brno_", "transactionTrace_", "hyperLink_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$Transaction.class) {
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

    public int getBrno() {
        return this.brno_;
    }

    public int getCategoryId() {
        return this.categoryId_;
    }

    public String getComment() {
        return this.comment_;
    }

    public AbstractC2383g getCommentBytes() {
        return AbstractC2383g.N(this.comment_);
    }

    public Int32Value getHyperLink() {
        Int32Value int32Value = this.hyperLink_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public long getId() {
        return this.id_;
    }

    public String getTransactionAmountWithSign() {
        return this.transactionAmountWithSign_;
    }

    public AbstractC2383g getTransactionAmountWithSignBytes() {
        return AbstractC2383g.N(this.transactionAmountWithSign_);
    }

    public String getTransactionChannel() {
        return this.transactionChannel_;
    }

    public AbstractC2383g getTransactionChannelBytes() {
        return AbstractC2383g.N(this.transactionChannel_);
    }

    public long getTransactionDate() {
        return this.transactionDate_;
    }

    public String getTransactionName() {
        return this.transactionName_;
    }

    public AbstractC2383g getTransactionNameBytes() {
        return AbstractC2383g.N(this.transactionName_);
    }

    public String getTransactionTrace() {
        return this.transactionTrace_;
    }

    public AbstractC2383g getTransactionTraceBytes() {
        return AbstractC2383g.N(this.transactionTrace_);
    }

    public String getTransactionType() {
        return this.transactionType_;
    }

    public AbstractC2383g getTransactionTypeBytes() {
        return AbstractC2383g.N(this.transactionType_);
    }

    public boolean hasHyperLink() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$Transaction messagingStruct$Transaction) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$Transaction);
    }

    public static MessagingStruct$Transaction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$Transaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$Transaction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$Transaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$Transaction parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$Transaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$Transaction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$Transaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$Transaction parseFrom(byte[] bArr) {
        return (MessagingStruct$Transaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$Transaction parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$Transaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$Transaction parseFrom(InputStream inputStream) {
        return (MessagingStruct$Transaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$Transaction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$Transaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$Transaction parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$Transaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$Transaction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$Transaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

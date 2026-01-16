package ai.bale.proto;

import ai.bale.proto.KetfStruct$PaymentDisapproval;
import ai.bale.proto.KetfStruct$PaymentSession;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7628Sn3;
import ir.nasim.InterfaceC9936ao3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class KetfOuterClass$ResponseGetPaymentDetails extends GeneratedMessageLite implements U64 {
    private static final KetfOuterClass$ResponseGetPaymentDetails DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 6;
    public static final int DISAPPROVED_FIELD_NUMBER = 5;
    public static final int LABELED_PRICES_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENTS_HISTORY_FIELD_NUMBER = 3;
    public static final int SESSION_FIELD_NUMBER = 4;
    public static final int TITLE_FIELD_NUMBER = 1;
    public static final int TOTAL_AMOUNT_FIELD_NUMBER = 2;
    private Object result_;
    private long totalAmount_;
    private int resultCase_ = 0;
    private String title_ = "";
    private B.j paymentsHistory_ = GeneratedMessageLite.emptyProtobufList();
    private String description_ = "";
    private B.j labeledPrices_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfOuterClass$ResponseGetPaymentDetails.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        SESSION(4),
        DISAPPROVED(5),
        RESULT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return RESULT_NOT_SET;
            }
            if (i == 4) {
                return SESSION;
            }
            if (i != 5) {
                return null;
            }
            return DISAPPROVED;
        }
    }

    static {
        KetfOuterClass$ResponseGetPaymentDetails ketfOuterClass$ResponseGetPaymentDetails = new KetfOuterClass$ResponseGetPaymentDetails();
        DEFAULT_INSTANCE = ketfOuterClass$ResponseGetPaymentDetails;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$ResponseGetPaymentDetails.class, ketfOuterClass$ResponseGetPaymentDetails);
    }

    private KetfOuterClass$ResponseGetPaymentDetails() {
    }

    private void addAllLabeledPrices(Iterable<? extends KetfStruct$LabeledPrice> iterable) {
        ensureLabeledPricesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.labeledPrices_);
    }

    private void addAllPaymentsHistory(Iterable<? extends KetfStruct$PaymentReceipt> iterable) {
        ensurePaymentsHistoryIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.paymentsHistory_);
    }

    private void addLabeledPrices(KetfStruct$LabeledPrice ketfStruct$LabeledPrice) {
        ketfStruct$LabeledPrice.getClass();
        ensureLabeledPricesIsMutable();
        this.labeledPrices_.add(ketfStruct$LabeledPrice);
    }

    private void addPaymentsHistory(KetfStruct$PaymentReceipt ketfStruct$PaymentReceipt) {
        ketfStruct$PaymentReceipt.getClass();
        ensurePaymentsHistoryIsMutable();
        this.paymentsHistory_.add(ketfStruct$PaymentReceipt);
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearDisapproved() {
        if (this.resultCase_ == 5) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    private void clearLabeledPrices() {
        this.labeledPrices_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPaymentsHistory() {
        this.paymentsHistory_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearResult() {
        this.resultCase_ = 0;
        this.result_ = null;
    }

    private void clearSession() {
        if (this.resultCase_ == 4) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearTotalAmount() {
        this.totalAmount_ = 0L;
    }

    private void ensureLabeledPricesIsMutable() {
        B.j jVar = this.labeledPrices_;
        if (jVar.u()) {
            return;
        }
        this.labeledPrices_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensurePaymentsHistoryIsMutable() {
        B.j jVar = this.paymentsHistory_;
        if (jVar.u()) {
            return;
        }
        this.paymentsHistory_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static KetfOuterClass$ResponseGetPaymentDetails getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDisapproved(KetfStruct$PaymentDisapproval ketfStruct$PaymentDisapproval) {
        ketfStruct$PaymentDisapproval.getClass();
        if (this.resultCase_ != 5 || this.result_ == KetfStruct$PaymentDisapproval.getDefaultInstance()) {
            this.result_ = ketfStruct$PaymentDisapproval;
        } else {
            this.result_ = ((KetfStruct$PaymentDisapproval.a) KetfStruct$PaymentDisapproval.newBuilder((KetfStruct$PaymentDisapproval) this.result_).v(ketfStruct$PaymentDisapproval)).j();
        }
        this.resultCase_ = 5;
    }

    private void mergeSession(KetfStruct$PaymentSession ketfStruct$PaymentSession) {
        ketfStruct$PaymentSession.getClass();
        if (this.resultCase_ != 4 || this.result_ == KetfStruct$PaymentSession.getDefaultInstance()) {
            this.result_ = ketfStruct$PaymentSession;
        } else {
            this.result_ = ((KetfStruct$PaymentSession.a) KetfStruct$PaymentSession.newBuilder((KetfStruct$PaymentSession) this.result_).v(ketfStruct$PaymentSession)).j();
        }
        this.resultCase_ = 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$ResponseGetPaymentDetails parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseGetPaymentDetails) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseGetPaymentDetails parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$ResponseGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeLabeledPrices(int i) {
        ensureLabeledPricesIsMutable();
        this.labeledPrices_.remove(i);
    }

    private void removePaymentsHistory(int i) {
        ensurePaymentsHistoryIsMutable();
        this.paymentsHistory_.remove(i);
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setDisapproved(KetfStruct$PaymentDisapproval ketfStruct$PaymentDisapproval) {
        ketfStruct$PaymentDisapproval.getClass();
        this.result_ = ketfStruct$PaymentDisapproval;
        this.resultCase_ = 5;
    }

    private void setLabeledPrices(int i, KetfStruct$LabeledPrice ketfStruct$LabeledPrice) {
        ketfStruct$LabeledPrice.getClass();
        ensureLabeledPricesIsMutable();
        this.labeledPrices_.set(i, ketfStruct$LabeledPrice);
    }

    private void setPaymentsHistory(int i, KetfStruct$PaymentReceipt ketfStruct$PaymentReceipt) {
        ketfStruct$PaymentReceipt.getClass();
        ensurePaymentsHistoryIsMutable();
        this.paymentsHistory_.set(i, ketfStruct$PaymentReceipt);
    }

    private void setSession(KetfStruct$PaymentSession ketfStruct$PaymentSession) {
        ketfStruct$PaymentSession.getClass();
        this.result_ = ketfStruct$PaymentSession;
        this.resultCase_ = 4;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    private void setTotalAmount(long j) {
        this.totalAmount_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$ResponseGetPaymentDetails();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\u0007\u0007\u0000\u0002\u0000\u0001Ȉ\u0002\u0002\u0003\u001b\u0004<\u0000\u0005<\u0000\u0006Ȉ\u0007\u001b", new Object[]{"result_", "resultCase_", "title_", "totalAmount_", "paymentsHistory_", KetfStruct$PaymentReceipt.class, KetfStruct$PaymentSession.class, KetfStruct$PaymentDisapproval.class, "description_", "labeledPrices_", KetfStruct$LabeledPrice.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$ResponseGetPaymentDetails.class) {
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

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public KetfStruct$PaymentDisapproval getDisapproved() {
        return this.resultCase_ == 5 ? (KetfStruct$PaymentDisapproval) this.result_ : KetfStruct$PaymentDisapproval.getDefaultInstance();
    }

    public KetfStruct$LabeledPrice getLabeledPrices(int i) {
        return (KetfStruct$LabeledPrice) this.labeledPrices_.get(i);
    }

    public int getLabeledPricesCount() {
        return this.labeledPrices_.size();
    }

    public List<KetfStruct$LabeledPrice> getLabeledPricesList() {
        return this.labeledPrices_;
    }

    public InterfaceC7628Sn3 getLabeledPricesOrBuilder(int i) {
        return (InterfaceC7628Sn3) this.labeledPrices_.get(i);
    }

    public List<? extends InterfaceC7628Sn3> getLabeledPricesOrBuilderList() {
        return this.labeledPrices_;
    }

    public KetfStruct$PaymentReceipt getPaymentsHistory(int i) {
        return (KetfStruct$PaymentReceipt) this.paymentsHistory_.get(i);
    }

    public int getPaymentsHistoryCount() {
        return this.paymentsHistory_.size();
    }

    public List<KetfStruct$PaymentReceipt> getPaymentsHistoryList() {
        return this.paymentsHistory_;
    }

    public InterfaceC9936ao3 getPaymentsHistoryOrBuilder(int i) {
        return (InterfaceC9936ao3) this.paymentsHistory_.get(i);
    }

    public List<? extends InterfaceC9936ao3> getPaymentsHistoryOrBuilderList() {
        return this.paymentsHistory_;
    }

    public b getResultCase() {
        return b.j(this.resultCase_);
    }

    public KetfStruct$PaymentSession getSession() {
        return this.resultCase_ == 4 ? (KetfStruct$PaymentSession) this.result_ : KetfStruct$PaymentSession.getDefaultInstance();
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public long getTotalAmount() {
        return this.totalAmount_;
    }

    public boolean hasDisapproved() {
        return this.resultCase_ == 5;
    }

    public boolean hasSession() {
        return this.resultCase_ == 4;
    }

    public static a newBuilder(KetfOuterClass$ResponseGetPaymentDetails ketfOuterClass$ResponseGetPaymentDetails) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$ResponseGetPaymentDetails);
    }

    public static KetfOuterClass$ResponseGetPaymentDetails parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetPaymentDetails) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseGetPaymentDetails parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$ResponseGetPaymentDetails parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$ResponseGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addLabeledPrices(int i, KetfStruct$LabeledPrice ketfStruct$LabeledPrice) {
        ketfStruct$LabeledPrice.getClass();
        ensureLabeledPricesIsMutable();
        this.labeledPrices_.add(i, ketfStruct$LabeledPrice);
    }

    private void addPaymentsHistory(int i, KetfStruct$PaymentReceipt ketfStruct$PaymentReceipt) {
        ketfStruct$PaymentReceipt.getClass();
        ensurePaymentsHistoryIsMutable();
        this.paymentsHistory_.add(i, ketfStruct$PaymentReceipt);
    }

    public static KetfOuterClass$ResponseGetPaymentDetails parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$ResponseGetPaymentDetails parseFrom(byte[] bArr) {
        return (KetfOuterClass$ResponseGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$ResponseGetPaymentDetails parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$ResponseGetPaymentDetails parseFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseGetPaymentDetails parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseGetPaymentDetails parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$ResponseGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$ResponseGetPaymentDetails parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

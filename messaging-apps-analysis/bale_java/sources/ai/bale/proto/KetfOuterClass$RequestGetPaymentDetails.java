package ai.bale.proto;

import ai.bale.proto.KetfStruct$InvoiceIdentifier;
import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfOuterClass$RequestGetPaymentDetails extends GeneratedMessageLite implements U64 {
    private static final KetfOuterClass$RequestGetPaymentDetails DEFAULT_INSTANCE;
    public static final int INVOICE_IDENTIFIER_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PURCHASE_MESSAGE_ID_FIELD_NUMBER = 1;
    private int identifierCase_ = 0;
    private Object identifier_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfOuterClass$RequestGetPaymentDetails.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        PURCHASE_MESSAGE_ID(1),
        INVOICE_IDENTIFIER(2),
        IDENTIFIER_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return IDENTIFIER_NOT_SET;
            }
            if (i == 1) {
                return PURCHASE_MESSAGE_ID;
            }
            if (i != 2) {
                return null;
            }
            return INVOICE_IDENTIFIER;
        }
    }

    static {
        KetfOuterClass$RequestGetPaymentDetails ketfOuterClass$RequestGetPaymentDetails = new KetfOuterClass$RequestGetPaymentDetails();
        DEFAULT_INSTANCE = ketfOuterClass$RequestGetPaymentDetails;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$RequestGetPaymentDetails.class, ketfOuterClass$RequestGetPaymentDetails);
    }

    private KetfOuterClass$RequestGetPaymentDetails() {
    }

    private void clearIdentifier() {
        this.identifierCase_ = 0;
        this.identifier_ = null;
    }

    private void clearInvoiceIdentifier() {
        if (this.identifierCase_ == 2) {
            this.identifierCase_ = 0;
            this.identifier_ = null;
        }
    }

    private void clearPurchaseMessageId() {
        if (this.identifierCase_ == 1) {
            this.identifierCase_ = 0;
            this.identifier_ = null;
        }
    }

    public static KetfOuterClass$RequestGetPaymentDetails getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeInvoiceIdentifier(KetfStruct$InvoiceIdentifier ketfStruct$InvoiceIdentifier) {
        ketfStruct$InvoiceIdentifier.getClass();
        if (this.identifierCase_ != 2 || this.identifier_ == KetfStruct$InvoiceIdentifier.getDefaultInstance()) {
            this.identifier_ = ketfStruct$InvoiceIdentifier;
        } else {
            this.identifier_ = ((KetfStruct$InvoiceIdentifier.a) KetfStruct$InvoiceIdentifier.newBuilder((KetfStruct$InvoiceIdentifier) this.identifier_).v(ketfStruct$InvoiceIdentifier)).j();
        }
        this.identifierCase_ = 2;
    }

    private void mergePurchaseMessageId(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        if (this.identifierCase_ != 1 || this.identifier_ == MessagingStruct$HistoryMessageIdentifier.getDefaultInstance()) {
            this.identifier_ = messagingStruct$HistoryMessageIdentifier;
        } else {
            this.identifier_ = ((MessagingStruct$HistoryMessageIdentifier.a) MessagingStruct$HistoryMessageIdentifier.newBuilder((MessagingStruct$HistoryMessageIdentifier) this.identifier_).v(messagingStruct$HistoryMessageIdentifier)).j();
        }
        this.identifierCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$RequestGetPaymentDetails parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestGetPaymentDetails) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestGetPaymentDetails parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$RequestGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setInvoiceIdentifier(KetfStruct$InvoiceIdentifier ketfStruct$InvoiceIdentifier) {
        ketfStruct$InvoiceIdentifier.getClass();
        this.identifier_ = ketfStruct$InvoiceIdentifier;
        this.identifierCase_ = 2;
    }

    private void setPurchaseMessageId(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        this.identifier_ = messagingStruct$HistoryMessageIdentifier;
        this.identifierCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$RequestGetPaymentDetails();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"identifier_", "identifierCase_", MessagingStruct$HistoryMessageIdentifier.class, KetfStruct$InvoiceIdentifier.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$RequestGetPaymentDetails.class) {
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

    public b getIdentifierCase() {
        return b.j(this.identifierCase_);
    }

    public KetfStruct$InvoiceIdentifier getInvoiceIdentifier() {
        return this.identifierCase_ == 2 ? (KetfStruct$InvoiceIdentifier) this.identifier_ : KetfStruct$InvoiceIdentifier.getDefaultInstance();
    }

    public MessagingStruct$HistoryMessageIdentifier getPurchaseMessageId() {
        return this.identifierCase_ == 1 ? (MessagingStruct$HistoryMessageIdentifier) this.identifier_ : MessagingStruct$HistoryMessageIdentifier.getDefaultInstance();
    }

    public boolean hasInvoiceIdentifier() {
        return this.identifierCase_ == 2;
    }

    public boolean hasPurchaseMessageId() {
        return this.identifierCase_ == 1;
    }

    public static a newBuilder(KetfOuterClass$RequestGetPaymentDetails ketfOuterClass$RequestGetPaymentDetails) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$RequestGetPaymentDetails);
    }

    public static KetfOuterClass$RequestGetPaymentDetails parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestGetPaymentDetails) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestGetPaymentDetails parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$RequestGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$RequestGetPaymentDetails parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$RequestGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfOuterClass$RequestGetPaymentDetails parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$RequestGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$RequestGetPaymentDetails parseFrom(byte[] bArr) {
        return (KetfOuterClass$RequestGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$RequestGetPaymentDetails parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$RequestGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$RequestGetPaymentDetails parseFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestGetPaymentDetails parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestGetPaymentDetails parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$RequestGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$RequestGetPaymentDetails parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$RequestGetPaymentDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

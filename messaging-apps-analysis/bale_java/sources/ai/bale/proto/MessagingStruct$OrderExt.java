package ai.bale.proto;

import ai.bale.proto.MessagingStruct$BillOrderMessage;
import ai.bale.proto.MessagingStruct$ChargeOrderMessage;
import ai.bale.proto.MessagingStruct$PsProxyOrderMessage;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$OrderExt extends GeneratedMessageLite implements U64 {
    public static final int BILL_ORDER_MESSAGE_FIELD_NUMBER = 1;
    public static final int CHARGE_ORDER_MESSAGE_FIELD_NUMBER = 2;
    private static final MessagingStruct$OrderExt DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PS_PROXY_ORDER_MESSAGE_FIELD_NUMBER = 3;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$OrderExt.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        BILL_ORDER_MESSAGE(1),
        CHARGE_ORDER_MESSAGE(2),
        PS_PROXY_ORDER_MESSAGE(3),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return BILL_ORDER_MESSAGE;
            }
            if (i == 2) {
                return CHARGE_ORDER_MESSAGE;
            }
            if (i != 3) {
                return null;
            }
            return PS_PROXY_ORDER_MESSAGE;
        }
    }

    static {
        MessagingStruct$OrderExt messagingStruct$OrderExt = new MessagingStruct$OrderExt();
        DEFAULT_INSTANCE = messagingStruct$OrderExt;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$OrderExt.class, messagingStruct$OrderExt);
    }

    private MessagingStruct$OrderExt() {
    }

    private void clearBillOrderMessage() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearChargeOrderMessage() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPsProxyOrderMessage() {
        if (this.traitCase_ == 3) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static MessagingStruct$OrderExt getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBillOrderMessage(MessagingStruct$BillOrderMessage messagingStruct$BillOrderMessage) {
        messagingStruct$BillOrderMessage.getClass();
        if (this.traitCase_ != 1 || this.trait_ == MessagingStruct$BillOrderMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$BillOrderMessage;
        } else {
            this.trait_ = ((MessagingStruct$BillOrderMessage.a) MessagingStruct$BillOrderMessage.newBuilder((MessagingStruct$BillOrderMessage) this.trait_).v(messagingStruct$BillOrderMessage)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergeChargeOrderMessage(MessagingStruct$ChargeOrderMessage messagingStruct$ChargeOrderMessage) {
        messagingStruct$ChargeOrderMessage.getClass();
        if (this.traitCase_ != 2 || this.trait_ == MessagingStruct$ChargeOrderMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$ChargeOrderMessage;
        } else {
            this.trait_ = ((MessagingStruct$ChargeOrderMessage.a) MessagingStruct$ChargeOrderMessage.newBuilder((MessagingStruct$ChargeOrderMessage) this.trait_).v(messagingStruct$ChargeOrderMessage)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergePsProxyOrderMessage(MessagingStruct$PsProxyOrderMessage messagingStruct$PsProxyOrderMessage) {
        messagingStruct$PsProxyOrderMessage.getClass();
        if (this.traitCase_ != 3 || this.trait_ == MessagingStruct$PsProxyOrderMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$PsProxyOrderMessage;
        } else {
            this.trait_ = ((MessagingStruct$PsProxyOrderMessage.a) MessagingStruct$PsProxyOrderMessage.newBuilder((MessagingStruct$PsProxyOrderMessage) this.trait_).v(messagingStruct$PsProxyOrderMessage)).j();
        }
        this.traitCase_ = 3;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$OrderExt parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$OrderExt) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$OrderExt parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$OrderExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBillOrderMessage(MessagingStruct$BillOrderMessage messagingStruct$BillOrderMessage) {
        messagingStruct$BillOrderMessage.getClass();
        this.trait_ = messagingStruct$BillOrderMessage;
        this.traitCase_ = 1;
    }

    private void setChargeOrderMessage(MessagingStruct$ChargeOrderMessage messagingStruct$ChargeOrderMessage) {
        messagingStruct$ChargeOrderMessage.getClass();
        this.trait_ = messagingStruct$ChargeOrderMessage;
        this.traitCase_ = 2;
    }

    private void setPsProxyOrderMessage(MessagingStruct$PsProxyOrderMessage messagingStruct$PsProxyOrderMessage) {
        messagingStruct$PsProxyOrderMessage.getClass();
        this.trait_ = messagingStruct$PsProxyOrderMessage;
        this.traitCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$OrderExt();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"trait_", "traitCase_", MessagingStruct$BillOrderMessage.class, MessagingStruct$ChargeOrderMessage.class, MessagingStruct$PsProxyOrderMessage.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$OrderExt.class) {
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

    public MessagingStruct$BillOrderMessage getBillOrderMessage() {
        return this.traitCase_ == 1 ? (MessagingStruct$BillOrderMessage) this.trait_ : MessagingStruct$BillOrderMessage.getDefaultInstance();
    }

    public MessagingStruct$ChargeOrderMessage getChargeOrderMessage() {
        return this.traitCase_ == 2 ? (MessagingStruct$ChargeOrderMessage) this.trait_ : MessagingStruct$ChargeOrderMessage.getDefaultInstance();
    }

    public MessagingStruct$PsProxyOrderMessage getPsProxyOrderMessage() {
        return this.traitCase_ == 3 ? (MessagingStruct$PsProxyOrderMessage) this.trait_ : MessagingStruct$PsProxyOrderMessage.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasBillOrderMessage() {
        return this.traitCase_ == 1;
    }

    public boolean hasChargeOrderMessage() {
        return this.traitCase_ == 2;
    }

    public boolean hasPsProxyOrderMessage() {
        return this.traitCase_ == 3;
    }

    public static a newBuilder(MessagingStruct$OrderExt messagingStruct$OrderExt) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$OrderExt);
    }

    public static MessagingStruct$OrderExt parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$OrderExt) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$OrderExt parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$OrderExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$OrderExt parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$OrderExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$OrderExt parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$OrderExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$OrderExt parseFrom(byte[] bArr) {
        return (MessagingStruct$OrderExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$OrderExt parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$OrderExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$OrderExt parseFrom(InputStream inputStream) {
        return (MessagingStruct$OrderExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$OrderExt parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$OrderExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$OrderExt parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$OrderExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$OrderExt parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$OrderExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

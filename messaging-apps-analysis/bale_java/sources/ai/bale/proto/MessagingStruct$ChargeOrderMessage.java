package ai.bale.proto;

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
public final class MessagingStruct$ChargeOrderMessage extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 3;
    public static final int CARD_ACQ_ID_FIELD_NUMBER = 5;
    private static final MessagingStruct$ChargeOrderMessage DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NO_FIELD_NUMBER = 2;
    public static final int PROVIDER_ID_FIELD_NUMBER = 1;
    public static final int TERMINAL_ID_FIELD_NUMBER = 4;
    private int amount_;
    private String providerId_ = "";
    private String phoneNo_ = "";
    private String terminalId_ = "";
    private String cardAcqId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ChargeOrderMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ChargeOrderMessage messagingStruct$ChargeOrderMessage = new MessagingStruct$ChargeOrderMessage();
        DEFAULT_INSTANCE = messagingStruct$ChargeOrderMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ChargeOrderMessage.class, messagingStruct$ChargeOrderMessage);
    }

    private MessagingStruct$ChargeOrderMessage() {
    }

    private void clearAmount() {
        this.amount_ = 0;
    }

    private void clearCardAcqId() {
        this.cardAcqId_ = getDefaultInstance().getCardAcqId();
    }

    private void clearPhoneNo() {
        this.phoneNo_ = getDefaultInstance().getPhoneNo();
    }

    private void clearProviderId() {
        this.providerId_ = getDefaultInstance().getProviderId();
    }

    private void clearTerminalId() {
        this.terminalId_ = getDefaultInstance().getTerminalId();
    }

    public static MessagingStruct$ChargeOrderMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ChargeOrderMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ChargeOrderMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ChargeOrderMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ChargeOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(int i) {
        this.amount_ = i;
    }

    private void setCardAcqId(String str) {
        str.getClass();
        this.cardAcqId_ = str;
    }

    private void setCardAcqIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cardAcqId_ = abstractC2383g.f0();
    }

    private void setPhoneNo(String str) {
        str.getClass();
        this.phoneNo_ = str;
    }

    private void setPhoneNoBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.phoneNo_ = abstractC2383g.f0();
    }

    private void setProviderId(String str) {
        str.getClass();
        this.providerId_ = str;
    }

    private void setProviderIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.providerId_ = abstractC2383g.f0();
    }

    private void setTerminalId(String str) {
        str.getClass();
        this.terminalId_ = str;
    }

    private void setTerminalIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.terminalId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ChargeOrderMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0004\u0004Ȉ\u0005Ȉ", new Object[]{"providerId_", "phoneNo_", "amount_", "terminalId_", "cardAcqId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ChargeOrderMessage.class) {
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

    public int getAmount() {
        return this.amount_;
    }

    public String getCardAcqId() {
        return this.cardAcqId_;
    }

    public AbstractC2383g getCardAcqIdBytes() {
        return AbstractC2383g.N(this.cardAcqId_);
    }

    public String getPhoneNo() {
        return this.phoneNo_;
    }

    public AbstractC2383g getPhoneNoBytes() {
        return AbstractC2383g.N(this.phoneNo_);
    }

    public String getProviderId() {
        return this.providerId_;
    }

    public AbstractC2383g getProviderIdBytes() {
        return AbstractC2383g.N(this.providerId_);
    }

    public String getTerminalId() {
        return this.terminalId_;
    }

    public AbstractC2383g getTerminalIdBytes() {
        return AbstractC2383g.N(this.terminalId_);
    }

    public static a newBuilder(MessagingStruct$ChargeOrderMessage messagingStruct$ChargeOrderMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ChargeOrderMessage);
    }

    public static MessagingStruct$ChargeOrderMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ChargeOrderMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ChargeOrderMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ChargeOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ChargeOrderMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ChargeOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ChargeOrderMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ChargeOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ChargeOrderMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$ChargeOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ChargeOrderMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ChargeOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ChargeOrderMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$ChargeOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ChargeOrderMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ChargeOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ChargeOrderMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ChargeOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ChargeOrderMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ChargeOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC4424Fb4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$GoldGiftPacketMessage extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 2;
    public static final int COUNT_FIELD_NUMBER = 3;
    private static final MessagingStruct$GoldGiftPacketMessage DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int GIVING_TYPE_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private long amount_;
    private long count_;
    private String description_ = "";
    private int givingType_;
    private long id_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$GoldGiftPacketMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$GoldGiftPacketMessage messagingStruct$GoldGiftPacketMessage = new MessagingStruct$GoldGiftPacketMessage();
        DEFAULT_INSTANCE = messagingStruct$GoldGiftPacketMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$GoldGiftPacketMessage.class, messagingStruct$GoldGiftPacketMessage);
    }

    private MessagingStruct$GoldGiftPacketMessage() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearCount() {
        this.count_ = 0L;
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearGivingType() {
        this.givingType_ = 0;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    public static MessagingStruct$GoldGiftPacketMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$GoldGiftPacketMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$GoldGiftPacketMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$GoldGiftPacketMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$GoldGiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setCount(long j) {
        this.count_ = j;
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setGivingType(EnumC4424Fb4 enumC4424Fb4) {
        this.givingType_ = enumC4424Fb4.getNumber();
    }

    private void setGivingTypeValue(int i) {
        this.givingType_ = i;
    }

    private void setId(long j) {
        this.id_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$GoldGiftPacketMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0002\u0004Ȉ\u0005\f", new Object[]{"id_", "amount_", "count_", "description_", "givingType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$GoldGiftPacketMessage.class) {
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

    public long getAmount() {
        return this.amount_;
    }

    public long getCount() {
        return this.count_;
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public EnumC4424Fb4 getGivingType() {
        EnumC4424Fb4 enumC4424Fb4J = EnumC4424Fb4.j(this.givingType_);
        return enumC4424Fb4J == null ? EnumC4424Fb4.UNRECOGNIZED : enumC4424Fb4J;
    }

    public int getGivingTypeValue() {
        return this.givingType_;
    }

    public long getId() {
        return this.id_;
    }

    public static a newBuilder(MessagingStruct$GoldGiftPacketMessage messagingStruct$GoldGiftPacketMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$GoldGiftPacketMessage);
    }

    public static MessagingStruct$GoldGiftPacketMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$GoldGiftPacketMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$GoldGiftPacketMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$GoldGiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$GoldGiftPacketMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$GoldGiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$GoldGiftPacketMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$GoldGiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$GoldGiftPacketMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$GoldGiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$GoldGiftPacketMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$GoldGiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$GoldGiftPacketMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$GoldGiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$GoldGiftPacketMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$GoldGiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$GoldGiftPacketMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$GoldGiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$GoldGiftPacketMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$GoldGiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

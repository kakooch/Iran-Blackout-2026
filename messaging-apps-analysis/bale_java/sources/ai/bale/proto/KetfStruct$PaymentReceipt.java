package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC8569Wn3;
import ir.nasim.InterfaceC9936ao3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfStruct$PaymentReceipt extends GeneratedMessageLite implements InterfaceC9936ao3 {
    public static final int BOT_MESSAGE_FIELD_NUMBER = 3;
    private static final KetfStruct$PaymentReceipt DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 4;
    public static final int TRACK_CODE_FIELD_NUMBER = 1;
    public static final int UNIX_DATE_FIELD_NUMBER = 2;
    private int bitField0_;
    private StringValue botMessage_;
    private int status_;
    private String trackCode_ = "";
    private long unixDate_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC9936ao3 {
        private a() {
            super(KetfStruct$PaymentReceipt.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfStruct$PaymentReceipt ketfStruct$PaymentReceipt = new KetfStruct$PaymentReceipt();
        DEFAULT_INSTANCE = ketfStruct$PaymentReceipt;
        GeneratedMessageLite.registerDefaultInstance(KetfStruct$PaymentReceipt.class, ketfStruct$PaymentReceipt);
    }

    private KetfStruct$PaymentReceipt() {
    }

    private void clearBotMessage() {
        this.botMessage_ = null;
        this.bitField0_ &= -2;
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void clearTrackCode() {
        this.trackCode_ = getDefaultInstance().getTrackCode();
    }

    private void clearUnixDate() {
        this.unixDate_ = 0L;
    }

    public static KetfStruct$PaymentReceipt getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBotMessage(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.botMessage_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.botMessage_ = stringValue;
        } else {
            this.botMessage_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.botMessage_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfStruct$PaymentReceipt parseDelimitedFrom(InputStream inputStream) {
        return (KetfStruct$PaymentReceipt) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$PaymentReceipt parseFrom(ByteBuffer byteBuffer) {
        return (KetfStruct$PaymentReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotMessage(StringValue stringValue) {
        stringValue.getClass();
        this.botMessage_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setStatus(EnumC8569Wn3 enumC8569Wn3) {
        this.status_ = enumC8569Wn3.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    private void setTrackCode(String str) {
        str.getClass();
        this.trackCode_ = str;
    }

    private void setTrackCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.trackCode_ = abstractC2383g.f0();
    }

    private void setUnixDate(long j) {
        this.unixDate_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1891s0.a[gVar.ordinal()]) {
            case 1:
                return new KetfStruct$PaymentReceipt();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003ဉ\u0000\u0004\f", new Object[]{"bitField0_", "trackCode_", "unixDate_", "botMessage_", "status_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfStruct$PaymentReceipt.class) {
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

    public StringValue getBotMessage() {
        StringValue stringValue = this.botMessage_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public EnumC8569Wn3 getStatus() {
        EnumC8569Wn3 enumC8569Wn3J = EnumC8569Wn3.j(this.status_);
        return enumC8569Wn3J == null ? EnumC8569Wn3.UNRECOGNIZED : enumC8569Wn3J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public String getTrackCode() {
        return this.trackCode_;
    }

    public AbstractC2383g getTrackCodeBytes() {
        return AbstractC2383g.N(this.trackCode_);
    }

    public long getUnixDate() {
        return this.unixDate_;
    }

    public boolean hasBotMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KetfStruct$PaymentReceipt ketfStruct$PaymentReceipt) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfStruct$PaymentReceipt);
    }

    public static KetfStruct$PaymentReceipt parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$PaymentReceipt) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$PaymentReceipt parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfStruct$PaymentReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfStruct$PaymentReceipt parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfStruct$PaymentReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfStruct$PaymentReceipt parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfStruct$PaymentReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfStruct$PaymentReceipt parseFrom(byte[] bArr) {
        return (KetfStruct$PaymentReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfStruct$PaymentReceipt parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfStruct$PaymentReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfStruct$PaymentReceipt parseFrom(InputStream inputStream) {
        return (KetfStruct$PaymentReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$PaymentReceipt parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$PaymentReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$PaymentReceipt parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfStruct$PaymentReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfStruct$PaymentReceipt parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfStruct$PaymentReceipt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

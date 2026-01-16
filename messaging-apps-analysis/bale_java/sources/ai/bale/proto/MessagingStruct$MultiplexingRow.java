package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC20789sc4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$MultiplexingRow extends GeneratedMessageLite implements InterfaceC20789sc4 {
    private static final MessagingStruct$MultiplexingRow DEFAULT_INSTANCE;
    public static final int IBAN_NUMBER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int ibanNumber_;
    private int value_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC20789sc4 {
        private a() {
            super(MessagingStruct$MultiplexingRow.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$MultiplexingRow messagingStruct$MultiplexingRow = new MessagingStruct$MultiplexingRow();
        DEFAULT_INSTANCE = messagingStruct$MultiplexingRow;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$MultiplexingRow.class, messagingStruct$MultiplexingRow);
    }

    private MessagingStruct$MultiplexingRow() {
    }

    private void clearIbanNumber() {
        this.ibanNumber_ = 0;
    }

    private void clearValue() {
        this.value_ = 0;
    }

    public static MessagingStruct$MultiplexingRow getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$MultiplexingRow parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$MultiplexingRow) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$MultiplexingRow parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$MultiplexingRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIbanNumber(int i) {
        this.ibanNumber_ = i;
    }

    private void setValue(int i) {
        this.value_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$MultiplexingRow();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"ibanNumber_", "value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$MultiplexingRow.class) {
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

    public int getIbanNumber() {
        return this.ibanNumber_;
    }

    public int getValue() {
        return this.value_;
    }

    public static a newBuilder(MessagingStruct$MultiplexingRow messagingStruct$MultiplexingRow) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$MultiplexingRow);
    }

    public static MessagingStruct$MultiplexingRow parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$MultiplexingRow) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$MultiplexingRow parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$MultiplexingRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$MultiplexingRow parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$MultiplexingRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$MultiplexingRow parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$MultiplexingRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$MultiplexingRow parseFrom(byte[] bArr) {
        return (MessagingStruct$MultiplexingRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$MultiplexingRow parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$MultiplexingRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$MultiplexingRow parseFrom(InputStream inputStream) {
        return (MessagingStruct$MultiplexingRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$MultiplexingRow parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$MultiplexingRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$MultiplexingRow parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$MultiplexingRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$MultiplexingRow parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$MultiplexingRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$ReplyKeyboardRemove extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$ReplyKeyboardRemove DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REMOVE_KEYBOARD_FIELD_NUMBER = 1;
    public static final int SELECTIVE_FIELD_NUMBER = 2;
    private int bitField0_;
    private boolean removeKeyboard_;
    private BoolValue selective_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ReplyKeyboardRemove.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ReplyKeyboardRemove messagingStruct$ReplyKeyboardRemove = new MessagingStruct$ReplyKeyboardRemove();
        DEFAULT_INSTANCE = messagingStruct$ReplyKeyboardRemove;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ReplyKeyboardRemove.class, messagingStruct$ReplyKeyboardRemove);
    }

    private MessagingStruct$ReplyKeyboardRemove() {
    }

    private void clearRemoveKeyboard() {
        this.removeKeyboard_ = false;
    }

    private void clearSelective() {
        this.selective_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$ReplyKeyboardRemove getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeSelective(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.selective_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.selective_ = boolValue;
        } else {
            this.selective_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.selective_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ReplyKeyboardRemove parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ReplyKeyboardRemove) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ReplyKeyboardRemove parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ReplyKeyboardRemove) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setRemoveKeyboard(boolean z) {
        this.removeKeyboard_ = z;
    }

    private void setSelective(BoolValue boolValue) {
        boolValue.getClass();
        this.selective_ = boolValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ReplyKeyboardRemove();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002ဉ\u0000", new Object[]{"bitField0_", "removeKeyboard_", "selective_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ReplyKeyboardRemove.class) {
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

    public boolean getRemoveKeyboard() {
        return this.removeKeyboard_;
    }

    public BoolValue getSelective() {
        BoolValue boolValue = this.selective_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public boolean hasSelective() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$ReplyKeyboardRemove messagingStruct$ReplyKeyboardRemove) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ReplyKeyboardRemove);
    }

    public static MessagingStruct$ReplyKeyboardRemove parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ReplyKeyboardRemove) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ReplyKeyboardRemove parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ReplyKeyboardRemove) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ReplyKeyboardRemove parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ReplyKeyboardRemove) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ReplyKeyboardRemove parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ReplyKeyboardRemove) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ReplyKeyboardRemove parseFrom(byte[] bArr) {
        return (MessagingStruct$ReplyKeyboardRemove) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ReplyKeyboardRemove parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ReplyKeyboardRemove) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ReplyKeyboardRemove parseFrom(InputStream inputStream) {
        return (MessagingStruct$ReplyKeyboardRemove) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ReplyKeyboardRemove parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ReplyKeyboardRemove) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ReplyKeyboardRemove parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ReplyKeyboardRemove) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ReplyKeyboardRemove parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ReplyKeyboardRemove) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

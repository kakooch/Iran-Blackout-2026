package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC5861Ld4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$TextModernField extends GeneratedMessageLite implements InterfaceC5861Ld4 {
    private static final MessagingStruct$TextModernField DEFAULT_INSTANCE;
    public static final int IS_SHORT_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int bitField0_;
    private BoolValue isShort_;
    private String title_ = "";
    private String value_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC5861Ld4 {
        private a() {
            super(MessagingStruct$TextModernField.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$TextModernField messagingStruct$TextModernField = new MessagingStruct$TextModernField();
        DEFAULT_INSTANCE = messagingStruct$TextModernField;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$TextModernField.class, messagingStruct$TextModernField);
    }

    private MessagingStruct$TextModernField() {
    }

    private void clearIsShort() {
        this.isShort_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearValue() {
        this.value_ = getDefaultInstance().getValue();
    }

    public static MessagingStruct$TextModernField getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeIsShort(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isShort_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isShort_ = boolValue;
        } else {
            this.isShort_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isShort_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$TextModernField parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$TextModernField) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TextModernField parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$TextModernField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsShort(BoolValue boolValue) {
        boolValue.getClass();
        this.isShort_ = boolValue;
        this.bitField0_ |= 1;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    private void setValue(String str) {
        str.getClass();
        this.value_ = str;
    }

    private void setValueBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.value_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$TextModernField();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003ဉ\u0000", new Object[]{"bitField0_", "title_", "value_", "isShort_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$TextModernField.class) {
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

    public BoolValue getIsShort() {
        BoolValue boolValue = this.isShort_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public String getValue() {
        return this.value_;
    }

    public AbstractC2383g getValueBytes() {
        return AbstractC2383g.N(this.value_);
    }

    public boolean hasIsShort() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$TextModernField messagingStruct$TextModernField) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$TextModernField);
    }

    public static MessagingStruct$TextModernField parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TextModernField) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TextModernField parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$TextModernField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$TextModernField parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$TextModernField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$TextModernField parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$TextModernField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$TextModernField parseFrom(byte[] bArr) {
        return (MessagingStruct$TextModernField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$TextModernField parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$TextModernField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$TextModernField parseFrom(InputStream inputStream) {
        return (MessagingStruct$TextModernField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TextModernField parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TextModernField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TextModernField parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$TextModernField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$TextModernField parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$TextModernField) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

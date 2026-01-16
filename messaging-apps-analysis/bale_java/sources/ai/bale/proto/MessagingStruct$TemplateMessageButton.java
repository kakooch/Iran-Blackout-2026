package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC3506Bd4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$TemplateMessageButton extends GeneratedMessageLite implements InterfaceC3506Bd4 {
    public static final int ACTION_FIELD_NUMBER = 3;
    private static final MessagingStruct$TemplateMessageButton DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int action_;
    private String text_ = "";
    private String value_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC3506Bd4 {
        private a() {
            super(MessagingStruct$TemplateMessageButton.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$TemplateMessageButton messagingStruct$TemplateMessageButton = new MessagingStruct$TemplateMessageButton();
        DEFAULT_INSTANCE = messagingStruct$TemplateMessageButton;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$TemplateMessageButton.class, messagingStruct$TemplateMessageButton);
    }

    private MessagingStruct$TemplateMessageButton() {
    }

    private void clearAction() {
        this.action_ = 0;
    }

    private void clearText() {
        this.text_ = getDefaultInstance().getText();
    }

    private void clearValue() {
        this.value_ = getDefaultInstance().getValue();
    }

    public static MessagingStruct$TemplateMessageButton getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$TemplateMessageButton parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$TemplateMessageButton) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TemplateMessageButton parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$TemplateMessageButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAction(int i) {
        this.action_ = i;
    }

    private void setText(String str) {
        str.getClass();
        this.text_ = str;
    }

    private void setTextBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.text_ = abstractC2383g.f0();
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
                return new MessagingStruct$TemplateMessageButton();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0004", new Object[]{"text_", "value_", "action_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$TemplateMessageButton.class) {
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

    public int getAction() {
        return this.action_;
    }

    public String getText() {
        return this.text_;
    }

    public AbstractC2383g getTextBytes() {
        return AbstractC2383g.N(this.text_);
    }

    public String getValue() {
        return this.value_;
    }

    public AbstractC2383g getValueBytes() {
        return AbstractC2383g.N(this.value_);
    }

    public static a newBuilder(MessagingStruct$TemplateMessageButton messagingStruct$TemplateMessageButton) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$TemplateMessageButton);
    }

    public static MessagingStruct$TemplateMessageButton parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TemplateMessageButton) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TemplateMessageButton parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$TemplateMessageButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$TemplateMessageButton parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$TemplateMessageButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$TemplateMessageButton parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$TemplateMessageButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$TemplateMessageButton parseFrom(byte[] bArr) {
        return (MessagingStruct$TemplateMessageButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$TemplateMessageButton parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$TemplateMessageButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$TemplateMessageButton parseFrom(InputStream inputStream) {
        return (MessagingStruct$TemplateMessageButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TemplateMessageButton parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TemplateMessageButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TemplateMessageButton parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$TemplateMessageButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$TemplateMessageButton parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$TemplateMessageButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

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
public final class MessagingStruct$ShowSnackBarAction extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$ShowSnackBarAction DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 1;
    private String text_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ShowSnackBarAction.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ShowSnackBarAction messagingStruct$ShowSnackBarAction = new MessagingStruct$ShowSnackBarAction();
        DEFAULT_INSTANCE = messagingStruct$ShowSnackBarAction;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ShowSnackBarAction.class, messagingStruct$ShowSnackBarAction);
    }

    private MessagingStruct$ShowSnackBarAction() {
    }

    private void clearText() {
        this.text_ = getDefaultInstance().getText();
    }

    public static MessagingStruct$ShowSnackBarAction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ShowSnackBarAction parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ShowSnackBarAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ShowSnackBarAction parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ShowSnackBarAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setText(String str) {
        str.getClass();
        this.text_ = str;
    }

    private void setTextBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.text_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ShowSnackBarAction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"text_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ShowSnackBarAction.class) {
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

    public String getText() {
        return this.text_;
    }

    public AbstractC2383g getTextBytes() {
        return AbstractC2383g.N(this.text_);
    }

    public static a newBuilder(MessagingStruct$ShowSnackBarAction messagingStruct$ShowSnackBarAction) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ShowSnackBarAction);
    }

    public static MessagingStruct$ShowSnackBarAction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ShowSnackBarAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ShowSnackBarAction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ShowSnackBarAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ShowSnackBarAction parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ShowSnackBarAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ShowSnackBarAction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ShowSnackBarAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static MessagingStruct$ShowSnackBarAction parseFrom(InputStream inputStream) {
        return (MessagingStruct$ShowSnackBarAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ShowSnackBarAction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ShowSnackBarAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ShowSnackBarAction parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ShowSnackBarAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MessagingStruct$ShowSnackBarAction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ShowSnackBarAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ShowSnackBarAction parseFrom(byte[] bArr) {
        return (MessagingStruct$ShowSnackBarAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ShowSnackBarAction parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ShowSnackBarAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}

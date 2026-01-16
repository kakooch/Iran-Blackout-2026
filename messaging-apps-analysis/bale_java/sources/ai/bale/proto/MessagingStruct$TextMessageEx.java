package ai.bale.proto;

import ai.bale.proto.MessagingStruct$TextCommand;
import ai.bale.proto.MessagingStruct$TextExMarkdown;
import ai.bale.proto.MessagingStruct$TextLinkPreview;
import ai.bale.proto.MessagingStruct$TextModernMessage;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$TextMessageEx extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$TextMessageEx DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TEXT_COMMAND_FIELD_NUMBER = 1;
    public static final int TEXT_EX_MARKDOWN_FIELD_NUMBER = 2;
    public static final int TEXT_LINK_PREVIEW_FIELD_NUMBER = 4;
    public static final int TEXT_MODERN_MESSAGE_FIELD_NUMBER = 3;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$TextMessageEx.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        TEXT_COMMAND(1),
        TEXT_EX_MARKDOWN(2),
        TEXT_MODERN_MESSAGE(3),
        TEXT_LINK_PREVIEW(4),
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
                return TEXT_COMMAND;
            }
            if (i == 2) {
                return TEXT_EX_MARKDOWN;
            }
            if (i == 3) {
                return TEXT_MODERN_MESSAGE;
            }
            if (i != 4) {
                return null;
            }
            return TEXT_LINK_PREVIEW;
        }
    }

    static {
        MessagingStruct$TextMessageEx messagingStruct$TextMessageEx = new MessagingStruct$TextMessageEx();
        DEFAULT_INSTANCE = messagingStruct$TextMessageEx;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$TextMessageEx.class, messagingStruct$TextMessageEx);
    }

    private MessagingStruct$TextMessageEx() {
    }

    private void clearTextCommand() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTextExMarkdown() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTextLinkPreview() {
        if (this.traitCase_ == 4) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTextModernMessage() {
        if (this.traitCase_ == 3) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static MessagingStruct$TextMessageEx getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTextCommand(MessagingStruct$TextCommand messagingStruct$TextCommand) {
        messagingStruct$TextCommand.getClass();
        if (this.traitCase_ != 1 || this.trait_ == MessagingStruct$TextCommand.getDefaultInstance()) {
            this.trait_ = messagingStruct$TextCommand;
        } else {
            this.trait_ = ((MessagingStruct$TextCommand.a) MessagingStruct$TextCommand.newBuilder((MessagingStruct$TextCommand) this.trait_).v(messagingStruct$TextCommand)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergeTextExMarkdown(MessagingStruct$TextExMarkdown messagingStruct$TextExMarkdown) {
        messagingStruct$TextExMarkdown.getClass();
        if (this.traitCase_ != 2 || this.trait_ == MessagingStruct$TextExMarkdown.getDefaultInstance()) {
            this.trait_ = messagingStruct$TextExMarkdown;
        } else {
            this.trait_ = ((MessagingStruct$TextExMarkdown.a) MessagingStruct$TextExMarkdown.newBuilder((MessagingStruct$TextExMarkdown) this.trait_).v(messagingStruct$TextExMarkdown)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergeTextLinkPreview(MessagingStruct$TextLinkPreview messagingStruct$TextLinkPreview) {
        messagingStruct$TextLinkPreview.getClass();
        if (this.traitCase_ != 4 || this.trait_ == MessagingStruct$TextLinkPreview.getDefaultInstance()) {
            this.trait_ = messagingStruct$TextLinkPreview;
        } else {
            this.trait_ = ((MessagingStruct$TextLinkPreview.a) MessagingStruct$TextLinkPreview.newBuilder((MessagingStruct$TextLinkPreview) this.trait_).v(messagingStruct$TextLinkPreview)).j();
        }
        this.traitCase_ = 4;
    }

    private void mergeTextModernMessage(MessagingStruct$TextModernMessage messagingStruct$TextModernMessage) {
        messagingStruct$TextModernMessage.getClass();
        if (this.traitCase_ != 3 || this.trait_ == MessagingStruct$TextModernMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$TextModernMessage;
        } else {
            this.trait_ = ((MessagingStruct$TextModernMessage.a) MessagingStruct$TextModernMessage.newBuilder((MessagingStruct$TextModernMessage) this.trait_).v(messagingStruct$TextModernMessage)).j();
        }
        this.traitCase_ = 3;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$TextMessageEx parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$TextMessageEx) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TextMessageEx parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$TextMessageEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setTextCommand(MessagingStruct$TextCommand messagingStruct$TextCommand) {
        messagingStruct$TextCommand.getClass();
        this.trait_ = messagingStruct$TextCommand;
        this.traitCase_ = 1;
    }

    private void setTextExMarkdown(MessagingStruct$TextExMarkdown messagingStruct$TextExMarkdown) {
        messagingStruct$TextExMarkdown.getClass();
        this.trait_ = messagingStruct$TextExMarkdown;
        this.traitCase_ = 2;
    }

    private void setTextLinkPreview(MessagingStruct$TextLinkPreview messagingStruct$TextLinkPreview) {
        messagingStruct$TextLinkPreview.getClass();
        this.trait_ = messagingStruct$TextLinkPreview;
        this.traitCase_ = 4;
    }

    private void setTextModernMessage(MessagingStruct$TextModernMessage messagingStruct$TextModernMessage) {
        messagingStruct$TextModernMessage.getClass();
        this.trait_ = messagingStruct$TextModernMessage;
        this.traitCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$TextMessageEx();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000", new Object[]{"trait_", "traitCase_", MessagingStruct$TextCommand.class, MessagingStruct$TextExMarkdown.class, MessagingStruct$TextModernMessage.class, MessagingStruct$TextLinkPreview.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$TextMessageEx.class) {
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

    public MessagingStruct$TextCommand getTextCommand() {
        return this.traitCase_ == 1 ? (MessagingStruct$TextCommand) this.trait_ : MessagingStruct$TextCommand.getDefaultInstance();
    }

    public MessagingStruct$TextExMarkdown getTextExMarkdown() {
        return this.traitCase_ == 2 ? (MessagingStruct$TextExMarkdown) this.trait_ : MessagingStruct$TextExMarkdown.getDefaultInstance();
    }

    public MessagingStruct$TextLinkPreview getTextLinkPreview() {
        return this.traitCase_ == 4 ? (MessagingStruct$TextLinkPreview) this.trait_ : MessagingStruct$TextLinkPreview.getDefaultInstance();
    }

    public MessagingStruct$TextModernMessage getTextModernMessage() {
        return this.traitCase_ == 3 ? (MessagingStruct$TextModernMessage) this.trait_ : MessagingStruct$TextModernMessage.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasTextCommand() {
        return this.traitCase_ == 1;
    }

    public boolean hasTextExMarkdown() {
        return this.traitCase_ == 2;
    }

    public boolean hasTextLinkPreview() {
        return this.traitCase_ == 4;
    }

    public boolean hasTextModernMessage() {
        return this.traitCase_ == 3;
    }

    public static a newBuilder(MessagingStruct$TextMessageEx messagingStruct$TextMessageEx) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$TextMessageEx);
    }

    public static MessagingStruct$TextMessageEx parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TextMessageEx) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TextMessageEx parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$TextMessageEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$TextMessageEx parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$TextMessageEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$TextMessageEx parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$TextMessageEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$TextMessageEx parseFrom(byte[] bArr) {
        return (MessagingStruct$TextMessageEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$TextMessageEx parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$TextMessageEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$TextMessageEx parseFrom(InputStream inputStream) {
        return (MessagingStruct$TextMessageEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TextMessageEx parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TextMessageEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TextMessageEx parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$TextMessageEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$TextMessageEx parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$TextMessageEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

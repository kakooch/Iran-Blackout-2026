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
public final class MessagingStruct$SwitchInlineQueryChosenChat extends GeneratedMessageLite implements U64 {
    public static final int ALLOW_BOT_CHATS_FIELD_NUMBER = 3;
    public static final int ALLOW_CHANNEL_CHATS_FIELD_NUMBER = 5;
    public static final int ALLOW_GROUP_CHATS_FIELD_NUMBER = 4;
    public static final int ALLOW_USER_CHATS_FIELD_NUMBER = 2;
    private static final MessagingStruct$SwitchInlineQueryChosenChat DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 1;
    private boolean allowBotChats_;
    private boolean allowChannelChats_;
    private boolean allowGroupChats_;
    private boolean allowUserChats_;
    private String query_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$SwitchInlineQueryChosenChat.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$SwitchInlineQueryChosenChat messagingStruct$SwitchInlineQueryChosenChat = new MessagingStruct$SwitchInlineQueryChosenChat();
        DEFAULT_INSTANCE = messagingStruct$SwitchInlineQueryChosenChat;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$SwitchInlineQueryChosenChat.class, messagingStruct$SwitchInlineQueryChosenChat);
    }

    private MessagingStruct$SwitchInlineQueryChosenChat() {
    }

    private void clearAllowBotChats() {
        this.allowBotChats_ = false;
    }

    private void clearAllowChannelChats() {
        this.allowChannelChats_ = false;
    }

    private void clearAllowGroupChats() {
        this.allowGroupChats_ = false;
    }

    private void clearAllowUserChats() {
        this.allowUserChats_ = false;
    }

    private void clearQuery() {
        this.query_ = getDefaultInstance().getQuery();
    }

    public static MessagingStruct$SwitchInlineQueryChosenChat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$SwitchInlineQueryChosenChat parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$SwitchInlineQueryChosenChat) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$SwitchInlineQueryChosenChat parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$SwitchInlineQueryChosenChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAllowBotChats(boolean z) {
        this.allowBotChats_ = z;
    }

    private void setAllowChannelChats(boolean z) {
        this.allowChannelChats_ = z;
    }

    private void setAllowGroupChats(boolean z) {
        this.allowGroupChats_ = z;
    }

    private void setAllowUserChats(boolean z) {
        this.allowUserChats_ = z;
    }

    private void setQuery(String str) {
        str.getClass();
        this.query_ = str;
    }

    private void setQueryBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.query_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$SwitchInlineQueryChosenChat();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\u0007\u0003\u0007\u0004\u0007\u0005\u0007", new Object[]{"query_", "allowUserChats_", "allowBotChats_", "allowGroupChats_", "allowChannelChats_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$SwitchInlineQueryChosenChat.class) {
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

    public boolean getAllowBotChats() {
        return this.allowBotChats_;
    }

    public boolean getAllowChannelChats() {
        return this.allowChannelChats_;
    }

    public boolean getAllowGroupChats() {
        return this.allowGroupChats_;
    }

    public boolean getAllowUserChats() {
        return this.allowUserChats_;
    }

    public String getQuery() {
        return this.query_;
    }

    public AbstractC2383g getQueryBytes() {
        return AbstractC2383g.N(this.query_);
    }

    public static a newBuilder(MessagingStruct$SwitchInlineQueryChosenChat messagingStruct$SwitchInlineQueryChosenChat) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$SwitchInlineQueryChosenChat);
    }

    public static MessagingStruct$SwitchInlineQueryChosenChat parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$SwitchInlineQueryChosenChat) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$SwitchInlineQueryChosenChat parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$SwitchInlineQueryChosenChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$SwitchInlineQueryChosenChat parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$SwitchInlineQueryChosenChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$SwitchInlineQueryChosenChat parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$SwitchInlineQueryChosenChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static MessagingStruct$SwitchInlineQueryChosenChat parseFrom(InputStream inputStream) {
        return (MessagingStruct$SwitchInlineQueryChosenChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$SwitchInlineQueryChosenChat parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$SwitchInlineQueryChosenChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$SwitchInlineQueryChosenChat parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$SwitchInlineQueryChosenChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MessagingStruct$SwitchInlineQueryChosenChat parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$SwitchInlineQueryChosenChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$SwitchInlineQueryChosenChat parseFrom(byte[] bArr) {
        return (MessagingStruct$SwitchInlineQueryChosenChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$SwitchInlineQueryChosenChat parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$SwitchInlineQueryChosenChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}

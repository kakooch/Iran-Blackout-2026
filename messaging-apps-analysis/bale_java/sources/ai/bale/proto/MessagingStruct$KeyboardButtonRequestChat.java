package ai.bale.proto;

import ai.bale.proto.MessagingStruct$ChatAdministratorRights;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$KeyboardButtonRequestChat extends GeneratedMessageLite implements U64 {
    public static final int BOT_ADMINISTRATOR_RIGHTS_FIELD_NUMBER = 7;
    public static final int BOT_IS_MEMBER_FIELD_NUMBER = 8;
    public static final int CHAT_HAS_USERNAME_FIELD_NUMBER = 4;
    public static final int CHAT_IS_CHANNEL_FIELD_NUMBER = 2;
    public static final int CHAT_IS_CREATED_FIELD_NUMBER = 5;
    public static final int CHAT_IS_FORUM_FIELD_NUMBER = 3;
    private static final MessagingStruct$KeyboardButtonRequestChat DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REQUEST_ID_FIELD_NUMBER = 1;
    public static final int USER_ADMINISTRATOR_RIGHTS_FIELD_NUMBER = 6;
    private int bitField0_;
    private MessagingStruct$ChatAdministratorRights botAdministratorRights_;
    private boolean botIsMember_;
    private boolean chatHasUsername_;
    private boolean chatIsChannel_;
    private boolean chatIsCreated_;
    private boolean chatIsForum_;
    private int requestId_;
    private MessagingStruct$ChatAdministratorRights userAdministratorRights_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$KeyboardButtonRequestChat.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$KeyboardButtonRequestChat messagingStruct$KeyboardButtonRequestChat = new MessagingStruct$KeyboardButtonRequestChat();
        DEFAULT_INSTANCE = messagingStruct$KeyboardButtonRequestChat;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$KeyboardButtonRequestChat.class, messagingStruct$KeyboardButtonRequestChat);
    }

    private MessagingStruct$KeyboardButtonRequestChat() {
    }

    private void clearBotAdministratorRights() {
        this.botAdministratorRights_ = null;
        this.bitField0_ &= -3;
    }

    private void clearBotIsMember() {
        this.botIsMember_ = false;
    }

    private void clearChatHasUsername() {
        this.chatHasUsername_ = false;
    }

    private void clearChatIsChannel() {
        this.chatIsChannel_ = false;
    }

    private void clearChatIsCreated() {
        this.chatIsCreated_ = false;
    }

    private void clearChatIsForum() {
        this.chatIsForum_ = false;
    }

    private void clearRequestId() {
        this.requestId_ = 0;
    }

    private void clearUserAdministratorRights() {
        this.userAdministratorRights_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$KeyboardButtonRequestChat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBotAdministratorRights(MessagingStruct$ChatAdministratorRights messagingStruct$ChatAdministratorRights) {
        messagingStruct$ChatAdministratorRights.getClass();
        MessagingStruct$ChatAdministratorRights messagingStruct$ChatAdministratorRights2 = this.botAdministratorRights_;
        if (messagingStruct$ChatAdministratorRights2 != null && messagingStruct$ChatAdministratorRights2 != MessagingStruct$ChatAdministratorRights.getDefaultInstance()) {
            messagingStruct$ChatAdministratorRights = (MessagingStruct$ChatAdministratorRights) ((MessagingStruct$ChatAdministratorRights.a) MessagingStruct$ChatAdministratorRights.newBuilder(this.botAdministratorRights_).v(messagingStruct$ChatAdministratorRights)).j();
        }
        this.botAdministratorRights_ = messagingStruct$ChatAdministratorRights;
        this.bitField0_ |= 2;
    }

    private void mergeUserAdministratorRights(MessagingStruct$ChatAdministratorRights messagingStruct$ChatAdministratorRights) {
        messagingStruct$ChatAdministratorRights.getClass();
        MessagingStruct$ChatAdministratorRights messagingStruct$ChatAdministratorRights2 = this.userAdministratorRights_;
        if (messagingStruct$ChatAdministratorRights2 != null && messagingStruct$ChatAdministratorRights2 != MessagingStruct$ChatAdministratorRights.getDefaultInstance()) {
            messagingStruct$ChatAdministratorRights = (MessagingStruct$ChatAdministratorRights) ((MessagingStruct$ChatAdministratorRights.a) MessagingStruct$ChatAdministratorRights.newBuilder(this.userAdministratorRights_).v(messagingStruct$ChatAdministratorRights)).j();
        }
        this.userAdministratorRights_ = messagingStruct$ChatAdministratorRights;
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$KeyboardButtonRequestChat parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$KeyboardButtonRequestChat) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$KeyboardButtonRequestChat parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$KeyboardButtonRequestChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotAdministratorRights(MessagingStruct$ChatAdministratorRights messagingStruct$ChatAdministratorRights) {
        messagingStruct$ChatAdministratorRights.getClass();
        this.botAdministratorRights_ = messagingStruct$ChatAdministratorRights;
        this.bitField0_ |= 2;
    }

    private void setBotIsMember(boolean z) {
        this.botIsMember_ = z;
    }

    private void setChatHasUsername(boolean z) {
        this.chatHasUsername_ = z;
    }

    private void setChatIsChannel(boolean z) {
        this.chatIsChannel_ = z;
    }

    private void setChatIsCreated(boolean z) {
        this.chatIsCreated_ = z;
    }

    private void setChatIsForum(boolean z) {
        this.chatIsForum_ = z;
    }

    private void setRequestId(int i) {
        this.requestId_ = i;
    }

    private void setUserAdministratorRights(MessagingStruct$ChatAdministratorRights messagingStruct$ChatAdministratorRights) {
        messagingStruct$ChatAdministratorRights.getClass();
        this.userAdministratorRights_ = messagingStruct$ChatAdministratorRights;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$KeyboardButtonRequestChat();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u0004\u0002\u0007\u0003\u0007\u0004\u0007\u0005\u0007\u0006ဉ\u0000\u0007ဉ\u0001\b\u0007", new Object[]{"bitField0_", "requestId_", "chatIsChannel_", "chatIsForum_", "chatHasUsername_", "chatIsCreated_", "userAdministratorRights_", "botAdministratorRights_", "botIsMember_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$KeyboardButtonRequestChat.class) {
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

    public MessagingStruct$ChatAdministratorRights getBotAdministratorRights() {
        MessagingStruct$ChatAdministratorRights messagingStruct$ChatAdministratorRights = this.botAdministratorRights_;
        return messagingStruct$ChatAdministratorRights == null ? MessagingStruct$ChatAdministratorRights.getDefaultInstance() : messagingStruct$ChatAdministratorRights;
    }

    public boolean getBotIsMember() {
        return this.botIsMember_;
    }

    public boolean getChatHasUsername() {
        return this.chatHasUsername_;
    }

    public boolean getChatIsChannel() {
        return this.chatIsChannel_;
    }

    public boolean getChatIsCreated() {
        return this.chatIsCreated_;
    }

    public boolean getChatIsForum() {
        return this.chatIsForum_;
    }

    public int getRequestId() {
        return this.requestId_;
    }

    public MessagingStruct$ChatAdministratorRights getUserAdministratorRights() {
        MessagingStruct$ChatAdministratorRights messagingStruct$ChatAdministratorRights = this.userAdministratorRights_;
        return messagingStruct$ChatAdministratorRights == null ? MessagingStruct$ChatAdministratorRights.getDefaultInstance() : messagingStruct$ChatAdministratorRights;
    }

    public boolean hasBotAdministratorRights() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasUserAdministratorRights() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$KeyboardButtonRequestChat messagingStruct$KeyboardButtonRequestChat) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$KeyboardButtonRequestChat);
    }

    public static MessagingStruct$KeyboardButtonRequestChat parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$KeyboardButtonRequestChat) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$KeyboardButtonRequestChat parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$KeyboardButtonRequestChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$KeyboardButtonRequestChat parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$KeyboardButtonRequestChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$KeyboardButtonRequestChat parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$KeyboardButtonRequestChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static MessagingStruct$KeyboardButtonRequestChat parseFrom(InputStream inputStream) {
        return (MessagingStruct$KeyboardButtonRequestChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$KeyboardButtonRequestChat parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$KeyboardButtonRequestChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$KeyboardButtonRequestChat parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$KeyboardButtonRequestChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MessagingStruct$KeyboardButtonRequestChat parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$KeyboardButtonRequestChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$KeyboardButtonRequestChat parseFrom(byte[] bArr) {
        return (MessagingStruct$KeyboardButtonRequestChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$KeyboardButtonRequestChat parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$KeyboardButtonRequestChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}

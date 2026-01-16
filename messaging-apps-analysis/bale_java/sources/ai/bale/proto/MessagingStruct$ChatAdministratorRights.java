package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$ChatAdministratorRights extends GeneratedMessageLite implements U64 {
    public static final int CAN_CHANGE_INFO_FIELD_NUMBER = 7;
    public static final int CAN_DELETE_MESSAGES_FIELD_NUMBER = 3;
    public static final int CAN_EDIT_MESSAGES_FIELD_NUMBER = 10;
    public static final int CAN_INVITE_USERS_FIELD_NUMBER = 8;
    public static final int CAN_MANAGE_CHAT_FIELD_NUMBER = 2;
    public static final int CAN_MANAGE_TOPICS_FIELD_NUMBER = 12;
    public static final int CAN_MANAGE_VIDEO_CHATS_FIELD_NUMBER = 4;
    public static final int CAN_PIN_MESSAGES_FIELD_NUMBER = 11;
    public static final int CAN_POST_MESSAGES_FIELD_NUMBER = 9;
    public static final int CAN_PROMOTE_MEMBERS_FIELD_NUMBER = 6;
    public static final int CAN_RESTRICT_MEMBERS_FIELD_NUMBER = 5;
    private static final MessagingStruct$ChatAdministratorRights DEFAULT_INSTANCE;
    public static final int IS_ANONYMOUS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private boolean canChangeInfo_;
    private boolean canDeleteMessages_;
    private boolean canEditMessages_;
    private boolean canInviteUsers_;
    private boolean canManageChat_;
    private boolean canManageTopics_;
    private boolean canManageVideoChats_;
    private boolean canPinMessages_;
    private boolean canPostMessages_;
    private boolean canPromoteMembers_;
    private boolean canRestrictMembers_;
    private boolean isAnonymous_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ChatAdministratorRights.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ChatAdministratorRights messagingStruct$ChatAdministratorRights = new MessagingStruct$ChatAdministratorRights();
        DEFAULT_INSTANCE = messagingStruct$ChatAdministratorRights;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ChatAdministratorRights.class, messagingStruct$ChatAdministratorRights);
    }

    private MessagingStruct$ChatAdministratorRights() {
    }

    private void clearCanChangeInfo() {
        this.canChangeInfo_ = false;
    }

    private void clearCanDeleteMessages() {
        this.canDeleteMessages_ = false;
    }

    private void clearCanEditMessages() {
        this.canEditMessages_ = false;
    }

    private void clearCanInviteUsers() {
        this.canInviteUsers_ = false;
    }

    private void clearCanManageChat() {
        this.canManageChat_ = false;
    }

    private void clearCanManageTopics() {
        this.canManageTopics_ = false;
    }

    private void clearCanManageVideoChats() {
        this.canManageVideoChats_ = false;
    }

    private void clearCanPinMessages() {
        this.canPinMessages_ = false;
    }

    private void clearCanPostMessages() {
        this.canPostMessages_ = false;
    }

    private void clearCanPromoteMembers() {
        this.canPromoteMembers_ = false;
    }

    private void clearCanRestrictMembers() {
        this.canRestrictMembers_ = false;
    }

    private void clearIsAnonymous() {
        this.isAnonymous_ = false;
    }

    public static MessagingStruct$ChatAdministratorRights getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ChatAdministratorRights parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ChatAdministratorRights) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ChatAdministratorRights parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ChatAdministratorRights) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCanChangeInfo(boolean z) {
        this.canChangeInfo_ = z;
    }

    private void setCanDeleteMessages(boolean z) {
        this.canDeleteMessages_ = z;
    }

    private void setCanEditMessages(boolean z) {
        this.canEditMessages_ = z;
    }

    private void setCanInviteUsers(boolean z) {
        this.canInviteUsers_ = z;
    }

    private void setCanManageChat(boolean z) {
        this.canManageChat_ = z;
    }

    private void setCanManageTopics(boolean z) {
        this.canManageTopics_ = z;
    }

    private void setCanManageVideoChats(boolean z) {
        this.canManageVideoChats_ = z;
    }

    private void setCanPinMessages(boolean z) {
        this.canPinMessages_ = z;
    }

    private void setCanPostMessages(boolean z) {
        this.canPostMessages_ = z;
    }

    private void setCanPromoteMembers(boolean z) {
        this.canPromoteMembers_ = z;
    }

    private void setCanRestrictMembers(boolean z) {
        this.canRestrictMembers_ = z;
    }

    private void setIsAnonymous(boolean z) {
        this.isAnonymous_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ChatAdministratorRights();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\f\u0000\u0000\u0001\f\f\u0000\u0000\u0000\u0001\u0007\u0002\u0007\u0003\u0007\u0004\u0007\u0005\u0007\u0006\u0007\u0007\u0007\b\u0007\t\u0007\n\u0007\u000b\u0007\f\u0007", new Object[]{"isAnonymous_", "canManageChat_", "canDeleteMessages_", "canManageVideoChats_", "canRestrictMembers_", "canPromoteMembers_", "canChangeInfo_", "canInviteUsers_", "canPostMessages_", "canEditMessages_", "canPinMessages_", "canManageTopics_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ChatAdministratorRights.class) {
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

    public boolean getCanChangeInfo() {
        return this.canChangeInfo_;
    }

    public boolean getCanDeleteMessages() {
        return this.canDeleteMessages_;
    }

    public boolean getCanEditMessages() {
        return this.canEditMessages_;
    }

    public boolean getCanInviteUsers() {
        return this.canInviteUsers_;
    }

    public boolean getCanManageChat() {
        return this.canManageChat_;
    }

    public boolean getCanManageTopics() {
        return this.canManageTopics_;
    }

    public boolean getCanManageVideoChats() {
        return this.canManageVideoChats_;
    }

    public boolean getCanPinMessages() {
        return this.canPinMessages_;
    }

    public boolean getCanPostMessages() {
        return this.canPostMessages_;
    }

    public boolean getCanPromoteMembers() {
        return this.canPromoteMembers_;
    }

    public boolean getCanRestrictMembers() {
        return this.canRestrictMembers_;
    }

    public boolean getIsAnonymous() {
        return this.isAnonymous_;
    }

    public static a newBuilder(MessagingStruct$ChatAdministratorRights messagingStruct$ChatAdministratorRights) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ChatAdministratorRights);
    }

    public static MessagingStruct$ChatAdministratorRights parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ChatAdministratorRights) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ChatAdministratorRights parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ChatAdministratorRights) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ChatAdministratorRights parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ChatAdministratorRights) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ChatAdministratorRights parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ChatAdministratorRights) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static MessagingStruct$ChatAdministratorRights parseFrom(InputStream inputStream) {
        return (MessagingStruct$ChatAdministratorRights) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ChatAdministratorRights parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ChatAdministratorRights) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ChatAdministratorRights parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ChatAdministratorRights) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MessagingStruct$ChatAdministratorRights parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ChatAdministratorRights) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ChatAdministratorRights parseFrom(byte[] bArr) {
        return (MessagingStruct$ChatAdministratorRights) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ChatAdministratorRights parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ChatAdministratorRights) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}

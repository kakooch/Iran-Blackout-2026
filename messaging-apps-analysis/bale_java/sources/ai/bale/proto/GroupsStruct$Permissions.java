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
public final class GroupsStruct$Permissions extends GeneratedMessageLite implements U64 {
    public static final int ADD_ADMIN_FIELD_NUMBER = 6;
    public static final int ADD_STORY_FIELD_NUMBER = 19;
    public static final int CHANGE_INFO_FIELD_NUMBER = 7;
    private static final GroupsStruct$Permissions DEFAULT_INSTANCE;
    public static final int DELETE_MESSAGE_FIELD_NUMBER = 2;
    public static final int EDIT_MESSAGE_FIELD_NUMBER = 10;
    public static final int FORWARD_MESSAGE_FROM_FIELD_NUMBER = 14;
    public static final int INVITE_USER_FIELD_NUMBER = 5;
    public static final int KICK_USER_FIELD_NUMBER = 3;
    public static final int MANAGE_CALL_FIELD_NUMBER = 20;
    private static volatile KW4 PARSER = null;
    public static final int PIN_MESSAGE_FIELD_NUMBER = 4;
    public static final int REPLY_TO_STORY_FIELD_NUMBER = 13;
    public static final int SEE_MEMBERS_FIELD_NUMBER = 9;
    public static final int SEE_MESSAGE_FIELD_NUMBER = 1;
    public static final int SEND_FORWARDED_MESSAGE_FIELD_NUMBER = 18;
    public static final int SEND_GIFT_PACKET_FIELD_NUMBER = 15;
    public static final int SEND_GIF_STICKERS_FIELD_NUMBER = 12;
    public static final int SEND_LINK_MESSAGE_FIELD_NUMBER = 17;
    public static final int SEND_MEDIA_FIELD_NUMBER = 11;
    public static final int SEND_MESSAGE_FIELD_NUMBER = 8;
    public static final int START_CALL_FIELD_NUMBER = 16;
    private boolean addAdmin_;
    private BoolValue addStory_;
    private int bitField0_;
    private boolean changeInfo_;
    private boolean deleteMessage_;
    private boolean editMessage_;
    private BoolValue forwardMessageFrom_;
    private boolean inviteUser_;
    private boolean kickUser_;
    private BoolValue manageCall_;
    private boolean pinMessage_;
    private BoolValue replyToStory_;
    private boolean seeMembers_;
    private boolean seeMessage_;
    private BoolValue sendForwardedMessage_;
    private BoolValue sendGifStickers_;
    private BoolValue sendGiftPacket_;
    private BoolValue sendLinkMessage_;
    private BoolValue sendMedia_;
    private boolean sendMessage_;
    private BoolValue startCall_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(boolean z) {
            q();
            ((GroupsStruct$Permissions) this.b).setAddAdmin(z);
            return this;
        }

        public a B(BoolValue boolValue) {
            q();
            ((GroupsStruct$Permissions) this.b).setAddStory(boolValue);
            return this;
        }

        public a C(boolean z) {
            q();
            ((GroupsStruct$Permissions) this.b).setChangeInfo(z);
            return this;
        }

        public a D(boolean z) {
            q();
            ((GroupsStruct$Permissions) this.b).setDeleteMessage(z);
            return this;
        }

        public a E(boolean z) {
            q();
            ((GroupsStruct$Permissions) this.b).setEditMessage(z);
            return this;
        }

        public a F(BoolValue boolValue) {
            q();
            ((GroupsStruct$Permissions) this.b).setForwardMessageFrom(boolValue);
            return this;
        }

        public a G(boolean z) {
            q();
            ((GroupsStruct$Permissions) this.b).setInviteUser(z);
            return this;
        }

        public a H(boolean z) {
            q();
            ((GroupsStruct$Permissions) this.b).setKickUser(z);
            return this;
        }

        public a I(BoolValue boolValue) {
            q();
            ((GroupsStruct$Permissions) this.b).setManageCall(boolValue);
            return this;
        }

        public a J(boolean z) {
            q();
            ((GroupsStruct$Permissions) this.b).setPinMessage(z);
            return this;
        }

        public a K(BoolValue boolValue) {
            q();
            ((GroupsStruct$Permissions) this.b).setReplyToStory(boolValue);
            return this;
        }

        public a L(boolean z) {
            q();
            ((GroupsStruct$Permissions) this.b).setSeeMembers(z);
            return this;
        }

        public a M(boolean z) {
            q();
            ((GroupsStruct$Permissions) this.b).setSeeMessage(z);
            return this;
        }

        public a N(BoolValue boolValue) {
            q();
            ((GroupsStruct$Permissions) this.b).setSendForwardedMessage(boolValue);
            return this;
        }

        public a O(BoolValue boolValue) {
            q();
            ((GroupsStruct$Permissions) this.b).setSendGifStickers(boolValue);
            return this;
        }

        public a Q(BoolValue boolValue) {
            q();
            ((GroupsStruct$Permissions) this.b).setSendGiftPacket(boolValue);
            return this;
        }

        public a R(BoolValue boolValue) {
            q();
            ((GroupsStruct$Permissions) this.b).setSendLinkMessage(boolValue);
            return this;
        }

        public a T(BoolValue boolValue) {
            q();
            ((GroupsStruct$Permissions) this.b).setSendMedia(boolValue);
            return this;
        }

        public a U(boolean z) {
            q();
            ((GroupsStruct$Permissions) this.b).setSendMessage(z);
            return this;
        }

        public a V(BoolValue boolValue) {
            q();
            ((GroupsStruct$Permissions) this.b).setStartCall(boolValue);
            return this;
        }

        private a() {
            super(GroupsStruct$Permissions.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsStruct$Permissions groupsStruct$Permissions = new GroupsStruct$Permissions();
        DEFAULT_INSTANCE = groupsStruct$Permissions;
        GeneratedMessageLite.registerDefaultInstance(GroupsStruct$Permissions.class, groupsStruct$Permissions);
    }

    private GroupsStruct$Permissions() {
    }

    private void clearAddAdmin() {
        this.addAdmin_ = false;
    }

    private void clearAddStory() {
        this.addStory_ = null;
        this.bitField0_ &= -257;
    }

    private void clearChangeInfo() {
        this.changeInfo_ = false;
    }

    private void clearDeleteMessage() {
        this.deleteMessage_ = false;
    }

    private void clearEditMessage() {
        this.editMessage_ = false;
    }

    private void clearForwardMessageFrom() {
        this.forwardMessageFrom_ = null;
        this.bitField0_ &= -9;
    }

    private void clearInviteUser() {
        this.inviteUser_ = false;
    }

    private void clearKickUser() {
        this.kickUser_ = false;
    }

    private void clearManageCall() {
        this.manageCall_ = null;
        this.bitField0_ &= -513;
    }

    private void clearPinMessage() {
        this.pinMessage_ = false;
    }

    private void clearReplyToStory() {
        this.replyToStory_ = null;
        this.bitField0_ &= -5;
    }

    private void clearSeeMembers() {
        this.seeMembers_ = false;
    }

    private void clearSeeMessage() {
        this.seeMessage_ = false;
    }

    private void clearSendForwardedMessage() {
        this.sendForwardedMessage_ = null;
        this.bitField0_ &= -129;
    }

    private void clearSendGifStickers() {
        this.sendGifStickers_ = null;
        this.bitField0_ &= -3;
    }

    private void clearSendGiftPacket() {
        this.sendGiftPacket_ = null;
        this.bitField0_ &= -17;
    }

    private void clearSendLinkMessage() {
        this.sendLinkMessage_ = null;
        this.bitField0_ &= -65;
    }

    private void clearSendMedia() {
        this.sendMedia_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSendMessage() {
        this.sendMessage_ = false;
    }

    private void clearStartCall() {
        this.startCall_ = null;
        this.bitField0_ &= -33;
    }

    public static GroupsStruct$Permissions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAddStory(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.addStory_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.addStory_ = boolValue;
        } else {
            this.addStory_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.addStory_).v(boolValue)).j();
        }
        this.bitField0_ |= 256;
    }

    private void mergeForwardMessageFrom(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.forwardMessageFrom_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.forwardMessageFrom_ = boolValue;
        } else {
            this.forwardMessageFrom_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.forwardMessageFrom_).v(boolValue)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeManageCall(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.manageCall_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.manageCall_ = boolValue;
        } else {
            this.manageCall_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.manageCall_).v(boolValue)).j();
        }
        this.bitField0_ |= 512;
    }

    private void mergeReplyToStory(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.replyToStory_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.replyToStory_ = boolValue;
        } else {
            this.replyToStory_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.replyToStory_).v(boolValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeSendForwardedMessage(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.sendForwardedMessage_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.sendForwardedMessage_ = boolValue;
        } else {
            this.sendForwardedMessage_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.sendForwardedMessage_).v(boolValue)).j();
        }
        this.bitField0_ |= 128;
    }

    private void mergeSendGifStickers(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.sendGifStickers_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.sendGifStickers_ = boolValue;
        } else {
            this.sendGifStickers_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.sendGifStickers_).v(boolValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeSendGiftPacket(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.sendGiftPacket_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.sendGiftPacket_ = boolValue;
        } else {
            this.sendGiftPacket_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.sendGiftPacket_).v(boolValue)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeSendLinkMessage(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.sendLinkMessage_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.sendLinkMessage_ = boolValue;
        } else {
            this.sendLinkMessage_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.sendLinkMessage_).v(boolValue)).j();
        }
        this.bitField0_ |= 64;
    }

    private void mergeSendMedia(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.sendMedia_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.sendMedia_ = boolValue;
        } else {
            this.sendMedia_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.sendMedia_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeStartCall(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.startCall_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.startCall_ = boolValue;
        } else {
            this.startCall_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.startCall_).v(boolValue)).j();
        }
        this.bitField0_ |= 32;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsStruct$Permissions parseDelimitedFrom(InputStream inputStream) {
        return (GroupsStruct$Permissions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$Permissions parseFrom(ByteBuffer byteBuffer) {
        return (GroupsStruct$Permissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddAdmin(boolean z) {
        this.addAdmin_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddStory(BoolValue boolValue) {
        boolValue.getClass();
        this.addStory_ = boolValue;
        this.bitField0_ |= 256;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChangeInfo(boolean z) {
        this.changeInfo_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeleteMessage(boolean z) {
        this.deleteMessage_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEditMessage(boolean z) {
        this.editMessage_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setForwardMessageFrom(BoolValue boolValue) {
        boolValue.getClass();
        this.forwardMessageFrom_ = boolValue;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInviteUser(boolean z) {
        this.inviteUser_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKickUser(boolean z) {
        this.kickUser_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setManageCall(BoolValue boolValue) {
        boolValue.getClass();
        this.manageCall_ = boolValue;
        this.bitField0_ |= 512;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPinMessage(boolean z) {
        this.pinMessage_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReplyToStory(BoolValue boolValue) {
        boolValue.getClass();
        this.replyToStory_ = boolValue;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeeMembers(boolean z) {
        this.seeMembers_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeeMessage(boolean z) {
        this.seeMessage_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSendForwardedMessage(BoolValue boolValue) {
        boolValue.getClass();
        this.sendForwardedMessage_ = boolValue;
        this.bitField0_ |= 128;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSendGifStickers(BoolValue boolValue) {
        boolValue.getClass();
        this.sendGifStickers_ = boolValue;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSendGiftPacket(BoolValue boolValue) {
        boolValue.getClass();
        this.sendGiftPacket_ = boolValue;
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSendLinkMessage(BoolValue boolValue) {
        boolValue.getClass();
        this.sendLinkMessage_ = boolValue;
        this.bitField0_ |= 64;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSendMedia(BoolValue boolValue) {
        boolValue.getClass();
        this.sendMedia_ = boolValue;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSendMessage(boolean z) {
        this.sendMessage_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartCall(BoolValue boolValue) {
        boolValue.getClass();
        this.startCall_ = boolValue;
        this.bitField0_ |= 32;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1877n0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsStruct$Permissions();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0014\u0000\u0001\u0001\u0014\u0014\u0000\u0000\u0000\u0001\u0007\u0002\u0007\u0003\u0007\u0004\u0007\u0005\u0007\u0006\u0007\u0007\u0007\b\u0007\t\u0007\n\u0007\u000bဉ\u0000\fဉ\u0001\rဉ\u0002\u000eဉ\u0003\u000fဉ\u0004\u0010ဉ\u0005\u0011ဉ\u0006\u0012ဉ\u0007\u0013ဉ\b\u0014ဉ\t", new Object[]{"bitField0_", "seeMessage_", "deleteMessage_", "kickUser_", "pinMessage_", "inviteUser_", "addAdmin_", "changeInfo_", "sendMessage_", "seeMembers_", "editMessage_", "sendMedia_", "sendGifStickers_", "replyToStory_", "forwardMessageFrom_", "sendGiftPacket_", "startCall_", "sendLinkMessage_", "sendForwardedMessage_", "addStory_", "manageCall_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsStruct$Permissions.class) {
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

    public boolean getAddAdmin() {
        return this.addAdmin_;
    }

    public BoolValue getAddStory() {
        BoolValue boolValue = this.addStory_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public boolean getChangeInfo() {
        return this.changeInfo_;
    }

    public boolean getDeleteMessage() {
        return this.deleteMessage_;
    }

    public boolean getEditMessage() {
        return this.editMessage_;
    }

    public BoolValue getForwardMessageFrom() {
        BoolValue boolValue = this.forwardMessageFrom_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public boolean getInviteUser() {
        return this.inviteUser_;
    }

    public boolean getKickUser() {
        return this.kickUser_;
    }

    public BoolValue getManageCall() {
        BoolValue boolValue = this.manageCall_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public boolean getPinMessage() {
        return this.pinMessage_;
    }

    public BoolValue getReplyToStory() {
        BoolValue boolValue = this.replyToStory_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public boolean getSeeMembers() {
        return this.seeMembers_;
    }

    public boolean getSeeMessage() {
        return this.seeMessage_;
    }

    public BoolValue getSendForwardedMessage() {
        BoolValue boolValue = this.sendForwardedMessage_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getSendGifStickers() {
        BoolValue boolValue = this.sendGifStickers_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getSendGiftPacket() {
        BoolValue boolValue = this.sendGiftPacket_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getSendLinkMessage() {
        BoolValue boolValue = this.sendLinkMessage_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getSendMedia() {
        BoolValue boolValue = this.sendMedia_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public boolean getSendMessage() {
        return this.sendMessage_;
    }

    public BoolValue getStartCall() {
        BoolValue boolValue = this.startCall_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public boolean hasAddStory() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasForwardMessageFrom() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasManageCall() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasReplyToStory() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasSendForwardedMessage() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasSendGifStickers() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSendGiftPacket() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasSendLinkMessage() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasSendMedia() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasStartCall() {
        return (this.bitField0_ & 32) != 0;
    }

    public static a newBuilder(GroupsStruct$Permissions groupsStruct$Permissions) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsStruct$Permissions);
    }

    public static GroupsStruct$Permissions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$Permissions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$Permissions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsStruct$Permissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsStruct$Permissions parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsStruct$Permissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsStruct$Permissions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsStruct$Permissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsStruct$Permissions parseFrom(byte[] bArr) {
        return (GroupsStruct$Permissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsStruct$Permissions parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsStruct$Permissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsStruct$Permissions parseFrom(InputStream inputStream) {
        return (GroupsStruct$Permissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$Permissions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$Permissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$Permissions parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsStruct$Permissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsStruct$Permissions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsStruct$Permissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}

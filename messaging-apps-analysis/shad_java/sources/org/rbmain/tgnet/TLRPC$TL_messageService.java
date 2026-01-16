package org.rbmain.tgnet;

import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.MessagesController;

/* loaded from: classes4.dex */
public class TLRPC$TL_messageService extends TLRPC$Message {
    public static int constructor = 721967202;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.out = (int32 & 2) != 0;
        this.mentioned = (int32 & 16) != 0;
        this.media_unread = (int32 & 32) != 0;
        this.silent = (int32 & 8192) != 0;
        this.post = (int32 & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0;
        this.legacy = (int32 & MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM) != 0;
        this.id = abstractSerializedData.readInt32(z);
        if ((this.flags & 256) != 0) {
            this.from_id = TLRPC$Peer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        if ((this.flags & 8) != 0) {
            this.reply_to = TLRPC$TL_messageReplyHeader.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        this.date = abstractSerializedData.readInt32(z);
        this.action = TLRPC$MessageAction.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
            this.ttl_period = abstractSerializedData.readInt32(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.out ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        int i2 = this.mentioned ? i | 16 : i & (-17);
        this.flags = i2;
        int i3 = this.media_unread ? i2 | 32 : i2 & (-33);
        this.flags = i3;
        int i4 = this.silent ? i3 | 8192 : i3 & (-8193);
        this.flags = i4;
        int i5 = this.post ? i4 | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM : i4 & (-16385);
        this.flags = i5;
        int i6 = this.legacy ? i5 | MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM : i5 & (-524289);
        this.flags = i6;
        abstractSerializedData.writeInt32(i6);
        abstractSerializedData.writeInt32((int) this.id);
        if ((this.flags & 256) != 0) {
            this.from_id.serializeToStream(abstractSerializedData);
        }
        this.peer_id.serializeToStream(abstractSerializedData);
        if ((this.flags & 8) != 0) {
            this.reply_to.serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(this.date);
        this.action.serializeToStream(abstractSerializedData);
        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
            abstractSerializedData.writeInt32(this.ttl_period);
        }
    }
}

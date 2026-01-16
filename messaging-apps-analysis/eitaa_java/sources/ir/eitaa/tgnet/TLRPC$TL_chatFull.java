package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_chatFull extends TLRPC$ChatFull {
    public static int constructor = 1304281241;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.can_set_username = (int32 & 128) != 0;
        this.has_scheduled = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
        this.id = stream.readInt64(exception);
        this.about = stream.readString(exception);
        this.participants = TLRPC$ChatParticipants.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 4) != 0) {
            this.chat_photo = TLRPC$Photo.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 8192) != 0) {
            this.exported_invite = TLRPC$ExportedChatInvite.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 8) != 0) {
            int int322 = stream.readInt32(exception);
            if (int322 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = stream.readInt32(exception);
            for (int i = 0; i < int323; i++) {
                TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$BotInfoTLdeserialize == null) {
                    return;
                }
                this.bot_info.add(tLRPC$BotInfoTLdeserialize);
            }
        }
        if ((this.flags & 64) != 0) {
            this.pinned_msg_id = stream.readInt32(exception);
        }
        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            this.folder_id = stream.readInt32(exception);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 16384) != 0) {
            this.ttl_period = stream.readInt32(exception);
        }
        if ((this.flags & 32768) != 0) {
            this.groupcall_default_join_as = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 65536) != 0) {
            this.theme_emoticon = stream.readString(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.can_set_username ? this.flags | 128 : this.flags & (-129);
        this.flags = i;
        int i2 = this.has_scheduled ? i | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i & (-257);
        this.flags = i2;
        stream.writeInt32(i2);
        stream.writeInt64(this.id);
        stream.writeString(this.about);
        this.participants.serializeToStream(stream);
        if ((this.flags & 4) != 0) {
            this.chat_photo.serializeToStream(stream);
        }
        this.notify_settings.serializeToStream(stream);
        if ((this.flags & 8192) != 0) {
            this.exported_invite.serializeToStream(stream);
        }
        if ((this.flags & 8) != 0) {
            stream.writeInt32(481674261);
            int size = this.bot_info.size();
            stream.writeInt32(size);
            for (int i3 = 0; i3 < size; i3++) {
                this.bot_info.get(i3).serializeToStream(stream);
            }
        }
        if ((this.flags & 64) != 0) {
            stream.writeInt32(this.pinned_msg_id);
        }
        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            stream.writeInt32(this.folder_id);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
            this.call.serializeToStream(stream);
        }
        if ((this.flags & 16384) != 0) {
            stream.writeInt32(this.ttl_period);
        }
        if ((this.flags & 32768) != 0) {
            this.groupcall_default_join_as.serializeToStream(stream);
        }
        if ((this.flags & 65536) != 0) {
            stream.writeString(this.theme_emoticon);
        }
    }
}

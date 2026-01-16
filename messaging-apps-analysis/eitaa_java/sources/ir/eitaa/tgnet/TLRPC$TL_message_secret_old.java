package ir.eitaa.tgnet;

import android.text.TextUtils;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_message_secret_old extends TLRPC$TL_message_secret {
    public static int constructor = 1431655928;

    @Override // ir.eitaa.tgnet.TLRPC$TL_message_secret, ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception) | Factory.DEVICE_HAS_CRAPPY_OPENSLES | Factory.DEVICE_USE_ANDROID_CAMCORDER;
        this.flags = int32;
        this.unread = (int32 & 1) != 0;
        this.out = (int32 & 2) != 0;
        this.mentioned = (int32 & 16) != 0;
        this.media_unread = (int32 & 32) != 0;
        this.id = stream.readInt32(exception);
        this.ttl = stream.readInt32(exception);
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        this.from_id = tLRPC$TL_peerUser;
        tLRPC$TL_peerUser.user_id = stream.readInt32(exception);
        this.peer_id = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.date = stream.readInt32(exception);
        this.message = stream.readString(exception);
        TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.media = tLRPC$MessageMediaTLdeserialize;
        if (tLRPC$MessageMediaTLdeserialize == null || TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
            return;
        }
        this.message = this.media.captionLegacy;
    }

    @Override // ir.eitaa.tgnet.TLRPC$TL_message_secret, ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.unread ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.out ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
        this.flags = i3;
        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
        this.flags = i4;
        stream.writeInt32(i4);
        stream.writeInt32(this.id);
        stream.writeInt32(this.ttl);
        stream.writeInt32((int) this.from_id.user_id);
        this.peer_id.serializeToStream(stream);
        stream.writeInt32(this.date);
        stream.writeString(this.message);
        this.media.serializeToStream(stream);
        writeAttachPath(stream);
    }
}

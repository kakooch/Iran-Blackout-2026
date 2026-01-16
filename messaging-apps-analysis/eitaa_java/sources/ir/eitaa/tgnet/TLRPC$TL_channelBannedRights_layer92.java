package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_channelBannedRights_layer92 extends TLObject {
    public static int constructor = 1489977929;
    public boolean embed_links;
    public int flags;
    public boolean send_forwarded_messages;
    public boolean send_games;
    public boolean send_gifs;
    public boolean send_inline;
    public boolean send_media;
    public boolean send_messages;
    public boolean send_stickers;
    public int until_date;
    public boolean view_messages;
    public boolean view_participants;

    public static TLRPC$TL_channelBannedRights_layer92 TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_channelBannedRights_layer92", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_channelBannedRights_layer92 tLRPC$TL_channelBannedRights_layer92 = new TLRPC$TL_channelBannedRights_layer92();
        tLRPC$TL_channelBannedRights_layer92.readParams(stream, exception);
        return tLRPC$TL_channelBannedRights_layer92;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.view_messages = (int32 & 1) != 0;
        this.send_messages = (int32 & 2) != 0;
        this.send_media = (int32 & 4) != 0;
        this.send_stickers = (int32 & 8) != 0;
        this.send_gifs = (int32 & 16) != 0;
        this.send_games = (int32 & 32) != 0;
        this.send_inline = (int32 & 64) != 0;
        this.embed_links = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
        this.send_forwarded_messages = (int32 & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
        this.view_participants = (int32 & 8192) != 0;
        this.until_date = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.view_messages ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.send_messages ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.send_media ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        int i4 = this.send_stickers ? i3 | 8 : i3 & (-9);
        this.flags = i4;
        int i5 = this.send_gifs ? i4 | 16 : i4 & (-17);
        this.flags = i5;
        int i6 = this.send_games ? i5 | 32 : i5 & (-33);
        this.flags = i6;
        int i7 = this.send_inline ? i6 | 64 : i6 & (-65);
        this.flags = i7;
        int i8 = this.embed_links ? i7 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i7 & (-4097);
        this.flags = i8;
        int i9 = this.send_forwarded_messages ? i8 | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i8 & (-2049);
        this.flags = i9;
        int i10 = this.view_participants ? i9 | 8192 : i9 & (-8193);
        this.flags = i10;
        stream.writeInt32(i10);
        stream.writeInt32(this.until_date);
    }
}

package ir.eitaa.tgnet;

import java.util.ArrayList;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_sendMultiMedia extends TLObject {
    public static int constructor = -872345397;
    public boolean background;
    public boolean clear_draft;
    public int flags;
    public ArrayList<TLRPC$TL_inputSingleMedia> multi_media = new ArrayList<>();
    public TLRPC$InputPeer peer;
    public int reply_to_msg_id;
    public int schedule_date;
    public boolean silent;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.silent ? this.flags | 32 : this.flags & (-33);
        this.flags = i;
        int i2 = this.background ? i | 64 : i & (-65);
        this.flags = i2;
        int i3 = this.clear_draft ? i2 | 128 : i2 & (-129);
        this.flags = i3;
        stream.writeInt32(i3);
        this.peer.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.reply_to_msg_id);
        }
        stream.writeInt32(481674261);
        int size = this.multi_media.size();
        stream.writeInt32(size);
        for (int i4 = 0; i4 < size; i4++) {
            this.multi_media.get(i4).serializeToStream(stream);
        }
        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
            stream.writeInt32(this.schedule_date);
        }
    }
}

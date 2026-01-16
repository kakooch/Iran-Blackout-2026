package ir.eitaa.tgnet;

import java.util.ArrayList;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_sendMessage extends TLObject {
    public static int constructor = 1376532592;
    public boolean background;
    public boolean clear_draft;
    public ArrayList<TLRPC$MessageEntity> entities = new ArrayList<>();
    public int flags;
    public String message;
    public boolean no_webpage;
    public TLRPC$InputPeer peer;
    public long random_id;
    public TLRPC$ReplyMarkup reply_markup;
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
        int i = this.no_webpage ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        int i2 = this.silent ? i | 32 : i & (-33);
        this.flags = i2;
        int i3 = this.background ? i2 | 64 : i2 & (-65);
        this.flags = i3;
        int i4 = this.clear_draft ? i3 | 128 : i3 & (-129);
        this.flags = i4;
        stream.writeInt32(i4);
        this.peer.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.reply_to_msg_id);
        }
        stream.writeString(this.message);
        stream.writeInt64(this.random_id);
        if ((this.flags & 4) != 0) {
            this.reply_markup.serializeToStream(stream);
        }
        if ((this.flags & 8) != 0) {
            stream.writeInt32(481674261);
            int size = this.entities.size();
            stream.writeInt32(size);
            for (int i5 = 0; i5 < size; i5++) {
                this.entities.get(i5).serializeToStream(stream);
            }
        }
        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
            stream.writeInt32(this.schedule_date);
        }
    }
}

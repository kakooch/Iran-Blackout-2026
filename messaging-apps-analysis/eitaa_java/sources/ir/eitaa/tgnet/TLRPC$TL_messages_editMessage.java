package ir.eitaa.tgnet;

import java.util.ArrayList;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_editMessage extends TLObject {
    public static int constructor = 1224152952;
    public ArrayList<TLRPC$MessageEntity> entities = new ArrayList<>();
    public int flags;
    public int id;
    public TLRPC$InputMedia media;
    public String message;
    public boolean no_webpage;
    public TLRPC$InputPeer peer;
    public TLRPC$ReplyMarkup reply_markup;
    public int schedule_date;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.no_webpage ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        stream.writeInt32(i);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.id);
        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            stream.writeString(this.message);
        }
        if ((this.flags & 16384) != 0) {
            this.media.serializeToStream(stream);
        }
        if ((this.flags & 4) != 0) {
            this.reply_markup.serializeToStream(stream);
        }
        if ((this.flags & 8) != 0) {
            stream.writeInt32(481674261);
            int size = this.entities.size();
            stream.writeInt32(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.entities.get(i2).serializeToStream(stream);
            }
        }
        if ((this.flags & 32768) != 0) {
            stream.writeInt32(this.schedule_date);
        }
    }
}

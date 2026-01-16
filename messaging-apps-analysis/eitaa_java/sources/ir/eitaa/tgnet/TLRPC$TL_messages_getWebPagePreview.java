package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_getWebPagePreview extends TLObject {
    public static int constructor = -1956073268;
    public ArrayList<TLRPC$MessageEntity> entities = new ArrayList<>();
    public int flags;
    public String message;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$MessageMedia.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeString(this.message);
        if ((this.flags & 8) != 0) {
            stream.writeInt32(481674261);
            int size = this.entities.size();
            stream.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.entities.get(i).serializeToStream(stream);
            }
        }
    }
}

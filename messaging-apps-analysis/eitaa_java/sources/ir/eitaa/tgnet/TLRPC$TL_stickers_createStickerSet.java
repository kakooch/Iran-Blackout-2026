package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_stickers_createStickerSet extends TLObject {
    public static int constructor = -1876841625;
    public boolean animated;
    public int flags;
    public boolean masks;
    public String short_name;
    public String software;
    public ArrayList<TLRPC$TL_inputStickerSetItem> stickers = new ArrayList<>();
    public TLRPC$InputDocument thumb;
    public String title;
    public TLRPC$InputUser user_id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_messages_stickerSet.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.masks ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.animated ? i | 2 : i & (-3);
        this.flags = i2;
        stream.writeInt32(i2);
        this.user_id.serializeToStream(stream);
        stream.writeString(this.title);
        stream.writeString(this.short_name);
        if ((this.flags & 4) != 0) {
            this.thumb.serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size = this.stickers.size();
        stream.writeInt32(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.stickers.get(i3).serializeToStream(stream);
        }
        if ((this.flags & 8) != 0) {
            stream.writeString(this.software);
        }
    }
}

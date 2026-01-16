package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_toggleStickerSets extends TLObject {
    public static int constructor = -1257951254;
    public boolean archive;
    public int flags;
    public ArrayList<TLRPC$InputStickerSet> stickersets = new ArrayList<>();
    public boolean unarchive;
    public boolean uninstall;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.uninstall ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.archive ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.unarchive ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        stream.writeInt32(i3);
        stream.writeInt32(481674261);
        int size = this.stickersets.size();
        stream.writeInt32(size);
        for (int i4 = 0; i4 < size; i4++) {
            this.stickersets.get(i4).serializeToStream(stream);
        }
    }
}

package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_wallPaperNoFile extends TLRPC$WallPaper {
    public static int constructor = -528465642;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readInt64(exception);
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.isDefault = (int32 & 2) != 0;
        this.dark = (int32 & 16) != 0;
        if ((int32 & 4) != 0) {
            this.settings = TLRPC$WallPaperSettings.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.id);
        int i = this.isDefault ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        int i2 = this.dark ? i | 16 : i & (-17);
        this.flags = i2;
        stream.writeInt32(i2);
        if ((this.flags & 4) != 0) {
            this.settings.serializeToStream(stream);
        }
    }
}

package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_wallPaperSettings extends TLRPC$WallPaperSettings {
    public static int constructor = 499236004;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.blur = (int32 & 2) != 0;
        this.motion = (int32 & 4) != 0;
        if ((int32 & 1) != 0) {
            this.background_color = stream.readInt32(exception);
        }
        if ((this.flags & 16) != 0) {
            this.second_background_color = stream.readInt32(exception);
        }
        if ((this.flags & 32) != 0) {
            this.third_background_color = stream.readInt32(exception);
        }
        if ((this.flags & 64) != 0) {
            this.fourth_background_color = stream.readInt32(exception);
        }
        if ((this.flags & 8) != 0) {
            this.intensity = stream.readInt32(exception);
        }
        if ((this.flags & 16) != 0) {
            this.rotation = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.blur ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        int i2 = this.motion ? i | 4 : i & (-5);
        this.flags = i2;
        stream.writeInt32(i2);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.background_color);
        }
        if ((this.flags & 16) != 0) {
            stream.writeInt32(this.second_background_color);
        }
        if ((this.flags & 32) != 0) {
            stream.writeInt32(this.third_background_color);
        }
        if ((this.flags & 64) != 0) {
            stream.writeInt32(this.fourth_background_color);
        }
        if ((this.flags & 8) != 0) {
            stream.writeInt32(this.intensity);
        }
        if ((this.flags & 16) != 0) {
            stream.writeInt32(this.rotation);
        }
    }
}

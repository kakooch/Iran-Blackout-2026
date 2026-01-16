package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_documentAttributeVideo extends TLRPC$DocumentAttribute {
    public static int constructor = 250621158;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.round_message = (int32 & 1) != 0;
        this.supports_streaming = (int32 & 2) != 0;
        this.duration = stream.readInt32(exception);
        this.w = stream.readInt32(exception);
        this.h = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.round_message ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.supports_streaming ? i | 2 : i & (-3);
        this.flags = i2;
        stream.writeInt32(i2);
        stream.writeInt32(this.duration);
        stream.writeInt32(this.w);
        stream.writeInt32(this.h);
    }
}

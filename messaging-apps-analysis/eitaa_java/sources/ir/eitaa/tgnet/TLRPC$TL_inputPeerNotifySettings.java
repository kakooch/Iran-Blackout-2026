package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputPeerNotifySettings extends TLObject {
    public static int constructor = -1673717362;
    public int flags;
    public int mute_until;
    public boolean show_previews;
    public boolean silent;
    public String sound;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.show_previews = stream.readBool(exception);
        }
        if ((this.flags & 2) != 0) {
            this.silent = stream.readBool(exception);
        }
        if ((this.flags & 4) != 0) {
            this.mute_until = stream.readInt32(exception);
        }
        if ((this.flags & 8) != 0) {
            this.sound = stream.readString(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeBool(this.show_previews);
        }
        if ((this.flags & 2) != 0) {
            stream.writeBool(this.silent);
        }
        if ((this.flags & 4) != 0) {
            stream.writeInt32(this.mute_until);
        }
        if ((this.flags & 8) != 0) {
            stream.writeString(this.sound);
        }
    }
}

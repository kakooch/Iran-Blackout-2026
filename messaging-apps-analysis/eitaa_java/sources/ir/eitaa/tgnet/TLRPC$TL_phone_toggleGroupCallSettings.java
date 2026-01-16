package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_toggleGroupCallSettings extends TLObject {
    public static int constructor = 1958458429;
    public TLRPC$TL_inputGroupCall call;
    public int flags;
    public boolean join_muted;
    public boolean reset_invite_hash;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.reset_invite_hash ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        stream.writeInt32(i);
        this.call.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            stream.writeBool(this.join_muted);
        }
    }
}

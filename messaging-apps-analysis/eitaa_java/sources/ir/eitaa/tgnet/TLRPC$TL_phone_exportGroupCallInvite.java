package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_exportGroupCallInvite extends TLObject {
    public static int constructor = -425040769;
    public TLRPC$TL_inputGroupCall call;
    public boolean can_self_unmute;
    public int flags;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_phone_exportedGroupCallInvite.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.can_self_unmute ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        this.call.serializeToStream(stream);
    }
}

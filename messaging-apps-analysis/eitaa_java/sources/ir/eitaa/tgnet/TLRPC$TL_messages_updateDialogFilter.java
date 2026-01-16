package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_updateDialogFilter extends TLObject {
    public static int constructor = 450142282;
    public TLRPC$TL_dialogFilter filter;
    public int flags;
    public int id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt32(this.id);
        if ((this.flags & 1) != 0) {
            this.filter.serializeToStream(stream);
        }
    }
}

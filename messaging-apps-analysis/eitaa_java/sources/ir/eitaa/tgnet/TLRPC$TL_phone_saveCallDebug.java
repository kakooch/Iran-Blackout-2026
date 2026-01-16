package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_saveCallDebug extends TLObject {
    public static int constructor = 662363518;
    public TLRPC$TL_dataJSON debug;
    public TLRPC$TL_inputPhoneCall peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        this.debug.serializeToStream(stream);
    }
}

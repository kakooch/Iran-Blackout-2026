package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_photos_updateProfilePhoto extends TLObject {
    public static int constructor = 1926525996;
    public TLRPC$InputPhoto id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_photos_photo.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.id.serializeToStream(stream);
    }
}

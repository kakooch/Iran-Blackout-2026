package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_getSavedGifs extends TLObject {
    public static int constructor = 1559270965;
    public long hash;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$messages_SavedGifs.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.hash);
    }
}

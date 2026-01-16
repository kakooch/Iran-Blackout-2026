package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputGeoPointEmpty extends TLRPC$InputGeoPoint {
    public static int constructor = -457104426;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}

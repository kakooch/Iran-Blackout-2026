package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputPhotoEmpty extends TLRPC$InputPhoto {
    public static int constructor = 483901197;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}

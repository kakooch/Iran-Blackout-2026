package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_LiveStreamStateInit extends TLRPC$LiveStreamState {
    public static int constructor = -1263446626;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}

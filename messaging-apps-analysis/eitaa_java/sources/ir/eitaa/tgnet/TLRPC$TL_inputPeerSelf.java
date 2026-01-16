package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputPeerSelf extends TLRPC$InputPeer {
    public static int constructor = 2107670217;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}

package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_peerNotifySettingsEmpty_layer77 extends TLRPC$PeerNotifySettings {
    public static int constructor = 1889961234;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}

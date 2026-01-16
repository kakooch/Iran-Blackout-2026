package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_sendMessageUploadAudioAction extends TLRPC$SendMessageAction {
    public static int constructor = -212740181;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.progress = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.progress);
    }
}

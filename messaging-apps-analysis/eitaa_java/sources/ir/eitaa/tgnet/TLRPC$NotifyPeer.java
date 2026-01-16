package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$NotifyPeer extends TLObject {
    public static TLRPC$NotifyPeer TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$NotifyPeer tLRPC$TL_notifyPeer;
        switch (constructor) {
            case -1613493288:
                tLRPC$TL_notifyPeer = new TLRPC$TL_notifyPeer();
                break;
            case -1261946036:
                tLRPC$TL_notifyPeer = new TLRPC$NotifyPeer() { // from class: ir.eitaa.tgnet.TLRPC$TL_notifyUsers
                    public static int constructor = -1261946036;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1073230141:
                tLRPC$TL_notifyPeer = new TLRPC$NotifyPeer() { // from class: ir.eitaa.tgnet.TLRPC$TL_notifyChats
                    public static int constructor = -1073230141;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -703403793:
                tLRPC$TL_notifyPeer = new TLRPC$NotifyPeer() { // from class: ir.eitaa.tgnet.TLRPC$TL_notifyBroadcasts
                    public static int constructor = -703403793;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            default:
                tLRPC$TL_notifyPeer = null;
                break;
        }
        if (tLRPC$TL_notifyPeer == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in NotifyPeer", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_notifyPeer != null) {
            tLRPC$TL_notifyPeer.readParams(stream, exception);
        }
        return tLRPC$TL_notifyPeer;
    }
}

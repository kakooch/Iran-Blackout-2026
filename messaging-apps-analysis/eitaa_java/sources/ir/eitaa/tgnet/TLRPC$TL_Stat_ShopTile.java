package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_Stat_ShopTile extends TLObject {
    public static int constructor = 762634149;
    public int categoryId;
    public int id;
    public TLRPC$InputPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.id);
        stream.writeInt32(this.categoryId);
    }
}

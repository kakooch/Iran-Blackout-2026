package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_setChatWallPaper extends TLObject {
    public static int constructor = -1879389471;
    public int flags;
    public long id;
    public TLRPC$InputPeer peer;
    public TLRPC$WallPaperSettings settings;
    public TLRPC$InputWallPaper wallpaper;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Updates.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        this.peer.serializeToStream(abstractSerializedData);
        if ((this.flags & 1) != 0) {
            this.wallpaper.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 4) != 0) {
            this.settings.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt64(this.id);
        }
    }
}

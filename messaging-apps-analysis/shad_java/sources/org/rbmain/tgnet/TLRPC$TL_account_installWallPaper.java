package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_account_installWallPaper extends TLObject {
    public static int constructor = -18000023;
    public TLRPC$TL_wallPaperSettings settings;
    public TLRPC$InputWallPaper wallpaper;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.wallpaper.serializeToStream(abstractSerializedData);
        this.settings.serializeToStream(abstractSerializedData);
    }
}

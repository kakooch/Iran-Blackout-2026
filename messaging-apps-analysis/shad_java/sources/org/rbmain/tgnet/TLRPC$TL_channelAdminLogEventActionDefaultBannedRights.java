package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_channelAdminLogEventActionDefaultBannedRights extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = 771095562;
    public TLRPC$TL_chatBannedRights new_banned_rights;
    public TLRPC$TL_chatBannedRights prev_banned_rights;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.prev_banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.new_banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.prev_banned_rights.serializeToStream(abstractSerializedData);
        this.new_banned_rights.serializeToStream(abstractSerializedData);
    }
}

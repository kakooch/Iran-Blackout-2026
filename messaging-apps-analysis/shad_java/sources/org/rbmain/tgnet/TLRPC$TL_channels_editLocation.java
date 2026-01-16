package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_channels_editLocation extends TLObject {
    public static int constructor = 1491484525;
    public String address;
    public TLRPC$InputChannel channel;
    public TLRPC$InputGeoPoint geo_point;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.channel.serializeToStream(abstractSerializedData);
        this.geo_point.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeString(this.address);
    }
}

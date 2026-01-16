package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$ChannelLocation extends TLObject {
    public static TLRPC$ChannelLocation TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$ChannelLocation tLRPC$TL_channelLocation;
        if (constructor == -1078612597) {
            tLRPC$TL_channelLocation = new TLRPC$ChannelLocation() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelLocationEmpty
                public static int constructor = -1078612597;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$TL_channelLocation = constructor != 547062491 ? null : new TLRPC$TL_channelLocation();
        }
        if (tLRPC$TL_channelLocation == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in ChannelLocation", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_channelLocation != null) {
            tLRPC$TL_channelLocation.readParams(stream, exception);
        }
        return tLRPC$TL_channelLocation;
    }
}

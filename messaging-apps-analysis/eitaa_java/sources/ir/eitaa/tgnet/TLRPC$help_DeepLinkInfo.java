package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$help_DeepLinkInfo extends TLObject {
    public static TLRPC$help_DeepLinkInfo TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$help_DeepLinkInfo tLRPC$TL_help_deepLinkInfo;
        if (constructor == 1722786150) {
            tLRPC$TL_help_deepLinkInfo = new TLRPC$help_DeepLinkInfo() { // from class: ir.eitaa.tgnet.TLRPC$TL_help_deepLinkInfoEmpty
                public static int constructor = 1722786150;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$TL_help_deepLinkInfo = constructor != 1783556146 ? null : new TLRPC$TL_help_deepLinkInfo();
        }
        if (tLRPC$TL_help_deepLinkInfo == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in help_DeepLinkInfo", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_help_deepLinkInfo != null) {
            tLRPC$TL_help_deepLinkInfo.readParams(stream, exception);
        }
        return tLRPC$TL_help_deepLinkInfo;
    }
}

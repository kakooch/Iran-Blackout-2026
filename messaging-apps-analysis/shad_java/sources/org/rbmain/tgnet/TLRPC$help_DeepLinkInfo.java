package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$help_DeepLinkInfo extends TLObject {
    public static TLRPC$help_DeepLinkInfo TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$help_DeepLinkInfo tLRPC$TL_help_deepLinkInfo;
        if (i == 1722786150) {
            tLRPC$TL_help_deepLinkInfo = new TLRPC$help_DeepLinkInfo() { // from class: org.rbmain.tgnet.TLRPC$TL_help_deepLinkInfoEmpty
                public static int constructor = 1722786150;

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$TL_help_deepLinkInfo = i != 1783556146 ? null : new TLRPC$TL_help_deepLinkInfo();
        }
        if (tLRPC$TL_help_deepLinkInfo == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in help_DeepLinkInfo", Integer.valueOf(i)));
        }
        if (tLRPC$TL_help_deepLinkInfo != null) {
            tLRPC$TL_help_deepLinkInfo.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_help_deepLinkInfo;
    }
}

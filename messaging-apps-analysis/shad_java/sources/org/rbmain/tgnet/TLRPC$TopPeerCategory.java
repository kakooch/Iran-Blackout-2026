package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$TopPeerCategory extends TLObject {
    public static TLRPC$TopPeerCategory TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$TopPeerCategory tLRPC$TL_topPeerCategoryCorrespondents;
        switch (i) {
            case -1472172887:
                tLRPC$TL_topPeerCategoryCorrespondents = new TLRPC$TopPeerCategory() { // from class: org.rbmain.tgnet.TLRPC$TL_topPeerCategoryForwardUsers
                    public static int constructor = -1472172887;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case -1419371685:
                tLRPC$TL_topPeerCategoryCorrespondents = new TLRPC$TopPeerCategory() { // from class: org.rbmain.tgnet.TLRPC$TL_topPeerCategoryBotsPM
                    public static int constructor = -1419371685;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case -1122524854:
                tLRPC$TL_topPeerCategoryCorrespondents = new TLRPC$TopPeerCategory() { // from class: org.rbmain.tgnet.TLRPC$TL_topPeerCategoryGroups
                    public static int constructor = -1122524854;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case -68239120:
                tLRPC$TL_topPeerCategoryCorrespondents = new TLRPC$TopPeerCategory() { // from class: org.rbmain.tgnet.TLRPC$TL_topPeerCategoryForwardChats
                    public static int constructor = -68239120;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case 104314861:
                tLRPC$TL_topPeerCategoryCorrespondents = new TLRPC$TL_topPeerCategoryCorrespondents();
                break;
            case 344356834:
                tLRPC$TL_topPeerCategoryCorrespondents = new TLRPC$TL_topPeerCategoryBotsInline();
                break;
            case 371037736:
                tLRPC$TL_topPeerCategoryCorrespondents = new TLRPC$TopPeerCategory() { // from class: org.rbmain.tgnet.TLRPC$TL_topPeerCategoryChannels
                    public static int constructor = 371037736;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case 511092620:
                tLRPC$TL_topPeerCategoryCorrespondents = new TLRPC$TopPeerCategory() { // from class: org.rbmain.tgnet.TLRPC$TL_topPeerCategoryPhoneCalls
                    public static int constructor = 511092620;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            default:
                tLRPC$TL_topPeerCategoryCorrespondents = null;
                break;
        }
        if (tLRPC$TL_topPeerCategoryCorrespondents == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in TopPeerCategory", Integer.valueOf(i)));
        }
        if (tLRPC$TL_topPeerCategoryCorrespondents != null) {
            tLRPC$TL_topPeerCategoryCorrespondents.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_topPeerCategoryCorrespondents;
    }
}

package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$TopPeerCategory extends TLObject {
    public static TLRPC$TopPeerCategory TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$TopPeerCategory tLRPC$TL_topPeerCategoryCorrespondents;
        switch (constructor) {
            case -1472172887:
                tLRPC$TL_topPeerCategoryCorrespondents = new TLRPC$TopPeerCategory() { // from class: ir.eitaa.tgnet.TLRPC$TL_topPeerCategoryForwardUsers
                    public static int constructor = -1472172887;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1419371685:
                tLRPC$TL_topPeerCategoryCorrespondents = new TLRPC$TopPeerCategory() { // from class: ir.eitaa.tgnet.TLRPC$TL_topPeerCategoryBotsPM
                    public static int constructor = -1419371685;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1122524854:
                tLRPC$TL_topPeerCategoryCorrespondents = new TLRPC$TopPeerCategory() { // from class: ir.eitaa.tgnet.TLRPC$TL_topPeerCategoryGroups
                    public static int constructor = -1122524854;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -68239120:
                tLRPC$TL_topPeerCategoryCorrespondents = new TLRPC$TopPeerCategory() { // from class: ir.eitaa.tgnet.TLRPC$TL_topPeerCategoryForwardChats
                    public static int constructor = -68239120;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
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
                tLRPC$TL_topPeerCategoryCorrespondents = new TLRPC$TopPeerCategory() { // from class: ir.eitaa.tgnet.TLRPC$TL_topPeerCategoryChannels
                    public static int constructor = 371037736;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 511092620:
                tLRPC$TL_topPeerCategoryCorrespondents = new TLRPC$TopPeerCategory() { // from class: ir.eitaa.tgnet.TLRPC$TL_topPeerCategoryPhoneCalls
                    public static int constructor = 511092620;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            default:
                tLRPC$TL_topPeerCategoryCorrespondents = null;
                break;
        }
        if (tLRPC$TL_topPeerCategoryCorrespondents == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in TopPeerCategory", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_topPeerCategoryCorrespondents != null) {
            tLRPC$TL_topPeerCategoryCorrespondents.readParams(stream, exception);
        }
        return tLRPC$TL_topPeerCategoryCorrespondents;
    }
}

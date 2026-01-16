package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$PhotoSize extends TLObject {
    public byte[] bytes;
    public String filePath;
    public int h;
    public TLRPC$FileLocation location;
    public int size;
    public String type;
    public int w;

    public static TLRPC$PhotoSize TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$PhotoSize tLRPC$TL_photoPathSize;
        switch (i) {
            case -668906175:
                tLRPC$TL_photoPathSize = new TLRPC$TL_photoPathSize();
                break;
            case -525288402:
                tLRPC$TL_photoPathSize = new TLRPC$TL_photoStrippedSize();
                break;
            case -374917894:
                tLRPC$TL_photoPathSize = new TLRPC$TL_photoCachedSize();
                break;
            case 236446268:
                tLRPC$TL_photoPathSize = new TLRPC$TL_photoSizeEmpty();
                break;
            case 1520986705:
                tLRPC$TL_photoPathSize = new TLRPC$TL_photoSizeProgressive();
                break;
            case 2009052699:
                tLRPC$TL_photoPathSize = new TLRPC$TL_photoSize();
                break;
            default:
                tLRPC$TL_photoPathSize = null;
                break;
        }
        if (tLRPC$TL_photoPathSize == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in PhotoSize", Integer.valueOf(i)));
        }
        if (tLRPC$TL_photoPathSize != null) {
            tLRPC$TL_photoPathSize.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_photoPathSize;
    }
}

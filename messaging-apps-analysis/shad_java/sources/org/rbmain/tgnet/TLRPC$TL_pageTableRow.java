package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_pageTableRow extends TLObject {
    public static int constructor = -524237339;
    public ArrayList<TLRPC$TL_pageTableCell> cells = new ArrayList<>();

    public static TLRPC$TL_pageTableRow TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_pageTableRow", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_pageTableRow tLRPC$TL_pageTableRow = new TLRPC$TL_pageTableRow();
        tLRPC$TL_pageTableRow.readParams(abstractSerializedData, z);
        return tLRPC$TL_pageTableRow;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_pageTableCell tLRPC$TL_pageTableCellTLdeserialize = TLRPC$TL_pageTableCell.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$TL_pageTableCellTLdeserialize == null) {
                return;
            }
            this.cells.add(tLRPC$TL_pageTableCellTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(481674261);
        int size = this.cells.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.cells.get(i).serializeToStream(abstractSerializedData);
        }
    }
}

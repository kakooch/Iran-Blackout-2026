package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_pageBlockTable extends TLRPC$PageBlock {
    public static int constructor = -1085412734;
    public boolean bordered;
    public int flags;
    public ArrayList<TLRPC$TL_pageTableRow> rows = new ArrayList<>();
    public boolean striped;
    public TLRPC$RichText title;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.bordered = (int32 & 1) != 0;
        this.striped = (int32 & 2) != 0;
        this.title = TLRPC$RichText.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        int int322 = abstractSerializedData.readInt32(z);
        if (int322 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int323; i++) {
            TLRPC$TL_pageTableRow tLRPC$TL_pageTableRowTLdeserialize = TLRPC$TL_pageTableRow.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$TL_pageTableRowTLdeserialize == null) {
                return;
            }
            this.rows.add(tLRPC$TL_pageTableRowTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.bordered ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.striped ? i | 2 : i & (-3);
        this.flags = i2;
        abstractSerializedData.writeInt32(i2);
        this.title.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(481674261);
        int size = this.rows.size();
        abstractSerializedData.writeInt32(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.rows.get(i3).serializeToStream(abstractSerializedData);
        }
    }
}

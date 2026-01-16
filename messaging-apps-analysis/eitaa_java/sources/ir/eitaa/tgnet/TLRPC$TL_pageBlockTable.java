package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_pageBlockTable extends TLRPC$PageBlock {
    public static int constructor = -1085412734;
    public boolean bordered;
    public int flags;
    public ArrayList<TLRPC$TL_pageTableRow> rows = new ArrayList<>();
    public boolean striped;
    public TLRPC$RichText title;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.bordered = (int32 & 1) != 0;
        this.striped = (int32 & 2) != 0;
        this.title = TLRPC$RichText.TLdeserialize(stream, stream.readInt32(exception), exception);
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            TLRPC$TL_pageTableRow tLRPC$TL_pageTableRowTLdeserialize = TLRPC$TL_pageTableRow.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_pageTableRowTLdeserialize == null) {
                return;
            }
            this.rows.add(tLRPC$TL_pageTableRowTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.bordered ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.striped ? i | 2 : i & (-3);
        this.flags = i2;
        stream.writeInt32(i2);
        this.title.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.rows.size();
        stream.writeInt32(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.rows.get(i3).serializeToStream(stream);
        }
    }
}

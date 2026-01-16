package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_pageTableRow extends TLObject {
    public static int constructor = -524237339;
    public ArrayList<TLRPC$TL_pageTableCell> cells = new ArrayList<>();

    public static TLRPC$TL_pageTableRow TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_pageTableRow", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_pageTableRow tLRPC$TL_pageTableRow = new TLRPC$TL_pageTableRow();
        tLRPC$TL_pageTableRow.readParams(stream, exception);
        return tLRPC$TL_pageTableRow;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_pageTableCell tLRPC$TL_pageTableCellTLdeserialize = TLRPC$TL_pageTableCell.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_pageTableCellTLdeserialize == null) {
                return;
            }
            this.cells.add(tLRPC$TL_pageTableCellTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.cells.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.cells.get(i).serializeToStream(stream);
        }
    }
}

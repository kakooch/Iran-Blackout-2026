package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_pageTableCell extends TLObject {
    public static int constructor = 878078826;
    public boolean align_center;
    public boolean align_right;
    public int colspan;
    public int flags;
    public boolean header;
    public int rowspan;
    public TLRPC$RichText text;
    public boolean valign_bottom;
    public boolean valign_middle;

    public static TLRPC$TL_pageTableCell TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_pageTableCell", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_pageTableCell tLRPC$TL_pageTableCell = new TLRPC$TL_pageTableCell();
        tLRPC$TL_pageTableCell.readParams(stream, exception);
        return tLRPC$TL_pageTableCell;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.header = (int32 & 1) != 0;
        this.align_center = (int32 & 8) != 0;
        this.align_right = (int32 & 16) != 0;
        this.valign_middle = (int32 & 32) != 0;
        this.valign_bottom = (int32 & 64) != 0;
        if ((int32 & 128) != 0) {
            this.text = TLRPC$RichText.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 2) != 0) {
            this.colspan = stream.readInt32(exception);
        }
        if ((this.flags & 4) != 0) {
            this.rowspan = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.header ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.align_center ? i | 8 : i & (-9);
        this.flags = i2;
        int i3 = this.align_right ? i2 | 16 : i2 & (-17);
        this.flags = i3;
        int i4 = this.valign_middle ? i3 | 32 : i3 & (-33);
        this.flags = i4;
        int i5 = this.valign_bottom ? i4 | 64 : i4 & (-65);
        this.flags = i5;
        stream.writeInt32(i5);
        if ((this.flags & 128) != 0) {
            this.text.serializeToStream(stream);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.colspan);
        }
        if ((this.flags & 4) != 0) {
            stream.writeInt32(this.rowspan);
        }
    }
}

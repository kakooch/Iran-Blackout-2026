package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$VideoSize extends TLObject {
    public ArrayList<Integer> background_colors = new ArrayList<>();
    public int flags;
    public int h;
    public TLRPC$FileLocation location;
    public int size;
    public String type;
    public double video_start_ts;
    public int w;

    public static TLRPC$VideoSize TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$TL_videoSize tLRPC$TL_videoSize;
        if (i != -399391402) {
            tLRPC$TL_videoSize = i != 1130084743 ? null : new TLRPC$TL_videoSize() { // from class: org.rbmain.tgnet.TLRPC$TL_videoSize_layer115
                public static int constructor = 1130084743;

                @Override // org.rbmain.tgnet.TLRPC$TL_videoSize, org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    this.type = abstractSerializedData2.readString(z2);
                    this.location = TLRPC$FileLocation.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    this.w = abstractSerializedData2.readInt32(z2);
                    this.h = abstractSerializedData2.readInt32(z2);
                    this.size = abstractSerializedData2.readInt32(z2);
                }

                @Override // org.rbmain.tgnet.TLRPC$TL_videoSize, org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    abstractSerializedData2.writeString(this.type);
                    this.location.serializeToStream(abstractSerializedData2);
                    abstractSerializedData2.writeInt32(this.w);
                    abstractSerializedData2.writeInt32(this.h);
                    abstractSerializedData2.writeInt32(this.size);
                }
            };
        } else {
            tLRPC$TL_videoSize = new TLRPC$TL_videoSize();
        }
        if (tLRPC$TL_videoSize == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in VideoSize", Integer.valueOf(i)));
        }
        if (tLRPC$TL_videoSize != null) {
            tLRPC$TL_videoSize.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_videoSize;
    }
}

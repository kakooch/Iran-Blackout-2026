package org.rbmain.tgnet;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;

/* loaded from: classes4.dex */
public class TLRPC$TL_chatPhoto extends TLRPC$ChatPhoto {
    public static int constructor = 1200680453;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.has_video = (int32 & 1) != 0;
        this.photo_small = TLRPC$FileLocation.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.photo_big = TLRPC$FileLocation.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        if ((this.flags & 2) != 0) {
            this.stripped_thumb = abstractSerializedData.readByteArray(z);
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    this.strippedBitmap = new BitmapDrawable(ImageLoader.getStrippedPhotoBitmap(this.stripped_thumb, "b"));
                } catch (Throwable th) {
                    FileLog.e(th);
                }
            }
        }
        this.dc_id = abstractSerializedData.readInt32(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.has_video ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        this.photo_small.serializeToStream(abstractSerializedData);
        this.photo_big.serializeToStream(abstractSerializedData);
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeByteArray(this.stripped_thumb);
        }
        abstractSerializedData.writeInt32(this.dc_id);
    }
}

package org.rbmain.tgnet;

import android.graphics.Path;
import org.rbmain.messenger.SvgHelper;

/* loaded from: classes4.dex */
public class TLRPC$TL_photoPathSize extends TLRPC$PhotoSize {
    public static int constructor = -668906175;
    public Path svgPath;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.type = abstractSerializedData.readString(z);
        byte[] byteArray = abstractSerializedData.readByteArray(z);
        this.bytes = byteArray;
        this.h = 50;
        this.w = 50;
        this.svgPath = SvgHelper.doPath(SvgHelper.decompress(byteArray));
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.type);
        abstractSerializedData.writeByteArray(this.bytes);
    }
}

package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputReportReasonChildAbuse extends TLRPC$ReportReason {
    public static int constructor = -1376497949;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}

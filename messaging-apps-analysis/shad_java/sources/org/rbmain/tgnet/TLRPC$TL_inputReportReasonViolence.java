package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputReportReasonViolence extends TLRPC$ReportReason {
    public static int constructor = 505595789;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}

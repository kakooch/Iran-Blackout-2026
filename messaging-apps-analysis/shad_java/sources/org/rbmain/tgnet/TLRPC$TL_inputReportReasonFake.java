package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputReportReasonFake extends TLRPC$ReportReason {
    public static int constructor = -170010905;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}

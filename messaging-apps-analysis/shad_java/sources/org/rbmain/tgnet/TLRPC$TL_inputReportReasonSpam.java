package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputReportReasonSpam extends TLRPC$ReportReason {
    public static int constructor = 1490799288;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}

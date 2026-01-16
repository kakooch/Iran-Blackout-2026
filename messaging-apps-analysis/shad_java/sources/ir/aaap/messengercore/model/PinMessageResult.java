package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.api.SetPinMessageOutput;

/* loaded from: classes3.dex */
public class PinMessageResult {
    public SetPinMessageOutput.Status status;

    public enum Status {
        OK,
        AnotherMessagePinned
    }
}

package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.api.SendMessageOutput;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ForwardMessageResult {
    public ArrayList<Message> messages = new ArrayList<>();
    public ArrayList<Long> prevMessageIds = new ArrayList<>();
    public SendMessageOutput.SendMessageStatus status;
}

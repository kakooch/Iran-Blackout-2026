package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.Link;
import ir.aaap.messengercore.model.PaymentInfoObject;

/* loaded from: classes3.dex */
public class GetBarcodeActionOutput {
    public Input input;
    public Link link;
    public PaymentInfoObject payment_info;
    public Status status;
    public TypeActionEnum type_action;

    public static class Input {
        public String default_value;
        public String message;
        public String track_input;
        public Type type;

        public enum Type {
            Text,
            Numeric
        }
    }

    public enum PaymentInfoEnum {
        Link,
        Payment,
        GetInput
    }

    public enum Status {
        OK,
        Invalid
    }

    public enum TypeActionEnum {
        Link,
        Payment,
        GetInput
    }
}

package ir.aaap.messengercore.model;

/* loaded from: classes3.dex */
public class AuxDataObject {
    public String button_id;
    public String button_payment_token;
    public String payment_status;
    public PaymentStatusType payment_status_type;
    public String start_id;

    public enum PaymentStatusType {
        Check,
        Error
    }

    public AuxDataObject(String str) {
        this.button_id = str;
    }

    public AuxDataObject() {
    }
}

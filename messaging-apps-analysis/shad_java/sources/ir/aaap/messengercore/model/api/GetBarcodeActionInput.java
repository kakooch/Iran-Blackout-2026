package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class GetBarcodeActionInput {
    public String barcode;
    public String input_value;
    public String track_input;
    public String type;

    public GetBarcodeActionInput(String str, String str2, String str3, String str4) {
        this.type = str;
        this.barcode = str2;
        this.input_value = str3;
        this.track_input = str4;
    }
}

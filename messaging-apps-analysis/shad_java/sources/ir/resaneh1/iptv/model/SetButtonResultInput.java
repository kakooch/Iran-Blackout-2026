package ir.resaneh1.iptv.model;

import ir.aaap.messengercore.model.AuxDataObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SetButtonResultInput {
    public ButtonFileObject file;
    public ArrayList<String> list_value;
    public LocationObject location;
    public AuxDataObject.PaymentStatusType payment_status;
    public String track_id;
    public String values;

    public SetButtonResultInput(String str) {
        this.track_id = str;
    }
}

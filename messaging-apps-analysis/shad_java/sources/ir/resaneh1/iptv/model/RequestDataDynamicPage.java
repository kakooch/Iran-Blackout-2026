package ir.resaneh1.iptv.model;

import ir.aaap.messengercore.model.AuxDataObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class RequestDataDynamicPage {
    public ButtonFileObject file;
    public ArrayList<String> list_value;
    public LocationObject location;
    public AuxDataObject.PaymentStatusType payment_status;
    public long time;
    public String track_id;
    public TypeEnum type;
    public String values;

    public enum TypeEnum {
        Click,
        TextEdit,
        Button
    }

    public RequestDataDynamicPage(String str) {
        this.track_id = str;
    }

    public void setForTextEdit(String str) {
        this.type = TypeEnum.TextEdit;
        this.values = str;
    }

    public void setForClick() {
        this.type = TypeEnum.Click;
    }

    public void setForButton(SetButtonResultInput setButtonResultInput) {
        this.type = TypeEnum.Button;
        if (setButtonResultInput != null) {
            this.values = setButtonResultInput.values;
            this.list_value = setButtonResultInput.list_value;
            this.file = setButtonResultInput.file;
            this.payment_status = setButtonResultInput.payment_status;
            this.location = setButtonResultInput.location;
        }
    }

    public String getKey() {
        if (this.track_id == null || this.type == null) {
            return null;
        }
        return this.track_id + this.type.name();
    }
}

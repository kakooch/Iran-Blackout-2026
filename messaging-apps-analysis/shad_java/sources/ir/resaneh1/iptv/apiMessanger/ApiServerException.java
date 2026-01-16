package ir.resaneh1.iptv.apiMessanger;

import ir.resaneh1.iptv.model.MessangerOutput;

/* loaded from: classes3.dex */
public class ApiServerException extends Exception {
    public MessangerOutput.EnumStatus status;
    public MessangerOutput.EnumStatusDet status_det;

    public ApiServerException(MessangerOutput.EnumStatus enumStatus, MessangerOutput.EnumStatusDet enumStatusDet) {
        this.status = enumStatus;
        this.status_det = enumStatusDet;
    }
}

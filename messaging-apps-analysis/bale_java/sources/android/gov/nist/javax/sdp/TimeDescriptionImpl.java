package android.gov.nist.javax.sdp;

import android.gov.nist.javax.sdp.fields.RepeatField;
import android.gov.nist.javax.sdp.fields.TimeField;
import android.javax.sdp.SdpException;
import ir.nasim.InterfaceC10580bq7;
import java.io.Serializable;
import java.util.Vector;

/* loaded from: classes.dex */
public class TimeDescriptionImpl implements Serializable, Cloneable {
    private Vector repeatList;
    private TimeField timeImpl;

    public TimeDescriptionImpl() {
        this.timeImpl = new TimeField();
        this.repeatList = new Vector();
    }

    public void addRepeatField(RepeatField repeatField) {
        if (repeatField == null) {
            throw new NullPointerException("null repeatField");
        }
        this.repeatList.add(repeatField);
    }

    public Vector getRepeatTimes(boolean z) {
        return this.repeatList;
    }

    public InterfaceC10580bq7 getTime() {
        return this.timeImpl;
    }

    public void setRepeatTimes(Vector vector) {
        this.repeatList = vector;
    }

    public void setTime(InterfaceC10580bq7 interfaceC10580bq7) throws SdpException {
        if (interfaceC10580bq7 == null) {
            throw new SdpException("The parameter is null");
        }
        if (!(interfaceC10580bq7 instanceof TimeField)) {
            throw new SdpException("The parameter is not an instance of TimeField");
        }
        this.timeImpl = (TimeField) interfaceC10580bq7;
    }

    public String toString() {
        String strEncode = this.timeImpl.encode();
        for (int i = 0; i < this.repeatList.size(); i++) {
            strEncode = strEncode + ((RepeatField) this.repeatList.elementAt(i)).encode();
        }
        return strEncode;
    }

    public TimeDescriptionImpl(TimeField timeField) {
        this.timeImpl = timeField;
        this.repeatList = new Vector();
    }
}

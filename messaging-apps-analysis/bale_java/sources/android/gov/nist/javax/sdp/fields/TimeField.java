package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.Separators;
import android.javax.sdp.SdpException;
import ir.nasim.C25048ze6;
import ir.nasim.InterfaceC10580bq7;
import java.util.Date;

/* loaded from: classes.dex */
public class TimeField extends SDPField implements InterfaceC10580bq7 {
    protected long startTime;
    protected long stopTime;

    public TimeField() {
        super(SDPFieldNames.TIME_FIELD);
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPField, android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        return SDPFieldNames.TIME_FIELD + this.startTime + Separators.SP + this.stopTime + Separators.NEWLINE;
    }

    public Date getStart() {
        return C25048ze6.b(this.startTime);
    }

    public long getStartTime() {
        return this.startTime;
    }

    public Date getStop() {
        return C25048ze6.b(this.stopTime);
    }

    public long getStopTime() {
        return this.stopTime;
    }

    public boolean getTypedTime() {
        return false;
    }

    public boolean isZero() {
        return getStartTime() == 0 && getStopTime() == 0;
    }

    public void setStart(Date date) throws SdpException {
        if (date == null) {
            throw new SdpException("The date is null");
        }
        this.startTime = C25048ze6.d(date);
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public void setStop(Date date) throws SdpException {
        if (date == null) {
            throw new SdpException("The date is null");
        }
        this.stopTime = C25048ze6.d(date);
    }

    public void setStopTime(long j) {
        this.stopTime = j;
    }

    public void setTypedTime(boolean z) {
    }

    public void setZero() {
        setStopTime(0L);
        setStartTime(0L);
    }
}

package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC7510Sa2;

/* loaded from: classes.dex */
public class Event extends ParametersHeader implements InterfaceC7510Sa2 {
    private static final long serialVersionUID = -6458387810431874841L;
    protected String eventType;

    public Event() {
        super(SIPHeaderNames.EVENT);
    }

    public String encodeBody() {
        return encodeBody(new StringBuilder()).toString();
    }

    public String getEventId() {
        return getParameter("id");
    }

    public String getEventType() {
        return this.eventType;
    }

    public boolean match(Event event) {
        String str = event.eventType;
        if (str == null && this.eventType != null) {
            return false;
        }
        if (str != null && this.eventType == null) {
            return false;
        }
        if (this.eventType == null && str == null) {
            return false;
        }
        if (getEventId() == null && event.getEventId() != null) {
            return false;
        }
        if ((getEventId() == null || event.getEventId() != null) && event.eventType.equalsIgnoreCase(this.eventType)) {
            return getEventId() == event.getEventId() || getEventId().equalsIgnoreCase(event.getEventId());
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC7510Sa2
    public void setEventId(String str) {
        if (str == null) {
            throw new NullPointerException(" the eventId parameter is null");
        }
        setParameter("id", str);
    }

    @Override // ir.nasim.InterfaceC7510Sa2
    public void setEventType(String str) {
        if (str == null) {
            throw new NullPointerException(" the eventType is null");
        }
        this.eventType = str;
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        String str = this.eventType;
        if (str != null) {
            sb.append(str);
        }
        if (!this.parameters.isEmpty()) {
            sb.append(Separators.SEMICOLON);
            this.parameters.encode(sb);
        }
        return sb;
    }
}

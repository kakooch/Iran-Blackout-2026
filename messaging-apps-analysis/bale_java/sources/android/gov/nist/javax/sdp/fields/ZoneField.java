package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.GenericObject;
import android.gov.nist.core.Separators;
import android.javax.sdp.SdpException;
import ir.nasim.InterfaceC23330wk2;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class ZoneField extends SDPField implements InterfaceC23330wk2 {
    protected SDPObjectList zoneAdjustments;

    public ZoneField() {
        super(SDPFieldNames.ZONE_FIELD);
        this.zoneAdjustments = new SDPObjectList();
    }

    public void addZoneAdjustment(ZoneAdjustment zoneAdjustment) {
        this.zoneAdjustments.add((SDPObject) zoneAdjustment);
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        ZoneField zoneField = (ZoneField) super.clone();
        SDPObjectList sDPObjectList = this.zoneAdjustments;
        if (sDPObjectList != null) {
            zoneField.zoneAdjustments = (SDPObjectList) sDPObjectList.clone();
        }
        return zoneField;
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPField, android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        StringBuilder sb = new StringBuilder(SDPFieldNames.ZONE_FIELD);
        ListIterator<GenericObject> listIterator = this.zoneAdjustments.listIterator();
        int i = 0;
        while (listIterator.hasNext()) {
            ZoneAdjustment zoneAdjustment = (ZoneAdjustment) listIterator.next();
            if (i > 0) {
                sb.append(Separators.SP);
            }
            sb.append(zoneAdjustment.encode());
            i++;
        }
        sb.append(Separators.NEWLINE);
        return sb.toString();
    }

    public boolean getTypedTime() {
        return false;
    }

    public SDPObjectList getZoneAdjustments() {
        return this.zoneAdjustments;
    }

    public void setTypedTime(boolean z) {
    }

    public void setZoneAdjustments(Hashtable hashtable) throws SdpException {
        if (hashtable == null) {
            throw new SdpException("The map is null");
        }
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            Object objNextElement = enumerationKeys.nextElement();
            if (!(objNextElement instanceof Date)) {
                throw new SdpException("The map is not well-formated ");
            }
            ZoneAdjustment zoneAdjustment = new ZoneAdjustment();
            zoneAdjustment.setTime(((Date) objNextElement).getTime());
            addZoneAdjustment(zoneAdjustment);
        }
    }

    public Hashtable getZoneAdjustments(boolean z) throws NumberFormatException {
        Hashtable hashtable = new Hashtable();
        SDPObjectList zoneAdjustments = getZoneAdjustments();
        if (zoneAdjustments == null) {
            if (z) {
                return new Hashtable();
            }
            return null;
        }
        while (true) {
            ZoneAdjustment zoneAdjustment = (ZoneAdjustment) zoneAdjustments.next();
            if (zoneAdjustment == null) {
                return hashtable;
            }
            hashtable.put(new Date(zoneAdjustment.getTime()), Integer.valueOf(Long.valueOf(zoneAdjustment.getTime()).toString()));
        }
    }
}

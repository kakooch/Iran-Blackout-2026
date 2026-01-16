package ir.aaap.messengercore.model;

import ir.aaap.messengercore.utilites.Objects;

/* loaded from: classes3.dex */
public class ServiceInfo {
    public String description;
    public long insertedToDbTime;
    public String service_guid;
    public WarningObject warning_info;

    public static ServiceInfo createFromServerObject(ServiceInfoFromServer serviceInfoFromServer) {
        ServiceInfo serviceInfo = new ServiceInfo();
        serviceInfo.service_guid = serviceInfoFromServer.service_guid;
        serviceInfo.description = serviceInfoFromServer.description;
        serviceInfo.warning_info = serviceInfoFromServer.warning_info;
        return serviceInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ServiceInfo)) {
            return false;
        }
        ServiceInfo serviceInfo = (ServiceInfo) obj;
        return this.insertedToDbTime == serviceInfo.insertedToDbTime && Objects.equals(this.service_guid, serviceInfo.service_guid) && Objects.equals(this.description, serviceInfo.description) && Objects.equals(this.warning_info, serviceInfo.warning_info);
    }

    public int hashCode() {
        return Objects.hash(this.service_guid, this.description, this.warning_info, Long.valueOf(this.insertedToDbTime));
    }
}

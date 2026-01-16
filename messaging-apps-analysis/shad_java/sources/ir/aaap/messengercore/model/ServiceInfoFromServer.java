package ir.aaap.messengercore.model;

import ir.aaap.messengercore.utilites.Objects;

/* loaded from: classes3.dex */
public class ServiceInfoFromServer {
    public AvatarFileInline avatar_thumbnail;
    public String description;
    public boolean is_deleted;
    public boolean is_verified;
    public String service_guid;
    public String service_title;
    public WarningObject warning_info;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ServiceInfoFromServer)) {
            return false;
        }
        ServiceInfoFromServer serviceInfoFromServer = (ServiceInfoFromServer) obj;
        return this.is_deleted == serviceInfoFromServer.is_deleted && this.is_verified == serviceInfoFromServer.is_verified && Objects.equals(this.service_guid, serviceInfoFromServer.service_guid) && Objects.equals(this.service_title, serviceInfoFromServer.service_title) && Objects.equals(this.avatar_thumbnail, serviceInfoFromServer.avatar_thumbnail) && Objects.equals(this.description, serviceInfoFromServer.description) && Objects.equals(this.warning_info, serviceInfoFromServer.warning_info);
    }
}

package com.google.firebase.messaging;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.messaging.Constants;
import java.util.Map;
import org.json.JSONException;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
/* loaded from: classes3.dex */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new RemoteMessageCreator();
    Bundle bundle;
    private Map<String, String> data;
    private Notification notification;

    /* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
    public static class Notification {
        private final String body;
        private final String imageUrl;
        private final String title;

        private Notification(NotificationParams notificationParams) throws JSONException {
            this.title = notificationParams.getString("gcm.n.title");
            notificationParams.getLocalizationResourceForKey("gcm.n.title");
            getLocalizationArgs(notificationParams, "gcm.n.title");
            this.body = notificationParams.getString("gcm.n.body");
            notificationParams.getLocalizationResourceForKey("gcm.n.body");
            getLocalizationArgs(notificationParams, "gcm.n.body");
            notificationParams.getString("gcm.n.icon");
            notificationParams.getSoundResourceName();
            notificationParams.getString("gcm.n.tag");
            notificationParams.getString("gcm.n.color");
            notificationParams.getString("gcm.n.click_action");
            notificationParams.getString("gcm.n.android_channel_id");
            notificationParams.getLink();
            this.imageUrl = notificationParams.getString("gcm.n.image");
            notificationParams.getString("gcm.n.ticker");
            notificationParams.getInteger("gcm.n.notification_priority");
            notificationParams.getInteger("gcm.n.visibility");
            notificationParams.getInteger("gcm.n.notification_count");
            notificationParams.getBoolean("gcm.n.sticky");
            notificationParams.getBoolean("gcm.n.local_only");
            notificationParams.getBoolean("gcm.n.default_sound");
            notificationParams.getBoolean("gcm.n.default_vibrate_timings");
            notificationParams.getBoolean("gcm.n.default_light_settings");
            notificationParams.getLong("gcm.n.event_time");
            notificationParams.getLightSettings();
            notificationParams.getVibrateTimings();
        }

        private static String[] getLocalizationArgs(NotificationParams notificationParams, String str) {
            Object[] localizationArgsForKey = notificationParams.getLocalizationArgsForKey(str);
            if (localizationArgsForKey == null) {
                return null;
            }
            String[] strArr = new String[localizationArgsForKey.length];
            for (int i = 0; i < localizationArgsForKey.length; i++) {
                strArr[i] = String.valueOf(localizationArgsForKey[i]);
            }
            return strArr;
        }

        public String getBody() {
            return this.body;
        }

        public Uri getImageUrl() {
            String str = this.imageUrl;
            if (str != null) {
                return Uri.parse(str);
            }
            return null;
        }

        public String getTitle() {
            return this.title;
        }
    }

    public RemoteMessage(Bundle bundle) {
        this.bundle = bundle;
    }

    public Map<String, String> getData() {
        if (this.data == null) {
            this.data = Constants.MessagePayloadKeys.extractDeveloperDefinedPayload(this.bundle);
        }
        return this.data;
    }

    public String getFrom() {
        return this.bundle.getString("from");
    }

    public Notification getNotification() {
        if (this.notification == null && NotificationParams.isNotification(this.bundle)) {
            this.notification = new Notification(new NotificationParams(this.bundle));
        }
        return this.notification;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        RemoteMessageCreator.writeToParcel(this, parcel, i);
    }
}

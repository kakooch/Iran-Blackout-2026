package org.acra.legacy;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class LegacyFileHandler {
    private final Context context;
    private final SharedPreferences prefs;

    public LegacyFileHandler(Context context, SharedPreferences sharedPreferences) {
        this.context = context;
        this.prefs = sharedPreferences;
    }

    public void updateToCurrentVersionIfNecessary() {
        if (!this.prefs.getBoolean("acra.legacyAlreadyConvertedTo4.8.0", false)) {
            new ReportMigrator(this.context).migrate();
            this.prefs.edit().putBoolean("acra.legacyAlreadyConvertedTo4.8.0", true).apply();
        }
        if (this.prefs.getBoolean("acra.legacyAlreadyConvertedToJson", false)) {
            return;
        }
        new ReportConverter(this.context).convert();
        this.prefs.edit().putBoolean("acra.legacyAlreadyConvertedToJson", true).apply();
    }
}

package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import io.github.inflationx.calligraphy3.BuildConfig;
import j$.retarget.C$r8$retargetLibraryMember$virtualDispatch$Date$toInstant$dispatchHolder;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
class HeartBeatInfoStorage {
    private final SharedPreferences firebaseSharedPreferences;

    public HeartBeatInfoStorage(Context context, String str) {
        this.firebaseSharedPreferences = context.getSharedPreferences("FirebaseHeartBeat" + str, 0);
    }

    synchronized void deleteAllHeartBeats() {
        SharedPreferences.Editor editorEdit = this.firebaseSharedPreferences.edit();
        for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                editorEdit.remove(entry.getKey());
            }
        }
        editorEdit.remove("fire-count");
        editorEdit.commit();
    }

    synchronized List<HeartBeatResult> getAllHeartBeats() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                arrayList.add(HeartBeatResult.create(entry.getKey(), new ArrayList((Set) entry.getValue())));
            }
        }
        updateGlobalHeartBeat(System.currentTimeMillis());
        return arrayList;
    }

    private synchronized String getStoredUserAgentString(String str) {
        for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return entry.getKey();
                    }
                }
            }
        }
        return null;
    }

    private synchronized void updateStoredUserAgent(String str, String str2) {
        removeStoredDate(str2);
        HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(str, new HashSet()));
        hashSet.add(str2);
        this.firebaseSharedPreferences.edit().putStringSet(str, hashSet).commit();
    }

    private synchronized void removeStoredDate(String str) {
        String storedUserAgentString = getStoredUserAgentString(str);
        if (storedUserAgentString == null) {
            return;
        }
        HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(storedUserAgentString, new HashSet()));
        hashSet.remove(str);
        if (hashSet.isEmpty()) {
            this.firebaseSharedPreferences.edit().remove(storedUserAgentString).commit();
        } else {
            this.firebaseSharedPreferences.edit().putStringSet(storedUserAgentString, hashSet).commit();
        }
    }

    synchronized void postHeartBeatCleanUp() {
        String formattedDate = getFormattedDate(System.currentTimeMillis());
        this.firebaseSharedPreferences.edit().putString("last-used-date", formattedDate).commit();
        removeStoredDate(formattedDate);
    }

    private synchronized String getFormattedDate(long j) {
        if (Build.VERSION.SDK_INT >= 26) {
            return C$r8$retargetLibraryMember$virtualDispatch$Date$toInstant$dispatchHolder.toInstant(new Date(j)).atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j));
    }

    synchronized void storeHeartBeat(long j, String str) {
        String formattedDate = getFormattedDate(j);
        if (this.firebaseSharedPreferences.getString("last-used-date", BuildConfig.FLAVOR).equals(formattedDate)) {
            String storedUserAgentString = getStoredUserAgentString(formattedDate);
            if (storedUserAgentString == null) {
                return;
            }
            if (storedUserAgentString.equals(str)) {
                return;
            }
            updateStoredUserAgent(str, formattedDate);
            return;
        }
        long j2 = this.firebaseSharedPreferences.getLong("fire-count", 0L);
        if (j2 + 1 == 30) {
            cleanUpStoredHeartBeats();
            j2 = this.firebaseSharedPreferences.getLong("fire-count", 0L);
        }
        HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(str, new HashSet()));
        hashSet.add(formattedDate);
        this.firebaseSharedPreferences.edit().putStringSet(str, hashSet).putLong("fire-count", j2 + 1).putString("last-used-date", formattedDate).commit();
    }

    private synchronized void cleanUpStoredHeartBeats() {
        long j = this.firebaseSharedPreferences.getLong("fire-count", 0L);
        String str = null;
        String key = BuildConfig.FLAVOR;
        for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                for (String str2 : (Set) entry.getValue()) {
                    if (str == null || str.compareTo(str2) > 0) {
                        key = entry.getKey();
                        str = str2;
                    }
                }
            }
        }
        HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(key, new HashSet()));
        hashSet.remove(str);
        this.firebaseSharedPreferences.edit().putStringSet(key, hashSet).putLong("fire-count", j - 1).commit();
    }

    synchronized void updateGlobalHeartBeat(long j) {
        this.firebaseSharedPreferences.edit().putLong("fire-global", j).commit();
    }

    synchronized boolean isSameDateUtc(long j, long j2) {
        return getFormattedDate(j).equals(getFormattedDate(j2));
    }

    synchronized boolean shouldSendSdkHeartBeat(String str, long j) {
        if (this.firebaseSharedPreferences.contains(str)) {
            if (isSameDateUtc(this.firebaseSharedPreferences.getLong(str, -1L), j)) {
                return false;
            }
            this.firebaseSharedPreferences.edit().putLong(str, j).commit();
            return true;
        }
        this.firebaseSharedPreferences.edit().putLong(str, j).commit();
        return true;
    }

    synchronized boolean shouldSendGlobalHeartBeat(long j) {
        return shouldSendSdkHeartBeat("fire-global", j);
    }
}

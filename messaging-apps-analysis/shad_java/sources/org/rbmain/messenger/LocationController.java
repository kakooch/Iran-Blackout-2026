package org.rbmain.messenger;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidMessenger.ServiceLocator;
import androidMessenger.utilites.MessageConverter;
import androidx.collection.LongSparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import ir.aaap.messengercore.LoadListener;
import ir.aaap.messengercore.model.LiveLocationInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.rbmain.SQLite.SQLitePreparedStatement;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputGeoPointEmpty;
import org.rbmain.tgnet.TLRPC$TL_inputMediaGeoLive;
import org.rbmain.tgnet.TLRPC$TL_messageActionGeoProximityReached;
import org.rbmain.tgnet.TLRPC$TL_messageMediaGeoLive;
import org.rbmain.tgnet.TLRPC$TL_messages_affectedMessages;
import org.rbmain.tgnet.TLRPC$TL_messages_editMessage;
import org.rbmain.tgnet.TLRPC$TL_messages_getRecentLocations;
import org.rbmain.tgnet.TLRPC$TL_peerLocated;
import org.rbmain.tgnet.TLRPC$TL_updateEditChannelMessage;
import org.rbmain.tgnet.TLRPC$TL_updateEditMessage;
import org.rbmain.tgnet.TLRPC$Update;
import org.rbmain.tgnet.TLRPC$Updates;
import org.rbmain.tgnet.TLRPC$messages_Messages;

/* loaded from: classes4.dex */
public class LocationController extends BaseController implements NotificationCenter.NotificationCenterDelegate, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static final int BACKGROUD_UPDATE_TIME = 30000;
    private static final long FASTEST_INTERVAL = 1000;
    private static final int FOREGROUND_UPDATE_TIME = 20000;
    private static final int LOCATION_ACQUIRE_TIME = 10000;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final int SEND_NEW_LOCATION_TIME = 2000;
    private static final long UPDATE_INTERVAL = 1000;
    private static final int WATCH_LOCATION_TIMEOUT = 65000;
    private LongSparseArray<Boolean> cacheRequests;
    private ArrayList<TLRPC$TL_peerLocated> cachedNearbyChats;
    private ArrayList<TLRPC$TL_peerLocated> cachedNearbyUsers;
    private FusedLocationListener fusedLocationListener;
    private GoogleApiClient googleApiClient;
    private GpsLocationListener gpsLocationListener;
    private Location lastKnownLocation;
    private boolean lastLocationByGoogleMaps;
    private long lastLocationSendTime;
    private long lastLocationStartTime;
    private LongSparseArray<Integer> lastReadLocationTime;
    private long locationEndWatchTime;
    private LocationManager locationManager;
    private LocationRequest locationRequest;
    private boolean locationSentSinceLastGoogleMapUpdate;
    public LongSparseArray<ArrayList<TLRPC$Message>> locationsCache;
    private boolean lookingForPeopleNearby;
    private GpsLocationListener networkLocationListener;
    private GpsLocationListener passiveLocationListener;
    private Boolean playServicesAvailable;
    private SparseIntArray requests;
    private boolean shareMyCurrentLocation;
    private ArrayList<SharingLocationInfo> sharingLocations;
    private LongSparseArray<SharingLocationInfo> sharingLocationsMap;
    private LongSparseArray<SharingLocationInfo> sharingLocationsMapUI;
    public ArrayList<SharingLocationInfo> sharingLocationsUI;
    private boolean started;
    private boolean wasConnectedToPlayServices;
    private static volatile LocationController[] Instance = new LocationController[3];
    private static HashMap<LocationFetchCallback, Runnable> callbacks = new HashMap<>();

    public interface LocationFetchCallback {
        void onLocationAddressAvailable(String str, String str2, Location location);
    }

    public static class SharingLocationInfo {
        public int account;
        public long did;
        public int lastSentProximityMeters;
        public MessageObject messageObject;
        public long mid;
        public int period;
        public int proximityMeters;
        public int stopTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$broadcastLastKnownLocation$8(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
    }

    public static LocationController getInstance(int i) {
        LocationController locationController = Instance[i];
        if (locationController == null) {
            synchronized (LocationController.class) {
                locationController = Instance[i];
                if (locationController == null) {
                    LocationController[] locationControllerArr = Instance;
                    LocationController locationController2 = new LocationController(i);
                    locationControllerArr[i] = locationController2;
                    locationController = locationController2;
                }
            }
        }
        return locationController;
    }

    private class GpsLocationListener implements LocationListener {
        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        private GpsLocationListener() {
        }

        /* synthetic */ GpsLocationListener(LocationController locationController, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null) {
                return;
            }
            if (LocationController.this.lastKnownLocation == null || (this != LocationController.this.networkLocationListener && this != LocationController.this.passiveLocationListener)) {
                LocationController.this.setLastKnownLocation(location);
            } else {
                if (LocationController.this.started || location.distanceTo(LocationController.this.lastKnownLocation) <= 20.0f) {
                    return;
                }
                LocationController.this.setLastKnownLocation(location);
                LocationController.this.lastLocationSendTime = (SystemClock.elapsedRealtime() - 30000) + 5000;
            }
        }
    }

    private class FusedLocationListener implements com.google.android.gms.location.LocationListener {
        private FusedLocationListener() {
        }

        /* synthetic */ FusedLocationListener(LocationController locationController, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.gms.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null) {
                return;
            }
            LocationController.this.setLastKnownLocation(location);
        }
    }

    public LocationController(int i) {
        super(i);
        this.sharingLocationsMap = new LongSparseArray<>();
        this.sharingLocations = new ArrayList<>();
        this.locationsCache = new LongSparseArray<>();
        this.lastReadLocationTime = new LongSparseArray<>();
        AnonymousClass1 anonymousClass1 = null;
        this.gpsLocationListener = new GpsLocationListener(this, anonymousClass1);
        this.networkLocationListener = new GpsLocationListener(this, anonymousClass1);
        this.passiveLocationListener = new GpsLocationListener(this, anonymousClass1);
        this.fusedLocationListener = new FusedLocationListener(this, anonymousClass1);
        this.locationSentSinceLastGoogleMapUpdate = true;
        this.requests = new SparseIntArray();
        this.cacheRequests = new LongSparseArray<>();
        this.sharingLocationsUI = new ArrayList<>();
        this.sharingLocationsMapUI = new LongSparseArray<>();
        this.cachedNearbyUsers = new ArrayList<>();
        this.cachedNearbyChats = new ArrayList<>();
        this.locationManager = (LocationManager) ApplicationLoader.applicationContext.getSystemService("location");
        this.googleApiClient = new GoogleApiClient.Builder(ApplicationLoader.applicationContext).addApi(LocationServices.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
        LocationRequest locationRequest = new LocationRequest();
        this.locationRequest = locationRequest;
        locationRequest.setPriority(100);
        this.locationRequest.setInterval(1000L);
        this.locationRequest.setFastestInterval(1000L);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        });
        loadSharingLocations();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        LocationController locationController = getAccountInstance().getLocationController();
        getNotificationCenter().addObserver(locationController, NotificationCenter.didReceiveNewMessages);
        getNotificationCenter().addObserver(locationController, NotificationCenter.messagesDeleted);
        getNotificationCenter().addObserver(locationController, NotificationCenter.replaceMessagesObjects);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        ArrayList<TLRPC$Message> arrayList;
        ArrayList<TLRPC$Message> arrayList2;
        boolean z;
        if (i == NotificationCenter.didReceiveNewMessages) {
            if (((Boolean) objArr[2]).booleanValue()) {
                return;
            }
            long jLongValue = ((Long) objArr[0]).longValue();
            if (isSharingLocation(jLongValue) && (arrayList2 = this.locationsCache.get(jLongValue)) != null) {
                ArrayList arrayList3 = (ArrayList) objArr[1];
                boolean z2 = false;
                for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                    MessageObject messageObject = (MessageObject) arrayList3.get(i3);
                    if (messageObject.isLiveLocation()) {
                        int i4 = 0;
                        while (true) {
                            if (i4 >= arrayList2.size()) {
                                z = false;
                                break;
                            } else {
                                if (MessageObject.getFromChatId(arrayList2.get(i4)) == messageObject.getFromChatId()) {
                                    arrayList2.set(i4, messageObject.messageOwner);
                                    z = true;
                                    break;
                                }
                                i4++;
                            }
                        }
                        if (!z) {
                            arrayList2.add(messageObject.messageOwner);
                        }
                        z2 = true;
                    } else if ((messageObject.messageOwner.action instanceof TLRPC$TL_messageActionGeoProximityReached) && ((int) messageObject.getDialogId()) > 0) {
                        setProximityLocation(messageObject.getDialogId(), 0, false);
                    }
                }
                if (z2) {
                    NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.liveLocationsCacheChanged, Long.valueOf(jLongValue), Integer.valueOf(this.currentAccount));
                    return;
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.messagesDeleted) {
            if (((Boolean) objArr[2]).booleanValue() || this.sharingLocationsUI.isEmpty()) {
                return;
            }
            ArrayList arrayList4 = (ArrayList) objArr[0];
            int iIntValue = ((Integer) objArr[1]).intValue();
            ArrayList arrayList5 = null;
            for (int i5 = 0; i5 < this.sharingLocationsUI.size(); i5++) {
                SharingLocationInfo sharingLocationInfo = this.sharingLocationsUI.get(i5);
                MessageObject messageObject2 = sharingLocationInfo.messageObject;
                if (iIntValue == (messageObject2 != null ? messageObject2.getChannelId() : 0) && arrayList4.contains(Long.valueOf(sharingLocationInfo.mid))) {
                    if (arrayList5 == null) {
                        arrayList5 = new ArrayList();
                    }
                    arrayList5.add(Long.valueOf(sharingLocationInfo.did));
                }
            }
            if (arrayList5 != null) {
                for (int i6 = 0; i6 < arrayList5.size(); i6++) {
                    removeSharingLocation(((Long) arrayList5.get(i6)).longValue());
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.replaceMessagesObjects) {
            long jLongValue2 = ((Long) objArr[0]).longValue();
            if (isSharingLocation(jLongValue2) && (arrayList = this.locationsCache.get(jLongValue2)) != null) {
                ArrayList arrayList6 = (ArrayList) objArr[1];
                boolean z3 = false;
                for (int i7 = 0; i7 < arrayList6.size(); i7++) {
                    MessageObject messageObject3 = (MessageObject) arrayList6.get(i7);
                    int i8 = 0;
                    while (true) {
                        if (i8 >= arrayList.size()) {
                            break;
                        }
                        if (MessageObject.getFromChatId(arrayList.get(i8)) == messageObject3.getFromChatId()) {
                            if (!messageObject3.isLiveLocation()) {
                                arrayList.remove(i8);
                            } else {
                                arrayList.set(i8, messageObject3.messageOwner);
                            }
                            z3 = true;
                        } else {
                            i8++;
                        }
                    }
                }
                if (z3) {
                    NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.liveLocationsCacheChanged, Long.valueOf(jLongValue2), Integer.valueOf(this.currentAccount));
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
        this.wasConnectedToPlayServices = true;
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                LocationServices.SettingsApi.checkLocationSettings(this.googleApiClient, new LocationSettingsRequest.Builder().addLocationRequest(this.locationRequest).build()).setResultCallback(new ResultCallback() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda0
                    @Override // com.google.android.gms.common.api.ResultCallback
                    public final void onResult(Result result) {
                        this.f$0.lambda$onConnected$4((LocationSettingsResult) result);
                    }
                });
            } else {
                startFusedLocationRequest(true);
            }
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConnected$4(LocationSettingsResult locationSettingsResult) {
        final Status status = locationSettingsResult.getStatus();
        int statusCode = status.getStatusCode();
        if (statusCode == 0) {
            startFusedLocationRequest(true);
        } else if (statusCode == 6) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onConnected$2(status);
                }
            });
        } else {
            if (statusCode != 8502) {
                return;
            }
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onConnected$3();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConnected$2(final Status status) {
        if (this.lookingForPeopleNearby || !this.sharingLocations.isEmpty()) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onConnected$1(status);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConnected$1(Status status) {
        getNotificationCenter().postNotificationName(NotificationCenter.needShowPlayServicesAlert, status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConnected$3() {
        this.playServicesAvailable = Boolean.FALSE;
        try {
            this.googleApiClient.disconnect();
            start();
        } catch (Throwable unused) {
        }
    }

    public void startFusedLocationRequest(final boolean z) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startFusedLocationRequest$5(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startFusedLocationRequest$5(boolean z) {
        if (!z) {
            this.playServicesAvailable = Boolean.FALSE;
        }
        if (this.shareMyCurrentLocation || this.lookingForPeopleNearby || !this.sharingLocations.isEmpty()) {
            if (z) {
                try {
                    FusedLocationProviderApi fusedLocationProviderApi = LocationServices.FusedLocationApi;
                    setLastKnownLocation(fusedLocationProviderApi.getLastLocation(this.googleApiClient));
                    fusedLocationProviderApi.requestLocationUpdates(this.googleApiClient, this.locationRequest, this.fusedLocationListener);
                    return;
                } catch (Throwable th) {
                    FileLog.e(th);
                    return;
                }
            }
            start();
        }
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (this.wasConnectedToPlayServices) {
            return;
        }
        this.playServicesAvailable = Boolean.FALSE;
        if (this.started) {
            this.started = false;
            start();
        }
    }

    private boolean checkPlayServices() {
        if (this.playServicesAvailable == null) {
            this.playServicesAvailable = Boolean.valueOf(GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(ApplicationLoader.applicationContext) == 0);
        }
        return this.playServicesAvailable.booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void broadcastLastKnownLocation(boolean r19) {
        /*
            Method dump skipped, instructions count: 447
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.LocationController.broadcastLastKnownLocation(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$broadcastLastKnownLocation$7(final SharingLocationInfo sharingLocationInfo, int[] iArr, TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            if (tLRPC$TL_error.text.equals("MESSAGE_ID_INVALID")) {
                this.sharingLocations.remove(sharingLocationInfo);
                this.sharingLocationsMap.remove(sharingLocationInfo.did);
                saveSharingLocation(sharingLocationInfo, 1);
                this.requests.delete(iArr[0]);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda16
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$broadcastLastKnownLocation$6(sharingLocationInfo);
                    }
                });
                return;
            }
            return;
        }
        if ((tLRPC$TL_messages_editMessage.flags & 8) != 0) {
            sharingLocationInfo.lastSentProximityMeters = tLRPC$TL_messages_editMessage.media.proximity_notification_radius;
        }
        TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
        boolean z = false;
        for (int i = 0; i < tLRPC$Updates.updates.size(); i++) {
            TLRPC$Update tLRPC$Update = tLRPC$Updates.updates.get(i);
            if (tLRPC$Update instanceof TLRPC$TL_updateEditMessage) {
                sharingLocationInfo.messageObject.messageOwner = ((TLRPC$TL_updateEditMessage) tLRPC$Update).message;
            } else if (tLRPC$Update instanceof TLRPC$TL_updateEditChannelMessage) {
                sharingLocationInfo.messageObject.messageOwner = ((TLRPC$TL_updateEditChannelMessage) tLRPC$Update).message;
            }
            z = true;
        }
        if (z) {
            saveSharingLocation(sharingLocationInfo, 0);
        }
        getMessagesController().processUpdates(tLRPC$Updates, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$broadcastLastKnownLocation$6(SharingLocationInfo sharingLocationInfo) {
        this.sharingLocationsUI.remove(sharingLocationInfo);
        this.sharingLocationsMapUI.remove(sharingLocationInfo.did);
        if (this.sharingLocationsUI.isEmpty()) {
            stopService();
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.liveLocationsChanged, new Object[0]);
    }

    private boolean shouldStopGps() {
        return SystemClock.elapsedRealtime() > this.locationEndWatchTime;
    }

    protected void setNewLocationEndWatchTime() {
        if (this.sharingLocations.isEmpty()) {
            return;
        }
        this.locationEndWatchTime = SystemClock.elapsedRealtime() + 65000;
        start();
    }

    protected void update() {
        UserConfig userConfig = getUserConfig();
        if (ApplicationLoader.isScreenOn && !ApplicationLoader.mainInterfacePaused && !this.shareMyCurrentLocation && userConfig.isClientActivated() && userConfig.isConfigLoaded() && userConfig.sharingMyLocationUntil != 0 && Math.abs((System.currentTimeMillis() / 1000) - userConfig.lastMyLocationShareTime) >= 3600) {
            this.shareMyCurrentLocation = true;
        }
        if (!this.sharingLocations.isEmpty()) {
            int i = 0;
            while (i < this.sharingLocations.size()) {
                final SharingLocationInfo sharingLocationInfo = this.sharingLocations.get(i);
                if (sharingLocationInfo.stopTime <= getConnectionsManager().getCurrentTime()) {
                    this.sharingLocations.remove(i);
                    this.sharingLocationsMap.remove(sharingLocationInfo.did);
                    saveSharingLocation(sharingLocationInfo, 1);
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda17
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$update$9(sharingLocationInfo);
                        }
                    });
                    i--;
                }
                i++;
            }
        }
        if (this.started) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.lastLocationByGoogleMaps || Math.abs(this.lastLocationStartTime - jElapsedRealtime) > 10000 || shouldSendLocationNow()) {
                this.lastLocationByGoogleMaps = false;
                this.locationSentSinceLastGoogleMapUpdate = true;
                boolean z = SystemClock.elapsedRealtime() - this.lastLocationSendTime > 2000;
                this.lastLocationStartTime = jElapsedRealtime;
                this.lastLocationSendTime = SystemClock.elapsedRealtime();
                broadcastLastKnownLocation(z);
                return;
            }
            return;
        }
        if (!this.sharingLocations.isEmpty() || this.shareMyCurrentLocation) {
            if (this.shareMyCurrentLocation || Math.abs(this.lastLocationSendTime - SystemClock.elapsedRealtime()) > 30000) {
                this.lastLocationStartTime = SystemClock.elapsedRealtime();
                start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$update$9(SharingLocationInfo sharingLocationInfo) {
        this.sharingLocationsUI.remove(sharingLocationInfo);
        this.sharingLocationsMapUI.remove(sharingLocationInfo.did);
        if (this.sharingLocationsUI.isEmpty()) {
            stopService();
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.liveLocationsChanged, new Object[0]);
    }

    private boolean shouldSendLocationNow() {
        return shouldStopGps() && Math.abs(this.lastLocationSendTime - SystemClock.elapsedRealtime()) >= 2000;
    }

    public void cleanup() {
        this.sharingLocationsUI.clear();
        this.sharingLocationsMapUI.clear();
        this.locationsCache.clear();
        this.cacheRequests.clear();
        this.cachedNearbyUsers.clear();
        this.cachedNearbyChats.clear();
        this.lastReadLocationTime.clear();
        stopService();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cleanup$10();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cleanup$10() {
        this.locationEndWatchTime = 0L;
        this.requests.clear();
        this.sharingLocationsMap.clear();
        this.sharingLocations.clear();
        setLastKnownLocation(null);
        stop(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastKnownLocation(Location location) {
        if (location == null || Build.VERSION.SDK_INT < 17 || (SystemClock.elapsedRealtimeNanos() - location.getElapsedRealtimeNanos()) / 1000000000 <= 300) {
            this.lastKnownLocation = location;
            if (location != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda21
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocationController.lambda$setLastKnownLocation$11();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setLastKnownLocation$11() {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.newLocationAvailable, new Object[0]);
    }

    public void setCachedNearbyUsersAndChats(ArrayList<TLRPC$TL_peerLocated> arrayList, ArrayList<TLRPC$TL_peerLocated> arrayList2) {
        this.cachedNearbyUsers = new ArrayList<>(arrayList);
        this.cachedNearbyChats = new ArrayList<>(arrayList2);
    }

    public ArrayList<TLRPC$TL_peerLocated> getCachedNearbyUsers() {
        return this.cachedNearbyUsers;
    }

    public ArrayList<TLRPC$TL_peerLocated> getCachedNearbyChats() {
        return this.cachedNearbyChats;
    }

    protected void addSharingLocation(TLRPC$Message tLRPC$Message) {
        final SharingLocationInfo sharingLocationInfo = new SharingLocationInfo();
        sharingLocationInfo.did = tLRPC$Message.dialog_id;
        sharingLocationInfo.mid = tLRPC$Message.id;
        TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
        sharingLocationInfo.period = tLRPC$MessageMedia.period;
        int i = tLRPC$MessageMedia.proximity_notification_radius;
        sharingLocationInfo.proximityMeters = i;
        sharingLocationInfo.lastSentProximityMeters = i;
        sharingLocationInfo.account = this.currentAccount;
        sharingLocationInfo.messageObject = new MessageObject(this.currentAccount, tLRPC$Message, false, false);
        sharingLocationInfo.stopTime = getConnectionsManager().getCurrentTime() + sharingLocationInfo.period;
        final SharingLocationInfo sharingLocationInfo2 = this.sharingLocationsMap.get(sharingLocationInfo.did);
        this.sharingLocationsMap.put(sharingLocationInfo.did, sharingLocationInfo);
        if (sharingLocationInfo2 != null) {
            this.sharingLocations.remove(sharingLocationInfo2);
        }
        this.sharingLocations.add(sharingLocationInfo);
        saveSharingLocation(sharingLocationInfo, 0);
        this.lastLocationSendTime = (SystemClock.elapsedRealtime() - 30000) + 5000;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addSharingLocation$12(sharingLocationInfo2, sharingLocationInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addSharingLocation$12(SharingLocationInfo sharingLocationInfo, SharingLocationInfo sharingLocationInfo2) {
        if (sharingLocationInfo != null) {
            this.sharingLocationsUI.remove(sharingLocationInfo);
        }
        this.sharingLocationsUI.add(sharingLocationInfo2);
        this.sharingLocationsMapUI.put(sharingLocationInfo2.did, sharingLocationInfo2);
        startService();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.liveLocationsChanged, new Object[0]);
    }

    public boolean isSharingLocation(long j) {
        return this.sharingLocationsMapUI.indexOfKey(j) >= 0;
    }

    public SharingLocationInfo getSharingLocationInfo(long j) {
        return this.sharingLocationsMapUI.get(j);
    }

    public boolean setProximityLocation(final long j, final int i, boolean z) {
        SharingLocationInfo sharingLocationInfo = this.sharingLocationsMapUI.get(j);
        if (sharingLocationInfo != null) {
            sharingLocationInfo.proximityMeters = i;
        }
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setProximityLocation$13(i, j);
            }
        });
        if (z) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setProximityLocation$14();
                }
            });
        }
        return sharingLocationInfo != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setProximityLocation$13(int i, long j) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("UPDATE sharing_locations SET proximity = ? WHERE uid = ?");
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindInteger(1, i);
            sQLitePreparedStatementExecuteFast.bindLong(2, j);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setProximityLocation$14() {
        broadcastLastKnownLocation(true);
    }

    public static int getHeading(Location location) {
        float bearing = location.getBearing();
        return (bearing <= 0.0f || bearing >= 1.0f) ? (int) bearing : bearing < 0.5f ? 360 : 1;
    }

    public void loadSharingLocations() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadSharingLocations$15();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadSharingLocations$15() {
        if (ServiceLocator.isAccountLoggedIn(this.currentAccount)) {
            getCoreMainClass().getLiveLocationInfoArray(new AnonymousClass1());
        }
    }

    /* renamed from: org.rbmain.messenger.LocationController$1, reason: invalid class name */
    class AnonymousClass1 implements LoadListener<ArrayList<LiveLocationInfo>> {
        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
        }

        AnonymousClass1() {
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(ArrayList<LiveLocationInfo> arrayList) {
            if (arrayList.isEmpty()) {
                return;
            }
            LocationController locationController = LocationController.this;
            final ArrayList<SharingLocationInfo> arrayListConvertAllLiveLocationInfos = MessageConverter.convertAllLiveLocationInfos(locationController.currentAccount, locationController.getCoreMainClass(), arrayList);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.LocationController$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDidLoad$2(arrayListConvertAllLiveLocationInfos);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDidLoad$2(final ArrayList arrayList) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.LocationController$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDidLoad$1(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDidLoad$1(final ArrayList arrayList) {
            LocationController.this.sharingLocations.addAll(arrayList);
            for (int i = 0; i < LocationController.this.sharingLocations.size(); i++) {
                SharingLocationInfo sharingLocationInfo = (SharingLocationInfo) LocationController.this.sharingLocations.get(i);
                LocationController.this.sharingLocationsMap.put(sharingLocationInfo.did, sharingLocationInfo);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.LocationController$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDidLoad$0(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDidLoad$0(ArrayList arrayList) {
            LocationController.this.sharingLocationsUI.addAll(arrayList);
            for (int i = 0; i < arrayList.size(); i++) {
                SharingLocationInfo sharingLocationInfo = (SharingLocationInfo) arrayList.get(i);
                LocationController.this.sharingLocationsMapUI.put(sharingLocationInfo.did, sharingLocationInfo);
            }
            LocationController.this.startService();
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.liveLocationsChanged, new Object[0]);
        }
    }

    private void saveSharingLocation(SharingLocationInfo sharingLocationInfo, int i) {
        getMessagesProxy().saveSharingLocation(sharingLocationInfo, i);
    }

    public void removeSharingLocation(final long j) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeSharingLocation$18(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeSharingLocation$18(long j) {
        final SharingLocationInfo sharingLocationInfo = this.sharingLocationsMap.get(j);
        this.sharingLocationsMap.remove(j);
        if (sharingLocationInfo != null) {
            TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage = new TLRPC$TL_messages_editMessage();
            tLRPC$TL_messages_editMessage.peer = getMessagesController().getInputPeer((int) sharingLocationInfo.did);
            tLRPC$TL_messages_editMessage.id = sharingLocationInfo.mid;
            tLRPC$TL_messages_editMessage.flags |= LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM;
            TLRPC$TL_inputMediaGeoLive tLRPC$TL_inputMediaGeoLive = new TLRPC$TL_inputMediaGeoLive();
            tLRPC$TL_messages_editMessage.media = tLRPC$TL_inputMediaGeoLive;
            tLRPC$TL_inputMediaGeoLive.stopped = true;
            tLRPC$TL_inputMediaGeoLive.geo_point = new TLRPC$TL_inputGeoPointEmpty();
            tLRPC$TL_messages_editMessage.messageOwner = sharingLocationInfo.messageObject.messageOwner;
            getMessagesProxy().stopLiveLocation(tLRPC$TL_messages_editMessage, new RequestDelegate() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda22
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$removeSharingLocation$16(tLObject, tLRPC$TL_error);
                }
            });
            this.sharingLocations.remove(sharingLocationInfo);
            saveSharingLocation(sharingLocationInfo, 1);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeSharingLocation$17(sharingLocationInfo);
                }
            });
            if (this.sharingLocations.isEmpty()) {
                stop(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeSharingLocation$16(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            return;
        }
        getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeSharingLocation$17(SharingLocationInfo sharingLocationInfo) {
        this.sharingLocationsUI.remove(sharingLocationInfo);
        this.sharingLocationsMapUI.remove(sharingLocationInfo.did);
        if (this.sharingLocationsUI.isEmpty()) {
            stopService();
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.liveLocationsChanged, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startService() {
        try {
            ApplicationLoader.applicationContext.startService(new Intent(ApplicationLoader.applicationContext, (Class<?>) LocationSharingService.class));
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    private void stopService() {
        ApplicationLoader.applicationContext.stopService(new Intent(ApplicationLoader.applicationContext, (Class<?>) LocationSharingService.class));
    }

    public void removeAllLocationSharings() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeAllLocationSharings$21();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeAllLocationSharings$21() {
        for (int i = 0; i < this.sharingLocations.size(); i++) {
            SharingLocationInfo sharingLocationInfo = this.sharingLocations.get(i);
            TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage = new TLRPC$TL_messages_editMessage();
            tLRPC$TL_messages_editMessage.peer = getMessagesController().getInputPeer((int) sharingLocationInfo.did);
            tLRPC$TL_messages_editMessage.id = sharingLocationInfo.mid;
            tLRPC$TL_messages_editMessage.flags |= LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM;
            TLRPC$TL_inputMediaGeoLive tLRPC$TL_inputMediaGeoLive = new TLRPC$TL_inputMediaGeoLive();
            tLRPC$TL_messages_editMessage.media = tLRPC$TL_inputMediaGeoLive;
            tLRPC$TL_inputMediaGeoLive.stopped = true;
            tLRPC$TL_inputMediaGeoLive.geo_point = new TLRPC$TL_inputGeoPointEmpty();
            tLRPC$TL_messages_editMessage.messageOwner = sharingLocationInfo.messageObject.messageOwner;
            getMessagesProxy().stopLiveLocation(tLRPC$TL_messages_editMessage, new RequestDelegate() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda23
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$removeAllLocationSharings$19(tLObject, tLRPC$TL_error);
                }
            });
        }
        this.sharingLocations.clear();
        this.sharingLocationsMap.clear();
        saveSharingLocation(null, 2);
        stop(true);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeAllLocationSharings$20();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeAllLocationSharings$19(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            return;
        }
        getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeAllLocationSharings$20() {
        this.sharingLocationsUI.clear();
        this.sharingLocationsMapUI.clear();
        stopService();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.liveLocationsChanged, new Object[0]);
    }

    public void setGoogleMapLocation(Location location, boolean z) {
        Location location2;
        if (location == null) {
            return;
        }
        this.lastLocationByGoogleMaps = true;
        if (z || ((location2 = this.lastKnownLocation) != null && location2.distanceTo(location) >= 20.0f)) {
            this.lastLocationSendTime = SystemClock.elapsedRealtime() - 30000;
            this.locationSentSinceLastGoogleMapUpdate = false;
        } else if (this.locationSentSinceLastGoogleMapUpdate) {
            this.lastLocationSendTime = (SystemClock.elapsedRealtime() - 30000) + 20000;
            this.locationSentSinceLastGoogleMapUpdate = false;
        }
        setLastKnownLocation(location);
    }

    private void start() {
        if (this.started) {
            return;
        }
        this.lastLocationStartTime = SystemClock.elapsedRealtime();
        boolean z = true;
        this.started = true;
        if (checkPlayServices()) {
            try {
                this.googleApiClient.connect();
            } catch (Throwable th) {
                FileLog.e(th);
            }
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        try {
            this.locationManager.requestLocationUpdates("gps", 1L, 0.0f, this.gpsLocationListener);
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            this.locationManager.requestLocationUpdates("network", 1L, 0.0f, this.networkLocationListener);
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        try {
            this.locationManager.requestLocationUpdates("passive", 1L, 0.0f, this.passiveLocationListener);
        } catch (Exception e3) {
            FileLog.e(e3);
        }
        if (this.lastKnownLocation == null) {
            try {
                setLastKnownLocation(this.locationManager.getLastKnownLocation("gps"));
                if (this.lastKnownLocation == null) {
                    setLastKnownLocation(this.locationManager.getLastKnownLocation("network"));
                }
            } catch (Exception e4) {
                FileLog.e(e4);
            }
        }
    }

    private void stop(boolean z) {
        if (this.lookingForPeopleNearby || this.shareMyCurrentLocation) {
            return;
        }
        this.started = false;
        if (checkPlayServices()) {
            try {
                LocationServices.FusedLocationApi.removeLocationUpdates(this.googleApiClient, this.fusedLocationListener);
                this.googleApiClient.disconnect();
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        this.locationManager.removeUpdates(this.gpsLocationListener);
        if (z) {
            this.locationManager.removeUpdates(this.networkLocationListener);
            this.locationManager.removeUpdates(this.passiveLocationListener);
        }
    }

    public void startLocationLookupForPeopleNearby(final boolean z) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startLocationLookupForPeopleNearby$22(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startLocationLookupForPeopleNearby$22(boolean z) {
        boolean z2 = !z;
        this.lookingForPeopleNearby = z2;
        if (z2) {
            start();
        } else if (this.sharingLocations.isEmpty()) {
            stop(true);
        }
    }

    public Location getLastKnownLocation() {
        return this.lastKnownLocation;
    }

    public void loadLiveLocations(final long j) {
        if (this.cacheRequests.indexOfKey(j) >= 0) {
            return;
        }
        this.cacheRequests.put(j, Boolean.TRUE);
        TLRPC$TL_messages_getRecentLocations tLRPC$TL_messages_getRecentLocations = new TLRPC$TL_messages_getRecentLocations();
        tLRPC$TL_messages_getRecentLocations.peer = getMessagesController().getInputPeer((int) j);
        tLRPC$TL_messages_getRecentLocations.limit = 100;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getRecentLocations, new RequestDelegate() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda25
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadLiveLocations$24(j, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadLiveLocations$24(final long j, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadLiveLocations$23(j, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadLiveLocations$23(long j, TLObject tLObject) {
        this.cacheRequests.delete(j);
        TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
        int i = 0;
        while (i < tLRPC$messages_Messages.messages.size()) {
            if (!(tLRPC$messages_Messages.messages.get(i).media instanceof TLRPC$TL_messageMediaGeoLive)) {
                tLRPC$messages_Messages.messages.remove(i);
                i--;
            }
            i++;
        }
        getMessagesStorage().putUsersAndChats(tLRPC$messages_Messages.users, tLRPC$messages_Messages.chats, true, true);
        getMessagesController().putUsers(tLRPC$messages_Messages.users, false);
        getMessagesController().putChats(tLRPC$messages_Messages.chats, false);
        this.locationsCache.put(j, tLRPC$messages_Messages.messages);
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.liveLocationsCacheChanged, Long.valueOf(j), Integer.valueOf(this.currentAccount));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARN: Type inference failed for: r0v1, types: [org.rbmain.tgnet.TLRPC$TL_messages_readMessageContents] */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.rbmain.tgnet.TLObject] */
    /* JADX WARN: Type inference failed for: r0v5, types: [org.rbmain.tgnet.TLRPC$TL_channels_readMessageContents] */
    /* JADX WARN: Type inference failed for: r8v4, types: [org.rbmain.tgnet.ConnectionsManager] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void markLiveLoactionsAsRead(long r8) {
        /*
            r7 = this;
            int r0 = (int) r8
            if (r0 != 0) goto L4
            return
        L4:
            androidx.collection.LongSparseArray<java.util.ArrayList<org.rbmain.tgnet.TLRPC$Message>> r1 = r7.locationsCache
            java.lang.Object r1 = r1.get(r8)
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            if (r1 == 0) goto L9b
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L16
            goto L9b
        L16:
            androidx.collection.LongSparseArray<java.lang.Integer> r2 = r7.lastReadLocationTime
            java.lang.Object r2 = r2.get(r8)
            java.lang.Integer r2 = (java.lang.Integer) r2
            long r3 = android.os.SystemClock.elapsedRealtime()
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r5
            int r4 = (int) r3
            if (r2 == 0) goto L31
            int r2 = r2.intValue()
            int r2 = r2 + 60
            if (r2 <= r4) goto L31
            return
        L31:
            androidx.collection.LongSparseArray<java.lang.Integer> r2 = r7.lastReadLocationTime
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r2.put(r8, r3)
            r8 = 0
            if (r0 >= 0) goto L70
            int r9 = -r0
            int r0 = r7.currentAccount
            boolean r0 = org.rbmain.messenger.ChatObject.isChannel(r9, r0)
            if (r0 == 0) goto L70
            org.rbmain.tgnet.TLRPC$TL_channels_readMessageContents r0 = new org.rbmain.tgnet.TLRPC$TL_channels_readMessageContents
            r0.<init>()
            int r2 = r1.size()
        L4f:
            if (r8 >= r2) goto L65
            java.util.ArrayList<java.lang.Long> r3 = r0.id
            java.lang.Object r4 = r1.get(r8)
            org.rbmain.tgnet.TLRPC$Message r4 = (org.rbmain.tgnet.TLRPC$Message) r4
            long r4 = r4.id
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r3.add(r4)
            int r8 = r8 + 1
            goto L4f
        L65:
            org.rbmain.messenger.MessagesController r8 = r7.getMessagesController()
            org.rbmain.tgnet.TLRPC$InputChannel r8 = r8.getInputChannel(r9)
            r0.channel = r8
            goto L8f
        L70:
            org.rbmain.tgnet.TLRPC$TL_messages_readMessageContents r0 = new org.rbmain.tgnet.TLRPC$TL_messages_readMessageContents
            r0.<init>()
            int r9 = r1.size()
        L79:
            if (r8 >= r9) goto L8f
            java.util.ArrayList<java.lang.Long> r2 = r0.id
            java.lang.Object r3 = r1.get(r8)
            org.rbmain.tgnet.TLRPC$Message r3 = (org.rbmain.tgnet.TLRPC$Message) r3
            long r3 = r3.id
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r2.add(r3)
            int r8 = r8 + 1
            goto L79
        L8f:
            org.rbmain.tgnet.ConnectionsManager r8 = r7.getConnectionsManager()
            org.rbmain.messenger.LocationController$$ExternalSyntheticLambda24 r9 = new org.rbmain.messenger.LocationController$$ExternalSyntheticLambda24
            r9.<init>()
            r8.sendRequest(r0, r9)
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.LocationController.markLiveLoactionsAsRead(long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markLiveLoactionsAsRead$25(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_messages_affectedMessages) {
            TLRPC$TL_messages_affectedMessages tLRPC$TL_messages_affectedMessages = (TLRPC$TL_messages_affectedMessages) tLObject;
            getMessagesController().processNewDifferenceParams(-1, tLRPC$TL_messages_affectedMessages.pts, -1, tLRPC$TL_messages_affectedMessages.pts_count);
        }
    }

    public static int getLocationsCount() {
        int size = 0;
        for (int i = 0; i < 3; i++) {
            size += getInstance(i).sharingLocationsUI.size();
        }
        return size;
    }

    public static void fetchLocationAddress(final Location location, final LocationFetchCallback locationFetchCallback) {
        if (locationFetchCallback == null) {
            return;
        }
        Runnable runnable = callbacks.get(locationFetchCallback);
        if (runnable != null) {
            Utilities.globalQueue.cancelRunnable(runnable);
            callbacks.remove(locationFetchCallback);
        }
        if (location == null) {
            locationFetchCallback.onLocationAddressAvailable(null, null, null);
            return;
        }
        DispatchQueue dispatchQueue = Utilities.globalQueue;
        Runnable runnable2 = new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                LocationController.lambda$fetchLocationAddress$27(location, locationFetchCallback);
            }
        };
        dispatchQueue.postRunnable(runnable2, 300L);
        callbacks.put(locationFetchCallback, runnable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fetchLocationAddress$27(final Location location, final LocationFetchCallback locationFetchCallback) throws IOException {
        final String string;
        final String string2;
        boolean z;
        try {
            List<Address> fromLocation = new Geocoder(ApplicationLoader.applicationContext, LocaleController.getInstance().getSystemDefaultLocale()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (fromLocation.size() > 0) {
                Address address = fromLocation.get(0);
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                String subThoroughfare = address.getSubThoroughfare();
                if (TextUtils.isEmpty(subThoroughfare)) {
                    z = false;
                } else {
                    sb.append(subThoroughfare);
                    z = true;
                }
                String thoroughfare = address.getThoroughfare();
                if (!TextUtils.isEmpty(thoroughfare)) {
                    if (sb.length() > 0) {
                        sb.append(" ");
                    }
                    sb.append(thoroughfare);
                    z = true;
                }
                if (!z) {
                    String adminArea = address.getAdminArea();
                    if (!TextUtils.isEmpty(adminArea)) {
                        if (sb.length() > 0) {
                            sb.append(", ");
                        }
                        sb.append(adminArea);
                    }
                    String subAdminArea = address.getSubAdminArea();
                    if (!TextUtils.isEmpty(subAdminArea)) {
                        if (sb.length() > 0) {
                            sb.append(", ");
                        }
                        sb.append(subAdminArea);
                    }
                }
                String locality = address.getLocality();
                if (!TextUtils.isEmpty(locality)) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(locality);
                }
                String countryName = address.getCountryName();
                if (!TextUtils.isEmpty(countryName)) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(countryName);
                }
                String countryName2 = address.getCountryName();
                if (!TextUtils.isEmpty(countryName2)) {
                    if (sb2.length() > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(countryName2);
                }
                String locality2 = address.getLocality();
                if (!TextUtils.isEmpty(locality2)) {
                    if (sb2.length() > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(locality2);
                }
                if (!z) {
                    String adminArea2 = address.getAdminArea();
                    if (!TextUtils.isEmpty(adminArea2)) {
                        if (sb2.length() > 0) {
                            sb2.append(", ");
                        }
                        sb2.append(adminArea2);
                    }
                    String subAdminArea2 = address.getSubAdminArea();
                    if (!TextUtils.isEmpty(subAdminArea2)) {
                        if (sb2.length() > 0) {
                            sb2.append(", ");
                        }
                        sb2.append(subAdminArea2);
                    }
                }
                string2 = sb.toString();
                string = sb2.toString();
            } else {
                string2 = String.format(Locale.US, "Unknown address (%f,%f)", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()));
                string = string2;
            }
        } catch (Exception unused) {
            string = String.format(Locale.US, "Unknown address (%f,%f)", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()));
            string2 = string;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.LocationController$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                LocationController.lambda$fetchLocationAddress$26(locationFetchCallback, string2, string, location);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fetchLocationAddress$26(LocationFetchCallback locationFetchCallback, String str, String str2, Location location) {
        callbacks.remove(locationFetchCallback);
        locationFetchCallback.onLocationAddressAvailable(str, str2, location);
    }
}

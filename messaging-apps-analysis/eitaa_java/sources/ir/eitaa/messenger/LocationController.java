package ir.eitaa.messenger;

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
import ir.eitaa.SQLite.SQLiteCursor;
import ir.eitaa.SQLite.SQLitePreparedStatement;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.tgnet.NativeByteBuffer;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputGeoPointEmpty;
import ir.eitaa.tgnet.TLRPC$TL_inputMediaGeoLive;
import ir.eitaa.tgnet.TLRPC$TL_messageActionGeoProximityReached;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaGeoLive;
import ir.eitaa.tgnet.TLRPC$TL_messages_affectedMessages;
import ir.eitaa.tgnet.TLRPC$TL_messages_editMessage;
import ir.eitaa.tgnet.TLRPC$TL_messages_getRecentLocations;
import ir.eitaa.tgnet.TLRPC$TL_peerLocated;
import ir.eitaa.tgnet.TLRPC$TL_updateEditChannelMessage;
import ir.eitaa.tgnet.TLRPC$TL_updateEditMessage;
import ir.eitaa.tgnet.TLRPC$Update;
import ir.eitaa.tgnet.TLRPC$Updates;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$messages_Messages;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
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
        void onLocationAddressAvailable(String address, String displayAddress, Location location);
    }

    public static class SharingLocationInfo {
        public int account;
        public long did;
        public int lastSentProximityMeters;
        public MessageObject messageObject;
        public int mid;
        public int period;
        public int proximityMeters;
        public int stopTime;
    }

    static /* synthetic */ void lambda$broadcastLastKnownLocation$8(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
    }

    public static LocationController getInstance(int num) {
        LocationController locationController = Instance[num];
        if (locationController == null) {
            synchronized (LocationController.class) {
                locationController = Instance[num];
                if (locationController == null) {
                    LocationController[] locationControllerArr = Instance;
                    LocationController locationController2 = new LocationController(num);
                    locationControllerArr[num] = locationController2;
                    locationController = locationController2;
                }
            }
        }
        return locationController;
    }

    private class GpsLocationListener implements LocationListener {
        @Override // android.location.LocationListener
        public void onProviderDisabled(String provider) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String provider) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        private GpsLocationListener() {
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

        @Override // com.google.android.gms.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null) {
                return;
            }
            LocationController.this.setLastKnownLocation(location);
        }
    }

    public LocationController(int instance) {
        super(instance);
        this.sharingLocationsMap = new LongSparseArray<>();
        this.sharingLocations = new ArrayList<>();
        this.locationsCache = new LongSparseArray<>();
        this.lastReadLocationTime = new LongSparseArray<>();
        this.gpsLocationListener = new GpsLocationListener();
        this.networkLocationListener = new GpsLocationListener();
        this.passiveLocationListener = new GpsLocationListener();
        this.fusedLocationListener = new FusedLocationListener();
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
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$23gz7XAxEZ0Nm1MEXykhiXMGDus
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$LocationController();
            }
        });
        loadSharingLocations();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$LocationController() {
        LocationController locationController = getAccountInstance().getLocationController();
        getNotificationCenter().addObserver(locationController, NotificationCenter.didReceiveNewMessages);
        getNotificationCenter().addObserver(locationController, NotificationCenter.messagesDeleted);
        getNotificationCenter().addObserver(locationController, NotificationCenter.replaceMessagesObjects);
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        ArrayList<TLRPC$Message> arrayList;
        ArrayList<TLRPC$Message> arrayList2;
        boolean z;
        if (id == NotificationCenter.didReceiveNewMessages) {
            if (((Boolean) args[2]).booleanValue()) {
                return;
            }
            long jLongValue = ((Long) args[0]).longValue();
            if (isSharingLocation(jLongValue) && (arrayList2 = this.locationsCache.get(jLongValue)) != null) {
                ArrayList arrayList3 = (ArrayList) args[1];
                boolean z2 = false;
                for (int i = 0; i < arrayList3.size(); i++) {
                    MessageObject messageObject = (MessageObject) arrayList3.get(i);
                    if (messageObject.isLiveLocation()) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= arrayList2.size()) {
                                z = false;
                                break;
                            } else {
                                if (MessageObject.getFromChatId(arrayList2.get(i2)) == messageObject.getFromChatId()) {
                                    arrayList2.set(i2, messageObject.messageOwner);
                                    z = true;
                                    break;
                                }
                                i2++;
                            }
                        }
                        if (!z) {
                            arrayList2.add(messageObject.messageOwner);
                        }
                        z2 = true;
                    } else if (messageObject.messageOwner.action instanceof TLRPC$TL_messageActionGeoProximityReached) {
                        long dialogId = messageObject.getDialogId();
                        if (DialogObject.isUserDialog(dialogId)) {
                            setProximityLocation(dialogId, 0, false);
                        }
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
        if (id == NotificationCenter.messagesDeleted) {
            if (((Boolean) args[2]).booleanValue() || this.sharingLocationsUI.isEmpty()) {
                return;
            }
            ArrayList arrayList4 = (ArrayList) args[0];
            long jLongValue2 = ((Long) args[1]).longValue();
            ArrayList arrayList5 = null;
            for (int i3 = 0; i3 < this.sharingLocationsUI.size(); i3++) {
                SharingLocationInfo sharingLocationInfo = this.sharingLocationsUI.get(i3);
                MessageObject messageObject2 = sharingLocationInfo.messageObject;
                if (jLongValue2 == (messageObject2 != null ? messageObject2.getChannelId() : 0L) && arrayList4.contains(Integer.valueOf(sharingLocationInfo.mid))) {
                    if (arrayList5 == null) {
                        arrayList5 = new ArrayList();
                    }
                    arrayList5.add(Long.valueOf(sharingLocationInfo.did));
                }
            }
            if (arrayList5 != null) {
                for (int i4 = 0; i4 < arrayList5.size(); i4++) {
                    removeSharingLocation(((Long) arrayList5.get(i4)).longValue());
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.replaceMessagesObjects) {
            long jLongValue3 = ((Long) args[0]).longValue();
            if (isSharingLocation(jLongValue3) && (arrayList = this.locationsCache.get(jLongValue3)) != null) {
                ArrayList arrayList6 = (ArrayList) args[1];
                boolean z3 = false;
                for (int i5 = 0; i5 < arrayList6.size(); i5++) {
                    MessageObject messageObject3 = (MessageObject) arrayList6.get(i5);
                    int i6 = 0;
                    while (true) {
                        if (i6 >= arrayList.size()) {
                            break;
                        }
                        if (MessageObject.getFromChatId(arrayList.get(i6)) == messageObject3.getFromChatId()) {
                            if (!messageObject3.isLiveLocation()) {
                                arrayList.remove(i6);
                            } else {
                                arrayList.set(i6, messageObject3.messageOwner);
                            }
                            z3 = true;
                        } else {
                            i6++;
                        }
                    }
                }
                if (z3) {
                    NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.liveLocationsCacheChanged, Long.valueOf(jLongValue3), Integer.valueOf(this.currentAccount));
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
        this.wasConnectedToPlayServices = true;
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                LocationServices.SettingsApi.checkLocationSettings(this.googleApiClient, new LocationSettingsRequest.Builder().addLocationRequest(this.locationRequest).build()).setResultCallback(new ResultCallback() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$vCY43O-ZWc5nM5wDooCvv5iJAbY
                    @Override // com.google.android.gms.common.api.ResultCallback
                    public final void onResult(Result result) {
                        this.f$0.lambda$onConnected$4$LocationController((LocationSettingsResult) result);
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
    /* renamed from: lambda$onConnected$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onConnected$4$LocationController(LocationSettingsResult locationSettingsResult) {
        final Status status = locationSettingsResult.getStatus();
        int statusCode = status.getStatusCode();
        if (statusCode == 0) {
            startFusedLocationRequest(true);
        } else if (statusCode == 6) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$iUqhr3PPoKXHcApESKHUTfbujFc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onConnected$2$LocationController(status);
                }
            });
        } else {
            if (statusCode != 8502) {
                return;
            }
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$GaKxJPpbF0KXQbGRdd0CsPXmwM8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onConnected$3$LocationController();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onConnected$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onConnected$2$LocationController(final Status status) {
        if (this.lookingForPeopleNearby || !this.sharingLocations.isEmpty()) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$YNTJaM8ImEEviUTQ7WooNw_eQK8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onConnected$1$LocationController(status);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onConnected$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onConnected$1$LocationController(Status status) {
        getNotificationCenter().postNotificationName(NotificationCenter.needShowPlayServicesAlert, status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onConnected$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onConnected$3$LocationController() {
        this.playServicesAvailable = Boolean.FALSE;
        try {
            this.googleApiClient.disconnect();
            start();
        } catch (Throwable unused) {
        }
    }

    public void startFusedLocationRequest(final boolean permissionsGranted) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$Ah7ffNOOcLsms0C6OgN1kyvqCXY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startFusedLocationRequest$5$LocationController(permissionsGranted);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startFusedLocationRequest$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startFusedLocationRequest$5$LocationController(boolean z) {
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

    /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void broadcastLastKnownLocation(boolean r19) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.LocationController.broadcastLastKnownLocation(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$broadcastLastKnownLocation$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$broadcastLastKnownLocation$7$LocationController(final SharingLocationInfo sharingLocationInfo, int[] iArr, TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            if (tLRPC$TL_error.text.equals("MESSAGE_ID_INVALID")) {
                this.sharingLocations.remove(sharingLocationInfo);
                this.sharingLocationsMap.remove(sharingLocationInfo.did);
                saveSharingLocation(sharingLocationInfo, 1);
                this.requests.delete(iArr[0]);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$3Gxa01F6EJv-jbVsaV6ZoBevaq8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$broadcastLastKnownLocation$6$LocationController(sharingLocationInfo);
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
    /* renamed from: lambda$broadcastLastKnownLocation$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$broadcastLastKnownLocation$6$LocationController(SharingLocationInfo sharingLocationInfo) {
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
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$9In1j93gd81jidGpD5WK_HBL6fc
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$update$9$LocationController(sharingLocationInfo);
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
    /* renamed from: lambda$update$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$update$9$LocationController(SharingLocationInfo sharingLocationInfo) {
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
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$KUQ82Nuc8S-nCrLerJd_xx2P0hE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cleanup$10$LocationController();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cleanup$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$cleanup$10$LocationController() {
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
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$yXwQ5S7ebAqsR5E8xYhArRRcHN4
                    @Override // java.lang.Runnable
                    public final void run() {
                        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.newLocationAvailable, new Object[0]);
                    }
                });
            }
        }
    }

    public void setCachedNearbyUsersAndChats(ArrayList<TLRPC$TL_peerLocated> u, ArrayList<TLRPC$TL_peerLocated> c) {
        this.cachedNearbyUsers = new ArrayList<>(u);
        this.cachedNearbyChats = new ArrayList<>(c);
    }

    public ArrayList<TLRPC$TL_peerLocated> getCachedNearbyUsers() {
        return this.cachedNearbyUsers;
    }

    public ArrayList<TLRPC$TL_peerLocated> getCachedNearbyChats() {
        return this.cachedNearbyChats;
    }

    protected void addSharingLocation(TLRPC$Message message) {
        final SharingLocationInfo sharingLocationInfo = new SharingLocationInfo();
        sharingLocationInfo.did = message.dialog_id;
        sharingLocationInfo.mid = message.id;
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        sharingLocationInfo.period = tLRPC$MessageMedia.period;
        int i = tLRPC$MessageMedia.proximity_notification_radius;
        sharingLocationInfo.proximityMeters = i;
        sharingLocationInfo.lastSentProximityMeters = i;
        sharingLocationInfo.account = this.currentAccount;
        sharingLocationInfo.messageObject = new MessageObject(this.currentAccount, message, false, false);
        sharingLocationInfo.stopTime = getConnectionsManager().getCurrentTime() + sharingLocationInfo.period;
        final SharingLocationInfo sharingLocationInfo2 = this.sharingLocationsMap.get(sharingLocationInfo.did);
        this.sharingLocationsMap.put(sharingLocationInfo.did, sharingLocationInfo);
        if (sharingLocationInfo2 != null) {
            this.sharingLocations.remove(sharingLocationInfo2);
        }
        this.sharingLocations.add(sharingLocationInfo);
        saveSharingLocation(sharingLocationInfo, 0);
        this.lastLocationSendTime = (SystemClock.elapsedRealtime() - 30000) + 5000;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$HBgNjn824VKX9AneHkZJwvVwEhc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addSharingLocation$12$LocationController(sharingLocationInfo2, sharingLocationInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addSharingLocation$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addSharingLocation$12$LocationController(SharingLocationInfo sharingLocationInfo, SharingLocationInfo sharingLocationInfo2) {
        if (sharingLocationInfo != null) {
            this.sharingLocationsUI.remove(sharingLocationInfo);
        }
        this.sharingLocationsUI.add(sharingLocationInfo2);
        this.sharingLocationsMapUI.put(sharingLocationInfo2.did, sharingLocationInfo2);
        startService();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.liveLocationsChanged, new Object[0]);
    }

    public boolean isSharingLocation(long did) {
        return this.sharingLocationsMapUI.indexOfKey(did) >= 0;
    }

    public SharingLocationInfo getSharingLocationInfo(long did) {
        return this.sharingLocationsMapUI.get(did);
    }

    public boolean setProximityLocation(final long did, final int meters, boolean broadcast) {
        SharingLocationInfo sharingLocationInfo = this.sharingLocationsMapUI.get(did);
        if (sharingLocationInfo != null) {
            sharingLocationInfo.proximityMeters = meters;
        }
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$Xj8ApE8CwoV4qABnm3KsB_bONcE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setProximityLocation$13$LocationController(meters, did);
            }
        });
        if (broadcast) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$eVNGyZ6cbexvU2BruFJEfTa0Gpc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setProximityLocation$14$LocationController();
                }
            });
        }
        return sharingLocationInfo != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setProximityLocation$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setProximityLocation$13$LocationController(int i, long j) {
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
    /* renamed from: lambda$setProximityLocation$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setProximityLocation$14$LocationController() {
        broadcastLastKnownLocation(true);
    }

    public static int getHeading(Location location) {
        float bearing = location.getBearing();
        return (bearing <= 0.0f || bearing >= 1.0f) ? (int) bearing : bearing < 0.5f ? 360 : 1;
    }

    private void loadSharingLocations() {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$DE0_030j0k2-B-6NPKzA_pP8PaA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadSharingLocations$18$LocationController();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadSharingLocations$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadSharingLocations$18$LocationController() {
        final ArrayList arrayList = new ArrayList();
        final ArrayList<TLRPC$User> arrayList2 = new ArrayList<>();
        final ArrayList<TLRPC$Chat> arrayList3 = new ArrayList<>();
        try {
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized("SELECT uid, mid, date, period, message, proximity FROM sharing_locations WHERE 1", new Object[0]);
            while (sQLiteCursorQueryFinalized.next()) {
                SharingLocationInfo sharingLocationInfo = new SharingLocationInfo();
                sharingLocationInfo.did = sQLiteCursorQueryFinalized.longValue(0);
                sharingLocationInfo.mid = sQLiteCursorQueryFinalized.intValue(1);
                sharingLocationInfo.stopTime = sQLiteCursorQueryFinalized.intValue(2);
                sharingLocationInfo.period = sQLiteCursorQueryFinalized.intValue(3);
                sharingLocationInfo.proximityMeters = sQLiteCursorQueryFinalized.intValue(5);
                sharingLocationInfo.account = this.currentAccount;
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(4);
                if (nativeByteBufferByteBufferValue != null) {
                    MessageObject messageObject = new MessageObject(this.currentAccount, TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false), false, false);
                    sharingLocationInfo.messageObject = messageObject;
                    MessagesStorage.addUsersAndChatsFromMessage(messageObject.messageOwner, arrayList4, arrayList5);
                    nativeByteBufferByteBufferValue.reuse();
                }
                arrayList.add(sharingLocationInfo);
                if (DialogObject.isChatDialog(sharingLocationInfo.did)) {
                    if (!arrayList5.contains(Long.valueOf(-sharingLocationInfo.did))) {
                        arrayList5.add(Long.valueOf(-sharingLocationInfo.did));
                    }
                } else if (DialogObject.isUserDialog(sharingLocationInfo.did) && !arrayList4.contains(Long.valueOf(sharingLocationInfo.did))) {
                    arrayList4.add(Long.valueOf(sharingLocationInfo.did));
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            if (!arrayList5.isEmpty()) {
                getMessagesStorage().getChatsInternal(TextUtils.join(",", arrayList5), arrayList3);
            }
            if (!arrayList4.isEmpty()) {
                getMessagesStorage().getUsersInternal(TextUtils.join(",", arrayList4), arrayList2);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$-iqx7QdM7knCehgCLosGPyK-20o
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadSharingLocations$17$LocationController(arrayList2, arrayList3, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadSharingLocations$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadSharingLocations$17$LocationController(ArrayList arrayList, ArrayList arrayList2, final ArrayList arrayList3) {
        getMessagesController().putUsers(arrayList, true);
        getMessagesController().putChats(arrayList2, true);
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$THMRBYp0CJcyjByMam9HOLCiVbU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadSharingLocations$16$LocationController(arrayList3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadSharingLocations$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadSharingLocations$16$LocationController(final ArrayList arrayList) {
        this.sharingLocations.addAll(arrayList);
        for (int i = 0; i < this.sharingLocations.size(); i++) {
            SharingLocationInfo sharingLocationInfo = this.sharingLocations.get(i);
            this.sharingLocationsMap.put(sharingLocationInfo.did, sharingLocationInfo);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$jieCcOfmQNhIcq5xMU11PvVlemg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadSharingLocations$15$LocationController(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadSharingLocations$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadSharingLocations$15$LocationController(ArrayList arrayList) {
        this.sharingLocationsUI.addAll(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            SharingLocationInfo sharingLocationInfo = (SharingLocationInfo) arrayList.get(i);
            this.sharingLocationsMapUI.put(sharingLocationInfo.did, sharingLocationInfo);
        }
        startService();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.liveLocationsChanged, new Object[0]);
    }

    private void saveSharingLocation(final SharingLocationInfo info, final int remove) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$TiYjoE6RQFHbfMmeUVduR_1QXPM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveSharingLocation$19$LocationController(remove, info);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveSharingLocation$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveSharingLocation$19$LocationController(int i, SharingLocationInfo sharingLocationInfo) {
        try {
            if (i == 2) {
                getMessagesStorage().getDatabase().executeFast("DELETE FROM sharing_locations WHERE 1").stepThis().dispose();
            } else if (i == 1) {
                if (sharingLocationInfo == null) {
                    return;
                }
                getMessagesStorage().getDatabase().executeFast("DELETE FROM sharing_locations WHERE uid = " + sharingLocationInfo.did).stepThis().dispose();
            } else {
                if (sharingLocationInfo == null) {
                    return;
                }
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = getMessagesStorage().getDatabase().executeFast("REPLACE INTO sharing_locations VALUES(?, ?, ?, ?, ?, ?)");
                sQLitePreparedStatementExecuteFast.requery();
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(sharingLocationInfo.messageObject.messageOwner.getObjectSize());
                sharingLocationInfo.messageObject.messageOwner.serializeToStream(nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindLong(1, sharingLocationInfo.did);
                sQLitePreparedStatementExecuteFast.bindInteger(2, sharingLocationInfo.mid);
                sQLitePreparedStatementExecuteFast.bindInteger(3, sharingLocationInfo.stopTime);
                sQLitePreparedStatementExecuteFast.bindInteger(4, sharingLocationInfo.period);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(5, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindInteger(6, sharingLocationInfo.proximityMeters);
                sQLitePreparedStatementExecuteFast.step();
                sQLitePreparedStatementExecuteFast.dispose();
                nativeByteBuffer.reuse();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void removeSharingLocation(final long did) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$v8_eB4bkV2w5Phlc9XaM9aeEq8Q
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeSharingLocation$22$LocationController(did);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removeSharingLocation$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$removeSharingLocation$22$LocationController(long j) {
        final SharingLocationInfo sharingLocationInfo = this.sharingLocationsMap.get(j);
        this.sharingLocationsMap.remove(j);
        if (sharingLocationInfo != null) {
            TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage = new TLRPC$TL_messages_editMessage();
            tLRPC$TL_messages_editMessage.peer = getMessagesController().getInputPeer(sharingLocationInfo.did);
            tLRPC$TL_messages_editMessage.id = sharingLocationInfo.mid;
            tLRPC$TL_messages_editMessage.flags |= 16384;
            TLRPC$TL_inputMediaGeoLive tLRPC$TL_inputMediaGeoLive = new TLRPC$TL_inputMediaGeoLive();
            tLRPC$TL_messages_editMessage.media = tLRPC$TL_inputMediaGeoLive;
            tLRPC$TL_inputMediaGeoLive.stopped = true;
            tLRPC$TL_inputMediaGeoLive.geo_point = new TLRPC$TL_inputGeoPointEmpty();
            getConnectionsManager().sendRequest(tLRPC$TL_messages_editMessage, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$7mLPfvh3WDA1NphmSpyh4_F6cSg
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$removeSharingLocation$20$LocationController(tLObject, tLRPC$TL_error);
                }
            });
            this.sharingLocations.remove(sharingLocationInfo);
            saveSharingLocation(sharingLocationInfo, 1);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$2SjO6EVf3GKWwyFGql5g7MgLSJw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeSharingLocation$21$LocationController(sharingLocationInfo);
                }
            });
            if (this.sharingLocations.isEmpty()) {
                stop(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removeSharingLocation$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$removeSharingLocation$20$LocationController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            return;
        }
        getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removeSharingLocation$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$removeSharingLocation$21$LocationController(SharingLocationInfo sharingLocationInfo) {
        this.sharingLocationsUI.remove(sharingLocationInfo);
        this.sharingLocationsMapUI.remove(sharingLocationInfo.did);
        if (this.sharingLocationsUI.isEmpty()) {
            stopService();
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.liveLocationsChanged, new Object[0]);
    }

    private void startService() {
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
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$UvDDnvipG3FY6d4Q4cXlkaFwwwQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeAllLocationSharings$25$LocationController();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removeAllLocationSharings$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$removeAllLocationSharings$25$LocationController() {
        for (int i = 0; i < this.sharingLocations.size(); i++) {
            SharingLocationInfo sharingLocationInfo = this.sharingLocations.get(i);
            TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage = new TLRPC$TL_messages_editMessage();
            tLRPC$TL_messages_editMessage.peer = getMessagesController().getInputPeer(sharingLocationInfo.did);
            tLRPC$TL_messages_editMessage.id = sharingLocationInfo.mid;
            tLRPC$TL_messages_editMessage.flags |= 16384;
            TLRPC$TL_inputMediaGeoLive tLRPC$TL_inputMediaGeoLive = new TLRPC$TL_inputMediaGeoLive();
            tLRPC$TL_messages_editMessage.media = tLRPC$TL_inputMediaGeoLive;
            tLRPC$TL_inputMediaGeoLive.stopped = true;
            tLRPC$TL_inputMediaGeoLive.geo_point = new TLRPC$TL_inputGeoPointEmpty();
            getConnectionsManager().sendRequest(tLRPC$TL_messages_editMessage, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$pB4AqtfCuSz8u2t5k6GakqIyvmg
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$removeAllLocationSharings$23$LocationController(tLObject, tLRPC$TL_error);
                }
            });
        }
        this.sharingLocations.clear();
        this.sharingLocationsMap.clear();
        saveSharingLocation(null, 2);
        stop(true);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$0fKOfl9w8vReiOTTqFqrHb4_xr8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeAllLocationSharings$24$LocationController();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removeAllLocationSharings$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$removeAllLocationSharings$23$LocationController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            return;
        }
        getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removeAllLocationSharings$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$removeAllLocationSharings$24$LocationController() {
        this.sharingLocationsUI.clear();
        this.sharingLocationsMapUI.clear();
        stopService();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.liveLocationsChanged, new Object[0]);
    }

    public void setGoogleMapLocation(Location location, boolean first) {
        Location location2;
        if (location == null) {
            return;
        }
        this.lastLocationByGoogleMaps = true;
        if (first || ((location2 = this.lastKnownLocation) != null && location2.distanceTo(location) >= 20.0f)) {
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

    private void stop(boolean empty) {
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
        if (empty) {
            this.locationManager.removeUpdates(this.networkLocationListener);
            this.locationManager.removeUpdates(this.passiveLocationListener);
        }
    }

    public void startLocationLookupForPeopleNearby(final boolean stop) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$KjDZyNBuyOblanxWiuq4OAYOg50
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startLocationLookupForPeopleNearby$26$LocationController(stop);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startLocationLookupForPeopleNearby$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startLocationLookupForPeopleNearby$26$LocationController(boolean z) {
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

    public void loadLiveLocations(final long did) {
        if (this.cacheRequests.indexOfKey(did) >= 0) {
            return;
        }
        this.cacheRequests.put(did, Boolean.TRUE);
        TLRPC$TL_messages_getRecentLocations tLRPC$TL_messages_getRecentLocations = new TLRPC$TL_messages_getRecentLocations();
        tLRPC$TL_messages_getRecentLocations.peer = getMessagesController().getInputPeer(did);
        tLRPC$TL_messages_getRecentLocations.limit = 100;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getRecentLocations, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$H_bMKjSez5KgoglhFCSNa0ITG_c
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadLiveLocations$28$LocationController(did, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadLiveLocations$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadLiveLocations$28$LocationController(final long j, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$jsXW2n4pILyzC9g-doq5hvelAow
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadLiveLocations$27$LocationController(j, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadLiveLocations$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadLiveLocations$27$LocationController(long j, TLObject tLObject) {
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
    /* JADX WARN: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARN: Type inference failed for: r1v10, types: [ir.eitaa.tgnet.TLRPC$TL_channels_readMessageContents] */
    /* JADX WARN: Type inference failed for: r1v6, types: [ir.eitaa.tgnet.TLRPC$TL_messages_readMessageContents] */
    /* JADX WARN: Type inference failed for: r1v7, types: [ir.eitaa.tgnet.TLObject] */
    /* JADX WARN: Type inference failed for: r7v2, types: [ir.eitaa.tgnet.ConnectionsManager] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void markLiveLoactionsAsRead(long r7) {
        /*
            r6 = this;
            boolean r0 = ir.eitaa.messenger.DialogObject.isEncryptedDialog(r7)
            if (r0 == 0) goto L7
            return
        L7:
            androidx.collection.LongSparseArray<java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message>> r0 = r6.locationsCache
            java.lang.Object r0 = r0.get(r7)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            if (r0 == 0) goto La2
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L19
            goto La2
        L19:
            androidx.collection.LongSparseArray<java.lang.Integer> r1 = r6.lastReadLocationTime
            java.lang.Object r1 = r1.get(r7)
            java.lang.Integer r1 = (java.lang.Integer) r1
            long r2 = android.os.SystemClock.elapsedRealtime()
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            int r3 = (int) r2
            if (r1 == 0) goto L34
            int r1 = r1.intValue()
            int r1 = r1 + 60
            if (r1 <= r3) goto L34
            return
        L34:
            androidx.collection.LongSparseArray<java.lang.Integer> r1 = r6.lastReadLocationTime
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r1.put(r7, r2)
            boolean r1 = ir.eitaa.messenger.DialogObject.isChatDialog(r7)
            r2 = 0
            if (r1 == 0) goto L77
            long r7 = -r7
            int r1 = r6.currentAccount
            boolean r1 = ir.eitaa.messenger.ChatObject.isChannel(r7, r1)
            if (r1 == 0) goto L77
            ir.eitaa.tgnet.TLRPC$TL_channels_readMessageContents r1 = new ir.eitaa.tgnet.TLRPC$TL_channels_readMessageContents
            r1.<init>()
            int r3 = r0.size()
        L56:
            if (r2 >= r3) goto L6c
            java.util.ArrayList<java.lang.Integer> r4 = r1.id
            java.lang.Object r5 = r0.get(r2)
            ir.eitaa.tgnet.TLRPC$Message r5 = (ir.eitaa.tgnet.TLRPC$Message) r5
            int r5 = r5.id
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.add(r5)
            int r2 = r2 + 1
            goto L56
        L6c:
            ir.eitaa.messenger.MessagesController r0 = r6.getMessagesController()
            ir.eitaa.tgnet.TLRPC$InputChannel r7 = r0.getInputChannel(r7)
            r1.channel = r7
            goto L96
        L77:
            ir.eitaa.tgnet.TLRPC$TL_messages_readMessageContents r1 = new ir.eitaa.tgnet.TLRPC$TL_messages_readMessageContents
            r1.<init>()
            int r7 = r0.size()
        L80:
            if (r2 >= r7) goto L96
            java.util.ArrayList<java.lang.Integer> r8 = r1.id
            java.lang.Object r3 = r0.get(r2)
            ir.eitaa.tgnet.TLRPC$Message r3 = (ir.eitaa.tgnet.TLRPC$Message) r3
            int r3 = r3.id
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r8.add(r3)
            int r2 = r2 + 1
            goto L80
        L96:
            ir.eitaa.tgnet.ConnectionsManager r7 = r6.getConnectionsManager()
            ir.eitaa.messenger.-$$Lambda$LocationController$aD5hx2D52TqDhb-5zq2xFwCHSS4 r8 = new ir.eitaa.messenger.-$$Lambda$LocationController$aD5hx2D52TqDhb-5zq2xFwCHSS4
            r8.<init>()
            r7.sendRequest(r1, r8)
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.LocationController.markLiveLoactionsAsRead(long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markLiveLoactionsAsRead$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markLiveLoactionsAsRead$29$LocationController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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

    public static void fetchLocationAddress(final Location location, final LocationFetchCallback callback) throws InterruptedException {
        if (callback == null) {
            return;
        }
        Runnable runnable = callbacks.get(callback);
        if (runnable != null) {
            Utilities.globalQueue.cancelRunnable(runnable);
            callbacks.remove(callback);
        }
        if (location == null) {
            callback.onLocationAddressAvailable(null, null, null);
            return;
        }
        DispatchQueue dispatchQueue = Utilities.globalQueue;
        Runnable runnable2 = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$k7IFkbaQatvJRd-F2UZsxtmwphc
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                LocationController.lambda$fetchLocationAddress$31(location, callback);
            }
        };
        dispatchQueue.postRunnable(runnable2, 300L);
        callbacks.put(callback, runnable2);
    }

    static /* synthetic */ void lambda$fetchLocationAddress$31(final Location location, final LocationFetchCallback locationFetchCallback) throws IOException {
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
                string2 = String.format(Locale.US, "%f,%f", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()));
                string = string2;
            }
        } catch (Exception unused) {
            string = String.format(Locale.US, "%f,%f", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()));
            string2 = string;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocationController$_H1GI38l9uGMTTJUWKkbKdEXrb4
            @Override // java.lang.Runnable
            public final void run() {
                LocationController.lambda$fetchLocationAddress$30(locationFetchCallback, string2, string, location);
            }
        });
    }

    static /* synthetic */ void lambda$fetchLocationAddress$30(LocationFetchCallback locationFetchCallback, String str, String str2, Location location) {
        callbacks.remove(locationFetchCallback);
        locationFetchCallback.onLocationAddressAvailable(str, str2, location);
    }
}

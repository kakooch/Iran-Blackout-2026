package ir.eitaa.helper;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.core.content.ContextCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import ir.eitaa.messenger.ApplicationLoader;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MapHelper implements LocationListener {
    private Context context;
    public Location currentLocation;
    private LocationDelegate delegate;
    private FusedLocationProviderClient fusedLocationClient;
    LocationCallback locationCallback;
    protected LocationManager locationManager;
    LocationRequest locationRequest;
    private WebView mapView;
    private boolean checkGPS = false;
    private boolean checkNetwork = false;
    public boolean isLocationTrackingStarted = false;
    private boolean didFindLocation = false;

    public interface LocationDelegate {
        void onLocationAvailability(Location location);
    }

    public interface MapListener {
        void onCenterLocationReceived(LngLat location);
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String provider) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String provider) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    public MapHelper(Context context, WebView mapView) {
        this.mapView = mapView;
        this.context = context;
    }

    public void startLocationTracking() {
        try {
            this.locationManager = (LocationManager) ApplicationLoader.applicationContext.getSystemService("location");
            this.fusedLocationClient = LocationServices.getFusedLocationProviderClient(this.context.getApplicationContext());
            this.checkGPS = this.locationManager.isProviderEnabled("gps");
            boolean zIsProviderEnabled = this.locationManager.isProviderEnabled("network");
            this.checkNetwork = zIsProviderEnabled;
            boolean z = this.checkGPS;
            if ((z || zIsProviderEnabled) && z) {
                if ((ContextCompat.checkSelfPermission(this.context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this.context, "android.permission.ACCESS_COARSE_LOCATION") == 0) && this.locationManager != null) {
                    this.isLocationTrackingStarted = true;
                    this.locationRequest = new LocationRequest.Builder(100, 5000L).build();
                    LocationCallback locationCallback = new LocationCallback() { // from class: ir.eitaa.helper.MapHelper.1
                        @Override // com.google.android.gms.location.LocationCallback
                        public void onLocationAvailability(LocationAvailability locationAvailability) {
                            super.onLocationAvailability(locationAvailability);
                        }

                        @Override // com.google.android.gms.location.LocationCallback
                        public void onLocationResult(LocationResult locationResult) {
                            super.onLocationResult(locationResult);
                            MapHelper.this.updateUserLocation(new LngLat(Double.valueOf(locationResult.getLocations().get(0).getLatitude()), Double.valueOf(locationResult.getLocations().get(0).getLongitude())));
                            MapHelper.this.currentLocation = locationResult.getLastLocation();
                            if (MapHelper.this.delegate == null || MapHelper.this.didFindLocation) {
                                return;
                            }
                            MapHelper mapHelper = MapHelper.this;
                            if (mapHelper.currentLocation != null) {
                                mapHelper.didFindLocation = true;
                                MapHelper.this.delegate.onLocationAvailability(MapHelper.this.currentLocation);
                            }
                        }
                    };
                    this.locationCallback = locationCallback;
                    this.fusedLocationClient.requestLocationUpdates(this.locationRequest, locationCallback, this.context.getMainLooper());
                    Location location = this.currentLocation;
                    if (location != null) {
                        LngLat lngLat = new LngLat(Double.valueOf(location.getLatitude()), Double.valueOf(this.currentLocation.getLongitude()));
                        updateUserLocation(lngLat);
                        moveTo(lngLat);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDelegate(LocationDelegate delegate) {
        this.delegate = delegate;
    }

    private void stopLocationTracking() {
        FusedLocationProviderClient fusedLocationProviderClient = this.fusedLocationClient;
        if (fusedLocationProviderClient != null) {
            fusedLocationProviderClient.removeLocationUpdates(this.locationCallback);
        }
        this.isLocationTrackingStarted = false;
    }

    public void onPause() {
        stopLocationTracking();
    }

    public void onResume() {
        if (this.currentLocation == null || !this.isLocationTrackingStarted) {
            startLocationTracking();
        }
    }

    public void moveTo(LngLat location) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.mapView.evaluateJavascript("moveTo(" + location.lat + "," + location.lng + ");", new ValueCallback<String>() { // from class: ir.eitaa.helper.MapHelper.2
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String value) {
                }
            });
        }
    }

    public void moveToUserLocation() {
        Location location = this.currentLocation;
        if (location != null) {
            moveTo(new LngLat(Double.valueOf(location.getLatitude()), Double.valueOf(this.currentLocation.getLongitude())));
        }
    }

    public void addMark(LngLat location, boolean goTo) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.mapView.evaluateJavascript("addMark(" + location.lat + "," + location.lng + ");", new ValueCallback<String>() { // from class: ir.eitaa.helper.MapHelper.3
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String value) {
                }
            });
        }
        if (goTo) {
            moveTo(location);
        }
    }

    public void updateUserLocation(LngLat location) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.mapView.evaluateJavascript("updateCenterMark(" + location.lat + "," + location.lng + ");", new ValueCallback<String>() { // from class: ir.eitaa.helper.MapHelper.4
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String value) {
                }
            });
        }
    }

    public void getCenterLocation(final MapListener mapListener) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.mapView.evaluateJavascript("getCenterLocation();", new ValueCallback<String>() { // from class: ir.eitaa.helper.MapHelper.5
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String value) {
                    try {
                        if (value.isEmpty()) {
                            return;
                        }
                        JSONObject jSONObject = new JSONObject(value);
                        mapListener.onCenterLocationReceived(new LngLat(Double.valueOf(jSONObject.getDouble("lat")), Double.valueOf(jSONObject.getDouble("lng"))));
                    } catch (Exception unused) {
                        mapListener.onCenterLocationReceived(new LngLat(Double.valueOf(0.0d), Double.valueOf(0.0d)));
                    }
                }
            });
        }
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        updateUserLocation(new LngLat(Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
        this.currentLocation = location;
    }

    public static class LngLat {
        public Double lat;
        public Double lng;

        public LngLat(Double lat, Double lng) {
            this.lat = lat;
            this.lng = lng;
        }
    }
}

package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.MapItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class MapPresenter extends AbstractPresenter<MapItem, MyViewHolder> {
    public int height;
    Context mContext;
    public int width;

    public MapPresenter(Context context) {
        super(context);
        this.width = -1;
        this.height = -1;
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R.layout.map_view, viewGroup, false);
        final MyViewHolder myViewHolder = new MyViewHolder(this, viewInflate);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        int i = this.width;
        if (i > 0) {
            layoutParams.width = i;
        }
        int i2 = this.height;
        if (i2 > 0) {
            layoutParams.height = i2;
        }
        viewInflate.setLayoutParams(layoutParams);
        myViewHolder.mapView.onCreate(null);
        myViewHolder.mapView.onResume();
        myViewHolder.mapView.getMapAsync(new OnMapReadyCallback() { // from class: ir.resaneh1.iptv.presenters.MapPresenter.1
            @Override // com.google.android.gms.maps.OnMapReadyCallback
            public void onMapReady(GoogleMap googleMap) {
                myViewHolder.googleMap = googleMap;
                MapsInitializer.initialize(((AbstractPresenter) MapPresenter.this).context);
                MapPresenter.this.bindMapLocation(myViewHolder);
            }
        });
        return myViewHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindMapLocation(MyViewHolder myViewHolder) {
        GoogleMap googleMap;
        if (myViewHolder.item == 0 || (googleMap = myViewHolder.googleMap) == null) {
            return;
        }
        googleMap.clear();
        GoogleMap googleMap2 = myViewHolder.googleMap;
        Titem titem = myViewHolder.item;
        googleMap2.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(((MapItem) titem).locationObject.latitude, ((MapItem) titem).locationObject.longitude), 15.0f));
        GoogleMap googleMap3 = myViewHolder.googleMap;
        MarkerOptions markerOptions = new MarkerOptions();
        Titem titem2 = myViewHolder.item;
        googleMap3.addMarker(markerOptions.position(new LatLng(((MapItem) titem2).locationObject.latitude, ((MapItem) titem2).locationObject.longitude)));
        myViewHolder.googleMap.setMapType(1);
        Titem titem3 = myViewHolder.item;
        if (((MapItem) titem3).locationObject == null || ((MapItem) titem3).locationObject.latitude == 0.0d) {
            myViewHolder.button.setVisibility(0);
            myViewHolder.mapView.setVisibility(8);
        } else {
            myViewHolder.button.setVisibility(4);
            myViewHolder.mapView.setVisibility(0);
        }
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, MapItem mapItem) {
        super.onBindViewHolder((MapPresenter) myViewHolder, (MyViewHolder) mapItem);
        bindMapLocation(myViewHolder);
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<MapItem> {
        View button;
        public FrameLayout clickableFrame;
        public GoogleMap googleMap;
        MapView mapView;

        public MyViewHolder(MapPresenter mapPresenter, View view) {
            super(view);
            this.mapView = (MapView) view.findViewById(R.id.mapView);
            this.clickableFrame = (FrameLayout) view.findViewById(R.id.frameLayoutClickable);
            this.button = view.findViewById(R.id.button);
        }
    }
}

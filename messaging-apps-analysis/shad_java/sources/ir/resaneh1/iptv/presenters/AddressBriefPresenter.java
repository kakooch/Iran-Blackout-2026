package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.model.DeliveryInfoObject;
import ir.resaneh1.iptv.model.DeliveryProvinceObject;
import ir.resaneh1.iptv.model.DeliveryTimeObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class AddressBriefPresenter extends AbstractPresenter<DeliveryInfoObject, MyViewHolder> {
    Context mContext;

    public AddressBriefPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        final MyViewHolder myViewHolder = new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.item_row_brief_address, viewGroup, false));
        myViewHolder.mapView.onCreate(null);
        myViewHolder.mapView.onResume();
        myViewHolder.mapView.getMapAsync(new OnMapReadyCallback() { // from class: ir.resaneh1.iptv.presenters.AddressBriefPresenter.1
            @Override // com.google.android.gms.maps.OnMapReadyCallback
            public void onMapReady(GoogleMap googleMap) {
                myViewHolder.googleMap = googleMap;
                googleMap.getUiSettings().setScrollGesturesEnabled(false);
                MapsInitializer.initialize(((AbstractPresenter) AddressBriefPresenter.this).context);
                AddressBriefPresenter.this.bindMapLocation(myViewHolder);
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
        if (((DeliveryInfoObject) myViewHolder.item).location != null) {
            GoogleMap googleMap2 = myViewHolder.googleMap;
            Titem titem = myViewHolder.item;
            googleMap2.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(((DeliveryInfoObject) titem).location.latitude, ((DeliveryInfoObject) titem).location.longitude), 15.0f));
            GoogleMap googleMap3 = myViewHolder.googleMap;
            MarkerOptions markerOptions = new MarkerOptions();
            Titem titem2 = myViewHolder.item;
            googleMap3.addMarker(markerOptions.position(new LatLng(((DeliveryInfoObject) titem2).location.latitude, ((DeliveryInfoObject) titem2).location.longitude)));
        }
        myViewHolder.googleMap.setMapType(1);
        Titem titem3 = myViewHolder.item;
        if (((DeliveryInfoObject) titem3).location == null || ((DeliveryInfoObject) titem3).location.latitude == 0.0d) {
            myViewHolder.mapView.setVisibility(8);
        } else {
            myViewHolder.mapView.setVisibility(0);
        }
        myViewHolder.googleMap.getUiSettings().setScrollGesturesEnabled(false);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, DeliveryInfoObject deliveryInfoObject) {
        String str;
        super.onBindViewHolder((AddressBriefPresenter) myViewHolder, (MyViewHolder) deliveryInfoObject);
        DeliveryProvinceObject deliveryProvinceObject = deliveryInfoObject.province;
        String str2 = BuildConfig.FLAVOR;
        if (deliveryProvinceObject != null) {
            str = BuildConfig.FLAVOR + deliveryInfoObject.province.name + " ،";
        } else {
            str = BuildConfig.FLAVOR;
        }
        if (deliveryInfoObject.city != null) {
            str = str + deliveryInfoObject.city.name + " ،";
        }
        if (deliveryInfoObject.address != null) {
            str = str + deliveryInfoObject.address;
        }
        myViewHolder.textView1.setText(SpanHelper.makeBoldSpanWithColor("آدرس : ", this.mContext.getResources().getColor(R.color.grey_900)));
        myViewHolder.textView1.append(str);
        if (deliveryInfoObject.recipient_name != null) {
            str2 = BuildConfig.FLAVOR + deliveryInfoObject.recipient_name + " ";
        }
        if (deliveryInfoObject.recipient_mobile != null) {
            str2 = str2 + NumberUtils.toPersian(deliveryInfoObject.recipient_mobile) + " ";
        }
        if (deliveryInfoObject.recipient_phone != null) {
            str2 = str2 + NumberUtils.toPersian(deliveryInfoObject.recipient_phone);
        }
        myViewHolder.textView2.setText(SpanHelper.makeBoldSpanWithColor("مشخصات گیرنده : ", this.mContext.getResources().getColor(R.color.grey_900)));
        myViewHolder.textView2.append(str2);
        bindMapLocation(myViewHolder);
    }

    public void bindDeliveryTime(MyViewHolder myViewHolder, DeliveryTimeObject deliveryTimeObject) {
        myViewHolder.textView3.setText(SpanHelper.makeBoldSpanWithColor("زمان تحویل : ", this.mContext.getResources().getColor(R.color.grey_900)));
        myViewHolder.textView3.append(deliveryTimeObject.title);
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<DeliveryInfoObject> {
        public CardView cardView;
        public GoogleMap googleMap;
        public MapView mapView;
        public TextView textView1;
        public TextView textView2;
        private TextView textView3;

        public MyViewHolder(AddressBriefPresenter addressBriefPresenter, View view) {
            super(view);
            this.textView1 = (TextView) view.findViewById(R.id.textView1);
            this.textView2 = (TextView) view.findViewById(R.id.textView2);
            this.textView3 = (TextView) view.findViewById(R.id.textView3);
            this.mapView = (MapView) view.findViewById(R.id.map);
            this.cardView = (CardView) view.findViewById(R.id.cardView);
        }
    }
}

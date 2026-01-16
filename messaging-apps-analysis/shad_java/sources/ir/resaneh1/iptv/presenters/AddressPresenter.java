package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import ir.resaneh1.iptv.fragment.DeliveryInfosListFragment;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.DeliveryCityObject;
import ir.resaneh1.iptv.model.DeliveryInfoObject;
import ir.resaneh1.iptv.model.DeliveryProvinceObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class AddressPresenter extends AbstractPresenter<DeliveryInfoObject, MyViewHolder> {
    public boolean hasSelectButton;
    public boolean isInList;
    Listener listener;
    Context mContext;
    View.OnClickListener onChangeAddressClickListener;
    View.OnClickListener onDeleteClickListener;
    View.OnClickListener onEditClickListener;
    View.OnClickListener onSelectClickListener;
    public DeliveryInfosListFragment.SelectButtonTypeEnum selectButtonType;

    public interface Listener {
        void onChangeAddressClick(MyViewHolder myViewHolder);

        void onDelete(MyViewHolder myViewHolder);

        void onEdit(MyViewHolder myViewHolder);

        void onSelect(MyViewHolder myViewHolder);
    }

    public AddressPresenter(Context context, Listener listener) {
        super(context);
        this.isInList = false;
        this.hasSelectButton = true;
        this.onEditClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.AddressPresenter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddressPresenter.this.listener.onEdit((MyViewHolder) view.getTag());
            }
        };
        this.onDeleteClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.AddressPresenter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddressPresenter.this.listener.onDelete((MyViewHolder) view.getTag());
            }
        };
        this.onSelectClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.AddressPresenter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddressPresenter.this.listener.onSelect((MyViewHolder) view.getTag());
            }
        };
        this.onChangeAddressClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.AddressPresenter.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddressPresenter.this.listener.onChangeAddressClick((MyViewHolder) view.getTag());
            }
        };
        this.mContext = context;
        this.listener = listener;
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<DeliveryInfoObject> {
        public FrameLayout buttonChangeAddress;
        public FrameLayout buttonSelectAddress;
        public CardView cardView;
        public ImageView delete;
        public ImageView edit;
        public GoogleMap googleMap;
        public MapView mapView;
        public TextView textViewAddressFull;
        public TextView textViewButtonSelect;
        public TextView textViewCityEntry;
        public TextView textViewName;
        public TextView textViewpHomePhoneEntry;
        public TextView textViewpMobilePhoneEntry;
        public TextView textViewpPostalCodeEntry;
        public TextView textViewproveneEntry;

        public MyViewHolder(AddressPresenter addressPresenter, View view) {
            super(view);
            this.textViewName = (TextView) view.findViewById(R.id.textViewName);
            this.textViewButtonSelect = (TextView) view.findViewById(R.id.textViewButtonSelect);
            this.textViewpHomePhoneEntry = (TextView) view.findViewById(R.id.textViewpHomePhoneEntry);
            this.textViewpMobilePhoneEntry = (TextView) view.findViewById(R.id.textViewpMobilePhoneEntry);
            this.textViewpPostalCodeEntry = (TextView) view.findViewById(R.id.textViewpPostalCodeEntry);
            this.textViewAddressFull = (TextView) view.findViewById(R.id.textViewAddressFull);
            this.textViewCityEntry = (TextView) view.findViewById(R.id.textViewCityEntry);
            this.textViewproveneEntry = (TextView) view.findViewById(R.id.textViewproveneEntry);
            this.buttonChangeAddress = (FrameLayout) view.findViewById(R.id.buttonChangeAddress);
            this.edit = (ImageView) view.findViewById(R.id.edit);
            this.delete = (ImageView) view.findViewById(R.id.delete);
            this.buttonSelectAddress = (FrameLayout) view.findViewById(R.id.buttonSelectAddress);
            this.mapView = (MapView) view.findViewById(R.id.map);
            this.cardView = (CardView) view.findViewById(R.id.cardView);
        }
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        final MyViewHolder myViewHolder = new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.item_row_address, viewGroup, false));
        myViewHolder.buttonSelectAddress.setOnClickListener(this.onSelectClickListener);
        myViewHolder.delete.setOnClickListener(this.onDeleteClickListener);
        myViewHolder.edit.setOnClickListener(this.onEditClickListener);
        myViewHolder.edit.setTag(myViewHolder);
        myViewHolder.delete.setTag(myViewHolder);
        myViewHolder.buttonSelectAddress.setTag(myViewHolder);
        myViewHolder.buttonChangeAddress.setOnClickListener(this.onChangeAddressClickListener);
        myViewHolder.buttonChangeAddress.setTag(myViewHolder);
        myViewHolder.mapView.onCreate(null);
        myViewHolder.mapView.onResume();
        myViewHolder.mapView.getMapAsync(new OnMapReadyCallback() { // from class: ir.resaneh1.iptv.presenters.AddressPresenter.1
            @Override // com.google.android.gms.maps.OnMapReadyCallback
            public void onMapReady(GoogleMap googleMap) {
                myViewHolder.googleMap = googleMap;
                MapsInitializer.initialize(((AbstractPresenter) AddressPresenter.this).context);
                AddressPresenter.this.bindMapLocation(myViewHolder);
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
        googleMap2.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(((DeliveryInfoObject) titem).location.latitude, ((DeliveryInfoObject) titem).location.longitude), 15.0f));
        GoogleMap googleMap3 = myViewHolder.googleMap;
        MarkerOptions markerOptions = new MarkerOptions();
        Titem titem2 = myViewHolder.item;
        googleMap3.addMarker(markerOptions.position(new LatLng(((DeliveryInfoObject) titem2).location.latitude, ((DeliveryInfoObject) titem2).location.longitude)));
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
        super.onBindViewHolder((AddressPresenter) myViewHolder, (MyViewHolder) deliveryInfoObject);
        TextView textView = myViewHolder.textViewName;
        String str = deliveryInfoObject.recipient_name;
        String str2 = BuildConfig.FLAVOR;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        textView.setText(str);
        TextView textView2 = myViewHolder.textViewpHomePhoneEntry;
        String str3 = deliveryInfoObject.recipient_phone;
        textView2.setText(str3 != null ? NumberUtils.toPersian(str3) : BuildConfig.FLAVOR);
        TextView textView3 = myViewHolder.textViewpMobilePhoneEntry;
        String str4 = deliveryInfoObject.recipient_mobile;
        textView3.setText(str4 != null ? NumberUtils.toPersian(str4) : BuildConfig.FLAVOR);
        TextView textView4 = myViewHolder.textViewpPostalCodeEntry;
        String str5 = deliveryInfoObject.postal_code;
        textView4.setText(str5 != null ? NumberUtils.toPersian(str5) : BuildConfig.FLAVOR);
        TextView textView5 = myViewHolder.textViewAddressFull;
        String str6 = deliveryInfoObject.address;
        if (str6 == null) {
            str6 = BuildConfig.FLAVOR;
        }
        textView5.setText(str6);
        DeliveryCityObject deliveryCityObject = deliveryInfoObject.city;
        if (deliveryCityObject != null) {
            TextView textView6 = myViewHolder.textViewCityEntry;
            String str7 = deliveryCityObject.name;
            if (str7 == null) {
                str7 = BuildConfig.FLAVOR;
            }
            textView6.setText(str7);
        }
        DeliveryProvinceObject deliveryProvinceObject = deliveryInfoObject.province;
        if (deliveryProvinceObject != null) {
            TextView textView7 = myViewHolder.textViewproveneEntry;
            String str8 = deliveryProvinceObject.name;
            if (str8 != null) {
                str2 = str8;
            }
            textView7.setText(str2);
        }
        if (this.isInList && this.hasSelectButton) {
            myViewHolder.buttonSelectAddress.setVisibility(0);
            DeliveryInfosListFragment.SelectButtonTypeEnum selectButtonTypeEnum = this.selectButtonType;
            DeliveryInfosListFragment.SelectButtonTypeEnum selectButtonTypeEnum2 = DeliveryInfosListFragment.SelectButtonTypeEnum.selectToSetDefault;
            if (selectButtonTypeEnum == selectButtonTypeEnum2 && ((DeliveryInfoObject) myViewHolder.item).is_default) {
                myViewHolder.textViewButtonSelect.setTextColor(this.mContext.getResources().getColor(R.color.grey_500));
                myViewHolder.textViewButtonSelect.setText("پیش فرض");
            } else {
                myViewHolder.textViewButtonSelect.setTextColor(this.mContext.getResources().getColor(R.color.colorPrimary));
                if (this.selectButtonType == selectButtonTypeEnum2) {
                    myViewHolder.textViewButtonSelect.setText("انتخاب به عنوان پیش فرض");
                } else {
                    myViewHolder.textViewButtonSelect.setText("انتخاب");
                }
            }
        } else {
            myViewHolder.buttonSelectAddress.setVisibility(8);
        }
        if (this.isInList) {
            myViewHolder.buttonChangeAddress.setVisibility(8);
        } else {
            myViewHolder.delete.setVisibility(4);
            myViewHolder.edit.setVisibility(4);
            myViewHolder.buttonSelectAddress.setVisibility(8);
        }
        bindMapLocation(myViewHolder);
    }
}

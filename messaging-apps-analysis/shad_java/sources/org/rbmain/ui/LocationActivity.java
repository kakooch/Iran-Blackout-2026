package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Property;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidMessenger.utilites.AppFavorUtils;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PatternItem;
import ir.aaap.messengercore.db.DBHelper;
import ir.aaap.messengercore.model.LocationObject;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.LocationController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserObject;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatPhoto;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$GeoPoint;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$TL_channelLocation;
import org.rbmain.tgnet.TLRPC$TL_channels_editLocation;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_geoPoint;
import org.rbmain.tgnet.TLRPC$TL_inputGeoPoint;
import org.rbmain.tgnet.TLRPC$TL_messageActionGeoProximityReached;
import org.rbmain.tgnet.TLRPC$TL_messageMediaGeo;
import org.rbmain.tgnet.TLRPC$TL_messageMediaGeoLive;
import org.rbmain.tgnet.TLRPC$TL_messageMediaVenue;
import org.rbmain.tgnet.TLRPC$TL_messages_getRecentLocations;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserProfilePhoto;
import org.rbmain.tgnet.TLRPC$messages_Messages;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Adapters.BaseLocationAdapter;
import org.rbmain.ui.Adapters.LocationActivityAdapter;
import org.rbmain.ui.Adapters.LocationActivitySearchAdapter;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.LocationCell;
import org.rbmain.ui.Cells.LocationDirectionCell;
import org.rbmain.ui.Cells.LocationLoadingCell;
import org.rbmain.ui.Cells.LocationPoweredCell;
import org.rbmain.ui.Cells.SendLocationCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.SharingLiveLocationCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.HintView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.MapPlaceholderDrawable;
import org.rbmain.ui.Components.ProximitySheet;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.UndoView;

/* loaded from: classes4.dex */
public class LocationActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private LocationActivityAdapter adapter;
    private AnimatorSet animatorSet;
    private int askWithRadius;
    private boolean canUndo;
    private TLRPC$TL_channelLocation chatLocation;
    private boolean currentMapStyleDark;
    private LocationActivityDelegate delegate;
    private long dialogId;
    private ImageView emptyImageView;
    private TextView emptySubtitleTextView;
    private TextView emptyTitleTextView;
    private LinearLayout emptyView;
    private boolean firstWas;
    private CameraUpdate forceUpdate;
    private GoogleMap googleMap;
    private HintView hintView;
    private TLRPC$TL_channelLocation initialLocation;
    private Marker lastPressedMarker;
    private FrameLayout lastPressedMarkerView;
    private VenueLocation lastPressedVenue;
    private LinearLayoutManager layoutManager;
    private RecyclerListView listView;
    private ImageView locationButton;
    private int locationType;
    private ActionBarMenuItem mapTypeButton;
    private MapView mapView;
    private FrameLayout mapViewClip;
    private boolean mapsInitialized;
    private Runnable markAsReadRunnable;
    private View markerImageView;
    private int markerTop;
    private MessageObject messageObject;
    private CameraUpdate moveToBounds;
    private Location myLocation;
    private boolean onResumeCalled;
    private ActionBarMenuItem otherItem;
    private MapOverlayView overlayView;
    private ChatActivity parentFragment;
    private double previousRadius;
    private boolean proximityAnimationInProgress;
    private ImageView proximityButton;
    private Circle proximityCircle;
    private ProximitySheet proximitySheet;
    private boolean scrolling;
    private LocationActivitySearchAdapter searchAdapter;
    private SearchButton searchAreaButton;
    private boolean searchInProgress;
    private ActionBarMenuItem searchItem;
    private RecyclerListView searchListView;
    private boolean searchWas;
    private boolean searchedForCustomLocations;
    private boolean searching;
    private View shadow;
    private Drawable shadowDrawable;
    private Runnable updateRunnable;
    private Location userLocation;
    private boolean userLocationMoved;
    private float yOffset;
    private UndoView[] undoView = new UndoView[2];
    private boolean checkGpsEnabled = true;
    private boolean isFirstLocation = true;
    private boolean firstFocus = true;
    private ArrayList<LiveLocation> markers = new ArrayList<>();
    private SparseArray<LiveLocation> markersMap = new SparseArray<>();
    private ArrayList<VenueLocation> placeMarkers = new ArrayList<>();
    private boolean checkPermission = true;
    private boolean checkBackgroundPermission = true;
    private int overScrollHeight = (AndroidUtilities.displaySize.x - ActionBar.getCurrentActionBarHeight()) - AndroidUtilities.dp(66.0f);
    private long updateLiveLocationPeriodMillis = 5000;
    private final Runnable updateLiveLocationRunnable = new Runnable() { // from class: org.rbmain.ui.LocationActivity.1
        @Override // java.lang.Runnable
        public void run() {
            LocationController.SharingLocationInfo sharingLocationInfo;
            if (LocationActivity.this.messageObject.isLiveLocation() && ((sharingLocationInfo = LocationActivity.this.getLocationController().getSharingLocationInfo(LocationActivity.this.messageObject.getDialogId())) == null || sharingLocationInfo.messageObject.messageOwner.id != LocationActivity.this.messageObject.messageOwner.id)) {
                LocationActivity.this.getMessageProxy().requestLiveLocationUpdate(LocationActivity.this.messageObject.messageOwner, LocationActivity.this.updateLiveLocationPeriodMillis);
                AndroidUtilities.runOnUIThread(LocationActivity.this.updateLiveLocationRunnable, LocationActivity.this.updateLiveLocationPeriodMillis);
            }
            if (LocationActivity.this.adapter == null || LocationActivity.this.adapter.currentLiveLocations == null) {
                return;
            }
            Iterator<LiveLocation> it = LocationActivity.this.adapter.currentLiveLocations.iterator();
            while (it.hasNext()) {
                LocationActivity.this.getMessageProxy().requestLiveLocationUpdate(it.next().object, LocationActivity.this.updateLiveLocationPeriodMillis);
            }
        }
    };
    private Bitmap[] bitmapCache = new Bitmap[7];

    public static class LiveLocation {
        public TLRPC$Chat chat;
        public Marker directionMarker;
        public boolean hasRotation;
        public int id;
        public Marker marker;
        public TLRPC$Message object;
        public TLRPC$User user;
    }

    public interface LocationActivityDelegate {
        void didSelectLocation(TLRPC$MessageMedia tLRPC$MessageMedia, int i, boolean z, int i2);
    }

    public static class VenueLocation {
        public Marker marker;
        public int num;
        public TLRPC$TL_messageMediaVenue venue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createView$7(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled(MotionEvent motionEvent) {
        return false;
    }

    static /* synthetic */ float access$3616(LocationActivity locationActivity, float f) {
        float f2 = locationActivity.yOffset + f;
        locationActivity.yOffset = f2;
        return f2;
    }

    private static class SearchButton extends TextView {
        private float additionanTranslationY;
        private float currentTranslationY;

        public SearchButton(Context context) {
            super(context);
        }

        @Override // android.view.View
        public float getTranslationX() {
            return this.additionanTranslationY;
        }

        @Override // android.view.View
        public void setTranslationX(float f) {
            this.additionanTranslationY = f;
            updateTranslationY();
        }

        public void setTranslation(float f) {
            this.currentTranslationY = f;
            updateTranslationY();
        }

        private void updateTranslationY() {
            setTranslationY(this.currentTranslationY + this.additionanTranslationY);
        }
    }

    public class MapOverlayView extends FrameLayout {
        private HashMap<Marker, View> views;

        public MapOverlayView(Context context) {
            super(context);
            this.views = new HashMap<>();
        }

        public void addInfoView(Marker marker) {
            final VenueLocation venueLocation = (VenueLocation) marker.getTag();
            if (venueLocation == null || LocationActivity.this.lastPressedVenue == venueLocation) {
                return;
            }
            LocationActivity.this.showSearchPlacesButton(false);
            if (LocationActivity.this.lastPressedMarker != null) {
                removeInfoView(LocationActivity.this.lastPressedMarker);
                LocationActivity.this.lastPressedMarker = null;
            }
            LocationActivity.this.lastPressedVenue = venueLocation;
            LocationActivity.this.lastPressedMarker = marker;
            Context context = getContext();
            FrameLayout frameLayout = new FrameLayout(context);
            addView(frameLayout, LayoutHelper.createFrame(-2, 114.0f));
            LocationActivity.this.lastPressedMarkerView = new FrameLayout(context);
            LocationActivity.this.lastPressedMarkerView.setBackgroundResource(R.drawable.venue_tooltip);
            LocationActivity.this.lastPressedMarkerView.getBackground().setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogBackground), PorterDuff.Mode.MULTIPLY));
            frameLayout.addView(LocationActivity.this.lastPressedMarkerView, LayoutHelper.createFrame(-2, 71.0f));
            LocationActivity.this.lastPressedMarkerView.setAlpha(0.0f);
            LocationActivity.this.lastPressedMarkerView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LocationActivity$MapOverlayView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addInfoView$1(venueLocation, view);
                }
            });
            TextView textView = new TextView(context);
            textView.setTextSize(1, 16.0f);
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setSingleLine(true);
            textView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
            textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            textView.setGravity(LocaleController.isRTL ? 5 : 3);
            LocationActivity.this.lastPressedMarkerView.addView(textView, LayoutHelper.createFrame(-2, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 18.0f, 10.0f, 18.0f, 0.0f));
            TextView textView2 = new TextView(context);
            textView2.setTextSize(1, 14.0f);
            textView2.setMaxLines(1);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setSingleLine(true);
            textView2.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText3));
            textView2.setGravity(LocaleController.isRTL ? 5 : 3);
            LocationActivity.this.lastPressedMarkerView.addView(textView2, LayoutHelper.createFrame(-2, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 18.0f, 32.0f, 18.0f, 0.0f));
            textView.setText(venueLocation.venue.title);
            textView2.setText(LocaleController.getString("TapToSendLocation", R.string.TapToSendLocation));
            final FrameLayout frameLayout2 = new FrameLayout(context);
            frameLayout2.setBackground(Theme.createCircleDrawable(AndroidUtilities.dp(36.0f), LocationCell.getColorForIndex(venueLocation.num)));
            frameLayout.addView(frameLayout2, LayoutHelper.createFrame(36, 36.0f, 81, 0.0f, 0.0f, 0.0f, 4.0f));
            BackupImageView backupImageView = new BackupImageView(context);
            backupImageView.setImage("https://ss3.4sqi.net/img/categories_v2/" + venueLocation.venue.venue_type + "_64.png", null, null);
            frameLayout2.addView(backupImageView, LayoutHelper.createFrame(30, 30, 17));
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.LocationActivity.MapOverlayView.1
                private final float[] animatorValues = {0.0f, 1.0f};
                private boolean startedInner;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float interpolation;
                    float fLerp = AndroidUtilities.lerp(this.animatorValues, valueAnimator.getAnimatedFraction());
                    if (fLerp >= 0.7f && !this.startedInner && LocationActivity.this.lastPressedMarkerView != null) {
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(ObjectAnimator.ofFloat(LocationActivity.this.lastPressedMarkerView, (Property<FrameLayout, Float>) View.SCALE_X, 0.0f, 1.0f), ObjectAnimator.ofFloat(LocationActivity.this.lastPressedMarkerView, (Property<FrameLayout, Float>) View.SCALE_Y, 0.0f, 1.0f), ObjectAnimator.ofFloat(LocationActivity.this.lastPressedMarkerView, (Property<FrameLayout, Float>) View.ALPHA, 0.0f, 1.0f));
                        animatorSet.setInterpolator(new OvershootInterpolator(1.02f));
                        animatorSet.setDuration(250L);
                        animatorSet.start();
                        this.startedInner = true;
                    }
                    if (fLerp <= 0.5f) {
                        interpolation = CubicBezierInterpolator.EASE_OUT.getInterpolation(fLerp / 0.5f) * 1.1f;
                    } else if (fLerp <= 0.75f) {
                        interpolation = 1.1f - (CubicBezierInterpolator.EASE_OUT.getInterpolation((fLerp - 0.5f) / 0.25f) * 0.2f);
                    } else {
                        interpolation = (CubicBezierInterpolator.EASE_OUT.getInterpolation((fLerp - 0.75f) / 0.25f) * 0.1f) + 0.9f;
                    }
                    frameLayout2.setScaleX(interpolation);
                    frameLayout2.setScaleY(interpolation);
                }
            });
            valueAnimatorOfFloat.setDuration(360L);
            valueAnimatorOfFloat.start();
            this.views.put(marker, frameLayout);
            LocationActivity.this.googleMap.animateCamera(CameraUpdateFactory.newLatLng(marker.getPosition()), 300, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$addInfoView$1(final VenueLocation venueLocation, View view) {
            if (LocationActivity.this.parentFragment == null || !LocationActivity.this.parentFragment.isInScheduleMode()) {
                LocationActivity.this.delegate.didSelectLocation(venueLocation.venue, LocationActivity.this.locationType, true, 0);
                LocationActivity.this.finishFragment();
            } else {
                AlertsCreator.createScheduleDatePickerDialog(LocationActivity.this.getParentActivity(), LocationActivity.this.parentFragment.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.LocationActivity$MapOverlayView$$ExternalSyntheticLambda1
                    @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                    public final void didSelectDate(boolean z, int i) {
                        this.f$0.lambda$addInfoView$0(venueLocation, z, i);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$addInfoView$0(VenueLocation venueLocation, boolean z, int i) {
            LocationActivity.this.delegate.didSelectLocation(venueLocation.venue, LocationActivity.this.locationType, z, i);
            LocationActivity.this.finishFragment();
        }

        public void removeInfoView(Marker marker) {
            View view = this.views.get(marker);
            if (view != null) {
                removeView(view);
                this.views.remove(marker);
            }
        }

        public void updatePositions() {
            if (LocationActivity.this.googleMap == null) {
                return;
            }
            Projection projection = LocationActivity.this.googleMap.getProjection();
            for (Map.Entry<Marker, View> entry : this.views.entrySet()) {
                Marker key = entry.getKey();
                View value = entry.getValue();
                Point screenLocation = projection.toScreenLocation(key.getPosition());
                value.setTranslationX(screenLocation.x - (value.getMeasuredWidth() / 2));
                value.setTranslationY((screenLocation.y - value.getMeasuredHeight()) + AndroidUtilities.dp(22.0f));
            }
        }
    }

    public LocationActivity(int i) {
        this.locationType = i;
        AndroidUtilities.fixGoogleMapsBug();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        getNotificationCenter().addObserver(this, NotificationCenter.closeChats);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.locationPermissionGranted);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.liveLocationsChanged);
        MessageObject messageObject = this.messageObject;
        if (messageObject == null || !messageObject.isLiveLocation()) {
            return true;
        }
        getNotificationCenter().addObserver(this, NotificationCenter.didReceiveNewMessages);
        getNotificationCenter().addObserver(this, NotificationCenter.replaceMessagesObjects);
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.locationPermissionGranted);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.liveLocationsChanged);
        getNotificationCenter().removeObserver(this, NotificationCenter.closeChats);
        getNotificationCenter().removeObserver(this, NotificationCenter.didReceiveNewMessages);
        getNotificationCenter().removeObserver(this, NotificationCenter.replaceMessagesObjects);
        try {
            GoogleMap googleMap = this.googleMap;
            if (googleMap != null) {
                googleMap.setMyLocationEnabled(false);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            MapView mapView = this.mapView;
            if (mapView != null) {
                mapView.onDestroy();
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        UndoView[] undoViewArr = this.undoView;
        if (undoViewArr[0] != null) {
            undoViewArr[0].hide(true, 0);
        }
        LocationActivityAdapter locationActivityAdapter = this.adapter;
        if (locationActivityAdapter != null) {
            locationActivityAdapter.destroy();
        }
        LocationActivitySearchAdapter locationActivitySearchAdapter = this.searchAdapter;
        if (locationActivitySearchAdapter != null) {
            locationActivitySearchAdapter.destroy();
        }
        Runnable runnable = this.updateRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.updateRunnable = null;
        }
        Runnable runnable2 = this.markAsReadRunnable;
        if (runnable2 != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable2);
            this.markAsReadRunnable = null;
        }
    }

    private UndoView getUndoView() {
        if (this.undoView[0].getVisibility() == 0) {
            UndoView[] undoViewArr = this.undoView;
            UndoView undoView = undoViewArr[0];
            undoViewArr[0] = undoViewArr[1];
            undoViewArr[1] = undoView;
            undoView.hide(true, 2);
            this.mapViewClip.removeView(this.undoView[0]);
            this.mapViewClip.addView(this.undoView[0]);
        }
        return this.undoView[0];
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        FrameLayout.LayoutParams layoutParams;
        int i;
        Drawable drawable;
        Drawable drawable2;
        FrameLayout.LayoutParams layoutParams2;
        int i2;
        int i3;
        this.searchWas = false;
        this.searching = false;
        this.searchInProgress = false;
        LocationActivityAdapter locationActivityAdapter = this.adapter;
        if (locationActivityAdapter != null) {
            locationActivityAdapter.destroy();
        }
        LocationActivitySearchAdapter locationActivitySearchAdapter = this.searchAdapter;
        if (locationActivitySearchAdapter != null) {
            locationActivitySearchAdapter.destroy();
        }
        if (this.chatLocation != null) {
            Location location = new Location("network");
            this.userLocation = location;
            location.setLatitude(this.chatLocation.geo_point.lat);
            this.userLocation.setLongitude(this.chatLocation.geo_point._long);
        } else if (this.messageObject != null) {
            Location location2 = new Location("network");
            this.userLocation = location2;
            location2.setLatitude(this.messageObject.messageOwner.media.geo.lat);
            this.userLocation.setLongitude(this.messageObject.messageOwner.media.geo._long);
        }
        ActionBar actionBar = this.actionBar;
        int i4 = Theme.key_dialogBackground;
        actionBar.setBackgroundColor(Theme.getColor(i4));
        ActionBar actionBar2 = this.actionBar;
        int i5 = Theme.key_dialogTextBlack;
        actionBar2.setTitleColor(Theme.getColor(i5));
        this.actionBar.setItemsColor(Theme.getColor(i5), false);
        this.actionBar.setItemsBackgroundColor(Theme.getColor(Theme.key_dialogButtonSelector), false);
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        if (AndroidUtilities.isTablet()) {
            this.actionBar.setOccupyStatusBar(false);
        }
        this.actionBar.setAddToContainer(false);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.LocationActivity.2
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i6) {
                if (i6 == -1) {
                    LocationActivity.this.finishFragment();
                    return;
                }
                if (i6 != 1) {
                    if (i6 == 5) {
                        LocationActivity.this.openShareLiveLocation(0);
                        return;
                    }
                    return;
                }
                try {
                    double d = LocationActivity.this.messageObject.messageOwner.media.geo.lat;
                    double d2 = LocationActivity.this.messageObject.messageOwner.media.geo._long;
                    LocationActivity.this.getParentActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("geo:" + d + "," + d2 + "?q=" + d + "," + d2)));
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        });
        ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
        if (this.chatLocation != null) {
            this.actionBar.setTitle(LocaleController.getString("ChatLocation", R.string.ChatLocation));
        } else {
            MessageObject messageObject = this.messageObject;
            if (messageObject != null) {
                if (messageObject.isLiveLocation()) {
                    this.actionBar.setTitle(LocaleController.getString("AttachLiveLocation", R.string.AttachLiveLocation));
                } else {
                    String str = this.messageObject.messageOwner.media.title;
                    if (str != null && str.length() > 0) {
                        this.actionBar.setTitle(LocaleController.getString("SharedPlace", R.string.SharedPlace));
                    } else {
                        this.actionBar.setTitle(LocaleController.getString("ChatLocation", R.string.ChatLocation));
                    }
                    ActionBarMenuItem actionBarMenuItemAddItem = actionBarMenuCreateMenu.addItem(0, R.drawable.ic_ab_other);
                    this.otherItem = actionBarMenuItemAddItem;
                    actionBarMenuItemAddItem.addSubItem(1, R.drawable.msg_openin, LocaleController.getString("OpenInExternalApp", R.string.OpenInExternalApp));
                    this.otherItem.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
                }
            } else {
                this.actionBar.setTitle(LocaleController.getString("ShareLocation", R.string.ShareLocation));
                if (this.locationType != 4) {
                    this.overlayView = new MapOverlayView(context);
                    ActionBarMenuItem actionBarMenuItemSearchListener = actionBarMenuCreateMenu.addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: org.rbmain.ui.LocationActivity.3
                        @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                        public void onSearchExpand() {
                            LocationActivity.this.searching = true;
                        }

                        @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                        public void onSearchCollapse() {
                            LocationActivity.this.searching = false;
                            LocationActivity.this.searchWas = false;
                            LocationActivity.this.searchAdapter.searchDelayed(null, null);
                            LocationActivity.this.updateEmptyView();
                        }

                        @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                        public void onTextChanged(EditText editText) {
                            if (LocationActivity.this.searchAdapter == null) {
                                return;
                            }
                            String string = editText.getText().toString();
                            if (string.length() != 0) {
                                LocationActivity.this.searchWas = true;
                                LocationActivity.this.searchItem.setShowSearchProgress(true);
                                if (LocationActivity.this.otherItem != null) {
                                    LocationActivity.this.otherItem.setVisibility(8);
                                }
                                LocationActivity.this.listView.setVisibility(8);
                                LocationActivity.this.mapViewClip.setVisibility(8);
                                if (LocationActivity.this.searchListView.getAdapter() != LocationActivity.this.searchAdapter) {
                                    LocationActivity.this.searchListView.setAdapter(LocationActivity.this.searchAdapter);
                                }
                                LocationActivity.this.searchListView.setVisibility(0);
                                LocationActivity locationActivity = LocationActivity.this;
                                locationActivity.searchInProgress = locationActivity.searchAdapter.getItemCount() == 0;
                            } else {
                                if (LocationActivity.this.otherItem != null) {
                                    LocationActivity.this.otherItem.setVisibility(0);
                                }
                                LocationActivity.this.listView.setVisibility(0);
                                LocationActivity.this.mapViewClip.setVisibility(0);
                                LocationActivity.this.searchListView.setAdapter(null);
                                LocationActivity.this.searchListView.setVisibility(8);
                            }
                            LocationActivity.this.updateEmptyView();
                            LocationActivity.this.searchAdapter.searchDelayed(string, LocationActivity.this.userLocation);
                        }
                    });
                    this.searchItem = actionBarMenuItemSearchListener;
                    actionBarMenuItemSearchListener.setSearchFieldHint(LocaleController.getString("Search", R.string.Search));
                    this.searchItem.setContentDescription(LocaleController.getString("Search", R.string.Search));
                    EditTextBoldCursor searchField = this.searchItem.getSearchField();
                    searchField.setTextColor(Theme.getColor(i5));
                    searchField.setCursorColor(Theme.getColor(i5));
                    searchField.setHintTextColor(Theme.getColor(Theme.key_chat_messagePanelHint));
                }
            }
        }
        FrameLayout frameLayout = new FrameLayout(context) { // from class: org.rbmain.ui.LocationActivity.4
            private boolean first = true;

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i6, int i7, int i8, int i9) {
                super.onLayout(z, i6, i7, i8, i9);
                if (z) {
                    LocationActivity.this.fixLayoutInternal(this.first);
                    this.first = false;
                } else {
                    LocationActivity.this.updateClipView(true);
                }
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View view, long j) {
                boolean zDrawChild = super.drawChild(canvas, view, j);
                if (view == ((BaseFragment) LocationActivity.this).actionBar && ((BaseFragment) LocationActivity.this).parentLayout != null) {
                    ((BaseFragment) LocationActivity.this).parentLayout.drawHeaderShadow(canvas, ((BaseFragment) LocationActivity.this).actionBar.getMeasuredHeight());
                }
                return zDrawChild;
            }
        };
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor(i4));
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i4), PorterDuff.Mode.MULTIPLY));
        final Rect rect = new Rect();
        this.shadowDrawable.getPadding(rect);
        int i6 = this.locationType;
        if (i6 == 0 || i6 == 1) {
            layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.dp(21.0f) + rect.top);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.dp(6.0f) + rect.top);
        }
        FrameLayout.LayoutParams layoutParams3 = layoutParams;
        layoutParams3.gravity = 83;
        FrameLayout frameLayout3 = new FrameLayout(context) { // from class: org.rbmain.ui.LocationActivity.5
            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i7, int i8) {
                super.onMeasure(i7, i8);
                if (LocationActivity.this.overlayView != null) {
                    LocationActivity.this.overlayView.updatePositions();
                }
            }
        };
        this.mapViewClip = frameLayout3;
        frameLayout3.setBackgroundDrawable(new MapPlaceholderDrawable());
        if (this.messageObject == null && ((i3 = this.locationType) == 0 || i3 == 1)) {
            SearchButton searchButton = new SearchButton(context);
            this.searchAreaButton = searchButton;
            searchButton.setTranslationX(-AndroidUtilities.dp(80.0f));
            Drawable drawableCreateSimpleSelectorRoundRectDrawable = Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(40.0f), Theme.getColor(Theme.key_location_actionBackground), Theme.getColor(Theme.key_location_actionPressedBackground));
            int i7 = Build.VERSION.SDK_INT;
            if (i7 < 21) {
                Drawable drawableMutate2 = context.getResources().getDrawable(R.drawable.places_btn).mutate();
                drawableMutate2.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
                CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate2, drawableCreateSimpleSelectorRoundRectDrawable, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f));
                combinedDrawable.setFullsize(true);
                drawableCreateSimpleSelectorRoundRectDrawable = combinedDrawable;
            } else {
                StateListAnimator stateListAnimator = new StateListAnimator();
                int[] iArr = {android.R.attr.state_pressed};
                SearchButton searchButton2 = this.searchAreaButton;
                Property property = View.TRANSLATION_Z;
                stateListAnimator.addState(iArr, ObjectAnimator.ofFloat(searchButton2, (Property<SearchButton, Float>) property, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f)).setDuration(200L));
                stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this.searchAreaButton, (Property<SearchButton, Float>) property, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
                this.searchAreaButton.setStateListAnimator(stateListAnimator);
                this.searchAreaButton.setOutlineProvider(new ViewOutlineProvider(this) { // from class: org.rbmain.ui.LocationActivity.6
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight(), view.getMeasuredHeight() / 2);
                    }
                });
            }
            this.searchAreaButton.setBackgroundDrawable(drawableCreateSimpleSelectorRoundRectDrawable);
            this.searchAreaButton.setTextColor(Theme.getColor(Theme.key_location_actionActiveIcon));
            this.searchAreaButton.setTextSize(1, 14.0f);
            this.searchAreaButton.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            this.searchAreaButton.setText(LocaleController.getString("PlacesInThisArea", R.string.PlacesInThisArea));
            this.searchAreaButton.setGravity(17);
            this.searchAreaButton.setPadding(AndroidUtilities.dp(20.0f), 0, AndroidUtilities.dp(20.0f), 0);
            this.mapViewClip.addView(this.searchAreaButton, LayoutHelper.createFrame(-2, i7 >= 21 ? 40.0f : 44.0f, 49, 80.0f, 12.0f, 80.0f, 0.0f));
            this.searchAreaButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createView$0(view);
                }
            });
        }
        int i8 = Theme.key_location_actionIcon;
        ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, null, 0, Theme.getColor(i8));
        this.mapTypeButton = actionBarMenuItem;
        actionBarMenuItem.setClickable(true);
        this.mapTypeButton.setSubMenuOpenSide(2);
        this.mapTypeButton.setAdditionalXOffset(AndroidUtilities.dp(10.0f));
        this.mapTypeButton.setAdditionalYOffset(-AndroidUtilities.dp(10.0f));
        this.mapTypeButton.addSubItem(2, R.drawable.msg_map, LocaleController.getString("Map", R.string.Map));
        this.mapTypeButton.addSubItem(3, R.drawable.msg_satellite, LocaleController.getString("Satellite", R.string.Satellite));
        this.mapTypeButton.addSubItem(4, R.drawable.msg_hybrid, LocaleController.getString("Hybrid", R.string.Hybrid));
        this.mapTypeButton.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        int iDp = AndroidUtilities.dp(40.0f);
        int i9 = Theme.key_location_actionBackground;
        int color = Theme.getColor(i9);
        int i10 = Theme.key_location_actionPressedBackground;
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(iDp, color, Theme.getColor(i10));
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 21) {
            Drawable drawableMutate3 = context.getResources().getDrawable(R.drawable.floating_shadow_profile).mutate();
            drawableMutate3.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable2 = new CombinedDrawable(drawableMutate3, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
            combinedDrawable2.setIconSize(AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
            i = i9;
            drawable = combinedDrawable2;
        } else {
            StateListAnimator stateListAnimator2 = new StateListAnimator();
            int[] iArr2 = {android.R.attr.state_pressed};
            ActionBarMenuItem actionBarMenuItem2 = this.mapTypeButton;
            Property property2 = View.TRANSLATION_Z;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionBarMenuItem2, (Property<ActionBarMenuItem, Float>) property2, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f));
            i = i9;
            stateListAnimator2.addState(iArr2, objectAnimatorOfFloat.setDuration(200L));
            stateListAnimator2.addState(new int[0], ObjectAnimator.ofFloat(this.mapTypeButton, (Property<ActionBarMenuItem, Float>) property2, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
            this.mapTypeButton.setStateListAnimator(stateListAnimator2);
            this.mapTypeButton.setOutlineProvider(new ViewOutlineProvider(this) { // from class: org.rbmain.ui.LocationActivity.7
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
                }
            });
            drawable = drawableCreateSimpleSelectorCircleDrawable;
        }
        this.mapTypeButton.setBackgroundDrawable(drawable);
        this.mapTypeButton.setIcon(R.drawable.location_type);
        this.mapViewClip.addView(this.mapTypeButton, LayoutHelper.createFrame(i11 >= 21 ? 40 : 44, i11 >= 21 ? 40.0f : 44.0f, 53, 0.0f, 12.0f, 12.0f, 0.0f));
        this.mapTypeButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$1(view);
            }
        });
        this.mapTypeButton.setDelegate(new ActionBarMenuItem.ActionBarMenuItemDelegate() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda28
            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemDelegate
            public final void onItemClick(int i12) {
                this.f$0.lambda$createView$2(i12);
            }
        });
        this.locationButton = new ImageView(context);
        Drawable drawableCreateSimpleSelectorCircleDrawable2 = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(40.0f), Theme.getColor(i), Theme.getColor(i10));
        if (i11 < 21) {
            Drawable drawableMutate4 = context.getResources().getDrawable(R.drawable.floating_shadow_profile).mutate();
            drawableMutate4.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable3 = new CombinedDrawable(drawableMutate4, drawableCreateSimpleSelectorCircleDrawable2, 0, 0);
            combinedDrawable3.setIconSize(AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
            drawable2 = combinedDrawable3;
        } else {
            StateListAnimator stateListAnimator3 = new StateListAnimator();
            int[] iArr3 = {android.R.attr.state_pressed};
            ImageView imageView = this.locationButton;
            Property property3 = View.TRANSLATION_Z;
            stateListAnimator3.addState(iArr3, ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property3, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f)).setDuration(200L));
            stateListAnimator3.addState(new int[0], ObjectAnimator.ofFloat(this.locationButton, (Property<ImageView, Float>) property3, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
            this.locationButton.setStateListAnimator(stateListAnimator3);
            this.locationButton.setOutlineProvider(new ViewOutlineProvider(this) { // from class: org.rbmain.ui.LocationActivity.8
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
                }
            });
            drawable2 = drawableCreateSimpleSelectorCircleDrawable2;
        }
        this.locationButton.setBackgroundDrawable(drawable2);
        this.locationButton.setImageResource(R.drawable.location_current);
        this.locationButton.setScaleType(ImageView.ScaleType.CENTER);
        ImageView imageView2 = this.locationButton;
        int i12 = Theme.key_location_actionActiveIcon;
        imageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i12), PorterDuff.Mode.MULTIPLY));
        this.locationButton.setTag(Integer.valueOf(i12));
        this.locationButton.setContentDescription(LocaleController.getString("AccDescrMyLocation", R.string.AccDescrMyLocation));
        FrameLayout.LayoutParams layoutParamsCreateFrame = LayoutHelper.createFrame(i11 >= 21 ? 40 : 44, i11 >= 21 ? 40.0f : 44.0f, 85, 0.0f, 0.0f, 12.0f, 12.0f);
        layoutParamsCreateFrame.bottomMargin += layoutParams3.height - rect.top;
        this.mapViewClip.addView(this.locationButton, layoutParamsCreateFrame);
        this.locationButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$3(view);
            }
        });
        this.proximityButton = new ImageView(context);
        Drawable drawableCreateSimpleSelectorCircleDrawable3 = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(40.0f), Theme.getColor(i), Theme.getColor(i10));
        if (i11 < 21) {
            Drawable drawableMutate5 = context.getResources().getDrawable(R.drawable.floating_shadow_profile).mutate();
            drawableMutate5.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable4 = new CombinedDrawable(drawableMutate5, drawableCreateSimpleSelectorCircleDrawable3, 0, 0);
            combinedDrawable4.setIconSize(AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
            drawableCreateSimpleSelectorCircleDrawable3 = combinedDrawable4;
            layoutParams2 = layoutParams3;
        } else {
            StateListAnimator stateListAnimator4 = new StateListAnimator();
            int[] iArr4 = {android.R.attr.state_pressed};
            ImageView imageView3 = this.proximityButton;
            Property property4 = View.TRANSLATION_Z;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(imageView3, (Property<ImageView, Float>) property4, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f));
            layoutParams2 = layoutParams3;
            stateListAnimator4.addState(iArr4, objectAnimatorOfFloat2.setDuration(200L));
            stateListAnimator4.addState(new int[0], ObjectAnimator.ofFloat(this.proximityButton, (Property<ImageView, Float>) property4, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
            this.proximityButton.setStateListAnimator(stateListAnimator4);
            this.proximityButton.setOutlineProvider(new ViewOutlineProvider(this) { // from class: org.rbmain.ui.LocationActivity.9
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
                }
            });
        }
        this.proximityButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i8), PorterDuff.Mode.MULTIPLY));
        this.proximityButton.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable3);
        this.proximityButton.setScaleType(ImageView.ScaleType.CENTER);
        this.proximityButton.setContentDescription(LocaleController.getString("AccDescrLocationNotify", R.string.AccDescrLocationNotify));
        this.mapViewClip.addView(this.proximityButton, LayoutHelper.createFrame(i11 >= 21 ? 40 : 44, i11 >= 21 ? 40.0f : 44.0f, 53, 0.0f, 62.0f, 12.0f, 0.0f));
        this.proximityButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$6(view);
            }
        });
        TLRPC$Chat chat = ((int) this.dialogId) < 0 ? getMessagesController().getChat(Integer.valueOf(-((int) this.dialogId))) : null;
        MessageObject messageObject2 = this.messageObject;
        if (messageObject2 == null || !messageObject2.isLiveLocation() || this.messageObject.isExpiredLiveLocation(getConnectionsManager().getCurrentTime()) || (ChatObject.isChannel(chat) && !chat.megagroup)) {
            this.proximityButton.setVisibility(8);
            this.proximityButton.setImageResource(R.drawable.msg_location_alert);
        } else {
            LocationController.SharingLocationInfo sharingLocationInfo = getLocationController().getSharingLocationInfo(this.dialogId);
            if (sharingLocationInfo != null && sharingLocationInfo.proximityMeters > 0) {
                this.proximityButton.setImageResource(R.drawable.msg_location_alert2);
            } else {
                if (((int) this.dialogId) > 0 && this.messageObject.getFromChatId() == getUserConfig().getClientUserId()) {
                    this.proximityButton.setVisibility(4);
                    this.proximityButton.setAlpha(0.0f);
                    this.proximityButton.setScaleX(0.4f);
                    this.proximityButton.setScaleY(0.4f);
                }
                this.proximityButton.setImageResource(R.drawable.msg_location_alert);
            }
        }
        HintView hintView = new HintView(context, 6, true);
        this.hintView = hintView;
        hintView.setVisibility(4);
        this.hintView.setShowingDuration(4000L);
        this.mapViewClip.addView(this.hintView, LayoutHelper.createFrame(-2, -2.0f, 51, 10.0f, 0.0f, 10.0f, 0.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        this.emptyView = linearLayout;
        linearLayout.setOrientation(1);
        this.emptyView.setGravity(1);
        this.emptyView.setPadding(0, AndroidUtilities.dp(160.0f), 0, 0);
        this.emptyView.setVisibility(8);
        frameLayout2.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        this.emptyView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return LocationActivity.lambda$createView$7(view, motionEvent);
            }
        });
        ImageView imageView4 = new ImageView(context);
        this.emptyImageView = imageView4;
        imageView4.setImageResource(R.drawable.location_empty);
        this.emptyImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogEmptyImage), PorterDuff.Mode.MULTIPLY));
        this.emptyView.addView(this.emptyImageView, LayoutHelper.createLinear(-2, -2));
        TextView textView = new TextView(context);
        this.emptyTitleTextView = textView;
        int i13 = Theme.key_dialogEmptyText;
        textView.setTextColor(Theme.getColor(i13));
        this.emptyTitleTextView.setGravity(17);
        this.emptyTitleTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.emptyTitleTextView.setTextSize(1, 17.0f);
        this.emptyTitleTextView.setText(LocaleController.getString("NoPlacesFound", R.string.NoPlacesFound));
        this.emptyView.addView(this.emptyTitleTextView, LayoutHelper.createLinear(-2, -2, 17, 0, 11, 0, 0));
        TextView textView2 = new TextView(context);
        this.emptySubtitleTextView = textView2;
        textView2.setTextColor(Theme.getColor(i13));
        this.emptySubtitleTextView.setGravity(17);
        this.emptySubtitleTextView.setTextSize(1, 15.0f);
        this.emptySubtitleTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), 0);
        this.emptyView.addView(this.emptySubtitleTextView, LayoutHelper.createLinear(-2, -2, 17, 0, 6, 0, 0));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        LocationActivityAdapter locationActivityAdapter2 = new LocationActivityAdapter(context, this.locationType, this.dialogId, false) { // from class: org.rbmain.ui.LocationActivity.10
            @Override // org.rbmain.ui.Adapters.LocationActivityAdapter
            protected void onDirectionClick() {
                Intent intent;
                Activity parentActivity;
                if (Build.VERSION.SDK_INT < 23 || (parentActivity = LocationActivity.this.getParentActivity()) == null || parentActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    if (LocationActivity.this.myLocation != null) {
                        try {
                            if (LocationActivity.this.messageObject != null) {
                                intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format(Locale.US, "http://maps.google.com/maps?saddr=%f,%f&daddr=%f,%f", Double.valueOf(LocationActivity.this.myLocation.getLatitude()), Double.valueOf(LocationActivity.this.myLocation.getLongitude()), Double.valueOf(LocationActivity.this.messageObject.messageOwner.media.geo.lat), Double.valueOf(LocationActivity.this.messageObject.messageOwner.media.geo._long))));
                            } else {
                                intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format(Locale.US, "http://maps.google.com/maps?saddr=%f,%f&daddr=%f,%f", Double.valueOf(LocationActivity.this.myLocation.getLatitude()), Double.valueOf(LocationActivity.this.myLocation.getLongitude()), Double.valueOf(LocationActivity.this.chatLocation.geo_point.lat), Double.valueOf(LocationActivity.this.chatLocation.geo_point._long))));
                            }
                            LocationActivity.this.getParentActivity().startActivity(intent);
                            return;
                        } catch (Exception e) {
                            FileLog.e(e);
                            return;
                        }
                    }
                    return;
                }
                LocationActivity.this.showPermissionAlert(true);
            }
        };
        this.adapter = locationActivityAdapter2;
        recyclerListView.setAdapter(locationActivityAdapter2);
        this.adapter.setUpdateRunnable(new Runnable() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$8();
            }
        });
        this.listView.setVerticalScrollBarEnabled(false);
        RecyclerListView recyclerListView2 = this.listView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.layoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.LocationActivity.11
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i14) {
                LocationActivity.this.scrolling = i14 != 0;
                if (LocationActivity.this.scrolling || LocationActivity.this.forceUpdate == null) {
                    return;
                }
                LocationActivity.this.forceUpdate = null;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i14, int i15) {
                LocationActivity.this.updateClipView(false);
                if (LocationActivity.this.forceUpdate != null) {
                    LocationActivity.access$3616(LocationActivity.this, i15);
                }
            }
        });
        ((DefaultItemAnimator) this.listView.getItemAnimator()).setDelayAnimations(false);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda37
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i14) {
                this.f$0.lambda$createView$14(view, i14);
            }
        });
        this.adapter.setDelegate(this.dialogId, new BaseLocationAdapter.BaseLocationAdapterDelegate() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda30
            @Override // org.rbmain.ui.Adapters.BaseLocationAdapter.BaseLocationAdapterDelegate
            public final void didLoadSearchResult(ArrayList arrayList) {
                this.f$0.updatePlacesMarkers(arrayList);
            }
        });
        this.adapter.setOverScrollHeight(this.overScrollHeight);
        frameLayout2.addView(this.mapViewClip, LayoutHelper.createFrame(-1, -1, 51));
        final AnonymousClass12 anonymousClass12 = new AnonymousClass12(context);
        this.mapView = anonymousClass12;
        new Thread(new Runnable() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$17(anonymousClass12);
            }
        }).start();
        MessageObject messageObject3 = this.messageObject;
        if (messageObject3 == null && this.chatLocation == null) {
            if (chat != null && this.locationType == 4 && this.dialogId != 0) {
                FrameLayout frameLayout4 = new FrameLayout(context);
                frameLayout4.setBackgroundResource(R.drawable.livepin);
                this.mapViewClip.addView(frameLayout4, LayoutHelper.createFrame(62, 76, 49));
                BackupImageView backupImageView = new BackupImageView(context);
                backupImageView.setRoundRadius(AndroidUtilities.dp(26.0f));
                backupImageView.setForUserOrChat(chat, new AvatarDrawable(chat));
                frameLayout4.addView(backupImageView, LayoutHelper.createFrame(52, 52.0f, 51, 5.0f, 5.0f, 0.0f, 0.0f));
                this.markerImageView = frameLayout4;
                frameLayout4.setTag(1);
            }
            if (this.markerImageView == null) {
                ImageView imageView5 = new ImageView(context);
                imageView5.setImageResource(R.drawable.map_pin2);
                this.mapViewClip.addView(imageView5, LayoutHelper.createFrame(28, 48, 49));
                this.markerImageView = imageView5;
            }
            RecyclerListView recyclerListView3 = new RecyclerListView(context);
            this.searchListView = recyclerListView3;
            recyclerListView3.setVisibility(8);
            i2 = 0;
            this.searchListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
            LocationActivitySearchAdapter locationActivitySearchAdapter2 = new LocationActivitySearchAdapter(context) { // from class: org.rbmain.ui.LocationActivity.13
                @Override // androidx.recyclerview.widget.RecyclerView.Adapter
                public void notifyDataSetChanged() {
                    if (LocationActivity.this.searchItem != null) {
                        LocationActivity.this.searchItem.setShowSearchProgress(LocationActivity.this.searchAdapter.isSearching());
                    }
                    if (LocationActivity.this.emptySubtitleTextView != null) {
                        LocationActivity.this.emptySubtitleTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("NoPlacesFoundInfo", R.string.NoPlacesFoundInfo, LocationActivity.this.searchAdapter.getLastSearchString())));
                    }
                    super.notifyDataSetChanged();
                }
            };
            this.searchAdapter = locationActivitySearchAdapter2;
            locationActivitySearchAdapter2.setDelegate(0L, new BaseLocationAdapter.BaseLocationAdapterDelegate() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda31
                @Override // org.rbmain.ui.Adapters.BaseLocationAdapter.BaseLocationAdapterDelegate
                public final void didLoadSearchResult(ArrayList arrayList) {
                    this.f$0.lambda$createView$18(arrayList);
                }
            });
            frameLayout2.addView(this.searchListView, LayoutHelper.createFrame(-1, -1, 51));
            this.searchListView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.LocationActivity.14
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i14) {
                    if (i14 == 1 && LocationActivity.this.searching && LocationActivity.this.searchWas) {
                        AndroidUtilities.hideKeyboard(LocationActivity.this.getParentActivity().getCurrentFocus());
                    }
                }
            });
            this.searchListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda38
                @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
                public final void onItemClick(View view, int i14) {
                    this.f$0.lambda$createView$20(view, i14);
                }
            });
        } else {
            i2 = 0;
            if ((messageObject3 != null && !messageObject3.isLiveLocation()) || this.chatLocation != null) {
                TLRPC$TL_channelLocation tLRPC$TL_channelLocation = this.chatLocation;
                if (tLRPC$TL_channelLocation != null) {
                    this.adapter.setChatLocation(tLRPC$TL_channelLocation);
                } else {
                    MessageObject messageObject4 = this.messageObject;
                    if (messageObject4 != null) {
                        this.adapter.setMessageObject(messageObject4);
                    }
                }
            }
        }
        MessageObject messageObject5 = this.messageObject;
        if (messageObject5 != null && this.locationType == 6) {
            this.adapter.setMessageObject(messageObject5);
        }
        while (i2 < 2) {
            this.undoView[i2] = new UndoView(context);
            this.undoView[i2].setAdditionalTranslationY(AndroidUtilities.dp(10.0f));
            if (Build.VERSION.SDK_INT >= 21) {
                this.undoView[i2].setTranslationZ(AndroidUtilities.dp(5.0f));
            }
            this.mapViewClip.addView(this.undoView[i2], LayoutHelper.createFrame(-1, -2.0f, 83, 8.0f, 0.0f, 8.0f, 8.0f));
            i2++;
        }
        View view = new View(context) { // from class: org.rbmain.ui.LocationActivity.15
            private RectF rect = new RectF();

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                LocationActivity.this.shadowDrawable.setBounds(-rect.left, 0, getMeasuredWidth() + rect.right, getMeasuredHeight());
                LocationActivity.this.shadowDrawable.draw(canvas);
                if (LocationActivity.this.locationType == 0 || LocationActivity.this.locationType == 1) {
                    int iDp2 = AndroidUtilities.dp(36.0f);
                    this.rect.set((getMeasuredWidth() - iDp2) / 2, rect.top + AndroidUtilities.dp(10.0f), (getMeasuredWidth() + iDp2) / 2, r1 + AndroidUtilities.dp(4.0f));
                    int color2 = Theme.getColor(Theme.key_sheet_scrollUp);
                    Color.alpha(color2);
                    Theme.dialogs_onlineCirclePaint.setColor(color2);
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), Theme.dialogs_onlineCirclePaint);
                }
            }
        };
        this.shadow = view;
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(AndroidUtilities.dp(6.0f));
        }
        this.mapViewClip.addView(this.shadow, layoutParams2);
        if (this.messageObject == null && this.chatLocation == null && this.initialLocation != null) {
            this.userLocationMoved = true;
            ImageView imageView6 = this.locationButton;
            int i14 = Theme.key_location_actionIcon;
            imageView6.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i14), PorterDuff.Mode.MULTIPLY));
            this.locationButton.setTag(Integer.valueOf(i14));
        }
        frameLayout2.addView(this.actionBar);
        updateEmptyView();
        MessageObject messageObject6 = this.messageObject;
        if (messageObject6 != null && messageObject6.isLiveLocation()) {
            AndroidUtilities.runOnUIThread(this.updateLiveLocationRunnable, this.updateLiveLocationPeriodMillis);
        }
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view) {
        showSearchPlacesButton(false);
        this.adapter.searchPlacesWithQuery(null, this.userLocation, true, true);
        this.searchedForCustomLocations = true;
        showResults();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(View view) {
        this.mapTypeButton.toggleSubMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(int i) {
        GoogleMap googleMap = this.googleMap;
        if (googleMap == null) {
            return;
        }
        if (i == 2) {
            googleMap.setMapType(1);
        } else if (i == 3) {
            googleMap.setMapType(2);
        } else if (i == 4) {
            googleMap.setMapType(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3(View view) {
        GoogleMap googleMap;
        Activity parentActivity;
        if (Build.VERSION.SDK_INT >= 23 && (parentActivity = getParentActivity()) != null && parentActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            showPermissionAlert(false);
            return;
        }
        if (checkGpsEnabled()) {
            if (this.messageObject != null || this.chatLocation != null) {
                if (this.myLocation != null && (googleMap = this.googleMap) != null) {
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(this.myLocation.getLatitude(), this.myLocation.getLongitude()), this.googleMap.getMaxZoomLevel() - 4.0f));
                }
            } else if (this.myLocation != null && this.googleMap != null) {
                ImageView imageView = this.locationButton;
                int i = Theme.key_location_actionActiveIcon;
                imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
                this.locationButton.setTag(Integer.valueOf(i));
                this.adapter.setCustomLocation(null);
                this.userLocationMoved = false;
                showSearchPlacesButton(false);
                this.googleMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(this.myLocation.getLatitude(), this.myLocation.getLongitude())));
                if (this.searchedForCustomLocations) {
                    Location location = this.myLocation;
                    if (location != null) {
                        this.adapter.searchPlacesWithQuery(null, location, true, true);
                    }
                    this.searchedForCustomLocations = false;
                    showResults();
                }
            }
            removeInfoView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$6(View view) {
        if (getParentActivity() == null || this.myLocation == null || !checkGpsEnabled() || this.googleMap == null) {
            return;
        }
        HintView hintView = this.hintView;
        if (hintView != null) {
            hintView.hide();
        }
        MessagesController.getGlobalMainSettings().edit().putInt("proximityhint", 3).apply();
        final LocationController.SharingLocationInfo sharingLocationInfo = getLocationController().getSharingLocationInfo(this.dialogId);
        if (this.canUndo) {
            this.undoView[0].hide(true, 1);
        }
        if (sharingLocationInfo != null && sharingLocationInfo.proximityMeters > 0) {
            this.proximityButton.setImageResource(R.drawable.msg_location_alert);
            Circle circle = this.proximityCircle;
            if (circle != null) {
                circle.remove();
                this.proximityCircle = null;
            }
            this.canUndo = true;
            getUndoView().showWithAction(0L, 25, 0, null, new Runnable() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createView$4();
                }
            }, new Runnable() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda22
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createView$5(sharingLocationInfo);
                }
            });
            return;
        }
        openProximityAlert();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4() {
        getLocationController().setProximityLocation(this.dialogId, 0, true);
        this.canUndo = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$5(LocationController.SharingLocationInfo sharingLocationInfo) {
        this.proximityButton.setImageResource(R.drawable.msg_location_alert2);
        createCircle(sharingLocationInfo.proximityMeters);
        this.canUndo = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$8() {
        updateClipView(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$14(View view, int i) {
        MessageObject messageObject;
        final TLRPC$TL_messageMediaVenue tLRPC$TL_messageMediaVenue;
        int i2 = this.locationType;
        if (i2 == 4) {
            if (i != 1 || (tLRPC$TL_messageMediaVenue = (TLRPC$TL_messageMediaVenue) this.adapter.getItem(i)) == null) {
                return;
            }
            if (this.dialogId == 0) {
                this.delegate.didSelectLocation(tLRPC$TL_messageMediaVenue, 4, true, 0);
                finishFragment();
                return;
            }
            final AlertDialog[] alertDialogArr = {new AlertDialog(getParentActivity(), 3)};
            TLRPC$TL_channels_editLocation tLRPC$TL_channels_editLocation = new TLRPC$TL_channels_editLocation();
            tLRPC$TL_channels_editLocation.address = tLRPC$TL_messageMediaVenue.address;
            tLRPC$TL_channels_editLocation.channel = getMessagesController().getInputChannel(-((int) this.dialogId));
            TLRPC$TL_inputGeoPoint tLRPC$TL_inputGeoPoint = new TLRPC$TL_inputGeoPoint();
            tLRPC$TL_channels_editLocation.geo_point = tLRPC$TL_inputGeoPoint;
            TLRPC$GeoPoint tLRPC$GeoPoint = tLRPC$TL_messageMediaVenue.geo;
            tLRPC$TL_inputGeoPoint.lat = tLRPC$GeoPoint.lat;
            tLRPC$TL_inputGeoPoint._long = tLRPC$GeoPoint._long;
            final int iSendRequest = getConnectionsManager().sendRequest(tLRPC$TL_channels_editLocation, new RequestDelegate() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda27
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$createView$10(alertDialogArr, tLRPC$TL_messageMediaVenue, tLObject, tLRPC$TL_error);
                }
            });
            alertDialogArr[0].setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.f$0.lambda$createView$11(iSendRequest, dialogInterface);
                }
            });
            showDialog(alertDialogArr[0]);
            return;
        }
        if (i2 == 5) {
            GoogleMap googleMap = this.googleMap;
            if (googleMap != null) {
                TLRPC$GeoPoint tLRPC$GeoPoint2 = this.chatLocation.geo_point;
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(tLRPC$GeoPoint2.lat, tLRPC$GeoPoint2._long), this.googleMap.getMaxZoomLevel() - 4.0f));
                return;
            }
            return;
        }
        if (i == 1 && (messageObject = this.messageObject) != null && (!messageObject.isLiveLocation() || this.locationType == 6)) {
            GoogleMap googleMap2 = this.googleMap;
            if (googleMap2 != null) {
                TLRPC$GeoPoint tLRPC$GeoPoint3 = this.messageObject.messageOwner.media.geo;
                googleMap2.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(tLRPC$GeoPoint3.lat, tLRPC$GeoPoint3._long), this.googleMap.getMaxZoomLevel() - 4.0f));
                return;
            }
            return;
        }
        if (i == 1 && this.locationType != 2) {
            if (this.delegate == null || this.userLocation == null) {
                return;
            }
            FrameLayout frameLayout = this.lastPressedMarkerView;
            if (frameLayout != null) {
                frameLayout.callOnClick();
                return;
            }
            final TLRPC$TL_messageMediaGeo tLRPC$TL_messageMediaGeo = new TLRPC$TL_messageMediaGeo();
            TLRPC$TL_geoPoint tLRPC$TL_geoPoint = new TLRPC$TL_geoPoint();
            tLRPC$TL_messageMediaGeo.geo = tLRPC$TL_geoPoint;
            tLRPC$TL_geoPoint.lat = AndroidUtilities.fixLocationCoord(this.userLocation.getLatitude());
            tLRPC$TL_messageMediaGeo.geo._long = AndroidUtilities.fixLocationCoord(this.userLocation.getLongitude());
            ChatActivity chatActivity = this.parentFragment;
            if (chatActivity != null && chatActivity.isInScheduleMode()) {
                AlertsCreator.createScheduleDatePickerDialog(getParentActivity(), this.parentFragment.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda33
                    @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                    public final void didSelectDate(boolean z, int i3) {
                        this.f$0.lambda$createView$12(tLRPC$TL_messageMediaGeo, z, i3);
                    }
                });
                return;
            } else {
                this.delegate.didSelectLocation(tLRPC$TL_messageMediaGeo, this.locationType, true, 0);
                finishFragment();
                return;
            }
        }
        if ((i == 2 && this.locationType == 1) || ((i == 1 && this.locationType == 2) || (i == 3 && this.locationType == 3))) {
            if (getLocationController().isSharingLocation(this.dialogId)) {
                getLocationController().removeSharingLocation(this.dialogId);
                finishFragment();
                return;
            } else {
                openShareLiveLocation(0);
                return;
            }
        }
        final Object item = this.adapter.getItem(i);
        if (item instanceof TLRPC$TL_messageMediaVenue) {
            ChatActivity chatActivity2 = this.parentFragment;
            if (chatActivity2 != null && chatActivity2.isInScheduleMode()) {
                AlertsCreator.createScheduleDatePickerDialog(getParentActivity(), this.parentFragment.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda32
                    @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                    public final void didSelectDate(boolean z, int i3) {
                        this.f$0.lambda$createView$13(item, z, i3);
                    }
                });
                return;
            } else {
                this.delegate.didSelectLocation((TLRPC$TL_messageMediaVenue) item, this.locationType, true, 0);
                finishFragment();
                return;
            }
        }
        if (item instanceof LiveLocation) {
            this.googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(((LiveLocation) item).marker.getPosition(), this.googleMap.getMaxZoomLevel() - 4.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$10(final AlertDialog[] alertDialogArr, final TLRPC$TL_messageMediaVenue tLRPC$TL_messageMediaVenue, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$9(alertDialogArr, tLRPC$TL_messageMediaVenue);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$9(AlertDialog[] alertDialogArr, TLRPC$TL_messageMediaVenue tLRPC$TL_messageMediaVenue) {
        try {
            alertDialogArr[0].dismiss();
        } catch (Throwable unused) {
        }
        alertDialogArr[0] = null;
        this.delegate.didSelectLocation(tLRPC$TL_messageMediaVenue, 4, true, 0);
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$11(int i, DialogInterface dialogInterface) {
        getConnectionsManager().cancelRequest(i, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$12(TLRPC$TL_messageMediaGeo tLRPC$TL_messageMediaGeo, boolean z, int i) {
        this.delegate.didSelectLocation(tLRPC$TL_messageMediaGeo, this.locationType, z, i);
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$13(Object obj, boolean z, int i) {
        this.delegate.didSelectLocation((TLRPC$TL_messageMediaVenue) obj, this.locationType, z, i);
        finishFragment();
    }

    /* renamed from: org.rbmain.ui.LocationActivity$12, reason: invalid class name */
    class AnonymousClass12 extends MapView {
        AnonymousClass12(Context context) {
            super(context);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            MotionEvent motionEvent2;
            if (LocationActivity.this.yOffset != 0.0f) {
                motionEvent = MotionEvent.obtain(motionEvent);
                motionEvent.offsetLocation(0.0f, (-LocationActivity.this.yOffset) / 2.0f);
                motionEvent2 = motionEvent;
            } else {
                motionEvent2 = null;
            }
            boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            return zDispatchTouchEvent;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (LocationActivity.this.messageObject == null && LocationActivity.this.chatLocation == null) {
                if (motionEvent.getAction() == 0) {
                    if (LocationActivity.this.animatorSet != null) {
                        LocationActivity.this.animatorSet.cancel();
                    }
                    LocationActivity.this.animatorSet = new AnimatorSet();
                    LocationActivity.this.animatorSet.setDuration(200L);
                    LocationActivity.this.animatorSet.playTogether(ObjectAnimator.ofFloat(LocationActivity.this.markerImageView, (Property<View, Float>) View.TRANSLATION_Y, LocationActivity.this.markerTop - AndroidUtilities.dp(10.0f)));
                    LocationActivity.this.animatorSet.start();
                } else if (motionEvent.getAction() == 1) {
                    if (LocationActivity.this.animatorSet != null) {
                        LocationActivity.this.animatorSet.cancel();
                    }
                    LocationActivity.this.yOffset = 0.0f;
                    LocationActivity.this.animatorSet = new AnimatorSet();
                    LocationActivity.this.animatorSet.setDuration(200L);
                    LocationActivity.this.animatorSet.playTogether(ObjectAnimator.ofFloat(LocationActivity.this.markerImageView, (Property<View, Float>) View.TRANSLATION_Y, LocationActivity.this.markerTop));
                    LocationActivity.this.animatorSet.start();
                    LocationActivity.this.adapter.fetchLocationAddress();
                }
                if (motionEvent.getAction() == 2) {
                    if (!LocationActivity.this.userLocationMoved) {
                        ImageView imageView = LocationActivity.this.locationButton;
                        int i = Theme.key_location_actionIcon;
                        imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
                        LocationActivity.this.locationButton.setTag(Integer.valueOf(i));
                        LocationActivity.this.userLocationMoved = true;
                    }
                    if (LocationActivity.this.googleMap != null && LocationActivity.this.userLocation != null) {
                        LocationActivity.this.userLocation.setLatitude(LocationActivity.this.googleMap.getCameraPosition().target.latitude);
                        LocationActivity.this.userLocation.setLongitude(LocationActivity.this.googleMap.getCameraPosition().target.longitude);
                    }
                    LocationActivity.this.adapter.setCustomLocation(LocationActivity.this.userLocation);
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LocationActivity$12$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onLayout$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLayout$0() {
            if (LocationActivity.this.moveToBounds != null) {
                LocationActivity.this.googleMap.moveCamera(LocationActivity.this.moveToBounds);
                LocationActivity.this.moveToBounds = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$17(final MapView mapView) {
        try {
            mapView.onCreate(null);
        } catch (Exception unused) {
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$16(mapView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$16(MapView mapView) {
        if (this.mapView == null || getParentActivity() == null) {
            return;
        }
        try {
            mapView.onCreate(null);
            MapsInitializer.initialize(ApplicationLoader.applicationContext);
            this.mapView.getMapAsync(new OnMapReadyCallback() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda13
                @Override // com.google.android.gms.maps.OnMapReadyCallback
                public final void onMapReady(GoogleMap googleMap) throws Resources.NotFoundException {
                    this.f$0.lambda$createView$15(googleMap);
                }
            });
            this.mapsInitialized = true;
            if (this.onResumeCalled) {
                this.mapView.onResume();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$15(GoogleMap googleMap) throws Resources.NotFoundException {
        this.googleMap = googleMap;
        if (isActiveThemeDark()) {
            this.currentMapStyleDark = true;
            this.googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(ApplicationLoader.applicationContext, R.raw.mapstyle_night));
        }
        this.googleMap.setPadding(AndroidUtilities.dp(70.0f), 0, AndroidUtilities.dp(70.0f), AndroidUtilities.dp(10.0f));
        onMapInit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$18(ArrayList arrayList) {
        this.searchInProgress = false;
        updateEmptyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$20(View view, int i) {
        final TLRPC$TL_messageMediaVenue item = this.searchAdapter.getItem(i);
        if (item == null || this.delegate == null) {
            return;
        }
        ChatActivity chatActivity = this.parentFragment;
        if (chatActivity != null && chatActivity.isInScheduleMode()) {
            AlertsCreator.createScheduleDatePickerDialog(getParentActivity(), this.parentFragment.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda34
                @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                public final void didSelectDate(boolean z, int i2) {
                    this.f$0.lambda$createView$19(item, z, i2);
                }
            });
        } else {
            this.delegate.didSelectLocation(item, this.locationType, true, 0);
            finishFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$19(TLRPC$TL_messageMediaVenue tLRPC$TL_messageMediaVenue, boolean z, int i) {
        this.delegate.didSelectLocation(tLRPC$TL_messageMediaVenue, this.locationType, z, i);
        finishFragment();
    }

    private boolean isActiveThemeDark() {
        return Theme.getActiveTheme().isDark() || AndroidUtilities.computePerceivedBrightness(Theme.getColor(Theme.key_windowBackgroundWhite)) < 0.721f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEmptyView() {
        if (this.searching) {
            if (this.searchInProgress) {
                this.searchListView.setEmptyView(null);
                this.emptyView.setVisibility(8);
                this.searchListView.setVisibility(8);
                return;
            }
            this.searchListView.setEmptyView(this.emptyView);
            return;
        }
        this.emptyView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSearchPlacesButton(boolean z) {
        SearchButton searchButton;
        Location location;
        Location location2;
        if (z && (searchButton = this.searchAreaButton) != null && searchButton.getTag() == null && ((location = this.myLocation) == null || (location2 = this.userLocation) == null || location2.distanceTo(location) < 300.0f)) {
            z = false;
        }
        SearchButton searchButton2 = this.searchAreaButton;
        if (searchButton2 != null) {
            if (!z || searchButton2.getTag() == null) {
                if (z || this.searchAreaButton.getTag() != null) {
                    this.searchAreaButton.setTag(z ? 1 : null);
                    AnimatorSet animatorSet = new AnimatorSet();
                    Animator[] animatorArr = new Animator[1];
                    SearchButton searchButton3 = this.searchAreaButton;
                    Property property = View.TRANSLATION_X;
                    float[] fArr = new float[1];
                    fArr[0] = z ? 0.0f : -AndroidUtilities.dp(80.0f);
                    animatorArr[0] = ObjectAnimator.ofFloat(searchButton3, (Property<SearchButton, Float>) property, fArr);
                    animatorSet.playTogether(animatorArr);
                    animatorSet.setDuration(180L);
                    animatorSet.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                    animatorSet.start();
                }
            }
        }
    }

    private Bitmap createUserBitmap(LiveLocation liveLocation) {
        TLRPC$FileLocation tLRPC$FileLocation;
        TLRPC$ChatPhoto tLRPC$ChatPhoto;
        TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto;
        Bitmap bitmap = null;
        try {
            TLRPC$User tLRPC$User = liveLocation.user;
            if (tLRPC$User != null && (tLRPC$UserProfilePhoto = tLRPC$User.photo) != null) {
                tLRPC$FileLocation = tLRPC$UserProfilePhoto.photo_small;
            } else {
                TLRPC$Chat tLRPC$Chat = liveLocation.chat;
                tLRPC$FileLocation = (tLRPC$Chat == null || (tLRPC$ChatPhoto = tLRPC$Chat.photo) == null) ? null : tLRPC$ChatPhoto.photo_small;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(AndroidUtilities.dp(62.0f), AndroidUtilities.dp(85.0f), Bitmap.Config.ARGB_8888);
            try {
                bitmapCreateBitmap.eraseColor(0);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                Drawable drawable = ApplicationLoader.applicationContext.getResources().getDrawable(R.drawable.map_pin_photo);
                drawable.setBounds(0, 0, AndroidUtilities.dp(62.0f), AndroidUtilities.dp(85.0f));
                drawable.draw(canvas);
                Paint paint = new Paint(1);
                RectF rectF = new RectF();
                canvas.save();
                if (tLRPC$FileLocation != null) {
                    Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(FileLoader.getPathToAttach(tLRPC$FileLocation, true).toString());
                    if (bitmapDecodeFile != null) {
                        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                        BitmapShader bitmapShader = new BitmapShader(bitmapDecodeFile, tileMode, tileMode);
                        Matrix matrix = new Matrix();
                        float fDp = AndroidUtilities.dp(50.0f) / bitmapDecodeFile.getWidth();
                        matrix.postTranslate(AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f));
                        matrix.postScale(fDp, fDp);
                        paint.setShader(bitmapShader);
                        bitmapShader.setLocalMatrix(matrix);
                        rectF.set(AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                        canvas.drawRoundRect(rectF, AndroidUtilities.dp(25.0f), AndroidUtilities.dp(25.0f), paint);
                    }
                } else {
                    AvatarDrawable avatarDrawable = new AvatarDrawable();
                    TLRPC$User tLRPC$User2 = liveLocation.user;
                    if (tLRPC$User2 != null) {
                        avatarDrawable.setInfo(tLRPC$User2);
                    } else {
                        TLRPC$Chat tLRPC$Chat2 = liveLocation.chat;
                        if (tLRPC$Chat2 != null) {
                            avatarDrawable.setInfo(tLRPC$Chat2);
                        }
                    }
                    canvas.translate(AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f));
                    avatarDrawable.setBounds(0, 0, AndroidUtilities.dp(50.0f), AndroidUtilities.dp(50.0f));
                    avatarDrawable.draw(canvas);
                }
                canvas.restore();
                try {
                    canvas.setBitmap(null);
                    return bitmapCreateBitmap;
                } catch (Exception unused) {
                    return bitmapCreateBitmap;
                }
            } catch (Throwable th) {
                th = th;
                bitmap = bitmapCreateBitmap;
                FileLog.e(th);
                return bitmap;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private int getMessageId(TLRPC$Message tLRPC$Message) {
        if (tLRPC$Message.from_id != null) {
            return MessageObject.getFromChatId(tLRPC$Message);
        }
        return (int) MessageObject.getDialogId(tLRPC$Message);
    }

    private void openProximityAlert() {
        Circle circle = this.proximityCircle;
        if (circle == null) {
            createCircle(HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
        } else {
            this.previousRadius = circle.getRadius();
        }
        final TLRPC$User user = ((int) this.dialogId) > 0 ? getMessagesController().getUser(Integer.valueOf((int) this.dialogId)) : null;
        ProximitySheet proximitySheet = new ProximitySheet(getParentActivity(), user, new ProximitySheet.onRadiusPickerChange() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda35
            @Override // org.rbmain.ui.Components.ProximitySheet.onRadiusPickerChange
            public final boolean run(boolean z, int i) {
                return this.f$0.lambda$openProximityAlert$21(z, i);
            }
        }, new ProximitySheet.onRadiusPickerChange() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda36
            @Override // org.rbmain.ui.Components.ProximitySheet.onRadiusPickerChange
            public final boolean run(boolean z, int i) {
                return this.f$0.lambda$openProximityAlert$23(user, z, i);
            }
        }, new Runnable() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openProximityAlert$24();
            }
        });
        this.proximitySheet = proximitySheet;
        ((FrameLayout) this.fragmentView).addView(proximitySheet, LayoutHelper.createFrame(-1, -1.0f));
        this.proximitySheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$openProximityAlert$21(boolean z, int i) {
        Circle circle = this.proximityCircle;
        if (circle != null) {
            circle.setRadius(i);
            if (z) {
                moveToBounds(i, true, true);
            }
        }
        if (((int) this.dialogId) < 0) {
            return true;
        }
        int size = this.markers.size();
        for (int i2 = 0; i2 < size; i2++) {
            LiveLocation liveLocation = this.markers.get(i2);
            if (liveLocation.object != null && !UserObject.isUserSelf(liveLocation.user)) {
                TLRPC$GeoPoint tLRPC$GeoPoint = liveLocation.object.media.geo;
                Location location = new Location("network");
                location.setLatitude(tLRPC$GeoPoint.lat);
                location.setLongitude(tLRPC$GeoPoint._long);
                if (this.myLocation.distanceTo(location) > i) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$openProximityAlert$23(final TLRPC$User tLRPC$User, boolean z, final int i) {
        if (getLocationController().getSharingLocationInfo(this.dialogId) == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setTitle(LocaleController.getString("ShareLocationAlertTitle", R.string.ShareLocationAlertTitle));
            builder.setMessage(LocaleController.getString("ShareLocationAlertText", R.string.ShareLocationAlertText));
            builder.setPositiveButton(LocaleController.getString("ShareLocationAlertButton", R.string.ShareLocationAlertButton), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$openProximityAlert$22(tLRPC$User, i, dialogInterface, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder.create());
            return false;
        }
        this.proximitySheet.setRadiusSet();
        this.proximityButton.setImageResource(R.drawable.msg_location_alert2);
        getUndoView().showWithAction(0L, 24, Integer.valueOf(i), tLRPC$User, null, null);
        getLocationController().setProximityLocation(this.dialogId, i, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openProximityAlert$22(TLRPC$User tLRPC$User, int i, DialogInterface dialogInterface, int i2) {
        lambda$openShareLiveLocation$26(tLRPC$User, DBHelper.GET_STICKER_LIMIT, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openProximityAlert$24() {
        GoogleMap googleMap = this.googleMap;
        if (googleMap != null) {
            googleMap.setPadding(AndroidUtilities.dp(70.0f), 0, AndroidUtilities.dp(70.0f), AndroidUtilities.dp(10.0f));
        }
        if (!this.proximitySheet.getRadiusSet()) {
            double d = this.previousRadius;
            if (d > 0.0d) {
                this.proximityCircle.setRadius(d);
            } else {
                Circle circle = this.proximityCircle;
                if (circle != null) {
                    circle.remove();
                    this.proximityCircle = null;
                }
            }
        }
        this.proximitySheet = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openShareLiveLocation(final int i) {
        Activity parentActivity;
        if (this.delegate == null || getParentActivity() == null || this.myLocation == null || !checkGpsEnabled()) {
            return;
        }
        if (this.checkBackgroundPermission && Build.VERSION.SDK_INT >= 29 && (parentActivity = getParentActivity()) != null) {
            this.askWithRadius = i;
            this.checkBackgroundPermission = false;
            SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
            if (Math.abs((System.currentTimeMillis() / 1000) - globalMainSettings.getInt("backgroundloc", 0)) > 86400 && parentActivity.checkSelfPermission("android.permission.ACCESS_BACKGROUND_LOCATION") != 0) {
                globalMainSettings.edit().putInt("backgroundloc", (int) (System.currentTimeMillis() / 1000)).apply();
                AlertsCreator.createBackgroundLocationPermissionDialog(parentActivity, getMessagesController().getUser(Integer.valueOf(getUserConfig().getClientUserId())), new Runnable() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda15
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$openShareLiveLocation$25();
                    }
                }).show();
                return;
            }
        }
        final TLRPC$User user = ((int) this.dialogId) > 0 ? getMessagesController().getUser(Integer.valueOf((int) this.dialogId)) : null;
        showDialog(AlertsCreator.createLocationUpdateDialog(getParentActivity(), user, new MessagesStorage.IntCallback() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda25
            @Override // org.rbmain.messenger.MessagesStorage.IntCallback
            public final void run(int i2) {
                this.f$0.lambda$openShareLiveLocation$26(user, i, i2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openShareLiveLocation$25() {
        openShareLiveLocation(this.askWithRadius);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shareLiveLocation, reason: merged with bridge method [inline-methods] */
    public void lambda$openShareLiveLocation$26(TLRPC$User tLRPC$User, int i, int i2) {
        TLRPC$TL_messageMediaGeoLive tLRPC$TL_messageMediaGeoLive = new TLRPC$TL_messageMediaGeoLive();
        TLRPC$TL_geoPoint tLRPC$TL_geoPoint = new TLRPC$TL_geoPoint();
        tLRPC$TL_messageMediaGeoLive.geo = tLRPC$TL_geoPoint;
        tLRPC$TL_geoPoint.lat = AndroidUtilities.fixLocationCoord(this.myLocation.getLatitude());
        tLRPC$TL_messageMediaGeoLive.geo._long = AndroidUtilities.fixLocationCoord(this.myLocation.getLongitude());
        tLRPC$TL_messageMediaGeoLive.heading = LocationController.getHeading(this.myLocation);
        int i3 = tLRPC$TL_messageMediaGeoLive.flags | 1;
        tLRPC$TL_messageMediaGeoLive.flags = i3;
        tLRPC$TL_messageMediaGeoLive.period = i;
        tLRPC$TL_messageMediaGeoLive.proximity_notification_radius = i2;
        tLRPC$TL_messageMediaGeoLive.flags = i3 | 8;
        this.delegate.didSelectLocation(tLRPC$TL_messageMediaGeoLive, this.locationType, true, 0);
        if (i2 > 0) {
            this.proximitySheet.setRadiusSet();
            this.proximityButton.setImageResource(R.drawable.msg_location_alert2);
            ProximitySheet proximitySheet = this.proximitySheet;
            if (proximitySheet != null) {
                proximitySheet.dismiss();
            }
            getUndoView().showWithAction(0L, 24, Integer.valueOf(i2), tLRPC$User, null, null);
            return;
        }
        finishFragment();
    }

    private Bitmap createPlaceBitmap(int i) {
        Bitmap[] bitmapArr = this.bitmapCache;
        int i2 = i % 7;
        if (bitmapArr[i2] != null) {
            return bitmapArr[i2];
        }
        try {
            Paint paint = new Paint(1);
            paint.setColor(-1);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawCircle(AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), paint);
            paint.setColor(LocationCell.getColorForIndex(i));
            canvas.drawCircle(AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(5.0f), paint);
            canvas.setBitmap(null);
            this.bitmapCache[i % 7] = bitmapCreateBitmap;
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            FileLog.e(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlacesMarkers(ArrayList<TLRPC$TL_messageMediaVenue> arrayList) {
        if (arrayList == null) {
            return;
        }
        int size = this.placeMarkers.size();
        for (int i = 0; i < size; i++) {
            this.placeMarkers.get(i).marker.remove();
        }
        this.placeMarkers.clear();
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            TLRPC$TL_messageMediaVenue tLRPC$TL_messageMediaVenue = arrayList.get(i2);
            try {
                MarkerOptions markerOptions = new MarkerOptions();
                TLRPC$GeoPoint tLRPC$GeoPoint = tLRPC$TL_messageMediaVenue.geo;
                MarkerOptions markerOptionsPosition = markerOptions.position(new LatLng(tLRPC$GeoPoint.lat, tLRPC$GeoPoint._long));
                markerOptionsPosition.icon(BitmapDescriptorFactory.fromBitmap(createPlaceBitmap(i2)));
                markerOptionsPosition.anchor(0.5f, 0.5f);
                markerOptionsPosition.title(tLRPC$TL_messageMediaVenue.title);
                markerOptionsPosition.snippet(tLRPC$TL_messageMediaVenue.address);
                VenueLocation venueLocation = new VenueLocation();
                venueLocation.num = i2;
                Marker markerAddMarker = this.googleMap.addMarker(markerOptionsPosition);
                venueLocation.marker = markerAddMarker;
                venueLocation.venue = tLRPC$TL_messageMediaVenue;
                markerAddMarker.setTag(venueLocation);
                this.placeMarkers.add(venueLocation);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    private LiveLocation addUserMarker(TLRPC$Message tLRPC$Message) {
        TLRPC$GeoPoint tLRPC$GeoPoint = tLRPC$Message.media.geo;
        LatLng latLng = new LatLng(tLRPC$GeoPoint.lat, tLRPC$GeoPoint._long);
        LiveLocation liveLocation = this.markersMap.get(MessageObject.getFromChatId(tLRPC$Message));
        if (liveLocation == null) {
            liveLocation = new LiveLocation();
            liveLocation.object = tLRPC$Message;
            if (tLRPC$Message.from_id instanceof TLRPC$TL_peerUser) {
                liveLocation.user = getMessagesController().getUser(Integer.valueOf(liveLocation.object.from_id.user_id));
                liveLocation.id = liveLocation.object.from_id.user_id;
            } else {
                int dialogId = (int) MessageObject.getDialogId(tLRPC$Message);
                if (dialogId > 0) {
                    liveLocation.user = getMessagesController().getUser(Integer.valueOf(dialogId));
                } else {
                    liveLocation.chat = getMessagesController().getChat(Integer.valueOf(-dialogId));
                }
                liveLocation.id = dialogId;
            }
            try {
                MarkerOptions markerOptionsPosition = new MarkerOptions().position(latLng);
                Bitmap bitmapCreateUserBitmap = createUserBitmap(liveLocation);
                if (bitmapCreateUserBitmap != null) {
                    markerOptionsPosition.icon(BitmapDescriptorFactory.fromBitmap(bitmapCreateUserBitmap));
                    markerOptionsPosition.anchor(0.5f, 0.907f);
                    liveLocation.marker = this.googleMap.addMarker(markerOptionsPosition);
                    if (!UserObject.isUserSelf(liveLocation.user)) {
                        MarkerOptions markerOptionsFlat = new MarkerOptions().position(latLng).flat(true);
                        markerOptionsFlat.anchor(0.5f, 0.5f);
                        Marker markerAddMarker = this.googleMap.addMarker(markerOptionsFlat);
                        liveLocation.directionMarker = markerAddMarker;
                        int i = tLRPC$Message.media.heading;
                        if (i != 0) {
                            markerAddMarker.setRotation(i);
                            liveLocation.directionMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin_cone2));
                            liveLocation.hasRotation = true;
                        } else {
                            markerAddMarker.setRotation(0.0f);
                            liveLocation.directionMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin_circle));
                            liveLocation.hasRotation = false;
                        }
                    }
                    this.markers.add(liveLocation);
                    this.markersMap.put(liveLocation.id, liveLocation);
                    LocationController.SharingLocationInfo sharingLocationInfo = getLocationController().getSharingLocationInfo(this.dialogId);
                    if (liveLocation.id == getUserConfig().getClientUserId() && sharingLocationInfo != null && liveLocation.object.id == sharingLocationInfo.mid && this.myLocation != null) {
                        liveLocation.marker.setPosition(new LatLng(this.myLocation.getLatitude(), this.myLocation.getLongitude()));
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        } else {
            liveLocation.object = tLRPC$Message;
            liveLocation.marker.setPosition(latLng);
        }
        ProximitySheet proximitySheet = this.proximitySheet;
        if (proximitySheet != null) {
            proximitySheet.updateText(true, true);
        }
        return liveLocation;
    }

    private LiveLocation addUserMarker(TLRPC$TL_channelLocation tLRPC$TL_channelLocation) {
        TLRPC$GeoPoint tLRPC$GeoPoint = tLRPC$TL_channelLocation.geo_point;
        LatLng latLng = new LatLng(tLRPC$GeoPoint.lat, tLRPC$GeoPoint._long);
        LiveLocation liveLocation = new LiveLocation();
        int i = (int) this.dialogId;
        if (i > 0) {
            liveLocation.user = getMessagesController().getUser(Integer.valueOf(i));
        } else {
            liveLocation.chat = getMessagesController().getChat(Integer.valueOf(-i));
        }
        liveLocation.id = i;
        try {
            MarkerOptions markerOptionsPosition = new MarkerOptions().position(latLng);
            Bitmap bitmapCreateUserBitmap = createUserBitmap(liveLocation);
            if (bitmapCreateUserBitmap != null) {
                markerOptionsPosition.icon(BitmapDescriptorFactory.fromBitmap(bitmapCreateUserBitmap));
                markerOptionsPosition.anchor(0.5f, 0.907f);
                liveLocation.marker = this.googleMap.addMarker(markerOptionsPosition);
                if (!UserObject.isUserSelf(liveLocation.user)) {
                    MarkerOptions markerOptionsFlat = new MarkerOptions().position(latLng).flat(true);
                    markerOptionsFlat.icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin_circle));
                    markerOptionsFlat.anchor(0.5f, 0.5f);
                    liveLocation.directionMarker = this.googleMap.addMarker(markerOptionsFlat);
                }
                this.markers.add(liveLocation);
                this.markersMap.put(liveLocation.id, liveLocation);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        return liveLocation;
    }

    private void onMapInit() {
        LocationController.SharingLocationInfo sharingLocationInfo;
        int i;
        if (this.googleMap == null) {
            return;
        }
        TLRPC$TL_channelLocation tLRPC$TL_channelLocation = this.chatLocation;
        if (tLRPC$TL_channelLocation != null) {
            this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(addUserMarker(tLRPC$TL_channelLocation).marker.getPosition(), this.googleMap.getMaxZoomLevel() - 4.0f));
        } else {
            MessageObject messageObject = this.messageObject;
            if (messageObject != null) {
                if (messageObject.isLiveLocation()) {
                    LiveLocation liveLocationAddUserMarker = addUserMarker(this.messageObject.messageOwner);
                    if (!getRecentLocations()) {
                        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(liveLocationAddUserMarker.marker.getPosition(), this.googleMap.getMaxZoomLevel() - 4.0f));
                    }
                } else {
                    LatLng latLng = new LatLng(this.userLocation.getLatitude(), this.userLocation.getLongitude());
                    try {
                        this.googleMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin2)));
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, this.googleMap.getMaxZoomLevel() - 4.0f));
                    this.firstFocus = false;
                    getRecentLocations();
                }
            } else {
                Location location = new Location("network");
                this.userLocation = location;
                if (this.initialLocation != null) {
                    TLRPC$GeoPoint tLRPC$GeoPoint = this.initialLocation.geo_point;
                    LatLng latLng2 = new LatLng(tLRPC$GeoPoint.lat, tLRPC$GeoPoint._long);
                    GoogleMap googleMap = this.googleMap;
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng2, googleMap.getMaxZoomLevel() - 4.0f));
                    this.userLocation.setLatitude(this.initialLocation.geo_point.lat);
                    this.userLocation.setLongitude(this.initialLocation.geo_point._long);
                    this.adapter.setCustomLocation(this.userLocation);
                } else {
                    LatLng latLng3 = AppFavorUtils.defaultLocation;
                    location.setLatitude(latLng3.latitude);
                    this.userLocation.setLongitude(latLng3.longitude);
                    GoogleMap googleMap2 = this.googleMap;
                    googleMap2.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng3, googleMap2.getMaxZoomLevel() - 4.0f));
                    this.adapter.setCustomLocation(this.userLocation);
                }
            }
        }
        try {
            this.googleMap.setMyLocationEnabled(true);
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        this.googleMap.getUiSettings().setMyLocationButtonEnabled(false);
        this.googleMap.getUiSettings().setZoomControlsEnabled(false);
        this.googleMap.getUiSettings().setCompassEnabled(false);
        this.googleMap.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda10
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener
            public final void onCameraMoveStarted(int i2) {
                this.f$0.lambda$onMapInit$27(i2);
            }
        });
        this.googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda12
            @Override // com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener
            public final void onMyLocationChange(Location location2) {
                this.f$0.lambda$onMapInit$28(location2);
            }
        });
        this.googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda11
            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
            public final boolean onMarkerClick(Marker marker) {
                return this.f$0.lambda$onMapInit$29(marker);
            }
        });
        this.googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda9
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveListener
            public final void onCameraMove() {
                this.f$0.lambda$onMapInit$30();
            }
        });
        Location lastLocation = getLastLocation();
        this.myLocation = lastLocation;
        positionMarker(lastLocation);
        if (this.checkGpsEnabled && getParentActivity() != null) {
            this.checkGpsEnabled = false;
            checkGpsEnabled();
        }
        ImageView imageView = this.proximityButton;
        if (imageView == null || imageView.getVisibility() != 0 || (sharingLocationInfo = getLocationController().getSharingLocationInfo(this.dialogId)) == null || (i = sharingLocationInfo.proximityMeters) <= 0) {
            return;
        }
        createCircle(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMapInit$27(int i) {
        View childAt;
        RecyclerView.ViewHolder viewHolderFindContainingViewHolder;
        if (i == 1) {
            showSearchPlacesButton(true);
            removeInfoView();
            if (this.scrolling) {
                return;
            }
            int i2 = this.locationType;
            if ((i2 == 0 || i2 == 1) && this.listView.getChildCount() > 0 && (childAt = this.listView.getChildAt(0)) != null && (viewHolderFindContainingViewHolder = this.listView.findContainingViewHolder(childAt)) != null && viewHolderFindContainingViewHolder.getAdapterPosition() == 0) {
                int iDp = this.locationType == 0 ? 0 : AndroidUtilities.dp(66.0f);
                int top = childAt.getTop();
                if (top < (-iDp)) {
                    CameraPosition cameraPosition = this.googleMap.getCameraPosition();
                    this.forceUpdate = CameraUpdateFactory.newLatLngZoom(cameraPosition.target, cameraPosition.zoom);
                    this.listView.smoothScrollBy(0, top + iDp);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMapInit$28(Location location) {
        positionMarker(location);
        getLocationController().setGoogleMapLocation(location, this.isFirstLocation);
        getDialogsProxy().updateUserLocation(new LocationObject(location.getLatitude(), location.getLongitude()));
        this.isFirstLocation = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onMapInit$29(Marker marker) {
        if (!(marker.getTag() instanceof VenueLocation)) {
            return true;
        }
        this.markerImageView.setVisibility(4);
        if (!this.userLocationMoved) {
            ImageView imageView = this.locationButton;
            int i = Theme.key_location_actionIcon;
            imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
            this.locationButton.setTag(Integer.valueOf(i));
            this.userLocationMoved = true;
        }
        this.overlayView.addInfoView(marker);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMapInit$30() {
        MapOverlayView mapOverlayView = this.overlayView;
        if (mapOverlayView != null) {
            mapOverlayView.updatePositions();
        }
    }

    private boolean checkGpsEnabled() {
        if (!getParentActivity().getPackageManager().hasSystemFeature("android.hardware.location.gps")) {
            return true;
        }
        try {
            if (!((LocationManager) ApplicationLoader.applicationContext.getSystemService("location")).isProviderEnabled("gps")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setTitle(LocaleController.getString("GpsDisabledAlertTitle", R.string.GpsDisabledAlertTitle));
                builder.setMessage(LocaleController.getString("GpsDisabledAlertText", R.string.GpsDisabledAlertText));
                builder.setPositiveButton(LocaleController.getString("ConnectingToProxyEnable", R.string.ConnectingToProxyEnable), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$checkGpsEnabled$31(dialogInterface, i);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                showDialog(builder.create());
                return false;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkGpsEnabled$31(DialogInterface dialogInterface, int i) {
        if (getParentActivity() == null) {
            return;
        }
        try {
            getParentActivity().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } catch (Exception unused) {
        }
    }

    private void createCircle(int i) {
        if (this.googleMap == null) {
            return;
        }
        List<PatternItem> listAsList = Arrays.asList(new Gap(20.0f), new Dash(20.0f));
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(new LatLng(this.myLocation.getLatitude(), this.myLocation.getLongitude()));
        circleOptions.radius(i);
        if (isActiveThemeDark()) {
            circleOptions.strokeColor(-1771658281);
            circleOptions.fillColor(476488663);
        } else {
            circleOptions.strokeColor(-1774024971);
            circleOptions.fillColor(474121973);
        }
        circleOptions.strokePattern(listAsList);
        circleOptions.strokeWidth(2.0f);
        this.proximityCircle = this.googleMap.addCircle(circleOptions);
    }

    private void removeInfoView() {
        if (this.lastPressedMarker != null) {
            this.markerImageView.setVisibility(0);
            this.overlayView.removeInfoView(this.lastPressedMarker);
            this.lastPressedMarker = null;
            this.lastPressedVenue = null;
            this.lastPressedMarkerView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPermissionAlert(boolean z) {
        if (getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        if (z) {
            builder.setMessage(LocaleController.getString("PermissionNoLocationPosition", R.string.PermissionNoLocationPosition));
        } else {
            builder.setMessage(LocaleController.getString("PermissionNoLocation", R.string.PermissionNoLocation));
        }
        builder.setNegativeButton(LocaleController.getString("PermissionOpenSettings", R.string.PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showPermissionAlert$32(dialogInterface, i);
            }
        });
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPermissionAlert$32(DialogInterface dialogInterface, int i) {
        if (getParentActivity() == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + ApplicationLoader.applicationContext.getPackageName()));
            getParentActivity().startActivity(intent);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean z, boolean z2) {
        if (!z || z2) {
            return;
        }
        try {
            if (this.mapView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mapView.getParent()).removeView(this.mapView);
            }
        } catch (Exception unused) {
        }
        FrameLayout frameLayout = this.mapViewClip;
        if (frameLayout != null) {
            frameLayout.addView(this.mapView, 0, LayoutHelper.createFrame(-1, this.overScrollHeight + AndroidUtilities.dp(10.0f), 51));
            MapOverlayView mapOverlayView = this.overlayView;
            if (mapOverlayView != null) {
                try {
                    if (mapOverlayView.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.overlayView.getParent()).removeView(this.overlayView);
                    }
                } catch (Exception unused2) {
                }
                this.mapViewClip.addView(this.overlayView, 1, LayoutHelper.createFrame(-1, this.overScrollHeight + AndroidUtilities.dp(10.0f), 51));
            }
            updateClipView(false);
            maybeShowProximityHint();
            return;
        }
        View view = this.fragmentView;
        if (view != null) {
            ((FrameLayout) view).addView(this.mapView, 0, LayoutHelper.createFrame(-1, -1, 51));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeShowProximityHint() {
        SharedPreferences globalMainSettings;
        int i;
        ImageView imageView = this.proximityButton;
        if (imageView == null || imageView.getVisibility() != 0 || this.proximityAnimationInProgress || (i = (globalMainSettings = MessagesController.getGlobalMainSettings()).getInt("proximityhint", 0)) >= 3) {
            return;
        }
        globalMainSettings.edit().putInt("proximityhint", i + 1).apply();
        if (((int) this.dialogId) > 0) {
            this.hintView.setOverrideText(LocaleController.formatString("ProximityTooltioUser", R.string.ProximityTooltioUser, UserObject.getFirstName(getMessagesController().getUser(Integer.valueOf((int) this.dialogId)))));
        } else {
            this.hintView.setOverrideText(LocaleController.getString("ProximityTooltioGroup", R.string.ProximityTooltioGroup));
        }
        this.hintView.showForView(this.proximityButton, true);
    }

    private void showResults() {
        if (this.adapter.getItemCount() != 0 && this.layoutManager.findFirstVisibleItemPosition() == 0) {
            int iDp = AndroidUtilities.dp(258.0f) + this.listView.getChildAt(0).getTop();
            if (iDp < 0 || iDp > AndroidUtilities.dp(258.0f)) {
                return;
            }
            this.listView.smoothScrollBy(0, iDp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateClipView(boolean z) {
        int y;
        int iMin;
        FrameLayout.LayoutParams layoutParams;
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(0);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            y = (int) viewHolderFindViewHolderForAdapterPosition.itemView.getY();
            iMin = this.overScrollHeight + Math.min(y, 0);
        } else {
            y = -this.mapViewClip.getMeasuredHeight();
            iMin = 0;
        }
        if (((FrameLayout.LayoutParams) this.mapViewClip.getLayoutParams()) != null) {
            if (iMin <= 0) {
                if (this.mapView.getVisibility() == 0) {
                    this.mapView.setVisibility(4);
                    this.mapViewClip.setVisibility(4);
                    MapOverlayView mapOverlayView = this.overlayView;
                    if (mapOverlayView != null) {
                        mapOverlayView.setVisibility(4);
                    }
                }
            } else if (this.mapView.getVisibility() == 4) {
                this.mapView.setVisibility(0);
                this.mapViewClip.setVisibility(0);
                MapOverlayView mapOverlayView2 = this.overlayView;
                if (mapOverlayView2 != null) {
                    mapOverlayView2.setVisibility(0);
                }
            }
            this.mapViewClip.setTranslationY(Math.min(0, y));
            int i = -y;
            int i2 = i / 2;
            this.mapView.setTranslationY(Math.max(0, i2));
            MapOverlayView mapOverlayView3 = this.overlayView;
            if (mapOverlayView3 != null) {
                mapOverlayView3.setTranslationY(Math.max(0, i2));
            }
            int measuredHeight = this.overScrollHeight - this.mapTypeButton.getMeasuredHeight();
            int i3 = this.locationType;
            float fMin = Math.min(measuredHeight - AndroidUtilities.dp(64 + ((i3 == 0 || i3 == 1) ? 30 : 10)), i);
            this.mapTypeButton.setTranslationY(fMin);
            this.proximityButton.setTranslationY(fMin);
            HintView hintView = this.hintView;
            if (hintView != null) {
                hintView.setExtraTranslationY(fMin);
            }
            SearchButton searchButton = this.searchAreaButton;
            if (searchButton != null) {
                searchButton.setTranslation(fMin);
            }
            View view = this.markerImageView;
            if (view != null) {
                int iDp = (i - AndroidUtilities.dp(view.getTag() == null ? 48.0f : 69.0f)) + (iMin / 2);
                this.markerTop = iDp;
                view.setTranslationY(iDp);
            }
            if (z) {
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mapView.getLayoutParams();
            if (layoutParams2 != null && layoutParams2.height != this.overScrollHeight + AndroidUtilities.dp(10.0f)) {
                layoutParams2.height = this.overScrollHeight + AndroidUtilities.dp(10.0f);
                GoogleMap googleMap = this.googleMap;
                if (googleMap != null) {
                    googleMap.setPadding(AndroidUtilities.dp(70.0f), 0, AndroidUtilities.dp(70.0f), AndroidUtilities.dp(10.0f));
                }
                this.mapView.setLayoutParams(layoutParams2);
            }
            MapOverlayView mapOverlayView4 = this.overlayView;
            if (mapOverlayView4 == null || (layoutParams = (FrameLayout.LayoutParams) mapOverlayView4.getLayoutParams()) == null || layoutParams.height == this.overScrollHeight + AndroidUtilities.dp(10.0f)) {
                return;
            }
            layoutParams.height = this.overScrollHeight + AndroidUtilities.dp(10.0f);
            this.overlayView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixLayoutInternal(boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.listView != null) {
            int currentActionBarHeight = (this.actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0) + ActionBar.getCurrentActionBarHeight();
            int measuredHeight = this.fragmentView.getMeasuredHeight();
            if (measuredHeight == 0) {
                return;
            }
            int i = this.locationType;
            if (i != 6 && i == 2) {
                this.overScrollHeight = (measuredHeight - AndroidUtilities.dp(73.0f)) - currentActionBarHeight;
            } else {
                this.overScrollHeight = (measuredHeight - AndroidUtilities.dp(66.0f)) - currentActionBarHeight;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.listView.getLayoutParams();
            layoutParams2.topMargin = currentActionBarHeight;
            this.listView.setLayoutParams(layoutParams2);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mapViewClip.getLayoutParams();
            layoutParams3.topMargin = currentActionBarHeight;
            layoutParams3.height = this.overScrollHeight;
            this.mapViewClip.setLayoutParams(layoutParams3);
            RecyclerListView recyclerListView = this.searchListView;
            if (recyclerListView != null) {
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) recyclerListView.getLayoutParams();
                layoutParams4.topMargin = currentActionBarHeight;
                this.searchListView.setLayoutParams(layoutParams4);
            }
            this.adapter.setOverScrollHeight(this.overScrollHeight);
            FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.mapView.getLayoutParams();
            if (layoutParams5 != null) {
                layoutParams5.height = this.overScrollHeight + AndroidUtilities.dp(10.0f);
                GoogleMap googleMap = this.googleMap;
                if (googleMap != null) {
                    googleMap.setPadding(AndroidUtilities.dp(70.0f), 0, AndroidUtilities.dp(70.0f), AndroidUtilities.dp(10.0f));
                }
                this.mapView.setLayoutParams(layoutParams5);
            }
            MapOverlayView mapOverlayView = this.overlayView;
            if (mapOverlayView != null && (layoutParams = (FrameLayout.LayoutParams) mapOverlayView.getLayoutParams()) != null) {
                layoutParams.height = this.overScrollHeight + AndroidUtilities.dp(10.0f);
                this.overlayView.setLayoutParams(layoutParams);
            }
            this.adapter.notifyDataSetChanged();
            if (z) {
                int i2 = this.locationType;
                final int i3 = i2 == 3 ? 73 : (i2 == 1 || i2 == 2) ? 66 : 0;
                this.layoutManager.scrollToPositionWithOffset(0, -AndroidUtilities.dp(i3));
                updateClipView(false);
                this.listView.post(new Runnable() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda19
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$fixLayoutInternal$33(i3);
                    }
                });
                return;
            }
            updateClipView(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fixLayoutInternal$33(int i) {
        this.layoutManager.scrollToPositionWithOffset(0, -AndroidUtilities.dp(i));
        updateClipView(false);
    }

    private Location getLastLocation() {
        LocationManager locationManager = (LocationManager) ApplicationLoader.applicationContext.getSystemService("location");
        List<String> providers = locationManager.getProviders(true);
        Location lastKnownLocation = null;
        for (int size = providers.size() - 1; size >= 0; size--) {
            lastKnownLocation = locationManager.getLastKnownLocation(providers.get(size));
            if (lastKnownLocation != null) {
                break;
            }
        }
        return lastKnownLocation;
    }

    private void positionMarker(Location location) {
        if (location == null) {
            return;
        }
        this.myLocation = new Location(location);
        LiveLocation liveLocation = this.markersMap.get(getUserConfig().getClientUserId());
        LocationController.SharingLocationInfo sharingLocationInfo = getLocationController().getSharingLocationInfo(this.dialogId);
        if (liveLocation != null && sharingLocationInfo != null && liveLocation.object.id == sharingLocationInfo.mid) {
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            liveLocation.marker.setPosition(latLng);
            Marker marker = liveLocation.directionMarker;
            if (marker != null) {
                marker.setPosition(latLng);
            }
        }
        if (this.messageObject == null && this.chatLocation == null && this.googleMap != null) {
            LatLng latLng2 = new LatLng(location.getLatitude(), location.getLongitude());
            LocationActivityAdapter locationActivityAdapter = this.adapter;
            if (locationActivityAdapter != null) {
                if (!this.searchedForCustomLocations && this.locationType != 4) {
                    locationActivityAdapter.searchPlacesWithQuery(null, this.myLocation, true);
                }
                this.adapter.setGpsLocation(this.myLocation);
            }
            if (!this.userLocationMoved) {
                this.userLocation = new Location(location);
                if (this.firstWas) {
                    this.googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng2));
                } else {
                    this.firstWas = true;
                    this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng2, this.googleMap.getMaxZoomLevel() - 4.0f));
                }
            }
        } else {
            this.adapter.setGpsLocation(this.myLocation);
        }
        ProximitySheet proximitySheet = this.proximitySheet;
        if (proximitySheet != null) {
            proximitySheet.updateText(true, true);
        }
        Circle circle = this.proximityCircle;
        if (circle != null) {
            circle.setCenter(new LatLng(this.myLocation.getLatitude(), this.myLocation.getLongitude()));
        }
    }

    public void setMessageObject(MessageObject messageObject) {
        this.messageObject = messageObject;
        this.dialogId = messageObject.getDialogId();
    }

    public void setChatLocation(int i, TLRPC$TL_channelLocation tLRPC$TL_channelLocation) {
        this.dialogId = -i;
        this.chatLocation = tLRPC$TL_channelLocation;
    }

    public void setDialogId(long j) {
        this.dialogId = j;
    }

    public void setInitialLocation(TLRPC$TL_channelLocation tLRPC$TL_channelLocation) {
        this.initialLocation = tLRPC$TL_channelLocation;
    }

    private static LatLng move(LatLng latLng, double d, double d2) {
        double dMeterToLongitude = meterToLongitude(d2, latLng.latitude);
        return new LatLng(latLng.latitude + meterToLatitude(d), latLng.longitude + dMeterToLongitude);
    }

    private static double meterToLongitude(double d, double d2) {
        return Math.toDegrees(d / (Math.cos(Math.toRadians(d2)) * 6366198.0d));
    }

    private static double meterToLatitude(double d) {
        return Math.toDegrees(d / 6366198.0d);
    }

    private void fetchRecentLocations(ArrayList<TLRPC$Message> arrayList) {
        LatLngBounds.Builder builder = this.firstFocus ? new LatLngBounds.Builder() : null;
        int currentTime = getConnectionsManager().getCurrentTime();
        for (int i = 0; i < arrayList.size(); i++) {
            TLRPC$Message tLRPC$Message = arrayList.get(i);
            if (tLRPC$Message.date + tLRPC$Message.media.period > currentTime) {
                if (builder != null) {
                    TLRPC$GeoPoint tLRPC$GeoPoint = tLRPC$Message.media.geo;
                    builder.include(new LatLng(tLRPC$GeoPoint.lat, tLRPC$GeoPoint._long));
                }
                addUserMarker(tLRPC$Message);
                if (this.proximityButton.getVisibility() != 8 && MessageObject.getFromChatId(tLRPC$Message) != getUserConfig().getClientUserId()) {
                    this.proximityButton.setVisibility(0);
                    this.proximityAnimationInProgress = true;
                    this.proximityButton.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(180L).setListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.LocationActivity.16
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            LocationActivity.this.proximityAnimationInProgress = false;
                            LocationActivity.this.maybeShowProximityHint();
                        }
                    }).start();
                }
            }
        }
        if (builder != null) {
            if (this.firstFocus) {
                this.listView.smoothScrollBy(0, AndroidUtilities.dp(99.0f));
            }
            this.firstFocus = false;
            this.adapter.setLiveLocations(this.markers);
            if (this.messageObject.isLiveLocation()) {
                try {
                    LatLng center = builder.build().getCenter();
                    LatLng latLngMove = move(center, 100.0d, 100.0d);
                    builder.include(move(center, -100.0d, -100.0d));
                    builder.include(latLngMove);
                    LatLngBounds latLngBoundsBuild = builder.build();
                    if (arrayList.size() > 1) {
                        try {
                            CameraUpdate cameraUpdateNewLatLngBounds = CameraUpdateFactory.newLatLngBounds(latLngBoundsBuild, AndroidUtilities.dp(113.0f));
                            this.moveToBounds = cameraUpdateNewLatLngBounds;
                            this.googleMap.moveCamera(cameraUpdateNewLatLngBounds);
                            this.moveToBounds = null;
                        } catch (Exception e) {
                            FileLog.e(e);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0084 -> B:27:0x010a). Please report as a decompilation issue!!! */
    private void moveToBounds(int i, boolean z, boolean z2) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(new LatLng(this.myLocation.getLatitude(), this.myLocation.getLongitude()));
        try {
            if (z) {
                int iMax = Math.max(i, 250);
                LatLng center = builder.build().getCenter();
                double d = iMax;
                LatLng latLngMove = move(center, d, d);
                double d2 = -iMax;
                builder.include(move(center, d2, d2));
                builder.include(latLngMove);
                LatLngBounds latLngBoundsBuild = builder.build();
                try {
                    this.googleMap.setPadding(AndroidUtilities.dp(70.0f), 0, AndroidUtilities.dp(70.0f), (int) ((this.proximitySheet.getCustomView().getMeasuredHeight() - AndroidUtilities.dp(40.0f)) + this.mapViewClip.getTranslationY()));
                    if (z2) {
                        this.googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBoundsBuild, 0), HttpStatus.HTTP_INTERNAL_SERVER_ERROR, null);
                    } else {
                        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBoundsBuild, 0));
                    }
                } catch (Exception e) {
                    FileLog.e(e);
                }
            } else {
                int currentTime = getConnectionsManager().getCurrentTime();
                int size = this.markers.size();
                for (int i2 = 0; i2 < size; i2++) {
                    TLRPC$Message tLRPC$Message = this.markers.get(i2).object;
                    if (tLRPC$Message.date + tLRPC$Message.media.period > currentTime) {
                        TLRPC$GeoPoint tLRPC$GeoPoint = tLRPC$Message.media.geo;
                        builder.include(new LatLng(tLRPC$GeoPoint.lat, tLRPC$GeoPoint._long));
                    }
                }
                LatLng center2 = builder.build().getCenter();
                LatLng latLngMove2 = move(center2, 100.0d, 100.0d);
                builder.include(move(center2, -100.0d, -100.0d));
                builder.include(latLngMove2);
                LatLngBounds latLngBoundsBuild2 = builder.build();
                try {
                    this.googleMap.setPadding(AndroidUtilities.dp(70.0f), 0, AndroidUtilities.dp(70.0f), this.proximitySheet.getCustomView().getMeasuredHeight() - AndroidUtilities.dp(100.0f));
                    this.googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBoundsBuild2, 0));
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            }
        } catch (Exception unused) {
        }
    }

    private boolean getRecentLocations() {
        ArrayList<TLRPC$Message> arrayList = getLocationController().locationsCache.get(this.messageObject.getDialogId());
        if (arrayList == null || !arrayList.isEmpty()) {
            arrayList = null;
        } else {
            fetchRecentLocations(arrayList);
        }
        int i = (int) this.dialogId;
        if (i < 0) {
            TLRPC$Chat chat = getMessagesController().getChat(Integer.valueOf(-i));
            if (ChatObject.isChannel(chat) && !chat.megagroup) {
                return false;
            }
        }
        TLRPC$TL_messages_getRecentLocations tLRPC$TL_messages_getRecentLocations = new TLRPC$TL_messages_getRecentLocations();
        final long dialogId = this.messageObject.getDialogId();
        tLRPC$TL_messages_getRecentLocations.peer = getMessagesController().getInputPeer((int) dialogId);
        tLRPC$TL_messages_getRecentLocations.limit = 100;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getRecentLocations, new RequestDelegate() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda26
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$getRecentLocations$36(dialogId, tLObject, tLRPC$TL_error);
            }
        });
        return arrayList != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getRecentLocations$36(final long j, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda23
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getRecentLocations$35(tLObject, j);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getRecentLocations$35(TLObject tLObject, long j) {
        if (this.googleMap == null) {
            return;
        }
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
        getLocationController().locationsCache.put(j, tLRPC$messages_Messages.messages);
        getNotificationCenter().postNotificationName(NotificationCenter.liveLocationsCacheChanged, Long.valueOf(j));
        fetchRecentLocations(tLRPC$messages_Messages.messages);
        getLocationController().markLiveLoactionsAsRead(this.dialogId);
        if (this.markAsReadRunnable == null) {
            Runnable runnable = new Runnable() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getRecentLocations$34();
                }
            };
            this.markAsReadRunnable = runnable;
            AndroidUtilities.runOnUIThread(runnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getRecentLocations$34() {
        Runnable runnable;
        getLocationController().markLiveLoactionsAsRead(this.dialogId);
        if (this.isPaused || (runnable = this.markAsReadRunnable) == null) {
            return;
        }
        AndroidUtilities.runOnUIThread(runnable, 5000L);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        LocationActivityAdapter locationActivityAdapter;
        LiveLocation liveLocation;
        LocationActivityAdapter locationActivityAdapter2;
        if (i == NotificationCenter.closeChats) {
            removeSelfFromStack();
            return;
        }
        if (i == NotificationCenter.locationPermissionGranted) {
            GoogleMap googleMap = this.googleMap;
            if (googleMap != null) {
                try {
                    googleMap.setMyLocationEnabled(true);
                    return;
                } catch (Exception e) {
                    FileLog.e(e);
                    return;
                }
            }
            return;
        }
        if (i == NotificationCenter.liveLocationsChanged) {
            LocationActivityAdapter locationActivityAdapter3 = this.adapter;
            if (locationActivityAdapter3 != null) {
                locationActivityAdapter3.updateLiveLocationCell();
                return;
            }
            return;
        }
        if (i == NotificationCenter.didReceiveNewMessages) {
            if (((Boolean) objArr[2]).booleanValue() || ((Long) objArr[0]).longValue() != this.dialogId || this.messageObject == null) {
                return;
            }
            ArrayList arrayList = (ArrayList) objArr[1];
            boolean z = false;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                MessageObject messageObject = (MessageObject) arrayList.get(i3);
                if (messageObject.isLiveLocation()) {
                    addUserMarker(messageObject.messageOwner);
                    z = true;
                } else if ((messageObject.messageOwner.action instanceof TLRPC$TL_messageActionGeoProximityReached) && ((int) messageObject.getDialogId()) > 0) {
                    this.proximityButton.setImageResource(R.drawable.msg_location_alert);
                    Circle circle = this.proximityCircle;
                    if (circle != null) {
                        circle.remove();
                        this.proximityCircle = null;
                    }
                }
            }
            if (!z || (locationActivityAdapter2 = this.adapter) == null) {
                return;
            }
            locationActivityAdapter2.setLiveLocations(this.markers);
            return;
        }
        if (i == NotificationCenter.replaceMessagesObjects) {
            long jLongValue = ((Long) objArr[0]).longValue();
            if (jLongValue != this.dialogId || this.messageObject == null) {
                return;
            }
            ArrayList arrayList2 = (ArrayList) objArr[1];
            boolean z2 = false;
            for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                MessageObject messageObject2 = (MessageObject) arrayList2.get(i4);
                if (messageObject2.isLiveLocation() && (liveLocation = this.markersMap.get(getMessageId(messageObject2.messageOwner))) != null) {
                    LocationController.SharingLocationInfo sharingLocationInfo = getLocationController().getSharingLocationInfo(jLongValue);
                    if (sharingLocationInfo == null || sharingLocationInfo.mid != messageObject2.getId()) {
                        liveLocation.object = messageObject2.messageOwner;
                        TLRPC$GeoPoint tLRPC$GeoPoint = messageObject2.messageOwner.media.geo;
                        LatLng latLng = new LatLng(tLRPC$GeoPoint.lat, tLRPC$GeoPoint._long);
                        liveLocation.marker.setPosition(latLng);
                        Marker marker = liveLocation.directionMarker;
                        if (marker != null) {
                            marker.getPosition();
                            liveLocation.directionMarker.setPosition(latLng);
                            int i5 = messageObject2.messageOwner.media.heading;
                            if (i5 != 0) {
                                liveLocation.directionMarker.setRotation(i5);
                                if (!liveLocation.hasRotation) {
                                    liveLocation.directionMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin_cone2));
                                    liveLocation.hasRotation = true;
                                }
                            } else if (liveLocation.hasRotation) {
                                liveLocation.directionMarker.setRotation(0.0f);
                                liveLocation.directionMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin_circle));
                                liveLocation.hasRotation = false;
                            }
                        }
                    }
                    z2 = true;
                }
            }
            if (!z2 || (locationActivityAdapter = this.adapter) == null) {
                return;
            }
            locationActivityAdapter.updateLiveLocations();
            ProximitySheet proximitySheet = this.proximitySheet;
            if (proximitySheet != null) {
                proximitySheet.updateText(true, true);
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        MapView mapView = this.mapView;
        if (mapView != null && this.mapsInitialized) {
            try {
                mapView.onPause();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        UndoView[] undoViewArr = this.undoView;
        if (undoViewArr[0] != null) {
            undoViewArr[0].hide(true, 0);
        }
        this.onResumeCalled = false;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        ProximitySheet proximitySheet = this.proximitySheet;
        if (proximitySheet != null) {
            proximitySheet.dismiss();
            return false;
        }
        return super.onBackPressed();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onBecomeFullyHidden() {
        UndoView[] undoViewArr = this.undoView;
        if (undoViewArr[0] != null) {
            undoViewArr[0].hide(true, 0);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        Activity parentActivity;
        super.onResume();
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
        MapView mapView = this.mapView;
        if (mapView != null && this.mapsInitialized) {
            try {
                mapView.onResume();
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        this.onResumeCalled = true;
        GoogleMap googleMap = this.googleMap;
        if (googleMap != null) {
            try {
                googleMap.setMyLocationEnabled(true);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        fixLayoutInternal(true);
        if (this.checkPermission && Build.VERSION.SDK_INT >= 23 && (parentActivity = getParentActivity()) != null) {
            this.checkPermission = false;
            if (parentActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
                parentActivity.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 2);
            }
        }
        Runnable runnable = this.markAsReadRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            AndroidUtilities.runOnUIThread(this.markAsReadRunnable, 5000L);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
        if (i == 30) {
            openShareLiveLocation(this.askWithRadius);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onLowMemory() {
        super.onLowMemory();
        MapView mapView = this.mapView;
        if (mapView == null || !this.mapsInitialized) {
            return;
        }
        mapView.onLowMemory();
    }

    public void setDelegate(LocationActivityDelegate locationActivityDelegate) {
        this.delegate = locationActivityDelegate;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.LocationActivity$$ExternalSyntheticLambda29
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() throws Resources.NotFoundException {
                this.f$0.lambda$getThemeDescriptions$37();
            }
        };
        for (int i = 0; i < this.undoView.length; i++) {
            UndoView undoView = this.undoView[i];
            int i2 = ThemeDescription.FLAG_BACKGROUNDFILTER;
            int i3 = Theme.key_undo_background;
            arrayList.add(new ThemeDescription(undoView, i2, null, null, null, null, i3));
            int i4 = Theme.key_undo_cancelColor;
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"undoImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"undoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
            int i5 = Theme.key_undo_infoColor;
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"infoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"subinfoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"textPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"progressPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"leftImageView"}, "BODY", i3));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"leftImageView"}, "Wibe Big", i3));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"leftImageView"}, "Wibe Big 3", i5));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"leftImageView"}, "Wibe Small", i5));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"leftImageView"}, "Body Main.**", i5));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"leftImageView"}, "Body Top.**", i5));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"leftImageView"}, "Line.**", i5));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"leftImageView"}, "Curve Big.**", i5));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"leftImageView"}, "Curve Small.**", i5));
        }
        View view = this.fragmentView;
        int i6 = ThemeDescription.FLAG_BACKGROUND;
        int i7 = Theme.key_dialogBackground;
        arrayList.add(new ThemeDescription(view, i6, null, null, null, themeDescriptionDelegate, i7));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i7));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i7));
        ActionBar actionBar = this.actionBar;
        int i8 = ThemeDescription.FLAG_AB_ITEMSCOLOR;
        int i9 = Theme.key_dialogTextBlack;
        arrayList.add(new ThemeDescription(actionBar, i8, null, null, null, null, i9));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, i9));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_dialogButtonSelector));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCH, null, null, null, null, i9));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCHPLACEHOLDER, null, null, null, null, Theme.key_chat_messagePanelHint));
        ActionBarMenuItem actionBarMenuItem = this.searchItem;
        arrayList.add(new ThemeDescription(actionBarMenuItem != null ? actionBarMenuItem.getSearchField() : null, ThemeDescription.FLAG_CURSORCOLOR, null, null, null, null, i9));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUBACKGROUND, null, null, null, themeDescriptionDelegate, Theme.key_actionBarDefaultSubmenuBackground));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, themeDescriptionDelegate, Theme.key_actionBarDefaultSubmenuItem));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_IMAGECOLOR | ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, themeDescriptionDelegate, Theme.key_actionBarDefaultSubmenuItemIcon));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        ImageView imageView = this.emptyImageView;
        int i10 = ThemeDescription.FLAG_IMAGECOLOR;
        int i11 = Theme.key_dialogEmptyImage;
        arrayList.add(new ThemeDescription(imageView, i10, null, null, null, null, i11));
        TextView textView = this.emptyTitleTextView;
        int i12 = ThemeDescription.FLAG_TEXTCOLOR;
        int i13 = Theme.key_dialogEmptyText;
        arrayList.add(new ThemeDescription(textView, i12, null, null, null, null, i13));
        arrayList.add(new ThemeDescription(this.emptySubtitleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i13));
        arrayList.add(new ThemeDescription(this.shadow, 0, null, null, null, null, Theme.key_sheet_scrollUp));
        ImageView imageView2 = this.locationButton;
        int i14 = ThemeDescription.FLAG_IMAGECOLOR | ThemeDescription.FLAG_CHECKTAG;
        int i15 = Theme.key_location_actionIcon;
        arrayList.add(new ThemeDescription(imageView2, i14, null, null, null, null, i15));
        ImageView imageView3 = this.locationButton;
        int i16 = ThemeDescription.FLAG_IMAGECOLOR | ThemeDescription.FLAG_CHECKTAG;
        int i17 = Theme.key_location_actionActiveIcon;
        arrayList.add(new ThemeDescription(imageView3, i16, null, null, null, null, i17));
        ImageView imageView4 = this.locationButton;
        int i18 = ThemeDescription.FLAG_BACKGROUNDFILTER;
        int i19 = Theme.key_location_actionBackground;
        arrayList.add(new ThemeDescription(imageView4, i18, null, null, null, null, i19));
        ImageView imageView5 = this.locationButton;
        int i20 = ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE;
        int i21 = Theme.key_location_actionPressedBackground;
        arrayList.add(new ThemeDescription(imageView5, i20, null, null, null, null, i21));
        arrayList.add(new ThemeDescription(this.mapTypeButton, 0, null, null, null, themeDescriptionDelegate, i15));
        arrayList.add(new ThemeDescription(this.mapTypeButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, i19));
        arrayList.add(new ThemeDescription(this.mapTypeButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, i21));
        arrayList.add(new ThemeDescription(this.proximityButton, 0, null, null, null, themeDescriptionDelegate, i15));
        arrayList.add(new ThemeDescription(this.proximityButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, i19));
        arrayList.add(new ThemeDescription(this.proximityButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, i21));
        arrayList.add(new ThemeDescription(this.searchAreaButton, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i17));
        arrayList.add(new ThemeDescription(this.searchAreaButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, i19));
        arrayList.add(new ThemeDescription(this.searchAreaButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, i21));
        arrayList.add(new ThemeDescription(null, 0, null, null, Theme.avatarDrawables, themeDescriptionDelegate, Theme.key_avatar_text));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundRed));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundOrange));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundViolet));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundGreen));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundCyan));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundBlue));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundPink));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, null, Theme.key_location_liveLocationProgress));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, null, Theme.key_location_placeLocationBackground));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, null, Theme.key_dialog_liveLocationProgress));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_CHECKTAG, new Class[]{SendLocationCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_location_sendLocationIcon));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_CHECKTAG, new Class[]{SendLocationCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_location_sendLiveLocationIcon));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_CHECKTAG, new Class[]{SendLocationCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_location_sendLocationBackground));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_CHECKTAG, new Class[]{SendLocationCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_location_sendLiveLocationBackground));
        int i22 = Theme.key_windowBackgroundWhiteGrayText3;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SendLocationCell.class}, new String[]{"accurateTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i22));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{SendLocationCell.class}, new String[]{"titleTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_location_sendLiveLocationText));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{SendLocationCell.class}, new String[]{"titleTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_location_sendLocationText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationDirectionCell.class}, new String[]{"buttonTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_featuredStickers_buttonText));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE, new Class[]{LocationDirectionCell.class}, new String[]{"frameLayout"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_featuredStickers_addButton));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{LocationDirectionCell.class}, new String[]{"frameLayout"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_featuredStickers_addButtonPressed));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{ShadowSectionCell.class}, null, null, null, Theme.key_windowBackgroundGray));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_dialogTextBlue2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{LocationCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i22));
        int i23 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i23));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationCell.class}, new String[]{"addressTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i22));
        arrayList.add(new ThemeDescription(this.searchListView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{LocationCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i22));
        arrayList.add(new ThemeDescription(this.searchListView, 0, new Class[]{LocationCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i23));
        arrayList.add(new ThemeDescription(this.searchListView, 0, new Class[]{LocationCell.class}, new String[]{"addressTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i22));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SharingLiveLocationCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i23));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SharingLiveLocationCell.class}, new String[]{"distanceTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i22));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationLoadingCell.class}, new String[]{"progressBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_progressCircle));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationLoadingCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i22));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationLoadingCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i22));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationPoweredCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i22));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{LocationPoweredCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i11));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationPoweredCell.class}, new String[]{"textView2"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i13));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$37() throws Resources.NotFoundException {
        this.mapTypeButton.setIconColor(Theme.getColor(Theme.key_location_actionIcon));
        this.mapTypeButton.redrawPopup(Theme.getColor(Theme.key_actionBarDefaultSubmenuBackground));
        this.mapTypeButton.setPopupItemsColor(Theme.getColor(Theme.key_actionBarDefaultSubmenuItemIcon), true);
        this.mapTypeButton.setPopupItemsColor(Theme.getColor(Theme.key_actionBarDefaultSubmenuItem), false);
        this.shadowDrawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogBackground), PorterDuff.Mode.MULTIPLY));
        this.shadow.invalidate();
        if (this.googleMap != null) {
            if (isActiveThemeDark()) {
                if (this.currentMapStyleDark) {
                    return;
                }
                this.currentMapStyleDark = true;
                this.googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(ApplicationLoader.applicationContext, R.raw.mapstyle_night));
                Circle circle = this.proximityCircle;
                if (circle != null) {
                    circle.setStrokeColor(-1);
                    this.proximityCircle.setFillColor(553648127);
                    return;
                }
                return;
            }
            if (this.currentMapStyleDark) {
                this.currentMapStyleDark = false;
                this.googleMap.setMapStyle(null);
                Circle circle2 = this.proximityCircle;
                if (circle2 != null) {
                    circle2.setStrokeColor(-16777216);
                    this.proximityCircle.setFillColor(536870912);
                }
            }
        }
    }
}

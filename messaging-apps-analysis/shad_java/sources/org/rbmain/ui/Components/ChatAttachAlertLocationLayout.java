package org.rbmain.ui.Components;

import android.animation.Animator;
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
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
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
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import ir.aaap.messengercore.model.LocationObject;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.LocationController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLRPC$GeoPoint;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$TL_geoPoint;
import org.rbmain.tgnet.TLRPC$TL_messageMediaGeo;
import org.rbmain.tgnet.TLRPC$TL_messageMediaGeoLive;
import org.rbmain.tgnet.TLRPC$TL_messageMediaVenue;
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
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.ChatAttachAlert;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes5.dex */
public class ChatAttachAlertLocationLayout extends ChatAttachAlert.AttachAlertLayout implements NotificationCenter.NotificationCenterDelegate {
    private LocationActivityAdapter adapter;
    private AnimatorSet animatorSet;
    private Paint backgroundPaint;
    private Bitmap[] bitmapCache;
    private boolean checkBackgroundPermission;
    private boolean checkGpsEnabled;
    private boolean checkPermission;
    private int clipSize;
    private boolean currentMapStyleDark;
    private LocationActivityDelegate delegate;
    private long dialogId;
    private ImageView emptyImageView;
    private TextView emptySubtitleTextView;
    private TextView emptyTitleTextView;
    private LinearLayout emptyView;
    private boolean first;
    private boolean firstWas;
    private CameraUpdate forceUpdate;
    private GoogleMap googleMap;
    private boolean ignoreLayout;
    private boolean isFirstLocation;
    private Marker lastPressedMarker;
    private FrameLayout lastPressedMarkerView;
    private VenueLocation lastPressedVenue;
    private FillLastLinearLayoutManager layoutManager;
    private RecyclerListView listView;
    private View loadingMapView;
    private ImageView locationButton;
    private int locationType;
    private int mapHeight;
    private ActionBarMenuItem mapTypeButton;
    private MapView mapView;
    private FrameLayout mapViewClip;
    private boolean mapsInitialized;
    private ImageView markerImageView;
    private int markerTop;
    private Location myLocation;
    private int nonClipSize;
    private boolean onResumeCalled;
    private ActionBarMenuItem otherItem;
    private int overScrollHeight;
    private MapOverlayView overlayView;
    private ArrayList<VenueLocation> placeMarkers;
    private boolean scrolling;
    private LocationActivitySearchAdapter searchAdapter;
    private SearchButton searchAreaButton;
    private boolean searchInProgress;
    private ActionBarMenuItem searchItem;
    private RecyclerListView searchListView;
    private boolean searchWas;
    private boolean searchedForCustomLocations;
    private boolean searching;
    private Location userLocation;
    private boolean userLocationMoved;
    private float yOffset;

    public static class LiveLocation {
        public Marker marker;
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
    public static /* synthetic */ boolean lambda$new$4(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    int needsActionBar() {
        return 1;
    }

    static /* synthetic */ float access$2816(ChatAttachAlertLocationLayout chatAttachAlertLocationLayout, float f) {
        float f2 = chatAttachAlertLocationLayout.yOffset + f;
        chatAttachAlertLocationLayout.yOffset = f2;
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
            if (ChatAttachAlertLocationLayout.this.lastPressedVenue == venueLocation) {
                return;
            }
            ChatAttachAlertLocationLayout.this.showSearchPlacesButton(false);
            if (ChatAttachAlertLocationLayout.this.lastPressedMarker != null) {
                removeInfoView(ChatAttachAlertLocationLayout.this.lastPressedMarker);
                ChatAttachAlertLocationLayout.this.lastPressedMarker = null;
            }
            ChatAttachAlertLocationLayout.this.lastPressedVenue = venueLocation;
            ChatAttachAlertLocationLayout.this.lastPressedMarker = marker;
            Context context = getContext();
            FrameLayout frameLayout = new FrameLayout(context);
            addView(frameLayout, LayoutHelper.createFrame(-2, 114.0f));
            ChatAttachAlertLocationLayout.this.lastPressedMarkerView = new FrameLayout(context);
            ChatAttachAlertLocationLayout.this.lastPressedMarkerView.setBackgroundResource(R.drawable.venue_tooltip);
            ChatAttachAlertLocationLayout.this.lastPressedMarkerView.getBackground().setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogBackground), PorterDuff.Mode.MULTIPLY));
            frameLayout.addView(ChatAttachAlertLocationLayout.this.lastPressedMarkerView, LayoutHelper.createFrame(-2, 71.0f));
            ChatAttachAlertLocationLayout.this.lastPressedMarkerView.setAlpha(0.0f);
            ChatAttachAlertLocationLayout.this.lastPressedMarkerView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$MapOverlayView$$ExternalSyntheticLambda0
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
            ChatAttachAlertLocationLayout.this.lastPressedMarkerView.addView(textView, LayoutHelper.createFrame(-2, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 18.0f, 10.0f, 18.0f, 0.0f));
            TextView textView2 = new TextView(context);
            textView2.setTextSize(1, 14.0f);
            textView2.setMaxLines(1);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setSingleLine(true);
            textView2.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText3));
            textView2.setGravity(LocaleController.isRTL ? 5 : 3);
            ChatAttachAlertLocationLayout.this.lastPressedMarkerView.addView(textView2, LayoutHelper.createFrame(-2, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 18.0f, 32.0f, 18.0f, 0.0f));
            textView.setText(venueLocation.venue.title);
            textView2.setText(LocaleController.getString("TapToSendLocation", R.string.TapToSendLocation));
            final FrameLayout frameLayout2 = new FrameLayout(context);
            frameLayout2.setBackground(Theme.createCircleDrawable(AndroidUtilities.dp(36.0f), LocationCell.getColorForIndex(venueLocation.num)));
            frameLayout.addView(frameLayout2, LayoutHelper.createFrame(36, 36.0f, 81, 0.0f, 0.0f, 0.0f, 4.0f));
            BackupImageView backupImageView = new BackupImageView(context);
            backupImageView.setImage("https://ss3.4sqi.net/img/categories_v2/" + venueLocation.venue.venue_type + "_64.png", null, null);
            frameLayout2.addView(backupImageView, LayoutHelper.createFrame(30, 30, 17));
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout.MapOverlayView.1
                private final float[] animatorValues = {0.0f, 1.0f};
                private boolean startedInner;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float interpolation;
                    float fLerp = AndroidUtilities.lerp(this.animatorValues, valueAnimator.getAnimatedFraction());
                    if (fLerp >= 0.7f && !this.startedInner && ChatAttachAlertLocationLayout.this.lastPressedMarkerView != null) {
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(ObjectAnimator.ofFloat(ChatAttachAlertLocationLayout.this.lastPressedMarkerView, (Property<FrameLayout, Float>) View.SCALE_X, 0.0f, 1.0f), ObjectAnimator.ofFloat(ChatAttachAlertLocationLayout.this.lastPressedMarkerView, (Property<FrameLayout, Float>) View.SCALE_Y, 0.0f, 1.0f), ObjectAnimator.ofFloat(ChatAttachAlertLocationLayout.this.lastPressedMarkerView, (Property<FrameLayout, Float>) View.ALPHA, 0.0f, 1.0f));
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
            ChatAttachAlertLocationLayout.this.googleMap.animateCamera(CameraUpdateFactory.newLatLng(marker.getPosition()), 300, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$addInfoView$1(final VenueLocation venueLocation, View view) {
            ChatActivity chatActivity = (ChatActivity) ChatAttachAlertLocationLayout.this.parentAlert.baseFragment;
            if (chatActivity.isInScheduleMode()) {
                AlertsCreator.createScheduleDatePickerDialog(ChatAttachAlertLocationLayout.this.getParentActivity(), chatActivity.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$MapOverlayView$$ExternalSyntheticLambda1
                    @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                    public final void didSelectDate(boolean z, int i) {
                        this.f$0.lambda$addInfoView$0(venueLocation, z, i);
                    }
                });
            } else {
                ChatAttachAlertLocationLayout.this.delegate.didSelectLocation(venueLocation.venue, ChatAttachAlertLocationLayout.this.locationType, true, 0);
                ChatAttachAlertLocationLayout.this.parentAlert.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$addInfoView$0(VenueLocation venueLocation, boolean z, int i) {
            ChatAttachAlertLocationLayout.this.delegate.didSelectLocation(venueLocation.venue, ChatAttachAlertLocationLayout.this.locationType, z, i);
            ChatAttachAlertLocationLayout.this.parentAlert.dismiss();
        }

        public void removeInfoView(Marker marker) {
            View view = this.views.get(marker);
            if (view != null) {
                removeView(view);
                this.views.remove(marker);
            }
        }

        public void updatePositions() {
            if (ChatAttachAlertLocationLayout.this.googleMap == null) {
                return;
            }
            Projection projection = ChatAttachAlertLocationLayout.this.googleMap.getProjection();
            for (Map.Entry<Marker, View> entry : this.views.entrySet()) {
                Marker key = entry.getKey();
                View value = entry.getValue();
                android.graphics.Point screenLocation = projection.toScreenLocation(key.getPosition());
                value.setTranslationX(screenLocation.x - (value.getMeasuredWidth() / 2));
                value.setTranslationY((screenLocation.y - value.getMeasuredHeight()) + AndroidUtilities.dp(22.0f));
            }
        }
    }

    public ChatAttachAlertLocationLayout(ChatAttachAlert chatAttachAlert, Context context) {
        super(chatAttachAlert, context);
        this.checkGpsEnabled = true;
        this.isFirstLocation = true;
        this.backgroundPaint = new Paint();
        this.placeMarkers = new ArrayList<>();
        this.checkPermission = true;
        this.checkBackgroundPermission = true;
        int currentActionBarHeight = (AndroidUtilities.displaySize.x - ActionBar.getCurrentActionBarHeight()) - AndroidUtilities.dp(66.0f);
        this.overScrollHeight = currentActionBarHeight;
        this.mapHeight = currentActionBarHeight;
        this.first = true;
        this.bitmapCache = new Bitmap[7];
        AndroidUtilities.fixGoogleMapsBug();
        final ChatActivity chatActivity = (ChatActivity) this.parentAlert.baseFragment;
        this.dialogId = chatActivity.getDialogId();
        this.locationType = 0;
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.locationPermissionGranted);
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
        ActionBarMenu actionBarMenuCreateMenu = this.parentAlert.actionBar.createMenu();
        this.overlayView = new MapOverlayView(context);
        ActionBarMenuItem actionBarMenuItemSearchListener = actionBarMenuCreateMenu.addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout.1
            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchExpand() {
                ChatAttachAlertLocationLayout.this.searching = true;
                ChatAttachAlertLocationLayout chatAttachAlertLocationLayout = ChatAttachAlertLocationLayout.this;
                chatAttachAlertLocationLayout.parentAlert.makeFocusable(chatAttachAlertLocationLayout.searchItem.getSearchField(), true);
            }

            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchCollapse() {
                ChatAttachAlertLocationLayout.this.searching = false;
                ChatAttachAlertLocationLayout.this.searchWas = false;
                ChatAttachAlertLocationLayout.this.searchAdapter.searchDelayed(null, null);
                ChatAttachAlertLocationLayout.this.updateEmptyView();
            }

            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onTextChanged(EditText editText) {
                if (ChatAttachAlertLocationLayout.this.searchAdapter == null) {
                    return;
                }
                String string = editText.getText().toString();
                if (string.length() != 0) {
                    ChatAttachAlertLocationLayout.this.searchWas = true;
                    ChatAttachAlertLocationLayout.this.searchItem.setShowSearchProgress(true);
                    if (ChatAttachAlertLocationLayout.this.otherItem != null) {
                        ChatAttachAlertLocationLayout.this.otherItem.setVisibility(8);
                    }
                    ChatAttachAlertLocationLayout.this.listView.setVisibility(8);
                    ChatAttachAlertLocationLayout.this.mapViewClip.setVisibility(8);
                    if (ChatAttachAlertLocationLayout.this.searchListView.getAdapter() != ChatAttachAlertLocationLayout.this.searchAdapter) {
                        ChatAttachAlertLocationLayout.this.searchListView.setAdapter(ChatAttachAlertLocationLayout.this.searchAdapter);
                    }
                    ChatAttachAlertLocationLayout.this.searchListView.setVisibility(0);
                    ChatAttachAlertLocationLayout chatAttachAlertLocationLayout = ChatAttachAlertLocationLayout.this;
                    chatAttachAlertLocationLayout.searchInProgress = chatAttachAlertLocationLayout.searchAdapter.getItemCount() == 0;
                    ChatAttachAlertLocationLayout.this.updateEmptyView();
                } else {
                    if (ChatAttachAlertLocationLayout.this.otherItem != null) {
                        ChatAttachAlertLocationLayout.this.otherItem.setVisibility(0);
                    }
                    ChatAttachAlertLocationLayout.this.listView.setVisibility(0);
                    ChatAttachAlertLocationLayout.this.mapViewClip.setVisibility(0);
                    ChatAttachAlertLocationLayout.this.searchListView.setAdapter(null);
                    ChatAttachAlertLocationLayout.this.searchListView.setVisibility(8);
                    ChatAttachAlertLocationLayout.this.emptyView.setVisibility(8);
                }
                ChatAttachAlertLocationLayout.this.searchAdapter.searchDelayed(string, ChatAttachAlertLocationLayout.this.userLocation);
            }
        });
        this.searchItem = actionBarMenuItemSearchListener;
        actionBarMenuItemSearchListener.setSearchFieldHint(LocaleController.getString("Search", R.string.Search));
        this.searchItem.setContentDescription(LocaleController.getString("Search", R.string.Search));
        EditTextBoldCursor searchField = this.searchItem.getSearchField();
        int i = Theme.key_dialogTextBlack;
        searchField.setTextColor(Theme.getColor(i));
        searchField.setCursorColor(Theme.getColor(i));
        searchField.setHintTextColor(Theme.getColor(Theme.key_chat_messagePanelHint));
        new FrameLayout.LayoutParams(-1, AndroidUtilities.dp(21.0f)).gravity = 83;
        FrameLayout frameLayout = new FrameLayout(context) { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout.2
            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i2, int i3) {
                super.onMeasure(i2, i3);
                if (ChatAttachAlertLocationLayout.this.overlayView != null) {
                    ChatAttachAlertLocationLayout.this.overlayView.updatePositions();
                }
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View view, long j) {
                canvas.save();
                canvas.clipRect(0, 0, getMeasuredWidth(), getMeasuredHeight() - ChatAttachAlertLocationLayout.this.clipSize);
                boolean zDrawChild = super.drawChild(canvas, view, j);
                canvas.restore();
                return zDrawChild;
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                ChatAttachAlertLocationLayout.this.backgroundPaint.setColor(Theme.getColor(Theme.key_dialogBackground));
                canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight() - ChatAttachAlertLocationLayout.this.clipSize, ChatAttachAlertLocationLayout.this.backgroundPaint);
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                if (motionEvent.getY() > getMeasuredHeight() - ChatAttachAlertLocationLayout.this.clipSize) {
                    return false;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }

            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                if (motionEvent.getY() > getMeasuredHeight() - ChatAttachAlertLocationLayout.this.clipSize) {
                    return false;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
        };
        this.mapViewClip = frameLayout;
        frameLayout.setWillNotDraw(false);
        View view = new View(context);
        this.loadingMapView = view;
        view.setBackgroundDrawable(new MapPlaceholderDrawable());
        SearchButton searchButton = new SearchButton(context);
        this.searchAreaButton = searchButton;
        searchButton.setTranslationX(-AndroidUtilities.dp(80.0f));
        this.searchAreaButton.setVisibility(4);
        int iDp = AndroidUtilities.dp(40.0f);
        int i2 = Theme.key_location_actionBackground;
        int color = Theme.getColor(i2);
        int i3 = Theme.key_location_actionPressedBackground;
        Drawable drawableCreateSimpleSelectorRoundRectDrawable = Theme.createSimpleSelectorRoundRectDrawable(iDp, color, Theme.getColor(i3));
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 21) {
            Drawable drawableMutate = context.getResources().getDrawable(R.drawable.places_btn).mutate();
            drawableMutate.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, drawableCreateSimpleSelectorRoundRectDrawable, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f));
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
            this.searchAreaButton.setOutlineProvider(new ViewOutlineProvider(this) { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout.3
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    outline.setRoundRect(0, 0, view2.getMeasuredWidth(), view2.getMeasuredHeight(), view2.getMeasuredHeight() / 2);
                }
            });
        }
        this.searchAreaButton.setBackgroundDrawable(drawableCreateSimpleSelectorRoundRectDrawable);
        SearchButton searchButton3 = this.searchAreaButton;
        int i5 = Theme.key_location_actionActiveIcon;
        searchButton3.setTextColor(Theme.getColor(i5));
        this.searchAreaButton.setTextSize(1, 14.0f);
        this.searchAreaButton.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.searchAreaButton.setText(LocaleController.getString("PlacesInThisArea", R.string.PlacesInThisArea));
        this.searchAreaButton.setGravity(17);
        this.searchAreaButton.setPadding(AndroidUtilities.dp(20.0f), 0, AndroidUtilities.dp(20.0f), 0);
        this.mapViewClip.addView(this.searchAreaButton, LayoutHelper.createFrame(-2, i4 >= 21 ? 40.0f : 44.0f, 49, 80.0f, 12.0f, 80.0f, 0.0f));
        this.searchAreaButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$0(view2);
            }
        });
        ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, null, 0, Theme.getColor(Theme.key_location_actionIcon));
        this.mapTypeButton = actionBarMenuItem;
        actionBarMenuItem.setClickable(true);
        this.mapTypeButton.setSubMenuOpenSide(2);
        this.mapTypeButton.setAdditionalXOffset(AndroidUtilities.dp(10.0f));
        this.mapTypeButton.setAdditionalYOffset(-AndroidUtilities.dp(10.0f));
        this.mapTypeButton.addSubItem(2, R.drawable.msg_map, LocaleController.getString("Map", R.string.Map));
        this.mapTypeButton.addSubItem(3, R.drawable.msg_satellite, LocaleController.getString("Satellite", R.string.Satellite));
        this.mapTypeButton.addSubItem(4, R.drawable.msg_hybrid, LocaleController.getString("Hybrid", R.string.Hybrid));
        this.mapTypeButton.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(40.0f), Theme.getColor(i2), Theme.getColor(i3));
        if (i4 < 21) {
            Drawable drawableMutate2 = context.getResources().getDrawable(R.drawable.floating_shadow_profile).mutate();
            drawableMutate2.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable2 = new CombinedDrawable(drawableMutate2, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
            combinedDrawable2.setIconSize(AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
            drawableCreateSimpleSelectorCircleDrawable = combinedDrawable2;
        } else {
            StateListAnimator stateListAnimator2 = new StateListAnimator();
            int[] iArr2 = {android.R.attr.state_pressed};
            ActionBarMenuItem actionBarMenuItem2 = this.mapTypeButton;
            Property property2 = View.TRANSLATION_Z;
            stateListAnimator2.addState(iArr2, ObjectAnimator.ofFloat(actionBarMenuItem2, (Property<ActionBarMenuItem, Float>) property2, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f)).setDuration(200L));
            stateListAnimator2.addState(new int[0], ObjectAnimator.ofFloat(this.mapTypeButton, (Property<ActionBarMenuItem, Float>) property2, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
            this.mapTypeButton.setStateListAnimator(stateListAnimator2);
            this.mapTypeButton.setOutlineProvider(new ViewOutlineProvider(this) { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout.4
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
                }
            });
        }
        this.mapTypeButton.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable);
        this.mapTypeButton.setIcon(R.drawable.location_type);
        this.mapViewClip.addView(this.mapTypeButton, LayoutHelper.createFrame(i4 >= 21 ? 40 : 44, i4 >= 21 ? 40.0f : 44.0f, 53, 0.0f, 12.0f, 12.0f, 0.0f));
        this.mapTypeButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$1(view2);
            }
        });
        this.mapTypeButton.setDelegate(new ActionBarMenuItem.ActionBarMenuItemDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda20
            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemDelegate
            public final void onItemClick(int i6) {
                this.f$0.lambda$new$2(i6);
            }
        });
        this.locationButton = new ImageView(context);
        Drawable drawableCreateSimpleSelectorCircleDrawable2 = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(40.0f), Theme.getColor(i2), Theme.getColor(i3));
        if (i4 < 21) {
            Drawable drawableMutate3 = context.getResources().getDrawable(R.drawable.floating_shadow_profile).mutate();
            drawableMutate3.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable3 = new CombinedDrawable(drawableMutate3, drawableCreateSimpleSelectorCircleDrawable2, 0, 0);
            combinedDrawable3.setIconSize(AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
            drawableCreateSimpleSelectorCircleDrawable2 = combinedDrawable3;
        } else {
            StateListAnimator stateListAnimator3 = new StateListAnimator();
            int[] iArr3 = {android.R.attr.state_pressed};
            ImageView imageView = this.locationButton;
            Property property3 = View.TRANSLATION_Z;
            stateListAnimator3.addState(iArr3, ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property3, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f)).setDuration(200L));
            stateListAnimator3.addState(new int[0], ObjectAnimator.ofFloat(this.locationButton, (Property<ImageView, Float>) property3, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
            this.locationButton.setStateListAnimator(stateListAnimator3);
            this.locationButton.setOutlineProvider(new ViewOutlineProvider(this) { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout.5
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
                }
            });
        }
        this.locationButton.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable2);
        this.locationButton.setImageResource(R.drawable.location_current);
        this.locationButton.setScaleType(ImageView.ScaleType.CENTER);
        this.locationButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i5), PorterDuff.Mode.MULTIPLY));
        this.locationButton.setTag(Integer.valueOf(i5));
        this.locationButton.setContentDescription(LocaleController.getString("AccDescrMyLocation", R.string.AccDescrMyLocation));
        this.mapViewClip.addView(this.locationButton, LayoutHelper.createFrame(i4 >= 21 ? 40 : 44, i4 >= 21 ? 40.0f : 44.0f, 85, 0.0f, 0.0f, 12.0f, 12.0f));
        this.locationButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$3(view2);
            }
        });
        LinearLayout linearLayout = new LinearLayout(context);
        this.emptyView = linearLayout;
        linearLayout.setOrientation(1);
        this.emptyView.setGravity(1);
        this.emptyView.setPadding(0, AndroidUtilities.dp(160.0f), 0, 0);
        this.emptyView.setVisibility(8);
        addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        this.emptyView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda5
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return ChatAttachAlertLocationLayout.lambda$new$4(view2, motionEvent);
            }
        });
        ImageView imageView2 = new ImageView(context);
        this.emptyImageView = imageView2;
        imageView2.setImageResource(R.drawable.location_empty);
        this.emptyImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogEmptyImage), PorterDuff.Mode.MULTIPLY));
        this.emptyView.addView(this.emptyImageView, LayoutHelper.createLinear(-2, -2));
        TextView textView = new TextView(context);
        this.emptyTitleTextView = textView;
        int i6 = Theme.key_dialogEmptyText;
        textView.setTextColor(Theme.getColor(i6));
        this.emptyTitleTextView.setGravity(17);
        this.emptyTitleTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.emptyTitleTextView.setTextSize(1, 17.0f);
        this.emptyTitleTextView.setText(LocaleController.getString("NoPlacesFound", R.string.NoPlacesFound));
        this.emptyView.addView(this.emptyTitleTextView, LayoutHelper.createLinear(-2, -2, 17, 0, 11, 0, 0));
        TextView textView2 = new TextView(context);
        this.emptySubtitleTextView = textView2;
        textView2.setTextColor(Theme.getColor(i6));
        this.emptySubtitleTextView.setGravity(17);
        this.emptySubtitleTextView.setTextSize(1, 15.0f);
        this.emptySubtitleTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), 0);
        this.emptyView.addView(this.emptySubtitleTextView, LayoutHelper.createLinear(-2, -2, 17, 0, 6, 0, 0));
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout.6
            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i7, int i8, int i9, int i10) {
                super.onLayout(z, i7, i8, i9, i10);
                ChatAttachAlertLocationLayout.this.updateClipView();
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setClipToPadding(false);
        RecyclerListView recyclerListView2 = this.listView;
        LocationActivityAdapter locationActivityAdapter2 = new LocationActivityAdapter(context, this.locationType, this.dialogId, true);
        this.adapter = locationActivityAdapter2;
        recyclerListView2.setAdapter(locationActivityAdapter2);
        this.adapter.setUpdateRunnable(new Runnable() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.updateClipView();
            }
        });
        this.listView.setVerticalScrollBarEnabled(false);
        RecyclerListView recyclerListView3 = this.listView;
        FillLastLinearLayoutManager fillLastLinearLayoutManager = new FillLastLinearLayoutManager(context, 1, false, 0, recyclerListView3) { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout.7
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i7) {
                LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout.7.1
                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    public int calculateDyToMakeVisible(View view2, int i8) {
                        return super.calculateDyToMakeVisible(view2, i8) - (ChatAttachAlertLocationLayout.this.listView.getPaddingTop() - (ChatAttachAlertLocationLayout.this.mapHeight - ChatAttachAlertLocationLayout.this.overScrollHeight));
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    protected int calculateTimeForDeceleration(int i8) {
                        return super.calculateTimeForDeceleration(i8) * 4;
                    }
                };
                linearSmoothScroller.setTargetPosition(i7);
                startSmoothScroll(linearSmoothScroller);
            }
        };
        this.layoutManager = fillLastLinearLayoutManager;
        recyclerListView3.setLayoutManager(fillLastLinearLayoutManager);
        addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout.8
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i7) {
                RecyclerListView.Holder holder;
                ChatAttachAlertLocationLayout.this.scrolling = i7 != 0;
                if (!ChatAttachAlertLocationLayout.this.scrolling && ChatAttachAlertLocationLayout.this.forceUpdate != null) {
                    ChatAttachAlertLocationLayout.this.forceUpdate = null;
                }
                if (i7 == 0) {
                    int iDp2 = AndroidUtilities.dp(13.0f);
                    int backgroundPaddingTop = ChatAttachAlertLocationLayout.this.parentAlert.getBackgroundPaddingTop();
                    if (((ChatAttachAlertLocationLayout.this.parentAlert.scrollOffsetY[0] - backgroundPaddingTop) - iDp2) + backgroundPaddingTop >= ActionBar.getCurrentActionBarHeight() || (holder = (RecyclerListView.Holder) ChatAttachAlertLocationLayout.this.listView.findViewHolderForAdapterPosition(0)) == null || holder.itemView.getTop() <= ChatAttachAlertLocationLayout.this.mapHeight - ChatAttachAlertLocationLayout.this.overScrollHeight) {
                        return;
                    }
                    ChatAttachAlertLocationLayout.this.listView.smoothScrollBy(0, holder.itemView.getTop() - (ChatAttachAlertLocationLayout.this.mapHeight - ChatAttachAlertLocationLayout.this.overScrollHeight));
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i7, int i8) {
                ChatAttachAlertLocationLayout.this.updateClipView();
                if (ChatAttachAlertLocationLayout.this.forceUpdate != null) {
                    ChatAttachAlertLocationLayout.access$2816(ChatAttachAlertLocationLayout.this, i8);
                }
                ChatAttachAlertLocationLayout chatAttachAlertLocationLayout = ChatAttachAlertLocationLayout.this;
                chatAttachAlertLocationLayout.parentAlert.updateLayout(chatAttachAlertLocationLayout, true, i8);
            }
        });
        ((DefaultItemAnimator) this.listView.getItemAnimator()).setDelayAnimations(false);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda27
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view2, int i7) {
                this.f$0.lambda$new$7(chatActivity, view2, i7);
            }
        });
        this.adapter.setDelegate(this.dialogId, new BaseLocationAdapter.BaseLocationAdapterDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda22
            @Override // org.rbmain.ui.Adapters.BaseLocationAdapter.BaseLocationAdapterDelegate
            public final void didLoadSearchResult(ArrayList arrayList) {
                this.f$0.updatePlacesMarkers(arrayList);
            }
        });
        this.adapter.setOverScrollHeight(this.overScrollHeight);
        addView(this.mapViewClip, LayoutHelper.createFrame(-1, -1, 51));
        final MapView mapView = new MapView(context) { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout.9
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                MotionEvent motionEvent2;
                if (ChatAttachAlertLocationLayout.this.yOffset != 0.0f) {
                    motionEvent = MotionEvent.obtain(motionEvent);
                    motionEvent.offsetLocation(0.0f, (-ChatAttachAlertLocationLayout.this.yOffset) / 2.0f);
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
                if (motionEvent.getAction() == 0) {
                    if (ChatAttachAlertLocationLayout.this.animatorSet != null) {
                        ChatAttachAlertLocationLayout.this.animatorSet.cancel();
                    }
                    ChatAttachAlertLocationLayout.this.animatorSet = new AnimatorSet();
                    ChatAttachAlertLocationLayout.this.animatorSet.setDuration(200L);
                    ChatAttachAlertLocationLayout.this.animatorSet.playTogether(ObjectAnimator.ofFloat(ChatAttachAlertLocationLayout.this.markerImageView, (Property<ImageView, Float>) View.TRANSLATION_Y, ChatAttachAlertLocationLayout.this.markerTop - AndroidUtilities.dp(10.0f)));
                    ChatAttachAlertLocationLayout.this.animatorSet.start();
                } else if (motionEvent.getAction() == 1) {
                    if (ChatAttachAlertLocationLayout.this.animatorSet != null) {
                        ChatAttachAlertLocationLayout.this.animatorSet.cancel();
                    }
                    ChatAttachAlertLocationLayout.this.yOffset = 0.0f;
                    ChatAttachAlertLocationLayout.this.animatorSet = new AnimatorSet();
                    ChatAttachAlertLocationLayout.this.animatorSet.setDuration(200L);
                    ChatAttachAlertLocationLayout.this.animatorSet.playTogether(ObjectAnimator.ofFloat(ChatAttachAlertLocationLayout.this.markerImageView, (Property<ImageView, Float>) View.TRANSLATION_Y, ChatAttachAlertLocationLayout.this.markerTop));
                    ChatAttachAlertLocationLayout.this.animatorSet.start();
                    ChatAttachAlertLocationLayout.this.adapter.fetchLocationAddress();
                }
                if (motionEvent.getAction() == 2) {
                    if (!ChatAttachAlertLocationLayout.this.userLocationMoved) {
                        ImageView imageView3 = ChatAttachAlertLocationLayout.this.locationButton;
                        int i7 = Theme.key_location_actionIcon;
                        imageView3.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i7), PorterDuff.Mode.MULTIPLY));
                        ChatAttachAlertLocationLayout.this.locationButton.setTag(Integer.valueOf(i7));
                        ChatAttachAlertLocationLayout.this.userLocationMoved = true;
                    }
                    if (ChatAttachAlertLocationLayout.this.googleMap != null && ChatAttachAlertLocationLayout.this.userLocation != null) {
                        ChatAttachAlertLocationLayout.this.userLocation.setLatitude(ChatAttachAlertLocationLayout.this.googleMap.getCameraPosition().target.latitude);
                        ChatAttachAlertLocationLayout.this.userLocation.setLongitude(ChatAttachAlertLocationLayout.this.googleMap.getCameraPosition().target.longitude);
                    }
                    ChatAttachAlertLocationLayout.this.adapter.setCustomLocation(ChatAttachAlertLocationLayout.this.userLocation);
                }
                return super.onInterceptTouchEvent(motionEvent);
            }
        };
        this.mapView = mapView;
        new Thread(new Runnable() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$12(mapView);
            }
        }).start();
        ImageView imageView3 = new ImageView(context);
        this.markerImageView = imageView3;
        imageView3.setImageResource(R.drawable.map_pin2);
        this.mapViewClip.addView(this.markerImageView, LayoutHelper.createFrame(28, 48, 49));
        RecyclerListView recyclerListView4 = new RecyclerListView(context);
        this.searchListView = recyclerListView4;
        recyclerListView4.setVisibility(8);
        this.searchListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        LocationActivitySearchAdapter locationActivitySearchAdapter2 = new LocationActivitySearchAdapter(context) { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout.10
            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void notifyDataSetChanged() {
                if (ChatAttachAlertLocationLayout.this.searchItem != null) {
                    ChatAttachAlertLocationLayout.this.searchItem.setShowSearchProgress(ChatAttachAlertLocationLayout.this.searchAdapter.isSearching());
                }
                if (ChatAttachAlertLocationLayout.this.emptySubtitleTextView != null) {
                    ChatAttachAlertLocationLayout.this.emptySubtitleTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("NoPlacesFoundInfo", R.string.NoPlacesFoundInfo, ChatAttachAlertLocationLayout.this.searchAdapter.getLastSearchString())));
                }
                super.notifyDataSetChanged();
            }
        };
        this.searchAdapter = locationActivitySearchAdapter2;
        locationActivitySearchAdapter2.setDelegate(0L, new BaseLocationAdapter.BaseLocationAdapterDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda23
            @Override // org.rbmain.ui.Adapters.BaseLocationAdapter.BaseLocationAdapterDelegate
            public final void didLoadSearchResult(ArrayList arrayList) {
                this.f$0.lambda$new$13(arrayList);
            }
        });
        addView(this.searchListView, LayoutHelper.createFrame(-1, -1, 51));
        this.searchListView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout.11
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i7) {
                if (i7 == 1 && ChatAttachAlertLocationLayout.this.searching && ChatAttachAlertLocationLayout.this.searchWas) {
                    AndroidUtilities.hideKeyboard(ChatAttachAlertLocationLayout.this.parentAlert.getCurrentFocus());
                }
            }
        });
        this.searchListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda28
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view2, int i7) {
                this.f$0.lambda$new$15(chatActivity, view2, i7);
            }
        });
        updateEmptyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        showSearchPlacesButton(false);
        this.adapter.searchPlacesWithQuery(null, this.userLocation, true, true);
        this.searchedForCustomLocations = true;
        showResults();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view) {
        this.mapTypeButton.toggleSubMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(int i) {
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
    public /* synthetic */ void lambda$new$3(View view) {
        Activity parentActivity;
        if (Build.VERSION.SDK_INT >= 23 && (parentActivity = getParentActivity()) != null && parentActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            showPermissionAlert(false);
            return;
        }
        if (this.myLocation != null && this.googleMap != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$7(ChatActivity chatActivity, View view, int i) {
        if (i == 1) {
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
            if (chatActivity.isInScheduleMode()) {
                AlertsCreator.createScheduleDatePickerDialog(getParentActivity(), chatActivity.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda25
                    @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                    public final void didSelectDate(boolean z, int i2) {
                        this.f$0.lambda$new$5(tLRPC$TL_messageMediaGeo, z, i2);
                    }
                });
                return;
            } else {
                this.delegate.didSelectLocation(tLRPC$TL_messageMediaGeo, this.locationType, true, 0);
                this.parentAlert.dismiss();
                return;
            }
        }
        if (i == 2 && this.locationType == 1) {
            if (getLocationController().isSharingLocation(this.dialogId)) {
                getLocationController().removeSharingLocation(this.dialogId);
                this.parentAlert.dismiss();
                return;
            } else {
                openShareLiveLocation();
                return;
            }
        }
        final Object item = this.adapter.getItem(i);
        if (item instanceof TLRPC$TL_messageMediaVenue) {
            if (chatActivity.isInScheduleMode()) {
                AlertsCreator.createScheduleDatePickerDialog(getParentActivity(), chatActivity.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda24
                    @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                    public final void didSelectDate(boolean z, int i2) {
                        this.f$0.lambda$new$6(item, z, i2);
                    }
                });
                return;
            } else {
                this.delegate.didSelectLocation((TLRPC$TL_messageMediaVenue) item, this.locationType, true, 0);
                this.parentAlert.dismiss();
                return;
            }
        }
        if (item instanceof LiveLocation) {
            this.googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(((LiveLocation) item).marker.getPosition(), this.googleMap.getMaxZoomLevel() - 4.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5(TLRPC$TL_messageMediaGeo tLRPC$TL_messageMediaGeo, boolean z, int i) {
        this.delegate.didSelectLocation(tLRPC$TL_messageMediaGeo, this.locationType, z, i);
        this.parentAlert.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$6(Object obj, boolean z, int i) {
        this.delegate.didSelectLocation((TLRPC$TL_messageMediaVenue) obj, this.locationType, z, i);
        this.parentAlert.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$12(final MapView mapView) {
        try {
            mapView.onCreate(null);
        } catch (Exception unused) {
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$11(mapView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$11(MapView mapView) {
        if (this.mapView == null || getParentActivity() == null) {
            return;
        }
        try {
            mapView.onCreate(null);
            MapsInitializer.initialize(ApplicationLoader.applicationContext);
            this.mapView.getMapAsync(new OnMapReadyCallback() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda11
                @Override // com.google.android.gms.maps.OnMapReadyCallback
                public final void onMapReady(GoogleMap googleMap) throws Resources.NotFoundException {
                    this.f$0.lambda$new$10(googleMap);
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
    public /* synthetic */ void lambda$new$10(GoogleMap googleMap) throws Resources.NotFoundException {
        this.googleMap = googleMap;
        googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda8
            @Override // com.google.android.gms.maps.GoogleMap.OnMapLoadedCallback
            public final void onMapLoaded() {
                this.f$0.lambda$new$9();
            }
        });
        if (isActiveThemeDark()) {
            this.currentMapStyleDark = true;
            this.googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(ApplicationLoader.applicationContext, R.raw.mapstyle_night));
        }
        onMapInit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$9() {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$8();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$8() {
        this.loadingMapView.setTag(1);
        this.loadingMapView.animate().alpha(0.0f).setDuration(180L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$13(ArrayList arrayList) {
        this.searchInProgress = false;
        updateEmptyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$15(ChatActivity chatActivity, View view, int i) {
        final TLRPC$TL_messageMediaVenue item = this.searchAdapter.getItem(i);
        if (item == null || this.delegate == null) {
            return;
        }
        if (chatActivity.isInScheduleMode()) {
            AlertsCreator.createScheduleDatePickerDialog(getParentActivity(), chatActivity.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda26
                @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                public final void didSelectDate(boolean z, int i2) {
                    this.f$0.lambda$new$14(item, z, i2);
                }
            });
        } else {
            this.delegate.didSelectLocation(item, this.locationType, true, 0);
            this.parentAlert.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$14(TLRPC$TL_messageMediaVenue tLRPC$TL_messageMediaVenue, boolean z, int i) {
        this.delegate.didSelectLocation(tLRPC$TL_messageMediaVenue, this.locationType, z, i);
        this.parentAlert.dismiss();
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onPause() {
        MapView mapView = this.mapView;
        if (mapView != null && this.mapsInitialized) {
            try {
                mapView.onPause();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        this.onResumeCalled = false;
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onDestroy() {
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.locationPermissionGranted);
        try {
            GoogleMap googleMap = this.googleMap;
            if (googleMap != null) {
                googleMap.setMyLocationEnabled(false);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        MapView mapView = this.mapView;
        if (mapView != null) {
            mapView.setTranslationY((-AndroidUtilities.displaySize.y) * 3);
        }
        try {
            MapView mapView2 = this.mapView;
            if (mapView2 != null) {
                mapView2.onPause();
            }
        } catch (Exception unused) {
        }
        try {
            MapView mapView3 = this.mapView;
            if (mapView3 != null) {
                mapView3.onDestroy();
                this.mapView = null;
            }
        } catch (Exception unused2) {
        }
        LocationActivityAdapter locationActivityAdapter = this.adapter;
        if (locationActivityAdapter != null) {
            locationActivityAdapter.destroy();
        }
        LocationActivitySearchAdapter locationActivitySearchAdapter = this.searchAdapter;
        if (locationActivitySearchAdapter != null) {
            locationActivitySearchAdapter.destroy();
        }
        this.parentAlert.actionBar.closeSearchField();
        this.parentAlert.actionBar.createMenu().removeView(this.searchItem);
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onHide() {
        this.searchItem.setVisibility(8);
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    boolean onDismiss() {
        onDestroy();
        return false;
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getCurrentItemTop() {
        if (this.listView.getChildCount() <= 0) {
            return ConnectionsManager.DEFAULT_DATACENTER_ID;
        }
        int iMax = 0;
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findViewHolderForAdapterPosition(0);
        if (holder != null) {
            int y = ((int) holder.itemView.getY()) - this.nonClipSize;
            iMax = Math.max(y, 0);
            if (y >= 0) {
                iMax = y;
            }
        }
        return iMax + AndroidUtilities.dp(56.0f);
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        this.parentAlert.getSheetContainer().invalidate();
        updateClipView();
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getListTopPadding() {
        return this.listView.getPaddingTop();
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getFirstOffset() {
        return getListTopPadding() + AndroidUtilities.dp(56.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void onPreMeasure(int r4, int r5) {
        /*
            r3 = this;
            org.rbmain.ui.Components.ChatAttachAlert r4 = r3.parentAlert
            org.rbmain.ui.ActionBar.ActionBar r4 = r4.actionBar
            boolean r4 = r4.isSearchFieldVisible()
            r0 = 1
            r1 = 0
            if (r4 != 0) goto L45
            org.rbmain.ui.Components.ChatAttachAlert r4 = r3.parentAlert
            org.rbmain.ui.Components.SizeNotifierFrameLayout r4 = r4.sizeNotifierFrameLayout
            int r4 = r4.measureKeyboardHeight()
            r2 = 1101004800(0x41a00000, float:20.0)
            int r2 = org.rbmain.messenger.AndroidUtilities.dp(r2)
            if (r4 <= r2) goto L1d
            goto L45
        L1d:
            boolean r4 = org.rbmain.messenger.AndroidUtilities.isTablet()
            if (r4 != 0) goto L31
            android.graphics.Point r4 = org.rbmain.messenger.AndroidUtilities.displaySize
            int r2 = r4.x
            int r4 = r4.y
            if (r2 <= r4) goto L31
            float r4 = (float) r5
            r5 = 1080033280(0x40600000, float:3.5)
            float r4 = r4 / r5
            int r4 = (int) r4
            goto L35
        L31:
            int r5 = r5 / 5
            int r4 = r5 * 2
        L35:
            r5 = 1112539136(0x42500000, float:52.0)
            int r5 = org.rbmain.messenger.AndroidUtilities.dp(r5)
            int r4 = r4 - r5
            if (r4 >= 0) goto L3f
            r4 = 0
        L3f:
            org.rbmain.ui.Components.ChatAttachAlert r5 = r3.parentAlert
            r5.setAllowNestedScroll(r0)
            goto L4f
        L45:
            int r4 = r3.mapHeight
            int r5 = r3.overScrollHeight
            int r4 = r4 - r5
            org.rbmain.ui.Components.ChatAttachAlert r5 = r3.parentAlert
            r5.setAllowNestedScroll(r1)
        L4f:
            org.rbmain.ui.Components.RecyclerListView r5 = r3.listView
            int r5 = r5.getPaddingTop()
            if (r5 == r4) goto L60
            r3.ignoreLayout = r0
            org.rbmain.ui.Components.RecyclerListView r5 = r3.listView
            r5.setPadding(r1, r4, r1, r1)
            r3.ignoreLayout = r1
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ChatAttachAlertLocationLayout.onPreMeasure(int, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            fixLayoutInternal(this.first);
            this.first = false;
        }
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getButtonsHideOffset() {
        return AndroidUtilities.dp(56.0f);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    void scrollToTop() {
        this.listView.smoothScrollToPosition(0);
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
                    this.searchAreaButton.setVisibility(z ? 0 : 4);
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

    public void openShareLiveLocation() {
        Activity parentActivity;
        if (this.delegate == null || getParentActivity() == null || this.myLocation == null) {
            return;
        }
        if (this.checkBackgroundPermission && Build.VERSION.SDK_INT >= 29 && (parentActivity = getParentActivity()) != null) {
            this.checkBackgroundPermission = false;
            SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
            if (Math.abs((System.currentTimeMillis() / 1000) - globalMainSettings.getInt("backgroundloc", 0)) > 86400 && parentActivity.checkSelfPermission("android.permission.ACCESS_BACKGROUND_LOCATION") != 0) {
                globalMainSettings.edit().putInt("backgroundloc", (int) (System.currentTimeMillis() / 1000)).apply();
                AlertsCreator.createBackgroundLocationPermissionDialog(parentActivity, getMessagesController().getUser(Integer.valueOf(getUserConfig().getClientUserId())), new Runnable() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.openShareLiveLocation();
                    }
                }).show();
                return;
            }
        }
        AlertsCreator.createLocationUpdateDialog(getParentActivity(), ((int) this.dialogId) > 0 ? this.parentAlert.baseFragment.getMessagesController().getUser(Integer.valueOf((int) this.dialogId)) : null, new MessagesStorage.IntCallback() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda19
            @Override // org.rbmain.messenger.MessagesStorage.IntCallback
            public final void run(int i) {
                this.f$0.lambda$openShareLiveLocation$16(i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openShareLiveLocation$16(int i) {
        TLRPC$TL_messageMediaGeoLive tLRPC$TL_messageMediaGeoLive = new TLRPC$TL_messageMediaGeoLive();
        TLRPC$TL_geoPoint tLRPC$TL_geoPoint = new TLRPC$TL_geoPoint();
        tLRPC$TL_messageMediaGeoLive.geo = tLRPC$TL_geoPoint;
        tLRPC$TL_geoPoint.lat = AndroidUtilities.fixLocationCoord(this.myLocation.getLatitude());
        tLRPC$TL_messageMediaGeoLive.geo._long = AndroidUtilities.fixLocationCoord(this.myLocation.getLongitude());
        tLRPC$TL_messageMediaGeoLive.period = i;
        this.delegate.didSelectLocation(tLRPC$TL_messageMediaGeoLive, this.locationType, true, 0);
        this.parentAlert.dismiss();
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

    private MessagesController getMessagesController() {
        return this.parentAlert.baseFragment.getMessagesController();
    }

    private LocationController getLocationController() {
        return this.parentAlert.baseFragment.getLocationController();
    }

    private UserConfig getUserConfig() {
        return this.parentAlert.baseFragment.getUserConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getParentActivity() {
        BaseFragment baseFragment;
        ChatAttachAlert chatAttachAlert = this.parentAlert;
        if (chatAttachAlert == null || (baseFragment = chatAttachAlert.baseFragment) == null) {
            return null;
        }
        return baseFragment.getParentActivity();
    }

    private void onMapInit() {
        if (this.googleMap == null) {
            return;
        }
        Location location = new Location("network");
        this.userLocation = location;
        LatLng latLng = AppFavorUtils.defaultLocation;
        location.setLatitude(latLng.latitude);
        this.userLocation.setLongitude(latLng.longitude);
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5));
        try {
            this.googleMap.setMyLocationEnabled(true);
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.googleMap.getUiSettings().setMyLocationButtonEnabled(false);
        this.googleMap.getUiSettings().setZoomControlsEnabled(false);
        this.googleMap.getUiSettings().setCompassEnabled(false);
        this.googleMap.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda7
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener
            public final void onCameraMoveStarted(int i) {
                this.f$0.lambda$onMapInit$17(i);
            }
        });
        this.googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda10
            @Override // com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener
            public final void onMyLocationChange(Location location2) {
                this.f$0.lambda$onMapInit$18(location2);
            }
        });
        this.googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda9
            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
            public final boolean onMarkerClick(Marker marker) {
                return this.f$0.lambda$onMapInit$19(marker);
            }
        });
        this.googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda6
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveListener
            public final void onCameraMove() {
                this.f$0.lambda$onMapInit$20();
            }
        });
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onMapInit$21();
            }
        }, 200L);
        Location lastLocation = getLastLocation();
        this.myLocation = lastLocation;
        positionMarker(lastLocation);
        if (this.checkGpsEnabled && getParentActivity() != null) {
            this.checkGpsEnabled = false;
            if (!getParentActivity().getPackageManager().hasSystemFeature("android.hardware.location.gps")) {
                return;
            }
            try {
                if (!((LocationManager) ApplicationLoader.applicationContext.getSystemService("location")).isProviderEnabled("gps")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                    builder.setTitle(LocaleController.getString("GpsDisabledAlertTitle", R.string.GpsDisabledAlertTitle));
                    builder.setMessage(LocaleController.getString("GpsDisabledAlertText", R.string.GpsDisabledAlertText));
                    builder.setPositiveButton(LocaleController.getString("ConnectingToProxyEnable", R.string.ConnectingToProxyEnable), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onMapInit$22(dialogInterface, i);
                        }
                    });
                    builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                    builder.show();
                }
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        }
        updateClipView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMapInit$17(int i) {
        View childAt;
        RecyclerView.ViewHolder viewHolderFindContainingViewHolder;
        if (i == 1) {
            showSearchPlacesButton(true);
            removeInfoView();
            if (this.scrolling || this.listView.getChildCount() <= 0 || (childAt = this.listView.getChildAt(0)) == null || (viewHolderFindContainingViewHolder = this.listView.findContainingViewHolder(childAt)) == null || viewHolderFindContainingViewHolder.getAdapterPosition() != 0) {
                return;
            }
            int iDp = this.locationType == 0 ? 0 : AndroidUtilities.dp(66.0f);
            int top = childAt.getTop();
            if (top < (-iDp)) {
                CameraPosition cameraPosition = this.googleMap.getCameraPosition();
                this.forceUpdate = CameraUpdateFactory.newLatLngZoom(cameraPosition.target, cameraPosition.zoom);
                this.listView.smoothScrollBy(0, top + iDp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMapInit$18(Location location) {
        ChatAttachAlert chatAttachAlert = this.parentAlert;
        if (chatAttachAlert == null || chatAttachAlert.baseFragment == null) {
            return;
        }
        positionMarker(location);
        getLocationController().setGoogleMapLocation(location, this.isFirstLocation);
        AccountInstance.getInstance(UserConfig.selectedAccount).getDialogsProxy().updateUserLocation(new LocationObject(location.getLatitude(), location.getLongitude()));
        this.isFirstLocation = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onMapInit$19(Marker marker) {
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
    public /* synthetic */ void lambda$onMapInit$20() {
        MapOverlayView mapOverlayView = this.overlayView;
        if (mapOverlayView != null) {
            mapOverlayView.updatePositions();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMapInit$21() {
        if (this.loadingMapView.getTag() == null) {
            this.loadingMapView.animate().alpha(0.0f).setDuration(180L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMapInit$22(DialogInterface dialogInterface, int i) {
        if (getParentActivity() == null) {
            return;
        }
        try {
            getParentActivity().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } catch (Exception unused) {
        }
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

    private void showPermissionAlert(boolean z) {
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
        builder.setNegativeButton(LocaleController.getString("PermissionOpenSettings", R.string.PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showPermissionAlert$23(dialogInterface, i);
            }
        });
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPermissionAlert$23(DialogInterface dialogInterface, int i) {
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
    public void updateClipView() {
        int y;
        int iMin;
        LatLng latLng;
        if (this.mapView == null || this.mapViewClip == null) {
            return;
        }
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
                this.mapView.setTranslationY(y);
                return;
            }
            if (this.mapView.getVisibility() == 4) {
                this.mapView.setVisibility(0);
                this.mapViewClip.setVisibility(0);
                MapOverlayView mapOverlayView2 = this.overlayView;
                if (mapOverlayView2 != null) {
                    mapOverlayView2.setVisibility(0);
                }
            }
            int iMax = Math.max(0, (-((y - this.mapHeight) + this.overScrollHeight)) / 2);
            float f = iMax;
            this.mapView.setTranslationY(f);
            float fMax = 1.0f - Math.max(0.0f, Math.min(1.0f, (this.listView.getPaddingTop() - y) / (this.listView.getPaddingTop() - (this.mapHeight - this.overScrollHeight))));
            int i = this.clipSize;
            int i2 = this.mapHeight;
            int i3 = this.overScrollHeight;
            int i4 = (int) ((i2 - i3) * fMax);
            this.clipSize = i4;
            this.nonClipSize = (i2 - i3) - i4;
            this.mapViewClip.invalidate();
            this.mapViewClip.setTranslationY(y - this.nonClipSize);
            GoogleMap googleMap = this.googleMap;
            if (googleMap != null) {
                googleMap.setPadding(0, AndroidUtilities.dp(6.0f), 0, this.clipSize + AndroidUtilities.dp(6.0f));
            }
            MapOverlayView mapOverlayView3 = this.overlayView;
            if (mapOverlayView3 != null) {
                mapOverlayView3.setTranslationY(f);
            }
            float fMin = Math.min(Math.max(this.nonClipSize - y, 0), (this.mapHeight - this.mapTypeButton.getMeasuredHeight()) - AndroidUtilities.dp(80.0f));
            this.mapTypeButton.setTranslationY(fMin);
            this.searchAreaButton.setTranslation(fMin);
            this.locationButton.setTranslationY(-this.clipSize);
            ImageView imageView = this.markerImageView;
            int iDp = (((this.mapHeight - this.clipSize) / 2) - AndroidUtilities.dp(48.0f)) + iMax;
            this.markerTop = iDp;
            imageView.setTranslationY(iDp);
            if (i != this.clipSize) {
                Marker marker = this.lastPressedMarker;
                if (marker != null) {
                    latLng = marker.getPosition();
                } else if (this.userLocationMoved) {
                    latLng = new LatLng(this.userLocation.getLatitude(), this.userLocation.getLongitude());
                } else {
                    latLng = this.myLocation != null ? new LatLng(this.myLocation.getLatitude(), this.myLocation.getLongitude()) : null;
                }
                if (latLng != null) {
                    this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                }
            }
        }
    }

    private void fixLayoutInternal(boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (getMeasuredHeight() == 0 || this.mapView == null) {
            return;
        }
        int currentActionBarHeight = ActionBar.getCurrentActionBarHeight();
        int iDp = AndroidUtilities.dp(189.0f);
        this.overScrollHeight = iDp;
        this.mapHeight = Math.max(iDp, Math.min(AndroidUtilities.dp(310.0f), (AndroidUtilities.displaySize.y - AndroidUtilities.dp(66.0f)) - currentActionBarHeight));
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.listView.getLayoutParams();
        layoutParams2.topMargin = currentActionBarHeight;
        this.listView.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mapViewClip.getLayoutParams();
        layoutParams3.topMargin = currentActionBarHeight;
        layoutParams3.height = this.mapHeight;
        this.mapViewClip.setLayoutParams(layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.searchListView.getLayoutParams();
        layoutParams4.topMargin = currentActionBarHeight;
        this.searchListView.setLayoutParams(layoutParams4);
        this.adapter.setOverScrollHeight(this.overScrollHeight);
        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.mapView.getLayoutParams();
        if (layoutParams5 != null) {
            layoutParams5.height = this.mapHeight + AndroidUtilities.dp(10.0f);
            this.mapView.setLayoutParams(layoutParams5);
        }
        MapOverlayView mapOverlayView = this.overlayView;
        if (mapOverlayView != null && (layoutParams = (FrameLayout.LayoutParams) mapOverlayView.getLayoutParams()) != null) {
            layoutParams.height = this.mapHeight + AndroidUtilities.dp(10.0f);
            this.overlayView.setLayoutParams(layoutParams);
        }
        this.adapter.notifyDataSetChanged();
        updateClipView();
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
        Location location2 = new Location(location);
        this.myLocation = location2;
        if (this.googleMap != null) {
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            LocationActivityAdapter locationActivityAdapter = this.adapter;
            if (locationActivityAdapter != null) {
                if (!this.searchedForCustomLocations) {
                    locationActivityAdapter.searchPlacesWithQuery(null, this.myLocation, true);
                }
                this.adapter.setGpsLocation(this.myLocation);
            }
            if (this.userLocationMoved) {
                return;
            }
            this.userLocation = new Location(location);
            if (this.firstWas) {
                this.googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                return;
            } else {
                this.firstWas = true;
                this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, this.googleMap.getMaxZoomLevel() - 4.0f));
                return;
            }
        }
        this.adapter.setGpsLocation(location2);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        GoogleMap googleMap;
        if (i != NotificationCenter.locationPermissionGranted || (googleMap = this.googleMap) == null) {
            return;
        }
        try {
            googleMap.setMyLocationEnabled(true);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    public void onResume() {
        MapView mapView = this.mapView;
        if (mapView != null && this.mapsInitialized) {
            try {
                mapView.onResume();
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        this.onResumeCalled = true;
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onShow() {
        this.parentAlert.actionBar.setTitle(LocaleController.getString("ShareLocation", R.string.ShareLocation));
        if (this.mapView.getParent() == null) {
            this.mapViewClip.addView(this.mapView, 0, LayoutHelper.createFrame(-1, this.overScrollHeight + AndroidUtilities.dp(10.0f), 51));
            this.mapViewClip.addView(this.overlayView, 1, LayoutHelper.createFrame(-1, this.overScrollHeight + AndroidUtilities.dp(10.0f), 51));
            this.mapViewClip.addView(this.loadingMapView, 2, LayoutHelper.createFrame(-1, -1.0f));
        }
        this.searchItem.setVisibility(8);
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
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onShow$24();
            }
        }, this.parentAlert.delegate.needEnterComment() ? 200L : 0L);
        this.layoutManager.scrollToPositionWithOffset(0, 0);
        updateClipView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onShow$24() {
        Activity parentActivity;
        if (!this.checkPermission || Build.VERSION.SDK_INT < 23 || (parentActivity = getParentActivity()) == null) {
            return;
        }
        this.checkPermission = false;
        if (parentActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            parentActivity.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 2);
        }
    }

    public void setDelegate(LocationActivityDelegate locationActivityDelegate) {
        this.delegate = locationActivityDelegate;
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlertLocationLayout$$ExternalSyntheticLambda21
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() throws Resources.NotFoundException {
                this.f$0.lambda$getThemeDescriptions$25();
            }
        };
        arrayList.add(new ThemeDescription(this.mapViewClip, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_dialogBackground));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, Theme.key_dialogScrollGlow));
        ActionBarMenuItem actionBarMenuItem = this.searchItem;
        arrayList.add(new ThemeDescription(actionBarMenuItem != null ? actionBarMenuItem.getSearchField() : null, ThemeDescription.FLAG_CURSORCOLOR, null, null, null, null, Theme.key_dialogTextBlack));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        ImageView imageView = this.emptyImageView;
        int i = ThemeDescription.FLAG_IMAGECOLOR;
        int i2 = Theme.key_dialogEmptyImage;
        arrayList.add(new ThemeDescription(imageView, i, null, null, null, null, i2));
        TextView textView = this.emptyTitleTextView;
        int i3 = ThemeDescription.FLAG_TEXTCOLOR;
        int i4 = Theme.key_dialogEmptyText;
        arrayList.add(new ThemeDescription(textView, i3, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.emptySubtitleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i4));
        ImageView imageView2 = this.locationButton;
        int i5 = ThemeDescription.FLAG_IMAGECOLOR | ThemeDescription.FLAG_CHECKTAG;
        int i6 = Theme.key_location_actionIcon;
        arrayList.add(new ThemeDescription(imageView2, i5, null, null, null, null, i6));
        ImageView imageView3 = this.locationButton;
        int i7 = ThemeDescription.FLAG_IMAGECOLOR | ThemeDescription.FLAG_CHECKTAG;
        int i8 = Theme.key_location_actionActiveIcon;
        arrayList.add(new ThemeDescription(imageView3, i7, null, null, null, null, i8));
        ImageView imageView4 = this.locationButton;
        int i9 = ThemeDescription.FLAG_BACKGROUNDFILTER;
        int i10 = Theme.key_location_actionBackground;
        arrayList.add(new ThemeDescription(imageView4, i9, null, null, null, null, i10));
        ImageView imageView5 = this.locationButton;
        int i11 = ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE;
        int i12 = Theme.key_location_actionPressedBackground;
        arrayList.add(new ThemeDescription(imageView5, i11, null, null, null, null, i12));
        arrayList.add(new ThemeDescription(this.mapTypeButton, 0, null, null, null, themeDescriptionDelegate, i6));
        arrayList.add(new ThemeDescription(this.mapTypeButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, i10));
        arrayList.add(new ThemeDescription(this.mapTypeButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, i12));
        arrayList.add(new ThemeDescription(this.searchAreaButton, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i8));
        arrayList.add(new ThemeDescription(this.searchAreaButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, i10));
        arrayList.add(new ThemeDescription(this.searchAreaButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, i12));
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
        int i13 = Theme.key_windowBackgroundWhiteGrayText3;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SendLocationCell.class}, new String[]{"accurateTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i13));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{SendLocationCell.class}, new String[]{"titleTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_location_sendLiveLocationText));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{SendLocationCell.class}, new String[]{"titleTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_location_sendLocationText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationDirectionCell.class}, new String[]{"buttonTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_featuredStickers_buttonText));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE, new Class[]{LocationDirectionCell.class}, new String[]{"frameLayout"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_featuredStickers_addButton));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{LocationDirectionCell.class}, new String[]{"frameLayout"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_featuredStickers_addButtonPressed));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{ShadowSectionCell.class}, null, null, null, Theme.key_windowBackgroundGray));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_dialogTextBlue2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{LocationCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i13));
        int i14 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i14));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationCell.class}, new String[]{"addressTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i13));
        arrayList.add(new ThemeDescription(this.searchListView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{LocationCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i13));
        arrayList.add(new ThemeDescription(this.searchListView, 0, new Class[]{LocationCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i14));
        arrayList.add(new ThemeDescription(this.searchListView, 0, new Class[]{LocationCell.class}, new String[]{"addressTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i13));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SharingLiveLocationCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i14));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SharingLiveLocationCell.class}, new String[]{"distanceTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i13));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationLoadingCell.class}, new String[]{"progressBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_progressCircle));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationLoadingCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i13));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationLoadingCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i13));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationPoweredCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i13));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{LocationPoweredCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i2));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationPoweredCell.class}, new String[]{"textView2"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$25() throws Resources.NotFoundException {
        this.mapTypeButton.setIconColor(Theme.getColor(Theme.key_location_actionIcon));
        this.mapTypeButton.redrawPopup(Theme.getColor(Theme.key_actionBarDefaultSubmenuBackground));
        this.mapTypeButton.setPopupItemsColor(Theme.getColor(Theme.key_actionBarDefaultSubmenuItemIcon), true);
        this.mapTypeButton.setPopupItemsColor(Theme.getColor(Theme.key_actionBarDefaultSubmenuItem), false);
        if (this.googleMap != null) {
            if (isActiveThemeDark()) {
                if (this.currentMapStyleDark) {
                    return;
                }
                this.currentMapStyleDark = true;
                this.googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(ApplicationLoader.applicationContext, R.raw.mapstyle_night));
                return;
            }
            if (this.currentMapStyleDark) {
                this.currentMapStyleDark = false;
                this.googleMap.setMapStyle(null);
            }
        }
    }
}

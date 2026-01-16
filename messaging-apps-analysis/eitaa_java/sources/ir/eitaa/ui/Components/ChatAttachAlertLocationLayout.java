package ir.eitaa.ui.Components;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.eitaa.helper.MapHelper;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$TL_GetLocationAuthHash;
import ir.eitaa.tgnet.TLRPC$TL_UserPayHash;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_geoPoint;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaGeo;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.SendLocationCell;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.ChatAttachAlert;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes3.dex */
public class ChatAttachAlertLocationLayout extends ChatAttachAlert.AttachAlertLayout implements NotificationCenter.NotificationCenterDelegate {
    private long DEFAULT_INTERVAL_IN_MILLISECONDS;
    private long DEFAULT_MAX_WAIT_TIME;
    private AnimatorSet animatorSet;
    private Paint backgroundPaint;
    private boolean checkGpsEnabled;
    private boolean checkPermission;
    private int clipSize;
    private LocationActivityDelegate delegate;
    private long dialogId;
    private boolean first;
    private boolean ignoreLayout;
    private View loadingMapView;
    private ImageView locationButton;
    private int locationType;
    private int mapHeight;
    private MapHelper mapHelper;
    private WebView mapView;
    private FrameLayout mapViewClip;
    private boolean mapsInitialized;
    private ImageView markerImageView;
    private int markerTop;
    private Location myLocation;
    private boolean onResumeCalled;
    private int overScrollHeight;
    private MapOverlayView overlayView;
    private SendLocationCell sendLocationButton;
    private Location userLocation;
    private boolean userLocationMoved;
    private float yOffset;

    public interface LocationActivityDelegate {
        void didSelectLocation(TLRPC$MessageMedia location, int live, boolean notify, int scheduleDate);
    }

    static /* synthetic */ void lambda$getThemeDescriptions$10() {
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getListTopPadding() {
        return 0;
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int needsActionBar() {
        return 1;
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void scrollToTop() {
    }

    public class MapOverlayView extends FrameLayout {
        public MapOverlayView(Context context) {
            super(context);
        }
    }

    public ChatAttachAlertLocationLayout(ChatAttachAlert alert, Context context, final Theme.ResourcesProvider resourcesProvider) {
        super(alert, context, resourcesProvider);
        this.checkGpsEnabled = true;
        this.backgroundPaint = new Paint();
        this.checkPermission = true;
        int currentActionBarHeight = (AndroidUtilities.displaySize.x - ActionBar.getCurrentActionBarHeight()) - AndroidUtilities.dp(66.0f);
        this.overScrollHeight = currentActionBarHeight;
        this.mapHeight = currentActionBarHeight;
        this.DEFAULT_INTERVAL_IN_MILLISECONDS = 1000L;
        this.DEFAULT_MAX_WAIT_TIME = 1000 * 5;
        this.first = true;
        AndroidUtilities.fixGoogleMapsBug();
        ChatActivity chatActivity = (ChatActivity) this.parentAlert.baseFragment;
        this.dialogId = chatActivity.getDialogId();
        if (chatActivity.getCurrentEncryptedChat() == null && !chatActivity.isInScheduleMode() && !UserObject.isUserSelf(chatActivity.getCurrentUser())) {
            this.locationType = 1;
        } else {
            this.locationType = 0;
        }
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.locationPermissionGranted);
        this.parentAlert.actionBar.createMenu();
        this.overlayView = new MapOverlayView(context);
        new FrameLayout.LayoutParams(-1, AndroidUtilities.dp(21.0f)).gravity = 83;
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.ChatAttachAlertLocationLayout.1
            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                canvas.save();
                canvas.clipRect(0, 0, getMeasuredWidth(), getMeasuredHeight() - ChatAttachAlertLocationLayout.this.clipSize);
                boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                canvas.restore();
                return zDrawChild;
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                ChatAttachAlertLocationLayout.this.backgroundPaint.setColor(ChatAttachAlertLocationLayout.this.getThemedColor("dialogBackground"));
                canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight() - ChatAttachAlertLocationLayout.this.clipSize, ChatAttachAlertLocationLayout.this.backgroundPaint);
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                if (ev.getY() > getMeasuredHeight() - ChatAttachAlertLocationLayout.this.clipSize) {
                    return false;
                }
                return super.onInterceptTouchEvent(ev);
            }

            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent ev) {
                if (ev.getY() > getMeasuredHeight() - ChatAttachAlertLocationLayout.this.clipSize) {
                    return false;
                }
                return super.dispatchTouchEvent(ev);
            }
        };
        this.mapViewClip = frameLayout;
        frameLayout.setWillNotDraw(false);
        View view = new View(context);
        this.loadingMapView = view;
        view.setBackgroundDrawable(new MapPlaceholderDrawable());
        Drawable drawableCreateSimpleSelectorRoundRectDrawable = Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(40.0f), getThemedColor("location_actionBackground"), getThemedColor("location_actionPressedBackground"));
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            Drawable drawableMutate = context.getResources().getDrawable(R.drawable.places_btn).mutate();
            drawableMutate.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            new CombinedDrawable(drawableMutate, drawableCreateSimpleSelectorRoundRectDrawable, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f)).setFullsize(true);
        } else {
            new StateListAnimator();
        }
        this.locationButton = new ImageView(context);
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(40.0f), getThemedColor("location_actionBackground"), getThemedColor("location_actionPressedBackground"));
        if (i < 21) {
            Drawable drawableMutate2 = context.getResources().getDrawable(R.drawable.floating_shadow_profile).mutate();
            drawableMutate2.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate2, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
            combinedDrawable.setIconSize(AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
            drawableCreateSimpleSelectorCircleDrawable = combinedDrawable;
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            int[] iArr = {android.R.attr.state_pressed};
            ImageView imageView = this.locationButton;
            Property property = View.TRANSLATION_Z;
            stateListAnimator.addState(iArr, ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f)).setDuration(200L));
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this.locationButton, (Property<ImageView, Float>) property, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
            this.locationButton.setStateListAnimator(stateListAnimator);
            this.locationButton.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.Components.ChatAttachAlertLocationLayout.2
                @Override // android.view.ViewOutlineProvider
                @SuppressLint({"NewApi"})
                public void getOutline(View view2, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
                }
            });
        }
        this.locationButton.setBackground(drawableCreateSimpleSelectorCircleDrawable);
        this.locationButton.setImageResource(R.drawable.location_current);
        this.locationButton.setScaleType(ImageView.ScaleType.CENTER);
        this.locationButton.setColorFilter(new PorterDuffColorFilter(getThemedColor("location_actionActiveIcon"), PorterDuff.Mode.MULTIPLY));
        this.locationButton.setTag("location_actionActiveIcon");
        this.locationButton.setContentDescription(LocaleController.getString("AccDescrMyLocation", R.string.AccDescrMyLocation));
        this.mapViewClip.addView(this.locationButton, LayoutHelper.createFrame(i >= 21 ? 40 : 44, i >= 21 ? 40.0f : 44.0f, 85, 0.0f, 0.0f, 12.0f, 90.0f));
        this.locationButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertLocationLayout$-VUrnCJqT_B8LOCl-J_Q6O-1WiA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$1$ChatAttachAlertLocationLayout(resourcesProvider, view2);
            }
        });
        SendLocationCell sendLocationCell = new SendLocationCell(context, false, resourcesProvider);
        this.sendLocationButton = sendLocationCell;
        this.mapViewClip.addView(sendLocationCell, LayoutHelper.createFrame(-1, -2.0f, 81, 12.0f, 12.0f, 12.0f, 12.0f));
        this.sendLocationButton.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(SharedConfig.bubbleRadius), getThemedColor("location_actionBackground"), getThemedColor("location_actionPressedBackground")));
        if (i >= 21) {
            this.sendLocationButton.setElevation(8.0f);
        }
        updateSendLocationButton();
        this.sendLocationButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertLocationLayout$diKtByedtuLDCRpvSdKzOsoGImI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$3$ChatAttachAlertLocationLayout(view2);
            }
        });
        addView(this.mapViewClip, LayoutHelper.createFrame(-1, -1, 51));
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(context);
        this.mapView = anonymousClass3;
        anonymousClass3.getSettings().setJavaScriptEnabled(true);
        this.mapView.setWebViewClient(new WebViewClient() { // from class: ir.eitaa.ui.Components.ChatAttachAlertLocationLayout.4
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view2, String url) {
                super.onPageFinished(view2, url);
                ChatAttachAlertLocationLayout.this.loadingMapView.setTag(1);
                ChatAttachAlertLocationLayout.this.loadingMapView.animate().alpha(0.0f).setDuration(180L).start();
                if (ChatAttachAlertLocationLayout.this.mapsInitialized) {
                    return;
                }
                ChatAttachAlertLocationLayout.this.onMapInit();
            }
        });
        ConnectionsManager.getInstance(UserConfig.selectedAccount).sendRequest(new TLRPC$TL_GetLocationAuthHash(), new RequestDelegate() { // from class: ir.eitaa.ui.Components.ChatAttachAlertLocationLayout.5
            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(final TLObject response, final TLRPC$TL_error error) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.ChatAttachAlertLocationLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (error == null) {
                            try {
                                ChatAttachAlertLocationLayout.this.mapView.postUrl(MessagesController.getInstance(UserConfig.selectedAccount).mapHostUrl, ("hash=" + URLEncoder.encode(((TLRPC$TL_UserPayHash) response).hash, "UTF-8")).getBytes());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
        ImageView imageView2 = new ImageView(context);
        this.markerImageView = imageView2;
        imageView2.setImageResource(R.drawable.map_pin2);
        this.mapViewClip.addView(this.markerImageView, LayoutHelper.createFrame(28, 48.0f, 17, 0.0f, 0.0f, 0.0f, 24.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$ChatAttachAlertLocationLayout(Theme.ResourcesProvider resourcesProvider, View view) {
        Activity parentActivity;
        if (Build.VERSION.SDK_INT >= 23 && (parentActivity = getParentActivity()) != null && parentActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            showPermissionAlert(false);
            return;
        }
        if (getParentActivity() != null) {
            if (!getParentActivity().getPackageManager().hasSystemFeature("android.hardware.location.gps")) {
                return;
            }
            try {
                if (!((LocationManager) ApplicationLoader.applicationContext.getSystemService("location")).isProviderEnabled("gps")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity(), resourcesProvider);
                    builder.setTitle(LocaleController.getString("GpsDisabledAlertTitle", R.string.GpsDisabledAlertTitle));
                    builder.setMessage(LocaleController.getString("GpsDisabledAlertText", R.string.GpsDisabledAlertText));
                    builder.setPositiveButton(LocaleController.getString("ConnectingToProxyEnable", R.string.ConnectingToProxyEnable), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertLocationLayout$PJ1foqJxAXb1d4_65_mDwx6_yHY
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$new$0$ChatAttachAlertLocationLayout(dialogInterface, i);
                        }
                    });
                    builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                    builder.show();
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        MapHelper mapHelper = this.mapHelper;
        if (mapHelper == null) {
            return;
        }
        if (!mapHelper.isLocationTrackingStarted) {
            mapHelper.startLocationTracking();
        }
        Location location = this.mapHelper.currentLocation;
        this.myLocation = location;
        if (location != null) {
            this.locationButton.setColorFilter(new PorterDuffColorFilter(getThemedColor("location_actionActiveIcon"), PorterDuff.Mode.MULTIPLY));
            this.locationButton.setTag("location_actionActiveIcon");
            this.userLocationMoved = false;
            this.mapHelper.moveToUserLocation();
            updateSendLocationButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ChatAttachAlertLocationLayout(DialogInterface dialogInterface, int i) {
        if (getParentActivity() == null) {
            return;
        }
        try {
            getParentActivity().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$ChatAttachAlertLocationLayout(View view) {
        if (this.delegate != null) {
            final TLRPC$TL_messageMediaGeo tLRPC$TL_messageMediaGeo = new TLRPC$TL_messageMediaGeo();
            tLRPC$TL_messageMediaGeo.geo = new TLRPC$TL_geoPoint();
            this.mapHelper.getCenterLocation(new MapHelper.MapListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertLocationLayout$za-V_Fj-kl1ty6fqxbHvrBLNArQ
                @Override // ir.eitaa.helper.MapHelper.MapListener
                public final void onCenterLocationReceived(MapHelper.LngLat lngLat) {
                    this.f$0.lambda$new$2$ChatAttachAlertLocationLayout(tLRPC$TL_messageMediaGeo, lngLat);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$ChatAttachAlertLocationLayout(TLRPC$TL_messageMediaGeo tLRPC$TL_messageMediaGeo, MapHelper.LngLat lngLat) {
        tLRPC$TL_messageMediaGeo.geo.lat = lngLat.lat.doubleValue();
        tLRPC$TL_messageMediaGeo.geo._long = lngLat.lng.doubleValue();
        this.delegate.didSelectLocation(tLRPC$TL_messageMediaGeo, this.locationType, true, 0);
        this.parentAlert.dismiss();
    }

    /* renamed from: ir.eitaa.ui.Components.ChatAttachAlertLocationLayout$3, reason: invalid class name */
    class AnonymousClass3 extends WebView {
        AnonymousClass3(Context context) {
            super(context);
        }

        @Override // android.webkit.WebView, android.view.View
        public boolean onTouchEvent(MotionEvent ev) {
            if (ev.getAction() == 0) {
                if (ChatAttachAlertLocationLayout.this.animatorSet != null) {
                    ChatAttachAlertLocationLayout.this.animatorSet.cancel();
                }
                ChatAttachAlertLocationLayout.this.animatorSet = new AnimatorSet();
                ChatAttachAlertLocationLayout.this.animatorSet.setDuration(200L);
                ChatAttachAlertLocationLayout.this.animatorSet.playTogether(ObjectAnimator.ofFloat(ChatAttachAlertLocationLayout.this.markerImageView, (Property<ImageView, Float>) View.TRANSLATION_Y, ChatAttachAlertLocationLayout.this.markerTop - AndroidUtilities.dp(10.0f)));
                ChatAttachAlertLocationLayout.this.animatorSet.start();
            } else if (ev.getAction() == 1) {
                if (ChatAttachAlertLocationLayout.this.animatorSet != null) {
                    ChatAttachAlertLocationLayout.this.animatorSet.cancel();
                }
                ChatAttachAlertLocationLayout.this.yOffset = 0.0f;
                ChatAttachAlertLocationLayout.this.animatorSet = new AnimatorSet();
                ChatAttachAlertLocationLayout.this.animatorSet.setDuration(200L);
                ChatAttachAlertLocationLayout.this.animatorSet.playTogether(ObjectAnimator.ofFloat(ChatAttachAlertLocationLayout.this.markerImageView, (Property<ImageView, Float>) View.TRANSLATION_Y, ChatAttachAlertLocationLayout.this.markerTop));
                ChatAttachAlertLocationLayout.this.animatorSet.start();
            }
            if (ev.getAction() == 2) {
                if (!ChatAttachAlertLocationLayout.this.userLocationMoved) {
                    ChatAttachAlertLocationLayout.this.locationButton.setColorFilter(new PorterDuffColorFilter(ChatAttachAlertLocationLayout.this.getThemedColor("location_actionIcon"), PorterDuff.Mode.MULTIPLY));
                    ChatAttachAlertLocationLayout.this.locationButton.setTag("location_actionIcon");
                    ChatAttachAlertLocationLayout.this.userLocationMoved = true;
                }
                if (ChatAttachAlertLocationLayout.this.mapHelper != null && ChatAttachAlertLocationLayout.this.userLocation != null) {
                    ChatAttachAlertLocationLayout.this.mapHelper.getCenterLocation(new MapHelper.MapListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertLocationLayout$3$5_SPdNZpdGRzbzwYMa0_w5GVeSc
                        @Override // ir.eitaa.helper.MapHelper.MapListener
                        public final void onCenterLocationReceived(MapHelper.LngLat lngLat) {
                            this.f$0.lambda$onTouchEvent$0$ChatAttachAlertLocationLayout$3(lngLat);
                        }
                    });
                }
            }
            return super.onTouchEvent(ev);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onTouchEvent$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onTouchEvent$0$ChatAttachAlertLocationLayout$3(MapHelper.LngLat lngLat) {
            ChatAttachAlertLocationLayout.this.userLocation.setLatitude(lngLat.lat.doubleValue());
            ChatAttachAlertLocationLayout.this.userLocation.setLongitude(lngLat.lng.doubleValue());
            ChatAttachAlertLocationLayout.this.updateSendLocationButton();
        }
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onPause() {
        MapHelper mapHelper = this.mapHelper;
        if (mapHelper != null && this.mapsInitialized) {
            try {
                mapHelper.onPause();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        this.onResumeCalled = false;
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onDestroy() {
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.locationPermissionGranted);
        WebView webView = this.mapView;
        if (webView != null) {
            webView.setTranslationY((-AndroidUtilities.displaySize.y) * 3);
        }
        try {
            WebView webView2 = this.mapView;
            if (webView2 != null) {
                webView2.onPause();
            }
        } catch (Exception unused) {
        }
        this.parentAlert.actionBar.closeSearchField();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    boolean onDismiss() {
        onDestroy();
        return false;
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getCurrentItemTop() {
        return AndroidUtilities.dp(56.0f);
    }

    @Override // android.view.View
    public void setTranslationY(float translationY) {
        super.setTranslationY(translationY);
        this.parentAlert.getSheetContainer().invalidate();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getFirstOffset() {
        return getListTopPadding() + AndroidUtilities.dp(56.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void onPreMeasure(int r2, int r3) {
        /*
            r1 = this;
            ir.eitaa.ui.Components.ChatAttachAlert r2 = r1.parentAlert
            ir.eitaa.ui.ActionBar.ActionBar r2 = r2.actionBar
            boolean r2 = r2.isSearchFieldVisible()
            if (r2 != 0) goto L41
            ir.eitaa.ui.Components.ChatAttachAlert r2 = r1.parentAlert
            ir.eitaa.ui.Components.SizeNotifierFrameLayout r2 = r2.sizeNotifierFrameLayout
            int r2 = r2.measureKeyboardHeight()
            r0 = 1101004800(0x41a00000, float:20.0)
            int r0 = ir.eitaa.messenger.AndroidUtilities.dp(r0)
            if (r2 <= r0) goto L1b
            goto L41
        L1b:
            boolean r2 = ir.eitaa.messenger.AndroidUtilities.isTablet()
            if (r2 != 0) goto L2f
            android.graphics.Point r2 = ir.eitaa.messenger.AndroidUtilities.displaySize
            int r0 = r2.x
            int r2 = r2.y
            if (r0 <= r2) goto L2f
            float r2 = (float) r3
            r3 = 1080033280(0x40600000, float:3.5)
            float r2 = r2 / r3
            int r2 = (int) r2
            goto L33
        L2f:
            int r3 = r3 / 5
            int r2 = r3 * 2
        L33:
            r3 = 1112539136(0x42500000, float:52.0)
            int r3 = ir.eitaa.messenger.AndroidUtilities.dp(r3)
            int r2 = r2 - r3
            ir.eitaa.ui.Components.ChatAttachAlert r2 = r1.parentAlert
            r3 = 1
            r2.setAllowNestedScroll(r3)
            goto L47
        L41:
            ir.eitaa.ui.Components.ChatAttachAlert r2 = r1.parentAlert
            r3 = 0
            r2.setAllowNestedScroll(r3)
        L47:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlertLocationLayout.onPreMeasure(int, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            this.first = false;
        }
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
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

    private Activity getParentActivity() {
        BaseFragment baseFragment;
        ChatAttachAlert chatAttachAlert = this.parentAlert;
        if (chatAttachAlert == null || (baseFragment = chatAttachAlert.baseFragment) == null) {
            return null;
        }
        return baseFragment.getParentActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMapInit() {
        this.mapsInitialized = true;
        MapHelper mapHelper = new MapHelper(getParentActivity(), this.mapView);
        this.mapHelper = mapHelper;
        mapHelper.startLocationTracking();
        this.mapHelper.setDelegate(new MapHelper.LocationDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertLocationLayout$BmW-UcHeg8ds0SvwA_Ss28VHm98
            @Override // ir.eitaa.helper.MapHelper.LocationDelegate
            public final void onLocationAvailability(Location location) {
                this.f$0.lambda$onMapInit$4$ChatAttachAlertLocationLayout(location);
            }
        });
        Location location = new Location("network");
        this.userLocation = location;
        location.setLatitude(20.659322d);
        this.userLocation.setLongitude(-11.40625d);
        this.userLocationMoved = true;
        this.mapHelper.getCenterLocation(new MapHelper.MapListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertLocationLayout$fDXWWdeQZHR0d9wvJRaDIFRlY6M
            @Override // ir.eitaa.helper.MapHelper.MapListener
            public final void onCenterLocationReceived(MapHelper.LngLat lngLat) {
                this.f$0.lambda$onMapInit$5$ChatAttachAlertLocationLayout(lngLat);
            }
        });
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertLocationLayout$vAa3q6Kt3W2TxckQvJzXUfLMQN8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onMapInit$6$ChatAttachAlertLocationLayout();
            }
        }, 200L);
        if (!this.checkGpsEnabled || getParentActivity() == null) {
            return;
        }
        this.checkGpsEnabled = false;
        if (getParentActivity().getPackageManager().hasSystemFeature("android.hardware.location.gps")) {
            try {
                if (((LocationManager) ApplicationLoader.applicationContext.getSystemService("location")).isProviderEnabled("gps")) {
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity(), this.resourcesProvider);
                builder.setTitle(LocaleController.getString("GpsDisabledAlertTitle", R.string.GpsDisabledAlertTitle));
                builder.setMessage(LocaleController.getString("GpsDisabledAlertText", R.string.GpsDisabledAlertText));
                builder.setPositiveButton(LocaleController.getString("ConnectingToProxyEnable", R.string.ConnectingToProxyEnable), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertLocationLayout$DJh4YtqoGCoEikoXGYbBJCnutH4
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onMapInit$7$ChatAttachAlertLocationLayout(dialogInterface, i);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                builder.show();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onMapInit$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onMapInit$4$ChatAttachAlertLocationLayout(Location location) {
        this.myLocation = location;
        this.userLocation.setLatitude(location.getLatitude());
        this.userLocation.setLongitude(location.getLongitude());
        this.mapHelper.moveTo(new MapHelper.LngLat(Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
        updateSendLocationButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onMapInit$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onMapInit$5$ChatAttachAlertLocationLayout(MapHelper.LngLat lngLat) {
        this.userLocation.setLatitude(lngLat.lat.doubleValue());
        this.userLocation.setLongitude(lngLat.lng.doubleValue());
        updateSendLocationButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onMapInit$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onMapInit$6$ChatAttachAlertLocationLayout() {
        if (this.loadingMapView.getTag() == null) {
            this.loadingMapView.animate().alpha(0.0f).setDuration(180L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onMapInit$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onMapInit$7$ChatAttachAlertLocationLayout(DialogInterface dialogInterface, int i) {
        if (getParentActivity() == null) {
            return;
        }
        try {
            getParentActivity().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } catch (Exception unused) {
        }
    }

    private void showPermissionAlert(boolean byButton) {
        if (getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity(), this.resourcesProvider);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        if (byButton) {
            builder.setMessage(LocaleController.getString("PermissionNoLocationPosition", R.string.PermissionNoLocationPosition));
        } else {
            builder.setMessage(LocaleController.getString("PermissionNoLocation", R.string.PermissionNoLocation));
        }
        builder.setNegativeButton(LocaleController.getString("PermissionOpenSettings", R.string.PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertLocationLayout$2Tt71PRzhTFmKIe2__5ai2LnfMM
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showPermissionAlert$8$ChatAttachAlertLocationLayout(dialogInterface, i);
            }
        });
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showPermissionAlert$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showPermissionAlert$8$ChatAttachAlertLocationLayout(DialogInterface dialogInterface, int i) {
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

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        MapHelper mapHelper;
        if (id != NotificationCenter.locationPermissionGranted || (mapHelper = this.mapHelper) == null) {
            return;
        }
        try {
            mapHelper.startLocationTracking();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    public void onResume() {
        MapHelper mapHelper = this.mapHelper;
        if (mapHelper != null && this.mapsInitialized) {
            try {
                mapHelper.onResume();
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        this.onResumeCalled = true;
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onShow() {
        this.parentAlert.actionBar.setTitle(LocaleController.getString("ShareLocation", R.string.ShareLocation));
        if (this.mapView.getParent() == null) {
            this.mapViewClip.addView(this.mapView, 0, LayoutHelper.createFrame(-1, -1, 51));
            this.mapViewClip.addView(this.overlayView, 1, LayoutHelper.createFrame(-1, -1, 51));
            this.mapViewClip.addView(this.loadingMapView, 2, LayoutHelper.createFrame(-1, -1.0f));
        }
        WebView webView = this.mapView;
        if (webView != null && this.mapsInitialized) {
            try {
                webView.onResume();
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        this.onResumeCalled = true;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertLocationLayout$HwV8TyRa_r27pjtEcuXVUOs7Cb0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onShow$9$ChatAttachAlertLocationLayout();
            }
        }, this.parentAlert.delegate.needEnterComment() ? 200L : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onShow$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onShow$9$ChatAttachAlertLocationLayout() {
        Activity parentActivity;
        if (!this.checkPermission || Build.VERSION.SDK_INT < 23 || (parentActivity = getParentActivity()) == null) {
            return;
        }
        this.checkPermission = false;
        if (parentActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 && parentActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            return;
        }
        parentActivity.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSendLocationButton() {
        SendLocationCell sendLocationCell = this.sendLocationButton;
        if (sendLocationCell != null) {
            if (this.userLocationMoved) {
                this.sendLocationButton.setText(LocaleController.getString("SendSelectedLocation", R.string.SendSelectedLocation), String.format(Locale.US, "(%f,%f)", Double.valueOf(this.userLocation.getLatitude()), Double.valueOf(this.userLocation.getLongitude())));
            } else if (this.myLocation != null) {
                sendLocationCell.setText(LocaleController.getString("SendLocation", R.string.SendLocation), LocaleController.formatString("AccurateTo", R.string.AccurateTo, LocaleController.formatPluralString("Meters", (int) this.myLocation.getAccuracy())));
            } else {
                sendLocationCell.setText(LocaleController.getString("SendLocation", R.string.SendLocation), LocaleController.getString("Loading", R.string.Loading));
            }
        }
    }

    public void setDelegate(LocationActivityDelegate delegate) {
        this.delegate = delegate;
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        $$Lambda$ChatAttachAlertLocationLayout$GpcozHF6zt0GVBitxbwPxOahDLE __lambda_chatattachalertlocationlayout_gpcozhf6zt0gvbitxbwpxoahdle = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertLocationLayout$GpcozHF6zt0GVBitxbwPxOahDLE
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                ChatAttachAlertLocationLayout.lambda$getThemeDescriptions$10();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.mapViewClip, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "dialogBackground"));
        arrayList.add(new ThemeDescription(this.locationButton, ThemeDescription.FLAG_IMAGECOLOR | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, "location_actionIcon"));
        arrayList.add(new ThemeDescription(this.locationButton, ThemeDescription.FLAG_IMAGECOLOR | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, "location_actionActiveIcon"));
        arrayList.add(new ThemeDescription(this.locationButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "location_actionBackground"));
        arrayList.add(new ThemeDescription(this.locationButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "location_actionPressedBackground"));
        arrayList.add(new ThemeDescription(null, 0, null, null, Theme.avatarDrawables, __lambda_chatattachalertlocationlayout_gpcozhf6zt0gvbitxbwpxoahdle, "avatar_text"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, __lambda_chatattachalertlocationlayout_gpcozhf6zt0gvbitxbwpxoahdle, "avatar_backgroundRed"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, __lambda_chatattachalertlocationlayout_gpcozhf6zt0gvbitxbwpxoahdle, "avatar_backgroundOrange"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, __lambda_chatattachalertlocationlayout_gpcozhf6zt0gvbitxbwpxoahdle, "avatar_backgroundViolet"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, __lambda_chatattachalertlocationlayout_gpcozhf6zt0gvbitxbwpxoahdle, "avatar_backgroundGreen"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, __lambda_chatattachalertlocationlayout_gpcozhf6zt0gvbitxbwpxoahdle, "avatar_backgroundCyan"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, __lambda_chatattachalertlocationlayout_gpcozhf6zt0gvbitxbwpxoahdle, "avatar_backgroundBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, __lambda_chatattachalertlocationlayout_gpcozhf6zt0gvbitxbwpxoahdle, "avatar_backgroundPink"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, null, "location_liveLocationProgress"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, null, "location_placeLocationBackground"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, null, "dialog_liveLocationProgress"));
        return arrayList;
    }
}

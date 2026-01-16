package ir.eitaa.ui.Components;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DocumentObject;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SvgHelper;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeImageSize;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.Theme;
import java.util.Locale;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class ChatGreetingsView extends LinearLayout {
    private final int currentAccount;
    private TextView descriptionView;
    boolean ignoreLayot;
    private Listener listener;
    private TLRPC$Document preloadedGreetingsSticker;
    private final Theme.ResourcesProvider resourcesProvider;
    public BackupImageView stickerToSendView;
    private TextView titleView;

    public interface Listener {
        void onGreetings(TLRPC$Document sticker);
    }

    public ChatGreetingsView(Context context, TLRPC$User user, int distance, int currentAccount, TLRPC$Document sticker, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        setOrientation(1);
        this.currentAccount = currentAccount;
        this.resourcesProvider = resourcesProvider;
        TextView textView = new TextView(context);
        this.titleView = textView;
        textView.setTextSize(1, 14.0f);
        this.titleView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.titleView.setGravity(1);
        TextView textView2 = new TextView(context);
        this.descriptionView = textView2;
        textView2.setTextSize(1, 14.0f);
        this.descriptionView.setGravity(1);
        this.stickerToSendView = new BackupImageView(context);
        addView(this.titleView, LayoutHelper.createLinear(-1, -2, 20.0f, 14.0f, 20.0f, 14.0f));
        updateColors();
        if (distance <= 0) {
            this.titleView.setText(LocaleController.getString("NoMessages", R.string.NoMessages));
        } else {
            this.titleView.setText(LocaleController.formatString("NearbyPeopleGreetingsMessage", R.string.NearbyPeopleGreetingsMessage, user.first_name, LocaleController.formatDistance(distance, 1)));
            this.descriptionView.setText(LocaleController.getString("NearbyPeopleGreetingsDescription", R.string.NearbyPeopleGreetingsDescription));
        }
        this.preloadedGreetingsSticker = sticker;
        if (sticker == null) {
            this.preloadedGreetingsSticker = MediaDataController.getInstance(currentAccount).getGreetingsSticker();
        }
        setSticker(this.preloadedGreetingsSticker);
    }

    private void setSticker(final TLRPC$Document sticker) {
        if (sticker == null) {
            return;
        }
        SvgHelper.SvgDrawable svgThumb = DocumentObject.getSvgThumb(sticker, "chat_serviceBackground", 1.0f);
        if (svgThumb != null) {
            this.stickerToSendView.setImage(ImageLocation.getForDocument(sticker), createFilter(sticker), svgThumb, 0, sticker);
        } else {
            this.stickerToSendView.setImage(ImageLocation.getForDocument(sticker), createFilter(sticker), ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(sticker.thumbs, 90), sticker), (String) null, 0, sticker);
        }
        this.stickerToSendView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatGreetingsView$8D8CAtQFlCdeDaMPHblWtewUIFo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setSticker$0$ChatGreetingsView(sticker, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setSticker$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setSticker$0$ChatGreetingsView(TLRPC$Document tLRPC$Document, View view) {
        Listener listener = this.listener;
        if (listener != null) {
            listener.onGreetings(tLRPC$Document);
        }
    }

    public static String createFilter(TLRPC$Document document) {
        float fMin;
        float f;
        int iDp;
        int i;
        if (AndroidUtilities.isTablet()) {
            fMin = AndroidUtilities.getMinTabletSide();
            f = 0.4f;
        } else {
            android.graphics.Point point = AndroidUtilities.displaySize;
            fMin = Math.min(point.x, point.y);
            f = 0.5f;
        }
        float f2 = fMin * f;
        int i2 = 0;
        while (true) {
            if (i2 >= document.attributes.size()) {
                iDp = 0;
                i = 0;
                break;
            }
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i2);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeImageSize) {
                iDp = tLRPC$DocumentAttribute.w;
                i = tLRPC$DocumentAttribute.h;
                break;
            }
            i2++;
        }
        if (MessageObject.isAnimatedStickerDocument(document, true) && iDp == 0 && i == 0) {
            iDp = Factory.DEVICE_USE_ANDROID_CAMCORDER;
            i = Factory.DEVICE_USE_ANDROID_CAMCORDER;
        }
        if (iDp == 0) {
            i = (int) f2;
            iDp = i + AndroidUtilities.dp(100.0f);
        }
        int i3 = (int) (i * (f2 / iDp));
        int i4 = (int) f2;
        float f3 = i3;
        if (f3 > f2) {
            i4 = (int) (i4 * (f2 / f3));
            i3 = i4;
        }
        float f4 = i4;
        float f5 = AndroidUtilities.density;
        return String.format(Locale.US, "%d_%d", Integer.valueOf((int) (f4 / f5)), Integer.valueOf((int) (i3 / f5)));
    }

    private void updateColors() {
        this.titleView.setTextColor(getThemedColor("chat_serviceText"));
        this.descriptionView.setTextColor(getThemedColor("chat_serviceText"));
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.ignoreLayot = true;
        this.descriptionView.setVisibility(0);
        this.stickerToSendView.setVisibility(0);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getMeasuredHeight() > View.MeasureSpec.getSize(heightMeasureSpec)) {
            this.descriptionView.setVisibility(8);
            this.stickerToSendView.setVisibility(8);
        } else {
            this.descriptionView.setVisibility(0);
            this.stickerToSendView.setVisibility(0);
        }
        this.ignoreLayot = false;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreLayot) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        fetchSticker();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    private void fetchSticker() {
        if (this.preloadedGreetingsSticker == null) {
            TLRPC$Document greetingsSticker = MediaDataController.getInstance(this.currentAccount).getGreetingsSticker();
            this.preloadedGreetingsSticker = greetingsSticker;
            setSticker(greetingsSticker);
        }
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}

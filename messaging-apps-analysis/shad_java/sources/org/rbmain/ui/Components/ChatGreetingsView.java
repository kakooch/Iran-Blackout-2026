package org.rbmain.ui.Components;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.medu.shad.R;
import java.util.Locale;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.DocumentObject;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.SvgHelper;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$DocumentAttribute;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeImageSize;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class ChatGreetingsView extends LinearLayout {
    private final int currentAccount;
    private TextView descriptionView;
    boolean ignoreLayot;
    private Listener listener;
    private TLRPC$Document preloadedGreetingsSticker;
    public BackupImageView stickerToSendView;
    private TextView titleView;

    public interface Listener {
        void onGreetings(TLRPC$Document tLRPC$Document);
    }

    public ChatGreetingsView(Context context, TLRPC$User tLRPC$User, int i, int i2, TLRPC$Document tLRPC$Document) {
        super(context);
        setOrientation(1);
        this.currentAccount = i2;
        TextView textView = new TextView(context);
        this.titleView = textView;
        textView.setTextSize(1, 14.0f);
        this.titleView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.titleView.setGravity(1);
        TextView textView2 = new TextView(context);
        this.descriptionView = textView2;
        textView2.setTextSize(1, 14.0f);
        this.descriptionView.setGravity(1);
        this.stickerToSendView = new BackupImageView(context);
        addView(this.titleView, LayoutHelper.createLinear(-1, -2, 20.0f, 14.0f, 20.0f, 14.0f));
        addView(this.descriptionView, LayoutHelper.createLinear(-1, -2, 20.0f, 12.0f, 20.0f, 14.0f));
        addView(this.stickerToSendView, LayoutHelper.createLinear(112, 112, 1, 0, 16, 0, 16));
        updateColors();
        if (i <= 0) {
            this.titleView.setText(LocaleController.getString("NoMessages", R.string.NoMessages));
            this.descriptionView.setText(LocaleController.getString("NoMessagesGreetings", R.string.NoMessagesGreetings));
        } else {
            this.titleView.setText(LocaleController.formatString("NearbyPeopleGreetingsMessage", R.string.NearbyPeopleGreetingsMessage, tLRPC$User.first_name, LocaleController.formatDistance(i, 1)));
            this.descriptionView.setText(LocaleController.getString("NearbyPeopleGreetingsDescription", R.string.NearbyPeopleGreetingsDescription));
        }
        this.preloadedGreetingsSticker = tLRPC$Document;
        if (tLRPC$Document == null) {
            this.preloadedGreetingsSticker = MediaDataController.getInstance(i2).getGreetingsSticker();
        }
        setSticker(this.preloadedGreetingsSticker);
    }

    private void setSticker(final TLRPC$Document tLRPC$Document) {
        if (tLRPC$Document == null) {
            return;
        }
        SvgHelper.SvgDrawable svgThumb = DocumentObject.getSvgThumb(tLRPC$Document, Theme.key_chat_serviceBackground, 1.0f);
        if (svgThumb != null) {
            this.stickerToSendView.setImage(ImageLocation.getForDocument(tLRPC$Document), createFilter(tLRPC$Document), svgThumb, 0, tLRPC$Document);
        } else {
            this.stickerToSendView.setImage(ImageLocation.getForDocument(tLRPC$Document), createFilter(tLRPC$Document), ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 90), tLRPC$Document), (String) null, 0, tLRPC$Document);
        }
        this.stickerToSendView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatGreetingsView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setSticker$0(tLRPC$Document, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSticker$0(TLRPC$Document tLRPC$Document, View view) {
        Listener listener = this.listener;
        if (listener != null) {
            listener.onGreetings(tLRPC$Document);
        }
    }

    public static String createFilter(TLRPC$Document tLRPC$Document) {
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
            if (i2 >= tLRPC$Document.attributes.size()) {
                iDp = 0;
                i = 0;
                break;
            }
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = tLRPC$Document.attributes.get(i2);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeImageSize) {
                iDp = tLRPC$DocumentAttribute.w;
                i = tLRPC$DocumentAttribute.h;
                break;
            }
            i2++;
        }
        if (MessageObject.isAnimatedStickerDocument(tLRPC$Document, true) && iDp == 0 && i == 0) {
            iDp = 512;
            i = 512;
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
        TextView textView = this.titleView;
        int i = Theme.key_chat_serviceText;
        textView.setTextColor(Theme.getColor(i));
        this.descriptionView.setTextColor(Theme.getColor(i));
        setBackground(Theme.createRoundRectDrawable(AndroidUtilities.dp(10.0f), Theme.getColor(Theme.key_chat_serviceBackground)));
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.ignoreLayot = true;
        this.descriptionView.setVisibility(0);
        this.stickerToSendView.setVisibility(0);
        super.onMeasure(i, i2);
        if (getMeasuredHeight() > View.MeasureSpec.getSize(i2)) {
            this.descriptionView.setVisibility(8);
            this.stickerToSendView.setVisibility(8);
        } else {
            this.descriptionView.setVisibility(0);
            this.stickerToSendView.setVisibility(0);
        }
        this.stickerToSendView.setVisibility(8);
        this.ignoreLayot = false;
        super.onMeasure(i, i2);
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
}

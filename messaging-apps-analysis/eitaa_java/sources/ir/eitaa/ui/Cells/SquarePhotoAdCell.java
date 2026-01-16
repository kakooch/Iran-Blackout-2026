package ir.eitaa.ui.Cells;

import android.content.Context;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.TLRPC$TL_ads_simpleAd;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class SquarePhotoAdCell extends LinearLayout {
    private BackupImageView imageView;
    private TextView titleTextView;

    public SquarePhotoAdCell(Context context) {
        super(context);
        setOrientation(1);
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(8.0f));
        addView(this.imageView, LayoutHelper.createLinear(R.styleable.AppCompatTheme_windowNoTitle, R.styleable.AppCompatTheme_windowNoTitle, 49, 8, 8, 8, 0));
        TextView textView = new TextView(context);
        this.titleTextView = textView;
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.titleTextView.setTextSize(1, 12.0f);
        this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.titleTextView.setMaxLines(2);
        this.titleTextView.setGravity(49);
        this.titleTextView.setLines(2);
        this.titleTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        addView(this.titleTextView, LayoutHelper.createLinear(-1, -2, 51, 6, 8, 6, 0));
    }

    public void setAd(TLRPC$TL_ads_simpleAd simpleAd) {
        String strSubstring = simpleAd.title;
        if (strSubstring != null && !strSubstring.isEmpty()) {
            int iIndexOf = strSubstring.indexOf(10);
            if (iIndexOf >= 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
            this.titleTextView.setText(strSubstring);
        } else {
            this.titleTextView.setText("Ads");
        }
        if (!simpleAd.photos.isEmpty()) {
            this.imageView.setImage(FileLoader.getPathToAttach(FileLoader.getClosestPhotoSizeWithSize(simpleAd.photos, 90), true).toString(), null, null);
        } else {
            this.imageView.setImageResource(R.drawable.photo_placeholder_in);
        }
    }
}

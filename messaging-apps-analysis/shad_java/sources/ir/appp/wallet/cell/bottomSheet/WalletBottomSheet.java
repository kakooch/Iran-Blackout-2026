package ir.appp.wallet.cell.bottomSheet;

import android.content.Context;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.appp.common.utils.LayoutHelper;
import ir.appp.wallet.helper.ViewCreator;
import ir.medu.shad.R;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.ui.ActionBar.Theme;

/* compiled from: WalletBottomSheet.kt */
/* loaded from: classes3.dex */
public class WalletBottomSheet extends LinearLayout {
    private final Context mContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletBottomSheet(Context mContext) {
        super(mContext);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        new LinkedHashMap();
        this.mContext = mContext;
        int i = Theme.key_windowBackgroundWhite;
        setBackgroundColor(Theme.getColor(i));
        setPadding(16, 16, 16, 16);
        setOrientation(1);
        setGravity(5);
        ViewCreator.Companion companion = ViewCreator.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setBackground(companion.getDrawableWithColor(R.drawable.wallet_bottom_sheet, context, Theme.getColor(i)));
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public FrameLayout initInputLayout(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        editText.setBackground(null);
        frameLayout.setBackgroundResource(R.drawable.bg_wallet_test_2);
        frameLayout.addView(editText, LayoutHelper.createFrame(-1, -2));
        return frameLayout;
    }

    public TextView initTitleTextView(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ViewCreator.Companion companion = ViewCreator.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TextView textViewCreateTextView = companion.createTextView(context);
        textViewCreateTextView.setText(text);
        textViewCreateTextView.setTextSize(22.0f);
        return textViewCreateTextView;
    }

    public ImageView initTopImage(int i) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(getContext().getResources().getDrawable(i));
        return imageView;
    }
}

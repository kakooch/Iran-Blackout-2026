package ir.resaneh1.iptv.fragment.home.music;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.CustomTextView;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* compiled from: HomeMusicEmptyCell.kt */
/* loaded from: classes3.dex */
public final class HomeMusicEmptyCell extends LinearLayout {
    private final int LOGO_SIZE;
    private final Context context;
    private final Lazy emptyImageView$delegate;
    private final Lazy emptyTextView$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeMusicEmptyCell(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.context = context;
        this.emptyImageView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.resaneh1.iptv.fragment.home.music.HomeMusicEmptyCell$emptyImageView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                ImageView imageView = new ImageView(this.this$0.context);
                imageView.setImageDrawable(imageView.getContext().getResources().getDrawable(R.drawable.music_empty));
                return imageView;
            }
        });
        this.emptyTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.home.music.HomeMusicEmptyCell$emptyTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textViewBuild = new CustomTextView.Builder(this.this$0.context).setTextColor(Theme.getColor(Theme.key_dialogTextGray)).setText(LocaleController.getString(R.string.empty_home_music)).removeBackgrounds().build();
                textViewBuild.setEllipsize(TextUtils.TruncateAt.END);
                textViewBuild.setSingleLine(true);
                return textViewBuild;
            }
        });
        int iDp = AndroidUtilities.dp(20.0f);
        this.LOGO_SIZE = iDp;
        setOrientation(1);
        setGravity(17);
        addView(getEmptyImageView(), LayoutHelper.createLinear(iDp, iDp, 0.0f, 32.0f, 0.0f, 16.0f));
        addView(getEmptyTextView(), LayoutHelper.createLinear(-2, -2, 0.0f, 16.0f, 0.0f, 32.0f));
    }

    private final ImageView getEmptyImageView() {
        return (ImageView) this.emptyImageView$delegate.getValue();
    }

    private final TextView getEmptyTextView() {
        return (TextView) this.emptyTextView$delegate.getValue();
    }
}

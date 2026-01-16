package ir.resaneh1.iptv.fragment.home.live;

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
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* compiled from: HomeLiveEmptyCell.kt */
/* loaded from: classes3.dex */
public final class HomeLiveEmptyCell extends LinearLayout {
    private final Context context;
    private final Lazy emptyImageView$delegate;
    private final Lazy emptyTextView$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeLiveEmptyCell(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.context = context;
        this.emptyImageView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.resaneh1.iptv.fragment.home.live.HomeLiveEmptyCell$emptyImageView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                ImageView imageView = new ImageView(this.this$0.context);
                imageView.setImageDrawable(imageView.getContext().getResources().getDrawable(R.drawable.ic_home_live_empty));
                return imageView;
            }
        });
        this.emptyTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.home.live.HomeLiveEmptyCell$emptyTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textViewBuild = new CustomTextView.Builder(this.this$0.context).setTextColor(Theme.getColor(Theme.key_dialogTextGray)).setText(LocaleController.getString(R.string.empty_home_live)).removeBackgrounds().build();
                textViewBuild.setEllipsize(TextUtils.TruncateAt.END);
                textViewBuild.setSingleLine(true);
                return textViewBuild;
            }
        });
        setOrientation(1);
        setGravity(17);
        addView(getEmptyImageView(), LayoutHelper.createLinear(50, 50, 0.0f, 8.0f, 0.0f, 8.0f));
        addView(getEmptyTextView(), LayoutHelper.createLinear(-2, -2, 0.0f, 8.0f, 0.0f, 16.0f));
    }

    private final ImageView getEmptyImageView() {
        return (ImageView) this.emptyImageView$delegate.getValue();
    }

    private final TextView getEmptyTextView() {
        return (TextView) this.emptyTextView$delegate.getValue();
    }
}

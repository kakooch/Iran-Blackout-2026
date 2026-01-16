package ir.appp.wallet.cell;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.appp.common.utils.LayoutHelper;
import ir.appp.wallet.helper.ViewCreator;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WalletHeaderActionCell.kt */
/* loaded from: classes3.dex */
public final class WalletHeaderActionCell extends FrameLayout {
    private final Lazy circleImageView$delegate;
    private final Context mContext;
    private final Lazy nameTextView$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletHeaderActionCell(Context mContext) {
        super(mContext);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        new LinkedHashMap();
        this.mContext = mContext;
        this.circleImageView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.appp.wallet.cell.WalletHeaderActionCell$circleImageView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return new ImageView(this.this$0.getMContext());
            }
        });
        this.nameTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.appp.wallet.cell.WalletHeaderActionCell$nameTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return ViewCreator.Companion.createTextView(this.this$0.getMContext());
            }
        });
        addView(getCircleImageView(), LayoutHelper.createFrame(50, 50, 49, 8.0f, 8.0f, 8.0f, 8.0f));
        getNameTextView().setGravity(1);
        addView(getNameTextView(), LayoutHelper.createFrame(-2, -2, 81, 0.0f, 66.0f, 0.0f, 8.0f));
    }

    public final Context getMContext() {
        return this.mContext;
    }

    private final ImageView getCircleImageView() {
        return (ImageView) this.circleImageView$delegate.getValue();
    }

    public final TextView getNameTextView() {
        return (TextView) this.nameTextView$delegate.getValue();
    }

    public final void setData(String text, int i) {
        Intrinsics.checkNotNullParameter(text, "text");
        getCircleImageView().setImageDrawable(this.mContext.getResources().getDrawable(i));
        getNameTextView().setText(text);
        getNameTextView().setTextColor(-1);
    }
}

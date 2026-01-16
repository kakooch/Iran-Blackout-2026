package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import ir.appp.messenger.SendPostHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.insta.RubinoDraftManager;
import ir.resaneh1.iptv.model.Rubino;
import java.util.ArrayList;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class RubinoSendingPostView extends FrameLayout {
    int currentAccount;
    public ImageView imageViewCancel;
    public ImageView imageViewOption;
    public ImageView imageViewPost;
    public ImageView imageViewVideoIcon;
    public Context mContext;
    View.OnClickListener onCancelClickListener;
    View.OnClickListener onOptionClickListener;
    public ProgressBar progressBar;
    public RubinoDraftManager.RubinoSendingPost sendingPost;
    public TextView textView;

    public RubinoSendingPostView(Context context) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.onCancelClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSendingPostView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SendPostHelper.getInstance(RubinoSendingPostView.this.currentAccount).cancelSendPostRubino(RubinoSendingPostView.this.sendingPost.rnd);
            }
        };
        this.onOptionClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSendingPostView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoRetrySendPost), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSendingPostView.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) throws InterruptedException {
                        SendPostHelper.getInstance(RubinoSendingPostView.this.currentAccount).retrySendPostRubino(RubinoSendingPostView.this.sendingPost.rnd);
                    }
                }));
                arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoCancelSendPost), 0, RubinoSendingPostView.this.onCancelClickListener));
                RubinoController.showRubinoCenterDialog(null, arrayList);
            }
        };
        setWillNotDraw(false);
        this.mContext = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rubino_sending_post_row, (ViewGroup) null, false);
        addView(viewInflate, LayoutHelper.createFrame(-1, -2.0f));
        this.imageViewPost = (ImageView) viewInflate.findViewById(R.id.imageView);
        this.imageViewVideoIcon = (ImageView) viewInflate.findViewById(R.id.imageViewVideoIcon);
        this.imageViewCancel = (ImageView) viewInflate.findViewById(R.id.imageViewCancel);
        this.imageViewOption = (ImageView) viewInflate.findViewById(R.id.imageViewOption);
        this.progressBar = (ProgressBar) viewInflate.findViewById(R.id.progressBar);
        this.textView = (TextView) viewInflate.findViewById(R.id.textView);
        this.imageViewOption.setOnClickListener(this.onOptionClickListener);
        this.imageViewCancel.setOnClickListener(this.onCancelClickListener);
        ImageView imageView = this.imageViewCancel;
        int i = Theme.key_rubinoBlackColor;
        imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.SRC_ATOP));
        this.textView.setTextColor(Theme.getColor(i));
        this.textView.setTypeface(Theme.getRubinoTypeFaceBold());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0.0f, getHeight() - 1, getWidth(), getHeight() - 1, Theme.getDividerPaint());
    }

    public void setObject(RubinoDraftManager.RubinoSendingPost rubinoSendingPost) {
        this.sendingPost = rubinoSendingPost;
        setProgress();
        if (rubinoSendingPost.entryList.get(0).isVideo) {
            this.imageViewVideoIcon.setVisibility(0);
        } else {
            this.imageViewVideoIcon.setVisibility(4);
        }
        Bitmap bitmap = rubinoSendingPost.entryList.get(0).thumbBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.imageViewPost.setImageBitmap(bitmap);
        } else {
            this.imageViewPost.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.shape_grey_background));
        }
        if (!rubinoSendingPost.hasError) {
            this.imageViewOption.setVisibility(4);
            this.imageViewCancel.setVisibility(0);
            this.textView.setVisibility(8);
        } else {
            this.textView.setVisibility(0);
            this.textView.setText(LocaleController.getString(R.string.error_on_send));
            this.imageViewCancel.setVisibility(4);
            this.imageViewOption.setVisibility(0);
        }
    }

    public void setProgress() {
        RubinoDraftManager.RubinoSendingPost rubinoSendingPost = this.sendingPost;
        if (!rubinoSendingPost.hasError) {
            this.progressBar.setProgress(rubinoSendingPost.getProgress());
            this.progressBar.setVisibility(0);
        } else {
            this.progressBar.setVisibility(4);
        }
    }
}

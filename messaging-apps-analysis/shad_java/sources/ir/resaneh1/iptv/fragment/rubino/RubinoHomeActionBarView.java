package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.FlavorHelper;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class RubinoHomeActionBarView extends FrameLayout {
    private final int currentAccount;
    private final ImageView imageViewCircleRed;
    private final ImageView imageViewNotif;
    private final ImageView imageViewProfile;

    public ImageView getImageViewCircleRed() {
        return this.imageViewCircleRed;
    }

    public RubinoHomeActionBarView(Context context) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        View viewInflate = LayoutInflater.from(context).inflate(LocaleController.isRTL ? R.layout.rubino_home_action_bar_view : R.layout.rubino_home_action_bar_view_left, (ViewGroup) null, false);
        addView(viewInflate);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.imageView1);
        this.imageViewProfile = imageView;
        this.imageViewCircleRed = (ImageView) viewInflate.findViewById(R.id.imageViewCircleRed);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.imageView2);
        this.imageViewNotif = imageView2;
        int i = Theme.key_rubinoBlackColor;
        imageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.SRC_ATOP));
        if (FlavorHelper.isRubino()) {
            imageView2.setImageResource(R.drawable.rubino_send_message_direct_outline_24);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoHomeActionBarView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RubinoHomeActionBarView.lambda$new$0(view);
                }
            });
        } else {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoHomeActionBarView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$1(view);
                }
            });
        }
        imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.SRC_ATOP));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoHomeActionBarView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$2(view);
            }
        });
        setImageViewCircleRed(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(View view) {
        new MainClickHandler().openChatTab();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view) {
        RubinoController.openNewEventActivity(this.currentAccount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(View view) {
        if (ApplicationLoader.applicationActivity != null) {
            ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoProfileActivity(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject()));
        }
    }

    public void setImageViewCircleRed(boolean z) {
        this.imageViewCircleRed.setVisibility(z ? 0 : 8);
    }
}

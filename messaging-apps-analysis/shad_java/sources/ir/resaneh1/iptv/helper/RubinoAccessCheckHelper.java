package ir.resaneh1.iptv.helper;

import android.content.DialogInterface;
import android.view.View;
import androidMessenger.utilites.AppFavorUtils;
import ir.medu.shad.R;
import ir.resaneh1.iptv.dialog.ThreeButtonDialog;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ChangeUsernameActivity;

/* loaded from: classes3.dex */
public class RubinoAccessCheckHelper {
    public static boolean hasUserName() {
        return (AppPreferences.getInstance(UserConfig.selectedAccount).getMyUsername() == null || AppPreferences.getInstance(UserConfig.selectedAccount).getMyUsername().isEmpty()) ? false : true;
    }

    public static void showSetRubinoUserNameDialog(final BaseFragment baseFragment) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(ApplicationLoader.applicationActivity, LocaleController.formatString(R.string.RubinoUsernameEmpty, LocaleController.getString(AppFavorUtils.rubinoNameId)).toString());
        threeButtonDialog.button1.setText(LocaleController.getString("OK", R.string.OK));
        threeButtonDialog.button1.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.helper.RubinoAccessCheckHelper.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                baseFragment.presentFragment(new ChangeUsernameActivity());
                threeButtonDialog.dismiss();
            }
        });
        threeButtonDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.resaneh1.iptv.helper.RubinoAccessCheckHelper.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                threeButtonDialog.dismiss();
            }
        });
        threeButtonDialog.button2.setVisibility(4);
        threeButtonDialog.button3.setVisibility(4);
        threeButtonDialog.show();
    }
}

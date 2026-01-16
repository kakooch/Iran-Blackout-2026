package ir.eitaa.ui;

import android.content.Intent;
import android.os.Bundle;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.EditWidgetActivity;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ChatsWidgetConfigActivity extends ExternalActionActivity {
    private int creatingAppWidgetId = 0;

    @Override // ir.eitaa.ui.ExternalActionActivity
    protected boolean handleIntent(Intent intent, boolean isNew, boolean restore, boolean fromPassword, int intentAccount, int state) {
        if (!checkPasscode(intent, isNew, restore, fromPassword, intentAccount, state)) {
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.creatingAppWidgetId = extras.getInt("appWidgetId", 0);
        }
        if (this.creatingAppWidgetId != 0) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("onlySelect", true);
            bundle.putInt("dialogsType", 10);
            bundle.putBoolean("allowSwitchAccount", true);
            EditWidgetActivity editWidgetActivity = new EditWidgetActivity(0, this.creatingAppWidgetId);
            editWidgetActivity.setDelegate(new EditWidgetActivity.EditWidgetActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatsWidgetConfigActivity$_Kc3xQYYKgRHsAE0uuhcfp2bzeA
                @Override // ir.eitaa.ui.EditWidgetActivity.EditWidgetActivityDelegate
                public final void didSelectDialogs(ArrayList arrayList) {
                    this.f$0.lambda$handleIntent$0$ChatsWidgetConfigActivity(arrayList);
                }
            });
            if (AndroidUtilities.isTablet()) {
                if (this.layersActionBarLayout.fragmentsStack.isEmpty()) {
                    this.layersActionBarLayout.addFragmentToStack(editWidgetActivity);
                }
            } else if (this.actionBarLayout.fragmentsStack.isEmpty()) {
                this.actionBarLayout.addFragmentToStack(editWidgetActivity);
            }
            if (!AndroidUtilities.isTablet()) {
                this.backgroundTablet.setVisibility(8);
            }
            this.actionBarLayout.showLastFragment();
            if (AndroidUtilities.isTablet()) {
                this.layersActionBarLayout.showLastFragment();
            }
            intent.setAction(null);
        } else {
            finish();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleIntent$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$handleIntent$0$ChatsWidgetConfigActivity(ArrayList arrayList) {
        Intent intent = new Intent();
        intent.putExtra("appWidgetId", this.creatingAppWidgetId);
        setResult(-1, intent);
        finish();
    }
}

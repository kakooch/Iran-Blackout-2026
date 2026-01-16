package ir.appp.rghapp.rubinoPostSlider;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class AddPostPermissionView extends FrameLayout {
    protected static int permission_request_code_camera = 4098;
    protected static int permission_request_code_gallery = 4097;
    AddPostPermissionDelegate delegate;
    TextView permissionDescriptionTextView;
    PermissionType[] requestForPermissions;

    protected interface AddPostPermissionDelegate {
        void didRequestPermission(PermissionType[] permissionTypeArr);
    }

    protected enum PermissionType {
        GALLERY,
        CAMERA,
        AUDIO
    }

    public AddPostPermissionView(Context context) {
        super(context);
        int iDp = AndroidUtilities.dp(10.0f);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        addView(linearLayout, LayoutHelper.createFrame(-1, -1.0f));
        TextView textView = new TextView(context);
        this.permissionDescriptionTextView = textView;
        textView.setGravity(17);
        this.permissionDescriptionTextView.setPadding(iDp, iDp, iDp, iDp);
        this.permissionDescriptionTextView.setTextColor(Theme.getColor(Theme.key_rubinoBlackColor));
        this.permissionDescriptionTextView.setTypeface(Theme.getRubinoTypeFaceRegular());
        linearLayout.addView(this.permissionDescriptionTextView);
        TextView textView2 = new TextView(context);
        textView2.setGravity(17);
        textView2.setSingleLine(true);
        textView2.setLines(1);
        textView2.setMaxLines(1);
        textView2.setPadding(iDp, iDp, iDp, iDp);
        textView2.setTextColor(Theme.getColor(Theme.key_rubino_add_postCheckBoxBackground));
        textView2.setTypeface(Theme.getRubinoTypeFaceBold());
        textView2.setTextSize(1, 16.0f);
        textView2.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_rubino_add_post_TabSelector), 3));
        textView2.setText(LocaleController.getString("AddPostPerButton", R.string.rubinoAddPostPermissionButton));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostPermissionView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0(view);
            }
        });
        linearLayout.addView(textView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        AddPostPermissionDelegate addPostPermissionDelegate = this.delegate;
        if (addPostPermissionDelegate != null) {
            addPostPermissionDelegate.didRequestPermission(this.requestForPermissions);
        }
    }

    public void setDelegate(AddPostPermissionDelegate addPostPermissionDelegate) {
        this.delegate = addPostPermissionDelegate;
    }

    public void setRequestForPermissions(PermissionType[] permissionTypeArr) {
        this.requestForPermissions = permissionTypeArr;
    }

    public void setPermissionDescription(String str) {
        this.permissionDescriptionTextView.setText(str);
    }
}

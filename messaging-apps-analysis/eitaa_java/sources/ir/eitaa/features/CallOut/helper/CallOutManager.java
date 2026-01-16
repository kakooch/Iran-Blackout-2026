package ir.eitaa.features.CallOut.helper;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import ir.eitaa.features.CallOut.CallOutActivity;
import ir.eitaa.features.CallOut.CallOutSingleton;
import ir.eitaa.features.CallOut.StartCallOutActivity;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBarLayout;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import java.util.ArrayList;
import org.linphone.core.Call;

/* loaded from: classes.dex */
public class CallOutManager {

    public interface CallOutDelegate {
        void onCallOutPressed(ContactsController.Contact contact);
    }

    public static Call getCall() {
        if (CallOutSingleton.getInstance().core == null || CallOutSingleton.getInstance().core.getCallsNb() == 0) {
            return null;
        }
        if (CallOutSingleton.getInstance().core.getCurrentCall() != null) {
            return CallOutSingleton.getInstance().core.getCurrentCall();
        }
        return CallOutSingleton.getInstance().core.getCalls()[0];
    }

    public static void makeCall(BaseFragment fragment, ContactsController.Contact contact) {
        if (getCall() != null && CallOutSingleton.getInstance().lastCallContact != null && CallOutSingleton.getInstance().lastCallContact.phones.get(0).equals(contact.phones.get(0))) {
            goToLastCall(fragment);
        } else if (getCall() == null) {
            fragment.presentFragment(new CallOutActivity(contact, fragment instanceof StartCallOutActivity));
            CallOutSingleton.getInstance().lastCallContact = contact;
        } else {
            Toast.makeText(fragment.getParentActivity(), LocaleController.getString("CallInProgress", R.string.CallInProgress), 1).show();
        }
    }

    public static void goToLastCall(BaseFragment fragment) {
        ActionBarLayout parentLayout = fragment.getParentLayout();
        if (getCall() == null || CallOutSingleton.getInstance().lastCallContact == null || !parentLayout.fragmentsStack.isEmpty()) {
            ArrayList<BaseFragment> arrayList = parentLayout.fragmentsStack;
            if (arrayList.get(arrayList.size() - 1) instanceof CallOutActivity) {
                return;
            }
        }
        fragment.presentFragment(new CallOutActivity(CallOutSingleton.getInstance().lastCallContact, false), !fragment.isLastFragment(), true);
    }

    public static void terminateCall() {
        if (CallOutSingleton.getInstance().core == null) {
            return;
        }
        if (CallOutAudioManager.isSpeakerActive()) {
            CallOutAudioManager.toggleSpeaker();
        }
        CallOutSingleton.getInstance().lastCallContact = null;
        CallOutSingleton.getInstance().lastCallState = null;
        CallOutSingleton.getInstance().lastCallMessage = "";
        CallOutSingleton.getInstance().lastCallStartTime = 0L;
        CallOutSingleton.getInstance().core.terminateAllCalls();
        CallOutSingleton.getInstance().core.stop();
    }

    public static ContactsController.Contact makeContactFromUser(TLRPC$User user) {
        ContactsController.Contact contact = new ContactsController.Contact();
        contact.user = user;
        contact.last_name = user.last_name;
        contact.first_name = user.first_name;
        ArrayList<String> arrayList = new ArrayList<>();
        contact.phones = arrayList;
        arrayList.add(user.phone);
        return contact;
    }

    public static boolean checkPermissions(Activity activity) {
        return ContextCompat.checkSelfPermission(activity, "android.permission.RECORD_AUDIO") == 0;
    }

    public static void requestPermissions(final BaseFragment fragment, int requestCode) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(fragment.getParentActivity(), "android.permission.RECORD_AUDIO")) {
            new AlertDialog.Builder(fragment.getParentActivity()).setTitle(LocaleController.getString("AppName", R.string.AppName)).setMessage(LocaleController.getString("VoipNeedMicPermission", R.string.VoipNeedMicPermission)).setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.features.CallOut.helper.-$$Lambda$CallOutManager$jIwqsYq-9UBsB47fBJOxRP0JJlg
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    fragment.finishFragment();
                }
            }).setNegativeButton(LocaleController.getString("Settings", R.string.Settings), new DialogInterface.OnClickListener() { // from class: ir.eitaa.features.CallOut.helper.-$$Lambda$CallOutManager$vXLeVMWsBy7kQnWYGESJVBRgccc
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    CallOutManager.lambda$requestPermissions$1(fragment, dialogInterface, i);
                }
            }).show();
        } else {
            ActivityCompat.requestPermissions(fragment.getParentActivity(), new String[]{"android.permission.RECORD_AUDIO"}, requestCode);
        }
    }

    static /* synthetic */ void lambda$requestPermissions$1(BaseFragment baseFragment, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", baseFragment.getParentActivity().getPackageName(), null));
        baseFragment.getParentActivity().startActivity(intent);
        baseFragment.finishFragment();
    }

    public static void onAppTerminate() {
        Call call = getCall();
        if (call != null) {
            call.terminate();
        }
    }
}

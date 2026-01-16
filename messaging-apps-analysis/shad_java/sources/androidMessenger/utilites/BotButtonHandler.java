package androidMessenger.utilites;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import androidMessenger.utilites.FilePicker;
import androidMessenger.utilites.FilePickerManager;
import androidx.core.content.ContextCompat;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.BotButtonObject;
import ir.aaap.messengercore.model.KeyboardButton;
import ir.aaap.messengercore.model.LocationObject;
import ir.aaap.messengercore.model.MiniFunctionModels;
import ir.aaap.messengercore.model.MiniFunctionObject;
import ir.medu.shad.R;
import ir.resaneh1.iptv.dialog.BotAlertDialog;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.model.ViewObjectAttr;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MrzRecognizer;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.CameraScanActivity;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.LocationActivity;

/* loaded from: classes.dex */
public class BotButtonHandler {

    public interface Delegate {
        void done(String str, ArrayList<String> arrayList);

        void notSupported();

        void onLocationSelected(TLRPC$MessageMedia tLRPC$MessageMedia);

        void uploadFileDone(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleButtonClick$1(int i, int i2, int i3) {
    }

    public static void handleButtonClick(final BaseFragment baseFragment, long j, final MiniFunctionObject miniFunctionObject, final ViewObjectAttr viewObjectAttr, final Delegate delegate) {
        MiniFunctionModels.ButtonEditText buttonEditText;
        MiniFunctionModels.ButtonStringPicker buttonStringPicker;
        MiniFunctionModels.ButtonNumberPicker buttonNumberPicker;
        MiniFunctionModels.ButtonCalendar buttonCalendar;
        MiniFunctionModels.ButtonType buttonType = miniFunctionObject.type;
        if (buttonType == MiniFunctionModels.ButtonType.Simple) {
            delegate.done(miniFunctionObject.getTitle(), null);
            return;
        }
        if (buttonType == MiniFunctionModels.ButtonType.Location || buttonType == MiniFunctionModels.ButtonType.LocationPicker) {
            LocationActivity locationActivity = new LocationActivity(0);
            locationActivity.setDelegate(new LocationActivity.LocationActivityDelegate() { // from class: androidMessenger.utilites.BotButtonHandler$$ExternalSyntheticLambda8
                @Override // org.rbmain.ui.LocationActivity.LocationActivityDelegate
                public final void didSelectLocation(TLRPC$MessageMedia tLRPC$MessageMedia, int i, boolean z, int i2) {
                    delegate.onLocationSelected(tLRPC$MessageMedia);
                }
            });
            baseFragment.presentFragment(locationActivity);
            return;
        }
        if (buttonType == MiniFunctionModels.ButtonType.Selection && miniFunctionObject.button_selection != null) {
            baseFragment.showDialog(AlertsCreator.createItemPickerDialog(baseFragment.getParentActivity(), baseFragment.getCurrentAccount(), j, miniFunctionObject.button_selection, miniFunctionObject instanceof KeyboardButton ? ((KeyboardButton) miniFunctionObject).button_text : BuildConfig.FLAVOR, new AlertsCreator.ItemPickerDelegate() { // from class: androidMessenger.utilites.BotButtonHandler.1
                @Override // org.rbmain.ui.Components.AlertsCreator.ItemPickerDelegate
                public void selectedItemChanged(ArrayList<BotButtonObject.BotButtonSimpleObject> arrayList) {
                }

                @Override // org.rbmain.ui.Components.AlertsCreator.ItemPickerDelegate
                public void didSelectItems(ArrayList<BotButtonObject.BotButtonSimpleObject> arrayList) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    Iterator<BotButtonObject.BotButtonSimpleObject> it = arrayList.iterator();
                    String str = BuildConfig.FLAVOR;
                    while (it.hasNext()) {
                        BotButtonObject.BotButtonSimpleObject next = it.next();
                        if (str.length() > 0) {
                            str = str + ",";
                        }
                        str = str + next.text;
                        arrayList2.add(next.text);
                    }
                    if (delegate == null || str.length() <= 0) {
                        return;
                    }
                    delegate.done(str, arrayList2);
                }
            }).create());
            return;
        }
        if (buttonType == MiniFunctionModels.ButtonType.Calendar && (buttonCalendar = miniFunctionObject.button_calendar) != null) {
            int i = buttonCalendar.min_year;
            int i2 = buttonCalendar.max_year;
            String str = buttonCalendar.title;
            String str2 = buttonCalendar.default_value;
            baseFragment.showDialog(AlertsCreator.createDatePickerDialog(baseFragment.getParentActivity(), i, i2, 1, 0, 0, 0, str, false, new AlertsCreator.DatePickerDelegate() { // from class: androidMessenger.utilites.BotButtonHandler$$ExternalSyntheticLambda4
                @Override // org.rbmain.ui.Components.AlertsCreator.DatePickerDelegate
                public final void didSelectDate(int i3, int i4, int i5) {
                    BotButtonHandler.lambda$handleButtonClick$1(i3, i4, i5);
                }
            }).create());
            return;
        }
        if (buttonType == MiniFunctionModels.ButtonType.NumberPicker && (buttonNumberPicker = miniFunctionObject.button_number_picker) != null) {
            baseFragment.showDialog(AlertsCreator.createNumberPickerAlert(baseFragment.getParentActivity(), miniFunctionObject.button_number_picker.title, buttonNumberPicker.min_value, buttonNumberPicker.max_value, buttonNumberPicker.default_value.intValue(), new AlertsCreator.NumberPickerDelegate() { // from class: androidMessenger.utilites.BotButtonHandler$$ExternalSyntheticLambda5
                @Override // org.rbmain.ui.Components.AlertsCreator.NumberPickerDelegate
                public final void didSelectNumber(int i3) {
                    BotButtonHandler.lambda$handleButtonClick$2(delegate, i3);
                }
            }).create());
            return;
        }
        if (buttonType == MiniFunctionModels.ButtonType.StringPicker && (buttonStringPicker = miniFunctionObject.button_string_picker) != null) {
            baseFragment.showDialog(AlertsCreator.createStringPickerAlert(baseFragment.getParentActivity(), buttonStringPicker.title, buttonStringPicker.items, buttonStringPicker.default_value, new AlertsCreator.StringPickerDelegate() { // from class: androidMessenger.utilites.BotButtonHandler$$ExternalSyntheticLambda7
                @Override // org.rbmain.ui.Components.AlertsCreator.StringPickerDelegate
                public final void didPickString(String str3) {
                    delegate.done(str3, null);
                }
            }).create());
            return;
        }
        if (buttonType == MiniFunctionModels.ButtonType.Textbox && (buttonEditText = miniFunctionObject.button_textbox) != null) {
            MiniFunctionModels.ButtonEditText.TypeLine typeLine = buttonEditText.type_line;
            MiniFunctionModels.ButtonEditText.TypeKeypad typeKeypad = buttonEditText.type_keypad;
            String str3 = buttonEditText.default_value;
            AlertsCreator.createTextBoxAlert(baseFragment.getParentActivity(), miniFunctionObject.getTitleForDialogPicker(), typeLine == MiniFunctionModels.ButtonEditText.TypeLine.SingleLine, typeKeypad == MiniFunctionModels.ButtonEditText.TypeKeypad.Number, buttonEditText.place_holder, str3, new AlertsCreator.StringPickerDelegate() { // from class: androidMessenger.utilites.BotButtonHandler$$ExternalSyntheticLambda6
                @Override // org.rbmain.ui.Components.AlertsCreator.StringPickerDelegate
                public final void didPickString(String str4) {
                    delegate.done(str4, null);
                }
            });
            return;
        }
        if (buttonType == MiniFunctionModels.ButtonType.Barcode) {
            CameraScanActivity.showAsSheet(baseFragment, true, new CameraScanActivity.CameraScanActivityDelegate() { // from class: androidMessenger.utilites.BotButtonHandler.2
                @Override // org.rbmain.ui.CameraScanActivity.CameraScanActivityDelegate
                public /* synthetic */ void didFindMrzInfo(MrzRecognizer.Result result) {
                    CameraScanActivity.CameraScanActivityDelegate.CC.$default$didFindMrzInfo(this, result);
                }

                @Override // org.rbmain.ui.CameraScanActivity.CameraScanActivityDelegate
                public void didFindQr(String str4) {
                    delegate.done(str4, null);
                }
            });
            return;
        }
        if (buttonType == MiniFunctionModels.ButtonType.MyPhoneNumber || buttonType == MiniFunctionModels.ButtonType.AskMyPhoneNumber) {
            AlertsCreator.AskAlertDelegate askAlertDelegate = new AlertsCreator.AskAlertDelegate() { // from class: androidMessenger.utilites.BotButtonHandler$$ExternalSyntheticLambda2
                @Override // org.rbmain.ui.Components.AlertsCreator.AskAlertDelegate
                public final void onAccepted() {
                    BotButtonHandler.lambda$handleButtonClick$5(delegate, baseFragment);
                }
            };
            if (miniFunctionObject.type == MiniFunctionModels.ButtonType.AskMyPhoneNumber) {
                AlertsCreator.showAskAlert(baseFragment.getParentActivity(), "شماره تلفن شما ارسال شود؟", askAlertDelegate);
                return;
            } else {
                askAlertDelegate.onAccepted();
                return;
            }
        }
        MiniFunctionModels.ButtonType buttonType2 = MiniFunctionModels.ButtonType.AskMyLocation;
        if (buttonType == buttonType2 || buttonType == MiniFunctionModels.ButtonType.MyLocation) {
            AlertsCreator.AskAlertDelegate askAlertDelegate2 = new AlertsCreator.AskAlertDelegate() { // from class: androidMessenger.utilites.BotButtonHandler$$ExternalSyntheticLambda3
                @Override // org.rbmain.ui.Components.AlertsCreator.AskAlertDelegate
                public final void onAccepted() {
                    BotButtonHandler.sendMyLocation(baseFragment, delegate);
                }
            };
            if (miniFunctionObject.type == buttonType2) {
                AlertsCreator.showAskAlert(baseFragment.getParentActivity(), "موقعیت شما ارسال شود؟", askAlertDelegate2);
                return;
            } else {
                askAlertDelegate2.onAccepted();
                return;
            }
        }
        if (buttonType == MiniFunctionModels.ButtonType.Link) {
            if (miniFunctionObject.button_link != null) {
                baseFragment.getMessengerLinkHandler().onLinkClick(ApplicationLoader.applicationActivity.getLastFragment(), miniFunctionObject.button_link);
                return;
            }
            return;
        }
        if (buttonType == MiniFunctionModels.ButtonType.RecordAudio) {
            if (viewObjectAttr == null || miniFunctionObject.file_upload_properties == null) {
                return;
            }
            FilePickerManager.getInstance().openAudioRecorder(new FilePickerManager.Listener(miniFunctionObject, viewObjectAttr, delegate) { // from class: androidMessenger.utilites.BotButtonHandler.3
            });
            return;
        }
        if (buttonType == MiniFunctionModels.ButtonType.CameraImage) {
            if (viewObjectAttr != null && miniFunctionObject.file_upload_properties != null) {
                FilePickerManager.getInstance().openCamera(false, new FilePickerManager.Listener(miniFunctionObject, viewObjectAttr, delegate) { // from class: androidMessenger.utilites.BotButtonHandler.4
                });
                return;
            } else {
                if (j != 0) {
                    delegate.notSupported();
                    return;
                }
                return;
            }
        }
        if (buttonType == MiniFunctionModels.ButtonType.CameraVideo) {
            if (viewObjectAttr != null && miniFunctionObject.file_upload_properties != null) {
                FilePickerManager.getInstance().openCamera(true, new FilePickerManager.Listener(miniFunctionObject, viewObjectAttr, delegate) { // from class: androidMessenger.utilites.BotButtonHandler.5
                });
                return;
            } else {
                if (j != 0) {
                    delegate.notSupported();
                    return;
                }
                return;
            }
        }
        if (buttonType == MiniFunctionModels.ButtonType.Call) {
            if (miniFunctionObject.button_call != null) {
                new MainClickHandler().callNumber(miniFunctionObject.button_call.phone_number + BuildConfig.FLAVOR);
                return;
            }
            return;
        }
        if (buttonType == MiniFunctionModels.ButtonType.Alert) {
            if (miniFunctionObject.button_alert != null) {
                new BotAlertDialog(ApplicationLoader.applicationActivity, miniFunctionObject.getTitleForDialogPicker(), miniFunctionObject.button_alert.message + BuildConfig.FLAVOR).show();
                return;
            }
            return;
        }
        if (buttonType == MiniFunctionModels.ButtonType.SMS) {
            if (miniFunctionObject.button_sms != null) {
                new MainClickHandler().sendSms(miniFunctionObject.button_sms.to_number + BuildConfig.FLAVOR, miniFunctionObject.button_sms.message + BuildConfig.FLAVOR);
                return;
            }
            return;
        }
        if (buttonType == MiniFunctionModels.ButtonType.MyUsername) {
            if (AppPreferences.getInstance(AndroidUtilities.getCurrentAccountTemporary()).getMyUsername() == null || AppPreferences.getInstance(AndroidUtilities.getCurrentAccountTemporary()).getMyUsername().length() == 0) {
                delegate.done("-", null);
                return;
            }
            delegate.done("@" + AppPreferences.getInstance(AndroidUtilities.getCurrentAccountTemporary()).getMyUsername(), null);
            return;
        }
        if (buttonType == MiniFunctionModels.ButtonType.GalleryImage) {
            if (viewObjectAttr != null && miniFunctionObject.file_upload_properties != null) {
                new FilePicker().selectImageOrVideo(ApplicationLoader.applicationActivity, true, false, new FilePicker.Listener() { // from class: androidMessenger.utilites.BotButtonHandler.6
                    @Override // androidMessenger.utilites.FilePicker.Listener
                    public void done(String str4) {
                        UploadFileProgressDialog uploadFileProgressDialog = new UploadFileProgressDialog(ApplicationLoader.applicationActivity);
                        uploadFileProgressDialog.createView();
                        uploadFileProgressDialog.startUploading(miniFunctionObject.file_upload_properties, viewObjectAttr, str4, delegate);
                    }
                });
                return;
            } else {
                if (j != 0) {
                    delegate.notSupported();
                    return;
                }
                return;
            }
        }
        if (buttonType == MiniFunctionModels.ButtonType.GalleryVideo) {
            if (viewObjectAttr != null && miniFunctionObject.file_upload_properties != null) {
                new FilePicker().selectImageOrVideo(ApplicationLoader.applicationActivity, false, true, new FilePicker.Listener() { // from class: androidMessenger.utilites.BotButtonHandler.7
                    @Override // androidMessenger.utilites.FilePicker.Listener
                    public void done(String str4) {
                        UploadFileProgressDialog uploadFileProgressDialog = new UploadFileProgressDialog(ApplicationLoader.applicationActivity);
                        uploadFileProgressDialog.createView();
                        uploadFileProgressDialog.startUploading(miniFunctionObject.file_upload_properties, viewObjectAttr, str4, delegate);
                    }
                });
                return;
            } else {
                if (j != 0) {
                    delegate.notSupported();
                    return;
                }
                return;
            }
        }
        if (buttonType == MiniFunctionModels.ButtonType.File) {
            if (viewObjectAttr != null && miniFunctionObject.file_upload_properties != null) {
                new FilePicker().selectFile(ApplicationLoader.applicationActivity, new FilePicker.Listener() { // from class: androidMessenger.utilites.BotButtonHandler.8
                    @Override // androidMessenger.utilites.FilePicker.Listener
                    public void done(String str4) {
                        ir.resaneh1.iptv.logger.MyLog.e("MiniFunctionClickHandler", "path " + str4);
                        UploadFileProgressDialog uploadFileProgressDialog = new UploadFileProgressDialog(ApplicationLoader.applicationActivity);
                        uploadFileProgressDialog.createView();
                        uploadFileProgressDialog.startUploading(miniFunctionObject.file_upload_properties, viewObjectAttr, str4, delegate);
                    }
                });
                return;
            } else {
                if (j != 0) {
                    delegate.notSupported();
                    return;
                }
                return;
            }
        }
        if (buttonType == MiniFunctionModels.ButtonType.Audio) {
            if (viewObjectAttr != null && miniFunctionObject.file_upload_properties != null) {
                new FilePicker().selectAudio(ApplicationLoader.applicationActivity, new FilePicker.Listener() { // from class: androidMessenger.utilites.BotButtonHandler.9
                    @Override // androidMessenger.utilites.FilePicker.Listener
                    public void done(String str4) {
                        ir.resaneh1.iptv.logger.MyLog.e("MiniFunctionClickHandler", "path " + str4);
                        UploadFileProgressDialog uploadFileProgressDialog = new UploadFileProgressDialog(ApplicationLoader.applicationActivity);
                        uploadFileProgressDialog.createView();
                        uploadFileProgressDialog.startUploading(miniFunctionObject.file_upload_properties, viewObjectAttr, str4, delegate);
                    }
                });
                return;
            } else {
                if (j != 0) {
                    delegate.notSupported();
                    return;
                }
                return;
            }
        }
        delegate.notSupported();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleButtonClick$2(Delegate delegate, int i) {
        delegate.done(String.valueOf(i), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleButtonClick$5(Delegate delegate, BaseFragment baseFragment) {
        delegate.done(baseFragment.getUserConfig().getClientPhone(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendMyLocation(BaseFragment baseFragment, final Delegate delegate) {
        int i;
        try {
            if (Build.VERSION.SDK_INT >= 19 && (i = Settings.Secure.getInt(ApplicationLoader.applicationActivity.getContentResolver(), "location_mode")) != 3 && i != 0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ApplicationLoader.applicationActivity);
                builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                builder.setMessage("روش مکان یابی را به دقت زیاد تغییر دهید");
                builder.setPositiveButton("باشه", new DialogInterface.OnClickListener() { // from class: androidMessenger.utilites.BotButtonHandler$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        BotButtonHandler.lambda$sendMyLocation$7(dialogInterface, i2);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                baseFragment.showDialog(builder.create());
                return;
            }
        } catch (Exception unused) {
        }
        try {
            if (!((LocationManager) ApplicationLoader.applicationContext.getSystemService("location")).isProviderEnabled("gps")) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(ApplicationLoader.applicationActivity);
                builder2.setTitle(LocaleController.getString("AppName", R.string.AppName));
                builder2.setMessage(LocaleController.getString("GpsDisabledAlert", R.string.GpsDisabledAlert));
                builder2.setPositiveButton(LocaleController.getString("ConnectingToProxyEnable", R.string.ConnectingToProxyEnable), new DialogInterface.OnClickListener() { // from class: androidMessenger.utilites.BotButtonHandler$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        BotButtonHandler.lambda$sendMyLocation$8(dialogInterface, i2);
                    }
                });
                builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                baseFragment.showDialog(builder2.create());
                return;
            }
            if (ContextCompat.checkSelfPermission(ApplicationLoader.applicationContext, "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.checkSelfPermission(ApplicationLoader.applicationContext, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                Activity parentActivity = baseFragment.getParentActivity();
                if (parentActivity == null || Build.VERSION.SDK_INT < 23 || parentActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    return;
                }
                parentActivity.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 2);
                return;
            }
            final LocationManager locationManager = (LocationManager) ApplicationLoader.applicationActivity.getSystemService("location");
            try {
                List<String> providers = locationManager.getProviders(true);
                for (int size = providers.size() - 1; size >= 0; size--) {
                    Location lastKnownLocation = locationManager.getLastKnownLocation(providers.get(size));
                    if (lastKnownLocation != null) {
                        delegate.onLocationSelected(MessageConverter.convertToTLLocation(new LocationObject(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude())));
                        return;
                    }
                }
            } catch (Exception unused2) {
            }
            locationManager.requestLocationUpdates("gps", 0L, 0.0f, new LocationListener() { // from class: androidMessenger.utilites.BotButtonHandler.10
                @Override // android.location.LocationListener
                public void onProviderDisabled(String str) {
                }

                @Override // android.location.LocationListener
                public void onProviderEnabled(String str) {
                }

                @Override // android.location.LocationListener
                public void onStatusChanged(String str, int i2, Bundle bundle) {
                }

                @Override // android.location.LocationListener
                public void onLocationChanged(Location location) {
                    delegate.onLocationSelected(MessageConverter.convertToTLLocation(new LocationObject(location.getLatitude(), location.getLongitude())));
                    locationManager.removeUpdates(this);
                }
            });
            locationManager.requestLocationUpdates("network", 0L, 0.0f, new LocationListener() { // from class: androidMessenger.utilites.BotButtonHandler.11
                @Override // android.location.LocationListener
                public void onProviderDisabled(String str) {
                }

                @Override // android.location.LocationListener
                public void onProviderEnabled(String str) {
                }

                @Override // android.location.LocationListener
                public void onStatusChanged(String str, int i2, Bundle bundle) {
                }

                @Override // android.location.LocationListener
                public void onLocationChanged(Location location) {
                    delegate.onLocationSelected(MessageConverter.convertToTLLocation(new LocationObject(location.getLatitude(), location.getLongitude())));
                    locationManager.removeUpdates(this);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendMyLocation$7(DialogInterface dialogInterface, int i) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        ApplicationLoader.applicationActivity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendMyLocation$8(DialogInterface dialogInterface, int i) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        try {
            ApplicationLoader.applicationActivity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } catch (Exception unused) {
        }
    }
}

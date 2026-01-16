package org.rbmain.messenger.voip;

import android.os.Bundle;
import android.telecom.Connection;
import android.telecom.ConnectionRequest;
import android.telecom.ConnectionService;
import android.telecom.PhoneAccountHandle;
import java.io.IOException;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.FileLog;

/* loaded from: classes4.dex */
public class RubikaConnectionService extends ConnectionService {
    @Override // android.app.Service
    public void onCreate() throws IOException {
        super.onCreate();
        if (BuildVars.LOGS_ENABLED) {
            FileLog.w("ConnectionService created");
        }
    }

    @Override // android.app.Service
    public void onDestroy() throws IOException {
        super.onDestroy();
        if (BuildVars.LOGS_ENABLED) {
            FileLog.w("ConnectionService destroyed");
        }
    }

    @Override // android.telecom.ConnectionService
    public Connection onCreateIncomingConnection(PhoneAccountHandle phoneAccountHandle, ConnectionRequest connectionRequest) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("onCreateIncomingConnection ");
        }
        Bundle extras = connectionRequest.getExtras();
        if (extras.getInt("call_type") == 1) {
            VoIPService sharedInstance = VoIPService.getSharedInstance();
            if (sharedInstance == null || sharedInstance.isOutgoing()) {
                return null;
            }
            return sharedInstance.getConnectionAndStartCall();
        }
        extras.getInt("call_type");
        return null;
    }

    @Override // android.telecom.ConnectionService
    public void onCreateIncomingConnectionFailed(PhoneAccountHandle phoneAccountHandle, ConnectionRequest connectionRequest) throws Exception {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.e("onCreateIncomingConnectionFailed ");
        }
        if (VoIPService.getSharedInstance() != null) {
            VoIPService.getSharedInstance().callFailedFromConnectionService();
        }
    }

    @Override // android.telecom.ConnectionService
    public void onCreateOutgoingConnectionFailed(PhoneAccountHandle phoneAccountHandle, ConnectionRequest connectionRequest) throws Exception {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.e("onCreateOutgoingConnectionFailed ");
        }
        if (VoIPService.getSharedInstance() != null) {
            VoIPService.getSharedInstance().callFailedFromConnectionService();
        }
    }

    @Override // android.telecom.ConnectionService
    public Connection onCreateOutgoingConnection(PhoneAccountHandle phoneAccountHandle, ConnectionRequest connectionRequest) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("onCreateOutgoingConnection ");
        }
        Bundle extras = connectionRequest.getExtras();
        if (extras.getInt("call_type") == 1) {
            VoIPService sharedInstance = VoIPService.getSharedInstance();
            if (sharedInstance == null) {
                return null;
            }
            return sharedInstance.getConnectionAndStartCall();
        }
        extras.getInt("call_type");
        return null;
    }
}

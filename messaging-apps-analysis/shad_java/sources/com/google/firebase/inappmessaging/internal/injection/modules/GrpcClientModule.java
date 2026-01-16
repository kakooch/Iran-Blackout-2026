package com.google.firebase.inappmessaging.internal.injection.modules;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.google.common.io.BaseEncoding;
import com.google.firebase.FirebaseApp;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import io.grpc.Channel;
import io.grpc.ClientInterceptors;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes3.dex */
public class GrpcClientModule {
    private final FirebaseApp firebaseApp;

    public GrpcClientModule(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
    }

    public Metadata providesApiKeyHeaders() throws PackageManager.NameNotFoundException {
        Metadata.AsciiMarshaller<String> asciiMarshaller = Metadata.ASCII_STRING_MARSHALLER;
        Metadata.Key keyOf = Metadata.Key.of("X-Goog-Api-Key", asciiMarshaller);
        Metadata.Key keyOf2 = Metadata.Key.of("X-Android-Package", asciiMarshaller);
        Metadata.Key keyOf3 = Metadata.Key.of("X-Android-Cert", asciiMarshaller);
        Metadata metadata = new Metadata();
        String packageName = this.firebaseApp.getApplicationContext().getPackageName();
        metadata.put(keyOf, this.firebaseApp.getOptions().getApiKey());
        metadata.put(keyOf2, packageName);
        String signature = getSignature(this.firebaseApp.getApplicationContext().getPackageManager(), packageName);
        if (signature != null) {
            metadata.put(keyOf3, signature);
        }
        return metadata;
    }

    public static String getSignature(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length != 0 && signatureArr[0] != null) {
                return signatureDigest(signatureArr[0]);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private static String signatureDigest(Signature signature) {
        try {
            return BaseEncoding.base16().upperCase().encode(MessageDigest.getInstance("SHA1").digest(signature.toByteArray()));
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub providesInAppMessagingSdkServingStub(Channel channel, Metadata metadata) {
        return InAppMessagingSdkServingGrpc.newBlockingStub(ClientInterceptors.intercept(channel, MetadataUtils.newAttachHeadersInterceptor(metadata)));
    }
}

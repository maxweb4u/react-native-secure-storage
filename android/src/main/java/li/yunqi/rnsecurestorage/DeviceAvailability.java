package li.yunqi.rnsecurestorage;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;

import androidx.biometric.BiometricManager;

/**
 * Created by ouyangyunqi on 2018/3/26.
 */

class DeviceAvailability {

    public static boolean isFingerprintAuthAvailable(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            BiometricManager biometricManager = BiometricManager.from(context);
            return biometricManager.canAuthenticate() == BiometricManager.BIOMETRIC_SUCCESS;
        }
        return false;
    }

    public static boolean isDeviceSecure(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(Activity.KEYGUARD_SERVICE);
        return keyguardManager.isDeviceSecure();
    }
}

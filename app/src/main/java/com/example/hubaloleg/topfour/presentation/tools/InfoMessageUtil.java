package com.example.hubaloleg.topfour.presentation.tools;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by kostya on 17.07.17.
 */

public class InfoMessageUtil {
    public static void showMessage(Context context, String message) {
        if (context != null)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}

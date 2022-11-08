package com.example.metaMergeTasker;

import android.content.Context;
import android.text.Html;
import android.view.Gravity;
import android.widget.Toast;

public class extraFunctions {
    public static class ShowToast {
        public ShowToast(Context context, Boolean error, String info) {
            if (error == true) {
                Toast toast = Toast.makeText(context, Html.fromHtml("<font color='#ff0000' ><b>" + info + "</b></font>"), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
            } else {
                Toast toast = Toast.makeText(context, Html.fromHtml("<font color='#008000' ><b>" + info + "</b></font>"), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
            }
        }
    }
}


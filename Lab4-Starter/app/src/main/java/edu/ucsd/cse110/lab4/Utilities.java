package edu.ucsd.cse110.lab4;

import android.app.Activity;
import android.app.AlertDialog;

import java.util.Optional;

public class Utilities {

    public static void showAlert(Activity activity, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(message);
        builder.setPositiveButton("OK", (dialogue, id) -> {
            dialogue.cancel();
        });
        builder.setCancelable(true);
        builder.setTitle("Alert!");

        AlertDialog dialog = builder.show();
        dialog.show();
    }

    public static Optional<Integer> parseCount(String str) {
        try {
            int count = Integer.parseInt(str);
            return Optional.of(count);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}

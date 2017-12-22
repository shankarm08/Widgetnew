package com.wedddingapp.shankar.widggynew;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MainActivity extends AppWidgetProvider
{

    //onUpdate method.
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
    {
        //for loop to process IDs one by one.
        for(int i=0;i<appWidgetIds.length;i++){
            int currentWidgetId= appWidgetIds[i];    //Fetching current ID.
            String url ="https://acadgild.com";  //Storing URL of to a String.

            //Creating Intent to show the web.
            Intent intent = new Intent(Intent.ACTION_VIEW);

            //Setting Flags to Intent and parsing the url as Uri.
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse(url));

            //Creating Pending Intent for given context and above intent.
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,intent, 0);

            //Creating Remote Views.
            RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.activity_main);

            //Setting onClick Listener to views.
            views.setOnClickPendingIntent(R.id.buttonneww,pendingIntent);
            appWidgetManager.updateAppWidget(currentWidgetId,views);   //updating Widget.
            Toast.makeText(context, "widget added", Toast.LENGTH_SHORT).show();   //Toast.
        }
    }
}

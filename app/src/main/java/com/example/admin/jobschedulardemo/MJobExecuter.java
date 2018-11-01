package com.example.admin.jobschedulardemo;

import android.os.AsyncTask;

public class MJobExecuter extends AsyncTask<Void,Void,String> {
    @Override
    protected String doInBackground(Void... voids) {
        return "Background long running task finishes";
    }
}
